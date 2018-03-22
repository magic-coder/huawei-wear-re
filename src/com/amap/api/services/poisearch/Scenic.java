package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public final class Scenic implements Parcelable {
    public static final Creator<Scenic> CREATOR = new C3464k();
    private String f12718a;
    private String f12719b;
    private String f12720c;
    private String f12721d;
    private String f12722e;
    private String f12723f;
    private String f12724g;
    private String f12725h;
    private String f12726i;
    private String f12727j;
    private String f12728k;
    private String f12729l;
    private List<Photo> f12730m = new ArrayList();

    public String getIntro() {
        return this.f12718a;
    }

    public void setIntro(String str) {
        this.f12718a = str;
    }

    public String getRating() {
        return this.f12719b;
    }

    public void setRating(String str) {
        this.f12719b = str;
    }

    public String getDeepsrc() {
        return this.f12720c;
    }

    public void setDeepsrc(String str) {
        this.f12720c = str;
    }

    public String getLevel() {
        return this.f12721d;
    }

    public void setLevel(String str) {
        this.f12721d = str;
    }

    public String getPrice() {
        return this.f12722e;
    }

    public void setPrice(String str) {
        this.f12722e = str;
    }

    public String getSeason() {
        return this.f12723f;
    }

    public void setSeason(String str) {
        this.f12723f = str;
    }

    public String getRecommend() {
        return this.f12724g;
    }

    public void setRecommend(String str) {
        this.f12724g = str;
    }

    public String getTheme() {
        return this.f12725h;
    }

    public void setTheme(String str) {
        this.f12725h = str;
    }

    public String getOrderWapUrl() {
        return this.f12726i;
    }

    public void setOrderWapUrl(String str) {
        this.f12726i = str;
    }

    public String getOrderWebUrl() {
        return this.f12727j;
    }

    public void setOrderWebUrl(String str) {
        this.f12727j = str;
    }

    public String getOpentimeGDF() {
        return this.f12728k;
    }

    public void setOpentimeGDF(String str) {
        this.f12728k = str;
    }

    public String getOpentime() {
        return this.f12729l;
    }

    public void setOpentime(String str) {
        this.f12729l = str;
    }

    public List<Photo> getPhotos() {
        return this.f12730m;
    }

    public void setPhotos(List<Photo> list) {
        this.f12730m = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12718a);
        parcel.writeString(this.f12719b);
        parcel.writeString(this.f12720c);
        parcel.writeString(this.f12721d);
        parcel.writeString(this.f12722e);
        parcel.writeString(this.f12723f);
        parcel.writeString(this.f12724g);
        parcel.writeString(this.f12725h);
        parcel.writeString(this.f12726i);
        parcel.writeString(this.f12727j);
        parcel.writeString(this.f12728k);
        parcel.writeString(this.f12729l);
        parcel.writeTypedList(this.f12730m);
    }

    public Scenic(Parcel parcel) {
        this.f12718a = parcel.readString();
        this.f12719b = parcel.readString();
        this.f12720c = parcel.readString();
        this.f12721d = parcel.readString();
        this.f12722e = parcel.readString();
        this.f12723f = parcel.readString();
        this.f12724g = parcel.readString();
        this.f12725h = parcel.readString();
        this.f12726i = parcel.readString();
        this.f12727j = parcel.readString();
        this.f12728k = parcel.readString();
        this.f12729l = parcel.readString();
        this.f12730m = parcel.createTypedArrayList(Photo.CREATOR);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f12723f == null ? 0 : this.f12723f.hashCode()) + (((this.f12724g == null ? 0 : this.f12724g.hashCode()) + (((this.f12719b == null ? 0 : this.f12719b.hashCode()) + (((this.f12722e == null ? 0 : this.f12722e.hashCode()) + (((this.f12730m == null ? 0 : this.f12730m.hashCode()) + (((this.f12727j == null ? 0 : this.f12727j.hashCode()) + (((this.f12726i == null ? 0 : this.f12726i.hashCode()) + (((this.f12728k == null ? 0 : this.f12728k.hashCode()) + (((this.f12729l == null ? 0 : this.f12729l.hashCode()) + (((this.f12721d == null ? 0 : this.f12721d.hashCode()) + (((this.f12718a == null ? 0 : this.f12718a.hashCode()) + (((this.f12720c == null ? 0 : this.f12720c.hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.f12725h != null) {
            i = this.f12725h.hashCode();
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
        Scenic scenic = (Scenic) obj;
        if (this.f12720c == null) {
            if (scenic.f12720c != null) {
                return false;
            }
        } else if (!this.f12720c.equals(scenic.f12720c)) {
            return false;
        }
        if (this.f12718a == null) {
            if (scenic.f12718a != null) {
                return false;
            }
        } else if (!this.f12718a.equals(scenic.f12718a)) {
            return false;
        }
        if (this.f12721d == null) {
            if (scenic.f12721d != null) {
                return false;
            }
        } else if (!this.f12721d.equals(scenic.f12721d)) {
            return false;
        }
        if (this.f12729l == null) {
            if (scenic.f12729l != null) {
                return false;
            }
        } else if (!this.f12729l.equals(scenic.f12729l)) {
            return false;
        }
        if (this.f12728k == null) {
            if (scenic.f12728k != null) {
                return false;
            }
        } else if (!this.f12728k.equals(scenic.f12728k)) {
            return false;
        }
        if (this.f12726i == null) {
            if (scenic.f12726i != null) {
                return false;
            }
        } else if (!this.f12726i.equals(scenic.f12726i)) {
            return false;
        }
        if (this.f12727j == null) {
            if (scenic.f12727j != null) {
                return false;
            }
        } else if (!this.f12727j.equals(scenic.f12727j)) {
            return false;
        }
        if (this.f12730m == null) {
            if (scenic.f12730m != null) {
                return false;
            }
        } else if (!this.f12730m.equals(scenic.f12730m)) {
            return false;
        }
        if (this.f12722e == null) {
            if (scenic.f12722e != null) {
                return false;
            }
        } else if (!this.f12722e.equals(scenic.f12722e)) {
            return false;
        }
        if (this.f12719b == null) {
            if (scenic.f12719b != null) {
                return false;
            }
        } else if (!this.f12719b.equals(scenic.f12719b)) {
            return false;
        }
        if (this.f12724g == null) {
            if (scenic.f12724g != null) {
                return false;
            }
        } else if (!this.f12724g.equals(scenic.f12724g)) {
            return false;
        }
        if (this.f12723f == null) {
            if (scenic.f12723f != null) {
                return false;
            }
        } else if (!this.f12723f.equals(scenic.f12723f)) {
            return false;
        }
        if (this.f12725h == null) {
            if (scenic.f12725h != null) {
                return false;
            }
            return true;
        } else if (this.f12725h.equals(scenic.f12725h)) {
            return true;
        } else {
            return false;
        }
    }
}
