package com.acme.framework.components;

import com.acme.framework.waits.Waiter;
import org.openqa.selenium.By;

public class Header {

    private static final By MEGA_MENU_BUTTON =
            By.xpath("//button[normalize-space()='Mega Menu']");

    private static final By Forms_link =
            By.cssSelector("a[href='/forms']");

    public void openMenu() {
        Waiter.clickable(MEGA_MENU_BUTTON).click();
    }

    public void navigateToForms() {
        openMenu();
        Waiter.clickable(Forms_link).click();
    }
}
