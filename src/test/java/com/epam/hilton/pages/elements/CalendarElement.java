package com.epam.hilton.pages.elements;

import com.epam.hilton.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalendarElement extends HomePage {

  private String dayResult = "//button[contains(@id,'%s')]";

    @FindBy(xpath = "//div[@id='searchFormCalendar']//button[contains(@class,'font-bold')]")
    private WebElement todayData;

    @FindBy(xpath = "//div[@id='searchFormCalendar']//button[contains(@class,'mr-auto')]")
    private WebElement closeCalendarButton;

    public CalendarElement(WebDriver driver) {
        super(driver);
    }

    public String getTodayId() {
      return todayData.getAttribute("id");
    }

    public void clickDate(long longTime) {
        driver.findElement(By.xpath(String.format(dayResult,longTime))).click();
    }

    public void clickCloseCalendarButton() {
        closeCalendarButton.click();
    }

}
