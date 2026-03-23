package ru.Yaroslav.NauJava.dateBase.repository;

import org.springframework.data.repository.CrudRepository;
import ru.Yaroslav.NauJava.dateBase.entity.Meal;

/**
 * Репозиторий для работы с типами приема пищи
 */
public interface MealRepository extends CrudRepository<Meal, Long> {
}