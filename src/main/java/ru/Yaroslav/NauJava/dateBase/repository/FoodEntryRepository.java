package ru.Yaroslav.NauJava.dateBase.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.Yaroslav.NauJava.dateBase.entity.FoodEntry;

import java.time.LocalDate;
import java.util.List;

public interface FoodEntryRepository extends CrudRepository<FoodEntry, Long> {

    List<FoodEntry> findByEntryDateBetween(LocalDate start, LocalDate end);

    @Query("SELECT f FROM FoodEntry f WHERE f.user.name = :userName")
    List<FoodEntry> findByUserName(String userName);
}