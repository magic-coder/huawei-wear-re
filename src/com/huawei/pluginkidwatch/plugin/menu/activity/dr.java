package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.google.gson.Gson;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.FenceItem;
import com.huawei.pluginkidwatch.plugin.menu.p165a.ag;

/* compiled from: ElectronicFenceActivity */
class dr implements OnItemClickListener {
    final /* synthetic */ ElectronicFenceActivity f6049a;

    dr(ElectronicFenceActivity electronicFenceActivity) {
        this.f6049a = electronicFenceActivity;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C2538c.m12674b("ElectronicFenceActivity", "----OnItemClickListener==== position is:" + i);
        if (this.f6049a.f5718n == 0) {
            Object obj = (FenceItem) ((ListView) adapterView).getItemAtPosition(i);
            Gson gson = new Gson();
            Intent intent = new Intent();
            intent.setClass(this.f6049a.f5719o, AddFenceActivity.class);
            intent.putExtra("menu_edit_elec_fence_flag", true);
            intent.putExtra("menu_edit_elec_fence", gson.toJson(obj));
            C2538c.m12674b("ElectronicFenceActivity", "=============gson.toJson(item)" + gson.toJson(obj));
            this.f6049a.startActivity(intent);
        } else if (1 == this.f6049a.f5718n) {
            ag agVar = (ag) view.getTag();
            if (agVar.f5171d.ismIsSelected()) {
                agVar.f5170c.setChecked(false);
            } else {
                agVar.f5170c.setChecked(true);
            }
        }
    }
}
