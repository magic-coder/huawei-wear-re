package cn.com.xy.sms.sdk.p208d;

import android.content.ContentValues;
import cn.com.xy.sms.sdk.p205a.C2904g;
import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p208d.p211c.C2953t;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p216h.C2996a;
import cn.com.xy.sms.sdk.p216h.p217a.C2991i;
import cn.com.xy.sms.sdk.p229l.C3042g;
import cn.com.xy.sms.sdk.p229l.C3049n;
import cn.com.xy.sms.sdk.p229l.C3050o;
import cn.com.xy.sms.sdk.p229l.C3055t;
import java.util.Map;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public final class C2970m {
    public static C2953t m13338a(String str) {
        Document a = C3049n.m13643a(str, "");
        if (a == null) {
            return null;
        }
        long parseLong;
        C2953t c2953t = new C2953t();
        String str2 = "";
        Element documentElement = a.getDocumentElement();
        NodeList elementsByTagName = documentElement.getElementsByTagName("PublicInfoVersion");
        if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
            str2 = C3042g.m13612a(elementsByTagName.item(0));
            if (C3049n.m13653e(str2)) {
                str2 = "";
            }
        }
        c2953t.f10025b = str2;
        str2 = "";
        elementsByTagName = documentElement.getElementsByTagName("downLoadUrl");
        if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
            str2 = C3042g.m13612a(elementsByTagName.item(0));
            if (C3049n.m13653e(str2)) {
                str2 = "";
            }
        }
        c2953t.f10026c = str2;
        NodeList elementsByTagName2 = documentElement.getElementsByTagName("delaystart");
        if (elementsByTagName2 != null && elementsByTagName2.getLength() > 0) {
            str2 = C3042g.m13612a(elementsByTagName2.item(0));
            if (!C3049n.m13653e(str2)) {
                try {
                    parseLong = Long.parseLong(str2);
                } catch (Throwable th) {
                    C2982a.m13415a("XIAOYUAN", "parseMenuSubInfo: " + th.getMessage(), th);
                    return null;
                }
                c2953t.f10029f = parseLong;
                elementsByTagName2 = documentElement.getElementsByTagName("delayend");
                if (elementsByTagName2 != null && elementsByTagName2.getLength() > 0) {
                    str2 = C3042g.m13612a(elementsByTagName2.item(0));
                    if (!C3049n.m13653e(str2)) {
                        try {
                            parseLong = Long.parseLong(str2);
                        } catch (Throwable th2) {
                            C2982a.m13415a("XIAOYUAN", "updateMenuInfo: " + th2.getMessage(), th2);
                        }
                        if (parseLong <= 0) {
                            parseLong = 86400000;
                        }
                        c2953t.f10030g = parseLong;
                        return c2953t;
                    }
                }
                parseLong = 0;
                if (parseLong <= 0) {
                    parseLong = 86400000;
                }
                c2953t.f10030g = parseLong;
                return c2953t;
            }
        }
        parseLong = 0;
        c2953t.f10029f = parseLong;
        elementsByTagName2 = documentElement.getElementsByTagName("delayend");
        str2 = C3042g.m13612a(elementsByTagName2.item(0));
        if (C3049n.m13653e(str2)) {
            parseLong = Long.parseLong(str2);
            if (parseLong <= 0) {
                parseLong = 86400000;
            }
            c2953t.f10030g = parseLong;
            return c2953t;
        }
        parseLong = 0;
        if (parseLong <= 0) {
            parseLong = 86400000;
        }
        c2953t.f10030g = parseLong;
        return c2953t;
    }

    public static void m13339a() {
        try {
            C2970m.m13345c("pubInfo");
            C2970m.m13345c("pubNum");
            C2970m.m13345c("pubMenu");
            C2960c.m13319b(C2917a.m13105a());
        } catch (Throwable th) {
            C2982a.m13415a("xiaoyuan", "insertMenuData error： " + th.getMessage(), th);
        }
    }

    public static void m13340a(C2953t c2953t) {
        String str = "duoqu_nqsql.zip";
        try {
            new StringBuilder("超过周期，启动下载 name=").append(c2953t.f10024a).append(" url=").append(c2953t.f10026c);
            if (C3049n.m13653e(c2953t.f10026c)) {
                try {
                    C3055t.m13709c(C2917a.m13112e() + str);
                    return;
                } catch (Throwable th) {
                    C2982a.m13415a("XIAOYUAN", "downloadMenuInfoNow deleteFile error:" + th.getMessage(), th);
                    return;
                }
            }
            String str2 = "menu.sql";
            if (C3055t.m13715f(c2953t.f10026c, C2917a.m13112e(), str) == -1) {
                C2982a.m13414a("XIAOYUAN", new StringBuilder(String.valueOf(str)).append(" 下载失败").toString());
                try {
                    C3055t.m13709c(C2917a.m13112e() + str);
                } catch (Throwable th2) {
                    C2982a.m13415a("XIAOYUAN", "downloadMenuInfoNow deleteFile error:" + th2.getMessage(), th2);
                }
            } else if (C3050o.m13676a(C2917a.m13112e() + str, C2917a.m13114g())) {
                str2 = C2917a.m13114g() + str2;
                if (C3055t.m13704a(str2)) {
                    C2970m.m13339a();
                    new StringBuilder("updateLastLoadTime").append(c2953t.f10024a);
                    str2 = c2953t.f10024a;
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("last_load_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
                    contentValues.put("status", new StringBuilder("1").toString());
                    C2922b.m13133a("tb_menu_list", contentValues, "name = ? ", new String[]{str2});
                    try {
                        C3055t.m13709c(C2917a.m13112e() + str);
                        return;
                    } catch (Throwable th22) {
                        C2982a.m13415a("XIAOYUAN", "downloadMenuInfoNow deleteFile error:" + th22.getMessage(), th22);
                        return;
                    }
                }
                C2982a.m13414a("XIAOYUAN", new StringBuilder(String.valueOf(str2)).append("文件不存在").toString());
                try {
                    C3055t.m13709c(C2917a.m13112e() + str);
                } catch (Throwable th222) {
                    C2982a.m13415a("XIAOYUAN", "downloadMenuInfoNow deleteFile error:" + th222.getMessage(), th222);
                }
            } else {
                C2982a.m13414a("XIAOYUAN", "解压zip到nqsql文件里面失败");
                try {
                    C3055t.m13709c(C2917a.m13112e() + str);
                } catch (Throwable th2222) {
                    C2982a.m13415a("XIAOYUAN", "downloadMenuInfoNow deleteFile error:" + th2222.getMessage(), th2222);
                }
            }
        } catch (Throwable th22222) {
            try {
                C2982a.m13415a("XIAOYUAN", "downloadMenuInfoNow error:" + th22222.getMessage(), th22222);
                C3055t.m13709c(C2917a.m13112e() + str);
            } catch (Throwable th222222) {
                C2982a.m13415a("XIAOYUAN", "downloadMenuInfoNow deleteFile error:" + th222222.getMessage(), th222222);
            }
        }
    }

    public static void m13341a(C2953t c2953t, C2904g c2904g, boolean z, Map<String, String> map) {
        try {
            C2904g c2971n = new C2971n(z, map, c2953t, c2904g);
            if (C2996a.m13494a((Map) map)) {
                String str = c2953t.f10025b;
                String str2 = c2953t.f10024a;
                str = C2991i.m13446a(str, c2953t.f10028e, c2953t.f10031h);
                if (!C3049n.m13653e(str)) {
                    C2996a.m13486a("", str, c2971n, C2996a.m13501d() + "updatepublic", (Map) map);
                }
            }
            String str3 = c2953t.f10024a;
            int i = c2953t.f10031h;
            ContentValues contentValues = new ContentValues();
            contentValues.put("count", Integer.valueOf(i + 1));
            C2922b.m13133a("tb_menu_list", contentValues, "name = ? ", new String[]{str3});
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "updateMenuInfo: " + th.getMessage(), th);
        }
    }

    public static C2953t m13342b() {
        C2962e a;
        Throwable th;
        try {
            a = C2922b.m13139a("tb_menu_list", new String[]{"id", "name", "version", "url", "status", "last_load_time", "update_time", "delaystart", "delayend", "count"}, null, null);
            if (a != null) {
                try {
                    if (a.m13323a() > 0) {
                        int a2 = a.m13325a("id");
                        int a3 = a.m13325a("name");
                        int a4 = a.m13325a("version");
                        int a5 = a.m13325a("url");
                        int a6 = a.m13325a("status");
                        int a7 = a.m13325a("last_load_time");
                        int a8 = a.m13325a("update_time");
                        int a9 = a.m13325a("delaystart");
                        int a10 = a.m13325a("delayend");
                        int a11 = a.m13325a("count");
                        if (a.m13327b()) {
                            C2953t c2953t = new C2953t();
                            a.m13326b(a2);
                            c2953t.f10024a = a.m13328c(a3);
                            c2953t.f10025b = a.m13328c(a4);
                            c2953t.f10026c = a.m13328c(a5);
                            c2953t.f10028e = a.m13324a(a6);
                            a.m13326b(a7);
                            c2953t.f10027d = a.m13326b(a8);
                            c2953t.f10029f = a.m13326b(a9);
                            c2953t.f10030g = a.m13326b(a10);
                            c2953t.f10031h = a.m13324a(a11);
                            C2962e.m13322a(a, true);
                            return c2953t;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        C2982a.m13415a("XIAOYUAN", "queryMenuInfo: " + th.getMessage(), th);
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

    public static void m13343b(C2953t c2953t) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            new StringBuilder("检查下载时间menuInfo.delaystart=").append(c2953t.f10029f).append("menuInfo.delayend=").append(c2953t.f10030g).append("nowTime=").append(currentTimeMillis).append(" menuInfo.status=").append(c2953t.f10028e);
            if (c2953t.f10028e == 0 && c2953t.f10029f <= currentTimeMillis && c2953t.f10030g >= currentTimeMillis) {
                C2970m.m13340a(c2953t);
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "downloadMenuInfo: " + th.getMessage(), th);
        }
    }

    public static synchronized void m13344b(String str) {
        synchronized (C2970m.class) {
            try {
                C2962e a = C2922b.m13139a("tb_menu_list", new String[]{"url", "version"}, "name = ? ", new String[]{str});
                if (a == null || a.m13323a() <= 0) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("name", str);
                    contentValues.put("version", "-1");
                    C2922b.m13135a("tb_menu_list", contentValues);
                }
                C2962e.m13322a(a, true);
            } catch (Throwable th) {
                C2962e.m13322a(null, true);
            }
        }
    }

    private static void m13345c(String str) {
        String str2 = "";
        if (!C3049n.m13653e(str)) {
            if (str.equalsIgnoreCase("pubInfo")) {
                str2 = "tb_public_info";
            } else if (str.equalsIgnoreCase("pubNum")) {
                str2 = "tb_public_num_info";
            } else if (str.equalsIgnoreCase("pubMenu")) {
                str2 = "tb_public_menu_info";
            }
            if (!C3049n.m13653e(str2)) {
                try {
                    C2922b.m13134a(str2, null, null);
                } catch (Throwable th) {
                    C2982a.m13415a("XIAOYUAN", "deletePubInfoOrNumOrMenu: " + th.getMessage(), th);
                }
            }
        }
    }
}
