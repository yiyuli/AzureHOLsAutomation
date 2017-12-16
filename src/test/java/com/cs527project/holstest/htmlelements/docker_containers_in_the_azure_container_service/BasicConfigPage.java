package com.cs527project.holstest.htmlelements.docker_containers_in_the_azure_container_service;

import com.cs527project.holstest.htmlelements.annotations.Name;
import com.cs527project.holstest.htmlelements.element.HtmlElement;
import com.cs527project.holstest.htmlelements.exceptions.HtmlElementsException;
import com.cs527project.holstest.htmlelements.loader.HtmlElementLoader;
import com.cs527project.holstest.htmlelements.page.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class BasicConfigPage extends Page {
    private final String pageError = "Basic configuration page is not displayed";
    private final String expectedTitle = "Basics - Microsoft Azure";
    private final String okBtnError = "OK button is not properly displayed";
    @Name("NAME")
    @FindBy(xpath = "//input[@class=\"azc-input azc-formControl azc-validation-border\"]")
    private List<HtmlElement> inputs;
    @Name("RESOURCE_GROUP")
    @FindBy(xpath = "//input[@class=\"azc-input azc-formControl azc-validation-border fxs-br-error\"]")
    private HtmlElement resourceGroup;
    @Name("OK_BUTTON")
    @FindBy(xpath = "//span[contains(text(), 'OK')][@class=\"fxs-button-text\"]")
    private HtmlElement okBtn;


    public BasicConfigPage(WebDriver driver) {
        super(driver);
        HtmlElementLoader.populatePageObject(this, driver);

        if (!titleContains(expectedTitle))
            throw new HtmlElementsException(pageError);
    }

    public void fillInfo() {
        inputs.get(2).sendKeys("acslab");
        resourceGroup.sendKeys("ACSLabResourceGroup");
    }

    public MasterConfigPage goToMasterConfigPage() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

//        WebDriverWait wait = new WebDriverWait(getDriver(),10);
//        wait.until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver driver) {
//                String enabled = okBtn.getAttribute("aria-disabled");
//                if(enabled != null)
//                    return true;
//                else
//                    return false;
//            }
//        });

        okBtn.click();
        MasterConfigPage masterConfigPage = new MasterConfigPage(getDriver());
        return masterConfigPage;
    }


}
