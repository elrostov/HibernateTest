package com.springboothibernate.hibernate.dao.abstraction;

import com.springboothibernate.hibernate.model.compositeKey.Customer;
import com.springboothibernate.hibernate.model.compositeKey.CustomerId;

public interface CustomerDao extends GenericDao<CustomerId, Customer> {

}
