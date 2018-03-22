package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;

public class SelectPictrueActivity extends Activity implements OnClickListener {
    private ImageView f5835a;
    private ImageView f5836b;
    private ImageView f5837c;
    private ImageView f5838d;
    private ImageView f5839e;
    private ImageView f5840f;
    private ImageView f5841g;
    private int[] f5842h = new int[]{g.menu_img_sister_on, g.menu_img_mother_on, g.menu_img_gm_on, g.menu_img_father_on, g.menu_img_brother_on, g.menu_img_gf_on};

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(h.activity_contact_select_headcion_pictrue);
        m9500a();
    }

    private void m9500a() {
        this.f5835a = (ImageView) findViewById(g.menu_img_sister_on);
        this.f5836b = (ImageView) findViewById(g.menu_img_mother_on);
        this.f5837c = (ImageView) findViewById(g.menu_img_gm_on);
        this.f5839e = (ImageView) findViewById(g.menu_img_father_on);
        this.f5838d = (ImageView) findViewById(g.menu_img_brother_on);
        this.f5840f = (ImageView) findViewById(g.menu_img_gf_on);
        this.f5841g = (ImageView) findViewById(g.menu_pic_cancle);
        this.f5841g.setOnClickListener(new fw(this));
    }

    public void onClick(View view) {
        int id = view.getId();
        m9501b();
        C1497q.m6947b((Context) this, "selectedimg", id);
        if (id == g.menu_img_sister_on) {
            this.f5835a.setBackgroundResource(C1617f.kw_pic_relation_mid_selected);
        } else if (id == g.menu_img_mother_on) {
            this.f5836b.setBackgroundResource(C1617f.kw_pic_relation_mid_selected);
        } else if (id == g.menu_img_gm_on) {
            this.f5837c.setBackgroundResource(C1617f.kw_pic_relation_mid_selected);
        } else if (id == g.menu_img_brother_on) {
            this.f5838d.setBackgroundResource(C1617f.kw_pic_relation_mid_selected);
        } else if (id == g.menu_img_father_on) {
            this.f5839e.setBackgroundResource(C1617f.kw_pic_relation_mid_selected);
        } else if (id == g.menu_img_gf_on) {
            this.f5840f.setBackgroundResource(C1617f.kw_pic_relation_mid_selected);
        }
        C1497q.m6942a((Context) this, "isselectImg", Boolean.valueOf(true));
        finish();
    }

    @SuppressLint({"NewApi"})
    private void m9501b() {
        for (int findViewById : this.f5842h) {
            ((ImageView) findViewById(findViewById)).setBackground(null);
        }
    }
}
