package com.springboothibernate.hibernate.dao.impl;

import com.springboothibernate.hibernate.model.OrderItem;
import com.springboothibernate.hibernate.dao.abstraction.OrderItemDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderItemDaoImpl extends AbstractDao<Long, OrderItem> implements OrderItemDao {

    OrderItemDaoImpl() {
        super(OrderItem.class);
    }

    @Override
    public List<OrderItem> getAll() {
        return em.createQuery(
                "SELECT o FROM OrderItem o JOIN FETCH  o.customer ",
                OrderItem.class)
                .getResultList();
    }
}
