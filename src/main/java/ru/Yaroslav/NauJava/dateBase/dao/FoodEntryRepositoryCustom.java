package ru.Yaroslav.NauJava.dateBase.dao;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.Yaroslav.NauJava.dateBase.entity.FoodEntry;

import java.time.LocalDate;
import java.util.List;

/**
 * Кастомный интерфейс репозитория записей о питании
 */
@RepositoryRestResource(path = "foodsEntryCustom")
public interface FoodEntryRepositoryCustom {

    /** Находит записи о питании за период между датами */
    List<FoodEntry> findByDateBetween(LocalDate start, LocalDate end);

    /** Находит записи о питании по имени пользователя */
    List<FoodEntry> findByUserName(String userName);
}