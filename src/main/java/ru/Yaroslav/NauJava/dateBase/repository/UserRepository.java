package ru.Yaroslav.NauJava.dateBase.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.Yaroslav.NauJava.dateBase.entity.User;

import java.util.List;

/**
 * Репозиторий для работы с пользователями
 */
@RepositoryRestResource(path = "users")
public interface UserRepository extends CrudRepository<User, Long> {

    /** Находит пользователей по имени */
    List<User> findByName(String name);

}