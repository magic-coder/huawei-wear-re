package com.huawei.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;

public class WorkoutRecordStruct {
    private int paceIndexCount = -1;
    private int workout_index_count;
    private int workout_record_id;

    public int getWorkout_record_id() {
        return ((Integer) C0978h.a(Integer.valueOf(this.workout_record_id))).intValue();
    }

    public void setWorkout_record_id(int i) {
        this.workout_record_id = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getWorkout_index_count() {
        return ((Integer) C0978h.a(Integer.valueOf(this.workout_index_count))).intValue();
    }

    public void setWorkout_index_count(int i) {
        this.workout_index_count = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getPaceIndexRecord() {
        return ((Integer) C0978h.a(Integer.valueOf(this.paceIndexCount))).intValue();
    }

    public void setPaceIndexCount(int i) {
        this.paceIndexCount = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public void procWorkoutRecordStruct1() {
    }

    public void procWorkoutRecordStruct2() {
    }

    public void procWorkoutRecordStruct3() {
    }

    public void procWorkoutRecordStruct4() {
    }
}
