package org.b3log.zephyr.service;

import org.b3log.zephyr.elasticsearch.Customer;

import java.util.List;

/**
 * Created by yu.zhang on 2017/6/1.
 */
public interface CustomerService {
    Customer findByFirstName(String firstName);
    List<Customer> findByLastName(String lastName);
    void addUser(String firstName,String lastName);
}
