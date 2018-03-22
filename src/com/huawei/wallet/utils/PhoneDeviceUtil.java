package com.huawei.wallet.utils;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.wallet.logic.multicard.MultiCardFactory;
import com.huawei.wallet.utils.log.LogC;
import java.util.UUID;

public class PhoneDeviceUtil {
    private static String f21602a = "";
    private static String f21603b = "";

    public static String m28466a(Context context) {
        String str = null;
        if (!TextUtils.isEmpty(f21602a)) {
            return f21602a;
        }
        if (MultiCardFactory.m28063b()) {
            LogC.m28527a("multicard device", false);
            str = MultiCardFactory.m28062a().mo5146a(0);
        }
        if (TextUtils.isEmpty(str)) {
            str = m28467b(context);
        }
        if (TextUtils.isEmpty(str)) {
            str = m28468c(context);
            if (!TextUtils.isEmpty(str)) {
                str = str.replaceAll(":", "");
            }
        }
        if (TextUtils.isEmpty(str)) {
            LogC.m28530b("getDeviceID getUUID", false);
            str = m28465a();
        }
        f21602a = str;
        return str;
    }

    public static String m28467b(Context context) {
        if (!TextUtils.isEmpty(f21603b)) {
            return f21603b;
        }
        if (context == null) {
            LogC.m28532c("PhoneDeviceUtil getDeviceId context is null", false);
            return null;
        }
        String str;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            str = null;
        } else if (VERSION.SDK_INT < 23) {
            str = telephonyManager.getDeviceId();
        } else if (context.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
            str = telephonyManager.getDeviceId();
        } else {
            LogC.m28532c("PhoneDeviceUtil getDeviceID , wallet has no READ_PHONE_STATE permission", false);
            str = null;
        }
        f21603b = str;
        return str;
    }

    public static String m28468c(Context context) {
        String str = "";
        String macAddress;
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager == null) {
                return str;
            }
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo == null) {
                return str;
            }
            macAddress = connectionInfo.getMacAddress();
            return macAddress;
        } catch (SecurityException e) {
            LogC.m28534d("can not get getLocalMacAddress", false);
            macAddress = str;
        }
    }

    public static String m28465a() {
        String replace = UUID.randomUUID().toString().replace("-", "");
        if (replace.length() > 15) {
            return replace.substring(0, 16);
        }
        return SNBConstant.DEFAULT_CARD_NO.substring(15 - replace.length()) + replace;
    }
}
