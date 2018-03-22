package com.huawei.hwcloudmodel.model.unite;

import java.util.Set;

public class GetHealthStatReq {
    private int dataSource;
    private long deviceCode;
    private int endTime;
    private int startTime;
    private Set<Integer> types;

    public int getStartTime() {
        return this.startTime;
    }

    public int getEndTime() {
        return this.endTime;
    }

    public int getDataSource() {
        return this.dataSource;
    }

    public long getDeviceCode() {
        return this.deviceCode;
    }

    public Set<Integer> getTypes() {
        return this.types;
    }

    public void setStartTime(int i) {
        this.startTime = i;
    }

    public void setEndTime(int i) {
        this.endTime = i;
    }

    public void setDataSource(int i) {
        this.dataSource = i;
    }

    public void setDeviceCode(long j) {
        this.deviceCode = j;
    }

    public void setTypes(Set<Integer> set) {
        this.types = set;
    }

    public String toString() {
        return "GetHealthStatReq{startTime=" + this.startTime + ", endTime=" + this.endTime + ", dataSource=" + this.dataSource + ", deviceCode=" + this.deviceCode + ", types=" + this.types + '}';
    }
}
