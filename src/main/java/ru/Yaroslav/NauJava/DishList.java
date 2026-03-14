package ru.Yaroslav.NauJava;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.Yaroslav.NauJava.data.Dish;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DishList {

    @Bean
    @Scope(value = BeanDefinition.SCOPE_SINGLETON)
    public List<Dish> createDishList(){
        return new ArrayList<>();
    }
}
