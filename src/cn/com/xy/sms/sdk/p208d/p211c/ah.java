package cn.com.xy.sms.sdk.p208d.p211c;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import cn.com.xy.sms.sdk.p208d.C2922b;
import cn.com.xy.sms.sdk.p215g.C2982a;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.log4j.spi.LocationInfo;

public final class ah {
    private static long m13242a() {
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(13, 0);
        instance.set(12, 0);
        instance.set(14, 0);
        return instance.getTimeInMillis();
    }

    public static String m13243a(int i) {
        if (i <= 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder((i << 1) - 1);
        stringBuilder.append(LocationInfo.NA);
        for (int i2 = 1; i2 < i; i2++) {
            stringBuilder.append(",?");
        }
        return stringBuilder.toString();
    }

    public static Map<String, Map<String, StringBuilder>> m13244a(List<String> list) {
        Map<String, Map<String, StringBuilder>> hashMap = new HashMap();
        if (list.isEmpty()) {
            return hashMap;
        }
        SQLiteDatabase a = C2922b.m13136a();
        if (a == null) {
            C2982a.m13414a("XIAOYUAN", "getParseSmsRecordByPhoneNum: getSQLiteDatabase 为空！");
            return hashMap;
        }
        String[] strArr = new String[]{"sms_num", "success_num", "date_time", Oauth2AccessToken.KEY_PHONE_NUM};
        String str = "date_time < " + ah.m13242a() + " AND phone_num" + " IN(" + ah.m13243a(list.size()) + ")";
        Cursor query = a.query("tb_sms_parse_recorder", strArr, str, (String[]) list.toArray(new String[list.size()]), null, null, null);
        if (query == null) {
            return hashMap;
        }
        while (query.moveToNext()) {
            StringBuilder stringBuilder;
            StringBuilder stringBuilder2;
            StringBuilder stringBuilder3;
            String string = query.getString(query.getColumnIndex(Oauth2AccessToken.KEY_PHONE_NUM));
            if (hashMap.containsKey(string)) {
                Map map = (Map) hashMap.get(string);
                stringBuilder = (StringBuilder) map.get("ac");
                stringBuilder2 = (StringBuilder) map.get("rc");
                stringBuilder3 = (StringBuilder) map.get("dt");
                stringBuilder.append(',');
                stringBuilder2.append(',');
                stringBuilder3.append(',');
            } else {
                Map hashMap2 = new HashMap();
                stringBuilder = new StringBuilder();
                stringBuilder2 = new StringBuilder();
                stringBuilder3 = new StringBuilder();
                hashMap2.put("ac", stringBuilder);
                hashMap2.put("rc", stringBuilder2);
                hashMap2.put("dt", stringBuilder3);
                hashMap.put(string, hashMap2);
            }
            int i = query.getInt(query.getColumnIndex("sms_num"));
            int i2 = query.getInt(query.getColumnIndex("success_num"));
            int currentTimeMillis = (int) ((System.currentTimeMillis() - query.getLong(query.getColumnIndex("date_time"))) / 86400000);
            stringBuilder.append(i);
            stringBuilder2.append(i2);
            stringBuilder3.append(currentTimeMillis);
        }
        query.close();
        ContentValues contentValues = new ContentValues();
        contentValues.put("query_flag", Integer.valueOf(1));
        try {
            a.beginTransaction();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                a.update("tb_sms_parse_recorder", contentValues, str, new String[]{(String) it.next()});
            }
            a.setTransactionSuccessful();
            if (a.inTransaction()) {
                a.endTransaction();
            }
        } catch (Throwable th) {
            if (a.inTransaction()) {
                a.endTransaction();
            }
        }
        C2922b.m13143a(a);
        return hashMap;
    }

    public static void m13245a(java.lang.String r9, boolean r10) {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1431)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r1 = 0;
        r0 = 1;
        r2 = 0;
        r3 = cn.com.xy.sms.sdk.p229l.C3049n.m13653e(r9);
        if (r3 == 0) goto L_0x0012;
    L_0x0009:
        r0 = "XIAOYUAN";
        r1 = "电话号码为空！";
        cn.com.xy.sms.sdk.p215g.C2982a.m13414a(r0, r1);
    L_0x0011:
        return;
    L_0x0012:
        r1 = cn.com.xy.sms.sdk.p208d.C2922b.m13136a();	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        if (r1 != 0) goto L_0x0025;	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
    L_0x0018:
        r0 = "XIAOYUAN";	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        r2 = "getSQLiteDatabase 为空！";	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        cn.com.xy.sms.sdk.p215g.C2982a.m13414a(r0, r2);	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        if (r1 == 0) goto L_0x0011;
    L_0x0021:
        cn.com.xy.sms.sdk.p208d.C2922b.m13143a(r1);
        goto L_0x0011;
    L_0x0025:
        r4 = cn.com.xy.sms.sdk.p208d.p211c.ah.m13242a();	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        r3 = "SELECT 1 FROM tb_sms_parse_recorder WHERE phone_num = ? AND date_time = ?";	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        r6 = 2;	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        r6 = new java.lang.String[r6];	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        r7 = 0;	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        r6[r7] = r9;	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        r7 = 1;	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        r8 = java.lang.String.valueOf(r4);	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        r6[r7] = r8;	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        r6 = r1.rawQuery(r3, r6);	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        if (r6 == 0) goto L_0x00c9;	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
    L_0x003e:
        r3 = r6.getCount();	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        if (r3 == 0) goto L_0x0081;	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
    L_0x0044:
        r3 = r0;	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
    L_0x0045:
        r6.close();	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
    L_0x0048:
        if (r3 != 0) goto L_0x0085;	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
    L_0x004a:
        r3 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        r3.<init>();	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        r6 = "phone_num";	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        r3.put(r6, r9);	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        r6 = "sms_num";	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        r7 = 1;	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        r3.put(r6, r7);	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        r6 = "success_num";	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        if (r10 == 0) goto L_0x0083;	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
    L_0x0064:
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        r3.put(r6, r0);	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        r0 = "date_time";	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        r2 = java.lang.Long.valueOf(r4);	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        r3.put(r0, r2);	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        r0 = "tb_sms_parse_recorder";	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        r2 = 0;	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        r1.insert(r0, r2, r3);	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
    L_0x007b:
        if (r1 == 0) goto L_0x0011;
    L_0x007d:
        cn.com.xy.sms.sdk.p208d.C2922b.m13143a(r1);
        goto L_0x0011;
    L_0x0081:
        r3 = r2;
        goto L_0x0045;
    L_0x0083:
        r0 = r2;
        goto L_0x0064;
    L_0x0085:
        r2 = "UPDATE tb_sms_parse_recorder SET sms_num = sms_num + 1, success_num = success_num + ? WHERE phone_num = ? AND date_time = ?";	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        r0 = 3;	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        r3 = new java.lang.String[r0];	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        r6 = 0;	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        if (r10 == 0) goto L_0x00bf;	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
    L_0x008d:
        r0 = "1";	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
    L_0x008f:
        r3[r6] = r0;	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        r0 = 1;	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        r3[r0] = r9;	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        r0 = 2;	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        r4 = java.lang.String.valueOf(r4);	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        r3[r0] = r4;	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        r1.execSQL(r2, r3);	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        goto L_0x007b;
    L_0x009f:
        r0 = move-exception;
        r2 = "XIAOYUAN";	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        r4 = "addRecord: ";	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        r3.<init>(r4);	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        r4 = r0.getMessage();	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r2, r3, r0);	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        if (r1 == 0) goto L_0x0011;
    L_0x00ba:
        cn.com.xy.sms.sdk.p208d.C2922b.m13143a(r1);
        goto L_0x0011;
    L_0x00bf:
        r0 = "0";	 Catch:{ Throwable -> 0x009f, all -> 0x00c2 }
        goto L_0x008f;
    L_0x00c2:
        r0 = move-exception;
        if (r1 == 0) goto L_0x00c8;
    L_0x00c5:
        cn.com.xy.sms.sdk.p208d.C2922b.m13143a(r1);
    L_0x00c8:
        throw r0;
    L_0x00c9:
        r3 = r2;
        goto L_0x0048;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.xy.sms.sdk.d.c.ah.a(java.lang.String, boolean):void");
    }

    public static void m13246a(boolean z) {
        String str = "query_flag=1";
        if (z) {
            try {
                C2922b.m13134a("tb_sms_parse_recorder", str, null);
                return;
            } catch (Throwable e) {
                C2982a.m13415a("XIAOYUAN", e.getMessage(), e);
                return;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("query_flag", Integer.valueOf(0));
        try {
            C2922b.m13133a("tb_sms_parse_recorder", contentValues, str, null);
        } catch (Throwable e2) {
            C2982a.m13415a("XIAOYUAN", e2.getMessage(), e2);
        }
    }
}
