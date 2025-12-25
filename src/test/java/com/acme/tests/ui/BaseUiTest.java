package com.acme.tests.ui;

import com.acme.framework.config.Config;
import com.acme.framework.drivers.DriverManager;
import com.acme.framework.drivers.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public abstract class BaseUiTest {


    @BeforeMethod(alwaysRun = true)
    public void setUP() {
        DriverManager.set(DriverFactory.create());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        try {
            // capture artifacts on failure only
            if (!result.isSuccess()) {
                takeScreenshot(result.getName());
            }
        } catch ( Exception ignored) {
            // keep teardown resilient
        } finally {
            DriverManager.quit();
        }
    }

    protected String baseUrl() {
        return Config.baseUrl();
    }

    private void takeScreenshot(String testName) throws Exception {
        var driver = DriverManager.get();
        if (driver == null) return;

        byte[] png  = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Path dir = Path.of("artifacts", "screenshots");
        Files.createDirectories(dir);
        Files.write(dir.resolve(testName + ".png"), png);

    }

}
