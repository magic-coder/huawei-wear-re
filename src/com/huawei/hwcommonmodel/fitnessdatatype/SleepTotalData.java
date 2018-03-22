package com.huawei.hwcommonmodel.fitnessdatatype;

import com.huawei.hwcommonmodel.p064d.C0978h;

public class SleepTotalData {
    private int breathQualityData = 0;
    private int deepSleepPart = 0;
    private int deepSleepTime = 0;
    private int mScore = 0;
    private int noonSleepTime = 0;
    private int shallowSleepTime = 0;
    private int slumberTime = 0;
    private int snoreFreq = 0;
    private int totalSleepDuration = 0;
    private int type = 255;
    private int wakeupDuration = 0;
    private int wakeupTimes = 0;

    public void setScore(int i) {
        this.mScore = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getScore() {
        return ((Integer) C0978h.a(Integer.valueOf(this.mScore))).intValue();
    }

    public void setType(int i) {
        this.type = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getType() {
        return ((Integer) C0978h.a(Integer.valueOf(this.type))).intValue();
    }

    public int getTotalSleepTime() {
        return ((Integer) C0978h.a(Integer.valueOf((this.deepSleepTime + this.shallowSleepTime) + this.slumberTime))).intValue();
    }

    public void setDeepSleepTime(int i) {
        this.deepSleepTime = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getDeepSleepTime() {
        return ((Integer) C0978h.a(Integer.valueOf(this.deepSleepTime))).intValue();
    }

    public void incDeepSleepTime(int i) {
        this.deepSleepTime = ((Integer) C0978h.a(Integer.valueOf(i))).intValue() + this.deepSleepTime;
    }

    public void setShallowSleepTime(int i) {
        this.shallowSleepTime = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getShallowSleepTime() {
        return ((Integer) C0978h.a(Integer.valueOf(this.shallowSleepTime))).intValue();
    }

    public void setNoonSleepTime(int i) {
        this.noonSleepTime = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getNoonSleepTime() {
        return ((Integer) C0978h.a(Integer.valueOf(this.noonSleepTime))).intValue();
    }

    public void setSlumberSleepTime(int i) {
        this.slumberTime = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getSlumberSleepTime() {
        return ((Integer) C0978h.a(Integer.valueOf(this.slumberTime))).intValue();
    }

    public void incShallowSleepTime(int i) {
        this.shallowSleepTime = ((Integer) C0978h.a(Integer.valueOf(i))).intValue() + this.shallowSleepTime;
    }

    public void setWakeupTimes(int i) {
        this.wakeupTimes = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getWakeupTimes() {
        return ((Integer) C0978h.a(Integer.valueOf(this.wakeupTimes))).intValue();
    }

    public void incWakeupTimes(int i) {
        this.wakeupTimes = ((Integer) C0978h.a(Integer.valueOf(i))).intValue() + this.wakeupTimes;
    }

    public void setWakeupDuration(int i) {
        this.wakeupDuration = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getWakeupDuration() {
        return ((Integer) C0978h.a(Integer.valueOf(this.wakeupDuration))).intValue();
    }

    public void setDeepSleepPart(int i) {
        this.deepSleepPart = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getDeepSleepPart() {
        return ((Integer) C0978h.a(Integer.valueOf(this.deepSleepPart))).intValue();
    }

    public void setSnoreFreq(int i) {
        this.snoreFreq = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getSnoreFreq() {
        return ((Integer) C0978h.a(Integer.valueOf(this.snoreFreq))).intValue();
    }

    public void setBreathQualityData(int i) {
        this.breathQualityData = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getBreathQualityData() {
        return ((Integer) C0978h.a(Integer.valueOf(this.breathQualityData))).intValue();
    }

    public void setTotalSleepDuration(int i) {
        this.totalSleepDuration = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getTotalSleepDuration() {
        return ((Integer) C0978h.a(Integer.valueOf(this.totalSleepDuration))).intValue();
    }

    public void incWakeupDuration(int i) {
        this.wakeupDuration = ((Integer) C0978h.a(Integer.valueOf(i))).intValue() + this.wakeupDuration;
    }

    public void clear() {
        this.type = 255;
        this.mScore = 0;
        this.totalSleepDuration = 0;
        this.breathQualityData = 0;
        this.snoreFreq = 0;
        this.deepSleepPart = 0;
        this.wakeupDuration = 0;
        this.wakeupTimes = 0;
        this.slumberTime = 0;
        this.noonSleepTime = 0;
        this.shallowSleepTime = 0;
        this.deepSleepTime = 0;
    }

    public String toString() {
        return "SleepTotalData{type=" + this.type + ", totalSleepTime=" + getTotalSleepTime() + ", deepSleepTime=" + this.deepSleepTime + ", shallowSleepTime=" + this.shallowSleepTime + ", noonSleepTime=" + this.noonSleepTime + ", wakeupTimes=" + this.wakeupTimes + ", wakeupDuration=" + this.wakeupDuration + ", deepSleepPart=" + this.deepSleepPart + ", snoreFreq=" + this.snoreFreq + ", mSlumberTime=" + this.slumberTime + ", totalSleepDuration=" + this.totalSleepDuration + ", mScore=" + this.mScore + '}';
    }

    public void initSleepTotalData1() {
    }

    public void initSleepTotalData2() {
    }

    public void initSleepTotalData3() {
    }

    public void initSleepTotalData4() {
    }

    public void initSleepTotalData5() {
    }

    public void initSleepTotalData6() {
    }

    public void initSleepTotalData7() {
    }

    public void initSleepTotalData8() {
    }

    public void initSleepTotalData9() {
    }

    public void initSleepTotalData10() {
    }

    public void initSleepTotalData11() {
    }

    public void initSleepTotalData12() {
    }

    public void initSleepTotalData13() {
    }

    public void initSleepTotalData14() {
    }

    public void initSleepTotalData15() {
    }

    public void initSleepTotalData16() {
    }

    public void initSleepTotalData17() {
    }
}
