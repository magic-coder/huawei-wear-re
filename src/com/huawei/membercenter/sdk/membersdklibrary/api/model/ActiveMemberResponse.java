package com.huawei.membercenter.sdk.membersdklibrary.api.model;

import android.os.Parcel;

public class ActiveMemberResponse {
    private String endDate;
    private int gradeId;
    private int growthValue;
    private String leaguerId;
    private String startDate;

    protected ActiveMemberResponse(Parcel parcel) {
        this.leaguerId = parcel.readString();
        this.growthValue = parcel.readInt();
        this.gradeId = parcel.readInt();
        this.startDate = parcel.readString();
        this.endDate = parcel.readString();
    }

    public String getLeaguerId() {
        return this.leaguerId;
    }

    public void setLeaguerId(String str) {
        this.leaguerId = str;
    }

    public int getGrowthValue() {
        return this.growthValue;
    }

    public void setGrowthValue(int i) {
        this.growthValue = i;
    }

    public int getGradeId() {
        return this.gradeId;
    }

    public void setGradeId(int i) {
        this.gradeId = i;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String str) {
        this.startDate = str;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public void setEndDate(String str) {
        this.endDate = str;
    }
}
