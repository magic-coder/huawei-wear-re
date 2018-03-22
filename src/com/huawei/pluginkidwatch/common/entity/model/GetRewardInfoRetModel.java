package com.huawei.pluginkidwatch.common.entity.model;

import cn.com.fmsh.communication.message.constants.Constants.XMLNode.XMLMessage;

public class GetRewardInfoRetModel extends BaseEntityModel {
    private static final long serialVersionUID = 9077384547756030938L;
    public String deviceCode = "-1";
    public String rewardInfo = "";

    public String toString() {
        return XMLMessage.MESSAGE_RET_CODE + this.retCode + "  deviceCode = " + this.deviceCode + " rewardInfo=" + this.rewardInfo;
    }
}
