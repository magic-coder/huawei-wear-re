package com.huawei.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;

public class GPSStruct {
    private int gps_altitude = -1;
    private double gps_direction = -1.0d;
    private long gps_distance = -1;
    private long gps_end_time = -1;
    private double gps_h_latitude = -1.0d;
    private double gps_h_longitude = -1.0d;
    private double gps_latitude = -1.0d;
    private double gps_longitude = -1.0d;
    private double gps_precision = -1.0d;
    private int gps_speed = -1;
    private long gps_start_time = -1;
    private long gps_total_distance = -1;

    public int getGps_speed() {
        return ((Integer) C0978h.a(Integer.valueOf(this.gps_speed))).intValue();
    }

    public void setGps_speed(int i) {
        this.gps_speed = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public long getGps_distance() {
        return ((Long) C0978h.a(Long.valueOf(this.gps_distance))).longValue();
    }

    public void setGps_distance(long j) {
        this.gps_distance = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public int getGps_altitude() {
        return ((Integer) C0978h.a(Integer.valueOf(this.gps_altitude))).intValue();
    }

    public void setGps_altitude(int i) {
        this.gps_altitude = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public long getGps_total_distance() {
        return ((Long) C0978h.a(Long.valueOf(this.gps_total_distance))).longValue();
    }

    public void setGps_total_distance(long j) {
        this.gps_total_distance = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public void setGps_start_time(long j) {
        this.gps_start_time = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public long getGps_start_time() {
        return ((Long) C0978h.a(Long.valueOf(this.gps_start_time))).longValue();
    }

    public void setGps_end_time(long j) {
        this.gps_end_time = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public long getGps_end_time() {
        return ((Long) C0978h.a(Long.valueOf(this.gps_end_time))).longValue();
    }

    public double getGps_h_longitude() {
        return ((Double) C0978h.a(Double.valueOf(this.gps_h_longitude))).doubleValue();
    }

    public void setGps_h_longitude(double d) {
        this.gps_h_longitude = ((Double) C0978h.a(Double.valueOf(d))).doubleValue();
    }

    public double getGps_h_latitude() {
        return ((Double) C0978h.a(Double.valueOf(this.gps_h_latitude))).doubleValue();
    }

    public void setGps_h_latitude(double d) {
        this.gps_h_latitude = ((Double) C0978h.a(Double.valueOf(d))).doubleValue();
    }

    public double getGps_longitude() {
        return ((Double) C0978h.a(Double.valueOf(this.gps_longitude))).doubleValue();
    }

    public void setGps_longitude(double d) {
        this.gps_longitude = ((Double) C0978h.a(Double.valueOf(d))).doubleValue();
    }

    public double getGps_latitude() {
        return ((Double) C0978h.a(Double.valueOf(this.gps_latitude))).doubleValue();
    }

    public void setGps_latitude(double d) {
        this.gps_latitude = ((Double) C0978h.a(Double.valueOf(d))).doubleValue();
    }

    public double getGps_direction() {
        return ((Double) C0978h.a(Double.valueOf(this.gps_direction))).doubleValue();
    }

    public void setGps_direction(double d) {
        this.gps_direction = ((Double) C0978h.a(Double.valueOf(d))).doubleValue();
    }

    public double getGps_precision() {
        return ((Double) C0978h.a(Double.valueOf(this.gps_precision))).doubleValue();
    }

    public void setGps_precision(double d) {
        this.gps_precision = ((Double) C0978h.a(Double.valueOf(d))).doubleValue();
    }
}
