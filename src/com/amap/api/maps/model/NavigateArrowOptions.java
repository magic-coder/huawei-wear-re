package com.amap.api.maps.model;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hihealth.HiUserInfo;
import com.huawei.hwcommonmodel.fitnessdatatype.FitnessSleepType;
import com.huawei.hwcommonmodel.fitnessdatatype.FitnessSportType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class NavigateArrowOptions implements Parcelable {
    public static final NavigateArrowOptionsCreator CREATOR = new NavigateArrowOptionsCreator();
    String f134a;
    private final List<LatLng> f135b = new ArrayList();
    private float f136c = 10.0f;
    private int f137d = Color.argb(FitnessSportType.HW_FITNESS_SPORT_ALL, 87, FitnessSleepType.HW_FITNESS_SLEEP_WRONG, 204);
    private int f138e = Color.argb(HiUserInfo.HEIGHT_DEFAULT, 0, 172, 146);
    private float f139f = 0.0f;
    private boolean f140g = true;

    public NavigateArrowOptions add(LatLng latLng) {
        this.f135b.add(latLng);
        return this;
    }

    public NavigateArrowOptions add(LatLng... latLngArr) {
        this.f135b.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public NavigateArrowOptions addAll(Iterable<LatLng> iterable) {
        for (LatLng add : iterable) {
            this.f135b.add(add);
        }
        return this;
    }

    public NavigateArrowOptions width(float f) {
        this.f136c = f;
        return this;
    }

    public NavigateArrowOptions topColor(int i) {
        this.f137d = i;
        return this;
    }

    @Deprecated
    public NavigateArrowOptions sideColor(int i) {
        this.f138e = i;
        return this;
    }

    public NavigateArrowOptions zIndex(float f) {
        this.f139f = f;
        return this;
    }

    public NavigateArrowOptions visible(boolean z) {
        this.f140g = z;
        return this;
    }

    public List<LatLng> getPoints() {
        return this.f135b;
    }

    public float getWidth() {
        return this.f136c;
    }

    public int getTopColor() {
        return this.f137d;
    }

    @Deprecated
    public int getSideColor() {
        return this.f138e;
    }

    public float getZIndex() {
        return this.f139f;
    }

    public boolean isVisible() {
        return this.f140g;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f135b);
        parcel.writeFloat(this.f136c);
        parcel.writeInt(this.f137d);
        parcel.writeInt(this.f138e);
        parcel.writeFloat(this.f139f);
        parcel.writeByte((byte) (this.f140g ? 1 : 0));
        parcel.writeString(this.f134a);
    }
}
