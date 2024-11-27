package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import helpers.Properties;

import static com.codeborne.selenide.Selenide.*;

public class GooglePage {

    SelenideElement googleSearch = $x("//textarea[@title = 'Поиск']");

    ElementsCollection googleSearchButtons = $$x("//input[@value = 'Поиск в Google']");

    /**
     * Метод переходит на сайт Google.ru
     * @author Алексей Фадеев
     * @return
     */

//    public GooglePage gotoSite() {
//        open(Properties.testsProperties.googleUrl(), GooglePage.class);
//        return this;
//    }

    /**
     * Метод вводит значение и нажимает кнопку поиска
     * @author Алексей Фадеев
     * @return
     */
    public GoogleResultSearchPage inputValueinSearch(String text) {
        googleSearch.setValue(text).pressEnter();
//        googleSearchButtons.last().;
        return page(GoogleResultSearchPage.class);
    }
}
