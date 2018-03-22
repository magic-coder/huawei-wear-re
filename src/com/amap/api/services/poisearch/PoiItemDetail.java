package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import java.util.ArrayList;
import java.util.List;

public class PoiItemDetail extends PoiItem implements Parcelable {
    public static final Creator<PoiItemDetail> CREATOR = new C3461h();
    private List<Groupbuy> f12680a;
    private List<Discount> f12681b;
    private Dining f12682c;
    private Hotel f12683d;
    private Cinema f12684e;
    private Scenic f12685f;
    private DeepType f12686g;

    public enum DeepType {
        UNKNOWN,
        DINING,
        HOTEL,
        CINEMA,
        SCENIC
    }

    public PoiItemDetail(String str, LatLonPoint latLonPoint, String str2, String str3) {
        super(str, latLonPoint, str2, str3);
        this.f12680a = new ArrayList();
        this.f12681b = new ArrayList();
    }

    public List<Groupbuy> getGroupbuys() {
        return this.f12680a;
    }

    public void initGroupbuys(List<Groupbuy> list) {
        if (list != null && list.size() != 0) {
            for (Groupbuy add : list) {
                this.f12680a.add(add);
            }
        }
    }

    public void addGroupbuy(Groupbuy groupbuy) {
        this.f12680a.add(groupbuy);
    }

    public List<Discount> getDiscounts() {
        return this.f12681b;
    }

    public void initDiscounts(List<Discount> list) {
        if (list != null && list.size() != 0) {
            this.f12681b.clear();
            for (Discount add : list) {
                this.f12681b.add(add);
            }
        }
    }

    public void addDiscount(Discount discount) {
        this.f12681b.add(discount);
    }

    public DeepType getDeepType() {
        return this.f12686g;
    }

    public void setDeepType(DeepType deepType) {
        this.f12686g = deepType;
    }

    public Dining getDining() {
        return this.f12682c;
    }

    public void setDining(Dining dining) {
        this.f12682c = dining;
    }

    public Hotel getHotel() {
        return this.f12683d;
    }

    public void setHotel(Hotel hotel) {
        this.f12683d = hotel;
    }

    public Cinema getCinema() {
        return this.f12684e;
    }

    public void setCinema(Cinema cinema) {
        this.f12684e = cinema;
    }

    public Scenic getScenic() {
        return this.f12685f;
    }

    public void setScenic(Scenic scenic) {
        this.f12685f = scenic;
    }

    private PoiItemDetail(Parcel parcel) {
        super(parcel);
        this.f12680a = new ArrayList();
        this.f12681b = new ArrayList();
        this.f12680a = parcel.readArrayList(Groupbuy.class.getClassLoader());
        this.f12681b = parcel.readArrayList(Discount.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeList(this.f12680a);
        parcel.writeList(this.f12681b);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f12683d == null ? 0 : this.f12683d.hashCode()) + (((this.f12680a == null ? 0 : this.f12680a.hashCode()) + (((this.f12681b == null ? 0 : this.f12681b.hashCode()) + (((this.f12682c == null ? 0 : this.f12682c.hashCode()) + (((this.f12686g == null ? 0 : this.f12686g.hashCode()) + (((this.f12684e == null ? 0 : this.f12684e.hashCode()) + (super.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.f12685f != null) {
            i = this.f12685f.hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        PoiItemDetail poiItemDetail = (PoiItemDetail) obj;
        if (this.f12684e == null) {
            if (poiItemDetail.f12684e != null) {
                return false;
            }
        } else if (!this.f12684e.equals(poiItemDetail.f12684e)) {
            return false;
        }
        if (this.f12686g != poiItemDetail.f12686g) {
            return false;
        }
        if (this.f12682c == null) {
            if (poiItemDetail.f12682c != null) {
                return false;
            }
        } else if (!this.f12682c.equals(poiItemDetail.f12682c)) {
            return false;
        }
        if (this.f12681b == null) {
            if (poiItemDetail.f12681b != null) {
                return false;
            }
        } else if (!this.f12681b.equals(poiItemDetail.f12681b)) {
            return false;
        }
        if (this.f12680a == null) {
            if (poiItemDetail.f12680a != null) {
                return false;
            }
        } else if (!this.f12680a.equals(poiItemDetail.f12680a)) {
            return false;
        }
        if (this.f12683d == null) {
            if (poiItemDetail.f12683d != null) {
                return false;
            }
        } else if (!this.f12683d.equals(poiItemDetail.f12683d)) {
            return false;
        }
        if (this.f12685f == null) {
            if (poiItemDetail.f12685f != null) {
                return false;
            }
            return true;
        } else if (this.f12685f.equals(poiItemDetail.f12685f)) {
            return true;
        } else {
            return false;
        }
    }
}
