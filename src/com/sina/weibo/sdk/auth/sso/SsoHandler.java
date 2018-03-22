package com.sina.weibo.sdk.auth.sso;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.sina.p526a.C6190a;
import com.sina.p526a.C6191b;
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.WeiboAppManager.WeiboInfo;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.cmd.WbAppActivator;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.exception.WeiboDialogException;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.register.mobile.MobileRegisterActivity;
import com.sina.weibo.sdk.statistic.WBAgent;
import com.sina.weibo.sdk.utils.AidTask;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.SecurityHelper;
import com.sina.weibo.sdk.utils.Utility;
import java.util.HashMap;
import java.util.Map;

public class SsoHandler {
    public static final String AUTH_FAILED_MSG = "auth failed!!!!!";
    public static final String AUTH_FAILED_NOT_INSTALL_MSG = "not install weibo client!!!!!";
    private static final String DEFAULT_WEIBO_REMOTE_SSO_SERVICE_NAME = "com.sina.weibo.remotessoservice";
    private static final int REQUEST_CODE_MOBILE_REGISTER = 40000;
    private static final int REQUEST_CODE_SSO_AUTH = 32973;
    private static final String TAG = "Weibo_SSO_login";
    private Activity mAuthActivity;
    private AuthInfo mAuthInfo;
    private WeiboAuthListener mAuthListener;
    private ServiceConnection mConnection = new C62031();
    private int mSSOAuthRequestCode;
    private WebAuthHandler mWebAuthHandler;
    private WeiboInfo mWeiboInfo;

    class C62031 implements ServiceConnection {
        C62031() {
        }

        public void onServiceDisconnected(ComponentName componentName) {
            SsoHandler.this.mWebAuthHandler.anthorize(SsoHandler.this.mAuthListener);
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C6190a a = C6191b.m28657a(iBinder);
            try {
                String a2 = a.mo5213a();
                String b = a.mo5214b();
                SsoHandler.this.mAuthActivity.getApplicationContext().unbindService(SsoHandler.this.mConnection);
                if (!SsoHandler.this.startSingleSignOn(a2, b)) {
                    SsoHandler.this.mWebAuthHandler.anthorize(SsoHandler.this.mAuthListener);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    enum AuthType {
        ALL,
        SsoOnly,
        WebOnly
    }

    public SsoHandler(Activity activity, AuthInfo authInfo) {
        this.mAuthActivity = activity;
        this.mAuthInfo = authInfo;
        this.mWebAuthHandler = new WebAuthHandler(activity, authInfo);
        this.mWeiboInfo = WeiboAppManager.getInstance(activity).getWeiboInfo();
        AidTask.getInstance(this.mAuthActivity).aidTaskInit(authInfo.getAppKey());
    }

    public void authorize(WeiboAuthListener weiboAuthListener) {
        authorize(REQUEST_CODE_SSO_AUTH, weiboAuthListener, AuthType.ALL);
        WbAppActivator.getInstance(this.mAuthActivity, this.mAuthInfo.getAppKey()).activateApp();
    }

    public void authorizeClientSso(WeiboAuthListener weiboAuthListener) {
        authorize(REQUEST_CODE_SSO_AUTH, weiboAuthListener, AuthType.SsoOnly);
        WbAppActivator.getInstance(this.mAuthActivity, this.mAuthInfo.getAppKey()).activateApp();
    }

    public void authorizeWeb(WeiboAuthListener weiboAuthListener) {
        authorize(REQUEST_CODE_SSO_AUTH, weiboAuthListener, AuthType.WebOnly);
        WbAppActivator.getInstance(this.mAuthActivity, this.mAuthInfo.getAppKey()).activateApp();
    }

    private void authorize(int i, WeiboAuthListener weiboAuthListener, AuthType authType) {
        this.mSSOAuthRequestCode = i;
        this.mAuthListener = weiboAuthListener;
        Object obj = null;
        if (authType == AuthType.SsoOnly) {
            obj = 1;
        }
        if (authType == AuthType.WebOnly) {
            if (weiboAuthListener != null) {
                this.mWebAuthHandler.anthorize(weiboAuthListener);
            }
        } else if (!bindRemoteSSOService(this.mAuthActivity.getApplicationContext())) {
            if (obj == null) {
                this.mWebAuthHandler.anthorize(this.mAuthListener);
            } else if (this.mAuthListener != null) {
                this.mAuthListener.onWeiboException(new WeiboException(AUTH_FAILED_NOT_INSTALL_MSG));
            }
        }
    }

    public void authorizeCallBack(int i, int i2, Intent intent) {
        LogUtil.m28661d(TAG, "requestCode: " + i + ", resultCode: " + i2 + ", data: " + intent);
        String stringExtra;
        Bundle extras;
        Oauth2AccessToken parseAccessToken;
        if (i == this.mSSOAuthRequestCode) {
            if (i2 == -1) {
                if (SecurityHelper.checkResponseAppLegal(this.mAuthActivity, this.mWeiboInfo, intent)) {
                    stringExtra = intent.getStringExtra(HwAccountConstants.EXTRA_OPLOG_ERROR);
                    if (stringExtra == null) {
                        stringExtra = intent.getStringExtra("error_type");
                    }
                    if (stringExtra == null) {
                        extras = intent.getExtras();
                        parseAccessToken = Oauth2AccessToken.parseAccessToken(extras);
                        if (parseAccessToken == null || !parseAccessToken.isSessionValid()) {
                            LogUtil.m28661d(TAG, "Failed to receive access token by SSO");
                            this.mWebAuthHandler.anthorize(this.mAuthListener);
                            return;
                        }
                        LogUtil.m28661d(TAG, "Login Success! " + parseAccessToken.toString());
                        this.mAuthListener.onComplete(extras);
                    } else if (stringExtra.equals("access_denied") || stringExtra.equals("OAuthAccessDeniedException")) {
                        LogUtil.m28661d(TAG, "Login canceled by user.");
                        this.mAuthListener.onCancel();
                    } else {
                        String stringExtra2 = intent.getStringExtra("error_description");
                        if (stringExtra2 != null) {
                            stringExtra = new StringBuilder(String.valueOf(stringExtra)).append(":").append(stringExtra2).toString();
                        }
                        LogUtil.m28661d(TAG, "Login failed: " + stringExtra);
                        this.mAuthListener.onWeiboException(new WeiboDialogException(stringExtra, i2, stringExtra2));
                    }
                }
            } else if (i2 != 0) {
            } else {
                if (intent != null) {
                    LogUtil.m28661d(TAG, "Login failed: " + intent.getStringExtra(HwAccountConstants.EXTRA_OPLOG_ERROR));
                    this.mAuthListener.onWeiboException(new WeiboDialogException(intent.getStringExtra(HwAccountConstants.EXTRA_OPLOG_ERROR), intent.getIntExtra("error_code", -1), intent.getStringExtra("failing_url")));
                    return;
                }
                LogUtil.m28661d(TAG, "Login canceled by user.");
                this.mAuthListener.onCancel();
            }
        } else if (i != 40000) {
        } else {
            if (i2 == -1) {
                extras = intent.getExtras();
                parseAccessToken = Oauth2AccessToken.parseAccessToken(extras);
                if (parseAccessToken != null && parseAccessToken.isSessionValid()) {
                    LogUtil.m28661d(TAG, "Login Success! " + parseAccessToken.toString());
                    this.mAuthListener.onComplete(extras);
                }
            } else if (i2 != 0) {
            } else {
                if (intent != null) {
                    LogUtil.m28661d(TAG, "Login failed: " + intent.getStringExtra(HwAccountConstants.EXTRA_OPLOG_ERROR));
                    stringExtra = intent.getStringExtra(HwAccountConstants.EXTRA_OPLOG_ERROR);
                    if (stringExtra == null) {
                        stringExtra = intent.getStringExtra("error_type");
                    }
                    if (stringExtra != null) {
                        this.mAuthListener.onWeiboException(new WeiboDialogException(intent.getStringExtra(HwAccountConstants.EXTRA_OPLOG_ERROR), intent.getIntExtra("error_code", -1), intent.getStringExtra("error_description")));
                        return;
                    }
                    return;
                }
                LogUtil.m28661d(TAG, "Login canceled by user.");
                this.mAuthListener.onCancel();
            }
        }
    }

    public static ComponentName isServiceExisted(Context context, String str) {
        for (RunningServiceInfo runningServiceInfo : ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE)) {
            ComponentName componentName = runningServiceInfo.service;
            if (componentName.getPackageName().equals(str) && componentName.getClassName().equals(new StringBuilder(String.valueOf(str)).append(".business.RemoteSSOService").toString())) {
                return componentName;
            }
        }
        return null;
    }

    private boolean bindRemoteSSOService(Context context) {
        if (!isWeiboAppInstalled()) {
            return false;
        }
        String packageName = this.mWeiboInfo.getPackageName();
        Intent intent = new Intent(DEFAULT_WEIBO_REMOTE_SSO_SERVICE_NAME);
        intent.setPackage(packageName);
        return context.bindService(intent, this.mConnection, 1);
    }

    private boolean startSingleSignOn(String str, String str2) {
        boolean z = true;
        Intent intent = new Intent();
        intent.setClassName(str, str2);
        intent.putExtras(this.mWebAuthHandler.getAuthInfo().getAuthBundle());
        intent.putExtra(WBConstants.COMMAND_TYPE_KEY, 3);
        String valueOf = String.valueOf(System.currentTimeMillis());
        intent.putExtra(WBConstants.TRAN, valueOf);
        addEventLog(this.mAuthActivity, valueOf, WBConstants.ACTION_LOG_TYPE_SSO);
        intent.putExtra("aid", Utility.getAid(this.mAuthActivity, this.mAuthInfo.getAppKey()));
        if (!SecurityHelper.validateAppSignatureForIntent(this.mAuthActivity, intent)) {
            return false;
        }
        Object aid = Utility.getAid(this.mAuthActivity, this.mAuthInfo.getAppKey());
        if (!TextUtils.isEmpty(aid)) {
            intent.putExtra("aid", aid);
        }
        try {
            this.mAuthActivity.startActivityForResult(intent, this.mSSOAuthRequestCode);
        } catch (ActivityNotFoundException e) {
            z = false;
        }
        return z;
    }

    public boolean isWeiboAppInstalled() {
        return this.mWeiboInfo != null && this.mWeiboInfo.isLegal();
    }

    public void registerOrLoginByMobile(String str, WeiboAuthListener weiboAuthListener) {
        this.mAuthListener = weiboAuthListener;
        Intent intent = new Intent(this.mAuthActivity, MobileRegisterActivity.class);
        Bundle authBundle = this.mAuthInfo.getAuthBundle();
        authBundle.putString(MobileRegisterActivity.REGISTER_TITLE, str);
        intent.putExtras(authBundle);
        this.mAuthActivity.startActivityForResult(intent, 40000);
    }

    public void addEventLog(Context context, String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put(WBConstants.ACTION_START_TIME, str);
        try {
            WBAgent.onEvent(context, str2, hashMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
