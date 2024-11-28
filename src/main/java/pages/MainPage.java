package pages;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Класс главной страницы сайта СберЛизинг
 */
public class MainPage {

    // Заголовок сайта
    SelenideElement title = $x("//a[@class = 'header__item-logo']");

    // Кнопка Подобрать по параметрам
    SelenideElement selectParametersButton = $x("//div[contains(@class, 'text-right') and contains(., 'Подобрать по параметрам')]");

    // Кнопка Принять куки
    SelenideElement acceptAllCookieButton = $x("//button[text() = ' Принять всё ']");

    /**
     * Метод провяряет заголовок сайта
     * @author Алексей Фадеев
     * @return text - Название сайта
     */
    public MainPage checkTitle(String text) {
        Assertions.assertTrue(title.getText().contains(text), "Заголовок сайта не соответствует ожидаемому");
        return this;
    }

    /**
     * Метод нажимает кнопку Подобрать по параметрам
     * @author Алексей Фадеев
     */
    public MainPage selectParametersButtonClick() {
        cookieAccept();
        selectParametersButton.shouldHave(visible, Duration.ofSeconds(600000)).click();
        return this;
    }

    /**
     * Метод нажимает кнопку Принять все (куки)
     * @author Алексей Фадеев
     */
    private void cookieAccept() {
        acceptAllCookieButton.shouldHave(visible, Duration.ofSeconds(600000)).click();
    }
}
