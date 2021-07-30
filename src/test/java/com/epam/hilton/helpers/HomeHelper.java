package com.epam.hilton.helpers;

import com.epam.hilton.framework.service.Rooms;
import com.epam.hilton.helpers.elementshelper.CalendarHelper;
import com.epam.hilton.helpers.elementshelper.RoomFormHelper;
import com.epam.hilton.pages.HomePage;
import org.openqa.selenium.WebDriver;

public class HomeHelper extends AbstractHelper {
    private HomePage homePage = new HomePage(this.driver);


    public HomeHelper(WebDriver driver) {
        super(driver);
    }

    public HomeHelper openPage() {
        log.info("Open Home page");
        homePage.openPage();
        return this;
    }

    public HomeHelper fillSearchForm(String inputData) {
        log.info("Fill 'Search Form'  with 'input data' - " + inputData);
        homePage.fillSearchForm(inputData);
        return this;
    }

    public HomeHelper chooseOneRoom(Rooms rooms) {
        if (rooms.getRoomsNumber() == 1 ){
        clickFormRoomButton()
        .chooseOneRoom()
        .chooseAdultGuestsNumber(rooms.getGuestsNumber())
        .clickCloseButton();
    } else {
            throw  new IllegalArgumentException("Wrong rooms number, need 1, actual - " + rooms.getRoomsNumber());
    }
        log.info("choose required room ");
        return this;
    }

    private RoomFormHelper clickFormRoomButton() {
        homePage.clickFormRoomButton();
        log.info("click 'form room button'");
     return new RoomFormHelper(this.driver);
    }

    public SearchResultHelper clickFindHotelButton() {
        homePage.clickFindHotelButton();
        log.info("click 'Find Hotel button'");
        return new SearchResultHelper(this.driver);
    }

    public CalendarHelper clickCalendarButton() {
        homePage.clickCalendarButton();
        log.info("click 'Calendar button'");
        return new CalendarHelper(this.driver);
    }

    public HomeHelper choosePeriodFromTomorrow(int period) {
        clickCalendarButton()
                .clickTomorrow()
                .chooseEndPeriodFromTomorrow(period)
                .clickCloseCalendarButton();
        return this;
    }

}
