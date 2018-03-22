package cn.com.xy.sms.sdk.p208d.p211c;

import android.content.ContentValues;
import cn.com.xy.sms.sdk.p208d.C2922b;
import cn.com.xy.sms.sdk.p208d.C2962e;
import cn.com.xy.sms.sdk.p208d.p210b.C2921a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p229l.C3049n;
import org.json.JSONObject;

public final class C2957x {
    private static String[] f10033a = new String[]{"updateInfoTime", "result"};

    public static long m13305a(String str, String str2, String str3) {
        if (!C3049n.m13644a(str, str2)) {
            return -1;
        }
        try {
            String i = C3049n.m13658i(new StringBuilder(String.valueOf(str)).append(str2).toString());
            ContentValues a = C2921a.m13130a(null, "phone", str, "numMsgMD5", i, "result", str3, "updateInfoTime", String.valueOf(System.currentTimeMillis()));
            return C2922b.m13133a("tb_operator_parse_info", a, new StringBuilder(String.valueOf(str)).append(" = ? and numMsgMD5").append(" = ?").toString(), new String[]{str, i}) <= 0 ? C2922b.m13135a("tb_operator_parse_info", a) : 0;
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "insertOrUpdateOperatorMsg: " + th.getMessage(), th);
            return -1;
        }
    }

    public static String m13306a() {
        return " create table if not exists tb_operator_parse_info (id INTEGER PRIMARY KEY,phone TEXT,msg TEXT,numMsgMD5 TEXT,result TEXT,updateInfoTime  long DEFAULT '0')";
    }

    public static JSONObject m13307a(String str, String str2) {
        C2962e a;
        Throwable th;
        C2962e c2962e = null;
        try {
            String i = C3049n.m13658i(new StringBuilder(String.valueOf(str)).append(str2).toString());
            a = C2922b.m13140a("tb_operator_parse_info", f10033a, "phone = ? and numMsgMD5 = ? ", new String[]{str, i}, null, null, null, null);
            try {
                JSONObject b = C2921a.m13132b(f10033a, a);
                C2962e.m13322a(a, true);
                return b;
            } catch (Throwable th2) {
                th = th2;
                try {
                    C2982a.m13415a("XIAOYUAN", "queryOperatorMsg: " + th.getMessage(), th);
                    C2962e.m13322a(a, true);
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    c2962e = a;
                    C2962e.m13322a(c2962e, true);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            C2962e.m13322a(c2962e, true);
            throw th;
        }
    }
}
