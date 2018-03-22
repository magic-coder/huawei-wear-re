package com.huawei.pluginkidwatch.common.entity.model;

import java.util.List;

public class GetPdrRetOEntityModel extends BaseEntityModel {
    private static final long serialVersionUID = 9077384547756030938L;
    public String deviceCode = "";
    public List<PDR> pdrList;

    public String toString() {
        String str = "deviceCode = " + this.deviceCode;
        if (this.pdrList != null) {
            return str + this.pdrList.toString();
        }
        return str + null;
    }
}
