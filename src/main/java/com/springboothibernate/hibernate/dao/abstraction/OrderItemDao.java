package com.springboothibernate.hibernate.dao.abstraction;

import com.springboothibernate.hibernate.model.compositeKey.OrderItem;

public interface OrderItemDao extends GenericDao<Long, OrderItem> {

    //    @Transactional
    void getAllCustomersAndTheirOrdersWithEntityGraph();
    //    @Transactional
    void getAllCustomersAndTheirOrdersWithLeftJoinFetch();
}
