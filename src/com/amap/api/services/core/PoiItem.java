package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PoiItem implements Parcelable {
    public static final Creator<PoiItem> CREATOR = new C3429q();
    private String f12270a;
    private String f12271b;
    private String f12272c;
    private String f12273d;
    private String f12274e = "";
    private int f12275f = -1;
    private LatLonPoint f12276g;
    private LatLonPoint f12277h;
    private String f12278i;
    private String f12279j;
    private String f12280k;
    private boolean f12281l;
    private boolean f12282m;
    protected final LatLonPoint mPoint;
    protected final String mSnippet;
    protected final String mTitle;
    private String f12283n;
    private String f12284o;
    private String f12285p;
    private String f12286q;
    private boolean f12287r;
    private String f12288s;

    public PoiItem(String str, LatLonPoint latLonPoint, String str2, String str3) {
        this.f12270a = str;
        this.mPoint = latLonPoint;
        this.mTitle = str2;
        this.mSnippet = str3;
    }

    public String getAdName() {
        return this.f12286q;
    }

    public void setAdName(String str) {
        this.f12286q = str;
    }

    public String getCityName() {
        return this.f12285p;
    }

    public void setCityName(String str) {
        this.f12285p = str;
    }

    public String getProvinceName() {
        return this.f12284o;
    }

    public void setProvinceName(String str) {
        this.f12284o = str;
    }

    public String getTypeDes() {
        return this.f12274e;
    }

    public void setTypeDes(String str) {
        this.f12274e = str;
    }

    public String getTel() {
        return this.f12271b;
    }

    public void setTel(String str) {
        this.f12271b = str;
    }

    public String getAdCode() {
        return this.f12272c;
    }

    public void setAdCode(String str) {
        this.f12272c = str;
    }

    public String getPoiId() {
        return this.f12270a;
    }

    public int getDistance() {
        return this.f12275f;
    }

    public void setDistance(int i) {
        this.f12275f = i;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getSnippet() {
        return this.mSnippet;
    }

    public LatLonPoint getLatLonPoint() {
        return this.mPoint;
    }

    public String getCityCode() {
        return this.f12273d;
    }

    public void setCityCode(String str) {
        this.f12273d = str;
    }

    public LatLonPoint getEnter() {
        return this.f12276g;
    }

    public void setEnter(LatLonPoint latLonPoint) {
        this.f12276g = latLonPoint;
    }

    public LatLonPoint getExit() {
        return this.f12277h;
    }

    public void setExit(LatLonPoint latLonPoint) {
        this.f12277h = latLonPoint;
    }

    public String getWebsite() {
        return this.f12278i;
    }

    public void setWebsite(String str) {
        this.f12278i = str;
    }

    public String getPostcode() {
        return this.f12279j;
    }

    public void setPostcode(String str) {
        this.f12279j = str;
    }

    public String getEmail() {
        return this.f12280k;
    }

    public void setEmail(String str) {
        this.f12280k = str;
    }

    public boolean isGroupbuyInfo() {
        return this.f12281l;
    }

    public void setGroupbuyInfo(boolean z) {
        this.f12281l = z;
    }

    public boolean isDiscountInfo() {
        return this.f12282m;
    }

    public void setDiscountInfo(boolean z) {
        this.f12282m = z;
    }

    public String getDirection() {
        return this.f12283n;
    }

    public void setDirection(String str) {
        this.f12283n = str;
    }

    public void setIndoorMap(boolean z) {
        this.f12287r = z;
    }

    public boolean isIndoorMap() {
        return this.f12287r;
    }

    public void setProvinceCode(String str) {
        this.f12288s = str;
    }

    public String getProvinceCode() {
        return this.f12288s;
    }

    protected PoiItem(Parcel parcel) {
        this.f12270a = parcel.readString();
        this.f12272c = parcel.readString();
        this.f12271b = parcel.readString();
        this.f12274e = parcel.readString();
        this.f12275f = parcel.readInt();
        this.mPoint = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.mTitle = parcel.readString();
        this.mSnippet = parcel.readString();
        this.f12273d = parcel.readString();
        this.f12276g = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f12277h = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f12278i = parcel.readString();
        this.f12279j = parcel.readString();
        this.f12280k = parcel.readString();
        boolean[] zArr = new boolean[3];
        parcel.readBooleanArray(zArr);
        this.f12281l = zArr[0];
        this.f12282m = zArr[1];
        this.f12287r = zArr[2];
        this.f12283n = parcel.readString();
        this.f12284o = parcel.readString();
        this.f12285p = parcel.readString();
        this.f12286q = parcel.readString();
        this.f12288s = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12270a);
        parcel.writeString(this.f12272c);
        parcel.writeString(this.f12271b);
        parcel.writeString(this.f12274e);
        parcel.writeInt(this.f12275f);
        parcel.writeValue(this.mPoint);
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mSnippet);
        parcel.writeString(this.f12273d);
        parcel.writeValue(this.f12276g);
        parcel.writeValue(this.f12277h);
        parcel.writeString(this.f12278i);
        parcel.writeString(this.f12279j);
        parcel.writeString(this.f12280k);
        parcel.writeBooleanArray(new boolean[]{this.f12281l, this.f12282m, this.f12287r});
        parcel.writeString(this.f12283n);
        parcel.writeString(this.f12284o);
        parcel.writeString(this.f12285p);
        parcel.writeString(this.f12286q);
        parcel.writeString(this.f12288s);
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
        PoiItem poiItem = (PoiItem) obj;
        if (this.f12270a == null) {
            if (poiItem.f12270a != null) {
                return false;
            }
            return true;
        } else if (this.f12270a.equals(poiItem.f12270a)) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (this.f12270a == null ? 0 : this.f12270a.hashCode()) + 31;
    }

    public String toString() {
        return this.mTitle;
    }
}
