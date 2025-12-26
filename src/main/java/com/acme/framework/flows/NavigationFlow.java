package com.acme.framework.flows;

import com.acme.framework.pages.FormsPage;
import com.acme.framework.pages.components.Header;


public class NavigationFlow {

    private final Header header;
    private final FormsPage formsPage;

    public NavigationFlow() {
        this.header = new Header();
        this.formsPage = new FormsPage();
    }

    public FormsPage goToForms() {
        header.navigateToForms();
        return formsPage;
    }
}
