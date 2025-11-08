package com.symplifica.auto.pages;

import com.symplifica.auto.stepdefinitions.ApplicationSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.symplifica.auto.utils.DriverManager;
import java.util.List;

public class TodoPage {

    private WebDriver driver;

    @FindBy(css = "textarea[name='description']")
    private WebElement DescInput;

    @FindBy(css = "input[name='title']")
    private WebElement titleInput;

    @FindBy(css = "input[type='checkbox']")
    private WebElement completedCheckbox;

    @FindBy(css = "button[type='submit']")
    private WebElement addTaskBtn;

    @FindBy(css = "ul.task-list")
    private List<WebElement> taskList;

    @FindBy(css = "ul.task-list li")
    private List<WebElement> taskElements;

    @FindBy(tagName = "button")
    private WebElement button;

    public TodoPage() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void navigateToApp(String url) {
        driver.get(url);
    }

    public void fillInput(String fieldName, String content) {
        ApplicationSteps appSteps = new ApplicationSteps();
        switch (fieldName.toUpperCase()) {
            case "TITLE":
                appSteps.fillInputValue(titleInput, content);
                break;
            case "DESCRIPTION":
                appSteps.fillInputValue(DescInput, content);
                break;
        }
    }

}