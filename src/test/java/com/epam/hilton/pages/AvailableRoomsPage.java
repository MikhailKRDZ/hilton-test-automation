package com.epam.hilton.pages;

import com.epam.hilton.framework.service.IConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AvailableRoomsPage extends AbstractPage{

    private String searchResultRooms = "//main[@id='main-layout']//button[@data-test='selectButton']";

    public AvailableRoomsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected AvailableRoomsPage openPage() {
        return new AvailableRoomsPage(driver);
    }


    public double getRoomsMaxPrice() {
        double maxValue = Double.parseDouble(driver.findElements(By.xpath(searchResultRooms)).stream().reduce((a,b) ->
                Double.parseDouble(a.getText().replaceAll(IConstant.regexDoubleNumber, ""))
                        >=  Double.parseDouble(b.getText().replaceAll(IConstant.regexDoubleNumber, "")) ? a:b)
                .get().getText().replaceAll(IConstant.regexDoubleNumber, ""));
        return maxValue;
        }

    public void chooseMostExpensiveVariant() {
        driver.findElements(By.xpath(searchResultRooms)).stream().reduce((a,b) ->
                Double.parseDouble(a.getText().replaceAll(IConstant.regexDoubleNumber, ""))
                        >=  Double.parseDouble(b.getText().replaceAll(IConstant.regexDoubleNumber, "")) ? a:b)
                .get().click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

}
