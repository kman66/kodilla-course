package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave(){
        //Given
        Item item1 = new Item(new BigDecimal(12.95), 10, new BigDecimal(10.0));
        Item item2 = new Item(new BigDecimal(56.89), 3, new BigDecimal(45.5));
        Item item3 = new Item(new BigDecimal(5.99), 75, new BigDecimal(3.0));
        Item item4 = new Item(new BigDecimal(5.99), 100, new BigDecimal(3.0));
        Item item5 = new Item(new BigDecimal(12.95), 45, new BigDecimal(10.0));

        Product product1 = new Product("mouse");
        Product product2 = new Product("keyboard");
        Product product3 = new Product(null);

        product1.getItems().add(item1);
        product1.getItems().add(item1);
        product2.getItems().add(item2);
        product3.getItems().add(item3);
        product3.getItems().add(item4);

        item1.setProduct(product1);
        item2.setProduct(product2);
        item3.setProduct(product3);

        Invoice invoice1 = new Invoice("34");
        Invoice invoice2 = new Invoice("453");

        invoice1.getItems().add(item1);
        invoice1.getItems().add(item2);
        invoice1.getItems().add(item3);

        invoice2.getItems().add(item4);
        invoice2.getItems().add(item5);

        item1.setInvoice(invoice1);
        item2.setInvoice(invoice1);
        item3.setInvoice(invoice1);

        item4.setInvoice(invoice2);
        item5.setInvoice(invoice2);

        //When
        invoiceDao.save(invoice1);
        invoiceDao.save(invoice2);
        int idOfInvoice1 = invoice1.getId();
        int idOfInvoice2 = invoice2.getId();

        //Then
        Assert.assertNotEquals(0, idOfInvoice1);
        Assert.assertNotEquals(0, idOfInvoice2);

        //CleanUp
        invoiceDao.delete(idOfInvoice1);
        invoiceDao.delete(idOfInvoice2);
    }
}
