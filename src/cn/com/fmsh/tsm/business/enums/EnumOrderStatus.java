package cn.com.fmsh.tsm.business.enums;

import cn.com.fmsh.util.BCCUtil;
import cn.com.fmsh.util.CRCUtil;
import cn.com.fmsh.util.FM_Bytes;
import cn.com.fmsh.util.FM_CN;
import cn.com.fmsh.util.FM_Int;
import cn.com.fmsh.util.FM_Long;
import cn.com.fmsh.util.Util4Java;
import com.huawei.hwcommonmodel.fitnessdatatype.FitnessSleepType;
import java.io.Serializable;

public enum EnumOrderStatus implements Serializable {
    notExist(0, FM_Long.copyValueOf("讯卟上孜圩", 5)),
    notPay(1, BCCUtil.getChars("松攠仒", 4, 27)),
    hasPaid(2, FM_CN.equals("嶧亞歩", 2)),
    success(3, FM_Int.replace(2, "仳晉才功")),
    failure(4, Util4Java.endsWith("份昞夰贰", 252, 20)),
    unsettled(5, FM_Int.replace(2, "仳晉狫态朩矣")),
    apilyForRefund(6, FM_Long.copyValueOf("畣论遊歹乩", 232)),
    hasRefunded(7, FM_Long.copyValueOf("嶾遉歸", 196)),
    refundFailure(8, BCCUtil.getChars("違欩奨贾", 5, 66)),
    payFailure(9, FM_CN.equals("亀歷奫赮", 5)),
    waitForPay(10, FM_Int.replace(4, "応敳亇")),
    recharging(11, FM_Bytes.concat("仡遉占儊偡並", 206, 46)),
    dubious(12, FM_Int.replace(3, "厷痊赸径夀琁")),
    invalid(13, CRCUtil.substring(FitnessSleepType.HW_FITNESS_WAKE, "诵南兾闵")),
    unknown(99, FM_Int.replace(3, "杲瞾"));

    public static EnumOrderStatus getOrderStatus4ID(int i) {
        for (EnumOrderStatus enumOrderStatus : values()) {
            if (enumOrderStatus.getId() == i) {
                return enumOrderStatus;
            }
        }
        return null;
    }

    public String getDesc() {
        return this.f9816b;
    }

    public int getId() {
        return this.f9815a;
    }
}
