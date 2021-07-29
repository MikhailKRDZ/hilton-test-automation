package com.epam.hilton.helpers;

import com.epam.hilton.pages.AvailableRoomsPage;
import org.openqa.selenium.WebDriver;

public class AvailableRoomsHelper  extends AbstractHelper {
    AvailableRoomsPage availableRoomsPage = new AvailableRoomsPage(this.driver);

    public AvailableRoomsHelper(WebDriver driver) {
        super(driver);
    }

    public UpdateRatesHelper chooseMostExpensiveVariant() {
        double maxPrice = availableRoomsPage.getRoomsMaxPrice();
        availableRoomsPage.chooseMostExpensiveVariant();
        log.info("choose 'Most expensive room' price - " + maxPrice);
        return new UpdateRatesHelper(this.driver);
    }

    @Override
    protected AvailableRoomsHelper  openPage() {
        return new AvailableRoomsHelper(driver);
    }
}
