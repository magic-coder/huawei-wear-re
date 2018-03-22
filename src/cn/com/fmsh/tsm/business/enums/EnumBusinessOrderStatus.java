package cn.com.fmsh.tsm.business.enums;

import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.util.FM_Bytes;
import cn.com.fmsh.util.FM_CN;
import cn.com.fmsh.util.FM_Int;
import cn.com.fmsh.util.Util4Java;
import com.huawei.datatype.SportType;

public enum EnumBusinessOrderStatus {
    noOrder(0, FM_Exception.insert(2, 9, "本训贵")),
    orderIng(1, FM_CN.equals("诣贿丮8术瞳该赵纚枆", 206)),
    orderSucess(2, FM_Int.replace(2, "诵起才功")),
    orderFail(3, FM_Int.replace(5, "诸走失账")),
    unsubscribeing(4, FM_Bytes.concat("逕讧丸", 62, 112)),
    unsubscribeSucess(5, Util4Java.endsWith("送讨戃劃", 4, 9)),
    unsubscribeFail(6, FM_Exception.insert(SportType.SPORT_TYPE_SWIM, 21, "逊讽夥赬"));

    public static EnumBusinessOrderStatus getBusinessOrderStatus4ID(int i) {
        for (EnumBusinessOrderStatus enumBusinessOrderStatus : values()) {
            if (enumBusinessOrderStatus.getId() == i) {
                return enumBusinessOrderStatus;
            }
        }
        return null;
    }

    public String getDesc() {
        return this.f9795b;
    }

    public int getId() {
        return this.f9794a;
    }
}
