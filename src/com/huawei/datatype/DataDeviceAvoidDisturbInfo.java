package com.huawei.datatype;

public class DataDeviceAvoidDisturbInfo {
    private int device_avoid_disturb_cycle = 127;
    private int device_avoid_disturb_end_time = 700;
    private int device_avoid_disturb_index = 1;
    private int device_avoid_disturb_start_time = 2300;
    private int device_avoid_disturb_switch = 0;
    private int device_avoid_disturb_time_switch = 0;
    private int device_avoid_disturb_type = 0;

    public int getDevice_avoid_disturb_index() {
        return this.device_avoid_disturb_index;
    }

    public void setDevice_avoid_disturb_index(int i) {
        this.device_avoid_disturb_index = i;
    }

    public int getDevice_avoid_disturb_switch() {
        return this.device_avoid_disturb_switch;
    }

    public void setDevice_avoid_disturb_switch(int i) {
        this.device_avoid_disturb_switch = i;
    }

    public int getDevice_avoid_disturb_type() {
        return this.device_avoid_disturb_type;
    }

    public void setDevice_avoid_disturb_type(int i) {
        this.device_avoid_disturb_type = i;
    }

    public int getDevice_avoid_disturb_start_time() {
        return this.device_avoid_disturb_start_time;
    }

    public void setDevice_avoid_disturb_start_time(int i) {
        this.device_avoid_disturb_start_time = i;
    }

    public int getDevice_avoid_disturb_end_time() {
        return this.device_avoid_disturb_end_time;
    }

    public void setDevice_avoid_disturb_end_time(int i) {
        this.device_avoid_disturb_end_time = i;
    }

    public int getDevice_avoid_disturb_cycle() {
        return this.device_avoid_disturb_cycle;
    }

    public void setDevice_avoid_disturb_cycle(int i) {
        this.device_avoid_disturb_cycle = i;
    }

    public int getDevice_avoid_disturb_time_switch() {
        return this.device_avoid_disturb_time_switch;
    }

    public void setDevice_avoid_disturb_time_switch(int i) {
        this.device_avoid_disturb_time_switch = i;
    }

    public String toString() {
        return "[勿扰信息列表：index = " + this.device_avoid_disturb_index + ", switch = " + this.device_avoid_disturb_switch + ", time_switch = " + this.device_avoid_disturb_time_switch + ", type = " + this.device_avoid_disturb_type + ", start_time = " + this.device_avoid_disturb_start_time + ", end_time = " + this.device_avoid_disturb_end_time + ", cycle = " + this.device_avoid_disturb_cycle + "]";
    }
}
