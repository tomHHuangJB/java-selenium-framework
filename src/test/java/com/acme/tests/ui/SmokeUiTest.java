package com.acme.tests.ui;

import com.acme.framework.pages.FormsPage;
import com.acme.framework.pages.HomePage;
import com.acme.tests.assertions.FormsAsserts;
import com.acme.tests.assertions.HomePageAsserts;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class SmokeUiTest extends BaseUiTest {

    @Test
    public void homePage_shouldLoad() {

        // without Page Object, this is the old style
//        DriverManager.get().get(baseUrl());
//
//        String title = DriverManager.get().getTitle();
//        Assertions.assertThat(title).isNotBlank();

        // with Page Object
        HomePage home = new HomePage().open();
        HomePageAsserts homePageAsserts = new HomePageAsserts();
        homePageAsserts.assertHomePageLoaded(home);
    }

    @Test
    public void user_can_navigate_to_forms_page() {
        HomePage home = new HomePage().open();
        HomePageAsserts homePageAsserts = new HomePageAsserts();
        FormsAsserts formsAsserts = new FormsAsserts();
        homePageAsserts.assertHomePageLoaded(home);

        home.header().navigateToForms();

        FormsPage forms = new FormsPage();
        formsAsserts.assertFormsPageLoaded(forms);
    }

}
