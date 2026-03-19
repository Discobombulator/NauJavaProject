package ru.Yaroslav.NauJava.dateBase.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "food_categories")
public class FoodCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Food> foods;

    public FoodCategory() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<Food> getFoods() { return foods; }
    public void setFoods(List<Food> foods) { this.foods = foods; }
}