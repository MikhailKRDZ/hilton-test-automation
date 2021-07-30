package com.epam.hilton.helpers.elementshelper;

import com.epam.hilton.helpers.HomeHelper;
import com.epam.hilton.pages.elements.RoomFormElement;
import org.openqa.selenium.WebDriver;

public class RoomFormHelper  extends HomeHelper {

    private RoomFormElement roomFormElement = new RoomFormElement(this.driver);

    public RoomFormHelper(WebDriver driver) {
        super(driver);
    }

    public RoomFormHelper chooseOneRoom() {
        int roomsNumberActual = roomFormElement.getRoomsNumberActual();
        log.info("rooms Number Actual - " + roomsNumberActual);
        return this;
    }

    public RoomFormHelper chooseAdultGuestsNumber(int guestsNumber) {
        int guestsNumberActual = roomFormElement.getGuestsNumber();
           while (guestsNumber > guestsNumberActual){
                roomFormElement.clickPlusAdultButton();
                guestsNumberActual = roomFormElement.getGuestsNumber();
            }
            log.info("'Guess number' Actual - " + guestsNumberActual);
            return this;
    }

    public HomeHelper clickCloseButton() {
        roomFormElement.clickCloseButton();
        log.info("Click 'Close button'");
        return this;
    }

}
