package com.huawei.ui.device.activity.leftrighthand;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.device.e;
import com.huawei.ui.device.f;
import com.huawei.ui.device.p170a.C1990r;

public class LeftRightHandSettingsActivity extends BaseActivity implements OnClickListener {
    private C1990r f7381a;
    private Button f7382b;
    private Button f7383c;
    private Context f7384d;
    private boolean f7385e = false;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(f.activity_left_right_hand_setting);
        this.f7384d = this;
        this.f7382b = (Button) d.a(this, e.settings_left_btn);
        this.f7383c = (Button) d.a(this, e.settings_right_btn);
        this.f7382b.setOnClickListener(this);
        this.f7383c.setOnClickListener(this);
        this.f7381a = C1990r.m10400a(this.f7384d);
        if (1 == this.f7381a.m10410a(null)) {
            this.f7385e = true;
        }
        m10836b(this.f7385e);
    }

    protected void onResume() {
        super.onResume();
        C2538c.m12677c("LeftRightHandSettingsActivity", "onResume()");
    }

    public void onClick(View view) {
        int id = view.getId();
        if (e.settings_left_btn == id) {
            if (this.f7385e) {
                this.f7385e = false;
                m10836b(this.f7385e);
                m10835a(this.f7385e);
            }
        } else if (e.settings_right_btn == id && !this.f7385e) {
            this.f7385e = true;
            m10836b(this.f7385e);
            m10835a(this.f7385e);
        }
    }

    private void m10835a(boolean z) {
        this.f7381a.m10430b(z, new C2093a(this, z));
    }

    private void m10836b(boolean z) {
        if (z) {
            this.f7382b.setBackgroundResource(com.huawei.ui.device.d.setting_wear_state_off);
            this.f7383c.setBackgroundResource(com.huawei.ui.device.d.setting_wear_state_on);
            return;
        }
        this.f7382b.setBackgroundResource(com.huawei.ui.device.d.setting_wear_state_on);
        this.f7383c.setBackgroundResource(com.huawei.ui.device.d.setting_wear_state_off);
    }

    protected void onDestroy() {
        super.onDestroy();
        C2538c.m12677c("LeftRightHandSettingsActivity", "onDestroy()");
    }
}
