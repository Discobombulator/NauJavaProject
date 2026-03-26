package ru.Yaroslav.NauJava.dateBase.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.Yaroslav.NauJava.dateBase.entity.FoodCategory;

/**
 * Репозиторий для работы с категориями продуктов
 */
@RepositoryRestResource(path = "foodsCategory")
public interface FoodCategoryRepository extends CrudRepository<FoodCategory, Long> {
}