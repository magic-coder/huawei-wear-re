package com.huawei.crowdtestsdk.bases;

public class ProjectItem {
    private String groupId;
    private String productType;
    private String projectId;
    private String projectName;
    private String versionList;

    public String getProjectId() {
        return this.projectId;
    }

    public void setProjectId(String str) {
        this.projectId = str;
    }

    public String getProjectName() {
        return this.projectName;
    }

    public void setProjectName(String str) {
        this.projectName = str;
    }

    public String getVersionList() {
        return this.versionList;
    }

    public void setVersionList(String str) {
        this.versionList = str;
    }

    public String getProductType() {
        return this.productType;
    }

    public void setProductType(String str) {
        this.productType = str;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public boolean isPadOrPhoneProject() {
        if ("0".equalsIgnoreCase(this.productType) || "2".equalsIgnoreCase(this.productType)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "ProjectItem{projectId='" + this.projectId + '\'' + ", projectName='" + this.projectName + '\'' + ", versionList='" + this.versionList + '\'' + ", productType='" + this.productType + '\'' + ", groupId='" + this.groupId + '\'' + '}';
    }
}
