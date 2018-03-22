package com.huawei.ui.main.stories.account.interactor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.p190v.C2538c;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: WeChat */
class C2368s extends BroadcastReceiver {
    private final WeakReference<WeChat> f8555a;

    public C2368s(WeChat weChat) {
        this.f8555a = new WeakReference(weChat);
    }

    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            C2538c.m12680e("WXLoginManager", "onReceive intent null");
            return;
        }
        WeChat weChat = (WeChat) this.f8555a.get();
        if (weChat != null) {
            try {
                String stringExtra = intent.getStringExtra(WeChat.RESULT_ACCESS_TOKEN);
                if (stringExtra == null) {
                    C2538c.m12677c("WXLoginManager", "onReceive result_access_token =null ");
                    if (weChat.mAuthorizeHuawei != null) {
                        weChat.mAuthorizeHuawei.mo2654a(2, null, null, null, -1);
                        return;
                    }
                    return;
                }
                JSONObject jSONObject = new JSONObject(stringExtra);
                Object string = jSONObject.getString("access_token");
                Object string2 = jSONObject.getString("openid");
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && weChat.mAuthorizeHuawei != null) {
                    weChat.mAuthorizeHuawei.mo2654a(0, string, string2, "", -1);
                }
            } catch (JSONException e) {
                C2538c.m12680e("WXLoginManager", "onReceive() JSONException=" + e.getMessage());
                if (weChat.mAuthorizeHuawei != null) {
                    weChat.mAuthorizeHuawei.mo2654a(1, null, null, null, -1);
                }
            } catch (Exception e2) {
                C2538c.m12680e("WXLoginManager", "onReceive() Exception=" + e2.getMessage());
                if (weChat.mAuthorizeHuawei != null) {
                    weChat.mAuthorizeHuawei.mo2654a(1, null, null, null, -1);
                }
            }
        }
    }
}
