package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.C0378p;
import com.google.android.gms.common.api.C0382t;
import com.google.android.gms.common.internal.C0424f;
import com.google.android.gms.wearable.C0524a;
import com.google.android.gms.wearable.C0525c;

public class db implements C0524a {
    public C0382t<C0525c> mo2015a(C0378p c0378p, String str, int i) {
        boolean z = true;
        if (!(i == 0 || i == 1)) {
            z = false;
        }
        C0424f.m657b(z);
        return c0378p.mo1839a(new dc(this, c0378p, str, i));
    }
}
