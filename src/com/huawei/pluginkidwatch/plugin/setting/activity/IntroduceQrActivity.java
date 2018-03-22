package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.widget.TextView;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.ui.base.KidWatchBaseActivity;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.j;

public class IntroduceQrActivity extends KidWatchBaseActivity {
    private String f6322b = "IntroduceQrActivity";
    private TextView f6323c;
    private TextView f6324d;

    protected void mo2517a() {
        requestWindowFeature(1);
        C2538c.m12674b(this.f6322b, "===BindbyQrActivity onCreate===:");
        setContentView(h.activity_introduce);
        this.f6323c = (TextView) findViewById(g.tv_bind_introduce_info1);
        this.f6324d = (TextView) findViewById(g.tv_bind_introduce_info2);
        TextView textView = this.f6323c;
        String string = getResources().getString(C1680l.IDS_plugin_kidwatch_settings_bind_introduce_info1);
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(1);
        objArr[1] = getResources().getQuantityString(j.IDS_plugin_kidwatch_common_second_unit, 3, new Object[]{Integer.valueOf(3)});
        textView.setText(String.format(string, objArr));
        this.f6324d.setText(String.format(getResources().getString(C1680l.IDS_plugin_kidwatch_settings_bind_introduce_info2), new Object[]{Integer.valueOf(2)}));
    }

    protected void onResume() {
        C2538c.m12674b(this.f6322b, "=============BindbyQrActivity onResume===:");
        super.onResume();
    }

    protected void onDestroy() {
        C2538c.m12677c(this.f6322b, "onDestroy()");
        C0977d.m3575n(this);
        super.onDestroy();
    }
}
