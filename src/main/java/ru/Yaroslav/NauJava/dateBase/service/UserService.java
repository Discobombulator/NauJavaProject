package ru.Yaroslav.NauJava.dateBase.service;

/**
 * Сервис для работы с пользователями
 */
public interface UserService {

    /** Удаляет пользователя и все связанные с ним записи о питании */
    void deleteUserWithEntries(Long userId);

}