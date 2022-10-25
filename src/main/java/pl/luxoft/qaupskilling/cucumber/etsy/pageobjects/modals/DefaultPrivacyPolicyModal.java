package pl.luxoft.qaupskilling.cucumber.etsy.pageobjects.modals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DefaultPrivacyPolicyModal {

    private static final String ACCEPT_BUTTON = "//button[@data-gdpr-single-choice-accept='true']";
    private static final String UPDATE_SETTINGS_BUTTON = "[data-gdpr-open-full-settings]";
    private static final String INITIAL_POLICY_INFO = "//div[@class='nova-widget-content-redux']/p";
    private static final String COOKIE_POLICY_LINK = "Cookie Policy";
    WebDriver driver;
    WebDriverWait wait;
    public DefaultPrivacyPolicyModal(WebDriver driver) {
        this.driver =  driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void acceptDefaultSettings() {
        getAcceptButton().click();
    }

    private WebElement getAcceptButton() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(ACCEPT_BUTTON))
        );
    }

    public boolean isNotVisible() {
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(By.xpath(ACCEPT_BUTTON))
        );
    }

    public void goToSettings() {
        getUpdateSettingsButton().click();
    }

    private WebElement getUpdateSettingsButton() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(UPDATE_SETTINGS_BUTTON))
        );
    }

    public boolean isInitialPolicyInformationVisible() {
        return getInitialPolicyInformation().isDisplayed();
    }

    private WebElement getInitialPolicyInformation() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(INITIAL_POLICY_INFO))
        );
    }

    public boolean isCookieHandlingPolicyDetailsAvailable() {
        return getCookieHandlingPolicyDetailsLink().isDisplayed();
    }

    private WebElement getCookieHandlingPolicyDetailsLink() {
       return wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText(COOKIE_POLICY_LINK))
        );
    }

}
