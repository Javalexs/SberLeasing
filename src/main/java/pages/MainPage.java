package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    SelenideElement selectParametrsButton = $x("//div[contains(@class, 'text-right') and contains(., 'Подобрать по параметрам')]");

    SelenideElement acceptAllCookieButton = $x("//button[text() = ' Принять всё ']");

    SelenideElement carDrive = $x("//div[@class = 'container' and contains(., 'Подобрать авто по параметрам')]//div[contains(@class, 'col-lg-4') and contains(., 'Привод')]");

    public By checkBox (String text) {
        return By.xpath(String.format(".//div[contains(@class, 'horizontal-filter-block__checkboxes-item') and contains(., %s)]/input", text));
    }

    public MainPage selectParametrsButtonClick() {
        cookieAccept();
        selectParametrsButton.shouldHave(visible, Duration.ofSeconds(90000)).click();
        return this;
    }

    private void cookieAccept() {
        acceptAllCookieButton.shouldHave(visible, Duration.ofSeconds(90000)).click();
    }



}
