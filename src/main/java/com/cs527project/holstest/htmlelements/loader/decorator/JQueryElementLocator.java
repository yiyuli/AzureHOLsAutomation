package com.cs527project.holstest.htmlelements.loader.decorator;

import com.cs527project.holstest.htmlelements.annotations.FindByJQuery;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.lang.reflect.Field;
import java.util.List;

public class JQueryElementLocator implements ElementLocator {
    private final JavascriptExecutor driver;
    private final FindByJQuery annotation;
    private String jqueryLocator;

    public JQueryElementLocator(final WebDriver driver, final Field field) {

        this.driver = (JavascriptExecutor) driver;
        this.annotation = field.getAnnotation(FindByJQuery.class);
        this.jqueryLocator = annotation.$();
    }

    @Override
    public WebElement findElement() {
        String jqueryFunction = String.format("function getElement() {return $  %s [0]; }; "
                + "return getElement()", jqueryLocator);
        return (WebElement) driver.executeScript(jqueryFunction);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<WebElement> findElements() {
        String jqueryFunction = String.format("function getElement() {return $  %s; }; "
                + "return getElement()", jqueryLocator);
        return (List<WebElement>) driver.executeScript(jqueryFunction);
    }

}
