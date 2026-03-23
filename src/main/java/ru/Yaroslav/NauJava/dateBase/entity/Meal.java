package ru.Yaroslav.NauJava.dateBase.entity;

import jakarta.persistence.*;
import java.util.List;

/**
 * Сущность типа приема пищи
 */
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

    /** Конструктор по умолчанию */
    public Meal() {}

    /** Возвращает идентификатор */
    public Long getId() { return id; }
    /** Устанавливает идентификатор */
    public void setId(Long id) { this.id = id; }

    /** Возвращает название приема пищи */
    public String getName() { return name; }
    /** Устанавливает название приема пищи */
    public void setName(String name) { this.name = name; }

    /** Возвращает записи о приеме пищи */
    public List<FoodEntry> getFoodEntries() { return foodEntries; }
    /** Устанавливает записи о приеме пищи */
    public void setFoodEntries(List<FoodEntry> foodEntries) { this.foodEntries = foodEntries; }
}