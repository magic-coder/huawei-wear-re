package cn.com.fmsh.tsm.business.enums;

import cn.com.fmsh.util.CRCUtil;
import cn.com.fmsh.util.FM_Bytes;

public enum EnumUserPlatformType {
    NFCOS(1, FM_Bytes.concat("\u0014\u0003S\u0014U粪练年厢", 3, 75)),
    THIRD(2, CRCUtil.substring(3, "笼丒斿幢召"));

    public static EnumUserPlatformType getActivationStatus4ID(int i) {
        for (EnumUserPlatformType enumUserPlatformType : values()) {
            if (enumUserPlatformType.getId() == i) {
                return enumUserPlatformType;
            }
        }
        return null;
    }

    public String getDesc() {
        return this.f9834b;
    }

    public int getId() {
        return this.f9833a;
    }
}
