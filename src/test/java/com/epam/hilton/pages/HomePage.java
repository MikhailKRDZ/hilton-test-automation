package com.epam.hilton.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class HomePage extends AbstractPage  {
    private static final String HOMEPAGE_URL = "https://www.hilton.com/en/";
    private String string;

    @FindBy(id = "search-form-query")
    private WebElement searchFormQuery;


    public HomePage(WebDriver driver) {
        super(driver);
    }



    public void fillSearchForm(String inputData) {
        searchFormQuery.sendKeys(inputData);
    }

    @Override
    public HomePage openPage() {
        driver.get(HOMEPAGE_URL);
        driver.manage().timeouts().pageLoadTimeout(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        return this;
    }
}
