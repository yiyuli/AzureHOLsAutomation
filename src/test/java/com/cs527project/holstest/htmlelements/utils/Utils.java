package com.cs527project.holstest.htmlelements.utils;

public class Utils {
    public static void waitForAMoment(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
