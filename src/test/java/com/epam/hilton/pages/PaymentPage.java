package com.epam.hilton.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage extends AbstractPage {

    private String dropDownMonthInput = "//select[@id='dropDownmonth']/option[@value='%s']";
    private String dropDownYearInput = "//select[@id='dropDownyear']/option[@value='%s']";

    @FindBy(xpath = "//input[@id='cardNumberTextInput']")
    private WebElement cardNumberTextInput;

    @FindBy(xpath = "//select[@id='dropDownmonth']")
    private WebElement selectMonth;

    @FindBy(xpath = "//select[@id='dropDownyear']")
    private WebElement selectYear;

    @FindBy(xpath = "//input[@id='firstNameTextInput']")
    private WebElement inputFirstName;

    @FindBy(xpath = "//input[@id='lastNameTextInput']")
    private WebElement inputLastName;

    @FindBy(xpath = "//input[@id='emailTextInput']")
    private WebElement inputEmail;

    @FindBy(xpath = "//input[@id='phoneTextInput']")
    private WebElement inputPhone;

    @FindBy(xpath = "//input[@id='addressLine1TextInput']")
    private WebElement inputAddress;

    @FindBy(xpath = "//ul/li[@aria-selected='false'][1]")
    private WebElement dropDownFirstAddress;

    @FindBy(xpath = "//button[@data-testid='bookReservationBtn']")
    private WebElement bookReservationButton;

    @FindBy(xpath = "//ul/li[@aria-selected='true']")
    private WebElement availableDropDownAddress;

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }

    public void fillCardNumberTextInput(String cardNumber) {
        cardNumberTextInput.sendKeys(cardNumber);
    }

    public void clickSelectMonth() {
        selectMonth.click();
    }

    public void chooseMonth(String validMonth) {
    new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.xpath(String.format(dropDownMonthInput, validMonth))))).click();
    }

    public void clickSelectYear() {
        selectYear.click();
    }

    public void chooseYear(String validYear) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(
                        driver.findElement(By.xpath(String.format(dropDownYearInput, validYear))))).click();
    }

    public void inputFirstName(String validFirstName) {
        inputFirstName.sendKeys(validFirstName);
    }

    public void inputLastName(String validLastName) {
        inputLastName.sendKeys(validLastName);
    }

    public void inputEmail(String validEmail) {
        inputEmail.sendKeys(validEmail);
    }

    public void inputPhone(String validPhone) {
        inputPhone.sendKeys(validPhone);
    }

  public void inputAddress(String validAddress) {
      String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
              + "var elementTop = arguments[0].getBoundingClientRect().top;"
              + "window.scrollBy(0, elementTop-(viewPortHeight/2));";

      ((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, inputAddress);
      inputAddress.sendKeys(validAddress);
  }

    public void chooseFirstDropDownAddress() {
    new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .until(ExpectedConditions.visibilityOf(dropDownFirstAddress));

        Actions builder = new Actions(driver);
        builder.moveToElement(dropDownFirstAddress).perform();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(availableDropDownAddress)).click();
    }

    public void clickBookReservationButton() {
        bookReservationButton.click();
    }
}
