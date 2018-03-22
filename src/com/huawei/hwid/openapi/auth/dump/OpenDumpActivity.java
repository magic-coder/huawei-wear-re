package com.huawei.hwid.openapi.auth.dump;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.cloudservice.CloudAccount;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.openapi.out.OutReturn;
import com.huawei.hwid.openapi.p445e.C5248c;
import com.huawei.hwid.openapi.p445e.p446a.C5243e;
import java.util.List;

public class OpenDumpActivity extends Activity {
    private final int f18823a = 1;

    protected void onActivityResult(int i, int i2, Intent intent) {
        Object obj = null;
        super.onActivityResult(i, i2, intent);
        C5248c.m25451e("OpenDumpActivity", "onActivityResult::requestCode==>" + i);
        if (i == 1) {
            Bundle bundle;
            C5248c.m25451e("OpenDumpActivity", "onActivityResult::resultCode==>" + i2);
            if (i2 == -1) {
                Bundle extras = intent.getExtras();
                String str = extras != null ? (String) extras.get("Exception") : null;
                C5248c.m25445a("OpenDumpActivity", C5243e.m25420a(intent));
                if (str != null && "".equals(str)) {
                    str = (String) extras.get("authAccount");
                    String str2 = (String) extras.get("accountType");
                    String str3 = (String) extras.get("authtoken");
                    C5248c.m25451e("OpenDumpActivity", "AuthTokenCallBack: accountName=" + C5243e.m25423a(str) + " accountType=" + str2 + "authToken" + C5243e.m25423a(str3));
                    bundle = null;
                    obj = str3;
                } else if ("AuthenticatorException".equals(str)) {
                    bundle = OutReturn.creatReturn(101, "getAuthTokenByFeatures : AuthenticatorException occur");
                    C5248c.m25449c("OpenDumpActivity", "AuthTokenCallBack AuthenticatorException:");
                } else if ("IOException".equals(str) || "AccessException".equals(str)) {
                    bundle = OutReturn.creatReturn(100, "getAuthTokenByFeatures : " + str + " occur");
                    C5248c.m25449c("OpenDumpActivity", "AuthTokenCallBack IOException");
                } else {
                    bundle = OutReturn.creatReturn(2, "getAuthTokenByFeatures : OperationCanceledException occur");
                    C5248c.m25445a("OpenDumpActivity", "AuthTokenCallBack OperationCanceledException");
                }
            } else {
                bundle = OutReturn.creatReturn(2, "getAuthTokenByFeatures : OperationCanceledException occur");
                C5248c.m25445a("OpenDumpActivity", "AuthTokenCallBack OperationCanceledException");
            }
            if (bundle != null) {
                C5248c.m25445a("OpenDumpActivity", "get authToken ERROR");
                Intent intent2 = new Intent();
                intent2.setAction("com.huawei.cloudserive.getSTCancel");
                intent2.putExtra(HwAccountConstants.EXTRA_BUNDLE, bundle);
                sendBroadcast(intent2);
            } else if (!TextUtils.isEmpty(obj)) {
                C5248c.m25445a("OpenDumpActivity", "get authToken OK");
                Intent intent3 = new Intent();
                intent3.setAction("com.huawei.cloudserive.getSTSuccess");
                Bundle bundle2 = new Bundle();
                bundle2.putString("authToken", obj);
                intent3.putExtra(HwAccountConstants.EXTRA_BUNDLE, bundle2);
                sendBroadcast(intent3);
            }
            finish();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        Intent intent = getIntent();
        Bundle bundle2 = new Bundle();
        if (intent == null) {
            C5248c.m25451e("OpenDumpActivity", "we got a wrong intent");
            return;
        }
        String stringExtra = intent.getStringExtra(HwAccountConstants.TOKEN_TYPE);
        if (TextUtils.isEmpty(stringExtra)) {
            C5248c.m25447b("OpenDumpActivity", "params invalid: tokenType is null");
            return;
        }
        C5248c.m25451e("OpenDumpActivity", "TokenType =" + stringExtra);
        PackageManager packageManager = getPackageManager();
        if (packageManager != null) {
            List queryIntentActivities = packageManager.queryIntentActivities(new Intent("com.huawei.hwid.GET_AUTH_TOKEN"), 0);
            if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
                C5248c.m25451e("OpenDumpActivity", "did not have the Access to HwID");
                return;
            }
            C5248c.m25451e("OpenDumpActivity", "have the Access to HwID");
            bundle2.putString("ServiceType", stringExtra);
            boolean booleanExtra = intent.getBooleanExtra("chooseAccount", false);
            C5248c.m25447b("OpenDumpActivity", "chooseAccount =" + booleanExtra);
            bundle2.putBoolean("chooseAccount", booleanExtra);
            bundle2.putInt("scope", 1);
            boolean booleanExtra2 = intent.getBooleanExtra(CloudAccount.KEY_NEEDAUTH, false);
            C5248c.m25447b("OpenDumpActivity", "needAuth =" + booleanExtra2);
            bundle2.putBoolean(CloudAccount.KEY_NEEDAUTH, booleanExtra2);
            intent = new Intent("com.huawei.hwid.GET_AUTH_TOKEN");
            intent.putExtras(bundle2);
            startActivityForResult(intent, 1);
        }
    }
}
