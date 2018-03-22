package cn.com.fmsh.tsm.business.enums;

import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.util.BCCUtil;
import cn.com.fmsh.util.CRCUtil;
import cn.com.fmsh.util.FM_Int;
import cn.com.fmsh.util.FM_Long;
import cn.com.fmsh.util.FM_Utils;

public enum EnumAppManageOperateType {
    APP_LOCK(1, FM_Int.replace(2, "匶乐廉用兰闫")),
    APP_UNLOCK(2, FM_Long.copyValueOf("卭七庒甫开呲", 132)),
    APP_STATUS_QUERY(3, BCCUtil.getChars("匲乐底甠彜剛犫怅柮诰", 3, 7)),
    APP_DELETE(4, CRCUtil.substring(2, "卮丐庑甸刻阢")),
    APP_MOVE(5, FM_Utils.regionMatches(62, 30, "卯乆廞甠过冾")),
    APP_DOWNLOAD(6, FM_Exception.insert(44, 118, "危丌庈町刨阺"));

    public static EnumAppManageOperateType instance(int i) {
        for (EnumAppManageOperateType enumAppManageOperateType : values()) {
            if (enumAppManageOperateType.getId() == i) {
                return enumAppManageOperateType;
            }
        }
        return null;
    }

    public String getDesc() {
        return this.f9786b;
    }

    public int getId() {
        return this.f9785a;
    }
}
