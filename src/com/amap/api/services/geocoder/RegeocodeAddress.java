package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.road.Crossroad;
import com.amap.api.services.road.Road;
import java.util.ArrayList;
import java.util.List;

public final class RegeocodeAddress implements Parcelable {
    public static final Creator<RegeocodeAddress> CREATOR = new C3447c();
    private String f12576a;
    private String f12577b;
    private String f12578c;
    private String f12579d;
    private String f12580e;
    private String f12581f;
    private String f12582g;
    private StreetNumber f12583h;
    private String f12584i;
    private String f12585j;
    private List<RegeocodeRoad> f12586k;
    private List<Crossroad> f12587l;
    private List<PoiItem> f12588m;
    private List<BusinessArea> f12589n;

    public RegeocodeAddress() {
        this.f12586k = new ArrayList();
        this.f12587l = new ArrayList();
        this.f12588m = new ArrayList();
        this.f12589n = new ArrayList();
    }

    public String getFormatAddress() {
        return this.f12576a;
    }

    public void setFormatAddress(String str) {
        this.f12576a = str;
    }

    public String getProvince() {
        return this.f12577b;
    }

    public void setProvince(String str) {
        this.f12577b = str;
    }

    public String getCity() {
        return this.f12578c;
    }

    public void setCity(String str) {
        this.f12578c = str;
    }

    public String getCityCode() {
        return this.f12584i;
    }

    public void setCityCode(String str) {
        this.f12584i = str;
    }

    public String getAdCode() {
        return this.f12585j;
    }

    public void setAdCode(String str) {
        this.f12585j = str;
    }

    public String getDistrict() {
        return this.f12579d;
    }

    public void setDistrict(String str) {
        this.f12579d = str;
    }

    public String getTownship() {
        return this.f12580e;
    }

    public void setTownship(String str) {
        this.f12580e = str;
    }

    public String getNeighborhood() {
        return this.f12581f;
    }

    public void setNeighborhood(String str) {
        this.f12581f = str;
    }

    public String getBuilding() {
        return this.f12582g;
    }

    public void setBuilding(String str) {
        this.f12582g = str;
    }

    public StreetNumber getStreetNumber() {
        return this.f12583h;
    }

    public void setStreetNumber(StreetNumber streetNumber) {
        this.f12583h = streetNumber;
    }

    public List<RegeocodeRoad> getRoads() {
        return this.f12586k;
    }

    public void setRoads(List<RegeocodeRoad> list) {
        this.f12586k = list;
    }

    public List<PoiItem> getPois() {
        return this.f12588m;
    }

    public void setPois(List<PoiItem> list) {
        this.f12588m = list;
    }

    public List<Crossroad> getCrossroads() {
        return this.f12587l;
    }

    public void setCrossroads(List<Crossroad> list) {
        this.f12587l = list;
    }

    public List<BusinessArea> getBusinessAreas() {
        return this.f12589n;
    }

    public void setBusinessAreas(List<BusinessArea> list) {
        this.f12589n = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12576a);
        parcel.writeString(this.f12577b);
        parcel.writeString(this.f12578c);
        parcel.writeString(this.f12579d);
        parcel.writeString(this.f12580e);
        parcel.writeString(this.f12581f);
        parcel.writeString(this.f12582g);
        parcel.writeValue(this.f12583h);
        parcel.writeList(this.f12586k);
        parcel.writeList(this.f12587l);
        parcel.writeList(this.f12588m);
        parcel.writeString(this.f12584i);
        parcel.writeString(this.f12585j);
        parcel.writeList(this.f12589n);
    }

    private RegeocodeAddress(Parcel parcel) {
        this.f12586k = new ArrayList();
        this.f12587l = new ArrayList();
        this.f12588m = new ArrayList();
        this.f12589n = new ArrayList();
        this.f12576a = parcel.readString();
        this.f12577b = parcel.readString();
        this.f12578c = parcel.readString();
        this.f12579d = parcel.readString();
        this.f12580e = parcel.readString();
        this.f12581f = parcel.readString();
        this.f12582g = parcel.readString();
        this.f12583h = (StreetNumber) parcel.readValue(StreetNumber.class.getClassLoader());
        this.f12586k = parcel.readArrayList(Road.class.getClassLoader());
        this.f12587l = parcel.readArrayList(Crossroad.class.getClassLoader());
        this.f12588m = parcel.readArrayList(PoiItem.class.getClassLoader());
        this.f12584i = parcel.readString();
        this.f12585j = parcel.readString();
        this.f12589n = parcel.readArrayList(BusinessArea.class.getClassLoader());
    }
}
