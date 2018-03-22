package cn.com.fmsh.tsm.business.enums;

import cn.com.fmsh.util.FM_Bytes;
import cn.com.fmsh.util.FM_CN;
import cn.com.fmsh.util.FM_Long;
import cn.com.fmsh.util.FM_Utils;
import cn.com.fmsh.util.Util4Java;

public enum EnumBackInfoType {
    TRAFFIC_CARD(0, FM_Long.copyValueOf("亭逜卢应畵", 1)),
    RECHARGE_REFUND(1, Util4Java.endsWith("儛健叞透歴", 1, 91)),
    CHANGE_MOVE(2, FM_Bytes.concat("捹卿友禿贃", 196, 99)),
    SUBWAY_PAY(3, FM_Utils.regionMatches(5, 75, "坥钁內仲制匭")),
    IMPROVE_ADVICE(4, FM_Utils.regionMatches(218, 18, "動股敷善廨讪")),
    OTHER(5, FM_CN.equals("仼道医廟甴", 5));

    public static EnumBackInfoType instance(int i) {
        for (EnumBackInfoType enumBackInfoType : values()) {
            if (enumBackInfoType.getId() == i) {
                return enumBackInfoType;
            }
        }
        return null;
    }

    public String getDesc() {
        return this.f9789b;
    }

    public int getId() {
        return this.f9788a;
    }
}
