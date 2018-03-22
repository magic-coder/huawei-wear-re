package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

public class WalkStep implements Parcelable {
    public static final Creator<WalkStep> CREATOR = new C3490u();
    private String f12827a;
    private String f12828b;
    private String f12829c;
    private float f12830d;
    private float f12831e;
    private List<LatLonPoint> f12832f = new ArrayList();
    private String f12833g;
    private String f12834h;

    public String getInstruction() {
        return this.f12827a;
    }

    public void setInstruction(String str) {
        this.f12827a = str;
    }

    public String getOrientation() {
        return this.f12828b;
    }

    public void setOrientation(String str) {
        this.f12828b = str;
    }

    public String getRoad() {
        return this.f12829c;
    }

    public void setRoad(String str) {
        this.f12829c = str;
    }

    public float getDistance() {
        return this.f12830d;
    }

    public void setDistance(float f) {
        this.f12830d = f;
    }

    public float getDuration() {
        return this.f12831e;
    }

    public void setDuration(float f) {
        this.f12831e = f;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f12832f;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f12832f = list;
    }

    public String getAction() {
        return this.f12833g;
    }

    public void setAction(String str) {
        this.f12833g = str;
    }

    public String getAssistantAction() {
        return this.f12834h;
    }

    public void setAssistantAction(String str) {
        this.f12834h = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12827a);
        parcel.writeString(this.f12828b);
        parcel.writeString(this.f12829c);
        parcel.writeFloat(this.f12830d);
        parcel.writeFloat(this.f12831e);
        parcel.writeTypedList(this.f12832f);
        parcel.writeString(this.f12833g);
        parcel.writeString(this.f12834h);
    }

    public WalkStep(Parcel parcel) {
        this.f12827a = parcel.readString();
        this.f12828b = parcel.readString();
        this.f12829c = parcel.readString();
        this.f12830d = parcel.readFloat();
        this.f12831e = parcel.readFloat();
        this.f12832f = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f12833g = parcel.readString();
        this.f12834h = parcel.readString();
    }
}
