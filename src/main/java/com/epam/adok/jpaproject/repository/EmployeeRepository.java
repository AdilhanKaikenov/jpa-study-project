package com.epam.adok.jpaproject.repository;

import com.epam.adok.jpaproject.jpa_entity_inheritance_examples.one_table_per_class_hierarchy.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
