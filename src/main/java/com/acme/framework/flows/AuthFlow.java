package com.acme.framework.flows;

import com.acme.framework.pages.AuthPage;
import com.acme.framework.pages.DashboardPage;


public class AuthFlow {

    private final AuthPage authPage;
    private final DashboardPage dashboardPage;

    public AuthFlow() {
        this.authPage = new AuthPage();
        this.dashboardPage = new DashboardPage();
    }

    public DashboardPage login(String username, String password) {
        authPage.open();
        authPage.login(username, password);
        return dashboardPage;
    }
}
