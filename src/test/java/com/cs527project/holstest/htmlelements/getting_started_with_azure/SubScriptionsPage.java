package com.cs527project.holstest.htmlelements.getting_started_with_azure;

import com.cs527project.holstest.htmlelements.annotations.Name;
import com.cs527project.holstest.htmlelements.element.HtmlElement;
import com.cs527project.holstest.htmlelements.exceptions.HtmlElementsException;
import com.cs527project.holstest.htmlelements.loader.HtmlElementLoader;
import com.cs527project.holstest.htmlelements.page.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SubScriptionsPage extends Page {
    private final String pageError = "SubScriptions page is not displayed";
    private final String expectedTitle = "Billing overview - Microsoft Azure";
    @Name("SUBSCRIPTIONS_TEXT")
    @FindBy(xpath = "//html/body/div[1]/div[3]/main/div[2]/div[2]/section/div[1]/div[2]/div[4]/div[2]/div[2]/div/div[2]/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div/div/div/div/table/tbody/tr/td[1]/div")
    private HtmlElement subscriptionsText;


    public SubScriptionsPage(WebDriver driver) {
        super(driver);
        HtmlElementLoader.populatePageObject(this, driver);

        if (!titleContains(expectedTitle))
            throw new HtmlElementsException(pageError);
    }

    public String getSubscriptions() {
        return subscriptionsText.getText();
    }

}
