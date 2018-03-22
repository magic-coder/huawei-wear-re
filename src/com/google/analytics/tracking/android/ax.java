package com.google.analytics.tracking.android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.Command;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.spi.LocationInfo;

/* compiled from: PersistentAnalyticsStore */
class ax implements f {
    private static final String f192a = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", new Object[]{"hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id"});
    private final az f193b;
    private volatile o f194c;
    private final g f195d;
    private final Context f196e;
    private final String f197f;
    private long f198g;
    private l f199h;

    ax(g gVar, Context context) {
        this(gVar, context, "google_analytics_v2.db");
    }

    ax(g gVar, Context context, String str) {
        this.f196e = context.getApplicationContext();
        this.f197f = str;
        this.f195d = gVar;
        this.f199h = new ay(this);
        this.f193b = new az(this, this.f196e, this.f197f);
        this.f194c = new bf(new DefaultHttpClient(), this.f196e);
        this.f198g = 0;
    }

    public void m235a(long j) {
        boolean z = true;
        SQLiteDatabase a = m224a("Error opening database for clearHits");
        if (a != null) {
            if (j == 0) {
                a.delete("hits2", null, null);
            } else {
                a.delete("hits2", "hit_app_id = ?", new String[]{Long.valueOf(j).toString()});
            }
            g gVar = this.f195d;
            if (m242d() != 0) {
                z = false;
            }
            gVar.a(z);
        }
    }

    public void m237a(Map<String, String> map, long j, String str, Collection<Command> collection) {
        m241c();
        m232f();
        m228a(map, collection);
        m227a(map, j, str);
    }

    private void m228a(Map<String, String> map, Collection<Command> collection) {
        String substring = "&_v".substring(1);
        if (collection != null) {
            for (Command command : collection) {
                if (Command.APPEND_VERSION.equals(command.getId())) {
                    map.put(substring, command.getValue());
                    return;
                }
            }
        }
    }

    private void m232f() {
        int d = (m242d() - 2000) + 1;
        if (d > 0) {
            List a = m233a(d);
            ar.c("Store full, deleting " + a.size() + " hits to make room.");
            m238a((String[]) a.toArray(new String[0]));
        }
    }

    private void m227a(Map<String, String> map, long j, String str) {
        SQLiteDatabase a = m224a("Error opening database for putHit");
        if (a != null) {
            long parseLong;
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_string", m226a((Map) map));
            contentValues.put("hit_time", Long.valueOf(j));
            if (map.containsKey("AppUID")) {
                try {
                    parseLong = Long.parseLong((String) map.get("AppUID"));
                } catch (NumberFormatException e) {
                    parseLong = 0;
                }
            } else {
                parseLong = 0;
            }
            contentValues.put("hit_app_id", Long.valueOf(parseLong));
            if (str == null) {
                str = "http://www.google-analytics.com/collect";
            }
            if (str.length() == 0) {
                ar.d("Empty path: not sending hit");
                return;
            }
            contentValues.put("hit_url", str);
            try {
                a.insert("hits2", null, contentValues);
                this.f195d.a(false);
            } catch (SQLiteException e2) {
                ar.d("Error storing hit");
            }
        }
    }

    static String m226a(Map<String, String> map) {
        Iterable arrayList = new ArrayList(map.size());
        for (Entry entry : map.entrySet()) {
            arrayList.add(aq.a((String) entry.getKey()) + "=" + aq.a((String) entry.getValue()));
        }
        return TextUtils.join(SNBConstant.FILTER, arrayList);
    }

    List<String> m233a(int i) {
        Cursor query;
        SQLiteException e;
        Throwable th;
        List<String> arrayList = new ArrayList();
        if (i <= 0) {
            ar.d("Invalid maxHits specified. Skipping");
            return arrayList;
        }
        SQLiteDatabase a = m224a("Error opening database for peekHitIds.");
        if (a == null) {
            return arrayList;
        }
        try {
            query = a.query("hits2", new String[]{"hit_id"}, null, null, null, null, String.format("%s ASC", new Object[]{"hit_id"}), Integer.toString(i));
            try {
                if (query.moveToFirst()) {
                    do {
                        arrayList.add(String.valueOf(query.getLong(0)));
                    } while (query.moveToNext());
                }
                if (query != null) {
                    query.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    ar.d("Error in peekHits fetching hitIds: " + e.getMessage());
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            ar.d("Error in peekHits fetching hitIds: " + e.getMessage());
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.google.analytics.tracking.android.ap> m240b(int r17) {
        /*
        r16 = this;
        r11 = new java.util.ArrayList;
        r11.<init>();
        r2 = "Error opening database for peekHits";
        r0 = r16;
        r2 = r0.m224a(r2);
        if (r2 != 0) goto L_0x0011;
    L_0x000f:
        r2 = r11;
    L_0x0010:
        return r2;
    L_0x0011:
        r12 = 0;
        r3 = "hits2";
        r4 = 2;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x00d4, all -> 0x00f9 }
        r5 = 0;
        r6 = "hit_id";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x00d4, all -> 0x00f9 }
        r5 = 1;
        r6 = "hit_time";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x00d4, all -> 0x00f9 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = "%s ASC";
        r10 = 1;
        r10 = new java.lang.Object[r10];	 Catch:{ SQLiteException -> 0x00d4, all -> 0x00f9 }
        r13 = 0;
        r14 = "hit_id";
        r10[r13] = r14;	 Catch:{ SQLiteException -> 0x00d4, all -> 0x00f9 }
        r9 = java.lang.String.format(r9, r10);	 Catch:{ SQLiteException -> 0x00d4, all -> 0x00f9 }
        r10 = java.lang.Integer.toString(r17);	 Catch:{ SQLiteException -> 0x00d4, all -> 0x00f9 }
        r13 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ SQLiteException -> 0x00d4, all -> 0x00f9 }
        r12 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x017b, all -> 0x0175 }
        r12.<init>();	 Catch:{ SQLiteException -> 0x017b, all -> 0x0175 }
        r3 = r13.moveToFirst();	 Catch:{ SQLiteException -> 0x0181, all -> 0x0175 }
        if (r3 == 0) goto L_0x005f;
    L_0x0046:
        r4 = new com.google.analytics.tracking.android.ap;	 Catch:{ SQLiteException -> 0x0181, all -> 0x0175 }
        r5 = 0;
        r3 = 0;
        r6 = r13.getLong(r3);	 Catch:{ SQLiteException -> 0x0181, all -> 0x0175 }
        r3 = 1;
        r8 = r13.getLong(r3);	 Catch:{ SQLiteException -> 0x0181, all -> 0x0175 }
        r4.<init>(r5, r6, r8);	 Catch:{ SQLiteException -> 0x0181, all -> 0x0175 }
        r12.add(r4);	 Catch:{ SQLiteException -> 0x0181, all -> 0x0175 }
        r3 = r13.moveToNext();	 Catch:{ SQLiteException -> 0x0181, all -> 0x0175 }
        if (r3 != 0) goto L_0x0046;
    L_0x005f:
        if (r13 == 0) goto L_0x0064;
    L_0x0061:
        r13.close();
    L_0x0064:
        r11 = 0;
        r3 = "hits2";
        r4 = 3;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x0173 }
        r5 = 0;
        r6 = "hit_id";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0173 }
        r5 = 1;
        r6 = "hit_string";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0173 }
        r5 = 2;
        r6 = "hit_url";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0173 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = "%s ASC";
        r10 = 1;
        r10 = new java.lang.Object[r10];	 Catch:{ SQLiteException -> 0x0173 }
        r14 = 0;
        r15 = "hit_id";
        r10[r14] = r15;	 Catch:{ SQLiteException -> 0x0173 }
        r9 = java.lang.String.format(r9, r10);	 Catch:{ SQLiteException -> 0x0173 }
        r10 = java.lang.Integer.toString(r17);	 Catch:{ SQLiteException -> 0x0173 }
        r3 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ SQLiteException -> 0x0173 }
        r2 = r3.moveToFirst();	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        if (r2 == 0) goto L_0x00cc;
    L_0x0099:
        r4 = r11;
    L_0x009a:
        r0 = r3;
        r0 = (android.database.sqlite.SQLiteCursor) r0;	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        r2 = r0;
        r2 = r2.getWindow();	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        r2 = r2.getNumRows();	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        if (r2 <= 0) goto L_0x0100;
    L_0x00a8:
        r2 = r12.get(r4);	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        r2 = (com.google.analytics.tracking.android.ap) r2;	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        r5 = 1;
        r5 = r3.getString(r5);	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        r2.a(r5);	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        r2 = r12.get(r4);	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        r2 = (com.google.analytics.tracking.android.ap) r2;	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        r5 = 2;
        r5 = r3.getString(r5);	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        r2.b(r5);	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
    L_0x00c4:
        r2 = r4 + 1;
        r4 = r3.moveToNext();	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        if (r4 != 0) goto L_0x0187;
    L_0x00cc:
        if (r3 == 0) goto L_0x00d1;
    L_0x00ce:
        r3.close();
    L_0x00d1:
        r2 = r12;
        goto L_0x0010;
    L_0x00d4:
        r2 = move-exception;
        r3 = r2;
        r4 = r12;
        r2 = r11;
    L_0x00d8:
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0178 }
        r5.<init>();	 Catch:{ all -> 0x0178 }
        r6 = "Error in peekHits fetching hitIds: ";
        r5 = r5.append(r6);	 Catch:{ all -> 0x0178 }
        r3 = r3.getMessage();	 Catch:{ all -> 0x0178 }
        r3 = r5.append(r3);	 Catch:{ all -> 0x0178 }
        r3 = r3.toString();	 Catch:{ all -> 0x0178 }
        com.google.analytics.tracking.android.ar.d(r3);	 Catch:{ all -> 0x0178 }
        if (r4 == 0) goto L_0x0010;
    L_0x00f4:
        r4.close();
        goto L_0x0010;
    L_0x00f9:
        r2 = move-exception;
    L_0x00fa:
        if (r12 == 0) goto L_0x00ff;
    L_0x00fc:
        r12.close();
    L_0x00ff:
        throw r2;
    L_0x0100:
        r5 = "HitString for hitId %d too large.  Hit will be deleted.";
        r2 = 1;
        r6 = new java.lang.Object[r2];	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        r7 = 0;
        r2 = r12.get(r4);	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        r2 = (com.google.analytics.tracking.android.ap) r2;	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        r8 = r2.b();	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        r2 = java.lang.Long.valueOf(r8);	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        r6[r7] = r2;	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        r2 = java.lang.String.format(r5, r6);	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        com.google.analytics.tracking.android.ar.d(r2);	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        goto L_0x00c4;
    L_0x011e:
        r2 = move-exception;
        r13 = r3;
    L_0x0120:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0169 }
        r3.<init>();	 Catch:{ all -> 0x0169 }
        r4 = "Error in peekHits fetching hitString: ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x0169 }
        r2 = r2.getMessage();	 Catch:{ all -> 0x0169 }
        r2 = r3.append(r2);	 Catch:{ all -> 0x0169 }
        r2 = r2.toString();	 Catch:{ all -> 0x0169 }
        com.google.analytics.tracking.android.ar.d(r2);	 Catch:{ all -> 0x0169 }
        r3 = new java.util.ArrayList;	 Catch:{ all -> 0x0169 }
        r3.<init>();	 Catch:{ all -> 0x0169 }
        r4 = 0;
        r5 = r12.iterator();	 Catch:{ all -> 0x0169 }
    L_0x0144:
        r2 = r5.hasNext();	 Catch:{ all -> 0x0169 }
        if (r2 == 0) goto L_0x015c;
    L_0x014a:
        r2 = r5.next();	 Catch:{ all -> 0x0169 }
        r2 = (com.google.analytics.tracking.android.ap) r2;	 Catch:{ all -> 0x0169 }
        r6 = r2.a();	 Catch:{ all -> 0x0169 }
        r6 = android.text.TextUtils.isEmpty(r6);	 Catch:{ all -> 0x0169 }
        if (r6 == 0) goto L_0x0165;
    L_0x015a:
        if (r4 == 0) goto L_0x0164;
    L_0x015c:
        if (r13 == 0) goto L_0x0161;
    L_0x015e:
        r13.close();
    L_0x0161:
        r2 = r3;
        goto L_0x0010;
    L_0x0164:
        r4 = 1;
    L_0x0165:
        r3.add(r2);	 Catch:{ all -> 0x0169 }
        goto L_0x0144;
    L_0x0169:
        r2 = move-exception;
    L_0x016a:
        if (r13 == 0) goto L_0x016f;
    L_0x016c:
        r13.close();
    L_0x016f:
        throw r2;
    L_0x0170:
        r2 = move-exception;
        r13 = r3;
        goto L_0x016a;
    L_0x0173:
        r2 = move-exception;
        goto L_0x0120;
    L_0x0175:
        r2 = move-exception;
        r12 = r13;
        goto L_0x00fa;
    L_0x0178:
        r2 = move-exception;
        r12 = r4;
        goto L_0x00fa;
    L_0x017b:
        r2 = move-exception;
        r3 = r2;
        r4 = r13;
        r2 = r11;
        goto L_0x00d8;
    L_0x0181:
        r2 = move-exception;
        r3 = r2;
        r4 = r13;
        r2 = r12;
        goto L_0x00d8;
    L_0x0187:
        r4 = r2;
        goto L_0x009a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.analytics.tracking.android.ax.b(int):java.util.List<com.google.analytics.tracking.android.ap>");
    }

    int m241c() {
        boolean z = true;
        long a = this.f199h.a();
        if (a <= this.f198g + 86400000) {
            return 0;
        }
        this.f198g = a;
        SQLiteDatabase a2 = m224a("Error opening database for deleteStaleHits.");
        if (a2 == null) {
            return 0;
        }
        int delete = a2.delete("hits2", "HIT_TIME < ?", new String[]{Long.toString(this.f199h.a() - 2592000000L)});
        g gVar = this.f195d;
        if (m242d() != 0) {
            z = false;
        }
        gVar.a(z);
        return delete;
    }

    @Deprecated
    void m236a(Collection<ap> collection) {
        if (collection == null || collection.isEmpty()) {
            ar.d("Empty/Null collection passed to deleteHits.");
            return;
        }
        String[] strArr = new String[collection.size()];
        int i = 0;
        for (ap b : collection) {
            int i2 = i + 1;
            strArr[i] = String.valueOf(b.b());
            i = i2;
        }
        m238a(strArr);
    }

    void m238a(String[] strArr) {
        boolean z = true;
        if (strArr == null || strArr.length == 0) {
            ar.d("Empty hitIds passed to deleteHits.");
            return;
        }
        SQLiteDatabase a = m224a("Error opening database for deleteHits.");
        if (a != null) {
            try {
                a.delete("hits2", String.format("HIT_ID in (%s)", new Object[]{TextUtils.join(",", Collections.nCopies(strArr.length, LocationInfo.NA))}), strArr);
                g gVar = this.f195d;
                if (m242d() != 0) {
                    z = false;
                }
                gVar.a(z);
            } catch (SQLiteException e) {
                ar.d("Error deleting hits " + strArr);
            }
        }
    }

    int m242d() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase a = m224a("Error opening database for getNumStoredHits.");
        if (a != null) {
            try {
                cursor = a.rawQuery("SELECT COUNT(*) from hits2", null);
                if (cursor.moveToFirst()) {
                    i = (int) cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException e) {
                ar.d("Error getting numStoredHits");
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return i;
    }

    public void m234a() {
        ar.c("Dispatch running...");
        if (this.f194c.a()) {
            List b = m240b(40);
            if (b.isEmpty()) {
                ar.c("...nothing to dispatch");
                this.f195d.a(true);
                return;
            }
            int a = this.f194c.a(b);
            ar.c("sent " + a + " of " + b.size() + " hits");
            m236a(b.subList(0, Math.min(a, b.size())));
            if (a == b.size() && m242d() > 0) {
                C0339w.m259a().mo1735c();
            }
        }
    }

    public o m239b() {
        return this.f194c;
    }

    private SQLiteDatabase m224a(String str) {
        try {
            return this.f193b.getWritableDatabase();
        } catch (SQLiteException e) {
            ar.d(str);
            return null;
        }
    }
}
