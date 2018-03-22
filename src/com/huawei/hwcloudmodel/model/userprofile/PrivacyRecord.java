package com.huawei.hwcloudmodel.model.userprofile;

public class PrivacyRecord {
    private Integer appType;
    private String description;
    private Integer opinion;
    private Integer privacyId;
    private Long timestamp;

    public Integer getAppType() {
        return this.appType;
    }

    public void setAppType(Integer num) {
        this.appType = num;
    }

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

    public Long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Long l) {
        this.timestamp = l;
    }

    public String toString() {
        return "PrivacyRecord{appType=" + this.appType + ", privacyId=" + this.privacyId + ", opinion=" + this.opinion + ", description='" + this.description + '\'' + ", timestamp=" + this.timestamp + '}';
    }
}
