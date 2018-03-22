package com.amap.api.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps.model.CameraPosition;

public class AMapOptions implements Parcelable {
    public static final AMapOptionsCreator CREATOR = new AMapOptionsCreator();
    public static final int LOGO_POSITION_BOTTOM_CENTER = 1;
    public static final int LOGO_POSITION_BOTTOM_LEFT = 0;
    public static final int LOGO_POSITION_BOTTOM_RIGHT = 2;
    public static final int ZOOM_POSITION_RIGHT_BUTTOM = 2;
    public static final int ZOOM_POSITION_RIGHT_CENTER = 1;
    private int f11959a = 1;
    private boolean f11960b = true;
    private boolean f11961c = true;
    private boolean f11962d = true;
    private boolean f11963e = true;
    private boolean f11964f = true;
    private boolean f11965g = false;
    private CameraPosition f11966h;
    private boolean f11967i = false;
    private boolean f11968j = false;
    private int f11969k = 0;

    public AMapOptions logoPosition(int i) {
        this.f11969k = i;
        return this;
    }

    public AMapOptions zOrderOnTop(boolean z) {
        this.f11965g = z;
        return this;
    }

    public AMapOptions mapType(int i) {
        this.f11959a = i;
        return this;
    }

    public AMapOptions camera(CameraPosition cameraPosition) {
        this.f11966h = cameraPosition;
        return this;
    }

    public AMapOptions scaleControlsEnabled(boolean z) {
        this.f11968j = z;
        return this;
    }

    public AMapOptions zoomControlsEnabled(boolean z) {
        this.f11964f = z;
        return this;
    }

    public AMapOptions compassEnabled(boolean z) {
        this.f11967i = z;
        return this;
    }

    public AMapOptions scrollGesturesEnabled(boolean z) {
        this.f11961c = z;
        return this;
    }

    public AMapOptions zoomGesturesEnabled(boolean z) {
        this.f11963e = z;
        return this;
    }

    public AMapOptions tiltGesturesEnabled(boolean z) {
        this.f11962d = z;
        return this;
    }

    public AMapOptions rotateGesturesEnabled(boolean z) {
        this.f11960b = z;
        return this;
    }

    public int getLogoPosition() {
        return this.f11969k;
    }

    public Boolean getZOrderOnTop() {
        return Boolean.valueOf(this.f11965g);
    }

    public int getMapType() {
        return this.f11959a;
    }

    public CameraPosition getCamera() {
        return this.f11966h;
    }

    public Boolean getScaleControlsEnabled() {
        return Boolean.valueOf(this.f11968j);
    }

    public Boolean getZoomControlsEnabled() {
        return Boolean.valueOf(this.f11964f);
    }

    public Boolean getCompassEnabled() {
        return Boolean.valueOf(this.f11967i);
    }

    public Boolean getScrollGesturesEnabled() {
        return Boolean.valueOf(this.f11961c);
    }

    public Boolean getZoomGesturesEnabled() {
        return Boolean.valueOf(this.f11963e);
    }

    public Boolean getTiltGesturesEnabled() {
        return Boolean.valueOf(this.f11962d);
    }

    public Boolean getRotateGesturesEnabled() {
        return Boolean.valueOf(this.f11960b);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f11966h, i);
        parcel.writeInt(this.f11959a);
        parcel.writeBooleanArray(new boolean[]{this.f11960b, this.f11961c, this.f11962d, this.f11963e, this.f11964f, this.f11965g, this.f11967i, this.f11968j});
    }
}
