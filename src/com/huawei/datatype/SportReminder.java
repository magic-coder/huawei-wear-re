package com.huawei.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;

import java.util.List;

public class SportReminder {
    private long distance_info;
    private int hr_status_info;
    private int hr_value_info;
    private int reminder_type;
    private int run_phrase_number;
    private List<Integer> run_phrase_variable;
    private int sport_type;
    private long time_info;

    public int getSport_type() {
        return ((Integer) C0978h.a(Integer.valueOf(this.sport_type))).intValue();
    }

    public void setSport_type(int i) {
        this.sport_type = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getReminder_type() {
        return ((Integer) C0978h.a(Integer.valueOf(this.reminder_type))).intValue();
    }

    public void setReminder_type(int i) {
        this.reminder_type = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getRun_phrase_number() {
        return ((Integer) C0978h.a(Integer.valueOf(this.run_phrase_number))).intValue();
    }

    public void setRun_phrase_number(int i) {
        this.run_phrase_number = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public List<Integer> getRun_phrase_variable() {
        return (List) C0978h.a(this.run_phrase_variable);
    }

    public void setRun_phrase_variable(List<Integer> list) {
        this.run_phrase_variable = (List) C0978h.a(list);
    }

    public long getDistance_info() {
        return ((Long) C0978h.a(Long.valueOf(this.distance_info))).longValue();
    }

    public void setDistance_info(long j) {
        this.distance_info = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public long getTime_info() {
        return ((Long) C0978h.a(Long.valueOf(this.time_info))).longValue();
    }

    public void setTime_info(long j) {
        this.time_info = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public int getHr_value_info() {
        return ((Integer) C0978h.a(Integer.valueOf(this.hr_value_info))).intValue();
    }

    public void setHr_value_info(int i) {
        this.hr_value_info = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getHr_status_info() {
        return ((Integer) C0978h.a(Integer.valueOf(this.hr_status_info))).intValue();
    }

    public void setHr_status_info(int i) {
        this.hr_status_info = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }
}
