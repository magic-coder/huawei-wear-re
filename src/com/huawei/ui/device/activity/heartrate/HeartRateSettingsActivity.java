package com.huawei.ui.device.activity.heartrate;

import android.content.Context;
import android.os.Bundle;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.commonui.switchbutton.CustomSwitchButton;
import com.huawei.ui.device.e;
import com.huawei.ui.device.f;
import com.huawei.ui.device.i;
import com.huawei.ui.device.p170a.C1990r;

public class HeartRateSettingsActivity extends BaseActivity {
    private CustomSwitchButton f7372a;
    private TextView f7373b;
    private TextView f7374c;
    private TextView f7375d;
    private ImageView f7376e;
    private Context f7377f;
    private C1990r f7378g;
    private OnCheckedChangeListener f7379h = new C2092a(this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(f.activity_heart_rate_settings);
        this.f7377f = BaseApplication.m2632b();
        m10833a();
    }

    private void m10833a() {
        this.f7372a = (CustomSwitchButton) d.a(this, e.heart_rate_switch_button);
        this.f7373b = (TextView) d.a(this, e.heart_rate_content_tv);
        this.f7374c = (TextView) d.a(this, e.heart_rate_tip1_tv);
        this.f7375d = (TextView) d.a(this, e.heart_rate_tip2_tv);
        this.f7376e = (ImageView) d.a(this, e.settings_heart_rate_imageView);
        this.f7378g = C1990r.m10400a(this.f7377f);
        DeviceInfo k = this.f7378g.m10447k();
        if (k == null) {
            C2538c.m12677c("HeartRateSettingsActivity", "refresh dialog Support deviceInfo is null , return");
            return;
        }
        String str = "";
        String str2 = "";
        String str3 = "";
        if (3 == k.getProductType() || 10 == k.getProductType() || 8 == k.getProductType()) {
            str = getResources().getString(i.IDS_Settings_heart_rate_watch_content);
            str2 = getResources().getString(i.IDS_Settings_heart_rate_watch_tip);
            this.f7376e.setImageResource(com.huawei.ui.device.d.res_testheartrate_automaticaly_watch);
        } else if (13 == k.getProductType() || 15 == k.getProductType() || 12 == k.getProductType()) {
            str = getResources().getString(i.IDS_Settings_heart_rate_band_content);
            str2 = getResources().getString(i.IDS_Settings_heart_rate_band_tip);
            this.f7376e.setImageResource(com.huawei.ui.device.d.res_testheartrate_automaticaly_band);
        }
        String string = getResources().getString(i.IDS_Settings_heart_rate_watch_or_band_tip);
        this.f7373b.setText(String.format(str, new Object[]{Integer.valueOf(24)}));
        this.f7374c.setText(String.format(str2, new Object[]{Integer.valueOf(1)}));
        this.f7375d.setText(String.format(string, new Object[]{Integer.valueOf(2)}));
        boolean b = m10834b();
        C2538c.m12677c("HeartRateSettingsActivity", "initData() getHeartRateEnable " + b);
        this.f7372a.setChecked(b);
        this.f7378g.m10420a(b);
        this.f7372a.setOnCheckedChangeListener(this.f7379h);
    }

    private boolean m10834b() {
        C2538c.m12677c("HeartRateSettingsActivity", "getHeartRateEnable enter.");
        return this.f7378g.m10443g();
    }
}
