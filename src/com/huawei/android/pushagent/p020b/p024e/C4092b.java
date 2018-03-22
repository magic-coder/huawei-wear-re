package com.huawei.android.pushagent.p020b.p024e;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.huawei.android.pushagent.c.a;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.c.a.f;
import com.huawei.android.pushagent.c.a.h;
import com.huawei.android.pushagent.p017a.p322b.C4055n;
import com.huawei.android.pushagent.p017a.p322b.C4057p;
import com.huawei.android.pushagent.p017a.p322b.p323a.C4041b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class C4092b {
    private static C4092b f15487b = null;
    public HashMap f15488a = new HashMap();

    private C4092b(Context context) {
        e.a("PushLogAC2712", "DeviceTokenMgr: create the DeviceTokenMgr");
        h hVar = new h(context, "pclient_info_v2");
        Set<String> keySet = hVar.b().keySet();
        if (keySet != null && keySet.size() > 0) {
            for (String str : keySet) {
                CharSequence a = f.a(context, str);
                e.a("PushLogAC2712", "packageName:" + str + " token:" + com.huawei.android.pushagent.c.a.a.e.a(a));
                if (TextUtils.isEmpty(a)) {
                    hVar.f(str);
                } else {
                    this.f15488a.put(a, str);
                }
            }
        }
    }

    public static synchronized C4092b m20086a(Context context) {
        C4092b c4092b;
        synchronized (C4092b.class) {
            if (f15487b != null) {
                c4092b = f15487b;
            } else {
                f15487b = new C4092b(context);
                c4092b = f15487b;
            }
        }
        return c4092b;
    }

    static void m20087a(Context context, String str, String str2) {
        if (C4092b.m20086a(context).f15488a == null) {
            e.d("PushLogAC2712", "responseRegisterToken the map is null!!! ");
            return;
        }
        C4092b.m20086a(context).f15488a.put(str, str2);
        f.b(context, str2, str);
    }

    private static void m20088a(Context context, String str, ArrayList arrayList, ArrayList arrayList2) {
        h hVar = new h(context, "pclient_request_info");
        for (String str2 : hVar.b().keySet()) {
            if (arrayList2.contains(str2)) {
                arrayList.add(C4092b.m20091b(context, str, str2));
                e.a("PushLogAC2712", "the package name is : " + str2 + " need register");
            } else {
                e.a("PushLogAC2712", "the package name is : " + str2 + " has removed");
                hVar.f(str2);
            }
        }
    }

    public static void m20089a(Context context, String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            h hVar = new h(context, "pclient_info_v2");
            h hVar2 = new h(context, "pclient_request_info");
            for (String str : strArr) {
                e.a("PushLogAC2712", str + " need to register again");
                String a = f.a(context, str);
                hVar.f(str);
                C4092b.m20086a(context).f15488a.remove(a);
                hVar2.a(str, "true");
            }
        }
    }

    public static boolean m20090a(Context context, String str) {
        h hVar = new h(context, "pclient_info_v2");
        return hVar.e(str) && !TextUtils.isEmpty(hVar.b(str));
    }

    private static C4041b m20091b(Context context, String str, String str2) {
        return new C4055n(str, a.f(context, str2));
    }

    public static ArrayList m20092b(Context context) {
        h hVar = new h(context, "pclient_info_v2");
        ArrayList arrayList = new ArrayList();
        List queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(new Intent("com.huawei.android.push.intent.RECEIVE"), 640);
        int size = queryBroadcastReceivers == null ? 0 : queryBroadcastReceivers.size();
        if (size == 0) {
            e.a("PushLogAC2712", "we have no push client");
            return arrayList;
        }
        String a = a.a(context);
        ArrayList arrayList2 = new ArrayList();
        Set<String> keySet = hVar.b().keySet();
        for (int i = 0; i < size; i++) {
            ResolveInfo resolveInfo = (ResolveInfo) queryBroadcastReceivers.get(i);
            ComponentInfo componentInfo = resolveInfo.activityInfo != null ? resolveInfo.activityInfo : resolveInfo.serviceInfo;
            if (!(componentInfo == null || TextUtils.isEmpty(componentInfo.packageName) || "com.huawei.android.pushagent".equals(componentInfo.packageName))) {
                arrayList2.add(componentInfo.packageName);
            }
        }
        C4092b.m20088a(context, a, arrayList, arrayList2);
        if (keySet != null && keySet.size() > 0) {
            for (String str : keySet) {
                if (!arrayList2.contains(str)) {
                    String a2 = f.a(context, str);
                    e.a("PushLogAC2712", "this package [" + str + "] need to unregister device toeken");
                    arrayList.add(new C4057p(a2));
                    C4092b.m20093b(context, str);
                }
            }
        }
        if (arrayList.size() == 0) {
            e.a("PushLogAC2712", "there is no more client need register and unregister token");
        }
        return arrayList;
    }

    static void m20093b(Context context, String str) {
        if (C4092b.m20086a(context).f15488a == null) {
            e.d("PushLogAC2712", "when removeClientInfo, tokenMap the map is null!!! ");
        } else {
            new h(context, "pclient_info_v2").f(str);
        }
    }

    public static void m20094c(Context context) {
        h hVar = new h(context, "pclient_info_v2");
        Map b = hVar.b();
        if (b != null && b.size() > 0) {
            h hVar2 = new h(context, "pclient_request_info");
            for (String str : b.keySet()) {
                hVar2.a(str, "true");
                e.a("PushLogAC2712", str + " need to register again");
            }
            hVar.c();
            C4092b.m20086a(context).f15488a.clear();
        }
    }

    static void m20095c(Context context, String str) {
        String str2 = "";
        if (C4092b.m20086a(context).f15488a != null) {
            str2 = (String) C4092b.m20086a(context).f15488a.get(str);
        }
        h hVar = new h(context, "pclient_info_v2");
        e.a("PushLogAC2712", "responseUnregisterToken,after delPClientInfo token,  packagename: " + str2);
        C4092b.m20086a(context).f15488a.remove(str);
        hVar.f(str2);
    }

    public static String m20096d(Context context, String str) {
        return f.a(context, str);
    }
}
