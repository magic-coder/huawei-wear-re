package com.huawei.pluginkidwatch.common.entity.model;

import com.huawei.hwid.core.constants.HwAccountConstants;
import java.io.Serializable;
import java.util.HashMap;

public class RewardInfo implements Serializable {
    private static final long serialVersionUID = 6212568607311630447L;
    public String deviceCode = "";
    public HashMap<String, String> reward = new HashMap();

    public String toString() {
        return " deviceCode=" + this.deviceCode + ", reward=" + this.reward + HwAccountConstants.BLANK;
    }
}
