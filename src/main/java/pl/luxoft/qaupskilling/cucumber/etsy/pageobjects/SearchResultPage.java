package pl.luxoft.qaupskilling.cucumber.etsy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultPage {

    private WebDriverWait wait;
    private WebDriver driver;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isSearchSuccessfulFor(String searchQuery) {
        return driver.getTitle().toLowerCase().contains(searchQuery);
    }
}
