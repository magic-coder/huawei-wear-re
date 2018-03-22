package cn.com.fmsh.tsm.business.enums;

import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.util.BCCUtil;
import cn.com.fmsh.util.FM_Bytes;

public enum EnumTerminalOpType {
    ANDROID(1, BCCUtil.getChars("\u0010X_\u0012JC\u000b", 1, 37)),
    IOS(2, FM_Exception.insert(3, 29, "nK\u0012")),
    WINDOWS(3, FM_Bytes.concat("+.<ygd-", 5, 107));

    public static EnumTerminalOpType getEnumTerminalOpType4ID(int i) {
        for (EnumTerminalOpType enumTerminalOpType : values()) {
            if (enumTerminalOpType.getId() == i) {
                return enumTerminalOpType;
            }
        }
        return null;
    }

    public String getDesc() {
        return this.f9828b;
    }

    public int getId() {
        return this.f9827a;
    }
}
