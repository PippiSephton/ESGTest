package com.esg.test.ESGTest.service;

import com.esg.test.ESGTest.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CsvServiceTest {
    @Mock
    CustomerRepository customerRepository;
    @Autowired
    CsvService csvService;

    @Test
    public void convertCsvToJsonTest() throws IOException {
        assertNotNull(csvService.convertCsvToJson("testcsv1.csv"));
    }

    @Test
    public void getAndSaveCsvTest() throws IOException {
        assertNotNull(csvService.getAndSaveCsv("testcsv1.csv"));
    }
}
