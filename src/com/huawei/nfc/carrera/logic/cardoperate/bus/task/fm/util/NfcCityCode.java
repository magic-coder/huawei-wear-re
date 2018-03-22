package com.huawei.nfc.carrera.logic.cardoperate.bus.task.fm.util;

import java.util.HashMap;
import java.util.Map;

public class NfcCityCode {
    private static final String FM_CZ = "58";
    private static final String FM_DG = "45";
    private static final String FM_FS = "11";
    private static final String FM_GZ = "01";
    private static final String FM_HY = "53";
    private static final String FM_HZ = "48";
    private static final String FM_JM = "35";
    private static final String FM_JY = "59";
    private static final String FM_MM = "56";
    private static final String FM_MZ = "57";
    private static final String FM_QY = "55";
    private static final String FM_SG = "52";
    private static final String FM_ST = "51";
    private static final String FM_SW = "30";
    private static final String FM_SZ = "20";
    private static final String FM_YF = "60";
    private static final String FM_YJ = "54";
    private static final String FM_ZH = "25";
    private static final String FM_ZJ = "50";
    private static final String FM_ZQ = "40";
    private static final String FM_ZS = "42";
    private static final String MAP_CZ = "0768";
    private static final String MAP_DG = "0769";
    private static final String MAP_FS = "0757";
    private static final String MAP_GZ = "020";
    private static final String MAP_HY = "0762";
    private static final String MAP_HZ = "0752";
    private static final String MAP_JM = "0750";
    private static final String MAP_JY = "0663";
    private static final String MAP_MM = "0668";
    private static final String MAP_MZ = "0753";
    private static final String MAP_QY = "0763";
    private static final String MAP_SG = "0751";
    private static final String MAP_ST = "0754";
    private static final String MAP_SW = "0660";
    private static final String MAP_SZ = "0755";
    private static final String MAP_YF = "0766";
    private static final String MAP_YJ = "0662";
    private static final String MAP_ZH = "0756";
    private static final String MAP_ZJ = "0759";
    private static final String MAP_ZQ = "0758";
    private static final String MAP_ZS = "0760";
    public static final Map<String, String> mFmcitys;

    static {
        Map hashMap = new HashMap();
        hashMap.put(MAP_GZ, "01");
        hashMap.put(MAP_FS, FM_FS);
        hashMap.put(MAP_SZ, FM_SZ);
        hashMap.put(MAP_ZH, "25");
        hashMap.put(MAP_SW, FM_SW);
        hashMap.put(MAP_JM, FM_JM);
        hashMap.put(MAP_ZQ, FM_ZQ);
        hashMap.put(MAP_ZS, FM_ZS);
        hashMap.put(MAP_DG, FM_DG);
        hashMap.put(MAP_HZ, FM_HZ);
        hashMap.put(MAP_ZJ, FM_ZJ);
        hashMap.put(MAP_ST, FM_ST);
        hashMap.put(MAP_SG, FM_SG);
        hashMap.put(MAP_HY, FM_HY);
        hashMap.put(MAP_YJ, FM_YJ);
        hashMap.put(MAP_QY, FM_QY);
        hashMap.put(MAP_MM, FM_MM);
        hashMap.put(MAP_MZ, FM_MZ);
        hashMap.put(MAP_CZ, "58");
        hashMap.put(MAP_JY, FM_JY);
        hashMap.put(MAP_YF, FM_YF);
        mFmcitys = hashMap;
    }

    public static String getFMCityCode(String str) {
        return (String) mFmcitys.get(str);
    }
}
