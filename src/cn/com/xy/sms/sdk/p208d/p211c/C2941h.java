package cn.com.xy.sms.sdk.p208d.p211c;

import android.content.ContentValues;
import cn.com.xy.sms.sdk.p208d.C2922b;
import cn.com.xy.sms.sdk.p208d.C2962e;
import cn.com.xy.sms.sdk.p208d.p210b.C2921a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p216h.p217a.C2994l;
import cn.com.xy.sms.sdk.p229l.C3040e;
import cn.com.xy.sms.sdk.p229l.C3049n;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import java.util.HashMap;
import org.json.JSONArray;

public final class C2941h {
    public static long m13253a(HashMap<String, String> hashMap) {
        String str = (String) hashMap.get("phoneNum");
        String str2 = (String) hashMap.get("companyNum");
        String str3 = (String) hashMap.get("functionMode");
        C2940g c2940g = null;
        try {
            if (!(C3049n.m13653e(str2) || C3049n.m13653e(str3))) {
                c2940g = C2941h.m13255a(str2, str3);
            }
            if (c2940g != null) {
                c2940g.f9978e++;
                C2922b.m13133a("tb_menu_action", C2941h.m13254a(c2940g), "company_num = ? and function_mode = ? and date = ? ", new String[]{c2940g.f9975b, c2940g.f9977d, c2940g.f9976c});
                return 0;
            }
            c2940g = new C2940g();
            c2940g.f9974a = C2994l.m13472a(str);
            c2940g.f9975b = str2;
            c2940g.f9977d = str3;
            c2940g.f9976c = C3040e.m13603a("yyyyMMdd");
            c2940g.f9978e = 1;
            return C2922b.m13135a("tb_menu_action", C2941h.m13254a(c2940g));
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "getSimIndex: " + th.getMessage(), th);
            return -1;
        }
    }

    private static ContentValues m13254a(C2940g c2940g) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Oauth2AccessToken.KEY_PHONE_NUM, c2940g.f9974a);
        contentValues.put("company_num", c2940g.f9975b);
        contentValues.put("date", c2940g.f9976c);
        contentValues.put("function_mode", c2940g.f9977d);
        contentValues.put("click_times", Integer.valueOf(c2940g.f9978e));
        return contentValues;
    }

    private static C2940g m13255a(String str, String str2) {
        C2962e a;
        Throwable th;
        Throwable th2;
        C2962e c2962e = null;
        String a2 = C3040e.m13603a("yyyyMMdd");
        C2940g c2940g;
        try {
            a = C2922b.m13140a("tb_menu_action", new String[]{Oauth2AccessToken.KEY_PHONE_NUM, "company_num", "date", "function_mode", "click_times"}, "company_num = ? and date = ? and function_mode = ? ", new String[]{str, a2, str2}, null, null, null, "1");
            if (a != null) {
                try {
                    if (a.m13323a() > 0) {
                        int a3 = a.m13325a(Oauth2AccessToken.KEY_PHONE_NUM);
                        int a4 = a.m13325a("company_num");
                        int a5 = a.m13325a("date");
                        int a6 = a.m13325a("function_mode");
                        int a7 = a.m13325a("click_times");
                        c2940g = null;
                        while (a.m13327b()) {
                            C2940g c2940g2;
                            try {
                                c2940g2 = new C2940g();
                                c2940g2.f9974a = a.m13328c(a3);
                                c2940g2.f9975b = a.m13328c(a4);
                                c2940g2.f9976c = a.m13328c(a5);
                                c2940g2.f9977d = a.m13328c(a6);
                                c2940g2.f9978e = a.m13324a(a7);
                                c2940g = c2940g2;
                            } catch (Throwable th3) {
                                th2 = th3;
                            }
                            try {
                            } catch (Throwable th32) {
                                th2 = th32;
                            }
                        }
                        C2962e.m13322a(a, true);
                        return c2940g;
                    }
                } catch (Throwable th322) {
                    th2 = th322;
                }
            }
            C2962e.m13322a(a, true);
            return null;
        } catch (Throwable th4) {
            th2 = th4;
            a = null;
            C2962e.m13322a(a, true);
            throw th2;
        }
    }

    public static JSONArray m13256a(String str) {
        C2962e a;
        Throwable th;
        C2962e c2962e = null;
        try {
            a = C2922b.m13140a("tb_menu_action", new String[]{Oauth2AccessToken.KEY_PHONE_NUM, "company_num", "date", "function_mode", "click_times"}, "date < ? ", new String[]{str}, null, null, null, null);
            try {
                JSONArray a2 = C2921a.m13131a(new String[]{Oauth2AccessToken.KEY_PHONE_NUM, "company_num", "date", "function_mode", "click_times"}, a);
                C2962e.m13322a(a, true);
                return a2;
            } catch (Throwable th2) {
                th = th2;
                try {
                    th.printStackTrace();
                    C2962e.m13322a(a, true);
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    c2962e = a;
                    C2962e.m13322a(c2962e, true);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            C2962e.m13322a(c2962e, true);
            throw th;
        }
    }
}
