package ru.Yaroslav.NauJava.dateBase.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.Yaroslav.NauJava.dateBase.entity.FoodEntry;

import java.time.LocalDate;
import java.util.List;

/**
 * Репозиторий для работы с записями о питании
 */
@RepositoryRestResource(path = "foodsEntry")
public interface FoodEntryRepository extends CrudRepository<FoodEntry, Long> {

    /** Находит записи о питании за период между датами */
    List<FoodEntry> findByEntryDateBetween(LocalDate start, LocalDate end);

    /** Находит записи о питании по имени пользователя */
    @Query("SELECT f FROM FoodEntry f WHERE f.user.name = :userName")
    List<FoodEntry> findByUserName(String userName);
}