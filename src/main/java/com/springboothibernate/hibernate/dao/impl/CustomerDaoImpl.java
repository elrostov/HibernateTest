package com.springboothibernate.hibernate.dao.impl;

import com.springboothibernate.hibernate.dao.abstraction.CustomerDao;
import com.springboothibernate.hibernate.model.compositeKey.Customer;
import com.springboothibernate.hibernate.model.compositeKey.CustomerId;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityGraph;
import java.util.List;

@Repository
public class CustomerDaoImpl extends AbstractDao<CustomerId, Customer> implements CustomerDao {

    CustomerDaoImpl() {
        super(Customer.class);
    }

    @Override
    public void getAllWithJoinFetch() {
        System.out.println("\n********************************************");
        System.out.println("Getting all customers with JOIN FETCH\n");
        List<Customer> customers = em.createQuery(
                "SELECT c FROM Customer c JOIN FETCH  c.orderItems ",
                Customer.class)
                .getResultList();
        customers.forEach(System.out::println);
    }

    @Override
    public void getAllWithLeftJoinFetch() {

    }

    @Override
    public void getAllWithEntityGraph() {
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
}
