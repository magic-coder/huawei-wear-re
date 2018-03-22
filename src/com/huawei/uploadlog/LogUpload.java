package com.huawei.uploadlog;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class LogUpload implements Parcelable {
    public static final Creator<LogUpload> CREATOR = new C2521d();
    private String accessToken;
    private String callbackAddress;
    private int channelId;
    private String contentRange;
    private boolean encrypt;
    private String encryptedFile;
    private String feedBackClassName;
    private String feedBackPackageName;
    private String filePath;
    private int flags;
    private long id;
    private String logDetailInfo;
    private String md5String;
    private boolean paused;
    private String policy;
    private boolean privacy;
    private String productName;
    private boolean reconnect;
    private boolean refresh;
    private String romVersion;
    private String secret;
    private boolean setTime;
    private String sign;
    private long size;
    private long startTime;
    private int status;
    private long taskId;
    private int timeAuthOverTime;
    private int timeReconnect;
    private String timeStamp;
    private int timeout;
    private int type;
    private String uploadAddress;
    private String uploadPath;
    private int userType;
    private boolean visible;
    private String zipTime;

    public LogUpload() {
        this.setTime = false;
        this.timeReconnect = 0;
        this.timeAuthOverTime = 0;
        this.paused = false;
        this.md5String = null;
    }

    private LogUpload(Parcel parcel) {
        this.setTime = false;
        this.timeReconnect = 0;
        this.timeAuthOverTime = 0;
        this.paused = false;
        this.md5String = null;
        readFromParcel(parcel);
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String str) {
        this.productName = str;
    }

    public String getRomVersion() {
        return this.romVersion;
    }

    public void setRomVersion(String str) {
        this.romVersion = str;
    }

    public String getSign() {
        return this.sign;
    }

    public void setSign(String str) {
        this.sign = str;
    }

    public boolean isPaused() {
        return this.paused;
    }

    public void setPaused(boolean z) {
        this.paused = z;
    }

    public String getZipTime() {
        return this.zipTime;
    }

    public void setZipTime(String str) {
        this.zipTime = str;
    }

    public String getLogDetailInfo() {
        return this.logDetailInfo;
    }

    public void setLogDetailInfo(String str) {
        this.logDetailInfo = str;
    }

    public long getTaskId() {
        return this.taskId;
    }

    public void setTaskId(long j) {
        this.taskId = j;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public void setVisible(boolean z) {
        this.visible = z;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long j) {
        this.id = j;
    }

    public long getSize() {
        return this.size;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public boolean isEncrypt() {
        return this.encrypt;
    }

    public void setEncrypt(boolean z) {
        this.encrypt = z;
    }

    public int getFlags() {
        return this.flags;
    }

    public void setFlags(int i) {
        this.flags = i;
    }

    public String getPolicy() {
        return this.policy;
    }

    public void setPolicy(String str) {
        this.policy = str;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public String getSecret() {
        return this.secret;
    }

    public void setSecret(String str) {
        this.secret = str;
    }

    public String getUploadPath() {
        return this.uploadPath;
    }

    public void setUploadPath(String str) {
        this.uploadPath = str;
    }

    public boolean isPrivacy() {
        return this.privacy;
    }

    public void setPrivacy(boolean z) {
        this.privacy = z;
    }

    public String getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(String str) {
        this.timeStamp = str;
    }

    public String getCallbackAddress() {
        return this.callbackAddress;
    }

    public void setCallbackAddress(String str) {
        this.callbackAddress = str;
    }

    public String getUploadAddress() {
        return this.uploadAddress;
    }

    public void setUploadAddress(String str) {
        this.uploadAddress = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String getContentRange() {
        return this.contentRange;
    }

    public void setContentRange(String str) {
        this.contentRange = str;
    }

    public boolean isRefresh() {
        return this.refresh;
    }

    public void setRefresh(boolean z) {
        this.refresh = z;
    }

    public String getEncryptedFile() {
        return this.encryptedFile;
    }

    public void setEncryptedFile(String str) {
        this.encryptedFile = str;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public void setTimeout(int i) {
        this.timeout = i;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public void setStartTime(long j) {
        this.startTime = j;
    }

    public int getChannelId() {
        return this.channelId;
    }

    public void setChannelId(int i) {
        this.channelId = i;
    }

    public boolean isSetTime() {
        return this.setTime;
    }

    public void setSetTime(boolean z) {
        this.setTime = z;
    }

    public String getFeedBackPackageName() {
        return this.feedBackPackageName;
    }

    public void setFeedBackPackageName(String str) {
        this.feedBackPackageName = str;
    }

    public String getFeedBackClassName() {
        return this.feedBackClassName;
    }

    public void setFeedBackClassName(String str) {
        this.feedBackClassName = str;
    }

    public boolean isReconnect() {
        return this.reconnect;
    }

    public void setReconnect(boolean z) {
        this.reconnect = z;
    }

    public int getUserType() {
        return this.userType;
    }

    public void setUserType(int i) {
        this.userType = i;
    }

    public int getTimeReconnect() {
        return this.timeReconnect;
    }

    public void setTimeReconnect(int i) {
        this.timeReconnect = i;
    }

    public int getTimeAuthOverTime() {
        return this.timeAuthOverTime;
    }

    public void setTimeAuthOverTime(int i) {
        this.timeAuthOverTime = i;
    }

    public String getMd5String() {
        return this.md5String;
    }

    public String setMd5String(String str) {
        this.md5String = str;
        return str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeByte((byte) (this.visible ? 1 : 0));
        parcel.writeString(this.filePath);
        parcel.writeString(this.encryptedFile);
        parcel.writeLong(this.id);
        parcel.writeLong(this.size);
        if (this.encrypt) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (this.privacy) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeInt(this.flags);
        parcel.writeInt(this.channelId);
        parcel.writeString(this.feedBackPackageName);
        parcel.writeString(this.feedBackClassName);
        if (this.refresh) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeString(this.policy);
        parcel.writeString(this.accessToken);
        parcel.writeString(this.secret);
        parcel.writeString(this.uploadPath);
        parcel.writeString(this.timeStamp);
        parcel.writeString(this.callbackAddress);
        parcel.writeString(this.uploadAddress);
        parcel.writeInt(this.type);
        parcel.writeInt(this.status);
        parcel.writeString(this.contentRange);
        parcel.writeInt(this.timeout);
        parcel.writeLong(this.taskId);
        parcel.writeByte((byte) (this.reconnect ? 1 : 0));
        parcel.writeLong(this.startTime);
        if (this.setTime) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeInt(this.userType);
        parcel.writeInt(this.timeReconnect);
        parcel.writeInt(this.timeAuthOverTime);
        parcel.writeString(this.productName);
        parcel.writeString(this.romVersion);
        parcel.writeString(this.sign);
        parcel.writeString(this.zipTime);
        parcel.writeString(this.logDetailInfo);
        if (!this.paused) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
    }

    public void readFromParcel(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.visible = parcel.readByte() != (byte) 0;
        this.filePath = parcel.readString();
        this.encryptedFile = parcel.readString();
        this.id = parcel.readLong();
        this.size = parcel.readLong();
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.encrypt = z;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.privacy = z;
        this.flags = parcel.readInt();
        this.channelId = parcel.readInt();
        this.feedBackPackageName = parcel.readString();
        this.feedBackClassName = parcel.readString();
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.refresh = z;
        this.policy = parcel.readString();
        this.accessToken = parcel.readString();
        this.secret = parcel.readString();
        this.uploadPath = parcel.readString();
        this.timeStamp = parcel.readString();
        this.callbackAddress = parcel.readString();
        this.uploadAddress = parcel.readString();
        this.type = parcel.readInt();
        this.status = parcel.readInt();
        this.contentRange = parcel.readString();
        this.timeout = parcel.readInt();
        this.taskId = parcel.readLong();
        this.reconnect = parcel.readByte() != (byte) 0;
        this.startTime = parcel.readLong();
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.setTime = z;
        this.userType = parcel.readInt();
        this.timeReconnect = parcel.readInt();
        this.timeAuthOverTime = parcel.readInt();
        this.productName = parcel.readString();
        this.romVersion = parcel.readString();
        this.sign = parcel.readString();
        this.zipTime = parcel.readString();
        this.logDetailInfo = parcel.readString();
        if (parcel.readByte() == (byte) 0) {
            z2 = false;
        }
        this.paused = z2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("LogUpload [");
        stringBuffer.append("visible=").append(this.visible).append(", ");
        stringBuffer.append("filePath=").append(this.filePath).append(", ");
        stringBuffer.append("encryptedFile=").append(this.encryptedFile).append(", ");
        stringBuffer.append("id=").append(this.id).append(", ");
        stringBuffer.append("size=").append(this.size).append(", ");
        stringBuffer.append("encrypt=").append(this.encrypt).append(", ");
        stringBuffer.append("privacy=").append(this.privacy).append(", ");
        stringBuffer.append("flags=").append(this.flags).append(", ");
        stringBuffer.append("channelId=").append(this.channelId).append(", ");
        stringBuffer.append("feedBackPackageName=").append(this.feedBackPackageName).append(", ");
        stringBuffer.append("feedBackClassName=").append(this.feedBackClassName).append(", ");
        stringBuffer.append("refresh=").append(this.refresh).append(", ");
        stringBuffer.append("policy=").append(this.policy).append(", ");
        stringBuffer.append("accessToken=").append(this.accessToken).append(", ");
        stringBuffer.append("secret=").append(this.secret).append(", ");
        stringBuffer.append("uploadPath=").append(this.uploadPath).append(", ");
        stringBuffer.append("timestamp=").append(this.timeStamp).append(", ");
        stringBuffer.append("callbackAddress=").append(this.callbackAddress).append(", ");
        stringBuffer.append("uploadAddress=").append(this.uploadAddress).append(", ");
        stringBuffer.append("type=").append(this.type).append(", ");
        stringBuffer.append("status=").append(this.status).append(", ");
        stringBuffer.append("contentRange=").append(this.contentRange).append(", ");
        stringBuffer.append("timeout=").append(this.timeout).append(", ");
        stringBuffer.append("taskId=").append(this.taskId).append(", ");
        stringBuffer.append("reconnect=").append(this.reconnect).append(", ");
        stringBuffer.append("startTime=").append(this.startTime).append(", ");
        stringBuffer.append("setTime=").append(this.setTime).append(", ");
        stringBuffer.append("userType=").append(this.userType).append(", ");
        stringBuffer.append("timeReconnect=").append(this.timeReconnect).append(", ");
        stringBuffer.append("timeAuthOverTime=").append(this.timeAuthOverTime).append(", ");
        stringBuffer.append("productName=").append(this.productName).append(", ");
        stringBuffer.append("romVersion=").append(this.romVersion).append(", ");
        stringBuffer.append("sign=").append(this.sign).append(", ");
        stringBuffer.append("zipTime=").append(this.zipTime).append(", ");
        stringBuffer.append("logDetailInfo=").append(this.logDetailInfo).append(", ");
        stringBuffer.append("paused=").append(this.paused).append("]");
        return stringBuffer.toString();
    }
}
