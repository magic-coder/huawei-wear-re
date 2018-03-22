package cn.com.fmsh.tsm.business.enums;

import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.util.FM_CN;
import cn.com.fmsh.util.FM_Long;
import cn.com.fmsh.util.FM_Utils;
import cn.com.fmsh.util.Util4Java;
import com.huawei.datatype.SportType;
import java.io.Serializable;

public enum EnumBusinessOrderLoadType implements Serializable {
    unknown(0, FM_CN.equals("板瞣", SportType.SPORT_TYPE_RUN)),
    load(1, FM_Long.copyValueOf("映遑儍偹", 230)),
    supplementLoad(2, FM_Exception.insert(3, 15, "衢兓倹")),
    welfareLoad(3, FM_Utils.regionMatches(150, 52, "禉刳儋倾")),
    promotionLoad(4, Util4Java.endsWith("葻镅光偯:", 1, 71));

    public static EnumBusinessOrderLoadType getBusinessOrderLoadType4ID(int i) {
        for (EnumBusinessOrderLoadType enumBusinessOrderLoadType : values()) {
            if (enumBusinessOrderLoadType.getId() == i) {
                return enumBusinessOrderLoadType;
            }
        }
        return null;
    }

    public String getDesc() {
        return this.f9792b;
    }

    public int getId() {
        return this.f9791a;
    }
}
