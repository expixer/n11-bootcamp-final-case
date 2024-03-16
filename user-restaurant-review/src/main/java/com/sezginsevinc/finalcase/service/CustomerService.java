package com.sezginsevinc.finalcase.service;

import com.sezginsevinc.finalcase.entity.Customer;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {

  public List<Customer> getAllCustomers() {
    return null;
  }

  public Customer getCustomerById(Long id) {

    List<Customer> allCustomers = getAllCustomers();
    Customer customer = allCustomers.stream().filter(c -> c.getId().equals(id)).findFirst().get();

    return customer;
  }

  public Customer saveCustomer(Customer customer){
    customer.setId(3L);
    return customer;
  }

  public void deleteCustomer(Long id){
    // do nothing
  }

  public Customer updateCustomer(Customer customer){
    Customer customerById = getCustomerById(customer.getId());
    customerById.setName(customer.getName());
    customerById.setSurname(customer.getSurname());
    return customerById;
  }

  public Customer updateCustomerName(Long id, String name){
    Customer customerById = getCustomerById(id);
    customerById.setName(name);
    return customerById;
  }

}
