package com.cmb.pboc.ota.hw;

import com.cmb.pboc.logger.PbocLog;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import com.unionpay.tsmservice.data.Constant;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class OtaValueHw {
    public static String f13464a = null;
    public static String f13465b = null;
    public static String f13466c = null;
    public static String f13467d = null;
    public static String f13468e = null;
    public static boolean f13469f = false;
    private static final String f13470g = OtaValueHw.class.getSimpleName();

    public static HashMap m17762a(String str) {
        HashMap hashMap = new HashMap();
        if (str == null || str.length() == 0 || !str.startsWith("result")) {
            PbocLog.m17741d(f13470g, "Method return error!");
            hashMap.put("result", LightCloudConstants.RESPONSE_RESULT_FAIL);
            return hashMap;
        }
        int indexOf = str.indexOf("{");
        int indexOf2 = str.indexOf("}");
        if (indexOf == -1) {
            PbocLog.m17741d(f13470g, "Error method result, No {");
            hashMap.put("result", LightCloudConstants.RESPONSE_RESULT_FAIL);
            return hashMap;
        } else if (indexOf2 != -1) {
            String substring = str.substring(indexOf + 1, indexOf2);
            Map b = m17763b(substring);
            if (str.contains("method={")) {
                str = str.replace("method={" + substring + "}&", "");
            }
            hashMap = m17763b(str);
            hashMap.putAll(b);
            hashMap.put(Constant.KEY_METHOD, "{" + substring + "}");
            return hashMap;
        } else {
            PbocLog.m17741d(f13470g, "Error method result, No }");
            hashMap.put("result", LightCloudConstants.RESPONSE_RESULT_FAIL);
            return hashMap;
        }
    }

    public static HashMap m17763b(String str) {
        HashMap hashMap = new HashMap();
        if (str == null) {
            PbocLog.m17741d(f13470g, "Result is null.");
            return hashMap;
        } else if (str.indexOf(38) == -1 || str.indexOf(61) == -1) {
            PbocLog.m17741d(f13470g, "Err Result:" + str);
            return hashMap;
        } else {
            String[] split = str.split(SNBConstant.FILTER);
            if (split == null || split.length <= 0) {
                return hashMap;
            }
            for (String str2 : split) {
                String[] split2 = str2.split("=");
                if (!(split2 == null || split2.length == 0)) {
                    if (split2.length == 2) {
                        String str3 = split2[0];
                        Object obj = split2[1];
                        if (str3.equalsIgnoreCase("bankSign") || str3.equalsIgnoreCase("bankSigned")) {
                            try {
                                obj = URLDecoder.decode(obj, "GBK");
                            } catch (UnsupportedEncodingException e) {
                                UnsupportedEncodingException unsupportedEncodingException = e;
                                obj = "";
                                unsupportedEncodingException.printStackTrace();
                            }
                        }
                        hashMap.put(str3, obj);
                    }
                    if (split2.length != 2) {
                        PbocLog.m17741d(f13470g, "Error Item: " + str2);
                    }
                }
            }
            return hashMap;
        }
    }
}
