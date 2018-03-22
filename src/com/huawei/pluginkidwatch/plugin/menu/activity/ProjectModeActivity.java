package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.content.Context;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.ui.base.KidWatchBaseActivity;
import com.huawei.pluginkidwatch.common.ui.button.C1514c;
import com.huawei.pluginkidwatch.common.ui.button.SlipButtonView;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;

public class ProjectModeActivity extends KidWatchBaseActivity {
    private RelativeLayout f5820b;
    private RelativeLayout f5821c;
    private RelativeLayout f5822d;
    private RelativeLayout f5823e;
    private SlipButtonView f5824f;
    private SlipButtonView f5825g;
    private SlipButtonView f5826h;
    private SlipButtonView f5827i;
    private TextView f5828j;
    private TextView f5829k;
    private TextView f5830l;
    private C1514c f5831m = new fs(this);
    private C1514c f5832n = new ft(this);
    private C1514c f5833o = new fu(this);
    private C1514c f5834p = new fv(this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected void mo2517a() {
        requestWindowFeature(1);
        setContentView(h.activity_project_mode);
        this.f5828j = (TextView) findViewById(g.menu_tv_track_throwpoint);
        this.f5829k = (TextView) findViewById(g.menu_tv_track_triving);
        this.f5830l = (TextView) findViewById(g.menu_tv_track_play);
        this.f5820b = (RelativeLayout) findViewById(g.menu_relstive_track_throwpoint);
        this.f5821c = (RelativeLayout) findViewById(g.menu_relstive_track_triving);
        this.f5822d = (RelativeLayout) findViewById(g.menu_relstive_track_play);
        this.f5823e = (RelativeLayout) findViewById(g.menu_relstive_show_app_position);
        this.f5824f = (SlipButtonView) findViewById(g.menu_sbv_track_throwpoint_switch);
        this.f5825g = (SlipButtonView) findViewById(g.menu_sbv_track_triving_switch);
        this.f5826h = (SlipButtonView) findViewById(g.menu_sbv_track_play_switch);
        this.f5827i = (SlipButtonView) findViewById(g.menu_sbv_app_posion);
        this.f5824f.setOnChangedListener(this.f5831m);
        this.f5825g.setOnChangedListener(this.f5832n);
        this.f5826h.setOnChangedListener(this.f5833o);
        this.f5827i.setOnChangedListener(this.f5834p);
        if (C1497q.m6937a((Context) this, "is_track_throwpoint", true).booleanValue()) {
            this.f5824f.setChecked(true);
        } else {
            this.f5824f.setChecked(false);
        }
        if (C1497q.m6937a((Context) this, "is_track_triving", true).booleanValue()) {
            this.f5825g.setChecked(true);
        } else {
            this.f5825g.setChecked(false);
        }
        if (C1497q.m6937a((Context) this, "is_track_play", false).booleanValue()) {
            this.f5826h.setChecked(true);
        } else {
            this.f5826h.setChecked(false);
        }
        if (C1497q.m6944b(this, "main_map_is_show_app_position").booleanValue()) {
            this.f5827i.setChecked(true);
        } else {
            this.f5827i.setChecked(false);
        }
        if (C1462f.m6746j().equals("")) {
            this.f5828j.setEnabled(false);
            this.f5829k.setEnabled(false);
            this.f5830l.setEnabled(false);
            this.f5820b.setEnabled(false);
            this.f5821c.setEnabled(false);
            this.f5822d.setEnabled(false);
            this.f5823e.setEnabled(false);
        }
    }
}
