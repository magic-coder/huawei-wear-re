package cn.com.xy.sms.sdk.p213e;

import android.content.Context;
import cn.com.xy.sms.p204a.C2909j;
import cn.com.xy.sms.sdk.p205a.C2904g;
import cn.com.xy.sms.sdk.p205a.C2910a;
import cn.com.xy.sms.sdk.p205a.C2911b;
import cn.com.xy.sms.sdk.p205a.C2912c;
import cn.com.xy.sms.sdk.p205a.C2913d;
import cn.com.xy.sms.sdk.p205a.C2914e;
import cn.com.xy.sms.sdk.p205a.C2915f;
import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p208d.p211c.C2947n;
import cn.com.xy.sms.sdk.p214f.C2978a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p216h.p217a.C2995m;
import cn.com.xy.sms.sdk.p229l.C3038c;
import cn.com.xy.sms.sdk.p229l.C3041f;
import cn.com.xy.sms.sdk.p229l.C3045j;
import cn.com.xy.sms.sdk.p229l.C3046k;
import cn.com.xy.sms.sdk.p229l.C3049n;
import cn.com.xy.sms.sdk.p229l.C3050o;
import cn.com.xy.sms.sdk.p229l.C3053r;
import cn.com.xy.sms.sdk.p229l.C3055t;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.unionpay.tsmservice.data.Constant;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

public class C2973a {
    public static ExecutorService f10064a = Executors.newFixedThreadPool(1);
    private static ClassLoader f10065b;
    private static C2911b f10066c;
    private static C2912c f10067d;
    private static C2915f f10068e;
    private static HashMap<String, ClassLoader> f10069f = new HashMap();
    private static HashMap<String, Class> f10070g = new HashMap();
    private static String f10071h = "";
    private static Object f10072i = null;

    public static long m13350a(int i, long j) {
        try {
            if (f10067d == null) {
                f10067d = C2973a.m13388j();
            }
            if (f10067d != null) {
                j = f10067d.m13088a(i, j);
            }
        } catch (Throwable th) {
            C2982a.m13415a("xiaoyuan", "DexUtil getUpdateCycleByType：" + th.getMessage(), th);
        }
        return j;
    }

    public static ClassLoader m13351a(Map<String, String> map, String str) {
        try {
            ClassLoader classLoader = (ClassLoader) f10069f.get(new StringBuilder(String.valueOf(str)).append("_ClassLoader").toString());
            if (classLoader != null) {
                try {
                    C2978a.f10090a.execute(new C2974b(str));
                    return classLoader;
                } catch (Throwable th) {
                    C2982a.m13415a("XIAOYUAN", "getClassLoaderBymap: " + th.getMessage(), th);
                    return classLoader;
                }
            }
            String d = C3055t.m13711d(C2917a.m13109b(), new StringBuilder(String.valueOf(str)).append(HwAccountConstants.SPLIIT_UNDERLINE).toString(), ".jar");
            new StringBuilder("subname=").append(str).append("jarPath=").append(d);
            File file = new File(d);
            if (file.exists() && C2995m.m13475a(d).booleanValue()) {
                File dir = C2917a.m13105a().getDir("outdex", 0);
                classLoader = new DexClassLoader(file.getCanonicalPath(), dir.getCanonicalPath(), null, C2973a.m13381d());
                C3050o.m13683c("640", dir.getCanonicalPath() + File.separator + file.getName().substring(0, file.getName().length() - 4) + ".dex");
                f10069f.put(new StringBuilder(String.valueOf(str)).append("_ClassLoader").toString(), classLoader);
                try {
                    C2978a.f10090a.execute(new C2974b(str));
                    return classLoader;
                } catch (Throwable th2) {
                    C2982a.m13415a("XIAOYUAN", "getClassLoaderBymap: " + th2.getMessage(), th2);
                    return classLoader;
                }
            }
            try {
                C2978a.f10090a.execute(new C2974b(str));
            } catch (Throwable th3) {
                C2982a.m13415a("XIAOYUAN", "getClassLoaderBymap: " + th3.getMessage(), th3);
            }
            return null;
        } catch (Throwable th32) {
            C2982a.m13415a("XIAOYUAN", "getClassLoaderBymap: " + th32.getMessage(), th32);
        }
    }

    public static ClassLoader m13352a(boolean z) {
        try {
            if (f10065b == null || z) {
                File file = new File(C2917a.m13111d());
                if (file.exists() && C2995m.m13475a(C2917a.m13111d()).booleanValue()) {
                    f10065b = new DexClassLoader(file.getCanonicalPath(), C2917a.m13105a().getDir("outdex", 0).getCanonicalPath(), null, C2917a.m13105a().getClassLoader());
                }
            }
        } catch (Throwable th) {
            C2982a.m13414a("DexUtil", th.getMessage());
        }
        return f10065b;
    }

    private static Object m13353a(Class<?> cls) {
        if (f10072i != null) {
            return f10072i;
        }
        if (cls == null) {
            return null;
        }
        Object newInstance = cls.newInstance();
        f10072i = newInstance;
        return newInstance;
    }

    public static String m13354a(Integer num, String str, String str2) {
        try {
            Class b = C2973a.m13370b(null, "cn.com.xy.sms.sdk.Iservice.LogService");
            if (b != null) {
                return (String) b.getMethod("queryLog", new Class[]{Integer.class, String.class, String.class}).invoke(b, new Object[]{num, str, str2});
            }
        } catch (Throwable th) {
            C2982a.m13415a("DexUtil", "DexUtil queryLog：" + th.getMessage(), th);
        }
        return "";
    }

    public static String m13355a(String str, String str2) {
        String str3;
        try {
            Class b = C2973a.m13370b(null, "cn.com.xy.sms.sdk.Iservice.ParseUtilUrl");
            if (b != null) {
                str3 = (String) b.getMethod("catchUrls", new Class[]{String.class, String.class}).invoke(b, new Object[]{str, str2});
                return str3 != null ? "" : str3;
            }
        } catch (Throwable th) {
            C2982a.m13414a("DexUtil", th.getMessage());
        }
        str3 = null;
        if (str3 != null) {
        }
    }

    public static String m13356a(String str, String str2, long j, Map map) {
        String a = C2909j.m13080a();
        String str3 = "";
        try {
            C3038c.m13592a(a, "cn.com.xy.sms.sdk.dex.DexUtil", "parseRecogniseValue", str, str2, Long.valueOf(j), map);
            Class b = C2973a.m13370b(null, "cn.com.xy.sms.sdk.Iservice.ParseUtilMultiple");
            if (b != null) {
                C3038c.m13593b(a, "cn.com.xy.sms.sdk.dex.DexUtil", "parseRecogniseValue", str, str2, Long.valueOf(j), map, (String) b.getMethod("multiParse", new Class[]{String.class, String.class, Long.TYPE, Map.class}).invoke(b, new Object[]{str, str2, Long.valueOf(j), map}));
                return (String) b.getMethod("multiParse", new Class[]{String.class, String.class, Long.TYPE, Map.class}).invoke(b, new Object[]{str, str2, Long.valueOf(j), map});
            }
            C3038c.m13593b(a, "cn.com.xy.sms.sdk.dex.DexUtil", "parseRecogniseValue", str, str2, Long.valueOf(j), map, str3);
            return null;
        } catch (Throwable th) {
            C3038c.m13593b(a, "cn.com.xy.sms.sdk.dex.DexUtil", "parseRecogniseValue", str, str2, Long.valueOf(j), map, str3);
        }
    }

    public static String m13357a(Map<String, Object> map) {
        String a;
        try {
            Class b = C2973a.m13370b(null, "cn.com.xy.sms.sdk.Iservice.ParseUtilBubble");
            if (b != null) {
                C2913d c2913d = (C2913d) b.newInstance();
                if (c2913d != null) {
                    a = c2913d.m13089a(map);
                    return a != null ? "" : a;
                }
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "getBubbleViewVersion: " + th.getMessage(), th);
        }
        a = null;
        if (a != null) {
        }
    }

    public static Map<String, Object> m13358a(String str, String str2, Map<String, String> map) {
        Throwable th;
        Map<String, Object> map2;
        Throwable th2;
        try {
            C2911b b = C2973a.m13369b(false);
            if (b != null) {
                Map<String, Object> a = b.m13084a(str, str2, map);
                if (a != null) {
                    return a;
                }
                try {
                    C2982a.m13415a("duoqu_test", "&&&&&result is null phoneNumber:" + str + " smsContent: " + str2 + " msgID: " + ((String) map.get("msgId")), null);
                    return a;
                } catch (Throwable th3) {
                    th = th3;
                    map2 = a;
                    th2 = th;
                    C2982a.m13414a("DexUtil", th2.getMessage());
                    return map2;
                }
            }
            C2982a.m13415a("duoqu_test", "lib = DexUtil.getOnlineParseImpl is null phoneNumber:" + str + " smsContent: " + str2 + " msgID: " + ((String) map.get("msgId")), null);
            return null;
        } catch (Throwable th32) {
            th = th32;
            map2 = null;
            th2 = th;
            C2982a.m13414a("DexUtil", th2.getMessage());
            return map2;
        }
    }

    public static void m13359a() {
        try {
            if (!new File(C2917a.m13111d()).exists()) {
                return;
            }
            if (C2995m.m13475a(C2917a.m13111d()).booleanValue()) {
                f10065b = C2973a.m13352a(true);
                f10066c = C2973a.m13369b(true);
                if (!C2982a.f10101a) {
                }
            } else if (!C2982a.f10101a) {
            }
        } catch (Throwable th) {
            C2982a.m13414a("DexUtil", th.getMessage());
        }
    }

    public static void m13360a(Context context, String str, String str2, String str3, String str4, long j, Map<String, String> map, Map<String, Object> map2) {
        try {
            JSONObject a = C3045j.m13624a((Map) map2);
            if (a != null) {
                f10064a.execute(new C2975c(context, str, str2, str3, str4, j, map, a));
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "handleParseMsg: " + th.getMessage(), th);
        }
    }

    public static void m13361a(Integer num, String str) {
        try {
            Class b = C2973a.m13370b(null, "cn.com.xy.sms.sdk.Iservice.LogService");
            if (b != null) {
                b.getMethod("postCallback", new Class[]{Integer.class, String.class}).invoke(b, new Object[]{num, str});
            }
        } catch (Throwable th) {
            C2982a.m13415a("DexUtil", "DexUtil postCallback：" + th.getMessage(), th);
        }
    }

    public static void m13362a(String str) {
        try {
            f10069f.remove(new StringBuilder(String.valueOf(str)).append("_ClassLoader").toString());
            f10070g.remove(new StringBuilder(String.valueOf(str)).append("_Class").toString());
        } catch (Throwable th) {
            C2982a.m13414a("DexUtil", th.getMessage());
        }
    }

    public static void m13363a(String str, String str2, String str3, Object... objArr) {
        try {
            f10064a.execute(new C2976d(str, str2, str3, objArr));
        } catch (Throwable th) {
            C2982a.m13415a("DexUtil", "DexUtil saveLogIn：" + th.getMessage(), th);
        }
    }

    private static void m13364a(JSONObject jSONObject, Map<String, Object> map) {
        try {
            jSONObject.put("NEW_ADACTION", map.get("NEW_ADACTION"));
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "DexUtil localPutActionDataToDataSource error:" + th.getMessage(), th);
        }
    }

    public static void m13365a(JSONObject jSONObject, Map<String, Object> map, Map<String, Object> map2) {
        if (jSONObject != null && map != null) {
            try {
                if (map.containsKey("NEW_ADACTION")) {
                    Class b = C2973a.m13370b(null, "cn.com.xy.sms.sdk.Iservice.WizardServiceMenuData");
                    if (b != null) {
                        b.getMethod("putActionDataToDataSource", new Class[]{JSONObject.class, Map.class, Map.class}).invoke(b, new Object[]{jSONObject, map, map2});
                        return;
                    }
                    C2973a.m13364a(jSONObject, (Map) map);
                }
            } catch (Throwable th) {
                C2973a.m13364a(jSONObject, (Map) map);
                C2982a.m13415a("XIAOYUAN", "DexUtil putActionDataToDataSource error:" + th.getMessage(), th);
            }
        }
    }

    public static boolean m13366a(int i) {
        try {
            Class b = C2973a.m13370b(null, "cn.com.xy.sms.sdk.Iservice.OnlineUpdateCycleConfig");
            if (b != null) {
                C3046k.m13626a();
                Object a = C2973a.m13353a(b);
                boolean booleanValue = ((Boolean) b.getMethod("geOnOffByType", new Class[]{Integer.class, String.class}).invoke(a, new Object[]{Integer.valueOf(i), C3046k.m13627b()})).booleanValue();
                new StringBuilder("DexUtil geOnOffByKey：type: ").append(i).append(" res: ").append(booleanValue);
                return booleanValue;
            }
        } catch (Throwable th) {
            C2982a.m13415a("DexUtil", "DexUtil geOnOffByKey：" + th.getMessage(), th);
        }
        return false;
    }

    public static Object[] m13367a(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        int i = 0;
        while (i < objArr.length) {
            try {
                Object obj = objArr[i];
                if (obj != null) {
                    if ((obj instanceof C2904g) || (obj instanceof Context) || obj.getClass().getName().startsWith("android.")) {
                        objArr[i] = new JSONObject().put("objectToJson", true).put("className", obj.getClass().getName());
                    } else if (obj.getClass().getName().startsWith("cn.com.xy.sms")) {
                        JSONObject a = C3045j.m13623a(obj);
                        if (a != null) {
                            objArr[i] = a;
                        }
                    }
                }
                i++;
            } catch (Throwable th) {
                C2982a.m13415a("DexUtil", "DexUtil handlerParamsToJSONObjectIfNeed：" + th.getMessage(), th);
                return objArr;
            }
        }
        return objArr;
    }

    public static String[] m13368a(String str, String str2, String str3) {
        try {
            Class b = C2973a.m13370b(null, "cn.com.xy.sms.sdk.Iservice.ParseUtilMultiple");
            if (b != null) {
                return (String[]) b.getMethod("check", new Class[]{String.class, String.class, String.class}).invoke(b, new Object[]{str, str2, str3});
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "DexUtil parseShard: " + th.getMessage(), th);
        }
        return null;
    }

    public static C2911b m13369b(boolean z) {
        try {
            if (f10066c == null || z) {
                ClassLoader d = C2973a.m13381d();
                if (d != null) {
                    Class loadClass = d.loadClass("cn.com.xy.sms.sdk.Iservice.OnlineParseImpl");
                    if (loadClass != null) {
                        f10066c = (C2911b) loadClass.newInstance();
                    }
                }
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "getOnlineParseImpl: " + th.getMessage(), th);
        }
        return f10066c;
    }

    public static Class m13370b(Map<String, String> map, String str) {
        try {
            String substring = str.substring(str.lastIndexOf(".") + 1);
            ClassLoader a = C2973a.m13351a((Map) map, substring);
            if (a != null) {
                Class cls = (Class) f10070g.get(new StringBuilder(String.valueOf(substring)).append("_Class").toString());
                if (cls != null) {
                    return cls;
                }
                cls = a.loadClass(str);
                if (cls != null) {
                    f10070g.put(new StringBuilder(String.valueOf(substring)).append("_Class").toString(), cls);
                    return cls;
                }
            }
        } catch (Throwable th) {
            C2982a.m13414a("DexUtil", th.getMessage());
        }
        return null;
    }

    public static String m13371b(String str, String str2) {
        String str3;
        try {
            Class b = C2973a.m13370b(null, "cn.com.xy.sms.sdk.Iservice.ParseUtilUnsubscribe");
            if (b != null) {
                str3 = (String) b.getMethod("parseUnsubscribe", new Class[]{String.class, String.class}).invoke(b, new Object[]{str, str2});
                return str3 != null ? "" : str3;
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "ParseUtilUnsubscribe getCmd: " + th.getMessage(), th);
        }
        str3 = null;
        if (str3 != null) {
        }
    }

    public static Map<String, Object> m13372b(String str, String str2, Map<String, String> map) {
        Throwable th;
        Map<String, Object> map2;
        Throwable th2;
        try {
            C2911b b = C2973a.m13369b(false);
            if (b != null) {
                Map<String, Object> b2 = b.m13086b(str, str2, map);
                if (b2 != null) {
                    return b2;
                }
                try {
                    C2982a.m13415a("duoqu_test", "parseVerifyCodeToMap result is null phoneNumber:" + str + " smsContent: " + str2 + " msgID: " + ((String) map.get("msgId")), null);
                    return b2;
                } catch (Throwable th3) {
                    th = th3;
                    map2 = b2;
                    th2 = th;
                    C2982a.m13414a("DexUtil", th2.getMessage());
                    return map2;
                }
            }
            C2982a.m13415a("duoqu_test", "parseVerifyCodeToMap lib = DexUtil.parseVerifyCodeToMap is null phoneNumber:" + str + " smsContent: " + str2 + " msgID: " + ((String) map.get("msgId")), null);
            return null;
        } catch (Throwable th32) {
            th = th32;
            map2 = null;
            th2 = th;
            C2982a.m13414a("DexUtil", th2.getMessage());
            return map2;
        }
    }

    public static JSONObject m13373b(Map<String, Object> map) {
        JSONObject jSONObject = null;
        try {
            C2914e c = C2973a.m13377c(false);
            if (c != null) {
                jSONObject = c.m13090a(map);
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "handerContactValueMap: " + th.getMessage(), th);
        }
        return jSONObject;
    }

    public static void m13374b() {
        f10067d = C2973a.m13388j();
        f10072i = null;
    }

    public static void m13375b(String str, String str2, String str3, Object... objArr) {
        try {
            f10064a.execute(new C2977e(str, str2, str3, objArr));
        } catch (Throwable th) {
            C2982a.m13415a("DexUtil", "DexUtil saveLogOut：" + th.getMessage(), th);
        }
    }

    public static String[] m13376b(String str) {
        String[] b;
        try {
            C2910a d = C2973a.m13380d(false);
            if (d != null) {
                b = d.m13082b(str);
                if (b == null && b.length >= 2) {
                    return b;
                }
                b = new String[2];
                b[0] = C2973a.m13378c(str);
                return b;
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "DexUtil getCorpAndEc: " + th.getMessage(), th);
        }
        b = null;
        if (b == null) {
        }
        b = new String[2];
        b[0] = C2973a.m13378c(str);
        return b;
    }

    public static C2914e m13377c(boolean z) {
        try {
            Class b = C2973a.m13370b(null, "cn.com.xy.sms.sdk.Iservice.ParseContact");
            if (b != null) {
                return (C2914e) b.newInstance();
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "getParseContactImpl: " + th.getMessage(), th);
        }
        return null;
    }

    public static String m13378c(String str) {
        try {
            C2910a d = C2973a.m13380d(false);
            return d != null ? d.m13081a(str) : C3053r.m13690a(str);
        } catch (Throwable th) {
            return "";
        }
    }

    public static void m13379c() {
        f10068e = C2973a.m13389k();
    }

    public static C2910a m13380d(boolean z) {
        try {
            Class b = C2973a.m13370b(null, "cn.com.xy.sms.sdk.Iservice.CorpSignImpl");
            if (b != null) {
                return (C2910a) b.newInstance();
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "getCorpSignImpl: " + th.getMessage(), th);
        }
        return null;
    }

    public static ClassLoader m13381d() {
        try {
            if (f10065b == null) {
                File file = new File(C2917a.m13111d());
                if (file.exists() && C2995m.m13475a(C2917a.m13111d()).booleanValue()) {
                    File dir = C2917a.m13105a().getDir("outdex", 0);
                    f10065b = new DexClassLoader(file.getCanonicalPath(), dir.getCanonicalPath(), null, C2917a.m13105a().getClassLoader());
                    C3050o.m13683c("640", dir.getCanonicalPath() + File.separator + file.getName().substring(0, file.getName().length() - 4) + ".dex");
                }
            }
        } catch (Throwable th) {
            C2982a.m13414a("DexUtil", th.getMessage());
        }
        return f10065b;
    }

    public static String m13382d(String str) {
        try {
            Class b = C2973a.m13370b(null, "cn.com.xy.sms.sdk.Iservice.ParseUtilMultiple");
            if (b != null) {
                return (String) b.getMethod("multiReplace", new Class[]{String.class}).invoke(b, new Object[]{str});
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "DexUtil multiReplace: " + th.getMessage(), th);
        }
        return null;
    }

    public static String m13383e() {
        Object obj = null;
        try {
            obj = C2947n.m13284d(C2917a.m13105a(), Constant.TARGET_CHANNEL);
            C2911b b = C2973a.m13369b(false);
            if (b != null) {
                String a = b.m13083a(obj);
                if (!C3049n.m13653e(a)) {
                    return a;
                }
            }
        } catch (Throwable th) {
            C2982a.m13414a("DexUtil getSuanfaVersion", "获取算法包内的版本号出现异常");
        }
        return "VMhlWdEwVNEW_LENOVO".equals(obj) ? "20150619" : "20150202";
    }

    public static String m13384f() {
        Object obj = null;
        try {
            obj = C2947n.m13284d(C2917a.m13105a(), Constant.TARGET_CHANNEL);
            C2911b b = C2973a.m13369b(false);
            if (b != null) {
                String b2 = b.m13085b(obj);
                if (!C3049n.m13653e(b2)) {
                    return b2;
                }
            }
        } catch (Throwable th) {
            C2982a.m13414a("DexUtil getSceneVersion", "获取算法包内的资源版本号出现异常");
        }
        return "VMhlWdEwVNEW_LENOVO".equals(obj) ? "20150619" : "20140815";
    }

    public static String m13385g() {
        try {
            if (C3049n.m13653e(f10071h)) {
                Class cls = Class.forName(C3041f.m13609b().m13103b(3, null));
                Method method = cls.getMethod("getUIVersion", new Class[0]);
                if (method != null) {
                    f10071h = (String) method.invoke(cls, new Object[0]);
                }
            }
        } catch (Throwable th) {
            f10071h = "-1";
            C2982a.m13415a("XIAOYUAN", "getUIVersion: " + th.getMessage(), th);
        }
        return f10071h;
    }

    public static void m13386h() {
        try {
            int i;
            String[] strArr = new String[]{"ScenesScanner", "ParseSimpleBubbleUtil", "ParseNotification"};
            String str = "cn.com.xy.sms.sdk.Iservice.";
            for (i = 0; i < 3; i++) {
                C2973a.m13370b(null, new StringBuilder(String.valueOf(str)).append(strArr[i]).toString());
            }
            i = 1;
            while (i <= 21) {
                C2973a.m13370b(null, new StringBuilder(String.valueOf(str)).append("PU").append(i < 10 ? "0" + i : Integer.valueOf(i)).toString());
                i++;
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "beforeInitBigJar: " + th.getMessage(), th);
        }
    }

    private static C2912c m13388j() {
        try {
            Class b = C2973a.m13370b(null, "cn.com.xy.sms.sdk.Iservice.OnlineUpdateCycleConfig");
            if (b != null) {
                f10067d = (C2912c) b.newInstance();
            }
        } catch (Throwable th) {
            C2982a.m13415a("xiaoyuan", "DexUtil getOnlineUpdateCycleConfig：" + th.getMessage(), th);
        }
        return f10067d;
    }

    private static C2915f m13389k() {
        try {
            Class b = C2973a.m13370b(null, "cn.com.xy.sms.sdk.Iservice.ParseVerifyCodeValidTime");
            if (b != null) {
                f10068e = (C2915f) b.newInstance();
            }
        } catch (Throwable th) {
            C2982a.m13415a("xiaoyuan", "DexUtil getParseVerifyCodeValidTime：" + th.getMessage(), th);
        }
        return f10068e;
    }
}
