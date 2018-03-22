package cn.com.xy.sms.sdk.p208d.p211c;

import android.content.ContentValues;
import cn.com.xy.sms.sdk.p208d.C2922b;
import cn.com.xy.sms.sdk.p208d.p210b.C2921a;
import cn.com.xy.sms.sdk.p215g.C2982a;

public final class C2954u {
    public static long m13297a(String str, int i) {
        try {
            ContentValues a = C2921a.m13130a(null, "url", str, "check_statu", new StringBuilder(String.valueOf(i)).toString(), "check_time", String.valueOf(System.currentTimeMillis()));
            if (i == 0) {
                return C2922b.m13133a("tb_msg_url", a, "url = ? and check_statu = ?", new String[]{str, "0"}) <= 0 ? C2922b.m13135a("tb_msg_url", a) : 0;
            } else {
                return C2922b.m13133a("tb_msg_url", a, "url = ? ", new String[]{str}) <= 0 ? C2922b.m13135a("tb_msg_url", a) : 0;
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "saveOrUpdate: " + th.getMessage(), th);
            return -1;
        }
    }
}
