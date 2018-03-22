package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.ContentProviderOperation;
import android.content.Context;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.RemoteException;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import android.support.annotation.NonNull;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.login.ui.login.C1093a;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.c;
import com.huawei.pluginkidwatch.common.entity.C1413d;
import com.huawei.pluginkidwatch.common.entity.C1417a;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.CommonRetIModel;
import com.huawei.pluginkidwatch.common.entity.model.DeviceProfile;
import com.huawei.pluginkidwatch.common.entity.model.GetDeviceProfileRetModel;
import com.huawei.pluginkidwatch.common.entity.model.SetDeviceProfileModel;
import com.huawei.pluginkidwatch.common.lib.p148c.C1466a;
import com.huawei.pluginkidwatch.common.lib.p148c.C1467b;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1488h;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.lib.utils.C1494n;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1395k;
import com.huawei.pluginkidwatch.common.ui.base.KidWatchBaseActivity;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;
import com.huawei.pluginkidwatch.common.ui.p150a.C1507h;
import com.huawei.pluginkidwatch.common.ui.title.CustomTitle;
import com.huawei.pluginkidwatch.common.ui.view.C1565a;
import com.huawei.pluginkidwatch.common.ui.view.C1595v;
import com.huawei.pluginkidwatch.common.ui.view.ae;
import com.huawei.pluginkidwatch.common.ui.view.af;
import com.huawei.pluginkidwatch.common.ui.view.ag;
import com.huawei.pluginkidwatch.common.ui.wheelview.C1605e;
import com.huawei.pluginkidwatch.common.ui.wheelview.C1608i;
import com.huawei.pluginkidwatch.common.ui.wheelview.WheelView;
import com.huawei.pluginkidwatch.d;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.m;
import com.huawei.pluginkidwatch.plugin.setting.p167b.C1943h;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import org.apache.log4j.helpers.FileWatchdog;

public class ProfileSettingActivity extends KidWatchBaseActivity implements OnClickListener, ag {
    private C1395k f6369A = new C1395k();
    private int f6370B = 2;
    private boolean f6371C = true;
    private boolean f6372D = false;
    private String f6373E = "";
    private C1507h f6374F = null;
    private int f6375G = 2;
    private C1413d f6376H;
    private boolean f6377I = false;
    private InputMethodManager f6378J;
    private Handler f6379K = new bm(this);
    private String f6380L = "";
    private boolean f6381M = false;
    private String f6382N = "";
    private LinearLayout f6383O;
    private LinearLayout f6384P;
    private LinearLayout f6385Q;
    private LinearLayout f6386R;
    private TextView f6387S;
    private TextView f6388T;
    private TextView f6389U;
    private TextView f6390V;
    private TextView f6391W;
    private bl f6392X = null;
    private long f6393Y = 0;
    private boolean f6394Z = false;
    private boolean aa = false;
    private final char ab = '·';
    private OnEditorActionListener ac = new bg(this);
    private OnClickListener ad = new bh(this);
    private OnClickListener ae = new bi(this);
    private TextWatcher af = new bj(this);
    private final int f6395b = 1;
    private final int f6396c = 2;
    private ae f6397d;
    private Context f6398e;
    private byte[] f6399f;
    private byte[] f6400g = new byte[1024];
    private String f6401h = "";
    private String f6402i = "";
    private TextView f6403j;
    private Bitmap f6404k;
    private Button f6405l;
    private EditText f6406m;
    private Dialog f6407n = null;
    private Dialog f6408o = null;
    private Dialog f6409p = null;
    private CustomTitle f6410q = null;
    private ImageView f6411r;
    private ImageView f6412s;
    private String f6413t = "";
    private boolean f6414u = false;
    private C1605e f6415v = null;
    private C1605e f6416w = null;
    private C1565a f6417x = null;
    private Activity f6418y;
    private LinearLayout f6419z;

    protected void mo2517a() {
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "=======Enter initView");
        this.f6418y = this;
        this.f6398e = this;
        requestWindowFeature(1);
        setContentView(h.activity_profilesetting);
        m9903e();
        m9907g();
    }

    private void m9903e() {
        this.f6378J = (InputMethodManager) getSystemService("input_method");
        this.f6392X = new bl();
        this.f6419z = (LinearLayout) findViewById(g.guide_llyt_selector);
        this.f6410q = (CustomTitle) findViewById(g.setting_title_profile);
        this.f6376H = C1417a.m6594a(getApplicationContext());
        this.f6411r = (ImageView) findViewById(g.setting_btn_head);
        this.f6406m = (EditText) findViewById(g.setting_etx_nickname);
        this.f6403j = (TextView) findViewById(g.setting_tv_describe);
        this.f6405l = (Button) findViewById(g.setting_btn_save);
        this.f6406m.setOnEditorActionListener(this.ac);
        this.f6383O = (LinearLayout) findViewById(g.setting_profile_lly_sex);
        this.f6384P = (LinearLayout) findViewById(g.setting_profile_lly_height);
        this.f6385Q = (LinearLayout) findViewById(g.setting_profile_lly_weight);
        this.f6386R = (LinearLayout) findViewById(g.setting_profile_lly_birthday);
        this.f6387S = (TextView) findViewById(g.setting_tv_sex);
        this.f6388T = (TextView) findViewById(g.setting_tv_height);
        this.f6389U = (TextView) findViewById(g.setting_tv_weight);
        this.f6390V = (TextView) findViewById(g.setting_tv_birthday);
        this.f6391W = (TextView) findViewById(g.setting_profile_birthday_day);
        this.f6412s = (ImageView) findViewById(g.setting_btn_sex);
        this.f6383O.setOnClickListener(this.ad);
        this.f6384P.setOnClickListener(this.ad);
        this.f6385Q.setOnClickListener(this.ad);
        this.f6386R.setOnClickListener(this.ad);
        this.f6405l.setOnClickListener(this.ae);
        this.f6411r.setOnClickListener(this);
        this.f6397d = new ae(this.f6418y);
        this.f6417x = new C1565a();
        this.f6406m.addTextChangedListener(this.af);
        this.f6397d.m7239a((ag) this);
        m9872a(2);
    }

    private void m9905f() {
        if (this.f6374F == null) {
            this.f6374F = new C1507h(this.f6398e, -1, -1, h.dialog_sex_choose, m.servicedialog, false);
        }
        this.f6374F.show();
        this.f6370B = this.f6375G;
        TextView textView = (TextView) this.f6374F.findViewById(g.menu_tv_remote_shutdown_cancle);
        TextView textView2 = (TextView) this.f6374F.findViewById(g.menu_tv_remote_shutdown_sure);
        ImageView imageView = (ImageView) this.f6374F.findViewById(g.dialog_img_boy);
        ImageView imageView2 = (ImageView) this.f6374F.findViewById(g.dialog_img_girl);
        TextView textView3 = (TextView) this.f6374F.findViewById(g.dialog_tv_boy);
        TextView textView4 = (TextView) this.f6374F.findViewById(g.dialog_tv_girl);
        if (imageView == null || imageView2 == null || textView3 == null || textView4 == null) {
            this.f6374F.cancel();
            return;
        }
        if (1 == this.f6375G) {
            imageView.setImageResource(C1617f.kw_btn_male_1);
            textView3.setTextColor(getResources().getColor(d.setting_profile_tv_not_selected));
            imageView2.setImageResource(C1617f.kw_btn_famale_2_2);
            textView4.setTextColor(getResources().getColor(d.setting_profile_tv_girl));
        } else {
            imageView.setImageResource(C1617f.kw_btn_male_1_2);
            textView3.setTextColor(getResources().getColor(d.setting_profile_tv_boy));
            imageView2.setImageResource(C1617f.kw_btn_famale_2_1);
            textView4.setTextColor(getResources().getColor(d.setting_profile_tv_not_selected));
        }
        imageView.setOnClickListener(m9868a(imageView, imageView2, textView3, textView4));
        imageView2.setOnClickListener(m9886b(imageView, imageView2, textView3, textView4));
        textView.setOnClickListener(new am(this));
        textView2.setOnClickListener(new ax(this));
    }

    @NonNull
    private OnClickListener m9868a(ImageView imageView, ImageView imageView2, TextView textView, TextView textView2) {
        return new be(this, imageView, textView, imageView2, textView2);
    }

    @NonNull
    private OnClickListener m9886b(ImageView imageView, ImageView imageView2, TextView textView, TextView textView2) {
        return new bf(this, imageView, textView, imageView2, textView2);
    }

    private boolean m9882a(TextView textView, int i) {
        if (i != 2 && i != 6) {
            return false;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) textView.getContext().getSystemService("input_method");
        if (inputMethodManager.isActive()) {
            inputMethodManager.hideSoftInputFromWindow(textView.getApplicationWindowToken(), 0);
        }
        this.f6406m.clearFocus();
        return true;
    }

    private void m9907g() {
        this.f6377I = false;
        this.f6381M = getIntent().getBooleanExtra("in_guide", false);
        this.f6380L = C1462f.m6746j();
        if (this.f6381M) {
            C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "=============== 导航页面 devicecode:", this.f6380L);
            String obj = this.f6406m.getText().toString();
            C1462f.m6729c(C1093a.m4739a((Context) this).m4750c());
            if (obj != null) {
                this.f6406m.setSelection(obj.length());
            }
        } else {
            C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "===============非导航页面");
            this.f6419z.setVisibility(8);
            this.f6369A = C1392h.m6269a(this.f6398e, C1462f.m6744i(), this.f6380L);
            C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "===wwww============  mDeviceInfoTable:" + this.f6369A);
        }
        if (this.f6369A == null) {
            C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "===============数据库中没有找到用户信息，这属于异常 devicecode:", "" + this.f6380L);
            this.f6369A = new C1395k();
        }
        this.f6413t = this.f6369A.f3084d;
        this.f6402i = this.f6369A.f3098r;
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "=============== Get Data From Local DataBase:", this.f6369A.toString());
        m9910h();
        if (this.f6381M) {
            this.f6369A.f3090j = C1492l.m6920d("35");
            this.f6369A.f3089i = C1492l.m6920d("110");
            this.f6406m.setText(C1680l.IDS_plugin_kidwatch_settings_profilekid_nickname_default);
            this.f6389U.setText("35");
            this.f6388T.setText("110");
            m9892b("2008-01-01");
            this.f6378J.showSoftInputFromInputMethod(this.f6406m.getWindowToken(), 0);
            this.f6406m.setSelection(this.f6406m.getText().toString().length());
            return;
        }
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "=============== 当前处于非导航页面");
        this.f6405l.setText(getResources().getString(C1680l.IDS_plugin_kidwatch_common_save));
        this.f6410q.setVisibility(0);
        this.f6405l.setEnabled(true);
        this.f6405l.setVisibility(8);
        m9930r();
    }

    private void m9910h() {
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "==========Enter freshUI");
        if (this.f6369A == null) {
            this.f6369A = new C1395k();
        }
        this.f6371C = new C1565a().m7221a(this.f6398e, this.f6411r, this.f6369A.f3098r);
        m9912i();
        m9914j();
        m9892b(this.f6369A.f3088h);
        m9916k();
        m9918l();
        m9893b(false);
    }

    private void m9912i() {
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "========Enter setUIGender");
        if (this.f6369A != null) {
            m9872a(this.f6369A.f3091k);
        }
    }

    private void m9914j() {
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "========Enter setUIName");
        if (this.f6369A != null) {
            this.f6406m.setText(this.f6369A.f3083c);
        }
    }

    private void m9892b(String str) {
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "========Enter setUIBrithday ");
        if (!"".equals(str)) {
            String[] split = str.replace("/", "-").split("-");
            int d = C1492l.m6920d(split[0]);
            int d2 = C1492l.m6920d(split[1]);
            int d3 = C1492l.m6920d(split[2]);
            if (this.f6373E != null && this.f6373E.equals("")) {
                m9873a(d, d2, d3);
            } else if (Calendar.getInstance().get(1) - d < 0) {
                C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "updateUI() Calendar.getInstance().get(Calendar.YEAR)" + Calendar.getInstance().get(1));
                m9873a(Calendar.getInstance().get(1), Calendar.getInstance().get(2) + 1, Calendar.getInstance().get(5));
            } else {
                C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "========开始设置生日");
                m9873a(d, d2, d3);
            }
        }
    }

    private void m9916k() {
        if (this.f6388T != null && this.f6369A != null) {
            C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "updateUI() height=" + this.f6369A.f3089i);
            int i = this.f6369A.f3089i;
            if (-1 != i) {
                this.f6388T.setText(String.valueOf(i));
            }
        }
    }

    private void m9918l() {
        int i = 3;
        if (this.f6389U != null && this.f6369A != null) {
            C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "updateUI() weight=" + this.f6369A.f3090j);
            int i2 = this.f6369A.f3090j;
            if (-1 != i2) {
                if (i2 < 3) {
                    this.f6389U.setText(String.valueOf(3));
                } else if (i2 > 60) {
                    this.f6389U.setText(String.valueOf(60));
                    i = 60;
                } else {
                    i = i2;
                }
                this.f6389U.setText(String.valueOf(i));
            }
        }
    }

    private void m9919m() {
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "=======Enter mBirthdayArea onClick");
        if (this.f6373E != null && !"".equals(this.f6373E)) {
            m9900c(this.f6373E);
        } else if ("".equals(this.f6369A.f3088h)) {
            m9900c("2008-01-01");
        } else {
            m9900c(this.f6369A.f3088h);
        }
    }

    private void m9921n() {
        if ("".equals(this.f6380L)) {
            C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "======= Now The DeviceCode Is 0, So APP don't need to send message to cloudServer ");
            finish();
        }
        String trim = this.f6406m.getText().toString().trim();
        if (trim.length() == 0) {
            C1483c.m6824a(this.f6398e, C1680l.IDS_plugin_kidwatch_settings_name_min_tips);
        } else if (20 < trim.length()) {
            C1483c.m6832c(this.f6398e, String.format(getResources().getString(C1680l.IDS_plugin_kidwatch_settings_name_max_tips), new Object[]{Integer.valueOf(20)}));
        } else if (C1492l.m6917b(trim.replace(String.valueOf('·'), "").replace(HwAccountConstants.BLANK, ""))) {
            mo2518d();
            if (this.f6381M || this.f6414u) {
                C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "======= 用户信息修改了，保存到云端 ");
                m9924o();
                return;
            }
            C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "======= 用户信息没有修 ");
            if (this.f6381M) {
                C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "======= 跳转到下一个导航界面 ");
                m9942y();
            } else {
                C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "======= 没有导航 ");
            }
            finish();
        } else {
            C1483c.m6824a(this.f6398e, C1680l.IDS_plugin_kidwatch_common_illegal);
        }
    }

    protected void mo2518d() {
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "============= Enter saveUiDataToLocal()");
        if (!"".equals(this.f6380L)) {
            int i;
            this.f6369A.f3082b = C1492l.m6920d(this.f6380L);
            this.f6369A.f3081a = C1462f.m6744i();
            this.f6369A.f3083c = this.f6406m.getText().toString();
            this.f6369A.f3098r = this.f6402i;
            this.f6369A.f3092l = this.f6375G;
            C2538c.m12677c("KIDWATCH_ProfileSettingActivity", "===www123==== deviceType " + C1467b.m6789d(this.f6398e));
            if (7 == C1467b.m6789d(this.f6398e)) {
                i = 1;
            } else {
                i = 0;
            }
            if (this.f6381M) {
                C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "=============导航中保存新设备信息到本地 KWCache.getHuaweiHuid():" + C1462f.m6744i());
                this.f6369A.f3097q = C1462f.m6744i();
                this.f6369A.f3096p = C1462f.m6740g(this.f6380L);
                this.f6369A.f3099s = i + "";
            }
            C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "=============www===mDeviceInfoTable:" + this.f6369A.toString());
            C1392h.m6287a(this.f6398e, C1462f.m6744i(), this.f6369A, true);
            C1462f.m6730c(true);
            C1462f.m6718a(C1392h.m6269a(this.f6398e, C1462f.m6744i(), this.f6380L));
            C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "=============www===mDeviceInfoTable getDeviceInfoTable:" + C1392h.m6269a(this.f6398e, C1462f.m6744i(), this.f6380L));
            C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "=============mDeviceInfoTable:", C1462f.m6748k().toString() + "");
        }
    }

    private void m9924o() {
        C2538c.m12680e("KIDWATCH_ProfileSettingActivity", "======= Enter setDataToCloud ");
        C1506g.m6978a(this, getResources().getString(C1680l.IDS_plugin_kidwatch_common_saving), false);
        this.f6394Z = false;
        this.f6379K.postDelayed(this.f6392X, FileWatchdog.DEFAULT_DELAY);
        if (!this.f6372D || this.f6371C) {
            if (!this.aa) {
                this.aa = true;
                m9864B();
            }
            if (System.currentTimeMillis() - this.f6393Y > 3000) {
                this.f6393Y = System.currentTimeMillis();
                C1483c.m6824a(this.f6398e, C1680l.IDS_plugin_kidwatch_common_saving);
                return;
            }
            return;
        }
        m9925p();
    }

    private void m9925p() {
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "======= Enter saveImageToCloud ");
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "===== KWCache.DEVICE_CODE:", this.f6380L);
        if ("".equals(this.f6380L) || !C1492l.m6919c(this.f6380L)) {
            C1506g.m6979b();
        } else {
            new bk(this).execute(new String[0]);
        }
    }

    private void m9927q() {
        this.f6379K.post(new an(this));
    }

    private void m9930r() {
        C1506g.m6978a(this, "", false);
        GetDeviceProfileRetModel getDeviceProfileRetModel = new GetDeviceProfileRetModel();
        getDeviceProfileRetModel.deviceCode = this.f6380L;
        this.f6376H.mo2483a(getDeviceProfileRetModel, new ao(this));
    }

    private void m9876a(BaseEntityModel baseEntityModel) {
        if (baseEntityModel != null && baseEntityModel.retCode == 0) {
            GetDeviceProfileRetModel getDeviceProfileRetModel = (GetDeviceProfileRetModel) baseEntityModel;
            if (getDeviceProfileRetModel.deviceProfiles != null) {
                DeviceProfile deviceProfile = null;
                if (getDeviceProfileRetModel.deviceProfiles.size() > 0) {
                    deviceProfile = (DeviceProfile) getDeviceProfileRetModel.deviceProfiles.get(0);
                    m9877a(deviceProfile);
                }
                m9910h();
                if (deviceProfile != null) {
                    C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "=== null != deviceInfo");
                }
            } else {
                return;
            }
        }
        C1506g.m6979b();
    }

    private void m9877a(DeviceProfile deviceProfile) {
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "===== Enter updataLocalTable");
        if (deviceProfile == null) {
            C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "===== deviceInfo null ");
            return;
        }
        if (deviceProfile.height <= 0) {
            C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "=============管理员还没有设置过宝贝信息,添加默认值到本地");
            this.f6369A.f3083c = getResources().getString(C1680l.IDS_plugin_kidwatch_settings_profilekid_nickname_default);
            this.f6369A.f3088h = "2008-01-01";
            this.f6369A.f3089i = C1492l.m6920d("110");
            this.f6369A.f3090j = C1492l.m6920d("35");
            this.f6369A.f3091k = 2;
            this.f6369A.f3093m = deviceProfile.simCardNum;
            this.f6369A.f3098r = "";
            this.f6369A.f3097q = deviceProfile.primaryHuid;
            this.f6369A.f3081a = C1462f.m6744i();
        } else {
            this.f6369A.f3083c = deviceProfile.name;
            this.f6369A.f3088h = deviceProfile.birthday;
            this.f6369A.f3089i = deviceProfile.height;
            this.f6369A.f3090j = deviceProfile.weight;
            this.f6369A.f3091k = deviceProfile.sex;
            this.f6369A.f3093m = deviceProfile.simCardNum;
            this.f6369A.f3098r = deviceProfile.bigPortraitUrl;
        }
        C1392h.m6287a(this.f6398e, C1462f.m6744i(), this.f6369A, true);
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "====www=  updataLocalTable mDeviceInfoTable111=" + this.f6369A);
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "====www=  updataLocalTable mDeviceInfoTable222=" + C1392h.m6269a(this.f6398e, C1462f.m6744i(), C1462f.m6746j()));
        C1462f.m6718a(this.f6369A);
        C1462f.m6730c(true);
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "===== Leave updataLocalTable");
    }

    private void m9900c(String str) {
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "dialogBirth() enter ageString:", str);
        this.f6406m.clearFocus();
        if (this.f6409p == null) {
            View inflate = LayoutInflater.from(this.f6398e).inflate(h.dialog_wheelview_in_profile, null);
            ((LinearLayout) inflate.findViewById(g.number_picker2_layout)).setVisibility(0);
            ((LinearLayout) inflate.findViewById(g.number_picker_unit_layout_poifile)).setVisibility(0);
            WheelView wheelView = (WheelView) inflate.findViewById(g.number_picker_profile);
            WheelView wheelView2 = (WheelView) inflate.findViewById(g.number_picker2);
            WheelView wheelView3 = (WheelView) inflate.findViewById(g.number_picker_unit_profile);
            wheelView.setUseDefaultTextColur(false);
            wheelView2.setUseDefaultTextColur(false);
            wheelView3.setUseDefaultTextColur(false);
            C1608i c1608i = new C1608i(wheelView, wheelView2, wheelView3);
            C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "dialogBirth() ageString= " + str);
            if (str.length() > 10) {
                c1608i.m7446a(str.substring(0, 4), str.substring(5, 7), str.substring(8, 10));
            } else if (str.length() == 10) {
                c1608i.m7446a(str.substring(0, 4), str.substring(5, 7), str.substring(8));
            } else {
                c1608i.m7446a(str.substring(0, 4), str.substring(4, 6), str.substring(6));
            }
            m9875a(inflate, c1608i);
            C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "dialogBirth() leave ");
        }
    }

    private void m9875a(View view, C1608i c1608i) {
        C1595v a = new C1595v(this.f6398e).m7339a(C1680l.IDS_plugin_kidwatch_settings_profilekid_info_birth_time);
        a.m7343a(view).m7340a(C1680l.IDS_plugin_kidwatch_common_ok, new aq(this, c1608i)).m7349b(C1680l.IDS_plugin_kidwatch_common_cancel, new ap(this));
        this.f6409p = a.m7338a();
        this.f6409p.setOnDismissListener(new ar(this));
        this.f6409p.setCanceledOnTouchOutside(false);
        this.f6409p.show();
    }

    private void m9878a(C1608i c1608i) {
        int b = c1608i.m7448b();
        int c = c1608i.m7449c();
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "dialogBirth() year= " + b + ",month" + c + ",day" + c1608i.m7450d());
        m9873a(b, c, r2);
        if (!this.f6377I) {
            b = Calendar.getInstance().get(1) - b;
            this.f6369A.f3089i = C1943h.m10167a(b, this.f6375G);
            this.f6369A.f3090j = C1943h.m10169b(b, this.f6375G);
            m9916k();
            m9918l();
            m9893b(true);
        }
    }

    private void m9932s() {
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "dialogWeight() enter ");
        this.f6406m.clearFocus();
        if (this.f6408o == null) {
            View inflate = LayoutInflater.from(this.f6398e).inflate(h.dialog_one_wheelview_in_profile, null);
            m9898c(inflate);
            m9874a(inflate);
            C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "dialogWeight() leave ");
        }
    }

    private void m9874a(View view) {
        this.f6408o = new C1595v(this.f6398e).m7339a(C1680l.IDS_plugin_kidwatch_settings_profilekid_info_weight).m7343a(view).m7340a(C1680l.IDS_plugin_kidwatch_common_ok, new at(this)).m7349b(C1680l.IDS_plugin_kidwatch_common_cancel, new as(this)).m7338a();
        this.f6408o.setOnDismissListener(new au(this));
        this.f6408o.setCanceledOnTouchOutside(false);
        this.f6408o.show();
    }

    private void m9934t() {
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "dialogWeight() weightPicker.getThirdPickerIndex() :  " + this.f6369A.f3090j);
        this.f6369A.f3090j = C1492l.m6920d(this.f6415v.m7424a());
        m9918l();
        m9893b(true);
        this.f6377I = true;
    }

    private void m9935u() {
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "===========dialogHeight() enter ");
        this.f6406m.clearFocus();
        if (this.f6407n == null) {
            View inflate = LayoutInflater.from(this.f6398e).inflate(h.dialog_one_wheelview_in_profile, null);
            m9901d(inflate);
            m9888b(inflate);
            C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "dialogHeight() leave ");
        }
    }

    private void m9888b(View view) {
        this.f6407n = new C1595v(this.f6398e).m7339a(C1680l.IDS_plugin_kidwatch_settings_profilekid_info_height).m7343a(view).m7340a(C1680l.IDS_plugin_kidwatch_common_ok, new aw(this)).m7349b(C1680l.IDS_plugin_kidwatch_common_cancel, new av(this)).m7338a();
        this.f6407n.setOnDismissListener(new ay(this));
        this.f6407n.setCanceledOnTouchOutside(false);
        this.f6407n.show();
    }

    private void m9937v() {
        this.f6369A.f3089i = this.f6416w.m7430d();
        this.f6369A.f3089i = C1492l.m6920d(this.f6416w.m7424a());
        m9916k();
        m9893b(true);
        this.f6377I = true;
    }

    private void m9898c(View view) {
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "initWeightPicker enter");
        WheelView wheelView = (WheelView) view.findViewById(g.number_picker_profile);
        WheelView wheelView2 = (WheelView) view.findViewById(g.number_picker_unit_profile);
        ((TextView) view.findViewById(g.number_picker_unit_poifile_text)).setText(C1680l.IDS_plugin_kidwatch_settings_profilekid_info_kg);
        wheelView2.setUseDefaultTextColur(false);
        wheelView.setUseDefaultTextColur(false);
        this.f6415v = new C1605e(this.f6398e, wheelView, wheelView2);
        int g = C1492l.m6923g(this.f6389U.getText().toString());
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "weightys  = " + g);
        String[] strArr = new String[58];
        for (g = 0; g <= 57; g++) {
            strArr[g] = (g + 3) + "";
        }
        String[] stringArray = getResources().getStringArray(c.IDS_plugin_kidwatch_weight_array_unit_profile);
        this.f6415v.m7425a(new az(this, strArr));
        this.f6415v.m7426a(strArr, Math.max(C1492l.m6923g(this.f6389U.getText().toString()), 3) - 3, true);
        this.f6415v.m7428b(stringArray, 0, false);
    }

    private void m9901d(View view) {
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "===========initHeightPicker enter");
        WheelView wheelView = (WheelView) view.findViewById(g.number_picker_profile);
        WheelView wheelView2 = (WheelView) view.findViewById(g.number_picker_profile);
        WheelView wheelView3 = (WheelView) view.findViewById(g.number_picker_unit_profile);
        wheelView.setUseDefaultTextColur(false);
        wheelView2.setUseDefaultTextColur(false);
        wheelView3.setUseDefaultTextColur(false);
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "===========dialogHeight() 4 ");
        this.f6416w = new C1605e(this.f6398e, wheelView, wheelView2, wheelView3);
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "===========dialogHeight()5 ");
        String[] strArr = new String[141];
        for (int i = 0; i <= 140; i++) {
            strArr[i] = (i + 50) + "";
        }
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "===========dialogHeight()6 ");
        String[] stringArray = getResources().getStringArray(c.IDS_plugin_kidwatch_height_array_unit_profile);
        this.f6416w.m7425a(new ba(this, strArr));
        this.f6416w.m7426a(strArr, Math.max(C1492l.m6923g(this.f6388T.getText().toString()), 50) - 50, true);
        this.f6416w.m7428b(stringArray, 0, false);
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "===========initHeightPicker() leave ");
    }

    public static int m9865a(int i, int i2) {
        return (int) ((((double) i) * 30.48d) + (((double) i2) * 2.54d));
    }

    private void m9872a(int i) {
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "selectGender() gender" + i);
        this.f6406m.clearFocus();
        m9893b(true);
        this.f6375G = i;
        this.f6369A.f3091k = this.f6375G;
        if (2 == i) {
            this.f6387S.setText(C1680l.IDS_plugin_kidwatch_settings_profilekid_info_boy);
            this.f6412s.setImageResource(C1617f.kw_btn_male);
        } else {
            this.f6387S.setText(C1680l.IDS_plugin_kidwatch_settings_profilekid_info_girl);
            this.f6412s.setImageResource(C1617f.kw_btn_female);
        }
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "===========defaultHeadImageFlag:" + this.f6371C);
        if (this.f6371C) {
            m9940w();
        }
    }

    public void mo2616a(boolean z) {
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "=======Enter onChooseDefaultHead");
        m9893b(true);
        if (z) {
            m9940w();
            this.f6371C = true;
            this.f6372D = false;
            this.f6403j.setText(getResources().getString(C1680l.IDS_plugin_kidwatch_settings_profilekid_info_set_success));
        }
    }

    public void mo2615a(af afVar, byte[] bArr) {
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "=======Enter onCorpComplete");
        if (bArr == null) {
            C2538c.m12680e("KIDWATCH_ProfileSettingActivity", "=======imageByte is null ,return");
            return;
        }
        this.f6400g = new byte[bArr.length];
        System.arraycopy(bArr, 0, this.f6400g, 0, bArr.length);
        this.f6399f = new byte[bArr.length];
        System.arraycopy(bArr, 0, this.f6399f, 0, bArr.length);
        Bitmap a = m9944a(this.f6399f);
        this.f6399f = null;
        if (!(a == null || a.isRecycled())) {
            this.f6404k = C1492l.m6903a(a);
            a.recycle();
            this.f6411r.setImageBitmap(this.f6404k);
        }
        this.f6372D = true;
        this.f6371C = false;
        Uri b = this.f6397d.m7240b();
        if (b != null) {
            C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "=======mImgUriStr:", b.getPath());
            String str = C1488h.m6885b(this.f6418y) + File.separator + C1494n.m6927a(str);
            C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "=======editPath:", str);
            if (!new File(str).delete()) {
                C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "======= (new File(editPath)).delete() failure");
            }
            if (new File(b.getPath()).renameTo(new File(str))) {
                C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "=======Rename Success");
                this.f6413t = b.getPath();
            }
        }
        m9893b(true);
        this.f6403j.setText(getResources().getString(C1680l.IDS_plugin_kidwatch_settings_profilekid_info_set_success));
    }

    private void m9940w() {
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "=======Enter changeHeadToDefault");
        this.f6402i = "";
        if (2 == this.f6375G) {
            this.f6411r.setImageDrawable(getResources().getDrawable(C1617f.kw_pic_user_boy));
        } else if (1 == this.f6375G) {
            this.f6411r.setImageDrawable(getResources().getDrawable(C1617f.kw_pic_user_girl));
        } else {
            C2538c.m12680e("KIDWATCH_ProfileSettingActivity", "=======onChooseDefaultHead error happened");
        }
        this.f6413t = "";
    }

    private void m9893b(boolean z) {
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "=======Enter setIsChangeUserInfo");
        this.f6414u = z;
    }

    public Bitmap m9944a(byte[] bArr) {
        if (bArr.length != 0) {
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        }
        return null;
    }

    public void onClick(View view) {
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "=======Enter onClick");
        this.f6406m.clearFocus();
        if (g.setting_btn_head == view.getId()) {
            m9941x();
            return;
        }
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "onClick() id=default!!");
    }

    private void m9941x() {
        this.f6397d.m7238a(af.UPDATE);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "==========onActivityResult requestCode:" + i + "    resultCode:" + i2);
        this.f6397d.m7236a(i, i2, intent);
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "==========onActivityResult2 requestCode:" + i + "    resultCode:" + i2);
    }

    private void m9873a(int i, int i2, int i3) {
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "========Enter setUIBirthday(int year, int month, int day)", i + HwAccountConstants.BLANK + i2 + HwAccountConstants.BLANK + i3 + "");
        this.f6373E = C1492l.m6906a(i, i2, i3, "yyyyMMdd");
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "========sYear:", this.f6373E);
        CharSequence a = C1492l.m6906a(i, i2, i3, "yyyy/MM");
        CharSequence a2 = C1492l.m6906a(i, i2, i3, "dd");
        this.f6369A.f3088h = C1492l.m6906a(i, i2, i3, "yyyy-MM-dd").replace("/", "-");
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "========birthdayContent:", r2);
        this.f6390V.setText(a);
        this.f6391W.setText(a2);
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "setUIBirthday() birthday=" + r2);
    }

    protected void onDestroy() {
        C1506g.m6979b();
        super.onDestroy();
    }

    protected void onStart() {
        if (this.f6417x == null) {
            this.f6417x = new C1565a();
        }
        super.onStart();
    }

    protected void onStop() {
        super.onStop();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "=======================onKeyDown");
        if (this.f6381M || i != 4) {
            if (i == 4) {
                C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "=======================onKeyDown 4");
                if (this.f6381M) {
                    C1483c.m6824a(this.f6398e, C1680l.IDS_plugin_kidwatch_settings_profilekid_warning);
                    return true;
                }
                finish();
                return true;
            }
            C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "=======================onKeyDown 5");
            return super.onKeyDown(i, keyEvent);
        } else if (this.f6414u) {
            m9943z();
            return super.onKeyDown(i, keyEvent);
        } else {
            C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "=======================onKeyDown2");
            finish();
            return super.onKeyDown(i, keyEvent);
        }
    }

    private void m9942y() {
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "=============Enter gotoHomeActivity()===");
        Intent intent = new Intent();
        intent.setClassName(this.f6398e, "com.huawei.pluginkidwatch.home.HomeActivity");
        intent.setPackage(this.f6398e.getPackageName());
        startActivity(intent);
        finish();
    }

    public void onSaveClick(View view) {
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "==========Enter onSaveClick()");
        m9921n();
    }

    public void onBackClick(View view) {
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "=========onBackClick");
        if (this.f6381M) {
            C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "=========Press back in ProfileSettingActivity of guide, So start HomeHomeactivity ");
            C1483c.m6832c(this.f6398e, "请保存宝贝信息");
        } else if (this.f6414u) {
            m9943z();
        } else {
            super.onBackClick(view);
        }
    }

    private void m9943z() {
        if (this.f6374F == null) {
            this.f6374F = new C1507h(this.f6398e, h.dialog_profile_config, m.servicedialog, false);
        }
        this.f6374F.show();
        this.f6374F.findViewById(g.menu_tv_remote_shutdown_cancle).setOnClickListener(new bb(this));
        this.f6374F.findViewById(g.menu_tv_remote_shutdown_sure).setOnClickListener(m9863A());
    }

    @NonNull
    private OnClickListener m9863A() {
        return new bc(this);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "===========Enter onTouchEvent");
        this.f6406m.clearFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (!(motionEvent.getAction() != 0 || getCurrentFocus() == null || getCurrentFocus().getWindowToken() == null)) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
            this.f6406m.clearFocus();
        }
        return super.onTouchEvent(motionEvent);
    }

    private void m9864B() {
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "======= Enter saveBaseInfoToCloud ");
        mo2518d();
        SetDeviceProfileModel setDeviceProfileModel = new SetDeviceProfileModel();
        setDeviceProfileModel.deviceCode = C1492l.m6920d(this.f6380L);
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "===== model.deviceCode:", setDeviceProfileModel.deviceCode + "");
        setDeviceProfileModel.name = this.f6406m.getText().toString();
        setDeviceProfileModel.height = this.f6369A.f3089i;
        setDeviceProfileModel.sex = this.f6375G;
        setDeviceProfileModel.weight = this.f6369A.f3090j;
        setDeviceProfileModel.birthday = this.f6369A.f3088h;
        setDeviceProfileModel.portraitUrl = this.f6401h;
        setDeviceProfileModel.bigPortraitUrl = this.f6402i;
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "==ww== baobei model ==" + setDeviceProfileModel.toString());
        this.f6376H.mo2494a(setDeviceProfileModel, new bd(this));
    }

    private void m9889b(BaseEntityModel baseEntityModel) {
        if (baseEntityModel == null || baseEntityModel.retCode != 0) {
            this.f6379K.removeCallbacks(this.f6392X);
            C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "==========上传失败了");
            C1483c.m6824a(this.f6398e, C1680l.IDS_plugin_kidwatch_settings_profile_save_failed);
        } else {
            this.f6379K.removeCallbacks(this.f6392X);
            CommonRetIModel commonRetIModel = (CommonRetIModel) baseEntityModel;
            String str = "";
            if (C1492l.m6913a((Context) this, C1466a.m6777a())) {
                str = m9945a(C1462f.m6748k().f3093m);
            }
            if (!"".equals(str)) {
                m9948a(this.f6406m.getText().toString(), str);
            }
            C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "====== setDeviceProfile :", commonRetIModel.toString());
            if (this.f6381M) {
                C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "====== www123 is guide");
                m9942y();
            } else {
                C1506g.m6979b();
                finish();
            }
        }
        this.aa = false;
        C1506g.m6979b();
    }

    public void m9948a(String str, String str2) {
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "==ww==  enter  method --upDateName");
        ArrayList arrayList = new ArrayList();
        arrayList.add(ContentProviderOperation.newUpdate(Data.CONTENT_URI).withSelection("raw_contact_id=? AND mimetype=?", new String[]{str2, "vnd.android.cursor.item/name"}).withValue("data1", str).build());
        try {
            getContentResolver().applyBatch("com.android.contacts", arrayList);
        } catch (RemoteException e) {
            C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "==ww==   method --upDateName error RemoteExceptione= " + e.getMessage());
        } catch (OperationApplicationException e2) {
            C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "==ww==   method --upDateName error OperationApplicationExceptione= " + e2.getMessage());
        }
    }

    public String m9945a(String str) {
        Cursor query = getContentResolver().query(Uri.parse("content://com.android.contacts/data/phones/filter/" + str), null, null, null, null);
        if (query == null) {
            return "";
        }
        if (query.getCount() > 0) {
            query.moveToFirst();
            Long valueOf = Long.valueOf(query.getLong(query.getColumnIndex("contact_id")));
            Cursor query2 = getContentResolver().query(RawContacts.CONTENT_URI, new String[]{"_id"}, "contact_id=?", new String[]{String.valueOf(valueOf)}, null);
            if (query2 == null) {
                query.close();
                return "";
            } else if (query2.moveToFirst()) {
                String string = query2.getString(query2.getColumnIndex("_id"));
                query2.close();
                query.close();
                return string;
            } else {
                query2.close();
            }
        }
        query.close();
        return "";
    }
}
