package pl.luxoft.qaupskilling.cucumber.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.luxoft.qaupskilling.cucumber.etsy.pageobjects.EmptySearchResultPage;
import pl.luxoft.qaupskilling.cucumber.etsy.pageobjects.EtsyLandingPage;
import pl.luxoft.qaupskilling.cucumber.etsy.pageobjects.SearchResultPage;

public class EtsyPrivacyPolicySteps {

    protected Logger logger = LoggerFactory.getLogger(EtsyPrivacyPolicySteps.class);

    EtsyLandingPage etsyPage;
    WebDriver driver;

    String searchQuery;


    //********************Hooks***********

    @Before("@ui")
    public void scenarioSetUp() {
        logger.info("Setting up Chrome driver");
        WebDriverManager.chromedriver().setup();
    }


    @After("@ui")
    public void scenarioCleanUp() {
        logger.info("Closing web driver session");
        driver.quit();
    }

    //**********************Givens***************************
    @Given("{string} is on the Etsy landing page")
    public void is_on_the_etsy_landing_page(String user) {
        setupApplication(user);
        driver = new ChromeDriver();
        etsyPage = new EtsyLandingPage(driver);
        etsyPage.goTo();
    }

    private void setupApplication(String user) {
        System.out.println("Setting up system depending on user " + user);
    }

    //*************Whens******************
    @When("(s)he accept default privacy policy")
    public void she_accept_default_privacy_policy() {
        etsyPage.acceptDefaultPrivacyPolicy();
    }

    @When("(s)he goes to the privacy policy settings")
    public void she_goes_to_the_privacy_policy_settings() {
        etsyPage.updatePrivacyPolicy();
    }

    @When("she enables site customization option in privacy policy settings")
    public void sheEnablesSiteCustomizationOptionInPrivacyPolicySettings() {
        etsyPage.enableSiteCustomisation();
    }

    @When("she enables personal advertising option in privacy policy settings")
    public void sheEnablesPersonalAdvertisingOptionInPrivacyPolicySettings() {
        etsyPage.enablePersonalAdvertising();
    }

    @When("she accepts privacy policy updates")
    public void sheAcceptsPrivacyPolicyUpdates() {
        etsyPage.acceptPolicyUpdate();
    }

    //***********************Thens************************
    @Then("she can proceed with the shopping")
    public void she_can_proceed_with_the_shopping() {
        Assertions.assertTrue(etsyPage.isPossibleToProceedWithShopping());
    }

    @Then("different privacy policy update options are available")
    public void differentPrivacyPolicyUpdateOptionsAreAvailable() {
        Assertions.assertTrue(etsyPage.isPrivacyPolicyUpdateOptionsAvailable());
    }


    @Then("initial privacy policy information is visible")
    public void initialPrivacyPolicyInformationIsVisible() {
        Assertions.assertTrue(etsyPage.isInitialPolicyInformationVisible());
    }

    @Then("cookie handling policy details is available")
    public void cookieHandlingPolicyDetailsIsAvailable() {
        Assertions.assertTrue(etsyPage.isCookieHandlingPolicyDetailsAvailable());
    }

    @Then("site customization option is available")
    public void siteCustomizationOptionIsAvailable() {
        Assertions.assertTrue(etsyPage.isPrivacyPolicyUpdateOptionsAvailable());
    }

    @Then("personal advertising option is available")
    public void personalAdvertisingOptionIsAvailable() {
        Assertions.assertTrue(etsyPage.isPrivacyPolicyUpdateOptionsAvailable());
    }

    @When("(s)he search for {string}")
    public void heSearchFor(String query) {
        searchQuery = query;
        etsyPage.searchFor(query);
    }

    @Then("the {string} result page have been displayed")
    public void theResultPageHaveBeenDisplayed(String result) {
        boolean isOnTheRightResultPage = switch (result){
            case "success" -> new SearchResultPage(driver).isSearchSuccessfulFor(searchQuery);
            case "error" -> new EmptySearchResultPage(driver).isInvalidSearchResult();
            default -> throw new InvalidArgumentException("Wrong argument for the step");
        };
        Assertions.assertTrue(isOnTheRightResultPage);
    }
}
