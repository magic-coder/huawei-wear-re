package com.huawei.openalliance.ad.p112a.p121e;

import android.content.Context;
import android.database.Cursor;
import com.huawei.openalliance.ad.utils.db.C1357a;
import com.huawei.openalliance.ad.utils.db.bean.SloganRecord;
import java.util.ArrayList;
import java.util.List;

public class C1258j {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.huawei.openalliance.ad.utils.db.bean.SloganRecord m5572a(android.content.Context r14, int r15) {
        /*
        r8 = 1;
        r7 = 0;
        r6 = 0;
        if (r14 != 0) goto L_0x0006;
    L_0x0005:
        return r6;
    L_0x0006:
        r0 = com.huawei.openalliance.ad.utils.db.bean.SloganRecord.class;
        r1 = r0.getSimpleName();
        if (r15 != 0) goto L_0x0088;
    L_0x000e:
        r0 = "width > height";
        r3 = r0;
    L_0x0012:
        r10 = com.huawei.openalliance.ad.p112a.p122h.C1287e.m5689d();
        r0 = com.huawei.openalliance.ad.utils.db.C1357a.m5982a(r14);
        r2 = 0;
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00de, all -> 0x00cc }
        r4.<init>();	 Catch:{ Exception -> 0x00de, all -> 0x00cc }
        r5 = "startTime <= ? and endTime >= ? and ";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x00de, all -> 0x00cc }
        r3 = r4.append(r3);	 Catch:{ Exception -> 0x00de, all -> 0x00cc }
        r3 = r3.toString();	 Catch:{ Exception -> 0x00de, all -> 0x00cc }
        r4 = 2;
        r4 = new java.lang.String[r4];	 Catch:{ Exception -> 0x00de, all -> 0x00cc }
        r5 = 0;
        r9 = java.lang.String.valueOf(r10);	 Catch:{ Exception -> 0x00de, all -> 0x00cc }
        r4[r5] = r9;	 Catch:{ Exception -> 0x00de, all -> 0x00cc }
        r5 = 1;
        r9 = java.lang.String.valueOf(r10);	 Catch:{ Exception -> 0x00de, all -> 0x00cc }
        r4[r5] = r9;	 Catch:{ Exception -> 0x00de, all -> 0x00cc }
        r5 = "_id asc";
        r3 = r0.m5989a(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x00de, all -> 0x00cc }
        if (r3 == 0) goto L_0x00f1;
    L_0x0047:
        r2 = r3.getCount();	 Catch:{ Exception -> 0x00e3, all -> 0x00d9 }
        if (r2 <= 0) goto L_0x00f1;
    L_0x004d:
        r4 = new com.huawei.openalliance.ad.utils.db.bean.SloganRecord;	 Catch:{ Exception -> 0x00e3, all -> 0x00d9 }
        r4.<init>();	 Catch:{ Exception -> 0x00e3, all -> 0x00d9 }
        r3.moveToFirst();	 Catch:{ Exception -> 0x00e8, all -> 0x00d9 }
        r5 = new java.util.ArrayList;	 Catch:{ Exception -> 0x00e8, all -> 0x00d9 }
        r2 = 4;
        r5.<init>(r2);	 Catch:{ Exception -> 0x00e8, all -> 0x00d9 }
        r2 = r7;
    L_0x005c:
        r4.m6001a(r3);	 Catch:{ Exception -> 0x00af, all -> 0x00d9 }
        r7 = r4.m6059c();	 Catch:{ Exception -> 0x00af, all -> 0x00d9 }
        if (r7 != 0) goto L_0x008d;
    L_0x0065:
        r3.moveToNext();	 Catch:{ Exception -> 0x00af, all -> 0x00d9 }
    L_0x0068:
        r7 = r3.isAfterLast();	 Catch:{ Exception -> 0x00af, all -> 0x00d9 }
        if (r7 != 0) goto L_0x0070;
    L_0x006e:
        if (r2 == 0) goto L_0x005c;
    L_0x0070:
        r7 = "contentId";
        r0.m5992a(r1, r7, r5);	 Catch:{ Exception -> 0x00af, all -> 0x00d9 }
        r1 = r2;
        r2 = r4;
    L_0x0077:
        if (r3 == 0) goto L_0x007c;
    L_0x0079:
        r3.close();
    L_0x007c:
        if (r0 == 0) goto L_0x00ef;
    L_0x007e:
        r0.close();
        r0 = r2;
    L_0x0082:
        if (r1 != 0) goto L_0x0085;
    L_0x0084:
        r0 = r6;
    L_0x0085:
        r6 = r0;
        goto L_0x0005;
    L_0x0088:
        r0 = "width <= height";
        r3 = r0;
        goto L_0x0012;
    L_0x008d:
        r9 = new java.io.File;	 Catch:{ Exception -> 0x00af, all -> 0x00d9 }
        r9.<init>(r7);	 Catch:{ Exception -> 0x00af, all -> 0x00d9 }
        r7 = r9.exists();	 Catch:{ Exception -> 0x00af, all -> 0x00d9 }
        if (r7 == 0) goto L_0x00a4;
    L_0x0098:
        r10 = r9.length();	 Catch:{ Exception -> 0x00af, all -> 0x00d9 }
        r12 = 0;
        r7 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r7 <= 0) goto L_0x00a4;
    L_0x00a2:
        r2 = r8;
        goto L_0x0068;
    L_0x00a4:
        r3.moveToNext();	 Catch:{ Exception -> 0x00af, all -> 0x00d9 }
        r7 = r4.m6056a();	 Catch:{ Exception -> 0x00af, all -> 0x00d9 }
        r5.add(r7);	 Catch:{ Exception -> 0x00af, all -> 0x00d9 }
        goto L_0x0068;
    L_0x00af:
        r1 = move-exception;
        r1 = r2;
        r2 = r3;
        r3 = r4;
    L_0x00b3:
        r4 = "SloganManager";
        r5 = 1;
        r5 = new java.lang.String[r5];	 Catch:{ all -> 0x00db }
        r7 = 0;
        r8 = "query slogan fail";
        r5[r7] = r8;	 Catch:{ all -> 0x00db }
        com.huawei.openalliance.ad.utils.p129b.C1336d.m5888c(r4, r5);	 Catch:{ all -> 0x00db }
        if (r2 == 0) goto L_0x00c5;
    L_0x00c2:
        r2.close();
    L_0x00c5:
        if (r0 == 0) goto L_0x00ed;
    L_0x00c7:
        r0.close();
        r0 = r3;
        goto L_0x0082;
    L_0x00cc:
        r1 = move-exception;
        r3 = r6;
    L_0x00ce:
        if (r3 == 0) goto L_0x00d3;
    L_0x00d0:
        r3.close();
    L_0x00d3:
        if (r0 == 0) goto L_0x00d8;
    L_0x00d5:
        r0.close();
    L_0x00d8:
        throw r1;
    L_0x00d9:
        r1 = move-exception;
        goto L_0x00ce;
    L_0x00db:
        r1 = move-exception;
        r3 = r2;
        goto L_0x00ce;
    L_0x00de:
        r1 = move-exception;
        r1 = r7;
        r2 = r6;
        r3 = r6;
        goto L_0x00b3;
    L_0x00e3:
        r1 = move-exception;
        r1 = r7;
        r2 = r3;
        r3 = r6;
        goto L_0x00b3;
    L_0x00e8:
        r1 = move-exception;
        r1 = r7;
        r2 = r3;
        r3 = r4;
        goto L_0x00b3;
    L_0x00ed:
        r0 = r3;
        goto L_0x0082;
    L_0x00ef:
        r0 = r2;
        goto L_0x0082;
    L_0x00f1:
        r1 = r7;
        r2 = r6;
        goto L_0x0077;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.a.e.j.a(android.content.Context, int):com.huawei.openalliance.ad.utils.db.bean.SloganRecord");
    }

    public static List<String> m5573a(Context context) {
        Cursor cursor = null;
        if (context == null) {
            return cursor;
        }
        List<String> arrayList = new ArrayList(4);
        C1357a a = C1357a.m5982a(context);
        try {
            cursor = a.m5989a(SloganRecord.class.getSimpleName(), new String[]{"contentId"}, null, null, null);
            if (cursor == null || cursor.getCount() <= 0) {
                if (cursor != null) {
                    cursor.close();
                }
                a.close();
                return arrayList;
            }
            cursor.moveToFirst();
            do {
                arrayList.add(cursor.getString(cursor.getColumnIndex("contentId")));
                cursor.moveToNext();
            } while (!cursor.isAfterLast());
            if (cursor != null) {
                cursor.close();
            }
            a.close();
            return arrayList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            a.close();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m5574a(android.content.Context r14, com.huawei.openalliance.ad.p112a.p113a.p115b.C1233s r15) {
        /*
        r8 = 0;
        r6 = 1;
        r7 = 0;
        if (r14 == 0) goto L_0x0007;
    L_0x0005:
        if (r15 != 0) goto L_0x0013;
    L_0x0007:
        r0 = "SloganManager";
        r1 = new java.lang.String[r6];
        r2 = "downSlogan param invalid";
        r1[r7] = r2;
        com.huawei.openalliance.ad.utils.p129b.C1336d.m5888c(r0, r1);
    L_0x0012:
        return;
    L_0x0013:
        r0 = com.huawei.openalliance.ad.utils.db.bean.SloganRecord.class;
        r1 = r0.getSimpleName();
        r9 = new com.huawei.openalliance.ad.utils.db.bean.SloganRecord;
        r9.<init>(r15);
        r0 = com.huawei.openalliance.ad.utils.db.C1357a.m5982a(r14);
        r2 = 1;
        r2 = new java.lang.String[r2];	 Catch:{ Exception -> 0x0144, all -> 0x00de }
        r3 = 0;
        r4 = "url";
        r2[r3] = r4;	 Catch:{ Exception -> 0x0144, all -> 0x00de }
        r3 = "contentId = ?";
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ Exception -> 0x0144, all -> 0x00de }
        r5 = 0;
        r10 = r15.getContentid__();	 Catch:{ Exception -> 0x0144, all -> 0x00de }
        r4[r5] = r10;	 Catch:{ Exception -> 0x0144, all -> 0x00de }
        r5 = 0;
        r3 = r0.m5989a(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x0144, all -> 0x00de }
        if (r3 == 0) goto L_0x007d;
    L_0x003e:
        r2 = r3.getCount();	 Catch:{ Exception -> 0x00c9, all -> 0x013f }
        if (r2 <= 0) goto L_0x007d;
    L_0x0044:
        r3.moveToFirst();	 Catch:{ Exception -> 0x0147, all -> 0x013f }
        r2 = "url";
        r2 = r3.getColumnIndex(r2);	 Catch:{ Exception -> 0x0147, all -> 0x013f }
        r2 = r3.getString(r2);	 Catch:{ Exception -> 0x0147, all -> 0x013f }
        if (r2 == 0) goto L_0x00b9;
    L_0x0054:
        r4 = new java.io.File;	 Catch:{ Exception -> 0x0147, all -> 0x013f }
        r4.<init>(r2);	 Catch:{ Exception -> 0x0147, all -> 0x013f }
        r2 = r4.exists();	 Catch:{ Exception -> 0x0147, all -> 0x013f }
        if (r2 == 0) goto L_0x0069;
    L_0x005f:
        r10 = r4.length();	 Catch:{ Exception -> 0x0147, all -> 0x013f }
        r12 = 0;
        r2 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r2 != 0) goto L_0x014b;
    L_0x0069:
        com.huawei.openalliance.ad.utils.C1345b.m5937a(r4);	 Catch:{ Exception -> 0x00c9, all -> 0x013f }
        r2 = "contentId = ?";
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ Exception -> 0x00c9, all -> 0x013f }
        r5 = 0;
        r6 = r15.getContentid__();	 Catch:{ Exception -> 0x00c9, all -> 0x013f }
        r4[r5] = r6;	 Catch:{ Exception -> 0x00c9, all -> 0x013f }
        r0.m5987a(r1, r2, r4);	 Catch:{ Exception -> 0x00c9, all -> 0x013f }
        r2 = r7;
    L_0x007c:
        r7 = r2;
    L_0x007d:
        if (r3 == 0) goto L_0x0082;
    L_0x007f:
        r3.close();
    L_0x0082:
        if (r7 == 0) goto L_0x00e6;
    L_0x0084:
        r2 = "SloganManager";
        r3 = 1;
        r3 = new java.lang.String[r3];	 Catch:{ Exception -> 0x0127 }
        r4 = 0;
        r5 = "has slogan, begin to update it";
        r3[r4] = r5;	 Catch:{ Exception -> 0x0127 }
        com.huawei.openalliance.ad.utils.p129b.C1336d.m5886b(r2, r3);	 Catch:{ Exception -> 0x0127 }
        r2 = r9.m6004u();	 Catch:{ Exception -> 0x0127 }
        r3 = "_id";
        r2.remove(r3);	 Catch:{ Exception -> 0x0127 }
        r3 = "sha256";
        r2.remove(r3);	 Catch:{ Exception -> 0x0127 }
        r3 = "url";
        r2.remove(r3);	 Catch:{ Exception -> 0x0127 }
        r3 = "contentId = ?";
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ Exception -> 0x0127 }
        r5 = 0;
        r6 = r9.m6056a();	 Catch:{ Exception -> 0x0127 }
        r4[r5] = r6;	 Catch:{ Exception -> 0x0127 }
        r0.m5986a(r1, r2, r3, r4);	 Catch:{ Exception -> 0x0127 }
    L_0x00b4:
        r0.close();
        goto L_0x0012;
    L_0x00b9:
        r2 = "contentId = ?";
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ Exception -> 0x00c9, all -> 0x013f }
        r5 = 0;
        r6 = r15.getContentid__();	 Catch:{ Exception -> 0x00c9, all -> 0x013f }
        r4[r5] = r6;	 Catch:{ Exception -> 0x00c9, all -> 0x013f }
        r0.m5987a(r1, r2, r4);	 Catch:{ Exception -> 0x00c9, all -> 0x013f }
        goto L_0x007d;
    L_0x00c9:
        r2 = move-exception;
        r2 = r3;
    L_0x00cb:
        r3 = "SloganManager";
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ all -> 0x0141 }
        r5 = 0;
        r6 = "query or delete slogan fail";
        r4[r5] = r6;	 Catch:{ all -> 0x0141 }
        com.huawei.openalliance.ad.utils.p129b.C1336d.m5888c(r3, r4);	 Catch:{ all -> 0x0141 }
        if (r2 == 0) goto L_0x0082;
    L_0x00da:
        r2.close();
        goto L_0x0082;
    L_0x00de:
        r0 = move-exception;
        r3 = r8;
    L_0x00e0:
        if (r3 == 0) goto L_0x00e5;
    L_0x00e2:
        r3.close();
    L_0x00e5:
        throw r0;
    L_0x00e6:
        r2 = "SloganManager";
        r3 = 1;
        r3 = new java.lang.String[r3];	 Catch:{ Exception -> 0x0127 }
        r4 = 0;
        r5 = "not has slogan, begin to down slogan";
        r3[r4] = r5;	 Catch:{ Exception -> 0x0127 }
        com.huawei.openalliance.ad.utils.p129b.C1336d.m5886b(r2, r3);	 Catch:{ Exception -> 0x0127 }
        r2 = r15.getUrl__();	 Catch:{ Exception -> 0x0127 }
        r3 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Exception -> 0x0127 }
        if (r3 != 0) goto L_0x00b4;
    L_0x00fd:
        r3 = new com.huawei.openalliance.ad.utils.c.a.a;	 Catch:{ Exception -> 0x0127 }
        r4 = r15.getCreativetype__();	 Catch:{ Exception -> 0x0127 }
        r4 = com.huawei.openalliance.ad.p112a.p122h.C1287e.m5679a(r14, r4);	 Catch:{ Exception -> 0x0127 }
        r5 = 0;
        r6 = r15.getSha256__();	 Catch:{ Exception -> 0x0127 }
        r3.<init>(r2, r4, r5, r6);	 Catch:{ Exception -> 0x0127 }
        r2 = "slogan";
        r3.m5942a(r2);	 Catch:{ Exception -> 0x0127 }
        r2 = new com.huawei.openalliance.ad.utils.c.a.b;	 Catch:{ Exception -> 0x0127 }
        r4 = new com.huawei.openalliance.ad.a.e.k;	 Catch:{ Exception -> 0x0127 }
        r4.<init>(r9, r1);	 Catch:{ Exception -> 0x0127 }
        r2.<init>(r14, r3, r4);	 Catch:{ Exception -> 0x0127 }
        r1 = com.huawei.openalliance.ad.utils.C1366j.f2949a;	 Catch:{ Exception -> 0x0127 }
        r3 = 0;
        r3 = new java.lang.Void[r3];	 Catch:{ Exception -> 0x0127 }
        r2.executeOnExecutor(r1, r3);	 Catch:{ Exception -> 0x0127 }
        goto L_0x00b4;
    L_0x0127:
        r1 = move-exception;
        r1 = "SloganManager";
        r2 = 1;
        r2 = new java.lang.String[r2];	 Catch:{ all -> 0x013a }
        r3 = 0;
        r4 = "handle and update material fail";
        r2[r3] = r4;	 Catch:{ all -> 0x013a }
        com.huawei.openalliance.ad.utils.p129b.C1336d.m5888c(r1, r2);	 Catch:{ all -> 0x013a }
        r0.close();
        goto L_0x0012;
    L_0x013a:
        r1 = move-exception;
        r0.close();
        throw r1;
    L_0x013f:
        r0 = move-exception;
        goto L_0x00e0;
    L_0x0141:
        r0 = move-exception;
        r3 = r2;
        goto L_0x00e0;
    L_0x0144:
        r2 = move-exception;
        r2 = r8;
        goto L_0x00cb;
    L_0x0147:
        r2 = move-exception;
        r2 = r3;
        r7 = r6;
        goto L_0x00cb;
    L_0x014b:
        r2 = r6;
        goto L_0x007c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.a.e.j.a(android.content.Context, com.huawei.openalliance.ad.a.a.b.s):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m5575a(android.content.Context r7, java.util.List<java.lang.String> r8) {
        /*
        if (r7 == 0) goto L_0x000a;
    L_0x0002:
        if (r8 == 0) goto L_0x000a;
    L_0x0004:
        r0 = r8.isEmpty();
        if (r0 == 0) goto L_0x000b;
    L_0x000a:
        return;
    L_0x000b:
        r0 = com.huawei.openalliance.ad.utils.db.bean.SloganRecord.class;
        r1 = r0.getSimpleName();
        r2 = com.huawei.openalliance.ad.utils.db.C1357a.m5982a(r7);
        r0 = 0;
        r3 = "contentId";
        r0 = r2.m5994b(r1, r3, r8);	 Catch:{ Exception -> 0x0056, all -> 0x006d }
        if (r0 == 0) goto L_0x0048;
    L_0x001e:
        r3 = r0.getCount();	 Catch:{ Exception -> 0x0056 }
        if (r3 <= 0) goto L_0x0048;
    L_0x0024:
        r0.moveToFirst();	 Catch:{ Exception -> 0x0056 }
    L_0x0027:
        r3 = "url";
        r3 = r0.getColumnIndex(r3);	 Catch:{ Exception -> 0x0056 }
        r3 = r0.getString(r3);	 Catch:{ Exception -> 0x0056 }
        if (r3 == 0) goto L_0x0042;
    L_0x0034:
        r4 = new java.io.File;	 Catch:{ Exception -> 0x0056 }
        r4.<init>(r3);	 Catch:{ Exception -> 0x0056 }
        r3 = r4.exists();	 Catch:{ Exception -> 0x0056 }
        if (r3 == 0) goto L_0x0042;
    L_0x003f:
        com.huawei.openalliance.ad.utils.C1345b.m5937a(r4);	 Catch:{ Exception -> 0x0056 }
    L_0x0042:
        r3 = r0.moveToNext();	 Catch:{ Exception -> 0x0056 }
        if (r3 != 0) goto L_0x0027;
    L_0x0048:
        r3 = "contentId";
        r2.m5992a(r1, r3, r8);	 Catch:{ Exception -> 0x0056 }
        if (r0 == 0) goto L_0x0052;
    L_0x004f:
        r0.close();
    L_0x0052:
        r2.close();
        goto L_0x000a;
    L_0x0056:
        r1 = move-exception;
        r1 = "SloganManager";
        r3 = 1;
        r3 = new java.lang.String[r3];	 Catch:{ all -> 0x007a }
        r4 = 0;
        r5 = "delete slogan fail";
        r3[r4] = r5;	 Catch:{ all -> 0x007a }
        com.huawei.openalliance.ad.utils.p129b.C1336d.m5888c(r1, r3);	 Catch:{ all -> 0x007a }
        if (r0 == 0) goto L_0x0069;
    L_0x0066:
        r0.close();
    L_0x0069:
        r2.close();
        goto L_0x000a;
    L_0x006d:
        r1 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
    L_0x0071:
        if (r1 == 0) goto L_0x0076;
    L_0x0073:
        r1.close();
    L_0x0076:
        r2.close();
        throw r0;
    L_0x007a:
        r1 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
        goto L_0x0071;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.a.e.j.a(android.content.Context, java.util.List):void");
    }
}
