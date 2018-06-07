package com.epam.adok.jpaproject.repository;

import com.epam.adok.jpaproject.jpa_entity_inheritance_examples.joined_table_inheritance.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
