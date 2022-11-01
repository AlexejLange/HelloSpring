package hibernate;

import hibernate.domain.Category;
import hibernate.domain.Person;
import hibernate.domain.Product;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class EntityManagerDemo {
    public static void main(String[] args) {
        // Получаем фабрику менеджеров сущностей
        EntityManagerFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        // Из фабрики создаем EntityManager
        EntityManager em = factory.createEntityManager();

        List<Person> persons = em.createQuery("SELECT p FROM Person p WHERE p.lastName='Petrov'", Person.class).getResultList();
        System.out.println(persons);

        addProduct(em, "Tablet", addCategory(em,"Electronic"));
    }

    static Category addCategory(EntityManager em, String title) {
        Category category = new Category(title);
        em.getTransaction().begin();
        em.persist(category);
        em.getTransaction().commit();
        return category;
    }

    static void addProduct(EntityManager em, String title, Category category) {
        Product product = new Product();
        product.setTitle(title);
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
    }

    static Person find(EntityManager em, int id) {
        return em.find(Person.class, 1);
    }

    static void update(EntityManager em, Person person) {
        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
    }

    static void remove(EntityManager em, Person person) {
        em.getTransaction().begin();
        em.remove(person);
        em.getTransaction().commit();
    }
}