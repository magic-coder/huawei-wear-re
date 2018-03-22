package com.tencent.open;

import android.net.Uri;
import android.webkit.WebView;
import com.sina.weibo.sdk.component.GameManager;
import com.tencent.open.p541a.C6367n;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* compiled from: ProGuard */
public class C6418g {
    protected HashMap<String, C6414i> f22281a = new HashMap();

    public void m29277a(C6414i c6414i, String str) {
        this.f22281a.put(str, c6414i);
    }

    public void mo5336a(String str, String str2, List<String> list, C6419h c6419h) {
        C6367n.m29107b("openSDK_LOG.JsBridge", "getResult---objName = " + str + " methodName = " + str2);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                list.set(i, URLDecoder.decode((String) list.get(i), GameManager.DEFAULT_CHARSET));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        C6414i c6414i = (C6414i) this.f22281a.get(str);
        if (c6414i != null) {
            C6367n.m29107b("openSDK_LOG.JsBridge", "call----");
            c6414i.m29270a(str2, list, c6419h);
            return;
        }
        C6367n.m29107b("openSDK_LOG.JsBridge", "not call----objName NOT FIND");
        if (c6419h != null) {
            c6419h.mo5338a();
        }
    }

    public boolean mo5337a(WebView webView, String str) {
        C6367n.m29107b("openSDK_LOG.JsBridge", "-->canHandleUrl---url = " + str);
        if (str == null || !Uri.parse(str).getScheme().equals("jsbridge")) {
            return false;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList((str + "/#").split("/")));
        if (arrayList.size() < 6) {
            return false;
        }
        String str2 = (String) arrayList.get(2);
        String str3 = (String) arrayList.get(3);
        List subList = arrayList.subList(4, arrayList.size() - 1);
        C6419h c6419h = new C6419h(webView, 4, str);
        webView.getUrl();
        mo5336a(str2, str3, subList, c6419h);
        return true;
    }
}
