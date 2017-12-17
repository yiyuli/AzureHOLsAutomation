package com.cs527project.holstest.htmlelements.azure_storage;

import com.cs527project.holstest.htmlelements.annotations.Name;
import com.cs527project.holstest.htmlelements.element.HtmlElement;
import com.cs527project.holstest.htmlelements.exceptions.HtmlElementsException;
import com.cs527project.holstest.htmlelements.loader.HtmlElementLoader;
import com.cs527project.holstest.htmlelements.page.Page;
import com.cs527project.holstest.htmlelements.resource_group_page.ResourceGroupPage;
import com.cs527project.holstest.htmlelements.utils.Driver.BrowserDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ResultPage extends Page {
    @Name("NOTIFICATION")
    @FindBy(xpath = "//a[@class=\"fxs-trim-svg fxs-topbar-button\"]")
    private HtmlElement notification;
    @Name("MESSAGE")
    @FindBy(xpath = "//a[contains(text(), 'Deployment succeeded')]")
    private HtmlElement message;
    @Name("RESOURCE_GROUP_ITEM")
    @FindBy(xpath = "/html/body/div[1]/div[3]/div[1]/nav/div[2]/ul/li[3]/a/div[2]")
    private HtmlElement resourceGroupItem;

    private final String pageError = "Result page is not displayed";
    private final String expectedTitle = "Dashboard - Microsoft Azure";

    public ResultPage(WebDriver driver) {
        super(driver);
        HtmlElementLoader.populatePageObject(this, driver);

        if (!titleContains(expectedTitle))
            throw new HtmlElementsException(pageError);
    }

    public String getResult() {
        notification.click();
        ((BrowserDriver) getDriver()).waitUntilVisible(message);
        return message.getText();
    }

    public ResourceGroupPage goToResourceGroupPage () {
        resourceGroupItem.click();
        ResourceGroupPage resourceGroupPage = new ResourceGroupPage(getDriver());
        return resourceGroupPage;
    }
}
