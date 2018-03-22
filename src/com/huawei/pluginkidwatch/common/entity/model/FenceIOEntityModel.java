package com.huawei.pluginkidwatch.common.entity.model;

import java.util.List;

public class FenceIOEntityModel extends BaseEntityModel {
    private static final long serialVersionUID = 9077384547756030938L;
    public String deviceCode = "";
    public List<Fence> fences;

    public String toString() {
        String str = "" + "deviceCode = " + this.deviceCode + "  ";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        if (this.fences != null && this.fences.size() > 0) {
            for (Fence fence : this.fences) {
                stringBuffer.append(fence.toString());
            }
        }
        return stringBuffer.toString();
    }
}
