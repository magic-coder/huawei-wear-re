package com.huawei.ui.main.stories.messagecenter.interactors;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.pushagent.PushReceiver;
import com.huawei.pluginmessagecenter.a.g;
import com.huawei.ui.main.stories.messagecenter.p182a.C2411a;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;

public class ADPushReceiver extends PushReceiver {
    public void onPushMsg(Context context, byte[] bArr, String str) {
        g.a("ADPushReceiver", "onPushMsg start");
        try {
            C2411a c2411a = (C2411a) new Gson().fromJson(new String(bArr, GameManager.DEFAULT_CHARSET), C2411a.class);
            g.a("ADPushReceiver", "onPushMsg | content of ADPushBean ad is: " + c2411a.toString());
            C2418a.m12156a(context).m12161a(c2411a);
        } catch (UnsupportedEncodingException e) {
            g.b("ADPushReceiver", "onPushMsg error catch UnsupportedEncodingException | " + e.getMessage());
        } catch (JsonSyntaxException e2) {
            g.b("ADPushReceiver", "onPushMsg error catch JsonSyntaxException | " + e2.getMessage());
        }
        g.a("ADPushReceiver", "onPushMsg end");
    }
}
