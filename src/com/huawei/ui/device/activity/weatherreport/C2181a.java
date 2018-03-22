package com.huawei.ui.device.activity.weatherreport;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.b.a;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.l.a.c;
import com.huawei.p190v.C2538c;
import com.huawei.ui.device.i;
import java.util.HashMap;
import java.util.Map;

/* compiled from: WeatherReportActivity */
class C2181a implements OnCheckedChangeListener {
    final /* synthetic */ WeatherReportActivity f7768a;

    C2181a(WeatherReportActivity weatherReportActivity) {
        this.f7768a = weatherReportActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        boolean z2 = true;
        boolean e = C0977d.m3555e(this.f7768a.f7765e);
        C2538c.m12677c("WeatherReportActivity", "zhanglintao isChecked = " + z);
        if (e) {
            this.f7768a.f7764d = z;
            this.f7768a.f7762b.setEnabled(false);
            C2538c.m12677c("WeatherReportActivity", "isChecked = " + z);
            this.f7768a.m11179c();
            if (z) {
                this.f7768a.f7761a.m10449m();
            }
            this.f7768a.f7761a.m10429b(z);
            this.f7768a.f7766f.sendEmptyMessageDelayed(0, 300);
            Map hashMap = new HashMap();
            hashMap.put("click", "1");
            if (z) {
                hashMap.put("status", "1");
            } else {
                hashMap.put("status", "0");
            }
            c.a().a(BaseApplication.m2632b(), a.cD.a(), hashMap, 0);
            return;
        }
        com.huawei.ui.commonui.c.a.a(this.f7768a.f7765e, i.IDS_confirm_network_whether_connected);
        Switch b = this.f7768a.f7762b;
        if (z) {
            z2 = false;
        }
        b.setChecked(z2);
    }
}
