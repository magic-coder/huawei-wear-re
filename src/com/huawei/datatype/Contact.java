package com.huawei.datatype;

import java.util.List;

public class Contact {
    private String icon_index = "-1";
    private int index = 1;
    private String name;
    private String note = "";
    private List<PhoneNumber> phoneNumbers;

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return this.phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumber> list) {
        this.phoneNumbers = list;
    }

    public String getNote() {
        return this.note;
    }

    public String getIcon_index() {
        return this.icon_index;
    }

    public void setIcon_index(String str) {
        this.icon_index = str;
    }

    public String toString() {
        return "[Contact: name = " + this.name + ", note = " + this.note + ", icon_index = " + this.icon_index + ", phoneNumbers = " + this.phoneNumbers + "]";
    }

    public Contact(String str, String str2, List<PhoneNumber> list) {
        this.name = str2;
        this.phoneNumbers = list;
        this.icon_index = str;
    }

    public void procContact1() {
    }

    public void procContact2() {
    }

    public void procContact3() {
    }

    public void procContact4() {
    }

    public void procContact5() {
    }

    public void procContact6() {
    }

    public void procContact7() {
    }
}
