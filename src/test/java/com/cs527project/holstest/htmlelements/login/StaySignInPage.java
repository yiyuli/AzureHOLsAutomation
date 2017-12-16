package com.cs527project.holstest.htmlelements.login;

import com.cs527project.holstest.htmlelements.annotations.Name;
import com.cs527project.holstest.htmlelements.element.HtmlElement;
import com.cs527project.holstest.htmlelements.exceptions.HtmlElementsException;
import com.cs527project.holstest.htmlelements.loader.HtmlElementLoader;
import com.cs527project.holstest.htmlelements.page.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class StaySignInPage extends Page {
    private final String staySignInPageError = "Stay sign in page is not displayed";
    private final String expectedTitle = "Sign in to Microsoft Azure";
    @Name("YES_BTN")
    @FindBy(id = "idSIButton9")
    private HtmlElement yesBtn;

    public StaySignInPage(WebDriver driver) {
        super(driver);
        HtmlElementLoader.populatePageObject(this, driver);

        if (!titleContains(expectedTitle))
            throw new HtmlElementsException(staySignInPageError);
    }

    public NoSubscriptionsPage goToNoSubscriptionPage() {
        yesBtn.click();
        NoSubscriptionsPage noSubscriptionsPage = new NoSubscriptionsPage(getDriver());
        return noSubscriptionsPage;
    }
}
