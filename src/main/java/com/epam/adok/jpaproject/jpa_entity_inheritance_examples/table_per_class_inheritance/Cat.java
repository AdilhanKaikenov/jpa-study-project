package com.epam.adok.jpaproject.jpa_entity_inheritance_examples.table_per_class_inheritance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cat")
public class Cat extends Animal {

    @Column(name = "is_purring")
    private boolean isPurring;

    public boolean isPurring() {
        return isPurring;
    }

    public void setPurring(boolean purring) {
        isPurring = purring;
    }
}
