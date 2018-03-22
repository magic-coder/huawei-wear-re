package com.huawei.pluginkidwatch.common.entity.model;

import java.io.Serializable;

public class CommonState implements Serializable {
    private static final long serialVersionUID = 9077384547756030938L;
    public String deviceCode = "";
    public String lastModifyTime = "";
    public int type = -1;
    public String value = "";

    public String toString() {
        return "CommonStateOModel [deviceCode=" + this.deviceCode + ", type=" + this.type + ",value=" + this.value + ", lastModifyTime=" + this.lastModifyTime + "]";
    }

    public void openCommonWearType() {
    }

    public void closeCommonWearTypd() {
    }

    public void checkModifyTimeForLast() {
    }

    public void onModeProcessDeviceCode() {
    }
}
