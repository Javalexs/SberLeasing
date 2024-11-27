package ru.sberleasing;

import helpers.Properties;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.jupiter.api.Test;
import pages.GooglePage;
import pages.MainPage;
import pages.ResultPage;

import static com.codeborne.selenide.Selenide.open;

public class Tests {

    @Test
    public void leasingSearchParametrsTest(){
        open(Properties.testsProperties.googleUrl(), MainPage.class)
//                .inputValueinSearch("sberleasing")
//                .goSberLeasingSite()
                .selectParametrsButtonClick();

        ResultPage rp = new ResultPage();
                rp.selectCarDrive("полный")
                        .selectCarDrive("бензин")
                        .selectCarDrive("автомат")
                        .selectTypeBody("универсал")
                        .slaiderPowerEnjine()

                        .selectParametersButtonClick();
    }
}
