package ru.Yaroslav.NauJava;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.Yaroslav.NauJava.dateBase.entity.*;
import ru.Yaroslav.NauJava.dateBase.repository.*;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class FoodEntryRepositoryTest {

    @Autowired
    private FoodEntryRepository foodEntryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private FoodRepository foodRepository;

    @Test
    void testFindByDateBetween() {

        User user = userRepository.save(new User() {{
            setName("testUser");
            setEmail("test@mail.com");
            setPassword("123");
        }});

        Meal meal = mealRepository.save(new Meal() {{
            setName("Lunch");
        }});

        Food food = foodRepository.save(new Food() {{
            setName("Apple");
            setCaloriesPer100g(50);
        }});

        FoodEntry entry = new FoodEntry();
        entry.setUser(user);
        entry.setMeal(meal);
        entry.setFood(food);
        entry.setEntryDate(LocalDate.now());
        entry.setQuantityInGrams(100);

        foodEntryRepository.save(entry);

        List<FoodEntry> result = foodEntryRepository
                .findByEntryDateBetween(LocalDate.now().minusDays(1), LocalDate.now().plusDays(1));

        Assertions.assertFalse(result.isEmpty());
    }

    @Test
    void testFindByUserName() {

        User user = userRepository.save(new User() {{
            setName("uniqueUser");
            setEmail("unique@mail.com");
            setPassword("123");
        }});

        Meal meal = mealRepository.save(new Meal() {{
            setName("Dinner");
        }});

        Food food = foodRepository.save(new Food() {{
            setName("Banana");
            setCaloriesPer100g(80);
        }});

        FoodEntry entry = new FoodEntry();
        entry.setUser(user);
        entry.setMeal(meal);
        entry.setFood(food);
        entry.setEntryDate(LocalDate.now());
        entry.setQuantityInGrams(150);

        foodEntryRepository.save(entry);

        List<FoodEntry> result = foodEntryRepository.findByUserName("uniqueUser");

        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals("uniqueUser", result.get(0).getUser().getName());
    }
    @Test
    void testCriteriaFindByDateBetween() {
        List<FoodEntry> result = foodEntryRepository.findByEntryDateBetween
                (LocalDate.now().minusDays(1), LocalDate.now().plusDays(1));

        Assertions.assertNotNull(result);
    }

    @Test
    void testCriteriaFindByUserName() {
        List<FoodEntry> result = foodEntryRepository.findByUserName("uniqueUser");

        Assertions.assertNotNull(result);
    }
}