package com.huawei.wallet.utils.device;

import android.os.Build;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.unionpay.tsmservice.data.ResultCode;
import java.util.UUID;

public class PhoneDeviceUtil {
    private static String f21613a = "";
    private static String f21614b = "";
    private static String f21615c = ResultCode.FAKE_ERROR_DUPLICATE_ACTIVE;

    public static String m28520a() {
        String replace = UUID.randomUUID().toString().replace("-", "");
        if (replace.length() > 15) {
            return replace.substring(0, 16);
        }
        return SNBConstant.DEFAULT_CARD_NO.substring(15 - replace.length()) + replace;
    }

    public static String m28521b() {
        return Build.MODEL;
    }
}
