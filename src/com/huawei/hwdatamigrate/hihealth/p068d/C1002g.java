package com.huawei.hwdatamigrate.hihealth.p068d;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.huawei.hihealth.HiDeviceInfo;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hwdatamigrate.hihealth.c.a;
import com.huawei.hwdatamigrate.hihealth.c.bs;
import com.huawei.hwdatamigrate.hihealth.c.y;
import com.huawei.p190v.C2538c;

/* compiled from: HiHealthContext */
public class C1002g {
    private int f1690a;
    private int f1691b;
    private int f1692c;
    private int f1693d;
    private String f1694e;
    private int f1695f;
    private long f1696g;

    public C1002g(int i) {
        this.f1690a = i;
    }

    public C1002g(int i, String str) {
        this.f1690a = i;
        this.f1694e = str;
    }

    public C1002g(int i, int i2, int i3, int i4) {
        this.f1690a = i;
        this.f1691b = i2;
        this.f1692c = i3;
        this.f1693d = i4;
    }

    public C1002g(int i, int i2, int i3) {
        this.f1690a = i3;
        this.f1691b = i2;
        this.f1692c = i;
    }

    public int m3675a() {
        return this.f1695f;
    }

    public void m3676a(int i) {
        this.f1695f = i;
    }

    public String m3678b() {
        return this.f1694e;
    }

    public int m3680c() {
        return this.f1693d;
    }

    public void m3679b(int i) {
        this.f1693d = i;
    }

    public int m3682d() {
        return this.f1690a;
    }

    public void m3681c(int i) {
        this.f1690a = i;
    }

    public int m3684e() {
        return this.f1691b;
    }

    public void m3683d(int i) {
        this.f1691b = i;
    }

    public int m3686f() {
        return this.f1692c;
    }

    public void m3685e(int i) {
        this.f1692c = i;
    }

    public long m3687g() {
        return this.f1696g;
    }

    public void m3677a(long j) {
        this.f1696g = j;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("HiHealthContext{");
        stringBuffer.append("app=").append(this.f1690a);
        stringBuffer.append(", device=").append(this.f1691b);
        stringBuffer.append(", client=").append(this.f1693d);
        stringBuffer.append(", who=").append(this.f1692c);
        stringBuffer.append(", packageName='").append(this.f1694e).append('\'');
        stringBuffer.append(", syncType=").append(this.f1695f);
        stringBuffer.append(", cloudDevice=").append(this.f1696g);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public static int m3672a(Context context, int i) {
        return bs.a(context).a(a.a(context).b(i), 0);
    }

    public static void m3674a(HiHealthData hiHealthData, C1002g c1002g) {
        hiHealthData.setUserID(c1002g.m3686f());
        hiHealthData.setAppID(c1002g.m3682d());
        hiHealthData.setDeviceID(c1002g.m3684e());
        hiHealthData.setClientID(c1002g.m3680c());
        hiHealthData.setSyncStatus(c1002g.m3675a());
    }

    public static int m3673a(Context context, String str) {
        int a = y.a(context).a(str);
        if (a > 0 || !com.huawei.hihealth.c.a.a(context).equals(str)) {
            return a;
        }
        C2538c.m12679d("HiH_HiHealthContext", "getDeviceID deviceUUID = android_ ");
        HiDeviceInfo hiDeviceInfo = new HiDeviceInfo();
        hiDeviceInfo.setDeviceUniqueCode(str);
        hiDeviceInfo.setDeviceType(32);
        hiDeviceInfo.setDeviceName(Build.MANUFACTURER);
        hiDeviceInfo.setSoftwareVersion(VERSION.RELEASE);
        C2538c.m12677c("HiH_HiHealthContext", "getDeviceID deviceUUID = android_ device = ", Integer.valueOf((int) y.a(context).a(hiDeviceInfo)));
        return (int) y.a(context).a(hiDeviceInfo);
    }
}
