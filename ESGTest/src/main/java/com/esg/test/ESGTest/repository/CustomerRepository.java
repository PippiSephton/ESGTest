package com.esg.test.ESGTest.repository;

import com.esg.test.ESGTest.identity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    Optional<Customer> findByCustomerRef(String customerRef);
}
