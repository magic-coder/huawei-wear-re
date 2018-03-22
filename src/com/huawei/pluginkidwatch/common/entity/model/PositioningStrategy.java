package com.huawei.pluginkidwatch.common.entity.model;

import com.huawei.pluginkidwatch.common.lib.utils.C1489i;
import java.util.List;

public class PositioningStrategy {
    public static final int KEY_CUSTOM_FREQUENCY_MODE = 2;
    public static final int KEY_LOCATION_FREQUENCY_MODE = 1;
    public static final int KEY_SAVING_FREQUENCY_MODE = 0;
    private List<PositioningFrequency> positioningFrequencyList;
    private int positioningMode;

    public int getPositioningMode() {
        return ((Integer) C1489i.m6887a(Integer.valueOf(this.positioningMode))).intValue();
    }

    public void setPositioningMode(int i) {
        this.positioningMode = ((Integer) C1489i.m6887a(Integer.valueOf(i))).intValue();
    }

    public List<PositioningFrequency> getPositioningFrequencyList() {
        return (List) C1489i.m6887a(this.positioningFrequencyList);
    }

    public void setPositioningFrequencyList(List<PositioningFrequency> list) {
        this.positioningFrequencyList = (List) C1489i.m6887a(list);
    }
}
