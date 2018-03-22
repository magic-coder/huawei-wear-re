package cn.com.xy.sms.sdk.p229l;

import cn.com.xy.sms.sdk.p215g.C2982a;

public final class C3051p {
    public static String m13686a(String str) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < 4; i++) {
                stringBuffer.append(str.substring(i, i + 1));
                stringBuffer.append(str.substring(i + 4, i + 5));
                stringBuffer.append(str.substring(i + 8, i + 9));
                stringBuffer.append(str.substring(i + 12, i + 13));
            }
            return stringBuffer.toString();
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "handlerAssemble: " + th.getMessage(), th);
            return "";
        }
    }
}
