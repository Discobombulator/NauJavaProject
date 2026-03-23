package ru.Yaroslav.NauJava.dateBase.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Сущность записи о приеме пищи
 */
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

    /** Конструктор по умолчанию */
    public FoodEntry() {}

    /** Возвращает идентификатор */
    public Long getId() { return id; }
    /** Устанавливает идентификатор */
    public void setId(Long id) { this.id = id; }

    /** Возвращает дату приема пищи */
    public LocalDate getEntryDate() { return entryDate; }
    /** Устанавливает дату приема пищи */
    public void setEntryDate(LocalDate entryDate) { this.entryDate = entryDate; }

    /** Возвращает количество в граммах */
    public Integer getQuantityInGrams() { return quantityInGrams; }
    /** Устанавливает количество в граммах */
    public void setQuantityInGrams(Integer quantityInGrams) { this.quantityInGrams = quantityInGrams; }

    /** Возвращает пользователя */
    public User getUser() { return user; }
    /** Устанавливает пользователя */
    public void setUser(User user) { this.user = user; }

    /** Возвращает продукт */
    public Food getFood() { return food; }
    /** Устанавливает продукт */
    public void setFood(Food food) { this.food = food; }

    /** Возвращает тип приема пищи */
    public Meal getMeal() { return meal; }
    /** Устанавливает тип приема пищи */
    public void setMeal(Meal meal) { this.meal = meal; }
}