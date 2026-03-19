package ru.Yaroslav.NauJava.logic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.Yaroslav.NauJava.DishRepository;
import ru.Yaroslav.NauJava.data.Dish;

import java.util.List;

@Service
public class ServiceLogic implements DishService
{
    private final DishRepository dishRepository;
    @Autowired
    public ServiceLogic(DishRepository dishRepository)
    {
        this.dishRepository = dishRepository;
    }
    @Override
    public void createDish(String name,Double weight,Integer kilocalories,
                           Integer protein,Integer fat,Integer carbohydrates)
    {
        Dish newDish = new Dish();
        newDish.setName(name);
        newDish.setWeight(weight);
        newDish.setKilocalories(kilocalories);
        newDish.setProtein(protein);
        newDish.setFat(fat);
        newDish.setCarbohydrates(carbohydrates);
        dishRepository.create(newDish);
    }
    @Override
    public Dish findById(Long id)
    {
        return dishRepository.read(id);
    }
    @Override
    public void deleteById(Long id)
    {
        dishRepository.delete(id);
    }

    @Override
    public void updateWeight(Long id, Double newWeight)
    {
        Dish dish = new Dish();
        dish.setId(id);
        dish.setWeight(newWeight);
        dishRepository.update(dish);
    }

    @Override
    public void updateKilocalories(Long id, Integer newKilocalories) {
        Dish dish = new Dish();
        dish.setId(id);
        dish.setKilocalories(newKilocalories);
        dishRepository.update(dish);
    }

    @Override
    public void updateProtein(Long id, Integer newProtein) {
        Dish dish = new Dish();
        dish.setId(id);
        dish.setProtein(newProtein);
        dishRepository.update(dish);
    }

    @Override
    public void updateFat(Long id, Integer newFat) {
        Dish dish = new Dish();
        dish.setId(id);
        dish.setFat(newFat);
        dishRepository.update(dish);
    }

    @Override
    public void updateCarbohydrates(Long id, Integer newCarbohydrates) {
        Dish dish = new Dish();
        dish.setId(id);
        dish.setCarbohydrates(newCarbohydrates);
        dishRepository.update(dish);
    }
    @Override
    public List<Dish> findAllDishes() {
        return dishRepository.findAll();
    }
}

