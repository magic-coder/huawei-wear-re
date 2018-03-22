package com.huawei.ui.main.stories.downloadhihealth.activity;

import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hwcloudmodel.p060b.C0969i;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.main.f;
import com.huawei.ui.main.g;
import com.huawei.ui.main.j;

public class UpDateHiHealthActivity extends BaseActivity {
    OnClickListener f8556a = new C2377i(this);
    private RelativeLayout f8557b;
    private TextView f8558c;
    private TextView f8559d;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(g.activity_guide_update_hihealth21);
        this.f8557b = (RelativeLayout) findViewById(f.update_hihealth_rl);
        this.f8557b.setOnClickListener(this.f8556a);
        this.f8558c = (TextView) findViewById(f.update_hihealth_tv);
        this.f8559d = (TextView) findViewById(f.scroll_view_tv);
        this.f8558c.setText(getResources().getString(j.IDS_startup_next).toUpperCase());
        if (C0969i.m3482a(55)) {
            this.f8559d.setText(getResources().getString(j.IDS_health_start_info));
        } else {
            this.f8559d.setText(getResources().getString(j.IDS_health_start_info_other));
        }
    }
}
