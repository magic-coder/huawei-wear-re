package com.alipay.sdk.auth;

import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;

final class C3160a extends WebChromeClient {
    final /* synthetic */ AuthActivity f10560a;

    private C3160a(AuthActivity authActivity) {
        this.f10560a = authActivity;
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String message = consoleMessage.message();
        if (TextUtils.isEmpty(message)) {
            return super.onConsoleMessage(consoleMessage);
        }
        Object obj = null;
        if (message.startsWith("h5container.message: ")) {
            obj = message.replaceFirst("h5container.message: ", "");
        }
        if (TextUtils.isEmpty(obj)) {
            return super.onConsoleMessage(consoleMessage);
        }
        AuthActivity.m14001b(this.f10560a, obj);
        return super.onConsoleMessage(consoleMessage);
    }
}
