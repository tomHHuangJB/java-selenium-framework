package com.acme.tests.assertions;

import com.acme.framework.pages.FormsPage;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class FormsAsserts {

    public void assertFormsPageLoaded(FormsPage page) {
        assertThat(page.isLoaded())
                .as("Forms page should be loaded")
                .isTrue();
    }
}
