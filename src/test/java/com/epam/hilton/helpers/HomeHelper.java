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

    public HomeHelper chooseRoom(Rooms rooms) {
        clickFormRoomButton()
        .chooseRoomNumber(rooms.getRoomsNumber())
        .chooseGuestsNumber(rooms.getGuestsNumber())
        .clickCloseButton();
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
        log.info("click 'calendar button'");
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
