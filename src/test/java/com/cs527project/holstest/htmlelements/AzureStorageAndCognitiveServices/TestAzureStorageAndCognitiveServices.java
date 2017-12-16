package com.cs527project.holstest.htmlelements.AzureStorageAndCognitiveServices;

import com.cs527project.holstest.htmlelements.base_test.BaseTestClass;
import com.cs527project.holstest.htmlelements.login.Login;
import com.cs527project.holstest.htmlelements.login.PortalPage;
import com.cs527project.holstest.htmlelements.resource_group_page.ResourceGroupPage;
import com.cs527project.holstest.htmlelements.search_page.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAzureStorageAndCognitiveServices extends BaseTestClass{
    private String expectedResource = "Deployment succeeded";


    @Test
    public void TestDockerContainersInTheAzureContainerService() {
        PortalPage portalPage = Login.login(driver);
        SearchPage searchPage = portalPage.goToSearchPage();
        CreateAccountPage createAccountPage = searchPage.goToCreateAccountPage();
        CreateAccountDetailPage createAccountDetailPage = createAccountPage.goToCreateAccountDetailPage();
        createAccountDetailPage.fillInfo();
        ResultPage resultPage = createAccountDetailPage.goToResultPage();
        Assert.assertEquals(resultPage.getResult(), expectedResource);
        ResourceGroupPage resourceGroupPage = resultPage.goToResourceGroupPage();
        resourceGroupPage.deleteAzureStorageResourceGroup();
    }
}
