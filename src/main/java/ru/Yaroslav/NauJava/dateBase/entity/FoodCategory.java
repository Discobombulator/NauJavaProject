package ru.Yaroslav.NauJava.dateBase.entity;

import jakarta.persistence.*;
import java.util.List;

/**
 * Сущность категории продуктов
 */
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

    /** Конструктор по умолчанию */
    public FoodCategory() {}

    /** Возвращает идентификатор */
    public Long getId() { return id; }
    /** Устанавливает идентификатор */
    public void setId(Long id) { this.id = id; }

    /** Возвращает название категории */
    public String getName() { return name; }
    /** Устанавливает название категории */
    public void setName(String name) { this.name = name; }

    /** Возвращает описание категории */
    public String getDescription() { return description; }
    /** Устанавливает описание категории */
    public void setDescription(String description) { this.description = description; }

    /** Возвращает список продуктов категории */
    public List<Food> getFoods() { return foods; }
    /** Устанавливает список продуктов категории */
    public void setFoods(List<Food> foods) { this.foods = foods; }
}