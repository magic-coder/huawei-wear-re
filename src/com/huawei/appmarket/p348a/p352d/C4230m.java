package com.huawei.appmarket.p348a.p352d;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.huawei.appmarket.C4234a;
import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class C4230m {
    protected static final C4225h f15868a = new C4225h();
    private static final ExecutorService f15869b = Executors.newFixedThreadPool(1);

    private static C4220c m20504a(String str, C4226i c4226i) {
        C4220c a = f15868a.m20500a(str, c4226i);
        return a != null ? a : null;
    }

    protected static void m20506a(int i, int i2) {
        switch (i) {
            case 3:
                C4230m.m20507a(C4234a.m20519a().m20523b(), i2, 3);
                return;
            case 4:
                C4230m.m20507a(C4234a.m20519a().m20523b(), i2, 4);
                return;
            case 5:
                C4230m.m20507a(C4234a.m20519a().m20523b(), i2, 5);
                return;
            default:
                return;
        }
    }

    public static void m20507a(Context context, int i, int i2) {
        Intent intent = new Intent();
        String a = C4221d.m20497a();
        Bundle bundle = new Bundle();
        bundle.putInt("INSTALL_STATE", i2);
        bundle.putInt("INSTALL_TYPE", i);
        intent.putExtras(bundle);
        intent.setAction(a);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    private static synchronized void m20508a(C4224g c4224g, String str, String str2, Object obj, int i, boolean z, C4218a c4218a) {
        synchronized (C4230m.class) {
            C4241a.m20529a("PackageService", "process:processType=" + c4224g + ",path=" + str + ",packageName:" + str2 + ",flag=" + i + ",isNow=" + z);
            C4220c c4220c = null;
            if (c4224g == C4224g.INSTALL) {
                if (TextUtils.isEmpty(str)) {
                    C4241a.m20532b("PackageService", "install failed!!!path is empty!!!!");
                } else {
                    c4220c = new C4220c(str2, str, obj);
                    if (i == 0) {
                        c4220c.f15838b = C4223f.NOT_HANDLER;
                    } else {
                        c4220c.f15838b = C4223f.WAIT_INSTALL;
                    }
                    if (i == 0) {
                        C4241a.m20529a("PackageService", "flag is 0,so just record the task and return!!!");
                    } else {
                        c4220c.f15841e = false;
                        if (C4241a.m20531a()) {
                            C4241a.m20529a("PackageService", "package:" + c4220c.f15842f + " is not update app!!!");
                        }
                        if (c4220c.f15839c == null) {
                            C4241a.m20529a("PackageService", "task.param is null!!");
                        }
                        f15868a.m20498a(str2, c4220c);
                    }
                }
            }
            if (c4220c != null) {
                c4220c.f15844h = c4224g;
                c4220c.f15840d = i;
                if (c4218a != null) {
                    c4220c.f15845i = c4218a;
                }
                if (z) {
                    c4220c.m20495a();
                }
                String str3 = "install|pkg:" + c4220c.f15842f + "|path:" + c4220c.f15843g + "|flag:" + c4220c.f15840d;
                Thread thread = new Thread(new C4227j(C4234a.m20519a().m20523b(), c4220c));
                thread.setName(str3);
                thread.start();
            }
        }
    }

    public static void m20509a(String str, String str2, Object obj, int i, boolean z) {
        C4230m.m20508a(C4224g.INSTALL, str, str2, obj, i, z, null);
    }

    private static C4220c m20510b(String str) {
        return C4230m.m20504a(str, C4226i.INSTALL_TYPE);
    }
}
