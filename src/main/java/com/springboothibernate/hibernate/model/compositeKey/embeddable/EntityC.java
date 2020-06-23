package com.springboothibernate.hibernate.model.compositeKey.embeddable;

import javax.persistence.*;

@Entity
public class EntityC {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int entityCId;

    @Embedded
    private EmbeddableClassA embeddableClassA;
}
