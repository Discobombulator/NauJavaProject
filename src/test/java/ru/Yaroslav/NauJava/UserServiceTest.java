package ru.Yaroslav.NauJava;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.Yaroslav.NauJava.dateBase.entity.*;
import ru.Yaroslav.NauJava.dateBase.repository.*;
import ru.Yaroslav.NauJava.dateBase.service.UserService;

import java.time.LocalDate;

@SpringBootTest
@ActiveProfiles("test")
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FoodEntryRepository foodEntryRepository;

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private FoodRepository foodRepository;

    @Test
    void testDeleteUserWithEntries_success() {

        User user = userRepository.save(new User() {{
            setName("deleteMe");
            setEmail("delete@mail.com");
            setPassword("123");
        }});

        Meal meal = mealRepository.save(new Meal() {{
            setName("Breakfast");
        }});

        Food food = foodRepository.save(new Food() {{
            setName("Egg");
            setCaloriesPer100g(155);
        }});

        FoodEntry entry = new FoodEntry();
        entry.setUser(user);
        entry.setMeal(meal);
        entry.setFood(food);
        entry.setEntryDate(LocalDate.now());
        entry.setQuantityInGrams(100);

        foodEntryRepository.save(entry);

        userService.deleteUserWithEntries(user.getId());

        Assertions.assertTrue(userRepository.findById(user.getId()).isEmpty());
    }

    @Test
    void testDeleteUserWithEntries_fail() {

        Long fakeId = -1L;

        Assertions.assertThrows(RuntimeException.class, () -> {
            userService.deleteUserWithEntries(fakeId);
        });
    }
}