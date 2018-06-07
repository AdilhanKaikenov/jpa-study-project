package com.epam.adok.jpaproject.jpa_entity_inheritance_examples.one_table_per_class_hierarchy;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("E")
public class Engineer extends Employee {

    @Column(name = "machine")
    private String machine;

    public String getMachine() {
        return machine;
    }

    public void setMachine(String machine) {
        this.machine = machine;
    }
}
