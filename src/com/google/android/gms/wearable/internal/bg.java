package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.C0538z;
import com.google.android.gms.wearable.C0569x;
import java.util.List;

public class bg implements C0538z {
    private final Status f969a;
    private final List<C0569x> f970b;

    public bg(Status status, List<C0569x> list) {
        this.f969a = status;
        this.f970b = list;
    }

    public List<C0569x> mo2008a() {
        return this.f970b;
    }

    public Status getStatus() {
        return this.f969a;
    }
}
