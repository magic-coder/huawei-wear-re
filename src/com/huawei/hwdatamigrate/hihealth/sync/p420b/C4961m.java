package com.huawei.hwdatamigrate.hihealth.sync.p420b;

import com.huawei.hihealth.HiGoalInfo;
import com.huawei.hihealth.HiUserInfo;
import com.huawei.hihealth.HiUserPreference;
import com.huawei.hihealth.data.p396c.C4555b;
import com.huawei.hwcloudmodel.model.userprofile.UserBasicInfo;
import com.huawei.hwcloudmodel.model.userprofile.UserGoalsInfo;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: UserInfoSwitch */
public class C4961m {
    public UserBasicInfo m23872a(HiUserInfo hiUserInfo) {
        if (hiUserInfo == null) {
            return null;
        }
        UserBasicInfo userBasicInfo = new UserBasicInfo();
        userBasicInfo.setBirthday(Integer.valueOf(hiUserInfo.getBirthday()));
        userBasicInfo.setEmail(hiUserInfo.getEmail());
        userBasicInfo.setGender(Integer.valueOf(hiUserInfo.getGender()));
        userBasicInfo.setHeight(Integer.valueOf(hiUserInfo.getHeight()));
        userBasicInfo.setMobile(hiUserInfo.getMobile());
        userBasicInfo.setName(hiUserInfo.getName());
        userBasicInfo.setPortraitUrl(hiUserInfo.getHeadImgUrl());
        userBasicInfo.setWeight(Integer.valueOf((int) hiUserInfo.getWeight()));
        userBasicInfo.setUnitType(Integer.valueOf(hiUserInfo.getUnitType()));
        userBasicInfo.setModifyTime(Long.valueOf(hiUserInfo.getCreateTime()));
        return userBasicInfo;
    }

    public HiUserInfo m23871a(UserBasicInfo userBasicInfo) {
        if (userBasicInfo == null) {
            return null;
        }
        HiUserInfo hiUserInfo = new HiUserInfo();
        hiUserInfo.setBirthday(userBasicInfo.getBirthday().intValue());
        hiUserInfo.setEmail(userBasicInfo.getEmail());
        hiUserInfo.setGender(userBasicInfo.getGender().intValue());
        hiUserInfo.setHeight(userBasicInfo.getHeight().intValue());
        hiUserInfo.setMobile(userBasicInfo.getMobile());
        hiUserInfo.setName(userBasicInfo.getName());
        hiUserInfo.setHeadImgUrl(userBasicInfo.getPortraitUrl());
        hiUserInfo.setWeight((float) userBasicInfo.getWeight().intValue());
        hiUserInfo.setUnitType(userBasicInfo.getUnitType().intValue());
        Long modifyTime = userBasicInfo.getModifyTime();
        if (modifyTime == null || modifyTime.longValue() <= 0) {
            C2538c.c("HiH_UserInfoSwitch", new Object[]{"switchUserBasicInfo old cloud modifyTime , it is ", modifyTime});
            modifyTime = Long.valueOf(System.currentTimeMillis());
        }
        hiUserInfo.setCreateTime(modifyTime.longValue());
        return hiUserInfo;
    }

    private HiGoalInfo m23868a(UserGoalsInfo userGoalsInfo) {
        if (userGoalsInfo == null) {
            return null;
        }
        HiGoalInfo hiGoalInfo = new HiGoalInfo();
        int a = C4555b.m21805a(userGoalsInfo.getGoalType().intValue(), userGoalsInfo.getGoalPeriod().intValue());
        if (a <= 0) {
            C2538c.d("HiH_UserInfoSwitch", new Object[]{"switchUserGoalsInfo no such local goal type"});
            return null;
        }
        hiGoalInfo.setGoalType(a);
        hiGoalInfo.setGoalValue(Double.parseDouble(userGoalsInfo.getGoalValue()));
        return hiGoalInfo;
    }

    public List<HiGoalInfo> m23873a(List<UserGoalsInfo> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<HiGoalInfo> arrayList = new ArrayList();
        for (UserGoalsInfo userGoalsInfo : list) {
            C2538c.c("HiH_UserInfoSwitch", new Object[]{"switchUserGoalsInfos userGoalInfo is ", userGoalsInfo});
            HiGoalInfo a = m23868a(userGoalsInfo);
            if (a != null) {
                arrayList.add(a);
            }
        }
        return arrayList;
    }

    private UserGoalsInfo m23869a(HiGoalInfo hiGoalInfo) {
        if (hiGoalInfo == null || !m23870a(hiGoalInfo.getGoalType())) {
            return null;
        }
        UserGoalsInfo userGoalsInfo = new UserGoalsInfo();
        int a = C4555b.m21804a(hiGoalInfo.getGoalType());
        if (a <= 0) {
            C2538c.d("HiH_UserInfoSwitch", new Object[]{"switchHiGoalInfo no such goalPeriod, goalPeriod is ", Integer.valueOf(a)});
            return null;
        }
        int b = C4555b.m21806b(hiGoalInfo.getGoalType(), a);
        if (b <= 0) {
            C2538c.d("HiH_UserInfoSwitch", new Object[]{"switchHiGoalInfo no such cloudGoalType,cloudGoalType is ", Integer.valueOf(b)});
            return null;
        }
        userGoalsInfo.setGoalPeriod(Integer.valueOf(a));
        userGoalsInfo.setGoalType(Integer.valueOf(b));
        userGoalsInfo.setGoalValue(Double.toString(hiGoalInfo.getGoalValue()));
        return userGoalsInfo;
    }

    public List<UserGoalsInfo> m23875b(List<HiGoalInfo> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<UserGoalsInfo> arrayList = new ArrayList();
        for (HiGoalInfo a : list) {
            UserGoalsInfo a2 = m23869a(a);
            C2538c.c("HiH_UserInfoSwitch", new Object[]{"switchHiGoalInfos userGoalInfo is ", a2});
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    public Map<String, String> m23876c(List<HiUserPreference> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Map<String, String> hashMap = new HashMap();
        for (HiUserPreference hiUserPreference : list) {
            hashMap.put(hiUserPreference.getKey(), hiUserPreference.getValue());
        }
        return hashMap;
    }

    public List<HiUserPreference> m23874a(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        List<HiUserPreference> arrayList = new ArrayList();
        for (Entry entry : map.entrySet()) {
            HiUserPreference hiUserPreference = new HiUserPreference();
            hiUserPreference.setKey((String) entry.getKey());
            hiUserPreference.setValue((String) entry.getValue());
            hiUserPreference.setSyncStatus(1);
            arrayList.add(hiUserPreference);
        }
        return arrayList;
    }

    private boolean m23870a(int i) {
        if (i >= 1 && i <= 46) {
            return true;
        }
        C2538c.b("HiH_UserInfoSwitch", new Object[]{"no such goalType, goalType is ", Integer.valueOf(i)});
        return false;
    }
}
