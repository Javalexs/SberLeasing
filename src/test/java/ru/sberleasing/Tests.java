package ru.sberleasing;

import dev.failsafe.internal.util.Assert;
import helpers.Properties;
import io.qameta.allure.Feature;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.GooglePage;
import pages.MainPage;
import pages.ResultPage;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests {

    private static ResultPage rp = new ResultPage();

    @Feature("Проверка функций на сайте sberleasing.ru")
    @DisplayName("Проверка различных функций на сайте sberleasing.ru для параметров")
    @ParameterizedTest(name = "{displayName}: {arguments}")
    @MethodSource("helpers.DataProvider#providerParameters")
    public void leasingSearchParametrsTest(String nameDriver, String fuel, String transmission, String typeBody, String color){
        open(Properties.testsProperties.googleUrl(), GooglePage.class)
                .inputValueinSearch("СберЛизинг")
                .goSberLeasingSite()
                .checkTitle("Сбербанк Лизинг")
                .selectParametersButtonClick();

                rp.selectOptions(nameDriver)
                        .selectOptions(fuel)
                        .selectOptions(transmission)
                        .selectTypeBody(typeBody)
                        .selectColor(color)
                        .showAllOffersButtonClick();

                List<String> expectedNames = rp.getAllNameResults();
                String actualName = rp.viewOffersButtonClick().getNameSelectedOffer();

        assertTrue(expectedNames.contains(actualName), "Выбранная марка автомобиля не соответствует марке в общем списке");
    }
}
