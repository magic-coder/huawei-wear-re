package com.huawei.hwfitnessmgr.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.aa.C0629a;
import com.huawei.hihealth.HiAccountInfo;
import com.huawei.hihealth.p036a.C0824b;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.DeviceCapability;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwcommonmodel.p062a.C0972a;
import com.huawei.hwcommonmodel.p063b.C0976c;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.login.ui.login.C1093a;
import com.huawei.p091m.C1111d;
import com.huawei.p108n.C1204c;
import com.huawei.p190v.C2538c;
import java.util.Calendar;

public class SyncFitnessPrivateBroadcastReceiver extends BroadcastReceiver {
    public static final String f1910a = SyncFitnessPrivateBroadcastReceiver.class.getSimpleName();
    private static boolean f1911b = false;
    private static boolean f1912c = false;
    private static boolean f1913d = false;

    public static boolean m4152a() {
        return f1912c;
    }

    public static void m4151a(boolean z) {
        f1912c = z;
    }

    public static boolean m4154b() {
        return f1913d;
    }

    public static void m4153b(boolean z) {
        f1913d = z;
    }

    public void onReceive(Context context, Intent intent) {
        DeviceInfo deviceInfo = null;
        C2538c.m12677c(f1910a, "onReceive(): intent.getAction() = " + intent.getAction());
        if ("com.huawei.hihealth.action_receive_push_relogin".equals(intent.getAction())) {
            C2538c.m12677c(f1910a, "initialHiLogin called");
            Context b = BaseApplication.m2632b();
            if (C1093a.m4739a(b).m4752e() != -1) {
                HiAccountInfo hiAccountInfo = new HiAccountInfo();
                String c = C1093a.m4739a(b).m4750c();
                if (c != null) {
                    C2538c.m12677c(f1910a, "the user_id is " + c);
                    String g = C1093a.m4739a(b).m4754g();
                    if (c.equals("0")) {
                        c = null;
                    }
                    hiAccountInfo.setHuid(c);
                    hiAccountInfo.setServiceToken(g);
                    hiAccountInfo.setAccessToken("");
                    C0824b.m2914a(b).m2901a(hiAccountInfo, null);
                    return;
                }
                C2538c.m12677c(f1910a, "user_id is null, ignore the login request....");
                return;
            }
            C2538c.m12677c(f1910a, "siteID is -1, ignore the login request....");
        } else if ("com.huawei.bone.action.force_stop".equals(intent.getAction())) {
            C2538c.m12677c(f1910a, "com.huawei.phoneservice was stopped unusually.");
            C0996a c0996a = new C0996a();
            C0996a.m3611a(BaseApplication.m2632b(), "security_setting", "popup_flag", "true", null);
        } else if ("com.huawei.bone.core_sleep_sync".equals(intent.getAction())) {
            C2538c.m12677c(f1910a, "enter ACTION_CORE_SLEEP_SYNC.");
            if (C1204c.m5370a(context) != null) {
                deviceInfo = C1204c.m5370a(context).m5447c();
            }
            if (deviceInfo == null || deviceInfo.getDeviceConnectState() != 2) {
                C2538c.m12680e(f1910a, "ACTION_CORE_SLEEP_SYNC get device info error or DEVICE_DISCONNECTED return!");
                return;
            }
            boolean z;
            int i = Calendar.getInstance().get(11);
            C2538c.m12677c(f1910a, "handleWhenGetDetailDataSuccessDelayTodu coreSleepDataSync localHour = " + i);
            if (i < 0 || i >= 6) {
                z = true;
            } else {
                C2538c.m12677c(f1910a, "it's 0 - 6 hour, isManualSync = " + f1912c);
                if (m4152a()) {
                    z = true;
                } else {
                    z = false;
                }
            }
            C2538c.m12677c(f1910a, "start to sync core sleep.isSyncCoreSleepData = " + z + "    isManualSync = " + f1912c);
            DeviceCapability a = C0972a.m3499a();
            if (a != null) {
                C2538c.m12677c(f1910a, "capability.isSupportCoreSleep(): " + a.isSupportCoreSleep());
                C2538c.m12677c(f1910a, "capability.isSupportQueryDeviceCoreSleepSwitch(): " + a.isSupportQueryDeviceCoreSleepSwitch());
                if ((a.isSupportCoreSleep() || a.isSupportQueryDeviceCoreSleepSwitch()) && z) {
                    m4157d();
                } else {
                    C2538c.m12677c(f1910a, "don't satisfy coreSleep sync condition! ");
                    C1111d.m4931a(BaseApplication.m2632b()).m4972e();
                    m4155c();
                }
            } else {
                C2538c.m12677c(f1910a, "capability is null.");
                C1111d.m4931a(BaseApplication.m2632b()).m4972e();
                m4155c();
            }
            m4151a(false);
        } else if ("com.huawei.bone.stress_and_relax_sync".equals(intent.getAction())) {
            C2538c.m12677c(f1910a, "enter ACTION_STRESS_AND_RELAX_SYNC.");
            m4158e();
        } else if ("com.huawei.bone.action.open_gps".equals(intent.getAction())) {
            C2538c.m12677c(f1910a, "ACTION_OPEN_GPS~~~");
            m4153b(true);
        }
    }

    private void m4157d() {
        C2538c.m12677c(f1910a, "enter refreshCoreSleepData():");
        C1111d.m4931a(BaseApplication.m2632b()).m4967a(new C1031g(this));
    }

    public static void m4155c() {
        C2538c.m12677c(f1910a, " sending broadcast to notify UI thread ...");
        Intent intent = new Intent("com.huawei.bone.action.CORE_SLEEP_DATA_SYNC_COMPLETED");
        intent.setPackage("com.huawei.bone");
        BaseApplication.m2632b().sendBroadcast(intent, C0976c.f1642a);
    }

    private void m4158e() {
        C2538c.m12677c(f1910a, "startSyncStressData() enter:");
        if (f1911b) {
            C2538c.m12677c(f1910a, "startSyncStressData() return mSyncStressState: " + f1911b);
            return;
        }
        DeviceInfo deviceInfo = null;
        if (C1204c.m5370a(BaseApplication.m2632b()) != null) {
            deviceInfo = C1204c.m5370a(BaseApplication.m2632b()).m5447c();
        }
        if (deviceInfo == null || deviceInfo.getDeviceConnectState() != 2) {
            C2538c.m12680e(f1910a, "startSyncStressData DEVICE_CONNECTED return!");
            return;
        }
        f1911b = true;
        C0629a.m2258a(BaseApplication.m2632b()).m2293a(new C1032h(this));
    }
}
