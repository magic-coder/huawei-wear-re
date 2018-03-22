package cn.com.xy.sms.sdk.p229l;

import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p208d.p211c.C2958y;
import cn.com.xy.sms.sdk.p208d.p211c.C2959z;
import cn.com.xy.sms.sdk.p208d.p211c.aa;
import cn.com.xy.sms.sdk.p214f.C2978a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ae {
    public static String m13587a(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        List<C2958y> a = C2959z.m13310a(str);
        stringBuffer.append("<SceneStat>");
        if (a.size() <= 0) {
            return null;
        }
        for (C2958y c2958y : a) {
            C2958y c2958y2;
            stringBuffer.append("t1;");
            String str2 = c2958y2.f10035b;
            stringBuffer.append(new StringBuilder(String.valueOf(str2)).append(";").toString());
            stringBuffer.append(new StringBuilder(String.valueOf(C3049n.m13658i(C2978a.m13392a(C2917a.m13105a())))).append(";").toString());
            List b = C2959z.m13312b(str2);
            for (int i = 0; i < b.size(); i++) {
                c2958y2 = (C2958y) b.get(i);
                if (i != 0) {
                    stringBuffer.append("&amp;");
                }
                String str3 = c2958y2.f10034a;
                stringBuffer.append(new StringBuilder(String.valueOf(str3)).append(",").toString());
                stringBuffer.append(c2958y2.f10036c + ",");
                stringBuffer.append(c2958y2.f10037d + ",");
                JSONArray a2 = aa.m13214a(str3, str2);
                if (a2 != null) {
                    int i2 = 0;
                    while (i2 < a2.length()) {
                        try {
                            JSONObject jSONObject = a2.getJSONObject(i2);
                            if (i2 != 0) {
                                stringBuffer.append("#");
                            }
                            Object string = jSONObject.getString("action_code");
                            if (C3049n.m13653e((String) string)) {
                                string = jSONObject.getString("action_type");
                            }
                            stringBuffer.append(new StringBuilder(String.valueOf(string)).append("=").toString());
                            stringBuffer.append(jSONObject.getString("times"));
                            i2++;
                        } catch (Throwable th) {
                            C2982a.m13415a("XIAOYUAN", "getReportDataString: " + th.getMessage(), th);
                        }
                    }
                }
            }
            stringBuffer.append("\n");
        }
        stringBuffer.append("</SceneStat>");
        return stringBuffer.toString();
    }
}
