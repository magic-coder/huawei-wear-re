package com.huawei.hihealth.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.huawei.hihealth.bb;
import java.util.HashMap;
import java.util.Map;

public class HiTrackMetaData implements Parcelable {
    public static final Creator<HiTrackMetaData> CREATOR = new C4561a();
    private int abnormalTrack = 0;
    private int avgHeartRate = 0;
    private float avgPace = 0.0f;
    private int avgStepRate = 0;
    private float bestPace = 0.0f;
    private int bestStepRate = 0;
    private Map<Integer, Float> britishPaceMap = new HashMap();
    private Map<Double, Double> britishPartTimeMap = new HashMap();
    private int chiefSportDataType = 0;
    private String coordinate;
    private float creepingWave = 0.0f;
    private boolean hasTrackPoint = true;
    private boolean isFreeMotion = false;
    private int maxHeartRate = 0;
    private int minHeartRate = 0;
    private Map<Integer, Float> paceMap = new HashMap();
    private Map<Double, Double> partTimeMap = new HashMap();
    private int sportDataSource = 0;
    private String sportId;
    private int sportType;
    private int totalCalories = 0;
    private int totalDistance = 0;
    private int totalSteps = 0;
    private long totalTime = 0;
    private int trackType;
    private String vendor;
    private Map<String, Integer> wearSportData = new HashMap();

    protected HiTrackMetaData(Parcel parcel) {
        boolean z = true;
        this.avgPace = parcel.readFloat();
        this.bestPace = parcel.readFloat();
        this.avgHeartRate = parcel.readInt();
        this.maxHeartRate = parcel.readInt();
        this.avgStepRate = parcel.readInt();
        this.bestStepRate = parcel.readInt();
        this.totalDistance = parcel.readInt();
        this.totalCalories = parcel.readInt();
        this.totalSteps = parcel.readInt();
        this.totalTime = parcel.readLong();
        this.sportId = parcel.readString();
        this.sportType = parcel.readInt();
        this.trackType = parcel.readInt();
        parcel.readMap(this.partTimeMap, Double.class.getClassLoader());
        parcel.readMap(this.paceMap, Float.class.getClassLoader());
        parcel.readMap(this.wearSportData, Integer.class.getClassLoader());
        this.creepingWave = parcel.readFloat();
        this.minHeartRate = parcel.readInt();
        this.vendor = parcel.readString();
        this.coordinate = parcel.readString();
        this.isFreeMotion = parcel.readByte() != (byte) 0;
        this.sportDataSource = parcel.readInt();
        this.chiefSportDataType = parcel.readInt();
        if (parcel.readByte() == (byte) 0) {
            z = false;
        }
        this.hasTrackPoint = z;
        parcel.readMap(this.britishPartTimeMap, Double.class.getClassLoader());
        parcel.readMap(this.britishPaceMap, Float.class.getClassLoader());
        this.abnormalTrack = parcel.readInt();
    }

    public int getTotalDistance() {
        return ((Integer) bb.m21746a(Integer.valueOf(this.totalDistance))).intValue();
    }

    public void setTotalDistance(int i) {
        this.totalDistance = ((Integer) bb.m21746a(Integer.valueOf(i))).intValue();
    }

    public long getTotalTime() {
        return ((Long) bb.m21746a(Long.valueOf(this.totalTime))).longValue();
    }

    public void setTotalTime(long j) {
        this.totalTime = ((Long) bb.m21746a(Long.valueOf(j))).longValue();
    }

    public int getTotalCalories() {
        return ((Integer) bb.m21746a(Integer.valueOf(this.totalCalories))).intValue();
    }

    public void setTotalCalories(int i) {
        this.totalCalories = ((Integer) bb.m21746a(Integer.valueOf(i))).intValue();
    }

    public int getTotalSteps() {
        return ((Integer) bb.m21746a(Integer.valueOf(this.totalSteps))).intValue();
    }

    public void setTotalSteps(int i) {
        this.totalSteps = ((Integer) bb.m21746a(Integer.valueOf(i))).intValue();
    }

    public float getAvgPace() {
        return ((Float) bb.m21746a(Float.valueOf(this.avgPace))).floatValue();
    }

    public void setAvgPace(float f) {
        this.avgPace = ((Float) bb.m21746a(Float.valueOf(f))).floatValue();
    }

    public int getAvgHeartRate() {
        return ((Integer) bb.m21746a(Integer.valueOf(this.avgHeartRate))).intValue();
    }

    public void setAvgHeartRate(int i) {
        this.avgHeartRate = ((Integer) bb.m21746a(Integer.valueOf(i))).intValue();
    }

    public int getAvgStepRate() {
        return ((Integer) bb.m21746a(Integer.valueOf(this.avgStepRate))).intValue();
    }

    public void setAvgStepRate(int i) {
        this.avgStepRate = ((Integer) bb.m21746a(Integer.valueOf(i))).intValue();
    }

    public void setSportId(String str) {
        this.sportId = (String) bb.m21746a(str);
    }

    public String getSportId() {
        return (String) bb.m21746a(this.sportId);
    }

    public void setSportType(int i) {
        this.sportType = ((Integer) bb.m21746a(Integer.valueOf(i))).intValue();
    }

    public int getSportType() {
        return ((Integer) bb.m21746a(Integer.valueOf(this.sportType))).intValue();
    }

    public void setPartTimeMap(Map<Double, Double> map) {
        this.partTimeMap = (Map) bb.m21746a(map);
    }

    public Map<Double, Double> getPartTimeMap() {
        return (Map) bb.m21746a(this.partTimeMap);
    }

    public int getTrackType() {
        return ((Integer) bb.m21746a(Integer.valueOf(this.trackType))).intValue();
    }

    public void setTrackType(int i) {
        this.trackType = ((Integer) bb.m21746a(Integer.valueOf(i))).intValue();
    }

    public int getMaxHeartRate() {
        return ((Integer) bb.m21746a(Integer.valueOf(this.maxHeartRate))).intValue();
    }

    public void setMaxHeartRate(int i) {
        this.maxHeartRate = ((Integer) bb.m21746a(Integer.valueOf(i))).intValue();
    }

    public int getBestStepRate() {
        return ((Integer) bb.m21746a(Integer.valueOf(this.bestStepRate))).intValue();
    }

    public void setBestStepRate(int i) {
        this.bestStepRate = ((Integer) bb.m21746a(Integer.valueOf(i))).intValue();
    }

    public void setBestPace(float f) {
        this.bestPace = ((Float) bb.m21746a(Float.valueOf(f))).floatValue();
    }

    public float getBestPace() {
        return ((Float) bb.m21746a(Float.valueOf(this.bestPace))).floatValue();
    }

    public Map<Integer, Float> getPaceMap() {
        return this.paceMap;
    }

    public void setPaceMap(Map<Integer, Float> map) {
        this.paceMap = map;
    }

    public Map<Integer, Float> getBritishPaceMap() {
        return this.britishPaceMap;
    }

    public void setBritishPaceMap(Map<Integer, Float> map) {
        this.britishPaceMap = (Map) bb.m21746a(map);
    }

    public float getCreepingWave() {
        return ((Float) bb.m21746a(Float.valueOf(this.creepingWave))).floatValue();
    }

    public void setCreepingWave(float f) {
        this.creepingWave = ((Float) bb.m21746a(Float.valueOf(f))).floatValue();
    }

    public Map<String, Integer> getWearSportData() {
        return (Map) bb.m21746a(this.wearSportData);
    }

    public void setWearSportData(Map<String, Integer> map) {
        this.wearSportData = (Map) bb.m21746a(map);
    }

    public int getMinHeartRate() {
        return ((Integer) bb.m21746a(Integer.valueOf(this.minHeartRate))).intValue();
    }

    public void setMinHeartRate(int i) {
        this.minHeartRate = ((Integer) bb.m21746a(Integer.valueOf(i))).intValue();
    }

    public String getVendor() {
        return (String) bb.m21746a(this.vendor);
    }

    public void setVendor(String str) {
        this.vendor = (String) bb.m21746a(str);
    }

    public String getCoordinate() {
        return (String) bb.m21746a(this.coordinate);
    }

    public void setCoordinate(String str) {
        this.coordinate = (String) bb.m21746a(str);
    }

    public boolean getIsFreeMotion() {
        return ((Boolean) bb.m21746a(Boolean.valueOf(this.isFreeMotion))).booleanValue();
    }

    public void setIsFreeMotion(boolean z) {
        this.isFreeMotion = ((Boolean) bb.m21746a(Boolean.valueOf(z))).booleanValue();
    }

    public int getSportDataSource() {
        return ((Integer) bb.m21746a(Integer.valueOf(this.sportDataSource))).intValue();
    }

    public void setSportDataSource(int i) {
        this.sportDataSource = ((Integer) bb.m21746a(Integer.valueOf(i))).intValue();
    }

    public int getChiefSportDataType() {
        return ((Integer) bb.m21746a(Integer.valueOf(this.chiefSportDataType))).intValue();
    }

    public void setChiefSportDataType(int i) {
        this.chiefSportDataType = ((Integer) bb.m21746a(Integer.valueOf(i))).intValue();
    }

    public boolean getHasTrackPoint() {
        return ((Boolean) bb.m21746a(Boolean.valueOf(this.hasTrackPoint))).booleanValue();
    }

    public void setHasTrackPoint(boolean z) {
        this.hasTrackPoint = ((Boolean) bb.m21746a(Boolean.valueOf(z))).booleanValue();
    }

    public Map<Double, Double> getBritishPartTimeMap() {
        return (Map) bb.m21746a(this.britishPartTimeMap);
    }

    public void setBritishPartTimeMap(Map<Double, Double> map) {
        this.britishPartTimeMap = (Map) bb.m21746a(map);
    }

    public int getAbnormalTrack() {
        return ((Integer) bb.m21746a(Integer.valueOf(this.abnormalTrack))).intValue();
    }

    public void setAbnormalTrack(int i) {
        this.abnormalTrack = ((Integer) bb.m21746a(Integer.valueOf(i))).intValue();
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("HiTrackMetaData{");
        stringBuffer.append("totalDistance=").append(this.totalDistance);
        stringBuffer.append(", totalCalories=").append(this.totalCalories);
        stringBuffer.append(", totalSteps=").append(this.totalSteps);
        stringBuffer.append(", totalTime=").append(this.totalTime);
        stringBuffer.append(", trackType=").append(this.trackType);
        stringBuffer.append(", sportType=").append(this.sportType);
        stringBuffer.append(", bestStepRate=").append(this.bestStepRate);
        stringBuffer.append(", avgStepRate=").append(this.avgStepRate);
        stringBuffer.append(", avgPace=").append(this.avgPace);
        stringBuffer.append(", bestPace=").append(this.bestPace);
        stringBuffer.append(", creepingWave=").append(this.creepingWave);
        stringBuffer.append(", wearSportData=").append(this.wearSportData.toString());
        stringBuffer.append(", vendor=").append(this.vendor);
        stringBuffer.append(", coordinate=").append(this.coordinate);
        stringBuffer.append(", isFreeMotion=").append(this.isFreeMotion);
        stringBuffer.append(", sportDataSource=").append(this.sportDataSource);
        stringBuffer.append(", chiefSportDataType=").append(this.chiefSportDataType);
        stringBuffer.append(", hasTrackPoint=").append(this.hasTrackPoint);
        stringBuffer.append(", abnormalTrack=").append(this.abnormalTrack);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeFloat(this.avgPace);
        parcel.writeFloat(this.bestPace);
        parcel.writeInt(this.avgHeartRate);
        parcel.writeInt(this.minHeartRate);
        parcel.writeInt(this.maxHeartRate);
        parcel.writeInt(this.avgStepRate);
        parcel.writeInt(this.bestStepRate);
        parcel.writeInt(this.totalDistance);
        parcel.writeInt(this.totalCalories);
        parcel.writeInt(this.totalSteps);
        parcel.writeLong(this.totalTime);
        parcel.writeString(this.sportId);
        parcel.writeInt(this.sportType);
        parcel.writeInt(this.trackType);
        parcel.writeMap(this.partTimeMap);
        parcel.writeMap(this.paceMap);
        parcel.writeFloat(this.creepingWave);
        parcel.writeMap(this.wearSportData);
        parcel.writeString(this.vendor);
        parcel.writeString(this.coordinate);
        parcel.writeByte((byte) (this.isFreeMotion ? 1 : 0));
        parcel.writeInt(this.sportDataSource);
        parcel.writeInt(this.chiefSportDataType);
        if (!this.hasTrackPoint) {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeMap(this.britishPartTimeMap);
        parcel.writeMap(this.britishPaceMap);
        parcel.writeInt(this.abnormalTrack);
    }
}
