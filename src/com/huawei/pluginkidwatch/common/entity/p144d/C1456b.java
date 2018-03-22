package com.huawei.pluginkidwatch.common.entity.p144d;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.p140b.C1418a;
import com.huawei.pluginkidwatch.common.lib.p145d.C1455g;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;

/* compiled from: PushRestfulService */
class C1456b implements C1455g {
    final /* synthetic */ String f3343a;
    final /* synthetic */ String f3344b;
    final /* synthetic */ C1418a f3345c;
    final /* synthetic */ C1378e f3346d;
    final /* synthetic */ C1454a f3347e;

    C1456b(C1454a c1454a, String str, String str2, C1418a c1418a, C1378e c1378e) {
        this.f3347e = c1454a;
        this.f3343a = str;
        this.f3344b = str2;
        this.f3345c = c1418a;
        this.f3346d = c1378e;
    }

    public void mo2514a(int i, Object obj) {
        String str;
        String str2 = "";
        try {
            str = new String((byte[]) obj, GameManager.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            C2538c.m12680e("PushRestfulService", "" + e.getMessage());
            str = str2;
        }
        C2538c.m12674b("PushRestfulService", "post return:  url:", this.f3343a, "\n  strBody: ", this.f3344b, "\n response:", str);
        BaseEntityModel a = this.f3345c.mo2511a(str);
        this.f3346d.mo2465a(a);
        this.f3347e.m6693a(a);
    }

    public void mo2515b(int i, Object obj) {
        BaseEntityModel a = this.f3345c.mo2511a("");
        a.retCode = 13201;
        this.f3346d.mo2465a(a);
        this.f3347e.m6693a(a);
    }
}
