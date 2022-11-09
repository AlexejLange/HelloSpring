package spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.domian.Person;
import spring.service.PersonService;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("spring");
        context.refresh();

        PersonService personService = (PersonService) context.getBean("personService");

        // add person
//        personService.add("Ivan", "Ivanov");

        // find person
        List<Person> persons = personService.findByFirstName("Ivan");
        System.out.println(persons);

        context.close();
    }
}
