package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.domain.Person;
import spring.service.PersonService;
import spring.util.StringUtil;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SimpleRestController {

    @Autowired
    PersonService personService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Void> add(@RequestBody Person person) {

        String firstName = person.getFirstName();
        String lastName = person.getLastName();

        if (!StringUtil.isEmpty(firstName) && !StringUtil.isEmpty(lastName)) {
            Person newPerson = new Person(firstName, lastName);
            personService.add(newPerson);
        }
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<Person>> get() {
        return ResponseEntity.ok(personService.findAll());
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<Person> get(@PathVariable("id") Integer id) {
        Person person = personService.findById(id);
        if (person != null) {
            return ResponseEntity.ok(person);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@PathVariable("id") Integer id, @RequestBody Person person) {
        personService.update(id, person);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        personService.remove(id);
        return ResponseEntity.ok().build();
    }
}
