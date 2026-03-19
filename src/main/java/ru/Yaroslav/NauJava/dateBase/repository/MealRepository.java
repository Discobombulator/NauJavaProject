package ru.Yaroslav.NauJava.dateBase.repository;

import org.springframework.data.repository.CrudRepository;
import ru.Yaroslav.NauJava.dateBase.entity.Meal;

public interface MealRepository extends CrudRepository<Meal, Long> {
}