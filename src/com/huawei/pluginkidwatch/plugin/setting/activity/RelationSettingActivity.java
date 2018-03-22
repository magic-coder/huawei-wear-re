package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.ui.base.KidWatchBaseActivity;
import com.huawei.pluginkidwatch.common.ui.p150a.C1507h;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.m;
import java.util.regex.Pattern;

public class RelationSettingActivity extends KidWatchBaseActivity {
    private Handler f6420A = null;
    private Runnable f6421B = new bn(this);
    private OnClickListener f6422C = new bo(this);
    private TextWatcher f6423D = new br(this);
    private Button f6424b;
    private LinearLayout f6425c;
    private LinearLayout f6426d;
    private LinearLayout f6427e;
    private LinearLayout f6428f;
    private LinearLayout f6429g;
    private TextView f6430h;
    private TextView f6431i;
    private TextView f6432j;
    private TextView f6433k;
    private TextView f6434l;
    private ImageView f6435m;
    private HorizontalScrollView f6436n;
    private C1507h f6437o = null;
    private Context f6438p;
    private String f6439q = "";
    private String f6440r = "is_from_qr_code";
    private EditText f6441s;
    private String f6442t = "0";
    private final float f6443u = 20.0f;
    private final float f6444v = 17.0f;
    private final int f6445w = 4;
    private final int f6446x = 10;
    private final int f6447y = 39;
    private final char f6448z = '·';

    protected void mo2517a() {
        requestWindowFeature(1);
        C2538c.m12674b("RelationSettingActivity", "=========Enter initView");
        setContentView(h.activity_relation);
        this.f6438p = this;
        this.f6420A = new Handler();
        this.f6435m = (ImageView) findViewById(g.relation_img_relation_pic);
        this.f6427e = (LinearLayout) findViewById(g.relation_lly_other);
        this.f6428f = (LinearLayout) findViewById(g.relation_lly_mother);
        this.f6429g = (LinearLayout) findViewById(g.relation_lly_father);
        this.f6425c = (LinearLayout) findViewById(g.relation_lly_grandpa);
        this.f6426d = (LinearLayout) findViewById(g.relation_lly_grandma);
        this.f6432j = (TextView) findViewById(g.relatiov_tv_other);
        this.f6433k = (TextView) findViewById(g.relatiov_tv_mother);
        this.f6434l = (TextView) findViewById(g.relatiov_tv_father);
        this.f6430h = (TextView) findViewById(g.relatiov_tv_grandpa);
        this.f6431i = (TextView) findViewById(g.relatiov_tv_grandma);
        this.f6436n = (HorizontalScrollView) findViewById(g.relation_horizontal);
        this.f6427e.setOnClickListener(this.f6422C);
        this.f6428f.setOnClickListener(this.f6422C);
        this.f6429g.setOnClickListener(this.f6422C);
        this.f6425c.setOnClickListener(this.f6422C);
        this.f6426d.setOnClickListener(this.f6422C);
        this.f6424b = (Button) findViewById(g.btn_next);
        this.f6424b.setOnClickListener(this.f6422C);
        if (getIntent().getBooleanExtra(this.f6440r, false)) {
            String b = C1497q.m6945b(this.f6438p, "pictype", "2");
            if ("1".equals(b)) {
                m9966h();
            } else if ("2".equals(b)) {
                m9964g();
            } else if ("3".equals(b)) {
                m9969i();
            } else if ("4".equals(b)) {
                m9971j();
            } else {
                this.f6427e.setSelected(true);
                this.f6428f.setSelected(false);
                this.f6429g.setSelected(false);
                this.f6425c.setSelected(false);
                this.f6426d.setSelected(false);
                this.f6432j.setTextSize(20.0f);
                this.f6433k.setTextSize(17.0f);
                this.f6434l.setTextSize(17.0f);
                this.f6430h.setTextSize(17.0f);
                this.f6431i.setTextSize(17.0f);
                this.f6435m.setImageResource(C1617f.kw_img_other);
                this.f6442t = "0";
                CharSequence r = C1462f.m6758r();
                this.f6424b.setEnabled(true);
                this.f6432j.setText(r);
            }
        } else {
            m9964g();
        }
        this.f6420A.postDelayed(this.f6421B, 10);
    }

    private void m9958d() {
        Intent intent = new Intent();
        intent.setClass(this.f6438p, BindbyQrActivity.class);
        startActivity(intent);
        finish();
    }

    private void m9960e() {
        C2538c.m12674b("RelationSettingActivity", "========Enter selectOther");
        m9962f();
    }

    private void m9962f() {
        C2538c.m12674b("RelationSettingActivity", "========Enter sendChangeThemeToCloud");
        if (this.f6437o == null) {
            this.f6437o = new C1507h(this.f6438p, h.dialog_selfdefine, m.servicedialog, false);
        }
        ((TextView) this.f6437o.findViewById(g.common_selfdefine_dialog_title)).setText(getResources().getString(C1680l.IDS_plugin_kidwatch_settings_relation_info));
        this.f6441s = (EditText) this.f6437o.findViewById(g.common_selfdefine_dialog_content);
        this.f6441s.addTextChangedListener(this.f6423D);
        if (this.f6442t.equals("0") && C1462f.m6758r().length() > 0) {
            this.f6441s.setText(C1462f.m6758r());
            this.f6441s.setSelection(this.f6441s.getText().toString().length());
        }
        this.f6437o.show();
        this.f6437o.findViewById(g.common_selfdefine_dialog_cancle).setOnClickListener(new bp(this));
        this.f6437o.findViewById(g.common_selfdefine_dialog_sure).setOnClickListener(new bq(this));
    }

    private boolean m9954a(String str) {
        if (str == null || "".equals(str)) {
            return false;
        }
        return Pattern.compile("[\\u4e00-\\u9fa5\\uF900-\\uFA2D]").matcher(str).find();
    }

    private void m9964g() {
        C2538c.m12674b("RelationSettingActivity", "=========Enter selectMother");
        this.f6427e.setSelected(false);
        this.f6428f.setSelected(true);
        this.f6429g.setSelected(false);
        this.f6425c.setSelected(false);
        this.f6426d.setSelected(false);
        this.f6432j.setTextSize(17.0f);
        this.f6433k.setTextSize(20.0f);
        this.f6434l.setTextSize(17.0f);
        this.f6430h.setTextSize(17.0f);
        this.f6431i.setTextSize(17.0f);
        this.f6432j.setText(C1680l.IDS_plugin_kidwatch_main_relation_other);
        this.f6435m.setImageResource(C1617f.kw_img_mother);
        this.f6442t = "2";
        C1462f.m6743h(getResources().getString(C1680l.IDS_plugin_kidwatch_main_relation_mom));
        this.f6424b.setEnabled(true);
    }

    private void m9966h() {
        C2538c.m12674b("RelationSettingActivity", "=========Enter selectFather");
        this.f6427e.setSelected(false);
        this.f6428f.setSelected(false);
        this.f6429g.setSelected(true);
        this.f6425c.setSelected(false);
        this.f6426d.setSelected(false);
        this.f6432j.setTextSize(17.0f);
        this.f6433k.setTextSize(17.0f);
        this.f6434l.setTextSize(20.0f);
        this.f6430h.setTextSize(17.0f);
        this.f6431i.setTextSize(17.0f);
        this.f6432j.setText(C1680l.IDS_plugin_kidwatch_main_relation_other);
        this.f6435m.setImageResource(C1617f.kw_img_father);
        this.f6442t = "1";
        C1462f.m6743h(getResources().getString(C1680l.IDS_plugin_kidwatch_main_relation_dad));
        this.f6424b.setEnabled(true);
    }

    private void m9969i() {
        C2538c.m12674b("RelationSettingActivity", "=========Enter selectGrandpa");
        this.f6427e.setSelected(false);
        this.f6428f.setSelected(false);
        this.f6429g.setSelected(false);
        this.f6425c.setSelected(true);
        this.f6426d.setSelected(false);
        this.f6432j.setTextSize(17.0f);
        this.f6433k.setTextSize(17.0f);
        this.f6434l.setTextSize(17.0f);
        this.f6430h.setTextSize(20.0f);
        this.f6431i.setTextSize(17.0f);
        this.f6432j.setText(C1680l.IDS_plugin_kidwatch_main_relation_other);
        this.f6435m.setImageResource(C1617f.kw_img_grandfather);
        this.f6442t = "3";
        C1462f.m6743h(getResources().getString(C1680l.IDS_plugin_kidwatch_main_relation_grandpa));
        this.f6424b.setEnabled(true);
    }

    private void m9971j() {
        C2538c.m12674b("RelationSettingActivity", "=========Enter selectGrandma");
        this.f6427e.setSelected(false);
        this.f6428f.setSelected(false);
        this.f6429g.setSelected(false);
        this.f6425c.setSelected(false);
        this.f6426d.setSelected(true);
        this.f6432j.setTextSize(17.0f);
        this.f6433k.setTextSize(17.0f);
        this.f6434l.setTextSize(17.0f);
        this.f6430h.setTextSize(17.0f);
        this.f6431i.setTextSize(20.0f);
        this.f6432j.setText(C1680l.IDS_plugin_kidwatch_main_relation_other);
        this.f6435m.setImageResource(C1617f.kw_img_grandmother);
        this.f6442t = "4";
        C1462f.m6743h(getResources().getString(C1680l.IDS_plugin_kidwatch_main_relation_grandma));
        this.f6424b.setEnabled(true);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        return true;
    }

    protected void onDestroy() {
        C2538c.m12677c("RelationSettingActivity", "onDestroy()");
        C0977d.m3575n(this.f6438p);
        if (this.f6420A != null) {
            this.f6420A.removeCallbacksAndMessages(null);
        }
        super.onDestroy();
    }
}
