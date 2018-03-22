package com.huawei.ab;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.hihealth.HiUserInfo;
import com.huawei.hihealth.p036a.C4509c;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwbasemgr.a;
import com.huawei.hwcloudmodel.c.w;
import com.huawei.hwcloudmodel.callback.C3957a;
import com.huawei.hwcloudmodel.p061c.C4689d;
import com.huawei.hwcloudmodel.p402a.C4671a;
import com.huawei.hwcloudmodel.p402a.C4672b;
import com.huawei.hwcommonmodel.p064d.C4727e;
import com.huawei.p190v.C2538c;
import com.huawei.up.model.UserInfomation;
import com.huawei.up.p404b.C4694a;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* compiled from: HWUserInfoMgr */
public class C3956a extends a {
    private static C3956a f15168a;
    private static final Object f15169b = new Object();
    private static final Object f15170c = new Object();
    private static HashSet<String> f15171j = new HashSet(Arrays.asList(new String[]{"com.huawei.bone.action.CLOUD_SWITCH_CHANGED", "com.huawei.bone.action.FITNESS_USERINFO_UPDATED"}));
    private UserInfomation f15172d;
    private Context f15173e = null;
    private C4689d f15174f = null;
    private ExecutorService f15175g;
    private Handler f15176h;
    private HandlerThread f15177i;
    private BroadcastReceiver f15178k = new C3966i(this);

    public static C3956a m19641a(Context context) {
        C3956a c3956a;
        synchronized (f15169b) {
            if (f15168a == null) {
                f15168a = new C3956a(context.getApplicationContext());
            }
            c3956a = f15168a;
        }
        return c3956a;
    }

    private C3956a(Context context) {
        super(context);
        this.f15173e = context;
        m19654b(context);
    }

    private void m19654b(Context context) {
        this.f15177i = new HandlerThread("HWUserProfileMgr_HandlerThread");
        this.f15177i.start();
        this.f15176h = new C3969l(this, this.f15177i.getLooper());
        registerBroadcast(this.f15178k, "com.huawei.hihealth.action_sync_data");
        registerBroadcast(this.f15178k, "com.huawei.hihealth.action_data_refresh");
        if (this.f15174f == null) {
            this.f15174f = C4689d.m22457a(context);
        }
        this.f15175g = Executors.newFixedThreadPool(5);
        m19663a(new C3958b(this));
    }

    public UserInfomation m19660a() {
        C2538c.c("HWUserInfoMgr", new Object[]{"enter getUserInfo"});
        UserInfomation userInfomation = (UserInfomation) new Gson().fromJson(getSharedPreference(UserInfomation.KEY_USER_INFO), UserInfomation.class);
        if (userInfomation != null) {
            C2538c.c("HWUserInfoMgr", new Object[]{" getUserInfo  userInfo=" + userInfomation});
            return userInfomation;
        }
        userInfomation = new UserInfomation();
        C2538c.c("HWUserInfoMgr", new Object[]{" getUserInfo  userInfo=null"});
        return userInfomation;
    }

    public void m19661a(Context context, C4694a c4694a) {
        C2538c.c("HWUserInfoMgr", new Object[]{"enter downloadUserInfo（）"});
        synchronized (f15170c) {
            this.f15172d = null;
        }
        if (!m19651a(c4694a)) {
            this.f15174f.m22487a(context, new C3959c(this, c4694a));
        }
    }

    private void m19648a(UserInfomation userInfomation, C4694a c4694a) {
        this.f15175g.execute(new C3960d(this, userInfomation, c4694a));
    }

    private boolean m19657b(UserInfomation userInfomation, C4694a c4694a) {
        Bitmap a = C4672b.m22420a(userInfomation.getPortraitUrl(), this.f15173e);
        Object c = com.huawei.login.ui.login.a.a(this.f15173e).c();
        if (TextUtils.isEmpty(c)) {
            c.c("HWUserInfoMgr", new Object[]{"userid is empty"});
            if (c4694a == null) {
                return true;
            }
            c4694a.mo4557a(-1);
            synchronized (f15170c) {
                this.f15172d = null;
            }
            return true;
        }
        Object a2 = C4671a.m22419a(this.f15173e, c, a);
        String picPath = m19660a().getPicPath();
        c.c("HWUserInfoMgr", new Object[]{"new url:" + userInfomation.getPortraitUrl() + "new picPath = " + a2 + " oldPath = " + picPath});
        if (TextUtils.isEmpty(a2)) {
            userInfomation.setPicPath("defaultPic");
        } else {
            if (!TextUtils.isEmpty(picPath)) {
                c.c("HWUserInfoMgr", new Object[]{"old picPath:" + picPath});
                if (!picPath.equals(a2)) {
                    c.c("HWUserInfoMgr", new Object[]{"picPath change, delete old"});
                    if (!new File(picPath).delete()) {
                        c.c("HWUserInfoMgr", new Object[]{"delete old pic file failed:" + picPath});
                    }
                }
            }
            userInfomation.setPicPath(a2);
        }
        c.c("HWUserInfoMgr", new Object[]{"download image success"});
        return false;
    }

    public void m19664a(C4694a c4694a, boolean z, boolean z2, int... iArr) {
        C2538c.c("HWUserInfoMgr", new Object[]{"getUserInfofromHiHealth isDatalogin ：" + w.a(com.huawei.login.ui.login.a.a(this.f15173e.getApplicationContext()).c())});
        if (w.a(com.huawei.login.ui.login.a.a(this.f15173e.getApplicationContext()).c())) {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            C4509c.m21594a(this.f15173e).m21617b(new C3962e(this, countDownLatch, z2, z, c4694a));
            if (iArr == null || iArr.length <= 0) {
                C2538c.c("HWUserInfoMgr", new Object[]{"outtime no value"});
                return;
            }
            boolean await;
            try {
                await = countDownLatch.await((long) iArr[0], TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                C2538c.e("HWUserInfoMgr", new Object[]{"InterruptedException e = ", e.getMessage()});
                await = false;
            }
            C2538c.e("HWUserInfoMgr", new Object[]{"sendMigrateDataToCloud outtime:" + await});
            if (!await) {
                m19649a(z, c4694a);
                return;
            }
            return;
        }
        m19649a(z, c4694a);
    }

    private void m19649a(boolean z, C4694a c4694a) {
        UserInfomation a = m19660a();
        synchronized (f15170c) {
            if (this.f15172d == null) {
                this.f15172d = a;
                C2538c.c("HWUserInfoMgr", new Object[]{"fetchUserData onFailure mUserInfo = null"});
            } else {
                this.f15172d.setWeight(Integer.valueOf(a.getWeight()));
                this.f15172d.setHeight(Integer.valueOf(a.getHeight()));
                this.f15172d.setClientSet(Integer.valueOf(a.getClientSet()));
                this.f15172d.setSetTime(a.getSetTime());
            }
        }
        Message obtainMessage = this.f15176h.obtainMessage();
        obtainMessage.what = 1004;
        HiUserInfo hiUserInfo = new HiUserInfo();
        hiUserInfo.setHeight(a.getHeight());
        hiUserInfo.setWeight((float) a.getWeight());
        hiUserInfo.setGender(1);
        hiUserInfo.setBirthday(HiUserInfo.BIRTHDAY_DEFAULT);
        hiUserInfo.setCreateTime(a.getSetTime());
        obtainMessage.obj = hiUserInfo;
        this.f15176h.sendMessage(obtainMessage);
        if (z && c4694a != null) {
            c4694a.mo4558a(new Bundle());
        }
    }

    private boolean m19651a(C4694a c4694a) {
        Object sharedPreference = getSharedPreference("custome_define_init_flag");
        if (TextUtils.isEmpty(sharedPreference) || !sharedPreference.equals("true")) {
            return false;
        }
        C2538c.c("HWUserInfoMgr", new Object[]{" user has logout , no need to save"});
        if (c4694a == null) {
            return true;
        }
        c4694a.mo4557a(-1);
        synchronized (f15170c) {
            this.f15172d = null;
        }
        return true;
    }

    public void m19663a(IBaseResponseCallback iBaseResponseCallback) {
        C4509c.m21594a(this.f15173e).m21617b(new C3963f(this, iBaseResponseCallback));
    }

    void m19662a(HiUserInfo hiUserInfo, UserInfomation userInfomation, C3957a<Boolean> c3957a, String str) {
        C2538c.c("HWUserInfoMgr", new Object[]{"setUserInfoToHiHealth hiUserInfo.getWeight() = " + hiUserInfo.getWeight() + " hiUserInfo.getHeight() = " + hiUserInfo.getHeight()});
        if (1 == userInfomation.getClientSet()) {
            int height = userInfomation.getHeight() / 12;
            hiUserInfo.setHeight(C4727e.m22623b(height, userInfomation.getHeight() - (height * 12)));
            hiUserInfo.setWeight((float) com.huawei.hwbasemgr.c.b((double) userInfomation.getWeight()));
        }
        hiUserInfo.setUnitType(0);
        C2538c.c("HWUserInfoMgr", new Object[]{"setUserInfoToHiHealth hiUserInfo = " + hiUserInfo.toString()});
        C4509c.m21594a(this.f15173e).m21610a(hiUserInfo, new C3964g(this, c3957a));
        if (str != null) {
            userInfomation.setPortraitUrl(str);
        }
        sendBroadcast("com.huawei.bone.action.FITNESS_USERINFO_UPDATED");
        Message obtainMessage = this.f15176h.obtainMessage();
        obtainMessage.what = 1002;
        obtainMessage.obj = userInfomation;
        this.f15176h.sendMessage(obtainMessage);
    }

    private void m19646a(HiUserInfo hiUserInfo) {
        C2538c.c("HWUserInfoMgr", new Object[]{"setUserInfoToHiHealth2 hiUserInfo.getWeight() = " + hiUserInfo.getWeight() + " hiUserInfo.getHeight() = " + hiUserInfo.getHeight()});
        C4509c.m21594a(this.f15173e).m21610a(hiUserInfo, new C3965h(this));
    }

    private long m19652b(HiUserInfo hiUserInfo) {
        C2538c.c("HWUserInfoMgr", new Object[]{"getHiUserInfoModifiedTime hiUserInfo.getModifiedTime() = " + hiUserInfo.getCreateTime()});
        return hiUserInfo.getCreateTime();
    }

    private void m19647a(HiUserInfo hiUserInfo, UserInfomation userInfomation) {
        if (1 == userInfomation.getClientSet()) {
            int height = userInfomation.getHeight() / 12;
            hiUserInfo.setHeight(C4727e.m22623b(height, userInfomation.getHeight() - (height * 12)));
            hiUserInfo.setWeight((float) C4727e.m22627f(userInfomation.getWeight()));
        } else {
            hiUserInfo.setHeight(userInfomation.getHeight());
            hiUserInfo.setWeight((float) userInfomation.getWeight());
        }
        hiUserInfo.setUnitType(0);
    }

    protected Integer getModuleId() {
        return Integer.valueOf(1004);
    }

    protected Set<String> getAvailableBroadcastSet() {
        return f15171j;
    }

    public UserInfomation m19665b() {
        UserInfomation userInfomation;
        synchronized (f15170c) {
            userInfomation = this.f15172d;
        }
        return userInfomation;
    }
}
