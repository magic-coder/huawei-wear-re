package cn.com.fmsh.tsm.business.enums;

import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.util.FM_Bytes;
import cn.com.fmsh.util.Util4Java;
import com.huawei.crowdtestsdk.common.SpecialIssueType;

public enum EnumCardIoType {
    CARD_IO_UNKNOW(0, Util4Java.endsWith("末瞭", 4, 103)),
    CARD_IO_TYPE_OUT(1, FM_Exception.insert(4, 40, "夞郸犴立卩ｘ桟卡ぉ归彺匡ａ")),
    CARD_IO_TYPE_IN(2, FM_Bytes.concat("凎卢３@\u0002\u000e区影怊あ>\u0000N彡怚ｚ", SpecialIssueType.BUG_TYPE_ID_CHARGE, 24));

    public static EnumCardIoType getCardIoType(int i) {
        for (EnumCardIoType enumCardIoType : values()) {
            if (enumCardIoType.getId() == i) {
                return enumCardIoType;
            }
        }
        return null;
    }

    public String getDesc() {
        return this.f9810b;
    }

    public int getId() {
        return this.f9809a;
    }
}
