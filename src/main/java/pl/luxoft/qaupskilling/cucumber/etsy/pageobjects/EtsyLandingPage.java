package pl.luxoft.qaupskilling.cucumber.etsy.pageobjects;

import org.openqa.selenium.WebDriver;
import pl.luxoft.qaupskilling.cucumber.etsy.pageobjects.modals.DefaultPrivacyPolicyModal;
import pl.luxoft.qaupskilling.cucumber.etsy.pageobjects.modals.UpdatePrivacyPolicyModal;

public class EtsyLandingPage {

    WebDriver driver;
    DefaultPrivacyPolicyModal privacyPolicyModal;
    UpdatePrivacyPolicyModal updatePolicyModal;

    public EtsyLandingPage(WebDriver driver) {
        this.driver = driver;
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
        return privacyPolicyModal.isVisible();
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
}
