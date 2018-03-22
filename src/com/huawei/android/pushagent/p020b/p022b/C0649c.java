package com.huawei.android.pushagent.p020b.p022b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.huawei.android.pushagent.b.a.b.b.a;
import com.huawei.android.pushagent.p017a.C0642a;
import com.huawei.android.pushagent.p018c.p019a.C0657e;
import com.huawei.hwid.core.constants.HwAccountConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public class C0649c {
    public static final HashMap f1168a = new HashMap();
    private static C0649c f1169b = null;
    private HashMap f1170c = new HashMap();
    private Context f1171d = null;

    static {
        C0649c.m2465c();
    }

    private C0649c(Context context) {
        this.f1171d = context;
        m2467a();
    }

    public static int m2455a(Context context, String str, int i) {
        try {
            Object b = C0649c.m2463b(context, str);
            if (b != null) {
                i = ((Integer) b).intValue();
            }
        } catch (Throwable e) {
            C0657e.m2521c("PushLogAC2712", e.toString(), e);
        }
        return i;
    }

    public static long m2456a(Context context, String str, long j) {
        try {
            Object b = C0649c.m2463b(context, str);
            return b == null ? j : b instanceof Integer ? (long) ((Integer) b).intValue() : b instanceof Long ? ((Long) b).longValue() : j;
        } catch (Throwable e) {
            C0657e.m2521c("PushLogAC2712", e.toString(), e);
            return j;
        }
    }

    public static C0642a m2457a(Context context, String str) {
        if (C0649c.m2458a(context) == null || str == null) {
            return null;
        }
        C0642a c0642a = (C0642a) f1169b.f1170c.get(str);
        return c0642a == null ? null : c0642a;
    }

    public static synchronized C0649c m2458a(Context context) {
        C0649c c0649c;
        synchronized (C0649c.class) {
            if (f1169b != null) {
                c0649c = f1169b;
            } else if (context == null) {
                c0649c = null;
            } else {
                f1169b = new C0649c(context);
                c0649c = f1169b;
            }
        }
        return c0649c;
    }

    public static String m2459a(Context context, String str, String str2) {
        Object b = C0649c.m2463b(context, str);
        if (b == null) {
            return str2;
        }
        String str3;
        try {
            str3 = (String) b;
        } catch (Exception e) {
            C0657e.m2512a("PushLogAC2712", "getString from config failed!");
            str3 = str2;
        }
        return str3;
    }

    public static void m2460a(Context context, C0642a c0642a) {
        if (c0642a == null || c0642a.f1153a == null) {
            C0657e.m2522d("PushLogAC2712", "set value err, cfg is null or itemName is null, cfg:" + c0642a);
        } else if (C0649c.m2458a(context) == null) {
            C0657e.m2522d("PushLogAC2712", "System init failed in set Value");
        } else {
            f1169b.f1170c.put(c0642a.f1153a, c0642a);
            f1169b.m2464b(context, c0642a);
        }
    }

    public static boolean m2461a(Context context, String str, boolean z) {
        try {
            Object b = C0649c.m2463b(context, str);
            if (b != null) {
                z = ((Boolean) b).booleanValue();
            }
        } catch (Throwable e) {
            C0657e.m2521c("PushLogAC2712", e.toString(), e);
        }
        return z;
    }

    public static a m2462b(Context context) {
        C0642a a = C0649c.m2457a(context, "USE_SSL");
        a aVar = a.b;
        if (a == null) {
            return aVar;
        }
        C0657e.m2512a("PushLogAC2712", HwAccountConstants.BLANK + a);
        Integer num = (Integer) a.f1154b;
        if (num.intValue() >= 0 && num.intValue() < a.values().length) {
            return a.values()[num.intValue()];
        }
        C0657e.m2522d("PushLogAC2712", "useSSL:" + a.f1154b + " is invalid cfg");
        return aVar;
    }

    private static Object m2463b(Context context, String str) {
        if (C0649c.m2458a(context) == null) {
            return null;
        }
        C0642a c0642a = (C0642a) f1169b.f1170c.get(str);
        return c0642a == null ? null : c0642a.f1154b;
    }

    private boolean m2464b(Context context, C0642a c0642a) {
        if (context == null) {
            context = this.f1171d;
        }
        Editor edit = context.getSharedPreferences("pushConfig", 4).edit();
        if (Boolean.class == c0642a.f1155c) {
            edit.putBoolean(c0642a.f1153a, ((Boolean) c0642a.f1154b).booleanValue());
        } else if (String.class == c0642a.f1155c) {
            edit.putString(c0642a.f1153a, (String) c0642a.f1154b);
        } else if (Long.class == c0642a.f1155c) {
            edit.putLong(c0642a.f1153a, ((Long) c0642a.f1154b).longValue());
        } else if (Integer.class == c0642a.f1155c) {
            edit.putInt(c0642a.f1153a, ((Integer) c0642a.f1154b).intValue());
        } else if (Float.class == c0642a.f1155c) {
            edit.putFloat(c0642a.f1153a, ((Float) c0642a.f1154b).floatValue());
        }
        return edit.commit();
    }

    private static void m2465c() {
        f1168a.clear();
        f1168a.put("cloudpush_isLogLocal", new C0642a("cloudpush_isLogLocal", Boolean.class, Boolean.valueOf(false)));
        f1168a.put("cloudpush_pushLogLevel", new C0642a("cloudpush_pushLogLevel", Integer.class, Integer.valueOf(4)));
        f1168a.put("cloudpush_isReportLog", new C0642a("cloudpush_isReportLog", Boolean.class, Boolean.valueOf(false)));
        f1168a.put("cloudpush_isNoDelayConnect", new C0642a("cloudpush_isNoDelayConnect", Boolean.class, Boolean.valueOf(false)));
        f1168a.put("cloudpush_isSupportUpdate", new C0642a("cloudpush_isSupportUpdate", Boolean.class, Boolean.valueOf(false)));
        f1168a.put("cloudpush_isSupportCollectSocketInfo", new C0642a("cloudpush_isSupportCollectSocketInfo", Boolean.class, Boolean.valueOf(false)));
        f1168a.put("cloudpush_trsIp", new C0642a("cloudpush_trsIp", String.class, "push.hicloud.com"));
        f1168a.put("cloudpush_fixHeatBeat", new C0642a("cloudpush_fixHeatBeat", String.class, " unit sec"));
        f1168a.put("USE_SSL", new C0642a("USE_SSL", Integer.class, Integer.valueOf(a.b.ordinal())));
    }

    private void m2466d() {
        this.f1170c.clear();
        SharedPreferences sharedPreferences = this.f1171d.getSharedPreferences("pushConfig", 4);
        this.f1170c.putAll(f1168a);
        for (Entry entry : sharedPreferences.getAll().entrySet()) {
            this.f1170c.put(entry.getKey(), new C0642a((String) entry.getKey(), entry.getValue().getClass(), entry.getValue()));
        }
    }

    public void m2467a() {
        C0649c.m2465c();
        m2466d();
    }

    public void m2468b() {
        Editor edit = this.f1171d.getSharedPreferences("pushConfig", 4).edit();
        Set<String> keySet = this.f1170c.keySet();
        LinkedList linkedList = new LinkedList();
        for (String str : keySet) {
            if (!(f1168a.containsKey(str) || "NeedMyServiceRun".equals(str) || "votedPackageName".equals(str) || "forbiddenMultiChannel".equals(str) || "version_config".equals(str))) {
                C0657e.m2512a("PushLogAC2712", "item " + str + " remove from " + "pushConfig" + " in deleteNoSysCfg");
                linkedList.add(str);
                edit.remove(str);
            }
        }
        edit.commit();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            this.f1170c.remove((String) it.next());
        }
    }
}
