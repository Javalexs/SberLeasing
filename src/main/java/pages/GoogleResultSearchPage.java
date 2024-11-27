package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.page;

public class GoogleResultSearchPage {

    ElementsCollection resultSearchGoogle = $$x("//h3[contains(., 'СберЛизинг')]");

    public MainPage goSberLeasingSite () {
        resultSearchGoogle.first().shouldHave(visible, Duration.ofSeconds(90000)).click();
        WebDriver driver = WebDriverRunner.getWebDriver();
        String originalWindow = driver.getWindowHandle();  // Сохраняем текущую вкладку

        // Получаем все идентификаторы окон (вкладок)
        for (String windowHandle : driver.getWindowHandles()) {
            // Переключаемся на вторую вкладку
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;  // Выходим после переключения
            }
        }
        return page(MainPage.class);
    }
}
