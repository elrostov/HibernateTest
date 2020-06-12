package com.springboothibernate.hibernate.dao.impl;

import com.springboothibernate.hibernate.dao.abstraction.CustomerDao;
import com.springboothibernate.hibernate.model.compositeKey.Customer;
import com.springboothibernate.hibernate.model.compositeKey.CustomerId;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDaoImpl extends AbstractDao<CustomerId, Customer> implements CustomerDao {

    CustomerDaoImpl() {
        super(Customer.class);
    }

    @Override
    public List<Customer> getAllWithJoinFetch() {
        return em.createQuery(
                "SELECT c FROM Customer c JOIN FETCH  c.orderItems ",
                Customer.class)
                .getResultList();
    }
}
