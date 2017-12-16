package com.cs527project.holstest.htmlelements.login;

import com.cs527project.holstest.htmlelements.annotations.Name;
import com.cs527project.holstest.htmlelements.element.HtmlElement;
import com.cs527project.holstest.htmlelements.exceptions.HtmlElementsException;
import com.cs527project.holstest.htmlelements.loader.HtmlElementLoader;
import com.cs527project.holstest.htmlelements.page.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class NoSubscriptionsPage extends Page {
    private final String noSubscriptionsPageError = "No subscriptions page is not displayed";
    private final String expectedTitle = "No subscriptions found.";
    @Name("PORTAL_LINK")
    @FindBy(xpath = "//html/body/div[1]/div/div[2]/div/ul/li[5]/a")
    private HtmlElement portalLink;

    public NoSubscriptionsPage(WebDriver driver) {
        super(driver);
        HtmlElementLoader.populatePageObject(this, driver);

        if (!titleContains(expectedTitle))
            throw new HtmlElementsException(noSubscriptionsPageError);
    }

    public PortalPage goToPortalPage() {
        portalLink.click();
        PortalPage portalPage = new PortalPage(getDriver());
        return portalPage;
    }
}
