package pl.luxoft.qaupskilling.cucumber.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.luxoft.qaupskilling.cucumber.etsy.pageobjects.EtsyLandingPage;

public class EtsyPrivacyPolicySteps {

    protected Logger logger = LoggerFactory.getLogger(EtsyPrivacyPolicySteps.class);

    EtsyLandingPage etsyPage;
    WebDriver driver;


    //********************Hooks***********

    @Before
    public void scenarioSetUp() {
        logger.info("Setting up Chrome driver");
        WebDriverManager.chromedriver().setup();
    }


    @After
    public void scenarioCleanUp() {
        logger.info("Closing web driver session");
        driver.quit();
    }

    //**********************Givens***************************
    @Given("{string} is on the Etsy landing page")
    public void is_on_the_etsy_landing_page(String string) {

        driver = new ChromeDriver();
        etsyPage = new EtsyLandingPage(driver);
        etsyPage.goTo();
    }

    //*************Whens******************
    @When("she accept default privacy policy")
    public void she_accept_default_privacy_policy() {
        etsyPage.acceptDefaultPrivacyPolicy();
    }

    @When("she goes to the privacy policy settings")
    public void she_goes_to_the_privacy_policy_settings() {
        etsyPage.updatePrivacyPolicy();
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
}
