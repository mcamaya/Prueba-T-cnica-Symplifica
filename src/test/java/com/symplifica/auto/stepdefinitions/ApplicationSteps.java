package com.symplifica.auto.stepdefinitions;

import com.symplifica.auto.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ApplicationSteps {
    private WebDriver driver;
    private WebDriverWait wait;

    public ApplicationSteps() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void fillInputValue(WebElement inputElement, String content) {
        inputElement.clear();
        inputElement.sendKeys(content);
    }
}
