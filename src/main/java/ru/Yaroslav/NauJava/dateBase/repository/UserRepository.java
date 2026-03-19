package ru.Yaroslav.NauJava.dateBase.repository;

import org.springframework.data.repository.CrudRepository;
import ru.Yaroslav.NauJava.dateBase.entity.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByName(String name);

}