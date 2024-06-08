package com.example.demo.bootstrap;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BootStrapData implements CommandLineRunner {
    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        if(customerRepository.count() == 1 && divisionRepository.count() > 0) {
            addSampleCustomers();
        }else {
            System.out.println("Customers already exists.");
        }

    }
    private void addSampleCustomers() {
        Division division = new Division();
        division.setDivision_name("Sample Division");
        division.setId(1L);
        division.setCountry_id(1L);
        divisionRepository.save(division);

        Customer customer1 = new Customer("123 Queens Street", "Nasir", "Jones", "111-222-3333", "12345",division);
        division.getCustomers().add(customer1);
        customerRepository.save(customer1);
        Customer customer2 = new Customer("456 Bronx Avenue", "Big", "Pun", "444-555-6666", "67890",division);
        division.getCustomers().add(customer2);
        customerRepository.save(customer2);
        Customer customer3 = new Customer("123 Brooklyn Street", "Biggie", "Smalls", "111-222-3333", "12345",division);
        division.getCustomers().add(customer3);
        customerRepository.save(customer3);
        Customer customer4 = new Customer("456 Staten Place", "Wu", "Tang", "444-555-6666", "67890", division);
        division.getCustomers().add(customer4);
        customerRepository.save(customer4);
        Customer customer5 = new Customer("123 Harlem Street", "Big", "L", "111-222-3333", "12345", division);
        division.getCustomers().add(customer5);
        customerRepository.save(customer5);
    }
}
