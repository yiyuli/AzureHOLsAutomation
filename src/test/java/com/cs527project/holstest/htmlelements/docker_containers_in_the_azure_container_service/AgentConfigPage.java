package com.cs527project.holstest.htmlelements.docker_containers_in_the_azure_container_service;

import com.cs527project.holstest.htmlelements.annotations.Name;
import com.cs527project.holstest.htmlelements.element.HtmlElement;
import com.cs527project.holstest.htmlelements.exceptions.HtmlElementsException;
import com.cs527project.holstest.htmlelements.loader.HtmlElementLoader;
import com.cs527project.holstest.htmlelements.page.Page;
import com.cs527project.holstest.htmlelements.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AgentConfigPage extends Page {

    private final String pageError = "Agent configuration page is not displayed";
    private final String expectedTitle = "Agent configuration - Microsoft Azure";
    @Name("OK_BTN")
    @FindBy(xpath = "//span[contains(text(), 'OK')][@class=\"fxs-button-text\"]")
    private HtmlElement okBtn;


    public AgentConfigPage(WebDriver driver) {
        super(driver);
        HtmlElementLoader.populatePageObject(this, driver);

        if (!titleContains(expectedTitle))
            throw new HtmlElementsException(pageError);
    }


    public SummaryPage goToSummaryPage() {
        Utils.waitForAMoment(3000);
        okBtn.click();
        SummaryPage summaryPage = new SummaryPage(getDriver());
        return summaryPage;
    }
}
