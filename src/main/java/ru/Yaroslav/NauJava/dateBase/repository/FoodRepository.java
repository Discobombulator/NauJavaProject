package ru.Yaroslav.NauJava.dateBase.repository;

import org.springframework.data.repository.CrudRepository;
import ru.Yaroslav.NauJava.dateBase.entity.Food;

import java.util.List;

/**
 * Репозиторий для работы с продуктами питания
 */
public interface FoodRepository extends CrudRepository<Food, Long> {

    /** Находит продукты по названию и калорийности на 100г */
    List<Food> findByNameAndCaloriesPer100g(String name, Integer caloriesPer100g);

}