package com.huawei.hwcommonmodel.fitnessdatatype;

import com.huawei.hwcommonmodel.p064d.C0978h;

public class FitnessTotalData {
    private int calorie;
    private int distance;
    private int duration;
    private int height;
    private int highIntensiveTime;
    private int lowIntensiveTime;
    private int midIntensiveTime;
    private int sportType;
    private int standTimes;
    private int steps;

    public FitnessTotalData() {
        this.sportType = FitnessSportType.HW_FITNESS_SPORT_ALL;
        this.steps = 0;
        this.calorie = 0;
        this.distance = 0;
    }

    public FitnessTotalData(DataTotalMotion dataTotalMotion) {
        this.sportType = dataTotalMotion.getMotion_type();
        this.steps = dataTotalMotion.getStep();
        this.calorie = dataTotalMotion.getCalorie();
        this.distance = dataTotalMotion.getDistance();
    }

    public void setSportType(int i) {
        this.sportType = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getSportType() {
        return ((Integer) C0978h.a(Integer.valueOf(this.sportType))).intValue();
    }

    public void setSteps(int i) {
        this.steps = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getSteps() {
        return ((Integer) C0978h.a(Integer.valueOf(this.steps))).intValue();
    }

    public void addSteps(int i) {
        this.steps = ((Integer) C0978h.a(Integer.valueOf(this.steps + i))).intValue();
    }

    public void setCalorie(int i) {
        this.calorie = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public void setLowIntensiveTime(int i) {
        this.lowIntensiveTime = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public void setMidIntensiveTime(int i) {
        this.midIntensiveTime = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public void setHighIntensiveTime(int i) {
        this.highIntensiveTime = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public void setStandTimes(int i) {
        this.standTimes = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getCalorie() {
        return ((Integer) C0978h.a(Integer.valueOf(this.calorie))).intValue();
    }

    public void addCalorie(int i) {
        this.calorie = ((Integer) C0978h.a(Integer.valueOf(this.calorie + i))).intValue();
    }

    public void setDistance(int i) {
        this.distance = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getDistance() {
        return ((Integer) C0978h.a(Integer.valueOf(this.distance))).intValue();
    }

    public void addDistance(int i) {
        this.distance = ((Integer) C0978h.a(Integer.valueOf(this.distance + i))).intValue();
    }

    public void setDuration(int i) {
        this.duration = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getDuration() {
        return ((Integer) C0978h.a(Integer.valueOf(this.duration))).intValue();
    }

    public void setHeight(int i) {
        this.height = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getHeight() {
        return ((Integer) C0978h.a(Integer.valueOf(this.height))).intValue();
    }

    public int getLowIntensiveTime() {
        return ((Integer) C0978h.a(Integer.valueOf(this.lowIntensiveTime))).intValue();
    }

    public int getMidIntensiveTime() {
        return ((Integer) C0978h.a(Integer.valueOf(this.midIntensiveTime))).intValue();
    }

    public int getHighIntensiveTime() {
        return ((Integer) C0978h.a(Integer.valueOf(this.highIntensiveTime))).intValue();
    }

    public int getStandTimes() {
        return ((Integer) C0978h.a(Integer.valueOf(this.standTimes))).intValue();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("t=" + getSportType());
        stringBuilder.append(",s=" + getSteps());
        stringBuilder.append(",d=" + getDistance());
        stringBuilder.append(",c=" + getCalorie());
        stringBuilder.append(",h=" + getHeight());
        stringBuilder.append(",du =" + getDuration());
        stringBuilder.append(",low=" + getLowIntensiveTime());
        stringBuilder.append(",mid=" + getMidIntensiveTime());
        stringBuilder.append(",high=" + getHighIntensiveTime());
        stringBuilder.append(",st=" + getStandTimes());
        stringBuilder.append(" ;");
        return stringBuilder.toString();
    }
}
