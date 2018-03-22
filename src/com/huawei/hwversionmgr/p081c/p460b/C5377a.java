package com.huawei.hwversionmgr.p081c.p460b;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.huawei.hwversionmgr.utils.a.a;
import com.huawei.hwversionmgr.utils.a.c;
import com.huawei.hwversionmgr.utils.p084b.C5380b;
import com.huawei.hwversionmgr.utils.p084b.C5386i;
import com.huawei.p190v.C2538c;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: HwSelfUpdate */
public class C5377a {
    private ExecutorService f19139a = Executors.newFixedThreadPool(3);

    public void m25851a(Context context, c cVar, Boolean bool) {
        Runnable c5380b = new C5380b(context, cVar, bool);
        C5380b.m25876a(false);
        this.f19139a.execute(c5380b);
    }

    public void m25852a(PackageInfo packageInfo, String str, Context context, a aVar, Boolean bool) {
        C2538c.b("MainHwSelfUpdate", new Object[]{"startCheckNewVersionForBone begin"});
        Runnable c5386i = new C5386i(context, packageInfo.packageName, aVar, bool);
        c5386i.m25905a(packageInfo);
        c5386i.m25906a(str);
        C5386i.m25903a(false);
        this.f19139a.execute(c5386i);
        C2538c.b("MainHwSelfUpdate", new Object[]{"startCheckNewVersionForBone end"});
    }
}
