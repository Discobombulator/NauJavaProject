package ru.Yaroslav.NauJava.exceptions;

/**
 * Класс для представления информации об исключении в API
 */
public class ApiException {

    private String message;
    private String type;

    /** Конструктор с сообщением и типом исключения */
    public ApiException(String message, String type) {
        this.message = message;
        this.type = type;
    }

    /** Создает объект ApiException на основе переданного исключения */
    public static ApiException create(Exception e) {
        return new ApiException(
                e.getMessage(),
                e.getClass().getSimpleName()
        );
    }

    /** Возвращает сообщение об ошибке */
    public String getMessage() { return message; }

    /** Возвращает тип исключения */
    public String getType() { return type; }
}