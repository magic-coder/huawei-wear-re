package com.huawei.ui.device.activity.goldmember;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.commonui.titlebar.CustomTitleBar;
import com.huawei.ui.device.e;
import com.huawei.ui.device.f;
import com.huawei.ui.device.i;

public class VIPUserRightsActivity extends BaseActivity {
    Context f7353a;
    private int f7354b = 0;
    private LinearLayout f7355c;
    private LinearLayout f7356d;
    private LinearLayout f7357e;
    private LinearLayout f7358f;
    private CustomTitleBar f7359g;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f7353a = this;
        this.f7354b = getIntent().getFlags();
        m10831a();
    }

    private void m10831a() {
        setContentView(f.acticity_vip_user_rights);
        this.f7359g = (CustomTitleBar) d.a(this, e.user_rights_title);
        this.f7355c = (LinearLayout) d.a(this, e.main_sns_member_Free_repair_content_layout);
        this.f7356d = (LinearLayout) d.a(this, e.main_sns_member_Wash_shell_content_layout);
        this.f7357e = (LinearLayout) d.a(this, e.main_sns_member_Whole_machine_protection_layout);
        this.f7358f = (LinearLayout) d.a(this, e.main_sns_member_Extended_warranty_layout);
        if (1 == this.f7354b) {
            this.f7359g.setTitleText(getResources().getString(i.IDS_main_sns_free_repair));
            this.f7355c.setVisibility(0);
            this.f7356d.setVisibility(8);
            this.f7357e.setVisibility(8);
            this.f7358f.setVisibility(8);
        } else if (2 == this.f7354b) {
            this.f7355c.setVisibility(8);
            this.f7356d.setVisibility(0);
            this.f7357e.setVisibility(8);
            this.f7358f.setVisibility(8);
            this.f7359g.setTitleText(getResources().getString(i.IDS_main_sns_wash_shell));
        } else if (3 == this.f7354b) {
            this.f7355c.setVisibility(8);
            this.f7356d.setVisibility(8);
            this.f7357e.setVisibility(0);
            this.f7358f.setVisibility(8);
            this.f7359g.setTitleText(getResources().getString(i.IDS_main_sns_whole_machine_protection));
        } else if (4 == this.f7354b) {
            this.f7358f.setVisibility(0);
            this.f7355c.setVisibility(8);
            this.f7357e.setVisibility(8);
            this.f7356d.setVisibility(8);
            this.f7359g.setTitleText(getResources().getString(i.IDS_main_sns_extended_warranty));
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
