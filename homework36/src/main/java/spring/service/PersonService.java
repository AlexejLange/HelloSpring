package spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.domain.Person;
import spring.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    static final Logger logger = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    private PersonRepository personRepository;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public void add(Person person) {
        personRepository.save(person);
        logger.info("Added person {}", person);
    }

    public Person findById(int idx) {
        Optional<Person> result = personRepository.findById(idx);
        return result.isPresent() ? result.get() : null;
    }

    public List<Person> findByFirstName(String firstName) {
        return personRepository.findByFirstName(firstName);
    }

    public void update(int idx, Person person) {
        Person old = personRepository.findById(idx).get();
        old.setFirstName(person.getFirstName());
        old.setLastName(person.getLastName());
        personRepository.save(old);
        logger.info("Updated person {}", old);
    }

    public void remove(int idx) {
        Person person = personRepository.findById(idx).get();
        personRepository.delete(person);
        logger.info("Removed person {}", person);
    }
}
