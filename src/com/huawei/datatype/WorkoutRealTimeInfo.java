package com.huawei.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;

public class WorkoutRealTimeInfo {
    private long calorie_info;
    private long clime_info;
    private long distance_info;
    private int hr_info;
    private float speed_info;
    private int sport_type;
    private long time_info;

    public int getSport_type() {
        return ((Integer) C0978h.a(Integer.valueOf(this.sport_type))).intValue();
    }

    public void setSport_type(int i) {
        this.sport_type = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public float getSpeed_info() {
        return ((Float) C0978h.a(Float.valueOf(this.speed_info))).floatValue();
    }

    public void setSpeed_info(float f) {
        this.speed_info = ((Float) C0978h.a(Float.valueOf(f))).floatValue();
    }

    public int getHr_info() {
        return ((Integer) C0978h.a(Integer.valueOf(this.hr_info))).intValue();
    }

    public void setHr_info(int i) {
        this.hr_info = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public long getTime_info() {
        return ((Long) C0978h.a(Long.valueOf(this.time_info))).longValue();
    }

    public void setTime_info(int i) {
        this.time_info = (long) ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public long getCalorie_info() {
        return ((Long) C0978h.a(Long.valueOf(this.calorie_info))).longValue();
    }

    public void setCalorie_info(long j) {
        this.calorie_info = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public long getDistance_info() {
        return ((Long) C0978h.a(Long.valueOf(this.distance_info))).longValue();
    }

    public void setDistance_info(long j) {
        this.distance_info = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public long getClime_info() {
        return ((Long) C0978h.a(Long.valueOf(this.clime_info))).longValue();
    }

    public void setClime_info(long j) {
        this.clime_info = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }
}
