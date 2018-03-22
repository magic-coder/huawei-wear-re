package com.huawei.hwcommonmodel.fitnessdatatype;

import com.huawei.hwcommonmodel.p064d.C0978h;

public class DataTotalMotion {
    private int calorie;
    private int distance;
    private int height;
    private int motion_type;
    private int sleep_time;
    private int step;

    public int getMotion_type() {
        return ((Integer) C0978h.a(Integer.valueOf(this.motion_type))).intValue();
    }

    public void setMotion_type(int i) {
        this.motion_type = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getStep() {
        return ((Integer) C0978h.a(Integer.valueOf(this.step))).intValue();
    }

    public void setStep(int i) {
        this.step = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getCalorie() {
        return ((Integer) C0978h.a(Integer.valueOf(this.calorie))).intValue();
    }

    public void setCalorie(int i) {
        this.calorie = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getDistance() {
        return ((Integer) C0978h.a(Integer.valueOf(this.distance))).intValue();
    }

    public void setDistance(int i) {
        this.distance = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getHeight() {
        return ((Integer) C0978h.a(Integer.valueOf(this.height))).intValue();
    }

    public void setHeight(int i) {
        this.height = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getSleep_time() {
        return ((Integer) C0978h.a(Integer.valueOf(this.sleep_time))).intValue();
    }

    public void setSleep_time(int i) {
        this.sleep_time = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }
}
