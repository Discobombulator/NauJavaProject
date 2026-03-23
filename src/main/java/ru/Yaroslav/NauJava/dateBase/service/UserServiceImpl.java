package ru.Yaroslav.NauJava.dateBase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import ru.Yaroslav.NauJava.dateBase.entity.FoodEntry;
import ru.Yaroslav.NauJava.dateBase.entity.User;
import ru.Yaroslav.NauJava.dateBase.repository.FoodEntryRepository;
import ru.Yaroslav.NauJava.dateBase.repository.UserRepository;

import java.util.List;

/**
 * Реализация сервиса для работы с пользователями
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final FoodEntryRepository foodEntryRepository;
    private final PlatformTransactionManager transactionManager;

    /** Конструктор с внедрением зависимостей */
    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           FoodEntryRepository foodEntryRepository,
                           PlatformTransactionManager transactionManager) {
        this.userRepository = userRepository;
        this.foodEntryRepository = foodEntryRepository;
        this.transactionManager = transactionManager;
    }

    /** Удаляет пользователя и все его записи о питании в рамках транзакции */
    @Override
    public void deleteUserWithEntries(Long userId) {

        TransactionStatus status =
                transactionManager.getTransaction(new DefaultTransactionDefinition());

        try {
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("User not found"));

            List<FoodEntry> entries = user.getFoodEntries();
            for (FoodEntry entry : entries) {
                foodEntryRepository.delete(entry);
            }

            userRepository.delete(user);

            transactionManager.commit(status);

        } catch (DataAccessException ex) {
            transactionManager.rollback(status);
            throw ex;
        }
    }
}