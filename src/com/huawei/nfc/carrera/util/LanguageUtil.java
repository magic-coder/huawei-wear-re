package com.huawei.nfc.carrera.util;

import android.content.Context;
import android.content.res.Configuration;
import java.util.Locale;

public final class LanguageUtil {
    private LanguageUtil() {
    }

    public static boolean isLanguageZhCn(Context context) {
        if ("zh_cn".equals(getLanguage(context))) {
            return true;
        }
        return false;
    }

    public static String getLanguage(Context context) {
        Configuration configuration = context.getResources().getConfiguration();
        String language = configuration.locale.getLanguage();
        return (language + '_' + configuration.locale.getCountry()).toLowerCase(Locale.getDefault());
    }

    public static String getUrlByLanguage(Context context, String str) {
        if (true == isLanguageZhCn(context)) {
            return str + "?language=zh";
        }
        return str + "?language=en";
    }
}
