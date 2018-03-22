package com.huawei.pluginmessagecenter.provider.data;

import android.text.TextUtils;
import com.huawei.pluginmessagecenter.a.b;
import java.util.Date;

public class MessageObject {
    private static final int INVALID_VALUE = -1;
    private static final int VALID_VALUE = 0;
    long createTime = 0;
    String detailUri = "";
    String detailUriExt = "";
    long expireTime = b.a(new Date(System.currentTimeMillis()), 1);
    int flag = 0;
    String huid = "";
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
    int notified = 0;
    int position = 1;
    int readFlag;
    long receiveTime = 0;
    String type = "";
    int weight = 0;

    public String getMsgId() {
        return this.msgId;
    }

    public void setMsgId(String str) {
        this.msgId = str;
    }

    public void setModule(String str) {
        this.module = str;
    }

    public String getModule() {
        return this.module;
    }

    public String getType() {
        return this.type;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public String getMetadata() {
        return this.metadata;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setMetadata(String str) {
        this.metadata = str;
    }

    public void setMsgType(int i) {
        this.msgType = i;
    }

    public void setFlag(int i) {
        this.flag = i;
    }

    public int getFlag() {
        return this.flag;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int i) {
        this.weight = i;
    }

    public String getMsgTitle() {
        return this.msgTitle;
    }

    public void setMsgTitle(String str) {
        this.msgTitle = str;
    }

    public void setMsgContent(String str) {
        this.msgContent = str;
    }

    public String getMsgContent() {
        return this.msgContent;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
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

    public void setDetailUriExt(String str) {
        this.detailUriExt = str;
    }

    public String getDetailUriExt() {
        return this.detailUriExt;
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

    public void setHuid(String str) {
        this.huid = str;
    }

    public String getHuid() {
        return this.huid;
    }

    public String getImei() {
        return this.imei;
    }

    public void setImei(String str) {
        this.imei = str;
    }

    public int getReadFlag() {
        return this.readFlag;
    }

    public void setReadFlag(int i) {
        this.readFlag = i;
    }

    public int getNotified() {
        return this.notified;
    }

    public void setNotified(int i) {
        this.notified = i;
    }

    public long getReceiveTime() {
        return this.receiveTime;
    }

    public void setReceiveTime(long j) {
        this.receiveTime = j;
    }

    public String toString() {
        return "MessageObject{msgId='" + this.msgId + '\'' + ", module='" + this.module + '\'' + ", type='" + this.type + '\'' + ", metadata='" + this.metadata + '\'' + ", msgType=" + this.msgType + ", flag=" + this.flag + ", weight=" + this.weight + ", msgTitle='" + this.msgTitle + '\'' + ", msgContent='" + this.msgContent + '\'' + ", createTime=" + this.createTime + ", receiveTime=" + this.receiveTime + ", expireTime=" + this.expireTime + ", imgUri='" + this.imgUri + '\'' + ", detailUri='" + this.detailUri + '\'' + ", detailUriExt='" + this.detailUriExt + '\'' + ", msgFrom='" + this.msgFrom + '\'' + ", position=" + this.position + ", huid='" + this.huid + '\'' + ", imei='" + this.imei + '\'' + ", readFlag=" + this.readFlag + ", notified=" + this.notified + '}';
    }

    public boolean isShowMessage() {
        if (getPosition() == 1 || getPosition() == 3) {
            return true;
        }
        return false;
    }

    public boolean checkoutExpireMessage() {
        if (getExpireTime() < System.currentTimeMillis()) {
            return true;
        }
        return false;
    }

    public int checkCompleteMessage() {
        if (TextUtils.isEmpty(getMsgId()) || TextUtils.isEmpty(getMsgTitle()) || getCreateTime() < 0 || getExpireTime() < 0 || getPosition() == 0) {
            return -1;
        }
        return 0;
    }

    public boolean isMessageCenterMessage() {
        if ((getPosition() == 1 || getPosition() == 3) && (getMsgPosition() == 11 || getMsgPosition() == 0)) {
            return true;
        }
        return false;
    }

    public boolean isAdvertisementBannerMessage() {
        if ((getPosition() == 1 || getPosition() == 3) && getMsgPosition() == 12) {
            return true;
        }
        return false;
    }

    public boolean isActivityCardMessage() {
        if ((getPosition() == 1 || getPosition() == 3) && getMsgPosition() == 14) {
            return true;
        }
        return false;
    }

    public boolean isWearDeviceBannerMessage() {
        if ((getPosition() == 1 || getPosition() == 3) && getMsgPosition() == 13) {
            return true;
        }
        return false;
    }

    public boolean isHealthDeviceBannerMessage() {
        if ((getPosition() == 1 || getPosition() == 3) && getMsgPosition() == 24) {
            return true;
        }
        return false;
    }

    public boolean isNotificationMessage() {
        if (getPosition() == 2 || getPosition() == 3) {
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

    public void resetMsgInfo() {
        setMetadata("");
        setMsgTitle("");
        setMsgContent("");
    }

    public void resetMsgTime() {
        setExpireTime(0);
        setCreateTime(0);
    }

    public void resetMsgUrl() {
        setDetailUri("");
        setDetailUriExt("");
        setImgUri("");
    }
}
