package com.huawei.crowdtestsdk.bases;

public class ReportResponseItem {
    private String imeiNo;
    private String projectId;
    private String reportSetId;
    private String reportValue;

    public String getImeiNo() {
        return this.imeiNo;
    }

    public void setImeiNo(String str) {
        this.imeiNo = str;
    }

    public void setReportSetId(String str) {
        this.reportSetId = str;
    }

    public String getReportValue() {
        return this.reportValue;
    }

    public void setReportValue(String str) {
        this.reportValue = str;
    }

    public String getProjectId() {
        return this.projectId;
    }

    public void setProjectId(String str) {
        this.projectId = str;
    }
}
