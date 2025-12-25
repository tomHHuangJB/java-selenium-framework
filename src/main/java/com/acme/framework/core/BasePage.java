package com.acme.framework.core;

import com.acme.framework.drivers.DriverManager;
import com.acme.framework.waits.Waiter;
import org.openqa.selenium.By;

//The BasePage encapsulates interaction logic so tests never directly touch WebDriver.
public abstract class BasePage {

    protected void open(String url) {
        DriverManager.get().get(url);
    }

    protected void click(By locator) {
        Waiter.clickable(locator).click();
    }

    protected void type (By locator, String text) {
        var element = Waiter.visible(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected String text(By locator) {
        return Waiter.visible(locator).getText();
    }

    protected boolean isVisible (By locator) {
        try {
            Waiter.visible(locator);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
