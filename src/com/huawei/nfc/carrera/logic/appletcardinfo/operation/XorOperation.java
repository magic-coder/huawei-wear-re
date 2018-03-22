package com.huawei.nfc.carrera.logic.appletcardinfo.operation;

import com.huawei.nfc.carrera.logic.appletcardinfo.exception.AppletCardException;

public class XorOperation extends Operation {
    public String handleData(String str) throws AppletCardException {
        char[] toCharArray = str.toCharArray();
        int numericValue = Character.getNumericValue(toCharArray[0]);
        for (int i = 1; i < toCharArray.length; i++) {
            numericValue ^= Character.getNumericValue(toCharArray[i]);
        }
        return String.valueOf(numericValue);
    }
}
