package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: PoiListActivity */
class fr implements OnItemClickListener {
    final /* synthetic */ PoiListActivity f6132a;

    fr(PoiListActivity poiListActivity) {
        this.f6132a = poiListActivity;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C2538c.m12674b("PoiListActivity", "===================onItemClick: position ", i + "");
        Intent intent = new Intent();
        intent.putExtra("menu_elec_selected_position", i);
        this.f6132a.setResult(0, intent);
        this.f6132a.finish();
    }
}
