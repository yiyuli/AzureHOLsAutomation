package com.cs527project.holstest.htmlelements.azure_web_apps;

import com.cs527project.holstest.htmlelements.base_test.BaseTestClass;
import com.cs527project.holstest.htmlelements.login.Login;
import com.cs527project.holstest.htmlelements.login.PortalPage;
import com.cs527project.holstest.htmlelements.resource_group_page.ResourceGroupPage;
import com.cs527project.holstest.htmlelements.search_page.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestAzureWebApps extends BaseTestClass {
    private String expectedResource = "WebAppsLabResourceGroup";

    @Test
    public void AzureWebApps() {
        PortalPage portalPage = Login.login(driver);
        SearchPage searchPage = portalPage.goToSearchPage();
        WebAppSqlPage webAppSqlPage = searchPage.goToWebAppSqlPage();
        webAppSqlPage.fillInfo();
        ResultPage resultPage = webAppSqlPage.goToResultPage();
        Assert.assertEquals(resultPage.getResult(), expectedResource);
        ResourceGroupPage resourceGroupPage = resultPage.goToResourceGroupPage();
        resourceGroupPage.deleteAzureWebAppResourceGroup();
    }
}
