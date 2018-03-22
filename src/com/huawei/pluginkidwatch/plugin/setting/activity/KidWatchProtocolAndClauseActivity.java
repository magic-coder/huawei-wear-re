package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.ui.base.KidWatchBaseActivity;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;

public class KidWatchProtocolAndClauseActivity extends KidWatchBaseActivity {
    private Context f6361b;
    private TextView f6362c;
    private TextView f6363d;
    private TextView f6364e;
    private TextView f6365f;
    private TextView f6366g;
    private Button f6367h;
    private Button f6368i;

    protected void mo2517a() {
        C2538c.m12677c("KidWatchProtocolAndClauseActivity", "enter initView()");
        setContentView(h.activity_kidwatch_protocol_and_clause_activity);
        this.f6361b = this;
        this.f6362c = (TextView) findViewById(g.kidwatch_user_permission_txt2);
        this.f6363d = (TextView) findViewById(g.kidwatch_user_permission_txt3);
        this.f6364e = (TextView) findViewById(g.kidwatch_user_permission_txt4);
        this.f6365f = (TextView) findViewById(g.kidwatch_user_permission_txt5);
        this.f6366g = (TextView) findViewById(g.kidwatch_user_permission_txt6);
        CharSequence stringBuilder = new StringBuilder("- ");
        stringBuilder.append(this.f6361b.getResources().getString(C1680l.IDS_plugin_kidwatch_user_permission_msg2));
        this.f6362c.setText(stringBuilder);
        stringBuilder = new StringBuilder("- ");
        stringBuilder.append(this.f6361b.getResources().getString(C1680l.IDS_plugin_kidwatch_user_permission_msg3));
        this.f6363d.setText(stringBuilder);
        stringBuilder = new StringBuilder("- ");
        stringBuilder.append(this.f6361b.getResources().getString(C1680l.IDS_plugin_kidwatch_user_permission_msg4));
        this.f6364e.setText(stringBuilder);
        this.f6365f.setText(this.f6361b.getResources().getString(C1680l.IDS_plugin_kidwatch_user_permission_msg5));
        this.f6366g.setText(this.f6361b.getResources().getString(C1680l.IDS_plugin_kidwatch_user_permission_msg6));
        this.f6367h = (Button) findViewById(g.guide_btn_confirm);
        this.f6367h.setOnClickListener(new ak(this));
        this.f6368i = (Button) findViewById(g.guide_btn_back);
        this.f6368i.setOnClickListener(new al(this));
    }

    private void m9861d() {
        Intent intent = new Intent();
        intent.setPackage(this.f6361b.getPackageName());
        if (C1497q.m6937a(this.f6361b, "sharedpreferences_exist_phone_number", false).booleanValue()) {
            intent.setClass(this.f6361b, RelationSettingActivity.class);
        } else {
            intent.setClass(this.f6361b, SetPhoneNumActivity.class);
        }
        this.f6361b.startActivity(intent);
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        this.f6367h.setEnabled(true);
        super.onDestroy();
    }
}
