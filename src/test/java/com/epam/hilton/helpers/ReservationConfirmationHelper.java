package com.epam.hilton.helpers;

import com.epam.hilton.pages.ReservationConfirmationPage;
import org.openqa.selenium.WebDriver;

public class ReservationConfirmationHelper extends AbstractHelper{
  ReservationConfirmationPage reservationConfirmationPage =
      new ReservationConfirmationPage(this.driver);

    public ReservationConfirmationHelper(WebDriver driver) {
        super(driver);
    }

    public String getTotalForStay() {
      String result = reservationConfirmationPage.getTotalForStay();
        log.info("Get 'Total for stay', price - " + result);
        return result;
    }

    @Override
    protected AbstractHelper openPage() {
        return null;
    }

}
