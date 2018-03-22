package com.huawei.pluginmessagecenter.provider.data;

import android.text.TextUtils;

public class CloudMessageObject {
    private static final int INVALID_VALUE = -1;
    private static final int VALID_VALUE = 0;
    long createTime;
    String detailUri;
    String expireTime;
    int flag;
    String from;
    String imgIosBigScreenUri;
    String imgIosSmallScreenUri;
    String imgUri;
    String msgContext;
    String msgDevice;
    String msgId;
    int msgMaterial;
    int msgPosition;
    String msgTitle;
    int msgType;
    String position;
    int readFlag;
    int weight;

    public CloudMessageObject() {
        this.msgPosition = 11;
        this.msgId = "";
        this.msgType = 1;
        this.flag = 0;
        this.weight = 0;
        this.msgTitle = "";
        this.msgContext = "";
        this.createTime = 0;
        this.expireTime = "0";
        this.imgUri = "";
        this.detailUri = "";
        this.from = "";
        this.position = "1";
        this.msgDevice = "";
        this.msgPosition = 11;
        this.msgMaterial = 0;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public String getMsgTitle() {
        return this.msgTitle;
    }

    public String getExpireTime() {
        return this.expireTime;
    }

    public String getMsgContext() {
        return this.msgContext;
    }

    public int getFlag() {
        return this.flag;
    }

    public int getWeight() {
        return this.weight;
    }

    public String getImgUri() {
        return this.imgUri;
    }

    public String getImgIosBigScreenUri() {
        return this.imgIosBigScreenUri;
    }

    public String getImgIosSmallScreenUri() {
        return this.imgIosSmallScreenUri;
    }

    public String getDetailUri() {
        return this.detailUri;
    }

    public String getFrom() {
        return this.from;
    }

    public int getReadFlag() {
        return this.readFlag;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public String getPosition() {
        return this.position;
    }

    public int getMsgPosition() {
        return this.msgPosition;
    }

    public String getMsgDevice() {
        return this.msgDevice;
    }

    public int getMsgMaterial() {
        return this.msgMaterial;
    }

    public void setMsgId(String str) {
        this.msgId = str;
    }

    public void setMsgType(int i) {
        this.msgType = i;
    }

    public void setMsgTitle(String str) {
        this.msgTitle = str;
    }

    public void setExpireTime(String str) {
        this.expireTime = str;
    }

    public void setMsgContext(String str) {
        this.msgContext = str;
    }

    public void setFlag(int i) {
        this.flag = i;
    }

    public void setWeight(int i) {
        this.weight = i;
    }

    public void setImgUri(String str) {
        this.imgUri = str;
    }

    public void setImgIosBigScreenUri(String str) {
        this.imgIosBigScreenUri = str;
    }

    public void setImgIosSmallScreenUri(String str) {
        this.imgIosSmallScreenUri = str;
    }

    public void setDetailUri(String str) {
        this.detailUri = str;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public void setReadFlag(int i) {
        this.readFlag = i;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public void setPosition(String str) {
        this.position = str;
    }

    public void setMsgPosition(int i) {
        this.msgPosition = i;
    }

    public void setMsgDevice(String str) {
        this.msgDevice = str;
    }

    public void setMsgMaterial(int i) {
        this.msgMaterial = i;
    }

    public String toString() {
        return "CloudMessageObject{msgId='" + this.msgId + '\'' + ", msgType=" + this.msgType + ", expireTime='" + this.expireTime + '\'' + ", msgTitle='" + this.msgTitle + '\'' + ", msgContext='" + this.msgContext + '\'' + ", flag=" + this.flag + ", weight=" + this.weight + ", imgUri='" + this.imgUri + '\'' + ", imgIosBigScreenUri='" + this.imgIosBigScreenUri + '\'' + ", imgIosSmallScreenUri='" + this.imgIosSmallScreenUri + '\'' + ", detailUri='" + this.detailUri + '\'' + ", from='" + this.from + '\'' + ", readFlag=" + this.readFlag + ", createTime=" + this.createTime + ", position='" + this.position + '\'' + ", msgDevice='" + this.msgDevice + '\'' + ", msgPosition='" + this.msgPosition + '\'' + ", msgMaterial='" + this.msgMaterial + '\'' + '}';
    }

    public int checkCompleteMessage() {
        if (TextUtils.isEmpty(getMsgId()) || TextUtils.isEmpty(getMsgTitle())) {
            return -1;
        }
        return 0;
    }

    public void resetMsgTime() {
        setExpireTime("0");
        setCreateTime(0);
    }

    public void resetMsgInfo() {
        setMsgTitle("");
    }

    public void resetMsgUrl() {
        setDetailUri("");
        setImgUri("");
    }

    public boolean isHealthDeviceBannerMessage() {
        if (getMsgPosition() == 1 || getMsgPosition() == 3) {
            return true;
        }
        return false;
    }

    public boolean isInfomationTypeMessage() {
        if (getMsgPosition() == 25) {
            return true;
        }
        return false;
    }

    public boolean isAdvertisementBannerMessage() {
        if (getMsgPosition() == 12) {
            return true;
        }
        return false;
    }
}
