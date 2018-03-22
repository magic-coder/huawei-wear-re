package com.huawei.ui.device.activity.core_sleep;

import android.content.Intent;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.huawei.hwcommonmodel.d.a;
import com.huawei.l.a.c;
import com.huawei.p190v.C2538c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: CoreSleepSelectorActivity */
class C2027a implements OnCheckedChangeListener {
    final /* synthetic */ CoreSleepSelectorActivity f7107a;

    C2027a(CoreSleepSelectorActivity coreSleepSelectorActivity) {
        this.f7107a = coreSleepSelectorActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        Object obj;
        C2538c.m12677c("CoreSleepSelectorActivity", "isChecked:" + z);
        String str = "";
        Intent intent = new Intent();
        Intent intent2 = new Intent();
        intent2.setAction("action_change_core_sleep_button");
        if (z) {
            obj = "1";
            this.f7107a.m10608a();
        } else {
            this.f7107a.f7103a;
            intent.putExtra("status", "0");
            this.f7107a.f7103a;
            intent2.putExtra("status", "0");
            obj = "0";
            a.b(this.f7107a.f7105c, intent2);
            this.f7107a.setResult(-1, intent);
        }
        Map hashMap = new HashMap();
        hashMap.put("click", "1");
        hashMap.put("status", obj);
        c.a().a(this.f7107a.f7105c, com.huawei.hwcommonmodel.b.a.C.a(), hashMap, 0);
        C2538c.m12677c("CoreSleepSelectorActivity", "BI save coreSleep click event finish, key = " + str);
    }
}
