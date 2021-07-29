package com.epam.hilton.helpers.elementshelper;

import com.epam.hilton.helpers.HomeHelper;
import com.epam.hilton.pages.elements.RoomFormElement;
import org.openqa.selenium.WebDriver;

public class RoomFormHelper  extends HomeHelper {

    private RoomFormElement roomFormElement = new RoomFormElement(this.driver);

    public RoomFormHelper(WebDriver driver) {
        super(driver);
    }

    public RoomFormHelper chooseRoomNumber(int roomsNumber) {
        int roomsNumberActual = roomFormElement.getRoomsNumberActual();
        if (roomsNumberActual == roomsNumber) {
            log.info("rooms Number Actual - " + roomsNumberActual);
            return this;
        } else  return null;
    }

    public RoomFormHelper chooseGuestsNumber(int guestsNumber) {//исправить
        int guestsNumberActual = roomFormElement.getGuestsNumber();
        if (guestsNumber == guestsNumberActual) {
            log.info("'Guess number' Actual - " + guestsNumberActual);
            return this;
        } else if (guestsNumber > guestsNumberActual) {
           while (guestsNumber > guestsNumberActual){
                roomFormElement.clickPlusAdultButton();
                guestsNumberActual = roomFormElement.getGuestsNumber();
            }
            log.info("'Guess number' Actual - " + guestsNumberActual);
            return this;
        }
        return null;
    }

    public HomeHelper clickCloseButton() {
        roomFormElement.clickCloseButton();
        log.info("Click 'Close button'");
        return this;
    }
}
