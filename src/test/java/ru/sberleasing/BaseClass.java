package ru.sberleasing;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {

    /**
     * Установка необходимых опций
     * @author Алексей Фадеев
     */
    @BeforeEach
    public void option(){
        Configuration.timeout = 10000;
        Configuration.browser="chrome";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--incognito");
        options.addArguments("--disable-cookie-encryption");
        Configuration.browserCapabilities = options;
        System.setProperty("webdriver.chrome.driver",System.getenv("CHROME_DRIVER"));
    }
}
