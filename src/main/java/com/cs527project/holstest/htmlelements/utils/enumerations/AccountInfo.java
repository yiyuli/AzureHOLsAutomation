package com.cs527project.holstest.htmlelements.utils.enumerations;

public enum AccountInfo {
    EMAIL("yiyuli2@illinois.edu"),
    PASSWORD("19940607Ab");

    private String value;

    private AccountInfo(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
