package com.huawei.ui.main.stories.messagecenter.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.operation.a;
import com.huawei.p190v.C2538c;
import com.huawei.pluginmessagecenter.C1971j;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.webview.WebViewActivity;
import com.huawei.ui.main.stories.about.activity.AboutActivity;
import com.huawei.ui.main.stories.about.activity.cloudservice.HuaweiCloudServiceActivity;
import com.huawei.ui.main.stories.about.p179a.C2286h;
import com.huawei.ui.main.stories.account.interactor.WeChat;
import com.huawei.ui.main.stories.lightcloud.constants.JoinConstants;
import com.huawei.ui.main.stories.nps.activity.QuestionMainActivity;
import com.huawei.ui.main.stories.settings.activity.PersonalPrivacySettingsActivity;

public class DispatchSkipEventActivity extends BaseActivity {
    private String f8682a;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        String stringExtra = intent.getStringExtra("msgId");
        String stringExtra2 = intent.getStringExtra("detailUri");
        this.f8682a = intent.getStringExtra("OPEN_STYLE");
        if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2)) {
            finish();
            return;
        }
        C1971j.m10236a(getApplicationContext()).m10248a(stringExtra);
        C2538c.m12674b("DispatchSkipEventActivity", "onCreate detailUri===============" + stringExtra2 + "  msgId = " + stringExtra);
        m12136a(stringExtra2);
        finish();
    }

    private void m12136a(String str) {
        Uri parse = Uri.parse(str);
        if (parse != null) {
            String scheme = parse.getScheme();
            String host = parse.getHost();
            C2538c.m12677c("DispatchSkipEventActivity", "handleDetailUri scheme = " + scheme + "   host = " + host);
            if (scheme.equals("http") || scheme.equals("https")) {
                if (this.f8682a == null || !"BROWSER".equals(this.f8682a)) {
                    a.a(getApplicationContext()).a(str);
                    return;
                }
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            } else if ("messagecenter".equals(scheme) && !"kakaMessage".equals(host) && !"historyBestMessage".equals(host)) {
                if ("sportReport".equals(host)) {
                    try {
                        int parseInt = Integer.parseInt(parse.getQueryParameter("max_report_no"));
                        int parseInt2 = Integer.parseInt(parse.getQueryParameter("min_report_no"));
                        int parseInt3 = Integer.parseInt(parse.getQueryParameter("report_stype"));
                        C2538c.m12674b("DispatchSkipEventActivity", "handleDetailUri==>max-->" + parseInt + ":min-->" + parseInt2 + ":reportType-->" + parseInt3);
                    } catch (NumberFormatException e) {
                        C2538c.m12680e("DispatchSkipEventActivity", e.getMessage());
                    }
                } else if ("nps_question".equals(host)) {
                    r0 = new Intent();
                    r0.setClass(this, QuestionMainActivity.class);
                    startActivity(r0);
                } else if ("device_guide".equals(host)) {
                    C2286h a = C2286h.m11749a();
                    if (a != null) {
                        Intent intent = new Intent();
                        intent.setClass(this, WebViewActivity.class);
                        intent.putExtra("WebViewActivity.REQUEST_URL_KEY", a.m11754a((Context) this));
                        intent.putExtra("WebViewActivity.JUMP_MODE_KEY", 0);
                        startActivity(intent);
                    }
                } else if ("device_app_update".equals(host)) {
                    r0 = new Intent();
                    r0.setClass(this, AboutActivity.class);
                    startActivity(r0);
                } else if (!"device_app_update_health".equals(host)) {
                    if ("device_ota".equals(host)) {
                        r0 = new Intent();
                        r0.setClassName(this, "com.huawei.ui.device.activity.update.UpdateVersionActivity");
                        startActivity(r0);
                    } else if ("HuaweiCloudServiceActivity".equals(host)) {
                        r0 = new Intent();
                        r0.setClass(this, HuaweiCloudServiceActivity.class);
                        startActivity(r0);
                    } else if ("special_person_setting".equals(host)) {
                        r0 = new Intent();
                        r0.setClass(this, PersonalPrivacySettingsActivity.class);
                        startActivity(r0);
                    } else if ("nativeDevice".equals(host)) {
                        scheme = parse.getQueryParameter(JoinConstants.ACTION);
                        host = parse.getQueryParameter("arg1");
                        String queryParameter = parse.getQueryParameter("arg2");
                        Intent intent2 = new Intent();
                        Bundle bundle = new Bundle();
                        if (!(scheme == null || scheme.equals(""))) {
                            intent2.setAction(scheme);
                        }
                        if (!(host == null || host.equals(""))) {
                            bundle.putString("arg1", host);
                        }
                        if (!(queryParameter == null || queryParameter.equals(""))) {
                            bundle.putString("arg2", queryParameter);
                        }
                        if ("SWITCH_PLUGINDEVICE".equals(scheme)) {
                            C2538c.m12677c("DispatchSkipEventActivity", "goto device");
                            intent2.setPackage("com.huaei.health");
                            intent2.setClassName(WeChat.HEALTH_PACKAGE_NAME, "com.huawei.health.device.ui.DeviceMainActivity");
                            intent2.putExtras(bundle);
                            startActivity(intent2);
                        }
                    }
                }
            }
        }
    }
}
