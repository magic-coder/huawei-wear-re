package com.huawei.crowdtestsdk.report;

public class GroupMemberItem {
    private String phoneAndroidVer;
    private String phoneModel;
    private String phoneVer;
    private String projectId;
    private String userId;

    public String getUserId() {
        return this.userId;
    }

    public String getProjectId() {
        return this.projectId;
    }

    public String getPhoneModel() {
        return this.phoneModel;
    }

    public String getPhoneVer() {
        return this.phoneVer;
    }

    public String getPhoneAndroidVer() {
        return this.phoneAndroidVer;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setProjectId(String str) {
        this.projectId = str;
    }

    public void setPhoneModel(String str) {
        this.phoneModel = str;
    }

    public void setPhoneVer(String str) {
        this.phoneVer = str;
    }

    public void setPhoneAndroidVer(String str) {
        this.phoneAndroidVer = str;
    }
}
