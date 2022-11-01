package hibernate.domain;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private int id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = true)
    private Category category;

    public Product() {
    }

    public Product(String title, Category category) {
        this.title = title;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
