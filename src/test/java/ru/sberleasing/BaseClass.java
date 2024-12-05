package ru.sberleasing;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Класс для установки опций и закрытия браузера
 */
public class BaseClass {


    /**
     * Установка необходимых опций
     * @author Алексей Фадеев
     */
    @BeforeAll
    public static void option(){
        Configuration.browser="chrome";
        Configuration.pageLoadTimeout = 600000;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-cookie-encryption");
        Configuration.browserCapabilities = options;
    }

    /**
     * Метод закрывает браузер после теста
     * @author Алексей Фадеев
     */
    @AfterEach
    public void closeTest(){
        if (WebDriverRunner.hasWebDriverStarted()) {
            WebDriverRunner.getWebDriver().quit();
        }
    }
}
