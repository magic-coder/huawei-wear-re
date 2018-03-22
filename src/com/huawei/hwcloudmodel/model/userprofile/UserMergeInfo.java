package com.huawei.hwcloudmodel.model.userprofile;

public class UserMergeInfo {
    private String originalHuid;
    private Integer status;

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer num) {
        this.status = num;
    }

    public String getOriginalHuid() {
        return this.originalHuid;
    }

    public void setOriginalHuid(String str) {
        this.originalHuid = str;
    }

    public String toString() {
        return "UserMergeInfo{originalHuid = " + this.originalHuid + ",status = " + this.status + "}";
    }
}
