package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.AMapException;
import java.util.ArrayList;

public final class DistrictResult implements Parcelable {
    public Creator<DistrictResult> CREATOR = new C3441b(this);
    private DistrictSearchQuery f12534a;
    private ArrayList<DistrictItem> f12535b = new ArrayList();
    private int f12536c;
    private AMapException f12537d;

    public DistrictResult(DistrictSearchQuery districtSearchQuery, ArrayList<DistrictItem> arrayList) {
        this.f12534a = districtSearchQuery;
        this.f12535b = arrayList;
    }

    public ArrayList<DistrictItem> getDistrict() {
        return this.f12535b;
    }

    public void setDistrict(ArrayList<DistrictItem> arrayList) {
        this.f12535b = arrayList;
    }

    public DistrictSearchQuery getQuery() {
        return this.f12534a;
    }

    public void setQuery(DistrictSearchQuery districtSearchQuery) {
        this.f12534a = districtSearchQuery;
    }

    public int getPageCount() {
        return this.f12536c;
    }

    public void setPageCount(int i) {
        this.f12536c = i;
    }

    public AMapException getAMapException() {
        return this.f12537d;
    }

    public void setAMapException(AMapException aMapException) {
        this.f12537d = aMapException;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f12534a, i);
        parcel.writeTypedList(this.f12535b);
    }

    protected DistrictResult(Parcel parcel) {
        this.f12534a = (DistrictSearchQuery) parcel.readParcelable(DistrictSearchQuery.class.getClassLoader());
        this.f12535b = parcel.createTypedArrayList(DistrictItem.CREATOR);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f12534a == null ? 0 : this.f12534a.hashCode()) + 31) * 31;
        if (this.f12535b != null) {
            i = this.f12535b.hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        DistrictResult districtResult = (DistrictResult) obj;
        if (this.f12534a == null) {
            if (districtResult.f12534a != null) {
                return false;
            }
        } else if (!this.f12534a.equals(districtResult.f12534a)) {
            return false;
        }
        if (this.f12535b == null) {
            if (districtResult.f12535b != null) {
                return false;
            }
            return true;
        } else if (this.f12535b.equals(districtResult.f12535b)) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return "DistrictResult [mDisQuery=" + this.f12534a + ", mDistricts=" + this.f12535b + "]";
    }
}
