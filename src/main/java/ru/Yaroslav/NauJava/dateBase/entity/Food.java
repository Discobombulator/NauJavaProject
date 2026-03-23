package ru.Yaroslav.NauJava.dateBase.entity;

import jakarta.persistence.*;
import java.util.List;

/**
 * Сущность продукта питания
 */
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

    /** Конструктор по умолчанию */
    public Food() {}

    /** Возвращает идентификатор */
    public Long getId() { return id; }
    /** Устанавливает идентификатор */
    public void setId(Long id) { this.id = id; }

    /** Возвращает название */
    public String getName() { return name; }
    /** Устанавливает название */
    public void setName(String name) { this.name = name; }

    /** Возвращает калорийность на 100г */
    public Integer getCaloriesPer100g() { return caloriesPer100g; }
    /** Устанавливает калорийность на 100г */
    public void setCaloriesPer100g(Integer caloriesPer100g) { this.caloriesPer100g = caloriesPer100g; }

    /** Возвращает белки на 100г */
    public Double getProteinsPer100g() { return proteinsPer100g; }
    /** Устанавливает белки на 100г */
    public void setProteinsPer100g(Double proteinsPer100g) { this.proteinsPer100g = proteinsPer100g; }

    /** Возвращает жиры на 100г */
    public Double getFatsPer100g() { return fatsPer100g; }
    /** Устанавливает жиры на 100г */
    public void setFatsPer100g(Double fatsPer100g) { this.fatsPer100g = fatsPer100g; }

    /** Возвращает углеводы на 100г */
    public Double getCarbsPer100g() { return carbsPer100g; }
    /** Устанавливает углеводы на 100г */
    public void setCarbsPer100g(Double carbsPer100g) { this.carbsPer100g = carbsPer100g; }

    /** Возвращает категорию продукта */
    public FoodCategory getCategory() { return category; }
    /** Устанавливает категорию продукта */
    public void setCategory(FoodCategory category) { this.category = category; }

    /** Возвращает записи о приеме пищи */
    public List<FoodEntry> getFoodEntries() { return foodEntries; }
    /** Устанавливает записи о приеме пищи */
    public void setFoodEntries(List<FoodEntry> foodEntries) { this.foodEntries = foodEntries; }
}