package com.amap.api.mapcore.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import java.util.List;
import java.util.Map;

/* compiled from: DBOperation */
public class co {
    private cs f11614a;
    private SQLiteDatabase f11615b;
    private cn f11616c;

    public co(Context context, cn cnVar) {
        try {
            this.f11614a = new cs(context, cnVar.mo4036b(), null, cnVar.mo4037c(), cnVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f11616c = cnVar;
    }

    private SQLiteDatabase m15915a(boolean z) {
        try {
            this.f11615b = this.f11614a.getReadableDatabase();
        } catch (Throwable th) {
            if (z) {
                th.printStackTrace();
            } else {
                cd.m15825a(th, "DBOperation", "getReadAbleDataBase");
            }
        }
        return this.f11615b;
    }

    private SQLiteDatabase m15918b(boolean z) {
        try {
            this.f11615b = this.f11614a.getWritableDatabase();
        } catch (Throwable th) {
            cd.m15825a(th, "DBOperation", "getReadAbleDataBase");
        }
        return this.f11615b;
    }

    public static String m15916a(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (String str : map.keySet()) {
            Object obj2;
            if (obj != null) {
                stringBuilder.append(str).append(" = '").append((String) map.get(str)).append("'");
                obj2 = null;
            } else {
                stringBuilder.append(" and ").append(str).append(" = '").append((String) map.get(str)).append("'");
                obj2 = obj;
            }
            obj = obj2;
        }
        return stringBuilder.toString();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> void m15922a(java.lang.String r5, com.amap.api.mapcore.util.cp<T> r6) {
        /*
        r4 = this;
        r1 = r4.f11616c;
        monitor-enter(r1);
        r0 = r6.mo4033b();	 Catch:{ all -> 0x0026 }
        if (r0 == 0) goto L_0x000b;
    L_0x0009:
        if (r5 != 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x0026 }
    L_0x000c:
        return;
    L_0x000d:
        r0 = r4.f11615b;	 Catch:{ all -> 0x0026 }
        if (r0 == 0) goto L_0x0019;
    L_0x0011:
        r0 = r4.f11615b;	 Catch:{ all -> 0x0026 }
        r0 = r0.isReadOnly();	 Catch:{ all -> 0x0026 }
        if (r0 == 0) goto L_0x0020;
    L_0x0019:
        r0 = 0;
        r0 = r4.m15918b(r0);	 Catch:{ all -> 0x0026 }
        r4.f11615b = r0;	 Catch:{ all -> 0x0026 }
    L_0x0020:
        r0 = r4.f11615b;	 Catch:{ all -> 0x0026 }
        if (r0 != 0) goto L_0x0029;
    L_0x0024:
        monitor-exit(r1);	 Catch:{ all -> 0x0026 }
        goto L_0x000c;
    L_0x0026:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0026 }
        throw r0;
    L_0x0029:
        r0 = r4.f11615b;	 Catch:{ Throwable -> 0x0041 }
        r2 = r6.mo4033b();	 Catch:{ Throwable -> 0x0041 }
        r3 = 0;
        r0.delete(r2, r5, r3);	 Catch:{ Throwable -> 0x0041 }
        r0 = r4.f11615b;	 Catch:{ all -> 0x0026 }
        if (r0 == 0) goto L_0x003f;
    L_0x0037:
        r0 = r4.f11615b;	 Catch:{ all -> 0x0026 }
        r0.close();	 Catch:{ all -> 0x0026 }
        r0 = 0;
        r4.f11615b = r0;	 Catch:{ all -> 0x0026 }
    L_0x003f:
        monitor-exit(r1);	 Catch:{ all -> 0x0026 }
        goto L_0x000c;
    L_0x0041:
        r0 = move-exception;
        r2 = "DataBase";
        r3 = "deleteData";
        com.amap.api.mapcore.util.cd.m15825a(r0, r2, r3);	 Catch:{ all -> 0x0056 }
        r0 = r4.f11615b;	 Catch:{ all -> 0x0026 }
        if (r0 == 0) goto L_0x003f;
    L_0x004d:
        r0 = r4.f11615b;	 Catch:{ all -> 0x0026 }
        r0.close();	 Catch:{ all -> 0x0026 }
        r0 = 0;
        r4.f11615b = r0;	 Catch:{ all -> 0x0026 }
        goto L_0x003f;
    L_0x0056:
        r0 = move-exception;
        r2 = r4.f11615b;	 Catch:{ all -> 0x0026 }
        if (r2 == 0) goto L_0x0063;
    L_0x005b:
        r2 = r4.f11615b;	 Catch:{ all -> 0x0026 }
        r2.close();	 Catch:{ all -> 0x0026 }
        r2 = 0;
        r4.f11615b = r2;	 Catch:{ all -> 0x0026 }
    L_0x0063:
        throw r0;	 Catch:{ all -> 0x0026 }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.co.a(java.lang.String, com.amap.api.mapcore.util.cp):void");
    }

    public <T> void m15926b(String str, cp<T> cpVar) {
        m15923a(str, cpVar, false);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> void m15923a(java.lang.String r6, com.amap.api.mapcore.util.cp<T> r7, boolean r8) {
        /*
        r5 = this;
        r1 = r5.f11616c;
        monitor-enter(r1);
        if (r7 == 0) goto L_0x000d;
    L_0x0005:
        if (r6 == 0) goto L_0x000d;
    L_0x0007:
        r0 = r7.mo4033b();	 Catch:{ all -> 0x0017 }
        if (r0 != 0) goto L_0x000f;
    L_0x000d:
        monitor-exit(r1);	 Catch:{ all -> 0x0017 }
    L_0x000e:
        return;
    L_0x000f:
        r0 = r7.mo4030a();	 Catch:{ all -> 0x0017 }
        if (r0 != 0) goto L_0x001a;
    L_0x0015:
        monitor-exit(r1);	 Catch:{ all -> 0x0017 }
        goto L_0x000e;
    L_0x0017:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0017 }
        throw r0;
    L_0x001a:
        r2 = r5.f11615b;	 Catch:{ all -> 0x0017 }
        if (r2 == 0) goto L_0x0026;
    L_0x001e:
        r2 = r5.f11615b;	 Catch:{ all -> 0x0017 }
        r2 = r2.isReadOnly();	 Catch:{ all -> 0x0017 }
        if (r2 == 0) goto L_0x002c;
    L_0x0026:
        r2 = r5.m15918b(r8);	 Catch:{ all -> 0x0017 }
        r5.f11615b = r2;	 Catch:{ all -> 0x0017 }
    L_0x002c:
        r2 = r5.f11615b;	 Catch:{ all -> 0x0017 }
        if (r2 != 0) goto L_0x0032;
    L_0x0030:
        monitor-exit(r1);	 Catch:{ all -> 0x0017 }
        goto L_0x000e;
    L_0x0032:
        r2 = r5.f11615b;	 Catch:{ Throwable -> 0x004a }
        r3 = r7.mo4033b();	 Catch:{ Throwable -> 0x004a }
        r4 = 0;
        r2.update(r3, r0, r6, r4);	 Catch:{ Throwable -> 0x004a }
        r0 = r5.f11615b;	 Catch:{ all -> 0x0017 }
        if (r0 == 0) goto L_0x0048;
    L_0x0040:
        r0 = r5.f11615b;	 Catch:{ all -> 0x0017 }
        r0.close();	 Catch:{ all -> 0x0017 }
        r0 = 0;
        r5.f11615b = r0;	 Catch:{ all -> 0x0017 }
    L_0x0048:
        monitor-exit(r1);	 Catch:{ all -> 0x0017 }
        goto L_0x000e;
    L_0x004a:
        r0 = move-exception;
        if (r8 != 0) goto L_0x0062;
    L_0x004d:
        r2 = "DataBase";
        r3 = "updateData";
        com.amap.api.mapcore.util.cd.m15825a(r0, r2, r3);	 Catch:{ all -> 0x0066 }
    L_0x0055:
        r0 = r5.f11615b;	 Catch:{ all -> 0x0017 }
        if (r0 == 0) goto L_0x0048;
    L_0x0059:
        r0 = r5.f11615b;	 Catch:{ all -> 0x0017 }
        r0.close();	 Catch:{ all -> 0x0017 }
        r0 = 0;
        r5.f11615b = r0;	 Catch:{ all -> 0x0017 }
        goto L_0x0048;
    L_0x0062:
        r0.printStackTrace();	 Catch:{ all -> 0x0066 }
        goto L_0x0055;
    L_0x0066:
        r0 = move-exception;
        r2 = r5.f11615b;	 Catch:{ all -> 0x0017 }
        if (r2 == 0) goto L_0x0073;
    L_0x006b:
        r2 = r5.f11615b;	 Catch:{ all -> 0x0017 }
        r2.close();	 Catch:{ all -> 0x0017 }
        r2 = 0;
        r5.f11615b = r2;	 Catch:{ all -> 0x0017 }
    L_0x0073:
        throw r0;	 Catch:{ all -> 0x0017 }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.co.a(java.lang.String, com.amap.api.mapcore.util.cp, boolean):void");
    }

    public <T> void m15920a(cp<T> cpVar, String str) {
        synchronized (this.f11616c) {
            List c = m15927c(str, cpVar);
            if (c == null || c.size() == 0) {
                m15919a((cp) cpVar);
            } else {
                m15926b(str, cpVar);
            }
        }
    }

    public <T> void m15919a(cp<T> cpVar) {
        m15921a((cp) cpVar, false);
    }

    public <T> void m15921a(cp<T> cpVar, boolean z) {
        synchronized (this.f11616c) {
            if (this.f11615b == null || this.f11615b.isReadOnly()) {
                this.f11615b = m15918b(z);
            }
            if (this.f11615b == null) {
                return;
            }
            try {
                m15917a(this.f11615b, (cp) cpVar);
                if (this.f11615b != null) {
                    this.f11615b.close();
                    this.f11615b = null;
                }
            } catch (Throwable th) {
                if (this.f11615b != null) {
                    this.f11615b.close();
                    this.f11615b = null;
                }
            }
        }
    }

    private <T> void m15917a(SQLiteDatabase sQLiteDatabase, cp<T> cpVar) {
        if (cpVar != null && sQLiteDatabase != null) {
            ContentValues a = cpVar.mo4030a();
            if (a != null && cpVar.mo4033b() != null) {
                sQLiteDatabase.insert(cpVar.mo4033b(), null, a);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> void m15924a(java.util.List<com.amap.api.mapcore.util.cp<T>> r5) {
        /*
        r4 = this;
        r1 = r4.f11616c;
        monitor-enter(r1);
        if (r5 == 0) goto L_0x000b;
    L_0x0005:
        r0 = r5.size();	 Catch:{ all -> 0x0026 }
        if (r0 != 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x0026 }
    L_0x000c:
        return;
    L_0x000d:
        r0 = r4.f11615b;	 Catch:{ all -> 0x0026 }
        if (r0 == 0) goto L_0x0019;
    L_0x0011:
        r0 = r4.f11615b;	 Catch:{ all -> 0x0026 }
        r0 = r0.isReadOnly();	 Catch:{ all -> 0x0026 }
        if (r0 == 0) goto L_0x0020;
    L_0x0019:
        r0 = 0;
        r0 = r4.m15918b(r0);	 Catch:{ all -> 0x0026 }
        r4.f11615b = r0;	 Catch:{ all -> 0x0026 }
    L_0x0020:
        r0 = r4.f11615b;	 Catch:{ all -> 0x0026 }
        if (r0 != 0) goto L_0x0029;
    L_0x0024:
        monitor-exit(r1);	 Catch:{ all -> 0x0026 }
        goto L_0x000c;
    L_0x0026:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0026 }
        throw r0;
    L_0x0029:
        r0 = r4.f11615b;	 Catch:{ Throwable -> 0x0044 }
        r0.beginTransaction();	 Catch:{ Throwable -> 0x0044 }
        r2 = r5.iterator();	 Catch:{ Throwable -> 0x0044 }
    L_0x0032:
        r0 = r2.hasNext();	 Catch:{ Throwable -> 0x0044 }
        if (r0 == 0) goto L_0x005b;
    L_0x0038:
        r0 = r2.next();	 Catch:{ Throwable -> 0x0044 }
        r0 = (com.amap.api.mapcore.util.cp) r0;	 Catch:{ Throwable -> 0x0044 }
        r3 = r4.f11615b;	 Catch:{ Throwable -> 0x0044 }
        r4.m15917a(r3, r0);	 Catch:{ Throwable -> 0x0044 }
        goto L_0x0032;
    L_0x0044:
        r0 = move-exception;
        r2 = "DataBase";
        r3 = "insertListData";
        com.amap.api.mapcore.util.cd.m15825a(r0, r2, r3);	 Catch:{ all -> 0x006e }
        r0 = r4.f11615b;	 Catch:{ all -> 0x0026 }
        r0.endTransaction();	 Catch:{ all -> 0x0026 }
        r0 = r4.f11615b;	 Catch:{ all -> 0x0026 }
        r0.close();	 Catch:{ all -> 0x0026 }
        r0 = 0;
        r4.f11615b = r0;	 Catch:{ all -> 0x0026 }
    L_0x0059:
        monitor-exit(r1);	 Catch:{ all -> 0x0026 }
        goto L_0x000c;
    L_0x005b:
        r0 = r4.f11615b;	 Catch:{ Throwable -> 0x0044 }
        r0.setTransactionSuccessful();	 Catch:{ Throwable -> 0x0044 }
        r0 = r4.f11615b;	 Catch:{ all -> 0x0026 }
        r0.endTransaction();	 Catch:{ all -> 0x0026 }
        r0 = r4.f11615b;	 Catch:{ all -> 0x0026 }
        r0.close();	 Catch:{ all -> 0x0026 }
        r0 = 0;
        r4.f11615b = r0;	 Catch:{ all -> 0x0026 }
        goto L_0x0059;
    L_0x006e:
        r0 = move-exception;
        r2 = r4.f11615b;	 Catch:{ all -> 0x0026 }
        r2.endTransaction();	 Catch:{ all -> 0x0026 }
        r2 = r4.f11615b;	 Catch:{ all -> 0x0026 }
        r2.close();	 Catch:{ all -> 0x0026 }
        r2 = 0;
        r4.f11615b = r2;	 Catch:{ all -> 0x0026 }
        throw r0;	 Catch:{ all -> 0x0026 }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.co.a(java.util.List):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> java.util.List<T> m15925b(java.lang.String r12, com.amap.api.mapcore.util.cp<T> r13, boolean r14) {
        /*
        r11 = this;
        r9 = 0;
        r10 = r11.f11616c;
        monitor-enter(r10);
        r8 = new java.util.ArrayList;	 Catch:{ all -> 0x005c }
        r8.<init>();	 Catch:{ all -> 0x005c }
        r0 = r11.f11615b;	 Catch:{ all -> 0x005c }
        if (r0 != 0) goto L_0x0013;
    L_0x000d:
        r0 = r11.m15915a(r14);	 Catch:{ all -> 0x005c }
        r11.f11615b = r0;	 Catch:{ all -> 0x005c }
    L_0x0013:
        r0 = r11.f11615b;	 Catch:{ all -> 0x005c }
        if (r0 == 0) goto L_0x001f;
    L_0x0017:
        r0 = r13.mo4033b();	 Catch:{ all -> 0x005c }
        if (r0 == 0) goto L_0x001f;
    L_0x001d:
        if (r12 != 0) goto L_0x0022;
    L_0x001f:
        monitor-exit(r10);	 Catch:{ all -> 0x005c }
        r0 = r8;
    L_0x0021:
        return r0;
    L_0x0022:
        r0 = r11.f11615b;	 Catch:{ Throwable -> 0x0108, all -> 0x00da }
        r1 = r13.mo4033b();	 Catch:{ Throwable -> 0x0108, all -> 0x00da }
        r2 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r3 = r12;
        r1 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x0108, all -> 0x00da }
        if (r1 != 0) goto L_0x006b;
    L_0x0034:
        r0 = r11.f11615b;	 Catch:{ Throwable -> 0x0079 }
        r0.close();	 Catch:{ Throwable -> 0x0079 }
        r0 = 0;
        r11.f11615b = r0;	 Catch:{ Throwable -> 0x0079 }
        if (r1 == 0) goto L_0x0041;
    L_0x003e:
        r1.close();	 Catch:{ Throwable -> 0x0050 }
    L_0x0041:
        r0 = r11.f11615b;	 Catch:{ Throwable -> 0x005f }
        if (r0 == 0) goto L_0x004d;
    L_0x0045:
        r0 = r11.f11615b;	 Catch:{ Throwable -> 0x005f }
        r0.close();	 Catch:{ Throwable -> 0x005f }
        r0 = 0;
        r11.f11615b = r0;	 Catch:{ Throwable -> 0x005f }
    L_0x004d:
        monitor-exit(r10);	 Catch:{ all -> 0x005c }
        r0 = r8;
        goto L_0x0021;
    L_0x0050:
        r0 = move-exception;
        if (r14 != 0) goto L_0x0041;
    L_0x0053:
        r1 = "DataBase";
        r2 = "searchListData";
        com.amap.api.mapcore.util.cd.m15825a(r0, r1, r2);	 Catch:{ all -> 0x005c }
        goto L_0x0041;
    L_0x005c:
        r0 = move-exception;
        monitor-exit(r10);	 Catch:{ all -> 0x005c }
        throw r0;
    L_0x005f:
        r0 = move-exception;
        if (r14 != 0) goto L_0x004d;
    L_0x0062:
        r1 = "DataBase";
        r2 = "searchListData";
        com.amap.api.mapcore.util.cd.m15825a(r0, r1, r2);	 Catch:{ all -> 0x005c }
        goto L_0x004d;
    L_0x006b:
        r0 = r1.moveToNext();	 Catch:{ Throwable -> 0x0079 }
        if (r0 == 0) goto L_0x0098;
    L_0x0071:
        r0 = r13.mo4032b(r1);	 Catch:{ Throwable -> 0x0079 }
        r8.add(r0);	 Catch:{ Throwable -> 0x0079 }
        goto L_0x006b;
    L_0x0079:
        r0 = move-exception;
    L_0x007a:
        if (r14 != 0) goto L_0x0084;
    L_0x007c:
        r2 = "DataBase";
        r3 = "searchListData";
        com.amap.api.mapcore.util.cd.m15825a(r0, r2, r3);	 Catch:{ all -> 0x0106 }
    L_0x0084:
        if (r1 == 0) goto L_0x0089;
    L_0x0086:
        r1.close();	 Catch:{ Throwable -> 0x00c2 }
    L_0x0089:
        r0 = r11.f11615b;	 Catch:{ Throwable -> 0x00ce }
        if (r0 == 0) goto L_0x0095;
    L_0x008d:
        r0 = r11.f11615b;	 Catch:{ Throwable -> 0x00ce }
        r0.close();	 Catch:{ Throwable -> 0x00ce }
        r0 = 0;
        r11.f11615b = r0;	 Catch:{ Throwable -> 0x00ce }
    L_0x0095:
        monitor-exit(r10);	 Catch:{ all -> 0x005c }
        r0 = r8;
        goto L_0x0021;
    L_0x0098:
        if (r1 == 0) goto L_0x009d;
    L_0x009a:
        r1.close();	 Catch:{ Throwable -> 0x00b6 }
    L_0x009d:
        r0 = r11.f11615b;	 Catch:{ Throwable -> 0x00aa }
        if (r0 == 0) goto L_0x0095;
    L_0x00a1:
        r0 = r11.f11615b;	 Catch:{ Throwable -> 0x00aa }
        r0.close();	 Catch:{ Throwable -> 0x00aa }
        r0 = 0;
        r11.f11615b = r0;	 Catch:{ Throwable -> 0x00aa }
        goto L_0x0095;
    L_0x00aa:
        r0 = move-exception;
        if (r14 != 0) goto L_0x0095;
    L_0x00ad:
        r1 = "DataBase";
        r2 = "searchListData";
        com.amap.api.mapcore.util.cd.m15825a(r0, r1, r2);	 Catch:{ all -> 0x005c }
        goto L_0x0095;
    L_0x00b6:
        r0 = move-exception;
        if (r14 != 0) goto L_0x009d;
    L_0x00b9:
        r1 = "DataBase";
        r2 = "searchListData";
        com.amap.api.mapcore.util.cd.m15825a(r0, r1, r2);	 Catch:{ all -> 0x005c }
        goto L_0x009d;
    L_0x00c2:
        r0 = move-exception;
        if (r14 != 0) goto L_0x0089;
    L_0x00c5:
        r1 = "DataBase";
        r2 = "searchListData";
        com.amap.api.mapcore.util.cd.m15825a(r0, r1, r2);	 Catch:{ all -> 0x005c }
        goto L_0x0089;
    L_0x00ce:
        r0 = move-exception;
        if (r14 != 0) goto L_0x0095;
    L_0x00d1:
        r1 = "DataBase";
        r2 = "searchListData";
        com.amap.api.mapcore.util.cd.m15825a(r0, r1, r2);	 Catch:{ all -> 0x005c }
        goto L_0x0095;
    L_0x00da:
        r0 = move-exception;
        r1 = r9;
    L_0x00dc:
        if (r1 == 0) goto L_0x00e1;
    L_0x00de:
        r1.close();	 Catch:{ Throwable -> 0x00ee }
    L_0x00e1:
        r1 = r11.f11615b;	 Catch:{ Throwable -> 0x00fa }
        if (r1 == 0) goto L_0x00ed;
    L_0x00e5:
        r1 = r11.f11615b;	 Catch:{ Throwable -> 0x00fa }
        r1.close();	 Catch:{ Throwable -> 0x00fa }
        r1 = 0;
        r11.f11615b = r1;	 Catch:{ Throwable -> 0x00fa }
    L_0x00ed:
        throw r0;	 Catch:{ all -> 0x005c }
    L_0x00ee:
        r1 = move-exception;
        if (r14 != 0) goto L_0x00e1;
    L_0x00f1:
        r2 = "DataBase";
        r3 = "searchListData";
        com.amap.api.mapcore.util.cd.m15825a(r1, r2, r3);	 Catch:{ all -> 0x005c }
        goto L_0x00e1;
    L_0x00fa:
        r1 = move-exception;
        if (r14 != 0) goto L_0x00ed;
    L_0x00fd:
        r2 = "DataBase";
        r3 = "searchListData";
        com.amap.api.mapcore.util.cd.m15825a(r1, r2, r3);	 Catch:{ all -> 0x005c }
        goto L_0x00ed;
    L_0x0106:
        r0 = move-exception;
        goto L_0x00dc;
    L_0x0108:
        r0 = move-exception;
        r1 = r9;
        goto L_0x007a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.co.b(java.lang.String, com.amap.api.mapcore.util.cp, boolean):java.util.List<T>");
    }

    public <T> List<T> m15927c(String str, cp<T> cpVar) {
        return m15925b(str, cpVar, false);
    }
}
