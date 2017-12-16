package com.cs527project.holstest.htmlelements.login;

import org.openqa.selenium.WebDriver;


public class Login {

    public static PortalPage login(WebDriver driver) {

        SignInEmailPage signInPage = new SignInEmailPage(driver);
        SignInPassPage signInPassPage = signInPage.open().goToPasswordPage();
        StaySignInPage staySignInPage = signInPassPage.goToStaySignInPage();
        NoSubscriptionsPage noSubscriptionsPage = staySignInPage.goToNoSubscriptionPage();
        PortalPage portalPage = noSubscriptionsPage.goToPortalPage();

        return portalPage;
    }
}
