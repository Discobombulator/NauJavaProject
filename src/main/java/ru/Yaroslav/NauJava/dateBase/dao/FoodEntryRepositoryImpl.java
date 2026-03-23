package ru.Yaroslav.NauJava.dateBase.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;
import ru.Yaroslav.NauJava.dateBase.entity.FoodEntry;
import ru.Yaroslav.NauJava.dateBase.entity.User;

import java.time.LocalDate;
import java.util.List;

/**
 * Реализация кастомного репозитория записей о питании
 */
@Repository
public class FoodEntryRepositoryImpl implements FoodEntryRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    /** Находит записи за период между датами */
    @Override
    public List<FoodEntry> findByDateBetween(LocalDate start, LocalDate end) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<FoodEntry> cq = cb.createQuery(FoodEntry.class);

        Root<FoodEntry> root = cq.from(FoodEntry.class);

        Predicate datePredicate = cb.between(root.get("entryDate"), start, end);

        cq.select(root).where(datePredicate);

        return entityManager.createQuery(cq).getResultList();
    }

    /** Находит записи по имени пользователя */
    @Override
    public List<FoodEntry> findByUserName(String userName) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<FoodEntry> cq = cb.createQuery(FoodEntry.class);

        Root<FoodEntry> root = cq.from(FoodEntry.class);

        Join<FoodEntry, User> userJoin = root.join("user", JoinType.INNER);

        Predicate userPredicate = cb.equal(userJoin.get("name"), userName);

        cq.select(root).where(userPredicate);

        return entityManager.createQuery(cq).getResultList();
    }
}