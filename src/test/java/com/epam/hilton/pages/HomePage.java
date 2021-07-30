package com.epam.hilton.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomePage extends AbstractPage{
    private static final String HOMEPAGE_URL = "https://www.hilton.com/en/";
    String pagesHeadLocator = "//html[@dir='ltr']";

    @FindBy(id = "search-form-query")
    private WebElement searchFormQuery;

    @FindBy(xpath = "//button[@aria-controls='searchFormRoomInfo']")
    private WebElement formRoomButton;

    @FindBy(xpath = "//button[@aria-controls='searchFormCalendar']")
    private WebElement calendarButton;

    @FindBy(xpath = "//button[@data-testid='search-cta-btn']")
    private WebElement findHotelButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void fillSearchForm(String inputData) {
        searchFormQuery.sendKeys(inputData);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.attributeContains(searchFormQuery,"value",inputData));
    }

    public void clickFormRoomButton() {
        formRoomButton.click();
    }

    public void clickCalendarButton() {
        calendarButton.click();
    }

    @Override
    public HomePage openPage() {
        driver.get(HOMEPAGE_URL);
        driver.manage().timeouts().pageLoadTimeout(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        return this;
    }

    public void clickFindHotelButton() {
        findHotelButton.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(pagesHeadLocator)));
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

}
