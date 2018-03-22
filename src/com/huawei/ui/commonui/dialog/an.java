package com.huawei.ui.commonui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.webview.WebViewActivity;

/* compiled from: SecurityManagerSettingSwitchDialog */
public class an extends Dialog {
    public static final String f20654a = an.class.getSimpleName();

    public an(Context context, int i) {
        super(context, i);
    }

    private static void m27520b(Context context, String str, int i) {
        C2538c.b(f20654a, new Object[]{"startWebViewActivity() -> url = ", str, ", jumpModeKey = ", Integer.valueOf(i)});
        Intent intent = new Intent(context, WebViewActivity.class);
        intent.putExtra("WebViewActivity.REQUEST_URL_KEY", str);
        intent.putExtra("WebViewActivity.JUMP_MODE_KEY", i);
        context.startActivity(intent);
    }
}
