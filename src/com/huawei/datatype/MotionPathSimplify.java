package com.huawei.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;

import java.io.Serializable;
import java.util.Map;

public class MotionPathSimplify implements Serializable {
    private static final long serialVersionUID = 4613834291759846024L;
    private int abnormalTrack = 0;
    private int avgHeartRate = 0;
    private float avgPace = 0.0f;
    private int avgStepRate = 0;
    private float bestPace = 0.0f;
    private int bestStepRate = 0;
    private Map<Integer, Float> britishPaceMap;
    private Map<Double, Double> britishPartTimeMap;
    private int chiefSportDataType = 0;
    private float creepingWave = 0.0f;
    private long endTime;
    private boolean hasTrackPoint = true;
    private boolean isFreeMotion = false;
    private String jsonString;
    private int mapType = 0;
    private int maxHeartRate = 0;
    private int minHeartRate = 0;
    private Map<Integer, Float> paceMap;
    private Map<Double, Double> partTimeMap;
    private int sportDataSource = 0;
    private String sportId;
    private int sportType;
    private long startTime;
    private int totalCalories = 0;
    private int totalDistance = 0;
    private int totalSteps = 0;
    private long totalTime = 0;
    private int trackType;
    private Map<String, Integer> wearSportData;

    public int requestAbnormalTrack() {
        return this.abnormalTrack;
    }

    public void saveAbnormalTrack(int i) {
        this.abnormalTrack = i;
    }

    public long getStartTime() {
        return ((Long) C0978h.a(Long.valueOf(this.startTime))).longValue();
    }

    public void setStartTime(long j) {
        this.startTime = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public long getEndTime() {
        return ((Long) C0978h.a(Long.valueOf(this.endTime))).longValue();
    }

    public void setEndTime(long j) {
        this.endTime = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public int getTotalDistance() {
        return ((Integer) C0978h.a(Integer.valueOf(this.totalDistance))).intValue();
    }

    public void setTotalDistance(int i) {
        this.totalDistance = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public long getTotalTime() {
        return ((Long) C0978h.a(Long.valueOf(this.totalTime))).longValue();
    }

    public void setTotalTime(long j) {
        this.totalTime = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public int getTotalCalories() {
        return ((Integer) C0978h.a(Integer.valueOf(this.totalCalories))).intValue();
    }

    public void setTotalCalories(int i) {
        this.totalCalories = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getTotalSteps() {
        return ((Integer) C0978h.a(Integer.valueOf(this.totalSteps))).intValue();
    }

    public void setTotalSteps(int i) {
        this.totalSteps = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public float getAvgPace() {
        return ((Float) C0978h.a(Float.valueOf(this.avgPace))).floatValue();
    }

    public void setAvgPace(float f) {
        this.avgPace = ((Float) C0978h.a(Float.valueOf(f))).floatValue();
    }

    public int getAvgHeartRate() {
        return ((Integer) C0978h.a(Integer.valueOf(this.avgHeartRate))).intValue();
    }

    public void setAvgHeartRate(int i) {
        this.avgHeartRate = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getAvgStepRate() {
        return ((Integer) C0978h.a(Integer.valueOf(this.avgStepRate))).intValue();
    }

    public void setAvgStepRate(int i) {
        this.avgStepRate = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public void setSportId(String str) {
        this.sportId = (String) C0978h.a(str);
    }

    public String getSportId() {
        return (String) C0978h.a(this.sportId);
    }

    public void setSportType(int i) {
        this.sportType = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getSportType() {
        return ((Integer) C0978h.a(Integer.valueOf(this.sportType))).intValue();
    }

    public void setPartTimeMap(Map<Double, Double> map) {
        this.partTimeMap = (Map) C0978h.a(map);
    }

    public Map<Double, Double> getPartTimeMap() {
        return (Map) C0978h.a(this.partTimeMap);
    }

    public Map<Double, Double> getBritishPartTimeMap() {
        return (Map) C0978h.a(this.britishPartTimeMap);
    }

    public void setBritishPartTimeMap(Map<Double, Double> map) {
        this.britishPartTimeMap = (Map) C0978h.a(map);
    }

    public int getTrackType() {
        return ((Integer) C0978h.a(Integer.valueOf(this.trackType))).intValue();
    }

    public void setTrackType(int i) {
        this.trackType = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getMaxHeartRate() {
        return ((Integer) C0978h.a(Integer.valueOf(this.maxHeartRate))).intValue();
    }

    public void setMaxHeartRate(int i) {
        this.maxHeartRate = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getBestStepRate() {
        return ((Integer) C0978h.a(Integer.valueOf(this.bestStepRate))).intValue();
    }

    public void setBestStepRate(int i) {
        this.bestStepRate = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public void setBestPace(float f) {
        this.bestPace = ((Float) C0978h.a(Float.valueOf(f))).floatValue();
    }

    public float getBestPace() {
        return ((Float) C0978h.a(Float.valueOf(this.bestPace))).floatValue();
    }

    public Map<Integer, Float> getPaceMap() {
        return (Map) C0978h.a(this.paceMap);
    }

    public void setPaceMap(Map<Integer, Float> map) {
        this.paceMap = (Map) C0978h.a(map);
    }

    public Map<Integer, Float> getBritishPaceMap() {
        return (Map) C0978h.a(this.britishPaceMap);
    }

    public void setBritishPaceMap(Map<Integer, Float> map) {
        this.britishPaceMap = (Map) C0978h.a(map);
    }

    public Map<String, Integer> getSportData() {
        return (Map) C0978h.a(this.wearSportData);
    }

    public void setSportData(Map<String, Integer> map) {
        this.wearSportData = (Map) C0978h.a(map);
    }

    public float getCreepingWave() {
        return ((Float) C0978h.a(Float.valueOf(this.creepingWave))).floatValue();
    }

    public void setCreepingWave(float f) {
        this.creepingWave = ((Float) C0978h.a(Float.valueOf(f))).floatValue();
    }

    public int getMinHeartRate() {
        return ((Integer) C0978h.a(Integer.valueOf(this.minHeartRate))).intValue();
    }

    public void setMinHeartRate(int i) {
        this.minHeartRate = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getMapType() {
        return ((Integer) C0978h.a(Integer.valueOf(this.mapType))).intValue();
    }

    public void setMapType(int i) {
        this.mapType = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public boolean getIsFreeMotion() {
        return ((Boolean) C0978h.a(Boolean.valueOf(this.isFreeMotion))).booleanValue();
    }

    public void setIsFreeMotion(boolean z) {
        this.isFreeMotion = ((Boolean) C0978h.a(Boolean.valueOf(z))).booleanValue();
    }

    public int getSportDataSource() {
        return ((Integer) C0978h.a(Integer.valueOf(this.sportDataSource))).intValue();
    }

    public void setSportDataSource(int i) {
        this.sportDataSource = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getChiefSportDataType() {
        return ((Integer) C0978h.a(Integer.valueOf(this.chiefSportDataType))).intValue();
    }

    public void setChiefSportDataType(int i) {
        this.chiefSportDataType = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public boolean getHasTrackPoint() {
        return ((Boolean) C0978h.a(Boolean.valueOf(this.hasTrackPoint))).booleanValue();
    }

    public void setHasTrackPoint(boolean z) {
        this.hasTrackPoint = ((Boolean) C0978h.a(Boolean.valueOf(z))).booleanValue();
    }

    public String getJsonString() {
        return (String) C0978h.a(this.jsonString);
    }

    public void setJsonString(String str) {
        this.jsonString = (String) C0978h.a(str);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("sportType ").append(this.sportType).append(" trackType ").append(this.trackType).append("\n");
        stringBuffer.append("sportTime ").append(this.startTime).append("--").append(this.endTime).append("\n");
        stringBuffer.append("duration ").append(this.totalTime).append(" distance ").append(this.totalDistance).append(" calories ").append(this.totalCalories).append(" creepingWave ").append(this.creepingWave).append("\n");
        stringBuffer.append("avgPace ").append(this.avgPace).append(" bestPace ").append(this.bestPace).append("\n");
        stringBuffer.append("avgHeartRate ").append("***").append(" max ").append("***").append(" min ").append("***").append("\n");
        stringBuffer.append("totalSteps ").append(this.totalSteps).append(" avgStepRate ").append(this.avgStepRate).append(" bestStepRate ").append(this.bestStepRate).append("\n");
        if (this.partTimeMap != null && this.partTimeMap.size() > 0) {
            stringBuffer.append("partTimeMap ").append(this.partTimeMap.toString()).append("\n");
        }
        if (this.britishPartTimeMap != null && this.britishPartTimeMap.size() > 0) {
            stringBuffer.append("britishPartTimeMap ").append(this.britishPartTimeMap.toString()).append("\n");
        }
        if (this.paceMap != null && this.paceMap.size() > 0) {
            stringBuffer.append("paceMap ").append(this.paceMap.toString()).append("\n");
        }
        if (this.britishPaceMap != null && this.britishPaceMap.size() > 0) {
            stringBuffer.append("britishPaceMap ").append(this.britishPaceMap.toString()).append("\n");
        }
        stringBuffer.append("isFreeMotion ").append(this.isFreeMotion).append("\n");
        stringBuffer.append("sportDataSource ").append(this.sportDataSource).append("\n");
        stringBuffer.append("chiefSportDataType ").append(this.chiefSportDataType).append("\n");
        stringBuffer.append("hasTrackPoint ").append(this.hasTrackPoint).append("\n");
        stringBuffer.append("abnormalTrack ").append(this.abnormalTrack);
        return stringBuffer.toString();
    }
}
