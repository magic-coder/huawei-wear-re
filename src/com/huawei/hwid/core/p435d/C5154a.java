package com.huawei.hwid.core.p435d;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import com.huawei.cloudservice.CloudAccount;
import com.huawei.hwid.core.datatype.C5196a;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

/* compiled from: AppInfoUtil */
public class C5154a {
    private static Map<String, C5196a> f18586a = new HashMap();
    private static String f18587b = "";

    private static synchronized void m24847a(Context context) {
        synchronized (C5154a.class) {
            try {
                f18586a = C5154a.m24850b(context);
            } catch (Throwable e) {
                C5165e.m24911d("AppInfoUtil", "initAppInfos error:" + e.getMessage(), e);
            }
        }
    }

    public static String m24846a(Context context, String str) {
        String a;
        String c = C5154a.m24852c(context, str);
        String str2 = "";
        if (((C5196a) f18586a.get(c)) != null) {
            a = ((C5196a) f18586a.get(c)).m25275a();
        } else {
            a = str2;
        }
        if (TextUtils.isEmpty(a)) {
            a = "7000000";
        }
        try {
            Integer.parseInt(a);
        } catch (NumberFormatException e) {
            C5165e.m24910d("AppInfoUtil", e.getMessage());
            a = "7000000";
        }
        C5165e.m24906b("AppInfoUtil", "getAppChannel is:" + a);
        return a;
    }

    public static String m24845a() {
        return C5154a.m24851c() + "AB09070647056445";
    }

    public static String m24849b(Context context, String str) {
        f18587b = str;
        return C5154a.m24851c() + f18587b;
    }

    private static String m24851c() {
        return "99E790F6FBA9FDA8";
    }

    public static String m24848b() {
        if (TextUtils.isEmpty(f18587b)) {
            byte[] bArr = new byte[8];
            new SecureRandom().nextBytes(bArr);
            f18587b = C5166b.m24918a(bArr);
        }
        return f18587b;
    }

    private static String m24852c(Context context, String str) {
        if (TextUtils.isEmpty(str) || "com.huawei.hwid".equalsIgnoreCase(str)) {
            str = "com.huawei.hwid";
        }
        if (f18586a == null || f18586a.isEmpty()) {
            C5154a.m24847a(context);
        }
        return str;
    }

    private static Map<String, C5196a> m24850b(Context context) {
        C5165e.m24906b("AppInfoUtil", "initAppInfos");
        XmlResourceParser xml = context.getResources().getXml(C5180k.m25029b(context, "appinfo"));
        Map<String, C5196a> hashMap = new HashMap();
        if (xml != null) {
            C5196a c5196a = new C5196a();
            for (int eventType = xml.getEventType(); 1 != eventType; eventType = xml.next()) {
                String name = xml.getName();
                switch (eventType) {
                    case 2:
                        if ("appID".equals(name)) {
                            c5196a.m25279c(xml.nextText());
                            break;
                        }
                        try {
                            if (!CloudAccount.KEY_REQCLIENTTYPE.equals(name)) {
                                if (!"defaultChannel".equals(name)) {
                                    break;
                                }
                                c5196a.m25278b(xml.nextText());
                                break;
                            }
                            c5196a.m25276a(xml.nextText());
                            break;
                        } catch (Throwable e) {
                            C5165e.m24911d("AppInfoUtil", "initAppInfos error:" + e.getMessage(), e);
                            break;
                        } finally {
                            xml.close();
                        }
                    case 3:
                        if (!"appInfo".equals(name)) {
                            break;
                        }
                        hashMap.put(c5196a.m25277b(), c5196a);
                        c5196a = new C5196a();
                        break;
                    default:
                        break;
                }
            }
        }
        return hashMap;
    }
}
