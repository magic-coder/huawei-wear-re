package com.tencent.connect.p193b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import com.huawei.nfc.carrera.logic.appletcardinfo.model.HciConfigInfo;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.sina.weibo.sdk.constant.WBConstants;
import com.tencent.connect.common.AssistActivity;
import com.tencent.connect.common.C6245a;
import com.tencent.connect.common.C6285b;
import com.tencent.open.p532d.C6395h;
import com.tencent.open.p532d.C6405r;
import com.tencent.open.p532d.C6406s;
import com.tencent.open.p532d.C6408u;
import com.tencent.open.p532d.C6412y;
import com.tencent.open.p541a.C6367n;
import com.tencent.open.p542b.C6375d;
import com.tencent.tauth.C6252b;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class C6263a extends C6245a {
    private C6252b f21788a;
    private String f21789l;
    private Activity f21790m;

    public C6263a(C6284w c6284w) {
        super(c6284w);
    }

    public int m28788a(Activity activity, String str, C6252b c6252b) {
        return m28789a(activity, str, c6252b, false, null);
    }

    public int m28789a(Activity activity, String str, C6252b c6252b, boolean z, Fragment fragment) {
        this.f21789l = str;
        this.f21790m = activity;
        this.f21788a = c6252b;
        if (m28779a(activity, fragment, z)) {
            C6367n.m29110c("openSDK_LOG", "OpenUi, showUi, return Constants.UI_ACTIVITY");
            C6375d.m29144a().m29147a(this.c.m28852d(), this.c.m28849b(), "2", "1", "5", "0", "0", "0");
            return 1;
        }
        C6375d.m29144a().m29147a(this.c.m28852d(), this.c.m28849b(), "2", "1", "5", "1", "0", "0");
        C6367n.m29111d("openSDK_LOG", "startActivity fail show dialog.");
        this.f21788a = new C6267e(this, this.f21788a);
        return m28777a(z, this.f21788a);
    }

    public void mo5289a() {
        this.f21790m = null;
        this.f21788a = null;
    }

    private int m28777a(boolean z, C6252b c6252b) {
        C6367n.m29110c("openSDK_LOG", "OpenUi, showDialog -- start");
        CookieSyncManager.createInstance(C6395h.m29184a());
        Bundle c = m28713c();
        if (z) {
            c.putString("isadd", "1");
        }
        c.putString("scope", this.f21789l);
        c.putString(WBConstants.AUTH_PARAMS_CLIENT_ID, this.c.m28849b());
        if (k) {
            c.putString("pf", "desktop_m_qq-" + i + "-" + "android" + "-" + h + "-" + j);
        } else {
            c.putString("pf", "openmobile_android");
        }
        String str = (System.currentTimeMillis() / 1000) + "";
        c.putString("sign", C6406s.m29223b(C6395h.m29184a(), str));
        c.putString(HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME, str);
        c.putString(WBConstants.AUTH_PARAMS_DISPLAY, "mobile");
        c.putString(WBConstants.AUTH_PARAMS_RESPONSE_TYPE, SNBConstant.FIELD_TOKEN);
        c.putString(WBConstants.AUTH_PARAMS_REDIRECT_URL, "auth://tauth.qq.com/");
        c.putString("cancel_display", "1");
        c.putString("switch", "1");
        c.putString("status_userip", C6412y.m29240a());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(C6405r.m29214a().m29215a(C6395h.m29184a(), "http://openmobile.qq.com/oauth2.0/m_authorize?"));
        stringBuilder.append(C6412y.m29241a(c));
        String stringBuilder2 = stringBuilder.toString();
        C6252b c6272j = new C6272j(this, C6395h.m29184a(), c6252b, true, false);
        C6367n.m29107b("openSDK_LOG", "OpenUi, showDialog TDialog");
        C6408u.m29230a(new C6264b(this, stringBuilder2, c6272j));
        C6367n.m29110c("openSDK_LOG", "OpenUi, showDialog -- end");
        return 2;
    }

    private boolean m28779a(Activity activity, Fragment fragment, boolean z) {
        C6367n.m29110c("openSDK_LOG", "startActionActivity() -- start");
        Intent b = m28712b("com.tencent.open.agent.AgentActivity");
        if (b != null) {
            Bundle c = m28713c();
            if (z) {
                c.putString("isadd", "1");
            }
            c.putString("scope", this.f21789l);
            c.putString(WBConstants.AUTH_PARAMS_CLIENT_ID, this.c.m28849b());
            if (k) {
                c.putString("pf", "desktop_m_qq-" + i + "-" + "android" + "-" + h + "-" + j);
            } else {
                c.putString("pf", "openmobile_android");
            }
            c.putString("need_pay", "1");
            c.putString("oauth_app_name", C6406s.m29219a(C6395h.m29184a()));
            b.putExtra("key_action", "action_login");
            b.putExtra("key_params", c);
            this.e = b;
            if (m28715e()) {
                this.f21788a = new C6267e(this, this.f21788a);
                if (fragment != null) {
                    C6367n.m29107b("AuthAgent", "startAssitActivity fragment");
                    m28710a(fragment, this.f21788a);
                } else {
                    C6367n.m29107b("AuthAgent", "startAssitActivity activity");
                    m28709a(activity, this.f21788a);
                }
                C6367n.m29110c("openSDK_LOG", "startActionActivity() -- end");
                C6375d.m29144a().m29145a(0, "LOGIN_CHECK_SDK", "1000", this.c.m28849b(), "", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "");
                return true;
            }
        }
        C6375d.m29144a().m29145a(1, "LOGIN_CHECK_SDK", "1000", this.c.m28849b(), "", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "startActionActivity fail");
        C6367n.m29110c("openSDK_LOG", "startActionActivity() -- end");
        return false;
    }

    public void mo5290a(Activity activity, int i, int i2, Intent intent) {
        C6252b c6252b;
        C6408u.m29230a(new C6266d(this));
        for (C6285b c6285b : this.d) {
            if (c6285b.f21867a == i) {
                C6252b c6252b2 = c6285b.f21868b;
                this.d.remove(c6285b);
                c6252b = c6252b2;
                break;
            }
        }
        c6252b = null;
        if (intent != null) {
            m28782c(intent.getStringExtra("key_response"));
            if (c6252b == null) {
                AssistActivity.m28853a(activity, intent);
                return;
            }
            if (i2 == -1) {
                C6245a.m28704a(intent, c6252b);
            } else {
                C6367n.m29107b("openSDK_LOG", "OpenUi, onActivityResult, Constants.ACTIVITY_CANCEL");
                c6252b.mo5286a();
            }
            mo5289a();
            C6367n.m29106b();
        } else if (c6252b != null) {
            c6252b.mo5286a();
        }
    }

    private void m28782c(String str) {
        try {
            JSONObject d = C6412y.m29260d(str);
            Object string = d.getString("access_token");
            Object string2 = d.getString("expires_in");
            Object string3 = d.getString("openid");
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
                this.c.m28847a(string, string2);
                this.c.m28850b(string3);
            }
        } catch (Exception e) {
        }
    }
}
