package com.google.android.gms.wearable.internal;

import com.google.android.gms.internal.C0502h;
import com.google.android.gms.wearable.C0548k;
import java.util.List;
import java.util.concurrent.FutureTask;

final class cd extends bu<C0548k> {
    private final List<FutureTask<Boolean>> f978a;

    cd(C0502h<C0548k> c0502h, List<FutureTask<Boolean>> list) {
        super(c0502h);
        this.f978a = list;
    }

    public void mo1945a(zzci com_google_android_gms_wearable_internal_zzci) {
        m1943a(new C0549j(bp.m2004a(com_google_android_gms_wearable_internal_zzci.statusCode), com_google_android_gms_wearable_internal_zzci.zzbUC));
        if (com_google_android_gms_wearable_internal_zzci.statusCode != 0) {
            for (FutureTask cancel : this.f978a) {
                cancel.cancel(true);
            }
        }
    }
}
