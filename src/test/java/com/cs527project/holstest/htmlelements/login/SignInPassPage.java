package com.cs527project.holstest.htmlelements.login;

import com.cs527project.holstest.htmlelements.annotations.Name;
import com.cs527project.holstest.htmlelements.element.HtmlElement;
import com.cs527project.holstest.htmlelements.exceptions.HtmlElementsException;
import com.cs527project.holstest.htmlelements.loader.HtmlElementLoader;
import com.cs527project.holstest.htmlelements.page.Page;
import com.cs527project.holstest.htmlelements.utils.enumerations.AccountInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SignInPassPage extends Page {
    private final String passwordPageError = "Sign in password page is not displayed";
    private final String expectedTitle = "Sign In";
    @Name("PASSWORD")
    @FindBy(id = "passwordInput")
    private HtmlElement password;
    @Name("SIGNIN")
    @FindBy(id = "submitButton")
    private HtmlElement signInBtn;

    public SignInPassPage(WebDriver driver) {
        super(driver);
        HtmlElementLoader.populatePageObject(this, driver);

        if (!titleContains(expectedTitle))
            throw new HtmlElementsException(passwordPageError);
    }

    public StaySignInPage goToStaySignInPage() {
        password.sendKeys(AccountInfo.PASSWORD.toString());
        signInBtn.click();
        StaySignInPage staySignInPage = new StaySignInPage(getDriver());
        return staySignInPage;
    }

}
