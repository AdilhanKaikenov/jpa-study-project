package com.epam.adok.jpaproject.repository;

import com.epam.adok.jpaproject.jpa_entity_inheritance_examples.table_per_class_inheritance.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

}
