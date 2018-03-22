package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C0421c;
import com.google.android.gms.common.internal.C0423e;
import com.google.android.gms.common.internal.C0424f;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

public class PlaceReport extends zza implements ReflectedParcelable {
    public static final Creator<PlaceReport> CREATOR = new C0519a();
    private final String mTag;
    private final String zzacO;
    final int zzaiI;
    private final String zzblE;

    PlaceReport(int i, String str, String str2, String str3) {
        this.zzaiI = i;
        this.zzblE = str;
        this.mTag = str2;
        this.zzacO = str3;
    }

    public static PlaceReport create(String str, String str2) {
        return zzj(str, str2, "unknown");
    }

    private static boolean zzeU(String str) {
        boolean z = true;
        switch (str.hashCode()) {
            case -1436706272:
                if (str.equals("inferredGeofencing")) {
                    z = true;
                    break;
                }
                break;
            case -1194968642:
                if (str.equals("userReported")) {
                    z = true;
                    break;
                }
                break;
            case -284840886:
                if (str.equals("unknown")) {
                    z = false;
                    break;
                }
                break;
            case -262743844:
                if (str.equals("inferredReverseGeocoding")) {
                    z = true;
                    break;
                }
                break;
            case 1164924125:
                if (str.equals("inferredSnappedToRoad")) {
                    z = true;
                    break;
                }
                break;
            case 1287171955:
                if (str.equals("inferredRadioSignals")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
            case true:
            case true:
            case true:
            case true:
            case true:
                return true;
            default:
                return false;
        }
    }

    public static PlaceReport zzj(String str, String str2, String str3) {
        C0424f.m649a((Object) str);
        C0424f.m651a(str2);
        C0424f.m651a(str3);
        C0424f.m658b(zzeU(str3), "Invalid source");
        return new PlaceReport(1, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlaceReport)) {
            return false;
        }
        PlaceReport placeReport = (PlaceReport) obj;
        return C0421c.m647a(this.zzblE, placeReport.zzblE) && C0421c.m647a(this.mTag, placeReport.mTag) && C0421c.m647a(this.zzacO, placeReport.zzacO);
    }

    public String getPlaceId() {
        return this.zzblE;
    }

    public String getSource() {
        return this.zzacO;
    }

    public String getTag() {
        return this.mTag;
    }

    public int hashCode() {
        return C0421c.m645a(this.zzblE, this.mTag, this.zzacO);
    }

    public String toString() {
        C0423e a = C0421c.m646a((Object) this);
        a.m648a("placeId", this.zzblE);
        a.m648a("tag", this.mTag);
        if (!"unknown".equals(this.zzacO)) {
            a.m648a("source", this.zzacO);
        }
        return a.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0519a.m1654a(this, parcel, i);
    }
}
