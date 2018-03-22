package com.huawei.hwcloudmodel.model.unite;

public class ProfessionalSleep {
    private int allSleepTime;
    private int awakeTime;
    private int daySleepTime;
    private int deepSleepPart;
    private int deepSleepTime;
    private int dreamTime;
    private long fallAsleepTime;
    private long goBedTime;
    private int lightSleepTime;
    private int sleepEfficiency;
    private int sleepLatency;
    private int sleepScore;
    private String sleepSuggestion;
    private int snoreFreq;
    private float validData;
    private int wakeupCnt;
    private long wakeupTime;

    public long getFallAsleepTime() {
        return this.fallAsleepTime;
    }

    public long getWakeupTime() {
        return this.wakeupTime;
    }

    public int getSleepScore() {
        return this.sleepScore;
    }

    public int getSleepLatency() {
        return this.sleepLatency;
    }

    public long getGoBedTime() {
        return this.goBedTime;
    }

    public float getValidData() {
        return this.validData;
    }

    public int getSleepEfficiency() {
        return this.sleepEfficiency;
    }

    public int getLightSleepTime() {
        return this.lightSleepTime;
    }

    public int getDeepSleepTime() {
        return this.deepSleepTime;
    }

    public int getDreamTime() {
        return this.dreamTime;
    }

    public int getAwakeTime() {
        return this.awakeTime;
    }

    public int getAllSleepTime() {
        return this.allSleepTime;
    }

    public int getWakeupCnt() {
        return this.wakeupCnt;
    }

    public int getDeepSleepPart() {
        return this.deepSleepPart;
    }

    public int getSnoreFreq() {
        return this.snoreFreq;
    }

    public int getDaySleepTime() {
        return this.daySleepTime;
    }

    public String getSleepSuggestion() {
        return this.sleepSuggestion;
    }

    public void setFallAsleepTime(long j) {
        this.fallAsleepTime = j;
    }

    public void setWakeupTime(long j) {
        this.wakeupTime = j;
    }

    public void setSleepScore(int i) {
        this.sleepScore = i;
    }

    public void setSleepLatency(int i) {
        this.sleepLatency = i;
    }

    public void setGoBedTime(long j) {
        this.goBedTime = j;
    }

    public void setValidData(float f) {
        this.validData = f;
    }

    public void setSleepEfficiency(int i) {
        this.sleepEfficiency = i;
    }

    public void setLightSleepTime(int i) {
        this.lightSleepTime = i;
    }

    public void setDeepSleepTime(int i) {
        this.deepSleepTime = i;
    }

    public void setDreamTime(int i) {
        this.dreamTime = i;
    }

    public void setAwakeTime(int i) {
        this.awakeTime = i;
    }

    public void setAllSleepTime(int i) {
        this.allSleepTime = i;
    }

    public void setWakeupCnt(int i) {
        this.wakeupCnt = i;
    }

    public void setDeepSleepPart(int i) {
        this.deepSleepPart = i;
    }

    public void setSnoreFreq(int i) {
        this.snoreFreq = i;
    }

    public void setDaySleepTime(int i) {
        this.daySleepTime = i;
    }

    public void setSleepSuggestion(String str) {
        this.sleepSuggestion = str;
    }

    public String toString() {
        return "ProfessionalSleep{fallAsleepTime=" + this.fallAsleepTime + ", wakeupTime=" + this.wakeupTime + ", sleepScore=" + this.sleepScore + ", sleepLatency=" + this.sleepLatency + ", goBedTime=" + this.goBedTime + ", validData=" + this.validData + ", sleepEfficiency=" + this.sleepEfficiency + ", lightSleepTime=" + this.lightSleepTime + ", deepSleepTime=" + this.deepSleepTime + ", dreamTime=" + this.dreamTime + ", awakeTime=" + this.awakeTime + ", allSleepTime=" + this.allSleepTime + ", wakeupCnt=" + this.wakeupCnt + ", deepSleepPart=" + this.deepSleepPart + ", snoreFreq=" + this.snoreFreq + ", daySleepTime=" + this.daySleepTime + ", sleepSuggestion=" + this.sleepSuggestion + '}';
    }
}
