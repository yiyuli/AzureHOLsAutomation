package com.cs527project.holstest.htmlelements.base_test;

import com.cs527project.holstest.htmlelements.utils.Driver.BrowserDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTestClass {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new BrowserDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        driver.quit();
    }
}
