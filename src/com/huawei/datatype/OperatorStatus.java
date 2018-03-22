package com.huawei.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;

public class OperatorStatus {
    private long operation_time;
    private int operator_type;
    private long run_plan_date;
    private int sport_exist = 1;
    private long sport_startTime;
    private int sport_type;
    private int train_monitor_state;
    private int workout_type;

    public int getSport_exist() {
        return ((Integer) C0978h.a(Integer.valueOf(this.sport_exist))).intValue();
    }

    public void setSport_exist(int i) {
        this.sport_exist = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getSport_type() {
        return ((Integer) C0978h.a(Integer.valueOf(this.sport_type))).intValue();
    }

    public void setSport_type(int i) {
        this.sport_type = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public long getSport_startTime() {
        return ((Long) C0978h.a(Long.valueOf(this.sport_startTime))).longValue();
    }

    public void setSport_startTime(long j) {
        this.sport_startTime = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public int getWorkout_type() {
        return ((Integer) C0978h.a(Integer.valueOf(this.workout_type))).intValue();
    }

    public void setWorkout_type(int i) {
        this.workout_type = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public long getRun_plan_date() {
        return ((Long) C0978h.a(Long.valueOf(this.run_plan_date))).longValue();
    }

    public void setRun_plan_date(long j) {
        this.run_plan_date = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public int getOperator_type() {
        return ((Integer) C0978h.a(Integer.valueOf(this.operator_type))).intValue();
    }

    public void setOperator_type(int i) {
        this.operator_type = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public void setTrain_monitor_state(int i) {
        this.train_monitor_state = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getTrain_monitor_state() {
        return ((Integer) C0978h.a(Integer.valueOf(this.train_monitor_state))).intValue();
    }

    public void setOperation_time(long j) {
        this.operation_time = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public long getOperation_time() {
        return ((Long) C0978h.a(Long.valueOf(this.operation_time))).longValue();
    }
}
