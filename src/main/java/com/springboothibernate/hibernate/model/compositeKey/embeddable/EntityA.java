package com.springboothibernate.hibernate.model.compositeKey.embeddable;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
public class EntityA {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int entityAId;

    @Embedded
    private EmbeddableClassA embeddableClassARef;

    public EntityA(){}
}
