package ru.Yaroslav.NauJava.logic;

import ru.Yaroslav.NauJava.data.Dish;

import java.util.List;

public interface DishService
{
    void createDish(String name,Double weight,Integer kilocalories,
                    Integer protein,Integer fat,Integer carbohydrates);
    Dish findById(Long id);
    void deleteById(Long id);
    void updateWeight(Long id, Double newWeight);
    void updateKilocalories(Long id, Integer newKilocalories);
    void updateProtein(Long id, Integer newProtein);
    void updateFat(Long id, Integer newFat);
    void updateCarbohydrates(Long id, Integer newCarbohydrates);

    List<Dish> findAllDishes();
}
