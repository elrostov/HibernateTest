package com.springboothibernate.hibernate.model.compositeKey.embeddable;

import javax.persistence.*;

@Entity
public class EntityB implements Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int entityBId;

    @Basic(optional = false)
    private String myStr2;

    public EntityB(){}
}
