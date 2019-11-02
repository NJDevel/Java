package com.trilogy.cloudgamestoreretail.service;

import com.trilogy.cloudgamestoreretail.exceptions.CustomerDoesNotExistException;
import com.trilogy.cloudgamestoreretail.model.*;
import com.trilogy.cloudgamestoreretail.util.feign.*;
import com.trilogy.cloudgamestoreretail.util.messages.LevelUpEntry;
import com.trilogy.cloudgamestoreretail.viewmodel.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class ServiceLayer {

    @Autowired
    private LevelUpClient levelUpClient;
    @Autowired
    private InvoiceServiceClient invoiceServiceClient;
    @Autowired
    private InventoryServiceClient inventoryServiceClient;
    @Autowired
    private CustomerServiceClient customerServiceClient;
    @Autowired
    private ProductServiceClient productServiceClient;

    private RabbitTemplate rabbitTemplate;
    private static final String EXCHANGE = "level-up-exchange";
    private static final String ROUTING_KEY = "level-up.#";

    @Autowired
    ServiceLayer(LevelUpClient levelUpClient, InvoiceServiceClient invoiceServiceClient,
                 InventoryServiceClient inventoryServiceClient, CustomerServiceClient customerServiceClient,
                 ProductServiceClient productServiceClient, RabbitTemplate rabbitTemplate) {
        this.levelUpClient = levelUpClient;
        this.invoiceServiceClient = invoiceServiceClient;
        this.inventoryServiceClient = inventoryServiceClient;
        this.customerServiceClient = customerServiceClient;
        this.productServiceClient = productServiceClient;
        this.rabbitTemplate = rabbitTemplate;
    }

    /**
     * Retrieves one invoice from database when passed
     * a valid invoice ID
     * @param invoiceId
     * @return
     */
    public InvoiceViewModel retrieveInvoice(int invoiceId) {
        Invoice invoice = invoiceServiceClient.fetchOneInvoice(invoiceId);
        InvoiceViewModel ivm = new InvoiceViewModel();
        ivm.setInvoice(invoice);
        ivm.setInvoiceItems(invoiceServiceClient.fetchInvoiceItemsByInvoiceId(invoiceId));
        return ivm;
    }

    /**
     * Retrieves a list of all invoices associated with the customer ID
     * provided
     * @param customerId
     * @return
     */
    public List<InvoiceViewModel> retrieveAllInvoicesByCustomerId(int customerId) {
        List<InvoiceViewModel> returnList = new ArrayList<>();
        InvoiceViewModel ivm = new InvoiceViewModel();
        List<Invoice> invoices = invoiceServiceClient.fetchInvoicesByCustomerId(customerId);

        invoices.stream().forEach(invoice -> {
            ivm.setInvoice(invoice);
            returnList.add(ivm);
        });

            returnList.stream().forEach(invoiceViewModel -> {
            ivm.setInvoiceItems(invoiceServiceClient.fetchInvoiceItemsByInvoiceId(ivm.getInvoice().getInvoiceId()));
        });

        return returnList;
    }

    /**
     * Retrieves all of the entries for invoice
     * in the database
     * @return
     */
    public List<InvoiceViewModel> retrieveAllInvoices() {
        List<InvoiceViewModel> returnList = new ArrayList<>();
        List<Invoice> invoices = invoiceServiceClient.getAllInvoices();
        InvoiceViewModel ivm = new InvoiceViewModel();
        invoices.stream().forEach(invoice -> {
            ivm.setInvoice(invoice);
            returnList.add(ivm);
        });
        returnList.stream().forEach(invoiceViewModel -> {
            invoiceViewModel.setInvoiceItems(invoiceServiceClient.fetchInvoiceItemsByInvoiceId(invoiceViewModel.getInvoice().getInvoiceId()));
        });
        return returnList;
    }

    /**
     * Retrieves a list of all the products currently in stock
     * from the database store
     * @return
     */
    public List<Product> getAllProductsInInventory() {
        List<Product> products = new ArrayList<>();
        List<Inventory> inventories = inventoryServiceClient.getAllInventories();
        inventories.stream().forEach(inventory -> {
            if(inventory.getQuantity() > 0) {
                products.add(productServiceClient.getProduct(inventory.getProductId()));
            }
        });
        return products;
    }

    /**
     * Retrieves one product from the database when passed
     * a valid product ID
     * @param productId
     * @return
     */
    public Product getProduct(int productId) {
        Product product = productServiceClient.getProduct(productId);
        return product;
    }

    /**
     * Retrieves a list of products for a single invoice entry
     * when passed a valid invoice ID
     * @param invoiceId
     * @return
     */
    public List<Product> getAllProductsOnInvoice(int invoiceId) {
        List<Product> products = new ArrayList<>();
        Product product = new Product();
        Invoice invoice = invoiceServiceClient.fetchOneInvoice(invoiceId);

        List<InvoiceItem> invoiceItems = invoiceServiceClient.fetchInvoiceItemsByInvoiceId(invoiceId);

        List<Inventory> inventories = new ArrayList<>();
        Inventory inventory = new Inventory();

        List<Integer> inventoryIds = new ArrayList<>();
        invoiceItems.stream().forEach(invoiceItem -> {
            inventoryIds.add(invoiceItem.getInventoryId());
        });

        for(int i : inventoryIds) {
            inventory = inventoryServiceClient.getInventory(i);
            inventories.add(inventory);
        }

        for(Inventory inventory1 : inventories) {
            product = productServiceClient.getProduct(inventory1.getProductId());
            products.add(product);
        }
        return products;
    }

    /**
     * Retrieves the points for the level up entry
     * associated with the customer ID passed
     * @param customerId
     * @return
     */
    public int fetchLevelUpPointsByCustomerId(int customerId) {
        return levelUpClient.fetchLevelUpByCustomerId(customerId).getPoints();
    }





    /***************************************
     * Purchases products when provided a valid a purchase view model
     * which includes a valid customer ID along with with a list of invoice
     * items containing the inventory IDs of the products to purchase and the quantity
     * to be purchased
     * @param pvm
     * @return
     ***************************************/
    public InvoiceViewModel purchaseProduct(PurchaseViewModel pvm) {
        InvoiceViewModel ivm = new InvoiceViewModel();
        ivm.setInvoice(pvm.getInvoice());
        ivm.setInvoiceItems(pvm.getInvoiceItems());
        /**  Customer Validation  ******************************************/

        Customer validatedCustomer = validateCustomer(pvm.getInvoice().getCustomerId());
        CustomerViewModel customerViewModel = new CustomerViewModel();
        customerViewModel.setCustomer(validatedCustomer);
        ivm.setCustomerViewModel(customerViewModel);

        /**  Product Validation  ******************************************/
        //Gathers list of products, if they are valid
        List<Product> products = validateProduct(ivm.getInvoiceItems());


        List<Inventory> inventoryItems = new ArrayList<>();
            try {
                ivm.getInvoiceItems().stream().forEach(invoiceItem -> {
                    inventoryItems.add(inventoryServiceClient.getInventory(invoiceItem.getInventoryId()));
                    if (inventoryItems == null) {
                        //throw new custom inventory not found exception
                    }
                });
            } catch (Exception e) {
                //throw custom exception for inventory not found
            }

        /**  Inventory Validation  ******************************************/

        pvm.getInvoiceItems().stream().forEach(invoiceItem -> {
            if (invoiceItem.getQuantity() > inventoryServiceClient.getInventory(invoiceItem.getInventoryId()).getQuantity()) {
                //thrown custom exception for insufficient inventory
            }
        });


        /**  Purchase Total Calculation  ******************************************/


        List<InventoryViewModel> inventoryViewModels = new ArrayList<>();
        InventoryViewModel[] inviewmodels = new InventoryViewModel[products.size()];


        InventoryViewModel inventoryViewModel = new InventoryViewModel();

        inventoryItems.stream().forEach(inventory -> {
            inventoryViewModels.add(new InventoryViewModel(inventory));
        });

        AtomicInteger i = new AtomicInteger();
        inventoryViewModels.stream().forEach(inventoryViewModel1 -> {
            inventoryViewModel1.setProduct(products.get(i.get()));
            i.getAndIncrement();
        });

        //Set Builds Invoice View Item List
        List<InvoiceItemViewModel> invoiceItemViewModelList = new ArrayList<>();
        inventoryViewModels.stream().forEach(inventoryViewModel1 -> {
            invoiceItemViewModelList.add(new InvoiceItemViewModel(inventoryViewModel1));
        });
        AtomicInteger x = new AtomicInteger(0);
        ivm.getInvoiceItems().stream().forEach(invoiceItem -> {
            invoiceItemViewModelList.get(x.get()).setQuantity(invoiceItem.getQuantity());
            x.getAndIncrement();
        });

        //Sets Subtotal price of each Invoice Item
        invoiceItemViewModelList.stream().forEach(invoiceItemViewModel -> {
            invoiceItemViewModel.setItemSubtotal(invoiceItemViewModel.getInventoryViewModel().getProduct().getListPrice().multiply(BigDecimal.valueOf(invoiceItemViewModel.getQuantity())));
        });

        List<BigDecimal> subtotals = new ArrayList<>();
        BigDecimal subTotalOfAllProducts = BigDecimal.ZERO;
        invoiceItemViewModelList.stream().forEach(invoiceItemViewModel2 -> {
            subtotals.add(invoiceItemViewModel2.getItemSubtotal());
        });

        for (BigDecimal itemSubtotal : subtotals){
            subTotalOfAllProducts = subTotalOfAllProducts.add(itemSubtotal);
        }

        /**  Level Up Points Total Calculation  ******************************************/

        int levelUpPointsFromPurchase = (subTotalOfAllProducts.intValue() / 50) * 10;

        /**  Level Up Points Total Message Publication  ******************************************/


        //Tries to retrieve a Level Up from database
        try {
            LevelUp levelUp = new LevelUp();
            //Tries to retrieve a Level Up given the customer's ID
            //Circuit breaker pattern is applied here
            levelUp = levelUpClient.fetchLevelUpByCustomerId(ivm.getCustomerViewModel().getCustomer().getCustomerId());
            levelUp.setPoints(levelUp.getPoints() + levelUpPointsFromPurchase);
            //Sets Level Up in IVM for return to customer
            ivm.getCustomerViewModel().setLevelUp(levelUp);
            //Updates existing Level Up entry from customer
            LevelUpEntry msg = new LevelUpEntry(levelUp);
            rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, levelUp);

        } catch (Exception e) {
            //Create a new entry for Level up when one isn't found in database
            LevelUp levelUp = new LevelUp();
            levelUp.setCustomerId(ivm.getCustomerViewModel().getCustomer().getCustomerId());
            levelUp.setMemberDate(LocalDate.now());
            levelUp.setPoints(levelUpPointsFromPurchase);
            //Sets Level Up in IVM for return to customer
            ivm.getCustomerViewModel().setLevelUp(levelUp);
            //Creates new Level Up entry for existing customer
            LevelUpEntry msg = new LevelUpEntry(levelUp);
            rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, msg);
        }
        Invoice returnInvoice = ivm.getInvoice();
        returnInvoice = invoiceServiceClient.createInvoice(returnInvoice);
        ivm.setInvoice(returnInvoice);

        List<InvoiceItem> returnInvoiceItemList = new ArrayList<>();
        int y = 0;
        for(Product product : products) {
            ivm.getInvoiceItems().get(y).setUnitPrice(product.getListPrice());
            y++;
        }
        ivm.getInvoiceItems().stream().forEach(invoiceItem -> {
            invoiceItem.setInvoiceId(ivm.getInvoice().getInvoiceId());

            invoiceItem = invoiceServiceClient.createInvoiceItem(invoiceItem);
            returnInvoiceItemList.add(invoiceItem);
        });

        ivm.setInvoiceItems(returnInvoiceItemList);

        //Reduce inventory

        LevelUp returnLevelUp = levelUpClient.fetchLevelUpByCustomerId(ivm.getCustomerViewModel().getCustomer().getCustomerId());
        ivm.getCustomerViewModel().setLevelUp(returnLevelUp);
        return ivm;
    }

    /***********************
     * Helper Methods
     ***********************/

    private InvoiceViewModel buildInvoiceViewModelWithoutInvoiceID(Invoice invoice) {
        //Build InvoiceViewModel with InovoiceItemViewModels

        InvoiceViewModel ivm = new InvoiceViewModel();
        //Feign Client Call to Customer Service
        //ivm.setCustomer(customerServiceClient.getCustomer(invoice.getCustomerId()));

        //Needs to be added after invoice is created an ID is provided by database
        //Build View Models for invoiceItem?
        //ivm.setInvoiceItems(invoiceServiceClient.fetchInvoiceItemsByInvoiceId(invoice.getInvoiceId()));

        return ivm;
    }

    private List<InvoiceItemViewModel> buildInvoiceItemViewModel(List<InvoiceItem> invoiceItems) {
        List<InvoiceItemViewModel> invoiceItemViewModelList = new ArrayList<>();
        InvoiceItemViewModel invoiceItemViewModel = new InvoiceItemViewModel();
        for (InvoiceItem invoiceItem : invoiceItems) {
            invoiceItemViewModel.setInvoiceItemId(invoiceItem.getInvoiceItemId());
            invoiceItemViewModel.setInvoiceId(invoiceItem.getInvoiceId());
            //get inventory view model - yikes
            invoiceItem.setQuantity(invoiceItem.getQuantity());
            invoiceItem.setUnitPrice(invoiceItem.getUnitPrice());
        }
//        invoiceItems.stream().
//                forEach(invoiceItem -> {
//                    invoiceItemViewModel.setInvoiceItemId(invoiceItem.getInvoiceItemId());
//                    invoiceItemViewModel.setInvoiceId(invoiceItem.getInvoiceId());
//                    invoiceItemViewModel.setItemSubtotal(invoiceItem.getUnitPrice().multiply(invoiceItem.getUnitPrice()));
//                    invoiceItemViewModel.setInventoryViewModel(buildInventoryViewModel(invoiceItem));
//                    invoiceItemViewModelList.add(invoiceItemViewModel);
//                });
        return invoiceItemViewModelList;
    }

    private InventoryViewModel buildInventoryViewModel(InvoiceItem invoiceItem) {
        InventoryViewModel inventoryViewModel = new InventoryViewModel();
        //Adds Inventory to view model
        inventoryViewModel.setInventory(inventoryServiceClient.getInventory(invoiceItem.getInventoryId()));

        //Adds product to view model
        Product product = new Product();
        inventoryViewModel.setProduct(productServiceClient.getProduct(inventoryViewModel.getInventory().getProductId()));

        return inventoryViewModel;
    }

    /**********************************************
     * Business Logic
     ***********************************************/

    /**
     * Tries to retrieve a customer from database using
     * the customer ID provided.  If not customer matches the value
     * provided, an exception is thrown.
     * @param customerId
     * @return
     */
    private Customer validateCustomer(int customerId) {
        try {
            Customer customer = customerServiceClient.getCustomer(customerId);
            return customer;
        } catch (Exception e) {
            throw new CustomerDoesNotExistException("The Customer ID " + customerId + " provided could not be found " +
                    "in our Database. Please enter a valid customer ID");
        }
    }

    /**
     *
     * @param invoiceItems
     */
    private List<Product> validateProduct(List<InvoiceItem> invoiceItems) {
        //validate product via productClient

        List<Product> products = new ArrayList<>();
        List<Inventory> inventoryItems = new ArrayList<>();

        invoiceItems.stream().forEach(invoiceItem -> {
            inventoryItems.add(inventoryServiceClient.getInventory(invoiceItem.getInventoryId()));
            if (inventoryItems == null) {
                //throw new custom inventory not found exception
            }
        });

        inventoryItems.stream().forEach(inventory -> {
            products.add(productServiceClient.getProduct(inventory.getProductId()));
        });
        if(products==null) {
            //throw new custom product not found exception
        }
        return products;
    }

    //Pass view model?
    private int calculateLevelUpPointsForPurchase(Invoice invoice) {
        //Calculate level up points per purchase
        int totalLevelUpPointsForPurchase = 0;
        return totalLevelUpPointsForPurchase;
    }

    private void submitLevelUpPoints(Invoice invoice) {
        //Send LevelUpPoints once purchase is completed via queue
    }

    //Circuit breaker pattern place holder
    private int getLevelUpPointsTotal(Invoice invoice) {

        //Circuit breaker read from Level up Client
        int levelUpPointsFromDatabase = 0;

        return levelUpPointsFromDatabase;
    }
}
