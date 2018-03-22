package com.tencent.connect.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.nfc.carrera.server.card.request.WipeAllCUPCardRequest;
import com.huawei.nfc.carrera.util.appdown.AppOpenOrDownHelper;
import com.huawei.ui.main.stories.lightcloud.constants.JoinConstants;
import com.tencent.open.p532d.C6407t;
import com.tencent.open.p532d.C6412y;
import com.tencent.open.p541a.C6367n;
import com.tencent.open.p542b.C6375d;
import com.tencent.tauth.C6252b;
import com.tencent.tauth.C6494d;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class AssistActivity extends Activity {
    public static boolean f21862a = false;
    public static boolean f21863b = false;
    public static boolean f21864c = false;
    private static C6245a f21865d;
    private C6245a f21866e;

    protected void onCreate(Bundle bundle) {
        int i = 0;
        super.onCreate(bundle);
        requestWindowFeature(1);
        C6367n.m29107b("AssistActivity", "AssistActivity--onCreate--");
        if (f21865d != null) {
            int i2;
            this.f21866e = f21865d;
            f21865d = null;
            Intent b = this.f21866e.m28711b();
            if (b == null) {
                i2 = 0;
            } else {
                i2 = b.getIntExtra("key_request_code", 0);
            }
            Bundle bundleExtra = getIntent().getBundleExtra("h5_share_data");
            if (bundle != null) {
                i = bundle.getBoolean("RESTART_FLAG");
            }
            if (i != 0) {
                return;
            }
            if (bundleExtra == null) {
                startActivityForResult(b, i2);
            } else {
                m28854a(bundleExtra);
            }
        }
    }

    protected void onStart() {
        C6367n.m29107b("AssistActivity", "-->onStart");
        super.onStart();
    }

    protected void onResume() {
        C6367n.m29107b("AssistActivity", "-->onResume");
        super.onResume();
        Intent intent = getIntent();
        if (!intent.getBooleanExtra("is_login", false)) {
            if (!intent.getBooleanExtra("is_qq_mobile_share", false)) {
                if (!(f21863b || isFinishing())) {
                    finish();
                }
                f21863b = false;
            }
            if (f21864c) {
                f21864c = false;
            }
        }
    }

    protected void onPause() {
        C6367n.m29107b("AssistActivity", "-->onPause");
        super.onPause();
    }

    protected void onStop() {
        C6367n.m29107b("AssistActivity", "-->onStop");
        super.onStop();
    }

    protected void onDestroy() {
        C6367n.m29107b("AssistActivity", "-->onDestroy");
        super.onDestroy();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Object a = C6407t.m29226a(intent.getStringExtra(JoinConstants.ACTION));
        C6367n.m29107b("AssistActivity", "AssistActivity--onNewIntent--" + (a == null ? "mAPiObject = null" : "mAPiObject != null"));
        intent.putExtra("key_action", "action_share");
        if (a != null) {
            C6245a.m28704a(intent, (C6252b) a);
        } else {
            setResult(-1, intent);
        }
        if (!isFinishing()) {
            finish();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        C6367n.m29107b("AssistActivity", "AssistActivity--onSaveInstanceState--");
        bundle.putBoolean("RESTART_FLAG", true);
        super.onSaveInstanceState(bundle);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        C6367n.m29107b("AssistActivity", "AssistActivity--onActivityResult--" + i2 + " data=" + intent);
        C6367n.m29107b("AssistActivity", "--requestCode: " + i + " | resultCode: " + i2 + " | data: " + intent);
        super.onActivityResult(i, i2, intent);
        if (i != 0) {
            if (intent != null) {
                intent.putExtra("key_action", "action_login");
            }
            if (this.f21866e != null) {
                C6367n.m29107b("AssistActivity", "AssistActivity--onActivityResult-- mAPiObject != null");
                this.f21866e.mo5290a(this, i, i2, intent);
            } else {
                C6367n.m29107b("AssistActivity", "AssistActivity--onActivityResult-- mAPiObject == null");
                m28853a(this, intent);
            }
            finish();
        } else if (!isFinishing()) {
            finish();
        }
    }

    public static void m28855a(C6245a c6245a) {
        f21865d = c6245a;
    }

    public static void m28853a(Activity activity, Intent intent) {
        if (activity != null) {
            if (intent == null) {
                activity.setResult(10101, intent);
                return;
            }
            try {
                Object stringExtra = intent.getStringExtra("key_response");
                C6367n.m29107b("AssistActivity", "AssistActivity--setResultDataForLogin-- " + stringExtra);
                if (!TextUtils.isEmpty(stringExtra)) {
                    JSONObject jSONObject = new JSONObject(stringExtra);
                    CharSequence optString = jSONObject.optString("openid");
                    CharSequence optString2 = jSONObject.optString("access_token");
                    if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                        activity.setResult(12345, intent);
                    } else {
                        activity.setResult(10101, intent);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void m28854a(Bundle bundle) {
        String string = bundle.getString("viaShareType");
        String string2 = bundle.getString("callbackAction");
        String string3 = bundle.getString("url");
        String string4 = bundle.getString("openId");
        String string5 = bundle.getString(AppOpenOrDownHelper.APP_ID_PARAM);
        String str = "";
        String str2 = "";
        if ("shareToQQ".equals(string2)) {
            str = "ANDROIDQQ.SHARETOQQ.XX";
            str2 = WipeAllCUPCardRequest.WIPE_ALL_CUP_CARD;
        } else if ("shareToQzone".equals(string2)) {
            str = "ANDROIDQQ.SHARETOQZ.XX";
            str2 = "11";
        }
        if (C6412y.m29249a((Context) this, string3)) {
            C6375d.m29144a().m29148a(string4, string5, str, str2, "3", "0", string, "0", "2", "0");
        } else {
            C6252b c6252b = (C6252b) C6407t.m29226a(string2);
            if (c6252b != null) {
                c6252b.mo5287a(new C6494d(-6, "打开浏览器失败!", null));
            }
            C6375d.m29144a().m29148a(string4, string5, str, str2, "3", "1", string, "0", "2", "0");
            finish();
        }
        getIntent().removeExtra("shareH5");
    }
}
