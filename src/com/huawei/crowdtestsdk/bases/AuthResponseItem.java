package com.huawei.crowdtestsdk.bases;

public class AuthResponseItem {
    private long createTime;
    private long expiredTime;
    private int resCode;

    public long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public long getExpiredTime() {
        return this.expiredTime;
    }

    public void setExpiredTime(long j) {
        this.expiredTime = j;
    }

    public int getResCode() {
        return this.resCode;
    }

    public void setResCode(int i) {
        this.resCode = i;
    }
}
