package com.huawei.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;

public class WorkoutDisplayInfo {
    private int chiefSportDataType = 0;
    private boolean hasTrackPoint = true;
    private boolean isFreeMotion = false;
    private int sportDataSource = 0;
    private int workoutType = SportType.SPORT_TYPE_RUN;

    public void setFreeMotion(boolean z) {
        this.isFreeMotion = ((Boolean) C0978h.a(Boolean.valueOf(z))).booleanValue();
    }

    public boolean getFreeMotion() {
        return ((Boolean) C0978h.a(Boolean.valueOf(this.isFreeMotion))).booleanValue();
    }

    public void setSportDataSource(int i) {
        this.sportDataSource = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getSportDataSource() {
        return ((Integer) C0978h.a(Integer.valueOf(this.sportDataSource))).intValue();
    }

    public void setChiefSportDataType(int i) {
        this.chiefSportDataType = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getChiefSportDataType() {
        return ((Integer) C0978h.a(Integer.valueOf(this.chiefSportDataType))).intValue();
    }

    public void setHasTrackPoint(boolean z) {
        this.hasTrackPoint = ((Boolean) C0978h.a(Boolean.valueOf(z))).booleanValue();
    }

    public boolean isHasTrackPoint() {
        return ((Boolean) C0978h.a(Boolean.valueOf(this.hasTrackPoint))).booleanValue();
    }

    public void setWorkoutType(int i) {
        this.workoutType = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getWorkoutType() {
        return ((Integer) C0978h.a(Integer.valueOf(this.workoutType))).intValue();
    }

    public void procWorkoutDisplayInfo1() {
    }

    public void procWorkoutDisplayInfo2() {
    }

    public void procWorkoutDisplayInfo3() {
    }

    public void procWorkoutDisplayInfo4() {
    }

    public void procWorkoutDisplayInfo5() {
    }

    public void procWorkoutDisplayInfo6() {
    }
}
