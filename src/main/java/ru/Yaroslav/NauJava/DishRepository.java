package ru.Yaroslav.NauJava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.Yaroslav.NauJava.data.Dish;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Репозиторий для работы с блюдами
 */
@Component
public class DishRepository implements CrudRepository<Dish, Long>
{
    private final List<Dish> dishContainer;

    /** Генерирует уникальный идентификатор */
    private Long generateId() {
        UUID uuid = UUID.randomUUID();

        long mostSignificantBits = uuid.getMostSignificantBits();
        return Math.abs(mostSignificantBits);
    }
    /** Конструктор с внедрением списка блюд */
    @Autowired
    public DishRepository(List<Dish> dishList)
    {
        this.dishContainer = dishList;
    }

    /** Создает новое блюдо */
    @Override
    public void create(Dish dish)
    {
        dish.setId(generateId());
        dishContainer.add(dish);
    }

    /** Находит блюдо */
    @Override
    public Dish read(Long id)
    {
        return dishContainer.stream()
                .filter(dish -> dish.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    /** Обновляет существующее блюдо */
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

    /** Удаляет блюдо */
    @Override
    public void delete(Long id)
    {
        dishContainer.removeIf(dish -> dish.getId().equals(id));
    }

    /** Возвращает список всех блюд */
    @Override
    public List<Dish> findAll() {
        return dishContainer;
    }
}

