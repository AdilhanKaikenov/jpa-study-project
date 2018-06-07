package com.epam.adok.jpaproject.repository;

import com.epam.adok.jpaproject.configuration.RootApplicationContextConfiguration;
import com.epam.adok.jpaproject.jpa_entity_inheritance_examples.joined_table_inheritance.Car;
import com.epam.adok.jpaproject.jpa_entity_inheritance_examples.joined_table_inheritance.Truck;
import com.epam.adok.jpaproject.jpa_entity_inheritance_examples.joined_table_inheritance.Vehicle;
import com.epam.adok.jpaproject.jpa_entity_inheritance_examples.one_table_per_class_hierarchy.Employee;
import com.epam.adok.jpaproject.jpa_entity_inheritance_examples.one_table_per_class_hierarchy.Engineer;
import com.epam.adok.jpaproject.jpa_entity_inheritance_examples.one_table_per_class_hierarchy.Salesperson;
import com.epam.adok.jpaproject.jpa_entity_inheritance_examples.table_per_class_inheritance.Animal;
import com.epam.adok.jpaproject.jpa_entity_inheritance_examples.table_per_class_inheritance.Cat;
import com.epam.adok.jpaproject.jpa_entity_inheritance_examples.table_per_class_inheritance.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootApplicationContextConfiguration.class)
public class JpaInheritanceTest {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private DataSource dataSource;

//    @Before
//    public void prepareGivenTestData() {
//        GivenTestDataPreparer.prepareJpaInheritance(dataSource);
//    }

    @Test
    public void tablePerClassInheritance_saveTheAnimalObjects_shouldBeSavedToTheRelevantTables() {
        // Given
        Cat cat = new Cat();
        cat.setName("CatName");
        cat.setPurring(true);

        Dog dog = new Dog();
        dog.setName("DogName");
        dog.setBarking(true);

        // When
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(cat);
        session.persist(dog);

        transaction.commit();
        session.close();

        // Then
        assertThat(cat.getId(), not(0L));
        assertThat(dog.getId(), not(0L));
    }

    @Test
    public void tablePerClassInheritance_readTheAnimalObjects_shouldBeRetrieved(){
        // Given
        GivenTestDataPreparer.prepareJpaInheritance(dataSource);

        // When
        Optional<Animal> cat = this.animalRepository.findById(1L);
        Optional<Animal> dog = this.animalRepository.findById(2L);

        // Then
        Assert.assertTrue(cat.isPresent());
        Assert.assertTrue(dog.isPresent());

    }

    @Test
    public void oneTablePerClassHierarchyInheritance_saveTheEmployeeObjects_shouldBeSavedToTheSameTable() {
        //Given
        Engineer engineer = new Engineer();
        engineer.setFirstname("E_FirstName");
        engineer.setLastname("E_LastName");
        engineer.setSalary(300_000.00D);
        engineer.setSpecialization("Engineer_Specialization");
        engineer.setMachine("Some_Machine");

        Salesperson salesperson = new Salesperson();
        salesperson.setFirstname("S_FirstName");
        salesperson.setLastname("S_LastName");
        salesperson.setSalary(200_000.00D);
        salesperson.setSpecialization("Salesperson_Specialization");
        salesperson.setSalesDepartment("Some_Department");

        // When
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(engineer);
        session.persist(salesperson);

        transaction.commit();
        session.close();

        // Then
        assertThat(engineer.getId(), not(0L));
        assertThat(salesperson.getId(), not(0L));
    }

    @Test
    public void oneTablePerClassHierarchyInheritance_readTheEmployeeObjects_shouldBeRetrieved(){
        // Given
        GivenTestDataPreparer.prepareJpaInheritance(dataSource);

        // When
        Optional<Employee> engineer = this.employeeRepository.findById(1L);
        Optional<Employee> salesperson = this.employeeRepository.findById(2L);

        // Then
        Assert.assertTrue(engineer.isPresent());
        Assert.assertTrue(salesperson.isPresent());
    }

    @Test
    public void joinedTableInheritance_saveTheVehicleObjects_shouldBeSaved() {

        //Given
        Truck truck = new Truck();
        truck.setLoadCapacity(200);
        truck.setManufacturer("Some_Truck_Manufacturer");
        truck.setNumOfContainers(2);

        Car car = new Car();
        car.setNumOfPassengers(5);
        car.setManufacturer("Some_Car_Manufacturer");
        car.setNumOfDoors(4);

        //When
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(truck);
        session.persist(car);

        transaction.commit();
        session.close();

        // Then
        assertThat(truck.getId(), not(0L));
        assertThat(car.getId(), not(0L));
    }

    @Test
    public void joinedTableInheritance_readTheVehicleObjects_shouldBeRetrieved(){
        // Given
        GivenTestDataPreparer.prepareJpaInheritance(dataSource);

        // When
        Optional<Vehicle> truck = this.vehicleRepository.findById(1L);
        Optional<Vehicle> car = this.vehicleRepository.findById(2L);

        // Then
        Assert.assertTrue(truck.isPresent());
        Assert.assertTrue(car.isPresent());
    }
}
