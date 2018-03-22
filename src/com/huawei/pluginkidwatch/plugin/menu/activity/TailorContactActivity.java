package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.common.entity.C1413d;
import com.huawei.pluginkidwatch.common.entity.C1417a;
import com.huawei.pluginkidwatch.common.lib.p147b.C1465a;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.p138a.C1391g;
import com.huawei.pluginkidwatch.common.ui.p150a.C1507h;
import com.huawei.pluginkidwatch.common.ui.view.ac;
import com.huawei.pluginkidwatch.common.ui.view.ae;
import com.huawei.pluginkidwatch.common.ui.view.af;
import com.huawei.pluginkidwatch.common.ui.view.ag;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1896m;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1906x;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.regex.Pattern;

public class TailorContactActivity extends Activity implements ag {
    private String f5875A = "";
    private String f5876B = "";
    private Handler f5877C = new gw(this);
    private byte[] f5878D;
    private String f5879E = "0";
    private String f5880F = "";
    private gv f5881G = null;
    private boolean f5882H = false;
    private ae f5883I;
    private final char f5884J = '·';
    private boolean f5885K = false;
    private OnClickListener f5886L = new gh(this);
    private OnClickListener f5887M = new gj(this);
    private OnClickListener f5888N = new gk(this);
    private OnClickListener f5889O = new go(this);
    private OnClickListener f5890P = new gp(this);
    private OnClickListener f5891Q = new gq(this);
    private OnClickListener f5892R = new gt(this);
    private TextWatcher f5893S = new gu(this);
    private final int f5894a = 11;
    private final int f5895b = 55;
    private final int f5896c = 56;
    private EditText f5897d;
    private EditText f5898e;
    private ImageView f5899f;
    private ImageView f5900g;
    private ImageView f5901h;
    private LinearLayout f5902i;
    private C1413d f5903j = null;
    private C1507h f5904k = null;
    private C1507h f5905l = null;
    private C1507h f5906m = null;
    private C1507h f5907n = null;
    private TextView f5908o;
    private TextView f5909p;
    private TextView f5910q;
    private TextView f5911r;
    private TextView f5912s;
    private ImageView f5913t = null;
    private C1391g f5914u = null;
    private int f5915v = 4;
    private int f5916w = 10;
    private boolean f5917x = false;
    private C1896m f5918y = null;
    private C1391g f5919z = null;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setSoftInputMode(32);
        requestWindowFeature(1);
        setContentView(h.activity_contact_tailorcontact);
        m9538a();
        this.f5903j = C1417a.m6594a(getApplicationContext());
    }

    private void m9538a() {
        this.f5881G = new gv();
        this.f5897d = (EditText) findViewById(g.menu_et_contactName);
        this.f5898e = (EditText) findViewById(g.menu_et_contactPhone_number);
        this.f5913t = (ImageView) findViewById(g.menu_tailor_head_img);
        this.f5901h = (ImageView) findViewById(g.menu_contact_improt);
        this.f5919z = new C1391g(getApplicationContext());
        this.f5901h.setOnClickListener(this.f5887M);
        this.f5918y = new C1896m(getApplicationContext());
        this.f5914u = new C1391g(getApplicationContext());
        this.f5883I = new ae(this);
        this.f5883I.m7239a((ag) this);
        Bitmap b;
        if (C1497q.m6944b(this, "onClickNet").booleanValue()) {
            String b2 = C1497q.m6945b((Context) this, "contactheadcion", "");
            if ("".equals(b2)) {
                String b3 = C1497q.m6945b((Context) this, "pictype", "0");
                Resources resources = getResources();
                if (b3.equals("0")) {
                    this.f5913t.setImageBitmap(BitmapFactory.decodeResource(resources, C1617f.kw_pic_ist_user_common));
                    this.f5879E = "0";
                } else if (b3.equals("1")) {
                    this.f5913t.setImageBitmap(BitmapFactory.decodeResource(resources, C1617f.kw_pic_relation_mid_dad));
                    this.f5879E = "1";
                } else if (b3.equals("2")) {
                    this.f5913t.setImageBitmap(BitmapFactory.decodeResource(resources, C1617f.kw_pic_relation_mid_mom));
                    this.f5879E = "2";
                } else if (b3.equals("3")) {
                    this.f5913t.setImageBitmap(BitmapFactory.decodeResource(resources, C1617f.kw_pic_relation_mid_grandpa));
                    this.f5879E = "3";
                } else if (b3.equals("4")) {
                    this.f5913t.setImageBitmap(BitmapFactory.decodeResource(resources, C1617f.kw_pic_relation_mid_grandma));
                    this.f5879E = "4";
                } else if (b3.equals("5")) {
                    this.f5913t.setImageBitmap(BitmapFactory.decodeResource(resources, C1617f.kw_pic_user_boy));
                    this.f5879E = "5";
                } else if (b3.equals("6")) {
                    this.f5913t.setImageBitmap(BitmapFactory.decodeResource(resources, C1617f.kw_pic_user_girl));
                    this.f5879E = "6";
                }
            } else {
                b = C1465a.m6770a().m6776b(b2);
                if (b == null) {
                    b = ac.m7222a(this, b2);
                }
                if (!(b == null || b.isRecycled())) {
                    this.f5879E = "7";
                    this.f5913t.setImageBitmap(C1492l.m6903a(b));
                    this.f5885K = true;
                    this.f5878D = C1906x.m9699a(b);
                    m9570a(b);
                }
            }
        } else if (C1497q.m6944b(this, "onClickDB").booleanValue()) {
            b = m9534a(C1497q.m6945b((Context) this, "contactpicurl", ""));
            if (b == null || b.isRecycled()) {
                this.f5913t.setImageResource(C1617f.kw_pic_ist_user_common);
            } else {
                this.f5913t.setImageBitmap(C1492l.m6903a(b));
            }
        }
        this.f5913t.setOnClickListener(this.f5889O);
        this.f5902i = (LinearLayout) findViewById(g.menu_img_choose_list);
        this.f5902i.setOnClickListener(this.f5890P);
        this.f5908o = (TextView) findViewById(g.menu_tv_delete);
        this.f5908o.setOnClickListener(this.f5888N);
        this.f5899f = (ImageView) findViewById(g.menu_img_setcontact_cancle);
        this.f5900g = (ImageView) findViewById(g.menu_img_setcontact_ok);
        this.f5900g.setOnClickListener(this.f5886L);
        this.f5899f.setOnClickListener(this.f5891Q);
        Object b4 = C1497q.m6945b((Context) this, "contactname", "");
        Object b5 = C1497q.m6945b((Context) this, "contactphonenumber", "");
        this.f5897d.setText(b4);
        this.f5897d.setSelection(b4.length());
        this.f5898e.setText(b5);
        this.f5898e.setSelection(b5.length());
        this.f5897d.addTextChangedListener(this.f5893S);
    }

    private void m9544b() {
        this.f5909p = (TextView) this.f5906m.findViewById(g.mom_tv);
        this.f5910q = (TextView) this.f5906m.findViewById(g.dad_tv);
        this.f5911r = (TextView) this.f5906m.findViewById(g.gf_tv);
        this.f5912s = (TextView) this.f5906m.findViewById(g.gm_tv);
        this.f5909p.setOnClickListener(this.f5892R);
        this.f5910q.setOnClickListener(this.f5892R);
        this.f5911r.setOnClickListener(this.f5892R);
        this.f5912s.setOnClickListener(this.f5892R);
        this.f5906m.show();
    }

    protected void onResume() {
        super.onResume();
        if (C1497q.m6944b(this, "isaddselectimg").booleanValue() && C1497q.m6944b(this, "isselectImg").booleanValue()) {
            int c = C1497q.m6948c(this, "selectedimg");
            this.f5913t.setImageBitmap(null);
            if (c == g.menu_img_sister_on) {
                this.f5879E = "6";
                this.f5913t.setBackgroundResource(C1617f.kw_pic_user_girl);
                m9569a(C1617f.kw_pic_user_girl);
            } else if (c == g.menu_img_mother_on) {
                this.f5879E = "2";
                this.f5913t.setBackgroundResource(C1617f.kw_pic_relation_mid_mom);
                m9569a(C1617f.kw_pic_relation_mid_mom);
            } else if (c == g.menu_img_gm_on) {
                this.f5879E = "4";
                this.f5913t.setBackgroundResource(C1617f.kw_pic_relation_mid_grandma);
                m9569a(C1617f.kw_pic_relation_mid_grandma);
            } else if (c == g.menu_img_brother_on) {
                this.f5879E = "5";
                this.f5913t.setBackgroundResource(C1617f.kw_pic_user_boy);
                m9569a(C1617f.kw_pic_user_boy);
            } else if (c == g.menu_img_father_on) {
                this.f5879E = "1";
                this.f5913t.setBackgroundResource(C1617f.kw_pic_relation_mid_dad);
                m9569a(C1617f.kw_pic_relation_mid_dad);
            } else if (c == g.menu_img_gf_on) {
                this.f5879E = "3";
                this.f5913t.setBackgroundResource(C1617f.kw_pic_relation_mid_grandpa);
                m9569a(C1617f.kw_pic_relation_mid_grandpa);
            }
            C1497q.m6942a((Context) this, "istailorselectimg", Boolean.valueOf(false));
            C1497q.m6942a((Context) this, "isselectImg", Boolean.valueOf(false));
        }
        if (C1497q.m6944b(this, "importcontactboolean").booleanValue() && C1497q.m6944b(this, "importcontactbooleanyes").booleanValue()) {
            CharSequence b = C1497q.m6945b((Context) this, "importcontactnumber", HwAccountConstants.BLANK);
            Bitmap a = m9534a(C1497q.m6945b((Context) this, "importcontactimg", ""));
            this.f5898e.setText(b);
            if (!(this.f5885K || a == null || !a.isRecycled())) {
                this.f5879E = "7";
                this.f5913t.setImageBitmap(C1492l.m6903a(a));
                this.f5885K = false;
                m9570a(a);
            }
            C1497q.m6942a((Context) this, "importcontactboolean", Boolean.valueOf(false));
            C1497q.m6942a((Context) this, "importcontactbooleanyes", Boolean.valueOf(false));
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        C1497q.m6942a((Context) this, "istailorselectimg", Boolean.valueOf(false));
        C1497q.m6943a((Context) this, "importcontactimg", "");
    }

    private void m9539a(C1507h c1507h) {
        if (c1507h != null) {
            c1507h.cancel();
        }
    }

    public void m9569a(int i) {
        m9570a(BitmapFactory.decodeResource(getResources(), i));
    }

    public void m9570a(Bitmap bitmap) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        this.f5878D = byteArrayOutputStream.toByteArray();
    }

    public static Bitmap m9534a(String str) {
        try {
            byte[] decode = Base64.decode(str, 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (Exception e) {
            return null;
        }
    }

    private boolean m9545b(String str) {
        if (str == null || "".equals(str)) {
            return false;
        }
        return Pattern.compile("[\\u4e00-\\u9fa5\\uF900-\\uFA2D]").matcher(str).find();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            View currentFocus = getCurrentFocus();
            if (currentFocus != null) {
                return inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            }
        }
        return false;
    }

    public void mo2615a(af afVar, byte[] bArr) {
        if (bArr != null) {
            Object obj = new byte[bArr.length];
            System.arraycopy(bArr, 0, obj, 0, bArr.length);
            this.f5879E = "7";
            this.f5878D = obj;
            this.f5913t.setImageBitmap(null);
            this.f5913t.setImageBitmap(C1492l.m6903a(BitmapFactory.decodeByteArray(obj, 0, obj.length)));
            this.f5885K = true;
        }
    }

    public void mo2616a(boolean z) {
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        C2538c.m12674b("TailorContactActivity", "==========onActivityResult requestCode:" + i + "    resultCode:" + i2);
        this.f5883I.m7236a(i, i2, intent);
        C2538c.m12674b("TailorContactActivity", "==========onActivityResult2 requestCode:" + i + "    resultCode:" + i2);
    }
}
