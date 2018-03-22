package com.huawei.up.p517a;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.huawei.common.login.IHwCloudLoginCallback;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.login.ui.login.a;
import com.huawei.login.ui.login.util.C5433c;
import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* compiled from: UpApi */
class C6111d implements IHwCloudLoginCallback {
    final /* synthetic */ C6108a f21122a;

    C6111d(C6108a c6108a) {
        this.f21122a = c6108a;
    }

    public void onComplete(Bundle bundle) {
        if (bundle != null) {
            Object string = bundle.getString("access_token");
            C2538c.c("UpApi", new Object[]{"HuaweiCloudLogin.stToAt onComplete success at:" + string});
            if (TextUtils.isEmpty(string)) {
                int i = bundle.getInt("resultCode");
                C2538c.c("UpApi", new Object[]{"HuaweiCloudLogin.stToAt errorcode:" + i});
                if (1002 == i || 10002 == i) {
                    a.a(BaseApplication.b()).h();
                }
                com.huawei.hwdataaccessmodel.sharedpreference.a.a(BaseApplication.b(), String.valueOf(20007), "current_token_is_timeout", "true", new com.huawei.hwdataaccessmodel.a.c());
                com.huawei.hwdataaccessmodel.sharedpreference.a.a(BaseApplication.b(), String.valueOf(20007), "migrate_migrate_over", "false", new com.huawei.hwdataaccessmodel.a.c(0));
                return;
            }
            String str = "";
            try {
                str = URLDecoder.decode(string, GameManager.DEFAULT_CHARSET);
            } catch (UnsupportedEncodingException e) {
                C2538c.c("UpApi", new Object[]{"UnsupportedEncodingException: " + e.getMessage()});
            }
            C5433c.m26039a(this.f21122a.f21116a).m26053c(str, null);
            C2538c.c("UpApi", new Object[]{"HuaweiCloudLogin.stToAt onComplete success "});
            if (a.a(this.f21122a.f21116a) != null) {
                a.a(this.f21122a.f21116a).a(str, null);
                Intent intent = new Intent();
                intent.setAction("com.huawei.plugin.account.login.st.to.at");
                if (LocalBroadcastManager.getInstance(this.f21122a.f21116a) != null) {
                    LocalBroadcastManager.getInstance(this.f21122a.f21116a).sendBroadcast(intent);
                }
                this.f21122a.f21116a.sendBroadcast(intent, com.huawei.hwcommonmodel.b.c.a);
            }
        }
    }
}
