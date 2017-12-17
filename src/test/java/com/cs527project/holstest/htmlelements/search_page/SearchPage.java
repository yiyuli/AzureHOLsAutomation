package com.cs527project.holstest.htmlelements.search_page;

import com.cs527project.holstest.htmlelements.annotations.Name;
import com.cs527project.holstest.htmlelements.azure_web_apps.WebAppSqlPage;
import com.cs527project.holstest.htmlelements.docker_containers_in_the_azure_container_service.BasicConfigPage;
import com.cs527project.holstest.htmlelements.element.HtmlElement;
import com.cs527project.holstest.htmlelements.exceptions.HtmlElementsException;
import com.cs527project.holstest.htmlelements.loader.HtmlElementLoader;
import com.cs527project.holstest.htmlelements.page.Page;
import com.cs527project.holstest.htmlelements.utils.Driver.BrowserDriver;
import com.cs527project.holstest.htmlelements.azure_storage.CreateAccountPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SearchPage extends Page {
    private final String pageError = "Search page is not displayed";
    private final String expectedTitle = "New - Microsoft Azure";
    @Name("SEARCH_INPUT")
    @FindBy(xpath = "//input[@aria-placeholder='Search the Marketplace']")
    private WebElement searchInput;

    @Name("WEBAPP_ITEM")
    @FindBy(xpath = "//a[contains(text(), 'Web App + MySQL')]")
    private HtmlElement webAppItem;

    @Name("CONTAINERS_ITEM")
    @FindBy(xpath = "//div[contains(text(), 'Containers')]")
    private HtmlElement containersItem;

    @Name("CONTAINERS_SERVICE_ITEM")
    @FindBy(xpath = "//a[contains(text(), 'Azure Container Service')][@aria-label=\"Create Azure Container Service\"]")
    private HtmlElement containersServiceItem;

    @Name("STORAGE_ITEM")
    @FindBy(xpath = "//div[contains(text(), 'Storage')]")
    private HtmlElement storageItem;


    public SearchPage(WebDriver driver) {
        super(driver);


        if (!titleContains(expectedTitle))
            throw new HtmlElementsException(pageError);

        HtmlElementLoader.populatePageObject(this, driver);
    }

    private void search(String keywords) {
        searchInput.sendKeys(keywords);
        searchInput.sendKeys(Keys.RETURN);
    }

    public WebAppSqlPage goToWebAppSqlPage() {
        webAppItem.click();
        WebAppSqlPage webAppSqlPage = new WebAppSqlPage(getDriver());
        return webAppSqlPage;
    }

    public BasicConfigPage goToBasicConfigPage() {
        containersItem.click();
        ((BrowserDriver) getDriver()).waitUntilVisible(containersServiceItem);
        containersServiceItem.click();
        BasicConfigPage basicConfigPage = new BasicConfigPage(getDriver());
        return basicConfigPage;
    }

    public CreateAccountPage goToCreateAccountPage() {
        storageItem.click();
        //((BrowserDriver) getDriver()).waitUntilVisible(storageAccountItem);
        //storageAccountItem.click();
        CreateAccountPage createAccountPage = new CreateAccountPage(getDriver());
        return createAccountPage;
    }
}
