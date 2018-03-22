package com.huawei.nfc.carrera.logic.spi.fm.impl;

import com.huawei.nfc.carrera.util.LogX;

public class FMAIDUtil {
    private static String myAid = null;

    public static String getAid() {
        LogX.i("FMAIDUtil getAid : " + myAid);
        return myAid;
    }

    public static void setAid(String str) {
        LogX.i("FMAIDUtil setAid : " + str);
        myAid = str;
    }
}
