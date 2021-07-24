package com.epam.hilton.helpers;

import com.epam.hilton.pages.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public abstract class AbstractHelper {
    protected WebDriver driver;

    protected static final Logger log = Logger.getLogger(AbstractHelper.class);

    private AbstractPage page;

    public AbstractHelper(WebDriver driver) {
        this.driver = driver;
    }

    protected abstract HomeHelper openPage();

}
