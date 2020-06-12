package com.springboothibernate.hibernate.model.compositeKey;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Cacheable(value = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@IdClass(CustomerId.class)
//@BatchSize(size = 4)
@NamedEntityGraph(
        name = "customers",
        attributeNodes = {
                @NamedAttributeNode("name"),
                @NamedAttributeNode("address"),
                @NamedAttributeNode("orderItems"),
        }
)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Id
    private String name;

    private String address;

    @OneToMany(
            mappedBy = "customer"
            , cascade=CascadeType.ALL
//            , fetch = FetchType.LAZY
    )
//    @Fetch(FetchMode.SELECT)
    private List<OrderItem> orderItems = new ArrayList<>();

//    @ElementCollection(fetch = FetchType.LAZY)
//    private Set<String> strings = new HashSet<>();

//    public void addOrderItem(String itemName, int qty) {
//        OrderItem orderItem = new OrderItem();
//        orderItem.setItemName(itemName);
//        orderItem.setQuantity(qty);
//        addOrderItem(orderItem);
//    }
//
//    public void addOrderItem(OrderItem orderItem) {
//        orderItem.setCustomer(this);
//        this.orderItems.add(orderItem);
//    }

//    public Set<String> getStrings() {
//        return strings;
//    }
//
//    public void setStrings(Set<String> strings) {
//        this.strings = strings;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    //    @OneToMany(
////            mappedBy = "customer",
//            cascade=CascadeType.ALL)
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
    //    @OneToMany(
////            mappedBy = "customer",
//            cascade=CascadeType.ALL)
    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", orderItems=" + orderItems +
                '}';
    }
}

