package com.google.android.gms.internal;

import android.os.DeadObjectException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.C0366w;
import com.google.android.gms.common.api.C0370g;
import com.google.android.gms.common.api.Status;

public class ew<A extends C0503g<? extends C0366w, C0370g>> extends eu {
    protected final A f775b;

    public ew(int i, A a) {
        super(i);
        this.f775b = a;
    }

    public void mo1876a(@NonNull Status status) {
        this.f775b.mo1880a(status);
    }

    public void mo1877a(@NonNull ab abVar, boolean z) {
        abVar.m882a(this.f775b, z);
    }

    public void mo1878a(bb<?> bbVar) throws DeadObjectException {
        this.f775b.m1492a(bbVar.m1056b());
    }
}
