package com.acme.framework.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//The BasePage encapsulates interaction logic so tests never directly touch WebDriver.
public abstract class BasePage {



    protected final WebDriver driver;
    protected final Waits waits;

    protected BasePage() {
        this.driver = DriverManager.getDriver();
        this.waits = new Waits(driver);
    }

    protected void open(String url) {
        DriverManager.getDriver().get(url);
    }

    protected void click(By locator) {
        waits.untilClickable(locator).click();
    }

    protected void type (By locator, String text) {
        var element = waits.untilVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected String text(By locator) {
        return waits.untilVisible(locator).getText();
    }

    protected boolean isVisible (By locator) {
        try {
            waits.untilVisible(locator);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
