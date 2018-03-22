package com.huawei.up.p518c;

import android.content.Context;
import android.os.Bundle;
import com.huawei.p190v.C2538c;
import com.huawei.up.p404b.C4694a;
import com.huawei.up.p519d.C6125a;
import com.unionpay.tsmservice.data.Constant;
import java.io.IOException;
import org.apache.http.cookie.SM;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: UserInfoManager */
class C6122b implements C4694a {
    final /* synthetic */ String f21147a;
    final /* synthetic */ String f21148b;
    final /* synthetic */ Context f21149c;
    final /* synthetic */ String f21150d;
    final /* synthetic */ String f21151e;
    final /* synthetic */ C4694a f21152f;
    final /* synthetic */ C6121a f21153g;

    C6122b(C6121a c6121a, String str, String str2, Context context, String str3, String str4, C4694a c4694a) {
        this.f21153g = c6121a;
        this.f21147a = str;
        this.f21148b = str2;
        this.f21149c = context;
        this.f21150d = str3;
        this.f21151e = str4;
        this.f21152f = c4694a;
    }

    public void mo4558a(Bundle bundle) {
        String a = this.f21153g.m27884a("getUserInfo", this.f21147a, this.f21148b);
        C6125a c6125a = new C6125a(this.f21149c);
        String string = bundle.getString(SM.SET_COOKIE, "");
        C2538c.b("UserInfoManager", new Object[]{"sessionID1 = " + string});
        if (string != null && !"".equals(string)) {
            c6125a.m27902f(string);
            new C6123c(this, string).start();
        } else if (this.f21150d != null) {
            c6125a.m27902f(this.f21150d);
        }
        if (this.f21148b != null) {
            c6125a.m27898b(this.f21148b);
        }
        if (this.f21151e != null) {
            c6125a.m27899c(this.f21151e);
        }
        if (this.f21151e != null) {
            c6125a.m27899c(this.f21151e);
        }
        c6125a.m27901e(a);
        try {
            Bundle a2 = c6125a.m27896a(c6125a.mo5139d(c6125a.m27897a()));
            if (this.f21152f != null) {
                a2.putString(Constant.KEY_METHOD, "getUserInfo");
                this.f21152f.mo4558a(a2);
            }
        } catch (IOException e) {
            C2538c.e("UserInfoManager", new Object[]{"Exception error = " + e.getMessage()});
        } catch (XmlPullParserException e2) {
            C2538c.e("UserInfoManager", new Object[]{"Exception error = " + e2.getMessage()});
        }
    }

    public void mo4557a(int i) {
        if (this.f21152f != null) {
            this.f21152f.mo4557a(-1);
        }
    }
}
