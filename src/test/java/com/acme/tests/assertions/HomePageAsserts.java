package com.acme.tests.assertions;

import com.acme.framework.pages.HomePage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HomePageAsserts {

    public void assertHomePageLoaded(HomePage page) {
        assertThat(page.isLoaded())
                .as("Home page should be loaded")
                .isTrue();
    }
}
