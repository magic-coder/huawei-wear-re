package cn.com.fmsh.tsm.business.enums;

import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.util.BCCUtil;
import cn.com.fmsh.util.CRCUtil;
import cn.com.fmsh.util.FM_Bytes;
import cn.com.fmsh.util.FM_Int;

public enum EnumCardAppStatus {
    STATUS_NO_APP(1, FM_Bytes.concat("廍电杫富裌", 2, 36)),
    STATUS_LOADED(2, FM_Int.replace(4, "厶戻蠓裇轸斏份B^US_Y")),
    STATUS_INSTALL(3, FM_Int.replace(5, "乐洪交這卧庝甤宆裗")),
    STATUS_PERSONALIZED(4, CRCUtil.substring(1, "丄浮亠逕卻乯仪卍")),
    STATUS_ACTIVATE(5, BCCUtil.getChars("乞浣亰過匵弔逎", 4, 32)),
    STATUS_UNKNOW(10, FM_Exception.insert(5, 114, "朣瞾狻恞"));

    public static EnumCardAppStatus instance(int i) {
        for (EnumCardAppStatus enumCardAppStatus : values()) {
            if (enumCardAppStatus.getId() == i) {
                return enumCardAppStatus;
            }
        }
        return null;
    }

    public String getDesc() {
        return this.f9801b;
    }

    public int getId() {
        return this.f9800a;
    }
}
