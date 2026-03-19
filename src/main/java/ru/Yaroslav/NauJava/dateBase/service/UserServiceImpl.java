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

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final FoodEntryRepository foodEntryRepository;
    private final PlatformTransactionManager transactionManager;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           FoodEntryRepository foodEntryRepository,
                           PlatformTransactionManager transactionManager) {
        this.userRepository = userRepository;
        this.foodEntryRepository = foodEntryRepository;
        this.transactionManager = transactionManager;
    }

    @Override
    public void deleteUserWithEntries(Long userId) {

        TransactionStatus status =
                transactionManager.getTransaction(new DefaultTransactionDefinition());

        try {
            // 1. найти пользователя
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("User not found"));

            // 2. удалить все FoodEntry
            List<FoodEntry> entries = user.getFoodEntries();
            for (FoodEntry entry : entries) {
                foodEntryRepository.delete(entry);
            }

            // 3. удалить пользователя
            userRepository.delete(user);

            // 4. commit
            transactionManager.commit(status);

        } catch (DataAccessException ex) {
            // rollback при ошибке
            transactionManager.rollback(status);
            throw ex;
        }
    }
}