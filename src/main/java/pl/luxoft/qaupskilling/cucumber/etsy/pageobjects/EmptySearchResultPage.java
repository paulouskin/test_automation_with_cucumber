package pl.luxoft.qaupskilling.cucumber.etsy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmptySearchResultPage extends BasePage{
    private static final String INVALID_SEARCH_HEADER = "h1.wt-text-title-01";

    public EmptySearchResultPage(WebDriver driver) {
        super(driver);
    }

    public boolean isInvalidSearchResult() {
        return findElement(By.cssSelector(INVALID_SEARCH_HEADER)).isDisplayed();
    }
}
