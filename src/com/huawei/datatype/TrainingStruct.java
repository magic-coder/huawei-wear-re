package com.huawei.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;

public class TrainingStruct {
    private int training_duration;
    private int training_hr_limit_high;
    private int training_hr_limit_low;
    private int training_intensity_limit_high;
    private int training_intensity_limit_low;
    private int training_speed_limit_high;
    private int training_speed_limit_low;
    private int training_type;

    public int getTraining_type() {
        return ((Integer) C0978h.a(Integer.valueOf(this.training_type))).intValue();
    }

    public void setTraining_type(int i) {
        this.training_type = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getTraining_speed_limit_high() {
        return ((Integer) C0978h.a(Integer.valueOf(this.training_speed_limit_high))).intValue();
    }

    public void setTraining_speed_limit_high(int i) {
        this.training_speed_limit_high = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getTraining_speed_limit_low() {
        return ((Integer) C0978h.a(Integer.valueOf(this.training_speed_limit_low))).intValue();
    }

    public void setTraining_speed_limit_low(int i) {
        this.training_speed_limit_low = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getTraining_hr_limit_high() {
        return ((Integer) C0978h.a(Integer.valueOf(this.training_hr_limit_high))).intValue();
    }

    public void setTraining_hr_limit_high(int i) {
        this.training_hr_limit_high = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getTraining_hr_limit_low() {
        return ((Integer) C0978h.a(Integer.valueOf(this.training_hr_limit_low))).intValue();
    }

    public void setTraining_hr_limit_low(int i) {
        this.training_hr_limit_low = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getTraining_intensity_limit_high() {
        return ((Integer) C0978h.a(Integer.valueOf(this.training_intensity_limit_high))).intValue();
    }

    public void setTraining_intensity_limit_high(int i) {
        this.training_intensity_limit_high = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getTraining_intensity_limit_low() {
        return ((Integer) C0978h.a(Integer.valueOf(this.training_intensity_limit_low))).intValue();
    }

    public void setTraining_intensity_limit_low(int i) {
        this.training_intensity_limit_low = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getTraining_duration() {
        return ((Integer) C0978h.a(Integer.valueOf(this.training_duration))).intValue();
    }

    public void setTraining_duration(int i) {
        this.training_duration = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.training_type);
        stringBuffer.append(this.training_speed_limit_high);
        stringBuffer.append(this.training_speed_limit_low);
        stringBuffer.append(this.training_hr_limit_high);
        stringBuffer.append(this.training_hr_limit_low);
        stringBuffer.append(this.training_intensity_limit_high);
        stringBuffer.append(this.training_intensity_limit_low);
        stringBuffer.append(this.training_duration);
        return stringBuffer.toString();
    }
}
