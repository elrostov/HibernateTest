package com.springboothibernate.hibernate.initializer;

import com.springboothibernate.hibernate.model.Post;
import com.springboothibernate.hibernate.model.PostComment;
import com.springboothibernate.hibernate.model.compositeKey.Customer;
import com.springboothibernate.hibernate.model.compositeKey.OrderItem;
import com.springboothibernate.hibernate.service.abstraction.CustomerService;
import com.springboothibernate.hibernate.service.abstraction.OrderItemService;
import com.springboothibernate.hibernate.service.abstraction.PostCommentService;
import com.springboothibernate.hibernate.service.abstraction.PostService;
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

    @Autowired
    private PostService postService;

    @Autowired
    private PostCommentService postCommentService;

    @Transactional
    void init() throws Exception {
//        System.out.println("##################################################################################");
//        System.out.println("-- Persisting Customer entity --");
//
//        Customer customer1 = new Customer();
//        customer1.setName("Maria Dorsey");
//        customer1.setAddress("1719 Shumaker Boulevard, Sylvania");
//        customer1.addOrderItem("GEN SSD", 2);
//        customer1.addOrderItem("SK Monitor", 3);

//        Customer customer2 = new Customer();
//        customer2.setName("El Su");
//        customer2.setAddress("1234 Nord, RnD");
//        customer2.addOrderItem("Ram", 5);
//        customer2.addOrderItem("Corei7", 1);

//        Customer customer3 = new Customer();
//        customer3.setName("Heather Barton");
//        customer3.setAddress("563 Holbein Square, Woodbine");
//
//        Customer customer4 = new Customer();
//        customer4.setName("Buba");
//        customer4.setAddress("---fwbjwejhbvc");
//
//        customerService.add(customer1);
//        customerService.add(customer2);
//        customerService.add(customer3);
//        customerService.add(customer4);

//        customerService.delete(customer1);
//        customerService.delete(customer2);

//        customerService.add(customer1);
//        customerService.add(customer2);

//        customerService.getProxy((Class<Customer>) customer1.getClass(), new CustomerId(customer1.getId(), customer1.getName()));

//        System.out.println("##################################################################################");
//        System.out.println("-- Persisting OrderItem entity --");
//
//        OrderItem orderItem1 = new OrderItem();
//        orderItem1.setItemName("QK USB Drive");
//        orderItem1.setQuantity(5);
//
//        OrderItem orderItem2 = new OrderItem();
//        orderItem2.setItemName("AXCVXV USB Drive");
//        orderItem2.setQuantity(7);
//
//        OrderItem orderItem3 = new OrderItem();
//        orderItem3.setItemName("GEN SSD");
//        orderItem3.setQuantity(2);
//
//        OrderItem orderItem4 = new OrderItem();
//        orderItem4.setItemName("SK Monitor");
//        orderItem4.setQuantity(3);
//
//        orderItem1.setCustomer(customer1);
//        orderItem2.setCustomer(customer1);
//        orderItem3.setCustomer(customer2);
//        orderItem4.setCustomer(customer4);
//
//        orderItemService.add(orderItem1);
//        orderItemService.add(orderItem2);
//        orderItemService.add(orderItem3);
//        orderItemService.add(orderItem4);


//        System.out.println("##################################################################################");
//        System.out.println("-- Setting OrderItems to Customer 1 --");
//        customer1.addOrderItem(orderItem1);
//        customer1.addOrderItem(orderItem2);
//        customer1.addOrderItem(orderItem3);
//        customer1.addOrderItem(orderItem4);

//        customerService.update(customer1);

//        System.out.println("##################################################################################");
//        System.out.println("-- Loading Customer --");
//        List<Customer> customers = customerService.getAllWithJoinFetch();
//        customers.forEach(System.out::println);
//        orderItemService.getAllCustomersAndTheirOrdersWithEntityGraph();
//        orderItemService.getAllCustomersAndTheirOrdersWithLeftJoinFetch();


//        System.out.println("##################################################################################");
//        System.out.println("-- Loading OrderItem --");
//        List<OrderItem> orderItems = orderItemService.getAll();
//        orderItems.forEach(System.out::println);
//
//        for (OrderItem orderItem : orderItems) {
//            Customer customer = orderItem.getCustomer();
//            if (customer != null) {
//                System.out.println(customer.getName());
//            }
//        }


//        System.out.println("##################################################################################");
//        System.out.println("-- Deleting OrderItem entity --");

//        orderItemService.delete(orderItem1);


        Post post1 = new Post();
        post1.setTitle("Post #1 Title");

        Post post2 = new Post();
        post2.setTitle("Post #2 Title");

        Post post3 = new Post();
        post3.setTitle("Post #3 Title");

        Post post4 = new Post();
        post4.setTitle("Post #4 Title");

        postService.add(post1);
        postService.add(post2);
        postService.add(post3);
        postService.add(post4);

        PostComment postComment1 = new PostComment();
        postComment1.setReview("Awesome!");
        postComment1.setPost(post1);

        PostComment postComment2 = new PostComment();
        postComment2.setReview("Great!");
        postComment2.setPost(post2);

        PostComment postComment3 = new PostComment();
        postComment3.setReview("Outstanding!");
        postComment3.setPost(post3);

        PostComment postComment4 = new PostComment();
        postComment4.setReview("Bad!");
        postComment4.setPost(post4);

        postCommentService.add(postComment1);
        postCommentService.add(postComment2);
        postCommentService.add(postComment3);
        postCommentService.add(postComment4);

        List<PostComment> postCommentList = postCommentService.getAllWithJoinFetch();
        postCommentList.forEach(System.out::println);
    }
}
