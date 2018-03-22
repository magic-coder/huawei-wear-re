package com.huawei.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;

import java.util.List;

public class WorkoutRecord {
    private List<WorkoutRecordStruct> workoutRecordStructList;
    private int workout_record_count;

    public int getWorkout_record_count() {
        return ((Integer) C0978h.a(Integer.valueOf(this.workout_record_count))).intValue();
    }

    public void setWorkout_record_count(int i) {
        this.workout_record_count = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public List<WorkoutRecordStruct> getWorkoutRecordStructList() {
        return (List) C0978h.a(this.workoutRecordStructList);
    }

    public void setWorkoutRecordStructList(List<WorkoutRecordStruct> list) {
        this.workoutRecordStructList = (List) C0978h.a(list);
    }
}
