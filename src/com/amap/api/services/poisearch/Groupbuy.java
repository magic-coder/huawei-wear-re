package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.C3409d;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class Groupbuy implements Parcelable {
    public static final Creator<Groupbuy> CREATOR = new C3457d();
    private String f12650a;
    private String f12651b;
    private String f12652c;
    private Date f12653d;
    private Date f12654e;
    private int f12655f;
    private int f12656g;
    private float f12657h;
    private float f12658i;
    private float f12659j;
    private String f12660k;
    private String f12661l;
    private List<Photo> f12662m = new ArrayList();
    private String f12663n;
    private String f12664o;

    public String getTypeCode() {
        return this.f12650a;
    }

    public void setTypeCode(String str) {
        this.f12650a = str;
    }

    public String getTypeDes() {
        return this.f12651b;
    }

    public void setTypeDes(String str) {
        this.f12651b = str;
    }

    public String getDetail() {
        return this.f12652c;
    }

    public void setDetail(String str) {
        this.f12652c = str;
    }

    public Date getStartTime() {
        if (this.f12653d == null) {
            return null;
        }
        return (Date) this.f12653d.clone();
    }

    public void setStartTime(Date date) {
        if (date == null) {
            this.f12653d = null;
        } else {
            this.f12653d = (Date) date.clone();
        }
    }

    public Date getEndTime() {
        if (this.f12654e == null) {
            return null;
        }
        return (Date) this.f12654e.clone();
    }

    public void setEndTime(Date date) {
        if (date == null) {
            this.f12654e = null;
        } else {
            this.f12654e = (Date) date.clone();
        }
    }

    public int getCount() {
        return this.f12655f;
    }

    public void setCount(int i) {
        this.f12655f = i;
    }

    public int getSoldCount() {
        return this.f12656g;
    }

    public void setSoldCount(int i) {
        this.f12656g = i;
    }

    public float getOriginalPrice() {
        return this.f12657h;
    }

    public void setOriginalPrice(float f) {
        this.f12657h = f;
    }

    public float getGroupbuyPrice() {
        return this.f12658i;
    }

    public void setGroupbuyPrice(float f) {
        this.f12658i = f;
    }

    public float getDiscount() {
        return this.f12659j;
    }

    public void setDiscount(float f) {
        this.f12659j = f;
    }

    public String getTicketAddress() {
        return this.f12660k;
    }

    public void setTicketAddress(String str) {
        this.f12660k = str;
    }

    public String getTicketTel() {
        return this.f12661l;
    }

    public void setTicketTel(String str) {
        this.f12661l = str;
    }

    public List<Photo> getPhotos() {
        return this.f12662m;
    }

    public void addPhotos(Photo photo) {
        this.f12662m.add(photo);
    }

    public void initPhotos(List<Photo> list) {
        if (list != null && list.size() != 0) {
            this.f12662m.clear();
            for (Photo add : list) {
                this.f12662m.add(add);
            }
        }
    }

    public String getUrl() {
        return this.f12663n;
    }

    public void setUrl(String str) {
        this.f12663n = str;
    }

    public String getProvider() {
        return this.f12664o;
    }

    public void setProvider(String str) {
        this.f12664o = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12650a);
        parcel.writeString(this.f12651b);
        parcel.writeString(this.f12652c);
        parcel.writeString(C3409d.m16879a(this.f12653d));
        parcel.writeString(C3409d.m16879a(this.f12654e));
        parcel.writeInt(this.f12655f);
        parcel.writeInt(this.f12656g);
        parcel.writeFloat(this.f12657h);
        parcel.writeFloat(this.f12658i);
        parcel.writeFloat(this.f12659j);
        parcel.writeString(this.f12660k);
        parcel.writeString(this.f12661l);
        parcel.writeTypedList(this.f12662m);
        parcel.writeString(this.f12663n);
        parcel.writeString(this.f12664o);
    }

    public Groupbuy(Parcel parcel) {
        this.f12650a = parcel.readString();
        this.f12651b = parcel.readString();
        this.f12652c = parcel.readString();
        this.f12653d = C3409d.m16886e(parcel.readString());
        this.f12654e = C3409d.m16886e(parcel.readString());
        this.f12655f = parcel.readInt();
        this.f12656g = parcel.readInt();
        this.f12657h = parcel.readFloat();
        this.f12658i = parcel.readFloat();
        this.f12659j = parcel.readFloat();
        this.f12660k = parcel.readString();
        this.f12661l = parcel.readString();
        this.f12662m = parcel.createTypedArrayList(Photo.CREATOR);
        this.f12663n = parcel.readString();
        this.f12664o = parcel.readString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f12651b == null ? 0 : this.f12651b.hashCode()) + (((this.f12650a == null ? 0 : this.f12650a.hashCode()) + (((this.f12661l == null ? 0 : this.f12661l.hashCode()) + (((this.f12660k == null ? 0 : this.f12660k.hashCode()) + (((this.f12653d == null ? 0 : this.f12653d.hashCode()) + (((((this.f12664o == null ? 0 : this.f12664o.hashCode()) + (((this.f12662m == null ? 0 : this.f12662m.hashCode()) + (((((((this.f12654e == null ? 0 : this.f12654e.hashCode()) + (((((this.f12652c == null ? 0 : this.f12652c.hashCode()) + ((this.f12655f + 31) * 31)) * 31) + Float.floatToIntBits(this.f12659j)) * 31)) * 31) + Float.floatToIntBits(this.f12658i)) * 31) + Float.floatToIntBits(this.f12657h)) * 31)) * 31)) * 31) + this.f12656g) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.f12663n != null) {
            i = this.f12663n.hashCode();
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
        Groupbuy groupbuy = (Groupbuy) obj;
        if (this.f12655f != groupbuy.f12655f) {
            return false;
        }
        if (this.f12652c == null) {
            if (groupbuy.f12652c != null) {
                return false;
            }
        } else if (!this.f12652c.equals(groupbuy.f12652c)) {
            return false;
        }
        if (Float.floatToIntBits(this.f12659j) != Float.floatToIntBits(groupbuy.f12659j)) {
            return false;
        }
        if (this.f12654e == null) {
            if (groupbuy.f12654e != null) {
                return false;
            }
        } else if (!this.f12654e.equals(groupbuy.f12654e)) {
            return false;
        }
        if (Float.floatToIntBits(this.f12658i) != Float.floatToIntBits(groupbuy.f12658i)) {
            return false;
        }
        if (Float.floatToIntBits(this.f12657h) != Float.floatToIntBits(groupbuy.f12657h)) {
            return false;
        }
        if (this.f12662m == null) {
            if (groupbuy.f12662m != null) {
                return false;
            }
        } else if (!this.f12662m.equals(groupbuy.f12662m)) {
            return false;
        }
        if (this.f12664o == null) {
            if (groupbuy.f12664o != null) {
                return false;
            }
        } else if (!this.f12664o.equals(groupbuy.f12664o)) {
            return false;
        }
        if (this.f12656g != groupbuy.f12656g) {
            return false;
        }
        if (this.f12653d == null) {
            if (groupbuy.f12653d != null) {
                return false;
            }
        } else if (!this.f12653d.equals(groupbuy.f12653d)) {
            return false;
        }
        if (this.f12660k == null) {
            if (groupbuy.f12660k != null) {
                return false;
            }
        } else if (!this.f12660k.equals(groupbuy.f12660k)) {
            return false;
        }
        if (this.f12661l == null) {
            if (groupbuy.f12661l != null) {
                return false;
            }
        } else if (!this.f12661l.equals(groupbuy.f12661l)) {
            return false;
        }
        if (this.f12650a == null) {
            if (groupbuy.f12650a != null) {
                return false;
            }
        } else if (!this.f12650a.equals(groupbuy.f12650a)) {
            return false;
        }
        if (this.f12651b == null) {
            if (groupbuy.f12651b != null) {
                return false;
            }
        } else if (!this.f12651b.equals(groupbuy.f12651b)) {
            return false;
        }
        if (this.f12663n == null) {
            if (groupbuy.f12663n != null) {
                return false;
            }
            return true;
        } else if (this.f12663n.equals(groupbuy.f12663n)) {
            return true;
        } else {
            return false;
        }
    }
}
