package com.huawei.pluginkidwatch.common.entity.model;

import java.io.Serializable;

public class ImportContact implements Serializable {
    private static final long serialVersionUID = -8429246251287724528L;
    private long contactId;
    private String imgBitmapStr;
    private String name;
    private String phoneNum;
    public String sortKey;
    private String sortLetters;

    public long getContactId() {
        return this.contactId;
    }

    public void setContactId(long j) {
        this.contactId = j;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public String getImgBitmapStr() {
        return this.imgBitmapStr;
    }

    public void setImgBitmapStr(String str) {
        this.imgBitmapStr = str;
    }

    public String getSortLetters() {
        return this.sortLetters;
    }

    public void setSortLetters(String str) {
        this.sortLetters = str;
    }

    public String getSortKey() {
        return this.sortKey;
    }

    public void setSortKey(String str) {
        this.sortKey = str;
    }

    public ImportContact(long j, String str, String str2, String str3, String str4, String str5) {
        this.contactId = j;
        this.name = str;
        this.phoneNum = str2;
        this.imgBitmapStr = str3;
        this.sortLetters = str4;
        this.sortKey = str5;
    }

    public void getImportContactName() {
    }

    public void requestImportContactHeadUrl() {
    }

    public void downloadImportContactNameUrl() {
    }

    public void judgeImportContactWeightBySomeInfo() {
    }

    public void setImportContactSwitchUpload() {
    }

    public void updataImportContactLocalTable() {
    }

    public void dealWithImportContactResetFactory() {
    }

    public void refreshImportContactInitData() {
    }

    public void queryImportContactProcessData() {
    }

    public void contrustImportContactHeadImage() {
    }

    public void changeImportContactDeviceInfo() {
    }
}
