package com.huawei.crowdtestsdk.bases;

import com.google.gson.Gson;

public class UploadItem {
    private String apkVer;
    private String creatorId;
    private int currentEvent;
    private long endTimeValue;
    private String fileName;
    private int netTransType;
    private long startTimeValue;
    private int statusType;
    private long totalSize;

    public void setStatusType(int i) {
        this.statusType = i;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setCurrentEvent(int i) {
        this.currentEvent = i;
    }

    public void setTotalSize(long j) {
        this.totalSize = j;
    }

    public void setStartTimeValue(long j) {
        this.startTimeValue = j;
    }

    public void setEndTimeValue(long j) {
        this.endTimeValue = j;
    }

    public void setNetTransType(int i) {
        this.netTransType = i;
    }

    public void setApkVer(String str) {
        this.apkVer = str;
    }

    public void setCreatorId(String str) {
        this.creatorId = str;
    }

    public String toString() {
        return "UploadItem{statusType=" + this.statusType + ", fileName='" + this.fileName + '\'' + ", currentEvent=" + this.currentEvent + ", totalSize=" + this.totalSize + ", startTimeValue=" + this.startTimeValue + ", endTimeValue=" + this.endTimeValue + ", netTransType=" + this.netTransType + ", apkVer='" + this.apkVer + '\'' + ", creatorId='" + this.creatorId + '\'' + '}';
    }

    public String toJsonString() {
        return new Gson().toJson((Object) this);
    }
}
