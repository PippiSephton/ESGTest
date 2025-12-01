package com.esg.test.ESGTest.repository;

import com.esg.test.ESGTest.identity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testSaveCustomerToH2Database() {
        Customer customer = new Customer();
        customer.setCustomerRef("ref001");
        customer.setCountry("England");
        customer.setTown("Southport");
        customer.setCounty("Merseyside");
        customer.setPostcode("SO1 u90");
        customer.setAddressLine1("123 ABC Lane");
        customer.setAddressLine2("");
        customer.setCustomerName("Pippi");

        customerRepository.save(customer);

        Customer savedCustomer = customerRepository.findById("ref001").orElse(null);

        assertNotNull(savedCustomer);
        assertEquals("ref001", savedCustomer.getCustomerRef());
        assertEquals("England", savedCustomer.getCountry());
        assertEquals("Southport", savedCustomer.getTown());
        assertEquals("Merseyside", savedCustomer.getCounty());
        assertEquals("SO1 u90", savedCustomer.getPostcode());
        assertEquals("123 ABC Lane", savedCustomer.getAddressLine1());
        assertEquals("", savedCustomer.getAddressLine2());
        assertEquals("Pippi", savedCustomer.getCustomerName());
    }
}
