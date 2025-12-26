package com.acme.framework.pages.components;

import com.acme.framework.core.BasePage;
import org.openqa.selenium.By;

public class Header extends BasePage {

    private static final By MEGA_MENU_BUTTON =
            By.xpath("//button[normalize-space()='Mega Menu']");

    private static final By Forms_link =
            By.cssSelector("a[href='/forms']");

    public void openMenu() {
        waits.untilClickable(MEGA_MENU_BUTTON).click();
    }

    public void navigateToForms() {
        openMenu();
        waits.untilClickable(Forms_link).click();
    }
}
