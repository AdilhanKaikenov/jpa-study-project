package com.epam.adok.jpaproject.jpa_entity_inheritance_examples.joined_table_inheritance;

import javax.persistence.*;

@Entity
@Table(name = "vehicle")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "vehicle_type")

/**
 * The primary key of the concrete subclass is also a foreign key to the superclass table.
 * If the @PrimaryKeyJoinColumn is not set, the primary key / foreign key columns are assumed to have the same names
 * as the primary key columns of the primary table of the superclass.
 */

public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehicle")
    private long id;

    @Column(name = "manufacturer")
    private String manufacturer;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
