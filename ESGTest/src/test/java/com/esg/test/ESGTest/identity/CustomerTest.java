package com.esg.test.ESGTest.identity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {
    @Test
    public void emptyConstructorCustomerTest(){
        Customer customer = new Customer();
        customer.setCustomerRef("Testing");
        assertEquals("Testing", customer.getCustomerRef());
    }

    @Test
    public void fullConstructorTest(){
        Customer customer = new Customer("RefID", "Name", "AddL1", "AddL2", "Town", "County", "Country", "PostCode");
        assertEquals("RefID", customer.getCustomerRef());
        assertEquals("Name", customer.getCustomerName());
        assertEquals("AddL1", customer.getAddressLine1());
        assertEquals("AddL2", customer.getAddressLine2());
        assertEquals("Town", customer.getTown());
        assertEquals("County", customer.getCounty());
        assertEquals("Country", customer.getCountry());
        assertEquals("PostCode", customer.getPostcode());

    }
}
