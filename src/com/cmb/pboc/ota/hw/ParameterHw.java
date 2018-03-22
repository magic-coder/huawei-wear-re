package com.cmb.pboc.ota.hw;

import com.cmb.pboc.device.DeviceInfo;
import com.cmb.pboc.global.PbocValue;
import com.cmb.pboc.logger.PbocLog;
import com.huawei.hwappdfxmgr.upload.UploadFile;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.nfc.carrera.storage.db.DataModel.RFConfInfoColumns;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class ParameterHw {
    private static final String f13471a = ParameterHw.class.getSimpleName();

    public static Map m17764a(int i, HashMap hashMap) {
        Map hashMap2;
        switch (i) {
            case 1:
                hashMap2 = new HashMap();
                DeviceInfo a = DeviceInfo.m17717a();
                hashMap2.put("channel", "default");
                hashMap2.put("opcode", "get_method");
                hashMap2.put("inf_ver", "2.0");
                hashMap2.put("term_brand", a.m17719b());
                hashMap2.put("term_model", a.m17720c());
                hashMap2.put("term_serial", a.m17721d());
                hashMap2.put("os_name", a.m17724g());
                hashMap2.put("os_ver", a.m17725h());
                hashMap2.put("dev_type", "1");
                hashMap2.put("se_name", PbocValue.f13426e);
                hashMap2.put("pkg_name", "com.huawei.wallet");
                hashMap2.put("pkg_version", a.m17731n());
                return hashMap2;
            case 2:
                return m17765a(hashMap);
            case 3:
                return m17766b(hashMap);
            case 4:
                return m17767c(hashMap);
            case 5:
                hashMap2 = new HashMap();
                hashMap2.put("inf_ver", "1.0");
                hashMap2.put("channel", new StringBuilder(String.valueOf(OtaValueHw.f13466c)).toString());
                hashMap2.put("opcode", "perso");
                hashMap2.put("type", "app_mgmt");
                hashMap2.put("data", PbocValue.f13429h);
                hashMap2.put("mobile", DeviceInfo.m17717a().m17728k());
                return hashMap2;
            case 6:
                return m17768d(hashMap);
            case 7:
                Object substring;
                String stringBuilder = new StringBuilder(String.valueOf((String) hashMap.get("cplc"))).toString();
                if (stringBuilder.length() > 16) {
                    substring = stringBuilder.substring(20, 36);
                } else {
                    String str = stringBuilder;
                }
                stringBuilder = (String) hashMap.get("aid");
                String str2 = (String) hashMap.get("smscode");
                Map hashMap3 = new HashMap();
                hashMap3.put("inf_ver", "1.0");
                hashMap3.put("channel", new StringBuilder(String.valueOf(OtaValueHw.f13466c)).toString());
                hashMap3.put("opcode", "verifyotp");
                hashMap3.put("smscode", new StringBuilder(String.valueOf(str2)).toString());
                hashMap3.put("command", "0x01");
                hashMap3.put("svc_id", "12");
                hashMap3.put("svc_ver", "1");
                hashMap3.put("type", "card");
                hashMap3.put("se_name", PbocValue.f13426e);
                hashMap3.put("seid", new StringBuilder(String.valueOf(substring)).toString());
                hashMap3.put("aid", new StringBuilder(String.valueOf(stringBuilder)).toString());
                DeviceInfo a2 = DeviceInfo.m17717a();
                hashMap3.put("term_brand", a2.m17719b());
                hashMap3.put("term_model", a2.m17720c());
                hashMap3.put("term_serial", a2.m17721d());
                hashMap3.put("mno", a2.m17729l());
                hashMap3.put("imei", a2.m17722e());
                hashMap3.put(UploadFile.DEVICE_IMSI_LABEL, a2.m17727j());
                hashMap3.put("os_name", a2.m17724g());
                hashMap3.put("os_ver", a2.m17725h());
                hashMap3.put("os_attr", a2.m17726i());
                hashMap3.put("dev_type", "1");
                hashMap3.put("dev_brand", a2.m17719b());
                hashMap3.put("dev_model", a2.m17720c());
                hashMap3.put("dev_serial", a2.m17721d());
                hashMap3.put("pkg_name", a2.m17730m());
                hashMap3.put(RFConfInfoColumns.COLUMN_NAME_ROM_VERSION, a2.m17723f());
                return hashMap3;
            case 8:
                return m17769e(hashMap);
            default:
                return null;
        }
    }

    private static Map m17765a(HashMap hashMap) {
        Object substring;
        String stringBuilder = new StringBuilder(String.valueOf((String) hashMap.get("cplc"))).toString();
        if (stringBuilder.length() > 16) {
            substring = stringBuilder.substring(20, 36);
        } else {
            String str = stringBuilder;
        }
        stringBuilder = (String) hashMap.get("fpan");
        String str2 = (String) hashMap.get("timestamp");
        Object obj = null;
        try {
            obj = URLEncoder.encode(hashMap.get("hwsign").toString(), "GBK");
        } catch (UnsupportedEncodingException e) {
            PbocLog.m17741d(f13471a, e.getMessage());
        }
        Map hashMap2 = new HashMap();
        hashMap2.put("timestamp", new StringBuilder(String.valueOf(str2)).toString());
        hashMap2.put("hwsign", new StringBuilder(String.valueOf(obj)).toString());
        hashMap2.put("checkdata", "APPLYIDCARDACTION|");
        hashMap2.put("inf_ver", "1.0");
        hashMap2.put("channel", new StringBuilder(String.valueOf(OtaValueHw.f13466c)).toString());
        hashMap2.put("opcode", SNBConstant.DEFAULT_OPERATION);
        hashMap2.put("fpan", new StringBuilder(String.valueOf(stringBuilder)).toString());
        hashMap2.put("svc_id", "12");
        hashMap2.put("svc_ver", "1");
        hashMap2.put("type", "card");
        hashMap2.put("se_name", PbocValue.f13426e);
        hashMap2.put("seid", new StringBuilder(String.valueOf(substring)).toString());
        DeviceInfo a = DeviceInfo.m17717a();
        hashMap2.put("term_brand", a.m17719b());
        hashMap2.put("term_model", a.m17720c());
        hashMap2.put("term_serial", a.m17721d());
        hashMap2.put("mno", a.m17729l());
        hashMap2.put("imei", a.m17722e());
        hashMap2.put(UploadFile.DEVICE_IMSI_LABEL, a.m17727j());
        hashMap2.put("os_name", a.m17724g());
        hashMap2.put("os_ver", a.m17725h());
        hashMap2.put("os_attr", a.m17726i());
        hashMap2.put("dev_type", "1");
        hashMap2.put("dev_brand", a.m17719b());
        hashMap2.put("dev_model", a.m17720c());
        hashMap2.put("dev_serial", a.m17721d());
        hashMap2.put(RFConfInfoColumns.COLUMN_NAME_ROM_VERSION, a.m17723f());
        return hashMap2;
    }

    private static Map m17766b(HashMap hashMap) {
        Object substring;
        Object decode;
        Object obj;
        UnsupportedEncodingException unsupportedEncodingException;
        Map hashMap2;
        DeviceInfo a;
        String stringBuilder = new StringBuilder(String.valueOf((String) hashMap.get("cplc"))).toString();
        if (stringBuilder.length() > 16) {
            substring = stringBuilder.substring(20, 36);
        } else {
            String str = stringBuilder;
        }
        stringBuilder = (String) hashMap.get("fpan");
        String str2 = (String) hashMap.get("aid");
        String str3 = (String) hashMap.get("expire");
        String str4 = (String) hashMap.get("userid");
        String str5 = (String) hashMap.get("cvv2");
        String str6 = (String) hashMap.get("inputmethod");
        String str7 = (String) hashMap.get("gps");
        String str8 = (String) hashMap.get("timestamp");
        try {
            String encode = URLEncoder.encode(new StringBuilder(String.valueOf((String) hashMap.get("hwsign"))).toString(), "GBK");
            try {
                decode = URLDecoder.decode(new StringBuilder(String.valueOf((String) hashMap.get("passcode"))).toString(), "GBK");
                obj = encode;
            } catch (UnsupportedEncodingException e) {
                UnsupportedEncodingException unsupportedEncodingException2 = e;
                String str9 = encode;
                unsupportedEncodingException = unsupportedEncodingException2;
                PbocLog.m17741d(f13471a, unsupportedEncodingException.getMessage());
                obj = decode;
                decode = null;
                hashMap2 = new HashMap();
                hashMap2.put("timestamp", new StringBuilder(String.valueOf(str8)).toString());
                hashMap2.put("hwsign", new StringBuilder(String.valueOf(obj)).toString());
                hashMap2.put("checkdata", "APPLYCARDACTION|");
                hashMap2.put("inf_ver", "1.0");
                hashMap2.put("channel", new StringBuilder(String.valueOf(OtaValueHw.f13466c)).toString());
                hashMap2.put("opcode", "userauth");
                hashMap2.put("fpan", new StringBuilder(String.valueOf(stringBuilder)).toString());
                if (hashMap.get("cardtype") != null) {
                    hashMap2.put("cardtype", hashMap.get("cardtype"));
                }
                hashMap2.put("passcode", new StringBuilder(String.valueOf(decode)).toString());
                hashMap2.put("expire", new StringBuilder(String.valueOf(str3)).toString());
                hashMap2.put("userid", new StringBuilder(String.valueOf(str4)).toString());
                hashMap2.put("cvv2", new StringBuilder(String.valueOf(str5)).toString());
                hashMap2.put("inputmethod", new StringBuilder(String.valueOf(str6)).toString());
                hashMap2.put("gps", new StringBuilder(String.valueOf(str7)).toString());
                hashMap2.put("svc_id", "12");
                hashMap2.put("svc_ver", "1");
                hashMap2.put("type", "card");
                hashMap2.put("se_name", PbocValue.f13426e);
                hashMap2.put("seid", new StringBuilder(String.valueOf(substring)).toString());
                hashMap2.put("aid", new StringBuilder(String.valueOf(str2)).toString());
                a = DeviceInfo.m17717a();
                hashMap2.put("term_brand", a.m17719b());
                hashMap2.put("term_model", a.m17720c());
                hashMap2.put("term_serial", a.m17721d());
                hashMap2.put("mno", a.m17729l());
                hashMap2.put("imei", a.m17722e());
                hashMap2.put(UploadFile.DEVICE_IMSI_LABEL, a.m17727j());
                hashMap2.put("os_name", a.m17724g());
                hashMap2.put("os_ver", a.m17725h());
                hashMap2.put("os_attr", a.m17726i());
                hashMap2.put("dev_type", "1");
                hashMap2.put("dev_brand", a.m17719b());
                hashMap2.put("dev_model", a.m17720c());
                hashMap2.put("dev_serial", a.m17721d());
                hashMap2.put(RFConfInfoColumns.COLUMN_NAME_ROM_VERSION, a.m17723f());
                return hashMap2;
            }
        } catch (UnsupportedEncodingException e2) {
            unsupportedEncodingException = e2;
            decode = null;
            PbocLog.m17741d(f13471a, unsupportedEncodingException.getMessage());
            obj = decode;
            decode = null;
            hashMap2 = new HashMap();
            hashMap2.put("timestamp", new StringBuilder(String.valueOf(str8)).toString());
            hashMap2.put("hwsign", new StringBuilder(String.valueOf(obj)).toString());
            hashMap2.put("checkdata", "APPLYCARDACTION|");
            hashMap2.put("inf_ver", "1.0");
            hashMap2.put("channel", new StringBuilder(String.valueOf(OtaValueHw.f13466c)).toString());
            hashMap2.put("opcode", "userauth");
            hashMap2.put("fpan", new StringBuilder(String.valueOf(stringBuilder)).toString());
            if (hashMap.get("cardtype") != null) {
                hashMap2.put("cardtype", hashMap.get("cardtype"));
            }
            hashMap2.put("passcode", new StringBuilder(String.valueOf(decode)).toString());
            hashMap2.put("expire", new StringBuilder(String.valueOf(str3)).toString());
            hashMap2.put("userid", new StringBuilder(String.valueOf(str4)).toString());
            hashMap2.put("cvv2", new StringBuilder(String.valueOf(str5)).toString());
            hashMap2.put("inputmethod", new StringBuilder(String.valueOf(str6)).toString());
            hashMap2.put("gps", new StringBuilder(String.valueOf(str7)).toString());
            hashMap2.put("svc_id", "12");
            hashMap2.put("svc_ver", "1");
            hashMap2.put("type", "card");
            hashMap2.put("se_name", PbocValue.f13426e);
            hashMap2.put("seid", new StringBuilder(String.valueOf(substring)).toString());
            hashMap2.put("aid", new StringBuilder(String.valueOf(str2)).toString());
            a = DeviceInfo.m17717a();
            hashMap2.put("term_brand", a.m17719b());
            hashMap2.put("term_model", a.m17720c());
            hashMap2.put("term_serial", a.m17721d());
            hashMap2.put("mno", a.m17729l());
            hashMap2.put("imei", a.m17722e());
            hashMap2.put(UploadFile.DEVICE_IMSI_LABEL, a.m17727j());
            hashMap2.put("os_name", a.m17724g());
            hashMap2.put("os_ver", a.m17725h());
            hashMap2.put("os_attr", a.m17726i());
            hashMap2.put("dev_type", "1");
            hashMap2.put("dev_brand", a.m17719b());
            hashMap2.put("dev_model", a.m17720c());
            hashMap2.put("dev_serial", a.m17721d());
            hashMap2.put(RFConfInfoColumns.COLUMN_NAME_ROM_VERSION, a.m17723f());
            return hashMap2;
        }
        hashMap2 = new HashMap();
        hashMap2.put("timestamp", new StringBuilder(String.valueOf(str8)).toString());
        hashMap2.put("hwsign", new StringBuilder(String.valueOf(obj)).toString());
        hashMap2.put("checkdata", "APPLYCARDACTION|");
        hashMap2.put("inf_ver", "1.0");
        hashMap2.put("channel", new StringBuilder(String.valueOf(OtaValueHw.f13466c)).toString());
        hashMap2.put("opcode", "userauth");
        hashMap2.put("fpan", new StringBuilder(String.valueOf(stringBuilder)).toString());
        if (hashMap.get("cardtype") != null) {
            hashMap2.put("cardtype", hashMap.get("cardtype"));
        }
        hashMap2.put("passcode", new StringBuilder(String.valueOf(decode)).toString());
        hashMap2.put("expire", new StringBuilder(String.valueOf(str3)).toString());
        hashMap2.put("userid", new StringBuilder(String.valueOf(str4)).toString());
        hashMap2.put("cvv2", new StringBuilder(String.valueOf(str5)).toString());
        hashMap2.put("inputmethod", new StringBuilder(String.valueOf(str6)).toString());
        hashMap2.put("gps", new StringBuilder(String.valueOf(str7)).toString());
        hashMap2.put("svc_id", "12");
        hashMap2.put("svc_ver", "1");
        hashMap2.put("type", "card");
        hashMap2.put("se_name", PbocValue.f13426e);
        hashMap2.put("seid", new StringBuilder(String.valueOf(substring)).toString());
        hashMap2.put("aid", new StringBuilder(String.valueOf(str2)).toString());
        a = DeviceInfo.m17717a();
        hashMap2.put("term_brand", a.m17719b());
        hashMap2.put("term_model", a.m17720c());
        hashMap2.put("term_serial", a.m17721d());
        hashMap2.put("mno", a.m17729l());
        hashMap2.put("imei", a.m17722e());
        hashMap2.put(UploadFile.DEVICE_IMSI_LABEL, a.m17727j());
        hashMap2.put("os_name", a.m17724g());
        hashMap2.put("os_ver", a.m17725h());
        hashMap2.put("os_attr", a.m17726i());
        hashMap2.put("dev_type", "1");
        hashMap2.put("dev_brand", a.m17719b());
        hashMap2.put("dev_model", a.m17720c());
        hashMap2.put("dev_serial", a.m17721d());
        hashMap2.put(RFConfInfoColumns.COLUMN_NAME_ROM_VERSION, a.m17723f());
        return hashMap2;
    }

    private static Map m17767c(HashMap hashMap) {
        Object substring;
        Object encode;
        String stringBuilder = new StringBuilder(String.valueOf((String) hashMap.get("cplc"))).toString();
        if (stringBuilder.length() > 16) {
            substring = stringBuilder.substring(20, 36);
        } else {
            String str = stringBuilder;
        }
        stringBuilder = (String) hashMap.get("aid");
        String str2 = (String) hashMap.get("timestamp");
        try {
            encode = URLEncoder.encode(new StringBuilder(String.valueOf((String) hashMap.get("hwsign"))).toString(), "GBK");
        } catch (UnsupportedEncodingException e) {
            PbocLog.m17741d(f13471a, e.getMessage());
            encode = null;
        }
        Map hashMap2 = new HashMap();
        hashMap2.put("timestamp", new StringBuilder(String.valueOf(str2)).toString());
        hashMap2.put("hwsign", new StringBuilder(String.valueOf(encode)).toString());
        hashMap2.put("checkdata", "ACTIVATEACTION|");
        hashMap2.put("inf_ver", "1.0");
        hashMap2.put("channel", new StringBuilder(String.valueOf(OtaValueHw.f13466c)).toString());
        hashMap2.put("opcode", "perso_init");
        hashMap2.put("svc_id", "12");
        hashMap2.put("svc_ver", "1");
        hashMap2.put("type", "app_mgmt");
        hashMap2.put("card_vendor", "Y");
        hashMap2.put("se_name", PbocValue.f13426e);
        hashMap2.put("se_type", PbocValue.f13425d);
        hashMap2.put("ATR", PbocValue.f13428g);
        hashMap2.put("seid", new StringBuilder(String.valueOf(substring)).toString());
        hashMap2.put("aid", new StringBuilder(String.valueOf(stringBuilder)).toString());
        DeviceInfo a = DeviceInfo.m17717a();
        hashMap2.put("mobile", a.m17728k());
        hashMap2.put("term_brand", a.m17719b());
        hashMap2.put("term_model", a.m17720c());
        hashMap2.put("term_serial", a.m17721d());
        hashMap2.put("app_right", a.m17726i());
        hashMap2.put("mno", a.m17729l());
        hashMap2.put("imei", a.m17722e());
        hashMap2.put(UploadFile.DEVICE_IMSI_LABEL, a.m17727j());
        hashMap2.put("os_name", a.m17724g());
        hashMap2.put("os_ver", a.m17725h());
        hashMap2.put("os_attr", a.m17726i());
        hashMap2.put("dev_type", "1");
        hashMap2.put("dev_brand", a.m17719b());
        hashMap2.put("dev_model", a.m17720c());
        hashMap2.put("dev_serial", a.m17721d());
        hashMap2.put(RFConfInfoColumns.COLUMN_NAME_ROM_VERSION, a.m17723f());
        return hashMap2;
    }

    private static Map m17768d(HashMap hashMap) {
        Object substring;
        Object encode;
        String stringBuilder = new StringBuilder(String.valueOf((String) hashMap.get("cplc"))).toString();
        if (stringBuilder.length() > 16) {
            substring = stringBuilder.substring(20, 36);
        } else {
            String str = stringBuilder;
        }
        stringBuilder = (String) hashMap.get("command");
        String str2 = (String) hashMap.get("dpan");
        String str3 = (String) hashMap.get("aid");
        String str4 = (String) hashMap.get("timestamp");
        try {
            encode = URLEncoder.encode(new StringBuilder(String.valueOf((String) hashMap.get("hwsign"))).toString(), "GBK");
        } catch (UnsupportedEncodingException e) {
            PbocLog.m17741d(f13471a, e.getMessage());
            encode = null;
        }
        Map hashMap2 = new HashMap();
        hashMap2.put("timestamp", new StringBuilder(String.valueOf(str4)).toString());
        hashMap2.put("hwsign", new StringBuilder(String.valueOf(encode)).toString());
        hashMap2.put("checkdata", "ACTIVATEACTION|");
        hashMap2.put("inf_ver", "1.0");
        hashMap2.put("channel", new StringBuilder(String.valueOf(OtaValueHw.f13466c)).toString());
        hashMap2.put("opcode", "triggerotp");
        hashMap2.put("command", new StringBuilder(String.valueOf(stringBuilder)).toString());
        hashMap2.put("dpan", new StringBuilder(String.valueOf(str2)).toString());
        hashMap2.put("svc_id", "12");
        hashMap2.put("svc_ver", "1");
        hashMap2.put("type", "card");
        hashMap2.put("se_name", PbocValue.f13426e);
        hashMap2.put("seid", new StringBuilder(String.valueOf(substring)).toString());
        hashMap2.put("aid", new StringBuilder(String.valueOf(str3)).toString());
        DeviceInfo a = DeviceInfo.m17717a();
        hashMap2.put("term_brand", a.m17719b());
        hashMap2.put("term_model", a.m17720c());
        hashMap2.put("term_serial", a.m17721d());
        hashMap2.put("mno", a.m17729l());
        hashMap2.put("imei", a.m17722e());
        hashMap2.put(UploadFile.DEVICE_IMSI_LABEL, a.m17727j());
        hashMap2.put("os_name", a.m17724g());
        hashMap2.put("os_ver", a.m17725h());
        hashMap2.put("os_attr", a.m17726i());
        hashMap2.put("dev_type", "1");
        hashMap2.put("dev_brand", a.m17719b());
        hashMap2.put("dev_model", a.m17720c());
        hashMap2.put("dev_serial", a.m17721d());
        hashMap2.put("pkg_name", a.m17730m());
        hashMap2.put(RFConfInfoColumns.COLUMN_NAME_ROM_VERSION, a.m17723f());
        return hashMap2;
    }

    private static Map m17769e(HashMap hashMap) {
        Object substring;
        Object encode;
        String stringBuilder = new StringBuilder(String.valueOf((String) hashMap.get("cplc"))).toString();
        if (stringBuilder.length() > 16) {
            substring = stringBuilder.substring(20, 36);
        } else {
            String str = stringBuilder;
        }
        stringBuilder = (String) hashMap.get("dpan");
        String str2 = (String) hashMap.get("aid");
        String str3 = (String) hashMap.get("timestamp");
        try {
            encode = URLEncoder.encode(new StringBuilder(String.valueOf((String) hashMap.get("hwsign"))).toString(), "GBK");
        } catch (UnsupportedEncodingException e) {
            PbocLog.m17741d(f13471a, e.getMessage());
            encode = null;
        }
        Map hashMap2 = new HashMap();
        hashMap2.put("timestamp", new StringBuilder(String.valueOf(str3)).toString());
        hashMap2.put("hwsign", new StringBuilder(String.valueOf(encode)).toString());
        hashMap2.put("checkdata", "NULLIFYACTION|");
        hashMap2.put("inf_ver", "1.0");
        hashMap2.put("channel", new StringBuilder(String.valueOf(OtaValueHw.f13466c)).toString());
        hashMap2.put("opcode", "deleteApp");
        hashMap2.put("dpan", new StringBuilder(String.valueOf(stringBuilder)).toString());
        hashMap2.put("svc_id", "12");
        hashMap2.put("svc_ver", "1");
        hashMap2.put("type", "card");
        hashMap2.put("se_name", PbocValue.f13426e);
        hashMap2.put("seid", new StringBuilder(String.valueOf(substring)).toString());
        hashMap2.put("aid", new StringBuilder(String.valueOf(str2)).toString());
        DeviceInfo a = DeviceInfo.m17717a();
        hashMap2.put("term_brand", a.m17719b());
        hashMap2.put("term_model", a.m17720c());
        hashMap2.put("term_serial", a.m17721d());
        hashMap2.put("mno", a.m17729l());
        hashMap2.put("imei", a.m17722e());
        hashMap2.put(UploadFile.DEVICE_IMSI_LABEL, a.m17727j());
        hashMap2.put("os_name", a.m17724g());
        hashMap2.put("os_ver", a.m17725h());
        hashMap2.put("os_attr", a.m17726i());
        hashMap2.put("dev_type", "1");
        hashMap2.put("dev_brand", a.m17719b());
        hashMap2.put("dev_model", a.m17720c());
        hashMap2.put("dev_serial", a.m17721d());
        hashMap2.put("pkg_name", a.m17730m());
        hashMap2.put(RFConfInfoColumns.COLUMN_NAME_ROM_VERSION, a.m17723f());
        return hashMap2;
    }
}
