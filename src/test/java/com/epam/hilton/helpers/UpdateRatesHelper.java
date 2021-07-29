package com.epam.hilton.helpers;

import com.epam.hilton.pages.UpdateRatesPage;
import org.openqa.selenium.WebDriver;

public class UpdateRatesHelper extends AbstractHelper{
    private UpdateRatesPage updateRatesPage = new UpdateRatesPage(this.driver);

    public UpdateRatesHelper(WebDriver driver) {
      super(driver);
    }

  @Override
  protected AbstractHelper openPage() {
    return this;
  }

    public PaymentHelper clickBookButton() {
        updateRatesPage.clickBookButton();
        log.info("Click 'Book' button");
        return new PaymentHelper(this.driver);
    }
}
