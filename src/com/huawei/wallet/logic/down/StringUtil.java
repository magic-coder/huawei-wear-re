package com.huawei.wallet.logic.down;

import android.text.TextUtils;

public class StringUtil {
    public static boolean m28046a(CharSequence charSequence, boolean z) {
        if (TextUtils.isEmpty(charSequence)) {
            return true;
        }
        if (z && TextUtils.isEmpty(charSequence.toString().trim())) {
            return true;
        }
        return false;
    }
}
