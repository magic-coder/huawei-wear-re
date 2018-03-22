package com.huawei.pluginkidwatch.common.entity.model;

import java.util.Map;

public class MotionPathsIOEntityModel extends BaseEntityModel {
    private static final long serialVersionUID = 9077384547756030938L;
    public String dateEnd = "";
    public int daysCount = 0;
    public String deviceCode = "";
    public Map<String, MotionPath[]> motionDatas;

    public String toString() {
        String str = "deviceCode = " + this.deviceCode + " dateEnd = " + this.dateEnd + " daysCount = " + this.daysCount + " motionDatas = ";
        if (this.motionDatas != null) {
            return str + this.motionDatas.toString();
        }
        return str + null;
    }

    public void mapMontionPathEnd() {
    }

    public void mapMontionPathStart() {
    }

    public void processMontionDeviceCode() {
    }

    public void processMotionDateEnd() {
    }

    public void queryMotionData() {
    }

    public void sumMontinDayCount() {
    }
}
