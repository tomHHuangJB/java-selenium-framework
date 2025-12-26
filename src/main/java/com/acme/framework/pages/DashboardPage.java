package com.acme.framework.pages;

import com.acme.framework.core.DriverManager;
import com.acme.framework.core.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    private final WebDriver driver;
    private final Waits waits;

    private final By dashboardRoot = By.cssSelector("[data-testid='dashboard-root']");

    public DashboardPage() {
        this.driver = DriverManager.getDriver();
        this.waits = new Waits(driver);
    }

    /**
     * Indicates whether the dashboard is visible.
     * This method is intentionally simple and deterministic
     */
    public boolean inVisible() {
        return waits.untilVisible(dashboardRoot).isDisplayed();
    }

}
