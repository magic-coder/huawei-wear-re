package com.huawei.ui.device.activity.onelevelmenu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.commonui.titlebar.CustomTitleBar;
import com.huawei.ui.device.e;
import com.huawei.ui.device.f;
import com.huawei.ui.device.p170a.af;
import com.huawei.ui.device.views.onelevelmenu.C2207a;
import java.util.ArrayList;

public class OneLevelMenuAddActivity extends BaseActivity {
    private String f7421a = "OneLevelMenuAddActivity";
    private Context f7422b;
    private ListView f7423c;
    private CustomTitleBar f7424d;
    private ArrayList<Integer> f7425e;
    private ArrayList<Integer> f7426f;
    private ArrayList<Integer> f7427g;
    private C2207a f7428h;
    private af f7429i;
    private LinearLayout f7430j;
    private LinearLayout f7431k;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(f.activity_one_level_add_menu_layout);
        m10860a();
        m10862b();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    private void m10860a() {
        this.f7422b = getApplicationContext();
        this.f7429i = af.m10306a();
        this.f7426f = getIntent().getIntegerArrayListExtra("intent_to_next_all_list");
        this.f7425e = getIntent().getIntegerArrayListExtra("intent_to_next_open_list");
        if (this.f7426f != null) {
            if (this.f7425e == null) {
                this.f7427g = this.f7426f;
                return;
            }
            C2538c.m12677c(this.f7421a, "===123===mAllItemTables" + this.f7426f);
            C2538c.m12677c(this.f7421a, "===123===mMenuItemTables" + this.f7425e);
            this.f7427g = af.m10306a().m10309a(this.f7425e, this.f7426f);
            C2538c.m12677c(this.f7421a, "mContactTables size = " + this.f7425e.size());
        }
    }

    private void m10862b() {
        this.f7424d = (CustomTitleBar) d.a(this, e.one_level_add_menu_titlebar);
        this.f7424d.setRightButtonOnClickListener(new C2105a(this));
        this.f7430j = (LinearLayout) d.a(this, e.one_level_add_menu_no_content_view);
        this.f7431k = (LinearLayout) d.a(this, e.one_level_add_menu_layout);
        this.f7423c = (ListView) d.a(this, e.one_level_add_menu_listview);
        if (this.f7427g == null || this.f7427g.size() <= 0) {
            m10861a(true);
            return;
        }
        m10861a(false);
        C2538c.m12677c(this.f7421a, "===123===123mDuplicateListItemTables" + this.f7427g);
        this.f7423c.setSelector(com.huawei.ui.device.d.device_settings_contact_listview_item_selector_black);
        this.f7428h = new C2207a(this.f7422b, this.f7427g);
        this.f7423c.setAdapter(this.f7428h);
        this.f7423c.setOnItemClickListener(new C2106b(this));
    }

    private void m10861a(boolean z) {
        if (z) {
            this.f7430j.setVisibility(0);
            this.f7431k.setVisibility(8);
            return;
        }
        this.f7430j.setVisibility(8);
        this.f7431k.setVisibility(0);
    }

    private void m10865c() {
        C2538c.m12674b(this.f7421a, "saveData() delete data before mContactTables = " + this.f7425e);
        if (!this.f7429i.m10311b()) {
            int size = this.f7427g.size();
            C2538c.m12677c(this.f7421a, "map=" + C2207a.m11332a());
            for (int i = size - 1; i >= 0; i--) {
                C2538c.m12677c(this.f7421a, "mContactTables i=" + i);
                if (!((Boolean) C2207a.m11332a().get(Integer.valueOf(i))).booleanValue()) {
                    C2538c.m12677c(this.f7421a, "getIsSelected i=" + i + " is selected!");
                    this.f7427g.remove(i);
                }
            }
            C2538c.m12677c(this.f7421a, "===123====saveData() delete data after mContactTables = " + this.f7427g);
            Intent intent = new Intent();
            intent.putIntegerArrayListExtra("intent_from_next_open_list", this.f7427g);
            C2538c.m12677c(this.f7421a, "===123====mMenuTables gotonext mMenuTables" + af.m10306a().m10309a(this.f7426f, this.f7427g));
            setResult(1, intent);
            finish();
        }
    }
}
