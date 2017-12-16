package com.cs527project.holstest.htmlelements.getting_started_with_azure;

import com.cs527project.holstest.htmlelements.base_test.BaseTestClass;
import com.cs527project.holstest.htmlelements.login.Login;
import com.cs527project.holstest.htmlelements.login.PortalPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestGettingStartedWithAzure extends BaseTestClass {
    private String expectedSubscription = "Microsoft Azure Sponsorship 2";

    @Test
    public void TestGettingStartedWithAzure() {

        PortalPage portalPage = Login.login(driver);
        CostManagementPage costManagementPage = portalPage.goToCostManagementPage();
        SubScriptionsPage subScriptionsPage = costManagementPage.goToSubScriptionsPage();
        Assert.assertEquals(subScriptionsPage.getSubscriptions(), expectedSubscription);

    }
}
