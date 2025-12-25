package com.acme.framework.pages;

import com.acme.framework.config.Config;
import com.acme.framework.core.BasePage;
import com.acme.framework.drivers.DriverManager;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private static final By HEADER = By.tagName("h1");

    public HomePage open() {
        open(Config.baseUrl());
        return this;
    }

    public boolean isLoaded() {
        return DriverManager.get()
                .getTitle()
                .contains("Local Automation Lab");
    }

}

