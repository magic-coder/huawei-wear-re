package com.huawei.multisimsdk.multidevicemanager.p104c;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.huawei.multisimsdk.multidevicemanager.common.C1149a;
import com.huawei.multisimsdk.multidevicemanager.common.C1150b;
import com.huawei.multisimsdk.multidevicemanager.common.C1157i;
import com.huawei.multisimsdk.multidevicemanager.p103b.C1132a;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1183h;
import com.huawei.multisimsdk.p096a.p098b.C1119a;

/* compiled from: HwMultiDeviceManager */
public class C1139f {
    public static String f2406a = "HwMultiDeviceManager";

    public void m5069a(Context context) {
        if (context == null) {
            C1183h.m5282b(f2406a, "the method param : context is null");
        } else {
            m5070a(context, null, null);
        }
    }

    public void m5070a(Context context, String str, String str2) {
        if (context == null) {
            C1183h.m5282b(f2406a, "the method param : context is null");
            return;
        }
        C1135b.m5057a(context);
        C1132a.m5034a().m5049a(context);
        C1119a.m4985a().m5006a(context);
        C1134a.m5054a(str, str2);
        C1136c.m5058a().m5060a(context);
        C1183h.m5282b(f2406a, "start HwMultiSIMSdk init");
    }

    public void m5068a() {
        C1132a.m5034a().m5052d();
        C1119a.m4985a().m5007b();
        C1183h.m5282b(f2406a, "finish HwMultiSIMSdk exit");
    }

    public void m5072a(C1150b c1150b, C1149a c1149a, Message message, Message message2) {
        m5065a(c1150b, c1149a, message, message2, 100);
    }

    public void m5071a(C1150b c1150b, C1149a c1149a, Message message) {
        m5065a(c1150b, c1149a, message, null, 102);
    }

    public void m5076b(C1150b c1150b, C1149a c1149a, Message message, Message message2) {
        m5065a(c1150b, c1149a, message, message2, 101);
    }

    public void m5073a(String str, Message message) {
        new C1146l(C1132a.m5034a().m5051c(), message).m5119a(str);
    }

    public void m5074a(String str, String str2, String str3, Message message) {
        new C1146l(C1132a.m5034a().m5051c(), message).m5120a(str, str2, str3);
    }

    public int m5067a(Context context, int i) {
        return C1135b.m5055a(context, i);
    }

    public boolean m5075a(Context context, String str) {
        return C1136c.m5058a().m5061a(context, str);
    }

    private void m5065a(C1150b c1150b, C1149a c1149a, Message message, Message message2, int i) {
        Handler b = C1132a.m5034a().m5050b();
        C1157i c1157i = new C1157i();
        if (c1150b != null) {
            String b2 = m5066b(c1150b.m5129c());
            c1157i.m5153a(c1150b.m5128b());
            String a = m5064a(c1150b.m5127a());
            c1157i.m5166g(a);
            c1157i.m5162e(b2);
            if (C1183h.f2599a.booleanValue()) {
                C1183h.m5282b(f2406a, "progressData.getPrimary():" + c1157i.m5150a());
                C1183h.m5282b(f2406a, "progressData.primarytype:" + a);
            }
        }
        if (c1149a != null) {
            c1157i.m5156b(c1149a.m5124b());
            c1157i.m5160d(m5064a(c1149a.m5123a()));
            c1157i.m5158c(c1149a.m5125c());
            c1157i.m5164f(c1149a.m5126d());
            if (C1183h.f2599a.booleanValue()) {
                C1183h.m5282b(f2406a, "SecondaryType:" + c1157i.m5165g());
                C1183h.m5282b(f2406a, "SecondaryID:" + c1157i.m5154b());
            }
        }
        if (message != null) {
            c1157i.m5155b(message);
        }
        if (message2 != null) {
            c1157i.m5152a(message2);
        }
        c1157i.m5151a(i);
        if (b != null) {
            b.sendMessage(b.obtainMessage(i, c1157i));
        }
    }

    private String m5064a(int i) {
        switch (i) {
            case 0:
                return "IMSI";
            case 1:
                return "MSISDN";
            case 2:
                return "ICCID";
            case 3:
                return "EID";
            default:
                return null;
        }
    }

    private String m5066b(int i) {
        switch (i) {
            case 0:
                return "Multi-SIM";
            case 1:
                return "eSIM Profile";
            default:
                return "Multi-SIM";
        }
    }
}
