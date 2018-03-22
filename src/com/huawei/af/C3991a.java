package com.huawei.af;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.ad.p314b.C3985a;
import com.huawei.ak.C4027a;
import com.huawei.datatype.Contact;
import com.huawei.datatype.DataDeviceAvoidDisturbInfo;
import com.huawei.datatype.EventAlarmInfo;
import com.huawei.datatype.SmartAlarmInfo;
import com.huawei.hihealth.HiUserPreference;
import com.huawei.hihealth.a.b;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwbasemgr.a;
import com.huawei.hwcloudmodel.c.w;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.fitnessdatatype.ActivityReminder;
import com.huawei.hwcommonmodel.p064d.C4732k;
import com.huawei.hwfitnessmgr.C5010a;
import com.huawei.hwfitnessmgr.q;
import com.huawei.p190v.C2538c;
import com.huawei.p392h.C4504a;
import com.huawei.p461i.C5393a;
import com.huawei.p510u.C5978a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: HWCombineMigrateMgr */
public class C3991a extends a {
    private static C3991a f15241a = null;
    private Map<String, String> f15242b;
    private Map<String, String> f15243c;
    private int f15244d = 0;
    private List<EventAlarmInfo> f15245e = new ArrayList();
    private boolean f15246f = false;
    private boolean f15247g = false;

    private C3991a(Context context) {
        super(context);
    }

    public static C3991a m19745a(Context context) {
        C3991a c3991a;
        synchronized (C3991a.class) {
            if (f15241a == null) {
                f15241a = new C3991a(BaseApplication.b());
            }
            c3991a = f15241a;
        }
        return c3991a;
    }

    protected Integer getModuleId() {
        return Integer.valueOf(1016);
    }

    public void m19761b(Context context) {
        String c = com.huawei.login.ui.login.a.a(BaseApplication.b()).c();
        if (TextUtils.isEmpty(c)) {
            c = "default_id";
        }
        Object sharedPreference = getSharedPreference(c + "first_time_combine_migrate_key");
        if (!TextUtils.isEmpty(sharedPreference)) {
            this.f15244d = Integer.parseInt(sharedPreference);
        }
        c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData isFirstTimeFlag = " + this.f15244d});
        if (1 == this.f15244d) {
            c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData2 NOT_FIRST_TIME_MIGRATE_DATA"});
            this.f15246f = Boolean.parseBoolean(getSharedPreference("have_migrate_event_alarm_key"));
            c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData2 haveMigrateEventAlarm = " + this.f15246f});
            if (!this.f15246f) {
                m19751a(new C3992b(this));
            }
            c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData2 mCommonSettingList = " + this.f15243c});
            this.f15247g = Boolean.parseBoolean(getSharedPreference("have_migrate_all_common_settings_key"));
            c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData2 haveMigrateAllCommonSettings = " + this.f15247g});
            if (!this.f15247g) {
                m19755b(new C4001k(this));
            }
        }
        if (this.f15244d == 0) {
            c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData Start migrate all data."});
            if (w.a(com.huawei.login.ui.login.a.a(BaseApplication.b()).c())) {
                CharSequence valueOf;
                List a;
                q a2 = q.a(context);
                if (a2 != null) {
                    ActivityReminder b = new C5010a().m24076b(a2);
                    c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData getActivityReminder activityReminder = " + b});
                    if (b != null) {
                        m19758a(b, true);
                    }
                }
                c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData COMMON_SETTING str = " + m19757a("custom.wear_common_setting")});
                this.f15242b = m19753b(r1);
                if (this.f15242b != null) {
                    c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData mCommonSettingDataList = " + this.f15242b.toString()});
                } else {
                    this.f15242b = new HashMap();
                }
                C5978a a3 = C5978a.m27400a();
                if (a3 != null) {
                    valueOf = String.valueOf(0);
                    c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData getSharedPreference isRemindFlag = " + a3.m27412b()});
                    if (a3.m27412b()) {
                        valueOf = String.valueOf(1);
                    }
                    c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData getSharedPreference isRemind = " + valueOf});
                    if (!TextUtils.isEmpty(valueOf)) {
                        this.f15242b.put("bt_lost_remind", valueOf);
                        c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData mCommonSettingDataList BT_LOST_REMIND = " + this.f15242b.toString()});
                    }
                }
                com.huawei.n.c a4 = com.huawei.n.c.a(context);
                if (a4 != null) {
                    valueOf = String.valueOf(1);
                    c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData getSharedPreference autoLightFlag = " + a4.e()});
                    if (!a4.e()) {
                        valueOf = String.valueOf(0);
                    }
                    c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData getSharedPreference autoLight = " + valueOf});
                    if (!TextUtils.isEmpty(valueOf)) {
                        this.f15242b.put("auto_light_screen", valueOf);
                        c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData mCommonSettingDataList AUTO_LIGHT_SCREEN = " + this.f15242b.toString()});
                    }
                }
                if (a4 != null) {
                    valueOf = String.valueOf(0);
                    c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData getSharedPreference rotateFlag = " + a4.f()});
                    if (a4.f()) {
                        valueOf = String.valueOf(1);
                    }
                    c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData getSharedPreference rotate = " + valueOf});
                    if (!TextUtils.isEmpty(valueOf)) {
                        this.f15242b.put("rotate_switch_screen", valueOf);
                        c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData mCommonSettingDataList ROTATE_SWITCH_SCREEN = " + this.f15242b.toString()});
                    }
                }
                C4504a a5 = C4504a.m21570a(context);
                if (a5 != null) {
                    a = a5.m21580a();
                    if (!(a == null || a.size() == 0)) {
                        c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData getContact contacts = " + a.toString()});
                        m19760a(a, true);
                    }
                }
                C5393a a6 = C5393a.m25948a(context);
                if (a6 != null) {
                    List a7 = a6.m25979a();
                    if (a7.size() != 0) {
                        m19763b(a7, true);
                    }
                    a = a6.m25984b();
                    if (a.size() != 0) {
                        m19765c(a, true);
                    }
                }
                if (a4 != null) {
                    a = a4.h();
                    if (!(a == null || a.size() == 0)) {
                        c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData getDeviceAvoidDisturbingFromDBNoCallback dataDeviceAvoidDisturbInfoList = " + a.toString()});
                        m19767d(a, true);
                    }
                }
                C3985a a8 = C3985a.m19730a(context);
                if (a8 != null) {
                    c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData getWeatherSwitchStatus,switchStatus-----------" + a8.m19741a()});
                    this.f15242b.put("weather_switch_status", String.valueOf(r1));
                    c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData mCommonSettingDataList WEATHER_SWITCH_STATUS = " + this.f15242b.toString()});
                }
                if (a2 != null) {
                    c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData getCoreSleepButtonEnable statusFlag = " + a2.l()});
                    sharedPreference = Integer.toString(r1);
                    if (!TextUtils.isEmpty(sharedPreference)) {
                        c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData getCoreSleepButtonEnable status = " + sharedPreference});
                        this.f15242b.put("core_sleep_button", sharedPreference);
                        c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData mCommonSettingDataList CORE_SLEEP_BUTTON = " + this.f15242b.toString()});
                    }
                }
                sharedPreference = com.huawei.hwdataaccessmodel.sharedpreference.a.a(context, String.valueOf(10009), "key_auto_update_switch");
                if (!TextUtils.isEmpty(sharedPreference)) {
                    c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData getWLANAutoUpdate value = " + sharedPreference});
                    this.f15242b.put("wlan_auto_update", sharedPreference);
                    c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData mCommonSettingDataList WLAN_AUTO_UPDATE = " + this.f15242b.toString()});
                }
                if (a4 != null) {
                    c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData getLeftOrRightHandWearStatus leftOrRight = " + a4.c(null)});
                    this.f15242b.put("left_or_right_hand_wear_status", String.valueOf(r1));
                    c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData mCommonSettingDataList LEFT_OR_RIGHT_HAND_WEAR_STATUS = " + this.f15242b.toString()});
                }
                if (a2 != null) {
                    c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData getHeartRateButtonEnable status =" + a2.n()});
                    this.f15242b.put("heart_rate_button", Integer.toString(r1));
                    c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData mCommonSettingDataList HEART_RATE_BUTTON = " + this.f15242b.toString()});
                }
                m19752a(this.f15242b);
                this.f15244d = 1;
                setSharedPreference(c + "first_time_combine_migrate_key", String.valueOf(this.f15244d), null);
                return;
            }
            c.e("HWCombineMigrateMgr", new Object[]{"HiHealth login error"});
        }
    }

    private void m19750a() {
        String valueOf;
        com.huawei.n.c a;
        q a2;
        Object num;
        if (this.f15243c != null) {
            C2538c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData2 mCommonSettingList = " + this.f15243c.toString()});
        } else {
            this.f15243c = new HashMap();
        }
        if (!this.f15243c.containsKey("bt_lost_remind")) {
            C5978a a3 = C5978a.m27400a();
            if (a3 != null) {
                valueOf = String.valueOf(0);
                C2538c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData2 getSharedPreference isRemindFlag = " + a3.m27412b()});
                if (a3.m27412b()) {
                    valueOf = String.valueOf(1);
                }
                C2538c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData2 getSharedPreference isRemind = " + valueOf});
                this.f15243c.put("bt_lost_remind", valueOf);
            }
        }
        if (!this.f15243c.containsKey("auto_light_screen")) {
            a = com.huawei.n.c.a(BaseApplication.b());
            if (a != null) {
                valueOf = String.valueOf(1);
                C2538c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData2 getSharedPreference autoLightFlag = " + a.e()});
                if (!a.e()) {
                    valueOf = String.valueOf(0);
                }
                C2538c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData2 getSharedPreference autoLight = " + valueOf});
                this.f15243c.put("auto_light_screen", valueOf);
            }
        }
        if (!this.f15243c.containsKey("rotate_switch_screen")) {
            a = com.huawei.n.c.a(BaseApplication.b());
            if (a != null) {
                valueOf = String.valueOf(0);
                C2538c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData2 getSharedPreference rotateFlag = " + a.f()});
                if (a.f()) {
                    valueOf = String.valueOf(1);
                }
                C2538c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData2 getSharedPreference rotate = " + valueOf});
                this.f15243c.put("rotate_switch_screen", valueOf);
            }
        }
        if (!this.f15243c.containsKey("weather_switch_status")) {
            C3985a a4 = C3985a.m19730a(BaseApplication.b());
            if (a4 != null) {
                C2538c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData2 getWeatherSwitchStatus,switchStatus-----------" + a4.m19741a()});
                this.f15243c.put("weather_switch_status", String.valueOf(r0));
            }
        }
        if (!this.f15243c.containsKey("core_sleep_button")) {
            a2 = q.a(BaseApplication.b());
            if (a2 != null) {
                C2538c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData2 getCoreSleepButtonEnable statusFlag = " + a2.l()});
                num = Integer.toString(r0);
                if (!TextUtils.isEmpty(num)) {
                    C2538c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData2 getCoreSleepButtonEnable status = " + num});
                    this.f15243c.put("core_sleep_button", num);
                }
            }
        }
        if (!this.f15243c.containsKey("wlan_auto_update")) {
            num = com.huawei.hwdataaccessmodel.sharedpreference.a.a(BaseApplication.b(), String.valueOf(10009), "key_auto_update_switch");
            if (!TextUtils.isEmpty(num)) {
                C2538c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData2 getWLANAutoUpdate value = " + num});
                this.f15243c.put("wlan_auto_update", num);
            }
        }
        if (!this.f15243c.containsKey("left_or_right_hand_wear_status")) {
            com.huawei.n.c a5 = com.huawei.n.c.a(BaseApplication.b());
            if (a5 != null) {
                C2538c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData2 getLeftOrRightHandWearStatus leftOrRight = " + a5.c(null)});
                this.f15243c.put("left_or_right_hand_wear_status", String.valueOf(r0));
            }
        }
        if (!this.f15243c.containsKey("heart_rate_button")) {
            a2 = q.a(BaseApplication.b());
            if (a2 != null) {
                C2538c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData2 getHeartRateButtonEnable status =" + a2.n()});
                this.f15243c.put("heart_rate_button", Integer.toString(r0));
            }
        }
        C2538c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData2 mCommonSettingList to HiHealth = " + this.f15243c.toString()});
        m19752a(this.f15243c);
    }

    private void m19752a(Map map) {
        if (map == null) {
            C2538c.e("HWCombineMigrateMgr", new Object[]{"===migrateAllData migrateCommonSettings map is null"});
            return;
        }
        C2538c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData migrateCommonSettings map = " + map.toString()});
        b.a(BaseApplication.b()).a(new HiUserPreference("custom.wear_common_setting", map.toString()), true);
        C2538c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData migrateCommonSettings setUserPreference"});
        if (b.a(BaseApplication.b()).a("custom.wear_common_setting") != null) {
            C2538c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData migrateCommonSettings value = " + b.a(BaseApplication.b()).a("custom.wear_common_setting").getValue()});
            return;
        }
        C2538c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData migrateCommonSettings value = null"});
    }

    private void m19751a(IBaseResponseCallback iBaseResponseCallback) {
        C2538c.c("HWCombineMigrateMgr", new Object[]{"getEventAlarm enter"});
        C4027a.m19820a().m19821a(new C4002l(this, iBaseResponseCallback));
    }

    private void m19755b(IBaseResponseCallback iBaseResponseCallback) {
        C4027a.m19820a().m19821a(new C4004n(this, iBaseResponseCallback));
    }

    public void m19758a(ActivityReminder activityReminder, boolean z) {
        C2538c.c("HWCombineMigrateMgr", new Object[]{"migrateActivityReminder enter"});
        C4027a.m19820a().m19821a(new C4005o(this, z, activityReminder));
    }

    public void m19759a(String str, boolean z) {
        C2538c.c("HWCombineMigrateMgr", new Object[]{"migrateBTLostRemind enter"});
        C4732k.m22635a(new C4006p(this, z, str));
    }

    public void m19762b(String str, boolean z) {
        C2538c.c("HWCombineMigrateMgr", new Object[]{"migrateAutoLightScreen enter"});
        C4732k.m22635a(new C4007q(this, z, str));
    }

    public void m19764c(String str, boolean z) {
        C2538c.c("HWCombineMigrateMgr", new Object[]{"migrateRotateSwitchScreen enter"});
        C4732k.m22635a(new C4008r(this, z, str));
    }

    public void m19760a(List<Contact> list, boolean z) {
        C2538c.c("HWCombineMigrateMgr", new Object[]{"migrateAddressBook enter"});
        C4732k.m22635a(new C4009s(this, z, list));
    }

    public void m19763b(List<SmartAlarmInfo> list, boolean z) {
        C2538c.c("HWCombineMigrateMgr", new Object[]{"migrateSmartAlarm enter"});
        C4732k.m22635a(new C3993c(this, z, list));
    }

    public void m19765c(List<EventAlarmInfo> list, boolean z) {
        C2538c.c("HWCombineMigrateMgr", new Object[]{"migrateEventAlarm enter"});
        C4732k.m22635a(new C3994d(this, z, list));
    }

    public void m19767d(List<DataDeviceAvoidDisturbInfo> list, boolean z) {
        C2538c.c("HWCombineMigrateMgr", new Object[]{"migrateAvoidDisturb enter"});
        C4732k.m22635a(new C3995e(this, z, list));
    }

    public void m19766d(String str, boolean z) {
        C2538c.c("HWCombineMigrateMgr", new Object[]{"migrateWeatherSwitchStatus enter"});
        C4732k.m22635a(new C3996f(this, z, str));
    }

    public void m19768e(String str, boolean z) {
        C2538c.c("HWCombineMigrateMgr", new Object[]{"migrateCoreSleepButton enter"});
        C4732k.m22635a(new C3997g(this, z, str));
    }

    public void m19769f(String str, boolean z) {
        C2538c.c("HWCombineMigrateMgr", new Object[]{"migrateWLANAutoUpdate enter"});
        C4732k.m22635a(new C3998h(this, z, str));
    }

    public void m19770g(String str, boolean z) {
        C2538c.c("HWCombineMigrateMgr", new Object[]{"migrateLeftOrRightHandWearStatus enter"});
        C4732k.m22635a(new C3999i(this, z, str));
    }

    public void m19771h(String str, boolean z) {
        C2538c.c("HWCombineMigrateMgr", new Object[]{"migrateHeartRateButton enter"});
        C4732k.m22635a(new C4000j(this, z, str));
    }

    public String m19757a(String str) {
        C2538c.c("HWCombineMigrateMgr", new Object[]{"getUserPreferenceFromHiHealth enter"});
        HiUserPreference a = b.a(BaseApplication.b()).a(str);
        if (a == null) {
            return null;
        }
        C2538c.c("HWCombineMigrateMgr", new Object[]{"key = " + str + "; value = " + a.getValue()});
        return a.getValue();
    }

    private HashMap<String, String> m19753b(String str) {
        C2538c.c("HWCombineMigrateMgr", new Object[]{"hashStringToHashMap str = " + str});
        if (str == null) {
            C2538c.e("HWCombineMigrateMgr", new Object[]{"str is null"});
            return null;
        }
        C2538c.c("HWCombineMigrateMgr", new Object[]{"strs = " + Arrays.toString(str.substring(1, str.length() - 1).split(","))});
        HashMap<String, String> hashMap = new HashMap();
        for (String str2 : r3) {
            C2538c.c("HWCombineMigrateMgr", new Object[]{"key = " + str2.split("=")[0].trim()});
            C2538c.c("HWCombineMigrateMgr", new Object[]{"value = " + str2.split("=")[1]});
            hashMap.put(r6, str2);
        }
        C2538c.c("HWCombineMigrateMgr", new Object[]{"map = " + hashMap.toString()});
        return hashMap;
    }
}
