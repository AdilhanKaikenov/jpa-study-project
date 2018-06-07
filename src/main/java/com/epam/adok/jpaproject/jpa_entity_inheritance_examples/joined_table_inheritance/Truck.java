package com.epam.adok.jpaproject.jpa_entity_inheritance_examples.joined_table_inheritance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "truck")
@PrimaryKeyJoinColumn(name = "id_truck", referencedColumnName = "id_vehicle")
public class Truck extends TransportationVehicle {

    @Column(name = "number_of_containers")
    private int numOfContainers;

    public int getNumOfContainers() {
        return numOfContainers;
    }

    public void setNumOfContainers(int numOfContainers) {
        this.numOfContainers = numOfContainers;
    }
}
