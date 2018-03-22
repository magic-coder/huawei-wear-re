package com.huawei.ab;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcloudmodel.model.userprofile.AddPrivacyRecordReq;
import com.huawei.hwcloudmodel.model.userprofile.DeleteUserProfileReq;
import com.huawei.hwcloudmodel.model.userprofile.GetPrivacyRecordReq;
import com.huawei.hwcloudmodel.p061c.C4689d;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwdataaccessmodel.sharedpreference.a;
import com.huawei.p190v.C2538c;
import com.huawei.up.model.UserInfomation;
import com.huawei.up.p404b.C4694a;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: UserProfileUtil */
public class C3978v {
    private static final String[] f15217a = new String[]{"", "true", "", "", "true", "true"};
    private static ExecutorService f15218b;
    private static final Object f15219c = new Object();
    private static UserInfomation f15220d = new UserInfomation();

    static UserInfomation m19694a() {
        UserInfomation userInfomation;
        C2538c.c("UserProfileUtil", new Object[]{"enter getUserInfo"});
        synchronized (f15219c) {
            userInfomation = (UserInfomation) new Gson().fromJson(C3978v.m19708c(UserInfomation.KEY_USER_INFO), UserInfomation.class);
            if (userInfomation != null) {
                C2538c.c("UserProfileUtil", new Object[]{" getUserInfo  userInfo=" + userInfomation});
            } else {
                userInfomation = new UserInfomation();
                C2538c.c("UserProfileUtil", new Object[]{" getUserInfo  userInfo=null"});
            }
        }
        return userInfomation;
    }

    static void m19697a(IBaseResponseCallback iBaseResponseCallback) {
        f15220d = C3978v.m19694a();
        iBaseResponseCallback.onResponse(0, f15220d);
    }

    static void m19699a(UserInfomation userInfomation) {
        C2538c.c("UserProfileUtil", new Object[]{" saveLocalUserInfo=" + userInfomation});
        synchronized (f15219c) {
            C3978v.m19702b(UserInfomation.KEY_USER_INFO, new Gson().toJson(userInfomation, UserInfomation.class), new com.huawei.hwdataaccessmodel.a.c(2));
        }
    }

    static void m19706b(UserInfomation userInfomation) {
        UserInfomation a = C3978v.m19694a();
        C2538c.c("UserProfileUtil", new Object[]{" saveUserInfo Entry user = " + userInfomation});
        if (userInfomation.getName() != null) {
            a.setName(userInfomation.getName());
        }
        if (userInfomation.getPortraitUrl() == null) {
            C2538c.c("UserProfileUtil", new Object[]{" saveUserInfo getPortraitUrl = null"});
        } else {
            a.setPortraitUrl(userInfomation.getPortraitUrl());
        }
        if (!TextUtils.isEmpty(userInfomation.getPicPath())) {
            a.setPicPath(userInfomation.getPicPath());
            if ("defaultPic".equals(userInfomation.getPicPath())) {
                C2538c.c("UserProfileUtil", new Object[]{" saveUserInfo set picPath to null "});
                a.setPicPath("");
            }
        }
        if (-1000 != userInfomation.getGender()) {
            a.setGender(Integer.valueOf(userInfomation.getGender()));
        }
        if (!TextUtils.isEmpty(userInfomation.getBirthday())) {
            a.setBirthday(userInfomation.getBirthday());
        }
        if (-1000 != userInfomation.getHeight()) {
            a.setHeight(Integer.valueOf(userInfomation.getHeight()));
            a.setClientSet(Integer.valueOf(userInfomation.getClientSet()));
        }
        if (-1000 != userInfomation.getWeight()) {
            a.setWeight(Integer.valueOf(userInfomation.getWeight()));
            a.setClientSet(Integer.valueOf(userInfomation.getClientSet()));
        }
        if (0 != userInfomation.getSetTime()) {
            a.setSetTime(userInfomation.getSetTime());
        }
        C3978v.m19699a(a);
    }

    private static int m19702b(String str, String str2, com.huawei.hwdataaccessmodel.a.c cVar) {
        return a.a(BaseApplication.b(), String.valueOf(1004), str, str2, cVar);
    }

    private static String m19708c(String str) {
        return a.a(BaseApplication.b(), String.valueOf(1004), str);
    }

    private static void m19707b(boolean z) {
        C2538c.c("UserProfileUtil", new Object[]{"setUserPrivacyUpgraded, flag = " + z});
        C3978v.m19702b("KEY_PERSONAL_PRIVACY_SETTINGS_UPGRADED_FLAG", String.valueOf(z), null);
    }

    static void m19698a(C4694a c4694a) {
        C2538c.c("UserProfileUtil", new Object[]{" downloadUserPrivacy Entry"});
        GetPrivacyRecordReq getPrivacyRecordReq = new GetPrivacyRecordReq();
        getPrivacyRecordReq.setPrivacyId(Integer.valueOf(0));
        C4689d.m22457a(BaseApplication.b()).m22491a(getPrivacyRecordReq, new C3979w(c4694a));
    }

    private static void m19711e() {
        a.b(BaseApplication.b(), String.valueOf(10009), "key_auto_update_switch");
        C2538c.c("UserProfileUtil", new Object[]{"deleteWLanAutoUpdate ok"});
    }

    static void m19704b() {
        C2538c.c("UserProfileUtil", new Object[]{"downloadWLanAutoUpdate enter  "});
        f15218b = Executors.newCachedThreadPool();
        f15218b.execute(new C3980x());
    }

    static void m19709c() {
        C2538c.c("UserProfileUtil", new Object[]{"downloadCoreSleepSwitchStatus enter :"});
        f15218b = Executors.newCachedThreadPool();
        f15218b.execute(new ab());
    }

    static void m19710d() {
        for (int i = 1; i < 6; i++) {
            if (1 == i) {
                C3978v.m19702b("cloud_user_privacy" + i, "", null);
            } else {
                C3978v.m19702b("cloud_user_privacy" + i, f15217a[i], null);
            }
            C3978v.m19702b("cloud_user_privacy_reupload" + i, "", null);
            C3978v.m19702b("cloud_user_privacy_reupload_desp" + i, "", null);
        }
        a.b(BaseApplication.b(), String.valueOf(1004), UserInfomation.KEY_USER_INFO);
        C2538c.c("UserProfileUtil", new Object[]{"deleteSharedPreference"});
        C3978v.m19711e();
    }

    static void m19700a(String str) {
        if (!TextUtils.isEmpty(str)) {
            UserInfomation a = C3978v.m19694a();
            a.setPicPath(str);
            C3978v.m19699a(a);
        }
    }

    static void m19696a(int i, boolean z, String str, IBaseResponseCallback iBaseResponseCallback) {
        C3978v.m19702b("cloud_user_privacy" + i, String.valueOf(z), null);
        AddPrivacyRecordReq addPrivacyRecordReq = new AddPrivacyRecordReq();
        addPrivacyRecordReq.setPrivacyId(Integer.valueOf(i));
        addPrivacyRecordReq.setOpinion(Integer.valueOf(z ? 1 : 2));
        addPrivacyRecordReq.setDescription(str);
        C4689d.m22457a(BaseApplication.b()).m22489a(addPrivacyRecordReq, new C3981y(iBaseResponseCallback, i, z, str));
        if (i == 104) {
            C4689d.m22457a(BaseApplication.b()).m22490a(new DeleteUserProfileReq(), new C3982z(iBaseResponseCallback));
        }
    }

    static String m19695a(int i) {
        C2538c.c("UserProfileUtil", new Object[]{" enter getUserPrivacy " + i});
        if (i < 1 || i >= 6) {
            C2538c.c("UserProfileUtil", new Object[]{" invalid privacyId"});
            return null;
        }
        String c = C3978v.m19708c("cloud_user_privacy" + i);
        if (TextUtils.isEmpty(c)) {
            c = f15217a[i];
        }
        c.c("UserProfileUtil", new Object[]{" geUserPrivacy value=" + c});
        return c;
    }

    static void m19705b(int i) {
        Object c = C3978v.m19708c("cloud_user_privacy_reupload" + i);
        Object c2 = C3978v.m19708c("cloud_user_privacy_reupload_desp" + i);
        if (!TextUtils.isEmpty(c) && !TextUtils.isEmpty(c2)) {
            AddPrivacyRecordReq addPrivacyRecordReq = new AddPrivacyRecordReq();
            addPrivacyRecordReq.setPrivacyId(Integer.valueOf(i));
            addPrivacyRecordReq.setOpinion(Integer.valueOf(c.equals("true") ? 1 : 2));
            addPrivacyRecordReq.setDescription(c2);
            C4689d.m22457a(BaseApplication.b()).m22489a(addPrivacyRecordReq, new aa(i));
        }
    }
}
