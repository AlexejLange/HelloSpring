package spring;

/**
 * Spring Boot (Spring Boot + h2 database + tests)
 * @author Alexej Lange
 * @version 29 Nov 2022
 *
 */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.domain.Person;
import spring.service.PersonService;

import java.util.List;

@SpringBootTest
public class PersonServiceTest {

    @Autowired
    PersonService service;

    @Test
    public void testAdd() {
        List<Person> persons = service.getAll();
        int count = persons.size();

        // add
        Person p = new Person("Ivan", "Ivanov");
        service.add(p);
        persons = service.getAll();
        Assertions.assertTrue(count + 1 == persons.size());
        Assertions.assertTrue(persons.get(0).getFirstName().equals("Ivan"));
        Assertions.assertTrue(persons.get(0).getLastName().equals("Ivanov"));
    }

    @Test
    public void testRemove() {
        List<Person> persons = service.getAll();
        int count = persons.size();

        // add
        Person p = new Person("Petr", "Petrov");
        service.add(p);
        persons = service.getAll();
        Assertions.assertTrue(count + 1 == persons.size());

        // remove
        service.remove(p.getId());
        persons = service.getAll();
        Assertions.assertTrue(count == persons.size());
    }

    @Test
    public void testFindByFirstName() {
        // add
        Person p = new Person("Sidor", "Sidorov");
        service.add(p);

        // find
        List<Person> persons = service.findByFirstName("Sidor");
        Assertions.assertTrue(persons.size() == 1);
        Assertions.assertTrue(persons.get(0).getFirstName().equals("Sidor"));
    }
}
