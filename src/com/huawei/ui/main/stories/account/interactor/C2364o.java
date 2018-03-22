package com.huawei.ui.main.stories.account.interactor;

import android.app.Activity;
import android.content.Intent;
import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.auth.sso.SsoHandler;

/* compiled from: Sinaweibo */
public class C2364o {
    private static final String f8545a = C2364o.class.getName();
    private Activity f8546b = null;
    private C2331j f8547c = null;
    private AuthInfo f8548d = null;
    private SsoHandler f8549e = null;
    private WeiboAuthListener f8550f = null;
    private C2367r f8551g = null;
    private Oauth2AccessToken f8552h = null;

    public C2364o(Activity activity, C2331j c2331j) {
        if (activity != null) {
            this.f8546b = activity;
            String packageName = this.f8546b.getPackageName();
            this.f8547c = c2331j;
            if (WeChat.HEALTH_PACKAGE_NAME.equals(packageName)) {
                this.f8548d = new AuthInfo(activity, "13750428", "https://api.weibo.com/oauth2/default.html", "");
            } else {
                this.f8548d = new AuthInfo(activity, "2319635419", "https://api.weibo.com/oauth2/default.html", "");
            }
            this.f8549e = new SsoHandler(activity, this.f8548d);
            this.f8550f = new C2366q();
            this.f8551g = new C2367r();
            C2538c.m12674b(f8545a, "Sinaweibo() mWeiboAuth=" + this.f8548d);
            if (this.f8547c != null) {
                this.f8547c.mo2655a(true);
            }
        }
    }

    public void m11980a() {
        C2538c.m12677c(f8545a, "login() enter.");
        if (this.f8549e == null || this.f8550f == null) {
            C2538c.m12680e(f8545a, "login() error! mSsoHandler=" + this.f8549e + ", mAuthListener=" + this.f8550f);
        } else {
            C2538c.m12677c(f8545a, "login() authorize()  start.");
            this.f8549e.authorize(this.f8550f);
            C2538c.m12677c(f8545a, "login() authorize()  end.");
        }
        C2538c.m12677c(f8545a, "login() leave.");
    }

    public boolean m11982a(Activity activity, String str) {
        return true;
    }

    public void m11981a(int i, int i2, Intent intent) {
        C2538c.m12677c(f8545a, "onActivityResult()  enter");
        if (this.f8549e != null) {
            C2538c.m12677c(f8545a, "onActivityResult()->mSsoHandler.authorizeCallBack()");
            this.f8549e.authorizeCallBack(i, i2, intent);
            return;
        }
        C2538c.m12680e(f8545a, "onActivityResult() error mSsoHandler=null");
    }
}
