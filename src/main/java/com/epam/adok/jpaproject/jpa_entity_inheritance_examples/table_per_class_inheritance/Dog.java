package com.epam.adok.jpaproject.jpa_entity_inheritance_examples.table_per_class_inheritance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "dog")
public class Dog extends Animal {

    @Column(name = "is_barking")
    private boolean isBarking;

    public boolean isBarking() {
        return isBarking;
    }

    public void setBarking(boolean barking) {
        isBarking = barking;
    }
}
