package com.huawei.ui.device.p171b;

import android.content.Context;
import android.text.format.DateFormat;
import com.huawei.hwbasemgr.C0956c;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.wheelview21.WheelView;
import com.huawei.ui.commonui.wheelview21.a;
import com.huawei.ui.commonui.wheelview21.c;
import com.huawei.ui.device.i;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: AlarmInteractor */
public class C2183a {
    private static C2183a f7771b;
    private Context f7772a;

    private C2183a(Context context) {
        this.f7772a = context;
    }

    public static C2183a m11184a(Context context) {
        if (f7771b == null) {
            f7771b = new C2183a(BaseApplication.m2632b());
        }
        return f7771b;
    }

    public c m11189a(int i, int i2, WheelView wheelView, WheelView wheelView2, WheelView wheelView3, WheelView wheelView4, a aVar) {
        int i3;
        CharSequence a = C2183a.m11185a(this.f7772a, (i * 100) + i2);
        if (a != null) {
            i3 = 0;
            Matcher matcher = Pattern.compile("\\d").matcher(a);
            if (matcher.find()) {
                i3 = matcher.start();
            }
            if (i3 != 0 || com.huawei.ui.commonui.d.c.e(this.f7772a)) {
                wheelView.setVisibility(0);
                wheelView2.setVisibility(8);
                wheelView.a(2, true);
                wheelView3.a(2, false);
                wheelView4.a(2, false);
                wheelView2 = wheelView;
            } else {
                wheelView.setVisibility(8);
                wheelView2.setVisibility(0);
                wheelView3.a(2, false);
                wheelView4.a(2, false);
                wheelView2.a(2, true);
            }
        } else {
            wheelView2 = null;
        }
        c cVar = new c(this.f7772a, wheelView2, wheelView3, wheelView4);
        String[] a2 = m11193a(12);
        String[] a3 = m11192a();
        String[] strArr = new String[]{this.f7772a.getString(i.IDS_settings_alarm_am), this.f7772a.getString(i.IDS_settings_alarm_pm)};
        Calendar instance = Calendar.getInstance();
        instance.set(11, i);
        instance.set(12, i2);
        int i4 = instance.get(9);
        i3 = instance.get(10);
        if (i3 == 0) {
            i3 = 12;
        }
        cVar.a(strArr, i4, false);
        cVar.b(a2, i3 - 1, true);
        cVar.a(aVar);
        cVar.c(a3, i2, true);
        cVar.b(aVar);
        cVar.c(aVar);
        return cVar;
    }

    public c m11190a(int i, int i2, WheelView wheelView, WheelView wheelView2, WheelView wheelView3, a aVar) {
        wheelView.setVisibility(8);
        wheelView2.a(1, false);
        wheelView3.a(1, false);
        c cVar = new c(this.f7772a, wheelView2, wheelView3);
        String[] a = m11193a(24);
        String[] a2 = m11192a();
        cVar.a(a, i, true);
        cVar.a(aVar);
        cVar.c(a2, i2, true);
        cVar.b(aVar);
        C2538c.m12677c("AlarmInteractor", "init24HourView  leave");
        return cVar;
    }

    public int m11187a(c cVar) {
        int parseInt;
        int parseInt2 = Integer.parseInt(cVar.c());
        if (DateFormat.is24HourFormat(this.f7772a)) {
            parseInt = Integer.parseInt(cVar.a());
        } else {
            parseInt = Integer.parseInt(cVar.b());
            if (this.f7772a.getString(i.IDS_settings_alarm_pm).equals(cVar.a())) {
                if (parseInt != 12) {
                    parseInt += 12;
                }
            } else if (parseInt == 12) {
                parseInt = 0;
            }
        }
        C2538c.m12677c("AlarmInteractor", "getAlarmTimeFromUI -> time = " + ((parseInt * 100) + parseInt2));
        return (parseInt * 100) + parseInt2;
    }

    public String[] m11193a(int i) {
        String[] strArr = new String[i];
        int i2;
        if (24 == i) {
            for (i2 = 0; i2 < i; i2++) {
                if (i2 < 10) {
                    strArr[i2] = C0956c.m3344a(0.0d, 1, 0) + C0956c.m3344a((double) i2, 1, 0);
                } else {
                    strArr[i2] = C0956c.m3344a((double) i2, 1, 0);
                }
            }
        } else {
            for (i2 = 1; i2 < i + 1; i2++) {
                if (i2 < 10) {
                    strArr[i2 - 1] = C0956c.m3344a(0.0d, 1, 0) + C0956c.m3344a((double) i2, 1, 0);
                } else {
                    strArr[i2 - 1] = C0956c.m3344a((double) i2, 1, 0);
                }
            }
        }
        return strArr;
    }

    public String[] m11192a() {
        String[] strArr = new String[60];
        for (int i = 0; i < 60; i++) {
            if (i < 10) {
                strArr[i] = C0956c.m3344a(0.0d, 1, 0) + C0956c.m3344a((double) i, 1, 0);
            } else {
                strArr[i] = C0956c.m3344a((double) i, 1, 0);
            }
        }
        return strArr;
    }

    public static String m11185a(Context context, int i) {
        return C2184b.m11196a(context, i);
    }

    public String m11194b(int i) {
        if (this.f7772a == null) {
            return "";
        }
        return C2184b.m11195a(i, this.f7772a.getApplicationContext());
    }

    public int m11188a(boolean[] zArr) {
        int i;
        C2538c.m12677c("AlarmInteractor", "getRemindWeek()");
        if (zArr[6]) {
            i = 64;
        } else {
            i = 0;
        }
        if (zArr[5]) {
            i += 32;
        }
        if (zArr[4]) {
            i += 16;
        }
        if (zArr[3]) {
            i += 8;
        }
        if (zArr[2]) {
            i += 4;
        }
        if (zArr[1]) {
            i += 2;
        }
        if (zArr[0]) {
            i++;
        }
        C2538c.m12677c("AlarmInteractor", "getRemindWeek() iWeek=" + i);
        return i;
    }

    public String m11191a(String str, int i) {
        while (str.length() < i) {
            str = "0" + str;
        }
        return str;
    }

    public int m11186a(int i, int i2, int i3) {
        int i4;
        if (i2 - i3 > 0) {
            i4 = i2 - i3;
        } else {
            i = ((i - 1) + 24) % 24;
            i4 = (i2 - i3) + 60;
        }
        return i4 + (i * 100);
    }
}
