package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.content.Context;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.ui.base.KidWatchBaseActivity;
import com.huawei.pluginkidwatch.common.ui.p150a.C1507h;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.m;
import java.util.regex.Pattern;

public class EditRelationSettingActivity extends KidWatchBaseActivity {
    private OnClickListener f5679A = new di(this);
    private TextWatcher f5680B = new dl(this);
    private Button f5681b;
    private Button f5682c;
    private LinearLayout f5683d;
    private LinearLayout f5684e;
    private LinearLayout f5685f;
    private LinearLayout f5686g;
    private LinearLayout f5687h;
    private TextView f5688i;
    private TextView f5689j;
    private TextView f5690k;
    private TextView f5691l;
    private TextView f5692m;
    private ImageView f5693n;
    private HorizontalScrollView f5694o;
    private C1507h f5695p = null;
    private Context f5696q;
    private String f5697r = "is_from_qr_code";
    private EditText f5698s;
    private String f5699t = "0";
    private final float f5700u = 20.0f;
    private final float f5701v = 17.0f;
    private final int f5702w = 4;
    private final int f5703x = 10;
    private final int f5704y = 39;
    private final char f5705z = '·';

    protected void mo2517a() {
        requestWindowFeature(1);
        C2538c.m12674b("RelationSettingActivity", "=========Enter initView");
        setContentView(h.activity_editrelation);
        this.f5696q = this;
        this.f5693n = (ImageView) findViewById(g.relation_img_relation_pic);
        this.f5683d = (LinearLayout) findViewById(g.relation_lly_other);
        this.f5684e = (LinearLayout) findViewById(g.relation_lly_mother);
        this.f5685f = (LinearLayout) findViewById(g.relation_lly_father);
        this.f5686g = (LinearLayout) findViewById(g.relation_lly_grandpa);
        this.f5687h = (LinearLayout) findViewById(g.relation_lly_grandma);
        this.f5688i = (TextView) findViewById(g.relatiov_tv_other);
        this.f5689j = (TextView) findViewById(g.relatiov_tv_mother);
        this.f5690k = (TextView) findViewById(g.relatiov_tv_father);
        this.f5691l = (TextView) findViewById(g.relatiov_tv_grandpa);
        this.f5692m = (TextView) findViewById(g.relatiov_tv_grandma);
        this.f5694o = (HorizontalScrollView) findViewById(g.relation_horizontal);
        this.f5683d.setOnClickListener(this.f5679A);
        this.f5684e.setOnClickListener(this.f5679A);
        this.f5685f.setOnClickListener(this.f5679A);
        this.f5686g.setOnClickListener(this.f5679A);
        this.f5687h.setOnClickListener(this.f5679A);
        this.f5681b = (Button) findViewById(g.btn_next);
        this.f5682c = (Button) findViewById(g.edit_btn_back);
        this.f5681b.setOnClickListener(this.f5679A);
        this.f5682c.setOnClickListener(this.f5679A);
        String stringExtra = getIntent().getStringExtra("name");
        if (stringExtra == null) {
            return;
        }
        if (!"".equals(stringExtra) && stringExtra.equals("爸爸")) {
            m9326g();
        } else if (!"".equals(stringExtra) && stringExtra.equals("妈妈")) {
            m9324f();
        } else if (!"".equals(stringExtra) && stringExtra.equals("爷爷")) {
            m9328h();
        } else if ("".equals(stringExtra) || !stringExtra.equals("奶奶")) {
            this.f5683d.setSelected(true);
            this.f5684e.setSelected(false);
            this.f5685f.setSelected(false);
            this.f5686g.setSelected(false);
            this.f5687h.setSelected(false);
            this.f5688i.setTextSize(20.0f);
            this.f5689j.setTextSize(17.0f);
            this.f5690k.setTextSize(17.0f);
            this.f5691l.setTextSize(17.0f);
            this.f5692m.setTextSize(17.0f);
            this.f5693n.setImageResource(C1617f.kw_img_other);
            this.f5699t = "0";
            C1497q.m6943a(this.f5696q, "editname", "0");
            C1497q.m6943a(this.f5696q, "othername", stringExtra);
            this.f5681b.setEnabled(true);
            this.f5688i.setText(stringExtra);
        } else {
            m9330i();
        }
    }

    private void m9319d() {
        C2538c.m12674b("RelationSettingActivity", "========Enter selectOther");
        m9321e();
    }

    private void m9321e() {
        C2538c.m12674b("RelationSettingActivity", "========Enter sendChangeThemeToCloud");
        if (this.f5695p == null) {
            this.f5695p = new C1507h(this.f5696q, h.dialog_selfdefine, m.servicedialog, false);
        }
        ((TextView) this.f5695p.findViewById(g.common_selfdefine_dialog_title)).setText(getResources().getString(C1680l.IDS_plugin_kidwatch_settings_relation_info));
        this.f5698s = (EditText) this.f5695p.findViewById(g.common_selfdefine_dialog_content);
        this.f5698s.setText("");
        this.f5698s.addTextChangedListener(this.f5680B);
        this.f5695p.show();
        this.f5695p.findViewById(g.common_selfdefine_dialog_cancle).setOnClickListener(new dj(this));
        this.f5695p.findViewById(g.common_selfdefine_dialog_sure).setOnClickListener(new dk(this));
    }

    private boolean m9315a(String str) {
        if (str == null || "".equals(str)) {
            return false;
        }
        return Pattern.compile("[\\u4e00-\\u9fa5\\uF900-\\uFA2D]").matcher(str).find();
    }

    private void m9324f() {
        C2538c.m12674b("RelationSettingActivity", "=========Enter selectMother");
        this.f5683d.setSelected(false);
        this.f5684e.setSelected(true);
        this.f5685f.setSelected(false);
        this.f5686g.setSelected(false);
        this.f5687h.setSelected(false);
        this.f5688i.setTextSize(17.0f);
        this.f5689j.setTextSize(20.0f);
        this.f5690k.setTextSize(17.0f);
        this.f5691l.setTextSize(17.0f);
        this.f5692m.setTextSize(17.0f);
        this.f5688i.setText(C1680l.IDS_plugin_kidwatch_main_relation_other);
        this.f5693n.setImageResource(C1617f.kw_img_mother);
        C1497q.m6943a(this.f5696q, "editname", "2");
        this.f5681b.setEnabled(true);
    }

    private void m9326g() {
        C2538c.m12674b("RelationSettingActivity", "=========Enter selectFather");
        this.f5683d.setSelected(false);
        this.f5684e.setSelected(false);
        this.f5685f.setSelected(true);
        this.f5686g.setSelected(false);
        this.f5687h.setSelected(false);
        this.f5688i.setTextSize(17.0f);
        this.f5689j.setTextSize(17.0f);
        this.f5690k.setTextSize(20.0f);
        this.f5691l.setTextSize(17.0f);
        this.f5692m.setTextSize(17.0f);
        this.f5688i.setText(C1680l.IDS_plugin_kidwatch_main_relation_other);
        this.f5693n.setImageResource(C1617f.kw_img_father);
        this.f5699t = "1";
        C1497q.m6943a(this.f5696q, "editname", "1");
        this.f5681b.setEnabled(true);
    }

    private void m9328h() {
        C2538c.m12674b("RelationSettingActivity", "=========Enter selectGrandpa");
        this.f5683d.setSelected(false);
        this.f5684e.setSelected(false);
        this.f5685f.setSelected(false);
        this.f5686g.setSelected(true);
        this.f5687h.setSelected(false);
        this.f5688i.setTextSize(17.0f);
        this.f5689j.setTextSize(17.0f);
        this.f5690k.setTextSize(17.0f);
        this.f5691l.setTextSize(20.0f);
        this.f5692m.setTextSize(17.0f);
        this.f5688i.setText(C1680l.IDS_plugin_kidwatch_main_relation_other);
        this.f5693n.setImageResource(C1617f.kw_img_grandfather);
        this.f5699t = "3";
        C1497q.m6943a(this.f5696q, "editname", "3");
        this.f5681b.setEnabled(true);
    }

    private void m9330i() {
        C2538c.m12674b("RelationSettingActivity", "=========Enter selectGrandma");
        this.f5683d.setSelected(false);
        this.f5684e.setSelected(false);
        this.f5685f.setSelected(false);
        this.f5686g.setSelected(false);
        this.f5687h.setSelected(true);
        this.f5688i.setTextSize(17.0f);
        this.f5689j.setTextSize(17.0f);
        this.f5690k.setTextSize(17.0f);
        this.f5691l.setTextSize(17.0f);
        this.f5692m.setTextSize(20.0f);
        this.f5688i.setText(C1680l.IDS_plugin_kidwatch_main_relation_other);
        this.f5693n.setImageResource(C1617f.kw_img_grandmother);
        this.f5699t = "4";
        C1497q.m6943a(this.f5696q, "editname", "4");
        this.f5681b.setEnabled(true);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        C1497q.m6943a(this.f5696q, "editname", "");
        finish();
        return true;
    }
}
