package com.huawei.ui.device.activity.heartrate;

import android.content.Intent;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.b.a;
import com.huawei.l.a.c;
import com.huawei.p190v.C2538c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: HeartRateSettingsActivity */
class C2092a implements OnCheckedChangeListener {
    final /* synthetic */ HeartRateSettingsActivity f7380a;

    C2092a(HeartRateSettingsActivity heartRateSettingsActivity) {
        this.f7380a = heartRateSettingsActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        C2538c.m12661a("03", 1, "HeartRateSettingsActivity", "Heart Rate Switch is onCheckedChanged isChecked = " + z);
        this.f7380a.f7378g.m10420a(z);
        Intent intent = new Intent();
        if (z) {
            this.f7380a.f7378g;
            intent.putExtra("status", "1");
        } else {
            this.f7380a.f7378g;
            intent.putExtra("status", "0");
        }
        this.f7380a.setResult(-1, intent);
        Map hashMap = new HashMap();
        hashMap.put("click", "1");
        if (z) {
            hashMap.put("status", "1");
        } else {
            hashMap.put("status", "0");
        }
        c.a().a(BaseApplication.m2632b(), a.cL.a(), hashMap, 0);
    }
}
