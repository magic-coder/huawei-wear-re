package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public final class Dining implements Parcelable {
    public static final Creator<Dining> CREATOR = new C3455b();
    private boolean f12622a;
    private String f12623b;
    private String f12624c;
    private String f12625d;
    private String f12626e;
    private String f12627f;
    private String f12628g;
    private String f12629h;
    private String f12630i;
    private String f12631j;
    private String f12632k;
    private String f12633l;
    private String f12634m;
    private String f12635n;
    private String f12636o;
    private String f12637p;
    private String f12638q;
    private String f12639r;
    private String f12640s;
    private List<Photo> f12641t = new ArrayList();

    public boolean isMealOrdering() {
        return this.f12622a;
    }

    public void setMealOrdering(boolean z) {
        this.f12622a = z;
    }

    public String getCuisines() {
        return this.f12623b;
    }

    public void setCuisines(String str) {
        this.f12623b = str;
    }

    public String getTag() {
        return this.f12624c;
    }

    public void setTag(String str) {
        this.f12624c = str;
    }

    public String getIntro() {
        return this.f12625d;
    }

    public void setIntro(String str) {
        this.f12625d = str;
    }

    public String getRating() {
        return this.f12626e;
    }

    public void setRating(String str) {
        this.f12626e = str;
    }

    public String getCpRating() {
        return this.f12627f;
    }

    public void setCpRating(String str) {
        this.f12627f = str;
    }

    public String getDeepsrc() {
        return this.f12628g;
    }

    public void setDeepsrc(String str) {
        this.f12628g = str;
    }

    public String getTasteRating() {
        return this.f12629h;
    }

    public void setTasteRating(String str) {
        this.f12629h = str;
    }

    public String getEnvironmentRating() {
        return this.f12630i;
    }

    public void setEnvironmentRating(String str) {
        this.f12630i = str;
    }

    public String getServiceRating() {
        return this.f12631j;
    }

    public void setServiceRating(String str) {
        this.f12631j = str;
    }

    public String getCost() {
        return this.f12632k;
    }

    public void setCost(String str) {
        this.f12632k = str;
    }

    public String getRecommend() {
        return this.f12633l;
    }

    public void setRecommend(String str) {
        this.f12633l = str;
    }

    public String getAtmosphere() {
        return this.f12634m;
    }

    public void setAtmosphere(String str) {
        this.f12634m = str;
    }

    public String getOrderingWapUrl() {
        return this.f12635n;
    }

    public void setOrderingWapUrl(String str) {
        this.f12635n = str;
    }

    public String getOrderingWebUrl() {
        return this.f12636o;
    }

    public void setOrderingWebUrl(String str) {
        this.f12636o = str;
    }

    public String getOrderinAppUrl() {
        return this.f12637p;
    }

    public void setOrderinAppUrl(String str) {
        this.f12637p = str;
    }

    public String getOpentimeGDF() {
        return this.f12638q;
    }

    public void setOpentimeGDF(String str) {
        this.f12638q = str;
    }

    public String getOpentime() {
        return this.f12639r;
    }

    public void setOpentime(String str) {
        this.f12639r = str;
    }

    public String getAddition() {
        return this.f12640s;
    }

    public void setAddition(String str) {
        this.f12640s = str;
    }

    public List<Photo> getPhotos() {
        return this.f12641t;
    }

    public void setPhotos(List<Photo> list) {
        this.f12641t = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBooleanArray(new boolean[]{this.f12622a});
        parcel.writeString(this.f12623b);
        parcel.writeString(this.f12624c);
        parcel.writeString(this.f12625d);
        parcel.writeString(this.f12626e);
        parcel.writeString(this.f12627f);
        parcel.writeString(this.f12628g);
        parcel.writeString(this.f12629h);
        parcel.writeString(this.f12630i);
        parcel.writeString(this.f12631j);
        parcel.writeString(this.f12632k);
        parcel.writeString(this.f12633l);
        parcel.writeString(this.f12634m);
        parcel.writeString(this.f12635n);
        parcel.writeString(this.f12636o);
        parcel.writeString(this.f12637p);
        parcel.writeString(this.f12638q);
        parcel.writeString(this.f12639r);
        parcel.writeString(this.f12640s);
        parcel.writeTypedList(this.f12641t);
    }

    public Dining(Parcel parcel) {
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.f12622a = zArr[0];
        this.f12623b = parcel.readString();
        this.f12624c = parcel.readString();
        this.f12625d = parcel.readString();
        this.f12626e = parcel.readString();
        this.f12627f = parcel.readString();
        this.f12628g = parcel.readString();
        this.f12629h = parcel.readString();
        this.f12630i = parcel.readString();
        this.f12631j = parcel.readString();
        this.f12632k = parcel.readString();
        this.f12633l = parcel.readString();
        this.f12634m = parcel.readString();
        this.f12635n = parcel.readString();
        this.f12636o = parcel.readString();
        this.f12637p = parcel.readString();
        this.f12638q = parcel.readString();
        this.f12639r = parcel.readString();
        this.f12640s = parcel.readString();
        this.f12641t = parcel.createTypedArrayList(Photo.CREATOR);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f12624c == null ? 0 : this.f12624c.hashCode()) + (((this.f12631j == null ? 0 : this.f12631j.hashCode()) + (((this.f12633l == null ? 0 : this.f12633l.hashCode()) + (((this.f12626e == null ? 0 : this.f12626e.hashCode()) + (((this.f12641t == null ? 0 : this.f12641t.hashCode()) + (((this.f12636o == null ? 0 : this.f12636o.hashCode()) + (((this.f12635n == null ? 0 : this.f12635n.hashCode()) + (((this.f12637p == null ? 0 : this.f12637p.hashCode()) + (((this.f12638q == null ? 0 : this.f12638q.hashCode()) + (((this.f12639r == null ? 0 : this.f12639r.hashCode()) + (((this.f12622a ? 1231 : 1237) + (((this.f12625d == null ? 0 : this.f12625d.hashCode()) + (((this.f12630i == null ? 0 : this.f12630i.hashCode()) + (((this.f12628g == null ? 0 : this.f12628g.hashCode()) + (((this.f12623b == null ? 0 : this.f12623b.hashCode()) + (((this.f12627f == null ? 0 : this.f12627f.hashCode()) + (((this.f12632k == null ? 0 : this.f12632k.hashCode()) + (((this.f12634m == null ? 0 : this.f12634m.hashCode()) + (((this.f12640s == null ? 0 : this.f12640s.hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.f12629h != null) {
            i = this.f12629h.hashCode();
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
        Dining dining = (Dining) obj;
        if (this.f12640s == null) {
            if (dining.f12640s != null) {
                return false;
            }
        } else if (!this.f12640s.equals(dining.f12640s)) {
            return false;
        }
        if (this.f12634m == null) {
            if (dining.f12634m != null) {
                return false;
            }
        } else if (!this.f12634m.equals(dining.f12634m)) {
            return false;
        }
        if (this.f12632k == null) {
            if (dining.f12632k != null) {
                return false;
            }
        } else if (!this.f12632k.equals(dining.f12632k)) {
            return false;
        }
        if (this.f12627f == null) {
            if (dining.f12627f != null) {
                return false;
            }
        } else if (!this.f12627f.equals(dining.f12627f)) {
            return false;
        }
        if (this.f12623b == null) {
            if (dining.f12623b != null) {
                return false;
            }
        } else if (!this.f12623b.equals(dining.f12623b)) {
            return false;
        }
        if (this.f12628g == null) {
            if (dining.f12628g != null) {
                return false;
            }
        } else if (!this.f12628g.equals(dining.f12628g)) {
            return false;
        }
        if (this.f12630i == null) {
            if (dining.f12630i != null) {
                return false;
            }
        } else if (!this.f12630i.equals(dining.f12630i)) {
            return false;
        }
        if (this.f12625d == null) {
            if (dining.f12625d != null) {
                return false;
            }
        } else if (!this.f12625d.equals(dining.f12625d)) {
            return false;
        }
        if (this.f12622a != dining.f12622a) {
            return false;
        }
        if (this.f12639r == null) {
            if (dining.f12639r != null) {
                return false;
            }
        } else if (!this.f12639r.equals(dining.f12639r)) {
            return false;
        }
        if (this.f12638q == null) {
            if (dining.f12638q != null) {
                return false;
            }
        } else if (!this.f12638q.equals(dining.f12638q)) {
            return false;
        }
        if (this.f12637p == null) {
            if (dining.f12637p != null) {
                return false;
            }
        } else if (!this.f12637p.equals(dining.f12637p)) {
            return false;
        }
        if (this.f12635n == null) {
            if (dining.f12635n != null) {
                return false;
            }
        } else if (!this.f12635n.equals(dining.f12635n)) {
            return false;
        }
        if (this.f12636o == null) {
            if (dining.f12636o != null) {
                return false;
            }
        } else if (!this.f12636o.equals(dining.f12636o)) {
            return false;
        }
        if (this.f12641t == null) {
            if (dining.f12641t != null) {
                return false;
            }
        } else if (!this.f12641t.equals(dining.f12641t)) {
            return false;
        }
        if (this.f12626e == null) {
            if (dining.f12626e != null) {
                return false;
            }
        } else if (!this.f12626e.equals(dining.f12626e)) {
            return false;
        }
        if (this.f12633l == null) {
            if (dining.f12633l != null) {
                return false;
            }
        } else if (!this.f12633l.equals(dining.f12633l)) {
            return false;
        }
        if (this.f12631j == null) {
            if (dining.f12631j != null) {
                return false;
            }
        } else if (!this.f12631j.equals(dining.f12631j)) {
            return false;
        }
        if (this.f12624c == null) {
            if (dining.f12624c != null) {
                return false;
            }
        } else if (!this.f12624c.equals(dining.f12624c)) {
            return false;
        }
        if (this.f12629h == null) {
            if (dining.f12629h != null) {
                return false;
            }
            return true;
        } else if (this.f12629h.equals(dining.f12629h)) {
            return true;
        } else {
            return false;
        }
    }
}
