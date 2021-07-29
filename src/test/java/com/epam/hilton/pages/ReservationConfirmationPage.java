package com.epam.hilton.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReservationConfirmationPage extends AbstractPage{

  @FindBy(xpath = "//div[@data-testid='resconfirmTotalForStay']/span")
  private WebElement searchFormQuery;

    public ReservationConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected AbstractPage openPage() {
        return this;
    }

    public String getTotalForStay() {
        return searchFormQuery.getText();
    }



}
