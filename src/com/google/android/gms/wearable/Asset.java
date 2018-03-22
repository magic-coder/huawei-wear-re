package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C0421c;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.Arrays;

public class Asset extends zza implements ReflectedParcelable {
    public static final Creator<Asset> CREATOR = new ax();
    public Uri uri;
    private String zzbSL;
    public ParcelFileDescriptor zzbSM;
    private byte[] zzbeL;

    Asset(byte[] bArr, String str, ParcelFileDescriptor parcelFileDescriptor, Uri uri) {
        this.zzbeL = bArr;
        this.zzbSL = str;
        this.zzbSM = parcelFileDescriptor;
        this.uri = uri;
    }

    public static Asset createFromBytes(byte[] bArr) {
        if (bArr != null) {
            return new Asset(bArr, null, null, null);
        }
        throw new IllegalArgumentException("Asset data cannot be null");
    }

    public static Asset createFromFd(ParcelFileDescriptor parcelFileDescriptor) {
        if (parcelFileDescriptor != null) {
            return new Asset(null, null, parcelFileDescriptor, null);
        }
        throw new IllegalArgumentException("Asset fd cannot be null");
    }

    public static Asset createFromRef(String str) {
        if (str != null) {
            return new Asset(null, str, null, null);
        }
        throw new IllegalArgumentException("Asset digest cannot be null");
    }

    public static Asset createFromUri(Uri uri) {
        if (uri != null) {
            return new Asset(null, null, null, uri);
        }
        throw new IllegalArgumentException("Asset uri cannot be null");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Asset)) {
            return false;
        }
        Asset asset = (Asset) obj;
        return Arrays.equals(this.zzbeL, asset.zzbeL) && C0421c.m647a(this.zzbSL, asset.zzbSL) && C0421c.m647a(this.zzbSM, asset.zzbSM) && C0421c.m647a(this.uri, asset.uri);
    }

    public byte[] getData() {
        return this.zzbeL;
    }

    public String getDigest() {
        return this.zzbSL;
    }

    public ParcelFileDescriptor getFd() {
        return this.zzbSM;
    }

    public Uri getUri() {
        return this.uri;
    }

    public int hashCode() {
        return Arrays.deepHashCode(new Object[]{this.zzbeL, this.zzbSL, this.zzbSM, this.uri});
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Asset[@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        if (this.zzbSL == null) {
            stringBuilder.append(", nodigest");
        } else {
            stringBuilder.append(", ");
            stringBuilder.append(this.zzbSL);
        }
        if (this.zzbeL != null) {
            stringBuilder.append(", size=");
            stringBuilder.append(this.zzbeL.length);
        }
        if (this.zzbSM != null) {
            stringBuilder.append(", fd=");
            stringBuilder.append(this.zzbSM);
        }
        if (this.uri != null) {
            stringBuilder.append(", uri=");
            stringBuilder.append(this.uri);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        ax.m1715a(this, parcel, i | 1);
    }
}
