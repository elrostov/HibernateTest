package com.springboothibernate.hibernate.dao.impl;

import com.springboothibernate.hibernate.model.compositeKey.Customer;
import com.springboothibernate.hibernate.model.compositeKey.OrderItem;
import com.springboothibernate.hibernate.dao.abstraction.OrderItemDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityGraph;
import java.util.List;

@Repository
public class OrderItemDaoImpl extends AbstractDao<Long, OrderItem> implements OrderItemDao {

    OrderItemDaoImpl() {
        super(OrderItem.class);
    }

    @Override
    public List<OrderItem> getAllWithJoinFetch() {
        return em.createQuery(
                "SELECT o FROM OrderItem o JOIN FETCH  o.customer ",
                OrderItem.class)
                .getResultList();
    }

    @Override
//    @Transactional
    public void getAllCustomersAndTheirOrdersWithEntityGraph() {
        System.out.println("\n********************************************");
        System.out.println("Getting all customers with EntityGraph - fetchgraph\n");
        EntityGraph<?> entityGraph = em.getEntityGraph("customers");
//        HashMap<String, Object> properties = new HashMap<>();
//        properties.put("javax.persistence.fetchgraph", entityGraph);

        List<Customer> customers = em.createQuery("SELECT c FROM Customer c", Customer.class)
                .setHint("javax.persistence.fetchgraph", entityGraph).getResultList();
        customers.forEach(System.out::println);

        System.out.println("\n********************************************");
        System.out.println("Accessing their ItemOrders...\n");

        for (Customer customer : customers) {
            customer.getOrderItems().forEach(System.out::println);
        }
    }

    @Override
//    @Transactional
    public void getAllCustomersAndTheirOrdersWithLeftJoinFetch() {
        System.out.println("\n********************************************");
        System.out.println("Getting all customers with LEFT JOIN FETCH...\n");

        List<Customer> customers = em.createQuery("SELECT c FROM Customer c LEFT JOIN FETCH c.orderItems", Customer.class)
                .getResultList();
        customers.forEach(System.out::println);

        System.out.println("\n********************************************");
        System.out.println("Accessing their ItemOrders...\n");

        for (Customer customer : customers) {
            customer.getOrderItems().forEach(System.out::println);
        }
    }
}
