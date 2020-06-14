package com.springboothibernate.hibernate.dao.impl;

import com.springboothibernate.hibernate.model.Customer;
import com.springboothibernate.hibernate.model.CustomerId;
import com.springboothibernate.hibernate.model.OrderItem;
import com.springboothibernate.hibernate.dao.abstraction.OrderItemDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityGraph;
import java.util.HashMap;
import java.util.List;

@Repository
public class OrderItemDaoImpl extends AbstractDao<Long, OrderItem> implements OrderItemDao {

    OrderItemDaoImpl() {
        super(OrderItem.class);
    }

    //    @Override
    //    public List<OrderItem> getAll() {
    //        return em.createQuery(
    //                "SELECT o FROM OrderItem o JOIN FETCH  o.customer ",
    //                OrderItem.class)
    //                .getResultList();
    //    }

    @Override
    //    @Transactional
    public void getAllCustomersAndTheirOrders() {
        System.out.println("********************************************");
        System.out.println("getting all customers...");
        EntityGraph<?> entityGraph = em.getEntityGraph("customers");
        //        HashMap<String, Object> properties = new HashMap<>();
        //        properties.put("javax.persistence.fetchgraph", entityGraph);

        List<Customer> customers = em.createQuery("SELECT c FROM Customer c", Customer.class)
                                     .setHint("javax.persistence.fetchgraph", entityGraph).getResultList();
        customers.forEach(System.out::println);

        System.out.println("********************************************");
        System.out.println("accessing their ItemOrders...");

        for (Customer customer : customers) {
            customer.getOrderItems().forEach(System.out::println);
        }
    }

    @Override
    //    @Transactional
    public void getAllCustomersAndTheirOrdersWithJoinFetch() {
        System.out.println("********************************************");
        System.out.println("getting all customers with JOIN FETCH...");

        List<Customer> customers = em.createQuery("SELECT c FROM Customer c LEFT JOIN FETCH c.orderItems",
                Customer.class
        )
                                     .getResultList();
        customers.forEach(System.out::println);

        System.out.println("********************************************");
        System.out.println("accessing their ItemOrders...");

        for (Customer customer : customers) {
            customer.getOrderItems().forEach(System.out::println);
        }
    }

    @Override
    public void getOne() {
        System.out.println("********************************************");
        CustomerId id = new CustomerId(1L, "Maria Dorsey");
        Customer customer =
/*                em.createQuery("SELECT c FROM Customer c WHERE c.id =: id", Customer.class)
                         .setParameter("id", 1L)
                         .getSingleResult();*/
                em.find(Customer.class, id);

        System.out.println(customer);
        customer.getOrderItems().forEach(System.out::println);
    }
}
