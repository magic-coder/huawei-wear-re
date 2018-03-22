package com.huawei.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;

public class RunPlanRecordStruct {
    private int paceIndexCount = -1;
    private int run_plan_index_count;
    private int run_plan_record_id;
    private int run_plan_workout_id;

    public int getRun_plan_workout_id() {
        return ((Integer) C0978h.a(Integer.valueOf(this.run_plan_workout_id))).intValue();
    }

    public void setRun_plan_workout_id(int i) {
        this.run_plan_workout_id = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getRun_plan_record_id() {
        return ((Integer) C0978h.a(Integer.valueOf(this.run_plan_record_id))).intValue();
    }

    public void setRun_plan_record_id(int i) {
        this.run_plan_record_id = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getRun_plan_index_count() {
        return ((Integer) C0978h.a(Integer.valueOf(this.run_plan_index_count))).intValue();
    }

    public void setRun_plan_index_count(int i) {
        this.run_plan_index_count = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getPaceIndextCount() {
        return ((Integer) C0978h.a(Integer.valueOf(this.paceIndexCount))).intValue();
    }

    public void setPaceIndextCount(int i) {
        this.paceIndexCount = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public void procRunPlanRecordStruct1() {
    }

    public void procRunPlanRecordStruct2() {
    }

    public void procRunPlanRecordStruct3() {
    }

    public void procRunPlanRecordStruct4() {
    }

    public void procRunPlanRecordStruct5() {
    }
}
