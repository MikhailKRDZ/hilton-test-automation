package com.epam.hilton.helpers.elementshelper;

import com.epam.hilton.helpers.HomeHelper;
import com.epam.hilton.pages.elements.CalendarElement;
import org.openqa.selenium.WebDriver;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class CalendarHelper extends HomeHelper {
    private CalendarElement calendarElement = new CalendarElement(this.driver);

    public CalendarHelper(WebDriver driver) {
        super(driver);
    }

    public CalendarHelper choosePeriodFromTomorrow(int i) {
        return null;
    }

    public CalendarHelper chooseEndPeriodFromTomorrow(int period) {
        if (period > 28 || period < 1) {
            throw new IllegalArgumentException("period valid from 1 till 28, please enter correct values");
        }
        long longTime = Long.parseLong(calendarElement.getTodayId().split("-")[1]) + 86400000L * (period + 1);
        LocalDate localDate = Instant.ofEpochMilli(longTime).atZone(ZoneId.systemDefault()).toLocalDate();
        calendarElement.clickDate(longTime);
        log.info("Choose 'End Period' - " + localDate.toString());
        return this;
    }

    public  HomeHelper clickCloseCalendarButton(){
        calendarElement.clickCloseCalendarButton();
        log.info("Click 'Close Calendar Button'");
        return new HomeHelper(driver);
    }

    public CalendarHelper clickTomorrow() {
        long longTime = Long.parseLong(calendarElement.getTodayId().split("-")[1]);
        longTime = longTime + 86400000L;
        calendarElement.clickDate(longTime);
        LocalDate localDate = Instant.ofEpochMilli(longTime).atZone(ZoneId.systemDefault()).toLocalDate();
        log.info("Choose Tomorrow '' - " + localDate.toString());
        return this;
    }

}
