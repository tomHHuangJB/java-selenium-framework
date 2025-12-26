package com.acme.framework.pages.components;

import com.acme.framework.core.BasePage;
import org.openqa.selenium.By;

public class Header extends BasePage {

    private static final By FORMS_LINK =
            By.cssSelector("[data-testid='nav-forms']");

    public void navigateToForms() {
        waits.untilClickable(FORMS_LINK).click();
    }
}
