package com.epam.hilton.helpers;

import com.epam.hilton.pages.HomePage;
import org.openqa.selenium.WebDriver;

public class HomeHelper extends AbstractHelper {
    private HomePage homePage = new HomePage(this.driver);

    public HomeHelper(WebDriver driver) {
        super(driver);
    }

    public HomeHelper openPage() {
        log.info("Open Home page");
        homePage.openPage();
        return this;
    }

    public HomeHelper fillSearchForm(String inputData) {
        log.info("Fill 'Search Form'  with 'input data' - " + inputData);
        homePage.fillSearchForm(inputData);
        return this;
    }
}
