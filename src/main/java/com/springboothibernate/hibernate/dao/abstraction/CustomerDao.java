package com.springboothibernate.hibernate.dao.abstraction;

import com.springboothibernate.hibernate.model.Customer;
import com.springboothibernate.hibernate.model.CustomerId;

public interface CustomerDao extends GenericDao<CustomerId, Customer> {

}
