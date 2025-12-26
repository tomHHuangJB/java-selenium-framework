package com.acme.framework.pages;

import com.acme.framework.core.BasePage;
import com.acme.framework.core.DriverManager;


public class FormsPage extends BasePage {


    public boolean isLoaded() {
        return DriverManager.getDriver()
                .getCurrentUrl()
                .endsWith("/forms");
    }


    }




