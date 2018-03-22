package com.huawei.nfc.carrera.server.card.model;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.huawei.nfc.PluginPay;
import com.huawei.nfc.PluginPayAdapter;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.pay.p473a.p476b.C5721c;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class RiskInfo {
    private static final String APPLAY_CHANEL = "01";
    private static final String DEVICE_WATCH = "3";
    private static final String KEY_ACCOUNTID_HASH = "accountIDHash";
    private static final String KEY_APPLAY_CHANNEL = "applyChannel";
    private static final String KEY_CAPTUREMETHOD = "captureMethod";
    private static final String KEY_DEVICENUMBER = "deviceNumber";
    private static final String KEY_DEVICETYPE = "deviceType";
    private static final String KEY_LANGUAGE = "deviceLanguage";
    private static final String KEY_LOCATION = "extensiveDeviceLocation";
    private static final String KEY_SIM_NUMBER = "deviceSIMNumber";
    private String accountIDHash;
    private String applyChannel = "01";
    private String captureMethod;
    private String deviceLanguage;
    private String devieceType = "3";
    private String extensiveDeviceLocation;
    private String number;
    private int simCount;

    public RiskInfo(Context context, String str, String str2) {
        String userID;
        this.captureMethod = str;
        this.extensiveDeviceLocation = str2;
        this.deviceLanguage = Locale.getDefault().getISO3Language();
        String phoneNum = getPhoneNum(context);
        if (phoneNum != null && phoneNum.length() > 4) {
            this.number = phoneNum.substring(phoneNum.length() - 4, phoneNum.length());
        }
        PluginPayAdapter pluginPayAdapter = (PluginPayAdapter) PluginPay.getInstance(context.getApplicationContext()).getAdapter();
        if (pluginPayAdapter != null) {
            userID = pluginPayAdapter.getUserID();
        } else {
            userID = null;
        }
        if (userID != null) {
            this.accountIDHash = String.valueOf(userID.hashCode());
        }
        if (StringUtil.isEmpty(phoneNum, true)) {
            this.simCount = 0;
        } else {
            this.simCount = 1;
        }
    }

    public JSONObject toJasonString() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("deviceType", this.devieceType);
        jSONObject.put(KEY_APPLAY_CHANNEL, this.applyChannel);
        jSONObject.put(KEY_SIM_NUMBER, this.simCount);
        if (!StringUtil.isEmpty(this.deviceLanguage, true)) {
            jSONObject.put(KEY_LANGUAGE, this.deviceLanguage);
        }
        if (!StringUtil.isEmpty(this.extensiveDeviceLocation, true)) {
            jSONObject.put(KEY_LOCATION, this.extensiveDeviceLocation);
        }
        if (!StringUtil.isEmpty(this.accountIDHash, true)) {
            jSONObject.put(KEY_ACCOUNTID_HASH, this.accountIDHash);
        }
        if (!StringUtil.isEmpty(this.number, true)) {
            jSONObject.put(KEY_DEVICENUMBER, this.number);
        }
        if (!StringUtil.isEmpty(this.captureMethod, true)) {
            jSONObject.put(KEY_CAPTUREMETHOD, this.captureMethod);
        }
        return jSONObject;
    }

    private String getPhoneNum(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            if (C5721c.m26377a(context, "android.permission.READ_PHONE_STATE")) {
                return telephonyManager.getLine1Number();
            }
            LogX.w("PhoneDeviceUtil getDeviceID , wallet has no READ_PHONE_STATE permission", false);
        }
        return null;
    }
}
