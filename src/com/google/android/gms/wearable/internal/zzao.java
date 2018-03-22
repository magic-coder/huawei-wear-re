package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.wearable.C0531q;
import com.google.android.gms.wearable.C0558p;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class zzao extends zza implements C0558p {
    public static final Creator<zzao> CREATOR = new C0560r();
    private final Uri mUri;
    private final Map<String, C0531q> zzbUr;
    private byte[] zzbeL;

    zzao(Uri uri, Bundle bundle, byte[] bArr) {
        this.mUri = uri;
        Map hashMap = new HashMap();
        bundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        for (String str : bundle.keySet()) {
            hashMap.put(str, (DataItemAssetParcelable) bundle.getParcelable(str));
        }
        this.zzbUr = hashMap;
        this.zzbeL = bArr;
    }

    public /* synthetic */ Object freeze() {
        return zzUy();
    }

    public Map<String, C0531q> getAssets() {
        return this.zzbUr;
    }

    public byte[] getData() {
        return this.zzbeL;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public boolean isDataValid() {
        return true;
    }

    public /* synthetic */ C0558p setData(byte[] bArr) {
        return zzR(bArr);
    }

    public String toString() {
        return toString(Log.isLoggable("DataItem", 3));
    }

    public String toString(boolean z) {
        StringBuilder stringBuilder = new StringBuilder("DataItemParcelable[");
        stringBuilder.append("@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        String valueOf = String.valueOf(this.zzbeL == null ? "null" : Integer.valueOf(this.zzbeL.length));
        stringBuilder.append(new StringBuilder(String.valueOf(valueOf).length() + 8).append(",dataSz=").append(valueOf).toString());
        stringBuilder.append(", numAssets=" + this.zzbUr.size());
        valueOf = String.valueOf(this.mUri);
        stringBuilder.append(new StringBuilder(String.valueOf(valueOf).length() + 6).append(", uri=").append(valueOf).toString());
        if (z) {
            stringBuilder.append("]\n  assets: ");
            for (String valueOf2 : this.zzbUr.keySet()) {
                String valueOf3 = String.valueOf(this.zzbUr.get(valueOf2));
                stringBuilder.append(new StringBuilder((String.valueOf(valueOf2).length() + 7) + String.valueOf(valueOf3).length()).append("\n    ").append(valueOf2).append(": ").append(valueOf3).toString());
            }
            stringBuilder.append("\n  ]");
            return stringBuilder.toString();
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0560r.m2201a(this, parcel, i);
    }

    public zzao zzR(byte[] bArr) {
        this.zzbeL = bArr;
        return this;
    }

    public Bundle zzUg() {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        for (Entry entry : this.zzbUr.entrySet()) {
            bundle.putParcelable((String) entry.getKey(), new DataItemAssetParcelable((C0531q) entry.getValue()));
        }
        return bundle;
    }

    public zzao zzUy() {
        return this;
    }
}
