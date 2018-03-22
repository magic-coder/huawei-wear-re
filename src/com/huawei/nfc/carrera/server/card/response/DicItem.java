package com.huawei.nfc.carrera.server.card.response;

public class DicItem {
    private String name;
    private String parent;
    private String value;

    public String getParent() {
        return this.parent;
    }

    public void setParent(String str) {
        this.parent = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }
}
