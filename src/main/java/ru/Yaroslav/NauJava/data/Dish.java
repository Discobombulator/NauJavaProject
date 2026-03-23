package ru.Yaroslav.NauJava.data;

/**
 * Класс блюда
 */
public class Dish {
    /** Идентификатор */
    private Long id;
    /** Название блюда */
    private String name;
    /** Вес */
    private Double weight;
    /** Калорийность (ккал) */
    private Integer kilocalories;
    /** Белки */
    private Integer protein;
    /** Жиры */
    private Integer fat;
    /** Углеводы */
    private Integer carbohydrates;

    /** Возвращает идентификатор */
    public Long getId() {
        return id;
    }

    /** Возвращает название */
    public String getName() {
        return name;
    }

    /** Возвращает вес */
    public Double getWeight() {
        return weight;
    }

    /** Возвращает калорийность */
    public Integer getKilocalories() {
        return kilocalories;
    }

    /** Возвращает количество жиров */
    public Integer getFat() {
        return fat;
    }

    /** Возвращает количество углеводов */
    public Integer getCarbohydrates() {
        return carbohydrates;
    }

    /** Возвращает количество белков */
    public Integer getProtein() {
        return protein;
    }

    /** Устанавливает идентификатор */
    public void setId(Long id) {
        this.id = id;
    }

    /** Устанавливает название */
    public void setName(String name) {
        this.name = name;
    }

    /** Устанавливает вес */
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    /** Устанавливает калорийность */
    public void setKilocalories(Integer kilocalories) {
        this.kilocalories = kilocalories;
    }

    /** Устанавливает количество белков */
    public void setProtein(Integer protein) {
        this.protein = protein;
    }

    /** Устанавливает количество жиров */
    public void setFat(Integer fat) {
        this.fat = fat;
    }

    /** Устанавливает количество углеводов */
    public void setCarbohydrates(Integer carbohydrates) {
        this.carbohydrates = carbohydrates;
    }
}