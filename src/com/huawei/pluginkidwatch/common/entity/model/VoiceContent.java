package com.huawei.pluginkidwatch.common.entity.model;

public class VoiceContent {
    public long createTime = 0;
    public String fromId = "";
    public String fromName = "";
    public int groupId = 0;
    public String headUrl = "";
    public String iv = "";
    public String key = "";
    public int messageType = -1;
    public long serverTime = 0;
    public String text = "";
    public String url = "";

    public String toString() {
        return "VoiceContent{fromId='" + this.fromId + '\'' + ", fromName='" + this.fromName + '\'' + ", headUrl='" + this.headUrl + '\'' + ", groupId=" + this.groupId + ", messageType=" + this.messageType + ", createTime=" + this.createTime + ", serverTime=" + this.serverTime + ", url='" + this.url + '\'' + ", text='" + this.text + '\'' + ", key='" + this.key + '\'' + ", iv='" + this.iv + '\'' + '}';
    }

    public void queryVoiceFromSource() {
    }

    public void deleteSpeVoiceInfo() {
    }

    public void createDownloadUrl() {
    }

    public void instertVoiceContentIV() {
    }

    public void instertVoiceContentKey() {
    }

    public void processSeviceVoiceInfoByTime() {
    }

    public void addSeviceCreateTiem() {
    }

    public void setHeadUrlFromUser() {
    }
}
