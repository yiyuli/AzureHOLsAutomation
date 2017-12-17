package com.cs527project.holstest.htmlelements.resource_group_page;

import com.cs527project.holstest.htmlelements.annotations.Name;
import com.cs527project.holstest.htmlelements.element.HtmlElement;
import com.cs527project.holstest.htmlelements.exceptions.HtmlElementsException;
import com.cs527project.holstest.htmlelements.loader.HtmlElementLoader;
import com.cs527project.holstest.htmlelements.page.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.JavascriptExecutor;
import com.cs527project.holstest.htmlelements.utils.Utils;

import java.util.List;

public class ResourceGroupPage extends Page{
    @Name("CONTEXT")
    @FindBy(xpath = "//a[@title=\"Click to open context menu\"][@class=\"msportalfx-inherit-color fxs-portal-svg\"]")
    private HtmlElement context;

    @Name("DELETE_BTN")
    @FindBy(xpath = "//div[contains(text(), 'Delete resource group')][@class=\"fxs-contextMenu-text fxs-portal-text msportalfx-text-ellipsis\"]")
    private HtmlElement deleteBtn;

    @Name("STORAGE_CONFIRM_TEXT")
    @FindBy(xpath = "//input[@aria-errormessage=\"Please enter 'johnleeresources' to confirm delete.\"]")
    private HtmlElement storageConfirmText;

    @Name("CONTAINER_CONFIRM_TEXT")
    @FindBy(xpath = "//input[@aria-errormessage=\"Please enter 'acslabresourcegroup' to confirm delete.\"]")
    private HtmlElement containerConfirmText;

    @Name("WEBAPP_CONFIRM_TEXT")
    @FindBy(xpath = "//input[@aria-errormessage=\"Please enter 'webappslabresourcegroup' to confirm delete.\"]")
    private HtmlElement appConfirmText;

    @Name("CONFIRM_BTN")
    @FindBy(xpath = "//span[@class=\"fxs-button-text\"][@data-bind=\"text: data.text\"][contains(text(), 'Delete')]")
    private List<HtmlElement> confirmBtn;

    @Name("NOTIFICATION_CLOSE")
    @FindBy(xpath = "//button[@class=\"fxs-contextpane-close\"][@title=\"Close\"]")
    private List<HtmlElement> notificationClose;

    private final String pageError = "Resource group page is not displayed";
    private final String expectedTitle = "Resource groups - Microsoft Azure";

    public ResourceGroupPage(WebDriver driver) {
        super(driver);

        if (!titleContains(expectedTitle))
            throw new HtmlElementsException(pageError);

        HtmlElementLoader.populatePageObject(this, driver);
    }

    public void deleteAzureStorageResourceGroup() {
        notificationClose.get(0).click();
        Utils.waitForAMoment(3000);
        context.click();
        deleteBtn.click();
        Utils.waitForAMoment(3000);
        storageConfirmText.sendKeys("johnleeresources");
        Utils.waitForAMoment(3000);
        confirmBtn.get(0).click();
    }

    public void deleteAzureContainerResourceGroup() {
        notificationClose.get(0).click();
        Utils.waitForAMoment(3000);
        context.click();
        Utils.waitForAMoment(3000);
        deleteBtn.click();
        containerConfirmText.sendKeys("ACSLabResourceGroup");
        Utils.waitForAMoment(3000);
        confirmBtn.get(0).click();
    }

    public void deleteAzureWebAppResourceGroup() {
        Utils.waitForAMoment(3000);
        context.click();
        Utils.waitForAMoment(3000);
        deleteBtn.click();
        appConfirmText.sendKeys("WebAppsLabResourceGroup");
        Utils.waitForAMoment(3000);
        confirmBtn.get(0).click();
    }

}
