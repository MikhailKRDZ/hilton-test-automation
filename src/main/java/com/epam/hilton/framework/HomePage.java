//package com.epam.hilton.framework;
//
//import org.openqa.selenium.WebDriver;
//
//import java.util.concurrent.TimeUnit;
//
//public class HomePage extends AbstractPage{
//    private static final String HOMEPAGE_URL = "https://www.hilton.com/en/";
//
//
//
//    public HomePage(WebDriver driver) {
//        super(driver);
//    }
//
//
//
//    @Override
//    public HomePage openPage() {
//        driver.get(HOMEPAGE_URL);
//        driver.manage().timeouts().pageLoadTimeout(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
//        driver.manage().timeouts().setScriptTimeout(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
//        return this;
//    }
//
//}
