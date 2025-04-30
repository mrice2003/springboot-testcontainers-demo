package com.testcontainers.demo;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

  private final CustomerRepository repo;

  public CustomerController(CustomerRepository repo) {
    this.repo = repo;
  }

  @GetMapping("/")
  public String home() {
    return "Welcome to the Customer API. Try /api/customers to see all customers.";
  }

  @GetMapping("/api/customers")
  public List<Customer> getAll() {
    return repo.findAll();
  }
} 