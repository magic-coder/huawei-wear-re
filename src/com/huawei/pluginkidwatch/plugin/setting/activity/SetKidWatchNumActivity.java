package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.C1413d;
import com.huawei.pluginkidwatch.common.entity.C1417a;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.VerifyBindCodeModel;
import com.huawei.pluginkidwatch.common.entity.model.WatchPhoneNumIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.WatchSecurityCodeIOEntityModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.ui.base.KidWatchBaseActivity;
import com.huawei.pluginkidwatch.common.ui.title.CustomTitle;
import com.huawei.pluginkidwatch.common.ui.view.C1595v;
import com.huawei.pluginkidwatch.common.ui.view.CustomDialog;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;

public class SetKidWatchNumActivity extends KidWatchBaseActivity implements OnClickListener {
    private String f6500b = "SetKidWatchNumActivity";
    private CustomTitle f6501c;
    private LinearLayout f6502d;
    private EditText f6503e;
    private Context f6504f;
    private EditText f6505g;
    private Button f6506h;
    private Button f6507i;
    private Button f6508j;
    private ImageView f6509k;
    private ImageView f6510l;
    private ImageView f6511m;
    private TextView f6512n;
    private TextView f6513o;
    private C1413d f6514p;
    private int f6515q = 60;
    private String f6516r = "";
    private boolean f6517s = false;
    private String f6518t = "";
    private CustomDialog f6519u;
    private boolean f6520v = false;
    private C1378e f6521w = new cb(this);
    private C1378e f6522x = new cc(this);
    private C1378e f6523y = new cd(this);
    private Handler f6524z = new Handler();

    protected void mo2517a() {
        requestWindowFeature(1);
        C2538c.m12674b(this.f6500b, "=========Enter initView");
        setContentView(h.activity_setphonenumber);
        this.f6504f = this;
        this.f6517s = getIntent().getBooleanExtra("in_guide", false);
        this.f6520v = getIntent().getBooleanExtra("other_manager_bind_in_guide", false);
        C2538c.m12674b(this.f6500b, "=========inGuide：", "" + this.f6517s, ", isOtherManager = ", Boolean.valueOf(this.f6520v));
        this.f6501c = (CustomTitle) findViewById(g.guide_ct_title);
        this.f6502d = (LinearLayout) findViewById(g.guide_llyt_selector);
        if (this.f6517s) {
            C2538c.m12674b(this.f6500b, "=========导航页面");
            this.f6516r = getIntent().getStringExtra("device_code_in_guide");
            this.f6518t = getIntent().getStringExtra("phone_num_in_guide");
            C2538c.m12674b(this.f6500b, "=========从二维码界面传进来的电话号码是：" + this.f6518t);
            this.f6501c.setVisibility(8);
            this.f6502d.setVisibility(0);
        } else {
            C2538c.m12674b(this.f6500b, "=========非导航页面");
            this.f6516r = C1462f.m6746j();
            this.f6501c.setVisibility(0);
            this.f6502d.setVisibility(8);
        }
        this.f6509k = (ImageView) findViewById(g.nav_im_dot1);
        this.f6510l = (ImageView) findViewById(g.nav_im_dot4);
        this.f6509k.setImageResource(C1617f.kw_pic_nav_selector_2);
        this.f6510l.setImageResource(C1617f.kw_pic_nav_selector_1);
        this.f6511m = (ImageView) findViewById(g.guide_iv_phoneorwatchpic);
        this.f6511m.setImageResource(C1617f.kw_pic_setting_watch);
        this.f6512n = (TextView) findViewById(g.guide_tv_verification);
        this.f6512n.setText(C1680l.IDS_plugin_kidwatch_settings_verification_watch);
        this.f6513o = (TextView) findViewById(g.guide_tv_hint);
        this.f6513o.setText(C1680l.IDS_plugin_kidwatch_settings_verification_watch_hit);
        this.f6503e = (EditText) findViewById(g.guide_edtv_phonenumber);
        this.f6503e.addTextChangedListener(new bz(this));
        this.f6505g = (EditText) findViewById(g.guide_edtv_validatecode);
        this.f6505g.addTextChangedListener(new ca(this));
        this.f6508j = (Button) findViewById(g.guide_btn_getvalidate);
        this.f6508j.setOnClickListener(this);
        this.f6506h = (Button) findViewById(g.guide_btn_confirm);
        this.f6507i = (Button) findViewById(g.guide_btn_back);
        this.f6506h.setOnClickListener(this);
        this.f6507i.setOnClickListener(this);
        if (!this.f6517s) {
            this.f6507i.setVisibility(8);
            this.f6506h.setText(C1680l.IDS_plugin_kidwatch_common_setting);
        }
        this.f6503e.setHint(C1680l.IDS_plugin_kidwatch_settings_verification_watch_phonenum);
        this.f6505g.setHint(C1680l.IDS_plugin_kidwatch_settings_verification_code);
        C2538c.m12674b(this.f6500b, "=========手表号码写入到输入框：" + this.f6518t);
        if (!(this.f6518t == null || "".equals(this.f6518t.trim()))) {
            this.f6503e.setText(this.f6518t);
            this.f6503e.setSelection(this.f6518t.trim().length());
            if (this.f6520v) {
                this.f6503e.setEnabled(false);
                this.f6505g.setSelection(0);
            }
        }
        this.f6514p = C1417a.m6594a(this);
    }

    public void onClick(View view) {
        if (C1492l.m6916b(getApplicationContext())) {
            int id = view.getId();
            String obj;
            if (g.guide_btn_getvalidate == id) {
                obj = this.f6503e.getText().toString();
                if ("".equals(obj)) {
                    C1483c.m6824a((Context) this, C1680l.IDS_plugin_kidwatch_settings_verification_hit);
                    return;
                }
                WatchSecurityCodeIOEntityModel watchSecurityCodeIOEntityModel = new WatchSecurityCodeIOEntityModel();
                watchSecurityCodeIOEntityModel.setWatchPhoneNum(this.f6516r, obj);
                this.f6514p.mo2504a(watchSecurityCodeIOEntityModel, this.f6521w);
                m10028a(this.f6515q);
                this.f6503e.setEnabled(false);
                return;
            } else if (g.guide_btn_confirm == id) {
                obj = this.f6505g.getText().toString();
                String obj2 = this.f6503e.getText().toString();
                if ("".equals(obj) || "".equals(obj2)) {
                    C1483c.m6824a((Context) this, C1680l.IDS_plugin_kidwatch_settings_verification_watch_hit2);
                    return;
                }
                this.f6506h.setClickable(false);
                if (this.f6520v) {
                    VerifyBindCodeModel verifyBindCodeModel = new VerifyBindCodeModel();
                    verifyBindCodeModel.deviceCode = this.f6516r;
                    verifyBindCodeModel.securityCode = obj;
                    this.f6514p.mo2502a(verifyBindCodeModel, this.f6523y);
                    return;
                }
                WatchPhoneNumIOEntityModel watchPhoneNumIOEntityModel = new WatchPhoneNumIOEntityModel();
                if (this.f6517s) {
                    watchPhoneNumIOEntityModel.setWatchPhoneNumValue(this.f6516r, obj2, obj);
                } else {
                    watchPhoneNumIOEntityModel.setWatchPhoneNumValue(C1462f.m6746j(), obj2, obj);
                }
                this.f6514p.mo2503a(watchPhoneNumIOEntityModel, this.f6522x);
                return;
            } else if (g.guide_btn_back == id) {
                C2538c.m12674b(this.f6500b, "=========点击上一步");
                Intent intent = new Intent();
                intent.setClass(this.f6504f, BindbyQrActivity.class);
                startActivity(intent);
                finish();
                return;
            } else {
                return;
            }
        }
        C1483c.m6824a((Context) this, C1680l.IDS_plugin_kidwatch_common_network_disable);
    }

    private void m10035d() {
        C2538c.m12674b(this.f6500b, "==========Enter addDefaultAlarm");
    }

    private void m10037e() {
        C2538c.m12674b(this.f6500b, "==========Enter addDefaultPeroid");
    }

    private void m10031a(String str) {
        C2538c.m12674b(this.f6500b, "==========Enter resetDeviceCode, deviceCode:", str);
        if (!"".equals(str) && !"0".equals(str)) {
            C1462f.m6731d(str);
            C1497q.m6943a(getApplicationContext(), "sharedpreferences_watch_device_code", str);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.f6517s) {
            Intent intent = new Intent();
            intent.setClass(this.f6504f, BindbyQrActivity.class);
            intent.addFlags(HwAccountConstants.FLAG_TRANSLUCENT_STATUS);
            startActivity(intent);
            finish();
        } else {
            m10038f();
        }
        return true;
    }

    private void m10028a(int i) {
        this.f6524z.removeCallbacksAndMessages(null);
        if (i < 0) {
            this.f6508j.setText(C1680l.IDS_plugin_kidwatch_settings_verification_get);
            this.f6503e.setEnabled(true);
            this.f6508j.setEnabled(true);
            return;
        }
        this.f6508j.setText("(" + i + ")");
        this.f6508j.setEnabled(false);
        this.f6524z.postDelayed(new ce(this, i), 1000);
    }

    private void m10038f() {
        if (this.f6519u == null || !this.f6519u.isShowing()) {
            C2538c.m12674b(this.f6500b, "=======Enter showWatchPhoneNumNullNoticeDialog");
            C1595v c1595v = new C1595v(this);
            c1595v.m7339a(C1680l.IDS_plugin_kidwatch_common_tips);
            c1595v.m7348b(C1680l.f4410x5969ef32);
            c1595v.m7347a(false);
            c1595v.m7340a(C1680l.f4408x265ed681, new cf(this));
            c1595v.m7349b(C1680l.f4409x1343f6f2, new cg(this));
            c1595v.m7342a(new ch(this));
            this.f6519u = c1595v.m7338a();
            this.f6519u.show();
        }
    }

    private void m10041g() {
        C2538c.m12674b(this.f6500b, "=============Enter gotoHomeActivity()===");
        Intent intent = new Intent();
        intent.setClassName(this.f6504f, "com.huawei.pluginkidwatch.home.HomeActivity");
        intent.setPackage(this.f6504f.getPackageName());
        startActivity(intent);
        finish();
    }
}
