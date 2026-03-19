package ru.Yaroslav.NauJava.dateBase.repository;

import org.springframework.data.repository.CrudRepository;
import ru.Yaroslav.NauJava.dateBase.entity.Food;

import java.util.List;

public interface FoodRepository extends CrudRepository<Food, Long> {

    List<Food> findByNameAndCaloriesPer100g(String name, Integer caloriesPer100g);

}
