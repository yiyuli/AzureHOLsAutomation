package com.cs527project.holstest.htmlelements.page;

public interface PageInterface {

    boolean urlContains(String url);

    boolean titleContains(String title);

    boolean urlIs(String url);

    boolean titleIs(String title);

    String getTitle();

    String getUrl();

    void reload();


}
