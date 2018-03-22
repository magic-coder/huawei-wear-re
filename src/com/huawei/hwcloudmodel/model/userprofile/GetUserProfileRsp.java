package com.huawei.hwcloudmodel.model.userprofile;

import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import java.util.List;
import java.util.Map;

public class GetUserProfileRsp extends CloudCommonReponse {
    private UserBasicInfo basic;
    private Map<String, String> customDefine;
    private List<UserGoalsInfo> goals;
    private UserSleepCycleInfo sleepCycle;

    public List<UserGoalsInfo> getGoals() {
        return this.goals;
    }

    public void setGoals(List<UserGoalsInfo> list) {
        this.goals = list;
    }

    public UserBasicInfo getBasic() {
        return this.basic;
    }

    public void setBasic(UserBasicInfo userBasicInfo) {
        this.basic = userBasicInfo;
    }

    public Map<String, String> getCustomDefine() {
        return this.customDefine;
    }

    public void setCustomDefine(Map<String, String> map) {
        this.customDefine = map;
    }

    public UserSleepCycleInfo getSleepCycle() {
        return this.sleepCycle;
    }

    public void setSleepCycle(UserSleepCycleInfo userSleepCycleInfo) {
        this.sleepCycle = userSleepCycleInfo;
    }

    public String toString() {
        return "GetUserProfileRsp{basic=" + this.basic + ", goals=" + this.goals + ", sleepCycle=" + this.sleepCycle + ", customDefine=" + this.customDefine + '}';
    }
}
