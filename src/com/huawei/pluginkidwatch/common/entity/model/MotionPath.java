package com.huawei.pluginkidwatch.common.entity.model;

import java.io.Serializable;

public class MotionPath implements Serializable {
    private static final long serialVersionUID = 1175906417227817747L;
    public LocationData[] lbsDatas = new LocationData[0];
    public int move_type;
    public String startTime = "";

    public String toString() {
        String str = "startTime = " + this.startTime + " move_type = " + this.move_type + " lbsDatas = ";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        if (this.lbsDatas != null) {
            for (LocationData locationData : this.lbsDatas) {
                stringBuffer.append(locationData.toString());
            }
        }
        return stringBuffer.toString();
    }

    public void getMotionPathName() {
    }

    public void requestMotionPathHeadUrl() {
    }

    public void downloadMotionPathNameUrl() {
    }

    public void judgeMotionPathWeightBySomeInfo() {
    }

    public void setMotionPathSwitchUpload() {
    }

    public void updataMotionPathLocalTable() {
    }

    public void dealWithMotionPathResetFactory() {
    }

    public void refreshMotionPathInitData() {
    }

    public void queryMotionPathProcessData() {
    }

    public void contrustMotionPathHeadImage() {
    }

    public void changeMotionPathDeviceInfo() {
    }
}
