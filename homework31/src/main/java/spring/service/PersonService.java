package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.domian.Person;
import spring.repository.PersonRepository;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public void add(Person person) {
        personRepository.save(person);
    }

    public Person get(int idx) {
        return personRepository.findById(idx).get();
    }

    public void set(int idx, Person person) {
        Person old = personRepository.findById(idx).get();
        old.setFirstName(person.getFirstName());
        old.setLastName(person.getLastName());
        personRepository.save(old);
    }

    public void remove(int idx) {
        Person person = personRepository.findById(idx).get();
        personRepository.delete(person);
    }
}
