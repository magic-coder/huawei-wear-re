package com.tencent.stat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.stat.p544a.C6443b;
import com.tencent.stat.p545b.C6452b;
import com.tencent.stat.p545b.C6463m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class C6487u {
    private static C6452b f22536e = C6463m.m29449b();
    private static C6487u f22537f = null;
    Handler f22538a = null;
    volatile int f22539b = 0;
    C6449a f22540c = null;
    private ad f22541d;
    private HashMap<String, String> f22542g = new HashMap();

    private C6487u(Context context) {
        try {
            HandlerThread handlerThread = new HandlerThread("StatStore");
            handlerThread.start();
            f22536e.m29409d("Launch store thread:" + handlerThread);
            this.f22538a = new Handler(handlerThread.getLooper());
            Context applicationContext = context.getApplicationContext();
            this.f22541d = new ad(applicationContext);
            this.f22541d.getWritableDatabase();
            this.f22541d.getReadableDatabase();
            m29618b(applicationContext);
            m29619c();
            m29611f();
            this.f22538a.post(new C6488v(this));
        } catch (Throwable th) {
            f22536e.m29411f(th);
        }
    }

    public static synchronized C6487u m29594a(Context context) {
        C6487u c6487u;
        synchronized (C6487u.class) {
            if (f22537f == null) {
                f22537f = new C6487u(context);
            }
            c6487u = f22537f;
        }
        return c6487u;
    }

    public static C6487u m29602b() {
        return f22537f;
    }

    private synchronized void m29603b(int i) {
        try {
            if (this.f22539b > 0 && i > 0) {
                f22536e.m29407b("Load " + Integer.toString(this.f22539b) + " unsent events");
                List arrayList = new ArrayList();
                List<ae> arrayList2 = new ArrayList();
                if (i == -1 || i > C6470c.m29523f()) {
                    i = C6470c.m29523f();
                }
                this.f22539b -= i;
                m29608c(arrayList2, i);
                f22536e.m29407b("Peek " + Integer.toString(arrayList2.size()) + " unsent events.");
                if (!arrayList2.isEmpty()) {
                    m29607b((List) arrayList2, 2);
                    for (ae aeVar : arrayList2) {
                        arrayList.add(aeVar.f22380b);
                    }
                    C6477k.m29580b().m29584b(arrayList, new ab(this, arrayList2, i));
                }
            }
        } catch (Throwable th) {
            f22536e.m29411f(th);
        }
    }

    private synchronized void m29604b(C6443b c6443b, C6450j c6450j) {
        if (C6470c.m29524g() > 0) {
            try {
                this.f22541d.getWritableDatabase().beginTransaction();
                if (this.f22539b > C6470c.m29524g()) {
                    f22536e.m29408c("Too many events stored in db.");
                    this.f22539b -= this.f22541d.getWritableDatabase().delete("events", "event_id in (select event_id from events where timestamp in (select min(timestamp) from events) limit 1)", null);
                }
                ContentValues contentValues = new ContentValues();
                String c = C6463m.m29454c(c6443b.m29367d());
                contentValues.put("content", c);
                contentValues.put("send_count", "0");
                contentValues.put("status", Integer.toString(1));
                contentValues.put("timestamp", Long.valueOf(c6443b.m29364b()));
                if (this.f22541d.getWritableDatabase().insert("events", null, contentValues) == -1) {
                    f22536e.m29410e("Failed to store event:" + c);
                } else {
                    this.f22539b++;
                    this.f22541d.getWritableDatabase().setTransactionSuccessful();
                    if (c6450j != null) {
                        c6450j.mo5344a();
                    }
                }
                try {
                    this.f22541d.getWritableDatabase().endTransaction();
                } catch (Throwable th) {
                }
            } catch (Throwable th2) {
            }
        }
        return;
    }

    private synchronized void m29605b(C6476i c6476i) {
        Throwable th;
        Cursor query;
        Object obj;
        try {
            long update;
            String a = c6476i.m29577a();
            String a2 = C6463m.m29443a(a);
            ContentValues contentValues = new ContentValues();
            contentValues.put("content", c6476i.f22513b.toString());
            contentValues.put("md5sum", a2);
            c6476i.f22514c = a2;
            contentValues.put("version", Integer.valueOf(c6476i.f22515d));
            query = this.f22541d.getReadableDatabase().query("config", null, null, null, null, null, null);
            do {
                try {
                    if (!query.moveToNext()) {
                        obj = null;
                        break;
                    }
                } catch (Throwable th2) {
                    obj = th2;
                }
            } while (query.getInt(0) != c6476i.f22512a);
            obj = 1;
            if (1 == obj) {
                update = (long) this.f22541d.getWritableDatabase().update("config", contentValues, "type=?", new String[]{Integer.toString(c6476i.f22512a)});
            } else {
                contentValues.put("type", Integer.valueOf(c6476i.f22512a));
                update = this.f22541d.getWritableDatabase().insert("config", null, contentValues);
            }
            if (update == -1) {
                f22536e.m29411f("Failed to store cfg:" + a);
            } else {
                f22536e.m29413h("Sucessed to store cfg:" + a);
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

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m29606b(java.util.List<com.tencent.stat.ae> r11) {
        /*
        r10 = this;
        monitor-enter(r10);
        r0 = f22536e;	 Catch:{ all -> 0x009f }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x009f }
        r1.<init>();	 Catch:{ all -> 0x009f }
        r2 = "Delete ";
        r1 = r1.append(r2);	 Catch:{ all -> 0x009f }
        r2 = r11.size();	 Catch:{ all -> 0x009f }
        r1 = r1.append(r2);	 Catch:{ all -> 0x009f }
        r2 = " sent events in thread:";
        r1 = r1.append(r2);	 Catch:{ all -> 0x009f }
        r2 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x009f }
        r1 = r1.append(r2);	 Catch:{ all -> 0x009f }
        r1 = r1.toString();	 Catch:{ all -> 0x009f }
        r0.m29407b(r1);	 Catch:{ all -> 0x009f }
        r0 = r10.f22541d;	 Catch:{ Throwable -> 0x0065 }
        r0 = r0.getWritableDatabase();	 Catch:{ Throwable -> 0x0065 }
        r0.beginTransaction();	 Catch:{ Throwable -> 0x0065 }
        r1 = r11.iterator();	 Catch:{ Throwable -> 0x0065 }
    L_0x0038:
        r0 = r1.hasNext();	 Catch:{ Throwable -> 0x0065 }
        if (r0 == 0) goto L_0x0076;
    L_0x003e:
        r0 = r1.next();	 Catch:{ Throwable -> 0x0065 }
        r0 = (com.tencent.stat.ae) r0;	 Catch:{ Throwable -> 0x0065 }
        r2 = r10.f22539b;	 Catch:{ Throwable -> 0x0065 }
        r3 = r10.f22541d;	 Catch:{ Throwable -> 0x0065 }
        r3 = r3.getWritableDatabase();	 Catch:{ Throwable -> 0x0065 }
        r4 = "events";
        r5 = "event_id = ?";
        r6 = 1;
        r6 = new java.lang.String[r6];	 Catch:{ Throwable -> 0x0065 }
        r7 = 0;
        r8 = r0.f22379a;	 Catch:{ Throwable -> 0x0065 }
        r0 = java.lang.Long.toString(r8);	 Catch:{ Throwable -> 0x0065 }
        r6[r7] = r0;	 Catch:{ Throwable -> 0x0065 }
        r0 = r3.delete(r4, r5, r6);	 Catch:{ Throwable -> 0x0065 }
        r0 = r2 - r0;
        r10.f22539b = r0;	 Catch:{ Throwable -> 0x0065 }
        goto L_0x0038;
    L_0x0065:
        r0 = move-exception;
        r1 = f22536e;	 Catch:{ all -> 0x00a9 }
        r1.m29411f(r0);	 Catch:{ all -> 0x00a9 }
        r0 = r10.f22541d;	 Catch:{ SQLiteException -> 0x00a2 }
        r0 = r0.getWritableDatabase();	 Catch:{ SQLiteException -> 0x00a2 }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x00a2 }
    L_0x0074:
        monitor-exit(r10);
        return;
    L_0x0076:
        r0 = r10.f22541d;	 Catch:{ Throwable -> 0x0065 }
        r0 = r0.getWritableDatabase();	 Catch:{ Throwable -> 0x0065 }
        r0.setTransactionSuccessful();	 Catch:{ Throwable -> 0x0065 }
        r0 = r10.f22541d;	 Catch:{ Throwable -> 0x0065 }
        r0 = r0.getReadableDatabase();	 Catch:{ Throwable -> 0x0065 }
        r1 = "events";
        r0 = android.database.DatabaseUtils.queryNumEntries(r0, r1);	 Catch:{ Throwable -> 0x0065 }
        r0 = (int) r0;	 Catch:{ Throwable -> 0x0065 }
        r10.f22539b = r0;	 Catch:{ Throwable -> 0x0065 }
        r0 = r10.f22541d;	 Catch:{ SQLiteException -> 0x0098 }
        r0 = r0.getWritableDatabase();	 Catch:{ SQLiteException -> 0x0098 }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x0098 }
        goto L_0x0074;
    L_0x0098:
        r0 = move-exception;
        r1 = f22536e;	 Catch:{ all -> 0x009f }
        r1.m29406b(r0);	 Catch:{ all -> 0x009f }
        goto L_0x0074;
    L_0x009f:
        r0 = move-exception;
        monitor-exit(r10);
        throw r0;
    L_0x00a2:
        r0 = move-exception;
        r1 = f22536e;	 Catch:{ all -> 0x009f }
        r1.m29406b(r0);	 Catch:{ all -> 0x009f }
        goto L_0x0074;
    L_0x00a9:
        r0 = move-exception;
        r1 = r10.f22541d;	 Catch:{ SQLiteException -> 0x00b4 }
        r1 = r1.getWritableDatabase();	 Catch:{ SQLiteException -> 0x00b4 }
        r1.endTransaction();	 Catch:{ SQLiteException -> 0x00b4 }
    L_0x00b3:
        throw r0;	 Catch:{ all -> 0x009f }
    L_0x00b4:
        r1 = move-exception;
        r2 = f22536e;	 Catch:{ all -> 0x009f }
        r2.m29406b(r1);	 Catch:{ all -> 0x009f }
        goto L_0x00b3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.u.b(java.util.List):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m29607b(java.util.List<com.tencent.stat.ae> r13, int r14) {
        /*
        r12 = this;
        monitor-enter(r12);
        r0 = f22536e;	 Catch:{ all -> 0x0110 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0110 }
        r1.<init>();	 Catch:{ all -> 0x0110 }
        r2 = "Update ";
        r1 = r1.append(r2);	 Catch:{ all -> 0x0110 }
        r2 = r13.size();	 Catch:{ all -> 0x0110 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x0110 }
        r2 = " sending events to status:";
        r1 = r1.append(r2);	 Catch:{ all -> 0x0110 }
        r1 = r1.append(r14);	 Catch:{ all -> 0x0110 }
        r2 = " in thread:";
        r1 = r1.append(r2);	 Catch:{ all -> 0x0110 }
        r2 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0110 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x0110 }
        r1 = r1.toString();	 Catch:{ all -> 0x0110 }
        r0.m29407b(r1);	 Catch:{ all -> 0x0110 }
        r1 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x0088 }
        r1.<init>();	 Catch:{ Throwable -> 0x0088 }
        r0 = "status";
        r2 = java.lang.Integer.toString(r14);	 Catch:{ Throwable -> 0x0088 }
        r1.put(r0, r2);	 Catch:{ Throwable -> 0x0088 }
        r0 = r12.f22541d;	 Catch:{ Throwable -> 0x0088 }
        r0 = r0.getWritableDatabase();	 Catch:{ Throwable -> 0x0088 }
        r0.beginTransaction();	 Catch:{ Throwable -> 0x0088 }
        r2 = r13.iterator();	 Catch:{ Throwable -> 0x0088 }
    L_0x0051:
        r0 = r2.hasNext();	 Catch:{ Throwable -> 0x0088 }
        if (r0 == 0) goto L_0x0113;
    L_0x0057:
        r0 = r2.next();	 Catch:{ Throwable -> 0x0088 }
        r0 = (com.tencent.stat.ae) r0;	 Catch:{ Throwable -> 0x0088 }
        r3 = r0.f22382d;	 Catch:{ Throwable -> 0x0088 }
        r3 = r3 + 1;
        r4 = com.tencent.stat.C6470c.m29521e();	 Catch:{ Throwable -> 0x0088 }
        if (r3 <= r4) goto L_0x0099;
    L_0x0067:
        r3 = r12.f22539b;	 Catch:{ Throwable -> 0x0088 }
        r4 = r12.f22541d;	 Catch:{ Throwable -> 0x0088 }
        r4 = r4.getWritableDatabase();	 Catch:{ Throwable -> 0x0088 }
        r5 = "events";
        r6 = "event_id=?";
        r7 = 1;
        r7 = new java.lang.String[r7];	 Catch:{ Throwable -> 0x0088 }
        r8 = 0;
        r10 = r0.f22379a;	 Catch:{ Throwable -> 0x0088 }
        r0 = java.lang.Long.toString(r10);	 Catch:{ Throwable -> 0x0088 }
        r7[r8] = r0;	 Catch:{ Throwable -> 0x0088 }
        r0 = r4.delete(r5, r6, r7);	 Catch:{ Throwable -> 0x0088 }
        r0 = r3 - r0;
        r12.f22539b = r0;	 Catch:{ Throwable -> 0x0088 }
        goto L_0x0051;
    L_0x0088:
        r0 = move-exception;
        r1 = f22536e;	 Catch:{ all -> 0x0105 }
        r1.m29411f(r0);	 Catch:{ all -> 0x0105 }
        r0 = r12.f22541d;	 Catch:{ SQLiteException -> 0x013e }
        r0 = r0.getWritableDatabase();	 Catch:{ SQLiteException -> 0x013e }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x013e }
    L_0x0097:
        monitor-exit(r12);
        return;
    L_0x0099:
        r3 = "send_count";
        r4 = r0.f22382d;	 Catch:{ Throwable -> 0x0088 }
        r4 = r4 + 1;
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Throwable -> 0x0088 }
        r1.put(r3, r4);	 Catch:{ Throwable -> 0x0088 }
        r3 = f22536e;	 Catch:{ Throwable -> 0x0088 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0088 }
        r4.<init>();	 Catch:{ Throwable -> 0x0088 }
        r5 = "Update event:";
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x0088 }
        r6 = r0.f22379a;	 Catch:{ Throwable -> 0x0088 }
        r4 = r4.append(r6);	 Catch:{ Throwable -> 0x0088 }
        r5 = " for content:";
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x0088 }
        r4 = r4.append(r1);	 Catch:{ Throwable -> 0x0088 }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x0088 }
        r3.m29407b(r4);	 Catch:{ Throwable -> 0x0088 }
        r3 = r12.f22541d;	 Catch:{ Throwable -> 0x0088 }
        r3 = r3.getWritableDatabase();	 Catch:{ Throwable -> 0x0088 }
        r4 = "events";
        r5 = "event_id=?";
        r6 = 1;
        r6 = new java.lang.String[r6];	 Catch:{ Throwable -> 0x0088 }
        r7 = 0;
        r8 = r0.f22379a;	 Catch:{ Throwable -> 0x0088 }
        r0 = java.lang.Long.toString(r8);	 Catch:{ Throwable -> 0x0088 }
        r6[r7] = r0;	 Catch:{ Throwable -> 0x0088 }
        r0 = r3.update(r4, r1, r5, r6);	 Catch:{ Throwable -> 0x0088 }
        if (r0 > 0) goto L_0x0051;
    L_0x00e7:
        r3 = f22536e;	 Catch:{ Throwable -> 0x0088 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0088 }
        r4.<init>();	 Catch:{ Throwable -> 0x0088 }
        r5 = "Failed to update db, error code:";
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x0088 }
        r0 = java.lang.Integer.toString(r0);	 Catch:{ Throwable -> 0x0088 }
        r0 = r4.append(r0);	 Catch:{ Throwable -> 0x0088 }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x0088 }
        r3.m29411f(r0);	 Catch:{ Throwable -> 0x0088 }
        goto L_0x0051;
    L_0x0105:
        r0 = move-exception;
        r1 = r12.f22541d;	 Catch:{ SQLiteException -> 0x0146 }
        r1 = r1.getWritableDatabase();	 Catch:{ SQLiteException -> 0x0146 }
        r1.endTransaction();	 Catch:{ SQLiteException -> 0x0146 }
    L_0x010f:
        throw r0;	 Catch:{ all -> 0x0110 }
    L_0x0110:
        r0 = move-exception;
        monitor-exit(r12);
        throw r0;
    L_0x0113:
        r0 = r12.f22541d;	 Catch:{ Throwable -> 0x0088 }
        r0 = r0.getWritableDatabase();	 Catch:{ Throwable -> 0x0088 }
        r0.setTransactionSuccessful();	 Catch:{ Throwable -> 0x0088 }
        r0 = r12.f22541d;	 Catch:{ Throwable -> 0x0088 }
        r0 = r0.getReadableDatabase();	 Catch:{ Throwable -> 0x0088 }
        r1 = "events";
        r0 = android.database.DatabaseUtils.queryNumEntries(r0, r1);	 Catch:{ Throwable -> 0x0088 }
        r0 = (int) r0;	 Catch:{ Throwable -> 0x0088 }
        r12.f22539b = r0;	 Catch:{ Throwable -> 0x0088 }
        r0 = r12.f22541d;	 Catch:{ SQLiteException -> 0x0136 }
        r0 = r0.getWritableDatabase();	 Catch:{ SQLiteException -> 0x0136 }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x0136 }
        goto L_0x0097;
    L_0x0136:
        r0 = move-exception;
        r1 = f22536e;	 Catch:{ all -> 0x0110 }
        r1.m29406b(r0);	 Catch:{ all -> 0x0110 }
        goto L_0x0097;
    L_0x013e:
        r0 = move-exception;
        r1 = f22536e;	 Catch:{ all -> 0x0110 }
        r1.m29406b(r0);	 Catch:{ all -> 0x0110 }
        goto L_0x0097;
    L_0x0146:
        r1 = move-exception;
        r2 = f22536e;	 Catch:{ all -> 0x0110 }
        r2.m29406b(r1);	 Catch:{ all -> 0x0110 }
        goto L_0x010f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.u.b(java.util.List, int):void");
    }

    private void m29608c(List<ae> list, int i) {
        Object th;
        Cursor cursor;
        Throwable th2;
        Cursor cursor2 = null;
        try {
            Cursor query = this.f22541d.getReadableDatabase().query("events", null, "status=?", new String[]{Integer.toString(1)}, null, null, "event_id", Integer.toString(i));
            while (query.moveToNext()) {
                try {
                    list.add(new ae(query.getLong(0), C6463m.m29457d(query.getString(1)), query.getInt(2), query.getInt(3)));
                } catch (Throwable th3) {
                    th2 = th3;
                    cursor2 = query;
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Throwable th4) {
            th2 = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th2;
        }
    }

    private void m29610e() {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", Integer.valueOf(1));
            this.f22541d.getWritableDatabase().update("events", contentValues, "status=?", new String[]{Long.toString(2)});
            this.f22539b = (int) DatabaseUtils.queryNumEntries(this.f22541d.getReadableDatabase(), "events");
            f22536e.m29407b("Total " + this.f22539b + " unsent events.");
        } catch (Throwable th) {
            f22536e.m29411f(th);
        }
    }

    private void m29611f() {
        Object th;
        Throwable th2;
        Cursor query;
        try {
            query = this.f22541d.getReadableDatabase().query("keyvalues", null, null, null, null, null, null);
            while (query.moveToNext()) {
                try {
                    this.f22542g.put(query.getString(0), query.getString(1));
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Throwable th4) {
            th2 = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th2;
        }
    }

    public int m29612a() {
        return this.f22539b;
    }

    void m29613a(int i) {
        this.f22538a.post(new ac(this, i));
    }

    void m29614a(C6443b c6443b, C6450j c6450j) {
        if (C6470c.m29515b()) {
            try {
                if (Thread.currentThread().getId() == this.f22538a.getLooper().getThread().getId()) {
                    m29604b(c6443b, c6450j);
                } else {
                    this.f22538a.post(new C6491y(this, c6443b, c6450j));
                }
            } catch (Throwable th) {
                f22536e.m29411f(th);
            }
        }
    }

    void m29615a(C6476i c6476i) {
        if (c6476i != null) {
            this.f22538a.post(new C6492z(this, c6476i));
        }
    }

    void m29616a(List<ae> list) {
        try {
            if (Thread.currentThread().getId() == this.f22538a.getLooper().getThread().getId()) {
                m29606b((List) list);
            } else {
                this.f22538a.post(new C6490x(this, list));
            }
        } catch (Exception e) {
            f22536e.m29406b(e);
        }
    }

    void m29617a(List<ae> list, int i) {
        try {
            if (Thread.currentThread().getId() == this.f22538a.getLooper().getThread().getId()) {
                m29607b((List) list, i);
            } else {
                this.f22538a.post(new C6489w(this, list, i));
            }
        } catch (Throwable th) {
            f22536e.m29411f(th);
        }
    }

    public synchronized C6449a m29618b(Context context) {
        C6449a c6449a;
        Cursor query;
        Object obj;
        Cursor cursor;
        Throwable th;
        if (this.f22540c != null) {
            c6449a = this.f22540c;
        } else {
            try {
                query = this.f22541d.getReadableDatabase().query("user", null, null, null, null, null, null, null);
                obj = null;
                try {
                    String d;
                    String str;
                    String l;
                    String str2 = "";
                    if (query.moveToNext()) {
                        Object obj2;
                        d = C6463m.m29457d(query.getString(0));
                        int i = query.getInt(1);
                        str2 = query.getString(2);
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        int i2 = (i == 1 || C6463m.m29442a(query.getLong(3) * 1000).equals(C6463m.m29442a(1000 * currentTimeMillis))) ? i : 1;
                        int i3 = !str2.equals(C6463m.m29476r(context)) ? i2 | 2 : i2;
                        String[] split = d.split(",");
                        if (split == null || split.length <= 0) {
                            str2 = C6463m.m29450b(context);
                            d = str2;
                            str = str2;
                            int i4 = 1;
                        } else {
                            str2 = split[0];
                            if (str2 == null || str2.length() < 11) {
                                l = C6463m.m29470l(context);
                                if (l == null || l.length() <= 10) {
                                    l = str2;
                                    obj2 = null;
                                } else {
                                    obj2 = 1;
                                }
                                str = d;
                                d = l;
                            } else {
                                String str3 = str2;
                                obj2 = null;
                                str = d;
                                d = str3;
                            }
                        }
                        if (split == null || split.length < 2) {
                            l = C6463m.m29453c(context);
                            if (l != null && l.length() > 0) {
                                str = d + "," + l;
                                obj2 = 1;
                            }
                        } else {
                            l = split[1];
                            str = d + "," + l;
                        }
                        this.f22540c = new C6449a(d, l, i3);
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("uid", C6463m.m29454c(str));
                        contentValues.put("user_type", Integer.valueOf(i3));
                        contentValues.put("app_ver", C6463m.m29476r(context));
                        contentValues.put("ts", Long.valueOf(currentTimeMillis));
                        if (obj2 != null) {
                            this.f22541d.getWritableDatabase().update("user", contentValues, "uid=?", new String[]{r10});
                        }
                        if (i3 != i) {
                            this.f22541d.getWritableDatabase().replace("user", null, contentValues);
                            obj = 1;
                        } else {
                            i2 = 1;
                        }
                    }
                    if (obj == null) {
                        str2 = C6463m.m29450b(context);
                        str = C6463m.m29453c(context);
                        l = (str == null || str.length() <= 0) ? str2 : str2 + "," + str;
                        long currentTimeMillis2 = System.currentTimeMillis() / 1000;
                        d = C6463m.m29476r(context);
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("uid", C6463m.m29454c(l));
                        contentValues2.put("user_type", Integer.valueOf(0));
                        contentValues2.put("app_ver", d);
                        contentValues2.put("ts", Long.valueOf(currentTimeMillis2));
                        this.f22541d.getWritableDatabase().insert("user", null, contentValues2);
                        this.f22540c = new C6449a(str2, str, 0);
                    }
                    if (query != null) {
                        query.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                query = null;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
            c6449a = this.f22540c;
        }
        return c6449a;
    }

    void m29619c() {
        this.f22538a.post(new aa(this));
    }
}
