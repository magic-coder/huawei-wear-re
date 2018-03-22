package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.content.Context;
import android.content.Intent;
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
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.p064d.C0977d;
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
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class SetPhoneNumActivity extends KidWatchBaseActivity implements OnClickListener {
    private String f6525b = "SetPhoneNumActivity";
    private EditText f6526c;
    private EditText f6527d;
    private Handler f6528e = new Handler();
    private Button f6529f;
    private Button f6530g;
    private Button f6531h;
    private TextView f6532i;
    private C1413d f6533j;
    private int f6534k = 60;
    private Context f6535l;
    private String f6536m = "";
    private String f6537n = "";
    private C1378e f6538o = new ci(this);
    private TextWatcher f6539p = new cj(this);
    private TextWatcher f6540q = new ck(this);
    private C1378e f6541r = new cl(this);
    private C1378e f6542s = new cm(this);

    protected void mo2517a() {
        requestWindowFeature(1);
        C2538c.m12674b(this.f6525b, "===========Enter initView");
        setContentView(h.activity_setphonenumber);
        this.f6535l = BaseApplication.m2632b();
        this.f6537n = getIntent().getStringExtra("infotosetphonenumber");
        C2538c.m12674b(this.f6525b, "===========isFromInfo=" + this.f6537n);
        this.f6526c = (EditText) findViewById(g.guide_edtv_phonenumber);
        this.f6526c.addTextChangedListener(this.f6540q);
        this.f6527d = (EditText) findViewById(g.guide_edtv_validatecode);
        this.f6527d.addTextChangedListener(this.f6539p);
        this.f6531h = (Button) findViewById(g.guide_btn_getvalidate);
        this.f6531h.setOnClickListener(this);
        this.f6532i = (TextView) findViewById(g.guide_tv_hint);
        this.f6529f = (Button) findViewById(g.guide_btn_confirm);
        this.f6530g = (Button) findViewById(g.guide_btn_back);
        this.f6529f.setOnClickListener(this);
        this.f6530g.setOnClickListener(this);
        CharSequence d = m10054d();
        if (d == null) {
            d = "";
        }
        if (d.startsWith("+86")) {
            d = d.substring(3);
        }
        this.f6526c.setText(d);
        this.f6533j = C1417a.m6594a(this);
        this.f6533j.mo2509b(new PhoneNumIOEntityModel(), this.f6538o);
    }

    protected void onDestroy() {
        C2538c.m12674b(this.f6525b, "========onDestroy========");
        C0977d.m3575n(this.f6535l);
        this.f6537n = "";
        super.onDestroy();
        if (this.f6528e != null) {
            this.f6528e.removeCallbacksAndMessages(null);
        }
    }

    private String m10054d() {
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
                obj = this.f6526c.getText().toString();
                ValidateCodeIOEntityModel validateCodeIOEntityModel = new ValidateCodeIOEntityModel();
                try {
                    validateCodeIOEntityModel.setPhoneNum(URLEncoder.encode(obj, GameManager.DEFAULT_CHARSET));
                } catch (UnsupportedEncodingException e) {
                    C2538c.m12680e(this.f6525b, "UnsupportedEncodingException e = " + e.getMessage());
                }
                this.f6533j.mo2501a(validateCodeIOEntityModel, this.f6541r);
                m10049a(this.f6534k);
                this.f6526c.setEnabled(false);
                return;
            } else if (g.guide_btn_confirm == id) {
                this.f6529f.setClickable(false);
                obj = this.f6527d.getText().toString();
                String obj2 = this.f6526c.getText().toString();
                PhoneNumIOEntityModel phoneNumIOEntityModel = new PhoneNumIOEntityModel();
                phoneNumIOEntityModel.setPhoneNumValue(obj2, obj);
                this.f6536m = obj2;
                this.f6533j.mo2491a(phoneNumIOEntityModel, this.f6542s);
                return;
            } else if (g.guide_btn_back == id) {
                C2538c.m12674b(this.f6525b, "=========回到上一页");
                finish();
                return;
            } else {
                return;
            }
        }
        C1483c.m6824a(this.f6535l, C1680l.IDS_plugin_kidwatch_common_network_disable);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        return true;
    }

    private void m10049a(int i) {
        this.f6528e.removeCallbacksAndMessages(null);
        if (i < 0) {
            this.f6531h.setText(C1680l.IDS_plugin_kidwatch_settings_verification_again);
            this.f6526c.setEnabled(true);
            this.f6531h.setEnabled(true);
            return;
        }
        this.f6531h.setText("(" + i + ")");
        this.f6531h.setEnabled(false);
        this.f6528e.postDelayed(new cn(this, i), 1000);
    }

    private void m10056e() {
        Intent intent = new Intent();
        intent.setClass(this.f6535l, RelationSettingActivity.class);
        startActivity(intent);
        m10049a(-1);
        finish();
    }

    private void m10058f() {
        C2538c.m12674b(this.f6525b, "=============Enter gotoHomeActivity()===");
        Intent intent = new Intent();
        intent.setClassName(this.f6535l, "com.huawei.pluginkidwatch.home.HomeActivity");
        intent.setPackage(this.f6535l.getPackageName());
        startActivity(intent);
        finish();
    }
}
