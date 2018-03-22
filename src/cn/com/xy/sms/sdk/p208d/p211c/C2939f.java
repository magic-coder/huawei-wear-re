package cn.com.xy.sms.sdk.p208d.p211c;

import android.content.ContentValues;
import cn.com.xy.sms.sdk.p208d.C2922b;
import cn.com.xy.sms.sdk.p208d.C2962e;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p229l.C3049n;

public final class C2939f {
    public static C2938e m13248a() {
        C2962e c2962e;
        Throwable th;
        C2962e c2962e2 = null;
        try {
            C2962e a = C2922b.m13140a("tb_xml_res_download", new String[]{"id", "scene_id", "url", "status", "pos", "sceneType"}, "status= ? and last_load_time < ?", new String[]{"0", new StringBuilder(String.valueOf(System.currentTimeMillis() - 21600000)).toString()}, null, null, "id asc", "1");
            if (a != null) {
                try {
                    if (a.m13323a() > 0) {
                        int a2 = a.m13325a("id");
                        int a3 = a.m13325a("scene_id");
                        int a4 = a.m13325a("status");
                        int a5 = a.m13325a("pos");
                        int a6 = a.m13325a("url");
                        int a7 = a.m13325a("sceneType");
                        if (a.m13327b()) {
                            long b = a.m13326b(a2);
                            a.m13328c(a3);
                            a.m13324a(a4);
                            a.m13324a(a5);
                            a3 = a.m13324a(a7);
                            String c = a.m13328c(a6);
                            C2938e c2938e = new C2938e();
                            c2938e.f9971a = b;
                            c2938e.f9972b = c;
                            c2938e.f9973c = a3;
                            C2939f.m13250a(c2938e);
                            C2962e.m13322a(a, true);
                            return c2938e;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    c2962e2 = a;
                    C2962e.m13322a(c2962e2, true);
                    throw th;
                }
            }
            C2962e.m13322a(a, true);
        } catch (Throwable th3) {
            th = th3;
            C2962e.m13322a(c2962e2, true);
            throw th;
        }
        return null;
    }

    public static void m13249a(long j, int i) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", Integer.valueOf(1));
            C2922b.m13133a("tb_xml_res_download", contentValues, "id = ? ", new String[]{new StringBuilder(String.valueOf(j)).toString()});
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "updateXmlResdownloadStatus: " + th.getMessage(), th);
        }
    }

    private static void m13250a(C2938e c2938e) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("last_load_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
            C2922b.m13133a("tb_xml_res_download", contentValues, "id = ? ", new String[]{new StringBuilder(String.valueOf(c2938e.f9971a)).toString()});
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "updateLoadTime: " + th.getMessage(), th);
        }
    }

    public static boolean m13251a(String str) {
        if (C3049n.m13653e(str)) {
            return false;
        }
        C2962e c2962e = null;
        try {
            c2962e = C2922b.m13139a("tb_xml_res_download", new String[]{"id", "url", "status"}, "url = ? and status = ?", new String[]{new StringBuilder(String.valueOf(str)).toString(), "1"});
            if (c2962e != null && c2962e.m13323a() > 0) {
                return true;
            }
            C2962e.m13322a(c2962e, true);
            return false;
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "isXmlResDownloaded: " + th.getMessage(), th);
            return false;
        } finally {
            C2962e.m13322a(c2962e, true);
        }
    }

    public static C2938e m13252b(String str) {
        C2962e a;
        Throwable th;
        try {
            a = C2922b.m13140a("tb_xml_res_download", new String[]{"id", "scene_id", "url", "status", "pos", "sceneType"}, "status= ? and url =? ", new String[]{"0", str}, null, null, "id asc", "1");
            if (a != null) {
                try {
                    if (a.m13323a() > 0) {
                        int a2 = a.m13325a("id");
                        int a3 = a.m13325a("scene_id");
                        int a4 = a.m13325a("status");
                        int a5 = a.m13325a("pos");
                        int a6 = a.m13325a("url");
                        int a7 = a.m13325a("sceneType");
                        if (a.m13327b()) {
                            long b = a.m13326b(a2);
                            a.m13328c(a3);
                            a.m13324a(a4);
                            a.m13324a(a5);
                            a3 = a.m13324a(a7);
                            String c = a.m13328c(a6);
                            C2938e c2938e = new C2938e();
                            c2938e.f9971a = b;
                            c2938e.f9972b = c;
                            c2938e.f9973c = a3;
                            C2939f.m13250a(c2938e);
                            C2962e.m13322a(a, true);
                            return c2938e;
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
}
