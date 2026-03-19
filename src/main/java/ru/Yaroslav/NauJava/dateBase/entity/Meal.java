package ru.Yaroslav.NauJava.dateBase.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "meals")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name; // Завтрак, Обед, Ужин и т.д.

    @OneToMany(mappedBy = "meal")
    private List<FoodEntry> foodEntries;

    public Meal() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<FoodEntry> getFoodEntries() { return foodEntries; }
    public void setFoodEntries(List<FoodEntry> foodEntries) { this.foodEntries = foodEntries; }
}