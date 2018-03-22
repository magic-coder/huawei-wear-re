package com.huawei.pluginkidwatch.common.entity.model;

public class AlarmModel {
    private static final long serialVersionUID = 9077384547756030938L;
    String cycle;
    String endTime;
    String isActive;
    String label;
    String startTime;

    public String toString() {
        return "Alarm [startTime=" + this.startTime + ", endTime=" + this.endTime + ", cycle=" + this.cycle + ", label=" + this.label + ", isActive=" + this.isActive + "]";
    }
}
