package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.amap.api.services.core.PoiItem;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.ui.base.KidWatchBaseActivity;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.plugin.menu.p165a.au;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1901r;
import java.util.ArrayList;
import java.util.List;

public class PoiListActivity extends KidWatchBaseActivity {
    private final String f5814b = "PoiListActivity";
    private List<PoiItem> f5815c;
    private ListView f5816d;
    private ArrayList<PoiItem> f5817e = null;
    private au f5818f;
    private OnItemClickListener f5819g = new fr(this);

    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        setContentView(h.activity_poi);
        super.onCreate(bundle);
    }

    protected void mo2517a() {
        this.f5815c = C1901r.m9676a();
        this.f5818f = new au(this);
        this.f5816d = (ListView) findViewById(g.menu_elec_poi_list);
        this.f5816d.setAdapter(this.f5818f);
        this.f5816d.setOnItemClickListener(this.f5819g);
        if (this.f5815c != null) {
            for (PoiItem poiItem : this.f5815c) {
                C2538c.m12674b("PoiListActivity", "===================item: ", poiItem.toString());
            }
            m9497d();
        }
    }

    private void m9497d() {
        C2538c.m12674b("PoiListActivity", "=======Enter updateShowingFenceList");
        synchronized (this.f5815c) {
            this.f5817e = new ArrayList(this.f5815c);
            this.f5818f.m8874a(this.f5817e);
        }
    }

    public void onBackClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("menu_elec_selected_position", -1);
        setResult(0, intent);
        finish();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        C2538c.m12674b("PoiListActivity", "========Enter onKeyUp");
        if (i == 4) {
            Intent intent = new Intent();
            intent.putExtra("menu_elec_selected_position", -1);
            setResult(0, intent);
            finish();
        }
        return super.onKeyUp(i, keyEvent);
    }
}
