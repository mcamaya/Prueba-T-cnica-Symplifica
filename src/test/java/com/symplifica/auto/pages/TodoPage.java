package com.symplifica.auto.pages;

import com.symplifica.auto.stepdefinitions.ApplicationSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.symplifica.auto.utils.DriverManager;
import java.util.List;

public class TodoPage {

    private WebDriver driver;
    ApplicationSteps appSteps = new ApplicationSteps();

    @FindBy(css = "textarea[name='description']")
    private WebElement DescInput;

    @FindBy(css = "input[name='title']")
    private WebElement titleInput;

    @FindBy(css = "input[type='checkbox']")
    private WebElement completedCheckbox;

    @FindBy(css = "button[type='submit']")
    private WebElement addTaskBtn;

    @FindBy(css = "ul.task-list")
    private WebElement taskList;

    @FindBy(css = "ul.task-list li")
    private List<WebElement> taskElements;

    @FindBy(tagName = "button")
    private WebElement button;

    By pTag = By.cssSelector("p");
    By buttonItem = By.cssSelector("button");

    public TodoPage() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void navigateToApp(String url) {
        driver.get(url);
    }

    public void clicAddTaskBtn() {
        appSteps.clicSingleButton(button);
    }

    public void clicCompleteCheckbox() {
        appSteps.clicSingleButton(completedCheckbox);
    }

    public void verifyTaskCreated(String value) {
        appSteps.searchElementAndVerifyInfo(taskElements, pTag, value);
    }

    public void clicDeleteButton(String value) {
        appSteps.searchElementAndClicSubElement(taskElements, buttonItem, value);
    }

    public void fillInput(String fieldName, String content) {
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