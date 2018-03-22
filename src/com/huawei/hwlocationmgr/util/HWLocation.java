package com.huawei.hwlocationmgr.util;

import android.annotation.SuppressLint;
import android.location.Location;
import com.huawei.hwcommonmodel.p064d.C0978h;

@SuppressLint({"ParcelCreator"})
public class HWLocation extends Location {
    private static final String TAG = HWLocation.class.getSimpleName();
    private float computedDistance;
    private long computedInterval;
    private float computedSpeed;

    public HWLocation(Location location) {
        super(location);
    }

    public float getSpeed() {
        return ((Float) C0978h.a(Float.valueOf(this.computedSpeed))).floatValue();
    }

    public float getDistance() {
        return ((Float) C0978h.a(Float.valueOf(this.computedDistance))).floatValue();
    }

    public long getComputedInterval() {
        return ((Long) C0978h.a(Long.valueOf(this.computedInterval))).longValue();
    }

    public void setComputedSpeed(float f) {
        this.computedSpeed = ((Float) C0978h.a(Float.valueOf(f))).floatValue();
    }

    public void setComputedDistance(float f) {
        this.computedDistance = ((Float) C0978h.a(Float.valueOf(f))).floatValue();
    }

    public void setComputedInterval(long j) {
        this.computedInterval = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public void procHwLocation1() {
    }

    public void procHwLocation2() {
    }

    public void procHwLocation3() {
    }

    public void procHwLocation4() {
    }
}
