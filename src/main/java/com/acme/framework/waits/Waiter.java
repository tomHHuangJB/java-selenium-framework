package com.acme.framework.waits;

import com.acme.framework.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiter {
    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(10);

    private static WebDriverWait createWait() {
        return new WebDriverWait(DriverManager.get(), DEFAULT_TIMEOUT);
    }

    public static WebElement visible(By locator) {
        return createWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement clickable(By locator) {
        return createWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static boolean isvisible(By locator) {
        return createWait().until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
}
