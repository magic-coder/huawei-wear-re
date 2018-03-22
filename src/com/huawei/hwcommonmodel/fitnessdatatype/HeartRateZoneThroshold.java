package com.huawei.hwcommonmodel.fitnessdatatype;

import com.huawei.hwcommonmodel.p064d.C0978h;
import com.huawei.p190v.C2538c;

public class HeartRateZoneThroshold {
    private int aerobicThreshold;
    private int anaerobicThreshold;
    private int fatBurnThreshold;
    private int fitnessThreshold;
    private int maxThreshold;
    private int warmUpThreshold;

    public HeartRateZoneThroshold() {
        this(30);
    }

    public HeartRateZoneThroshold(int i) {
        this.maxThreshold = 220 - i;
        this.fitnessThreshold = (this.maxThreshold * 50) / 100;
        this.warmUpThreshold = (this.maxThreshold * 60) / 100;
        this.fatBurnThreshold = (this.maxThreshold * 70) / 100;
        this.aerobicThreshold = (this.maxThreshold * 80) / 100;
        this.anaerobicThreshold = (this.maxThreshold * 90) / 100;
    }

    public void setFitnessThreshold(int i) {
        this.fitnessThreshold = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public void setWarmUpThreshold(int i) {
        this.warmUpThreshold = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public void setFatBurnThreshold(int i) {
        this.fatBurnThreshold = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public void setAerobicThreshold(int i) {
        this.aerobicThreshold = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public void setAnaerobicThreshold(int i) {
        this.anaerobicThreshold = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public void setMaxThreshold(int i) {
        this.maxThreshold = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getFitnessThreshold() {
        return ((Integer) C0978h.a(Integer.valueOf(this.fitnessThreshold))).intValue();
    }

    public int getWarmUpThreshold() {
        return ((Integer) C0978h.a(Integer.valueOf(this.warmUpThreshold))).intValue();
    }

    public int getFatBurnThreshold() {
        return ((Integer) C0978h.a(Integer.valueOf(this.fatBurnThreshold))).intValue();
    }

    public int getAerobicThreshold() {
        return ((Integer) C0978h.a(Integer.valueOf(this.aerobicThreshold))).intValue();
    }

    public int getAnaerobicThreshold() {
        return ((Integer) C0978h.a(Integer.valueOf(this.anaerobicThreshold))).intValue();
    }

    public int getMaxThreshold() {
        return ((Integer) C0978h.a(Integer.valueOf(this.maxThreshold))).intValue();
    }

    public String getThresholdString() {
        return this.fitnessThreshold + "|" + this.warmUpThreshold + "|" + this.fatBurnThreshold + "|" + this.aerobicThreshold + "|" + this.anaerobicThreshold + "|" + this.maxThreshold;
    }

    public void setThreshold(String str) {
        C2538c.c("HeartRateZoneThroshold", new Object[]{"setThreshold :" + str});
        if (!str.isEmpty()) {
            String[] split = str.split("\\|");
            try {
                this.fitnessThreshold = Integer.parseInt(split[0]);
                this.warmUpThreshold = Integer.parseInt(split[1]);
                this.fatBurnThreshold = Integer.parseInt(split[2]);
                this.aerobicThreshold = Integer.parseInt(split[3]);
                this.anaerobicThreshold = Integer.parseInt(split[4]);
                this.maxThreshold = Integer.parseInt(split[5]);
            } catch (Exception e) {
                C2538c.c("HeartRateZoneThroshold", new Object[]{"getThreshold " + str + " meet e:" + e});
            }
        }
    }

    public String toString() {
        return "HeartRateZoneThroshold{fitnessThreshold=" + this.fitnessThreshold + ", warmUpThreshold=" + this.warmUpThreshold + ", fatBurnThreshold=" + this.fatBurnThreshold + ", aerobicThreshold=" + this.aerobicThreshold + ", anaerobicThreshold=" + this.anaerobicThreshold + ", maxThreshold=" + this.maxThreshold + '}';
    }
}
