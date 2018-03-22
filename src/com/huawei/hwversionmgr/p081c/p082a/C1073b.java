package com.huawei.hwversionmgr.p081c.p082a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.huawei.hwversionmgr.utils.C1078c;
import com.huawei.hwversionmgr.utils.p083a.C1074a;
import com.huawei.hwversionmgr.utils.p083a.C1075b;
import com.huawei.hwversionmgr.utils.p083a.C1076c;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.account.interactor.WeChat;

/* compiled from: UpdateBase */
public class C1073b {
    protected Context f2159a = null;
    protected C1072a f2160b = null;
    private String f2161c = "";

    public C1073b(Context context) {
        this.f2159a = context;
        this.f2160b = new C1072a();
        this.f2161c = "https://query.hicloud.com/Ring/v2/CheckEx.action?ruleAttr=true";
        C2538c.m12674b("UpdateBase", "UpdateBase() mUpdateServerUrl=" + this.f2161c);
    }

    public void m4543a(String str, C1074a c1074a) {
        C2538c.m12674b("UpdateBase", "checkAppNewVersion() telephIMEI=" + str + ",+handler = " + c1074a);
        C2538c.m12674b("UpdateBase", "checkAppNewVersion() mUpdateServerUrl=" + this.f2161c);
        C1078c.m4563a(this.f2161c);
        PackageInfo b = m4536b();
        if (b != null) {
            this.f2160b.m4535a(b, str, this.f2159a, c1074a, Boolean.valueOf(true));
            return;
        }
        c1074a.mo2345a(3);
    }

    public void m4545b(String str, C1074a c1074a) {
        C2538c.m12674b("UpdateBase", "checkHiHealthAppNewVersion() telephIMEI=" + str + ",+handler = " + c1074a);
        C2538c.m12674b("UpdateBase", "checkHiHealthAppNewVersion() mUpdateServerUrl=" + this.f2161c);
        C1078c.m4563a(this.f2161c);
        this.f2160b.m4535a(C1073b.m4537c(), str, this.f2159a, c1074a, Boolean.valueOf(true));
    }

    public void m4540a(int i, String str, String str2, C1074a c1074a) {
        C2538c.m12674b("UpdateBase", "checkBandNewVersion() type=" + i + ",+version = " + str + ",+macAddress = " + str2 + ",+handler = " + c1074a);
        C2538c.m12674b("UpdateBase", "checkBandNewVersion() mUpdateServerUrl=" + this.f2161c);
        C1078c.m4563a(this.f2161c);
        PackageInfo a = m4538a(i, str);
        if (a != null) {
            this.f2160b.m4535a(a, str2, this.f2159a, c1074a, Boolean.valueOf(false));
            return;
        }
        c1074a.mo2345a(3);
    }

    public PackageInfo m4538a(int i, String str) {
        C2538c.m12674b("UpdateBase", "getBandPackageInfo() type=" + i + ",+version = " + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        PackageInfo packageInfo = new PackageInfo();
        switch (i) {
            case 1:
                packageInfo.packageName = "com.huawei.btwo.firmware";
                break;
            case 4:
                packageInfo.packageName = "com.huawei.none.firmware";
                break;
            case 5:
                packageInfo.packageName = "com.huawei.bzero.firmware";
                break;
            case 7:
                packageInfo.packageName = "com.huawei.gemini.firmware";
                break;
            case 8:
                packageInfo.packageName = "com.huawei.metis.firmware";
                break;
            case 12:
                packageInfo.packageName = "com.huawei.aonepro.firmware";
                break;
            case 13:
                packageInfo.packageName = "com.huawei.nyx.firmware";
                break;
            case 14:
                packageInfo.packageName = "com.huawei.grus.firmware";
                break;
            case 15:
                packageInfo.packageName = "com.huawei.Eris.firmware";
                break;
            default:
                return null;
        }
        packageInfo.versionCode = 0;
        packageInfo.versionName = str;
        return packageInfo;
    }

    private PackageInfo m4536b() {
        try {
            return this.f2159a.getPackageManager().getPackageInfo(this.f2159a.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    private static PackageInfo m4537c() {
        PackageInfo packageInfo = new PackageInfo();
        packageInfo.packageName = WeChat.HEALTH_PACKAGE_NAME;
        return packageInfo;
    }

    public void m4542a(C1076c c1076c, Boolean bool) {
        this.f2160b.m4533a(this.f2159a, c1076c, bool);
    }

    public void m4541a(C1075b c1075b, Boolean bool) {
        this.f2160b.m4532a(this.f2159a, c1075b, bool);
    }

    public void m4544a(String str, String str2) {
        C2538c.m12674b("UpdateBase", "install: path = " + str + ", version = " + str2);
        C2538c.m12674b("UpdateBase", "install: pkgName = " + this.f2159a.getPackageName());
        this.f2160b.m4534a(this.f2159a, str, r0);
    }

    public void m4539a() {
        this.f2160b.m4531a(this.f2159a);
    }
}
