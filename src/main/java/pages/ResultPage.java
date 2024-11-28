package pages;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


/**
 * Класс страницы поиска сайта СберЛизинг
 */
public class ResultPage {

    // Селектор кнопки Показать все результаты
    SelenideElement showAllOffersButton = $x("//a[contains(@class, 'sbl-btn') and contains(., 'Показать все предложения')]");

    //Мультиселект цвета
    SelenideElement colorDropDown = $x("//input[@class = 'sbl-filter-block__search-string' and @placeholder = 'Выберите или введите']");

    //Селектор выбора всех результатов поиска
    ElementsCollection allResultsName = $$x("//div[contains(@class,'fs-14')]");

    //Селектор выбора предложения
    ElementsCollection viewOffers = $$x("//div[@class = 'car-card__item-order-buttons']");

    //Название выбранного элемента
    SelenideElement nameSelectOffer = $x("//h1[@class = 'h2']");

    //Селектор слайдера Мощность двигателя
    SelenideElement sliderPowerEngine = $x("//div[contains(@class, 'col-lg-4') and contains(., 'Мощность двигателя')]");

    //Селектор слайдера Объем двигателя
    SelenideElement sliderVolumeEngine = $x("//div[contains(@class, 'col-lg-4') and contains(., 'Объём двигателя')]");

    //Селектор правого бегунка слайдера
    By endSlider = By.xpath(".//div[@aria-label = 'pick end value']");

    /**
     * Метод изменяет параметры слайдера Мощность двигателя
     * @author Алексей Фадеев
     */
    public ResultPage sliderVolumeEngine() {
        actions().moveToElement(sliderVolumeEngine.$(endSlider)).clickAndHold().moveByOffset(-130, 0).release().perform();
        return this;
    }

    /**
     * Метод изменяет параметры слайдера Мощность двигателя
     * @author Алексей Фадеев
     */
    public ResultPage sliderPowerEngine() {
        actions().moveToElement(sliderPowerEngine.$(endSlider)).clickAndHold().moveByOffset(-100, 0).release().perform();
        sleep(3000);
        return this;
    }

    /**
     * Метод возвращает элемент чекбокса для Тип топлива, Привод, Коробка передач
     * @author Алексей Фадеев
     * @return text - Тип топлива, Привод, Коробка передач
     */
    public SelenideElement checkBox (String text) {
        return $x(String.format("//div[contains(@class, 'horizontal-filter-block__checkboxes-item') and contains(., '%s')]/input[@type = 'checkbox']", text));
    }

    /**
     * Метод возвращает элемент чекбокса для Типа кузова
     * @author Алексей Фадеев
     * @return text -Тип кузова
     */
    public SelenideElement checkBoxTypeBody (String text) {
        return $x (String.format("//div[@class = 'checkboxes-body-type__label' and contains(., '%s')]", text));
    }

    /**
     * Метод выбирает цвет кузова
     * @author Алексей Фадеев
     * @return text - Цвет кузова
     */
    public ResultPage selectColor (String text) {
        colorDropDown.scrollIntoView(false).shouldHave(visible, enabled).setValue(text);
        return this;
    }

    /**
     * Метод выбирает опции поиска через чекбокс (Тип топлива, Привод, Коробка передач)
     * @author Алексей Фадеев
     */
    public ResultPage showAllOffersButtonClick() {
        showAllOffersButton.shouldHave(visible, Duration.ofSeconds(600)).scrollIntoView(false).click();
        return this;
    }

    /**
     * Метод выбирает опции типа кузова через чекбокс
     * @author Алексей Фадеев
     * @return text - Тип кузова
     */
    public ResultPage selectTypeBody (String text) {
        checkBoxTypeBody(text).shouldHave(visible, enabled).click(ClickOptions.usingJavaScript());
        return this;
    }

    /**
     * Метод выбирает опции поиска через чекбокс (Тип топлива, Привод, Коробка передач)
     * @author Алексей Фадеев
     * @return text - Тип топлива, Привод, Коробка передач
     */
    public ResultPage selectOptions(String text) {
       if(!checkBox(text).isSelected()){
           checkBox(text).click(ClickOptions.usingJavaScript());
       }
        return this;
    }

    /**
     * Метод возвращает все результаты поиска
     * @author Алексей Фадеев
     */
    public List<String> getAllNameResults () {
        return allResultsName.texts();
    }

    /**
     * Метод нажимает кнопку Выбрать предложение
     * @author Алексей Фадеев
     */
    public ResultPage viewOffersButtonClick() {
        viewOffers.first().shouldHave(visible, enabled).click();
        return this;
    }

    /**
     * Метод возвращает выбранный результат
     * @author Алексей Фадеев
     */
    public String getNameSelectedOffer() {
        return nameSelectOffer.getText();
    }
}
