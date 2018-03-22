package com.huawei.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;

public class RunPlanParameter {
    private int run_plan_algorithm_type;
    private String run_plan_algorithm_version;
    private String run_plan_sign;
    private int run_plan_sync_size;
    private int run_plan_sync_size_pre;
    private int run_plan_sync_size_sub;
    private String run_plan_total_sign;

    public int getRun_plan_sync_size_sub() {
        return ((Integer) C0978h.a(Integer.valueOf(this.run_plan_sync_size_sub))).intValue();
    }

    public void setRun_plan_sync_size_sub(int i) {
        this.run_plan_sync_size_sub = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getRun_plan_sync_size_pre() {
        return ((Integer) C0978h.a(Integer.valueOf(this.run_plan_sync_size_pre))).intValue();
    }

    public void setRun_plan_sync_size_pre(int i) {
        this.run_plan_sync_size_pre = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

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

    public int getRun_plan_algorithm_type() {
        return ((Integer) C0978h.a(Integer.valueOf(this.run_plan_algorithm_type))).intValue();
    }

    public void setRun_plan_algorithm_type(int i) {
        this.run_plan_algorithm_type = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public String getRun_plan_algorithm_version() {
        return (String) C0978h.a(this.run_plan_algorithm_version);
    }

    public void setRun_plan_algorithm_version(String str) {
        this.run_plan_algorithm_version = (String) C0978h.a(str);
    }

    public int getRun_plan_sync_size() {
        return ((Integer) C0978h.a(Integer.valueOf(this.run_plan_sync_size))).intValue();
    }

    public void setRun_plan_sync_size(int i) {
        this.run_plan_sync_size = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }
}
