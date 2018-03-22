package com.huawei.pluginkidwatch.common.entity.model;

import cn.com.fmsh.communication.message.constants.Constants.XMLNode.XMLMessage;
import java.util.List;

public class GetDeviceProfileRetModel extends BaseEntityModel {
    private static final long serialVersionUID = 9077384547756030938L;
    public String deviceCode = "-1";
    public List<DeviceProfile> deviceProfiles;

    public String toString() {
        String str = XMLMessage.MESSAGE_RET_CODE + this.retCode + "  deviceCode = " + this.deviceCode;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        if (this.deviceProfiles != null && this.deviceProfiles.size() > 0) {
            for (DeviceProfile deviceProfile : this.deviceProfiles) {
                stringBuffer.append(deviceProfile.toString());
            }
        }
        return stringBuffer.toString();
    }
}
