package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.C3409d;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class Discount implements Parcelable {
    public static final Creator<Discount> CREATOR = new C3456c();
    private String f12642a;
    private String f12643b;
    private Date f12644c;
    private Date f12645d;
    private int f12646e;
    private List<Photo> f12647f = new ArrayList();
    private String f12648g;
    private String f12649h;

    public String getTitle() {
        return this.f12642a;
    }

    public void setTitle(String str) {
        this.f12642a = str;
    }

    public String getDetail() {
        return this.f12643b;
    }

    public void setDetail(String str) {
        this.f12643b = str;
    }

    public Date getStartTime() {
        if (this.f12644c == null) {
            return null;
        }
        return (Date) this.f12644c.clone();
    }

    public void setStartTime(Date date) {
        if (date == null) {
            this.f12644c = null;
        } else {
            this.f12644c = (Date) date.clone();
        }
    }

    public Date getEndTime() {
        if (this.f12645d == null) {
            return null;
        }
        return (Date) this.f12645d.clone();
    }

    public void setEndTime(Date date) {
        if (date == null) {
            this.f12645d = null;
        } else {
            this.f12645d = (Date) date.clone();
        }
    }

    public int getSoldCount() {
        return this.f12646e;
    }

    public void setSoldCount(int i) {
        this.f12646e = i;
    }

    public List<Photo> getPhotos() {
        return this.f12647f;
    }

    public void addPhotos(Photo photo) {
        this.f12647f.add(photo);
    }

    public void initPhotos(List<Photo> list) {
        if (list != null && list.size() != 0) {
            this.f12647f.clear();
            for (Photo add : list) {
                this.f12647f.add(add);
            }
        }
    }

    public String getUrl() {
        return this.f12648g;
    }

    public void setUrl(String str) {
        this.f12648g = str;
    }

    public String getProvider() {
        return this.f12649h;
    }

    public void setProvider(String str) {
        this.f12649h = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12642a);
        parcel.writeString(this.f12643b);
        parcel.writeString(C3409d.m16879a(this.f12644c));
        parcel.writeString(C3409d.m16879a(this.f12645d));
        parcel.writeInt(this.f12646e);
        parcel.writeTypedList(this.f12647f);
        parcel.writeString(this.f12648g);
        parcel.writeString(this.f12649h);
    }

    public Discount(Parcel parcel) {
        this.f12642a = parcel.readString();
        this.f12643b = parcel.readString();
        this.f12644c = C3409d.m16886e(parcel.readString());
        this.f12645d = C3409d.m16886e(parcel.readString());
        this.f12646e = parcel.readInt();
        this.f12647f = parcel.createTypedArrayList(Photo.CREATOR);
        this.f12648g = parcel.readString();
        this.f12649h = parcel.readString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f12642a == null ? 0 : this.f12642a.hashCode()) + (((this.f12644c == null ? 0 : this.f12644c.hashCode()) + (((((this.f12649h == null ? 0 : this.f12649h.hashCode()) + (((this.f12647f == null ? 0 : this.f12647f.hashCode()) + (((this.f12645d == null ? 0 : this.f12645d.hashCode()) + (((this.f12643b == null ? 0 : this.f12643b.hashCode()) + 31) * 31)) * 31)) * 31)) * 31) + this.f12646e) * 31)) * 31)) * 31;
        if (this.f12648g != null) {
            i = this.f12648g.hashCode();
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
        Discount discount = (Discount) obj;
        if (this.f12643b == null) {
            if (discount.f12643b != null) {
                return false;
            }
        } else if (!this.f12643b.equals(discount.f12643b)) {
            return false;
        }
        if (this.f12645d == null) {
            if (discount.f12645d != null) {
                return false;
            }
        } else if (!this.f12645d.equals(discount.f12645d)) {
            return false;
        }
        if (this.f12647f == null) {
            if (discount.f12647f != null) {
                return false;
            }
        } else if (!this.f12647f.equals(discount.f12647f)) {
            return false;
        }
        if (this.f12649h == null) {
            if (discount.f12649h != null) {
                return false;
            }
        } else if (!this.f12649h.equals(discount.f12649h)) {
            return false;
        }
        if (this.f12646e != discount.f12646e) {
            return false;
        }
        if (this.f12644c == null) {
            if (discount.f12644c != null) {
                return false;
            }
        } else if (!this.f12644c.equals(discount.f12644c)) {
            return false;
        }
        if (this.f12642a == null) {
            if (discount.f12642a != null) {
                return false;
            }
        } else if (!this.f12642a.equals(discount.f12642a)) {
            return false;
        }
        if (this.f12648g == null) {
            if (discount.f12648g != null) {
                return false;
            }
            return true;
        } else if (this.f12648g.equals(discount.f12648g)) {
            return true;
        } else {
            return false;
        }
    }
}
