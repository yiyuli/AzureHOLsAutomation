package com.cs527project.holstest.htmlelements.getting_started_with_azure;

import com.cs527project.holstest.htmlelements.annotations.Name;
import com.cs527project.holstest.htmlelements.element.HtmlElement;
import com.cs527project.holstest.htmlelements.exceptions.HtmlElementsException;
import com.cs527project.holstest.htmlelements.loader.HtmlElementLoader;
import com.cs527project.holstest.htmlelements.page.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public class CostManagementPage extends Page {
    private final String pageError = "Cost Management page is not displayed";
    private final String expectedTitle = "Billing overview - Microsoft Azure";
    @Name("SUBSCRIPTIONS_LINK")
    @FindBy(xpath = "//*[@id=\"web-container\"]/div[3]/main/div[2]/div[2]/section/div[1]/div[1]/div[4]/div[2]/div[2]/div/div[2]/div/div[2]/div[2]/div/div[2]/div/div[1]/section[2]/div[2]/ul/li[1]/div[2]")
    private HtmlElement subScriptionsLink;


    public CostManagementPage(WebDriver driver) {
        super(driver);
        HtmlElementLoader.populatePageObject(this, driver);

        if (!titleContains(expectedTitle))
            throw new HtmlElementsException(pageError);
    }

    public SubScriptionsPage goToSubScriptionsPage() {
        subScriptionsLink.click();
        SubScriptionsPage subScriptionsPage = new SubScriptionsPage(getDriver());
        return subScriptionsPage;
    }

}
