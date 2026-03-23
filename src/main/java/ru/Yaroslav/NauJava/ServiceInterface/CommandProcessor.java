package ru.Yaroslav.NauJava.ServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.Yaroslav.NauJava.data.Dish;
import ru.Yaroslav.NauJava.logic.DishService;

import java.util.List;
import java.util.Scanner;

/**
 * Обработчик консольных команд
 */
@Component
public class CommandProcessor
{
    private final DishService dishService;
    private final Scanner scanner = new Scanner(System.in);

    /** Конструктор */
    @Autowired
    public CommandProcessor(DishService dishService)
    {
        this.dishService = dishService;
    }

    /** Обрабатывает введенную команду */
    public void processCommand(String input)
    {
        String[] cmd = input.split(" ");
        switch (cmd[0])
        {
            case "create" ->
            {
                System.out.println("Создание нового блюда:");

                System.out.print("Введите название блюда: ");
                String name = scanner.nextLine();

                System.out.print("Введите вес (в граммах): ");
                double weight = Double.parseDouble(scanner.nextLine());

                System.out.print("Введите калорийность: ");
                int kilocalories = Integer.parseInt(scanner.nextLine());

                System.out.print("Введите количество белков: ");
                int protein = Integer.parseInt(scanner.nextLine());

                System.out.print("Введите количество жиров: ");
                int fat = Integer.parseInt(scanner.nextLine());

                System.out.print("Введите количество углеводов: ");
                int carbohydrates = Integer.parseInt(scanner.nextLine());

                dishService.createDish(name, weight, kilocalories, protein, fat, carbohydrates);
                System.out.println("Блюдо успешно добавлен...");
            }
            case "find" ->
            {
                System.out.println("Введите id блюда: ");
                Long id = Long.parseLong(scanner.nextLine());
                Dish dish = dishService.findById(id);
                if (dish == null){
                    System.out.println("Блюдо не найдено");
                }
                else {
                    System.out.println("Блюдо успешно найдено: ");
                    System.out.println("ID: " + dish.getId());
                    System.out.println("Название: " + dish.getName());
                    System.out.println("Вес: " + dish.getWeight() + " г");
                    System.out.println("Калории: " + dish.getKilocalories() + " ккал");
                    System.out.println("Белки: " + dish.getProtein() + " г");
                    System.out.println("Жиры: " + dish.getFat() + " г");
                    System.out.println("Углеводы: " + dish.getCarbohydrates() + " г");
                }
            }
            case "delete" ->
            {
                System.out.println("Введите id блюда для удаления: ");
                Long id = Long.parseLong(scanner.nextLine());
                Dish dish = dishService.findById(id);
                if (dish == null){
                    System.out.println("Блюдо не найдено");
                }
                else {
                    dishService.deleteById(id);
                    System.out.println("Блюдо успешно удалено");
                }
            }
            case "update-weight" ->
            {
                System.out.println("Обновление веса блюда");
                System.out.print("Введите ID блюда: ");
                Long id = Long.parseLong(scanner.nextLine());

                Dish dish = dishService.findById(id);
                if (dish == null) {
                    System.out.println("Блюдо не найдено");
                } else {
                    System.out.print("Введите новый вес (в граммах): ");
                    Double newWeight = Double.parseDouble(scanner.nextLine());

                    dishService.updateWeight(id, newWeight);
                    System.out.println("Вес блюда успешно обновлён");
                }
            }
            case "update-calories" ->
            {
                System.out.println("Обновление калорийности блюда");
                System.out.print("Введите ID блюда: ");
                Long id = Long.parseLong(scanner.nextLine());

                Dish dish = dishService.findById(id);
                if (dish == null) {
                    System.out.println("Блюдо не найдено");
                } else {
                    System.out.print("Введите новую калорийность: ");
                    Integer newCalories = Integer.parseInt(scanner.nextLine());

                    dishService.updateKilocalories(id, newCalories);
                    System.out.println("Калорийность блюда успешно обновлена");
                }
            }
            case "update-protein" ->
            {
                System.out.println("Обновление содержания белков");
                System.out.print("Введите ID блюда: ");
                Long id = Long.parseLong(scanner.nextLine());

                Dish dish = dishService.findById(id);
                if (dish == null) {
                    System.out.println("Блюдо не найдено");
                } else {
                    System.out.print("Введите новое содержание белков (г): ");
                    Integer newProtein = Integer.parseInt(scanner.nextLine());

                    dishService.updateProtein(id, newProtein);
                    System.out.println("Содержание белков успешно обновлено");
                }
            }
            case "update-fat" ->
            {
                System.out.println("Обновление содержания жиров");
                System.out.print("Введите ID блюда: ");
                Long id = Long.parseLong(scanner.nextLine());

                Dish dish = dishService.findById(id);
                if (dish == null) {
                    System.out.println("Блюдо не найдено");
                } else {
                    System.out.print("Введите новое содержание жиров (г): ");
                    Integer newFat = Integer.parseInt(scanner.nextLine());

                    dishService.updateFat(id, newFat);
                    System.out.println("Содержание жиров успешно обновлено");
                }
            }
            case "update-carbs" ->
            {
                System.out.println("Обновление содержания углеводов");
                System.out.print("Введите ID блюда: ");
                Long id = Long.parseLong(scanner.nextLine());

                Dish dish = dishService.findById(id);
                if (dish == null) {
                    System.out.println("Блюдо не найдено");
                } else {
                    System.out.print("Введите новое содержание углеводов (г): ");
                    Integer newCarbs = Integer.parseInt(scanner.nextLine());

                    dishService.updateCarbohydrates(id, newCarbs);
                    System.out.println("Содержание углеводов успешно обновлено");
                }
            }
            case "list" ->
            {
                List<Dish> dishes = dishService.findAllDishes();
                if (dishes.isEmpty()) {
                    System.out.println("Список блюд пуст");
                } else {
                    System.out.println("Список блюд:");
                    System.out.println("----------------------------------------");
                    for (Dish dish : dishes) {
                        System.out.println("ID: " + dish.getId());
                        System.out.println("Название: " + dish.getName());
                        System.out.println("Вес: " + dish.getWeight() + " г");
                        System.out.println("Калории: " + dish.getKilocalories() + " ккал");
                        System.out.println("Белки: " + dish.getProtein() + " г");
                        System.out.println("Жиры: " + dish.getFat() + " г");
                        System.out.println("Углеводы: " + dish.getCarbohydrates() + " г");
                    }
                }
            }
            case "help" -> {
                System.out.println("Доступные команды:");
                System.out.println("  create                 - создать новое блюдо");
                System.out.println("  list                   - показать все блюда");
                System.out.println("  find                   - показать детали блюда");
                System.out.println("  delete                 - удалить блюдо");
                System.out.println("  update-weight          - обновить вес блюда");
                System.out.println("  update-calories        - обновить калорийность");
                System.out.println("  update-protein         - обновить белки");
                System.out.println("  update-fat             - обновить жиры");
                System.out.println("  update-carbs           - обновить углеводы");
                System.out.println("  update                 - универсальное обновление");
                System.out.println("  exit                   - выход из программы\n");
            }

            default -> System.out.println("Введена неизвестная команда...");
        }
    }
}