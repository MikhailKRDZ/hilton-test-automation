package com.epam.hilton.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpdateRatesPage extends AbstractPage{

    @FindBy(xpath = "//div[@data-testid='rateTableStandardCell'][2]//button[@data-testid='standardPriceBookCTA']")
    private WebElement bookButton;

    public UpdateRatesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }

    public void clickBookButton() {
        bookButton.click();
    }

}
