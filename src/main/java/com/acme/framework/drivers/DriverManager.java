package com.acme.framework.drivers;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static final ThreadLocal<WebDriver> TL = new ThreadLocal<>();

    private DriverManager(){}

    public static void set(WebDriver driver) {

        TL.set(driver);
    }
    public static WebDriver get() {
        return TL.get();
    }

    public static void quit () {
        WebDriver driver = TL.get();
        if (driver != null) {
            driver.quit();
            TL.remove();
        }
    }

}
