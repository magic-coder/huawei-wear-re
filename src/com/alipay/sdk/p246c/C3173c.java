package com.alipay.sdk.p246c;

import android.content.pm.Signature;
import android.text.TextUtils;
import com.alipay.sdk.app.p244a.C3149a;

public final class C3173c {
    public Signature[] f10575a;
    public int f10576b;

    public final boolean m14027a() {
        if (this.f10575a == null || this.f10575a.length <= 0) {
            return false;
        }
        int i = 0;
        while (i < this.f10575a.length) {
            String a = C3172b.m14018a(this.f10575a[i].toByteArray());
            if (a == null || TextUtils.equals(a, "b6cbad6cbd5ed0d209afc69ad3b7a617efaae9b3c47eabe0be42d924936fa78c8001b1fd74b079e5ff9690061dacfa4768e981a526b9ca77156ca36251cf2f906d105481374998a7e6e6e18f75ca98b8ed2eaf86ff402c874cca0a263053f22237858206867d210020daa38c48b20cc9dfd82b44a51aeb5db459b22794e2d649")) {
                i++;
            } else {
                C3149a.m13983a("biz", "PublicKeyUnmatch", a);
                return true;
            }
        }
        return false;
    }
}
