package com.huawei.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;

import java.util.List;

public class WorkRecordIndexPaceMapList {
    private int paceIndex = -1;
    List<WorkoutRecordPaceMap> paceMapList;
    private int workout_record_id;

    public void setWorkout_record_id(int i) {
        this.workout_record_id = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getWorkout_record_id() {
        return ((Integer) C0978h.a(Integer.valueOf(this.workout_record_id))).intValue();
    }

    public void setPaceIndex(int i) {
        this.paceIndex = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getPaceIndex() {
        return ((Integer) C0978h.a(Integer.valueOf(this.paceIndex))).intValue();
    }

    public void setPaceMapList(List<WorkoutRecordPaceMap> list) {
        this.paceMapList = (List) C0978h.a(list);
    }

    public List<WorkoutRecordPaceMap> getPaceMapList() {
        return (List) C0978h.a(this.paceMapList);
    }

    public void procWorkRecordIndexPace1() {
    }

    public void procWorkRecordIndexPace2() {
    }

    public void procWorkRecordIndexPace3() {
    }

    public void procWorkRecordIndexPace4() {
    }
}
