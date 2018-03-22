package com.huawei.ui.main.stories.about.p179a;

import android.content.Context;
import android.content.res.Configuration;
import com.huawei.nfc.carrera.ui.dialog.PayManagerSettingSwitchDialog;
import com.huawei.p190v.C2538c;

/* compiled from: ServiceTermsInteractor */
public class C2289k {
    private static final String[] f8297a = new String[]{"az-AZ", "eu-ES", "bs-BA", "bg-BG", "my-MM", "ca-ES", "hr-HR", "cs-CZ", "da-DK", "nl-NL", "en-GB", "et-EE", "fa-TJ", "fi-FI", "fr-FR", "gl-ES", "ka-GE", "de-DE", "el-GR", "hi-IN", "zh-HK", "hu-HU", "id-ID", "it-IT", "ja-JP", "km-KH", "ko-KR", "lv-LV", "lt-LT", "mk-MK", "ms-MY", "nb-NO", "pl-PL", "pt-BR", "pt-PT", "ro-RO", "ru-RU", "sr-RS", "si-LK", "sk-SK", "sl-SI", "es-ES", "es-US", "sv-SE", "zh-TW", "th-TH", "bo-CN", "tr-TR", "uk-UA", "uz-UZ", "vi-VN", "zh-CN", PayManagerSettingSwitchDialog.LOCALE_ABROAD};

    public static String m11764a(Context context) {
        int i;
        C2538c.m12674b("ServiceTermsInteractor", "===www===getFormatUrl");
        Configuration configuration = context.getResources().getConfiguration();
        String str = configuration.locale.getLanguage() + "-" + configuration.locale.getCountry();
        C2538c.m12674b("ServiceTermsInteractor", "===www=== uintStr before" + r4 + "-" + r5);
        for (String equalsIgnoreCase : f8297a) {
            if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                i = 1;
                break;
            }
        }
        i = 0;
        String str2 = i == 0 ? (str.startsWith("ar") || str.startsWith("ar-")) ? "ar-AE" : (str.startsWith("iw") || str.startsWith("iw-")) ? "he-IL" : (str.startsWith("ur") || str.startsWith("ur-")) ? "ur-IN" : PayManagerSettingSwitchDialog.LOCALE_ABROAD : str;
        C2538c.m12674b("ServiceTermsInteractor", "getFormatUrl : language = " + r4 + ", country = " + r5 + ",url = " + String.format("https://health.vmall.com/help/userimprovement/index.jsp?lang=%s", new Object[]{str2}));
        return String.format("https://health.vmall.com/help/userimprovement/index.jsp?lang=%s", new Object[]{str2});
    }
}
