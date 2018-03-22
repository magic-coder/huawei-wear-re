package com.tencent.open.web.security;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.sina.weibo.sdk.component.GameManager;
import com.tencent.open.C6414i;
import com.tencent.open.C6418g;
import com.tencent.open.C6419h;
import com.tencent.open.p541a.C6367n;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: ProGuard */
public class C6423c extends C6418g {
    public void mo5336a(String str, String str2, List<String> list, C6419h c6419h) {
        C6367n.m29107b("openSDK_LOG.SecureJs", "-->getResult, objectName: " + str + " | methodName: " + str2);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                list.set(i, URLDecoder.decode((String) list.get(i), GameManager.DEFAULT_CHARSET));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        C6414i c6414i = (C6414i) this.a.get(str);
        if (c6414i != null) {
            C6367n.m29107b("openSDK_LOG.SecureJs", "-->handler != null");
            c6414i.m29270a(str2, list, c6419h);
            return;
        }
        C6367n.m29107b("openSDK_LOG.SecureJs", "-->handler == null");
        if (c6419h != null) {
            c6419h.mo5338a();
        }
    }

    public boolean mo5337a(WebView webView, String str) {
        C6367n.m29107b("openSDK_LOG.SecureJs", "-->canHandleUrl---url = " + str);
        if (str == null) {
            return false;
        }
        if (!Uri.parse(str).getScheme().equals("jsbridge")) {
            return false;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList((str + "/#").split("/")));
        if (arrayList.size() < 7) {
            return false;
        }
        String str2 = (String) arrayList.get(2);
        String str3 = (String) arrayList.get(3);
        String str4 = (String) arrayList.get(4);
        String str5 = (String) arrayList.get(5);
        C6367n.m29107b("openSDK_LOG.SecureJs", "-->canHandleUrl, objectName: " + str2 + " | methodName: " + str3 + " | snStr: " + str4);
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            return false;
        }
        try {
            mo5336a(str2, str3, arrayList.subList(6, arrayList.size() - 1), new C6424d(webView, Long.parseLong(str4), str, str5));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
