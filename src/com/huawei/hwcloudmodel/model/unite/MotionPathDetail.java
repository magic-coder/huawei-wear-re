package com.huawei.hwcloudmodel.model.unite;

import com.huawei.hwcloudmodel.model.samplepoint.SamplePoint;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class MotionPathDetail implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    private String attribute;
    private String coordinate;
    private Long deviceCode;
    private Long endTime;
    private List<MotionPathHeartRate> heartRateList;
    private List<Location> location;
    private Map<String, Float> paceMap;
    private Map<Double, Double> partTimeMap;
    private String pathImageUri;
    private String recordId;
    private Integer runState;
    private List<SamplePoint> samplePoints;
    private Integer sportType;
    private Long startTime;
    private String timeZone;
    private Integer totalCalories;
    private Integer totalDistance;
    private Integer totalSteps;
    private Long totalTime;
    private String vendor;
    private Long version;

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long l) {
        this.version = l;
    }

    public List<SamplePoint> getSamplePoints() {
        return this.samplePoints;
    }

    public void setSamplePoints(List<SamplePoint> list) {
        this.samplePoints = list;
    }

    public Long getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Long l) {
        this.startTime = l;
    }

    public Long getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Long l) {
        this.endTime = l;
    }

    public Long getDeviceCode() {
        return this.deviceCode;
    }

    public void setDeviceCode(Long l) {
        this.deviceCode = l;
    }

    public String getRecordId() {
        return this.recordId;
    }

    public void setRecordId(String str) {
        this.recordId = str;
    }

    public String getTimeZone() {
        return this.timeZone;
    }

    public void setTimeZone(String str) {
        this.timeZone = str;
    }

    public Integer getTotalSteps() {
        return this.totalSteps;
    }

    public void setTotalSteps(Integer num) {
        this.totalSteps = num;
    }

    public Integer getTotalDistance() {
        return this.totalDistance;
    }

    public void setTotalDistance(Integer num) {
        this.totalDistance = num;
    }

    public Integer getTotalCalories() {
        return this.totalCalories;
    }

    public void setTotalCalories(Integer num) {
        this.totalCalories = num;
    }

    public Long getTotalTime() {
        return this.totalTime;
    }

    public void setTotalTime(Long l) {
        this.totalTime = l;
    }

    public String getPathImageUri() {
        return this.pathImageUri;
    }

    public void setPathImageUri(String str) {
        this.pathImageUri = str;
    }

    public List<MotionPathHeartRate> getHeartRateList() {
        return this.heartRateList;
    }

    public void setHeartRateList(List<MotionPathHeartRate> list) {
        this.heartRateList = list;
    }

    public Integer getSportType() {
        return this.sportType;
    }

    public void setSportType(Integer num) {
        this.sportType = num;
    }

    public Integer getRunState() {
        return this.runState;
    }

    public void setRunState(Integer num) {
        this.runState = num;
    }

    public Map<String, Float> getPaceMap() {
        return this.paceMap;
    }

    public void setPaceMap(Map<String, Float> map) {
        this.paceMap = map;
    }

    public String getVendor() {
        return this.vendor;
    }

    public void setVendor(String str) {
        this.vendor = str;
    }

    public String getCoordinate() {
        return this.coordinate;
    }

    public void setCoordinate(String str) {
        this.coordinate = str;
    }

    public String getAttribute() {
        return this.attribute;
    }

    public void setAttribute(String str) {
        this.attribute = str;
    }

    public List<Location> getLocation() {
        return this.location;
    }

    public void setLocation(List<Location> list) {
        this.location = list;
    }

    public Map<Double, Double> getPartTimeMap() {
        return this.partTimeMap;
    }

    public void setPartTimeMap(Map<Double, Double> map) {
        this.partTimeMap = map;
    }

    public String toString() {
        return "MotionPathDetail [" + "startTime=" + this.startTime + ", endTime=" + this.endTime + ", deviceCode=" + this.deviceCode + ", recordId=" + this.recordId + ", timeZone=" + this.timeZone + ", totalSteps=" + this.totalSteps + ", totalDistance=" + this.totalDistance + ", totalCalories=" + this.totalCalories + ", totalTime=" + this.totalTime + ", pathImageUri=" + this.pathImageUri + ", heartRateList=" + this.heartRateList + ", sportType=" + this.sportType + ", runState=" + this.runState + ", paceMap=" + this.paceMap + ", vendor=" + this.vendor + ", coordinate=" + this.coordinate + ", attribute=" + this.attribute + ", location=" + this.location + ", partTimeMap=" + this.partTimeMap + ", version=" + this.version + "]";
    }

    public MotionPathDetail clone() {
        try {
            return (MotionPathDetail) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
