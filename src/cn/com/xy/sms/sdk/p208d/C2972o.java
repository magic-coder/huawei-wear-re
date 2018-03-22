package cn.com.xy.sms.sdk.p208d;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.LruCache;
import cn.com.xy.sms.sdk.p208d.p209a.C2918a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p229l.C3049n;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class C2972o {
    private static LruCache<String, String> f10063a = new LruCache(200);

    public static JSONArray m13346a(long j, String str, boolean z) {
        C2962e c2962e = null;
        JSONArray jSONArray = new JSONArray();
        String str2 = "querytime asc";
        String[] strArr = new String[]{"id", "phonenum", "publd", "queryflag", "querytime"};
        try {
            SQLiteDatabase a = C2918a.m13119a();
            if (a == null) {
                return c2962e;
            }
            if (z) {
                c2962e = C2918a.m13121a("tb_phone_pubid", strArr, "querytime <? and publd='' and queryflag =0", new String[]{String.valueOf(j)}, null, null, str2, str);
            } else {
                c2962e = C2918a.m13121a("tb_phone_pubid", strArr, "querytime <? and publd!='' and queryflag =0", new String[]{String.valueOf(j)}, null, null, str2, str);
            }
            while (c2962e.m13327b()) {
                jSONArray.put(C3049n.m13660k(c2962e.m13328c(1)));
            }
            if (z) {
                a.execSQL("UPDATE tb_phone_pubid SET queryflag =1 WHERE id IN (SELECT id FROM tb_phone_pubid WHERE querytime < " + String.valueOf(j) + " and publd" + "='' and queryflag" + " =0  ORDER BY querytime asc  limit " + str + " )");
            } else {
                a.execSQL("UPDATE tb_phone_pubid SET queryflag =1 WHERE id IN (SELECT id FROM tb_phone_pubid WHERE querytime < " + String.valueOf(j) + " and publd" + "!='' and queryflag" + " =0  ORDER BY querytime asc  limit " + str + " )");
            }
            C2962e.m13322a(c2962e, true);
            return jSONArray;
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "queryPubIdByDateAndUpdate: " + th.getMessage(), th);
        } finally {
            C2962e.m13322a(c2962e, true);
        }
    }

    public static void m13347a(boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("queryflag", Integer.valueOf(0));
        contentValues.put("querytime", Long.valueOf(System.currentTimeMillis()));
        try {
            C2918a.m13117a("tb_phone_pubid", contentValues, "queryflag=1", null);
        } catch (Throwable e) {
            C2982a.m13415a("XIAOYUAN", "ResoultMultyUpdate: " + e.getMessage(), e);
        }
    }

    public static boolean m13348a(HashMap<String, String> hashMap) {
        SQLiteDatabase a = C2918a.m13119a();
        if (a != null) {
            try {
                a.beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("PHONENUM", (String) hashMap.get("phone"));
                contentValues.put("PUBLD", (String) hashMap.get("pubId"));
                contentValues.put("QUERYTIME", (String) hashMap.get("querytime"));
                contentValues.put("QUERYFLAG", (String) hashMap.get("queryflag"));
                if (((long) a.update("tb_phone_pubid", contentValues, "phonenum=?", new String[]{(String) hashMap.get("phone")})) < 1) {
                    a.insert("tb_phone_pubid", null, contentValues);
                }
                if (a != null) {
                    try {
                        if (a.inTransaction()) {
                            a.setTransactionSuccessful();
                            a.endTransaction();
                        }
                        C2918a.m13122a(a);
                    } catch (Throwable th) {
                    }
                }
            } catch (Throwable th2) {
                try {
                    C2982a.m13415a("XIAOYUAN", "ParsePhonePubIdManager.saveOrUpdate " + th2.getMessage(), th2);
                } finally {
                    C2918a.m13122a(a);
                }
            }
        }
        return false;
        C2918a.m13122a(a);
    }

    public static boolean m13349a(JSONArray jSONArray) {
        SQLiteDatabase a = C2918a.m13119a();
        if (a != null) {
            a.beginTransaction();
            int i = 0;
            while (i < jSONArray.length()) {
                try {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (!(optJSONObject == null || C3049n.m13653e(optJSONObject.optString("phone")))) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("PHONENUM", optJSONObject.optString("phone"));
                        contentValues.put("PUBLD", optJSONObject.optString("pubId"));
                        contentValues.put("QUERYTIME", Long.valueOf(System.currentTimeMillis()));
                        contentValues.put("QUERYFLAG", "0");
                        if (((long) a.update("tb_phone_pubid", contentValues, "phonenum=?", new String[]{optJSONObject.optString("phone")})) < 1) {
                            a.insert("tb_phone_pubid", null, contentValues);
                        }
                    }
                    i++;
                } catch (Throwable th) {
                    try {
                        C2982a.m13414a("XIAOYUAN", "ParsePhonePubIdManager.saveOrUpdate " + th.getMessage());
                    } finally {
                        C2918a.m13122a(a);
                    }
                }
            }
            if (a != null) {
                try {
                    if (a.inTransaction()) {
                        a.setTransactionSuccessful();
                        a.endTransaction();
                    }
                    C2918a.m13122a(a);
                } catch (Throwable th2) {
                }
            }
        }
        return false;
        C2918a.m13122a(a);
    }
}
