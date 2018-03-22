package cn.com.xy.sms.p204a;

import android.content.Context;
import android.os.Process;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import cn.com.xy.sms.sdk.p206b.C2916a;
import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p208d.C2960c;
import cn.com.xy.sms.sdk.p208d.p211c.C2947n;
import cn.com.xy.sms.sdk.p213e.C2973a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p216h.C2996a;
import cn.com.xy.sms.sdk.p216h.p217a.C2995m;
import cn.com.xy.sms.sdk.p218i.C3008a;
import cn.com.xy.sms.sdk.p220j.p221a.C3017b;
import cn.com.xy.sms.sdk.p220j.p224d.C3026b;
import cn.com.xy.sms.sdk.p220j.p224d.C3030f;
import cn.com.xy.sms.sdk.p229l.C3038c;
import cn.com.xy.sms.sdk.p229l.C3049n;
import com.huawei.hwid.core.constants.HwAccountConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

public class C2899a {
    public static boolean f9866a = false;
    public static long f9867b = 0;
    public static boolean f9868c = false;
    public static long f9869d = 0;
    public static long f9870e = 1;
    private static boolean f9871f = false;
    private static HashMap<String, Long> f9872g = new HashMap();
    private static ExecutorService f9873h = Executors.newFixedThreadPool(1);

    public static int m13063a(Context context, Map map) {
        try {
            String a = C2906g.m13077a(context, "PARSE_VERSION");
            if (!C3049n.m13653e(a)) {
                return Integer.parseInt(a);
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "getParseVersion" + th.getLocalizedMessage(), th);
        }
        return 0;
    }

    public static String m13064a(Context context, String str, int i, String str2, Map<String, String> map, C2905f c2905f) {
        if (!C2995m.m13478a((byte) 5)) {
            return null;
        }
        if (C3049n.m13649c(str)) {
            return null;
        }
        String a = C2909j.m13080a();
        try {
            C3038c.m13592a(a, "cn.com.xy.sms.util.ParseManager", "queryPublicInfo", context, str, Integer.valueOf(i), str2, map);
            String a2 = C3030f.m13570a(str, i, str2, map, c2905f);
            try {
                C3038c.m13593b(a, "cn.com.xy.sms.util.ParseManager", "queryPublicInfo", context, str, Integer.valueOf(i), str2, map, a2);
                C3008a.m13531a();
                C3026b.m13568b();
                return a2;
            } catch (Throwable th) {
                C2982a.m13415a("ParseManager", "queryPublicInfo error: " + th.getMessage(), th);
                return a2;
            }
        } catch (Throwable th2) {
            C2982a.m13415a("ParseManager", "queryPublicInfo error: " + th2.getMessage(), th2);
        }
        return null;
    }

    public static JSONObject m13065a(String str, String str2, long j, Map map) {
        if (C3049n.m13653e(str2) || !C2995m.m13478a((byte) TagName.IDENTIFYING_CODE)) {
            return null;
        }
        try {
            return new JSONObject(C2973a.m13356a(str, str2, j, map));
        } catch (Throwable th) {
            C2982a.m13414a("XIAOYUAN", "parseRecogniseValue failed!");
            return null;
        }
    }

    public static void m13066a(Context context) {
        C3017b.m13548b(context);
    }

    public static void m13067a(Context context, String str, String str2, boolean z, boolean z2, Map<String, String> map) {
        if (context == null) {
            throw new Exception("context is null,please check.");
        }
        C2917a.m13108a(context);
        C3017b.m13544a(context);
        if (context.getPackageName().equals(C2916a.m13091a(Process.myPid(), context))) {
            Runnable c2907h = new C2907h(context, str, str2, z, z2, map);
            if (map == null || !map.containsKey("SYNCHRONIZED")) {
                C2996a.m13484a(c2907h);
                return;
            } else {
                c2907h.run();
                return;
            }
        }
        C2982a.m13414a("xiaoyuan", "processName is not " + context.getPackageName());
    }

    static /* synthetic */ void m13068a(String str, String str2) {
        String stringBuilder = new StringBuilder(String.valueOf(str2)).append(HwAccountConstants.SPLIIT_UNDERLINE).append(str).toString();
        C2947n.m13272a(C2917a.m13105a(), "bubbleViewVersion", stringBuilder, null);
        C2947n.f10009a.put("bubbleViewVersion", stringBuilder);
    }

    public static boolean m13069a() {
        return f9871f;
    }

    public static boolean m13070b() {
        return C2960c.m13317a();
    }
}
