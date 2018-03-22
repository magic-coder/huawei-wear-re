package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.C0369f;
import com.google.android.gms.common.api.C0380r;
import com.google.android.gms.common.api.C0381s;
import com.google.android.gms.common.internal.C0443x;

final class dh extends C0369f<dy, dl> {
    dh() {
    }

    public dy m1198a(Context context, Looper looper, C0443x c0443x, dl dlVar, C0380r c0380r, C0381s c0381s) {
        return new dy(context, looper, true, c0443x, dlVar == null ? dl.f693a : dlVar, c0380r, c0381s);
    }
}
