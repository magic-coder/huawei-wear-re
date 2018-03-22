package cn.com.xy.sms.sdk.p208d;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p208d.p209a.C2918a;
import cn.com.xy.sms.sdk.p208d.p211c.C2947n;
import cn.com.xy.sms.sdk.p213e.C2973a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p229l.C3040e;
import cn.com.xy.sms.sdk.p229l.C3055t;
import java.io.File;
import java.util.HashMap;

public class C2960c {
    public static StringBuffer f10038a = new StringBuffer();
    public static boolean f10039b = false;
    private static boolean f10040c = false;
    private static boolean f10041d = false;
    private static HashMap<Long, SQLiteDatabase> f10042e = new HashMap();
    private static boolean f10043f = false;

    public static void m13314a(int i, int i2) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("state", Integer.valueOf(i2));
            C2918a.m13117a("tb_regex", contentValues, "state = ? ", new String[]{new StringBuilder(String.valueOf(i)).toString()});
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "updateStatue: " + th.getMessage(), th);
        }
    }

    public static void m13315a(Context context) {
        String h = C2917a.m13115h();
        if (C3055t.m13704a(h)) {
            try {
                C2960c.m13314a(0, -1);
                f10043f = true;
                C2918a.m13123a(h, false);
                f10043f = false;
                C2917a.m13105a();
                C2918a.m13118a("tb_regex", "state=? ", new String[]{new StringBuilder("-1").toString()});
            } catch (Throwable th) {
                try {
                    C2960c.m13314a(-1, 0);
                    return;
                } finally {
                    f10043f = false;
                    C2918a.m13124a(h, true, null, null, null);
                }
            }
            C3055t.m13712d(h);
            f10043f = false;
            C2918a.m13124a(h, true, null, null, null);
        }
    }

    public static void m13316a(String str) {
        try {
            StringBuffer stringBuffer = new StringBuffer("last_use_time < ?");
            stringBuffer.append(" and scene_id = ? ");
            long a = C2973a.m13350a(32, 7776000000L);
            long currentTimeMillis = System.currentTimeMillis() - a;
            new StringBuilder("scenId=").append(str).append(" result=").append(C2918a.m13118a("tb_regex", stringBuffer.toString(), new String[]{String.valueOf(currentTimeMillis), str})).append(" timeOut =").append(a).append(" time=").append(C3040e.m13604a("yyyyMMdd hh:MM:ss", currentTimeMillis));
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "deleteTimeOutMatchId: " + th.getMessage(), th);
        }
    }

    public static boolean m13317a() {
        if (!f10040c) {
            f10040c = C2947n.m13273a("init_xiaoyuan_sdk", 0, C2917a.m13105a()) == 1;
        }
        return f10040c;
    }

    public static void m13318b() {
        try {
            C2918a.m13118a("tb_regex", null, null);
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "deleteAll: " + th.getMessage(), th);
        }
    }

    public static boolean m13319b(Context context) {
        try {
            File file = new File(C2917a.m13116i());
            if (file.exists()) {
                f10039b = true;
                boolean a = C2922b.m13148a(file, true);
                f10039b = false;
                return a;
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "updateNeiQianSql: " + th.getMessage(), th);
        } finally {
            f10039b = false;
        }
        return false;
    }

    public static void m13320c() {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = C2918a.m13119a();
            sQLiteDatabase.execSQL("DELETE FROM tb_regex WHERE state=-2 AND match_id IN (SELECT match_id FROM tb_regex GROUP BY match_id HAVING COUNT(match_id) > 1)");
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "deleteRepeatData: " + th.getMessage(), th);
        } finally {
            C2918a.m13122a(sQLiteDatabase);
        }
    }
}
