package ru.Yaroslav.NauJava.dateBase.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "foods")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "calories_per_100g", nullable = false)
    private Integer caloriesPer100g;

    @Column(name = "proteins_per_100g")
    private Double proteinsPer100g;

    @Column(name = "fats_per_100g")
    private Double fatsPer100g;

    @Column(name = "carbs_per_100g")
    private Double carbsPer100g;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private FoodCategory category;

    @OneToMany(mappedBy = "food")
    private List<FoodEntry> foodEntries;

    public Food() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getCaloriesPer100g() { return caloriesPer100g; }
    public void setCaloriesPer100g(Integer caloriesPer100g) { this.caloriesPer100g = caloriesPer100g; }

    public Double getProteinsPer100g() { return proteinsPer100g; }
    public void setProteinsPer100g(Double proteinsPer100g) { this.proteinsPer100g = proteinsPer100g; }

    public Double getFatsPer100g() { return fatsPer100g; }
    public void setFatsPer100g(Double fatsPer100g) { this.fatsPer100g = fatsPer100g; }

    public Double getCarbsPer100g() { return carbsPer100g; }
    public void setCarbsPer100g(Double carbsPer100g) { this.carbsPer100g = carbsPer100g; }

    public FoodCategory getCategory() { return category; }
    public void setCategory(FoodCategory category) { this.category = category; }

    public List<FoodEntry> getFoodEntries() { return foodEntries; }
    public void setFoodEntries(List<FoodEntry> foodEntries) { this.foodEntries = foodEntries; }
}