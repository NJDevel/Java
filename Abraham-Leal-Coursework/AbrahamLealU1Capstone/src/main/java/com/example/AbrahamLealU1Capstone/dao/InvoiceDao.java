package com.example.AbrahamLealU1Capstone.dao;

import com.example.AbrahamLealU1Capstone.model.Invoice;
import com.example.AbrahamLealU1Capstone.model.Purchase;

import java.util.List;

public interface InvoiceDao {

    Invoice addInvoice(Invoice invoice);

    Invoice getInvoice(int id);

    List<Invoice> getAllInvoices();

    void updateInvoice(Invoice invoice);

    void deleteInvoice(int id);

    double getUnitPrice(Purchase purchase);
}
