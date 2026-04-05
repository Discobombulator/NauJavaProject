package ru.Yaroslav.NauJava.dateBase.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.Yaroslav.NauJava.dateBase.entity.User;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(path = "users")
public interface UserRepository extends CrudRepository<User, Long> {

    /** Находит пользователей по имени */
    List<User> findByName(String name);

    /** Находит пользователя по email (для авторизации) */
    Optional<User> findByEmail(String email);
}