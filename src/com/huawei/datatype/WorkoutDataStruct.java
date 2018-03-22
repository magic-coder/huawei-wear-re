package com.huawei.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;

public class WorkoutDataStruct {
    private DataHeader dataHeader;
    private int workout_data_index;
    private int workout_record_id;

    public int getWorkout_record_id() {
        return ((Integer) C0978h.a(Integer.valueOf(this.workout_record_id))).intValue();
    }

    public void setWorkout_record_id(int i) {
        this.workout_record_id = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getWorkout_data_index() {
        return ((Integer) C0978h.a(Integer.valueOf(this.workout_data_index))).intValue();
    }

    public void setWorkout_data_index(int i) {
        this.workout_data_index = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public DataHeader getDataHeader() {
        return (DataHeader) C0978h.a(this.dataHeader);
    }

    public void setDataHeader(DataHeader dataHeader) {
        this.dataHeader = (DataHeader) C0978h.a(dataHeader);
    }
}
