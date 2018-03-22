package com.huawei.nfc.carrera.logic.appletcardinfo.operation;

import com.huawei.nfc.carrera.logic.appletcardinfo.exception.AppletCardException;
import com.huawei.nfc.carrera.util.StringUtil;
import java.math.BigInteger;

public class ParseIntOperation extends Operation {
    public String handleData(String str) throws AppletCardException {
        if (!StringUtil.isEmpty(this.param, true)) {
            return String.valueOf(new BigInteger(str, Integer.parseInt(this.param)).intValue());
        }
        throw new AppletCardException(2, " ParseIntOperation param is null");
    }
}
