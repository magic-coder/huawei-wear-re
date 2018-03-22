package com.huawei.nfc.carrera.logic.appletcardinfo.operation;

import com.huawei.nfc.carrera.logic.appletcardinfo.exception.AppletCardException;
import com.huawei.nfc.carrera.util.StringUtil;
import java.math.BigInteger;

public class MinusOperation extends Operation {
    public String handleData(String str) throws AppletCardException {
        if (!StringUtil.isEmpty(this.param, true)) {
            return String.valueOf(new BigInteger(str).intValue() - new BigInteger(this.param).intValue());
        }
        throw new AppletCardException(2, " MinusOperation param is null");
    }
}
