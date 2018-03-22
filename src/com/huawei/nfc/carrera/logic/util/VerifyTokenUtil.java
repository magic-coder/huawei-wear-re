package com.huawei.nfc.carrera.logic.util;

import android.content.Context;
import com.huawei.nfc.carrera.storage.sp.NFCPreferences;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.nfc.carrera.util.Util;

public class VerifyTokenUtil {
    public static final String SHAREPREFERENCE_KEY_TAG_CITIC_VERIFY_TOKEN = "citic_encrypt_verify_token";
    public static final String SHAREPREFERENCE_KEY_TAG_CMB_VERIFY_TOKEN = "cmb_encrypt_verify_token";

    public static String getVerifyTokenString(Context context, String str) {
        String string = NFCPreferences.getInstance(context).getString(str, null);
        if (StringUtil.isEmpty(string, true)) {
            return null;
        }
        return Util.aesDecryptString(string, context);
    }

    public static void putVerifyTokenString(String str, Context context, String str2) {
        if (StringUtil.isEmpty(str, true)) {
            LogX.d("putVerifyTokenString, but verifytoken is empty.");
            return;
        }
        String aesEncryptString = Util.aesEncryptString(str, context);
        if (!StringUtil.isEmpty(aesEncryptString, true)) {
            NFCPreferences.getInstance(context).putString(str2, aesEncryptString);
        }
    }
}
