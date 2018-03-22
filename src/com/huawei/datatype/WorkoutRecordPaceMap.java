package com.huawei.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;

public class WorkoutRecordPaceMap {
    private int distance;
    private boolean isLastLessDistance = false;
    private int lastLessDistance = 0;
    private int pace;
    private int point_index = 0;
    private int unit_type;

    public void setDistance(int i) {
        this.distance = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getDistance() {
        return ((Integer) C0978h.a(Integer.valueOf(this.distance))).intValue();
    }

    public void setUnit_type(int i) {
        this.unit_type = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getUnit_type() {
        return ((Integer) C0978h.a(Integer.valueOf(this.unit_type))).intValue();
    }

    public void setPace(int i) {
        this.pace = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getPace() {
        return ((Integer) C0978h.a(Integer.valueOf(this.pace))).intValue();
    }

    public void setPoint_index(int i) {
        this.point_index = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getPoint_index() {
        return ((Integer) C0978h.a(Integer.valueOf(this.point_index))).intValue();
    }

    public void setLastLessDistance(int i) {
        this.lastLessDistance = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getLastLessDistance() {
        return ((Integer) C0978h.a(Integer.valueOf(this.lastLessDistance))).intValue();
    }

    public void setIsLastLessDistance(boolean z) {
        this.isLastLessDistance = ((Boolean) C0978h.a(Boolean.valueOf(z))).booleanValue();
    }

    public boolean isLastLessDistance() {
        return ((Boolean) C0978h.a(Boolean.valueOf(this.isLastLessDistance))).booleanValue();
    }
}
