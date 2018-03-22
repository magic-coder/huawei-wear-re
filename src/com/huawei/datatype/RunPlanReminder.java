package com.huawei.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;

public class RunPlanReminder {
    private int run_plan_reminder_switch;
    private int run_plan_reminder_time_hour;
    private int run_plan_reminder_time_minute;

    public int getRun_plan_reminder_switch() {
        return ((Integer) C0978h.a(Integer.valueOf(this.run_plan_reminder_switch))).intValue();
    }

    public void setRun_plan_reminder_switch(int i) {
        this.run_plan_reminder_switch = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getRun_plan_reminder_time_hour() {
        return ((Integer) C0978h.a(Integer.valueOf(this.run_plan_reminder_time_hour))).intValue();
    }

    public void setRun_plan_reminder_time_hour(int i) {
        this.run_plan_reminder_time_hour = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getRun_plan_reminder_time_minute() {
        return ((Integer) C0978h.a(Integer.valueOf(this.run_plan_reminder_time_minute))).intValue();
    }

    public void setRun_plan_reminder_time_minute(int i) {
        this.run_plan_reminder_time_minute = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }
}
