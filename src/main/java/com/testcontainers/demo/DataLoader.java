package com.testcontainers.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    public DataLoader(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) {
        if (customerRepository.findByEmail("john@mail.com").isEmpty()) {
            customerRepository.save(new Customer(null, "John", "john@mail.com"));
        }
        if (customerRepository.findByEmail("dennis@mail.com").isEmpty()) {
            customerRepository.save(new Customer(null, "Dennis", "dennis@mail.com"));
        }
    }
} 