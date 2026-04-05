package ru.Yaroslav.NauJava.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ru.Yaroslav.NauJava.dateBase.entity.User;
import ru.Yaroslav.NauJava.dateBase.repository.UserRepository;
import ru.Yaroslav.NauJava.security.Role;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Регистрирует нового пользователя
     */
    public void registerUser(User user) {

        userRepository.findByEmail(user.getEmail())
                .ifPresent(u -> {
                    throw new RuntimeException("User exists");
                });

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        user.setRole(Role.ROLE_USER);

        userRepository.save(user);
    }
}