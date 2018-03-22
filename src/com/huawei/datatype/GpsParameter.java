package com.huawei.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;

public class GpsParameter {
    private int gps_info_bitmap;
    private int gps_para_element_num;
    private int gps_para_format;
    private int gps_threshold;

    public int getGps_info_bitmap() {
        return ((Integer) C0978h.a(Integer.valueOf(this.gps_info_bitmap))).intValue();
    }

    public void setGps_info_bitmap(int i) {
        this.gps_info_bitmap = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getGps_para_format() {
        return ((Integer) C0978h.a(Integer.valueOf(this.gps_para_format))).intValue();
    }

    public void setGps_para_format(int i) {
        this.gps_para_format = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getGps_para_element_num() {
        return ((Integer) C0978h.a(Integer.valueOf(this.gps_para_element_num))).intValue();
    }

    public void setGps_para_element_num(int i) {
        this.gps_para_element_num = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getGps_threshold() {
        return ((Integer) C0978h.a(Integer.valueOf(this.gps_threshold))).intValue();
    }

    public void setGps_threshold(int i) {
        this.gps_threshold = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }
}
