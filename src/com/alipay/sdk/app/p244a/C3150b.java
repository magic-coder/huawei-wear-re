package com.alipay.sdk.app.p244a;

import android.text.TextUtils;

public final class C3150b {
    String f10528a;

    public final void m13989a(String str, String str2, Throwable th) {
        m13987a(str, str2, C3150b.m13986a(th));
    }

    public final void m13988a(String str, String str2, String str3, String str4) {
        String str5 = "";
        if (!TextUtils.isEmpty(this.f10528a)) {
            str5 = str5 + "^";
        }
        this.f10528a += (str5 + String.format("%s,%s,%s,%s", new Object[]{str, str2, C3150b.m13985a(str3), str4}));
    }

    public final void m13987a(String str, String str2, String str3) {
        m13988a(str, str2, str3, "-");
    }

    static String m13985a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.replace("[", "【").replace("]", "】").replace("(", "（").replace(")", "）").replace(",", "，").replace("-", "=").replace("^", "~");
    }

    static String m13986a(Throwable th) {
        if (th == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append(th.getClass().getName()).append(":");
            stringBuffer.append(th.getMessage());
            stringBuffer.append(" 》 ");
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null) {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    stringBuffer.append(stackTraceElement.toString() + " 》 ");
                }
            }
        } catch (Throwable th2) {
        }
        return stringBuffer.toString();
    }
}
