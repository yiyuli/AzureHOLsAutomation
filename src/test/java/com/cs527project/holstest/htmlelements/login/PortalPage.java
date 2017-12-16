package com.cs527project.holstest.htmlelements.login;

import com.cs527project.holstest.htmlelements.annotations.Name;
import com.cs527project.holstest.htmlelements.element.HtmlElement;
import com.cs527project.holstest.htmlelements.exceptions.HtmlElementsException;
import com.cs527project.holstest.htmlelements.getting_started_with_azure.CostManagementPage;
import com.cs527project.holstest.htmlelements.loader.HtmlElementLoader;
import com.cs527project.holstest.htmlelements.page.Page;
import com.cs527project.holstest.htmlelements.search_page.SearchPage;
import com.cs527project.holstest.htmlelements.resource_group_page.ResourceGroupPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PortalPage extends Page {
    private final String portalPageError = "Portal page is not displayed";
    private final String expectedTitle = "Dashboard - Microsoft Azure";
    @Name("COST_LINK")
    @FindBy(xpath = "//html/body/div[1]/div[3]/div[1]/nav/div[2]/ul/li[16]/a")
    private HtmlElement costLink;
    @Name("NEW_LINK")
    @FindBy(xpath = "//*[@id=\"web-container\"]/div[3]/div[1]/nav/div[1]/button[2]/div/div[2]")
    private HtmlElement newLink;
    @Name("RESOURCE_GROUP_ITEM")
    @FindBy(xpath = "/html/body/div[1]/div[3]/div[1]/nav/div[2]/ul/li[3]/a/div[2]")
    private HtmlElement resourceGroupItem;

    public PortalPage(WebDriver driver) {
        super(driver);
        HtmlElementLoader.populatePageObject(this, driver);

        if (!titleContains(expectedTitle))
            throw new HtmlElementsException(portalPageError);
    }

    public CostManagementPage goToCostManagementPage() {
        costLink.click();
        CostManagementPage costManagementPage = new CostManagementPage(getDriver());
        return costManagementPage;
    }

    public SearchPage goToSearchPage() {
        newLink.click();
        SearchPage searchPage = new SearchPage(getDriver());
        return searchPage;
    }

    public ResourceGroupPage goToResourceGroupPage() {
        resourceGroupItem.click();
        ResourceGroupPage resourceGroupPage = new ResourceGroupPage(getDriver());
        return resourceGroupPage;
    }


}
