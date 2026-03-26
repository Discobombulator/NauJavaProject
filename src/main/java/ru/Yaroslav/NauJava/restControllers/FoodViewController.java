package ru.Yaroslav.NauJava.restControllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.Yaroslav.NauJava.dateBase.entity.Food;
import ru.Yaroslav.NauJava.dateBase.repository.FoodRepository;

import java.util.List;

/**
 * Контроллер для отображения страницы продуктов
 */
@Controller
public class FoodViewController {

    private final FoodRepository foodRepository;

    /** Конструктор с внедрением репозитория продуктов */
    public FoodViewController(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    /** Отображает страницу со списком всех продуктов */
    @GetMapping("/foods-view")
    public String getFoods(Model model) {

        List<Food> foods = (List<Food>) foodRepository.findAll();
        model.addAttribute("foods", foods);

        return "foods";
    }
}