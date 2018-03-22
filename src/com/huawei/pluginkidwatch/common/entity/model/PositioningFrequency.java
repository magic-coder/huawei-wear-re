package com.huawei.pluginkidwatch.common.entity.model;

import com.huawei.pluginkidwatch.common.lib.utils.C1489i;

public class PositioningFrequency {
    public String cycle;
    public String endTime;
    public String label;
    public String startTime;
    public int strategyType;

    public int getStrategyType() {
        return ((Integer) C1489i.m6887a(Integer.valueOf(this.strategyType))).intValue();
    }

    public void setStrategyType(int i) {
        this.strategyType = ((Integer) C1489i.m6887a(Integer.valueOf(i))).intValue();
    }

    public String getStartTime() {
        return (String) C1489i.m6887a(this.startTime);
    }

    public void setStartTime(String str) {
        this.startTime = (String) C1489i.m6887a(str);
    }

    public String getEndTime() {
        return (String) C1489i.m6887a(this.endTime);
    }

    public void setEndTime(String str) {
        this.endTime = (String) C1489i.m6887a(str);
    }

    public String getCycle() {
        return this.cycle;
    }

    public void setCycle(String str) {
        this.cycle = str;
    }

    public String getLabel() {
        return (String) C1489i.m6887a(this.label);
    }

    public void setLabel(String str) {
        this.label = (String) C1489i.m6887a(str);
    }

    public PositioningFrequency(int i, String str, String str2, String str3, String str4) {
        this.strategyType = i;
        this.startTime = str;
        this.endTime = str2;
        this.cycle = str3;
        this.label = str4;
    }

    public String toString() {
        return "PositioningFrequency{strategyType=" + this.strategyType + ", startTime='" + this.startTime + '\'' + ", endTime='" + this.endTime + '\'' + ", cycle='" + this.cycle + '\'' + ", label='" + this.label + '\'' + '}';
    }

    public void getPotionFrequencyName() {
    }

    public void requestPotionFrequencyHeadUrl() {
    }

    public void downloadPotionFrequencyNameUrl() {
    }

    public void judgePotionFrequencyWeightBySomeInfo() {
    }

    public void setPotionFrequencySwitchUpload() {
    }

    public void updataPotionFrequencyLocalTable() {
    }

    public void dealWithPotionFrequencyResetFactory() {
    }

    public void refreshPotionFrequencyInitData() {
    }

    public void queryPotionFrequencyProcessData() {
    }

    public void contrustPotionFrequencyHeadImage() {
    }

    public void changePotionFrequencyDeviceInfo() {
    }
}
