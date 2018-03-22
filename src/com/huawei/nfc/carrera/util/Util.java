package com.huawei.nfc.carrera.util;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.nfc.carrera.constant.Constant;
import com.huawei.nfc.carrera.storage.sp.NFCPreferences;
import com.huawei.wallet.utils.crypto.AES;
import com.huawei.wallet.utils.device.PhoneDeviceUtil;

public class Util {
    public static final String CHAOS_UUID = "chaos_uuid";
    public static final String SECTION_1 = "5c";
    public static final String SECTION_4 = "58";

    public static boolean isNull(Object obj) {
        if (obj == null) {
            return true;
        }
        return false;
    }

    public static boolean isNullorEmpty(String str) {
        if (str == null || "".equals(str)) {
            return true;
        }
        return false;
    }

    public static String aesDecryptString(String str, Context context) {
        return getStringDecryptAES(str, getUUIDky(context));
    }

    public static String getStringEncryptAES(String str, String str2) {
        String aESKey = getAESKey(str2);
        if (!TextUtils.isEmpty(aESKey) && aESKey.length() == 16 && !TextUtils.isEmpty(str)) {
            return AES.m28502a(str, aESKey);
        }
        LogX.e("aesKey is illeagal", false);
        return null;
    }

    public static String getStringDecryptAES(String str, String str2) {
        String aESKey = getAESKey(str2);
        if (!TextUtils.isEmpty(aESKey) && aESKey.length() == 16 && !TextUtils.isEmpty(str)) {
            return AES.m28507b(str, aESKey);
        }
        LogX.e("aesKey is illeagal", false);
        return null;
    }

    public static String aesEncryptString(String str, Context context) {
        return getStringEncryptAES(str, getUUIDky(context));
    }

    public static String getAESKey(String str) {
        if (!isNullorEmpty(str) && str.length() >= 16) {
            return str.substring(0, 16);
        }
        LogX.e("key is illeagal", false);
        return str;
    }

    public static String getUUIDky(Context context) {
        String string = NFCPreferences.getInstance(context).getString(CHAOS_UUID, null);
        StringBuilder stringBuilder = new StringBuilder();
        if (TextUtils.isEmpty(string)) {
            string = recycleLeftMoveBit(PhoneDeviceUtil.m28520a().substring(0, 8), 3);
            NFCPreferences.getInstance(context).putString(CHAOS_UUID, string);
        }
        stringBuilder.append(recycleLeftMoveBit(string, 5)).append(recycleLeftMoveBit(SECTION_1, 7)).append(recycleLeftMoveBit(FusionField.SECTION_2, 6)).append(recycleLeftMoveBit(Constant.SECTION_3, 5)).append(recycleLeftMoveBit(SECTION_4, 4));
        return stringBuilder.toString();
    }

    public static String recycleLeftMoveBit(String str, int i) {
        if (str == null || i >= 8) {
            return str;
        }
        byte[] a = AES.m28505a(str);
        if (a == null) {
            return str;
        }
        int length = a.length;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = (byte) (((a[i2] & 255) << i) | ((a[i2] & 255) >>> (8 - i)));
        }
        return AES.m28504a(bArr);
    }
}
