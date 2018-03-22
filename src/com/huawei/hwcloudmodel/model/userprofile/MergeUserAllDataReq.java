package com.huawei.hwcloudmodel.model.userprofile;

public class MergeUserAllDataReq {
    private String originalHuid;
    private String originalST;

    public String getOriginalHuid() {
        return this.originalHuid;
    }

    public void setOriginalHuid(String str) {
        this.originalHuid = str;
    }

    public String getOriginalST() {
        return this.originalST;
    }

    public void setOriginalST(String str) {
        this.originalST = str;
    }

    public String toString() {
        return "MergeUserAllDataReq{originalHuid=" + this.originalHuid + ", originalST=" + this.originalST + '}';
    }
}
