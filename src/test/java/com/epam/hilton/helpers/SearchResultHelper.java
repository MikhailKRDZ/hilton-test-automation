package com.epam.hilton.helpers;

import com.epam.hilton.pages.SearchResultPage;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.ThreadLocalRandom;

public class SearchResultHelper extends AbstractHelper{
    private SearchResultPage searchResultPage = new SearchResultPage(this.driver);

    public SearchResultHelper(WebDriver driver) {
        super(driver);
    }

    @Override
    protected SearchResultHelper openPage() {
        log.info("Open 'Search result page'");
        return new SearchResultHelper(driver);
    }

    public AvailableRoomsHelper chooseRandomViewRatesHotel() {
        int size =  searchResultPage.getSizeRatesButtons();
        int randomNum = ThreadLocalRandom.current().nextInt( size + 1);
        String hotelsName = searchResultPage.getHotelsName(randomNum);
        searchResultPage.getRandomViewRatesHotel(randomNum);
        log.info("choose 'View Rates button' name - " + hotelsName);
        return new AvailableRoomsHelper(this.driver);
    }

}
