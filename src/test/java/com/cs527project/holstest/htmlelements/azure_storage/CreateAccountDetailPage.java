package com.cs527project.holstest.htmlelements.azure_storage;

import com.cs527project.holstest.htmlelements.annotations.Name;
import com.cs527project.holstest.htmlelements.element.HtmlElement;
import com.cs527project.holstest.htmlelements.exceptions.HtmlElementsException;
import com.cs527project.holstest.htmlelements.loader.HtmlElementLoader;
import com.cs527project.holstest.htmlelements.page.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CreateAccountDetailPage extends Page{
    @Name("INPUTS")
    @FindBy(xpath = "//input[@class=\"azc-input azc-formControl azc-validation-border\"]")
    private List<HtmlElement> inputs;

    @Name("PIN")
    @FindBy(xpath = "//label[contains(text(), 'Pin to dashboard')]")
    private List<HtmlElement> pin;

    @Name("CREATE_BTN")
    @FindBy(xpath = "//span[contains(text(), 'Create')][@class='fxs-button-text'][@data-bind=\"text: data.text\"]")
    private List<HtmlElement> createBtn;

    private final String pageError = "Create detail account page is not displayed";
    private final String expectedTitle = "Create storage account - Microsoft Azure";

    public CreateAccountDetailPage(WebDriver driver) {
        super(driver);
        HtmlElementLoader.populatePageObject(this, driver);

        if (!titleContains(expectedTitle))
            throw new HtmlElementsException(pageError);
    }

    public void fillInfo() {
        inputs.get(5).sendKeys("johnlee");
        inputs.get(5).sendKeys("johnLeeResources");
        pin.get(0).click();
    }

    public ResultPage goToResultPage() {
        createBtn.get(11).click();
        ResultPage resultPage = new ResultPage(getDriver());
        return resultPage;
    }


}
