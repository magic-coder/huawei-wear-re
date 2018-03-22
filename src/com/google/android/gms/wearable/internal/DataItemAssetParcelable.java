package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.C0424f;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.wearable.C0531q;

@KeepName
public class DataItemAssetParcelable extends zza implements ReflectedParcelable, C0531q {
    public static final Creator<DataItemAssetParcelable> CREATOR = new C0556o();
    private final String zzAX;
    private final String zzGV;

    public DataItemAssetParcelable(C0531q c0531q) {
        this.zzGV = (String) C0424f.m649a(c0531q.getId());
        this.zzAX = (String) C0424f.m649a(c0531q.getDataItemKey());
    }

    DataItemAssetParcelable(String str, String str2) {
        this.zzGV = str;
        this.zzAX = str2;
    }

    public /* synthetic */ Object freeze() {
        return zzUw();
    }

    public String getDataItemKey() {
        return this.zzAX;
    }

    public String getId() {
        return this.zzGV;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataItemAssetParcelable[");
        stringBuilder.append("@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        if (this.zzGV == null) {
            stringBuilder.append(",noid");
        } else {
            stringBuilder.append(",");
            stringBuilder.append(this.zzGV);
        }
        stringBuilder.append(", key=");
        stringBuilder.append(this.zzAX);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0556o.m2195a(this, parcel, i);
    }

    public C0531q zzUw() {
        return this;
    }
}
