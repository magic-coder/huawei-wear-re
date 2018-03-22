package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C0424f;
import com.google.android.gms.internal.C0502h;
import com.google.android.gms.wearable.C0527e;
import java.io.InputStream;

final class by extends bu<C0527e> {
    private final C0539c f973a;

    public by(C0502h<C0527e> c0502h, C0539c c0539c) {
        super(c0502h);
        this.f973a = (C0539c) C0424f.m649a((Object) c0539c);
    }

    public void mo1933a(zzax com_google_android_gms_wearable_internal_zzax) {
        InputStream inputStream = null;
        if (com_google_android_gms_wearable_internal_zzax.zzbUv != null) {
            inputStream = new du(new AutoCloseInputStream(com_google_android_gms_wearable_internal_zzax.zzbUv));
            this.f973a.m2015a(inputStream.m2157a());
        }
        m1943a(new dr(new Status(com_google_android_gms_wearable_internal_zzax.statusCode), inputStream));
    }
}
