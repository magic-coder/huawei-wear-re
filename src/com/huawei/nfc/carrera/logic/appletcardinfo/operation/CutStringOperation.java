package com.huawei.nfc.carrera.logic.appletcardinfo.operation;

import com.huawei.nfc.carrera.logic.appletcardinfo.exception.AppletCardException;
import com.huawei.nfc.carrera.util.StringUtil;

public class CutStringOperation extends Operation {
    public String handleData(String str) throws AppletCardException {
        if (StringUtil.isEmpty(this.param, true)) {
            throw new AppletCardException(2, " CutStringOperation param is null");
        }
        if (this.param.split("-").length < 2) {
            throw new AppletCardException(2, " CutStringOperation index param config error. param : " + this.param);
        }
        int[] iArr = new int[]{Integer.parseInt(this.param.split("-")[0]), Integer.parseInt(this.param.split("-")[1])};
        if (iArr[0] <= iArr[1] && str.length() >= iArr[1]) {
            return str.substring(iArr[0], iArr[1]);
        }
        throw new AppletCardException(2, " CutStringOperation index param config error. param : " + this.param);
    }
}
