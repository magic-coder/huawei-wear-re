package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzacn extends zza {
    public static final Creator<zzacn> CREATOR = new cl();
    private final zzacp zzaGR;
    final int zzaiI;

    zzacn(int i, zzacp com_google_android_gms_internal_zzacp) {
        this.zzaiI = i;
        this.zzaGR = com_google_android_gms_internal_zzacp;
    }

    private zzacn(zzacp com_google_android_gms_internal_zzacp) {
        this.zzaiI = 1;
        this.zzaGR = com_google_android_gms_internal_zzacp;
    }

    public static zzacn zza(co<?, ?> coVar) {
        if (coVar instanceof zzacp) {
            return new zzacn((zzacp) coVar);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    public void writeToParcel(Parcel parcel, int i) {
        cl.m1153a(this, parcel, i);
    }

    zzacp zzyo() {
        return this.zzaGR;
    }

    public co<?, ?> zzyp() {
        if (this.zzaGR != null) {
            return this.zzaGR;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }
}
