package com.huawei.hwcloudmodel.model.unite;

import java.util.Set;

public class GetSportDimenStatReq {
    private Integer dataSource = Integer.valueOf(2);
    private Integer endTime;
    Set<Integer> sportTypes;
    private Integer startTime;

    public Integer getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Integer num) {
        this.startTime = num;
    }

    public Integer getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Integer num) {
        this.endTime = num;
    }

    public Set<Integer> getSportTypes() {
        return this.sportTypes;
    }

    public Integer getDataSource() {
        return this.dataSource;
    }

    public void setDataSource(Integer num) {
        this.dataSource = num;
    }

    public void setSportTypes(Set<Integer> set) {
        this.sportTypes = set;
    }

    public String toString() {
        return "GetSportDimenStatReq{startTime=" + this.startTime + ", endTime=" + this.endTime + ", dataSource=" + this.dataSource + ", sportTypes=" + this.sportTypes + '}';
    }

    public void uadpGetSportDimenStatReq1() {
    }

    public void uadpGetSportDimenStatReq2() {
    }

    public void uadpGetSportDimenStatReq3() {
    }
}
