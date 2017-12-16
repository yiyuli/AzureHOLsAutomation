package com.cs527project.holstest.htmlelements.docker_containers_in_the_azure_container_service;

import com.cs527project.holstest.htmlelements.annotations.Name;
import com.cs527project.holstest.htmlelements.element.HtmlElement;
import com.cs527project.holstest.htmlelements.exceptions.HtmlElementsException;
import com.cs527project.holstest.htmlelements.loader.HtmlElementLoader;
import com.cs527project.holstest.htmlelements.page.Page;
import com.cs527project.holstest.htmlelements.utils.Driver.BrowserDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SummaryPage extends Page {

    @Name("OK_BTN")
    @FindBy(xpath = "//span[contains(text(), 'OK')][@class=\"fxs-button-text\"]")
    private HtmlElement okBtn;

    @Name("VALIDATION_PASSED")
    @FindBy(xpath = "//span[contains(text(), 'Validation passed')][@class=\"fxs-blade-status-text\"]")
    private HtmlElement validationNotification;

    private final String pageError = "Summary page is not displayed";
    private final String expectedTitle = "Summary - Microsoft Azure";

    public SummaryPage(WebDriver driver) {
        super(driver);
        HtmlElementLoader.populatePageObject(this, driver);

        if (!titleContains(expectedTitle))
            throw new HtmlElementsException(pageError);
    }

    public ResultPage goToResultPage() {
        ((BrowserDriver) getDriver()).waitUntilVisible(validationNotification);
        okBtn.click();
        ResultPage resultPage = new ResultPage(getDriver());
        return resultPage;
    }
}
