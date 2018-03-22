package com.huawei.ui.device.activity.weatherreport;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.TextView;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.device.e;
import com.huawei.ui.device.f;
import com.huawei.ui.device.i;
import com.huawei.ui.device.p170a.C1990r;

public class WeatherReportActivity extends BaseActivity {
    private C1990r f7761a;
    private Switch f7762b;
    private TextView f7763c;
    private boolean f7764d;
    private Context f7765e;
    private Handler f7766f = new C2182b(this, this);
    private OnCheckedChangeListener f7767g = new C2181a(this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(f.activity_settings_weatherreport);
        this.f7765e = this;
        m11175a();
        m11178b();
    }

    protected void onDestroy() {
        super.onDestroy();
        C2538c.m12674b("WeatherReportActivity", "onDestroy()");
        setResult(0, null);
        C0977d.m3575n(this.f7765e);
    }

    private void m11175a() {
        this.f7761a = C1990r.m10400a((Context) this);
        this.f7764d = this.f7761a.m10448l();
        C2538c.m12677c("WeatherReportActivity", "mWeatherReportFlag=" + this.f7764d);
    }

    private void m11178b() {
        this.f7763c = (TextView) d.a(this, e.weather_report_content);
        this.f7762b = (Switch) d.a(this, e.weather_report_switch_button);
        if (this.f7763c == null) {
            C2538c.m12680e("WeatherReportActivity", "ERROR widget get!");
            return;
        }
        this.f7762b.setChecked(this.f7764d);
        this.f7762b.setOnCheckedChangeListener(this.f7767g);
        m11179c();
    }

    private void m11179c() {
        if (this.f7764d) {
            this.f7763c.setText(i.IDS_weather_push_opened_tip);
        } else {
            this.f7763c.setText(i.IDS_weather_push_closed_tip);
        }
    }
}
