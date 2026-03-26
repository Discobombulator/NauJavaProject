package ru.Yaroslav.NauJava.exceptions;

/**
 * Исключение, выбрасываемое при отсутствии запрашиваемого ресурса
 */
public class ResourceNotFoundException extends RuntimeException {

    /** Конструктор с сообщением об ошибке */
    public ResourceNotFoundException(String message) {
        super(message);
    }
}