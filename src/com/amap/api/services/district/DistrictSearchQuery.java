package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.C3409d;

public class DistrictSearchQuery implements Parcelable, Cloneable {
    public static final Creator<DistrictSearchQuery> CREATOR = new C3442c();
    public static final String KEYWORDS_BUSINESS = "biz_area";
    public static final String KEYWORDS_CITY = "city";
    public static final String KEYWORDS_COUNTRY = "country";
    public static final String KEYWORDS_DISTRICT = "district";
    public static final String KEYWORDS_PROVINCE = "province";
    private int f12546a;
    private int f12547b;
    private String f12548c;
    private String f12549d;
    private boolean f12550e;
    private boolean f12551f;

    public void setShowBoundary(boolean z) {
        this.f12551f = z;
    }

    public boolean isShowBoundary() {
        return this.f12551f;
    }

    public DistrictSearchQuery() {
        this.f12546a = 0;
        this.f12547b = 20;
        this.f12550e = true;
        this.f12551f = false;
    }

    public DistrictSearchQuery(String str, String str2, int i) {
        this.f12546a = 0;
        this.f12547b = 20;
        this.f12550e = true;
        this.f12551f = false;
        this.f12548c = str;
        this.f12549d = str2;
        this.f12546a = i;
    }

    public DistrictSearchQuery(String str, String str2, int i, boolean z, int i2) {
        this(str, str2, i);
        this.f12550e = z;
        this.f12547b = i2;
    }

    public int getPageNum() {
        return this.f12546a;
    }

    public void setPageNum(int i) {
        this.f12546a = i;
    }

    public int getPageSize() {
        return this.f12547b;
    }

    public void setPageSize(int i) {
        this.f12547b = i;
    }

    public String getKeywords() {
        return this.f12548c;
    }

    public void setKeywords(String str) {
        this.f12548c = str;
    }

    public String getKeywordsLevel() {
        return this.f12549d;
    }

    public void setKeywordsLevel(String str) {
        this.f12549d = str;
    }

    public boolean isShowChild() {
        return this.f12550e;
    }

    public void setShowChild(boolean z) {
        this.f12550e = z;
    }

    public boolean checkLevels() {
        if (this.f12549d == null) {
            return false;
        }
        if (this.f12549d.trim().equals("country") || this.f12549d.trim().equals("province") || this.f12549d.trim().equals("city") || this.f12549d.trim().equals(KEYWORDS_DISTRICT) || this.f12549d.trim().equals(KEYWORDS_BUSINESS)) {
            return true;
        }
        return false;
    }

    public boolean checkKeyWords() {
        if (this.f12548c == null || this.f12548c.trim().equalsIgnoreCase("")) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = 1231;
        int i2 = 0;
        int hashCode = ((this.f12548c == null ? 0 : this.f12548c.hashCode()) + (((this.f12551f ? 1231 : 1237) + 31) * 31)) * 31;
        if (this.f12549d != null) {
            i2 = this.f12549d.hashCode();
        }
        hashCode = (((((hashCode + i2) * 31) + this.f12546a) * 31) + this.f12547b) * 31;
        if (!this.f12550e) {
            i = 1237;
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
        DistrictSearchQuery districtSearchQuery = (DistrictSearchQuery) obj;
        if (this.f12551f != districtSearchQuery.f12551f) {
            return false;
        }
        if (this.f12548c == null) {
            if (districtSearchQuery.f12548c != null) {
                return false;
            }
        } else if (!this.f12548c.equals(districtSearchQuery.f12548c)) {
            return false;
        }
        if (this.f12549d == null) {
            if (districtSearchQuery.f12549d != null) {
                return false;
            }
        } else if (!this.f12549d.equals(districtSearchQuery.f12549d)) {
            return false;
        }
        if (this.f12546a != districtSearchQuery.f12546a) {
            return false;
        }
        if (this.f12547b != districtSearchQuery.f12547b) {
            return false;
        }
        if (this.f12550e != districtSearchQuery.f12550e) {
            return false;
        }
        return true;
    }

    protected boolean weakEquals(DistrictSearchQuery districtSearchQuery) {
        if (this == districtSearchQuery) {
            return true;
        }
        if (districtSearchQuery == null) {
            return false;
        }
        if (this.f12548c == null) {
            if (districtSearchQuery.f12548c != null) {
                return false;
            }
        } else if (!this.f12548c.equals(districtSearchQuery.f12548c)) {
            return false;
        }
        if (this.f12549d == null) {
            if (districtSearchQuery.f12549d != null) {
                return false;
            }
        } else if (!this.f12549d.equals(districtSearchQuery.f12549d)) {
            return false;
        }
        if (this.f12547b != districtSearchQuery.f12547b) {
            return false;
        }
        if (this.f12550e != districtSearchQuery.f12550e) {
            return false;
        }
        if (this.f12551f != districtSearchQuery.f12551f) {
            return false;
        }
        return true;
    }

    public DistrictSearchQuery clone() {
        try {
            super.clone();
        } catch (Throwable e) {
            C3409d.m16881a(e, "DistrictSearchQuery", "clone");
        }
        DistrictSearchQuery districtSearchQuery = new DistrictSearchQuery(this.f12548c, this.f12549d, this.f12546a, this.f12550e, this.f12547b);
        districtSearchQuery.setShowBoundary(this.f12551f);
        return districtSearchQuery;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.f12548c);
        parcel.writeString(this.f12549d);
        parcel.writeInt(this.f12546a);
        parcel.writeInt(this.f12547b);
        if (this.f12550e) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!this.f12551f) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
    }
}
