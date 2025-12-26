package com.acme.framework.pages;

import com.acme.framework.core.Waits;
import com.acme.framework.core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthPage {

    private final WebDriver driver;
    private final Waits waits;

    private final By usernameInput = By.cssSelector("[data-testid='username']");
    private final By passwordInput = By.cssSelector("[data-testid='password']");
    private final By loginButton = By.cssSelector("[data-testid='login-button']");

    public AuthPage() {
        this.driver = DriverManager.getDriver();
        this.waits = new Waits(driver);

    }
    /**
     * Loads the authentication page.
     */
    public void open() {
        driver.get("/auth");
        waits.untilVisible(usernameInput);
    }
    /**
     * Performs login action.
     * This method intentionally does NOT return a page object.
     * Navigation ownership stays with the test or flow layer.
     */
    public void login(String username, String password) {
        waits.untilVisible(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }

}
