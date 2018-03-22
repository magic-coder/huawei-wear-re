package com.huawei.openalliance.ad.p112a.p121e;

import android.content.Context;
import android.database.Cursor;
import android.os.Handler;
import com.huawei.openalliance.ad.utils.db.C1357a;
import com.huawei.openalliance.ad.utils.db.bean.MaterialRecord;
import com.huawei.openalliance.ad.utils.p119c.p120a.C1347b.C1247a;
import com.huawei.openalliance.ad.utils.p129b.C1336d;

public class C1248a implements C1247a {
    String f2664a;
    Handler f2665b;
    private MaterialRecord f2666c;

    public C1248a(MaterialRecord materialRecord, String str, Handler handler) {
        this.f2666c = materialRecord;
        this.f2664a = str;
        this.f2665b = handler;
    }

    private static long m5528b(Context context, String str) {
        long j;
        C1357a c1357a;
        Cursor cursor;
        Throwable th;
        C1357a c1357a2;
        Throwable th2;
        Cursor cursor2 = null;
        if (str == null) {
            return 0;
        }
        try {
            C1357a a = C1357a.m5982a(context);
            try {
                long j2;
                Cursor a2 = a.m5989a(MaterialRecord.class.getSimpleName(), new String[]{"lastShowTime"}, "taskId=?", new String[]{str}, "lastShowTime desc");
                if (a2 != null) {
                    try {
                        if (a2.getCount() > 0) {
                            a2.moveToFirst();
                            j2 = a2.getLong(a2.getColumnIndex("lastShowTime"));
                            if (a2 != null) {
                                a2.close();
                            }
                            if (a == null) {
                                a.close();
                                j = j2;
                            } else {
                                j = j2;
                            }
                            return j;
                        }
                    } catch (Exception e) {
                        c1357a = a;
                        cursor = a2;
                        try {
                            C1336d.m5888c("AdDownloadCallBack", "get taskid " + str + " lashShowTime fail");
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (c1357a != null) {
                                j = 0;
                            } else {
                                c1357a.close();
                                j = 0;
                            }
                            return j;
                        } catch (Throwable th3) {
                            th = th3;
                            c1357a2 = c1357a;
                            cursor2 = cursor;
                            th2 = th;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            if (c1357a2 != null) {
                                c1357a2.close();
                            }
                            throw th2;
                        }
                    } catch (Throwable th4) {
                        cursor2 = a2;
                        c1357a2 = a;
                        th2 = th4;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        if (c1357a2 != null) {
                            c1357a2.close();
                        }
                        throw th2;
                    }
                }
                j2 = 0;
                if (a2 != null) {
                    a2.close();
                }
                if (a == null) {
                    j = j2;
                } else {
                    a.close();
                    j = j2;
                }
            } catch (Exception e2) {
                c1357a = a;
                cursor = null;
                C1336d.m5888c("AdDownloadCallBack", "get taskid " + str + " lashShowTime fail");
                if (cursor != null) {
                    cursor.close();
                }
                if (c1357a != null) {
                    c1357a.close();
                    j = 0;
                } else {
                    j = 0;
                }
                return j;
            } catch (Throwable th32) {
                th = th32;
                c1357a2 = a;
                th2 = th;
                if (cursor2 != null) {
                    cursor2.close();
                }
                if (c1357a2 != null) {
                    c1357a2.close();
                }
                throw th2;
            }
        } catch (Exception e3) {
            cursor = null;
            C1336d.m5888c("AdDownloadCallBack", "get taskid " + str + " lashShowTime fail");
            if (cursor != null) {
                cursor.close();
            }
            if (c1357a != null) {
                c1357a.close();
                j = 0;
            } else {
                j = 0;
            }
            return j;
        } catch (Throwable th5) {
            th2 = th5;
            c1357a2 = null;
            if (cursor2 != null) {
                cursor2.close();
            }
            if (c1357a2 != null) {
                c1357a2.close();
            }
            throw th2;
        }
        return j;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo2428a(android.content.Context r9, java.lang.String r10) {
        /*
        r8 = this;
        r6 = 1006; // 0x3ee float:1.41E-42 double:4.97E-321;
        r5 = 1002; // 0x3ea float:1.404E-42 double:4.95E-321;
        r0 = 0;
        r0 = com.huawei.openalliance.ad.utils.db.C1357a.m5982a(r9);	 Catch:{ Exception -> 0x006b, all -> 0x009b }
        r1 = android.text.TextUtils.isEmpty(r10);	 Catch:{ Exception -> 0x006b }
        if (r1 != 0) goto L_0x0049;
    L_0x000f:
        r1 = new java.io.File;	 Catch:{ Exception -> 0x006b }
        r1.<init>(r10);	 Catch:{ Exception -> 0x006b }
        r1 = com.huawei.openalliance.ad.utils.C1345b.m5940b(r1);	 Catch:{ Exception -> 0x006b }
        if (r1 == 0) goto L_0x0049;
    L_0x001a:
        r1 = r8.f2666c;	 Catch:{ Exception -> 0x006b }
        r1 = r1.m6047m();	 Catch:{ Exception -> 0x006b }
        r2 = r8.f2664a;	 Catch:{ Exception -> 0x006b }
        r1 = r1.replace(r2, r10);	 Catch:{ Exception -> 0x006b }
        r2 = r8.f2666c;	 Catch:{ Exception -> 0x006b }
        r2.m6040i(r1);	 Catch:{ Exception -> 0x006b }
        r1 = r8.f2666c;	 Catch:{ Exception -> 0x006b }
        r2 = r8.f2666c;	 Catch:{ Exception -> 0x006b }
        r2 = r2.m6026e();	 Catch:{ Exception -> 0x006b }
        r2 = com.huawei.openalliance.ad.p112a.p121e.C1248a.m5528b(r9, r2);	 Catch:{ Exception -> 0x006b }
        r1.m6012a(r2);	 Catch:{ Exception -> 0x006b }
        r1 = com.huawei.openalliance.ad.utils.db.bean.MaterialRecord.class;
        r1 = r1.getSimpleName();	 Catch:{ Exception -> 0x006b }
        r2 = r8.f2666c;	 Catch:{ Exception -> 0x006b }
        r2 = r2.m6004u();	 Catch:{ Exception -> 0x006b }
        r0.m5988a(r1, r2);	 Catch:{ Exception -> 0x006b }
    L_0x0049:
        if (r0 == 0) goto L_0x004e;
    L_0x004b:
        r0.close();
    L_0x004e:
        r0 = r8.f2665b;
        if (r0 == 0) goto L_0x006a;
    L_0x0052:
        r0 = r8.f2665b;
        r0 = r0.obtainMessage(r5);
        r1 = r8.f2666c;
        r1 = r1.m6022d();
        r0.obj = r1;
        r1 = r8.f2665b;
        r1.sendMessage(r0);
        r0 = r8.f2665b;
        r0.sendEmptyMessage(r6);
    L_0x006a:
        return;
    L_0x006b:
        r1 = move-exception;
        r1 = "AdDownloadCallBack";
        r2 = 1;
        r2 = new java.lang.String[r2];	 Catch:{ all -> 0x00c1 }
        r3 = 0;
        r4 = "insert material fail";
        r2[r3] = r4;	 Catch:{ all -> 0x00c1 }
        com.huawei.openalliance.ad.utils.p129b.C1336d.m5888c(r1, r2);	 Catch:{ all -> 0x00c1 }
        if (r0 == 0) goto L_0x007e;
    L_0x007b:
        r0.close();
    L_0x007e:
        r0 = r8.f2665b;
        if (r0 == 0) goto L_0x006a;
    L_0x0082:
        r0 = r8.f2665b;
        r0 = r0.obtainMessage(r5);
        r1 = r8.f2666c;
        r1 = r1.m6022d();
        r0.obj = r1;
        r1 = r8.f2665b;
        r1.sendMessage(r0);
        r0 = r8.f2665b;
        r0.sendEmptyMessage(r6);
        goto L_0x006a;
    L_0x009b:
        r1 = move-exception;
        r7 = r1;
        r1 = r0;
        r0 = r7;
    L_0x009f:
        if (r1 == 0) goto L_0x00a4;
    L_0x00a1:
        r1.close();
    L_0x00a4:
        r1 = r8.f2665b;
        if (r1 == 0) goto L_0x00c0;
    L_0x00a8:
        r1 = r8.f2665b;
        r1 = r1.obtainMessage(r5);
        r2 = r8.f2666c;
        r2 = r2.m6022d();
        r1.obj = r2;
        r2 = r8.f2665b;
        r2.sendMessage(r1);
        r1 = r8.f2665b;
        r1.sendEmptyMessage(r6);
    L_0x00c0:
        throw r0;
    L_0x00c1:
        r1 = move-exception;
        r7 = r1;
        r1 = r0;
        r0 = r7;
        goto L_0x009f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.a.e.a.a(android.content.Context, java.lang.String):void");
    }
}
