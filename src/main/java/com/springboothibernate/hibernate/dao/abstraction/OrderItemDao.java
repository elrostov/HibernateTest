package com.springboothibernate.hibernate.dao.abstraction;

import com.springboothibernate.hibernate.model.OrderItem;

import java.util.List;

public interface OrderItemDao extends GenericDao<Long, OrderItem> {

    List<OrderItem> getAll();
    //    @Transactional
    void getAllCustomersAndTheirOrders();
    //    @Transactional
    void getAllCustomersAndTheirOrdersWithJoinFetch();
    void getOne();
}
