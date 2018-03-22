package com.huawei.hwversionmgr.p081c.p082a;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.huawei.hwversionmgr.p079a.C1068c;
import com.huawei.hwversionmgr.utils.C1078c;
import com.huawei.hwversionmgr.utils.b.b;
import com.huawei.hwversionmgr.utils.b.i;
import com.huawei.hwversionmgr.utils.b.l;
import com.huawei.hwversionmgr.utils.b.m;
import com.huawei.hwversionmgr.utils.p083a.C1074a;
import com.huawei.hwversionmgr.utils.p083a.C1075b;
import com.huawei.hwversionmgr.utils.p083a.C1076c;
import com.huawei.hwversionmgr.utils.p084b.C1077f;
import com.huawei.p190v.C2538c;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: HwSelfUpdate */
public class C1072a {
    private ExecutorService f2158a = Executors.newFixedThreadPool(3);

    public void m4533a(Context context, C1076c c1076c, Boolean bool) {
        Runnable bVar = new b(context, c1076c, bool);
        b.a(false);
        new Thread(bVar).start();
    }

    public void m4534a(Context context, String str, String str2) {
        C1078c.m4561a(context, str, str2);
    }

    public void m4532a(Context context, C1075b c1075b, Boolean bool) {
        C2538c.m12674b("HwSelfUpdate", "startDownloadApp isApp:" + bool);
        long d = C1078c.m4575d();
        C2538c.m12674b("HwSelfUpdate", "downloadStartTime = " + d + "; currentTime = " + System.currentTimeMillis());
        C2538c.m12674b("HwSelfUpdate", "start download");
        m.a(true);
        C1078c.m4559a(r2);
        this.f2158a.execute(new l(context, c1075b, bool));
        C1068c c1068c = new C1068c();
        c1068c.f2123a = 1;
        c1068c.f2124b = C1078c.m4574c(context);
        if (bool.booleanValue() && C1078c.m4587i() != null) {
            c1068c.f2125c = C1078c.m4587i().f2130c;
        } else if (!(bool.booleanValue() || C1078c.m4588j() == null)) {
            c1068c.f2125c = C1078c.m4588j().f2130c;
        }
        c1068c.f2126d = C1078c.m4557a(C1078c.m4586h(), context);
        c1068c.f2127e = "";
        this.f2158a.execute(new C1077f(context, c1068c));
    }

    public void m4535a(PackageInfo packageInfo, String str, Context context, C1074a c1074a, Boolean bool) {
        C2538c.m12674b("HwSelfUpdate", "startCheckNewVersionForBone");
        Runnable iVar = new i(context, packageInfo.packageName, c1074a, bool);
        iVar.a(packageInfo);
        iVar.a(str);
        i.a(false);
        this.f2158a.execute(iVar);
    }

    public void m4531a(Context context) {
        C2538c.m12674b("HwSelfUpdate", "cancelDownloadApp");
        C1078c.m4559a(-1);
        m.a(true);
    }
}
