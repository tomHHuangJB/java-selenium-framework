package com.acme.framework.pages;

import com.acme.framework.core.BasePage;
import com.acme.framework.drivers.DriverManager;
import org.openqa.selenium.By;

public class FormsPage extends BasePage {


    public boolean isLoaded() {
        return DriverManager.get()
                .getCurrentUrl()
                .endsWith("/forms");
    }


    }




