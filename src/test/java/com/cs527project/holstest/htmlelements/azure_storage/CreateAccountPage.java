package com.cs527project.holstest.htmlelements.azure_storage;

import com.cs527project.holstest.htmlelements.annotations.Name;
import com.cs527project.holstest.htmlelements.element.HtmlElement;
import com.cs527project.holstest.htmlelements.exceptions.HtmlElementsException;
import com.cs527project.holstest.htmlelements.loader.HtmlElementLoader;
import com.cs527project.holstest.htmlelements.page.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends Page{

    @Name("CREATE_ACCOUNT_BTN")
    @FindBy(xpath = "//span[contains(text(), 'Create Storage accounts')]")
    private HtmlElement createAccountBtn;

    private final String pageError = "Create account page is not displayed";
    private final String expectedTitle = "Storage accounts - Microsoft Azure";

    public CreateAccountPage(WebDriver driver) {
        super(driver);
        HtmlElementLoader.populatePageObject(this, driver);

        if (!titleContains(expectedTitle))
            throw new HtmlElementsException(pageError);
    }

    public CreateAccountDetailPage goToCreateAccountDetailPage() {
        createAccountBtn.click();
        CreateAccountDetailPage createAccountDetailPage = new CreateAccountDetailPage(getDriver());
        return createAccountDetailPage;
    }
}
