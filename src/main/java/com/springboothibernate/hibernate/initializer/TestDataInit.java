package com.springboothibernate.hibernate.initializer;

import com.springboothibernate.hibernate.model.Customer;
import com.springboothibernate.hibernate.model.CustomerId;
import com.springboothibernate.hibernate.model.OrderItem;
import com.springboothibernate.hibernate.service.abstraction.CustomerService;
import com.springboothibernate.hibernate.service.abstraction.OrderItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class TestDataInit {

    private final static Logger LOGGER = LoggerFactory.getLogger(TestDataInit.class);

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderItemService orderItemService;

    @Transactional
    void init() throws Exception {
        System.out.println("-- Persisting Customer entity --");

        Customer customer1 = new Customer();
        customer1.setName("Maria Dorsey");
        customer1.setAddress("1719 Shumaker Boulevard, Sylvania");
        customer1.addOrderItem("GEN SSD", 2);
        customer1.addOrderItem("SK Monitor", 3);

        Customer customer2 = new Customer();
        customer2.setName("El Su");
        customer2.setAddress("1234 Nord, RnD");
        customer2.addOrderItem("Ram", 5);
        customer2.addOrderItem("Corei7", 1);

        customerService.add(customer1);
        customerService.add(customer2);

//        customerService.delete(customer1);
//        customerService.delete(customer2);

//        customerService.add(customer1);
//        customerService.add(customer2);

        customerService.getProxy((Class<Customer>) customer1.getClass(), new CustomerId(customer1.getId(), customer1.getName()));

        System.out.println("-- Persisting OrderItem entity --");

        OrderItem orderItem1 = new OrderItem();
        orderItem1.setItemName("QK USB Drive");
        orderItem1.setQuantity(5);

        OrderItem orderItem2 = new OrderItem();
        orderItem2.setItemName("AXCVXV USB Drive");
        orderItem2.setQuantity(7);

        Customer customer = new Customer();
        customer.setName("Heather Barton");
        customer.setAddress("563 Holbein Square, Woodbine");
        customer.addOrderItem(orderItem1);
        customer.addOrderItem(orderItem2);

        orderItemService.add(orderItem1);
//        orderItemService.add(orderItem2);

        System.out.println("-- Loading Customer --");
        List<Customer> customers = customerService.getAll();
//        customers.forEach(System.out::println);

        System.out.println("-- Loading OrderItem --");
        List<OrderItem> orderItems = orderItemService.getAll();
//        orderItems.forEach(System.out::println);

        System.out.println("-- Deleting OrderItem entity --");

        orderItemService.delete(orderItem1);
    }
}
