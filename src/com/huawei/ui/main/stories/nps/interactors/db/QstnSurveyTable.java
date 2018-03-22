package com.huawei.ui.main.stories.nps.interactors.db;

import java.io.Serializable;

public class QstnSurveyTable implements Serializable {
    public String deviceID;
    public String deviceType;
    public int id = 0;
    public long lastSurveyTime;
    public String surveyID;
    public Integer times;

    public String getDeviceID() {
        return this.deviceID;
    }

    public void setDeviceID(String str) {
        this.deviceID = str;
    }

    public long getLastSurveyTime() {
        return this.lastSurveyTime;
    }

    public void setLastSurveyTime(long j) {
        this.lastSurveyTime = j;
    }

    public String getDeviceType() {
        return this.deviceType;
    }

    public void setDeviceType(String str) {
        this.deviceType = str;
    }

    public Integer getTimes() {
        return this.times;
    }

    public void setTimes(Integer num) {
        this.times = num;
    }

    public String getSurveyID() {
        return this.surveyID;
    }

    public void setSurveyID(String str) {
        this.surveyID = str;
    }

    public String toString() {
        return "QstnSurveyTable{deviceID='" + this.deviceID + '\'' + ", lastSurveyTime=" + this.lastSurveyTime + ", deviceType='" + this.deviceType + '\'' + ", times=" + this.times + ", surveyID=" + this.surveyID + ", id=" + this.id + '}';
    }

    public void QSTData1() {
    }

    public void QSTData2() {
    }

    public void QSTData3() {
    }

    public void QSTData4() {
    }

    public void QSTData5() {
    }

    public void QSTData6() {
    }

    public void QSTData7() {
    }

    public void QSTData8() {
    }

    public void QSTData9() {
    }
}
