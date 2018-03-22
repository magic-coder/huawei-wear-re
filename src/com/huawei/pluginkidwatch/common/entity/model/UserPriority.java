package com.huawei.pluginkidwatch.common.entity.model;

import java.io.Serializable;

public class UserPriority implements Serializable {
    private static final long serialVersionUID = -8429246251287724528L;
    public String huid;
    public int id = -1;
    public String priority;

    public String getHuid() {
        return this.huid;
    }

    public void setHuid(String str) {
        this.huid = str;
    }

    public String getPriority() {
        return this.priority;
    }

    public void setPriority(String str) {
        this.priority = str;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public String toString() {
        return "UserPriority{huid='" + this.huid + '\'' + ", priority='" + this.priority + '\'' + ", id=" + this.id + '}';
    }

    public void getUserPriorityName() {
    }

    public void requestUserPriorityHeadUrl() {
    }

    public void downloadUserPriorityNameUrl() {
    }

    public void judgeUserPriorityWeightBySomeInfo() {
    }

    public void setUserPrioritySwitchUpload() {
    }

    public void updataUserPriorityLocalTable() {
    }

    public void dealWithUserPriorityResetFactory() {
    }

    public void refreshUserPriorityInitData() {
    }

    public void queryUserPriorityProcessData() {
    }

    public void contrustUserPriorityHeadImage() {
    }

    public void changeUserPriorityDeviceInfo() {
    }
}
