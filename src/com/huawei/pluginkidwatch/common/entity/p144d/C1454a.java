package com.huawei.pluginkidwatch.common.entity.p144d;

import android.content.Context;
import com.huawei.hwcloudmodel.c.p;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.login.ui.login.C1093a;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.p140b.C1418a;
import com.huawei.pluginkidwatch.common.lib.p145d.C1469a;
import java.util.Locale;

/* compiled from: PushRestfulService */
public class C1454a {
    private Context f3341a;
    private C1469a f3342b = new C1469a(this.f3341a);

    public C1454a(Context context) {
        this.f3341a = context.getApplicationContext();
    }

    public static String m6691a() {
        return "https://api.vmall.com";
    }

    public void m6695a(C1418a c1418a, C1378e c1378e) {
        m6694a(C1454a.m6691a() + c1418a.f3234a, c1418a.mo2512a(), c1378e, c1418a);
    }

    private void m6694a(String str, String str2, C1378e c1378e, C1418a c1418a) {
        this.f3342b.m6796a(str, str2, new C1456b(this, str, str2, c1418a, c1378e));
    }

    private void m6693a(BaseEntityModel baseEntityModel) {
        if (baseEntityModel.retCode == -1 && baseEntityModel.error != null && baseEntityModel.error.toLowerCase(Locale.ENGLISH).indexOf("session") > -1) {
            String f = C1093a.m4739a(BaseApplication.m2632b()).m4753f();
            C2538c.m12674b("PushRestfulService", "session expire, tokenBefore = " + f);
            new p(this.f3341a).c();
            f = C1093a.m4739a(BaseApplication.m2632b()).m4753f();
            C2538c.m12674b("PushRestfulService", "session fresh, tokenAfter = " + f);
        }
    }
}
