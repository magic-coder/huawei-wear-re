package cn.com.fmsh.tsm.business.enums;

import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.util.BCCUtil;

public enum EnumResultsSortType {
    FORWARD(1, FM_Exception.insert(5, 67, "吘刁柪记＝匫尔仐袪枡该盎孚毥：v")),
    BACKWARD(2, BCCUtil.getChars("呂吅枦诹｛卸奤仕袸枮诡盟孄毾＊", 3, 56));

    public static EnumResultsSortType instance(int i) {
        for (EnumResultsSortType enumResultsSortType : values()) {
            if (enumResultsSortType.getId() == i) {
                return enumResultsSortType;
            }
        }
        return null;
    }

    public String getDesc() {
        return this.f9825b;
    }

    public int getId() {
        return this.f9824a;
    }
}
