package com.epam.hilton.helpers;

import com.epam.hilton.framework.service.ITestData;
import com.epam.hilton.pages.PaymentPage;
import org.openqa.selenium.WebDriver;

public class PaymentHelper extends AbstractHelper {
  PaymentPage paymentPage = new PaymentPage(this.driver);

    public PaymentHelper(WebDriver driver) {
        super(driver);
    }

    @Override
    protected PaymentHelper openPage() {
        log.info("Open 'Payment page'");
        return new PaymentHelper(driver);
    }

    public ReservationConfirmationHelper fillPaymentForm() {
        fillCardNumberTextInput();
        fillCardsMonth();
        fillCardsYear();
        inputFirstName();
        inputLastName();
        inputEmailText();
        inputPhone();
        inputAddress();
        clickBookReservationButton();
        log.info("Fill Payment Form' - " );
        return new ReservationConfirmationHelper(this.driver);
    }

    private PaymentHelper fillCardNumberTextInput() {
        paymentPage.fillCardNumberTextInput(ITestData.cardNumber);
        log.info("Fill Card Number Text Input' - " + ITestData.cardNumber);
        return this;
    }

    public PaymentHelper fillCardsMonth(){
        paymentPage.clickSelectMonth();
        paymentPage.chooseMonth(ITestData.validMonth);
        log.info("Fill cards Month" + ITestData.validMonth);
        return this;
    };

    public PaymentHelper fillCardsYear() {
        paymentPage.clickSelectYear();
        paymentPage.chooseYear(ITestData.validYear);
        log.info("Click Select Month");
        return this;
    }

    public PaymentHelper inputFirstName() {
        paymentPage.inputFirstName(ITestData.firstName);
        log.info("inputFirstName" + ITestData.firstName);
        return this;
    }

    public PaymentHelper inputLastName() {
        paymentPage.inputLastName(ITestData.lastName);
        log.info("input Last Name" + ITestData.lastName);
        return this;
    }

    public PaymentHelper inputEmailText() {
        paymentPage.inputEmail(ITestData.email);
        log.info("input Email Text" + ITestData.email);
        return this;
    }

    public PaymentHelper inputPhone() {
        paymentPage.inputPhone(ITestData.phone);
        log.info("input 'Phone'" + ITestData.phone);
        return this;
    }

     public PaymentHelper inputAddress() {
        paymentPage.inputAddress(ITestData.address);
        paymentPage.chooseFirstDropDownAddress();

        log.info("input 'Address'" + ITestData.address);
        return this;
    }

    public ReservationConfirmationHelper clickBookReservationButton() {
        paymentPage.clickBookReservationButton();
        log.info("Click  'Book Reservation Button'");
        return new ReservationConfirmationHelper(this.driver);
    }



}
