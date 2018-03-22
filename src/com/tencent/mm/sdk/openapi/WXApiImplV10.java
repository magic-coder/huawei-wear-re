package com.tencent.mm.sdk.openapi;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.mm.sdk.constants.ConstantsAPI;
import com.tencent.mm.sdk.constants.ConstantsAPI.Token;
import com.tencent.mm.sdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelbiz.AddCardToWXCardPackage;
import com.tencent.mm.sdk.modelmsg.GetMessageFromWX.Req;
import com.tencent.mm.sdk.modelmsg.LaunchFromWX;
import com.tencent.mm.sdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX;
import com.tencent.mm.sdk.modelmsg.ShowMessageFromWX;
import com.tencent.mm.sdk.modelpay.PayResp;
import com.tencent.mm.sdk.p537a.C6340a;
import com.tencent.mm.sdk.p537a.C6340a.C6336a;
import com.tencent.mm.sdk.p537a.p538a.C6338a;
import com.tencent.mm.sdk.p537a.p538a.C6338a.C6337a;
import com.tencent.mm.sdk.p537a.p538a.C6339b;
import com.tencent.mm.sdk.p539b.C6342a;
import com.tencent.wxop.stat.C6504a;
import com.tencent.wxop.stat.C6544v;
import com.tencent.wxop.stat.C6545w;
import com.tencent.wxop.stat.C6546x;

final class WXApiImplV10 implements IWXAPI {
    private static final String TAG = "MicroMsg.SDK.WXApiImplV10";
    private static ActivityLifecycleCb activityCb = null;
    private static String wxappPayEntryClassname = null;
    private String appId;
    private boolean checkSignature = false;
    private Context context;
    private boolean detached = false;

    final class ActivityLifecycleCb implements ActivityLifecycleCallbacks {
        private static final int DELAYED = 800;
        private static final String TAG = "MicroMsg.SDK.WXApiImplV10.ActivityLifecycleCb";
        private Context context;
        private Handler handler;
        private boolean isForeground;
        private Runnable onPausedRunnable;
        private Runnable onResumedRunnable;

        class C63511 implements Runnable {
            C63511() {
            }

            public void run() {
                if (WXApiImplV10.activityCb != null && ActivityLifecycleCb.this.isForeground) {
                    Log.v(ActivityLifecycleCb.TAG, "WXStat trigger onBackground");
                    C6546x.m29864a(ActivityLifecycleCb.this.context, "onBackground_WX");
                    ActivityLifecycleCb.this.isForeground = false;
                }
            }
        }

        class C63522 implements Runnable {
            C63522() {
            }

            public void run() {
                if (WXApiImplV10.activityCb != null && !ActivityLifecycleCb.this.isForeground) {
                    Log.v(ActivityLifecycleCb.TAG, "WXStat trigger onForeground");
                    C6546x.m29864a(ActivityLifecycleCb.this.context, "onForeground_WX");
                    ActivityLifecycleCb.this.isForeground = true;
                }
            }
        }

        private ActivityLifecycleCb(Context context) {
            this.isForeground = false;
            this.handler = new Handler(Looper.getMainLooper());
            this.onPausedRunnable = new C63511();
            this.onResumedRunnable = new C63522();
            this.context = context;
        }

        public final void detach() {
            this.handler.removeCallbacks(this.onResumedRunnable);
            this.handler.removeCallbacks(this.onPausedRunnable);
            this.context = null;
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public final void onActivityDestroyed(Activity activity) {
        }

        public final void onActivityPaused(Activity activity) {
            Log.v(TAG, activity.getComponentName().getClassName() + "  onActivityPaused");
            this.handler.removeCallbacks(this.onResumedRunnable);
            this.handler.postDelayed(this.onPausedRunnable, 800);
        }

        public final void onActivityResumed(Activity activity) {
            Log.v(TAG, activity.getComponentName().getClassName() + "  onActivityResumed");
            this.handler.removeCallbacks(this.onPausedRunnable);
            this.handler.postDelayed(this.onResumedRunnable, 800);
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityStarted(Activity activity) {
        }

        public final void onActivityStopped(Activity activity) {
        }
    }

    WXApiImplV10(Context context, String str, boolean z) {
        C6342a.m29033d(TAG, "<init>, appId = " + str + ", checkSignature = " + z);
        this.context = context;
        this.appId = str;
        this.checkSignature = z;
    }

    private boolean checkSumConsistent(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length == 0) {
            C6342a.m29029a(TAG, "checkSumConsistent fail, invalid arguments");
            return false;
        } else if (bArr.length != bArr2.length) {
            C6342a.m29029a(TAG, "checkSumConsistent fail, length is different");
            return false;
        } else {
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] != bArr2[i]) {
                    return false;
                }
            }
            return true;
        }
    }

    private void initMta(Context context, String str) {
        String str2 = "AWXOP" + str;
        C6544v.m29821a(context, str2);
        C6544v.m29847n();
        C6544v.m29823a(C6545w.PERIOD);
        C6544v.m29844k();
        C6544v.m29828b(context, "Wechat_Sdk");
        try {
            C6546x.m29868a(context, str2, "2.0.3");
        } catch (C6504a e) {
            e.printStackTrace();
        }
    }

    private boolean sendAddCardToWX(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/addCardToWX"), null, null, new String[]{this.appId, bundle.getString("_wxapi_add_card_to_wx_card_list"), bundle.getString("_wxapi_basereq_transaction")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendJumpToBizProfileReq(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToBizProfile"), null, null, new String[]{this.appId, bundle.getString("_wxapi_jump_to_biz_profile_req_to_user_name"), bundle.getString("_wxapi_jump_to_biz_profile_req_ext_msg"), bundle.getInt("_wxapi_jump_to_biz_profile_req_scene"), bundle.getInt("_wxapi_jump_to_biz_profile_req_profile_type")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendJumpToBizWebviewReq(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToBizProfile"), null, null, new String[]{this.appId, bundle.getString("_wxapi_jump_to_biz_webview_req_to_user_name"), bundle.getString("_wxapi_jump_to_biz_webview_req_ext_msg"), bundle.getInt("_wxapi_jump_to_biz_webview_req_scene")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendPayReq(Context context, Bundle bundle) {
        if (wxappPayEntryClassname == null) {
            wxappPayEntryClassname = new MMSharedPreferences(context).getString("_wxapp_pay_entry_classname_", null);
            C6342a.m29033d(TAG, "pay, set wxappPayEntryClassname = " + wxappPayEntryClassname);
            if (wxappPayEntryClassname == null) {
                C6342a.m29029a(TAG, "pay fail, wxappPayEntryClassname is null");
                return false;
            }
        }
        C6336a c6336a = new C6336a();
        c6336a.f22076n = bundle;
        c6336a.f22073k = "com.tencent.mm";
        c6336a.f22074l = wxappPayEntryClassname;
        return C6340a.m29023a(context, c6336a);
    }

    public final void detach() {
        C6342a.m29033d(TAG, "detach");
        this.detached = true;
        if (activityCb != null && VERSION.SDK_INT >= 14) {
            if (this.context instanceof Activity) {
                ((Activity) this.context).getApplication().unregisterActivityLifecycleCallbacks(activityCb);
            } else if (this.context instanceof Service) {
                ((Service) this.context).getApplication().unregisterActivityLifecycleCallbacks(activityCb);
            }
            activityCb.detach();
        }
        this.context = null;
    }

    public final int getWXAppSupportAPI() {
        if (this.detached) {
            throw new IllegalStateException("getWXAppSupportAPI fail, WXMsgImpl has been detached");
        } else if (isWXAppInstalled()) {
            return new MMSharedPreferences(this.context).getInt("_build_info_sdk_int_", 0);
        } else {
            C6342a.m29029a(TAG, "open wx app failed, not installed or signature check failed");
            return 0;
        }
    }

    public final boolean handleIntent(Intent intent, IWXAPIEventHandler iWXAPIEventHandler) {
        if (!WXApiImplComm.isIntentFromWx(intent, Token.WX_TOKEN_VALUE_MSG)) {
            C6342a.m29032c(TAG, "handleIntent fail, intent not from weixin msg");
            return false;
        } else if (this.detached) {
            throw new IllegalStateException("handleIntent fail, WXMsgImpl has been detached");
        } else {
            String stringExtra = intent.getStringExtra(ConstantsAPI.CONTENT);
            int intExtra = intent.getIntExtra(ConstantsAPI.SDK_VERSION, 0);
            String stringExtra2 = intent.getStringExtra(ConstantsAPI.APP_PACKAGE);
            if (stringExtra2 == null || stringExtra2.length() == 0) {
                C6342a.m29029a(TAG, "invalid argument");
                return false;
            } else if (checkSumConsistent(intent.getByteArrayExtra(ConstantsAPI.CHECK_SUM), C6339b.m29022a(stringExtra, intExtra, stringExtra2))) {
                int intExtra2 = intent.getIntExtra("_wxapi_command_type", 0);
                switch (intExtra2) {
                    case 1:
                        iWXAPIEventHandler.onResp(new Resp(intent.getExtras()));
                        return true;
                    case 2:
                        iWXAPIEventHandler.onResp(new SendMessageToWX.Resp(intent.getExtras()));
                        return true;
                    case 3:
                        iWXAPIEventHandler.onReq(new Req(intent.getExtras()));
                        return true;
                    case 4:
                        iWXAPIEventHandler.onReq(new ShowMessageFromWX.Req(intent.getExtras()));
                        return true;
                    case 5:
                        iWXAPIEventHandler.onResp(new PayResp(intent.getExtras()));
                        return true;
                    case 6:
                        iWXAPIEventHandler.onReq(new LaunchFromWX.Req(intent.getExtras()));
                        return true;
                    case 9:
                        iWXAPIEventHandler.onResp(new AddCardToWXCardPackage.Resp(intent.getExtras()));
                        return true;
                    default:
                        C6342a.m29029a(TAG, "unknown cmd = " + intExtra2);
                        return false;
                }
            } else {
                C6342a.m29029a(TAG, "checksum fail");
                return false;
            }
        }
    }

    public final boolean isWXAppInstalled() {
        boolean z = false;
        if (this.detached) {
            throw new IllegalStateException("isWXAppInstalled fail, WXMsgImpl has been detached");
        }
        try {
            PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo("com.tencent.mm", 64);
            if (packageInfo != null) {
                z = WXApiImplComm.validateAppSignature(this.context, packageInfo.signatures, this.checkSignature);
            }
        } catch (NameNotFoundException e) {
        }
        return z;
    }

    public final boolean isWXAppSupportAPI() {
        if (!this.detached) {
            return getWXAppSupportAPI() >= 570490883;
        } else {
            throw new IllegalStateException("isWXAppSupportAPI fail, WXMsgImpl has been detached");
        }
    }

    public final boolean openWXApp() {
        if (this.detached) {
            throw new IllegalStateException("openWXApp fail, WXMsgImpl has been detached");
        } else if (isWXAppInstalled()) {
            try {
                this.context.startActivity(this.context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm"));
                return true;
            } catch (Exception e) {
                C6342a.m29029a(TAG, "startActivity fail, exception = " + e.getMessage());
                return false;
            }
        } else {
            C6342a.m29029a(TAG, "open wx app failed, not installed or signature check failed");
            return false;
        }
    }

    public final boolean registerApp(String str) {
        if (this.detached) {
            throw new IllegalStateException("registerApp fail, WXMsgImpl has been detached");
        } else if (WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
            if (activityCb == null && VERSION.SDK_INT >= 14) {
                if (this.context instanceof Activity) {
                    initMta(this.context, str);
                    activityCb = new ActivityLifecycleCb(this.context);
                    ((Activity) this.context).getApplication().registerActivityLifecycleCallbacks(activityCb);
                } else if (this.context instanceof Service) {
                    initMta(this.context, str);
                    activityCb = new ActivityLifecycleCb(this.context);
                    ((Service) this.context).getApplication().registerActivityLifecycleCallbacks(activityCb);
                } else {
                    C6342a.m29031b(TAG, "context is not instanceof Activity or Service, disable WXStat");
                }
            }
            C6342a.m29033d(TAG, "registerApp, appId = " + str);
            if (str != null) {
                this.appId = str;
            }
            C6342a.m29033d(TAG, "register app " + this.context.getPackageName());
            C6337a c6337a = new C6337a();
            c6337a.f22079o = "com.tencent.mm";
            c6337a.f22080p = ConstantsAPI.ACTION_HANDLE_APP_REGISTER;
            c6337a.f22077m = "weixin://registerapp?appid=" + this.appId;
            return C6338a.m29021a(this.context, c6337a);
        } else {
            C6342a.m29029a(TAG, "register app failed for wechat app signature check failed");
            return false;
        }
    }

    public final boolean sendReq(BaseReq baseReq) {
        if (this.detached) {
            throw new IllegalStateException("sendReq fail, WXMsgImpl has been detached");
        } else if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
            C6342a.m29029a(TAG, "sendReq failed for wechat app signature check failed");
            return false;
        } else if (baseReq.checkArgs()) {
            C6342a.m29033d(TAG, "sendReq, req type = " + baseReq.getType());
            Bundle bundle = new Bundle();
            baseReq.toBundle(bundle);
            if (baseReq.getType() == 5) {
                return sendPayReq(this.context, bundle);
            }
            if (baseReq.getType() == 7) {
                return sendJumpToBizProfileReq(this.context, bundle);
            }
            if (baseReq.getType() == 8) {
                return sendJumpToBizWebviewReq(this.context, bundle);
            }
            if (baseReq.getType() == 9) {
                return sendAddCardToWX(this.context, bundle);
            }
            C6336a c6336a = new C6336a();
            c6336a.f22076n = bundle;
            c6336a.f22075m = "weixin://sendreq?appid=" + this.appId;
            c6336a.f22073k = "com.tencent.mm";
            c6336a.f22074l = WXApp.WXAPP_MSG_ENTRY_CLASSNAME;
            return C6340a.m29023a(this.context, c6336a);
        } else {
            C6342a.m29029a(TAG, "sendReq checkArgs fail");
            return false;
        }
    }

    public final boolean sendResp(BaseResp baseResp) {
        if (this.detached) {
            throw new IllegalStateException("sendResp fail, WXMsgImpl has been detached");
        } else if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
            C6342a.m29029a(TAG, "sendResp failed for wechat app signature check failed");
            return false;
        } else if (baseResp.checkArgs()) {
            Bundle bundle = new Bundle();
            baseResp.toBundle(bundle);
            C6336a c6336a = new C6336a();
            c6336a.f22076n = bundle;
            c6336a.f22075m = "weixin://sendresp?appid=" + this.appId;
            c6336a.f22073k = "com.tencent.mm";
            c6336a.f22074l = WXApp.WXAPP_MSG_ENTRY_CLASSNAME;
            return C6340a.m29023a(this.context, c6336a);
        } else {
            C6342a.m29029a(TAG, "sendResp checkArgs fail");
            return false;
        }
    }

    public final void unregisterApp() {
        if (this.detached) {
            throw new IllegalStateException("unregisterApp fail, WXMsgImpl has been detached");
        } else if (WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
            C6342a.m29033d(TAG, "unregisterApp, appId = " + this.appId);
            if (this.appId == null || this.appId.length() == 0) {
                C6342a.m29029a(TAG, "unregisterApp fail, appId is empty");
                return;
            }
            C6342a.m29033d(TAG, "unregister app " + this.context.getPackageName());
            C6337a c6337a = new C6337a();
            c6337a.f22079o = "com.tencent.mm";
            c6337a.f22080p = ConstantsAPI.ACTION_HANDLE_APP_UNREGISTER;
            c6337a.f22077m = "weixin://unregisterapp?appid=" + this.appId;
            C6338a.m29021a(this.context, c6337a);
        } else {
            C6342a.m29029a(TAG, "unregister app failed for wechat app signature check failed");
        }
    }
}
