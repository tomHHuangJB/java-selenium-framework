package com.acme.framework.pages;

import com.acme.framework.pages.components.Header;
import com.acme.framework.config.Config;
import com.acme.framework.core.BasePage;
import com.acme.framework.core.DriverManager;


public class HomePage extends BasePage {

//    private static final By HEADER = By.tagName("h1");
    private final Header header = new Header();


    public HomePage open() {
        open(Config.baseUrl());
        return this;
    }

    public boolean isLoaded() {
        return DriverManager.getDriver()
                .getTitle()
                .contains("Local Automation Lab");
    }

    public Header header() {
        return header;
    }

}

