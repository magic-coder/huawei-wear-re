package com.huawei.openalliance.ad.utils.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.huawei.openalliance.ad.utils.C1365i;
import com.huawei.openalliance.ad.utils.p129b.C1336d;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class C1357a extends SQLiteOpenHelper {
    private static final String f2939a = C1357a.class.getSimpleName();
    private static AtomicInteger f2940b = new AtomicInteger();
    private static C1357a f2941e;
    private Context f2942c;
    private SQLiteDatabase f2943d = null;

    protected C1357a(Context context) {
        super(context, "hiad.db", null, 12);
        this.f2942c = context;
    }

    public static synchronized C1357a m5982a(Context context) {
        C1357a c1357a;
        synchronized (C1357a.class) {
            Context applicationContext = context.getApplicationContext();
            if (f2941e == null) {
                f2941e = new C1357a(applicationContext);
            }
            int incrementAndGet = f2940b.incrementAndGet();
            C1336d.m5886b(f2939a, "getInstance, count is:", "" + incrementAndGet);
            c1357a = f2941e;
        }
        return c1357a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m5983a() {
        /*
        r6 = this;
        r0 = 0;
        r1 = new java.util.ArrayList;
        r2 = 4;
        r1.<init>(r2);
        r2 = com.huawei.openalliance.ad.utils.db.bean.MaterialRecord.class;
        r2 = r2.getSimpleName();
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x004c, all -> 0x0089 }
        r3.<init>();	 Catch:{ Exception -> 0x004c, all -> 0x0089 }
        r4 = "select htmlStr from ";
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x004c, all -> 0x0089 }
        r2 = r3.append(r2);	 Catch:{ Exception -> 0x004c, all -> 0x0089 }
        r3 = " where adType = ";
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x004c, all -> 0x0089 }
        r3 = 1;
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x004c, all -> 0x0089 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x004c, all -> 0x0089 }
        r3 = r6.f2943d;	 Catch:{ Exception -> 0x004c, all -> 0x0089 }
        r4 = 0;
        r0 = r3.rawQuery(r2, r4);	 Catch:{ Exception -> 0x004c, all -> 0x0089 }
    L_0x0032:
        r2 = r0.moveToNext();	 Catch:{ Exception -> 0x004c }
        if (r2 == 0) goto L_0x0060;
    L_0x0038:
        r2 = "htmlStr";
        r2 = r0.getColumnIndex(r2);	 Catch:{ Exception -> 0x004c }
        r2 = r0.getString(r2);	 Catch:{ Exception -> 0x004c }
        r2 = com.huawei.openalliance.ad.utils.C1345b.m5934a(r2);	 Catch:{ Exception -> 0x004c }
        if (r2 == 0) goto L_0x0032;
    L_0x0048:
        r1.add(r2);	 Catch:{ Exception -> 0x004c }
        goto L_0x0032;
    L_0x004c:
        r1 = move-exception;
        r1 = f2939a;	 Catch:{ all -> 0x007f }
        r2 = 1;
        r2 = new java.lang.String[r2];	 Catch:{ all -> 0x007f }
        r3 = 0;
        r4 = "delete invalid pics fail";
        r2[r3] = r4;	 Catch:{ all -> 0x007f }
        com.huawei.openalliance.ad.utils.p129b.C1336d.m5888c(r1, r2);	 Catch:{ all -> 0x007f }
        if (r0 == 0) goto L_0x005f;
    L_0x005c:
        r0.close();
    L_0x005f:
        return;
    L_0x0060:
        r2 = com.huawei.openalliance.ad.utils.C1366j.f2951c;	 Catch:{ Exception -> 0x0070 }
        r3 = new com.huawei.openalliance.ad.utils.db.b;	 Catch:{ Exception -> 0x0070 }
        r3.<init>(r6, r1);	 Catch:{ Exception -> 0x0070 }
        r2.execute(r3);	 Catch:{ Exception -> 0x0070 }
    L_0x006a:
        if (r0 == 0) goto L_0x005f;
    L_0x006c:
        r0.close();
        goto L_0x005f;
    L_0x0070:
        r1 = move-exception;
        r1 = f2939a;	 Catch:{ Exception -> 0x004c }
        r2 = 1;
        r2 = new java.lang.String[r2];	 Catch:{ Exception -> 0x004c }
        r3 = 0;
        r4 = "excute thread fail";
        r2[r3] = r4;	 Catch:{ Exception -> 0x004c }
        com.huawei.openalliance.ad.utils.p129b.C1336d.m5888c(r1, r2);	 Catch:{ Exception -> 0x004c }
        goto L_0x006a;
    L_0x007f:
        r1 = move-exception;
        r5 = r1;
        r1 = r0;
        r0 = r5;
    L_0x0083:
        if (r1 == 0) goto L_0x0088;
    L_0x0085:
        r1.close();
    L_0x0088:
        throw r0;
    L_0x0089:
        r1 = move-exception;
        r5 = r1;
        r1 = r0;
        r0 = r5;
        goto L_0x0083;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.utils.db.a.a():void");
    }

    private void m5984a(int i, boolean z) {
        try {
            C1360c c1360c = new C1360c(this, this.f2942c);
            this.f2943d.beginTransaction();
            if (z) {
                c1360c.m6065a();
            } else {
                c1360c.m6066b();
            }
            this.f2943d.setTransactionSuccessful();
        } catch (Exception e) {
            C1336d.m5888c(f2939a, "initTables error");
        } finally {
            this.f2943d.endTransaction();
        }
    }

    private boolean m5985g(String str) {
        return (str == null || "".equals(str) || str.length() > 30) ? false : true;
    }

    public synchronized int m5986a(String str, ContentValues contentValues, String str2, String[] strArr) {
        int i = 0;
        synchronized (this) {
            C1336d.m5886b(f2939a, "update()");
            try {
                i = getWritableDatabase().update(str, contentValues, str2, strArr);
            } catch (Exception e) {
                C1336d.m5888c(f2939a, "update ex");
            }
        }
        return i;
    }

    public synchronized int m5987a(String str, String str2, String[] strArr) {
        int i = 0;
        synchronized (this) {
            C1336d.m5886b(f2939a, "delete()");
            try {
                i = getWritableDatabase().delete(str, str2, strArr);
            } catch (Exception e) {
                C1336d.m5888c(f2939a, "delete ex");
            }
        }
        return i;
    }

    public synchronized long m5988a(String str, ContentValues contentValues) throws Exception {
        long j;
        C1336d.m5886b(f2939a, "insert()");
        j = -1;
        try {
            j = getWritableDatabase().insertOrThrow(str, null, contentValues);
        } catch (Exception e) {
            C1336d.m5888c(f2939a, "insert ex");
        }
        return j;
    }

    public synchronized Cursor m5989a(String str, String[] strArr, String str2, String[] strArr2, String str3) {
        return getReadableDatabase().query(str, strArr, str2, strArr2, null, null, str3);
    }

    public synchronized Cursor m5990a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4) {
        return getReadableDatabase().query(str, strArr, str2, strArr2, null, null, str3, str4);
    }

    public void m5991a(String str) throws Exception {
        if (m5985g(str)) {
            try {
                this.f2943d.execSQL(" DROP TABLE _temp_" + str);
                return;
            } catch (Exception e) {
                C1336d.m5888c(f2939a, "delete temp table fail");
                throw e;
            }
        }
        throw new Exception();
    }

    public synchronized void m5992a(String str, String str2, List<String> list) {
        if (!(C1365i.m6081a(str) || list == null)) {
            if (!list.isEmpty()) {
                StringBuilder stringBuilder = new StringBuilder("delete from ");
                stringBuilder.append(str);
                stringBuilder.append(" where ");
                stringBuilder.append(str2);
                stringBuilder.append(" in (");
                stringBuilder.append(C1365i.m6080a((List) list, ",", "'"));
                stringBuilder.append(")");
                try {
                    getWritableDatabase().execSQL(stringBuilder.toString());
                } catch (Exception e) {
                    C1336d.m5888c(f2939a, "delete record fail");
                }
            }
        }
    }

    public synchronized void m5993a(String str, List<String> list, long j) {
        StringBuilder stringBuilder = new StringBuilder("update ");
        stringBuilder.append(str);
        stringBuilder.append(" set lockTime = ");
        stringBuilder.append(j);
        stringBuilder.append(" where _id in ( ");
        stringBuilder.append(C1365i.m6079a(list, ","));
        stringBuilder.append(")");
        try {
            getWritableDatabase().execSQL(stringBuilder.toString());
        } catch (Exception e) {
            C1336d.m5888c(f2939a, "update record fail");
        }
    }

    public synchronized Cursor m5994b(String str, String str2, List<String> list) {
        Cursor cursor = null;
        synchronized (this) {
            StringBuilder stringBuilder = new StringBuilder("select * from ");
            stringBuilder.append(str);
            stringBuilder.append(" where ");
            stringBuilder.append(str2);
            stringBuilder.append(" in (");
            stringBuilder.append(C1365i.m6080a((List) list, ",", "'"));
            stringBuilder.append(")");
            try {
                cursor = getWritableDatabase().rawQuery(stringBuilder.toString(), null);
            } catch (Exception e) {
                C1336d.m5888c(f2939a, "query record fail");
            }
        }
        return cursor;
    }

    public void m5995b(String str) throws Exception {
        if (m5985g(str)) {
            try {
                this.f2943d.execSQL(" DROP TABLE " + str);
                return;
            } catch (Exception e) {
                C1336d.m5888c(f2939a, "delete table fail");
                throw e;
            }
        }
        throw new Exception();
    }

    public void m5996c(String str) throws Exception {
        try {
            this.f2943d.execSQL(str);
        } catch (Exception e) {
            C1336d.m5888c(f2939a, "executeSQL error");
            throw e;
        }
    }

    public synchronized void close() {
        int decrementAndGet = f2940b.decrementAndGet();
        C1336d.m5884a(f2939a, "close, count is:", "" + decrementAndGet);
        if (decrementAndGet == 0) {
            super.close();
        }
    }

    public String[] m5997d(String str) throws Exception {
        Cursor cursor = null;
        if (m5985g(str)) {
            try {
                cursor = this.f2943d.rawQuery(" select * from " + str + " order by _id asc LIMIT 1", null);
                cursor.moveToNext();
                String[] columnNames = cursor.getColumnNames();
                if (cursor != null) {
                    cursor.close();
                }
                return columnNames;
            } catch (Exception e) {
                C1336d.m5888c(f2939a, "getColumnNames error");
                throw e;
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
        } else {
            throw new Exception();
        }
    }

    public boolean m5998e(String str) throws Exception {
        boolean z = false;
        if (m5985g(str)) {
            if (str != null) {
                Cursor cursor = null;
                try {
                    cursor = this.f2943d.rawQuery("select count(1) as c from sqlite_master where type ='table' and name = ?", new String[]{str.trim()});
                    if (cursor.moveToNext() && cursor.getInt(0) > 0) {
                        z = true;
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Exception e) {
                    throw e;
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
            return z;
        }
        throw new Exception();
    }

    public void m5999f(String str) throws Exception {
        if (m5985g(str)) {
            try {
                this.f2943d.execSQL(" ALTER TABLE " + str + " RENAME TO _temp_" + str);
                return;
            } catch (Exception e) {
                C1336d.m5888c(f2939a, "modifyTableName fail");
                throw e;
            }
        }
        throw new Exception();
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        f2940b.incrementAndGet();
        this.f2943d = sQLiteDatabase;
        m5984a(12, false);
        f2940b.decrementAndGet();
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        f2940b.incrementAndGet();
        this.f2943d = sQLiteDatabase;
        if (i < 6 || 12 == i2) {
            m5984a(i2, false);
        } else {
            m5984a(i2, true);
        }
        m5983a();
        f2940b.decrementAndGet();
    }
}
