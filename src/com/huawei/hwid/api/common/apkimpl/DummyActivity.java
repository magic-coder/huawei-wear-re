package com.huawei.hwid.api.common.apkimpl;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.Window;
import com.huawei.cloudservice.CloudAccount;
import com.huawei.cloudservice.LoginHandler;
import com.huawei.hwid.api.common.C5088d;
import com.huawei.hwid.api.common.C5106n;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.core.datatype.HwAccount;
import com.huawei.hwid.core.encrypt.C5203g;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.hwid.core.p429a.C5117b;
import com.huawei.hwid.core.p429a.C5118c;
import com.huawei.hwid.core.p435d.C5166b;
import com.huawei.hwid.core.p435d.C5172c;
import com.huawei.hwid.core.p435d.C5180k;
import com.huawei.hwid.core.p435d.C5181l;
import com.huawei.hwid.core.p435d.C5182m;
import com.huawei.hwid.core.p435d.C5183n;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.huawei.hwid.p428c.C5115a;
import java.io.IOException;

public class DummyActivity extends Activity {
    private AccountManager f18319a = null;
    private String f18320b = "";
    private String f18321c = "";
    private String f18322d = "";
    private String f18323e = "";
    private String f18324f = "";
    private String f18325g = "";
    private boolean f18326h = false;
    private AlertDialog f18327i = null;
    private boolean f18328j = false;
    private Intent f18329k = null;
    private Bundle f18330l = null;
    private Bundle f18331m = null;
    private boolean f18332n;

    class C50741 implements OnClickListener {
        final /* synthetic */ DummyActivity f18314a;

        C50741(DummyActivity dummyActivity) {
            this.f18314a = dummyActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f18314a.f18328j = true;
            C5183n.m25069c(this.f18314a);
        }
    }

    class C50752 implements OnClickListener {
        final /* synthetic */ DummyActivity f18315a;

        C50752(DummyActivity dummyActivity) {
            this.f18315a = dummyActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            C5165e.m24910d("DummyActivity", "READ_PHONE_STATE PermissionName is null!");
            Parcelable errorStatus = new ErrorStatus(28, "READ_PHONE_STATE  Permission is not allowed");
            Intent intent = new Intent();
            intent.setPackage(this.f18315a.getPackageName());
            intent.putExtra(HwAccountConstants.EXTRA_IS_USE_SDK, false);
            intent.putExtra(HwAccountConstants.EXTRA_PARCE, errorStatus);
            C5172c.m24990b(this.f18315a, intent);
            this.f18315a.finish();
        }
    }

    class C50763 implements OnDismissListener {
        final /* synthetic */ DummyActivity f18316a;

        C50763(DummyActivity dummyActivity) {
            this.f18316a = dummyActivity;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            this.f18316a.f18327i = null;
        }
    }

    class C5077a implements AccountManagerCallback<Bundle> {
        final /* synthetic */ DummyActivity f18317a;

        public C5077a(DummyActivity dummyActivity) {
            this.f18317a = dummyActivity;
        }

        public void run(AccountManagerFuture<Bundle> accountManagerFuture) {
            Bundle bundle;
            int i;
            Bundle bundle2;
            String str;
            String str2 = "";
            C5165e.m24906b("AuthTokenCallBack", "AuthTokenCallBack::run==>");
            if (accountManagerFuture != null) {
                try {
                    bundle = (Bundle) accountManagerFuture.getResult();
                } catch (Throwable e) {
                    C5165e.m24911d("AuthTokenCallBack", "AuthTokenCallBack OperationCanceledException:" + e.getMessage(), e);
                    i = 3002;
                    bundle2 = null;
                    str = "getAuthTokenByFeatures : OperationCanceledException occur";
                } catch (Throwable e2) {
                    C5165e.m24911d("AuthTokenCallBack", "AuthTokenCallBack AuthenticatorException:" + e2.getMessage(), e2);
                    i = 3003;
                    bundle2 = null;
                    str = "getAuthTokenByFeatures : AuthenticatorException occur";
                } catch (Throwable e22) {
                    C5165e.m24911d("AuthTokenCallBack", "AuthTokenCallBack IOException:" + e22.getMessage(), e22);
                    i = 3004;
                    bundle2 = null;
                    str = "getAuthTokenByFeatures : IOException occur";
                }
            } else {
                bundle = null;
            }
            str = str2;
            bundle2 = bundle;
            i = 0;
            if ((i == 0 || TextUtils.isEmpty(str)) && bundle2 != null) {
                this.f18317a.f18322d = (String) bundle2.get("authAccount");
                this.f18317a.f18323e = (String) bundle2.get("accountType");
                this.f18317a.f18321c = (String) bundle2.get("authtoken");
                C5165e.m24906b("AuthTokenCallBack", "AuthTokenCallBack: accountName=" + C5203g.m25322d(this.f18317a.f18322d) + " accountType=" + this.f18317a.f18323e);
                this.f18317a.m24423a(this.f18317a.f18321c, this.f18317a.f18322d, i, bundle2);
                return;
            }
            Parcelable errorStatus;
            if (bundle2 == null) {
                C5165e.m24906b("AuthTokenCallBack", "AuthTokenCallBack:run bundle is null");
                errorStatus = new ErrorStatus(i, "bundle is null");
                C5165e.m24906b("AuthTokenCallBack", "error: " + errorStatus.toString());
            } else {
                C5165e.m24906b("AuthTokenCallBack", "AuthTokenCallBack:error:" + str);
                errorStatus = new ErrorStatus(i, str);
                C5165e.m24906b("AuthTokenCallBack", "error: " + errorStatus.toString());
            }
            Intent intent = new Intent();
            intent.setPackage(this.f18317a.getPackageName());
            intent.putExtra(HwAccountConstants.EXTRA_IS_USE_SDK, false);
            intent.putExtra(HwAccountConstants.EXTRA_PARCE, errorStatus);
            C5172c.m24990b(this.f18317a, intent);
            this.f18317a.finish();
        }
    }

    class C5078b implements AccountManagerCallback<Bundle> {
        final /* synthetic */ DummyActivity f18318a;

        private C5078b(DummyActivity dummyActivity) {
            this.f18318a = dummyActivity;
        }

        public void run(AccountManagerFuture<Bundle> accountManagerFuture) {
            if (accountManagerFuture != null) {
                try {
                    this.f18318a.f18331m = (Bundle) accountManagerFuture.getResult();
                    if (!this.f18318a.m24424a(this.f18318a.f18331m) || VERSION.SDK_INT <= 22) {
                        this.f18318a.m24430b(this.f18318a.f18331m);
                        this.f18318a.finish();
                        return;
                    }
                    this.f18318a.m24429b();
                } catch (OperationCanceledException e) {
                    this.f18318a.finish();
                    C5165e.m24910d("DummyActivity", "OperationCanceledException / " + e.getMessage());
                } catch (AuthenticatorException e2) {
                    this.f18318a.finish();
                    C5165e.m24910d("DummyActivity", "AuthenticatorException / " + e2.getMessage());
                } catch (IOException e3) {
                    this.f18318a.finish();
                    C5165e.m24910d("DummyActivity", "IOException / " + e3.getMessage());
                }
            }
        }
    }

    protected void onCreate(Bundle bundle) {
        C5165e.m24906b("DummyActivity", "onCreate");
        super.onCreate(bundle);
        this.f18329k = getIntent();
        if (this.f18329k == null) {
            C5165e.m24906b("DummyActivity", "we got a wrong intent");
            finish();
            return;
        }
        this.f18330l = this.f18329k.getBundleExtra(HwAccountConstants.EXTRA_BUNDLE);
        if (this.f18330l == null) {
            this.f18330l = new Bundle();
        }
        this.f18332n = this.f18330l.getBoolean("isTransNavigationBar", false);
        requestWindowFeature(1);
        Window window = getWindow();
        window.setFlags(HwAccountConstants.FLAG_TRANSLUCENT_STATUS, HwAccountConstants.FLAG_TRANSLUCENT_STATUS);
        if (VERSION.SDK_INT >= 19 && this.f18332n) {
            window.setFlags(HwAccountConstants.FLAG_TRANS_NAVIGATION_BAR, HwAccountConstants.FLAG_TRANS_NAVIGATION_BAR);
        }
        if (C5166b.m24923a((Activity) this, Boolean.valueOf(true))) {
            C5166b.m24919a((Activity) this, true);
        }
        this.f18319a = AccountManager.get(this);
        this.f18320b = this.f18329k.getStringExtra("requestTokenType");
        if (TextUtils.isEmpty(this.f18320b)) {
            C5165e.m24906b("DummyActivity", "params invalid: tokenType is null");
            finish();
            return;
        }
        LoginHandler a = C5106n.m24581a();
        if (a == null) {
            C5165e.m24906b("DummyActivity", "params invalid: loginHandler is null");
            finish();
        } else if (this.f18330l.getBoolean("IS_LOGIN_BY_ACTIVITY", false)) {
            m24437d();
        } else if (C5166b.m24934b(this, "com.huawei.hwid.GET_AUTH_TOKEN")) {
            C5088d.m24474a((Context) this, a, C5106n.m24592b());
            this.f18330l.putString("ServiceType", this.f18320b);
            m24434c();
        } else {
            Account[] accountsByType = this.f18319a.getAccountsByType("com.huawei.hwid");
            String[] strArr = new String[]{""};
            if (accountsByType == null || accountsByType.length <= 0) {
                this.f18319a.getAuthTokenByFeatures("com.huawei.hwid", "com.huawei.hwid", strArr, this, this.f18330l, this.f18330l, new C5077a(this), null);
                return;
            }
            this.f18330l.putBoolean("chooseAccount", true);
            this.f18319a.getAuthToken(accountsByType[0], getPackageName(), this.f18330l, this, new C5077a(this), null);
        }
    }

    @TargetApi(23)
    private void m24429b() {
        if (checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
            requestPermissions(new String[]{"android.permission.READ_PHONE_STATE"}, HwAccountConstants.MY_PERMISSIONS_REQUEST_READ_PHONE_STATE);
            return;
        }
        C5182m.m25058c((Context) this);
        C5182m.m25047a((Context) this);
        C5182m.m25061e(this);
        m24430b(this.f18331m);
        finish();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i != HwAccountConstants.MY_PERMISSIONS_REQUEST_READ_PHONE_STATE) {
            return;
        }
        if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
            m24441a(getString(C5180k.m25027a(this, "CS_read_phone_state_permission")));
            return;
        }
        C5182m.m25058c((Context) this);
        C5182m.m25047a((Context) this);
        C5182m.m25061e(this);
        m24430b(this.f18331m);
        finish();
    }

    public void m24441a(String str) {
        if (TextUtils.isEmpty(str)) {
            C5165e.m24910d("DummyActivity", "READ_PHONE_STATE PermissionName is null!");
            Parcelable errorStatus = new ErrorStatus(28, "READ_PHONE_STATE  Permission is not allowed");
            Intent intent = new Intent();
            intent.setPackage(getPackageName());
            intent.putExtra(HwAccountConstants.EXTRA_IS_USE_SDK, false);
            intent.putExtra(HwAccountConstants.EXTRA_PARCE, errorStatus);
            C5172c.m24990b(this, intent);
            finish();
            return;
        }
        this.f18327i = C5166b.m24944e(this, str).setNegativeButton(17039360, new C50752(this)).setPositiveButton(C5180k.m25027a(this, "CS_go_settings"), new C50741(this)).create();
        this.f18327i.setCancelable(false);
        this.f18327i.setCanceledOnTouchOutside(false);
        this.f18327i.setOnDismissListener(new C50763(this));
        if (!isFinishing()) {
            this.f18327i.show();
        }
    }

    public void m24440a() {
        if (this.f18327i != null) {
            this.f18327i.dismiss();
            this.f18327i = null;
        }
    }

    private void m24434c() {
        this.f18329k = new Intent("com.huawei.hwid.GET_AUTH_TOKEN");
        this.f18329k.putExtras(this.f18330l);
        this.f18329k.putExtra("isTransNavigationBar", this.f18332n);
        this.f18329k.setPackage("com.huawei.hwid");
        try {
            startActivityForResult(this.f18329k, 1);
        } catch (Exception e) {
            m24438e();
        }
    }

    private void m24437d() {
        Intent intent = new Intent(HwAccountConstants.ACTION_HWID_LOGIN_BY_ACTIVITY);
        intent.setPackage("com.huawei.hwid");
        intent.putExtra("isTransNavigationBar", this.f18332n);
        try {
            startActivityForResult(intent, 2);
        } catch (Exception e) {
            m24438e();
        }
    }

    private void m24438e() {
        C5165e.m24910d("DummyActivity", "SDK can not start intent for GETTOKEN");
        Parcelable errorStatus = new ErrorStatus(15, "Access is not allowed");
        Intent intent = new Intent();
        intent.setPackage(getPackageName());
        intent.putExtra(HwAccountConstants.EXTRA_IS_USE_SDK, false);
        intent.putExtra(HwAccountConstants.EXTRA_PARCE, errorStatus);
        C5172c.m24990b(this, intent);
        finish();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        C5165e.m24906b("DummyActivity", "onActivityResult::requestCode==>" + i);
        try {
            Thread.sleep(50);
        } catch (Throwable e) {
            C5165e.m24911d("DummyActivity", "InterruptedException / " + e.getMessage(), e);
        }
        String str;
        ErrorStatus a;
        Object obj;
        String str2;
        if (1 == i) {
            Bundle bundle;
            int i3;
            Parcelable errorStatus;
            Intent intent2;
            str = "";
            C5165e.m24906b("DummyActivity", "onActivityResult::resultCode==>" + i2);
            if (-1 == i2) {
                Bundle extras = intent.getExtras();
                a = m24419a(i, i2, intent, extras);
                int errorCode = a.getErrorCode();
                String errorReason = a.getErrorReason();
                bundle = extras;
                i3 = errorCode;
                obj = errorReason;
            } else if (i2 == 0) {
                errorStatus = new ErrorStatus(3002, "getAuthTokenByFeatures : OperationCanceledException occur");
                C5165e.m24906b("DummyActivity", "error: " + errorStatus.toString());
                intent2 = new Intent();
                intent2.setPackage(getPackageName());
                intent2.putExtra(HwAccountConstants.EXTRA_IS_USE_SDK, false);
                intent2.putExtra(HwAccountConstants.EXTRA_PARCE, errorStatus);
                C5172c.m24990b(this, intent2);
                finish();
                return;
            } else {
                C5165e.m24906b("DummyActivity", "OperationCanceledException");
                bundle = null;
                i3 = 3002;
                str2 = "getAuthTokenByFeatures : OperationCanceledException occur";
            }
            if ((i3 == 0 || TextUtils.isEmpty(obj)) && bundle != null) {
                m24423a(this.f18321c, this.f18322d, i3, bundle);
                return;
            }
            if (bundle == null) {
                C5165e.m24906b("DummyActivity", "AuthTokenCallBack:run bundle is null");
                errorStatus = new ErrorStatus(i3, "bundle is null");
                C5165e.m24906b("DummyActivity", "error: " + errorStatus.toString());
            } else {
                C5165e.m24906b("DummyActivity", "AuthTokenCallBack:error");
                errorStatus = new ErrorStatus(i3, obj);
                C5165e.m24906b("DummyActivity", "error: " + errorStatus.toString());
            }
            intent2 = new Intent();
            intent2.setPackage(getPackageName());
            intent2.putExtra(HwAccountConstants.EXTRA_IS_USE_SDK, false);
            intent2.putExtra(HwAccountConstants.EXTRA_PARCE, errorStatus);
            C5172c.m24990b(this, intent2);
            finish();
        } else if (2 != i) {
        } else {
            if (i2 != -1 || intent == null || intent.getExtras() == null) {
                C5165e.m24906b("DummyActivity", "loginResult#cancel");
                a = new ErrorStatus(3002, "getAuthTokenByFeatures : OperationCanceledException occur");
                C5165e.m24906b("DummyActivity", "error: " + a.toString());
                C5106n.m24581a().onError(a);
                finish();
                return;
            }
            C5165e.m24906b("DummyActivity", "loginResult#ok");
            HwAccount a2 = new HwAccount().m25116a(intent.getExtras());
            C5115a.m24641a((Context) this).m24644a(a2);
            CloudAccount[] a3 = C5088d.m24489a((Context) this);
            str = "";
            if (!TextUtils.isEmpty(a2.m25120b())) {
                str = a2.m25120b();
            }
            obj = a2.m25134i();
            if (TextUtils.isEmpty(obj) || "null".equalsIgnoreCase(obj)) {
                str2 = C5182m.m25054b((Context) this);
                if (str2 == null) {
                    str2 = "";
                }
                a2.m25133h(str2);
            }
            obj = a2.m25136j();
            if (TextUtils.isEmpty(obj) || "null".equalsIgnoreCase(obj)) {
                str2 = C5182m.m25061e(this);
                if (str2 == null) {
                    str2 = "";
                }
                a2.m25135i(str2);
            }
            obj = a2.m25138k();
            if (TextUtils.isEmpty(obj) || "null".equalsIgnoreCase(obj)) {
                a2.m25137j(C5182m.m25049a((Context) this, C5182m.m25054b((Context) this)));
            }
            C5106n.m24585a((Context) this, str);
            C5106n.m24581a().onLogin(a3, C5088d.m24463a(a3, str));
            C5117b b = C5106n.m24592b();
            if (b != null) {
                b.m24661a(C5166b.m24915a());
                C5118c.m24666a(b, (Context) this);
                C5106n.m24587a(null);
            } else {
                C5165e.m24906b("DummyActivity", "aidl mOpLogItem is null");
            }
            finish();
        }
    }

    private ErrorStatus m24426b(String str) {
        int i;
        String str2;
        String str3 = "";
        if ("AuthenticatorException".equals(str)) {
            i = 3003;
            str2 = "getAuthTokenByFeatures : AuthenticatorException occur";
            C5165e.m24906b("DummyActivity", "AuthenticatorException");
        } else if ("IOException".equals(str)) {
            i = 3004;
            str2 = "getAuthTokenByFeatures : IOException occur";
            C5165e.m24906b("DummyActivity", "IOException");
        } else if ("AccessException".equals(str)) {
            i = 15;
            str2 = "Access is not allowed";
            C5165e.m24906b("DummyActivity", "AccessError:appID is not allowed");
        } else if ("AreaNotAllowException".equals(str)) {
            i = 23;
            str2 = "AreaNotAllowError: Area is not allowed";
            C5165e.m24906b("DummyActivity", "AreaNotAllowError: Area is not allowed");
        } else if ("HwIDNotAllowException".equals(str)) {
            i = 24;
            str2 = "HwIDNotAllowError: HwID is not allowed";
            C5165e.m24906b("DummyActivity", "HwIDNotAllowError: HwID is not allowed");
        } else {
            i = 3002;
            str2 = "getAuthTokenByFeatures : OperationCanceledException occur";
            C5165e.m24906b("DummyActivity", "OperationCanceledException");
        }
        return new ErrorStatus(i, str2);
    }

    private ErrorStatus m24419a(int i, int i2, Intent intent, Bundle bundle) {
        if (C5106n.m24581a() == null) {
            C5183n.m25067a(this, getString(C5180k.m25027a(this, "CS_system_error_tip")), 1);
            C5165e.m24906b("DummyActivity", "callback is null, please login again!");
            finish();
        }
        String str = null;
        if (bundle != null) {
            str = (String) bundle.get("Exception");
        }
        if (str == null || !"".equals(str)) {
            return m24426b(str);
        }
        this.f18322d = (String) bundle.get("authAccount");
        this.f18323e = (String) bundle.get("accountType");
        this.f18321c = (String) bundle.get("authtoken");
        this.f18326h = bundle.getBoolean(HwAccountConstants.EXTRA_USE_SELF_ACCOUNT, false);
        if (bundle.containsKey("loginUserName")) {
            this.f18324f = bundle.getString("loginUserName");
        }
        if (bundle.containsKey("countryIsoCode")) {
            this.f18325g = bundle.getString("countryIsoCode");
        }
        return new ErrorStatus(0, "");
    }

    private void m24423a(String str, String str2, int i, Bundle bundle) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            Parcelable errorStatus = new ErrorStatus(i, "token or accountName is null");
            C5165e.m24906b("DummyActivity", "error: " + errorStatus.toString());
            Intent intent = new Intent();
            intent.setPackage(getPackageName());
            intent.putExtra(HwAccountConstants.EXTRA_IS_USE_SDK, false);
            intent.putExtra(HwAccountConstants.EXTRA_PARCE, errorStatus);
            C5172c.m24990b(this, intent);
            finish();
        } else if (!this.f18326h) {
            Account account = new Account(str2, "com.huawei.hwid");
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("getUserId", true);
            this.f18319a.updateCredentials(account, this.f18320b, bundle2, this, new C5078b(), null);
        } else if (bundle != null) {
            Bundle bundle3 = bundle.getBundle(HwAccountConstants.EXTRA_BUNDLE);
            if (bundle3 != null) {
                bundle3.putBundle(HwAccountConstants.EXTRA_ENVEXTRA, bundle.getBundle(HwAccountConstants.EXTRA_ENVEXTRA));
            }
            this.f18331m = bundle3;
            if (!m24424a(this.f18331m) || VERSION.SDK_INT <= 22) {
                m24430b(this.f18331m);
                finish();
                return;
            }
            m24429b();
        }
    }

    private boolean m24424a(Bundle bundle) {
        if (bundle == null) {
            C5165e.m24906b("DummyActivity", "bundle is null isNeedcheckPermission false");
            return false;
        }
        String str = (String) bundle.get("deviceId");
        String str2 = (String) bundle.get("deviceType");
        return TextUtils.isEmpty(str) || "null".equalsIgnoreCase(str) || TextUtils.isEmpty(str2) || "null".equalsIgnoreCase(str2);
    }

    public void onBackPressed() {
        try {
            super.onBackPressed();
        } catch (Throwable e) {
            C5165e.m24911d("DummyActivity", "catch Exception throw by FragmentManager!", e);
        }
    }

    private void m24430b(Bundle bundle) {
        if (bundle == null) {
            C5165e.m24906b("DummyActivity", "bundle is null");
            return;
        }
        String str = (String) bundle.get("userId");
        int i = bundle.getInt("siteId", 0);
        String str2 = (String) bundle.get("deviceId");
        String str3 = (String) bundle.get("subDeviceId");
        String str4 = (String) bundle.get("deviceType");
        String str5 = (String) bundle.get("accountType");
        String string = bundle.getString("STValidStatus");
        if (TextUtils.isEmpty(str2) || "null".equalsIgnoreCase(str2)) {
            str2 = C5182m.m25054b((Context) this);
            if (str2 == null) {
                str2 = "";
            }
        }
        if (TextUtils.isEmpty(str3) || "null".equalsIgnoreCase(str3)) {
            str3 = C5182m.m25061e(this);
            if (str3 == null) {
                str3 = "";
            }
        }
        if (TextUtils.isEmpty(str4) || "null".equalsIgnoreCase(str4)) {
            str4 = C5182m.m25049a((Context) this, C5182m.m25054b((Context) this));
        }
        C5165e.m24906b("DummyActivity", "sendSuccess is" + str4);
        if (C5166b.m24947e(str5) && !TextUtils.isEmpty(this.f18322d)) {
            this.f18322d = C5181l.m25041c(this.f18322d, str5);
        }
        if (this.f18322d != null && this.f18321c != null) {
            Intent intent = new Intent();
            if (this.f18326h || !C5166b.m24939c(this, "com.huawei.hwid.ICloudService")) {
                Parcelable hwAccount = new HwAccount();
                hwAccount.m25121b(this.f18322d);
                hwAccount.m25133h(str2);
                hwAccount.m25135i(str3);
                hwAccount.m25137j(str4);
                hwAccount.m25118a(i);
                hwAccount.m25129f(this.f18321c);
                hwAccount.m25125d(str);
                hwAccount.m25123c(this.f18320b);
                hwAccount.m25131g(str5);
                hwAccount.m25139k(this.f18324f);
                hwAccount.m25119a(this.f18325g);
                hwAccount.m25141l(string);
                intent.setPackage(getPackageName());
                intent.putExtra(HwAccountConstants.EXTRA_HWACCOUNT, hwAccount);
                intent.putExtra(HwAccountConstants.EXTRA_ENVEXTRA, bundle.getBundle(HwAccountConstants.EXTRA_ENVEXTRA));
            }
            intent.putExtra(HwAccountConstants.EXTRA_IS_USE_SDK, false);
            C5172c.m24989a(this, intent);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        C5165e.m24906b("DummyActivity", "onDestroy");
        Bundle bundle = new Bundle();
        bundle.putBoolean("LoginBroadcastReceiver", true);
        C5088d.m24471a((Context) this, bundle);
        m24440a();
    }

    protected void onResume() {
        super.onResume();
        C5165e.m24906b("DummyActivity", "onResume");
        if (this.f18328j) {
            this.f18328j = false;
            if (VERSION.SDK_INT <= 22) {
                return;
            }
            if (checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
                C5165e.m24910d("DummyActivity", "READ_PHONE_STATE PermissionName is null!");
                Parcelable errorStatus = new ErrorStatus(28, "READ_PHONE_STATE  Permission is not allowed");
                Intent intent = new Intent();
                intent.setPackage(getPackageName());
                intent.putExtra(HwAccountConstants.EXTRA_IS_USE_SDK, false);
                intent.putExtra(HwAccountConstants.EXTRA_PARCE, errorStatus);
                C5172c.m24990b(this, intent);
                finish();
                return;
            }
            C5182m.m25058c((Context) this);
            C5182m.m25047a((Context) this);
            C5182m.m25061e(this);
            m24430b(this.f18331m);
            finish();
        }
    }
}
