package com.acme.tests.assertions;

import com.acme.framework.pages.DashboardPage;
import  static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DashboardAsserts {

    public void assertDashboardVisible(DashboardPage page) {
        assertThat(page.inVisible())
                .as("Dashboard should be visible after successful login")
                .isTrue();
    }

}
