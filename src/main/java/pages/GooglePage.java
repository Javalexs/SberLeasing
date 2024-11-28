package pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

/**
 * Класс страницы Google
 */
public class GooglePage {

    // Строка поиска google
    SelenideElement googleSearch = $x("//textarea[@title = 'Поиск']");

    /**
     * Метод вводит значение и нажимает кнопку поиска в google
     * @author Алексей Фадеев
     * @return
     */
    public GoogleResultSearchPage inputValueInSearch(String text) {
        googleSearch.shouldHave(visible, Duration.ofSeconds(90000)).setValue(text).pressEnter();
        return page(GoogleResultSearchPage.class);
    }
}
