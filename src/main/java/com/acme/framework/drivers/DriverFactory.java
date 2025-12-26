package com.acme.framework.drivers;

import com.acme.framework.config.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    private DriverFactory() {}

    public static WebDriver create() {
        String broswer = Config.browser().toLowerCase();
        if (!broswer.equals("chrome")) {
            throw new IllegalArgumentException("Day1 supports chrome only. Got: " + broswer);
        }
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        if (Config.headless()) {
            options.addArguments("--headless=new");
        }
        options.addArguments("--window-size=1400,980");

        return new ChromeDriver(options);

    }
}
