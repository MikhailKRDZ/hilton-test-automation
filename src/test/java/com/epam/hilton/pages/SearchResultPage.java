package com.epam.hilton.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage extends AbstractPage {

    List<WebElement> webElements = new ArrayList<>(driver.findElements(By.xpath("//li[@data-testid]//a[@rel='noopener noreferrer']")));
    private String searchResult = "//li[@data-testid][%s]//a[@rel='noopener noreferrer']";
    private String searchResultHotelsDescription = "//li[@data-testid][%s]//a[@rel='noopener noreferrer']/ancestor::div[@data-testid='hotel-card-content']";

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }

    public int getSizeRatesButtons() {
        return webElements.size();
    }

    public void getRandomViewRatesHotel(int number) {
        driver.get(driver.findElement(By.xpath(String.format(searchResult, number))).getAttribute("href"));
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public String getHotelsName(int number) {
        return driver.findElement(By.xpath(String.format(searchResultHotelsDescription , number))).getText().split("\\n")[0];
    }
}
