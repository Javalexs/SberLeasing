package ru.sberleasing;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Класс для установки опций и закрытия браузера
 */
public class BaseClass {

    /**
     * Установка необходимых опций
     * @author Алексей Фадеев
     */
    @BeforeEach
    public void option(){
        Configuration.browser="chrome";
        Configuration.pageLoadTimeout = 600000;
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
//        options.addArguments("--disable-gpu");
//        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--disable-cookie-encryption");
        Configuration.browserCapabilities = options;
        System.setProperty("webdriver.chrome.driver",System.getenv("CHROME_DRIVER"));
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
