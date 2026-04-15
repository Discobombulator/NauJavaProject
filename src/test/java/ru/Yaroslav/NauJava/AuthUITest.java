package ru.Yaroslav.NauJava;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AuthUITest {

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/login");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void shouldLoginSuccessfully() {
        driver.findElement(By.name("username")).sendKeys("test");
        driver.findElement(By.name("password")).sendKeys("123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        assertTrue(driver.getCurrentUrl().contains("home")
                || driver.getPageSource().contains("???????"));
    }

    @Test
    void shouldLogoutSuccessfully() {

        driver.findElement(By.name("username")).sendKeys("test");
        driver.findElement(By.name("password")).sendKeys("123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        driver.findElement(By.id("logout")).click();
        assertTrue(driver.getCurrentUrl().contains("login"));
    }
}
