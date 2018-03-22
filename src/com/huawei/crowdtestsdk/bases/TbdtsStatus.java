package com.huawei.crowdtestsdk.bases;

public class TbdtsStatus {
    public String description;
    public String projectId;
    public String projectName;
    public int status;
    public String tbdtsQuesNo;

    public String getTbdtsQuesNo() {
        return this.tbdtsQuesNo;
    }

    public int getStatus() {
        return this.status;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.tbdtsQuesNo).append("/").append(this.status).append("/").append(this.description).append("/").append(this.projectId).append("/").append(this.projectName).append("/");
        return stringBuilder.toString();
    }
}
