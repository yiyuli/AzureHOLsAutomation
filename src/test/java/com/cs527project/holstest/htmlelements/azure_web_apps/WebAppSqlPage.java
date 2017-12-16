package com.cs527project.holstest.htmlelements.azure_web_apps;

import com.cs527project.holstest.htmlelements.annotations.Name;
import com.cs527project.holstest.htmlelements.element.HtmlElement;
import com.cs527project.holstest.htmlelements.exceptions.HtmlElementsException;
import com.cs527project.holstest.htmlelements.loader.HtmlElementLoader;
import com.cs527project.holstest.htmlelements.page.Page;
import com.cs527project.holstest.htmlelements.utils.Driver.BrowserDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebAppSqlPage extends Page {

    private final String pageError = "Web App + MySQL page is not displayed";
    private final String expectedTitle = "Web App + MySQL - Microsoft Azure";
    @Name("APP_NAME")
    @FindBy(xpath = "//input[@placeholder='Enter a name for your App']")
    private HtmlElement appName;
    @Name("RESOURCE_GROUP")
    @FindBy(xpath = "//input[@placeholder=''][@spellcheck='false']")
    private HtmlElement resourceGroup;
    @Name("DATABASE_PROVIDER")
    @FindBy(xpath = "//*[@aria-label=\"MySQL In App\"]")
    private HtmlElement databaseProvider;
    @Name("DROPDOWN")
    @FindBy(xpath = "//span[@class='fxc-group-dropdown-arrow fxc-dropdown-open']")
    private HtmlElement dropdown;
    @Name("PIN")
    @FindBy(xpath = "//label[contains(text(), 'Pin to dashboard')]")
    private List<HtmlElement> pin;
    @Name("CREATE_BTN")
    @FindBy(xpath = "//span[contains(text(), 'Create')][@class='fxs-button-text'][@data-bind=\"text: data.text\"]")
    private List<HtmlElement> createBtn;
    @Name("NOTES")
    @FindBy(xpath = "//div[contains(text(), 'MySQL In App runs a local MySQL instance')]")
    private HtmlElement notes;


    public WebAppSqlPage(WebDriver driver) {
        super(driver);
        HtmlElementLoader.populatePageObject(this, driver);

        if (!titleContains(expectedTitle))
            throw new HtmlElementsException(pageError);
    }

    public void fillInfo() {
        resourceGroup.sendKeys(""); // Necessary step for locating this element, Otherwise its placeholder will change after appName input is changed
        appName.sendKeys("testwebappslab");
        resourceGroup.clear();
        resourceGroup.sendKeys("WebAppsLabResourceGroup");
        dropdown.click();
        databaseProvider.click();
        pin.get(0).click();
    }

    public ResultPage goToResultPage() {
        ((BrowserDriver) getDriver()).waitUntilVisible(notes);
        createBtn.get(9).click();
        ResultPage resultPage = new ResultPage(getDriver());
        return resultPage;
    }
}
