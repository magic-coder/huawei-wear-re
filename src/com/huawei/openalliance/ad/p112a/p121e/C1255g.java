package com.huawei.openalliance.ad.p112a.p121e;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1221g;
import com.huawei.openalliance.ad.p112a.p122h.C1284b;
import com.huawei.openalliance.ad.p112a.p122h.C1287e;
import com.huawei.openalliance.ad.p112a.p122h.C1289h;
import com.huawei.openalliance.ad.utils.C1345b;
import com.huawei.openalliance.ad.utils.C1365i;
import com.huawei.openalliance.ad.utils.C1366j;
import com.huawei.openalliance.ad.utils.db.C1357a;
import com.huawei.openalliance.ad.utils.db.bean.MaterialRecord;
import com.huawei.openalliance.ad.utils.p129b.C1336d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class C1255g {
    public static C1221g m5561a(Context context, String str) {
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        C1357a a = C1357a.m5982a(context);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            a.m5987a(MaterialRecord.class.getSimpleName(), "materialId = ? and validTime < ?", new String[]{str, String.valueOf(currentTimeMillis)});
            Cursor a2 = a.m5989a(MaterialRecord.class.getSimpleName(), null, "materialId = ? and validTime >= ?", new String[]{str, String.valueOf(currentTimeMillis)}, null);
            if (a2 != null) {
                try {
                    if (a2.getCount() > 0) {
                        a2.moveToFirst();
                        MaterialRecord materialRecord = new MaterialRecord();
                        materialRecord.m6001a(a2);
                        C1221g a3 = C1284b.m5661a(materialRecord);
                        if (a2 != null) {
                            a2.close();
                        }
                        a.close();
                        return a3;
                    }
                } catch (Exception e) {
                    cursor = a2;
                    try {
                        C1336d.m5888c("MaterialManager", "get material fail");
                        if (cursor != null) {
                            cursor.close();
                        }
                        a.close();
                        return null;
                    } catch (Throwable th2) {
                        cursor2 = cursor;
                        th = th2;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        a.close();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor2 = a2;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    a.close();
                    throw th;
                }
            }
            if (a2 != null) {
                a2.close();
            }
            a.close();
            return null;
        } catch (Exception e2) {
            cursor = null;
            C1336d.m5888c("MaterialManager", "get material fail");
            if (cursor != null) {
                cursor.close();
            }
            a.close();
            return null;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            a.close();
            throw th;
        }
    }

    public static C1221g m5562a(Context context, String str, String str2, int i, int i2) {
        MaterialRecord materialRecord;
        Object obj;
        MaterialRecord materialRecord2;
        Throwable th;
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        String str3;
        String[] strArr;
        C1289h a = C1289h.m5695a(context);
        C1255g.m5563a(context);
        String simpleName = MaterialRecord.class.getSimpleName();
        int c = a.m5705c();
        long d = C1287e.m5689d();
        String str4 = i == 0 ? "width > height" : "width <= height";
        if (2 == c) {
            str3 = str4 + " and starttime <= ? and validTime >= ? and adType = ? and slotId = ? and isSplashPreContent <> ? and materialId = ?";
            strArr = new String[]{String.valueOf(d), String.valueOf(d), String.valueOf(i2), str, "0", str2};
        } else {
            long f = a.m5713f();
            String a2 = C1287e.m5681a("yyyy-MM-dd");
            str3 = str4 + " and starttime <= ? and validTime >= ? and adType = ? and slotId = ? and isSplashPreContent <> ? and lastShowTime < ? and fcCtrlDate <> ?";
            strArr = new String[]{String.valueOf(d), String.valueOf(d), String.valueOf(i2), str, "0", String.valueOf(d - f), a2};
        }
        C1357a a3 = C1357a.m5982a(context);
        Cursor a4;
        try {
            a4 = a3.m5989a(simpleName, null, str3, strArr, "isPriority asc, displayCount asc, updateTime desc");
            if (a4 != null) {
                try {
                    if (a4.getCount() > 0) {
                        materialRecord = new MaterialRecord();
                        try {
                            a4.moveToFirst();
                            List arrayList = new ArrayList(4);
                            obj = null;
                            do {
                                try {
                                    materialRecord.m6001a(a4);
                                    String a5 = C1345b.m5934a(materialRecord.m6047m());
                                    if (a5 == null) {
                                        a4.moveToNext();
                                    } else {
                                        File file = new File(a5);
                                        if (!file.exists() || file.length() <= 0) {
                                            C1345b.m5937a(file);
                                            arrayList.add(materialRecord.m6022d());
                                            a4.moveToNext();
                                        } else {
                                            obj = 1;
                                        }
                                    }
                                    if (a4.isAfterLast()) {
                                        break;
                                    }
                                } catch (Exception e) {
                                }
                            } while (obj == null);
                            a3.m5992a(simpleName, "materialId", arrayList);
                            if (a4 != null) {
                                a4.close();
                            }
                            if (a3 != null) {
                                a3.close();
                                materialRecord2 = materialRecord;
                                if (obj != null || materialRecord2 == null) {
                                    materialRecord2 = null;
                                } else {
                                    C1366j.f2951c.execute(new C1257i(context, materialRecord2, simpleName));
                                }
                                return C1284b.m5661a(materialRecord2);
                            }
                        } catch (Exception e2) {
                            obj = null;
                            try {
                                C1336d.m5888c("MaterialManager", "query material fail");
                                if (a4 != null) {
                                    a4.close();
                                }
                                if (a3 != null) {
                                    a3.close();
                                    materialRecord2 = materialRecord;
                                    if (obj != null) {
                                    }
                                    materialRecord2 = null;
                                    return C1284b.m5661a(materialRecord2);
                                }
                                materialRecord2 = materialRecord;
                                if (obj != null) {
                                }
                                materialRecord2 = null;
                                return C1284b.m5661a(materialRecord2);
                            } catch (Throwable th2) {
                                th = th2;
                                if (a4 != null) {
                                    a4.close();
                                }
                                if (a3 != null) {
                                    a3.close();
                                }
                                throw th;
                            }
                        }
                        materialRecord2 = materialRecord;
                        if (obj != null) {
                        }
                        materialRecord2 = null;
                        return C1284b.m5661a(materialRecord2);
                    }
                } catch (Exception e3) {
                    obj = null;
                    materialRecord = null;
                    C1336d.m5888c("MaterialManager", "query material fail");
                    if (a4 != null) {
                        a4.close();
                    }
                    if (a3 != null) {
                        a3.close();
                        materialRecord2 = materialRecord;
                        if (obj != null) {
                        }
                        materialRecord2 = null;
                        return C1284b.m5661a(materialRecord2);
                    }
                    materialRecord2 = materialRecord;
                    if (obj != null) {
                    }
                    materialRecord2 = null;
                    return C1284b.m5661a(materialRecord2);
                }
            }
            obj = null;
            materialRecord = null;
            if (a4 != null) {
                a4.close();
            }
            if (a3 != null) {
                a3.close();
                materialRecord2 = materialRecord;
                if (obj != null) {
                }
                materialRecord2 = null;
                return C1284b.m5661a(materialRecord2);
            }
        } catch (Exception e4) {
            obj = null;
            a4 = null;
            materialRecord = null;
            C1336d.m5888c("MaterialManager", "query material fail");
            if (a4 != null) {
                a4.close();
            }
            if (a3 != null) {
                a3.close();
                materialRecord2 = materialRecord;
                if (obj != null) {
                }
                materialRecord2 = null;
                return C1284b.m5661a(materialRecord2);
            }
            materialRecord2 = materialRecord;
            if (obj != null) {
            }
            materialRecord2 = null;
            return C1284b.m5661a(materialRecord2);
        } catch (Throwable th3) {
            th = th3;
            a4 = null;
            if (a4 != null) {
                a4.close();
            }
            if (a3 != null) {
                a3.close();
            }
            throw th;
        }
        materialRecord2 = materialRecord;
        if (obj != null) {
        }
        materialRecord2 = null;
        return C1284b.m5661a(materialRecord2);
    }

    public static void m5563a(Context context) {
        Cursor cursor;
        Throwable th;
        String simpleName = MaterialRecord.class.getSimpleName();
        long currentTimeMillis = System.currentTimeMillis();
        C1357a a = C1357a.m5982a(context);
        Cursor a2;
        try {
            a2 = a.m5989a(simpleName, null, "validTime < ? and isSplashPreContent <> ?", new String[]{String.valueOf(currentTimeMillis), "0"}, null);
            if (a2 != null) {
                try {
                    if (a2.getCount() > 0) {
                        List arrayList = new ArrayList(4);
                        a2.moveToFirst();
                        do {
                            if (1 == a2.getInt(a2.getColumnIndex("adType"))) {
                                String a3 = C1345b.m5934a(a2.getString(a2.getColumnIndex("htmlStr")));
                                if (a3 != null) {
                                    C1345b.m5937a(new File(a3));
                                }
                            }
                            arrayList.add(a2.getString(a2.getColumnIndex("materialId")));
                            a2.moveToNext();
                        } while (!a2.isAfterLast());
                        a.m5992a(simpleName, "materialId", arrayList);
                    }
                } catch (Exception e) {
                    cursor = a2;
                    try {
                        C1336d.m5888c("MaterialManager", "delete invalid material fail");
                        if (cursor != null) {
                            cursor.close();
                        }
                        a.close();
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        a2 = cursor;
                        th = th3;
                        if (a2 != null) {
                            a2.close();
                        }
                        a.close();
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    if (a2 != null) {
                        a2.close();
                    }
                    a.close();
                    throw th;
                }
            }
            if (a2 != null) {
                a2.close();
            }
            a.close();
        } catch (Exception e2) {
            cursor = null;
            C1336d.m5888c("MaterialManager", "delete invalid material fail");
            if (cursor != null) {
                cursor.close();
            }
            a.close();
        } catch (Throwable th5) {
            th = th5;
            a2 = null;
            if (a2 != null) {
                a2.close();
            }
            a.close();
            throw th;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m5564a(android.content.Context r7, java.util.List<java.lang.String> r8) {
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
        r2 = com.huawei.openalliance.ad.utils.db.C1357a.m5982a(r7);
        r0 = 0;
        r1 = com.huawei.openalliance.ad.utils.db.bean.MaterialRecord.class;
        r1 = r1.getSimpleName();	 Catch:{ Exception -> 0x005f, all -> 0x0076 }
        r3 = "adType = 1 and materialId";
        r0 = r2.m5994b(r1, r3, r8);	 Catch:{ Exception -> 0x005f, all -> 0x0076 }
        if (r0 == 0) goto L_0x004b;
    L_0x001e:
        r1 = r0.getCount();	 Catch:{ Exception -> 0x005f }
        if (r1 <= 0) goto L_0x004b;
    L_0x0024:
        r0.moveToFirst();	 Catch:{ Exception -> 0x005f }
    L_0x0027:
        r1 = "htmlStr";
        r1 = r0.getColumnIndex(r1);	 Catch:{ Exception -> 0x005f }
        r1 = r0.getString(r1);	 Catch:{ Exception -> 0x005f }
        r1 = com.huawei.openalliance.ad.utils.C1345b.m5934a(r1);	 Catch:{ Exception -> 0x005f }
        if (r1 == 0) goto L_0x0045;
    L_0x0037:
        r3 = new java.io.File;	 Catch:{ Exception -> 0x005f }
        r3.<init>(r1);	 Catch:{ Exception -> 0x005f }
        r1 = r3.exists();	 Catch:{ Exception -> 0x005f }
        if (r1 == 0) goto L_0x0045;
    L_0x0042:
        com.huawei.openalliance.ad.utils.C1345b.m5937a(r3);	 Catch:{ Exception -> 0x005f }
    L_0x0045:
        r1 = r0.moveToNext();	 Catch:{ Exception -> 0x005f }
        if (r1 != 0) goto L_0x0027;
    L_0x004b:
        r1 = com.huawei.openalliance.ad.utils.db.bean.MaterialRecord.class;
        r1 = r1.getSimpleName();	 Catch:{ Exception -> 0x005f }
        r3 = "materialId";
        r2.m5992a(r1, r3, r8);	 Catch:{ Exception -> 0x005f }
        if (r0 == 0) goto L_0x005b;
    L_0x0058:
        r0.close();
    L_0x005b:
        r2.close();
        goto L_0x000a;
    L_0x005f:
        r1 = move-exception;
        r1 = "MaterialManager";
        r3 = 1;
        r3 = new java.lang.String[r3];	 Catch:{ all -> 0x0083 }
        r4 = 0;
        r5 = "delete material fail";
        r3[r4] = r5;	 Catch:{ all -> 0x0083 }
        com.huawei.openalliance.ad.utils.p129b.C1336d.m5888c(r1, r3);	 Catch:{ all -> 0x0083 }
        if (r0 == 0) goto L_0x0072;
    L_0x006f:
        r0.close();
    L_0x0072:
        r2.close();
        goto L_0x000a;
    L_0x0076:
        r1 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
    L_0x007a:
        if (r1 == 0) goto L_0x007f;
    L_0x007c:
        r1.close();
    L_0x007f:
        r2.close();
        throw r0;
    L_0x0083:
        r1 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
        goto L_0x007a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.a.e.g.a(android.content.Context, java.util.List):void");
    }

    public static boolean m5565a(Context context, String str, int i, int i2) {
        Cursor cursor;
        Throwable th;
        boolean z;
        if (context == null || C1365i.m6081a(str)) {
            C1336d.m5888c("MaterialManager", "check params failed");
            return false;
        }
        String simpleName = MaterialRecord.class.getSimpleName();
        long d = C1287e.m5689d();
        C1289h a = C1289h.m5695a(context);
        String str2 = i == 0 ? "width > height" : "width <= height";
        long f = a.m5713f();
        String a2 = C1287e.m5681a("yyyy-MM-dd");
        String str3 = str2 + " and starttime <= ? and validTime >= ? and adType = ? and slotId = ? and isSplashPreContent <> ? and lastShowTime < ? and fcCtrlDate <> ?";
        String[] strArr = new String[]{String.valueOf(d), String.valueOf(d), String.valueOf(i2), str, "0", String.valueOf(d - f), a2};
        C1357a a3 = C1357a.m5982a(context);
        Cursor a4;
        try {
            boolean z2;
            a4 = a3.m5989a(simpleName, new String[]{"htmlStr"}, str3, strArr, null);
            if (a4 != null) {
                try {
                    if (a4.getCount() > 0) {
                        a4.moveToFirst();
                        do {
                            simpleName = C1345b.m5934a(a4.getString(a4.getColumnIndex("htmlStr")));
                            if (simpleName != null) {
                                File file = new File(simpleName);
                                if (file.exists() && file.length() > 0) {
                                    z2 = true;
                                    break;
                                }
                                a4.moveToNext();
                            } else {
                                a4.moveToNext();
                            }
                        } while (!a4.isAfterLast());
                    }
                } catch (Exception e) {
                    cursor = a4;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            z2 = false;
            if (a4 != null) {
                a4.close();
            }
            if (a3 != null) {
                a3.close();
                z = z2;
            } else {
                z = z2;
            }
        } catch (Exception e2) {
            cursor = null;
            try {
                C1336d.m5888c("MaterialManager", "query has material fail");
                if (cursor != null) {
                    cursor.close();
                }
                if (a3 != null) {
                    a3.close();
                    z = false;
                } else {
                    z = false;
                }
                C1336d.m5886b("MaterialManager", "has ad material cache to show:" + z);
                return z;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                a4 = cursor;
                th = th4;
                if (a4 != null) {
                    a4.close();
                }
                if (a3 != null) {
                    a3.close();
                }
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            a4 = null;
            if (a4 != null) {
                a4.close();
            }
            if (a3 != null) {
                a3.close();
            }
            throw th;
        }
        C1336d.m5886b("MaterialManager", "has ad material cache to show:" + z);
        return z;
    }
}
