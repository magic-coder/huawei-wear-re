package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.telephony.SmsManager;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.core.datatype.UserInfo;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1413d;
import com.huawei.pluginkidwatch.common.entity.C1417a;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.lib.p148c.C1466a;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.ui.base.KidWatchBaseActivity;
import com.huawei.pluginkidwatch.common.ui.p150a.C1507h;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import java.util.regex.Pattern;

public class InviteManagerActivity extends KidWatchBaseActivity {
    private boolean f6330A = false;
    private Context f6331B;
    private int f6332C = 4;
    private int f6333D = 10;
    private OnClickListener f6334E = new af(this);
    private TextWatcher f6335F = new aj(this);
    private final String f6336b = "InviteManagerActivity";
    private TextView f6337c;
    private ImageView f6338d;
    private ImageView f6339e;
    private ImageView f6340f;
    private ImageView f6341g;
    private ImageView f6342h;
    private ImageView f6343i;
    private ImageView f6344j;
    private ImageView f6345k;
    private ImageView f6346l;
    private ImageView f6347m;
    private EditText f6348n;
    private EditText f6349o;
    private String f6350p = "";
    private Resources f6351q = null;
    private String f6352r = "";
    private String f6353s = "";
    private String f6354t = "";
    private String f6355u = "";
    private C1413d f6356v;
    private C1507h f6357w = null;
    private final int f6358x = SdkConstants.REQUEST_CAMERA_VIDEO;
    private final int f6359y = 181;
    private String f6360z = "0";

    protected void mo2517a() {
        getWindow().setSoftInputMode(32);
        requestWindowFeature(1);
        setContentView(h.activity_invite);
        this.f6331B = this;
        this.f6330A = getIntent().getBooleanExtra("in_guide", false);
        this.f6356v = C1417a.m6594a(getApplicationContext());
        this.f6339e = (ImageView) findViewById(g.iv_relation_mid_mom);
        this.f6340f = (ImageView) findViewById(g.iv_relation_mid_dad);
        this.f6341g = (ImageView) findViewById(g.iv_relation_mid_grandma);
        this.f6342h = (ImageView) findViewById(g.iv_relation_mid_grandpa);
        this.f6338d = (ImageView) findViewById(g.iv_cancle);
        this.f6343i = (ImageView) findViewById(g.iv_relation_mid_selected_mom);
        this.f6344j = (ImageView) findViewById(g.iv_relation_mid_selected_dad);
        this.f6345k = (ImageView) findViewById(g.iv_relation_mid_selected_grandma);
        this.f6346l = (ImageView) findViewById(g.iv_relation_mid_selected_grandpa);
        this.f6347m = (ImageView) findViewById(g.setting_tv_improt);
        this.f6351q = getResources();
        this.f6352r = this.f6351q.getString(C1680l.IDS_plugin_kidwatch_main_relation_mom);
        this.f6353s = this.f6351q.getString(C1680l.IDS_plugin_kidwatch_main_relation_dad);
        this.f6354t = this.f6351q.getString(C1680l.IDS_plugin_kidwatch_main_relation_grandpa);
        this.f6355u = this.f6351q.getString(C1680l.IDS_plugin_kidwatch_main_relation_grandma);
        this.f6348n = (EditText) findViewById(g.et_relation);
        this.f6349o = (EditText) findViewById(g.et_phonenumber);
        this.f6337c = (TextView) findViewById(g.btn_next);
        this.f6339e.setOnClickListener(this.f6334E);
        this.f6340f.setOnClickListener(this.f6334E);
        this.f6341g.setOnClickListener(this.f6334E);
        this.f6342h.setOnClickListener(this.f6334E);
        this.f6337c.setOnClickListener(this.f6334E);
        this.f6347m.setOnClickListener(this.f6334E);
        this.f6338d.setOnClickListener(this.f6334E);
        this.f6348n.addTextChangedListener(this.f6335F);
    }

    private boolean m9837a(String str) {
        if (str == null || "".equals(str)) {
            return false;
        }
        return Pattern.compile("[\\u4e00-\\u9fa5\\uF900-\\uFA2D]").matcher(str).find();
    }

    protected void onResume() {
        super.onResume();
        if (C1497q.m6944b(this, "importcontactboolean").booleanValue() && C1497q.m6944b(this, "importcontactbooleanyes").booleanValue()) {
            this.f6349o.setText(C1497q.m6945b((Context) this, "importcontactnumber", HwAccountConstants.BLANK));
            C1497q.m6942a((Context) this, "importcontactboolean", Boolean.valueOf(false));
            C1497q.m6942a((Context) this, "importcontactbooleanyes", Boolean.valueOf(false));
        }
    }

    private void m9836a(String str, String str2) {
        if (C1492l.m6913a(this.f6331B, C1466a.m6782f())) {
            SmsManager smsManager = SmsManager.getDefault();
            if (C1462f.m6748k() != null) {
                String format = String.format(str2, new Object[]{C1462f.m6748k().f3083c});
                try {
                    smsManager.sendTextMessage(str, null, format, null, null);
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(UserInfo.ADDRESS, str);
                    contentValues.put("body", format);
                    getContentResolver().insert(Uri.parse("content://sms/sent"), contentValues);
                } catch (SecurityException e) {
                    C2538c.m12674b("InviteManagerActivity", "=== sendMessageToInvitedManage SecurityException " + e.getMessage());
                }
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (getCurrentFocus() != null) {
            return inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        return false;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.f6330A) {
                C2538c.m12674b("InviteManagerActivity", "=========从导航进入邀请界面，这是点击back，则直接跳到HomeActivity.java");
                m9843d();
                finish();
            } else {
                C2538c.m12674b("InviteManagerActivity", "=========从非导航进入邀请界面 onKeyDown");
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void m9843d() {
        C2538c.m12674b("InviteManagerActivity", "=========Enter gotoHome");
        Intent intent = new Intent();
        intent.setClassName(this, "com.huawei.pluginkidwatch.home.HomeActivity");
        intent.addFlags(32768);
        startActivity(intent);
    }
}
