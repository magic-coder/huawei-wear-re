package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender.SendIntentException;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.C0421c;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class Status extends zza implements C0366w, ReflectedParcelable {
    public static final Creator<Status> CREATOR = new ag();
    public static final Status zzazA = new Status(15);
    public static final Status zzazB = new Status(16);
    public static final Status zzazC = new Status(17);
    public static final Status zzazD = new Status(18);
    public static final Status zzazx = new Status(0);
    public static final Status zzazy = new Status(14);
    public static final Status zzazz = new Status(8);
    private final PendingIntent mPendingIntent;
    final int zzaiI;
    private final int zzavD;
    private final String zzayk;

    public Status(int i) {
        this(i, null);
    }

    Status(int i, int i2, String str, PendingIntent pendingIntent) {
        this.zzaiI = i;
        this.zzavD = i2;
        this.zzayk = str;
        this.mPendingIntent = pendingIntent;
    }

    public Status(int i, String str) {
        this(1, i, str, null);
    }

    public Status(int i, String str, PendingIntent pendingIntent) {
        this(1, i, str, pendingIntent);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.zzaiI == status.zzaiI && this.zzavD == status.zzavD && C0421c.m647a(this.zzayk, status.zzayk) && C0421c.m647a(this.mPendingIntent, status.mPendingIntent);
    }

    public PendingIntent getResolution() {
        return this.mPendingIntent;
    }

    public Status getStatus() {
        return this;
    }

    public int getStatusCode() {
        return this.zzavD;
    }

    @Nullable
    public String getStatusMessage() {
        return this.zzayk;
    }

    public boolean hasResolution() {
        return this.mPendingIntent != null;
    }

    public int hashCode() {
        return C0421c.m645a(Integer.valueOf(this.zzaiI), Integer.valueOf(this.zzavD), this.zzayk, this.mPendingIntent);
    }

    public boolean isCanceled() {
        return this.zzavD == 16;
    }

    public boolean isInterrupted() {
        return this.zzavD == 14;
    }

    public boolean isSuccess() {
        return this.zzavD <= 0;
    }

    public void startResolutionForResult(Activity activity, int i) throws SendIntentException {
        if (hasResolution()) {
            activity.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), i, null, 0, 0, 0);
        }
    }

    public String toString() {
        return C0421c.m646a((Object) this).m648a("statusCode", zzvv()).m648a("resolution", this.mPendingIntent).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        ag.m352a(this, parcel, i);
    }

    PendingIntent zzvu() {
        return this.mPendingIntent;
    }

    public String zzvv() {
        return this.zzayk != null ? this.zzayk : C0377o.m372a(this.zzavD);
    }
}
