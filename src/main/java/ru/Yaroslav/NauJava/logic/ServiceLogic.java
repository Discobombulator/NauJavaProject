package ru.Yaroslav.NauJava.logic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.Yaroslav.NauJava.UserRepository;
import ru.Yaroslav.NauJava.data.Dish;

import java.util.List;

@Service
public class ServiceLogic implements DishService
{
    private final UserRepository userRepository;
    @Autowired
    public ServiceLogic(UserRepository userRepository)
    {
        this.userRepository = userRepository;
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
        userRepository.create(newDish);
    }
    @Override
    public Dish findById(Long id)
    {
        return userRepository.read(id);
    }
    @Override
    public void deleteById(Long id)
    {
        userRepository.delete(id);
    }

    @Override
    public void updateWeight(Long id, Double newWeight)
    {
        Dish dish = new Dish();
        dish.setId(id);
        dish.setWeight(newWeight);
        userRepository.update(dish);
    }

    @Override
    public void updateKilocalories(Long id, Integer newKilocalories) {
        Dish dish = new Dish();
        dish.setId(id);
        dish.setKilocalories(newKilocalories);
        userRepository.update(dish);
    }

    @Override
    public void updateProtein(Long id, Integer newProtein) {
        Dish dish = new Dish();
        dish.setId(id);
        dish.setProtein(newProtein);
        userRepository.update(dish);
    }

    @Override
    public void updateFat(Long id, Integer newFat) {
        Dish dish = new Dish();
        dish.setId(id);
        dish.setFat(newFat);
        userRepository.update(dish);
    }

    @Override
    public void updateCarbohydrates(Long id, Integer newCarbohydrates) {
        Dish dish = new Dish();
        dish.setId(id);
        dish.setCarbohydrates(newCarbohydrates);
        userRepository.update(dish);
    }
    @Override
    public List<Dish> findAllDishes() {
        return userRepository.findAll();
    }
}

