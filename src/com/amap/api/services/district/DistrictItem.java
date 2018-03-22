package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class DistrictItem implements Parcelable {
    public static final Creator<DistrictItem> CREATOR = new C3440a();
    private String f12527a;
    private String f12528b;
    private String f12529c;
    private LatLonPoint f12530d;
    private String f12531e;
    private List<DistrictItem> f12532f;
    private String[] f12533g;

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12527a);
        parcel.writeString(this.f12528b);
        parcel.writeString(this.f12529c);
        parcel.writeParcelable(this.f12530d, i);
        parcel.writeString(this.f12531e);
        parcel.writeTypedList(this.f12532f);
        parcel.writeInt(this.f12533g.length);
        parcel.writeStringArray(this.f12533g);
    }

    public void setDistrictBoundary(String[] strArr) {
        this.f12533g = strArr;
    }

    public String[] districtBoundary() {
        return this.f12533g;
    }

    public DistrictItem() {
        this.f12532f = new ArrayList();
        this.f12533g = new String[0];
    }

    public DistrictItem(String str, String str2, String str3, LatLonPoint latLonPoint, String str4) {
        this.f12532f = new ArrayList();
        this.f12533g = new String[0];
        this.f12529c = str;
        this.f12527a = str2;
        this.f12528b = str3;
        this.f12530d = latLonPoint;
        this.f12531e = str4;
    }

    public String getCitycode() {
        return this.f12527a;
    }

    public void setCitycode(String str) {
        this.f12527a = str;
    }

    public String getAdcode() {
        return this.f12528b;
    }

    public void setAdcode(String str) {
        this.f12528b = str;
    }

    public String getName() {
        return this.f12529c;
    }

    public void setName(String str) {
        this.f12529c = str;
    }

    public LatLonPoint getCenter() {
        return this.f12530d;
    }

    public void setCenter(LatLonPoint latLonPoint) {
        this.f12530d = latLonPoint;
    }

    public String getLevel() {
        return this.f12531e;
    }

    public void setLevel(String str) {
        this.f12531e = str;
    }

    public List<DistrictItem> getSubDistrict() {
        return this.f12532f;
    }

    public void setSubDistrict(ArrayList<DistrictItem> arrayList) {
        this.f12532f = arrayList;
    }

    public int describeContents() {
        return 0;
    }

    public DistrictItem(Parcel parcel) {
        this.f12532f = new ArrayList();
        this.f12533g = new String[0];
        this.f12527a = parcel.readString();
        this.f12528b = parcel.readString();
        this.f12529c = parcel.readString();
        this.f12530d = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f12531e = parcel.readString();
        this.f12532f = parcel.createTypedArrayList(CREATOR);
        this.f12533g = new String[parcel.readInt()];
        parcel.readStringArray(this.f12533g);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f12531e == null ? 0 : this.f12531e.hashCode()) + (((this.f12532f == null ? 0 : this.f12532f.hashCode()) + (((((this.f12527a == null ? 0 : this.f12527a.hashCode()) + (((this.f12530d == null ? 0 : this.f12530d.hashCode()) + (((this.f12528b == null ? 0 : this.f12528b.hashCode()) + 31) * 31)) * 31)) * 31) + Arrays.hashCode(this.f12533g)) * 31)) * 31)) * 31;
        if (this.f12529c != null) {
            i = this.f12529c.hashCode();
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
        DistrictItem districtItem = (DistrictItem) obj;
        if (this.f12528b == null) {
            if (districtItem.f12528b != null) {
                return false;
            }
        } else if (!this.f12528b.equals(districtItem.f12528b)) {
            return false;
        }
        if (this.f12530d == null) {
            if (districtItem.f12530d != null) {
                return false;
            }
        } else if (!this.f12530d.equals(districtItem.f12530d)) {
            return false;
        }
        if (this.f12527a == null) {
            if (districtItem.f12527a != null) {
                return false;
            }
        } else if (!this.f12527a.equals(districtItem.f12527a)) {
            return false;
        }
        if (!Arrays.equals(this.f12533g, districtItem.f12533g)) {
            return false;
        }
        if (this.f12532f == null) {
            if (districtItem.f12532f != null) {
                return false;
            }
        } else if (!this.f12532f.equals(districtItem.f12532f)) {
            return false;
        }
        if (this.f12531e == null) {
            if (districtItem.f12531e != null) {
                return false;
            }
        } else if (!this.f12531e.equals(districtItem.f12531e)) {
            return false;
        }
        if (this.f12529c == null) {
            if (districtItem.f12529c != null) {
                return false;
            }
            return true;
        } else if (this.f12529c.equals(districtItem.f12529c)) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return "DistrictItem [mCitycode=" + this.f12527a + ", mAdcode=" + this.f12528b + ", mName=" + this.f12529c + ", mCenter=" + this.f12530d + ", mLevel=" + this.f12531e + ", mDistricts=" + this.f12532f + "]";
    }
}
