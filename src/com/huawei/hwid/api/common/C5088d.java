package com.huawei.hwid.api.common;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.cloudservice.CloudAccount;
import com.huawei.cloudservice.CloudRequestHandler;
import com.huawei.cloudservice.IntentResultHandler;
import com.huawei.cloudservice.LoginHandler;
import com.huawei.hwid.api.common.apkimpl.C5079a;
import com.huawei.hwid.api.common.apkimpl.DummyActivity;
import com.huawei.hwid.api.common.p425b.C5080a;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.core.datatype.HwAccount;
import com.huawei.hwid.core.datatype.UserInfo;
import com.huawei.hwid.core.encrypt.C5201e;
import com.huawei.hwid.core.encrypt.C5203g;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.hwid.core.p429a.C5116a;
import com.huawei.hwid.core.p429a.C5117b;
import com.huawei.hwid.core.p429a.C5118c;
import com.huawei.hwid.core.p430b.p431a.C5125a;
import com.huawei.hwid.core.p430b.p431a.p432a.C5131d;
import com.huawei.hwid.core.p430b.p431a.p432a.C5134e;
import com.huawei.hwid.core.p430b.p431a.p432a.C5136f;
import com.huawei.hwid.core.p430b.p431a.p432a.C5138g;
import com.huawei.hwid.core.p435d.C5166b;
import com.huawei.hwid.core.p435d.C5173d;
import com.huawei.hwid.core.p435d.C5176g;
import com.huawei.hwid.core.p435d.C5180k;
import com.huawei.hwid.core.p435d.C5181l;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.huawei.hwid.p426b.C5114a;
import com.huawei.hwid.p428c.C5115a;
import com.huawei.hwid.vermanager.C5312b;
import com.unionpay.tsmservice.data.Constant;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SuppressLint({"InlinedApi"})
/* compiled from: CloudAccountImpl */
public class C5088d {
    private static Object f18352b = new Object();
    private static Map<String, ArrayList<BroadcastReceiver>> f18353d = new HashMap();
    private HwAccount f18354a = new HwAccount();
    private AlertDialog f18355c;
    private Context f18356e;
    private CloudRequestHandler f18357f;
    private String f18358g;
    private CloudRequestHandler f18359h = new C50841(this);

    /* compiled from: CloudAccountImpl */
    class C50841 implements CloudRequestHandler {
        final /* synthetic */ C5088d f18340a;

        /* compiled from: CloudAccountImpl */
        class C50831 extends Thread {
            final /* synthetic */ C50841 f18339a;

            C50831(C50841 c50841) {
                this.f18339a = c50841;
            }

            public void run() {
                this.f18339a.f18340a.m24485a(this.f18339a.f18340a.f18358g, this.f18339a.f18340a.f18356e, this.f18339a.f18340a.f18357f);
            }
        }

        C50841(C5088d c5088d) {
            this.f18340a = c5088d;
        }

        public void onFinish(Bundle bundle) {
            new C50831(this).start();
        }

        public void onError(ErrorStatus errorStatus) {
            C5165e.m24910d("CloudAccountImpl", "getUserInfo onError, ErrorCode: " + errorStatus.getErrorCode() + ", ErrorReason: " + errorStatus.getErrorReason());
            this.f18340a.f18357f.onError(errorStatus);
        }
    }

    /* compiled from: CloudAccountImpl */
    class C5086a extends BroadcastReceiver {
        private Context f18345a = null;
        private boolean f18346b = false;
        private LoginHandler f18347c = null;
        private C5117b f18348d;

        public C5086a(Context context, LoginHandler loginHandler, C5117b c5117b) {
            this.f18345a = context;
            this.f18347c = loginHandler;
            this.f18348d = c5117b;
        }

        private void m24461a(Context context, HwAccount hwAccount) {
            String str = "";
            if (hwAccount == null) {
                this.f18347c.onLogin(null, 0);
                return;
            }
            C5115a.m24641a(context).m24644a(hwAccount);
            CloudAccount[] a = C5088d.m24489a(context);
            if (!TextUtils.isEmpty(hwAccount.m25120b())) {
                str = hwAccount.m25120b();
            }
            C5165e.m24906b("CloudAccountImpl", "onLogin");
            this.f18347c.onLogin(a, C5088d.m24463a(a, str));
        }

        private void m24460a(Context context, Intent intent) {
            boolean booleanExtra = intent.getBooleanExtra(HwAccountConstants.EXTRA_IS_USE_SDK, false);
            boolean booleanExtra2 = intent.getBooleanExtra(HwAccountConstants.IS_CHANGE_ACCOUNT, false);
            C5165e.m24906b("CloudAccountImpl", "isUseSDK=" + booleanExtra + ",isSwitchAccount=" + booleanExtra2);
            if (this.f18347c != null) {
                String str = "";
                if (booleanExtra) {
                    if (booleanExtra2) {
                        str = intent.getStringExtra(HwAccountConstants.CURRENT_ACCOUNT);
                    } else {
                        HwAccount b = C5088d.m24500c(context, intent);
                        if (!(b == null || TextUtils.isEmpty(b.m25120b()))) {
                            str = b.m25120b();
                        }
                    }
                    CloudAccount[] a = C5088d.m24489a(context);
                    this.f18347c.onLogin(a, C5088d.m24463a(a, str));
                } else {
                    m24461a(context, C5088d.m24500c(context, intent));
                    if (this.f18348d != null) {
                        this.f18348d.m24661a(C5166b.m24915a());
                        C5118c.m24666a(this.f18348d, context);
                        C5106n.m24587a(null);
                    } else {
                        C5165e.m24906b("CloudAccountImpl", "in CloudAccountImpl, opLogItem is null");
                    }
                }
                C5106n.m24585a(context, str);
                return;
            }
            C5165e.m24906b("CloudAccountImpl", "handler is null,so cannot handler message");
        }

        private void m24462b(Context context, Intent intent) {
            ErrorStatus errorStatus = new ErrorStatus(3002, "use the sdk: press back key");
            boolean booleanExtra = intent.getBooleanExtra(HwAccountConstants.EXTRA_IS_USE_SDK, true);
            Bundle bundleExtra = intent.getBundleExtra(HwAccountConstants.EXTRA_BUNDLE);
            if (!(bundleExtra == null || booleanExtra)) {
                int i = bundleExtra.getInt("errorcode");
                Object string = bundleExtra.getString("errorreason");
                if (!(i == 0 || TextUtils.isEmpty(string))) {
                    errorStatus = new ErrorStatus(i, string);
                }
            }
            if (this.f18347c != null) {
                this.f18347c.onError(errorStatus);
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onReceive(android.content.Context r5, android.content.Intent r6) {
            /*
            r4 = this;
            r1 = com.huawei.hwid.api.common.C5088d.f18352b;
            monitor-enter(r1);
            r0 = r4.f18346b;	 Catch:{ all -> 0x0055 }
            if (r0 == 0) goto L_0x000b;
        L_0x0009:
            monitor-exit(r1);	 Catch:{ all -> 0x0055 }
        L_0x000a:
            return;
        L_0x000b:
            r0 = new android.os.Bundle;	 Catch:{ all -> 0x0055 }
            r0.<init>();	 Catch:{ all -> 0x0055 }
            r2 = "LoginBroadcastReceiver";
            r3 = 1;
            r0.putBoolean(r2, r3);	 Catch:{ all -> 0x0055 }
            r2 = r4.f18345a;	 Catch:{ all -> 0x0055 }
            com.huawei.hwid.api.common.C5088d.m24471a(r2, r0);	 Catch:{ all -> 0x0055 }
            r0 = 1;
            r4.f18346b = r0;	 Catch:{ all -> 0x0055 }
            monitor-exit(r1);	 Catch:{ all -> 0x0055 }
            if (r6 == 0) goto L_0x000a;
        L_0x0021:
            r0 = r6.getAction();	 Catch:{ RuntimeException -> 0x004c }
            r1 = "CloudAccountImpl";
            r2 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x004c }
            r2.<init>();	 Catch:{ RuntimeException -> 0x004c }
            r3 = "onReceive:: mBroadcastReceiver=";
            r2 = r2.append(r3);	 Catch:{ RuntimeException -> 0x004c }
            r2 = r2.append(r4);	 Catch:{ RuntimeException -> 0x004c }
            r2 = r2.toString();	 Catch:{ RuntimeException -> 0x004c }
            com.huawei.hwid.core.p435d.p437b.C5165e.m24912e(r1, r2);	 Catch:{ RuntimeException -> 0x004c }
            com.huawei.hwid.api.common.C5088d.m24507e(r5);	 Catch:{ RuntimeException -> 0x004c }
            r1 = "com.huawei.cloudserive.loginSuccess";
            r1 = r1.equals(r0);	 Catch:{ RuntimeException -> 0x004c }
            if (r1 == 0) goto L_0x0058;
        L_0x0048:
            r4.m24460a(r5, r6);	 Catch:{ RuntimeException -> 0x004c }
            goto L_0x000a;
        L_0x004c:
            r0 = move-exception;
            r0 = "CloudAccountImpl";
            r1 = "Unhandle exception because of Intent to prevent DDOS";
            com.huawei.hwid.core.p435d.p437b.C5165e.m24910d(r0, r1);
            goto L_0x000a;
        L_0x0055:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0055 }
            throw r0;
        L_0x0058:
            r1 = "com.huawei.cloudserive.loginFailed";
            r1 = r1.equals(r0);	 Catch:{ RuntimeException -> 0x004c }
            if (r1 == 0) goto L_0x0072;
        L_0x0060:
            r0 = "parce";
            r0 = r6.getParcelableExtra(r0);	 Catch:{ RuntimeException -> 0x004c }
            r0 = (com.huawei.hwid.core.helper.handler.ErrorStatus) r0;	 Catch:{ RuntimeException -> 0x004c }
            r1 = r4.f18347c;	 Catch:{ RuntimeException -> 0x004c }
            if (r1 == 0) goto L_0x000a;
        L_0x006c:
            r1 = r4.f18347c;	 Catch:{ RuntimeException -> 0x004c }
            r1.onError(r0);	 Catch:{ RuntimeException -> 0x004c }
            goto L_0x000a;
        L_0x0072:
            r1 = "com.huawei.cloudserive.loginCancel";
            r0 = r1.equals(r0);	 Catch:{ RuntimeException -> 0x004c }
            if (r0 == 0) goto L_0x000a;
        L_0x007a:
            r4.m24462b(r5, r6);	 Catch:{ RuntimeException -> 0x004c }
            goto L_0x000a;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hwid.api.common.d.a.onReceive(android.content.Context, android.content.Intent):void");
        }
    }

    /* compiled from: CloudAccountImpl */
    class C5087b extends BroadcastReceiver {
        private Context f18349a = null;
        private boolean f18350b = false;
        private CloudRequestHandler f18351c;

        public C5087b(Context context, CloudRequestHandler cloudRequestHandler) {
            this.f18349a = context;
            this.f18351c = cloudRequestHandler;
        }

        public void onReceive(Context context, Intent intent) {
            if (!this.f18350b) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("LogoutBroadcastReceiver", true);
                    C5088d.m24471a(this.f18349a, bundle);
                } catch (Throwable e) {
                    C5165e.m24909c("CloudAccountImpl", e.getMessage(), e);
                }
                this.f18350b = true;
                if (intent != null) {
                    String str = "";
                    try {
                        str = intent.getAction();
                        C5088d.m24507e(context);
                        if (HwAccountConstants.ACTION_LOGOUT_CANCEL.equals(str)) {
                            if (this.f18351c != null) {
                                this.f18351c.onError(new ErrorStatus(3002, "logout hwid cancel: press cancel or back key"));
                                C5165e.m24906b("CloudAccountImpl", "logout hwid cancel: press cancel or back key");
                            }
                        } else if (HwAccountConstants.ACTION_LOGOUT_FAIL.equals(str) && this.f18351c != null) {
                            this.f18351c.onError(new ErrorStatus(19, "logout hwid failed"));
                            C5165e.m24906b("CloudAccountImpl", "logout hwid failed");
                        }
                    } catch (Exception e2) {
                        C5165e.m24910d("CloudAccountImpl", "LogoutBroadcastReceiver param error");
                    }
                }
            }
        }
    }

    public static void m24470a(Context context, Intent intent, int i, CloudRequestHandler cloudRequestHandler) {
        if (!C5106n.m24591a(context, cloudRequestHandler)) {
            C5165e.m24906b("CloudAccountImpl", "setLogoutIntent: context or cloudRequestHandler is null");
        } else if (!C5166b.m24955h(context)) {
            C5165e.m24906b("CloudAccountImpl", "setLogoutIntent:can not use hwid");
            cloudRequestHandler.onError(new ErrorStatus(33, "hwid is not exit"));
        } else if (!C5106n.m24593b(context)) {
            C5165e.m24906b("CloudAccountImpl", "setLogoutIntent:hwid is not exit");
            cloudRequestHandler.onError(new ErrorStatus(34, "hwid is not exit"));
        } else if (C5106n.m24589a(context, 20302000)) {
            cloudRequestHandler.onError(new ErrorStatus(35, "hwid version must be higher than 2.3.2"));
            C5165e.m24906b("CloudAccountImpl", "apk version is low");
        } else if (i < 0 || intent == null || !C5106n.m24590a(context, intent)) {
            C5165e.m24906b("CloudAccountImpl", "priority or intent is  invalid!");
            cloudRequestHandler.onError(new ErrorStatus(12, "parameter can not be empty,  priority should not be less than 0, Intent must be valid"));
        } else {
            C5079a.m24442a(context, intent, i, cloudRequestHandler);
        }
    }

    public static void m24476a(Context context, String str, Bundle bundle, LoginHandler loginHandler) {
        int i = 0;
        if (!C5088d.m24487a(context, loginHandler)) {
            C5165e.m24906b("CloudAccountImpl", "getAccountsByType: context or handler is null");
        } else if (!C5166b.m24955h(context)) {
            C5165e.m24906b("CloudAccountImpl", "can not use hwid");
            loginHandler.onError(new ErrorStatus(33, "hwid is not exit"));
        } else if (C5106n.m24593b(context)) {
            boolean z;
            boolean z2;
            Bundle bundle2;
            C5106n.m24586a(loginHandler);
            C5165e.m24906b("CloudAccountImpl", "mHandler is " + loginHandler);
            C5088d.m24507e(context);
            String d = C5088d.m24504d(context, str);
            if (bundle != null) {
                boolean z3 = bundle.getBoolean("popLogin", false);
                z = bundle.getBoolean(CloudAccount.KEY_CHOOSE_WINDOW, false);
                i = bundle.getInt(CloudAccount.KEY_LOGIN_CHANNEL, 0);
                z2 = z3;
                bundle2 = bundle;
            } else {
                bundle2 = new Bundle();
                z = false;
                z2 = false;
            }
            if (i == 0) {
                C5165e.m24906b("CloudAccountImpl", "loginChannel can't be null!");
                loginHandler.onError(new ErrorStatus(12, "loginChannel can't be null!"));
                return;
            }
            C5165e.m24912e("CloudAccountImpl", "getAccountsByType:isSelectAccount=" + z + ",isPopLogin=" + z2);
            if (TextUtils.isEmpty(d)) {
                d = C5166b.m24937c(context);
            }
            if (C5088d.m24498b(context, d, loginHandler)) {
                C5088d.m24511g(context);
                String a = C5106n.m24583a(context);
                C5173d.m24991a(d);
                C5116a.m24648a(context).m24653a(String.valueOf(i));
                C5117b c5117b = new C5117b(context, "105", a);
                C5106n.m24587a(c5117b);
                C5079a.m24447a(context, d, a, bundle2, loginHandler, c5117b);
            }
        } else {
            C5165e.m24906b("CloudAccountImpl", "hwid is not exit");
            loginHandler.onError(new ErrorStatus(34, "hwid is not exit"));
        }
    }

    public static void m24467a(Activity activity, LoginHandler loginHandler, int i, String str) {
        if (C5106n.m24589a((Context) activity, 20504100)) {
            C5165e.m24906b("CloudAccountImpl", "hwid apk version is low");
            loginHandler.onError(new ErrorStatus(35, "hwid is low version"));
        } else if (i == 0) {
            C5165e.m24906b("CloudAccountImpl", "loginChannel can't be null!");
            loginHandler.onError(new ErrorStatus(12, "loginChannel can't be null!"));
        } else {
            C5106n.m24586a(loginHandler);
            C5173d.m24991a(str);
            C5116a.m24648a((Context) activity).m24653a(String.valueOf(i));
            C5106n.m24587a(new C5117b(activity, "105", C5106n.m24583a((Context) activity)));
            Intent intent = new Intent();
            intent.setClass(activity, DummyActivity.class);
            intent.putExtra("requestTokenType", str);
            Bundle bundle = new Bundle();
            bundle.putBoolean("isFromApk", true);
            bundle.putBoolean("IS_LOGIN_BY_ACTIVITY", true);
            intent.putExtra(HwAccountConstants.EXTRA_BUNDLE, bundle);
            intent.setFlags(1048576);
            activity.startActivity(intent);
        }
    }

    private static boolean m24498b(Context context, String str, LoginHandler loginHandler) {
        if (context.getPackageName().equals(str)) {
            return true;
        }
        ErrorStatus errorStatus = new ErrorStatus(12, "tokenType is not the same as package name");
        C5165e.m24906b("CloudAccountImpl", "error: " + errorStatus.toString());
        loginHandler.onError(errorStatus);
        return false;
    }

    public static int m24463a(CloudAccount[] cloudAccountArr, String str) {
        if (!(TextUtils.isEmpty(str) || cloudAccountArr == null || cloudAccountArr.length <= 0)) {
            for (int i = 0; i < cloudAccountArr.length; i++) {
                if (str.equalsIgnoreCase(cloudAccountArr[i].getAccountName())) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static CloudAccount[] m24489a(Context context) {
        if (context == null) {
            C5165e.m24906b("CloudAccountImpl", "context is null");
            return new CloudAccount[0];
        }
        List a = C5114a.m24640a(context).mo4617a(context, C5166b.m24960l(context));
        if (a == null || a.isEmpty()) {
            return new CloudAccount[0];
        }
        CloudAccount[] cloudAccountArr = new CloudAccount[a.size()];
        for (int i = 0; i < cloudAccountArr.length; i++) {
            C5088d c5088d = new C5088d();
            c5088d.m24484a((HwAccount) a.get(i));
            cloudAccountArr[i] = new CloudAccount(c5088d);
        }
        return cloudAccountArr;
    }

    private void m24484a(HwAccount hwAccount) {
        this.f18354a = hwAccount;
    }

    private static void m24511g(Context context) {
        C5088d.m24512h(context);
        if (C5106n.m24595c()) {
            C5165e.m24912e("CloudAccountImpl", "begin to init accounts");
            C5088d.m24489a(context);
            C5106n.m24588a(false);
            C5165e.m24912e("CloudAccountImpl", "initData");
            if (TextUtils.isEmpty(C5106n.m24583a(context))) {
                List a = C5114a.m24640a(context).mo4617a(context, C5166b.m24960l(context));
                if (a != null && !a.isEmpty()) {
                    String b = ((HwAccount) a.get(0)).m25120b();
                    C5106n.m24585a(context, b);
                    C5165e.m24912e("CloudAccountImpl", "initData===> mCurrentLoginUserName:" + C5203g.m25322d(b));
                }
            }
        }
    }

    private static synchronized void m24512h(Context context) {
        synchronized (C5088d.class) {
            C5165e.m24906b("CloudAccountImpl", "synAccountFromApkToSDK");
            if (C5166b.m24955h(context) && C5106n.m24593b(context)) {
                Account[] accountsByType = AccountManager.get(context).getAccountsByType("com.huawei.hwid");
                if (accountsByType == null || accountsByType.length == 0) {
                    C5165e.m24912e("CloudAccountImpl", "apk has no account, clear all sdk accounts");
                    C5088d.m24493b(context);
                } else {
                    List<HwAccount> a = C5114a.m24640a(context).mo4617a(context, C5166b.m24960l(context));
                    if (!(a == null || a.isEmpty())) {
                        C5165e.m24912e("CloudAccountImpl", "sdk has accounts， so need to synchronize accounts");
                        ArrayList arrayList = new ArrayList();
                        for (HwAccount hwAccount : a) {
                            Object obj;
                            String b = hwAccount.m25120b();
                            for (Account account : accountsByType) {
                                if (b.equals(account.name)) {
                                    obj = 1;
                                    break;
                                }
                            }
                            obj = null;
                            if (obj != null) {
                                arrayList.add(hwAccount);
                            }
                        }
                        if (arrayList.isEmpty()) {
                            C5088d.m24493b(context);
                        } else {
                            C5114a.m24640a(context).mo4622a(context, arrayList);
                            C5165e.m24912e("CloudAccountImpl", "save accounts size: " + arrayList.size());
                        }
                        C5106n.m24585a(context, C5088d.m24502c(context, C5106n.m24583a(context)));
                    }
                }
            }
        }
    }

    private static String m24502c(Context context, String str) {
        List<HwAccount> a = C5114a.m24640a(context).mo4617a(context, C5166b.m24960l(context));
        if (a == null || a.isEmpty()) {
            return "";
        }
        for (HwAccount b : a) {
            if (b.m25120b().equals(str)) {
                return str;
            }
        }
        return ((HwAccount) a.get(0)).m25120b();
    }

    public static void m24493b(Context context) {
        if (context == null) {
            C5165e.m24906b("CloudAccountImpl", "context is null");
            return;
        }
        C5165e.m24906b("CloudAccountImpl", "clear all accout data");
        C5114a.m24640a(context).mo4624b(context, C5166b.m24960l(context));
        C5106n.m24585a(context, "");
    }

    public static void m24474a(Context context, LoginHandler loginHandler, C5117b c5117b) {
        if (context == null) {
            C5165e.m24906b("CloudAccountImpl", "context is null");
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(HwAccountConstants.ACTION_LOGIN_SUCCESS);
        intentFilter.addAction(HwAccountConstants.ACTION_LOGIN_FAILED);
        intentFilter.addAction(HwAccountConstants.ACTION_LOGIN_CANCEL);
        if (f18353d.containsKey("LoginBroadcastReceiver")) {
            C5088d.m24508e(context, "LoginBroadcastReceiver");
        }
        BroadcastReceiver c5086a = new C5086a(context, loginHandler, c5117b);
        try {
            context.registerReceiver(c5086a, intentFilter);
            C5088d.m24468a(c5086a, "LoginBroadcastReceiver");
        } catch (Exception e) {
            C5165e.m24906b("CloudAccountImpl", "BroadcastReceiver components are not allowed to register to receive intents");
        }
    }

    private static HwAccount m24500c(Context context, Intent intent) {
        if (intent.hasExtra(HwAccountConstants.EXTRA_HWACCOUNT)) {
            return (HwAccount) intent.getParcelableExtra(HwAccountConstants.EXTRA_HWACCOUNT);
        }
        if (intent.hasExtra(HwAccountConstants.EXTRA_ACCOUNT_BUNDLE)) {
            return C5106n.m24582a(context, intent.getBundleExtra(HwAccountConstants.EXTRA_ACCOUNT_BUNDLE));
        }
        if (intent.hasExtra(HwAccountConstants.EXTRA_BUNDLE)) {
            return C5106n.m24582a(context, intent.getBundleExtra(HwAccountConstants.EXTRA_BUNDLE));
        }
        return null;
    }

    public static String m24501c(Context context) {
        if (!C5166b.m24955h(context)) {
            C5165e.m24906b("CloudAccountImpl", "can not use hwid");
            return "";
        } else if (C5106n.m24593b(context)) {
            String str = "";
            if (context != null) {
                return C5106n.m24583a(context);
            }
            return str;
        } else {
            C5165e.m24906b("CloudAccountImpl", "hwid is not exit");
            return "";
        }
    }

    public HwAccount m24514a() {
        return this.f18354a;
    }

    public static boolean m24488a(Context context, String str) {
        if (context != null) {
            return C5114a.m24640a(context).mo4626c(context, str);
        }
        C5165e.m24906b("CloudAccountImpl", "context is null");
        return false;
    }

    public static void m24478a(Context context, String str, LoginHandler loginHandler) {
        if (C5088d.m24487a(context, loginHandler)) {
            C5165e.m24906b("CloudAccountImpl", "enter quickLogin(context:" + context + " tokenType:" + str + " loginHandler" + loginHandler);
            String d = C5088d.m24504d(context, str);
            C5173d.m24991a(d);
            ErrorStatus errorStatus;
            if (!C5166b.m24924a(context)) {
                errorStatus = new ErrorStatus(5, context.getString(C5180k.m25027a(context, "CS_no_network_content")));
                C5165e.m24912e("CloudAccountImpl", "error: " + errorStatus.toString());
                loginHandler.onError(errorStatus);
                return;
            } else if (!C5166b.m24925a(context, (int) HwAccountConstants.NO_SUBID)) {
                errorStatus = new ErrorStatus(6, context.getString(C5180k.m25027a(context, "CS_sim_card_unavailable")));
                C5165e.m24912e("CloudAccountImpl", "error: " + errorStatus.toString());
                loginHandler.onError(errorStatus);
                return;
            } else if (!C5166b.m24955h(context)) {
                C5165e.m24906b("CloudAccountImpl", "can not use hwid");
                loginHandler.onError(new ErrorStatus(33, "hwid is not exit"));
                return;
            } else if (C5106n.m24593b(context)) {
                C5088d.m24507e(context);
                if (TextUtils.isEmpty(d)) {
                    d = C5166b.m24937c(context);
                }
                if (VERSION.SDK_INT > 22 || C5166b.m24929a(context.getPackageManager(), "android.permission.SEND_SMS", "com.huawei.hwid")) {
                    C5079a.m24445a(context, d, loginHandler);
                    return;
                }
                errorStatus = new ErrorStatus(17, "no permission to send sms");
                C5165e.m24912e("CloudAccountImpl", "error: " + errorStatus.toString());
                loginHandler.onError(errorStatus);
                return;
            } else {
                C5165e.m24906b("CloudAccountImpl", "hwid is not exit");
                loginHandler.onError(new ErrorStatus(34, "hwid is not exit"));
                return;
            }
        }
        C5165e.m24906b("CloudAccountImpl", "quickLogin: context or loginHandler is null");
    }

    public void m24518a(Context context, String str, String str2, int i, CloudRequestHandler cloudRequestHandler) {
        if (!C5106n.m24591a(context, cloudRequestHandler)) {
            C5165e.m24906b("CloudAccountImpl", "serviceTokenAuth: context or requestHandler is null");
        } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || i < 0) {
            C5165e.m24912e("CloudAccountImpl", "error: parameter is invalid");
            r0 = new ErrorStatus(12, "parameter is invalid");
            C5165e.m24912e("CloudAccountImpl", "error: " + r0.toString());
            cloudRequestHandler.onError(r0);
        } else if (!C5166b.m24924a(context)) {
            C5165e.m24912e("CloudAccountImpl", "error: have no network");
            r0 = new ErrorStatus(5, context.getString(C5180k.m25027a(context, "CS_no_network_content")));
            C5165e.m24912e("CloudAccountImpl", "error: " + r0.toString());
            cloudRequestHandler.onError(r0);
        } else if (!C5166b.m24955h(context)) {
            C5165e.m24906b("CloudAccountImpl", "can not use hwid");
            cloudRequestHandler.onError(new ErrorStatus(33, "hwid is not exit"));
        } else if (C5106n.m24593b(context)) {
            C5173d.m24991a(str);
            String str3 = "";
            if (this.f18354a != null) {
                str3 = this.f18354a.m25134i();
            }
            C5125a c5131d = new C5131d(context, str, str2, i, str3);
            c5131d.mo4627a(context, c5131d, null, cloudRequestHandler);
        } else {
            C5165e.m24906b("CloudAccountImpl", "hwid is not exit");
            cloudRequestHandler.onError(new ErrorStatus(34, "hwid is not exit"));
        }
    }

    public static CloudAccount m24491b(Context context, String str) {
        if (context == null) {
            C5165e.m24906b("CloudAccountImpl", "context is null");
            return null;
        } else if (TextUtils.isEmpty(str)) {
            C5165e.m24912e("CloudAccountImpl", "get account by userID failed, the userID is null!");
            return null;
        } else if (!C5166b.m24955h(context)) {
            C5165e.m24906b("CloudAccountImpl", "can not use hwid");
            return null;
        } else if (C5106n.m24593b(context)) {
            HwAccount d = C5166b.m24941d(context, str);
            if (d != null) {
                C5088d c5088d = new C5088d();
                c5088d.m24484a(d);
                C5165e.m24912e("CloudAccountImpl", "get account by userID success!");
                return new CloudAccount(c5088d);
            }
            C5165e.m24906b("CloudAccountImpl", "get account by userID failed, there is no matching account!");
            return null;
        } else {
            C5165e.m24906b("CloudAccountImpl", "hwid is not exit");
            return null;
        }
    }

    public String m24520b() {
        return this.f18354a.m25130g();
    }

    public Bundle m24522c() {
        return this.f18354a.m25146p();
    }

    public void m24524d(Context context) {
        if (context == null) {
            C5165e.m24906b("CloudAccountImpl", "context is null");
            return;
        }
        if (C5166b.m24955h(context) && C5106n.m24593b(context)) {
            C5079a.m24443a(context, this.f18354a);
        }
        C5114a.m24640a(context).mo4618a(context, this.f18354a.m25120b(), C5166b.m24960l(context));
        String a = C5106n.m24583a(context);
        if (this.f18354a.m25120b().equalsIgnoreCase(a)) {
            a = "";
            C5106n.m24585a(context, a);
        }
        LoginHandler a2 = C5106n.m24581a();
        if (a2 != null) {
            CloudAccount[] a3 = C5088d.m24489a(context);
            a2.onLogout(a3, C5088d.m24463a(a3, a));
        }
    }

    public void m24516a(Context context, String str, CloudRequestHandler cloudRequestHandler) {
        if (!C5106n.m24591a(context, cloudRequestHandler)) {
            C5165e.m24906b("CloudAccountImpl", "getUserInfo: context or cloudRequestHandler is null");
        } else if (!C5166b.m24955h(context)) {
            C5165e.m24906b("CloudAccountImpl", "can not use hwid");
            cloudRequestHandler.onError(new ErrorStatus(33, "hwid is not exit"));
        } else if (C5106n.m24593b(context)) {
            C5166b.m24921a(context, this.f18354a.m25124d(), str, cloudRequestHandler);
        } else {
            C5165e.m24906b("CloudAccountImpl", "hwid is not exit");
            cloudRequestHandler.onError(new ErrorStatus(34, "hwid is not exit"));
        }
    }

    public boolean m24519a(final Context context, final UserInfo userInfo, final CloudRequestHandler cloudRequestHandler) {
        C5165e.m24906b("CloudAccountImpl", "updateUserInfo enter");
        if (!C5106n.m24591a(context, cloudRequestHandler) || userInfo == null) {
            C5165e.m24906b("CloudAccountImpl", "updataUserinfo: context or cloudRequestHandler or info is null");
            return false;
        } else if (!C5166b.m24955h(context)) {
            C5165e.m24906b("CloudAccountImpl", "can not use hwid");
            cloudRequestHandler.onError(new ErrorStatus(33, "hwid is not exit"));
            return false;
        } else if (!C5106n.m24593b(context)) {
            C5165e.m24906b("CloudAccountImpl", "hwid is not exit");
            cloudRequestHandler.onError(new ErrorStatus(34, "hwid is not exit"));
            return false;
        } else if (C5106n.m24589a(context, 20300000)) {
            C5165e.m24906b("CloudAccountImpl", "hwid apk version is low");
            cloudRequestHandler.onError(new ErrorStatus(35, "hwid is low version"));
            return false;
        } else {
            new Thread(this) {
                final /* synthetic */ C5088d f18344d;

                public void run() {
                    this.f18344d.m24496b(context, userInfo, cloudRequestHandler);
                }
            }.start();
            return true;
        }
    }

    private void m24485a(String str, Context context, CloudRequestHandler cloudRequestHandler) {
        HashMap hashMap = new HashMap();
        hashMap.put("userID", this.f18354a.m25124d());
        hashMap.put(CloudAccount.KEY_REQCLIENTTYPE, "7");
        hashMap.put("fileCnt", "1");
        hashMap.put("ver", "12000");
        String a = m24466a(C5125a.m24676c(), this.f18354a.m25126e());
        if (C5166b.m24924a(context)) {
            String a2 = C5176g.m25008a(context, m24464a(str), a, hashMap, this.f18354a.m25120b());
            Intent intent = new Intent();
            C5176g.m25007a(a2, intent);
            Bundle extras = intent.getExtras();
            if (extras == null) {
                a2 = "";
            } else {
                a2 = extras.getString("fileUrlB", "");
            }
            Bundle extras2;
            if (a2.isEmpty()) {
                a2 = "upload headPic faild";
                extras2 = intent.getExtras();
                if (extras2 != null) {
                    a2 = extras2.getString(Constant.KEY_ERROR_DESC, a2);
                }
                cloudRequestHandler.onError(new ErrorStatus(37, a2));
                return;
            }
            extras2 = new Bundle();
            extras2.putBoolean(HwAccountConstants.SERVICETOKENAUTH_IS_SECCUSS, true);
            extras2.putString("url", a2);
            cloudRequestHandler.onFinish(extras2);
            return;
        }
        cloudRequestHandler.onError(new ErrorStatus(5, context.getString(C5180k.m25027a(context, "CS_no_network_content"))));
        C5165e.m24906b("CloudAccountImpl", "error: have no network");
    }

    public boolean m24521b(Context context, String str, CloudRequestHandler cloudRequestHandler) {
        if (!C5106n.m24591a(context, cloudRequestHandler) || str == null || str.isEmpty()) {
            C5165e.m24906b("CloudAccountImpl", "updataUserinfo: context or cloudRequestHandler or info is null");
            return false;
        } else if (!C5166b.m24955h(context)) {
            C5165e.m24906b("CloudAccountImpl", "can not use hwid");
            cloudRequestHandler.onError(new ErrorStatus(33, "hwid is not exit"));
            return false;
        } else if (!C5106n.m24593b(context)) {
            C5165e.m24906b("CloudAccountImpl", "hwid is not exit");
            cloudRequestHandler.onError(new ErrorStatus(34, "hwid is not exit"));
            return false;
        } else if (C5106n.m24589a(context, 20300000)) {
            C5165e.m24906b("CloudAccountImpl", "hwid apk version is low");
            cloudRequestHandler.onError(new ErrorStatus(35, "hwid is low version"));
            return false;
        } else if (m24464a(str) == null) {
            return false;
        } else {
            this.f18358g = str;
            this.f18356e = context;
            this.f18357f = cloudRequestHandler;
            m24518a(context, this.f18354a.m25132h(), this.f18354a.m25130g(), this.f18354a.m25126e(), this.f18359h);
            return true;
        }
    }

    private void m24496b(Context context, UserInfo userInfo, CloudRequestHandler cloudRequestHandler) {
        C5165e.m24906b("CloudAccountImpl", "syncUserInfo enter");
        if (C5166b.m24924a(context)) {
            C5125a c5136f = new C5136f(this.f18354a.m25124d(), null, null, userInfo, null, new Bundle());
            c5136f.m24690c(this.f18354a.m25126e());
            c5136f.mo4627a(context, c5136f, this.f18354a.m25120b(), cloudRequestHandler);
            return;
        }
        cloudRequestHandler.onError(new ErrorStatus(5, context.getString(C5180k.m25027a(context, "CS_no_network_content"))));
        C5165e.m24906b("CloudAccountImpl", "error: have no network");
    }

    private File m24464a(String str) {
        File file = new File(str);
        if (file.exists()) {
            C5165e.m24908c("CloudAccountImpl", "Photo is existed ");
            return file;
        }
        C5165e.m24908c("CloudAccountImpl", "Photo is not existed ");
        return null;
    }

    private String m24466a(String str, int i) {
        C5165e.m24904a("CloudAccountImpl", "genUpdateHeadUrl, mSiteId is " + i);
        String str2 = "";
        if (i >= 1 && i <= 999) {
            str2 = String.valueOf(i);
        }
        return C5181l.m25036a(str, new String[]{"\\{0\\}", str2});
    }

    public static synchronized void m24507e(Context context) {
        synchronized (C5088d.class) {
            C5165e.m24903a(context);
        }
    }

    public static void m24480a(Context context, String str, String str2, String str3, String str4, CloudRequestHandler cloudRequestHandler, Bundle bundle) {
        if (!C5106n.m24591a(context, cloudRequestHandler)) {
            C5165e.m24906b("CloudAccountImpl", "checkPassWord: context or cloudRequestHandler is null");
        } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str4)) {
            C5165e.m24912e("CloudAccountImpl", "error: parameter is invalid");
            r0 = new ErrorStatus(12, "parameter is invalid");
            C5165e.m24912e("CloudAccountImpl", "error: " + r0.toString());
            cloudRequestHandler.onError(r0);
        } else if (!C5166b.m24924a(context)) {
            C5165e.m24912e("CloudAccountImpl", "error: have no network");
            r0 = new ErrorStatus(5, context.getString(C5180k.m25027a(context, "CS_no_network_content")));
            C5165e.m24912e("CloudAccountImpl", "error: " + r0.toString());
            cloudRequestHandler.onError(r0);
        } else if (!C5106n.m24593b(context)) {
            C5165e.m24906b("CloudAccountImpl", "hwid is not exit");
            cloudRequestHandler.onError(new ErrorStatus(34, "hwid is not exit"));
        } else if (C5166b.m24947e(str3)) {
            C5165e.m24906b("CloudAccountImpl", "this is third account");
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean(HwAccountConstants.SERVICETOKENAUTH_IS_SECCUSS, true);
            cloudRequestHandler.onFinish(bundle2);
        } else {
            String c;
            if (str3 == null) {
                c = C5166b.m24938c(str);
            } else {
                c = str3;
            }
            C5125a c5138g = new C5138g(context, str, C5201e.m25305a(str2), c, str4);
            c5138g.mo4627a(context, c5138g, str, cloudRequestHandler);
        }
    }

    private static String m24504d(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return C5166b.m24960l(context);
        }
        C5176g.m25009a(context, HwAccountConstants.TOKEN_TYPE, str);
        return str;
    }

    public static void m24477a(Context context, String str, CloudRequestHandler cloudRequestHandler, Bundle bundle) {
        if (!C5106n.m24591a(context, cloudRequestHandler)) {
            C5165e.m24906b("CloudAccountImpl", "logoutHwIDByUserID: context or cloudRequestHandler is null");
        } else if (TextUtils.isEmpty(str)) {
            if (cloudRequestHandler != null) {
                cloudRequestHandler.onError(new ErrorStatus(12, "userId is empty"));
            }
            C5165e.m24906b("CloudAccountImpl", "userId is empty");
        } else if (C5166b.m24934b(context, HwAccountConstants.ACTION_LOGOUT_FOR_APP)) {
            CloudAccount b = C5088d.m24491b(context, str);
            HwAccount hwAccount = null;
            if (b != null) {
                hwAccount = b.getAccountData();
            }
            if (C5166b.m24934b(context, HwAccountConstants.ACTION_LOGOUT_FOR_APP_BY_USERID)) {
                C5088d.m24505d(context, cloudRequestHandler);
                C5165e.m24906b("CloudAccountImpl", "start logout listener");
            } else {
                C5165e.m24906b("CloudAccountImpl", "hwid is not send broadcast");
            }
            if (hwAccount != null) {
                C5088d.m24479a(context, str, hwAccount.m25120b(), cloudRequestHandler);
                return;
            }
            String str2 = "";
            if (bundle != null) {
                C5088d.m24479a(context, str, bundle.getString("accountName"), cloudRequestHandler);
            }
        } else if (cloudRequestHandler != null) {
            C5165e.m24906b("CloudAccountImpl", "HwID is not install or version isn't support this port!");
            cloudRequestHandler.onError(new ErrorStatus(20, "HwID is not install or version isn't support this port!"));
        }
    }

    private static void m24505d(Context context, CloudRequestHandler cloudRequestHandler) {
        if (context == null) {
            C5165e.m24906b("CloudAccountImpl", "context is null");
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(HwAccountConstants.ACTION_LOGOUT_CANCEL);
        intentFilter.addAction(HwAccountConstants.ACTION_LOGOUT_FAIL);
        intentFilter.addAction("com.huawei.hwid.ACTION_REMOVE_ACCOUNT");
        if (f18353d.containsKey("LogoutBroadcastReceiver")) {
            C5088d.m24508e(context, "LogoutBroadcastReceiver");
        }
        BroadcastReceiver c5087b = new C5087b(context, cloudRequestHandler);
        try {
            context.registerReceiver(c5087b, intentFilter);
            C5088d.m24468a(c5087b, "LogoutBroadcastReceiver");
        } catch (Exception e) {
            C5165e.m24906b("CloudAccountImpl", "BroadcastReceiver components are not allowed to register to receive intents");
        }
    }

    private static void m24479a(Context context, String str, String str2, CloudRequestHandler cloudRequestHandler) {
        C5165e.m24906b("CloudAccountImpl", "handlerLogout :" + C5203g.m25318a("userId", (Object) str) + HwAccountConstants.BLANK + C5203g.m25322d(str2));
        Intent intent = new Intent(HwAccountConstants.ACTION_LOGOUT_FOR_APP);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("userId", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra(HwAccountConstants.ACCOUNT_KEY, new Account(str2, "com.huawei.hwid"));
        }
        intent.setPackage("com.huawei.hwid");
        C5166b.m24920a(context, intent, 0);
    }

    public static void m24473a(Context context, CloudRequestHandler cloudRequestHandler) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.hwid.ACTION.BINDSAFEPHONE.SUCCESS");
        if (f18353d.containsKey("BindSafePhoneBroadcastReceiver")) {
            C5088d.m24508e(context, "BindSafePhoneBroadcastReceiver");
        }
        BroadcastReceiver c5082c = new C5082c(context, cloudRequestHandler);
        try {
            context.registerReceiver(c5082c, intentFilter);
            C5088d.m24468a(c5082c, "BindSafePhoneBroadcastReceiver");
        } catch (Exception e) {
            C5165e.m24906b("CloudAccountImpl", "BroadcastReceiver components are not allowed to register to receive intents");
        }
    }

    public static void m24495b(Context context, CloudRequestHandler cloudRequestHandler) {
        if (context == null) {
            C5165e.m24906b("CloudAccountImpl", "context is null");
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.cloudserive.fingerSuccess");
        intentFilter.addAction("com.huawei.cloudserive.fingerCancel");
        if (f18353d.containsKey("FingerBroadcastReceiver")) {
            C5088d.m24508e(context, "FingerBroadcastReceiver");
        }
        BroadcastReceiver c5096h = new C5096h(context, cloudRequestHandler);
        try {
            context.registerReceiver(c5096h, intentFilter);
            C5088d.m24468a(c5096h, "FingerBroadcastReceiver");
        } catch (Exception e) {
            C5165e.m24906b("CloudAccountImpl", "BroadcastReceiver components are not allowed to register to receive intents");
        }
    }

    public static void m24469a(Context context, Intent intent) {
        HwAccount c = C5088d.m24500c(context, intent);
        if (c != null && C5166b.m24930a(c)) {
            C5088d.m24493b(context);
            C5115a.m24641a(context).m24644a(c);
            C5106n.m24585a(context, c.m25120b());
        }
    }

    public static void m24481a(Context context, String str, boolean z, CloudRequestHandler cloudRequestHandler, Bundle bundle) {
        if (!C5106n.m24591a(context, cloudRequestHandler)) {
            C5165e.m24906b("CloudAccountImpl", "checkHwIDPassword: context or cloudRequestHandler is null");
        } else if (cloudRequestHandler == null) {
            C5165e.m24906b("CloudAccountImpl", "cloudRequestHandler is null");
        } else if (TextUtils.isEmpty(str)) {
            cloudRequestHandler.onError(new ErrorStatus(12, "the param is invalid"));
            C5165e.m24906b("CloudAccountImpl", "userId is empty");
        } else if (bundle == null) {
            cloudRequestHandler.onError(new ErrorStatus(12, "the param is invalid"));
            C5165e.m24906b("CloudAccountImpl", "bundle is null");
        } else if (!C5166b.m24955h(context)) {
            C5165e.m24906b("CloudAccountImpl", "can not use hwid");
            cloudRequestHandler.onError(new ErrorStatus(33, "hwid is not exit"));
        } else if (C5106n.m24593b(context)) {
            String str2 = "";
            C5165e.m24906b("CloudAccountImpl", "checkHwIDPassword");
            CloudAccount b = C5088d.m24491b(context, str);
            if (b == null) {
                str2 = bundle.getString("accountType");
                C5165e.m24906b("CloudAccountImpl", "get accountType from bundle");
                if (TextUtils.isEmpty(str2)) {
                    cloudRequestHandler.onError(new ErrorStatus(12, "the param is invalid"));
                    C5165e.m24906b("CloudAccountImpl", "userId  actp is error");
                    return;
                }
            }
            str2 = b.getAccountType();
            Intent intent = new Intent();
            C5088d.m24495b(context, cloudRequestHandler);
            intent.putExtra("userId", str);
            intent.putExtra("accountType", str2);
            intent.putExtra("requestTokenType", context.getPackageName());
            intent.putExtra("startway", 3);
            intent.putExtra("use_finger", z);
            intent.putExtra("receive_package", C5166b.m24937c(context));
            intent.putExtras(bundle);
            if (bundle.containsKey("bindOperation")) {
                intent.putExtra(HwAccountConstants.ONLY_BIND_PHONE_FOR_THIRD, 1);
                intent.putExtra("startway", 8);
            }
            if (C5166b.m24934b(context, "com.huawei.hwid.FINGER_AUTH")) {
                intent.setAction("com.huawei.hwid.FINGER_AUTH");
                intent.setPackage("com.huawei.hwid");
            } else if (C5166b.m24927a(context, HwAccountConstants.ACTION_UID_AUTH, context.getPackageName())) {
                intent.setAction(HwAccountConstants.ACTION_UID_AUTH);
                intent.setPackage(context.getPackageName());
            } else {
                cloudRequestHandler.onError(new ErrorStatus(12, "check pwd activity is null"));
                C5165e.m24906b("CloudAccountImpl", "check pwd activity is null");
                return;
            }
            C5166b.m24920a(context, intent, 0);
        } else {
            C5165e.m24906b("CloudAccountImpl", "hwid is not exit");
            cloudRequestHandler.onError(new ErrorStatus(34, "hwid is not exit"));
        }
    }

    private static boolean m24487a(Context context, LoginHandler loginHandler) {
        if (loginHandler == null) {
            C5165e.m24906b("CloudAccountImpl", "loginHandler is null");
            return false;
        } else if (context != null) {
            return true;
        } else {
            C5165e.m24906b("CloudAccountImpl", "context is null");
            loginHandler.onError(new ErrorStatus(12, "context is null"));
            return false;
        }
    }

    private static boolean m24486a(Context context, IntentResultHandler intentResultHandler) {
        if (intentResultHandler == null) {
            C5165e.m24906b("CloudAccountImpl", "loginHandler is null");
            return false;
        } else if (context != null) {
            return true;
        } else {
            C5165e.m24906b("CloudAccountImpl", "context is null");
            intentResultHandler.onError(new ErrorStatus(12, "context is null"));
            return false;
        }
    }

    public static void m24475a(Context context, LoginHandler loginHandler, String str) {
        if (context == null) {
            C5165e.m24906b("CloudAccountImpl", "context is null");
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.hwid.opensdk.smsauth.success");
        intentFilter.addAction("com.huawei.hwid.opensdk.smsauth.quicklogin.SUCCESS");
        intentFilter.addAction("com.huawei.hwid.opensdk.smsauth.quicklogin.fail");
        intentFilter.addAction("com.huawei.hwid.opensdk.switch.other");
        if (f18353d.containsKey("OpenLoginBroadcastReceiver")) {
            C5088d.m24508e(context, "OpenLoginBroadcastReceiver");
        }
        BroadcastReceiver c5105m = new C5105m(context, loginHandler, str);
        try {
            context.registerReceiver(c5105m, intentFilter);
            C5088d.m24468a(c5105m, "OpenLoginBroadcastReceiver");
        } catch (Exception e) {
            C5165e.m24906b("CloudAccountImpl", "BroadcastReceiver components are not allowed to register to receive intents");
        }
    }

    public static void m24471a(Context context, Bundle bundle) {
        if (context == null || bundle == null || f18353d == null) {
            C5165e.m24906b("CloudAccountImpl", "context, bundle or broadcast is null, can't remove broadcast");
            return;
        }
        boolean z = bundle.getBoolean("LoginBroadcastReceiver", false);
        boolean z2 = bundle.getBoolean("LogoutBroadcastReceiver", false);
        boolean z3 = bundle.getBoolean("FingerBroadcastReceiver", false);
        boolean z4 = bundle.getBoolean("OpenLoginBroadcastReceiver", false);
        boolean z5 = bundle.getBoolean("BindSafePhoneBroadcastReceiver", false);
        if (z) {
            C5088d.m24508e(context, "LoginBroadcastReceiver");
        }
        if (z2) {
            C5088d.m24508e(context, "LogoutBroadcastReceiver");
        }
        if (z3) {
            C5088d.m24508e(context, "FingerBroadcastReceiver");
        }
        if (z4) {
            C5088d.m24508e(context, "OpenLoginBroadcastReceiver");
        }
        if (z5) {
            C5088d.m24508e(context, "BindSafePhoneBroadcastReceiver");
        }
    }

    private static synchronized boolean m24508e(Context context, String str) {
        boolean z;
        Exception e;
        synchronized (C5088d.class) {
            ArrayList arrayList = (ArrayList) f18353d.get(str);
            if (arrayList == null || arrayList.isEmpty()) {
                z = false;
            } else {
                Collection arrayList2 = new ArrayList();
                Iterator it = arrayList.iterator();
                boolean z2 = false;
                while (it.hasNext()) {
                    boolean z3;
                    BroadcastReceiver broadcastReceiver = (BroadcastReceiver) it.next();
                    try {
                        context.unregisterReceiver(broadcastReceiver);
                        arrayList2.add(broadcastReceiver);
                        z3 = true;
                        try {
                            C5165e.m24906b("CloudAccountImpl", "remove " + str + " success!");
                        } catch (Exception e2) {
                            e = e2;
                        }
                    } catch (Exception e3) {
                        Exception exception = e3;
                        z3 = z2;
                        e = exception;
                        C5165e.m24908c("CloudAccountImpl", e.getMessage());
                        z2 = z3;
                    }
                    z2 = z3;
                }
                if (!arrayList2.isEmpty()) {
                    arrayList.removeAll(arrayList2);
                }
                z = z2;
            }
        }
        return z;
    }

    public static synchronized void m24468a(BroadcastReceiver broadcastReceiver, String str) {
        synchronized (C5088d.class) {
            ArrayList arrayList = (ArrayList) f18353d.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(broadcastReceiver);
            f18353d.put(str, arrayList);
        }
    }

    public static void m24497b(Context context, String str, String str2, String str3, String str4, CloudRequestHandler cloudRequestHandler, Bundle bundle) {
        int i = 7;
        if (!C5106n.m24591a(context, cloudRequestHandler)) {
            C5165e.m24906b("CloudAccountImpl", "checkPasswordByUserId: context or cloudRequestHandler is null");
        } else if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            cloudRequestHandler.onError(new ErrorStatus(12, "the param is invalid"));
            C5165e.m24906b("CloudAccountImpl", "userId or password is empty");
        } else if (TextUtils.isEmpty(str) || !str.equals(context.getPackageName())) {
            cloudRequestHandler.onError(new ErrorStatus(12, "the param is invalid"));
            C5165e.m24906b("CloudAccountImpl", "tokenType is empty or not equals");
        } else if (C5166b.m24947e(str4)) {
            cloudRequestHandler.onError(new ErrorStatus(26, "third account is not allowed to verify password"));
            C5165e.m24906b("CloudAccountImpl", "third account is not allowed to verify password");
        } else if (!C5166b.m24924a(context)) {
            cloudRequestHandler.onError(new ErrorStatus(5, context.getString(C5180k.m25027a(context, "CS_no_network_content"))));
            C5165e.m24912e("CloudAccountImpl", "error: have no network");
        } else if (!C5166b.m24955h(context)) {
            C5165e.m24906b("CloudAccountImpl", "can not use hwid");
            cloudRequestHandler.onError(new ErrorStatus(33, "hwid is not exit"));
        } else if (C5106n.m24593b(context)) {
            String str5 = "";
            String str6 = "";
            if (bundle != null) {
                i = bundle.getInt(CloudAccount.KEY_REQCLIENTTYPE, 7);
                str5 = bundle.getString("deviceId");
                str6 = bundle.getString("deviceType");
            }
            if (context.getPackageManager().checkPermission("com.huawei.android.permission.ANTITHEFT", str) != 0) {
                cloudRequestHandler.onError(new ErrorStatus(27, "permission is deny"));
                C5165e.m24906b("CloudAccountImpl", "permission is deny");
                return;
            }
            C5125a c5134e = new C5134e(context, str2, str, C5201e.m25305a(str3), "0", i, str5, str6);
            c5134e.mo4627a(context, c5134e, null, cloudRequestHandler);
        } else {
            C5165e.m24906b("CloudAccountImpl", "hwid is not exit");
            cloudRequestHandler.onError(new ErrorStatus(34, "hwid is not exit"));
        }
    }

    public static String m24509f(Context context) {
        return C5079a.m24453c(context);
    }

    public static void m24472a(Context context, Bundle bundle, CloudRequestHandler cloudRequestHandler) {
        if (bundle != null) {
            if (!C5106n.m24591a(context, cloudRequestHandler)) {
                C5165e.m24906b("CloudAccountImpl", "initial: context or cloudRequestHandler is null");
            } else if (C5166b.m24924a(context)) {
                C5312b.m25692a(context);
                if (!C5106n.m24593b(context)) {
                    C5165e.m24906b("CloudAccountImpl", "hwid is not exit");
                    cloudRequestHandler.onError(new ErrorStatus(34, "hwid is not exit"));
                    bundle.putBoolean("updateApk", false);
                } else if (C5106n.m24589a(context, 20300000)) {
                    cloudRequestHandler.onError(new ErrorStatus(35, "hwid low update"));
                    C5165e.m24906b("CloudAccountImpl", "apk version is low");
                } else {
                    Bundle bundle2 = new Bundle();
                    String c = C5106n.m24594c(context);
                    bundle2.putString(CloudAccount.KEY_VERSION_NAME, c);
                    C5165e.m24906b("CloudAccountImpl", "versionName: " + C5203g.m25316a(c));
                    cloudRequestHandler.onFinish(bundle2);
                    return;
                }
                C5088d.m24507e(context);
                C5079a.m24452b(context, bundle);
            } else {
                cloudRequestHandler.onError(new ErrorStatus(5, context.getString(C5180k.m25027a(context, "CS_no_network_content"))));
                C5165e.m24906b("CloudAccountImpl", "error: have no network");
            }
        }
    }

    public static void m24494b(Context context, Bundle bundle, CloudRequestHandler cloudRequestHandler) {
        if (bundle == null) {
            C5165e.m24906b("CloudAccountImpl", "updateHwID bunlde is null");
        } else if (!C5106n.m24591a(context, cloudRequestHandler)) {
            C5165e.m24906b("CloudAccountImpl", "updateHwID context or cloudRequestHandler is null");
        } else if (!C5166b.m24924a(context)) {
            cloudRequestHandler.onError(new ErrorStatus(5, context.getString(C5180k.m25027a(context, "CS_no_network_content"))));
            C5165e.m24906b("CloudAccountImpl", "error: have no network");
        } else if (C5106n.m24593b(context)) {
            C5079a.m24452b(context, bundle);
        } else {
            C5165e.m24906b("CloudAccountImpl", "hwid is not exit");
            cloudRequestHandler.onError(new ErrorStatus(34, "hwid is not exit"));
            bundle.putBoolean("updateApk", false);
        }
    }

    public AlertDialog m24513a(Activity activity, String str, Bundle bundle, CloudRequestHandler cloudRequestHandler) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        CloudRequestHandler c5110o = new C5110o(activity, cloudRequestHandler, this.f18354a);
        bundle.putString("serviceToken", m24520b());
        bundle.putString("deviceId", this.f18354a.m25134i());
        bundle.putString("deviceType", this.f18354a.m25138k());
        bundle.putInt("siteId", this.f18354a.m25126e());
        this.f18355c = C5080a.m24455a(activity, str, bundle, c5110o);
        return this.f18355c;
    }

    public static Intent m24503d() {
        Intent intent = new Intent();
        intent.setPackage("com.huawei.hwid");
        intent.setAction(HwAccountConstants.ACTION_HWID_UNIFY_PASSWORD_VERIFY);
        return intent;
    }

    public void m24517a(Context context, String str, IntentResultHandler intentResultHandler) {
        if (!C5088d.m24486a(context, intentResultHandler)) {
            C5165e.m24906b("CloudAccountImpl", "getAccountsByType: context or handler is null");
        } else if (!C5166b.m24955h(context)) {
            C5165e.m24906b("CloudAccountImpl", "can not use hwid");
            intentResultHandler.onError(new ErrorStatus(33, "hwid is not exit"));
        } else if (!C5106n.m24593b(context)) {
            C5165e.m24906b("CloudAccountImpl", "hwid is not exit");
            intentResultHandler.onError(new ErrorStatus(34, "hwid is not exit"));
        } else if (m24510f(context, str)) {
            C5165e.m24906b("CloudAccountImpl", "hwid version is low");
            intentResultHandler.onError(new ErrorStatus(35, "hwid is low version"));
        } else if (this.f18354a == null) {
            C5165e.m24906b("CloudAccountImpl", "hwid is not login");
            intentResultHandler.onError(new ErrorStatus(31, "hwid is not login"));
        } else {
            String d = this.f18354a.m25124d();
            if (TextUtils.isEmpty(d)) {
                C5165e.m24906b("CloudAccountImpl", "hwid is not login");
                intentResultHandler.onError(new ErrorStatus(31, "hwid is not login"));
                return;
            }
            C5079a.m24448a(context, str, d, intentResultHandler);
        }
    }

    private boolean m24510f(Context context, String str) {
        if (HwAccountConstants.AUTH_APP_LIST_INTENT.equals(str)) {
            return C5106n.m24589a(context, 20504000);
        }
        if (HwAccountConstants.REMOTE_AUTH_INTENT.equals(str) || HwAccountConstants.HOME_COUNTRY_CHANGE_INTENT.equals(str)) {
            return C5106n.m24589a(context, 20502000);
        }
        if (C5106n.m24589a(context, 20503000)) {
            return true;
        }
        return false;
    }

    public void m24523c(Context context, CloudRequestHandler cloudRequestHandler) {
        if (!C5106n.m24591a(context, cloudRequestHandler)) {
            C5165e.m24906b("CloudAccountImpl", "getUserInfo: context or cloudRequestHandler is null");
        } else if (!C5166b.m24955h(context)) {
            C5165e.m24906b("CloudAccountImpl", "can not use hwid");
            cloudRequestHandler.onError(new ErrorStatus(33, "hwid is not exit"));
        } else if (!C5106n.m24593b(context)) {
            C5165e.m24906b("CloudAccountImpl", "hwid is not exit");
            cloudRequestHandler.onError(new ErrorStatus(34, "hwid is not exit"));
        } else if (C5106n.m24589a(context, 20503000)) {
            C5165e.m24906b("CloudAccountImpl", "hwid version is low");
            cloudRequestHandler.onError(new ErrorStatus(35, "hwid is low version"));
        } else if (this.f18354a == null) {
            C5165e.m24906b("CloudAccountImpl", "hwid is not login");
            cloudRequestHandler.onError(new ErrorStatus(31, "hwid is not login"));
        } else {
            String d = this.f18354a.m25124d();
            if (TextUtils.isEmpty(d)) {
                C5165e.m24906b("CloudAccountImpl", "hwid is not login");
                cloudRequestHandler.onError(new ErrorStatus(31, "hwid is not login"));
                return;
            }
            C5079a.m24444a(context, d, cloudRequestHandler);
        }
    }

    public void m24515a(Context context, int i, IntentResultHandler intentResultHandler) {
        String str = "";
        if (i == 0) {
            str = HwAccountConstants.REAL_NAME_INFO_INTENT;
        } else if (1 == i) {
            str = HwAccountConstants.SIMPLE_IDENTY_VERIFY_INTENT;
        } else if (2 == i) {
            str = HwAccountConstants.IDENTY_CAM_VERIFY_INTENT;
        } else if (3 == i) {
            str = HwAccountConstants.BIND_CARD_VERIFY_INTENT;
        } else if (4 == i) {
            str = HwAccountConstants.BIND_SECURITY_MOBILE_VERIFY_INTENT;
        } else {
            C5165e.m24906b("CloudAccountImpl", "flag is invalid");
            return;
        }
        m24517a(context, str, intentResultHandler);
    }
}
