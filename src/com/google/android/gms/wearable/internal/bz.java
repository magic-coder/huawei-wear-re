package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C0424f;
import com.google.android.gms.internal.C0502h;
import com.google.android.gms.wearable.C0528f;
import java.io.OutputStream;

final class bz extends bu<C0528f> {
    private final C0539c f974a;

    public bz(C0502h<C0528f> c0502h, C0539c c0539c) {
        super(c0502h);
        this.f974a = (C0539c) C0424f.m649a((Object) c0539c);
    }

    public void mo1934a(zzaz com_google_android_gms_wearable_internal_zzaz) {
        OutputStream outputStream = null;
        if (com_google_android_gms_wearable_internal_zzaz.zzbUv != null) {
            outputStream = new dw(new AutoCloseOutputStream(com_google_android_gms_wearable_internal_zzaz.zzbUv));
            this.f974a.m2015a(outputStream.m2161a());
        }
        m1943a(new ds(new Status(com_google_android_gms_wearable_internal_zzaz.statusCode), outputStream));
    }
}
