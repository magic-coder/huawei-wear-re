package com.huawei.multisimsdk.multidevicemanager.p104c;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.multisimsdk.multidevicemanager.common.C1158j;
import com.huawei.multisimsdk.multidevicemanager.common.C1159k;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1141i;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1176a;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1183h;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1185k;
import java.util.ArrayList;

/* compiled from: SmsAuthen */
class C1146l {
    private static final String f2423a = C1146l.class.getSimpleName();
    private ArrayList f2424b = new ArrayList();
    private ArrayList f2425c = new ArrayList();
    private Message f2426d;
    private String f2427e;
    private String f2428f;
    private Context f2429g;
    private C1141i f2430h = new C1147m(this);
    private C1141i f2431i = new C1148n(this);

    C1146l(Context context, Message message) {
        this.f2429g = context;
        this.f2426d = message;
    }

    void m5119a(String str) {
        if (this.f2429g != null && !C1185k.m5297a(this.f2429g)) {
            C1185k.m5296a(this.f2426d, 1008);
        } else if (!m5113b(str)) {
            C1185k.m5296a(this.f2426d, 1001);
        } else if (C1136c.m5058a().m5061a(this.f2429g, str)) {
            C1176a.m5272a().m5273a(C1135b.m5056a("MSISDN", str), m5115c(str), this.f2430h);
            C1183h.m5282b(f2423a, "startMmsFirstAuthen");
        } else {
            C1185k.m5296a(this.f2426d, 1009);
        }
    }

    private boolean m5113b(String str) {
        if (str != null) {
            return str.matches("^((\\+86)|(86)|(0086))?[1][3456789][0-9]{9}$");
        }
        return false;
    }

    void m5120a(String str, String str2, String str3) {
        if (this.f2426d != null) {
            if (this.f2429g != null && !C1185k.m5297a(this.f2429g)) {
                C1185k.m5296a(this.f2426d, 1008);
            } else if (!m5113b(str)) {
                C1185k.m5296a(this.f2426d, 1001);
            } else if (C1136c.m5058a().m5061a(this.f2429g, str)) {
                m5107a(str, str3);
                String a = C1135b.m5056a("MSISDN", str);
                this.f2428f = str;
                this.f2427e = str3;
                C1176a.m5272a().m5273a(a, m5110b(str, str2), this.f2431i);
                C1183h.m5282b(f2423a, "startMmsSecondAuthen");
            } else {
                C1185k.m5296a(this.f2426d, 1009);
            }
        }
    }

    private void m5107a(String str, String str2) {
        String a;
        if (!TextUtils.isEmpty(C1185k.m5292a(this.f2429g, str, "authen_Token"))) {
            C1183h.m5282b(f2423a, "deleteToken number.");
            a = C1185k.m5292a(this.f2429g, str, "Tag");
            if (!TextUtils.isEmpty(a)) {
                C1185k.m5303c(this.f2429g, a, "authen_Token");
                C1185k.m5303c(this.f2429g, a, "Tag");
                C1185k.m5303c(this.f2429g, str, "Tag");
            }
            C1185k.m5303c(this.f2429g, str, "authen_Token");
        }
        if (!TextUtils.isEmpty(C1185k.m5292a(this.f2429g, str2, "authen_Token"))) {
            C1183h.m5282b(f2423a, "deleteToken imsi.");
            a = C1185k.m5292a(this.f2429g, str2, "Tag");
            if (!TextUtils.isEmpty(a)) {
                C1185k.m5303c(this.f2429g, a, "authen_Token");
                C1185k.m5303c(this.f2429g, a, "Tag");
                C1185k.m5303c(this.f2429g, str2, "Tag");
            }
            C1185k.m5303c(this.f2429g, str2, "authen_Token");
        }
    }

    private void m5106a(Integer num) {
        if (this.f2424b != null && num != null) {
            synchronized (this.f2424b) {
                if (!this.f2424b.contains(num)) {
                    this.f2424b.add(num);
                }
            }
        }
    }

    private boolean m5112b(Integer num) {
        if (!(this.f2424b == null || num == null)) {
            synchronized (this.f2424b) {
                if (this.f2424b.contains(num)) {
                    this.f2424b.remove(num);
                    return true;
                }
            }
        }
        return false;
    }

    private void m5116c(Integer num) {
        if (this.f2425c != null && num != null) {
            synchronized (this.f2425c) {
                if (!this.f2425c.contains(num)) {
                    this.f2425c.add(num);
                }
            }
        }
    }

    private boolean m5118d(Integer num) {
        if (!(this.f2425c == null || num == null)) {
            synchronized (this.f2425c) {
                if (this.f2425c.contains(num)) {
                    this.f2425c.remove(num);
                    return true;
                }
            }
        }
        return false;
    }

    private String m5115c(String str) {
        C1158j c1158j = new C1158j();
        int a = C1185k.m5290a();
        m5106a(Integer.valueOf(a));
        c1158j.m5171a(a);
        c1158j.m5172a("SMSAuth");
        c1158j.m5174b("MTSMS");
        c1158j.m5175c(str);
        return c1158j.m5170a().toString();
    }

    private String m5110b(String str, String str2) {
        C1159k c1159k = new C1159k();
        int a = C1185k.m5290a();
        m5116c(Integer.valueOf(a));
        c1159k.m5178a(a);
        c1159k.m5179a("SMSAuthChallenge");
        c1159k.m5182b(str2);
        c1159k.m5181b(24);
        c1159k.m5183c(str);
        return c1159k.m5177a().toString();
    }
}
