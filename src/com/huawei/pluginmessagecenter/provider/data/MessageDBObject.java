package com.huawei.pluginmessagecenter.provider.data;

public class MessageDBObject {
    long createTime;
    String detailUri = "";
    String detailUriExt = "";
    long expireTime;
    int flag;
    String huid = "";
    int id;
    String imei = "";
    String imgUri = "";
    String metadata = "";
    String module = "";
    String msgContent = "";
    String msgFrom = "";
    String msgId = "";
    int msgPosition = 0;
    String msgTitle = "";
    int msgType = 1;
    int notified;
    int position = 1;
    int readFlag;
    long receiveTime;
    String type = "";
    int weight;

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public void setMsgId(String str) {
        this.msgId = str;
    }

    public String getModule() {
        return this.module;
    }

    public void setModule(String str) {
        this.module = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getMetadata() {
        return this.metadata;
    }

    public void setMetadata(String str) {
        this.metadata = str;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public void setMsgType(int i) {
        this.msgType = i;
    }

    public int getFlag() {
        return this.flag;
    }

    public void setFlag(int i) {
        this.flag = i;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int i) {
        this.weight = i;
    }

    public int getReadFlag() {
        return this.readFlag;
    }

    public void setReadFlag(int i) {
        this.readFlag = i;
    }

    public String getMsgTitle() {
        return this.msgTitle;
    }

    public void setMsgTitle(String str) {
        this.msgTitle = str;
    }

    public String getMsgContent() {
        return this.msgContent;
    }

    public void setMsgContent(String str) {
        this.msgContent = str;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public long getReceiveTime() {
        return this.receiveTime;
    }

    public void setReceiveTime(long j) {
        this.receiveTime = j;
    }

    public long getExpireTime() {
        return this.expireTime;
    }

    public void setExpireTime(long j) {
        this.expireTime = j;
    }

    public String getImgUri() {
        return this.imgUri;
    }

    public void setImgUri(String str) {
        this.imgUri = str;
    }

    public String getDetailUri() {
        return this.detailUri;
    }

    public void setDetailUri(String str) {
        this.detailUri = str;
    }

    public String getDetailUriExt() {
        return this.detailUriExt;
    }

    public void setDetailUriExt(String str) {
        this.detailUriExt = str;
    }

    public String getMsgFrom() {
        return this.msgFrom;
    }

    public void setMsgFrom(String str) {
        this.msgFrom = str;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int i) {
        this.position = i;
    }

    public int getMsgPosition() {
        return this.msgPosition;
    }

    public void setMsgPosition(int i) {
        this.msgPosition = i;
    }

    public String getHuid() {
        return this.huid;
    }

    public void setHuid(String str) {
        this.huid = str;
    }

    public String getImei() {
        return this.imei;
    }

    public void setImei(String str) {
        this.imei = str;
    }

    public int getNotified() {
        return this.notified;
    }

    public void setNotified(int i) {
        this.notified = i;
    }

    public String toString() {
        return "MessageDBObject{id=" + this.id + ", msgId='" + this.msgId + '\'' + ", module='" + this.module + '\'' + ", type='" + this.type + '\'' + ", metadata='" + this.metadata + '\'' + ", msgType=" + this.msgType + ", flag=" + this.flag + ", weight=" + this.weight + ", readFlag=" + this.readFlag + ", msgTitle='" + this.msgTitle + '\'' + ", msgContent='" + this.msgContent + '\'' + ", createTime=" + this.createTime + ", receiveTime=" + this.receiveTime + ", expireTime=" + this.expireTime + ", imgUri='" + this.imgUri + '\'' + ", detailUri='" + this.detailUri + '\'' + ", detailUriExt='" + this.detailUriExt + '\'' + ", msgFrom='" + this.msgFrom + '\'' + ", position=" + this.position + ", huid='" + this.huid + '\'' + ", imei='" + this.imei + '\'' + ", notified=" + this.notified + '}';
    }
}
