package com.symplifica.auto.stepdefinitions;

import com.symplifica.auto.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public void clicSingleButton(WebElement element) {
        element.click();
    }

    public void searchElementAndVerifyInfo(List<WebElement> list, By tag, String info) {
        list.stream()
                .flatMap(el -> el.findElements(tag).stream())
                .filter(e -> e.getText().trim().equalsIgnoreCase(info))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(
                        "No se encontró elemento con texto: '" + info + "'"
                ));
    }

    public void searchElementAndClicSubElement(List<WebElement> list, By tag, String info){
        Optional<WebElement> opt = list.stream()
                .filter(e -> e.getText().trim().contains(info))
                .flatMap(el -> el.findElements(tag).stream())
                .findFirst();

        WebElement subEl = opt.orElseThrow(() -> new NoSuchElementException("No se encontró elemento: " + tag));
        subEl.click();
    }
}
