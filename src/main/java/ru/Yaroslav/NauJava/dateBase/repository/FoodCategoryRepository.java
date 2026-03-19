package ru.Yaroslav.NauJava.dateBase.repository;

import org.springframework.data.repository.CrudRepository;
import ru.Yaroslav.NauJava.dateBase.entity.FoodCategory;

public interface FoodCategoryRepository extends CrudRepository<FoodCategory, Long> {
}