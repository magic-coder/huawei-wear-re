package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.C0531q;

public class C0555n implements C0531q {
    private final String f1067a;
    private final String f1068b;

    public C0555n(C0531q c0531q) {
        this.f1067a = c0531q.getId();
        this.f1068b = c0531q.getDataItemKey();
    }

    public C0531q m2194a() {
        return this;
    }

    public /* synthetic */ Object freeze() {
        return m2194a();
    }

    public String getDataItemKey() {
        return this.f1068b;
    }

    public String getId() {
        return this.f1067a;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataItemAssetEntity[");
        stringBuilder.append("@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        if (this.f1067a == null) {
            stringBuilder.append(",noid");
        } else {
            stringBuilder.append(",");
            stringBuilder.append(this.f1067a);
        }
        stringBuilder.append(", key=");
        stringBuilder.append(this.f1068b);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
