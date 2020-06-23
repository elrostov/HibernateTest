package com.springboothibernate.hibernate.service.abstraction;

import com.springboothibernate.hibernate.model.compositeKey.Customer;
import com.springboothibernate.hibernate.model.compositeKey.CustomerId;

import java.util.List;

public interface CustomerService {
    void add(Customer customer);
    void update(Customer customer);
    Customer getById(CustomerId id);
    void delete(Customer customer);
    List<Customer> getAll();
    void detach(Customer customer);
    Customer getProxy(Class<Customer> entityClass, CustomerId id);
    void getAllWithJoinFetch();
    void getAllWithLeftJoinFetch();
    void getAllWithEntityGraph();
}
