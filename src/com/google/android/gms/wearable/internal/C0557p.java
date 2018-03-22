package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.C0402j;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.C0531q;

public class C0557p extends C0402j implements C0531q {
    public C0557p(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public C0531q m2198a() {
        return new C0555n(this);
    }

    public /* synthetic */ Object freeze() {
        return m2198a();
    }

    public String getDataItemKey() {
        return m474b("asset_key");
    }

    public String getId() {
        return m474b("asset_id");
    }
}
