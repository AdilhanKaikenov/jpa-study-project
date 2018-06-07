package com.epam.adok.jpaproject.jpa_entity_inheritance_examples.joined_table_inheritance;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class PassengerVehicle extends Vehicle {

    @Column(name = "number_of_passengers")
    private int numOfPassengers;

    public int getNumOfPassengers() {
        return numOfPassengers;
    }

    public void setNumOfPassengers(int numOfPassengers) {
        this.numOfPassengers = this.numOfPassengers;
    }
}
