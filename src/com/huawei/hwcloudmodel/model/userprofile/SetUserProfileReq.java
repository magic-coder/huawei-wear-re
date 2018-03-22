package com.huawei.hwcloudmodel.model.userprofile;

import java.util.List;
import java.util.Map;

public class SetUserProfileReq {
    private UserBasicInfo basic;
    private Map<String, String> customDefine;
    private List<UserGoalsInfo> goals;
    private UserSleepCycleInfo sleepCycle;

    public UserBasicInfo getBasic() {
        return this.basic;
    }

    public void setBasic(UserBasicInfo userBasicInfo) {
        this.basic = userBasicInfo;
    }

    public List<UserGoalsInfo> getGoals() {
        return this.goals;
    }

    public void setGoals(List<UserGoalsInfo> list) {
        this.goals = list;
    }

    public UserSleepCycleInfo getSleepCycle() {
        return this.sleepCycle;
    }

    public void setSleepCycle(UserSleepCycleInfo userSleepCycleInfo) {
        this.sleepCycle = userSleepCycleInfo;
    }

    public Map<String, String> getCustomDefine() {
        return this.customDefine;
    }

    public void setCustomDefine(Map<String, String> map) {
        this.customDefine = map;
    }

    public String toString() {
        return "SetUserProfileReq{basic=" + this.basic + ", goals=" + this.goals + ", sleepCycle=" + this.sleepCycle + ", customDefine=" + this.customDefine + '}';
    }
}
