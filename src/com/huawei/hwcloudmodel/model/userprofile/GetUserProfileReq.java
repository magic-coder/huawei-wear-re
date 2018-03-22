package com.huawei.hwcloudmodel.model.userprofile;

import java.util.List;

public class GetUserProfileReq {
    private List<String> customDefine;
    private List<Integer> profileType;

    public List<Integer> getProfileType() {
        return this.profileType;
    }

    public void setProfileType(List<Integer> list) {
        this.profileType = list;
    }

    public List<String> getCustomDefine() {
        return this.customDefine;
    }

    public void setCustomDefine(List<String> list) {
        this.customDefine = list;
    }

    public String toString() {
        return "GetUserProfileReq{profileType=" + this.profileType + ", customDefine=" + this.customDefine + '}';
    }
}
