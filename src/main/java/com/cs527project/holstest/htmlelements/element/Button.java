package com.cs527project.holstest.htmlelements.element;

import org.openqa.selenium.WebElement;

/**
 * Represents web page button control.
 *
 * @author Alexander Tolmachev starlight@yandex-team.ru
 * Date: 14.08.12
 */
public class Button extends TypifiedElement {
    /**
     * Specifies wrapped {@link WebElement}.
     *
     * @param wrappedElement {@code WebElement} to wrap.
     */
    public Button(WebElement wrappedElement) {
        super(wrappedElement);
    }
}
