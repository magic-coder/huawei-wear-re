package com.huawei.hwcloudmodel.model.unite;

import java.io.Serializable;

public class MotionPathHeartRate implements Serializable {
    private static final long serialVersionUID = -6019653484064737738L;
    private Integer heartRate;
    private Long time;

    public Long getTime() {
        return this.time;
    }

    public void setTime(Long l) {
        this.time = l;
    }

    public Integer getHeartRate() {
        return this.heartRate;
    }

    public void setHeartRate(Integer num) {
        this.heartRate = num;
    }

    public String toString() {
        return "MotionPathHeartRate [time=" + this.time + ", heartRate=" + this.heartRate + "]";
    }
}
