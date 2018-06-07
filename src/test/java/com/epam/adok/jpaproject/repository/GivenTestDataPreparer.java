package com.epam.adok.jpaproject.repository;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.destination.DataSourceDestination;
import com.ninja_squad.dbsetup.operation.Operation;

import javax.sql.DataSource;

import static com.ninja_squad.dbsetup.Operations.deleteAllFrom;
import static com.ninja_squad.dbsetup.Operations.insertInto;
import static com.ninja_squad.dbsetup.Operations.sequenceOf;

public class GivenTestDataPreparer {

    public static void prepareJpaInheritance(DataSource dataSource) {

        Operation operation;
        operation = sequenceOf(
                deleteAllFrom("cat", "dog", "employee", "car", "truck", "vehicle"),
                insertInto("cat")
                        .columns("id", "name", "is_purring")
                        .values(1L, "Bars", true)
                        .build(),
                insertInto("dog")
                        .columns("id", "name", "is_barking")
                        .values(2L, "Aktos", true)
                        .build(),
                insertInto("employee")
                        .columns("id", "firstname", "lastname", "salary", "specialization", "machine", "sales_department", "employee_type")
                        .values(1L, "E_firstname", "E_lastname", 200_000, "Engineer_Specialization", "Some_Machine", null, "E")
                        .values(2L, "S_firstname", "S_lastname", 100_000, "Salesperson_Specialization", null, "Some_Department", "S")
                        .build(),
                insertInto("vehicle")
                        .columns("id_vehicle", "manufacturer", "vehicle_type")
                        .values(1L, "Some_Truck_Manufacturer", "Truck")
                        .values(2L, "Some_Car_Manufacturer", "Car")
                        .build(),
                insertInto("truck")
                        .columns("id_truck", "load_capacity", "number_of_containers")
                        .values(1L, 200, 2)
                        .build(),
                insertInto("car")
                        .columns("id_car", "number_of_passengers", "number_of_doors")
                        .values(2L, 2, 4)
                        .build()
                );
        DbSetup dbSetup = new DbSetup(new DataSourceDestination(dataSource), operation);
        dbSetup.launch();
    }

}
