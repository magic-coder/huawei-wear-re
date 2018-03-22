package com.huawei.crowdtestsdk.bases;

import com.google.gson.Gson;

public class TbdtsCreationUnit {
    private String APPEAR_DATE;
    private String APPEAR_TIME_ZONE;
    private String DESCRIPTION;
    private String IMEI_NO;
    private String NEW_QUES_TYPE;
    private String PHONE_MODEL;
    private String PHONE_VER;
    private String PRODB_NO;
    private String PROJECT_ID;
    private String RECURE;
    private String USER_ACCOUNT;

    public String getAPPEAR_TIME_ZONE() {
        return this.APPEAR_TIME_ZONE;
    }

    public String getPHONE_MODEL() {
        return this.PHONE_MODEL;
    }

    public void setPHONE_MODEL(String str) {
        this.PHONE_MODEL = str;
    }

    public String getPHONE_VER() {
        return this.PHONE_VER;
    }

    public void setPHONE_VER(String str) {
        this.PHONE_VER = str;
    }

    public String getAPPEAR_DATE() {
        return this.APPEAR_DATE;
    }

    public void setAPPEAR_DATE(String str) {
        this.APPEAR_DATE = str;
    }

    public String getPROJECT_ID() {
        return this.PROJECT_ID;
    }

    public String getPRODB_NO() {
        return this.PRODB_NO;
    }

    public String getIMEI_NO() {
        return this.IMEI_NO;
    }

    public String getNEW_QUES_TYPE() {
        return this.NEW_QUES_TYPE;
    }

    public String getRECURE() {
        return this.RECURE;
    }

    public String getDESCRIPTION() {
        return this.DESCRIPTION;
    }

    public String getUSER_ACCOUNT() {
        return this.USER_ACCOUNT;
    }

    public void setPROJECT_ID(String str) {
        this.PROJECT_ID = str;
    }

    public void setPRODB_NO(String str) {
        this.PRODB_NO = str;
    }

    public void setIMEI_NO(String str) {
        this.IMEI_NO = str;
    }

    public void setNEW_QUES_TYPE(String str) {
        this.NEW_QUES_TYPE = str;
    }

    public void setRECURE(String str) {
        this.RECURE = str;
    }

    public void setDESCRIPTION(String str) {
        this.DESCRIPTION = str;
    }

    public void setUSER_ACCOUNT(String str) {
        this.USER_ACCOUNT = str;
    }

    public void setAPPEAR_TIME_ZONE(String str) {
        this.APPEAR_TIME_ZONE = str;
    }

    public String toJsonString() {
        return new Gson().toJson((Object) this);
    }
}
