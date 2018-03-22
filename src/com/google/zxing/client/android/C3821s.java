package com.google.zxing.client.android;

import android.app.ProgressDialog;
import android.content.Context;

/* compiled from: QRProgressDialog */
public class C3821s {
    private ProgressDialog f14834a;

    public C3821s(Context context, String str, String str2, C3809t c3809t) {
        m19073a(context, str, str2, false, c3809t);
    }

    private void m19073a(Context context, String str, String str2, boolean z, C3809t c3809t) {
        this.f14834a = new C3822u(context, z, c3809t);
        if (str != null) {
            this.f14834a.setTitle(str);
        }
        this.f14834a.setMessage(str2);
    }

    public void m19074a() {
        if (this.f14834a != null && !this.f14834a.isShowing()) {
            this.f14834a.setCanceledOnTouchOutside(false);
            this.f14834a.show();
        }
    }

    public void m19075b() {
        if (this.f14834a != null && this.f14834a.isShowing()) {
            this.f14834a.dismiss();
        }
    }
}
