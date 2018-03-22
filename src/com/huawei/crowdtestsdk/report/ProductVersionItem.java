package com.huawei.crowdtestsdk.report;

public class ProductVersionItem {
    private String currentProdVer;
    private String projectId;
    private String userId;

    public String getProjectId() {
        return this.projectId;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getCurrentProdVer() {
        return this.currentProdVer;
    }

    public void setProjectId(String str) {
        this.projectId = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setCurrentProdVer(String str) {
        this.currentProdVer = str;
    }
}
