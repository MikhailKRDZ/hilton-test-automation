package com.epam.hilton.tests;

import com.epam.hilton.framework.service.IConstant;
import com.epam.hilton.framework.service.ITestData;
import com.epam.hilton.helpers.HomeHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebDriverSeleniumTest {
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void login() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

  @Test(description =
          "1. открыть страницу https://www.hilton.com/en/\n"
              + "2. в поле Where to? ввести “Washington, District of Columbia, US”, 1комната для 2 взрослых (1 Room, 2 Guests), на 1 неделю с завтрашнего дня. нажать 'Find a Hotel'.\n"
              + "3. на открывшейся странице найти любой доступный отель, вывести в лог его название и выбрать его (нажать 'View Rates')\n"
              + "4. на открывшейся странице найти самый дорогой вариант (при наличии нескольких таковых - выбрать любой) и выбрать его (нажать 'select')\n"
              + "5. заполнить появившуюся форму, нажать 'Book From ...$'.\n"
              + "6. подтвердить выбор, нажать ‘Book’\n"
              + "7. вывести в лог итоговую сумму к уплате ('Total for stay')")
  public void hiltonTest() {

        String result = new HomeHelper(driver)
                .openPage()
                .fillSearchForm(ITestData.inputData)
                .chooseOneRoom(ITestData.guestsNumber)
                .choosePeriodFromTomorrow(ITestData.periodInDay)
                .clickFindHotelButton()
                .chooseRandomViewRatesHotel()
                .chooseMostExpensiveVariant()
                .clickBookButton()
                .fillPaymentForm()
                .getTotalForStay();
    Assert.assertTrue(Double.parseDouble(result.replaceAll(IConstant.regexDoubleNumber, "")) > 0, " Result isn't correct");
    }
}
