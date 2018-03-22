package com.huawei.crowdtestsdk.bases;

public class IssueStatusFlow {
    private String assignee;
    private boolean isCurrentFlow;
    private String remarks;
    private String status;
    private String updateTime;

    public String getStatus() {
        return this.status;
    }

    public String getAssignee() {
        return this.assignee;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public boolean isCurrentFlow() {
        return this.isCurrentFlow;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setAssignee(String str) {
        this.assignee = str;
    }

    public void setUpdateTime(String str) {
        this.updateTime = str;
    }

    public void setRemarks(String str) {
        this.remarks = str;
    }

    public void setCurrentFlow(boolean z) {
        this.isCurrentFlow = z;
    }
}
