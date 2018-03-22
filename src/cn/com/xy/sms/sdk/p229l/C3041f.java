package cn.com.xy.sms.sdk.p229l;

import cn.com.xy.sms.sdk.p206b.C2916a;
import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p226k.p227a.p228a.C3035a;

public class C3041f {
    public static C2916a f10284a = null;
    public static C3061z f10285b = null;
    private static C2916a f10286c = null;
    private static String f10287d = "DuoquUtils";

    public static C3061z m13607a() {
        return f10285b != null ? f10285b : null;
    }

    public static String m13608a(int i, int i2) {
        String a;
        switch (i) {
            case 1:
                a = C3055t.m13695a(i2);
                break;
            case 2:
                a = i2 == 1 ? "5YD15P" : "3T0CFQ";
                break;
            case 3:
                a = C2917a.m13106a(i2);
                break;
            case 4:
                a = C3035a.m13582a(i2);
                break;
            default:
                a = null;
                break;
        }
        try {
            String str = "";
            return a == null ? str : new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(str)).append(a.substring(0, i - 1)).toString())).append(a.substring(i, a.length() - 1)).toString();
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "getCode: " + th.getMessage(), th);
            return "";
        }
    }

    public static C2916a m13609b() {
        if (f10284a != null) {
            return f10284a;
        }
        if (f10286c == null) {
            f10286c = new C3054s();
        }
        String str = f10287d;
        return f10286c;
    }
}
