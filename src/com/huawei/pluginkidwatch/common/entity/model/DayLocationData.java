package com.huawei.pluginkidwatch.common.entity.model;

import java.util.List;

public class DayLocationData {
    public List<LocationData> dataList;
    public String logDate;

    public DayLocationData(String str, List<LocationData> list) {
        this.logDate = str;
        this.dataList = list;
    }

    public String toString() {
        return "[ logDate=" + this.logDate + " dataList=" + this.dataList + " ]";
    }
}
