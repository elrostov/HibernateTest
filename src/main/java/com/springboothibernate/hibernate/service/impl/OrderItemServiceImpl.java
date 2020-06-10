package com.springboothibernate.hibernate.service.impl;

import com.springboothibernate.hibernate.dao.abstraction.OrderItemDao;
import com.springboothibernate.hibernate.model.OrderItem;
import com.springboothibernate.hibernate.service.abstraction.OrderItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderItemServiceImpl implements OrderItemService {

    private OrderItemDao orderItemDao;

    public OrderItemServiceImpl(OrderItemDao orderItemDao) {
        this.orderItemDao = orderItemDao;
    }

    @Override
    public void add(OrderItem orderItem) {
        orderItemDao.save(orderItem);
    }

    @Override
    public void update(OrderItem orderItem) {
        orderItemDao.update(orderItem);
    }

    @Override
    public OrderItem getById(Long id) {
        return orderItemDao.getById(id);
    }

    @Override
    public void delete(OrderItem orderItem) {
        orderItemDao.deleteEntity(orderItem);
    }

    @Override
    public void deleteById(Long id) {
        orderItemDao.deleteById(id);
    }

    @Override
    public List<OrderItem> getAll() {
        return orderItemDao.getAll();
    }

    @Override
    public void detach(OrderItem orderItem) {
        orderItemDao.detach(orderItem);
    }

    @Override
    public OrderItem getProxy(Class<OrderItem> entityClass, Long id) {
        return orderItemDao.getProxy(entityClass, id);
    }
}
