package com.huawei.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;

import java.util.List;

public class DataHeader {
    private int frameID;
    private int sportID;
    private long time;
    private int timeInterval;
    private List<WorkoutDataInfo> workoutDataInfoList;

    public int getSportID() {
        return ((Integer) C0978h.a(Integer.valueOf(this.sportID))).intValue();
    }

    public void setSportID(int i) {
        this.sportID = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getFrameID() {
        return ((Integer) C0978h.a(Integer.valueOf(this.frameID))).intValue();
    }

    public void setFrameID(int i) {
        this.frameID = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public long getTime() {
        return ((Long) C0978h.a(Long.valueOf(this.time))).longValue();
    }

    public void setTime(long j) {
        this.time = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public int getTimeInterval() {
        return ((Integer) C0978h.a(Integer.valueOf(this.timeInterval))).intValue();
    }

    public void setTimeInterval(int i) {
        this.timeInterval = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public List<WorkoutDataInfo> getWorkoutDataInfoList() {
        return (List) C0978h.a(this.workoutDataInfoList);
    }

    public void setWorkoutDataInfoList(List<WorkoutDataInfo> list) {
        this.workoutDataInfoList = (List) C0978h.a(list);
    }
}
