package com.huawei.ui.device.views.device;

import android.text.TextUtils;
import com.huawei.hwcommonmodel.p064d.C0978h;
import com.huawei.p190v.C2538c;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: DeviceListItem */
public class C2202h {
    private static Map<String, Integer> f7892g = new HashMap();
    int f7893a = 0;
    private String f7894b;
    private String f7895c;
    private int f7896d = -1;
    private int f7897e = 0;
    private int f7898f;
    private int f7899h = -1;

    public String m11316a() {
        return (String) C0978h.m3579a(this.f7895c);
    }

    public void m11318a(String str) {
        this.f7895c = (String) C0978h.m3579a(str);
    }

    public int m11321b(String str) {
        C2538c.m12677c("DeviceListItem", "getDeviceBatteryValue(): map = " + f7892g);
        for (Entry entry : f7892g.entrySet()) {
            String str2 = (String) entry.getKey();
            if (!TextUtils.isEmpty(str2) && str2.equals(str)) {
                this.f7893a = ((Integer) entry.getValue()).intValue();
            }
        }
        C2538c.m12677c("DeviceListItem", "deviceBattery" + this.f7893a);
        return this.f7893a;
    }

    public void m11319a(String str, int i) {
        int i2;
        int i3 = 100;
        if (i <= 0) {
            i2 = 0;
        } else {
            i2 = i;
        }
        if (100 >= i2) {
            i3 = i2;
        }
        C2538c.m12677c("DeviceListItem", "deviceIdentify = " + str + ", deviceBatteryValue = " + i3);
        f7892g.put(str, Integer.valueOf(i3));
    }

    public int m11320b() {
        return ((Integer) C0978h.m3579a(Integer.valueOf(this.f7897e))).intValue();
    }

    public void m11317a(int i) {
        this.f7897e = ((Integer) C0978h.m3579a(Integer.valueOf(i))).intValue();
    }

    public int m11323c() {
        return ((Integer) C0978h.m3579a(Integer.valueOf(this.f7896d))).intValue();
    }

    public void m11322b(int i) {
        this.f7896d = ((Integer) C0978h.m3579a(Integer.valueOf(i))).intValue();
    }

    public int m11325d() {
        return ((Integer) C0978h.m3579a(Integer.valueOf(this.f7898f))).intValue();
    }

    public void m11324c(int i) {
        this.f7898f = ((Integer) C0978h.m3579a(Integer.valueOf(i))).intValue();
    }

    public String m11326e() {
        return (String) C0978h.m3579a(this.f7894b);
    }

    public int m11327f() {
        return ((Integer) C0978h.m3579a(Integer.valueOf(this.f7899h))).intValue();
    }

    public String toString() {
        return "[ mDeviceTypeName =" + m11316a() + ", mDeviceTypeView=" + this.f7896d + ", mDeviceBatteryValue=" + m11321b(this.f7894b) + ", mConnectStatus=" + m11320b() + ", mDeviceIdentify=" + this.f7894b + ", mDeviceItemType = " + this.f7898f + ", mProductType = " + this.f7899h + "]";
    }

    public C2202h(int i, String str, String str2, int i2, int i3, int i4) {
        this.f7896d = i;
        this.f7895c = str;
        this.f7894b = str2;
        this.f7897e = i2;
        this.f7898f = i3;
        this.f7899h = i4;
    }
}
