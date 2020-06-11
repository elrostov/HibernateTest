package com.springboothibernate.hibernate.service.impl;

import com.springboothibernate.hibernate.model.Customer;
import com.springboothibernate.hibernate.model.CustomerId;
import com.springboothibernate.hibernate.service.abstraction.CustomerService;
import com.springboothibernate.hibernate.dao.abstraction.CustomerDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;

    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void add(Customer customer) {
        customerDao.save(customer);
    }

    @Override
    public void update(Customer customer) {
        customerDao.update(customer);
    }

    @Override
    public Customer getById(CustomerId id) {
        return customerDao.getById(id);
    }

    @Override
    public void delete(Customer customer) {
        customerDao.deleteEntity(customer);
    }

    @Override
    public List<Customer> getAll() {
        return customerDao.getAll();
    }

    @Override
    public void detach(Customer customer) {
        customerDao.detach(customer);
    }

    @Override
    public Customer getProxy(Class<Customer> entityClass, CustomerId id) {
        return customerDao.getProxy(entityClass, id);
    }
}
