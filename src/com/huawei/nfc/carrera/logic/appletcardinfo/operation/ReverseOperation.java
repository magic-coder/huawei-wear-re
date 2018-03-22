package com.huawei.nfc.carrera.logic.appletcardinfo.operation;

import com.huawei.nfc.carrera.logic.appletcardinfo.exception.AppletCardException;
import com.huawei.nfc.carrera.util.StringUtil;

public class ReverseOperation extends Operation {
    public String handleData(String str) throws AppletCardException {
        if (StringUtil.isEmpty(this.param, true)) {
            throw new AppletCardException(2, " ReverseOperation param is null");
        }
        int parseInt = Integer.parseInt(this.param);
        int length = str.length();
        if (parseInt <= 0 || length % parseInt != 0) {
            throw new AppletCardException(2, " ReverseOperation the data length can not divide setp . len : " + length + " step : " + parseInt);
        }
        char[] cArr = new char[length];
        if (parseInt != 1) {
            return rervse(split(str, parseInt));
        }
        for (parseInt = 0; parseInt < length; parseInt++) {
            cArr[parseInt] = str.charAt((length - parseInt) - 1);
        }
        return String.copyValueOf(cArr);
    }

    private String[] split(String str, int i) {
        int length = str.length() / i;
        String[] strArr = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            strArr[i2] = str.substring(i2 * i, (i2 + 1) * i);
        }
        return strArr;
    }

    private String rervse(String[] strArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int length = strArr.length - 1; length >= 0; length--) {
            stringBuilder.append(strArr[length]);
        }
        return stringBuilder.toString();
    }
}
