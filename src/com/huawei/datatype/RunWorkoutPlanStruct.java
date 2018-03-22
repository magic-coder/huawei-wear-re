package com.huawei.datatype;

public class RunWorkoutPlanStruct {
    long date;
    String workoutName;

    public void setDate(long j) {
        this.date = j;
    }

    public long getDate() {
        return this.date;
    }

    public void setWorkoutName(String str) {
        this.workoutName = str;
    }

    public String getWorkoutName() {
        return this.workoutName;
    }
}
