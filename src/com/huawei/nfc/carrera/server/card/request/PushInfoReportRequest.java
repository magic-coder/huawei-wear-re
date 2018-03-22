package com.huawei.nfc.carrera.server.card.request;

public class PushInfoReportRequest extends CardServerBaseRequest {
    public static final String REPORT_TYPE_PUSH_TOKEN = "ptoken";
    private String cplc;
    private String deviceInfo;
    private String reportType;

    public String getCplc() {
        return this.cplc;
    }

    public String getReportType() {
        return this.reportType;
    }

    public String getDeviceInfo() {
        return this.deviceInfo;
    }

    public void setCplc(String str) {
        this.cplc = str;
    }

    public void setReportType(String str) {
        this.reportType = str;
    }

    public void setDeviceInfo(String str) {
        this.deviceInfo = str;
    }
}
