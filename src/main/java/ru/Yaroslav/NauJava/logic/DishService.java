package ru.Yaroslav.NauJava.logic;

import ru.Yaroslav.NauJava.data.Dish;

import java.util.List;

/**
 * Интерфейс для управления блюдами
 */
public interface DishService
{
    /** Создает новое блюдо */
    void createDish(String name, Double weight, Integer kilocalories,
                    Integer protein, Integer fat, Integer carbohydrates);

    /** Находит блюдо */
    Dish findById(Long id);

    /** Удаляет блюдо */
    void deleteById(Long id);

    /** Обновляет вес блюда */
    void updateWeight(Long id, Double newWeight);

    /** Обновляет калорийность блюда */
    void updateKilocalories(Long id, Integer newKilocalories);

    /** Обновляет содержание белков */
    void updateProtein(Long id, Integer newProtein);

    /** Обновляет содержание жиров */
    void updateFat(Long id, Integer newFat);

    /** Обновляет содержание углеводов */
    void updateCarbohydrates(Long id, Integer newCarbohydrates);

    /** Возвращает список всех блюд */
    List<Dish> findAllDishes();
}