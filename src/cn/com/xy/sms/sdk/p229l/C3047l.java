package cn.com.xy.sms.sdk.p229l;

import cn.com.xy.sms.sdk.p215g.C2982a;
import java.util.regex.Pattern;

public class C3047l {
    private static Pattern f10295a = Pattern.compile("(?<![\\-0-9])0\\d{2,3}-?\\d{7,8}(?!\\d)");

    public static String m13628a(int i) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = 1; i2 < 5; i2++) {
                stringBuffer.append(C3041f.m13608a(i2, i));
            }
            return C3049n.m13657h(C3049n.m13662m(C3051p.m13686a(stringBuffer.toString())));
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "getValue: " + th.getMessage(), th);
            return "";
        }
    }
}
