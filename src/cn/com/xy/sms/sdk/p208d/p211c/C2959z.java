package cn.com.xy.sms.sdk.p208d.p211c;

import android.content.ContentValues;
import cn.com.xy.sms.sdk.p208d.C2922b;
import cn.com.xy.sms.sdk.p208d.C2962e;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p229l.C3040e;
import cn.com.xy.sms.sdk.p229l.C3041f;
import cn.com.xy.sms.sdk.p229l.C3049n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class C2959z {
    public static long m13308a(HashMap<String, String> hashMap) {
        C2958y c2958y = null;
        String str = (String) hashMap.get("titleNo");
        try {
            if (!C3049n.m13653e(str)) {
                c2958y = C2959z.m13313c(str);
            }
            if (c2958y != null) {
                c2958y.f10036c++;
                C2922b.m13133a("tb_popup_action_scene", C2959z.m13309a(c2958y), "scene_id = ? and date = ? ", new String[]{c2958y.f10034a, c2958y.f10035b});
                return 0;
            }
            c2958y = new C2958y();
            c2958y.f10034a = str;
            c2958y.f10035b = C3040e.m13603a("yyyyMMdd");
            c2958y.f10036c = 1;
            long a = C2922b.m13135a("tb_popup_action_scene", C2959z.m13309a(c2958y));
            C3041f.m13609b().m13100a(str, "-2", null);
            return a;
        } catch (Throwable th) {
            Throwable th2 = th;
            long j = -1;
            Throwable th3 = th2;
            C2982a.m13415a("XIAOYUAN", "insertOrUpdateParse: " + th3.getMessage(), th3);
            return j;
        }
    }

    private static ContentValues m13309a(C2958y c2958y) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("scene_id", c2958y.f10034a);
        contentValues.put("date", c2958y.f10035b);
        contentValues.put("parse_times", Integer.valueOf(c2958y.f10036c));
        contentValues.put("popup_times", Integer.valueOf(c2958y.f10037d));
        return contentValues;
    }

    public static List<C2958y> m13310a(String str) {
        Throwable th;
        List<C2958y> arrayList = new ArrayList();
        C2962e a;
        try {
            a = C2922b.m13140a("tb_popup_action_scene", new String[]{"date"}, "date < ? ", new String[]{str}, "date", null, null, null);
            if (a != null) {
                try {
                    if (a.m13323a() > 0) {
                        int a2 = a.m13325a("date");
                        while (a.m13327b()) {
                            C2958y c2958y = new C2958y();
                            c2958y.f10035b = a.m13328c(a2);
                            arrayList.add(c2958y);
                        }
                        C2962e.m13322a(a, true);
                        return arrayList;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            C2962e.m13322a(a, true);
        } catch (Throwable th3) {
            th = th3;
            a = null;
            C2962e.m13322a(a, true);
            throw th;
        }
        return arrayList;
    }

    public static long m13311b(HashMap<String, String> hashMap) {
        String str = (String) hashMap.get("titleNo");
        C2958y c2958y = null;
        try {
            if (!C3049n.m13653e(str)) {
                c2958y = C2959z.m13313c(str);
            }
            if (c2958y != null) {
                c2958y.f10037d++;
                C2922b.m13133a("tb_popup_action_scene", C2959z.m13309a(c2958y), "scene_id = ? and date = ? ", new String[]{c2958y.f10034a, c2958y.f10035b});
                return 0;
            }
            c2958y = new C2958y();
            c2958y.f10034a = str;
            c2958y.f10035b = C3040e.m13603a("yyyyMMdd");
            c2958y.f10037d = 1;
            return C2922b.m13135a("tb_popup_action_scene", C2959z.m13309a(c2958y));
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "insertOrUpdatePopup: " + th.getMessage(), th);
            return -1;
        }
    }

    public static List<C2958y> m13312b(String str) {
        Throwable th;
        List<C2958y> arrayList = new ArrayList();
        C2962e a;
        try {
            a = C2922b.m13140a("tb_popup_action_scene", new String[]{"scene_id", "date", "parse_times", "popup_times"}, "date = ? ", new String[]{str}, null, null, null, null);
            if (a != null) {
                try {
                    if (a.m13323a() > 0) {
                        int a2 = a.m13325a("scene_id");
                        int a3 = a.m13325a("date");
                        int a4 = a.m13325a("parse_times");
                        int a5 = a.m13325a("popup_times");
                        while (a.m13327b()) {
                            C2958y c2958y = new C2958y();
                            c2958y.f10034a = a.m13328c(a2);
                            c2958y.f10035b = a.m13328c(a3);
                            c2958y.f10036c = a.m13324a(a4);
                            c2958y.f10037d = a.m13324a(a5);
                            arrayList.add(c2958y);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            C2962e.m13322a(a, true);
        } catch (Throwable th3) {
            th = th3;
            a = null;
            C2962e.m13322a(a, true);
            throw th;
        }
        return arrayList;
    }

    private static C2958y m13313c(String str) {
        C2958y c2958y;
        C2958y c2958y2;
        Throwable th;
        Throwable th2;
        C2962e c2962e = null;
        String a = C3040e.m13603a("yyyyMMdd");
        try {
            C2962e a2 = C2922b.m13140a("tb_popup_action_scene", new String[]{"scene_id", "date", "parse_times", "popup_times"}, "scene_id = ? and date = ? ", new String[]{str, a}, null, null, null, "1");
            if (a2 != null) {
                try {
                    if (a2.m13323a() > 0) {
                        int a3 = a2.m13325a("scene_id");
                        int a4 = a2.m13325a("date");
                        int a5 = a2.m13325a("parse_times");
                        int a6 = a2.m13325a("popup_times");
                        c2958y = null;
                        while (a2.m13327b()) {
                            try {
                                try {
                                    c2958y2 = new C2958y();
                                    c2958y2.f10034a = a2.m13328c(a3);
                                    c2958y2.f10035b = a2.m13328c(a4);
                                    c2958y2.f10036c = a2.m13324a(a5);
                                    c2958y2.f10037d = a2.m13324a(a6);
                                    c2958y = c2958y2;
                                } catch (Throwable th3) {
                                    th2 = th3;
                                    c2962e = a2;
                                }
                            } catch (Throwable th32) {
                                th2 = th32;
                                c2962e = a2;
                            }
                        }
                        C2962e.m13322a(a2, true);
                        return c2958y;
                    }
                } catch (Throwable th322) {
                    th2 = th322;
                    c2962e = a2;
                }
            }
            C2962e.m13322a(a2, true);
            return null;
        } catch (Throwable th22) {
            th = th22;
            c2958y = null;
            C2982a.m13415a("XIAOYUAN", "queryInfoBySceneId: " + th.getMessage(), th);
            C2962e.m13322a(c2962e, true);
            return c2958y;
        }
    }
}
