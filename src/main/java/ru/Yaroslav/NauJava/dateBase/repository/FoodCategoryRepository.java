package ru.Yaroslav.NauJava.dateBase.repository;

import org.springframework.data.repository.CrudRepository;
import ru.Yaroslav.NauJava.dateBase.entity.FoodCategory;

/**
 * Репозиторий для работы с категориями продуктов
 */
public interface FoodCategoryRepository extends CrudRepository<FoodCategory, Long> {
}