package com.tencent.open;

import android.os.Build.VERSION;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import com.tencent.open.p541a.C6367n;

/* compiled from: ProGuard */
class C6420k extends WebChromeClient {
    final /* synthetic */ C6370j f22285a;

    C6420k(C6370j c6370j) {
        this.f22285a = c6370j;
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (consoleMessage == null) {
            return false;
        }
        C6367n.m29110c("WebConsole", consoleMessage.message() + " -- From  111 line " + consoleMessage.lineNumber() + " of " + consoleMessage.sourceId());
        if (VERSION.SDK_INT > 7) {
            this.f22285a.mo5333a(consoleMessage == null ? "" : consoleMessage.message());
        }
        return true;
    }

    public void onConsoleMessage(String str, int i, String str2) {
        C6367n.m29110c("WebConsole", str + " -- From 222 line " + i + " of " + str2);
        if (VERSION.SDK_INT == 7) {
            this.f22285a.mo5333a(str);
        }
    }
}
