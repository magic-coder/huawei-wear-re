package com.huawei.openalliance.ad.p112a.p121e;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Handler;
import android.os.Message;
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
import com.huawei.openalliance.ad.utils.p119c.p120a.C1346a;
import com.huawei.openalliance.ad.utils.p119c.p120a.C1347b;
import com.huawei.openalliance.ad.utils.p129b.C1336d;
import com.sina.weibo.sdk.component.ShareRequestParam;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class C1256h {
    public static void m5566a(Context context) {
        if (context != null) {
            C1284b.m5664a(context);
        }
    }

    public static void m5567a(Context context, int i, String str) {
        Cursor a;
        Cursor cursor;
        Throwable th;
        Throwable th2;
        C1357a c1357a = null;
        if (1 == i) {
            int a2 = C1289h.m5695a(context).m5696a();
            String str2 = "adType = 1";
            try {
                C1357a a3 = C1357a.m5982a(context);
                try {
                    String str3 = str;
                    a = a3.m5989a(str3, new String[]{"htmlStr", "materialId"}, str2, null, "isSplashPreContent asc, updateTime asc");
                    if (a != null) {
                        try {
                            int count = a.getCount();
                            if (count > a2) {
                                a.moveToFirst();
                                List arrayList = new ArrayList(4);
                                do {
                                    count--;
                                    String a4 = C1345b.m5934a(a.getString(a.getColumnIndex("htmlStr")));
                                    if (a4 != null) {
                                        C1345b.m5937a(new File(a4));
                                    }
                                    arrayList.add(a.getString(a.getColumnIndex("materialId")));
                                    if (count <= a2) {
                                        break;
                                    }
                                } while (a.moveToNext());
                                a3.m5992a(str, "materialId", arrayList);
                            }
                        } catch (Exception e) {
                            c1357a = a3;
                            cursor = a;
                            try {
                                C1336d.m5888c("MaterialManagerUtil", "delete overtime material fail");
                                if (cursor != null) {
                                    cursor.close();
                                }
                                if (c1357a == null) {
                                    c1357a.close();
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                a = cursor;
                                th2 = th;
                                if (a != null) {
                                    a.close();
                                }
                                if (c1357a != null) {
                                    c1357a.close();
                                }
                                throw th2;
                            }
                        } catch (Throwable th4) {
                            c1357a = a3;
                            th2 = th4;
                            if (a != null) {
                                a.close();
                            }
                            if (c1357a != null) {
                                c1357a.close();
                            }
                            throw th2;
                        }
                    }
                    if (a != null) {
                        a.close();
                    }
                    if (a3 != null) {
                        a3.close();
                    }
                } catch (Exception e2) {
                    c1357a = a3;
                    Object obj = null;
                    C1336d.m5888c("MaterialManagerUtil", "delete overtime material fail");
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (c1357a == null) {
                        c1357a.close();
                    }
                } catch (Throwable th32) {
                    th = th32;
                    a = null;
                    c1357a = a3;
                    th2 = th;
                    if (a != null) {
                        a.close();
                    }
                    if (c1357a != null) {
                        c1357a.close();
                    }
                    throw th2;
                }
            } catch (Exception e3) {
                cursor = null;
                C1336d.m5888c("MaterialManagerUtil", "delete overtime material fail");
                if (cursor != null) {
                    cursor.close();
                }
                if (c1357a == null) {
                    c1357a.close();
                }
            } catch (Throwable th5) {
                th2 = th5;
                a = null;
                if (a != null) {
                    a.close();
                }
                if (c1357a != null) {
                    c1357a.close();
                }
                throw th2;
            }
        }
    }

    public static void m5568a(Context context, String str, int i, C1221g c1221g, Handler handler, boolean z) {
        if (context != null && c1221g != null && !C1365i.m6081a(c1221g.getContentid__())) {
            String simpleName = MaterialRecord.class.getSimpleName();
            MaterialRecord a = C1284b.m5663a(str, i, c1221g, z);
            if (a != null) {
                C1357a a2 = C1357a.m5982a(context);
                boolean a3 = C1256h.m5570a(a2, simpleName, a);
                ContentValues u;
                if (a3 && !z) {
                    try {
                        C1336d.m5886b("MaterialManagerUtil", "show content and has material");
                        u = a.m6004u();
                        u.remove("displayCount");
                        u.remove("displayDate");
                        u.remove("htmlStr");
                        u.remove("lastShowTime");
                        u.remove("fcCtrlDate");
                        a2.m5986a(simpleName, u, "materialId = ?", new String[]{a.m6022d()});
                        if (handler != null) {
                            Message obtainMessage = handler.obtainMessage(1002);
                            obtainMessage.obj = a.m6022d();
                            handler.sendMessage(obtainMessage);
                            handler.sendEmptyMessage(1006);
                        }
                    } catch (Exception e) {
                        C1336d.m5888c("MaterialManagerUtil", "handle and update material fail");
                        return;
                    } finally {
                        a2.close();
                    }
                } else if (a3 && z) {
                    C1336d.m5886b("MaterialManagerUtil", "pre content and has material");
                    u = new ContentValues();
                    u.put("updateTime", Long.valueOf(a.m6043k()));
                    a2.m5986a(simpleName, u, "materialId = ?", new String[]{a.m6022d()});
                } else {
                    C1336d.m5886b("MaterialManagerUtil", "not has material, begin to down pic");
                    if (1 == i) {
                        String a4 = C1365i.m6078a(a.m6047m(), ShareRequestParam.REQ_UPLOAD_PIC_PARAM_IMG, "src");
                        if (!TextUtils.isEmpty(a4)) {
                            new C1347b(context, new C1346a(a4, C1287e.m5679a(context, a.m6050o()), a.m6010a(), a.m6014b()), new C1248a(a, a4, handler)).executeOnExecutor(C1366j.f2949a, new Void[0]);
                        }
                    } else if (2 == i) {
                        a2.m5988a(MaterialRecord.class.getSimpleName(), a.m6004u());
                    }
                }
                C1256h.m5567a(context, i, simpleName);
                a2.close();
            }
        }
    }

    public static void m5569a(Context context, List<String> list) {
        if (context == null || list == null || list.isEmpty()) {
            C1336d.m5886b("MaterialManagerUtil", "no content trigger fc control");
            return;
        }
        C1357a a = C1357a.m5982a(context);
        String a2 = C1287e.m5681a("yyyy-MM-dd");
        ContentValues contentValues = new ContentValues();
        contentValues.put("fcCtrlDate", a2);
        try {
            a.m5986a(MaterialRecord.class.getSimpleName(), contentValues, "materialId in (" + C1365i.m6080a((List) list, ",", "'") + ")", null);
        } catch (Exception e) {
            C1336d.m5890d("MaterialManagerUtil", e.getMessage());
        } finally {
            a.close();
        }
    }

    private static boolean m5570a(C1357a c1357a, String str, MaterialRecord materialRecord) {
        Cursor a;
        boolean z;
        Throwable th;
        try {
            C1357a c1357a2 = c1357a;
            String str2 = str;
            a = c1357a2.m5989a(str2, new String[]{"htmlStr"}, "materialId = ?", new String[]{materialRecord.m6022d()}, "updateTime desc");
            if (a != null) {
                try {
                    if (a.getCount() > 0) {
                        try {
                            a.moveToFirst();
                            String a2 = C1345b.m5934a(a.getString(a.getColumnIndex("htmlStr")));
                            if (a2 != null) {
                                File file = new File(a2);
                                if (!file.exists() || file.length() == 0) {
                                    C1345b.m5937a(file);
                                    c1357a.m5987a(str, "materialId = ?", new String[]{materialRecord.m6022d()});
                                }
                            }
                            z = true;
                            if (a != null) {
                                a.close();
                            }
                        } catch (Exception e) {
                            z = true;
                            try {
                                C1336d.m5888c("MaterialManagerUtil", "query or delete material fail");
                                if (a != null) {
                                    a.close();
                                }
                                return z;
                            } catch (Throwable th2) {
                                th = th2;
                                if (a != null) {
                                    a.close();
                                }
                                throw th;
                            }
                        }
                        return z;
                    }
                } catch (Exception e2) {
                    z = false;
                    C1336d.m5888c("MaterialManagerUtil", "query or delete material fail");
                    if (a != null) {
                        a.close();
                    }
                    return z;
                }
            }
            z = false;
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            a = null;
            z = false;
            C1336d.m5888c("MaterialManagerUtil", "query or delete material fail");
            if (a != null) {
                a.close();
            }
            return z;
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
                a.close();
            }
            throw th;
        }
        return z;
    }

    public static java.util.List<java.lang.String> m5571b(android.content.Context r8) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0062 in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r6 = 0;
        if (r8 != 0) goto L_0x0005;
    L_0x0003:
        r0 = r6;
    L_0x0004:
        return r0;
    L_0x0005:
        r7 = new java.util.ArrayList;
        r0 = 4;
        r7.<init>(r0);
        r0 = com.huawei.openalliance.ad.utils.db.C1357a.m5982a(r8);
        r1 = com.huawei.openalliance.ad.utils.db.bean.MaterialRecord.class;	 Catch:{ Exception -> 0x004f, all -> 0x0066 }
        r1 = r1.getSimpleName();	 Catch:{ Exception -> 0x004f, all -> 0x0066 }
        r2 = 1;	 Catch:{ Exception -> 0x004f, all -> 0x0066 }
        r2 = new java.lang.String[r2];	 Catch:{ Exception -> 0x004f, all -> 0x0066 }
        r3 = 0;	 Catch:{ Exception -> 0x004f, all -> 0x0066 }
        r4 = "materialId";	 Catch:{ Exception -> 0x004f, all -> 0x0066 }
        r2[r3] = r4;	 Catch:{ Exception -> 0x004f, all -> 0x0066 }
        r3 = 0;	 Catch:{ Exception -> 0x004f, all -> 0x0066 }
        r4 = 0;	 Catch:{ Exception -> 0x004f, all -> 0x0066 }
        r5 = 0;	 Catch:{ Exception -> 0x004f, all -> 0x0066 }
        r6 = r0.m5989a(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x004f, all -> 0x0066 }
        if (r6 == 0) goto L_0x0045;	 Catch:{ Exception -> 0x004f, all -> 0x0066 }
    L_0x0026:
        r1 = r6.getCount();	 Catch:{ Exception -> 0x004f, all -> 0x0066 }
        if (r1 <= 0) goto L_0x0045;	 Catch:{ Exception -> 0x004f, all -> 0x0066 }
    L_0x002c:
        r6.moveToFirst();	 Catch:{ Exception -> 0x004f, all -> 0x0066 }
    L_0x002f:
        r1 = "materialId";	 Catch:{ Exception -> 0x004f, all -> 0x0066 }
        r1 = r6.getColumnIndex(r1);	 Catch:{ Exception -> 0x004f, all -> 0x0066 }
        r1 = r6.getString(r1);	 Catch:{ Exception -> 0x004f, all -> 0x0066 }
        r7.add(r1);	 Catch:{ Exception -> 0x004f, all -> 0x0066 }
        r6.moveToNext();	 Catch:{ Exception -> 0x004f, all -> 0x0066 }
        r1 = r6.isAfterLast();	 Catch:{ Exception -> 0x004f, all -> 0x0066 }
        if (r1 == 0) goto L_0x002f;
    L_0x0045:
        if (r6 == 0) goto L_0x004a;
    L_0x0047:
        r6.close();
    L_0x004a:
        r0.close();
    L_0x004d:
        r0 = r7;
        goto L_0x0004;
    L_0x004f:
        r1 = move-exception;
        r1 = "MaterialManagerUtil";	 Catch:{ Exception -> 0x004f, all -> 0x0066 }
        r2 = 1;	 Catch:{ Exception -> 0x004f, all -> 0x0066 }
        r2 = new java.lang.String[r2];	 Catch:{ Exception -> 0x004f, all -> 0x0066 }
        r3 = 0;	 Catch:{ Exception -> 0x004f, all -> 0x0066 }
        r4 = "get cache material ids fail";	 Catch:{ Exception -> 0x004f, all -> 0x0066 }
        r2[r3] = r4;	 Catch:{ Exception -> 0x004f, all -> 0x0066 }
        com.huawei.openalliance.ad.utils.p129b.C1336d.m5888c(r1, r2);	 Catch:{ Exception -> 0x004f, all -> 0x0066 }
        if (r6 == 0) goto L_0x0062;
    L_0x005f:
        r6.close();
    L_0x0062:
        r0.close();
        goto L_0x004d;
    L_0x0066:
        r1 = move-exception;
        if (r6 == 0) goto L_0x006c;
    L_0x0069:
        r6.close();
    L_0x006c:
        r0.close();
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.a.e.h.b(android.content.Context):java.util.List<java.lang.String>");
    }
}
