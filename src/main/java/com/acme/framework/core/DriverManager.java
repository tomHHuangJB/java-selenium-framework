package com.acme.framework.core;


import org.openqa.selenium.WebDriver;

/**
 * Thread-safe WebDriver holder.
 *
 * Responsibilities:
 *  - Store one WebDriver per test thread
 *  - Prevent shared mutable state
 *
 * Non-responsibilities:
 *  - Creating drivers
 *  - Quitting drivers
 */
public final class DriverManager {
    private static final  ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();
    private DriverManager() {}


    public static WebDriver getDriver() {
        WebDriver driver =DRIVER.get();
        if (driver == null) {
            throw new IllegalStateException(
                    "WebDriver is not initialized. " +
                            "Did you forget to set it in the test lifecycle?"
            );
        }
        return driver;
    }

    /* =========================
       Canonical API (preferred)
       ========================= */
    public static void setDriver(WebDriver driver) {
        DRIVER.set(driver);
    }

    public static void removeDriver() {
        DRIVER.remove();
    }
}
