package com.tencent.wxop.stat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.wxop.stat.p546a.C6495d;
import com.tencent.wxop.stat.p547b.C6507b;
import com.tencent.wxop.stat.p547b.C6508c;
import com.tencent.wxop.stat.p547b.C6511f;
import com.tencent.wxop.stat.p547b.C6517l;
import com.tencent.wxop.stat.p547b.C6523r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class am {
    private static C6507b f22624h = C6517l.m29740c();
    private static Context f22625i = null;
    private static am f22626j = null;
    volatile int f22627a = 0;
    C6508c f22628b = null;
    private C6527d f22629c = null;
    private C6527d f22630d = null;
    private C6511f f22631e = null;
    private String f22632f = "";
    private String f22633g = "";
    private int f22634k = 0;
    private ConcurrentHashMap<C6495d, String> f22635l = null;
    private boolean f22636m = false;
    private HashMap<String, String> f22637n = new HashMap();

    private am(Context context) {
        try {
            this.f22631e = new C6511f();
            f22625i = context.getApplicationContext();
            this.f22635l = new ConcurrentHashMap();
            this.f22632f = C6517l.m29762p(context);
            this.f22633g = "pri_" + C6517l.m29762p(context);
            this.f22629c = new C6527d(f22625i, this.f22632f);
            this.f22630d = new C6527d(f22625i, this.f22633g);
            m29678a(true);
            m29678a(false);
            m29686e();
            m29697b(f22625i);
            m29690i();
            m29691j();
        } catch (Throwable th) {
            f22624h.m29705b(th);
        }
    }

    public static am m29668a(Context context) {
        if (f22626j == null) {
            synchronized (am.class) {
                if (f22626j == null) {
                    f22626j = new am(context);
                }
            }
        }
        return f22626j;
    }

    private static String m29669a(List<C6528e> list) {
        StringBuilder stringBuilder = new StringBuilder(list.size() * 3);
        stringBuilder.append("event_id in (");
        int size = list.size();
        int i = 0;
        for (C6528e c6528e : list) {
            stringBuilder.append(c6528e.f22745a);
            if (i != size - 1) {
                stringBuilder.append(",");
            }
            i++;
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private synchronized void m29670a(int i, boolean z) {
        try {
            if (this.f22627a > 0 && i > 0 && !C6546x.m29867a()) {
                if (C6544v.m29830b()) {
                    f22624h.m29702a("Load " + this.f22627a + " unsent events");
                }
                List arrayList = new ArrayList(i);
                m29683b(arrayList, i, z);
                if (arrayList.size() > 0) {
                    if (C6544v.m29830b()) {
                        f22624h.m29702a("Peek " + arrayList.size() + " unsent events.");
                    }
                    m29677a(arrayList, 2, z);
                    C6534l.m29803b(f22625i).m29806b(arrayList, new C6525b(this, arrayList, z));
                }
            }
        } catch (Throwable th) {
            f22624h.m29705b(th);
        }
    }

    static /* synthetic */ void m29672a(am amVar, int i, boolean z) {
        int f = i == -1 ? !z ? amVar.m29687f() : amVar.m29688g() : i;
        if (f > 0) {
            int l = (C6544v.m29845l() * 60) * C6544v.m29841h();
            if (f > l && l > 0) {
                f = l;
            }
            int i2 = C6544v.m29842i();
            int i3 = f / i2;
            int i4 = f % i2;
            if (C6544v.m29830b()) {
                f22624h.m29702a("sentStoreEventsByDb sendNumbers=" + f + ",important=" + z + ",maxSendNumPerFor1Period=" + l + ",maxCount=" + i3 + ",restNumbers=" + i4);
            }
            for (f = 0; f < i3; f++) {
                amVar.m29670a(i2, z);
            }
            if (i4 > 0) {
                amVar.m29670a(i4, z);
            }
        }
    }

    private synchronized void m29677a(List<C6528e> list, int i, boolean z) {
        SQLiteDatabase b;
        Throwable th;
        String str = null;
        synchronized (this) {
            if (list.size() != 0) {
                int g = !z ? C6544v.m29840g() : C6544v.m29837e();
                try {
                    String str2;
                    b = m29679b(z);
                    if (i == 2) {
                        try {
                            str2 = "update events set status=" + i + ", send_count=send_count+1  where " + m29669a((List) list);
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                f22624h.m29705b(th);
                                if (b != null) {
                                    try {
                                        b.endTransaction();
                                    } catch (Throwable th3) {
                                        f22624h.m29705b(th3);
                                    }
                                }
                            } catch (Throwable th4) {
                                th3 = th4;
                                if (b != null) {
                                    try {
                                        b.endTransaction();
                                    } catch (Throwable th5) {
                                        f22624h.m29705b(th5);
                                    }
                                }
                                throw th3;
                            }
                        }
                    }
                    String str3 = "update events set status=" + i + " where " + m29669a((List) list);
                    if (this.f22634k % 3 == 0) {
                        str = "delete from events where send_count>" + g;
                    }
                    this.f22634k++;
                    str2 = str3;
                    if (C6544v.m29830b()) {
                        f22624h.m29702a("update sql:" + str2);
                    }
                    b.beginTransaction();
                    b.execSQL(str2);
                    if (str != null) {
                        f22624h.m29702a("update for delete sql:" + str);
                        b.execSQL(str);
                        m29686e();
                    }
                    b.setTransactionSuccessful();
                    if (b != null) {
                        try {
                            b.endTransaction();
                        } catch (Throwable th32) {
                            f22624h.m29705b(th32);
                        }
                    }
                } catch (Throwable th6) {
                    th32 = th6;
                    b = null;
                    if (b != null) {
                        b.endTransaction();
                    }
                    throw th32;
                }
            }
        }
    }

    private void m29678a(boolean z) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = m29679b(z);
            sQLiteDatabase.beginTransaction();
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", Integer.valueOf(1));
            int update = sQLiteDatabase.update("events", contentValues, "status=?", new String[]{Long.toString(2)});
            if (C6544v.m29830b()) {
                f22624h.m29702a("update " + update + " unsent events.");
            }
            sQLiteDatabase.setTransactionSuccessful();
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable th) {
                    f22624h.m29705b(th);
                }
            }
        } catch (Throwable th2) {
            f22624h.m29705b(th2);
        }
    }

    private SQLiteDatabase m29679b(boolean z) {
        return !z ? this.f22629c.getWritableDatabase() : this.f22630d.getWritableDatabase();
    }

    public static am m29680b() {
        return f22626j;
    }

    private synchronized void m29681b(com.tencent.wxop.stat.p546a.C6495d r7, com.tencent.wxop.stat.C6505k r8, boolean r9, boolean r10) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.tencent.wxop.stat.am.b(com.tencent.wxop.stat.a.d, com.tencent.wxop.stat.k, boolean, boolean):void. bs: [B:20:0x0095, B:51:0x00ec]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
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
        r6 = this;
        r1 = 0;
        monitor-enter(r6);
        r0 = com.tencent.wxop.stat.C6544v.m29843j();	 Catch:{ all -> 0x00f0 }
        if (r0 <= 0) goto L_0x00c8;	 Catch:{ all -> 0x00f0 }
    L_0x0008:
        r0 = com.tencent.wxop.stat.C6544v.f22818n;	 Catch:{ all -> 0x00f0 }
        if (r0 <= 0) goto L_0x0010;
    L_0x000c:
        if (r9 != 0) goto L_0x0010;
    L_0x000e:
        if (r10 == 0) goto L_0x0113;
    L_0x0010:
        r1 = r6.m29679b(r9);	 Catch:{ Throwable -> 0x00d2 }
        r1.beginTransaction();	 Catch:{ Throwable -> 0x00d2 }
        if (r9 != 0) goto L_0x003c;	 Catch:{ Throwable -> 0x00d2 }
    L_0x0019:
        r0 = r6.f22627a;	 Catch:{ Throwable -> 0x00d2 }
        r2 = com.tencent.wxop.stat.C6544v.m29843j();	 Catch:{ Throwable -> 0x00d2 }
        if (r0 <= r2) goto L_0x003c;	 Catch:{ Throwable -> 0x00d2 }
    L_0x0021:
        r0 = f22624h;	 Catch:{ Throwable -> 0x00d2 }
        r2 = "Too many events stored in db.";	 Catch:{ Throwable -> 0x00d2 }
        r0.m29704b(r2);	 Catch:{ Throwable -> 0x00d2 }
        r0 = r6.f22627a;	 Catch:{ Throwable -> 0x00d2 }
        r2 = r6.f22629c;	 Catch:{ Throwable -> 0x00d2 }
        r2 = r2.getWritableDatabase();	 Catch:{ Throwable -> 0x00d2 }
        r3 = "events";	 Catch:{ Throwable -> 0x00d2 }
        r4 = "event_id in (select event_id from events where timestamp in (select min(timestamp) from events) limit 1)";	 Catch:{ Throwable -> 0x00d2 }
        r5 = 0;	 Catch:{ Throwable -> 0x00d2 }
        r2 = r2.delete(r3, r4, r5);	 Catch:{ Throwable -> 0x00d2 }
        r0 = r0 - r2;	 Catch:{ Throwable -> 0x00d2 }
        r6.f22627a = r0;	 Catch:{ Throwable -> 0x00d2 }
    L_0x003c:
        r0 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x00d2 }
        r0.<init>();	 Catch:{ Throwable -> 0x00d2 }
        r2 = r7.m29635g();	 Catch:{ Throwable -> 0x00d2 }
        r3 = com.tencent.wxop.stat.C6544v.m29830b();	 Catch:{ Throwable -> 0x00d2 }
        if (r3 == 0) goto L_0x005f;	 Catch:{ Throwable -> 0x00d2 }
    L_0x004b:
        r3 = f22624h;	 Catch:{ Throwable -> 0x00d2 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00d2 }
        r5 = "insert 1 event, content:";	 Catch:{ Throwable -> 0x00d2 }
        r4.<init>(r5);	 Catch:{ Throwable -> 0x00d2 }
        r4 = r4.append(r2);	 Catch:{ Throwable -> 0x00d2 }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x00d2 }
        r3.m29702a(r4);	 Catch:{ Throwable -> 0x00d2 }
    L_0x005f:
        r2 = com.tencent.wxop.stat.p547b.C6523r.m29788b(r2);	 Catch:{ Throwable -> 0x00d2 }
        r3 = "content";	 Catch:{ Throwable -> 0x00d2 }
        r0.put(r3, r2);	 Catch:{ Throwable -> 0x00d2 }
        r2 = "send_count";	 Catch:{ Throwable -> 0x00d2 }
        r3 = "0";	 Catch:{ Throwable -> 0x00d2 }
        r0.put(r2, r3);	 Catch:{ Throwable -> 0x00d2 }
        r2 = "status";	 Catch:{ Throwable -> 0x00d2 }
        r3 = 1;	 Catch:{ Throwable -> 0x00d2 }
        r3 = java.lang.Integer.toString(r3);	 Catch:{ Throwable -> 0x00d2 }
        r0.put(r2, r3);	 Catch:{ Throwable -> 0x00d2 }
        r2 = "timestamp";	 Catch:{ Throwable -> 0x00d2 }
        r4 = r7.m29631c();	 Catch:{ Throwable -> 0x00d2 }
        r3 = java.lang.Long.valueOf(r4);	 Catch:{ Throwable -> 0x00d2 }
        r0.put(r2, r3);	 Catch:{ Throwable -> 0x00d2 }
        r2 = "events";	 Catch:{ Throwable -> 0x00d2 }
        r3 = 0;	 Catch:{ Throwable -> 0x00d2 }
        r2 = r1.insert(r2, r3, r0);	 Catch:{ Throwable -> 0x00d2 }
        r1.setTransactionSuccessful();	 Catch:{ Throwable -> 0x00d2 }
        if (r1 == 0) goto L_0x018d;
    L_0x0095:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00ca }
        r0 = r2;
    L_0x0099:
        r2 = 0;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 <= 0) goto L_0x00fa;
    L_0x009f:
        r0 = r6.f22627a;	 Catch:{ all -> 0x00f0 }
        r0 = r0 + 1;	 Catch:{ all -> 0x00f0 }
        r6.f22627a = r0;	 Catch:{ all -> 0x00f0 }
        r0 = com.tencent.wxop.stat.C6544v.m29830b();	 Catch:{ all -> 0x00f0 }
        if (r0 == 0) goto L_0x00c3;	 Catch:{ all -> 0x00f0 }
    L_0x00ab:
        r0 = f22624h;	 Catch:{ all -> 0x00f0 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00f0 }
        r2 = "directStoreEvent insert event to db, event:";	 Catch:{ all -> 0x00f0 }
        r1.<init>(r2);	 Catch:{ all -> 0x00f0 }
        r2 = r7.m29635g();	 Catch:{ all -> 0x00f0 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x00f0 }
        r1 = r1.toString();	 Catch:{ all -> 0x00f0 }
        r0.m29710g(r1);	 Catch:{ all -> 0x00f0 }
    L_0x00c3:
        if (r8 == 0) goto L_0x00c8;	 Catch:{ all -> 0x00f0 }
    L_0x00c5:
        r8.mo5349a();	 Catch:{ all -> 0x00f0 }
    L_0x00c8:
        monitor-exit(r6);
        return;
    L_0x00ca:
        r0 = move-exception;
        r1 = f22624h;	 Catch:{ all -> 0x00f0 }
        r1.m29705b(r0);	 Catch:{ all -> 0x00f0 }
        r0 = r2;
        goto L_0x0099;
    L_0x00d2:
        r0 = move-exception;
        r2 = -1;
        r4 = f22624h;	 Catch:{ all -> 0x00e9 }
        r4.m29705b(r0);	 Catch:{ all -> 0x00e9 }
        if (r1 == 0) goto L_0x018d;
    L_0x00dc:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00e1 }
        r0 = r2;
        goto L_0x0099;
    L_0x00e1:
        r0 = move-exception;
        r1 = f22624h;	 Catch:{ all -> 0x00f0 }
        r1.m29705b(r0);	 Catch:{ all -> 0x00f0 }
        r0 = r2;
        goto L_0x0099;
    L_0x00e9:
        r0 = move-exception;
        if (r1 == 0) goto L_0x00ef;
    L_0x00ec:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00f3 }
    L_0x00ef:
        throw r0;	 Catch:{ all -> 0x00f0 }
    L_0x00f0:
        r0 = move-exception;
        monitor-exit(r6);
        throw r0;
    L_0x00f3:
        r1 = move-exception;
        r2 = f22624h;	 Catch:{ all -> 0x00f0 }
        r2.m29705b(r1);	 Catch:{ all -> 0x00f0 }
        goto L_0x00ef;	 Catch:{ all -> 0x00f0 }
    L_0x00fa:
        r0 = f22624h;	 Catch:{ all -> 0x00f0 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00f0 }
        r2 = "Failed to store event:";	 Catch:{ all -> 0x00f0 }
        r1.<init>(r2);	 Catch:{ all -> 0x00f0 }
        r2 = r7.m29635g();	 Catch:{ all -> 0x00f0 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x00f0 }
        r1 = r1.toString();	 Catch:{ all -> 0x00f0 }
        r0.m29707d(r1);	 Catch:{ all -> 0x00f0 }
        goto L_0x00c8;	 Catch:{ all -> 0x00f0 }
    L_0x0113:
        r0 = com.tencent.wxop.stat.C6544v.f22818n;	 Catch:{ all -> 0x00f0 }
        if (r0 <= 0) goto L_0x00c8;	 Catch:{ all -> 0x00f0 }
    L_0x0117:
        r0 = com.tencent.wxop.stat.C6544v.m29830b();	 Catch:{ all -> 0x00f0 }
        if (r0 == 0) goto L_0x0167;	 Catch:{ all -> 0x00f0 }
    L_0x011d:
        r0 = f22624h;	 Catch:{ all -> 0x00f0 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00f0 }
        r2 = "cacheEventsInMemory.size():";	 Catch:{ all -> 0x00f0 }
        r1.<init>(r2);	 Catch:{ all -> 0x00f0 }
        r2 = r6.f22635l;	 Catch:{ all -> 0x00f0 }
        r2 = r2.size();	 Catch:{ all -> 0x00f0 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x00f0 }
        r2 = ",numEventsCachedInMemory:";	 Catch:{ all -> 0x00f0 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x00f0 }
        r2 = com.tencent.wxop.stat.C6544v.f22818n;	 Catch:{ all -> 0x00f0 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x00f0 }
        r2 = ",numStoredEvents:";	 Catch:{ all -> 0x00f0 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x00f0 }
        r2 = r6.f22627a;	 Catch:{ all -> 0x00f0 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x00f0 }
        r1 = r1.toString();	 Catch:{ all -> 0x00f0 }
        r0.m29702a(r1);	 Catch:{ all -> 0x00f0 }
        r0 = f22624h;	 Catch:{ all -> 0x00f0 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00f0 }
        r2 = "cache event:";	 Catch:{ all -> 0x00f0 }
        r1.<init>(r2);	 Catch:{ all -> 0x00f0 }
        r2 = r7.m29635g();	 Catch:{ all -> 0x00f0 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x00f0 }
        r1 = r1.toString();	 Catch:{ all -> 0x00f0 }
        r0.m29702a(r1);	 Catch:{ all -> 0x00f0 }
    L_0x0167:
        r0 = r6.f22635l;	 Catch:{ all -> 0x00f0 }
        r1 = "";	 Catch:{ all -> 0x00f0 }
        r0.put(r7, r1);	 Catch:{ all -> 0x00f0 }
        r0 = r6.f22635l;	 Catch:{ all -> 0x00f0 }
        r0 = r0.size();	 Catch:{ all -> 0x00f0 }
        r1 = com.tencent.wxop.stat.C6544v.f22818n;	 Catch:{ all -> 0x00f0 }
        if (r0 < r1) goto L_0x017b;	 Catch:{ all -> 0x00f0 }
    L_0x0178:
        r6.m29689h();	 Catch:{ all -> 0x00f0 }
    L_0x017b:
        if (r8 == 0) goto L_0x00c8;	 Catch:{ all -> 0x00f0 }
    L_0x017d:
        r0 = r6.f22635l;	 Catch:{ all -> 0x00f0 }
        r0 = r0.size();	 Catch:{ all -> 0x00f0 }
        if (r0 <= 0) goto L_0x0188;	 Catch:{ all -> 0x00f0 }
    L_0x0185:
        r6.m29689h();	 Catch:{ all -> 0x00f0 }
    L_0x0188:
        r8.mo5349a();	 Catch:{ all -> 0x00f0 }
        goto L_0x00c8;
    L_0x018d:
        r0 = r2;
        goto L_0x0099;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.am.b(com.tencent.wxop.stat.a.d, com.tencent.wxop.stat.k, boolean, boolean):void");
    }

    private synchronized void m29682b(C6532i c6532i) {
        Throwable th;
        Cursor query;
        try {
            Object obj;
            long update;
            String jSONObject = c6532i.f22755b.toString();
            String a = C6517l.m29732a(jSONObject);
            ContentValues contentValues = new ContentValues();
            contentValues.put("content", c6532i.f22755b.toString());
            contentValues.put("md5sum", a);
            c6532i.f22756c = a;
            contentValues.put("version", Integer.valueOf(c6532i.f22757d));
            query = this.f22629c.getReadableDatabase().query("config", null, null, null, null, null, null);
            do {
                try {
                    if (!query.moveToNext()) {
                        obj = null;
                        break;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } while (query.getInt(0) != c6532i.f22754a);
            obj = 1;
            this.f22629c.getWritableDatabase().beginTransaction();
            if (1 == obj) {
                update = (long) this.f22629c.getWritableDatabase().update("config", contentValues, "type=?", new String[]{Integer.toString(c6532i.f22754a)});
            } else {
                contentValues.put("type", Integer.valueOf(c6532i.f22754a));
                update = this.f22629c.getWritableDatabase().insert("config", null, contentValues);
            }
            if (update == -1) {
                f22624h.m29708e("Failed to store cfg:" + jSONObject);
            } else {
                f22624h.m29710g("Sucessed to store cfg:" + jSONObject);
            }
            this.f22629c.getWritableDatabase().setTransactionSuccessful();
            if (query != null) {
                query.close();
            }
            try {
                this.f22629c.getWritableDatabase().endTransaction();
            } catch (Exception e) {
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            this.f22629c.getWritableDatabase().endTransaction();
            throw th;
        }
        return;
    }

    private void m29683b(List<C6528e> list, int i, boolean z) {
        SQLiteDatabase readableDatabase;
        Throwable th;
        Cursor cursor;
        Cursor cursor2;
        if (z) {
            readableDatabase = this.f22630d.getReadableDatabase();
        } else {
            try {
                readableDatabase = this.f22629c.getReadableDatabase();
            } catch (Throwable th2) {
                th = th2;
                cursor2 = null;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        }
        cursor2 = readableDatabase.query("events", null, "status=?", new String[]{Integer.toString(1)}, null, null, null, Integer.toString(i));
        while (cursor2.moveToNext()) {
            try {
                long j = cursor2.getLong(0);
                String string = cursor2.getString(1);
                if (!C6544v.f22811g) {
                    string = C6523r.m29784a(string);
                }
                int i2 = cursor2.getInt(2);
                int i3 = cursor2.getInt(3);
                C6528e c6528e = new C6528e(j, string, i2, i3);
                if (C6544v.m29830b()) {
                    f22624h.m29702a("peek event, id=" + j + ",send_count=" + i3 + ",timestamp=" + cursor2.getLong(4));
                }
                list.add(c6528e);
            } catch (Throwable th3) {
                th = th3;
            }
        }
        if (cursor2 != null) {
            cursor2.close();
        }
    }

    private synchronized void m29684c(java.util.List<com.tencent.wxop.stat.C6528e> r9, boolean r10) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.tencent.wxop.stat.am.c(java.util.List, boolean):void. bs: [B:26:0x00c1, B:49:0x00e9]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
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
        r8 = this;
        r1 = 0;
        monitor-enter(r8);
        r0 = r9.size();	 Catch:{ all -> 0x00ce }
        if (r0 != 0) goto L_0x000a;
    L_0x0008:
        monitor-exit(r8);
        return;
    L_0x000a:
        r0 = com.tencent.wxop.stat.C6544v.m29830b();	 Catch:{ all -> 0x00ce }
        if (r0 == 0) goto L_0x0032;	 Catch:{ all -> 0x00ce }
    L_0x0010:
        r0 = f22624h;	 Catch:{ all -> 0x00ce }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ce }
        r3 = "Delete ";	 Catch:{ all -> 0x00ce }
        r2.<init>(r3);	 Catch:{ all -> 0x00ce }
        r3 = r9.size();	 Catch:{ all -> 0x00ce }
        r2 = r2.append(r3);	 Catch:{ all -> 0x00ce }
        r3 = " events, important:";	 Catch:{ all -> 0x00ce }
        r2 = r2.append(r3);	 Catch:{ all -> 0x00ce }
        r2 = r2.append(r10);	 Catch:{ all -> 0x00ce }
        r2 = r2.toString();	 Catch:{ all -> 0x00ce }
        r0.m29702a(r2);	 Catch:{ all -> 0x00ce }
    L_0x0032:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ce }
        r0 = r9.size();	 Catch:{ all -> 0x00ce }
        r0 = r0 * 3;	 Catch:{ all -> 0x00ce }
        r3.<init>(r0);	 Catch:{ all -> 0x00ce }
        r0 = "event_id in (";	 Catch:{ all -> 0x00ce }
        r3.append(r0);	 Catch:{ all -> 0x00ce }
        r0 = 0;	 Catch:{ all -> 0x00ce }
        r4 = r9.size();	 Catch:{ all -> 0x00ce }
        r5 = r9.iterator();	 Catch:{ all -> 0x00ce }
        r2 = r0;	 Catch:{ all -> 0x00ce }
    L_0x004c:
        r0 = r5.hasNext();	 Catch:{ all -> 0x00ce }
        if (r0 == 0) goto L_0x006a;	 Catch:{ all -> 0x00ce }
    L_0x0052:
        r0 = r5.next();	 Catch:{ all -> 0x00ce }
        r0 = (com.tencent.wxop.stat.C6528e) r0;	 Catch:{ all -> 0x00ce }
        r6 = r0.f22745a;	 Catch:{ all -> 0x00ce }
        r3.append(r6);	 Catch:{ all -> 0x00ce }
        r0 = r4 + -1;	 Catch:{ all -> 0x00ce }
        if (r2 == r0) goto L_0x0066;	 Catch:{ all -> 0x00ce }
    L_0x0061:
        r0 = ",";	 Catch:{ all -> 0x00ce }
        r3.append(r0);	 Catch:{ all -> 0x00ce }
    L_0x0066:
        r0 = r2 + 1;	 Catch:{ all -> 0x00ce }
        r2 = r0;	 Catch:{ all -> 0x00ce }
        goto L_0x004c;	 Catch:{ all -> 0x00ce }
    L_0x006a:
        r0 = ")";	 Catch:{ all -> 0x00ce }
        r3.append(r0);	 Catch:{ all -> 0x00ce }
        r1 = r8.m29679b(r10);	 Catch:{ Throwable -> 0x00d1 }
        r1.beginTransaction();	 Catch:{ Throwable -> 0x00d1 }
        r0 = "events";	 Catch:{ Throwable -> 0x00d1 }
        r2 = r3.toString();	 Catch:{ Throwable -> 0x00d1 }
        r5 = 0;	 Catch:{ Throwable -> 0x00d1 }
        r0 = r1.delete(r0, r2, r5);	 Catch:{ Throwable -> 0x00d1 }
        r2 = com.tencent.wxop.stat.C6544v.m29830b();	 Catch:{ Throwable -> 0x00d1 }
        if (r2 == 0) goto L_0x00b3;	 Catch:{ Throwable -> 0x00d1 }
    L_0x0087:
        r2 = f22624h;	 Catch:{ Throwable -> 0x00d1 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00d1 }
        r6 = "delete ";	 Catch:{ Throwable -> 0x00d1 }
        r5.<init>(r6);	 Catch:{ Throwable -> 0x00d1 }
        r4 = r5.append(r4);	 Catch:{ Throwable -> 0x00d1 }
        r5 = " event ";	 Catch:{ Throwable -> 0x00d1 }
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x00d1 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x00d1 }
        r3 = r4.append(r3);	 Catch:{ Throwable -> 0x00d1 }
        r4 = ", success delete:";	 Catch:{ Throwable -> 0x00d1 }
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x00d1 }
        r3 = r3.append(r0);	 Catch:{ Throwable -> 0x00d1 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x00d1 }
        r2.m29702a(r3);	 Catch:{ Throwable -> 0x00d1 }
    L_0x00b3:
        r2 = r8.f22627a;	 Catch:{ Throwable -> 0x00d1 }
        r0 = r2 - r0;	 Catch:{ Throwable -> 0x00d1 }
        r8.f22627a = r0;	 Catch:{ Throwable -> 0x00d1 }
        r1.setTransactionSuccessful();	 Catch:{ Throwable -> 0x00d1 }
        r8.m29686e();	 Catch:{ Throwable -> 0x00d1 }
        if (r1 == 0) goto L_0x0008;
    L_0x00c1:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00c6 }
        goto L_0x0008;
    L_0x00c6:
        r0 = move-exception;
        r1 = f22624h;	 Catch:{ all -> 0x00ce }
        r1.m29705b(r0);	 Catch:{ all -> 0x00ce }
        goto L_0x0008;
    L_0x00ce:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
    L_0x00d1:
        r0 = move-exception;
        r2 = f22624h;	 Catch:{ all -> 0x00e6 }
        r2.m29705b(r0);	 Catch:{ all -> 0x00e6 }
        if (r1 == 0) goto L_0x0008;
    L_0x00d9:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00de }
        goto L_0x0008;
    L_0x00de:
        r0 = move-exception;
        r1 = f22624h;	 Catch:{ all -> 0x00ce }
        r1.m29705b(r0);	 Catch:{ all -> 0x00ce }
        goto L_0x0008;
    L_0x00e6:
        r0 = move-exception;
        if (r1 == 0) goto L_0x00ec;
    L_0x00e9:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00ed }
    L_0x00ec:
        throw r0;	 Catch:{ all -> 0x00ce }
    L_0x00ed:
        r1 = move-exception;	 Catch:{ all -> 0x00ce }
        r2 = f22624h;	 Catch:{ all -> 0x00ce }
        r2.m29705b(r1);	 Catch:{ all -> 0x00ce }
        goto L_0x00ec;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.am.c(java.util.List, boolean):void");
    }

    private void m29686e() {
        this.f22627a = m29687f() + m29688g();
    }

    private int m29687f() {
        return (int) DatabaseUtils.queryNumEntries(this.f22629c.getReadableDatabase(), "events");
    }

    private int m29688g() {
        return (int) DatabaseUtils.queryNumEntries(this.f22630d.getReadableDatabase(), "events");
    }

    private void m29689h() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.tencent.wxop.stat.am.h():void. bs: [B:42:0x011e, B:53:0x0136]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
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
        r9 = this;
        r1 = 0;
        r0 = r9.f22636m;
        if (r0 == 0) goto L_0x0006;
    L_0x0005:
        return;
    L_0x0006:
        r2 = r9.f22635l;
        monitor-enter(r2);
        r0 = r9.f22635l;	 Catch:{ all -> 0x0013 }
        r0 = r0.size();	 Catch:{ all -> 0x0013 }
        if (r0 != 0) goto L_0x0016;	 Catch:{ all -> 0x0013 }
    L_0x0011:
        monitor-exit(r2);	 Catch:{ all -> 0x0013 }
        goto L_0x0005;
    L_0x0013:
        r0 = move-exception;
        monitor-exit(r2);
        throw r0;
    L_0x0016:
        r0 = 1;
        r9.f22636m = r0;	 Catch:{ all -> 0x0013 }
        r0 = com.tencent.wxop.stat.C6544v.m29830b();	 Catch:{ all -> 0x0013 }
        if (r0 == 0) goto L_0x0051;	 Catch:{ all -> 0x0013 }
    L_0x001f:
        r0 = f22624h;	 Catch:{ all -> 0x0013 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0013 }
        r4 = "insert ";	 Catch:{ all -> 0x0013 }
        r3.<init>(r4);	 Catch:{ all -> 0x0013 }
        r4 = r9.f22635l;	 Catch:{ all -> 0x0013 }
        r4 = r4.size();	 Catch:{ all -> 0x0013 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0013 }
        r4 = " events ,numEventsCachedInMemory:";	 Catch:{ all -> 0x0013 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0013 }
        r4 = com.tencent.wxop.stat.C6544v.f22818n;	 Catch:{ all -> 0x0013 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0013 }
        r4 = ",numStoredEvents:";	 Catch:{ all -> 0x0013 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0013 }
        r4 = r9.f22627a;	 Catch:{ all -> 0x0013 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0013 }
        r3 = r3.toString();	 Catch:{ all -> 0x0013 }
        r0.m29702a(r3);	 Catch:{ all -> 0x0013 }
    L_0x0051:
        r0 = r9.f22629c;	 Catch:{ Throwable -> 0x00cd }
        r1 = r0.getWritableDatabase();	 Catch:{ Throwable -> 0x00cd }
        r1.beginTransaction();	 Catch:{ Throwable -> 0x00cd }
        r0 = r9.f22635l;	 Catch:{ Throwable -> 0x00cd }
        r0 = r0.entrySet();	 Catch:{ Throwable -> 0x00cd }
        r3 = r0.iterator();	 Catch:{ Throwable -> 0x00cd }
    L_0x0064:
        r0 = r3.hasNext();	 Catch:{ Throwable -> 0x00cd }
        if (r0 == 0) goto L_0x0119;	 Catch:{ Throwable -> 0x00cd }
    L_0x006a:
        r0 = r3.next();	 Catch:{ Throwable -> 0x00cd }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ Throwable -> 0x00cd }
        r0 = r0.getKey();	 Catch:{ Throwable -> 0x00cd }
        r0 = (com.tencent.wxop.stat.p546a.C6495d) r0;	 Catch:{ Throwable -> 0x00cd }
        r4 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x00cd }
        r4.<init>();	 Catch:{ Throwable -> 0x00cd }
        r5 = r0.m29635g();	 Catch:{ Throwable -> 0x00cd }
        r6 = com.tencent.wxop.stat.C6544v.m29830b();	 Catch:{ Throwable -> 0x00cd }
        if (r6 == 0) goto L_0x0099;	 Catch:{ Throwable -> 0x00cd }
    L_0x0085:
        r6 = f22624h;	 Catch:{ Throwable -> 0x00cd }
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00cd }
        r8 = "insert content:";	 Catch:{ Throwable -> 0x00cd }
        r7.<init>(r8);	 Catch:{ Throwable -> 0x00cd }
        r7 = r7.append(r5);	 Catch:{ Throwable -> 0x00cd }
        r7 = r7.toString();	 Catch:{ Throwable -> 0x00cd }
        r6.m29702a(r7);	 Catch:{ Throwable -> 0x00cd }
    L_0x0099:
        r5 = com.tencent.wxop.stat.p547b.C6523r.m29788b(r5);	 Catch:{ Throwable -> 0x00cd }
        r6 = "content";	 Catch:{ Throwable -> 0x00cd }
        r4.put(r6, r5);	 Catch:{ Throwable -> 0x00cd }
        r5 = "send_count";	 Catch:{ Throwable -> 0x00cd }
        r6 = "0";	 Catch:{ Throwable -> 0x00cd }
        r4.put(r5, r6);	 Catch:{ Throwable -> 0x00cd }
        r5 = "status";	 Catch:{ Throwable -> 0x00cd }
        r6 = 1;	 Catch:{ Throwable -> 0x00cd }
        r6 = java.lang.Integer.toString(r6);	 Catch:{ Throwable -> 0x00cd }
        r4.put(r5, r6);	 Catch:{ Throwable -> 0x00cd }
        r5 = "timestamp";	 Catch:{ Throwable -> 0x00cd }
        r6 = r0.m29631c();	 Catch:{ Throwable -> 0x00cd }
        r0 = java.lang.Long.valueOf(r6);	 Catch:{ Throwable -> 0x00cd }
        r4.put(r5, r0);	 Catch:{ Throwable -> 0x00cd }
        r0 = "events";	 Catch:{ Throwable -> 0x00cd }
        r5 = 0;	 Catch:{ Throwable -> 0x00cd }
        r1.insert(r0, r5, r4);	 Catch:{ Throwable -> 0x00cd }
        r3.remove();	 Catch:{ Throwable -> 0x00cd }
        goto L_0x0064;
    L_0x00cd:
        r0 = move-exception;
        r3 = f22624h;	 Catch:{ all -> 0x0133 }
        r3.m29705b(r0);	 Catch:{ all -> 0x0133 }
        if (r1 == 0) goto L_0x00db;
    L_0x00d5:
        r1.endTransaction();	 Catch:{ Throwable -> 0x012c }
        r9.m29686e();	 Catch:{ Throwable -> 0x012c }
    L_0x00db:
        r0 = 0;
        r9.f22636m = r0;	 Catch:{ all -> 0x0013 }
        r0 = com.tencent.wxop.stat.C6544v.m29830b();	 Catch:{ all -> 0x0013 }
        if (r0 == 0) goto L_0x0116;	 Catch:{ all -> 0x0013 }
    L_0x00e4:
        r0 = f22624h;	 Catch:{ all -> 0x0013 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0013 }
        r3 = "after insert, cacheEventsInMemory.size():";	 Catch:{ all -> 0x0013 }
        r1.<init>(r3);	 Catch:{ all -> 0x0013 }
        r3 = r9.f22635l;	 Catch:{ all -> 0x0013 }
        r3 = r3.size();	 Catch:{ all -> 0x0013 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0013 }
        r3 = ",numEventsCachedInMemory:";	 Catch:{ all -> 0x0013 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0013 }
        r3 = com.tencent.wxop.stat.C6544v.f22818n;	 Catch:{ all -> 0x0013 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0013 }
        r3 = ",numStoredEvents:";	 Catch:{ all -> 0x0013 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0013 }
        r3 = r9.f22627a;	 Catch:{ all -> 0x0013 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0013 }
        r1 = r1.toString();	 Catch:{ all -> 0x0013 }
        r0.m29702a(r1);	 Catch:{ all -> 0x0013 }
    L_0x0116:
        monitor-exit(r2);	 Catch:{ all -> 0x0013 }
        goto L_0x0005;
    L_0x0119:
        r1.setTransactionSuccessful();	 Catch:{ Throwable -> 0x00cd }
        if (r1 == 0) goto L_0x00db;
    L_0x011e:
        r1.endTransaction();	 Catch:{ Throwable -> 0x0125 }
        r9.m29686e();	 Catch:{ Throwable -> 0x0125 }
        goto L_0x00db;
    L_0x0125:
        r0 = move-exception;
        r1 = f22624h;	 Catch:{ all -> 0x0013 }
        r1.m29705b(r0);	 Catch:{ all -> 0x0013 }
        goto L_0x00db;	 Catch:{ all -> 0x0013 }
    L_0x012c:
        r0 = move-exception;	 Catch:{ all -> 0x0013 }
        r1 = f22624h;	 Catch:{ all -> 0x0013 }
        r1.m29705b(r0);	 Catch:{ all -> 0x0013 }
        goto L_0x00db;
    L_0x0133:
        r0 = move-exception;
        if (r1 == 0) goto L_0x013c;
    L_0x0136:
        r1.endTransaction();	 Catch:{ Throwable -> 0x013d }
        r9.m29686e();	 Catch:{ Throwable -> 0x013d }
    L_0x013c:
        throw r0;	 Catch:{ all -> 0x0013 }
    L_0x013d:
        r1 = move-exception;	 Catch:{ all -> 0x0013 }
        r3 = f22624h;	 Catch:{ all -> 0x0013 }
        r3.m29705b(r1);	 Catch:{ all -> 0x0013 }
        goto L_0x013c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.am.h():void");
    }

    private void m29690i() {
        Cursor query;
        Throwable th;
        try {
            query = this.f22629c.getReadableDatabase().query("config", null, null, null, null, null, null);
            while (query.moveToNext()) {
                try {
                    int i = query.getInt(0);
                    String string = query.getString(1);
                    String string2 = query.getString(2);
                    int i2 = query.getInt(3);
                    C6532i c6532i = new C6532i(i);
                    c6532i.f22754a = i;
                    c6532i.f22755b = new JSONObject(string);
                    c6532i.f22756c = string2;
                    c6532i.f22757d = i2;
                    C6544v.m29819a(f22625i, c6532i);
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    private void m29691j() {
        Cursor query;
        Throwable th;
        try {
            query = this.f22629c.getReadableDatabase().query("keyvalues", null, null, null, null, null, null);
            while (query.moveToNext()) {
                try {
                    this.f22637n.put(query.getString(0), query.getString(1));
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public final int m29692a() {
        return this.f22627a;
    }

    final void m29693a(int i) {
        this.f22631e.m29719a(new C6526c(this, i));
    }

    final void m29694a(C6495d c6495d, C6505k c6505k, boolean z, boolean z2) {
        if (this.f22631e != null) {
            this.f22631e.m29719a(new aq(this, c6495d, c6505k, z, z2));
        }
    }

    final void m29695a(C6532i c6532i) {
        if (c6532i != null) {
            this.f22631e.m29719a(new ar(this, c6532i));
        }
    }

    final void m29696a(List<C6528e> list, boolean z) {
        if (this.f22631e != null) {
            this.f22631e.m29719a(new an(this, list, z));
        }
    }

    public final synchronized C6508c m29697b(Context context) {
        C6508c c6508c;
        Cursor query;
        Throwable th;
        Cursor cursor;
        if (this.f22628b != null) {
            c6508c = this.f22628b;
        } else {
            try {
                this.f22629c.getWritableDatabase().beginTransaction();
                if (C6544v.m29830b()) {
                    f22624h.m29702a((Object) "try to load user info from db.");
                }
                query = this.f22629c.getReadableDatabase().query("user", null, null, null, null, null, null, null);
                Object obj = null;
                try {
                    String string;
                    String b;
                    if (query.moveToNext()) {
                        String a = C6523r.m29784a(query.getString(0));
                        int i = query.getInt(1);
                        string = query.getString(2);
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        int i2 = (i == 1 || C6517l.m29730a(query.getLong(3) * 1000).equals(C6517l.m29730a(1000 * currentTimeMillis))) ? i : 1;
                        int i3 = !string.equals(C6517l.m29759m(context)) ? i2 | 2 : i2;
                        String[] split = a.split(",");
                        obj = null;
                        if (split == null || split.length <= 0) {
                            b = C6517l.m29739b(context);
                            obj = 1;
                            a = b;
                        } else {
                            b = split[0];
                            if (b == null || b.length() < 11) {
                                string = C6523r.m29783a(context);
                                if (string == null || string.length() <= 10) {
                                    string = b;
                                } else {
                                    obj = 1;
                                }
                                b = a;
                                a = string;
                            } else {
                                String str = b;
                                b = a;
                                a = str;
                            }
                        }
                        if (split == null || split.length < 2) {
                            string = C6517l.m29741c(context);
                            if (string != null && string.length() > 0) {
                                b = a + "," + string;
                                obj = 1;
                            }
                        } else {
                            string = split[1];
                            b = a + "," + string;
                        }
                        this.f22628b = new C6508c(a, string, i3);
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("uid", C6523r.m29788b(b));
                        contentValues.put("user_type", Integer.valueOf(i3));
                        contentValues.put("app_ver", C6517l.m29759m(context));
                        contentValues.put("ts", Long.valueOf(currentTimeMillis));
                        if (obj != null) {
                            this.f22629c.getWritableDatabase().update("user", contentValues, "uid=?", new String[]{r10});
                        }
                        if (i3 != i) {
                            this.f22629c.getWritableDatabase().replace("user", null, contentValues);
                        }
                        obj = 1;
                    }
                    if (obj == null) {
                        string = C6517l.m29739b(context);
                        b = C6517l.m29741c(context);
                        String str2 = (b == null || b.length() <= 0) ? string : string + "," + b;
                        long currentTimeMillis2 = System.currentTimeMillis() / 1000;
                        String m = C6517l.m29759m(context);
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("uid", C6523r.m29788b(str2));
                        contentValues2.put("user_type", Integer.valueOf(0));
                        contentValues2.put("app_ver", m);
                        contentValues2.put("ts", Long.valueOf(currentTimeMillis2));
                        this.f22629c.getWritableDatabase().insert("user", null, contentValues2);
                        this.f22628b = new C6508c(string, b, 0);
                    }
                    this.f22629c.getWritableDatabase().setTransactionSuccessful();
                    if (query != null) {
                        try {
                            query.close();
                        } catch (Throwable th2) {
                            f22624h.m29705b(th2);
                        }
                    }
                    this.f22629c.getWritableDatabase().endTransaction();
                } catch (Throwable th3) {
                    th2 = th3;
                    if (query != null) {
                        query.close();
                    }
                    this.f22629c.getWritableDatabase().endTransaction();
                    throw th2;
                }
            } catch (Throwable th4) {
                th2 = th4;
                query = null;
                if (query != null) {
                    query.close();
                }
                this.f22629c.getWritableDatabase().endTransaction();
                throw th2;
            }
            c6508c = this.f22628b;
        }
        return c6508c;
    }

    final void m29698b(List<C6528e> list, boolean z) {
        if (this.f22631e != null) {
            this.f22631e.m29719a(new ao(this, list, z));
        }
    }

    final void m29699c() {
        if (C6544v.m29833c()) {
            try {
                this.f22631e.m29719a(new ap(this));
            } catch (Throwable th) {
                f22624h.m29705b(th);
            }
        }
    }
}
