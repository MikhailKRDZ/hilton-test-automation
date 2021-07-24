package com.epam.hilton.tests;


import com.epam.hilton.helpers.HomeHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverSeleniumTest {
    private WebDriver driver;
    HomeHelper homeHelper;

    private  String  inputData = "Washington, District of Columbia, US";

    @BeforeMethod(alwaysRun = true)
    public void login() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }
//    Task
//1. открыть страницу https://www.hilton.com/en/
//            2. в поле Where to? ввести “Washington, District of Columbia, US”, 1 комната для 2 взрослых (1 Room, 2 Guests), на 1 неделю с завтрашнего дня. нажать 'Find a Hotel'.
//            3. на открывшейся странице найти любой доступный отель, вывести в лог его название и выбрать его (нажать 'View Rates')
//4. на открывшейся странице найти самый дорогой вариант (при наличии нескольких таковых - выбрать любой) и выбрать его (нажать 'select')
//            5. заполнить появившуюся форму, нажать 'Book From ...$'.
//            6. подтвердить выбор, нажать ‘Book’
//            7. вывести в лог итоговую сумму к уплате ('Total for stay')



    @Test(description = "Just first test, JIRA binding can be here")
    public void loginGmailTest() {
        homeHelper = new HomeHelper(driver)
                .openPage()
        .fillSearchForm(inputData);
        int a =1;
        Assert.assertTrue( 2+2==4," testcondition");
    }
}
