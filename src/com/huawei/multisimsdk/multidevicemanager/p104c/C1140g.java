package com.huawei.multisimsdk.multidevicemanager.p104c;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.huawei.multisimsdk.multidevicemanager.common.C1161m;
import com.huawei.multisimsdk.multidevicemanager.common.C1162n;
import com.huawei.multisimsdk.multidevicemanager.common.C1163o;
import com.huawei.multisimsdk.multidevicemanager.common.C1165q;
import com.huawei.multisimsdk.multidevicemanager.common.C1169u;
import com.huawei.multisimsdk.multidevicemanager.common.C1170v;
import com.huawei.multisimsdk.multidevicemanager.common.InProgressData;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1141i;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1176a;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1183h;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1185k;
import com.huawei.multisimsdk.multidevicemanager.ui.SignWebActivity;
import net.sqlcipher.database.SQLiteDatabase;

/* compiled from: MultiDeviceWebManager */
public class C1140g {
    private static final String f2407a = C1140g.class.getSimpleName();
    private Context f2408b;
    private InProgressData f2409c;
    private C1141i f2410d = new C1142h(this);

    public C1140g(Context context) {
        if (context != null) {
            this.f2408b = context.getApplicationContext();
        }
    }

    public void m5084a(InProgressData inProgressData) {
        this.f2409c = inProgressData;
    }

    public void m5083a() {
        if (this.f2409c == null) {
            return;
        }
        if (100 == this.f2409c.getType()) {
            m5085b();
        } else {
            m5086c();
        }
    }

    public void m5085b() {
        C1176a.m5272a().m5273a(C1185k.m5293a(this.f2409c), m5079a(1), this.f2410d);
    }

    private String m5079a(int i) {
        C1163o c1163o = new C1163o();
        C1162n c1162n = new C1162n();
        String str = null;
        c1163o.m5205a(C1185k.m5290a());
        if (this.f2409c != null) {
            if (1 == i) {
                c1162n.m5198a("Binding");
                c1162n.m5203f(this.f2409c.getNikename());
            } else if (2 == i) {
                c1162n.m5198a("Unbinding");
            }
            str = this.f2409c.getPrimary();
            c1162n.m5199b(this.f2409c.getPrimaryIDtype());
            c1162n.m5200c(str);
            c1162n.m5201d(this.f2409c.getSecondarytype());
            c1162n.m5202e(this.f2409c.getSecondaryID());
            c1163o.m5208b(str);
            c1163o.m5207a(this.f2409c.getPrimaryIDtype());
            c1163o.m5209c(this.f2409c.getServiceType());
        }
        c1163o.m5206a(c1162n);
        C1161m c1161m = new C1161m();
        c1161m.m5196a(c1163o);
        c1161m.m5194a(C1185k.m5291a(this.f2408b, str));
        return c1161m.m5193a();
    }

    private void m5082a(String str) {
        Uri uri = null;
        try {
            uri = Uri.parse(str);
        } catch (NullPointerException e) {
            C1183h.m5284c(f2407a, "uri is null");
        }
        Intent intent = new Intent();
        intent.setClass(this.f2408b, SignWebActivity.class);
        intent.setData(uri);
        Bundle bundle = new Bundle();
        bundle.putParcelable("sms_data", this.f2409c);
        intent.putExtras(bundle);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        C1183h.m5282b(f2407a, "startShowWsApplyActivity");
        try {
            if (this.f2408b != null) {
                this.f2408b.startActivity(intent);
            }
        } catch (ActivityNotFoundException e2) {
            C1183h.m5284c(f2407a, "startShowWsApplyActivity: startActivity failed" + e2);
        }
    }

    public void m5086c() {
        C1176a.m5272a().m5273a(C1185k.m5293a(this.f2409c), m5079a(2), this.f2410d);
    }

    private Boolean m5078a(C1165q c1165q) {
        if (c1165q != null) {
            int b = c1165q.m5214b();
            if (this.f2409c != null) {
                this.f2409c.setResultcode(b);
            }
            C1183h.m5282b(f2407a, "handlerQuickAuthenResult.getResultcode()=" + b);
            if (1000 == b) {
                C1183h.m5282b(f2407a, "TokenAuthen is valid");
                return Boolean.valueOf(true);
            } else if (1004 == b) {
                C1183h.m5282b(f2407a, "TokenAuthen is invalid");
                C1185k.m5294a(107, this.f2409c);
                return Boolean.valueOf(false);
            } else {
                C1183h.m5282b(f2407a, "TokenAuthen is fail");
                C1185k.m5294a(106, this.f2409c);
                return Boolean.valueOf(false);
            }
        }
        C1183h.m5282b(f2407a, "responseAuthFirstInfo is null");
        return Boolean.valueOf(false);
    }

    private void m5081a(C1170v c1170v) {
        if (c1170v != null) {
            int a = c1170v.m5236a();
            if (this.f2409c != null) {
                this.f2409c.setResultcode(a);
            }
            C1183h.m5282b(f2407a, "responseServiceProvisionInfo.getResultcode()=" + a);
            if (2000 == a) {
                C1169u b = c1170v.m5238b();
                if (b != null) {
                    String a2 = b.m5232a();
                    String b2 = b.m5234b();
                    if (C1183h.f2599a.booleanValue()) {
                        C1183h.m5282b(f2407a, "MultiServiceResponseHandler:url =" + a2 + "   postdata=" + b2);
                    }
                    if (this.f2409c != null) {
                        this.f2409c.setTime(b.m5235c());
                    }
                    m5082a(a2);
                    return;
                }
                C1183h.m5282b(f2407a, "responseMultiSIMService is null");
                C1185k.m5294a(115, this.f2409c);
                return;
            }
            C1183h.m5282b(f2407a, "responseServiceProvisionInfo.getResultcode() is no success");
            C1185k.m5294a(115, this.f2409c);
            return;
        }
        C1183h.m5282b(f2407a, "responseServiceProvisionInfo is null");
        if (this.f2409c != null) {
            this.f2409c.setResultcode(99);
        }
        C1185k.m5294a(115, this.f2409c);
    }
}
