package com.cs527project.holstest.htmlelements.login;

import com.cs527project.holstest.htmlelements.annotations.Name;
import com.cs527project.holstest.htmlelements.element.HtmlElement;
import com.cs527project.holstest.htmlelements.exceptions.HtmlElementsException;
import com.cs527project.holstest.htmlelements.loader.HtmlElementLoader;
import com.cs527project.holstest.htmlelements.page.Page;
import com.cs527project.holstest.htmlelements.utils.enumerations.AccountInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public class SignInEmailPage extends Page {
    private final String siteUrl = "http://manage.windowsazure.com";
    private final String expectedTitle = "Sign in to Microsoft Azure";
    private final String signInEmailPageError = "Login email page is not displayed";
    @Name("EMAIL")
    @FindBy(id = "i0116")
    private HtmlElement email;
    @Name("NEXT")
    @FindBy(id = "idSIButton9")
    private HtmlElement next;

    public SignInEmailPage(WebDriver driver) {
        super(driver);
        HtmlElementLoader.populatePageObject(this, driver);
    }

    public SignInEmailPage open() {
        getDriver().get(siteUrl);

        if (!titleContains(expectedTitle))
            throw new HtmlElementsException(signInEmailPageError);

        return this;
    }

    public SignInPassPage goToPasswordPage() {
        email.sendKeys(AccountInfo.EMAIL.toString());
        next.click();
        SignInPassPage signInPassPage = new SignInPassPage(getDriver());
        return signInPassPage;
    }

}
