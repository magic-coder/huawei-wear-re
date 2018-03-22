package cn.com.fmsh.tsm.business.enums;

import cn.com.fmsh.util.BCCUtil;
import cn.com.fmsh.util.FM_Long;

public enum EnumCardBusinessOpType {
    ORDER(1, FM_Long.copyValueOf("讯货濇洿", 5)),
    UNSUBSCRIBE(2, BCCUtil.getChars("達诹", 4, 103));

    public static EnumCardBusinessOpType getCardIoType(int i) {
        for (EnumCardBusinessOpType enumCardBusinessOpType : values()) {
            if (enumCardBusinessOpType.getId() == i) {
                return enumCardBusinessOpType;
            }
        }
        return null;
    }

    public String getDesc() {
        return this.f9807b;
    }

    public int getId() {
        return this.f9806a;
    }
}
