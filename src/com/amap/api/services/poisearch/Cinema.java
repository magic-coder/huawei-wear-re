package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public final class Cinema implements Parcelable {
    public static final Creator<Cinema> CREATOR = new C3454a();
    private boolean f12614a;
    private String f12615b;
    private String f12616c;
    private String f12617d;
    private String f12618e;
    private String f12619f;
    private String f12620g;
    private List<Photo> f12621h = new ArrayList();

    public boolean isSeatOrdering() {
        return this.f12614a;
    }

    public void setSeatOrdering(boolean z) {
        this.f12614a = z;
    }

    public String getIntro() {
        return this.f12615b;
    }

    public void setIntro(String str) {
        this.f12615b = str;
    }

    public String getRating() {
        return this.f12616c;
    }

    public void setRating(String str) {
        this.f12616c = str;
    }

    public String getDeepsrc() {
        return this.f12617d;
    }

    public void setDeepsrc(String str) {
        this.f12617d = str;
    }

    public String getParking() {
        return this.f12618e;
    }

    public void setParking(String str) {
        this.f12618e = str;
    }

    public String getOpentimeGDF() {
        return this.f12619f;
    }

    public void setOpentimeGDF(String str) {
        this.f12619f = str;
    }

    public String getOpentime() {
        return this.f12620g;
    }

    public void setOpentime(String str) {
        this.f12620g = str;
    }

    public List<Photo> getPhotos() {
        return this.f12621h;
    }

    public void setPhotos(List<Photo> list) {
        this.f12621h = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBooleanArray(new boolean[]{this.f12614a});
        parcel.writeString(this.f12615b);
        parcel.writeString(this.f12616c);
        parcel.writeString(this.f12617d);
        parcel.writeString(this.f12618e);
        parcel.writeString(this.f12619f);
        parcel.writeString(this.f12620g);
        parcel.writeTypedList(this.f12621h);
    }

    public Cinema(Parcel parcel) {
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.f12614a = zArr[0];
        this.f12615b = parcel.readString();
        this.f12616c = parcel.readString();
        this.f12617d = parcel.readString();
        this.f12618e = parcel.readString();
        this.f12619f = parcel.readString();
        this.f12620g = parcel.readString();
        this.f12621h = parcel.createTypedArrayList(Photo.CREATOR);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f12621h == null ? 0 : this.f12621h.hashCode()) + (((this.f12618e == null ? 0 : this.f12618e.hashCode()) + (((this.f12619f == null ? 0 : this.f12619f.hashCode()) + (((this.f12620g == null ? 0 : this.f12620g.hashCode()) + (((this.f12615b == null ? 0 : this.f12615b.hashCode()) + (((this.f12617d == null ? 0 : this.f12617d.hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.f12616c != null) {
            i = this.f12616c.hashCode();
        }
        return (this.f12614a ? 1231 : 1237) + ((hashCode + i) * 31);
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
        Cinema cinema = (Cinema) obj;
        if (this.f12617d == null) {
            if (cinema.f12617d != null) {
                return false;
            }
        } else if (!this.f12617d.equals(cinema.f12617d)) {
            return false;
        }
        if (this.f12615b == null) {
            if (cinema.f12615b != null) {
                return false;
            }
        } else if (!this.f12615b.equals(cinema.f12615b)) {
            return false;
        }
        if (this.f12620g == null) {
            if (cinema.f12620g != null) {
                return false;
            }
        } else if (!this.f12620g.equals(cinema.f12620g)) {
            return false;
        }
        if (this.f12619f == null) {
            if (cinema.f12619f != null) {
                return false;
            }
        } else if (!this.f12619f.equals(cinema.f12619f)) {
            return false;
        }
        if (this.f12618e == null) {
            if (cinema.f12618e != null) {
                return false;
            }
        } else if (!this.f12618e.equals(cinema.f12618e)) {
            return false;
        }
        if (this.f12621h == null) {
            if (cinema.f12621h != null) {
                return false;
            }
        } else if (!this.f12621h.equals(cinema.f12621h)) {
            return false;
        }
        if (this.f12616c == null) {
            if (cinema.f12616c != null) {
                return false;
            }
        } else if (!this.f12616c.equals(cinema.f12616c)) {
            return false;
        }
        if (this.f12614a != cinema.f12614a) {
            return false;
        }
        return true;
    }
}
