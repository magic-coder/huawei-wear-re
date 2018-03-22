package com.huawei.nfc.carrera.server.card.request;

import com.huawei.nfc.carrera.constant.Constant;

public class TsmParamQueryRequest extends CardServerBaseRequest {
    private String aid;
    private String bankRsaIndex;
    private String bankSignResult;
    private String bankSignTime;
    private String cplc;
    private boolean deleteRelatedObjects = false;
    private String issuerId;
    private String signType;
    private String terminal;
    private String tsmParamIMEI;

    public TsmParamQueryRequest(String str, String str2, int i, String str3, String str4, String str5) {
        super(str2, i, str3);
        this.cplc = str;
        this.terminal = str4;
        this.tsmParamIMEI = str5;
    }

    public TsmParamQueryRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z) {
        this.cplc = str;
        this.aid = str2;
        this.terminal = str3;
        this.bankSignResult = str4;
        this.bankSignTime = str5;
        this.bankRsaIndex = str6;
        this.tsmParamIMEI = str7;
        this.deleteRelatedObjects = z;
    }

    public String getCplc() {
        return this.cplc;
    }

    public String getAid() {
        return this.aid;
    }

    public String getTerminal() {
        return this.terminal;
    }

    public String getBankSignResult() {
        return this.bankSignResult;
    }

    public String getBankSignTime() {
        return this.bankSignTime;
    }

    public String getBankRsaIndex() {
        return this.bankRsaIndex;
    }

    public String getSignType() {
        return this.signType;
    }

    public boolean isDeleteRelatedObjects() {
        return this.deleteRelatedObjects;
    }

    public String getTsmParamIMEI() {
        return this.tsmParamIMEI;
    }

    public void setCplc(String str) {
        this.cplc = str;
    }

    public void setAid(String str) {
        this.aid = str;
    }

    public void setTerminal(String str) {
        this.terminal = str;
    }

    public void setBankSignResult(String str) {
        this.bankSignResult = str;
    }

    public void setBankSignTime(String str) {
        this.bankSignTime = str;
    }

    public void setBankRsaIndex(String str) {
        this.bankRsaIndex = str;
    }

    public void setSignType(String str) {
        this.signType = str;
    }

    public void setDeleteRelatedObjects(boolean z) {
        this.deleteRelatedObjects = z;
    }

    public void setTsmParamIMEI(String str) {
        this.tsmParamIMEI = str;
    }

    public String getIssuerId() {
        return this.issuerId;
    }

    public void setIssuerId(String str) {
        if (str != null && !str.equals("") && str.equals(Constant.FM_LNT_CARD_ISSERID)) {
            this.issuerId = str;
        }
    }
}
