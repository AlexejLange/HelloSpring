package spring.service;

import org.springframework.stereotype.Service;
import spring.domain.Person;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    private List<Person> persons = new ArrayList<>();

    {
        persons.add(new Person("Bill", "Gates"));
        persons.add(new Person("Steve", "Jobs"));
    }

    public List<Person> getAll() {
        return persons;
    }

    public void add(Person person) {
        persons.add(person);
    }

    public Person get(int idx) {
        return persons.get(idx);
    }

    public void set(int idx, Person person) {
        persons.set(idx, person);
    }

    public void remove(int idx) {
        persons.remove(idx);
    }
}
