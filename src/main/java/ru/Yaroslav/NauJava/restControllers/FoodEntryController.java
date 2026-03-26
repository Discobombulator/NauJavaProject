package ru.Yaroslav.NauJava.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.Yaroslav.NauJava.dateBase.dao.FoodEntryRepositoryImpl;
import ru.Yaroslav.NauJava.dateBase.entity.FoodEntry;


import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/food-entries")
public class FoodEntryController {

    private final FoodEntryRepositoryImpl foodEntryRepositoryImpl;

    @Autowired
    public FoodEntryController(FoodEntryRepositoryImpl foodEntryRepositoryImpl) {
        this.foodEntryRepositoryImpl = foodEntryRepositoryImpl;
    }

    /**
     * Получить записи за период
     */
    @GetMapping("/by-date")
    public List<FoodEntry> getByDateBetween(
            @RequestParam LocalDate start,
            @RequestParam LocalDate end) {

        return foodEntryRepositoryImpl.findByDateBetween(start, end);
    }

    /**
     * Получить записи по имени пользователя
     */
    @GetMapping("/by-user")
    public List<FoodEntry> getByUserName(
            @RequestParam String name) {

        return foodEntryRepositoryImpl.findByUserName(name);
    }
}