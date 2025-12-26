package com.acme.framework.core;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Centralized explicit wait utility.
 *
 * Design goals:
 *  - Eliminate Thread.sleep usage
 *  - Prevent implicit wait misuse
 *  - Make synchronization intention-revealing
 *
 * This class should be the ONLY place WebDriverWait is used.
 */
public class Waits {
    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(10);
    private static final Duration DEFAULT_POLLING = Duration.ofMillis(200);

//    private final WebDriver driver;
    private final WebDriverWait wait;

    public Waits(WebDriver driver) {
        this.wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
        this.wait.pollingEvery(DEFAULT_POLLING);
    }
    /**
     * Waits until element is visible and returns it
     */
    public WebElement untilVisible(By locator) {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Waits until element is clickable and returns it.
     */
    public WebElement untilClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * Wait until element is no longer visible.
     */
    public void untilInvisible(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    /**
     * Wait until specific text is present in element.
     *
     */
    public void untilTextPresent(By locator, String text) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    /**
     * Waits until URL contains expected fragment.
     */
    public void untilUrlContains(String urlFragment) {
        wait.until(ExpectedConditions.urlContains(urlFragment));
    }
}
