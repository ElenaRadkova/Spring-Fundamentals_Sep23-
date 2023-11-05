package bg.softuni.Pathfinder.model.entity;

import bg.softuni.Pathfinder.model.enums.CategoriesEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "name", nullable = false)
    private CategoriesEnum name;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    public Categories() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoriesEnum getName() {
        return name;
    }

    public void setName(CategoriesEnum name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
