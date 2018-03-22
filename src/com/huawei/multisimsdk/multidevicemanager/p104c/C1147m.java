package com.huawei.multisimsdk.multidevicemanager.p104c;

import com.huawei.multisimsdk.multidevicemanager.common.C1165q;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1141i;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1183h;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1185k;

/* compiled from: SmsAuthen */
class C1147m implements C1141i {
    final /* synthetic */ C1146l f2432a;

    C1147m(C1146l c1146l) {
        this.f2432a = c1146l;
    }

    public void mo2360a(String str) {
        C1165q c1165q = new C1165q();
        if (C1185k.m5299a(str)) {
            c1165q.m5213a(str);
        } else {
            c1165q.m5215b(str);
        }
        if (!this.f2432a.m5112b(Integer.valueOf(c1165q.m5211a()))) {
            C1183h.m5282b(C1146l.f2423a, " handle Sms First Authen Response reqsn is error.");
        } else if ("SMSAuth".equals(c1165q.m5216c())) {
            C1183h.m5282b(C1146l.f2423a, " handleSmsFirstAuthenResponse");
            C1185k.m5296a(this.f2432a.f2426d, c1165q.m5214b());
        } else {
            C1183h.m5282b(C1146l.f2423a, " handle Sms First Authen Response reqname is error.");
        }
    }
}
