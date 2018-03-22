package com.huawei.ui.main.stories.account.interactor;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.huawei.hwcommonmodel.d.a;
import com.huawei.p190v.C2538c;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelmsg.SendAuth.Req;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

public class WeChat {
    public static final String ACTION = WeChat.class.getName();
    public static final String HEALTH_APP_ID = "LwJsQ2pE01kvbgL7poYGM+WPzMnLvnvLbv9x3Q==";
    public static final String HEALTH_PACKAGE_NAME = "com.huawei.health";
    public static final String RESULT_ACCESS_TOKEN = "RESULT_ACCESS_TOKEN";
    public static final String SECRET_DATA = "StPeLgPIv20i/MS+1DCTz9WYr+UBiB45+4Rg==";
    private static final String TAG = "WXLoginManager";
    public static final String WEAR_APP_ID = "wx3d91f74f61accef0";
    private String mAppId;
    private C2331j mAuthorizeHuawei = null;
    private Activity mContext = null;
    private final boolean mDebug = false;
    private IWXAPI mWXApi;
    private BroadcastReceiver receiver = new C2368s(this);

    public WeChat(Activity activity, C2331j c2331j) {
        if (activity != null) {
            this.mContext = activity;
            a.a(this.mContext.getApplicationContext(), this.receiver, new IntentFilter(ACTION));
            this.mAuthorizeHuawei = c2331j;
            this.mAppId = WEAR_APP_ID;
            this.mWXApi = WXAPIFactory.createWXAPI(this.mContext, this.mAppId, false);
            if (this.mWXApi != null) {
                this.mWXApi.registerApp(this.mAppId);
                if (this.mAuthorizeHuawei != null) {
                    this.mAuthorizeHuawei.mo2655a(true);
                }
            } else if (this.mAuthorizeHuawei != null) {
                this.mAuthorizeHuawei.mo2655a(false);
            }
        }
    }

    public void login() {
        if (this.mWXApi != null && !TextUtils.isEmpty(this.mAppId)) {
            BaseReq req = new Req();
            req.scope = "snsapi_userinfo,snsapi_friend,snsapi_message";
            req.state = "weixin";
            this.mWXApi.sendReq(req);
        }
    }

    public void logout() {
        if (this.mWXApi != null) {
            this.mWXApi.unregisterApp();
        }
        if (this.mContext != null && this.receiver != null) {
            a.a(this.mContext.getApplicationContext(), this.receiver);
            this.receiver = null;
        }
    }

    public void release() {
        this.mAuthorizeHuawei = null;
        if (this.mContext != null && this.receiver != null) {
            a.a(this.mContext.getApplicationContext(), this.receiver);
            this.receiver = null;
        }
    }

    public boolean isWXAppInstalled() {
        if (this.mWXApi != null) {
            return this.mWXApi.isWXAppInstalled();
        }
        C2538c.m12680e(TAG, "isWXAppInstalled() mWXApi=null");
        return true;
    }
}
