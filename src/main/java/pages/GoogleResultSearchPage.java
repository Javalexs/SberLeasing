package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

/**
 * Класс страницы результатов поиска в Google
 */
public class GoogleResultSearchPage {

    // Список всех результатов поиска
    ElementsCollection resultSearchGoogle = $$x("//h3[contains(., 'СберЛизинг')]");

    /**
     * Метод выбирает первый результат поиска в google
     * @author Алексей Фадеев
     */
    public MainPage goSberLeasingSite () {
        resultSearchGoogle.first().shouldHave(visible, Duration.ofSeconds(90000)).click();
        switchTab();
        return page(MainPage.class);
    }

    /**
     * Метод для переключения вкладок
     * @author Алексей Фадеев
     */
    private static void switchTab() {
        WebDriver driver = WebDriverRunner.getWebDriver();
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
}
