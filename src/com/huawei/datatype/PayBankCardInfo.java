package com.huawei.datatype;

public class PayBankCardInfo {
    private String AID;
    private String fileName;
    private String name;
    private String number;
    private int type;

    public String getAID() {
        return this.AID;
    }

    public void setAID(String str) {
        this.AID = str;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String str) {
        this.number = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }
}
