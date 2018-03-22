package com.huawei.hwcloudmodel.model.userprofile;

public class GetPrivacyRecordReq {
    private Integer privacyId;
    private Integer recordCount;

    public Integer getPrivacyId() {
        return this.privacyId;
    }

    public void setPrivacyId(Integer num) {
        this.privacyId = num;
    }

    public Integer getRecordCount() {
        return this.recordCount;
    }

    public void setRecordCount(Integer num) {
        this.recordCount = num;
    }

    public String toString() {
        return "GetPrivacyRecordReq{privacyId=" + this.privacyId + ", recordCount=" + this.recordCount + '}';
    }
}
