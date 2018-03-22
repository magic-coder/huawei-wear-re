package com.huawei.ui.device.activity.pairing;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.b.a;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwcommonmodel.p063b.C0976c;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.hwservicesmgr.C1047b;
import com.huawei.nfc.carrera.ui.NFCBaseActivity;
import com.huawei.p108n.C1204c;
import com.huawei.p190v.C2538c;
import com.huawei.pluginmessagecenter.service.MessageObserver;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.d.c;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.commonui.dialog.u;
import com.huawei.ui.commonui.dialog.w;
import com.huawei.ui.commonui.titlebar.CustomTitleBar;
import com.huawei.ui.device.e;
import com.huawei.ui.device.f;
import com.huawei.ui.device.g;
import com.huawei.ui.device.i;
import com.huawei.ui.device.p170a.C1975c;
import com.huawei.ui.device.p170a.C1988p;
import com.huawei.ui.device.p170a.C1996x;
import com.huawei.ui.device.p170a.ah;
import com.huawei.ui.main.stories.downloadhihealth.activity.HealthStartActivity;
import com.huawei.ui.main.stories.guide.p181a.C2378a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DevicePairGuideActivity extends BaseActivity implements OnClickListener {
    private TextView f7469A;
    private TextView f7470B;
    private TextView f7471C;
    private TextView f7472D;
    private TextView f7473E;
    private TextView f7474F;
    private LinearLayout f7475G;
    private LinearLayout f7476H;
    private LinearLayout f7477I;
    private TextView f7478J;
    private Button f7479K;
    private RelativeLayout f7480L;
    private ImageView f7481M;
    private TextView f7482N;
    private TextView f7483O;
    private TextView f7484P;
    private TextView f7485Q;
    private FrameLayout f7486R;
    private ImageView f7487S;
    private AnimationDrawable f7488T;
    private RelativeLayout f7489U;
    private ImageView f7490V;
    private String f7491W = "";
    private boolean f7492X = false;
    private ViewTreeObserver f7493Y;
    private final int[] f7494Z = new int[]{i.IDS_device_pair_guide_b2_tip1_ex, i.IDS_select_device_connect_b2_tip_2, i.IDS_device_pair_guide_b2_tip3_ex};
    String f7495a;
    private final int[] aa = new int[]{i.IDS_device_pair_guide_b3_tip1_ex, i.IDS_device_pair_guide_b3_tip2_ex, i.IDS_device_pair_guide_b3_tip3};
    private final int[] ab = new int[]{i.IDS_startup_restart_band_first, i.IDS_device_fragment_b1_pairing_guide_2};
    private final int[] ac = new int[]{i.IDS_device_paring_type_le_des_info_21};
    private final int[] ad = new int[]{i.IDS_device_fragment_n1_pairing_guide_1};
    private final int[] ae = new int[]{i.IDS_device_paring_type_r1_des_info_step1, i.IDS_device_paring_type_r1_des_info_guide_2};
    private final int[] af = new int[]{i.IDS_device_paring_tip_des_info_21};
    private final int[] ag = new int[]{i.IDS_select_device_connect_grus_change_tip_1, i.IDS_select_device_connect_grus_change_tip_2, i.IDS_device_pair_guide_b3_tip3};
    private String ah = "";
    private Handler ai = new C2138w(this);
    private boolean aj = false;
    private List<DeviceInfo> ak = null;
    private C1975c al;
    private C2139x am;
    private boolean an = false;
    private u ao = null;
    private u ap = null;
    private u aq = null;
    private OnKeyListener ar = new C2135t(this);
    private u as = null;
    private C1047b at = new C2126k(this);
    private final BroadcastReceiver au = new C2127l(this);
    String f7496b;
    private Context f7497c;
    private Context f7498d;
    private C1988p f7499e;
    private int f7500f;
    private String f7501g;
    private String f7502h;
    private boolean f7503i;
    private boolean f7504j;
    private CustomTitleBar f7505k;
    private ImageView f7506l;
    private ImageView f7507m;
    private ImageView f7508n;
    private ImageView f7509o;
    private AnimationDrawable f7510p;
    private AnimationDrawable f7511q;
    private AnimationDrawable f7512r;
    private RelativeLayout f7513s;
    private RelativeLayout f7514t;
    private RelativeLayout f7515u;
    private RelativeLayout f7516v;
    private RelativeLayout f7517w;
    private TextView f7518x;
    private TextView f7519y;
    private TextView f7520z;

    protected void onCreate(Bundle bundle) {
        C2538c.m12677c("DevicePairGuideActivity", "Enter onCreate():");
        super.onCreate(bundle);
        this.f7497c = BaseApplication.m2632b();
        this.f7498d = this;
        this.am = new C2139x(Looper.getMainLooper(), this);
        this.f7499e = C1988p.m10381a(BaseApplication.m2632b());
        m10942k();
        this.ah = getIntent().getStringExtra("personalbasicinfosettingflag");
        C2538c.m12677c("DevicePairGuideActivity", "initListView() personalBasicInfoSettingflag = " + this.ah);
        this.f7500f = getIntent().getIntExtra("pairGuideProductType", -1);
        this.f7501g = getIntent().getStringExtra("pairGuideProductName");
        this.f7503i = getIntent().getBooleanExtra("pairGuideW1Success", false);
        this.f7504j = getIntent().getBooleanExtra("pairGuideFromScanList", false);
        this.f7495a = getIntent().getStringExtra("pairGuideSelectName");
        this.f7496b = getIntent().getStringExtra("pairGuideSelectAddress");
        this.aj = getIntent().getBooleanExtra("isPorc", false);
        C2538c.m12677c("DevicePairGuideActivity", "onCreate():deviceProductType = " + this.f7500f + ",deviceProductName=" + this.f7501g + ",pairSuccessFlag=" + this.f7503i + ",name = " + this.f7495a + ",macAddress=" + this.f7496b);
        setContentView(f.activity_device_pairing_guide_black);
        m10903a();
    }

    private void m10903a() {
        C2538c.m12677c("DevicePairGuideActivity", "Enter initView():");
        this.an = false;
        this.al = new C1975c();
        this.f7505k = (CustomTitleBar) d.a(this, e.pair_guide_custom_title);
        this.f7505k.setLeftButtonVisibility(0);
        this.f7506l = (ImageView) d.a(this, e.device_pairing_guide_img);
        this.f7507m = (ImageView) d.a(this, e.device_pairing_guide_b3_anim_img);
        this.f7507m.setVisibility(8);
        this.f7508n = (ImageView) d.a(this, e.pair_guide_left_image);
        this.f7509o = (ImageView) d.a(this, e.pair_guide_right_image);
        if (c.e(this.f7497c)) {
            C2538c.m12677c("DevicePairGuideActivity", "isRTLLanguage!!!");
            this.f7508n.setImageResource(g.ic_arrow_next);
            this.f7509o.setImageResource(g.ic_arrow_previous);
            C2538c.m12677c("DevicePairGuideActivity", "isRTLLanguage!!!!!!!");
        }
        this.f7480L = (RelativeLayout) d.a(this, e.device_pair_guide_text_tips);
        this.f7513s = (RelativeLayout) d.a(this, e.device_pair_guide_text_tips_1);
        this.f7514t = (RelativeLayout) d.a(this, e.device_pair_guide_text_tips_2);
        this.f7515u = (RelativeLayout) d.a(this, e.device_pair_guide_text_tips_3);
        this.f7516v = (RelativeLayout) d.a(this, e.device_pair_guide_text_tips_4);
        this.f7517w = (RelativeLayout) d.a(this, e.device_pair_guide_text_tips_single);
        this.f7518x = (TextView) d.a(this, e.device_pairing_guide_txt_1);
        this.f7519y = (TextView) d.a(this, e.device_pairing_guide_txt_2);
        this.f7520z = (TextView) d.a(this, e.device_pairing_guide_txt_3);
        this.f7469A = (TextView) d.a(this, e.device_pairing_guide_txt_4);
        this.f7470B = (TextView) d.a(this, e.device_pairing_guide_single);
        this.f7471C = (TextView) d.a(this, e.device_pairing_guide_num_text_1);
        this.f7472D = (TextView) d.a(this, e.device_pairing_guide_num_text_2);
        this.f7473E = (TextView) d.a(this, e.device_pairing_guide_num_text_3);
        this.f7474F = (TextView) d.a(this, e.device_pairing_guide_num_text_4);
        m10932f();
        this.f7476H = (LinearLayout) d.a(this, e.pair_guide_left_cancel_layout);
        this.f7477I = (LinearLayout) d.a(this, e.pair_guide_right_btn_layout);
        this.f7486R = (FrameLayout) d.a(this, e.pair_result_device_progress_img);
        this.f7475G = (LinearLayout) d.a(this, e.device_pairing_guide_bottom_arrow_layout);
        this.f7478J = (TextView) d.a(this, e.right_arrow_txt);
        this.f7478J.setText(getResources().getString(i.IDS_device_start_paring_title).toUpperCase());
        this.f7487S = (ImageView) d.a(this, e.device_pair_guide_progress_anim);
        this.f7488T = (AnimationDrawable) this.f7487S.getDrawable();
        this.f7481M = (ImageView) d.a(this, e.pair_result_device_img);
        this.f7493Y = this.f7481M.getViewTreeObserver();
        this.f7493Y.addOnGlobalLayoutListener(new C2116a(this));
        this.f7482N = (TextView) d.a(this, e.pair_result_device_show_txt);
        this.f7485Q = (TextView) d.a(this, e.device_pairing_progress_leo_failure);
        this.f7484P = (TextView) d.a(this, e.device_pairing_progress_guide_single_note);
        this.f7483O = (TextView) d.a(this, e.pair_result_device_privacy_txt);
        this.f7489U = (RelativeLayout) d.a(this, e.device_pair_result_img_text);
        this.f7490V = (ImageView) d.a(this, e.pair_result_device_show_img);
        this.f7476H.setOnClickListener(this);
        this.f7477I.setOnClickListener(this);
        C2538c.m12677c("DevicePairGuideActivity", "===123====fromScanList" + this.f7504j);
        this.al.m10372a(this.f7498d.getApplicationContext(), this.f7500f, this.am, new C2128m(this));
        String string = getResources().getString(i.IDS_sns_compelete);
        this.f7479K = (Button) d.a(this, e.done_button);
        this.f7479K.setText(string.toUpperCase());
        this.f7479K.setOnClickListener(new C2130o(this));
    }

    private void m10914b() {
        C2538c.m12677c("DevicePairGuideActivity", "Enter connectDevice");
        if (this.al.m10377a(this.f7500f)) {
            this.al.m10375a(this.am, this.f7500f, new C2131p(this));
            return;
        }
        C2538c.m12677c("DevicePairGuideActivity", "not v2 device,direct connect");
        m10911a(false);
    }

    private void m10910a(String str, int i) {
        C2538c.m12677c("DevicePairGuideActivity", "Enter noteToHealthwithNocloud");
        w b = new w(this).a(getResources().getString(i.IDS_service_area_notice_title)).b(String.format(getResources().getString(i.IDS_pair_union_note_goto_health_modify), new Object[]{str})).a(i.IDS_pair_union_note_sure, new C2134s(this)).b(i.IDS_pair_union_note_cancle, new C2133r(this));
        if (this.aq == null) {
            this.aq = b.a();
            this.aq.setCanceledOnTouchOutside(false);
            this.aq.setOnKeyListener(this.ar);
            this.aq.show();
        }
    }

    private void m10922c() {
        C2538c.m12677c("DevicePairGuideActivity", "Enter guideToHealth");
        String b = C1988p.m10381a(this.f7497c).m10391b(this.f7500f);
        if (11 == this.f7500f && ("HUAWEI CM-R1P".equals(this.f7495a) || this.f7497c.getString(i.IDS_huawei_r1_pro_content).equals(this.f7495a) || this.f7497c.getString(i.IDS_device_r1_pro_name_title).equals(this.f7495a))) {
            b = this.f7497c.getString(i.IDS_huawei_r1_pro_content);
        }
        if (this.al.m10376a()) {
            m10909a(b);
        } else {
            m10918b(b);
        }
    }

    private void m10909a(String str) {
        C2538c.m12677c("DevicePairGuideActivity", "Enter forceToHealth");
        String string = getResources().getString(i.IDS_app_name_health);
        w b = new w(this).a(getResources().getString(i.IDS_service_area_notice_title)).b(String.format(getResources().getString(i.IDS_pair_union_note_goto_health_switch_force), new Object[]{string, str, string})).a(i.IDS_pair_union_note_sure, new C2137v(this)).b(i.IDS_settings_button_cancal, new C2136u(this));
        if (this.ap == null) {
            this.ap = b.a();
            this.ap.setCanceledOnTouchOutside(false);
            this.ap.show();
            this.ap.setOnKeyListener(this.ar);
        }
    }

    private void m10918b(String str) {
        C2538c.m12677c("DevicePairGuideActivity", "Enter noteToHealth");
        w b = new w(this).a(getResources().getString(i.IDS_service_area_notice_title)).b(String.format(getResources().getString(i.IDS_pair_union_note_goto_health_modify), new Object[]{str})).a(i.IDS_pair_union_note_sure, new C2118c(this)).b(i.IDS_pair_union_note_cancle, new C2117b(this));
        if (this.ao == null) {
            this.ao = b.a();
            this.ao.setCanceledOnTouchOutside(false);
            this.ao.setOnKeyListener(this.ar);
            this.ao.show();
        }
    }

    private void m10927d() {
        PackageInfo k = C0977d.m3572k(this.f7498d);
        if (k != null) {
            C2538c.m12674b("DevicePairGuideActivity", "CommonUtil.HIHEALTH_VERSION_CODE = 20100000 packageInfo.versionCode = " + k.versionCode);
            if (20100000 <= k.versionCode) {
                C2538c.m12677c("DevicePairGuideActivity", "Enter gotoHealth ");
                C0977d.m3529a(this.f7500f, this.f7501g, this.f7496b, this.f7498d, this.aj);
            } else {
                C2538c.m12677c("DevicePairGuideActivity", "Enter gotoHealth download");
                this.f7498d.startActivity(new Intent(this.f7498d, HealthStartActivity.class));
            }
        } else {
            C2538c.m12677c("DevicePairGuideActivity", "Enter gotoHealth download");
            this.f7498d.startActivity(new Intent(this.f7498d, HealthStartActivity.class));
        }
        finish();
    }

    private void m10930e() {
        Object[] objArr = new Object[1];
        StringBuilder append = new StringBuilder().append("AddDevice, device.Type =");
        C1988p c1988p = this.f7499e;
        c1988p = this.f7499e;
        append = append.append(C1988p.m10379a(C1988p.m10380a(this.f7495a))).append(", name = ").append(this.f7495a).append("deviceType=");
        c1988p = this.f7499e;
        objArr[0] = append.append(C1988p.m10380a(this.f7495a)).append("macAddress=").append(this.f7496b).toString();
        C2538c.m12677c("DevicePairGuideActivity", objArr);
        C1988p c1988p2 = this.f7499e;
        C1988p c1988p3 = this.f7499e;
        c1988p3 = this.f7499e;
        int a = C1988p.m10379a(C1988p.m10380a(this.f7495a));
        String str = this.f7495a;
        C1988p.m10381a(this.f7497c);
        c1988p2.m10386a(a, str, C1988p.m10382f(), this.at, this.f7496b);
        ah.m10316a(this.f7497c).m10350q();
    }

    private void m10904a(int i) {
        m10915b(i);
    }

    private void m10911a(boolean z) {
        if (this.f7504j) {
            this.ai.sendEmptyMessage(1);
            if (z) {
                this.ai.postDelayed(new C2119d(this), 2000);
                return;
            } else {
                m10930e();
                return;
            }
        }
        this.ai.sendEmptyMessage(0);
    }

    private void m10915b(int i) {
        w b = new w(this).a(getResources().getString(i.IDS_service_area_notice_title)).b(String.format(getResources().getString(i.IDS_pair_union_note_goto_health_switch_3), new Object[]{getResources().getString(i.IDS_app_name)})).a(i.IDS_settings_button_ok, new C2121f(this)).b(i.IDS_settings_button_cancal, new C2120e(this));
        if (this.as == null) {
            this.as = b.a();
            this.as.setCanceledOnTouchOutside(false);
            this.as.show();
            this.as.setOnKeyListener(this.ar);
        }
    }

    private void m10932f() {
        String string = getResources().getString(i.IDS_device_pair_guide_step);
        this.f7471C.setText(String.format(string, new Object[]{Integer.valueOf(1)}));
        this.f7472D.setText(String.format(string, new Object[]{Integer.valueOf(2)}));
        this.f7473E.setText(String.format(string, new Object[]{Integer.valueOf(3)}));
        this.f7474F.setText(String.format(string, new Object[]{Integer.valueOf(4)}));
    }

    private void m10934g() {
        C2538c.m12677c("DevicePairGuideActivity", "Enter showPairGuide(): deviceProductType = " + this.f7500f);
        this.f7505k.setLeftButtonVisibility(8);
        this.f7492X = false;
        switch (this.f7500f) {
            case 0:
                this.f7506l.setImageResource(com.huawei.ui.device.d.b1_pair_guide_animation);
                this.f7512r = (AnimationDrawable) this.f7506l.getDrawable();
                if (this.f7512r != null) {
                    this.f7512r.start();
                } else {
                    C2538c.m12679d("DevicePairGuideActivity", "b1PairGuideAnimation is null!");
                }
                this.f7513s.setVisibility(0);
                this.f7514t.setVisibility(0);
                this.f7515u.setVisibility(8);
                this.f7517w.setVisibility(8);
                this.f7518x.setText(this.f7497c.getString(this.ab[0], new Object[]{this.f7501g}));
                this.f7519y.setText(this.ab[1]);
                break;
            case 1:
                this.f7506l.setImageResource(com.huawei.ui.device.d.b2_pair_guide_animation);
                this.f7511q = (AnimationDrawable) this.f7506l.getDrawable();
                if (this.f7511q != null) {
                    this.f7511q.start();
                } else {
                    C2538c.m12679d("DevicePairGuideActivity", "b2PairGuideAnimation is null!");
                }
                this.f7513s.setVisibility(0);
                this.f7514t.setVisibility(0);
                this.f7515u.setVisibility(0);
                this.f7517w.setVisibility(8);
                this.f7518x.setText(this.f7494Z[0]);
                this.f7519y.setText(this.f7494Z[1]);
                this.f7520z.setText(this.f7494Z[2]);
                break;
            case 3:
            case 10:
                if (!this.f7503i) {
                    this.ai.sendEmptyMessage(1);
                    this.ai.sendEmptyMessage(4);
                    this.ai.sendEmptyMessage(5);
                    break;
                }
                this.ai.sendEmptyMessage(2);
                break;
            case 4:
                this.f7506l.setImageResource(g.pic_pairing_guide_n1_01);
                this.f7513s.setVisibility(8);
                this.f7514t.setVisibility(8);
                this.f7515u.setVisibility(8);
                this.f7517w.setVisibility(0);
                this.f7470B.setText(this.ad[0]);
                break;
            case 5:
                this.f7506l.setImageResource(g.pic_pairing_guide_b0_01);
                this.f7513s.setVisibility(8);
                this.f7514t.setVisibility(8);
                this.f7515u.setVisibility(8);
                this.f7517w.setVisibility(0);
                this.f7470B.setText(this.f7497c.getString(this.ac[0]));
                break;
            case 7:
                this.f7506l.setImageResource(g.ic_pic_b3_empty_bg);
                this.f7507m.setVisibility(0);
                this.f7507m.setImageResource(com.huawei.ui.device.d.b3_pair_guide_animation);
                this.f7510p = (AnimationDrawable) this.f7507m.getDrawable();
                if (this.f7510p != null) {
                    this.f7510p.start();
                } else {
                    C2538c.m12679d("DevicePairGuideActivity", "mB3PairGuideAnim is null!");
                }
                this.f7513s.setVisibility(0);
                this.f7514t.setVisibility(0);
                this.f7515u.setVisibility(0);
                this.f7517w.setVisibility(8);
                this.f7520z.setText(this.aa[2]);
                ImageGetter c2124i = new C2124i(this);
                String string = this.f7497c.getResources().getString(this.aa[0]);
                String string2 = this.f7497c.getResources().getString(this.aa[1]);
                int indexOf = string.indexOf("%1$s");
                int indexOf2 = string2.indexOf("%1$s");
                if (indexOf > 0) {
                    this.f7518x.setText(string.substring(0, indexOf));
                    this.f7518x.append(Html.fromHtml("<img src='" + g.img_pairing_more + "'/>", c2124i, null));
                    this.f7518x.append(string.substring(indexOf + 4));
                }
                if (indexOf2 > 0) {
                    this.f7519y.setText(string2.substring(0, indexOf2));
                    this.f7519y.append(Html.fromHtml("<img src='" + g.img_bluetooth + "'/>", c2124i, null));
                    this.f7519y.append(string2.substring(indexOf2 + 4));
                    break;
                }
                break;
            case 8:
                this.f7506l.setImageResource(g.pic_pairing_metis_guide);
                this.f7513s.setVisibility(8);
                this.f7514t.setVisibility(8);
                this.f7515u.setVisibility(8);
                this.f7517w.setVisibility(0);
                this.f7470B.setText(this.f7497c.getString(this.ac[0]));
                break;
            case 11:
                if ("HUAWEI CM-R1P".equals(this.f7495a) || this.f7497c.getString(i.IDS_huawei_r1_pro_content).equals(this.f7495a) || this.f7497c.getString(i.IDS_device_r1_pro_name_title).equals(this.f7495a)) {
                    this.f7506l.setImageResource(g.r1_pro_pairing);
                } else {
                    this.f7506l.setImageResource(g.ic_pairing_guide_r1_01);
                }
                this.f7513s.setVisibility(0);
                this.f7514t.setVisibility(0);
                this.f7515u.setVisibility(8);
                this.f7516v.setVisibility(8);
                this.f7517w.setVisibility(8);
                this.f7518x.setText(this.ae[0]);
                this.f7519y.setText(this.ae[1]);
                break;
            case 12:
                this.f7506l.setImageResource(g.ic_pic_a1_empty_bg);
                this.f7513s.setVisibility(8);
                this.f7514t.setVisibility(8);
                this.f7515u.setVisibility(8);
                this.f7517w.setVisibility(0);
                this.f7470B.setText(this.f7497c.getString(this.ac[0], new Object[]{this.f7501g}));
                break;
            case 13:
                this.f7506l.setImageResource(g.pic_pairing_nyx_guide);
                this.f7513s.setVisibility(8);
                this.f7514t.setVisibility(8);
                this.f7515u.setVisibility(8);
                this.f7517w.setVisibility(0);
                this.f7470B.setText(this.f7497c.getString(this.ac[0], new Object[]{this.f7501g}));
                break;
            case 14:
                this.f7506l.setImageResource(g.ic_pic_grus_empty_bg);
                this.f7507m.setVisibility(0);
                this.f7507m.setImageResource(com.huawei.ui.device.d.grus_pair_guide_animation);
                this.f7510p = (AnimationDrawable) this.f7507m.getDrawable();
                if (this.f7510p != null) {
                    this.f7510p.start();
                } else {
                    C2538c.m12679d("DevicePairGuideActivity", "mGRUSPairGuideAnim is null!");
                }
                this.f7513s.setVisibility(0);
                this.f7514t.setVisibility(0);
                this.f7515u.setVisibility(0);
                this.f7517w.setVisibility(8);
                this.f7520z.setText(this.ag[2]);
                CharSequence string3 = this.f7497c.getResources().getString(this.ag[0]);
                CharSequence string4 = this.f7497c.getResources().getString(this.ag[1]);
                this.f7518x.setText(string3);
                this.f7519y.setText(string4);
                break;
            case 15:
                this.f7506l.setImageResource(g.pic_pairing_eris_guide);
                this.f7513s.setVisibility(8);
                this.f7514t.setVisibility(8);
                this.f7515u.setVisibility(8);
                this.f7517w.setVisibility(0);
                this.f7470B.setText(this.f7497c.getString(this.ac[0], new Object[]{this.f7501g}));
                break;
        }
        if (3 != this.f7500f && 10 != this.f7500f) {
            this.ai.sendEmptyMessage(4);
        }
    }

    public void onClick(View view) {
        C2538c.m12677c("DevicePairGuideActivity", "Enter onClick():");
        int id = view.getId();
        if (id == e.pair_guide_left_cancel_layout) {
            C2538c.m12677c("DevicePairGuideActivity", "onClick():cancel");
            m10956r();
            C2538c.m12677c("DevicePairGuideActivity", "Enter noteToHealth 3");
            finish();
        } else if (id == e.pair_guide_right_btn_layout) {
            C2538c.m12677c("DevicePairGuideActivity", "onClick():btn right");
            if ((this.f7500f == 3 || this.f7500f == 10) && this.f7478J.getText().toString().equalsIgnoreCase(this.f7497c.getResources().getString(i.IDS_device_fragment_pairing_btn_open_android_wear))) {
                C2538c.m12677c("DevicePairGuideActivity", "onClick():btn_right, W1向导");
                m10939j();
            } else if (this.f7478J.getText().toString().equalsIgnoreCase(this.f7497c.getResources().getString(i.IDS_sns_compelete).toUpperCase()) || this.f7478J.getText().toString().equalsIgnoreCase(this.f7497c.getResources().getString(i.IDS_startup_next).toUpperCase())) {
                Intent intent;
                C2538c.m12677c("DevicePairGuideActivity", "mConnectStateChangedReceiver(): setResult = 2");
                m10935h();
                setResult(2);
                if (10 == this.f7500f) {
                    C2538c.m12677c("DevicePairGuideActivity", "androidwear = " + new C2378a(BaseApplication.m2632b()).m12004h());
                    if (new C2378a(BaseApplication.m2632b()).m12004h()) {
                        C2538c.m12677c("DevicePairGuideActivity", "跳转到主页");
                        intent = new Intent();
                        intent.setClassName(this, "com.huawei.bone.root.MainActivity");
                        startActivity(intent);
                        finish();
                        return;
                    }
                }
                C2538c.m12677c("DevicePairGuideActivity", "onClick() value = " + C0996a.m3612a(this.f7497c, String.valueOf(MessageObserver.RET_CHECK_PARAM_ERROR), "first_pair_success_status"));
                if ("true".equals(C0996a.m3612a(this.f7497c, String.valueOf(MessageObserver.RET_CHECK_PARAM_ERROR), "first_pair_success_status"))) {
                    finish();
                    return;
                }
                C0996a.m3611a(this.f7497c, String.valueOf(MessageObserver.RET_CHECK_PARAM_ERROR), "first_pair_success_status", "true", null);
                PackageInfo k = C0977d.m3572k(this.f7497c);
                C2378a c2378a = new C2378a(BaseApplication.m2632b());
                if (k != null) {
                    C2538c.m12677c("DevicePairGuideActivity", "!isFromDevicePairToEnter (ELSE) CommonUtil.HIHEALTH_VERSION_CODE = 20100000 packageInfo.versionCode = " + k.versionCode);
                    if (20100000 <= k.versionCode || c2378a.m12000f()) {
                        finish();
                        return;
                    }
                    intent = new Intent(this.f7497c, HealthStartActivity.class);
                    intent.putExtra("is_frome_device_pair_guide_activity_to_enter", true);
                    startActivityForResult(intent, 1);
                    if (this.ah != null && this.ah.equals("personalbasicinfosetting")) {
                        finish();
                    }
                } else if (c2378a.m12000f()) {
                    finish();
                } else {
                    intent = new Intent(this.f7497c, HealthStartActivity.class);
                    intent.putExtra("is_frome_device_pair_guide_activity_to_enter", true);
                    startActivityForResult(intent, 1);
                    if (this.ah != null && this.ah.equals("personalbasicinfosetting")) {
                        finish();
                    }
                }
            } else {
                this.ai.sendEmptyMessage(4);
            }
        } else {
            C2538c.m12677c("DevicePairGuideActivity", "onClick():i =" + id);
        }
    }

    private void m10935h() {
        Map hashMap = new HashMap();
        switch (this.f7500f) {
            case -2:
                hashMap.put("devicename", "AF500");
                break;
            case 0:
                hashMap.put("devicename", "B1");
                break;
            case 1:
                hashMap.put("devicename", "B2");
                break;
            case 2:
                hashMap.put("devicename", "k1");
                break;
            case 3:
                hashMap.put("devicename", "huawei watch");
                break;
            case 5:
                hashMap.put("devicename", "B0");
                break;
            case 7:
                hashMap.put("devicename", "B3");
                break;
            case 8:
                hashMap.put("devicename", "metis");
                break;
            case 9:
                hashMap.put("devicename", "k2");
                break;
            case 10:
                hashMap.put("devicename", "huawei watch2");
                break;
            case 11:
                hashMap.put("devicename", "HUAWEI AM-R1");
                break;
            case 12:
                hashMap.put("devicename", "A2");
                break;
            case 13:
                hashMap.put("devicename", "NYX");
                break;
            case 14:
                hashMap.put("devicename", "Grus");
                break;
            case 15:
                hashMap.put("devicename", "ERIS");
                break;
            default:
                hashMap.put("devicename", "unknown");
                break;
        }
        if (3 == this.f7500f || 10 == this.f7500f) {
            C1204c.m5370a(this.f7497c).m5425a(new C2125j(this, hashMap));
            return;
        }
        hashMap.put("mac", this.f7502h);
        com.huawei.l.a.c.a().a(BaseApplication.m2632b(), a.A.a(), hashMap, 0);
    }

    private void m10937i() {
        C2538c.m12677c("DevicePairGuideActivity", "enter startAddDevice():");
        this.ai.sendEmptyMessage(6);
        if (11 == this.f7500f) {
            List arrayList = new ArrayList();
            if ("HUAWEI CM-R1P".equals(this.f7495a) || this.f7497c.getString(i.IDS_huawei_r1_pro_content).equals(this.f7495a) || this.f7497c.getString(i.IDS_device_r1_pro_name_title).equals(this.f7495a)) {
                arrayList.add("HUAWEI CM-R1P");
            } else {
                arrayList.add("HUAWEI AM-R1");
            }
            C1988p c1988p = this.f7499e;
            C1988p c1988p2 = this.f7499e;
            c1988p.m10386a(C1988p.m10379a(this.f7500f), this.f7501g, arrayList, this.at, null);
            return;
        }
        c1988p = this.f7499e;
        c1988p2 = this.f7499e;
        c1988p.m10386a(C1988p.m10379a(this.f7500f), this.f7501g, C1996x.m10456a(this.f7500f), this.at, null);
    }

    private void m10939j() {
        PackageInfo packageInfo;
        String str = "com.google.android.wearable.app";
        String str2 = NFCBaseActivity.AW_NAME_CN;
        PackageManager packageManager = this.f7497c.getPackageManager();
        try {
            packageInfo = packageManager.getPackageInfo(str2, 0);
        } catch (NameNotFoundException e) {
            C2538c.m12677c("DevicePairGuideActivity", "onClick() androidWearNameCn, error = " + e.getMessage());
            try {
                packageInfo = packageManager.getPackageInfo(str, 0);
            } catch (NameNotFoundException e2) {
                C2538c.m12677c("DevicePairGuideActivity", "onClick() androidWearName, error = " + e2.getMessage());
                com.huawei.ui.commonui.c.a.a(this.f7497c, this.f7497c.getString(i.IDS_device_hauwei_watch_download_android_wear_tips));
                packageInfo = null;
            }
        }
        if (packageInfo != null) {
            Intent intent = new Intent("android.intent.action.MAIN", null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(packageInfo.packageName);
            ResolveInfo resolveInfo = (ResolveInfo) this.f7497c.getPackageManager().queryIntentActivities(intent, 0).iterator().next();
            if (resolveInfo != null) {
                String str3 = resolveInfo.activityInfo.packageName;
                str = resolveInfo.activityInfo.name;
                intent = new Intent("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.setComponent(new ComponentName(str3, str));
                startActivity(intent);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        C2538c.m12677c("DevicePairGuideActivity", "Enter onActivityResult()");
        super.onActivityResult(i, i2, intent);
        if (1 == i && i2 == 2) {
            setResult(2);
            finish();
        }
    }

    private void m10942k() {
        IntentFilter intentFilter = new IntentFilter("com.huawei.bone.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("com.huawei.bone.action.CONNECTION_STATE_CHANGED");
        registerReceiver(this.au, intentFilter, C0976c.f1642a, null);
    }

    private void m10944l() {
        C2538c.m12677c("DevicePairGuideActivity", "enter showPairProcess()");
        this.f7505k.setLeftButtonVisibility(8);
        this.f7492X = true;
        this.f7506l.setVisibility(8);
        this.f7507m.setVisibility(8);
        this.f7480L.setVisibility(8);
        this.f7475G.setVisibility(8);
        this.f7486R.setVisibility(0);
        this.f7489U.setVisibility(0);
        this.f7484P.setVisibility(8);
        this.f7483O.setVisibility(8);
        this.f7490V.setVisibility(8);
        this.f7482N.setText(this.f7497c.getString(i.IDS_blite_guide_paire_opt_title));
        this.f7485Q.setVisibility(8);
        switch (this.f7500f) {
            case 0:
                this.f7481M.setImageResource(g.ic_pairing_result_b1);
                break;
            case 1:
                this.f7481M.setImageResource(g.ic_pairing_result_b2);
                break;
            case 3:
                this.f7481M.setImageResource(g.ic_pairing_result_huawei_watch);
                this.f7477I.setVisibility(8);
                break;
            case 4:
                this.f7481M.setImageResource(g.ic_pairing_result_n1);
                break;
            case 5:
                this.f7481M.setImageResource(g.ic_pairing_result_b0);
                this.f7484P.setVisibility(0);
                this.f7484P.setText(this.f7497c.getString(this.af[0], new Object[]{this.f7501g}));
                break;
            case 7:
                this.f7481M.setImageResource(g.ic_pairing_result_gemini);
                break;
            case 8:
                this.f7481M.setImageResource(g.ic_pairing_metis);
                this.f7484P.setVisibility(0);
                this.f7484P.setText(this.f7497c.getString(this.af[0], new Object[]{this.f7501g}));
                break;
            case 10:
                this.f7481M.setImageResource(g.ic_pairing_result_huawei_watch2);
                this.f7477I.setVisibility(8);
                break;
            case 11:
                this.f7481M.setImageResource(g.ic_pairing_result_n1);
                break;
            case 12:
                this.f7481M.setImageResource(g.ic_pairing_result_a1);
                this.f7484P.setVisibility(0);
                this.f7484P.setText(this.f7497c.getString(this.af[0], new Object[]{this.f7501g}));
                break;
            case 13:
                this.f7481M.setImageResource(g.ic_pairing_result_nyx);
                this.f7484P.setVisibility(0);
                this.f7484P.setText(this.f7497c.getString(this.af[0], new Object[]{this.f7501g}));
                break;
            case 14:
                this.f7481M.setImageResource(g.ic_pairing_result_grus);
                break;
            case 15:
                this.f7481M.setImageResource(g.ic_pairing_eris);
                this.f7484P.setVisibility(0);
                this.f7484P.setText(this.f7497c.getString(this.af[0], new Object[]{this.f7501g}));
                break;
        }
        this.f7488T.start();
        C2538c.m12677c("DevicePairGuideActivity", "开启动画");
    }

    private void m10923c(int i) {
        C2538c.m12677c("DevicePairGuideActivity", "Enter showPairFailureResult():");
        com.huawei.l.a.c.a().a(BaseApplication.m2632b(), a.dh.a(), new HashMap(), 0);
        this.f7488T.stop();
        C2538c.m12677c("DevicePairGuideActivity", "停止动画");
        this.f7505k.setLeftButtonVisibility(8);
        this.f7492X = false;
        this.f7506l.setVisibility(8);
        this.f7507m.setVisibility(8);
        this.f7480L.setVisibility(8);
        this.f7475G.setVisibility(0);
        this.f7476H.setVisibility(0);
        this.f7478J.setText(getResources().getString(i.IDS_retry).toUpperCase());
        this.f7486R.setVisibility(0);
        this.f7489U.setVisibility(0);
        this.f7484P.setVisibility(8);
        this.f7490V.setVisibility(0);
        this.f7490V.setImageResource(g.ic_pairing_result_failure);
        this.f7482N.setText(i.IDS_blite_guide_paire_fail);
        this.f7483O.setVisibility(8);
        switch (this.f7500f) {
            case 0:
                this.f7481M.setImageResource(g.ic_pairing_result_b1);
                m10947n();
                return;
            case 1:
                this.f7481M.setImageResource(g.ic_pairing_result_b2);
                m10947n();
                return;
            case 3:
                this.f7481M.setImageResource(g.ic_pairing_result_huawei_watch);
                this.f7482N.setText(this.f7497c.getResources().getString(i.IDS_blite_guide_paire_fail));
                this.f7482N.setVisibility(8);
                this.f7485Q.setText(m10945m());
                this.f7485Q.setVisibility(0);
                this.ai.sendEmptyMessage(5);
                C2538c.m12677c("DevicePairGuideActivity", "提示用户打开Android Wear");
                this.f7477I.setVisibility(0);
                this.f7478J.setText(i.IDS_device_fragment_pairing_btn_open_android_wear);
                return;
            case 4:
                this.f7481M.setImageResource(g.ic_pairing_result_n1);
                m10947n();
                return;
            case 5:
                this.f7481M.setImageResource(g.ic_pairing_result_b0);
                m10947n();
                return;
            case 7:
                this.f7481M.setImageResource(g.ic_pairing_result_gemini);
                if (i == 1) {
                    C2538c.m12677c("DevicePairGuideActivity", "PairFailureResult B3 errorType ：1");
                    this.f7484P.setVisibility(0);
                    this.f7484P.setText(i.IDS_band_is_unavailable_tip_string_new);
                    return;
                }
                m10947n();
                return;
            case 8:
                this.f7481M.setImageResource(g.ic_pairing_metis);
                m10947n();
                return;
            case 10:
                this.f7481M.setImageResource(g.ic_pairing_result_huawei_watch2);
                this.f7482N.setText(this.f7497c.getResources().getString(i.IDS_blite_guide_paire_fail));
                this.f7482N.setVisibility(8);
                this.f7485Q.setText(m10945m());
                this.f7485Q.setVisibility(0);
                this.ai.sendEmptyMessage(5);
                C2538c.m12677c("DevicePairGuideActivity", "提示用户打开Android Wear");
                this.f7477I.setVisibility(0);
                this.f7478J.setText(i.IDS_device_fragment_pairing_btn_open_android_wear);
                return;
            case 11:
                this.f7481M.setImageResource(g.ic_pairing_result_n1);
                m10947n();
                return;
            case 12:
                this.f7481M.setImageResource(g.ic_pairing_result_a1);
                m10947n();
                return;
            case 13:
                this.f7481M.setImageResource(g.ic_pairing_result_nyx);
                m10950o();
                return;
            case 14:
                this.f7481M.setImageResource(g.ic_pairing_result_grus);
                if (i == 1) {
                    C2538c.m12677c("DevicePairGuideActivity", "PairFailureResult GRUS errorType ：1");
                    this.f7484P.setVisibility(0);
                    this.f7484P.setText(i.IDS_band_is_unavailable_tip_string_new);
                    return;
                }
                m10947n();
                return;
            case 15:
                this.f7481M.setImageResource(g.ic_pairing_eris);
                m10950o();
                return;
            default:
                return;
        }
    }

    private String m10945m() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f7497c.getResources().getString(i.IDS_compatibility_note_reasons));
        stringBuffer.append("\n");
        stringBuffer.append(String.format(this.f7497c.getResources().getString(i.IDS_compatibility_note_not_connected_with_android_wear), new Object[]{"1"}));
        stringBuffer.append("\n");
        stringBuffer.append(String.format(this.f7497c.getResources().getString(i.IDS_compatibility_note_low_watch_version), new Object[]{"2"}));
        stringBuffer.append("\n");
        if (c.c(this.f7497c)) {
            stringBuffer.append(String.format(this.f7497c.getResources().getString(i.IDS_compatibility_Android_Wear_low_watch_version), new Object[]{"3"}));
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }

    private void m10947n() {
        C2538c.m12677c("DevicePairGuideActivity", "enter showPairFailureNote():" + this.f7500f);
        this.f7484P.setVisibility(0);
        String b = this.f7499e.m10391b(this.f7500f);
        C2538c.m12677c("DevicePairGuideActivity", "content = " + b);
        if (11 == this.f7500f && ("HUAWEI CM-R1P".equals(this.f7495a) || this.f7497c.getString(i.IDS_huawei_r1_pro_content).equals(this.f7495a) || this.f7497c.getString(i.IDS_device_r1_pro_name_title).equals(this.f7495a))) {
            b = this.f7497c.getString(i.IDS_huawei_r1_pro_content);
        }
        this.f7484P.setText(String.format(this.f7497c.getResources().getString(i.IDS_blite_guide_paire_fail_help_string), new Object[]{b}));
    }

    private void m10950o() {
        C2538c.m12677c("DevicePairGuideActivity", "enter showPairFailureOnlyPhoneNote():" + this.f7500f);
        this.f7484P.setVisibility(0);
        this.f7484P.setText(this.f7497c.getResources().getString(i.IDS_blite_guide_paire_fail_help_no_band_string));
    }

    private void m10952p() {
        C2538c.m12677c("DevicePairGuideActivity", "Enter showPairSuccessResult():");
        this.f7488T.stop();
        C2538c.m12677c("DevicePairGuideActivity", "停止动画");
        this.f7505k.setLeftButtonVisibility(8);
        this.f7492X = true;
        this.f7506l.setVisibility(8);
        this.f7507m.setVisibility(8);
        this.f7480L.setVisibility(8);
        this.f7486R.setVisibility(0);
        this.f7489U.setVisibility(0);
        this.f7484P.setVisibility(8);
        this.f7490V.setVisibility(0);
        this.f7490V.setImageResource(g.ic_pairing_completed);
        this.f7482N.setText(i.IDS_blite_guide_paire_completed);
        this.f7483O.setVisibility(0);
        this.f7483O.setText(this.f7497c.getResources().getString(i.IDS_device_paring_success_descommon_info_new));
        this.f7475G.setVisibility(0);
        this.f7476H.setVisibility(8);
        this.f7477I.setVisibility(0);
        C2378a c2378a = new C2378a(BaseApplication.m2632b());
        C2538c.m12677c("DevicePairGuideActivity", "Enter MSG_SHOW_PAIR_SUCCESS_RESULT():");
        c2378a.m12012l(true);
        PackageInfo k = C0977d.m3572k(this.f7497c);
        if (k != null) {
            C2538c.m12677c("DevicePairGuideActivity", "showPairSuccessResult CommonUtil.HIHEALTH_VERSION_CODE = 20100000 packageInfo.versionCode = " + k.versionCode);
            if (20100000 <= k.versionCode || c2378a.m12000f()) {
                d.a(this, e.pair_text_layout).setVisibility(8);
                this.f7479K.setVisibility(0);
            } else {
                this.f7478J.setText(getResources().getString(i.IDS_startup_next).toUpperCase());
            }
        } else if (c2378a.m12000f()) {
            d.a(this, e.pair_text_layout).setVisibility(8);
            this.f7479K.setVisibility(0);
        } else {
            this.f7478J.setText(getResources().getString(i.IDS_startup_next).toUpperCase());
        }
        switch (this.f7500f) {
            case 0:
                this.f7481M.setImageResource(g.ic_pairing_result_b1);
                return;
            case 1:
                this.f7481M.setImageResource(g.ic_pairing_result_b2);
                return;
            case 3:
                this.f7481M.setImageResource(g.ic_pairing_result_huawei_watch);
                return;
            case 4:
                this.f7481M.setImageResource(g.ic_pairing_result_n1);
                return;
            case 5:
                this.f7481M.setImageResource(g.ic_pairing_result_b0);
                return;
            case 7:
                this.f7481M.setImageResource(g.ic_pairing_result_gemini);
                return;
            case 8:
                this.f7481M.setImageResource(g.ic_pairing_metis);
                return;
            case 10:
                this.f7481M.setImageResource(g.ic_pairing_result_huawei_watch2);
                return;
            case 11:
                this.f7481M.setImageResource(g.ic_pairing_result_n1);
                return;
            case 12:
                this.f7481M.setImageResource(g.ic_pairing_result_a1);
                return;
            case 13:
                this.f7481M.setImageResource(g.ic_pairing_result_nyx);
                return;
            case 14:
                this.f7481M.setImageResource(g.ic_pairing_result_grus);
                return;
            case 15:
                this.f7481M.setImageResource(g.ic_pairing_eris);
                return;
            default:
                return;
        }
    }

    private void m10954q() {
        try {
            unregisterReceiver(this.au);
        } catch (IllegalArgumentException e) {
            C2538c.m12677c("DevicePairGuideActivity", e.getMessage());
        } catch (RuntimeException e2) {
            C2538c.m12677c("DevicePairGuideActivity", e2.getMessage());
        }
    }

    protected void onStart() {
        C2538c.m12677c("DevicePairGuideActivity", "Enter onStart():");
        super.onStart();
    }

    protected void onRestart() {
        C2538c.m12677c("DevicePairGuideActivity", "Enter onRestart():");
        super.onRestart();
    }

    protected void onResume() {
        C2538c.m12677c("DevicePairGuideActivity", "Enter onResume():");
        super.onResume();
    }

    protected void onPause() {
        C2538c.m12677c("DevicePairGuideActivity", "Enter onPause():");
        super.onPause();
    }

    protected void onStop() {
        C2538c.m12677c("DevicePairGuideActivity", "Enter onStop():");
        super.onStop();
    }

    protected void onDestroy() {
        C2538c.m12677c("DevicePairGuideActivity", "Enter onDestroy():");
        super.onDestroy();
        m10956r();
        this.f7492X = false;
        m10954q();
        if (this.ai != null) {
            this.ai.removeCallbacksAndMessages(null);
        }
        if (this.am != null) {
            this.am.removeCallbacksAndMessages(null);
        }
        this.f7503i = false;
        C0977d.m3575n(this.f7497c);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.f7492X) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void onBackPressed() {
        C2538c.m12677c("DevicePairGuideActivity", "Enter onBackPressed():");
        m10956r();
        super.onBackPressed();
    }

    private void m10919b(boolean z) {
        C2538c.m12677c("DevicePairGuideActivity", "enter enableScanBtn():enable = " + z);
        this.f7477I.setEnabled(z);
    }

    private void m10956r() {
        C2538c.m12677c("DevicePairGuideActivity", "enter stopPairGuideAnim():!");
        if (this.f7512r != null) {
            this.f7512r.stop();
            this.f7512r = null;
        } else {
            C2538c.m12679d("DevicePairGuideActivity", "b1PairGuideAnimation is null!");
        }
        if (this.f7511q != null) {
            this.f7511q.stop();
            this.f7512r = null;
        } else {
            C2538c.m12679d("DevicePairGuideActivity", "b2PairGuideAnimation is null!");
        }
        if (this.f7510p != null) {
            this.f7510p.stop();
            this.f7512r = null;
            return;
        }
        C2538c.m12679d("DevicePairGuideActivity", "b1PairGuideAnimation is null!");
    }
}
