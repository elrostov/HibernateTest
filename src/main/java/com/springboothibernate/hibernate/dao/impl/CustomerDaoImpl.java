package com.springboothibernate.hibernate.dao.impl;

import com.springboothibernate.hibernate.model.Customer;
import com.springboothibernate.hibernate.dao.abstraction.CustomerDao;
import com.springboothibernate.hibernate.model.CustomerId;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoImpl extends AbstractDao<CustomerId, Customer> implements CustomerDao {

    CustomerDaoImpl() {
        super(Customer.class);
    }
}
