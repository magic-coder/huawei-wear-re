package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: GeneralSettingsActivity */
class ea implements OnItemClickListener {
    final /* synthetic */ GeneralSettingsActivity f6066a;

    ea(GeneralSettingsActivity generalSettingsActivity) {
        this.f6066a = generalSettingsActivity;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.f6066a.f5747p.size() > i && ((eu) this.f6066a.f5747p.get(i)).f6102e.equals("reset_factory_tag")) {
            C2538c.m12674b("KIDWATCH_GeneralSettingsActivity", "OnItemClick rest factory!!!!");
            C2538c.m12674b("KIDWATCH_GeneralSettingsActivity", "==ww== nItemClick rest factory index" + i);
            this.f6066a.m9408g();
        }
        if (this.f6066a.f5747p.size() > i && ((eu) this.f6066a.f5747p.get(i)).f6102e.equals("map_reset_tag")) {
            C2538c.m12674b("KIDWATCH_GeneralSettingsActivity", "OnItemClick rest map!!!!");
            C2538c.m12674b("KIDWATCH_GeneralSettingsActivity", "==ww== OnItemClick rest map mapChoiceIndex" + i);
            this.f6066a.f5755x = i;
            this.f6066a.m9419l();
        }
    }
}
