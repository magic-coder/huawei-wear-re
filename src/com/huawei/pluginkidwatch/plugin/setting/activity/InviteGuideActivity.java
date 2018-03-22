package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1395k;
import com.huawei.pluginkidwatch.common.ui.base.KidWatchBaseActivity;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;

public class InviteGuideActivity extends KidWatchBaseActivity implements OnClickListener {
    private String f6325b = "InviteGuideActivity";
    private Context f6326c;
    private ImageView f6327d;
    private Button f6328e;
    private Button f6329f;

    protected void mo2517a() {
        requestWindowFeature(1);
        C2538c.m12674b(this.f6325b, "==================initView==:");
        setContentView(h.activity_guide_invite);
        this.f6326c = this;
        this.f6327d = (ImageView) findViewById(g.guide_iv_sex_info);
        this.f6328e = (Button) findViewById(g.guide_btn_invite_later);
        this.f6329f = (Button) findViewById(g.guide_btn_invite_now);
        this.f6328e.setOnClickListener(this);
        this.f6329f.setOnClickListener(this);
        C1395k a = C1392h.m6269a(this.f6326c, C1462f.m6744i(), C1462f.m6746j());
        if (a != null) {
            if (1 == a.f3091k) {
                this.f6327d.setImageResource(C1617f.kw_img_invite2);
            } else {
                this.f6327d.setImageResource(C1617f.kw_img_invite);
            }
        }
        C1497q.m6942a(this.f6326c, "sharedpreferences_new_device_bind", Boolean.valueOf(true));
    }

    protected void onResume() {
        C2538c.m12674b(this.f6325b, "=============onResume===:");
        super.onResume();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (g.guide_btn_invite_later == id) {
            m9829d();
        } else if (g.guide_btn_invite_now == id) {
            m9830e();
        }
    }

    private void m9829d() {
        C2538c.m12674b(this.f6325b, "=============Enter gotoHomeActivity()===");
        Intent intent = new Intent();
        intent.setClassName(this.f6326c, "com.huawei.pluginkidwatch.home.HomeActivity");
        intent.addFlags(32768);
        intent.setPackage(this.f6326c.getPackageName());
        startActivity(intent);
        finish();
    }

    private void m9830e() {
        C2538c.m12674b(this.f6325b, "=============Enter gotoInviteManagerActivity()===");
        Intent intent = new Intent();
        intent.setClass(this.f6326c, InviteManagerActivity.class);
        intent.putExtra("in_guide", true);
        startActivity(intent);
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        C2538c.m12674b(this.f6325b, "=============Backkey is pressed,so go to HomeActivity.java");
        m9829d();
        return true;
    }
}
