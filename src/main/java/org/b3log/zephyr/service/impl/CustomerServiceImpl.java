package org.b3log.zephyr.service.impl;

import org.b3log.zephyr.elasticsearch.Customer;
import org.b3log.zephyr.elasticsearch.CustomerRepository;
import org.b3log.zephyr.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yu.zhang on 2017/6/1.
 */
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer findByFirstName(String firstName) {
        return customerRepository.findByFirstName(firstName);
    }

    @Override
    public List<Customer> findByLastName(String lastName) {
        return customerRepository.findByLastName(lastName);
    }

    @Override
    public void addUser(String firstName, String lastName) {
        Customer c = new Customer();
        c.setFirstName(firstName);
        c.setLastName(lastName);
        c.setId("test");
        customerRepository.save(c);
    }
}
