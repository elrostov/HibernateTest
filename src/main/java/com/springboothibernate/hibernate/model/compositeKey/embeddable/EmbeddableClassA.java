package com.springboothibernate.hibernate.model.compositeKey.embeddable;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Embeddable
public class EmbeddableClassA {

    private String myStr;

    private int myInt;

    @ElementCollection
    private List<Integer> integerList = new ArrayList<>();

    @ManyToOne
    private EntityB entityBRef;

    @OneToMany
    private Set<EntityC> entityCSet = new HashSet<>();

    private EmbeddableClassB embeddableClassB;

    @ElementCollection
    private Set<EmbeddableClassB> embeddableClassBSet = new HashSet<>();

    public String getMyStr() {
        return myStr;
    }

    public void setMyStr(String myStr) {
        this.myStr = myStr;
    }

    public int getMyInt() {
        return myInt;
    }

    public void setMyInt(int myInt) {
        this.myInt = myInt;
    }

    public List<Integer> getIntegerList() {
        return integerList;
    }

    public void setIntegerList(List<Integer> integerList) {
        this.integerList = integerList;
    }

    public EntityB getEntityBRef() {
        return entityBRef;
    }

    public void setEntityBRef(EntityB entityBRef) {
        this.entityBRef = entityBRef;
    }

    public Set<EntityC> getEntityCSet() {
        return entityCSet;
    }

    public void setEntityCSet(Set<EntityC> entityCSet) {
        this.entityCSet = entityCSet;
    }

    public EmbeddableClassB getEmbeddableClassB() {
        return embeddableClassB;
    }

    public void setEmbeddableClassB(EmbeddableClassB embeddableClassB) {
        this.embeddableClassB = embeddableClassB;
    }

    public Set<EmbeddableClassB> getEmbeddableClassBSet() {
        return embeddableClassBSet;
    }

    public void setEmbeddableClassBSet(Set<EmbeddableClassB> embeddableClassBSet) {
        this.embeddableClassBSet = embeddableClassBSet;
    }
}
