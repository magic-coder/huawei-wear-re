package com.tencent.tauth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.ui.main.stories.lightcloud.constants.JoinConstants;
import com.tencent.connect.common.AssistActivity;
import com.tencent.connect.common.C6245a;
import com.tencent.connect.p193b.C6282t;
import com.tencent.connect.p193b.C6283u;
import com.tencent.open.p532d.C6406s;
import com.tencent.open.p532d.C6407t;
import com.tencent.open.p532d.C6412y;
import com.tencent.open.p541a.C6367n;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class AuthActivity extends Activity {
    private static int f22554a = 0;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null) {
            Uri uri = null;
            try {
                uri = getIntent().getData();
            } catch (Exception e) {
                C6367n.m29112e("openSDK_LOG.AuthActivity", "-->onCreate, getIntent().getData() has exception! " + e.getMessage());
            }
            C6367n.m29107b("openSDK_LOG.AuthActivity", "-->onCreate, uri: " + uri);
            m29620a(uri);
        }
    }

    private void m29620a(Uri uri) {
        if (uri == null || uri.toString() == null || uri.toString().equals("")) {
            finish();
            return;
        }
        String uri2 = uri.toString();
        Bundle a = C6412y.m29236a(uri2.substring(uri2.indexOf("#") + 1));
        if (a == null) {
            finish();
            return;
        }
        String string = a.getString(JoinConstants.ACTION);
        C6367n.m29107b("openSDK_LOG.AuthActivity", "-->handleActionUri, action: " + string);
        if (string == null) {
            m29621a(a, uri2);
        } else if (string.equals("shareToQQ") || string.equals("shareToQzone") || string.equals("sendToMyComputer") || string.equals("shareToTroopBar")) {
            if (string.equals("shareToQzone") && C6406s.m29220a((Context) this, "com.tencent.mobileqq") != null && C6406s.m29225c(this, "5.2.0") < 0) {
                f22554a++;
                if (f22554a == 2) {
                    f22554a = 0;
                    finish();
                    return;
                }
            }
            Intent intent = new Intent(this, AssistActivity.class);
            intent.putExtras(a);
            intent.setFlags(603979776);
            AssistActivity.f21864c = true;
            startActivity(intent);
            finish();
        } else if (string.equals("addToQQFavorites")) {
            Intent intent2 = getIntent();
            intent2.putExtras(a);
            intent2.putExtra("key_action", "action_share");
            r0 = C6407t.m29226a(string);
            if (r0 != null) {
                C6245a.m28704a(intent2, (C6252b) r0);
            }
            finish();
        } else if (string.equals("sharePrize")) {
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
            r0 = "";
            try {
                r0 = C6412y.m29260d(a.getString("response")).getString("activityid");
            } catch (Exception e) {
                C6367n.m29112e("openSDK_LOG.AuthActivity", "sharePrize parseJson has exception.");
            }
            if (!TextUtils.isEmpty(r0)) {
                launchIntentForPackage.putExtra("sharePrize", true);
                a = new Bundle();
                a.putString("activityid", r0);
                launchIntentForPackage.putExtras(a);
            }
            startActivity(launchIntentForPackage);
            finish();
        } else {
            m29621a(a, uri2);
        }
    }

    private void m29621a(Bundle bundle, String str) {
        if (bundle == null || str == null) {
            finish();
            return;
        }
        C6282t a = C6282t.m28838a();
        String string = bundle.getString("serial");
        C6283u a2 = a.m28841a(string);
        if (a2 != null) {
            if (str.indexOf("://cancel") != -1) {
                a2.f21854a.mo5286a();
                a2.f21855b.dismiss();
            } else {
                String string2 = bundle.getString("access_token");
                if (string2 != null) {
                    bundle.putString("access_token", a.m28843a(string2, a2.f21856c));
                }
                Object a3 = C6412y.m29244a(new JSONObject(), C6412y.m29241a(bundle));
                String optString = a3.optString("cb");
                if ("".equals(optString)) {
                    a2.f21854a.mo5288a(a3);
                    a2.f21855b.dismiss();
                } else {
                    a2.f21855b.m28832a(optString, a3.toString());
                }
            }
            a.m28844b(string);
        }
        finish();
    }
}
