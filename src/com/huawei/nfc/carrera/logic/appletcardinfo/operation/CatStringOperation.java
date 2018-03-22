package com.huawei.nfc.carrera.logic.appletcardinfo.operation;

import com.huawei.nfc.carrera.util.StringUtil;

public class CatStringOperation extends Operation {
    public String handleData(String str) {
        return StringUtil.isEmpty(this.param, true) ? str : str + this.param;
    }
}
