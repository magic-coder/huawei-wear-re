package com.huawei.pluginkidwatch.common.entity.model;

import cn.com.fmsh.communication.message.constants.Constants.XMLNode.XMLMessage;
import java.util.List;

public class DeviceBindUsersIOEntityModel extends BaseEntityModel {
    private static final long serialVersionUID = 9077384547756030938L;
    public String deviceCode = "";
    public String manager = "";
    public List<UserInfo> userInfos;

    public String toString() {
        String str = XMLMessage.MESSAGE_RET_CODE + this.retCode + "  deviceCode = " + this.deviceCode + "  manager = " + this.manager + "  userInfos = ";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        if (this.userInfos != null && this.userInfos.size() > 0) {
            for (UserInfo userInfo : this.userInfos) {
                stringBuffer.append(userInfo.toString());
            }
        }
        return stringBuffer.toString();
    }

    public void sortBindUser() {
    }

    public void managerDeviceCode() {
    }

    public void processUserInfos() {
    }

    public void judgeManagerIsMainManager() {
    }
}
