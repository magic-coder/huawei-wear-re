package cn.com.fmsh.tsm.business.enums;

import android.support.v4.media.TransportMediator;
import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.util.BCCUtil;
import cn.com.fmsh.util.CRCUtil;
import cn.com.fmsh.util.FM_Bytes;
import cn.com.fmsh.util.FM_CN;
import cn.com.fmsh.util.FM_Long;
import cn.com.fmsh.util.Util4Java;

public enum EnumRechargeMode {
    COMPANY_GIVE(0, FM_Bytes.concat("唟扸伝悻", 2, 86)),
    ALIPAY_ONE_KEY(1, FM_CN.equals("敹亟寅义锴攤仄", 3)),
    ALIPAY_SECURE(2, CRCUtil.substring(118, "攬他宄宍內攵亝")),
    UNIONPAY(3, FM_CN.equals("钠耓斸匨7卪兰叵儗奨`", 3)),
    UNIONPAY_CARD(49, FM_Bytes.concat("钯聇杄卦l卺儹号儀夤", TransportMediator.KEYCODE_MEDIA_RECORD, 58)),
    UNIONPAY_FM(4, FM_Long.copyValueOf("铸聟%夈旤忱", 6)),
    UNIONPAY_CARD_FM(65, Util4Java.endsWith("钩聜杘医.奁斳徰赡厧9", 2, 41)),
    CARD_SHIFT_CAPITAL(58, FM_Bytes.concat("亱遑占蠲先偿q丂厪额厀祯4", 318, 54)),
    MIPAY_MI(81, BCCUtil.getChars("屝簩敭仒", 2, 104)),
    SAMSUNG_PAY(86, BCCUtil.getChars("九晐攥仝", 4, 91)),
    UNIONPAY_CARD_PT(87, FM_CN.equals("钠耓村匨7鹄泬丄晁", 3)),
    MOBILE_PROMOTION(60, FM_CN.equals("禯勭侕镇0丄叵颍厍礥", 1)),
    HW_PAY(69, FM_CN.equals("卙串敶互", 292)),
    LKL_PAY(80, FM_Exception.insert(5, 125, "拀卧拊支亅"));

    public static EnumRechargeMode instance(int i) {
        for (EnumRechargeMode enumRechargeMode : values()) {
            if (enumRechargeMode.getId() == i) {
                return enumRechargeMode;
            }
        }
        return null;
    }

    public String getDesc() {
        return this.f9822b;
    }

    public int getId() {
        return this.f9821a;
    }
}
