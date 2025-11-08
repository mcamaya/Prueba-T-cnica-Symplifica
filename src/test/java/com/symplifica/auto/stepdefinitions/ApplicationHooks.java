package com.symplifica.auto.stepdefinitions;

import com.symplifica.auto.utils.ConfigReader;
import com.symplifica.auto.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ApplicationHooks {

    @Before
    public void setUp() {
        String browser = ConfigReader.getBrowser();
        DriverManager.initializeDriver(browser);
    }

    @AfterStep
    public void takeScreenshot(Scenario scenario) {
        byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver())
                .getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}