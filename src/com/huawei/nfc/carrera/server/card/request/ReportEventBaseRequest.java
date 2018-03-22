package com.huawei.nfc.carrera.server.card.request;

public class ReportEventBaseRequest extends CardServerBaseRequest {
    public static final String RESULT_CODE_FAIL = "1";
    public static final String RESULT_CODE_SUCCESS = "0";
    private String cardIssuerid;
    private int cardType;
    private String errorDesc;
    private String requestNum;
    private String result;
    private String terminal;
    private String time;
    private String uid;

    public String getErrorDesc() {
        return this.errorDesc;
    }

    public void setErrorDesc(String str) {
        this.errorDesc = str;
    }

    public String getRequestNum() {
        return this.requestNum;
    }

    public void setRequestNum(String str) {
        this.requestNum = str;
    }

    public String getCardIssuerid() {
        return this.cardIssuerid;
    }

    public void setCardIssuerid(String str) {
        this.cardIssuerid = str;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public int getCardType() {
        return this.cardType;
    }

    public void setCardType(int i) {
        this.cardType = i;
    }

    public String getTerminal() {
        return this.terminal;
    }

    public void setTerminal(String str) {
        this.terminal = str;
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String str) {
        this.result = str;
    }
}
