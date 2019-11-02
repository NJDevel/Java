package com.example.AbrahamLealU12M3Summative.dao;

import com.example.AbrahamLealU12M3Summative.model.Invoice;
import com.example.AbrahamLealU12M3Summative.model.Purchase;

import java.util.List;

public interface InvoiceDao {

    Invoice addInvoice(Invoice invoice);

    Invoice getInvoice(int id);

    List<Invoice> getAllInvoices();

    void updateInvoice(Invoice invoice);

    void deleteInvoice(int id);

    double getUnitPrice(Purchase purchase);
}
