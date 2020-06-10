package com.springboothibernate.hibernate.dao.impl;

import com.springboothibernate.hibernate.model.OrderItem;
import com.springboothibernate.hibernate.dao.abstraction.OrderItemDao;
import org.springframework.stereotype.Repository;

@Repository
public class OrderItemDaoImpl extends AbstractDao<Long, OrderItem> implements OrderItemDao {

    OrderItemDaoImpl() {
        super(OrderItem.class);
    }
}
