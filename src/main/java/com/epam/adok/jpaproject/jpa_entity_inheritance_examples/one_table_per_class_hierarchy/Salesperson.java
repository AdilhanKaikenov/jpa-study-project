package com.epam.adok.jpaproject.jpa_entity_inheritance_examples.one_table_per_class_hierarchy;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("S")
public class Salesperson extends Employee {

    @Column(name = "sales_department")
    private String salesDepartment;

    public String getSalesDepartment() {
        return salesDepartment;
    }

    public void setSalesDepartment(String salesDepartment) {
        this.salesDepartment = salesDepartment;
    }
}
