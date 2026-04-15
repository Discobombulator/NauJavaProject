package ru.Yaroslav.NauJava;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import ru.Yaroslav.NauJava.dateBase.entity.FoodEntry;
import ru.Yaroslav.NauJava.dateBase.entity.User;
import ru.Yaroslav.NauJava.dateBase.repository.FoodEntryRepository;
import ru.Yaroslav.NauJava.dateBase.repository.UserRepository;
import ru.Yaroslav.NauJava.dateBase.service.UserServiceImpl;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private FoodEntryRepository foodEntryRepository;

    @Mock
    private PlatformTransactionManager transactionManager;

    @Mock
    private TransactionStatus transactionStatus;

    @InjectMocks
    private UserServiceImpl userService;

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setId(1L);
    }

    @Test
    void shouldDeleteUserWithEntries() {
        FoodEntry entry = new FoodEntry();
        user.setFoodEntries(List.of(entry));

        when(transactionManager.getTransaction(any()))
                .thenReturn(transactionStatus);
        when(userRepository.findById(1L))
                .thenReturn(Optional.of(user));

        userService.deleteUserWithEntries(1L);

        verify(foodEntryRepository).delete(entry);
        verify(userRepository).delete(user);
        verify(transactionManager).commit(transactionStatus);
    }

    @Test
    void shouldThrowExceptionWhenUserNotFound() {
        when(transactionManager.getTransaction(any()))
                .thenReturn(transactionStatus);
        when(userRepository.findById(1L))
                .thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> {
            userService.deleteUserWithEntries(1L);
        });
    }

    @Test
    void shouldRollbackOnException() {
        when(transactionManager.getTransaction(any()))
                .thenReturn(transactionStatus);
        when(userRepository.findById(1L))
                .thenThrow(new DataAccessException("DB error") {});

        assertThrows(DataAccessException.class, () -> {
            userService.deleteUserWithEntries(1L);
        });

        verify(transactionManager).rollback(transactionStatus);
    }
}