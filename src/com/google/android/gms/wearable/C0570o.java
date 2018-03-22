package com.google.android.gms.wearable;

import com.google.android.gms.common.api.C0366w;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.C0404l;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.internal.C0554m;
import org.apache.http.cookie.ClientCookie;

public class C0570o extends C0404l<C0552n> implements C0366w {
    private final Status f1076b;

    public C0570o(DataHolder dataHolder) {
        super(dataHolder);
        this.f1076b = new Status(dataHolder.getStatusCode());
    }

    protected /* synthetic */ Object mo2045a(int i, int i2) {
        return m2227b(i, i2);
    }

    protected C0552n m2227b(int i, int i2) {
        return new C0554m(this.a, i, i2);
    }

    protected String mo2046c() {
        return ClientCookie.PATH_ATTR;
    }

    public Status getStatus() {
        return this.f1076b;
    }
}
