package ru.Yaroslav.NauJava.dateBase.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "food_entries")
public class FoodEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "entry_date", nullable = false)
    private LocalDate entryDate;

    @Column(name = "quantity_in_grams", nullable = false)
    private Integer quantityInGrams;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "food_id", nullable = false)
    private Food food;

    @ManyToOne
    @JoinColumn(name = "meal_id", nullable = false)
    private Meal meal;

    public FoodEntry() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getEntryDate() { return entryDate; }
    public void setEntryDate(LocalDate entryDate) { this.entryDate = entryDate; }

    public Integer getQuantityInGrams() { return quantityInGrams; }
    public void setQuantityInGrams(Integer quantityInGrams) { this.quantityInGrams = quantityInGrams; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Food getFood() { return food; }
    public void setFood(Food food) { this.food = food; }

    public Meal getMeal() { return meal; }
    public void setMeal(Meal meal) { this.meal = meal; }
}