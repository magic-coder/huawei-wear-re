package com.huawei.multisimsdk.multidevicemanager.p104c;

import com.huawei.multisimsdk.multidevicemanager.common.C1166r;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1141i;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1183h;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1185k;

/* compiled from: SmsAuthen */
class C1148n implements C1141i {
    final /* synthetic */ C1146l f2433a;

    C1148n(C1146l c1146l) {
        this.f2433a = c1146l;
    }

    public void mo2360a(String str) {
        C1166r c1166r = new C1166r();
        if (C1185k.m5299a(str)) {
            c1166r.m5218a(str);
        } else {
            c1166r.m5220b(str);
        }
        if (!this.f2433a.m5118d(Integer.valueOf(c1166r.m5217a()))) {
            C1183h.m5282b(C1146l.f2423a, "handle Sms second challenge Response reqsn is error.");
        } else if ("SMSAuthChallenge".equals(c1166r.m5222d())) {
            if (1000 == c1166r.m5219b()) {
                if (this.f2433a.f2427e != null) {
                    C1185k.m5298a(this.f2433a.f2429g, this.f2433a.f2427e, "authen_Token", c1166r.m5221c());
                }
                if (this.f2433a.f2428f != null) {
                    C1185k.m5298a(this.f2433a.f2429g, this.f2433a.f2428f, "authen_Token", c1166r.m5221c());
                }
                if (!(this.f2433a.f2428f == null || this.f2433a.f2427e == null)) {
                    C1185k.m5300b(this.f2433a.f2429g, this.f2433a.f2428f, this.f2433a.f2427e);
                }
                C1183h.m5282b(C1146l.f2423a, "handle second response success");
            }
            if (this.f2433a.f2426d != null) {
                C1185k.m5296a(this.f2433a.f2426d, c1166r.m5219b());
            }
        } else {
            C1183h.m5282b(C1146l.f2423a, "handle Sms second challenge Response reqname is error.");
        }
    }
}
