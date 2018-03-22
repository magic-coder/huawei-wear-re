package com.huawei.ui.device.p170a;

import android.content.Context;
import android.os.Handler;
import android.text.format.DateFormat;
import com.google.gson.Gson;
import com.huawei.datatype.Contact;
import com.huawei.datatype.DataDeviceAvoidDisturbInfo;
import com.huawei.datatype.EventAlarmInfo;
import com.huawei.datatype.SmartAlarmInfo;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.d.m;
import com.huawei.hwcommonmodel.datatypes.DeviceCapability;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwcommonmodel.fitnessdatatype.ActivityReminder;
import com.huawei.hwcommonmodel.p062a.C0972a;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.hwdataaccessmodel.p065a.C0993c;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.hwfitnessmgr.C1026q;
import com.huawei.hwlocationmgr.util.HWLocation;
import com.huawei.hwversionmgr.p080b.C1071a;
import com.huawei.p108n.C1204c;
import com.huawei.p190v.C2538c;
import com.huawei.u.a;
import com.huawei.ui.device.i;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.helpers.FileWatchdog;

/* compiled from: DeviceSettingsInteractors */
public class C1990r {
    private static volatile C1990r f6943g = null;
    private static HWLocation f6944i = null;
    C1204c f6945a = null;
    a f6946b = null;
    C1026q f6947c = null;
    com.huawei.i.a f6948d = null;
    C1071a f6949e = null;
    boolean f6950f = false;
    private Context f6951h;
    private Handler f6952j = new C1991s(this);
    private com.huawei.hwlocationmgr.a.a f6953k = new C1992t(this);
    private int f6954l = 0;

    public C1990r(Context context) {
        this.f6951h = context;
        this.f6945a = C1204c.m5370a(this.f6951h);
        this.f6946b = a.a();
        this.f6947c = C1026q.m4018a(this.f6951h);
        this.f6948d = com.huawei.i.a.a(this.f6951h);
        this.f6949e = C1071a.m4507a(this.f6951h);
    }

    public static C1990r m10400a(Context context) {
        if (f6943g == null) {
            synchronized (C1990r.class) {
                if (f6943g == null) {
                    f6943g = new C1990r(BaseApplication.m2632b());
                }
            }
        }
        return f6943g;
    }

    public DeviceCapability m10411a() {
        C2538c.m12677c("DeviceSettingsInteractors", "serviceCapabilityNegotiation()");
        return C0972a.m3499a();
    }

    public void m10421a(boolean z, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c("DeviceSettingsInteractors", "setAutoLightScreenSwitchStatus() Status " + z);
        this.f6945a.m5438a(z, iBaseResponseCallback, false);
    }

    public void m10430b(boolean z, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c("DeviceSettingsInteractors", "setDeviceLeftOrRightHandStatus() Status " + z);
        if (C1988p.m10381a(this.f6951h).m10396d() != 2) {
            m10407o();
        }
        this.f6945a.m5448c(z, iBaseResponseCallback, false);
    }

    public int m10410a(IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c("DeviceSettingsInteractors", "getLeftOrRightHandWearStatus enter");
        return this.f6945a.m5446c(iBaseResponseCallback);
    }

    public boolean m10431b() {
        C2538c.m12677c("DeviceSettingsInteractors", "getAutoLightScreenSwitchStatus enter");
        return this.f6945a.m5452e();
    }

    public void m10434c(boolean z, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c("DeviceSettingsInteractors", "setRotateSwitchScreenSwitchStatus() Status " + z);
        this.f6945a.m5445b(z, iBaseResponseCallback, false);
    }

    public boolean m10435c() {
        C2538c.m12677c("DeviceSettingsInteractors", "getRotateSwitchScreenSwitchStatus enter");
        return this.f6945a.m5454f();
    }

    public void m10438d(boolean z, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c("DeviceSettingsInteractors", "setBluetoothOffalertSwitchStatus() Status " + z);
        this.f6946b.a(z, iBaseResponseCallback);
    }

    public boolean m10439d() {
        C2538c.m12677c("DeviceSettingsInteractors", "getBTLostRemindEnable enter");
        return this.f6946b.b();
    }

    public boolean m10441e() {
        C2538c.m12677c("DeviceSettingsInteractors", "isNew" + this.f6949e.m4523f());
        return this.f6949e.m4523f();
    }

    public void m10426b(IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c("DeviceSettingsInteractors", "factoryReset()");
        this.f6945a.m5453f(iBaseResponseCallback);
    }

    public void m10440e(boolean z, IBaseResponseCallback iBaseResponseCallback) {
        ActivityReminder activityReminder = new ActivityReminder();
        activityReminder.setEnabled(z);
        this.f6947c.m4123a(activityReminder, iBaseResponseCallback);
    }

    public boolean m10442f() {
        C2538c.m12677c("DeviceSettingsInteractors", "getActivityReminder()");
        return this.f6947c.m4138e();
    }

    public void m10420a(boolean z) {
        this.f6947c.m4126a(z);
    }

    public boolean m10443g() {
        C2538c.m12677c("DeviceSettingsInteractors", "getHeartRateBtStatus()");
        if (this.f6947c.m4146n() > 0) {
            return true;
        }
        return false;
    }

    public boolean m10444h() {
        C2538c.m12677c("DeviceSettingsInteractors", "getCoreSleepBtStatus()");
        if (1 == this.f6947c.m4144l()) {
            return true;
        }
        return false;
    }

    public void m10433c(IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c("DeviceSettingsInteractors", "getEventAlarm()");
        com.huawei.i.a.a(this.f6951h).a(iBaseResponseCallback);
    }

    public void m10419a(List<EventAlarmInfo> list, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c("DeviceSettingsInteractors", "setEventAlarm()");
        if (C1988p.m10381a(this.f6951h).m10396d() != 2) {
            m10407o();
        }
        com.huawei.i.a.a(this.f6951h).a(list, iBaseResponseCallback, false);
        m10418a((List) list);
    }

    public void m10418a(List<EventAlarmInfo> list) {
        Object arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            EventAlarmInfo eventAlarmInfo = (EventAlarmInfo) list.get(i);
            if (eventAlarmInfo.getEventAlarmRepeat() == 0 && 1 == eventAlarmInfo.getEventAlarmEnable()) {
                arrayList.add(eventAlarmInfo.resetAlarm(eventAlarmInfo, i));
            }
        }
        C2538c.m12677c("DeviceSettingsInteractors", "==once== eventAlarm saveAlarmInfoList.size() = " + arrayList.size());
        if (arrayList.size() > 0) {
            try {
                C0993c c0993c = new C0993c();
                c0993c.f1664a = 0;
                C2538c.m12677c("DeviceSettingsInteractors", "==once== eventAlarm saveOnceAlarm() json = " + new Gson().toJson(arrayList));
                C0996a.m3611a(this.f6951h, String.valueOf(10010), "ONCE_EVENT_ALARM_INFO", r1, c0993c);
            } catch (Exception e) {
                C2538c.m12680e("DeviceSettingsInteractors", "==once== eventAlarm saveOnceAlarm() setSharedPreference error = " + e.getMessage());
            }
        }
    }

    private void m10407o() {
        C2538c.m12677c("DeviceSettingsInteractors", "showNoConnectedToast()");
        com.huawei.ui.commonui.c.a.b(this.f6951h, i.IDS_device_not_connect);
    }

    public void m10437d(IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c("DeviceSettingsInteractors", "getSmartAlarm()");
        com.huawei.i.a.a(this.f6951h).b(iBaseResponseCallback);
    }

    public List<SmartAlarmInfo> m10445i() {
        C2538c.m12677c("DeviceSettingsInteractors", "getSmartAlarmNoCallback()");
        return com.huawei.i.a.a(this.f6951h).a();
    }

    public void m10428b(List<SmartAlarmInfo> list, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c("DeviceSettingsInteractors", "setSmartAlarm()");
        if (C1988p.m10381a(this.f6951h).m10396d() != 2) {
            m10407o();
        }
        com.huawei.i.a.a(this.f6951h).b(list, iBaseResponseCallback, false);
        m10427b((List) list);
    }

    public void m10427b(List<SmartAlarmInfo> list) {
        Object arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            SmartAlarmInfo smartAlarmInfo = (SmartAlarmInfo) list.get(i);
            if (smartAlarmInfo.getSmartAlarmRepeat() == 0 && 1 == smartAlarmInfo.getSmartAlarmEnable()) {
                arrayList.add(smartAlarmInfo.resetSmartAlarm(smartAlarmInfo, i));
            }
        }
        C2538c.m12677c("DeviceSettingsInteractors", "==once== saveOnceSmartAlarm saveAlarmInfoList.size() = " + arrayList.size());
        if (arrayList.size() > 0) {
            try {
                C0993c c0993c = new C0993c();
                c0993c.f1664a = 0;
                C2538c.m12677c("DeviceSettingsInteractors", "==once== saveOnceSmartAlarm() json = " + new Gson().toJson(arrayList));
                C0996a.m3611a(this.f6951h, String.valueOf(10010), "ONCE_SMART_ALARM_INFO", r1, c0993c);
            } catch (Exception e) {
                C2538c.m12680e("DeviceSettingsInteractors", "==once== saveOnceSmartAlarm() setSharedPreference error = " + e.getMessage());
            }
        }
    }

    public String m10446j() {
        C2538c.m12677c("DeviceSettingsInteractors", "getCurrentDeviceProtocol()");
        if (this.f6945a.m5447c() != null) {
            return this.f6945a.m5447c().getDeviceName();
        }
        return "";
    }

    public DeviceInfo m10447k() {
        DeviceInfo c = this.f6945a.m5447c();
        return c != null ? c : null;
    }

    public boolean m10448l() {
        return com.huawei.ad.b.a.a(this.f6951h).a();
    }

    public void m10429b(boolean z) {
        C2538c.m12677c("DeviceSettingsInteractors", "setWeatherReportSwitch weatherReportSwitch=" + z);
        com.huawei.ad.b.a.a(this.f6951h).a(z);
    }

    private void m10408p() {
        C2538c.m12677c("DeviceSettingsInteractors", "stopLocationPosition() ENTER");
        com.huawei.hwlocationmgr.b.a.a(this.f6951h).b(this.f6953k);
    }

    private void m10401a(HWLocation hWLocation) {
        C2538c.m12677c("DeviceSettingsInteractors", "handleWhenGetLocationSuccess() ENTER");
        if (hWLocation == null) {
            C2538c.m12677c("DeviceSettingsInteractors", "handleWhenGetLocationSuccess() if (hwLocation == null)");
            return;
        }
        f6944i = hWLocation;
        C2538c.m12677c("DeviceSettingsInteractors", "handleWhenGetLocationSuccess() getLocationObj Success getLatitude=" + f6944i.getLatitude() + ", getLongitude=" + f6944i.getLongitude());
        m10409q();
    }

    private void m10409q() {
        C2538c.m12677c("DeviceSettingsInteractors", "pushWeather2Device() ENTER");
        if (f6944i == null) {
            C2538c.m12677c("DeviceSettingsInteractors", "pushWeather2Device() if (mHWLocation == null)");
            return;
        }
        com.huawei.hwcloudmodel.mgr.a a = com.huawei.hwcloudmodel.mgr.a.a(this.f6951h);
        double a2 = C0977d.m3522a(f6944i.getLatitude(), 1);
        C2538c.m12677c("DeviceSettingsInteractors", "pushWeather2Device(),latitude = " + a2 + ", longitude = " + C0977d.m3522a(f6944i.getLongitude(), 1));
        a.a(a2, r4, new C1993u(this));
    }

    public void m10449m() {
        if (f6944i == null) {
            C2538c.m12677c("DeviceSettingsInteractors", "pushWeatherReport2Device() if (mHWLocation == null)");
            com.huawei.hwlocationmgr.b.a a = com.huawei.hwlocationmgr.b.a.a(this.f6951h);
            if (a != null) {
                this.f6952j.sendEmptyMessageDelayed(1, FileWatchdog.DEFAULT_DELAY);
                a.a(this.f6953k);
                return;
            }
            return;
        }
        C2538c.m12677c("DeviceSettingsInteractors", "pushWeatherReport2Device() if (mHWLocation == null) ELSE");
        m10409q();
    }

    public void m10417a(Handler handler) {
        C1988p.m10381a(this.f6951h).m10387a(new C1994v(this, handler));
    }

    public void m10425b(Handler handler) {
        m10426b(new C1995w(this, handler));
    }

    public void m10450n() {
        C2538c.m12677c("DeviceSettingsInteractors", "enter handleRestoreFactorySuccess()");
    }

    public List<DataDeviceAvoidDisturbInfo> m10422b(Context context) {
        C1204c a = C1204c.m5370a(context);
        if (a != null) {
            return a.m5457h();
        }
        C2538c.m12680e("DeviceSettingsInteractors", "getNoDisturbInfo() if (hwDeviceConfigManager == null)");
        return null;
    }

    public void m10415a(Context context, IBaseResponseCallback iBaseResponseCallback) {
        C1204c a = C1204c.m5370a(context);
        if (a == null || iBaseResponseCallback == null) {
            C2538c.m12680e("DeviceSettingsInteractors", "getNoDisturbInfo() hwDeviceConfigManager == null || callback == null");
            return;
        }
        a.m5449d(iBaseResponseCallback);
    }

    public void m10414a(Context context, DataDeviceAvoidDisturbInfo dataDeviceAvoidDisturbInfo, IBaseResponseCallback iBaseResponseCallback) {
        C1204c a = C1204c.m5370a(context);
        if (a == null || dataDeviceAvoidDisturbInfo == null) {
            C2538c.m12680e("DeviceSettingsInteractors", "setNoDisturb2Device() hwDeviceConfigManager == null || mDataDeviceAvoidDisturbInfo == null");
            return;
        }
        List arrayList = new ArrayList();
        arrayList.add(dataDeviceAvoidDisturbInfo);
        a.m5435a(arrayList, iBaseResponseCallback, false);
    }

    public List<Contact> m10432c(Context context) {
        com.huawei.h.a a = com.huawei.h.a.a(context);
        if (a != null) {
            return a.a();
        }
        C2538c.m12680e("DeviceSettingsInteractors", "getContact() hwAddressBookManager == null");
        return null;
    }

    public void m10416a(Context context, List<Contact> list, IBaseResponseCallback iBaseResponseCallback) {
        com.huawei.h.a a = com.huawei.h.a.a(context);
        if (a == null || list == null) {
            C2538c.m12680e("DeviceSettingsInteractors", "hwAddressBookManager == null || list == null");
            return;
        }
        C2538c.m12677c("DeviceSettingsInteractors", "before list.size = " + list.size());
        a.a(list, iBaseResponseCallback, false);
    }

    public int m10436d(Context context) {
        com.huawei.h.a a = com.huawei.h.a.a(context);
        if (a != null) {
            return a.b();
        }
        C2538c.m12680e("DeviceSettingsInteractors", "hwAddressBookManager == null");
        return 0;
    }

    public void m10423b(Context context, IBaseResponseCallback iBaseResponseCallback) {
        com.huawei.x.a a = com.huawei.x.a.a(context);
        if (a == null) {
            C2538c.m12680e("DeviceSettingsInteractors", "getOneLevelMenu() hwOneLevelMenuManager == null");
            return;
        }
        a.a(iBaseResponseCallback);
    }

    public void m10424b(Context context, List<Integer> list, IBaseResponseCallback iBaseResponseCallback) {
        com.huawei.x.a a = com.huawei.x.a.a(context);
        if (a == null || list == null) {
            C2538c.m12680e("DeviceSettingsInteractors", "hwOneLevelMenuManager == null || list == null");
            return;
        }
        C2538c.m12677c("DeviceSettingsInteractors", "before list.size = " + list.size());
        a.a(list, iBaseResponseCallback);
    }

    public String m10412a(Context context, int i, int i2) {
        String str = "";
        str = "";
        str = m.a(i);
        String a = m.a(i2);
        String a2 = m10413a(str);
        if (i > i2) {
            str = m10413a(a);
            str = context.getResources().getString(i.IDS_no_disturb_setting_next_day, new Object[]{str});
        } else {
            str = m10413a(a);
        }
        return a2 + "\n" + str;
    }

    public String m10413a(String str) {
        String format;
        ParseException e;
        try {
            format = DateFormat.getTimeFormat(this.f6951h.getApplicationContext()).format(Long.valueOf(new SimpleDateFormat("HH:mm").parse(str).getTime()));
            try {
                C2538c.m12677c("DeviceSettingsInteractors", "getOffsetTimeStr dateFormat time = " + format);
            } catch (ParseException e2) {
                e = e2;
                C2538c.m12677c("DeviceSettingsInteractors", "e.getMessage() = " + e.getMessage());
                return format;
            }
        } catch (ParseException e3) {
            e = e3;
            format = str;
            C2538c.m12677c("DeviceSettingsInteractors", "e.getMessage() = " + e.getMessage());
            return format;
        }
        return format;
    }
}
