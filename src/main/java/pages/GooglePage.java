package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import helpers.Properties;

import static com.codeborne.selenide.Selenide.*;

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
    public GoogleResultSearchPage inputValueinSearch(String text) {
        googleSearch.setValue(text).pressEnter();
        return page(GoogleResultSearchPage.class);
    }
}
