package com.acme.tests.ui;

import com.acme.framework.drivers.DriverManager;
import com.acme.framework.pages.FormsPage;
import com.acme.framework.pages.HomePage;
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
        Assertions.assertThat(home.isLoaded()).isTrue();
    }

    @Test
    public void user_can_navigate_to_forms_page() {
        HomePage home = new HomePage().open();
        Assertions.assertThat(home.isLoaded()).isTrue();

        home.header().navigateToForms();

        FormsPage forms = new FormsPage();
        Assertions.assertThat(forms.isLoaded()).isTrue();
    }

}
