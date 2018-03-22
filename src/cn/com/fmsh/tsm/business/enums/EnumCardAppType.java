package cn.com.fmsh.tsm.business.enums;

import cn.com.fmsh.util.CRCUtil;
import cn.com.fmsh.util.FM_CN;
import cn.com.fmsh.util.FM_Long;
import cn.com.fmsh.util.Util4Java;
import java.io.Serializable;

public enum EnumCardAppType implements Serializable {
    CARD_APP_TYPE_SH(1, Util4Java.endsWith("丈浣亢适匫", 5, 18)),
    CARD_APP_TYPE_LNT(2, CRCUtil.substring(5, "岿半递")),
    CARD_APP_TYPE_SH_TOUR(3, FM_Long.copyValueOf("一浰旁渹卿", 162)),
    CARD_APP_TYPE_SH_RENT(4, FM_CN.equals("乞洲瞻禘卹", 1));

    public static EnumCardAppType instance(int i) {
        for (EnumCardAppType enumCardAppType : values()) {
            if (enumCardAppType.getId() == i) {
                return enumCardAppType;
            }
        }
        return null;
    }

    public String getDesc() {
        return this.f9804b;
    }

    public int getId() {
        return this.f9803a;
    }
}
