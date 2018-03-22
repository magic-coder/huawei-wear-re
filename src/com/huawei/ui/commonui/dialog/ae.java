package com.huawei.ui.commonui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import com.huawei.hwcommonmodel.d.d;
import com.huawei.nfc.carrera.ui.dialog.PayManagerSettingSwitchDialog;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.webview.WebViewActivity;

import java.util.Locale;

/* compiled from: HuaweiMobileServiceSettingDialog */
public class ae extends Dialog {
    public static final String f20633a = ae.class.getSimpleName();

    public ae(Context context, int i) {
        super(context, i);
    }

    private static void m27494b(Context context, int i) {
        String str = "http://health.vmall.com/help/mobilephone-note/zh-CN/index.html";
        C2538c.b(f20633a, new Object[]{"startWebViewActivity() -> URL = ", str, ", jumpModeKey = ", Integer.valueOf(i)});
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        String country = locale.getCountry();
        C2538c.c(f20633a, new Object[]{"the language code is " + language});
        C2538c.c(f20633a, new Object[]{"the country code is " + country});
        if (!d.a(context)) {
            str = str.replace("zh-CN", PayManagerSettingSwitchDialog.LOCALE_ABROAD);
        }
        Intent intent = new Intent(context, WebViewActivity.class);
        intent.putExtra("WebViewActivity.REQUEST_URL_KEY", str);
        intent.putExtra("WebViewActivity.JUMP_MODE_KEY", i);
        context.startActivity(intent);
    }
}
