package ru.Yaroslav.NauJava.dateBase.dao;

import ru.Yaroslav.NauJava.dateBase.entity.FoodEntry;

import java.time.LocalDate;
import java.util.List;

public interface FoodEntryRepositoryCustom {


    List<FoodEntry> findByDateBetween(LocalDate start, LocalDate end);
    
    List<FoodEntry> findByUserName(String userName);
}