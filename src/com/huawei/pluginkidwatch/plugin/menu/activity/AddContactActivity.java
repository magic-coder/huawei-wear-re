package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.b.a;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.l.a.c;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1413d;
import com.huawei.pluginkidwatch.common.entity.C1417a;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.AddWatchContactIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.Contact;
import com.huawei.pluginkidwatch.common.entity.model.WatchContactModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.p138a.C1391g;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1395k;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;
import com.huawei.pluginkidwatch.common.ui.p150a.C1507h;
import com.huawei.pluginkidwatch.common.ui.view.ac;
import com.huawei.pluginkidwatch.common.ui.view.ae;
import com.huawei.pluginkidwatch.common.ui.view.af;
import com.huawei.pluginkidwatch.common.ui.view.ag;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.m;
import com.sina.weibo.sdk.component.GameManager;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.log4j.helpers.FileWatchdog;

public class AddContactActivity extends Activity implements OnClickListener, ag {
    private C1879u f5381A = null;
    private boolean f5382B = false;
    private ae f5383C;
    private final char f5384D = '·';
    private boolean f5385E = false;
    private int f5386F = 15;
    private OnClickListener f5387G = new C1871m(this);
    private OnClickListener f5388H = new C1872n(this);
    private TextWatcher f5389I = new C1876r(this);
    private final int f5390a = 5;
    private final int f5391b = 56;
    private ImageView f5392c;
    private ImageView f5393d;
    private LinearLayout f5394e;
    private ImageView f5395f;
    private ImageView f5396g;
    private C1507h f5397h = null;
    private C1507h f5398i = null;
    private C1507h f5399j = null;
    private TextView f5400k;
    private TextView f5401l;
    private TextView f5402m;
    private TextView f5403n;
    private C1413d f5404o = null;
    private EditText f5405p;
    private EditText f5406q;
    private int f5407r = 4;
    private int f5408s = 10;
    private boolean f5409t = false;
    private String f5410u = "";
    private String f5411v = "";
    private Handler f5412w = new C1878t(this);
    private byte[] f5413x;
    private String f5414y = "0";
    private String f5415z = "";

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(h.activity_contact_add_contact);
        m9016a();
    }

    public void m9016a() {
        this.f5404o = C1417a.m6594a(getApplicationContext());
        this.f5381A = new C1879u();
        this.f5392c = (ImageView) findViewById(g.addcontact_cancle);
        this.f5393d = (ImageView) findViewById(g.addcontactok);
        this.f5392c.setOnClickListener(this);
        this.f5393d.setOnClickListener(this);
        this.f5405p = (EditText) findViewById(g.menu_et_addname);
        this.f5405p.addTextChangedListener(this.f5389I);
        this.f5396g = (ImageView) findViewById(g.menu_contact_improt);
        this.f5396g.setOnClickListener(this.f5388H);
        this.f5406q = (EditText) findViewById(g.menu_et_addphonenumber);
        this.f5394e = (LinearLayout) findViewById(g.list_img);
        this.f5395f = (ImageView) findViewById(g.menu_img_user_pic);
        this.f5383C = new ae(this);
        this.f5383C.m7239a((ag) this);
        this.f5395f.setOnClickListener(new C1869k(this));
        this.f5394e.setOnClickListener(new C1870l(this));
        int a = C1497q.m6935a((Context) this, C1462f.m6746j() + "CONTACTNUM", -1);
        C2538c.m12674b("AddContactActivity", " ===============haveNumSpecifyAbility SharedPreferencesUtil contactNum : " + a);
        if (-1 < a) {
            this.f5386F = a;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        C2538c.m12674b("AddContactActivity", "==========onActivityResult requestCode:" + i + "    resultCode:" + i2);
        this.f5383C.m7236a(i, i2, intent);
        C2538c.m12674b("AddContactActivity", "==========onActivityResult2 requestCode:" + i + "    resultCode:" + i2);
    }

    public void onClick(View view) {
        if (view.getId() == g.addcontact_cancle) {
            if (this.f5399j == null) {
                this.f5399j = new C1507h(this, SdkConstants.REQUEST_CAMERA_VIDEO, 150, h.dialog_contact_cancle, m.servicedialog, false);
            }
            this.f5399j.show();
            ((TextView) this.f5399j.findViewById(g.menu_tv_cancle)).setOnClickListener(new C1873o(this));
            ((TextView) this.f5399j.findViewById(g.menu_tv_sure)).setOnClickListener(new C1874p(this));
        } else if (view.getId() == g.addcontactok) {
            Map hashMap = new HashMap();
            hashMap.put("click", "1");
            c.a().a(BaseApplication.m2632b(), a.Y.a(), hashMap, 0);
            if ("".equals(this.f5405p.getText().toString())) {
                C1483c.m6824a((Context) this, C1680l.IDS_plugin_kidwatch_menu_contactmanage_tv_name_not_null);
            } else if ("".equals(this.f5406q.getText().toString())) {
                C1483c.m6824a((Context) this, C1680l.IDS_plugin_kidwatch_menu_contactmanage_tv_phonenumber_not_null);
            } else if (C1492l.m6917b(this.f5405p.getText().toString().replace(String.valueOf('·'), "").replace(HwAccountConstants.BLANK, ""))) {
                C1506g.m6978a(this, getResources().getString(C1680l.IDS_plugin_kidwatch_common_saving), false);
                this.f5382B = false;
                this.f5412w.postDelayed(this.f5381A, FileWatchdog.DEFAULT_DELAY);
                if (this.f5414y.equals("7")) {
                    new C1875q(this).execute(new String[0]);
                } else {
                    this.f5412w.sendEmptyMessage(5);
                }
            } else {
                C1483c.m6824a((Context) this, C1680l.IDS_plugin_kidwatch_common_illegal);
            }
        }
    }

    private void m8985a(C1507h c1507h) {
        if (c1507h != null) {
            c1507h.cancel();
        }
    }

    public void m9017a(int i) {
        m9018a(BitmapFactory.decodeResource(getResources(), i));
    }

    public void m9018a(Bitmap bitmap) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        this.f5413x = byteArrayOutputStream.toByteArray();
    }

    protected void onResume() {
        super.onResume();
        if (C1497q.m6944b(this, "isaddselectimg").booleanValue() && C1497q.m6944b(this, "isselectImg").booleanValue()) {
            int c = C1497q.m6948c(this, "selectedimg");
            this.f5395f.setImageBitmap(null);
            if (c == g.menu_img_sister_on) {
                this.f5414y = "6";
                this.f5395f.setBackgroundResource(C1617f.kw_pic_user_girl);
                m9017a(C1617f.kw_pic_user_girl);
            } else if (c == g.menu_img_mother_on) {
                this.f5414y = "2";
                this.f5395f.setBackgroundResource(C1617f.kw_pic_relation_mid_mom);
                m9017a(C1617f.kw_pic_relation_mid_mom);
            } else if (c == g.menu_img_gm_on) {
                this.f5414y = "4";
                this.f5395f.setBackgroundResource(C1617f.kw_pic_relation_mid_grandma);
                m9017a(C1617f.kw_pic_relation_mid_mom);
            } else if (c == g.menu_img_brother_on) {
                this.f5414y = "5";
                this.f5395f.setBackgroundResource(C1617f.kw_pic_user_boy);
                m9017a(C1617f.kw_pic_user_boy);
            } else if (c == g.menu_img_father_on) {
                this.f5414y = "1";
                this.f5395f.setBackgroundResource(C1617f.kw_pic_relation_mid_dad);
                m9017a(C1617f.kw_pic_relation_mid_mom);
            } else if (c == g.menu_img_gf_on) {
                this.f5414y = "3";
                this.f5395f.setBackgroundResource(C1617f.kw_pic_relation_mid_grandpa);
                m9017a(C1617f.kw_pic_relation_mid_mom);
            }
            C1497q.m6942a((Context) this, "isaddselectimg", Boolean.valueOf(false));
            C1497q.m6942a((Context) this, "isselectImg", Boolean.valueOf(false));
        }
        if (C1497q.m6944b(this, "importcontactboolean").booleanValue() && C1497q.m6944b(this, "importcontactbooleanyes").booleanValue()) {
            CharSequence b = C1497q.m6945b((Context) this, "importcontactnumber", HwAccountConstants.BLANK);
            Bitmap a = m8977a(C1497q.m6945b((Context) this, "importcontactimg", ""));
            this.f5406q.setText(b);
            if (!(this.f5385E || a == null || a.isRecycled())) {
                this.f5414y = "7";
                this.f5395f.setImageBitmap(C1492l.m6903a(a));
                this.f5385E = false;
                m9018a(a);
            }
            C1497q.m6942a((Context) this, "importcontactboolean", Boolean.valueOf(false));
            C1497q.m6942a((Context) this, "importcontactbooleanyes", Boolean.valueOf(false));
        }
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

    protected void onDestroy() {
        super.onDestroy();
        C1497q.m6942a((Context) this, "isaddselectimg", Boolean.valueOf(false));
        C1497q.m6942a((Context) this, "importcontactboolean", Boolean.valueOf(false));
        C1497q.m6942a((Context) this, "importcontactbooleanyes", Boolean.valueOf(false));
        C1497q.m6943a((Context) this, "importcontactimg", "");
    }

    public static Bitmap m8977a(String str) {
        try {
            byte[] decode = Base64.decode(str, 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (Exception e) {
            return null;
        }
    }

    private boolean m8994b(String str) {
        if (str == null || "".equals(str)) {
            return false;
        }
        return Pattern.compile("[\\u4e00-\\u9fa5\\uF900-\\uFA2D]").matcher(str).find();
    }

    public void mo2615a(af afVar, byte[] bArr) {
        if (bArr != null) {
            this.f5414y = "7";
            this.f5413x = new byte[bArr.length];
            System.arraycopy(bArr, 0, this.f5413x, 0, bArr.length);
            this.f5395f.setImageBitmap(null);
            this.f5395f.setImageBitmap(C1492l.m6903a(BitmapFactory.decodeByteArray(bArr, 0, bArr.length)));
            this.f5385E = true;
        }
    }

    public void mo2616a(boolean z) {
    }

    private void m8991b() {
        try {
            Contact contact = new Contact();
            AddWatchContactIOEntityModel addWatchContactIOEntityModel = new AddWatchContactIOEntityModel(contact);
            addWatchContactIOEntityModel.deviceCode = C1462f.m6746j();
            contact.setName(this.f5405p.getText().toString());
            contact.setPhoneNum(URLEncoder.encode(this.f5406q.getText().toString(), GameManager.DEFAULT_CHARSET));
            contact.setType(this.f5414y);
            if (this.f5414y.equals("7")) {
                if (!"".equals(this.f5410u)) {
                    contact.setHeadIcon(this.f5410u);
                }
                if (!"".equals(this.f5411v)) {
                    contact.setBigHeadIcon(this.f5411v);
                }
            }
            m8982a(addWatchContactIOEntityModel);
        } catch (Exception e) {
            C2538c.m12680e("AddContactActivity", "EXCEPTION E = " + e.getMessage());
        }
    }

    private void m8982a(AddWatchContactIOEntityModel addWatchContactIOEntityModel) {
        this.f5404o.mo2469a(addWatchContactIOEntityModel, new C1877s(this));
    }

    private void m8983a(BaseEntityModel baseEntityModel) {
        this.f5412w.removeCallbacks(this.f5381A);
        if (baseEntityModel != null && baseEntityModel.retCode == 0) {
            m8984a((WatchContactModel) baseEntityModel);
        } else if (baseEntityModel == null || 13205 != baseEntityModel.retCode) {
            m8992b(baseEntityModel);
        } else {
            C1506g.m6979b();
            C1483c.m6832c(this, String.format(getResources().getString(C1680l.IDS_plugin_kidwatch_menu_contactmanage_full), new Object[]{this.f5386F + ""}));
        }
    }

    private void m8992b(BaseEntityModel baseEntityModel) {
        C1506g.m6979b();
        if (baseEntityModel != null) {
            WatchContactModel watchContactModel = (WatchContactModel) baseEntityModel;
            String str = watchContactModel.retMsg;
            int i = watchContactModel.retCode;
            C2538c.m12674b("AddContactActivity", "add contact error String==" + str + "  , retCode=" + i);
            if (str.contains("exists")) {
                C1483c.m6824a((Context) this, C1680l.IDS_plugin_kidwatch_menu_phone_number_exists);
            } else if (str.contains("illegal")) {
                C1483c.m6824a((Context) this, C1680l.IDS_plugin_kidwatch_menu_phone_number_illegal);
            } else if ("".equals(str)) {
                C1483c.m6824a((Context) this, C1680l.IDS_plugin_kidwatch_common_network_timeout_try);
            } else {
                C1483c.m6824a((Context) this, C1680l.IDS_plugin_kidwatch_common_add_failed);
            }
        }
    }

    private void m8984a(WatchContactModel watchContactModel) {
        C1506g.m6979b();
        C1391g c1391g = new C1391g(getApplicationContext());
        Contact contact = new Contact();
        contact.setName(this.f5405p.getText().toString());
        contact.setPhoneNum(this.f5406q.getText().toString());
        contact.setContactId((int) watchContactModel.getContactId());
        contact.setType(this.f5414y);
        if ("".equals(this.f5411v)) {
            contact.setBigHeadIcon("");
        } else {
            contact.setBigHeadIcon(this.f5411v);
        }
        c1391g.m6260a(contact, C1462f.m6746j());
        C1395k a = C1392h.m6269a((Context) this, C1462f.m6744i(), C1462f.m6746j());
        C2538c.m12674b("AddContactActivity", "deviceInfo = " + a);
        if (a.m6340a() != null) {
            C2538c.m12674b("AddContactActivity", "deviceInfo.BtMac = " + a.m6340a());
            this.f5404o.mo2508a(a.m6340a(), C1462f.m6746j());
        }
        C2538c.m12674b("AddContactActivity", "addWatchContact success  response :  headicon==" + watchContactModel.retMsg + ", contactID==" + watchContactModel.getContactId());
        if (!"".equals(this.f5411v)) {
            ac.m7223a(this, this.f5411v, BitmapFactory.decodeByteArray(this.f5413x, 0, this.f5413x.length));
        }
        ContactsListActivity.m9217a(true);
        finish();
    }
}
