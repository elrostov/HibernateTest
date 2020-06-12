package com.springboothibernate.hibernate.service.abstraction;

import com.springboothibernate.hibernate.model.compositeKey.OrderItem;

import java.util.List;

public interface OrderItemService {
    void add(OrderItem orderItem);
    void update(OrderItem orderItem);
    OrderItem getById(Long id);
    void delete(OrderItem orderItem);
    void deleteById(Long id);
    List<OrderItem> getAll();
    void detach(OrderItem orderItem);
    OrderItem getProxy(Class<OrderItem> entityClass, Long id);
    List<OrderItem> getAllWithJoinFetch();
    void getAllCustomersAndTheirOrders();
    void getAllCustomersAndTheirOrdersWithJoinFetch();
}
