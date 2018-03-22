package com.huawei.hwcommonmodel.fitnessdatatype;

import com.huawei.hwcommonmodel.p064d.C0978h;

public class ActivityReminder {
    private int cycle = 127;
    private boolean enable = true;
    private int endTime = 5120;
    private int interval = 60;
    private int startTime = 2048;

    public boolean isEnabled() {
        return ((Boolean) C0978h.a(Boolean.valueOf(this.enable))).booleanValue();
    }

    public void setEnabled(boolean z) {
        this.enable = ((Boolean) C0978h.a(Boolean.valueOf(z))).booleanValue();
    }

    public int getInterval() {
        return ((Integer) C0978h.a(Integer.valueOf(this.interval))).intValue();
    }

    public void setInterval(int i) {
        this.interval = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getStartTime() {
        return ((Integer) C0978h.a(Integer.valueOf(this.startTime))).intValue();
    }

    public void setStartTime(int i) {
        this.startTime = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getEndTime() {
        return ((Integer) C0978h.a(Integer.valueOf(this.endTime))).intValue();
    }

    public void setEndTime(int i) {
        this.endTime = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getCycle() {
        return ((Integer) C0978h.a(Integer.valueOf(this.cycle))).intValue();
    }

    public void setCycle(int i) {
        this.cycle = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public String toString() {
        return "ActivityReminder{enable=" + this.enable + ", interval=" + this.interval + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", cycle=" + this.cycle + '}';
    }

    public void initActivityReminder1() {
    }

    public void initActivityReminder2() {
    }

    public void initActivityReminder3() {
    }

    public void initActivityReminder4() {
    }

    public void initActivityReminder5() {
    }

    public void initActivityReminder6() {
    }

    public void initActivityReminder7() {
    }
}
