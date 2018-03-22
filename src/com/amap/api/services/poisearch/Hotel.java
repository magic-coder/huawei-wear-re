package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public final class Hotel implements Parcelable {
    public static final Creator<Hotel> CREATOR = new C3458e();
    private String f12665a;
    private String f12666b;
    private String f12667c;
    private String f12668d;
    private String f12669e;
    private String f12670f;
    private String f12671g;
    private String f12672h;
    private String f12673i;
    private String f12674j;
    private String f12675k;
    private List<Photo> f12676l = new ArrayList();

    public String getRating() {
        return this.f12665a;
    }

    public void setRating(String str) {
        this.f12665a = str;
    }

    public String getStar() {
        return this.f12666b;
    }

    public void setStar(String str) {
        this.f12666b = str;
    }

    public String getIntro() {
        return this.f12667c;
    }

    public void setIntro(String str) {
        this.f12667c = str;
    }

    public String getLowestPrice() {
        return this.f12668d;
    }

    public void setLowestPrice(String str) {
        this.f12668d = str;
    }

    public String getFaciRating() {
        return this.f12669e;
    }

    public void setFaciRating(String str) {
        this.f12669e = str;
    }

    public String getHealthRating() {
        return this.f12670f;
    }

    public void setHealthRating(String str) {
        this.f12670f = str;
    }

    public String getEnvironmentRating() {
        return this.f12671g;
    }

    public void setEnvironmentRating(String str) {
        this.f12671g = str;
    }

    public String getServiceRating() {
        return this.f12672h;
    }

    public void setServiceRating(String str) {
        this.f12672h = str;
    }

    public String getTraffic() {
        return this.f12673i;
    }

    public void setTraffic(String str) {
        this.f12673i = str;
    }

    public String getAddition() {
        return this.f12674j;
    }

    public void setAddition(String str) {
        this.f12674j = str;
    }

    public String getDeepsrc() {
        return this.f12675k;
    }

    public void setDeepsrc(String str) {
        this.f12675k = str;
    }

    public List<Photo> getPhotos() {
        return this.f12676l;
    }

    public void setPhotos(List<Photo> list) {
        this.f12676l = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12665a);
        parcel.writeString(this.f12666b);
        parcel.writeString(this.f12667c);
        parcel.writeString(this.f12668d);
        parcel.writeString(this.f12669e);
        parcel.writeString(this.f12670f);
        parcel.writeString(this.f12671g);
        parcel.writeString(this.f12672h);
        parcel.writeString(this.f12673i);
        parcel.writeString(this.f12674j);
        parcel.writeString(this.f12675k);
        parcel.writeTypedList(this.f12676l);
    }

    public Hotel(Parcel parcel) {
        this.f12665a = parcel.readString();
        this.f12666b = parcel.readString();
        this.f12667c = parcel.readString();
        this.f12668d = parcel.readString();
        this.f12669e = parcel.readString();
        this.f12670f = parcel.readString();
        this.f12671g = parcel.readString();
        this.f12672h = parcel.readString();
        this.f12673i = parcel.readString();
        this.f12674j = parcel.readString();
        this.f12675k = parcel.readString();
        this.f12676l = parcel.createTypedArrayList(Photo.CREATOR);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f12666b == null ? 0 : this.f12666b.hashCode()) + (((this.f12672h == null ? 0 : this.f12672h.hashCode()) + (((this.f12665a == null ? 0 : this.f12665a.hashCode()) + (((this.f12676l == null ? 0 : this.f12676l.hashCode()) + (((this.f12668d == null ? 0 : this.f12668d.hashCode()) + (((this.f12667c == null ? 0 : this.f12667c.hashCode()) + (((this.f12670f == null ? 0 : this.f12670f.hashCode()) + (((this.f12669e == null ? 0 : this.f12669e.hashCode()) + (((this.f12671g == null ? 0 : this.f12671g.hashCode()) + (((this.f12675k == null ? 0 : this.f12675k.hashCode()) + (((this.f12674j == null ? 0 : this.f12674j.hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.f12673i != null) {
            i = this.f12673i.hashCode();
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
        Hotel hotel = (Hotel) obj;
        if (this.f12674j == null) {
            if (hotel.f12674j != null) {
                return false;
            }
        } else if (!this.f12674j.equals(hotel.f12674j)) {
            return false;
        }
        if (this.f12675k == null) {
            if (hotel.f12675k != null) {
                return false;
            }
        } else if (!this.f12675k.equals(hotel.f12675k)) {
            return false;
        }
        if (this.f12671g == null) {
            if (hotel.f12671g != null) {
                return false;
            }
        } else if (!this.f12671g.equals(hotel.f12671g)) {
            return false;
        }
        if (this.f12669e == null) {
            if (hotel.f12669e != null) {
                return false;
            }
        } else if (!this.f12669e.equals(hotel.f12669e)) {
            return false;
        }
        if (this.f12670f == null) {
            if (hotel.f12670f != null) {
                return false;
            }
        } else if (!this.f12670f.equals(hotel.f12670f)) {
            return false;
        }
        if (this.f12667c == null) {
            if (hotel.f12667c != null) {
                return false;
            }
        } else if (!this.f12667c.equals(hotel.f12667c)) {
            return false;
        }
        if (this.f12668d == null) {
            if (hotel.f12668d != null) {
                return false;
            }
        } else if (!this.f12668d.equals(hotel.f12668d)) {
            return false;
        }
        if (this.f12676l == null) {
            if (hotel.f12676l != null) {
                return false;
            }
        } else if (!this.f12676l.equals(hotel.f12676l)) {
            return false;
        }
        if (this.f12665a == null) {
            if (hotel.f12665a != null) {
                return false;
            }
        } else if (!this.f12665a.equals(hotel.f12665a)) {
            return false;
        }
        if (this.f12672h == null) {
            if (hotel.f12672h != null) {
                return false;
            }
        } else if (!this.f12672h.equals(hotel.f12672h)) {
            return false;
        }
        if (this.f12666b == null) {
            if (hotel.f12666b != null) {
                return false;
            }
        } else if (!this.f12666b.equals(hotel.f12666b)) {
            return false;
        }
        if (this.f12673i == null) {
            if (hotel.f12673i != null) {
                return false;
            }
            return true;
        } else if (this.f12673i.equals(hotel.f12673i)) {
            return true;
        } else {
            return false;
        }
    }
}
