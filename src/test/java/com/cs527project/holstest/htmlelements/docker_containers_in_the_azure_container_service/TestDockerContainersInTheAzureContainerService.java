package com.cs527project.holstest.htmlelements.docker_containers_in_the_azure_container_service;

import com.cs527project.holstest.htmlelements.base_test.BaseTestClass;
import com.cs527project.holstest.htmlelements.login.Login;
import com.cs527project.holstest.htmlelements.login.PortalPage;
import com.cs527project.holstest.htmlelements.resource_group_page.ResourceGroupPage;
import com.cs527project.holstest.htmlelements.search_page.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDockerContainersInTheAzureContainerService extends BaseTestClass {
    private String expectedResource = "Deployment succeeded";


    @Test
    public void TestDockerContainersInTheAzureContainerService() {
        PortalPage portalPage = Login.login(driver);
        SearchPage searchPage = portalPage.goToSearchPage();
        BasicConfigPage basicConfigPage = searchPage.goToBasicConfigPage();
        basicConfigPage.fillInfo();
        MasterConfigPage masterConfigPage = basicConfigPage.goToMasterConfigPage();
        masterConfigPage.fillInfo();
        AgentConfigPage agentConfigPage = masterConfigPage.goToAgentConfigPage();
        SummaryPage summaryPage = agentConfigPage.goToSummaryPage();
        ResultPage resultPage = summaryPage.goToResultPage();
        Assert.assertEquals(resultPage.getResult(), expectedResource);
        ResourceGroupPage resourceGroupPage = resultPage.goToResourceGroupPage();
        resourceGroupPage.deleteAzureContainerResourceGroup();
    }


}
