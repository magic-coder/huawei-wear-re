package cn.com.fmsh.tsm.business.enums;

import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.util.BCCUtil;

public enum EnumOrderType {
    MAIN(1, FM_Exception.insert(6, 22, "丱订千")),
    BUSINESS(2, FM_Exception.insert(2, 96, "东勧诤卓")),
    PAY(3, BCCUtil.getChars("敥从诠匛", 250, 44));

    public static EnumOrderType instance(int i) {
        for (EnumOrderType enumOrderType : values()) {
            if (enumOrderType.getId() == i) {
                return enumOrderType;
            }
        }
        return null;
    }

    public String getDesc() {
        return this.f9819b;
    }

    public int getId() {
        return this.f9818a;
    }
}
