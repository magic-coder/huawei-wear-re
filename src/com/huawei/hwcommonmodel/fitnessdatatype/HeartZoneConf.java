package com.huawei.hwcommonmodel.fitnessdatatype;

import com.huawei.hwcommonmodel.p064d.C0978h;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.p190v.C2538c;

public class HeartZoneConf extends HeartRateZoneThroshold {
    boolean warningEnble;
    int warningLimitHR;

    public HeartZoneConf() {
        this(30);
    }

    public HeartZoneConf(int i) {
        super(i);
        this.warningEnble = true;
        this.warningLimitHR = getMaxThreshold();
    }

    public void setThroshold(HeartRateZoneThroshold heartRateZoneThroshold) {
        setFitnessThreshold(heartRateZoneThroshold.getFitnessThreshold());
        setWarmUpThreshold(heartRateZoneThroshold.getWarmUpThreshold());
        setFatBurnThreshold(heartRateZoneThroshold.getFatBurnThreshold());
        setAerobicThreshold(heartRateZoneThroshold.getAerobicThreshold());
        setAnaerobicThreshold(heartRateZoneThroshold.getAnaerobicThreshold());
        setMaxThreshold(heartRateZoneThroshold.getMaxThreshold());
    }

    public void setWarningEnble(boolean z) {
        this.warningEnble = ((Boolean) C0978h.a(Boolean.valueOf(z))).booleanValue();
    }

    public void setWarningLimitHR(int i) {
        this.warningLimitHR = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public boolean isWarningEnble() {
        return ((Boolean) C0978h.a(Boolean.valueOf(this.warningEnble))).booleanValue();
    }

    public int getWarningLimitHR() {
        return ((Integer) C0978h.a(Integer.valueOf(this.warningLimitHR))).intValue();
    }

    public String getHRZoneConfStr() {
        return (String) C0978h.a((this.warningEnble ? "1" : "0") + "|" + this.warningLimitHR);
    }

    public void setHRZoneConf(String str) {
        C2538c.c("HeartRateConf", new Object[]{"setThreshold :" + str});
        if (!str.isEmpty()) {
            String[] split = str.split("\\|");
            try {
                if (split.length == 2) {
                    if (Integer.parseInt(split[0]) == 0) {
                        this.warningEnble = false;
                    } else {
                        this.warningEnble = true;
                    }
                    this.warningLimitHR = Integer.parseInt(split[1]);
                }
            } catch (Exception e) {
                C2538c.c("HeartRateConf", new Object[]{"getThreshold " + str + " meet e:" + e});
            }
        }
    }

    public String toString() {
        return "HeartZoneConf{warningEnble=" + this.warningEnble + ", warningLimitHR=" + this.warningLimitHR + HwAccountConstants.BLANK + super.toString() + '}';
    }
}
