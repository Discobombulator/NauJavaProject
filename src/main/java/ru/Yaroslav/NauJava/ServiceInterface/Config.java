package ru.Yaroslav.NauJava.ServiceInterface;

import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import jakarta.annotation.PostConstruct;

@Configuration
public class Config
{
    @Value("${info.app.name}")
    private String appName;

    @Value("${info.app.version}")
    private String appVersion;

    @Autowired
    private CommandProcessor commandProcessor;

    @PostConstruct
    public void init() {
        System.out.println("  " + appName + " v" + appVersion);
    }

    @Bean
    public CommandLineRunner commandScanner()
    {
        return args ->
        {
            try (Scanner scanner = new Scanner(System.in))
            {
                System.out.println("Введите команду. 'exit' для выхода.");
                System.out.println("Введите команду. 'help' для вывода всех функций.");
                while (true)
                {
                    System.out.print("> ");
                    String input = scanner.nextLine();

                    if ("exit".equalsIgnoreCase(input.trim()))
                    {
                        System.out.println("Выход из программы...");
                        break;
                    }

                    commandProcessor.processCommand(input);
                }
            }
        };
    }
}