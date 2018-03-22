package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.api.C0378p;
import com.google.android.gms.common.api.C0382t;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.C0536y;
import com.google.android.gms.wearable.C0538z;
import com.google.android.gms.wearable.aa;

public final class bc implements C0536y {
    private static C0537y<aa> m1962a(IntentFilter[] intentFilterArr) {
        return new be(intentFilterArr);
    }

    public C0382t<C0538z> mo2004a(C0378p c0378p) {
        return c0378p.mo1839a(new bd(this, c0378p));
    }

    public C0382t<Status> mo2005a(C0378p c0378p, aa aaVar) {
        return C0566x.m2218a(c0378p, m1962a(new IntentFilter[]{bs.m2008a("com.google.android.gms.wearable.NODE_CHANGED")}), aaVar);
    }

    public C0382t<Status> mo2006b(C0378p c0378p, aa aaVar) {
        return c0378p.mo1839a(new bf(this, c0378p, aaVar));
    }
}
