package cn.com.fmsh.tsm.business.enums;

import android.support.v4.media.TransportMediator;
import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.util.CRCUtil;
import cn.com.fmsh.util.FM_CN;
import cn.com.fmsh.util.FM_Int;
import cn.com.fmsh.util.FM_Long;
import cn.com.fmsh.util.FM_Utils;
import cn.com.fmsh.util.Util4Java;
import java.io.Serializable;

public enum EnumTradeType implements Serializable {
    bus(1, FM_Long.copyValueOf("兢亯", 38)),
    privilege(2, FM_CN.equals("住您份晙", 4)),
    subwayConsumption(3, FM_Exception.insert(2, TransportMediator.KEYCODE_MEDIA_PLAY, "轮遗亦通淖赥")),
    subwayUpdate(4, CRCUtil.substring(204, "輱逗仫遀曱斠")),
    maglev(5, FM_Int.replace(272, "磄悤浥")),
    recharge(6, FM_Int.replace(5, "償贙")),
    ferry(7, FM_CN.equals("轳港", 202)),
    taxi(8, FM_CN.equals("冬禘", 3)),
    expressway(9, FM_Utils.regionMatches(2, 120, "骊違儮趵")),
    park(10, FM_Exception.insert(4, 26, "偔轤圦")),
    gasStation(11, FM_Exception.insert(172, 104, "劰没站")),
    onlineRecharge(12, FM_CN.equals("缉乃償贏", 5)),
    onlineConsumption(13, FM_Long.copyValueOf("罝七涎贺", 4)),
    elseTrade(14, FM_Long.copyValueOf("兼仑亠昒", 2)),
    Consumption(15, Util4Java.endsWith("淗贤", 2, 62)),
    CompositeConsumption(16, FM_Long.copyValueOf("夆吀涍贻", 3));

    public String getDesc() {
        return this.f9831b;
    }

    public int getId() {
        return this.f9830a;
    }
}
