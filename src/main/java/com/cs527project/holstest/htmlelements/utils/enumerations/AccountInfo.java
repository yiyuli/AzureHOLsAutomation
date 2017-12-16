package com.cs527project.holstest.htmlelements.utils.enumerations;

public enum AccountInfo {
    EMAIL(""),      //email here
    PASSWORD("");   //password here

    private String value;

    private AccountInfo(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
