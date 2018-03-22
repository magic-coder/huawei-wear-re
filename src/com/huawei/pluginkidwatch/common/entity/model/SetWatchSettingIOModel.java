package com.huawei.pluginkidwatch.common.entity.model;

import cn.com.fmsh.communication.message.constants.Constants.XMLNode.XMLMessage;
import java.util.Map;

public class SetWatchSettingIOModel extends BaseEntityModel {
    private static final long serialVersionUID = 9077384547756030938L;
    public String deviceCode;
    public Map<String, Object> settingMap;

    public String toString() {
        String str = XMLMessage.MESSAGE_RET_CODE + this.retCode + "  deviceCode = " + this.deviceCode + "  settingMap = ";
        if (this.settingMap != null) {
            return str + this.settingMap.toString();
        }
        return str + null;
    }
}
