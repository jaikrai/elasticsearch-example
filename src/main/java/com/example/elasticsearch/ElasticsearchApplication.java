package com.example.elasticsearch;

import com.example.model.Customer;
import com.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
public class ElasticsearchApplication {
    // Inject the customer repo
    protected final CustomerRepository repository;

    public ElasticsearchApplication(CustomerRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/saveCustomer")
    public int saveCustomer(@RequestBody List<Customer> customers){
        repository.saveAll(customers);
        return customers.size();
    }

    @GetMapping("/findAll")
    public Iterable<Customer> findAllCustomers(){
        return repository.findAll();
    }

    @GetMapping("/findByFirstName/{firstName}")
    public List<Customer> findBuFirstName(@PathVariable String firstName){
        return repository.findByFirstName(firstName);
    }
    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchApplication.class, args);
    }

}
