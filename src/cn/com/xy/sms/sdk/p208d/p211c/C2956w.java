package cn.com.xy.sms.sdk.p208d.p211c;

import android.content.ContentValues;
import cn.com.xy.sms.sdk.p208d.C2922b;
import cn.com.xy.sms.sdk.p208d.C2962e;
import cn.com.xy.sms.sdk.p208d.p210b.C2921a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import org.json.JSONObject;

public final class C2956w {
    private static String[] f10032a = new String[]{"updateInfoTime", "actions"};

    public static long m13302a(String str, String str2, String str3) {
        try {
            ContentValues a = C2921a.m13130a(null, "phone", str, "iccid", str2, "actions", str3, "updateInfoTime", String.valueOf(System.currentTimeMillis()));
            return C2922b.m13133a("tb_operator_cmd_info", a, new StringBuilder(String.valueOf(str)).append(" = ? or iccid").append(" = ?").toString(), new String[]{str, str2}) <= 0 ? C2922b.m13135a("tb_operator_cmd_info", a) : 0;
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "insertOrUpdateOperatorCmd: " + th.getMessage(), th);
            return -1;
        }
    }

    public static String m13303a() {
        return " create table  if not exists tb_operator_cmd_info (id  INTEGER PRIMARY KEY,phone  TEXT,iccid  TEXT,actions TEXT,updateInfoTime  long DEFAULT '0')";
    }

    public static JSONObject m13304a(String str) {
        C2962e a;
        Throwable th;
        try {
            a = C2922b.m13140a("tb_operator_cmd_info", f10032a, "phone = ?", new String[]{str}, null, null, null, null);
            try {
                JSONObject b = C2921a.m13132b(f10032a, a);
                C2962e.m13322a(a, true);
                return b;
            } catch (Throwable th2) {
                th = th2;
                try {
                    C2982a.m13415a("XIAOYUAN", "queryOperatorCmd: " + th.getMessage(), th);
                    C2962e.m13322a(a, true);
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    C2962e.m13322a(a, true);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            a = null;
            C2962e.m13322a(a, true);
            throw th;
        }
    }
}
