package cn.com.xy.sms.sdk.p208d.p211c;

import android.content.ContentValues;
import cn.com.xy.sms.sdk.p208d.C2922b;
import cn.com.xy.sms.sdk.p208d.C2962e;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p229l.C3049n;

public final class ac {
    public static ab m13219a() {
        C2962e c2962e;
        Throwable th;
        C2962e a;
        try {
            a = C2922b.m13140a("tb_res_download", new String[]{"id", "scene_id", "url", "status", "pos"}, "status= ? and last_load_time < ?", new String[]{"0", new StringBuilder(String.valueOf(System.currentTimeMillis() - 21600000)).toString()}, null, null, "id asc", "1");
            if (a != null) {
                try {
                    if (a.m13323a() > 0) {
                        int a2 = a.m13325a("id");
                        int a3 = a.m13325a("scene_id");
                        int a4 = a.m13325a("status");
                        int a5 = a.m13325a("pos");
                        int a6 = a.m13325a("url");
                        if (a.m13327b()) {
                            long b = a.m13326b(a2);
                            String c = a.m13328c(a3);
                            a4 = a.m13324a(a4);
                            a5 = a.m13324a(a5);
                            String c2 = a.m13328c(a6);
                            ab abVar = new ab();
                            abVar.f9947a = b;
                            abVar.f9948b = c;
                            abVar.f9950d = a4;
                            abVar.f9951e = a5;
                            abVar.f9949c = c2;
                            ac.m13226c(abVar);
                            C2962e.m13322a(a, true);
                            return abVar;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    C2962e.m13322a(a, true);
                    throw th;
                }
            }
            C2962e.m13322a(a, true);
        } catch (Throwable th3) {
            th = th3;
            a = null;
            C2962e.m13322a(a, true);
            throw th;
        }
        return null;
    }

    public static ab m13220a(ab abVar) {
        C2962e c2962e = null;
        try {
            c2962e = C2922b.m13139a("tb_res_download", new String[]{"id", "scene_id", "url", "status", "pos"}, "url = ? ", new String[]{abVar.f9949c});
            if (c2962e == null || c2962e.m13323a() <= 0) {
                long a = C2922b.m13135a("tb_res_download", ac.m13224b(abVar));
                if (a > -1) {
                    abVar.f9947a = a;
                    C2962e.m13322a(c2962e, true);
                    return abVar;
                }
            }
            int a2 = c2962e.m13325a("id");
            int a3 = c2962e.m13325a("scene_id");
            int a4 = c2962e.m13325a("status");
            int a5 = c2962e.m13325a("pos");
            if (c2962e.m13327b()) {
                long b = c2962e.m13326b(a2);
                String c = c2962e.m13328c(a3);
                a3 = c2962e.m13324a(a4);
                a4 = c2962e.m13324a(a5);
                abVar.f9947a = b;
                abVar.f9948b = c;
                abVar.f9950d = a3;
                abVar.f9951e = a4;
                return abVar;
            }
            C2962e.m13322a(c2962e, true);
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "insertOrUpdate: " + th.getMessage(), th);
        } finally {
            C2962e.m13322a(c2962e, true);
        }
        return abVar;
    }

    public static void m13221a(long j, int i) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", Integer.valueOf(1));
            C2922b.m13133a("tb_res_download", contentValues, "id = ? ", new String[]{new StringBuilder(String.valueOf(j)).toString()});
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "updateResdownloadStatus: " + th.getMessage(), th);
        }
    }

    public static void m13222a(ab abVar, long j) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("last_load_time", new StringBuilder(String.valueOf(j)).toString());
            C2922b.m13133a("tb_res_download", contentValues, "id = ? ", new String[]{new StringBuilder(String.valueOf(abVar.f9947a)).toString()});
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "updateLoadTime: " + th.getMessage(), th);
        }
    }

    public static boolean m13223a(String str) {
        if (C3049n.m13653e(str)) {
            return false;
        }
        C2962e c2962e = null;
        try {
            c2962e = C2922b.m13139a("tb_res_download", new String[]{"id", "url", "status"}, "url = ? and status = ?", new String[]{new StringBuilder(String.valueOf(str)).toString(), "1"});
            if (c2962e != null && c2962e.m13323a() > 0) {
                return true;
            }
            C2962e.m13322a(c2962e, true);
            return false;
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "isResDownloaded: " + th.getMessage(), th);
            return false;
        } finally {
            C2962e.m13322a(c2962e, true);
        }
    }

    private static ContentValues m13224b(ab abVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("scene_id", abVar.f9948b);
        contentValues.put("url", abVar.f9949c);
        contentValues.put("status", Integer.valueOf(abVar.f9950d));
        contentValues.put("pos", Integer.valueOf(abVar.f9951e));
        contentValues.put("last_load_time", Integer.valueOf(0));
        return contentValues;
    }

    public static ab m13225b(String str) {
        Throwable th;
        C2962e a;
        try {
            a = C2922b.m13140a("tb_res_download", new String[]{"id", "scene_id", "url", "status", "pos"}, "status= ? and url =? ", new String[]{"0", str}, null, null, "id asc", "1");
            if (a != null) {
                try {
                    if (a.m13323a() > 0) {
                        int a2 = a.m13325a("id");
                        int a3 = a.m13325a("scene_id");
                        int a4 = a.m13325a("status");
                        int a5 = a.m13325a("pos");
                        int a6 = a.m13325a("url");
                        if (a.m13327b()) {
                            long b = a.m13326b(a2);
                            String c = a.m13328c(a3);
                            a4 = a.m13324a(a4);
                            a5 = a.m13324a(a5);
                            String c2 = a.m13328c(a6);
                            ab abVar = new ab();
                            abVar.f9947a = b;
                            abVar.f9948b = c;
                            abVar.f9950d = a4;
                            abVar.f9951e = a5;
                            abVar.f9949c = c2;
                            ac.m13226c(abVar);
                            C2962e.m13322a(a, true);
                            return abVar;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        C2982a.m13415a("XIAOYUAN", "getNeedPriorDownUrlData: " + th.getMessage(), th);
                        C2962e.m13322a(a, true);
                        return null;
                    } catch (Throwable th3) {
                        th = th3;
                        C2962e.m13322a(a, true);
                        throw th;
                    }
                }
            }
            C2962e.m13322a(a, true);
        } catch (Throwable th4) {
            th = th4;
            a = null;
            C2962e.m13322a(a, true);
            throw th;
        }
        return null;
    }

    private static void m13226c(ab abVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("last_load_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
            C2922b.m13133a("tb_res_download", contentValues, "id = ? ", new String[]{new StringBuilder(String.valueOf(abVar.f9947a)).toString()});
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "updateLoadTime: " + th.getMessage(), th);
        }
    }
}
