package com.huawei.ui.device.views.p173b;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.datatype.EventAlarmInfo;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.p190v.C2538c;
import com.huawei.ui.device.p170a.C1974b;
import java.io.Serializable;
import java.util.List;

/* compiled from: AlarmListItem */
public class C2190b implements Serializable {
    private int f7791a = -1;
    private int f7792b = 0;
    private int f7793c = 0;
    private String f7794d = null;
    private String f7795e = null;
    private String f7796f = null;
    private int f7797g = 0;
    private int f7798h = 0;
    private int f7799i = 1;
    private int f7800j = 0;

    public int m11226a() {
        return this.f7792b;
    }

    public void m11229a(int i) {
        this.f7792b = i;
    }

    public int m11231b() {
        return this.f7793c;
    }

    public void m11232b(int i) {
        this.f7793c = i;
    }

    public String m11234c() {
        return this.f7794d;
    }

    public void m11230a(String str) {
        this.f7794d = str;
    }

    public String m11237d() {
        return this.f7795e;
    }

    public void m11233b(String str) {
        this.f7795e = str;
    }

    public String m11239e() {
        return this.f7796f;
    }

    public void m11236c(String str) {
        this.f7796f = str;
    }

    public int m11241f() {
        return this.f7797g;
    }

    public void m11235c(int i) {
        this.f7797g = i;
    }

    public int m11242g() {
        return this.f7798h;
    }

    public void m11238d(int i) {
        this.f7798h = i;
    }

    public int m11243h() {
        return this.f7799i;
    }

    public void m11240e(int i) {
        this.f7799i = i;
    }

    public String toString() {
        return "AlarmListItem [ID=" + this.f7791a + ", mAlarmTime=" + this.f7794d + ", mAlarmContent=" + this.f7795e + ", mAlarmRepeat=" + this.f7796f + ", mRepeat=" + this.f7797g + ", mEventIndex=" + this.f7798h + ", mType=" + this.f7799i + "]";
    }

    public C2190b m11227a(C2190b c2190b, EventAlarmInfo eventAlarmInfo, C1974b c1974b, Context context) {
        if (!(eventAlarmInfo == null || c1974b == null || context == null)) {
            C2538c.m12677c("AlarmListItem", "strTime=" + C1974b.m10365a(context, (eventAlarmInfo.getEventAlarmStartTime_hour() * 100) + eventAlarmInfo.getEventAlarmStartTime_mins()));
            c2190b.m11229a(eventAlarmInfo.getEventAlarmEnable());
            c2190b.m11232b((eventAlarmInfo.getEventAlarmStartTime_hour() * 100) + eventAlarmInfo.getEventAlarmStartTime_mins());
            c2190b.m11230a(r0);
            c2190b.m11233b(eventAlarmInfo.getEventAlarmName());
            c2190b.m11236c(c1974b.m10366a(eventAlarmInfo.getEventAlarmRepeat()));
            c2190b.m11238d(eventAlarmInfo.getEventAlarmIndex());
            c2190b.m11240e(1);
            C2538c.m12677c("AlarmListItem", "weekRepeat" + r0);
            c2190b.m11235c(eventAlarmInfo.getEventAlarmRepeat());
        }
        return c2190b;
    }

    public C2190b m11228a(C2190b c2190b, EventAlarmInfo eventAlarmInfo, C1974b c1974b, Context context, List<EventAlarmInfo> list, int i) {
        if (!(eventAlarmInfo == null || c1974b == null || context == null || list == null)) {
            C2538c.m12677c("AlarmListItem", "EventAlarmStartTime = " + ((eventAlarmInfo.getEventAlarmStartTime_hour() * 100) + eventAlarmInfo.getEventAlarmStartTime_mins()));
            C2538c.m12677c("AlarmListItem", "EventAlarmName = " + eventAlarmInfo.getEventAlarmName());
            C2538c.m12677c("AlarmListItem", "EventAlarmIndex = " + eventAlarmInfo.getEventAlarmIndex());
            C2538c.m12677c("AlarmListItem", "EventAlarmRepeat = " + eventAlarmInfo.getEventAlarmRepeat());
            C2538c.m12677c("AlarmListItem", "EventAlarmEnable = " + eventAlarmInfo.getEventAlarmEnable());
            String a = C1974b.m10365a(context, (eventAlarmInfo.getEventAlarmStartTime_hour() * 100) + eventAlarmInfo.getEventAlarmStartTime_mins());
            if (eventAlarmInfo.getEventAlarmRepeat() == 0 && 1 == eventAlarmInfo.getEventAlarmEnable()) {
                int a2 = m11225a(eventAlarmInfo, context);
                c2190b.m11229a(a2);
                if (a2 == 0) {
                    this.f7800j = 1;
                    ((EventAlarmInfo) list.get(i)).setEventAlarmEnable(a2);
                }
            } else {
                c2190b.m11229a(eventAlarmInfo.getEventAlarmEnable());
            }
            c2190b.m11232b((eventAlarmInfo.getEventAlarmStartTime_hour() * 100) + eventAlarmInfo.getEventAlarmStartTime_mins());
            c2190b.m11230a(a);
            c2190b.m11233b(eventAlarmInfo.getEventAlarmName());
            c2190b.m11235c(eventAlarmInfo.getEventAlarmRepeat());
            c2190b.m11236c(c1974b.m10366a(eventAlarmInfo.getEventAlarmRepeat()));
            c2190b.m11240e(1);
            c2190b.m11238d(eventAlarmInfo.getEventAlarmIndex());
            C2538c.m12677c("AlarmListItem", "alarm---------------" + c2190b.toString());
        }
        return c2190b;
    }

    public int m11244i() {
        return this.f7800j;
    }

    private int m11225a(EventAlarmInfo eventAlarmInfo, Context context) {
        int i;
        int eventAlarmEnable = eventAlarmInfo.getEventAlarmEnable();
        String a = C0996a.m3612a(context, String.valueOf(10010), "ONCE_EVENT_ALARM_INFO");
        C2538c.m12677c("AlarmListItem", "==once== onceEventAlarmIsOver json = " + a);
        if (TextUtils.isEmpty(a)) {
            C2538c.m12679d("AlarmListItem", "==once== onceEventAlarmIsOver json is null");
            i = eventAlarmEnable;
        } else {
            List list = (List) new Gson().fromJson(a, new C2191c(this).getType());
            i = eventAlarmEnable;
            for (int i2 = 0; i2 < list.size(); i2++) {
                EventAlarmInfo eventAlarmInfo2 = (EventAlarmInfo) list.get(i2);
                if (eventAlarmInfo2.getEventAlarmIndex() == eventAlarmInfo.getEventAlarmIndex()) {
                    C2538c.m12677c("AlarmListItem", "==once== CurTime = " + (System.currentTimeMillis() / 1000));
                    if (System.currentTimeMillis() / 1000 >= eventAlarmInfo2.getEventAlarmTime()) {
                        i = 0;
                    }
                }
            }
        }
        C2538c.m12677c("AlarmListItem", "==once== onceEventAlarmIsOver iRet = " + i);
        return i;
    }
}
