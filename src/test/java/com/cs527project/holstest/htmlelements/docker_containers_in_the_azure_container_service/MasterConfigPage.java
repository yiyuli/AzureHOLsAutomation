package com.cs527project.holstest.htmlelements.docker_containers_in_the_azure_container_service;

import com.cs527project.holstest.htmlelements.annotations.Name;
import com.cs527project.holstest.htmlelements.element.HtmlElement;
import com.cs527project.holstest.htmlelements.exceptions.HtmlElementsException;
import com.cs527project.holstest.htmlelements.loader.HtmlElementLoader;
import com.cs527project.holstest.htmlelements.page.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MasterConfigPage extends Page {
    private final String pageError = "Master configuration page is not displayed";
    private final String expectedTitle = "Master configuration - Microsoft Azure";
    @Name("DROPDOWN")
    @FindBy(xpath = "//span[@class=\"fxc-group-dropdown-arrow fxc-dropdown-open\"]")
    private HtmlElement dropdown;
    @Name("SWARM_OPTION")
    @FindBy(xpath = "//span[contains(text(), 'Swarm')][@class=\"fxs-portal-svg\"]")
    private HtmlElement swarmOption;
    @Name("INPUTS")
    @FindBy(xpath = "//input[@class=\"azc-input azc-formControl azc-validation-border\"]")
    private List<HtmlElement> inputs;
    @Name("USERNAME")
    @FindBy(xpath = "//input[@class=\"azc-input azc-formControl azc-validation-border\"]")
    private HtmlElement username;
    @Name("SSH_TEXT")
    @FindBy(xpath = "//textarea[@class=\"azc-textarea azc-formControl azc-input azc-validation-border msportalfx-font-regular\"]")
    private HtmlElement sshText;
    @Name("OK_BTN")
    @FindBy(xpath = "//span[contains(text(), 'OK')][@class=\"fxs-button-text\"]")
    private HtmlElement okBtn;


    public MasterConfigPage(WebDriver driver) {
        super(driver);
        HtmlElementLoader.populatePageObject(this, driver);

        if (!titleContains(expectedTitle))
            throw new HtmlElementsException(pageError);
    }

    public void fillInfo() {
        dropdown.click();
        swarmOption.click();
        inputs.get(2).sendKeys("asclab");
        inputs.get(2).sendKeys("dockeruser");
        sshText.sendKeys("ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQC1jpO7E8fiH7VqezB5b11UfNh7bH4SZaZmamwKaMTeeth7kL5PgkmZFyuCuszXOpb6Zo3MlQPgPIJMBL9i05q4b4KdneBGdSyffcOtqyNcPBf7LpThGmzszzVzlNXQxi6QCZd798ls7Pk1VSIepdKSQyt8LV8c35/p62VPp3JHMGkJh+8n17oDgv9Kqg8RRy6bxPnTbaFIVJ4hvwyEOFNh3utqlwu8oQzxQsDOWTxr2fZiZKU4rjh4RNtCbPBgpIlG5spolZvTEb2kmWKUMJDV51tvLqzrGKtos6FLtFS7ZDWRxj7+T8Psbt6nwgCGwHbnXshsP5aSB0hbm34Inx3N liyiyu1@wirelessprv-10-192-244-106.near.illinois.edu");

    }

    public AgentConfigPage goToAgentConfigPage() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        okBtn.click();
        AgentConfigPage agentConfigPage = new AgentConfigPage(getDriver());
        return agentConfigPage;
    }
}
