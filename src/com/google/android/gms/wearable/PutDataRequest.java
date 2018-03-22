package com.google.android.gms.wearable;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.C0424f;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.wearable.internal.DataItemAssetParcelable;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class PutDataRequest extends zza {
    public static final Creator<PutDataRequest> CREATOR = new ba();
    public static final String WEAR_URI_SCHEME = "wear";
    private static final long zzbSV = TimeUnit.MINUTES.toMillis(30);
    private static final Random zzbSW = new SecureRandom();
    private final Uri mUri;
    private final Bundle zzbSX;
    private long zzbSY;
    private byte[] zzbeL;

    private PutDataRequest(Uri uri) {
        this(uri, new Bundle(), null, zzbSV);
    }

    PutDataRequest(Uri uri, Bundle bundle, byte[] bArr, long j) {
        this.mUri = uri;
        this.zzbSX = bundle;
        this.zzbSX.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        this.zzbeL = bArr;
        this.zzbSY = j;
    }

    public static PutDataRequest create(String str) {
        return zzy(zzin(str));
    }

    public static PutDataRequest createFromDataItem(C0558p c0558p) {
        PutDataRequest zzy = zzy(c0558p.getUri());
        for (Entry entry : c0558p.getAssets().entrySet()) {
            if (((C0531q) entry.getValue()).getId() == null) {
                String str = "Cannot create an asset for a put request without a digest: ";
                String valueOf = String.valueOf((String) entry.getKey());
                throw new IllegalStateException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            }
            zzy.putAsset((String) entry.getKey(), Asset.createFromRef(((C0531q) entry.getValue()).getId()));
        }
        zzy.setData(c0558p.getData());
        return zzy;
    }

    public static PutDataRequest createWithAutoAppendedId(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        if (!str.endsWith("/")) {
            stringBuilder.append("/");
        }
        stringBuilder.append("PN").append(zzbSW.nextLong());
        return new PutDataRequest(zzin(stringBuilder.toString()));
    }

    private static Uri zzin(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("An empty path was supplied.");
        } else if (!str.startsWith("/")) {
            throw new IllegalArgumentException("A path must start with a single / .");
        } else if (!str.startsWith("//")) {
            return new Builder().scheme(WEAR_URI_SCHEME).path(str).build();
        } else {
            throw new IllegalArgumentException("A path must start with a single / .");
        }
    }

    public static PutDataRequest zzy(Uri uri) {
        return new PutDataRequest(uri);
    }

    public Asset getAsset(String str) {
        return (Asset) this.zzbSX.getParcelable(str);
    }

    public Map<String, Asset> getAssets() {
        Map hashMap = new HashMap();
        for (String str : this.zzbSX.keySet()) {
            hashMap.put(str, (Asset) this.zzbSX.getParcelable(str));
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public byte[] getData() {
        return this.zzbeL;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public boolean hasAsset(String str) {
        return this.zzbSX.containsKey(str);
    }

    public boolean isUrgent() {
        return this.zzbSY == 0;
    }

    public PutDataRequest putAsset(String str, Asset asset) {
        C0424f.m649a((Object) str);
        C0424f.m649a((Object) asset);
        this.zzbSX.putParcelable(str, asset);
        return this;
    }

    public PutDataRequest removeAsset(String str) {
        this.zzbSX.remove(str);
        return this;
    }

    public PutDataRequest setData(byte[] bArr) {
        this.zzbeL = bArr;
        return this;
    }

    public PutDataRequest setUrgent() {
        this.zzbSY = 0;
        return this;
    }

    public String toString() {
        return toString(Log.isLoggable("DataMap", 3));
    }

    public String toString(boolean z) {
        StringBuilder stringBuilder = new StringBuilder("PutDataRequest[");
        String valueOf = String.valueOf(this.zzbeL == null ? "null" : Integer.valueOf(this.zzbeL.length));
        stringBuilder.append(new StringBuilder(String.valueOf(valueOf).length() + 7).append("dataSz=").append(valueOf).toString());
        stringBuilder.append(", numAssets=" + this.zzbSX.size());
        valueOf = String.valueOf(this.mUri);
        stringBuilder.append(new StringBuilder(String.valueOf(valueOf).length() + 6).append(", uri=").append(valueOf).toString());
        stringBuilder.append(", syncDeadline=" + this.zzbSY);
        if (z) {
            stringBuilder.append("]\n  assets: ");
            for (String valueOf2 : this.zzbSX.keySet()) {
                String valueOf3 = String.valueOf(this.zzbSX.getParcelable(valueOf2));
                stringBuilder.append(new StringBuilder((String.valueOf(valueOf2).length() + 7) + String.valueOf(valueOf3).length()).append("\n    ").append(valueOf2).append(": ").append(valueOf3).toString());
            }
            stringBuilder.append("\n  ]");
            return stringBuilder.toString();
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        ba.m1721a(this, parcel, i);
    }

    public Bundle zzUg() {
        return this.zzbSX;
    }

    public long zzUh() {
        return this.zzbSY;
    }
}
