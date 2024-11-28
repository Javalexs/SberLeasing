package ru.sberleasing;

import helpers.Properties;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.GooglePage;
import pages.ResultPage;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Класс тестов для "https://sberleasing.ru"
 */
public class Tests {

    //Переменная класса страницы поиска автомобиля по параметрам
    private static ResultPage rp = new ResultPage();

    @Feature("Проверка поиска на сайте sberleasing.ru")
    @DisplayName("Проверка поиска автомобиля на сайте sberleasing.ru для параметров")
    @ParameterizedTest(name = "{displayName}: {arguments}")
    @MethodSource("helpers.DataProvider#providerParameters")
    public void leasingSearchParametrsTest(String nameBank, String nameDriver, String fuel, String transmission, String typeBody, String color){
        open(Properties.testsProperties.googleUrl(), GooglePage.class)
                .inputValueInSearch(nameBank)
                .goSberLeasingSite()
                .selectParametersButtonClick();

                rp.selectOptions(nameDriver)
                        .selectOptions(transmission)
                        .selectOptions(fuel)
                        .selectTypeBody(typeBody)
                        .selectColor(color)
                        .sliderVolumeEngine()
                        .sliderPowerEngine()
                        .showAllOffersButtonClick();

                List<String> expectedNames = rp.getAllNameResults();
                String actualName = rp.viewOffersButtonClick().getNameSelectedOffer();

        assertTrue(expectedNames.contains(actualName), "Выбранная марка автомобиля не соответствует марке в общем списке");
    }
}
