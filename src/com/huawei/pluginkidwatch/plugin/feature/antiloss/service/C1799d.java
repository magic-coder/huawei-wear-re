package com.huawei.pluginkidwatch.plugin.feature.antiloss.service;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.C1413d;
import com.huawei.pluginkidwatch.common.entity.C1417a;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.SetAccompanyUserIEntityModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.lib.utils.C1495o;
import com.huawei.pluginkidwatch.home.HomeActivity;
import com.huawei.pluginkidwatch.plugin.feature.antiloss.AntilossPopupDialogActivity;
import com.huawei.pluginkidwatch.plugin.feature.antiloss.p162a.C1773a;
import com.huawei.pluginkidwatch.plugin.p152a.C1723d;
import com.huawei.pluginkidwatch.plugin.p152a.C1743x;

/* compiled from: KidWatchServiceInteractor */
public class C1799d {
    private C1723d f4957a;
    private Context f4958b;
    private C1413d f4959c;
    private SetAccompanyUserIEntityModel f4960d;
    private C1378e f4961e = new C1800e(this);

    public C1799d(Context context) {
        this.f4958b = context;
        this.f4960d = new SetAccompanyUserIEntityModel();
        this.f4959c = C1417a.m6594a(this.f4958b.getApplicationContext());
    }

    public void m8597a(int i) {
        C2538c.m12674b("KidWatchService", "refreashAntilossState state = " + i);
        this.f4957a = C1743x.m8322a(this.f4958b).m8323a();
        if (this.f4957a != null) {
            this.f4957a.m8297e(i);
        }
    }

    public void m8596a() {
        C2538c.m12674b("KidWatchService", "onRangeOutTimeoutProcess runnableRangeOutTimeout !!!!");
        if (this.f4957a != null) {
            this.f4957a.m8292c(9);
        }
        m8602d();
        m8601c();
        if (this.f4957a == null || 2 != this.f4957a.m8302i()) {
            m8595h();
        } else {
            this.f4957a.m8283a(2, new C1801f(this));
        }
    }

    public void m8600b() {
        C2538c.m12674b("KidWatchService", "start AntilossPopupDialogActivity");
        if (!m8593f() || m8594g()) {
            m8592e();
            m8595h();
        } else {
            C2538c.m12674b("KidWatchService", "start AntilossPopupDialogActivity into");
            C1773a.m8552a(this.f4958b).m8555a(this.f4958b, "", AntilossPopupDialogActivity.class);
        }
        C1773a.m8552a(this.f4958b).m8554a();
        C1773a.m8552a(this.f4958b).m8562f();
    }

    private void m8592e() {
        String string;
        C2538c.m12674b("KidWatchService", "start startAntilossAlarmNotification");
        if (C1462f.m6748k() == null) {
            string = this.f4958b.getResources().getString(C1680l.IDS_plugin_kidwatch_feature_antiloss_rangeout_notice, new Object[]{this.f4958b.getResources().getString(C1680l.IDS_plugin_kidwatch_settings_profilekid_nickname_default)});
        } else {
            string = this.f4958b.getResources().getString(C1680l.IDS_plugin_kidwatch_feature_antiloss_rangeout_notify, new Object[]{C1462f.m6748k().f3083c});
        }
        C1495o.m6930a(this.f4958b.getApplicationContext(), HomeActivity.class, string, this.f4958b.getResources().getString(C1680l.IDS_plugin_kidwatch_common_title), string, 7, new int[0]);
    }

    public void m8601c() {
        C2538c.m12674b("KidWatchService", "sendAntilossAlarmBroadcast... action = start.antiloss.alarm");
        Intent intent = new Intent();
        intent.setAction("start.antiloss.alarm");
        LocalBroadcastManager.getInstance(this.f4958b).sendBroadcast(intent);
    }

    private boolean m8593f() {
        Context context = this.f4958b;
        Context context2 = this.f4958b;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        String str = "";
        if (activityManager == null || activityManager.getRunningTasks(1) == null || activityManager.getRunningTasks(1).get(0) == null) {
            String str2 = str;
        } else {
            Object packageName = ((RunningTaskInfo) activityManager.getRunningTasks(1).get(0)).topActivity.getPackageName();
        }
        if (TextUtils.isEmpty(packageName) || !packageName.equals(this.f4958b.getPackageName())) {
            return false;
        }
        return true;
    }

    private final boolean m8594g() {
        Context context = this.f4958b;
        Context context2 = this.f4958b;
        return ((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    }

    public void m8602d() {
        C2538c.m12674b("KidWatchService", "clearCurRunningAntilossPopupDialogActivity");
        C2538c.m12674b("KidWatchService", "=============销毁报警的dialog");
        Intent intent = new Intent();
        intent.setAction("antiloss.popup.dialog.activity.destory.action");
        this.f4958b.sendBroadcast(intent, "com.huawei.bone.permission.LOCAL_BROADCAST");
    }

    public void m8598a(String str) {
        C2538c.m12674b("KidWatchService", "sendCloseAntilossRadarBroadcast... action = " + str);
        Intent intent = new Intent();
        intent.setAction(str);
        LocalBroadcastManager.getInstance(this.f4958b).sendBroadcast(intent);
    }

    private void m8595h() {
        C2538c.m12674b("KidWatchService", "sendCloseAntilossActivity");
        Intent intent = new Intent();
        intent.setAction("com.huawei.kone.broadcast.close.antilossactivity");
        LocalBroadcastManager.getInstance(this.f4958b).sendBroadcast(intent);
    }

    public void m8599a(boolean z) {
        if (C1462f.m6746j() != null && C1492l.m6919c(C1462f.m6746j())) {
            this.f4960d.deviceCode = C1492l.m6920d(C1462f.m6746j());
            if (z) {
                this.f4960d.operation = 1;
            } else {
                this.f4960d.operation = 2;
            }
            this.f4959c.mo2493a(this.f4960d, this.f4961e);
        }
    }
}
