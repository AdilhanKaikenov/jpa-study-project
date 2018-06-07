package com.epam.adok.jpaproject.jpa_entity_inheritance_examples.joined_table_inheritance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "car")
@PrimaryKeyJoinColumn(name = "id_car", referencedColumnName = "id_vehicle")
public class Car extends PassengerVehicle {

    @Column(name = "number_of_doors")
    private int numOfDoors;

    public int getNumOfDoors() {
        return numOfDoors;
    }

    public void setNumOfDoors(int numOfDoors) {
        this.numOfDoors = numOfDoors;
    }
}
