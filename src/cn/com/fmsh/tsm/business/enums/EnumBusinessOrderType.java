package cn.com.fmsh.tsm.business.enums;

import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.util.CRCUtil;
import cn.com.fmsh.util.FM_Bytes;
import cn.com.fmsh.util.FM_CN;
import cn.com.fmsh.util.FM_Int;
import cn.com.fmsh.util.FM_Long;
import cn.com.fmsh.util.Util4Java;
import com.huawei.crowdtestsdk.common.SpecialIssueType;
import com.huawei.hwcommonmodel.fitnessdatatype.FitnessSleepType;

public enum EnumBusinessOrderType {
    ORDER_TYPE_RECHARGE(1, CRCUtil.substring(FitnessSleepType.HW_FITNESS_WAKE, "儒倾讯卍")),
    ORDER_TYPE_ISSUE(2, FM_Long.copyValueOf("叟卪讪卐", 6)),
    ORDER_TYPE_PROMOTION(3, FM_Int.replace(3, "供镛诼協")),
    TRANSFER(4, FM_CN.equals("輸赣说匒", 1)),
    ORDER_TYPE_ADDED(5, FM_Bytes.concat("蠹儜偪诱包", 5, 125)),
    ORDER_TYPE_WELFARE(6, FM_Exception.insert(194, 6, "秉剥诰匍")),
    UNKNOW(0, Util4Java.endsWith("杴瞷", 1, SpecialIssueType.BUG_TYPE_ID_CHARGE));

    public static EnumBusinessOrderType instance(int i) {
        for (EnumBusinessOrderType enumBusinessOrderType : values()) {
            if (enumBusinessOrderType.getId() == i) {
                return enumBusinessOrderType;
            }
        }
        return null;
    }

    public String getDesc() {
        return this.f9798b;
    }

    public int getId() {
        return this.f9797a;
    }
}
