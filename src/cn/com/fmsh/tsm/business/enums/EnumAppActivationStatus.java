package cn.com.fmsh.tsm.business.enums;

import cn.com.fmsh.util.CRCUtil;
import cn.com.fmsh.util.FM_Bytes;
import cn.com.fmsh.util.FM_CN;
import cn.com.fmsh.util.FM_Int;
import cn.com.fmsh.util.FM_Utils;

public enum EnumAppActivationStatus {
    noActivity(0, FM_Bytes.concat("杶彟逘", 5, 3)),
    activiting(1, FM_CN.equals("彙遐丶", 230)),
    activitySucess(2, FM_Int.replace(4, "彙遆扏劝")),
    activityFail(3, FM_CN.equals("彑遘奢赡", 254)),
    closeing(4, FM_CN.equals("儥閪乵", 3)),
    closeSucess(5, FM_Utils.regionMatches(3, 59, "儠闣扙力")),
    closeFail(6, CRCUtil.substring(2, "兼闷头贵"));

    public static EnumAppActivationStatus getActivationStatus4ID(int i) {
        for (EnumAppActivationStatus enumAppActivationStatus : values()) {
            if (enumAppActivationStatus.getId() == i) {
                return enumAppActivationStatus;
            }
        }
        return null;
    }

    public String getDesc() {
        return this.f9783b;
    }

    public int getId() {
        return this.f9782a;
    }
}
