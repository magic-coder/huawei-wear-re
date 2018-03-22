package com.huawei.ui.device.activity.core_sleep;

import android.content.Context;
import android.os.Bundle;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.dialog.ai;
import com.huawei.ui.commonui.dialog.ak;
import com.huawei.ui.commonui.switchbutton.CustomSwitchButton;
import com.huawei.ui.device.e;
import com.huawei.ui.device.f;
import com.huawei.ui.device.i;
import com.huawei.ui.device.p170a.C1990r;

public class CoreSleepSelectorActivity extends BaseActivity {
    private C1990r f7103a;
    private CustomSwitchButton f7104b;
    private Context f7105c;
    private ai f7106d = null;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(f.activity_core_sleep_selector);
        this.f7105c = this;
        this.f7104b = (CustomSwitchButton) findViewById(e.event_core_sleep_switch_btn);
        this.f7103a = C1990r.m10400a(this.f7105c);
        this.f7104b.setOnCheckedChangeListener(new C2027a(this));
    }

    protected void onResume() {
        super.onResume();
        C2538c.m12677c("CoreSleepSelectorActivity", "onResume()");
        if ((this.f7106d == null || !this.f7106d.isShowing()) && this.f7103a != null) {
            C2538c.m12677c("CoreSleepSelectorActivity", "mDeviceInteractors.getCoreSleepBtStatus():" + this.f7103a.m10444h());
            this.f7104b.setChecked(this.f7103a.m10444h());
        }
    }

    private void m10608a() {
        if (this.f7106d == null || !this.f7106d.isShowing()) {
            this.f7106d = new ak(this).a(i.IDS_Settings_truSleep_switch_dialog_tip).a(getResources().getString(i.IDS_common_enable_button).toUpperCase(), new C2029c(this)).b(i.IDS_settings_button_cancal, new C2028b(this)).a();
            this.f7106d.setCancelable(false);
            this.f7106d.show();
        }
    }

    private void m10611b() {
        if (this.f7106d != null) {
            this.f7106d.dismiss();
            this.f7106d = null;
        }
    }

    protected void onDestroy() {
        m10611b();
        super.onDestroy();
        C2538c.m12677c("CoreSleepSelectorActivity", "onDestroy()");
        finish();
    }
}
