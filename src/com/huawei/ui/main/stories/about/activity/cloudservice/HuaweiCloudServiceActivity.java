package com.huawei.ui.main.stories.about.activity.cloudservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.main.c;
import com.huawei.ui.main.e;
import com.huawei.ui.main.f;
import com.huawei.ui.main.g;
import com.huawei.ui.main.j;
import com.huawei.ui.main.stories.about.p179a.C2283e;

public class HuaweiCloudServiceActivity extends BaseActivity implements OnClickListener {
    private static final String f8337a = HuaweiCloudServiceActivity.class.getSimpleName();
    private Context f8338b;
    private Button f8339c;
    private TextView f8340d;
    private TextView f8341e;
    private LocalBroadcastManager f8342f;
    private C2283e f8343g;
    private String f8344h;
    private BroadcastReceiver f8345i = new C2294a(this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(g.activity_cloud_service);
        this.f8338b = this;
        this.f8340d = (TextView) d.a(this, f.cloud_service_status_text);
        this.f8341e = (TextView) d.a(this, f.cloud_service_warn_text);
        this.f8339c = (Button) d.a(this, f.cloud_service_switch_btn);
        this.f8339c.setOnClickListener(this);
        this.f8343g = new C2283e(this.f8338b);
        this.f8344h = this.f8343g.m11744a();
        m11803b(this.f8344h);
        m11801b();
    }

    public void onClick(View view) {
        if (view.getId() == f.cloud_service_switch_btn) {
            m11799a(this.f8344h);
        }
    }

    private void m11799a(String str) {
        C2538c.m12674b(f8337a, "switchCloudService() ");
        if (TextUtils.isEmpty(str) || !Boolean.valueOf(str).booleanValue()) {
            this.f8344h = "true";
        } else {
            this.f8344h = "false";
        }
        this.f8343g.m11745a(this.f8344h);
        this.f8343g.m11746b(this.f8344h);
        m11803b(this.f8344h);
    }

    private void m11801b() {
        IntentFilter intentFilter = new IntentFilter("com.huawei.bone.action.CLOUD_SWITCH_CHANGED");
        this.f8342f = LocalBroadcastManager.getInstance(this);
        this.f8342f.registerReceiver(this.f8345i, intentFilter);
    }

    private void m11803b(String str) {
        if (TextUtils.isEmpty(str) || !Boolean.valueOf(str).booleanValue()) {
            this.f8340d.setText(j.IDS_settings_about_huawei_cloud_service_off);
            this.f8341e.setText(j.IDS_settings_about_huawei_cloud_service_off_warn);
            this.f8339c.setText(j.IDS_settings_about_huawei_cloud_service_action_turn_on);
            this.f8339c.setTextColor(getResources().getColor(c.settings_weather_report_button_turn_on_color));
            this.f8339c.setBackground(getResources().getDrawable(e.common_blue_btn_selector));
            return;
        }
        this.f8340d.setText(j.IDS_settings_about_huawei_cloud_service_on);
        this.f8341e.setText(j.IDS_settings_about_huawei_cloud_service_on_warn);
        this.f8339c.setText(j.IDS_settings_about_huawei_cloud_service_action_turn_off);
        this.f8339c.setTextColor(getResources().getColor(c.settings_weather_report_button_turn_off_color));
        this.f8339c.setBackground(getResources().getDrawable(e.common_gray_btn_selector));
    }

    public void onDestroy() {
        super.onDestroy();
        this.f8342f.unregisterReceiver(this.f8345i);
    }
}
