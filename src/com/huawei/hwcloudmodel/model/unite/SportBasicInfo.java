package com.huawei.hwcloudmodel.model.unite;

public class SportBasicInfo {
    private Float altitude;
    private Integer calorie;
    private Integer count;
    private Integer distance;
    private Integer duration;
    private Integer floor;
    private Integer steps;

    public Integer getSteps() {
        return this.steps;
    }

    public void setSteps(Integer num) {
        this.steps = num;
    }

    public Integer getDistance() {
        return this.distance;
    }

    public void setDistance(Integer num) {
        this.distance = num;
    }

    public Integer getCalorie() {
        return this.calorie;
    }

    public void setCalorie(Integer num) {
        this.calorie = num;
    }

    public Float getAltitude() {
        return this.altitude;
    }

    public void setAltitude(Float f) {
        this.altitude = f;
    }

    public Integer getFloor() {
        return this.floor;
    }

    public void setFloor(Integer num) {
        this.floor = num;
    }

    public Integer getDuration() {
        return this.duration;
    }

    public void setDuration(Integer num) {
        this.duration = num;
    }

    public Integer getCount() {
        return this.count;
    }

    public void setCount(Integer num) {
        this.count = num;
    }
}
