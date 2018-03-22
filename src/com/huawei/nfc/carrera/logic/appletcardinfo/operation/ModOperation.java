package com.huawei.nfc.carrera.logic.appletcardinfo.operation;

import com.huawei.nfc.carrera.logic.appletcardinfo.exception.AppletCardException;
import com.huawei.nfc.carrera.util.StringUtil;

public class ModOperation extends Operation {
    public String handleData(String str) throws AppletCardException {
        if (!StringUtil.isEmpty(this.param, true)) {
            return String.valueOf(Integer.parseInt(str) % Integer.parseInt(this.param));
        }
        throw new AppletCardException(2, " ModOperation param is null");
    }
}
