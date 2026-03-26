package ru.Yaroslav.NauJava.dateBase.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.Yaroslav.NauJava.dateBase.entity.Meal;

/**
 * Репозиторий для работы с типами приема пищи
 */
@RepositoryRestResource(path = "meals")
public interface MealRepository extends CrudRepository<Meal, Long> {
}