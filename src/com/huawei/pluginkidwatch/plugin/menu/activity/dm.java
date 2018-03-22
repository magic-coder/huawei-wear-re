package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;

/* compiled from: ElectronicFenceActivity */
class dm implements OnClickListener {
    final /* synthetic */ ElectronicFenceActivity f6040a;

    dm(ElectronicFenceActivity electronicFenceActivity) {
        this.f6040a = electronicFenceActivity;
    }

    public void onClick(View view) {
        C2538c.m12680e("ElectronicFenceActivity", "=====mFenceList：" + this.f6040a.f5708d.size());
        if (this.f6040a.f5708d.size() < 5) {
            Intent intent = new Intent();
            intent.setClass(this.f6040a.f5719o, AddFenceActivity.class);
            this.f6040a.startActivity(intent);
            return;
        }
        C1483c.m6832c(this.f6040a.f5719o, this.f6040a.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_electronic_fence_limit_up));
    }
}
