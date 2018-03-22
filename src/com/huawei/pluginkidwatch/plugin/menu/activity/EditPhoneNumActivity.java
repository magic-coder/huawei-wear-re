package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.C1413d;
import com.huawei.pluginkidwatch.common.entity.C1417a;
import com.huawei.pluginkidwatch.common.entity.model.PhoneNumIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.ValidateCodeIOEntityModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.ui.base.KidWatchBaseActivity;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.sina.weibo.sdk.component.GameManager;
import java.net.URLEncoder;

public class EditPhoneNumActivity extends KidWatchBaseActivity implements OnClickListener {
    private String f5661b = "SetPhoneNumActivity";
    private EditText f5662c;
    private EditText f5663d;
    private Handler f5664e = new Handler();
    private Button f5665f;
    private Button f5666g;
    private Button f5667h;
    private TextView f5668i;
    private C1413d f5669j;
    private int f5670k = 60;
    private Context f5671l;
    private String f5672m = "";
    private String f5673n = "";
    private C1378e f5674o = new dc(this);
    private TextWatcher f5675p = new dd(this);
    private TextWatcher f5676q = new de(this);
    private C1378e f5677r = new df(this);
    private C1378e f5678s = new dg(this);

    protected void mo2517a() {
        requestWindowFeature(1);
        C2538c.m12674b(this.f5661b, "===========Enter initView");
        setContentView(h.activity_editphonenumber);
        this.f5671l = this;
        this.f5673n = getIntent().getStringExtra("infotosetphonenumber");
        C2538c.m12674b(this.f5661b, "===========isFromInfo=" + this.f5673n);
        this.f5662c = (EditText) findViewById(g.guide_edtv_phonenumber);
        this.f5662c.addTextChangedListener(this.f5676q);
        this.f5663d = (EditText) findViewById(g.guide_edtv_validatecode);
        this.f5663d.addTextChangedListener(this.f5675p);
        this.f5667h = (Button) findViewById(g.guide_btn_getvalidate);
        this.f5667h.setOnClickListener(this);
        this.f5668i = (TextView) findViewById(g.guide_tv_hint);
        this.f5665f = (Button) findViewById(g.guide_btn_confirm);
        this.f5666g = (Button) findViewById(g.guide_btn_back);
        this.f5665f.setOnClickListener(this);
        this.f5666g.setOnClickListener(this);
        CharSequence d = m9304d();
        if (d == null) {
            d = "";
        }
        if (d.startsWith("+86")) {
            d = d.substring(3);
        }
        this.f5662c.setText(d);
        this.f5669j = C1417a.m6594a(this);
        this.f5669j.mo2509b(new PhoneNumIOEntityModel(), this.f5674o);
    }

    protected void onDestroy() {
        C2538c.m12674b(this.f5661b, "========onDestroy========");
        this.f5673n = "";
        super.onDestroy();
    }

    private String m9304d() {
        if (VERSION.SDK_INT <= 22 || checkSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
            return ((TelephonyManager) getSystemService("phone")).getLine1Number();
        }
        return null;
    }

    public void onClick(View view) {
        if (C1492l.m6916b(getApplicationContext())) {
            int id = view.getId();
            String obj;
            if (g.guide_btn_getvalidate == id) {
                obj = this.f5662c.getText().toString();
                ValidateCodeIOEntityModel validateCodeIOEntityModel = new ValidateCodeIOEntityModel();
                try {
                    validateCodeIOEntityModel.setPhoneNum(URLEncoder.encode(obj, GameManager.DEFAULT_CHARSET));
                } catch (Exception e) {
                    C2538c.m12674b(this.f5661b, "exception e =" + e.getMessage());
                }
                this.f5669j.mo2501a(validateCodeIOEntityModel, this.f5677r);
                m9299a(this.f5670k);
                this.f5662c.setEnabled(false);
                return;
            } else if (g.guide_btn_confirm == id) {
                this.f5665f.setClickable(false);
                obj = this.f5663d.getText().toString();
                String obj2 = this.f5662c.getText().toString();
                PhoneNumIOEntityModel phoneNumIOEntityModel = new PhoneNumIOEntityModel();
                phoneNumIOEntityModel.setPhoneNumValue(obj2, obj);
                this.f5672m = obj2;
                this.f5669j.mo2491a(phoneNumIOEntityModel, this.f5678s);
                return;
            } else if (g.guide_btn_back == id) {
                C2538c.m12674b(this.f5661b, "=========回到上一页");
                finish();
                return;
            } else {
                return;
            }
        }
        C1483c.m6824a(this.f5671l, C1680l.IDS_plugin_kidwatch_common_network_disable);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        return true;
    }

    private void m9299a(int i) {
        this.f5664e.removeCallbacksAndMessages(null);
        if (i < 0) {
            this.f5667h.setText(C1680l.IDS_plugin_kidwatch_settings_verification_again);
            this.f5662c.setEnabled(true);
            this.f5667h.setEnabled(true);
            return;
        }
        this.f5667h.setText("(" + i + ")");
        this.f5667h.setEnabled(false);
        this.f5664e.postDelayed(new dh(this, i), 1000);
    }
}
