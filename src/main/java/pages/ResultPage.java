package pages;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ResultPage {


    SelenideElement selectParametersButton = $x("//a[contains(@class, 'sbl-btn') and contains(., 'Показать все предложения')]");

    SelenideElement carDrive = $x("//div[@id = 'automall-filter-horizontal']");

    SelenideElement sliderEnginePower = $x("//div[contains(@class, 'col-lg-4') and contains (., 'Мощность двигателя')]");

    SelenideElement sliderEngineCapacity = $x("//div[contains(@class, 'col-lg-4') and contains (., 'Объём двигателя')]");

    By endSlider = By.xpath(".//div[@aria-label = 'pick end value']");

    By startSlider = By.xpath(".//div[@aria-label = 'pick start value']");

    SelenideElement colorDropDown = $x("//input[@class = 'sbl-filter-block__search-string' and @placeholder = 'Выберите или введите']");

    ElementsCollection allResultsName = $$x("//div[contains(@class,'fs-14')]");

    ElementsCollection viewOffers = $$x("//div[@class = 'car-card__item-order-buttons']");

    SelenideElement nameSelectOffer = $x("//h1[@class = 'h2']");


    public SelenideElement checkBox (String text) {
        return $x(String.format("//div[contains(@class, 'horizontal-filter-block__checkboxes-item') and contains(., '%s')]/input[@type = 'checkbox']", text));
    }

    public SelenideElement checkBoxTypeBody (String text) {
        return $x (String.format("//div[@class = 'checkboxes-body-type__label' and contains(., '%s')]", text));
    }

    public ResultPage selectColor (String text) {
        colorDropDown.scrollIntoView(false).shouldHave(visible, enabled).setValue(text);
        return this;
    }

    public ResultPage selectParametersButtonClick() {
        selectParametersButton.shouldHave(visible).scrollIntoView("{block: 'end'}").click();
        return this;
    }

    public ResultPage selectTypeBody (String text) {
        checkBoxTypeBody(text).shouldHave(visible, enabled).click(ClickOptions.usingJavaScript());
        return this;
    }

    public ResultPage selectOptions(String text) {
       if(!checkBox(text).isSelected()){
           checkBox(text).click(ClickOptions.usingJavaScript());
       }
        return this;
    }

    public ResultPage slaiderPowerEnjine(){
        executeJavaScript("arguments[0].setAttribute('style', 'left': 20%;')", sliderEnginePower.$(startSlider));
        executeJavaScript("arguments[0].setAttribute('style', 'left': 70%;')", sliderEnginePower.$(endSlider));
        return this;
    }

    public List<String> getAllNameResults () {
        return allResultsName.texts();
    }

    public ResultPage viewOffersButtonClick() {
        viewOffers.first().shouldHave(visible, enabled).click();
        return this;
    }

    public String getNameSelectedOffer() {
        return nameSelectOffer.getText();
    }
}
