package ru.Yaroslav.NauJava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.Yaroslav.NauJava.data.Dish;

import java.util.List;
import java.util.Objects;
import java.util.UUID;


@Component
public class DishRepository implements CrudRepository<Dish, Long>
{
    private final List<Dish> dishContainer;

    private Long generateId() {
        UUID uuid = UUID.randomUUID();

        long mostSignificantBits = uuid.getMostSignificantBits();
        return Math.abs(mostSignificantBits);
    }
    @Autowired
    public DishRepository(List<Dish> dishList)
    {
        this.dishContainer = dishList;
    }

    @Override
    public void create(Dish dish)
    {
        dish.setId(generateId());
        dishContainer.add(dish);
    }
    @Override
    public Dish read(Long id)
    {
        return dishContainer.stream()
                .filter(dish -> dish.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    @Override
    public void update(Dish dish)
    {
        for (int i=0 ;i<dishContainer.size();i++){
            if(Objects.equals(dishContainer.get(i).getId(), dish.getId())){
                dishContainer.set(i,dish);
                return;
            }
        }
        throw new RuntimeException("Блюда с id: " + dish.getId() + " не найдено");
    }
    @Override
    public void delete(Long id)
    {
        dishContainer.removeIf(dish -> dish.getId().equals(id));
    }

    @Override
    public List<Dish> findAll() {
        return dishContainer;
    }
}

