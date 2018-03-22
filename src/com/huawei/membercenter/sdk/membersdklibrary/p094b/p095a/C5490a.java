package com.huawei.membercenter.sdk.membersdklibrary.p094b.p095a;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.membercenter.sdk.membersdklibrary.b.a.d;
import com.huawei.membercenter.sdk.membersdklibrary.p092a.p093c.C5475d.C5477a;
import com.huawei.membercenter.sdk.membersdklibrary.p092a.p093c.C5476c;
import com.huawei.membercenter.sdk.membersdklibrary.p092a.p472d.C5486h;

/* compiled from: AbsHttpProcessor */
public abstract class C5490a {
    protected String f19354a;
    protected Context f19355b;

    protected abstract d mo4699a(String str);

    protected abstract boolean mo4701b();

    protected C5490a(String str, Context context) {
        this.f19354a = str;
        this.f19355b = context;
    }

    public d m26218a() {
        try {
            C5477a a = new C5476c(this.f19355b, this.f19354a, mo4700a(this.f19355b), true, mo4701b()).m26176a();
            if (!(a == null || TextUtils.isEmpty(a.m26177a()))) {
                return mo4699a(a.m26177a());
            }
        } catch (Exception e) {
            C5486h.m26202a(e, "AbsHttpProcessor");
        } catch (Exception e2) {
            C5486h.m26202a(e2, "AbsHttpProcessor");
        } catch (Exception e22) {
            C5486h.m26202a(e22, "AbsHttpProcessor");
        }
        d dVar = new d();
        dVar.a("-1");
        dVar.b("unknown error!");
        return dVar;
    }

    protected Object mo4700a(Context context) {
        return null;
    }
}
