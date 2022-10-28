package pl.luxoft.qaupskilling.cucumber.etsy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.luxoft.qaupskilling.cucumber.etsy.pageobjects.modals.DefaultPrivacyPolicyModal;
import pl.luxoft.qaupskilling.cucumber.etsy.pageobjects.modals.UpdatePrivacyPolicyModal;

import java.time.Duration;

public class EtsyLandingPage {

    private static final String SEARCH_FIELD = "//input[@name='search_query']";
    WebDriver driver;
    WebDriverWait wait;
    DefaultPrivacyPolicyModal privacyPolicyModal;
    UpdatePrivacyPolicyModal updatePolicyModal;

    public EtsyLandingPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void goTo() {
        driver.get("https://www.etsy.com");
    }

    public void acceptDefaultPrivacyPolicy() {
        privacyPolicyModal = new DefaultPrivacyPolicyModal(driver);
        privacyPolicyModal.acceptDefaultSettings();
        privacyPolicyModal = null;
    }

    public boolean isPossibleToProceedWithShopping() {
        privacyPolicyModal = new DefaultPrivacyPolicyModal(driver);
        return privacyPolicyModal.isNotVisible();
    }

    public void updatePrivacyPolicy() {
        privacyPolicyModal = new DefaultPrivacyPolicyModal(driver);
        privacyPolicyModal.goToSettings();
    }

    public boolean isPrivacyPolicyUpdateOptionsAvailable() {
        updatePolicyModal = new UpdatePrivacyPolicyModal(driver);
        return updatePolicyModal.isUpdateOptionsAvailable();
    }

    public boolean isInitialPolicyInformationVisible() {
        privacyPolicyModal = new DefaultPrivacyPolicyModal(driver);
        return privacyPolicyModal.isInitialPolicyInformationVisible();
    }

    public boolean isCookieHandlingPolicyDetailsAvailable() {
        privacyPolicyModal = new DefaultPrivacyPolicyModal(driver);
        return privacyPolicyModal.isCookieHandlingPolicyDetailsAvailable();
    }

    public void enableSiteCustomisation() {
        updatePolicyModal = new UpdatePrivacyPolicyModal(driver);
        updatePolicyModal.enableSiteCustomisation();
    }

    public void enablePersonalAdvertising() {
        updatePolicyModal = new UpdatePrivacyPolicyModal(driver);
        updatePolicyModal.enablePersonalAdvertising();
    }

    public void acceptPolicyUpdate() {
        updatePolicyModal = new UpdatePrivacyPolicyModal(driver);
        updatePolicyModal.acceptPolicyChanges();
    }

    public void searchFor(String query) {
        WebElement searchField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(SEARCH_FIELD))
        );
        searchField.clear();
        searchField.sendKeys(query + Keys.ENTER);
    }
}
