package ru.Yaroslav.NauJava.dateBase.entity;

import jakarta.persistence.*;
import java.util.List;

/**
 * Сущность пользователя
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FoodEntry> foodEntries;

    /** Конструктор по умолчанию */
    public User() {}

    /** Возвращает идентификатор */
    public Long getId() { return id; }
    /** Устанавливает идентификатор */
    public void setId(Long id) { this.id = id; }

    /** Возвращает имя пользователя */
    public String getName() { return name; }
    /** Устанавливает имя пользователя */
    public void setName(String name) { this.name = name; }

    /** Возвращает email пользователя */
    public String getEmail() { return email; }
    /** Устанавливает email пользователя */
    public void setEmail(String email) { this.email = email; }

    /** Возвращает пароль пользователя */
    public String getPassword() { return password; }
    /** Устанавливает пароль пользователя */
    public void setPassword(String password) { this.password = password; }

    /** Возвращает записи о приеме пищи */
    public List<FoodEntry> getFoodEntries() { return foodEntries; }
    /** Устанавливает записи о приеме пищи */
    public void setFoodEntries(List<FoodEntry> foodEntries) { this.foodEntries = foodEntries; }
}