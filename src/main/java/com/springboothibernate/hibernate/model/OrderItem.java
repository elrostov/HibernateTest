package com.springboothibernate.hibernate.model;

import org.hibernate.FetchMode;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue
    private Long id;

    private String itemName;

    private int quantity;

    @ManyToOne
            (cascade={CascadeType.MERGE}/*, fetch = FetchType.LAZY*/)
//    @JoinColumn
    @BatchSize(size = 4)
    private Customer customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

