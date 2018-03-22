package com.huawei.hwcloudmodel.model.userprofile;

public class AddPrivacyRecordReq {
    private String description;
    private Integer opinion;
    private Integer privacyId;

    public Integer getPrivacyId() {
        return this.privacyId;
    }

    public void setPrivacyId(Integer num) {
        this.privacyId = num;
    }

    public Integer getOpinion() {
        return this.opinion;
    }

    public void setOpinion(Integer num) {
        this.opinion = num;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String toString() {
        return "AddPrivacyRecordReq{privacyId=" + this.privacyId + ", opinion=" + this.opinion + ", description='" + this.description + '\'' + '}';
    }
}
