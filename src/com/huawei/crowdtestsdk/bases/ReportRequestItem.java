package com.huawei.crowdtestsdk.bases;

public class ReportRequestItem {
    private String createUserCN;
    private String creationDate;
    private String lastUpdateDate;
    private String lastUpdateUserCN;
    private String reportCode;
    private String reportNameCh;
    private String reportNameEn;
    private String reportSetId;

    public ReportRequestItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.createUserCN = str;
        this.creationDate = str2;
        this.lastUpdateDate = str3;
        this.lastUpdateUserCN = str4;
        this.reportCode = str5;
        this.reportNameCh = str6;
        this.reportNameEn = str7;
        this.reportSetId = str8;
    }

    public String getCreateUserCN() {
        return this.createUserCN;
    }

    public void setCreateUserCN(String str) {
        this.createUserCN = str;
    }

    public String getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(String str) {
        this.creationDate = str;
    }

    public String getLastUpdateDate() {
        return this.lastUpdateDate;
    }

    public void setLastUpdateDate(String str) {
        this.lastUpdateDate = str;
    }

    public String getLastUpdateUserCN() {
        return this.lastUpdateUserCN;
    }

    public void setLastUpdateUserCN(String str) {
        this.lastUpdateUserCN = str;
    }

    public String getReportCode() {
        return this.reportCode;
    }

    public void setReportCode(String str) {
        this.reportCode = str;
    }

    public String getReportNameCh() {
        return this.reportNameCh;
    }

    public void setReportNameCh(String str) {
        this.reportNameCh = str;
    }

    public String getReportNameEn() {
        return this.reportNameEn;
    }

    public void setReportNameEn(String str) {
        this.reportNameEn = str;
    }

    public String getReportSetId() {
        return this.reportSetId;
    }

    public void setReportSetId(String str) {
        this.reportSetId = str;
    }

    public String toString() {
        return "ReportRequestItem{createUserCN='" + this.createUserCN + '\'' + ", creationDate='" + this.creationDate + '\'' + ", lastUpdateDate='" + this.lastUpdateDate + '\'' + ", lastUpdateUserCN='" + this.lastUpdateUserCN + '\'' + ", reportCode='" + this.reportCode + '\'' + ", reportNameCh='" + this.reportNameCh + '\'' + ", reportNameEn='" + this.reportNameEn + '\'' + ", reportSetId='" + this.reportSetId + '\'' + '}';
    }
}
