package com.huawei.ui.main.stories.account.interactor;

import android.os.Bundle;
import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.exception.WeiboException;

/* compiled from: Sinaweibo */
class C2366q implements WeiboAuthListener {
    final /* synthetic */ C2364o f8553a;

    private C2366q(C2364o c2364o) {
        this.f8553a = c2364o;
    }

    public void onComplete(Bundle bundle) {
        this.f8553a.f8552h = Oauth2AccessToken.parseAccessToken(bundle);
        if (this.f8553a.f8552h != null) {
            String uid = this.f8553a.f8552h.getUid();
            String token = this.f8553a.f8552h.getToken();
            String str = "sina";
            this.f8553a.m11982a(this.f8553a.f8546b, token);
            if (this.f8553a.f8547c != null) {
                C2538c.m12677c(C2364o.f8545a, "onComplete()->mAuthorizeCallback.loginCallback()  start");
                this.f8553a.f8547c.mo2654a(0, token, uid, "sina", -1);
                C2538c.m12677c(C2364o.f8545a, "onComplete()->mAuthorizeCallback.loginCallback()  end");
            }
        }
    }

    public void onCancel() {
        C2538c.m12677c(C2364o.f8545a, "onCancel");
        if (this.f8553a.f8547c != null) {
            C2538c.m12677c(C2364o.f8545a, "onCancel()->mAuthorizeCallback.loginCallback()  start");
            this.f8553a.f8547c.mo2654a(2, null, null, null, -1);
            C2538c.m12677c(C2364o.f8545a, "onCancel()->mAuthorizeCallback.loginCallback()  end");
        }
    }

    public void onWeiboException(WeiboException weiboException) {
        C2538c.m12680e(C2364o.f8545a, "onWeiboException()=" + weiboException);
        this.f8553a.f8547c.mo2654a(1, null, null, null, -1);
    }
}
