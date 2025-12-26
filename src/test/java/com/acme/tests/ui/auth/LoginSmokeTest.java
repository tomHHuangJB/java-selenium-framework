package com.acme.tests.ui.auth;


import com.acme.framework.flows.AuthFlow;
import com.acme.framework.pages.DashboardPage;
import com.acme.tests.assertions.DashboardAsserts;
import org.testng.annotations.Test;

/**
 * Smoke test verifying that a user can log in successfully.
 *
 * Framework rules enforced:
 *  - TestNG is the test runner
 *  - Assertions live in tests
 *  - No WebDriver lifecycle logic here
 *  - Page Objects expose state, not assertions
 */

public class LoginSmokeTest {

    @Test(groups = "smoke")
    public void user_can_login_with_valid_credentials() {
        AuthFlow authFlow = new AuthFlow();
        DashboardPage dashboardPage = authFlow.login("test.user@example.com", "Password123!");

        // improved asserts
        DashboardAsserts dashboardAsserts = new DashboardAsserts();
        dashboardAsserts.assertDashboardVisible(dashboardPage);
    }
}
