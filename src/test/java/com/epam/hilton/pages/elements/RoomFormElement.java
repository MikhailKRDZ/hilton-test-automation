package com.epam.hilton.pages.elements;

import com.epam.hilton.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RoomFormElement extends HomePage {

    @FindBy(xpath = "//button[@aria-controls='searchFormRoomInfo']/parent::div")
    private WebElement roomsInfo;

    @FindBy(xpath = "//button[contains(@aria-label,'Add adult to room')]")
    private WebElement plusAdultButton;

    @FindBy(xpath = "//button[contains(@aria-label,'Close Rooms')]")
    private WebElement closeButton;

    public RoomFormElement(WebDriver driver) {
        super(driver);
    }

    public int getRoomsNumberActual() {
        return Integer.parseInt(roomsInfo.getText().split(" ")[0]);
    }

    public int getGuestsNumber() {
        return Integer.parseInt(roomsInfo.getText().split(",")[1].split(" ")[1]);
    }

    public void clickPlusAdultButton() {
        plusAdultButton.click();
    }

    public void clickCloseButton() {
        closeButton.click();
    }
}
