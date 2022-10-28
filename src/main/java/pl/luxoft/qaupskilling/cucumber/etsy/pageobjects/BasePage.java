package pl.luxoft.qaupskilling.cucumber.etsy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    private static final long DEFAULT_WAIT_TIME = 5;
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_TIME));
    }

    protected WebElement findElement(By locator){
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }
}
