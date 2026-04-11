package ru.Yaroslav.NauJava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Основной класс приложения
 */
@EnableAsync
@SpringBootApplication
public class NauJavaApplication {

	/** Точка входа в приложение */
	public static void main(String[] args) {
		SpringApplication.run(NauJavaApplication.class, args);
	}

}