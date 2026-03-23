package ru.Yaroslav.NauJava;

import java.util.List;

/**
 * Интерфейс CRUD-репозитория
 */
public interface CrudRepository<T, ID>
{
    /** Создает новую сущность */
    void create(T entity);

    /** Находит сущность */
    T read(ID id);

    /** Обновляет существующую сущность */
    void update(T entity);

    /** Удаляет сущность */
    void delete(ID id);

    /** Возвращает все сущности */
    List<T> findAll();
}