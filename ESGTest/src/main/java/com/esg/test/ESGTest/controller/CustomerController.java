package com.esg.test.ESGTest.controller;

import com.esg.test.ESGTest.identity.Customer;
import com.esg.test.ESGTest.service.CsvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private final CsvService csvService;

    @Autowired
    public CustomerController(CsvService csvService){
        this.csvService = csvService;
    }

    @GetMapping("/{refId}")
    public ResponseEntity<Customer> getCustomerByRefId(@PathVariable String refId) {
        Optional<Customer> customer = csvService.getCustomerByRefId(refId);
        return customer.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<List<Customer>> createIdentity(@RequestBody String csvLocation) throws IOException {
        List<Customer> createdIdentity = csvService.getAndSaveCsv(csvLocation);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdIdentity);
    }
}
