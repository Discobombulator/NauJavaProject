package ru.Yaroslav.NauJava.exceptions;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Глобальный обработчик исключений для REST API
 */
@ControllerAdvice
public class ExceptionControllerAdvice {

    /** Обрабатывает все общие исключения */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiException handleException(Exception e) {
        return ApiException.create(e);
    }

    /** Обрабатывает исключения, когда ресурс не найден */
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiException handleNotFound(ResourceNotFoundException e) {
        return ApiException.create(e);
    }
}