package com.huawei.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;

import java.util.List;

public class RunPlanInfo {
    private List<RunPlanStruct> runPlanStructList;
    private String run_plan_sign;
    private long run_plan_start_date;
    private String run_plan_total_sign;

    public String getRun_plan_total_sign() {
        return (String) C0978h.a(this.run_plan_total_sign);
    }

    public void setRun_plan_total_sign(String str) {
        this.run_plan_total_sign = (String) C0978h.a(str);
    }

    public String getRun_plan_sign() {
        return (String) C0978h.a(this.run_plan_sign);
    }

    public void setRun_plan_sign(String str) {
        this.run_plan_sign = (String) C0978h.a(str);
    }

    public long getRun_plan_start_date() {
        return ((Long) C0978h.a(Long.valueOf(this.run_plan_start_date))).longValue();
    }

    public void setRun_plan_start_date(long j) {
        this.run_plan_start_date = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public List<RunPlanStruct> getRunPlanStructList() {
        return (List) C0978h.a(this.runPlanStructList);
    }

    public void setRunPlanStructList(List<RunPlanStruct> list) {
        this.runPlanStructList = (List) C0978h.a(list);
    }
}
