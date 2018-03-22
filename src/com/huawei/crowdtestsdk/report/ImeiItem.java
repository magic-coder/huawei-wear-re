package com.huawei.crowdtestsdk.report;

public class ImeiItem {
    private String projectId;
    private String userId;
    private String userImeiNo;

    public String getProjectId() {
        return this.projectId;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUserImeiNo() {
        return this.userImeiNo;
    }

    public void setProjectId(String str) {
        this.projectId = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setUserImeiNo(String str) {
        this.userImeiNo = str;
    }
}
