package com.huawei.ui.device.activity.weatherreport;

import android.os.Handler;
import android.os.Message;
import com.huawei.p190v.C2538c;
import java.lang.ref.WeakReference;

/* compiled from: WeatherReportActivity */
class C2182b extends Handler {
    WeakReference<WeatherReportActivity> f7769a;
    final /* synthetic */ WeatherReportActivity f7770b;

    C2182b(WeatherReportActivity weatherReportActivity, WeatherReportActivity weatherReportActivity2) {
        this.f7770b = weatherReportActivity;
        this.f7769a = new WeakReference(weatherReportActivity2);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (((WeatherReportActivity) this.f7769a.get()) != null) {
            removeMessages(0);
            this.f7770b.f7762b.setEnabled(true);
            C2538c.m12677c("WeatherReportActivity", "mHandler mWeatherReportFlag = " + this.f7770b.f7764d);
            this.f7770b.f7762b.setChecked(this.f7770b.f7764d);
        }
    }
}
