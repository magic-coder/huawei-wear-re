package com.huawei.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;

import java.util.List;

public class RunPlanRecord {
    private List<RunPlanRecordStruct> runPlanRecordStructList;
    private int run_plan_record_count;

    public int getRun_plan_record_count() {
        return ((Integer) C0978h.a(Integer.valueOf(this.run_plan_record_count))).intValue();
    }

    public void setRun_plan_record_count(int i) {
        this.run_plan_record_count = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public List<RunPlanRecordStruct> getRunPlanRecordStructList() {
        return (List) C0978h.a(this.runPlanRecordStructList);
    }

    public void setRunPlanRecordStructList(List<RunPlanRecordStruct> list) {
        this.runPlanRecordStructList = (List) C0978h.a(list);
    }
}
