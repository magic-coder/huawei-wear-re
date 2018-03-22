package com.google.android.gms.wearable;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.C0369f;
import com.google.android.gms.common.api.C0380r;
import com.google.android.gms.common.api.C0381s;
import com.google.android.gms.common.internal.C0443x;
import com.google.android.gms.wearable.internal.ch;

final class ad extends C0369f<ch, ae> {
    ad() {
    }

    public ch m1692a(Context context, Looper looper, C0443x c0443x, ae aeVar, C0380r c0380r, C0381s c0381s) {
        if (aeVar == null) {
            ae aeVar2 = new ae(new af());
        }
        return new ch(context, looper, c0380r, c0381s, c0443x);
    }
}
