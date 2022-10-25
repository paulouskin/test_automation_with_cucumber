package pl.luxoft.qaupskilling.cucumber.etsy.pageobjects.modals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UpdatePrivacyPolicyModal {
    private static final String PERSONAL_ADVERTISING_TOGGLE = "[for=third_party_consent]";
    private static final String SITE_CUSTOMIZATION_TOGGLE = "[for=personalization_consent]";
    private static final String ACCEPT_CHANGES_BUTTON = "//*[@id='gdpr-privacy-settings']/div/div[3]/div[2]/div/div[3]/button";
    private final WebDriver driver;
    private WebDriverWait wait;

    public UpdatePrivacyPolicyModal(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isUpdateOptionsAvailable() {
        return getSiteCustomisationToggle().isDisplayed()
                && getPersonalAdvertisingToggle().isDisplayed();
    }

    private WebElement getPersonalAdvertisingToggle() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PERSONAL_ADVERTISING_TOGGLE))
        );
    }

    private WebElement getSiteCustomisationToggle() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(SITE_CUSTOMIZATION_TOGGLE))
        );
    }

    public void enableSiteCustomisation() {
        getSiteCustomisationToggle().click();
    }

    public void enablePersonalAdvertising() {
        getPersonalAdvertisingToggle().click();
    }

    public void acceptPolicyChanges() {
        getAcceptChangesButton().click();
    }

    private WebElement getAcceptChangesButton() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(ACCEPT_CHANGES_BUTTON))
        );
    }
}
