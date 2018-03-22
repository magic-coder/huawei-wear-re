package com.tencent.connect.common;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.huawei.hwdevicedfxmanager.constants.HWDeviceDFXConstants;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.tencent.connect.b.v;
import com.tencent.connect.p193b.C6284w;
import com.tencent.open.p532d.C6395h;
import com.tencent.open.p532d.C6406s;
import com.tencent.open.p532d.C6412y;
import com.tencent.open.p541a.C6367n;
import com.tencent.tauth.C6252b;
import com.tencent.tauth.C6494d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public abstract class C6245a {
    private static final String f21721a = C6245a.class.getName();
    protected static int f21722f = 1000;
    public static String f21723h = null;
    public static String f21724i = null;
    public static String f21725j = null;
    public static boolean f21726k = false;
    protected v f21727b;
    protected C6284w f21728c;
    protected List<C6285b> f21729d;
    protected Intent f21730e;
    protected C6252b f21731g;

    public C6245a(v vVar, C6284w c6284w) {
        this.f21729d = null;
        this.f21730e = null;
        this.f21731g = null;
        this.f21727b = vVar;
        this.f21728c = c6284w;
        this.f21729d = new ArrayList();
    }

    public C6245a(C6284w c6284w) {
        this(null, c6284w);
    }

    public void mo5290a(Activity activity, int i, int i2, Intent intent) {
        C6252b c6252b;
        for (C6285b c6285b : this.f21729d) {
            if (c6285b.f21867a == i) {
                C6252b c6252b2 = c6285b.f21868b;
                this.f21729d.remove(c6285b);
                c6252b = c6252b2;
                break;
            }
        }
        c6252b = null;
        if (c6252b == null) {
            C6367n.m29107b(f21721a, "BaseApi--onActivityResult-- listener == null");
            AssistActivity.m28853a(activity, intent);
            return;
        }
        if (i2 == -1) {
            C6245a.m28704a(intent, c6252b);
        } else {
            C6367n.m29107b("openSDK_LOG", "OpenUi, onActivityResult, Constants.ACTIVITY_CANCEL");
            c6252b.mo5286a();
        }
        C6367n.m29106b();
    }

    public static void m28704a(Intent intent, C6252b c6252b) {
        if (intent == null) {
            c6252b.mo5286a();
            return;
        }
        String stringExtra = intent.getStringExtra("key_action");
        String stringExtra2;
        if ("action_login".equals(stringExtra)) {
            int intExtra = intent.getIntExtra("key_error_code", 0);
            if (intExtra == 0) {
                stringExtra2 = intent.getStringExtra("key_response");
                if (stringExtra2 != null) {
                    try {
                        c6252b.mo5288a(C6412y.m29260d(stringExtra2));
                        return;
                    } catch (Throwable e) {
                        c6252b.mo5287a(new C6494d(-4, "服务器返回数据格式有误!", stringExtra2));
                        C6367n.m29108b("openSDK_LOG", "OpenUi, onActivityResult, json error", e);
                        return;
                    }
                }
                C6367n.m29107b("openSDK_LOG", "OpenUi, onActivityResult, onComplete");
                c6252b.mo5288a(new JSONObject());
                return;
            }
            C6367n.m29112e("openSDK_LOG", "OpenUi, onActivityResult, onError = " + intExtra + "");
            c6252b.mo5287a(new C6494d(intExtra, intent.getStringExtra("key_error_msg"), intent.getStringExtra("key_error_detail")));
        } else if ("action_share".equals(stringExtra)) {
            stringExtra = intent.getStringExtra("result");
            stringExtra2 = intent.getStringExtra("response");
            if ("cancel".equals(stringExtra)) {
                c6252b.mo5286a();
            } else if (HwAccountConstants.EXTRA_OPLOG_ERROR.equals(stringExtra)) {
                c6252b.mo5287a(new C6494d(-6, "unknown error", stringExtra2 + ""));
            } else if ("complete".equals(stringExtra)) {
                try {
                    if (stringExtra2 == null) {
                        stringExtra = "{\"ret\": 0}";
                    } else {
                        stringExtra = stringExtra2;
                    }
                    c6252b.mo5288a(new JSONObject(stringExtra));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    c6252b.mo5287a(new C6494d(-4, "json error", stringExtra2 + ""));
                }
            }
        }
    }

    Intent m28711b() {
        return this.f21730e;
    }

    protected Bundle m28713c() {
        Bundle bundle = new Bundle();
        bundle.putString("format", "json");
        bundle.putString("status_os", VERSION.RELEASE);
        bundle.putString("status_machine", Build.MODEL);
        bundle.putString("status_version", VERSION.SDK);
        bundle.putString("sdkv", "2.9.1");
        bundle.putString("sdkp", "a");
        if (this.f21728c != null && this.f21728c.m28848a()) {
            bundle.putString("access_token", this.f21728c.m28851c());
            bundle.putString("oauth_consumer_key", this.f21728c.m28849b());
            bundle.putString("openid", this.f21728c.m28852d());
            bundle.putString("appid_for_getting_config", this.f21728c.m28849b());
        }
        SharedPreferences sharedPreferences = C6395h.m29184a().getSharedPreferences("pfStore", 0);
        if (f21726k) {
            bundle.putString("pf", "desktop_m_qq-" + f21724i + "-" + "android" + "-" + f21723h + "-" + f21725j);
        } else {
            bundle.putString("pf", sharedPreferences.getString("pf", "openmobile_android"));
        }
        return bundle;
    }

    protected String m28705a(String str) {
        Bundle c = m28713c();
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            c.putString("need_version", str);
        }
        stringBuilder.append("http://openmobile.qq.com/oauth2.0/m_jump_by_version?");
        stringBuilder.append(C6412y.m29241a(c));
        return stringBuilder.toString();
    }

    protected Bundle m28714d() {
        Bundle bundle = new Bundle();
        bundle.putString("appid", this.f21728c.m28849b());
        if (this.f21728c.m28848a()) {
            bundle.putString("keystr", this.f21728c.m28851c());
            bundle.putString("keytype", "0x80");
        }
        String d = this.f21728c.m28852d();
        if (d != null) {
            bundle.putString("hopenid", d);
        }
        bundle.putString(LogBuilder.KEY_PLATFORM, "androidqz");
        SharedPreferences sharedPreferences = C6395h.m29184a().getSharedPreferences("pfStore", 0);
        if (f21726k) {
            bundle.putString("pf", "desktop_m_qq-" + f21724i + "-" + "android" + "-" + f21723h + "-" + f21725j);
        } else {
            bundle.putString("pf", sharedPreferences.getString("pf", "openmobile_android"));
            bundle.putString("pf", "openmobile_android");
        }
        bundle.putString("sdkv", "2.9.1");
        bundle.putString("sdkp", "a");
        return bundle;
    }

    private Intent m28703a(Activity activity) {
        Intent intent = new Intent(activity.getApplicationContext(), AssistActivity.class);
        intent.putExtra("is_login", true);
        return intent;
    }

    protected void m28707a(Activity activity, int i) {
        AssistActivity.m28855a(this);
        Intent intent = new Intent(activity.getApplicationContext(), AssistActivity.class);
        AssistActivity.f21863b = true;
        if (AssistActivity.f21862a) {
            intent.putExtra("is_qq_mobile_share", true);
            AssistActivity.f21862a = false;
        }
        activity.startActivityForResult(intent, i);
    }

    protected void m28709a(Activity activity, C6252b c6252b) {
        AssistActivity.m28855a(this);
        int i = f21722f;
        f21722f = i + 1;
        this.f21730e.putExtra("key_request_code", i);
        this.f21729d.add(new C6285b(this, i, c6252b));
        activity.startActivityForResult(m28703a(activity), HWDeviceDFXConstants.ERROR_CODE_GET_FILE_NAME_ERROR);
    }

    protected void m28710a(Fragment fragment, C6252b c6252b) {
        AssistActivity.m28855a(this);
        int i = f21722f;
        f21722f = i + 1;
        this.f21730e.putExtra("key_request_code", i);
        this.f21729d.add(new C6285b(this, i, c6252b));
        fragment.startActivityForResult(m28703a(fragment.getActivity()), HWDeviceDFXConstants.ERROR_CODE_GET_FILE_NAME_ERROR);
    }

    protected boolean m28715e() {
        if (this.f21730e != null) {
            return C6406s.m29221a(C6395h.m29184a(), this.f21730e);
        }
        return false;
    }

    protected Intent m28712b(String str) {
        Intent intent = new Intent();
        intent.setClassName("com.tencent.mobileqq", str);
        return C6406s.m29221a(C6395h.m29184a(), intent) ? intent : null;
    }

    public void mo5289a() {
    }
}
