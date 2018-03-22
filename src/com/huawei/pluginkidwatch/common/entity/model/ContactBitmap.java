package com.huawei.pluginkidwatch.common.entity.model;

import java.util.Arrays;

public class ContactBitmap {
    private int contactId;
    private byte[] headIcon;
    private String iconType;
    private String name;
    private String phoneNum;
    private int sosType = 0;
    private int type = 0;

    public String getIconType() {
        return this.iconType;
    }

    public void setIconType(String str) {
        this.iconType = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getPhoneNum() {
        return this.phoneNum;
    }

    public void setPhoneNum(String str) {
        this.phoneNum = str;
    }

    public int getContactId() {
        return this.contactId;
    }

    public void setContactId(int i) {
        this.contactId = i;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public int getSosType() {
        return this.sosType;
    }

    public void setSosType(int i) {
        this.sosType = i;
    }

    public byte[] getHeadIcon() {
        if (this.headIcon == null) {
            return null;
        }
        Object obj = new byte[this.headIcon.length];
        System.arraycopy(this.headIcon, 0, obj, 0, this.headIcon.length);
        return obj;
    }

    public void setHeadIcon(byte[] bArr) {
        if (bArr != null) {
            Object obj = new byte[bArr.length];
            System.arraycopy(bArr, 0, obj, 0, bArr.length);
            this.headIcon = obj;
        }
    }

    public String toString() {
        return "ContactBitmap [contactId=" + this.contactId + ", name=" + this.name + ", phoneNum=" + this.phoneNum + ", headIcon=" + Arrays.toString(this.headIcon) + ", iconType=" + this.iconType + ", type=" + this.type + ", sosType=" + this.sosType + "]";
    }

    public ContactBitmap(int i, String str, String str2, byte[] bArr, String str3, int i2, int i3) {
        this.contactId = i;
        this.name = str;
        this.phoneNum = str2;
        if (bArr != null) {
            Object obj = new byte[bArr.length];
            System.arraycopy(bArr, 0, obj, 0, bArr.length);
            this.headIcon = obj;
        }
        this.iconType = str3;
        this.type = i2;
        this.sosType = i3;
    }
}
