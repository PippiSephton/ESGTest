package com.esg.test.ESGTest.service;

import com.esg.test.ESGTest.identity.Customer;
import com.esg.test.ESGTest.repository.CustomerRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@Service
public class CsvService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CsvService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAndSaveCsv(String csvLocation) throws IOException {
        List<Map<String, String>> jsonData = convertCsvToJson(csvLocation);
        List<Customer> customerData = saveCsvDataToDb(jsonData);
        return customerData;
    }

    public Optional<Customer> getCustomerByRefId(String refId) {
        return customerRepository.findByCustomerRef(refId);
    }

    public List<Map<String, String>> convertCsvToJson(String csvFilePath) throws IOException {
        List<Map<String, String>> jsonData = new ArrayList<>();

        // Use ClassPathResource to access the file in resources folder
        ClassPathResource resource = new ClassPathResource("csv/"+csvFilePath);

        // Check if the file exists
        if (!resource.exists()) {
            throw new IOException("CSV file not found in resources.");
        }
        try (CSVReader reader = new CSVReader(new InputStreamReader(resource.getInputStream()))) {            String[] headers = reader.readNext();
            if (headers == null) {
                throw new IOException("CSV file is empty or malformed.");
            }

            String[] row;
            while ((row = reader.readNext()) != null) {
                Map<String, String> record = new HashMap<>();
                for (int i = 0; i < row.length; i++) {
                    record.put(headers[i].trim(), row[i].trim());
                }
                jsonData.add(record);
            }
        } catch (CsvValidationException e) {
            throw new BadRequestException(e);
        }
        return jsonData;
    }

    public List<Customer> saveCsvDataToDb(List<Map<String, String>> csvData) {
        List<Customer> customers = new ArrayList<>();
        for (Map<String, String> data : csvData) {
            Customer customer = new Customer();
            customer.setCustomerRef(data.get("customerRef"));
            customer.setCountry(data.get("country"));
            customer.setTown(data.get("town"));
            customer.setCounty(data.get("county"));
            customer.setPostcode(data.get("postcode"));
            customer.setAddressLine1(data.get("addressLine1"));
            customer.setAddressLine2(data.get("addressLine2"));
            customer.setCustomerName(data.get("customerName"));

            // Add the customer to the list
            customers.add(customer);
        }

        // Save the customers to the database
        return customerRepository.saveAll(customers); // Using saveAll to batch save the customers
    }
}
