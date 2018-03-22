package com.huawei.ui.main.stories.guide.activity;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.ab.C0630m;
import com.huawei.hihealth.HiUserInfo;
import com.huawei.hwbasemgr.C0956c;
import com.huawei.hwcloudmodel.p060b.C0969i;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.d.n;
import com.huawei.hwcommonmodel.p063b.C0976c;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.hwfitnessmgr.C1026q;
import com.huawei.login.p087a.C1092a;
import com.huawei.login.ui.login.util.ILoginCallback;
import com.huawei.login.ui.login.util.b;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.b.e;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.d.c;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.commonui.dialog.CustomAlertDialog;
import com.huawei.ui.commonui.dialog.ai;
import com.huawei.ui.commonui.dialog.ak;
import com.huawei.ui.commonui.dialog.j;
import com.huawei.ui.commonui.dialog.l;
import com.huawei.ui.commonui.dialog.u;
import com.huawei.ui.commonui.dialog.w;
import com.huawei.ui.commonui.wheelview.a;
import com.huawei.ui.main.f;
import com.huawei.ui.main.g;
import com.huawei.ui.main.i;
import com.huawei.ui.main.k;
import com.huawei.ui.main.stories.guide.p181a.C2378a;
import com.huawei.up.model.UserInfomation;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BasicInfoSettingActivity extends BaseActivity implements OnRequestPermissionsResultCallback, OnClickListener, e {
    private static String[] f8572R = new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA"};
    private static long f8573c = 0;
    private a f8574A;
    private a f8575B;
    private a f8576C;
    private boolean f8577D = false;
    private String f8578E = "";
    private String f8579F;
    private C2378a f8580G;
    private UserInfomation f8581H;
    private com.huawei.ui.main.stories.a.a.a f8582I;
    private com.huawei.ui.commonui.b.a f8583J;
    private C0630m f8584K;
    private ExecutorService f8585L;
    private boolean f8586M = false;
    private boolean f8587N = false;
    private boolean f8588O = false;
    private boolean f8589P = false;
    private C1092a f8590Q = null;
    private final BroadcastReceiver f8591S = new C2379a(this);
    private Handler f8592T = new C2403y(this);
    private ILoginCallback f8593U = new ac(this);
    private TextWatcher f8594V = new C2385g(this);
    private OnItemClickListener f8595W = new C2388j(this);
    private Context f8596a;
    private Context f8597b;
    private LinearLayout f8598d;
    private LinearLayout f8599e;
    private LinearLayout f8600f;
    private LinearLayout f8601g;
    private TextView f8602h;
    private TextView f8603i;
    private TextView f8604j;
    private TextView f8605k;
    private TextView f8606l;
    private TextView f8607m;
    private EditText f8608n;
    private ImageView f8609o;
    private ImageView f8610p;
    private com.huawei.ui.commonui.dialog.a f8611q = null;
    private u f8612r = null;
    private ai f8613s = null;
    private CustomAlertDialog f8614t = null;
    private CustomAlertDialog f8615u = null;
    private CustomAlertDialog f8616v = null;
    private j f8617w;
    private l f8618x;
    private boolean[] f8619y = new boolean[]{true, false, false};
    private int f8620z = 0;

    private void m12062c() {
        C2538c.m12677c("BasicInfoSettingActivity", "enter getUserInfo");
        this.f8580G.m11988a(new C2390l(this));
    }

    private void m12065d() {
        C0630m.m2297a(BaseApplication.m2632b()).m2305a(this.f8597b, new C2401w(this));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1026q.m4018a(BaseApplication.m2632b());
        setContentView(g.activity_guide_basic_info_setting21);
        this.f8596a = BaseApplication.m2632b();
        this.f8590Q = new C1092a(this.f8596a, this.f8593U);
        this.f8584K = C0630m.m2297a(this.f8596a);
        this.f8585L = Executors.newSingleThreadExecutor();
        Intent intent = getIntent();
        if (intent != null) {
            C2538c.m12677c("BasicInfoSettingActivity", "onCreate() path = " + intent.getStringExtra("flag") + " BasicInfoSettingActivity.PERSONAL_CENTER = " + "personal");
            if ("personal".equals(intent.getStringExtra("flag"))) {
                this.f8584K.m2306a(new C2404z(this));
            }
        } else {
            C2538c.m12677c("BasicInfoSettingActivity", "onCreate() intent is null");
        }
        this.f8597b = this;
        m12081l();
        m12098u();
        m12068f();
    }

    private boolean m12067e() {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f8573c > 500) {
            z = false;
        } else {
            z = true;
        }
        f8573c = currentTimeMillis;
        return z;
    }

    private void m12068f() {
        if (this.f8586M) {
            C2538c.m12677c("BasicInfoSettingActivity", "onCreate() if (mifNoNeedLogin)");
            if (this.f8584K != null) {
                this.f8584K.m2315b(BaseApplication.m2632b());
                this.f8585L.execute(new aa(this));
                return;
            }
            return;
        }
        m12070g();
    }

    private void m12070g() {
        if (this.f8590Q != null) {
            this.f8590Q.m4731a(this.f8597b);
        }
    }

    private void m12050a(b bVar) {
        C2538c.m12677c("BasicInfoSettingActivity", "Enter loginHealthFailure");
        if (bVar != null) {
            C2538c.m12674b("BasicInfoSettingActivity", "login loginResult = ", bVar);
            int a = bVar.a();
            C2538c.m12677c("BasicInfoSettingActivity", "login errcode = ", Integer.valueOf(a));
            runOnUiThread(new ad(this));
        }
    }

    private void m12072h() {
        C2538c.m12677c("BasicInfoSettingActivity", "Enter loginHealthSuccess");
        runOnUiThread(new ae(this));
    }

    private void m12074i() {
        C2538c.m12677c("BasicInfoSettingActivity", "handleWhenLogin()");
        m12056a(this.f8596a.getString(com.huawei.ui.main.j.IDS_basic_info_downloading));
        this.f8592T.sendEmptyMessageDelayed(2, 35000);
    }

    private void m12076j() {
        C2538c.m12677c("BasicInfoSettingActivity", "handleWhenNOTLogin()");
        m12090q();
    }

    private void m12079k() {
        IntentFilter intentFilter = new IntentFilter("com.huawei.bone.action.FITNESS_USERINFO_UPDATED");
        LocalBroadcastManager instance = LocalBroadcastManager.getInstance(this.f8596a);
        if (instance != null) {
            instance.registerReceiver(this.f8591S, intentFilter);
        }
    }

    private void m12081l() {
        this.f8580G = new C2378a(this.f8596a);
        this.f8582I = com.huawei.ui.main.stories.a.a.a.a(this.f8596a);
        this.f8583J = new com.huawei.ui.commonui.b.a(this);
        this.f8583J.a(this);
        Intent intent = getIntent();
        this.f8588O = intent.getBooleanExtra("haveDevice", false);
        C2538c.m12677c("BasicInfoSettingActivity", "is have device " + this.f8588O);
        String stringExtra = intent.getStringExtra("flag");
        if (stringExtra != null && stringExtra.equals("personal")) {
            C2538c.m12677c("BasicInfoSettingActivity", "initData() if (flag != null && flag.equals(PERSONAL_CENTER))");
            this.f8587N = true;
        }
        if (this.f8587N || !this.f8584K.m2320e()) {
            C2538c.m12677c("BasicInfoSettingActivity", "initData() if (mIfPreActivityIsPersonalCenter || !mHWUserProfileMgr.getIfAccountArea())");
            this.f8586M = true;
        }
        this.f8581H = new UserInfomation();
        com.huawei.hwcloudmodel.mgr.a.a(this.f8596a);
        m12079k();
    }

    private void m12054a(UserInfomation userInfomation) {
        C2538c.m12677c("BasicInfoSettingActivity", "handleWhenGetUserInfoSuccess()! ");
        this.f8581H = userInfomation;
        if (C0969i.m3482a(35)) {
            if (C0956c.m3349a()) {
                if (this.f8581H.getClientSet() == 0) {
                    this.f8581H.setWeight(Integer.valueOf(com.huawei.hwcommonmodel.d.e.g(this.f8581H.getWeight())));
                    this.f8581H.setHeight(Integer.valueOf(com.huawei.hwcommonmodel.d.e.e(this.f8581H.getHeight())));
                    this.f8581H.setClientSet(Integer.valueOf(1));
                }
            } else if (1 == this.f8581H.getClientSet()) {
                this.f8581H.setWeight(Integer.valueOf(com.huawei.hwcommonmodel.d.e.f(this.f8581H.getWeight())));
                int height = this.f8581H.getHeight() / 12;
                this.f8581H.setHeight(Integer.valueOf(com.huawei.hwcommonmodel.d.e.b(height, this.f8581H.getHeight() - (height * 12))));
                this.f8581H.setClientSet(Integer.valueOf(0));
            }
        }
        m12082m();
        m12110a();
        this.f8592T.removeMessages(2);
        m12038M();
        m12101v();
    }

    private void m12082m() {
        if (this.f8581H.getClientSet() == 1) {
            C0956c.m3348a(true);
        } else {
            C0956c.m3348a(false);
        }
    }

    public void m12110a() {
        if (this.f8581H.getClientSet() == 1) {
            if (this.f8581H.getHeight() != 0) {
                if (this.f8581H.getHeight() > 107) {
                    C2538c.m12679d("BasicInfoSettingActivity", "checkUserInformation() if (mUserInfomation.getHeight() > MAX_HEIGHT_FT2INCH)");
                    this.f8581H.setHeight(Integer.valueOf(107));
                }
                if (this.f8581H.getHeight() < 12) {
                    C2538c.m12679d("BasicInfoSettingActivity", "checkUserInformation() if (mUserInfomation.getHeight() < MIN_HEIGHT_FT2INCH)");
                    this.f8581H.setHeight(Integer.valueOf(12));
                }
            }
            if (this.f8581H.getWeight() != 0) {
                if (this.f8581H.getWeight() > 552) {
                    C2538c.m12679d("BasicInfoSettingActivity", "checkUserInformation() if (mUserInfomation.getWeight() > MAX_WEIGHT_LB)");
                    this.f8581H.setWeight(Integer.valueOf(552));
                }
                if (this.f8581H.getWeight() < 22) {
                    C2538c.m12679d("BasicInfoSettingActivity", "checkUserInformation() if (mUserInfomation.getWeight() < MIN_WEIGHT_LB)");
                    this.f8581H.setWeight(Integer.valueOf(22));
                }
            }
        } else {
            if (this.f8581H.getHeight() != 0) {
                if (this.f8581H.getHeight() > 250) {
                    C2538c.m12679d("BasicInfoSettingActivity", "checkUserInformation() if (mUserInfomation.getHeight() > MAX_HEIGHT_CM)");
                    this.f8581H.setHeight(Integer.valueOf(250));
                }
                if (this.f8581H.getHeight() < 50) {
                    C2538c.m12679d("BasicInfoSettingActivity", "checkUserInformation() if (mUserInfomation.getHeight() < MIN_HEIGHT_CM)");
                    this.f8581H.setHeight(Integer.valueOf(50));
                }
            }
            if (this.f8581H.getWeight() != 0) {
                if (this.f8581H.getWeight() > 250) {
                    C2538c.m12679d("BasicInfoSettingActivity", "checkUserInformation() if (mUserInfomation.getWeight() > MAX_WEIGHT_KG)");
                    this.f8581H.setWeight(Integer.valueOf(250));
                }
                if (this.f8581H.getWeight() < 10) {
                    C2538c.m12679d("BasicInfoSettingActivity", "checkUserInformation() if (mUserInfomation.getWeight() < MIN_WEIGHT_KG)");
                    this.f8581H.setWeight(Integer.valueOf(10));
                }
            }
        }
        if (this.f8581H.getBirthday().length() < 4 || Integer.parseInt(this.f8581H.getBirthday().substring(0, 4)) < 1900) {
            C2538c.m12679d("BasicInfoSettingActivity", "checkUserInformation() if (Integer.valueOf(mUserInfomation.getBirthday().substring(0, 5)) < 1900)");
            this.f8581H.setBirthday("19000101");
        }
    }

    private void m12084n() {
        C2538c.m12677c("BasicInfoSettingActivity", "handleWhenGetUserInfoFail!");
        this.f8592T.removeMessages(2);
        m12038M();
        m12089p();
    }

    private void m12087o() {
        C2538c.m12677c("BasicInfoSettingActivity", "handleWhenGetUserInfoTimeOut!");
        m12038M();
        m12089p();
    }

    private void m12089p() {
        if (this.f8613s == null && !isFinishing()) {
            C2538c.m12677c("BasicInfoSettingActivity", "enter showObtainFailed");
            this.f8613s = new ak(this.f8597b).a(com.huawei.ui.main.j.IDS_basic_info_failed).a(com.huawei.ui.main.j.IDS_retry, new C2381c(this)).b(com.huawei.ui.main.j.IDS_settings_button_cancal, new C2380b(this)).a();
            this.f8613s.setCancelable(true);
            this.f8613s.show();
        }
    }

    private void m12090q() {
        if (this.f8612r == null && !isFinishing()) {
            this.f8612r = new w(this.f8597b).a(com.huawei.ui.main.j.IDS_service_area_notice_title).b(com.huawei.ui.main.j.IDS_settings_login_expire).a(com.huawei.ui.main.j.IDS_retry, new C2383e(this)).b(com.huawei.ui.main.j.IDS_settings_button_cancal, new C2382d(this)).a();
            this.f8612r.setCancelable(true);
            this.f8612r.show();
        }
    }

    private void m12092r() {
        if (!isFinishing()) {
            u a = new w(this).a(com.huawei.ui.main.j.IDS_question_title).b(com.huawei.ui.main.j.IDS_question_content).b(com.huawei.ui.main.j.IDS_settings_close, new C2384f(this)).a();
            a.setCancelable(false);
            if (!a.isShowing()) {
                a.show();
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0) {
            return false;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void m12094s() {
        C2538c.m12677c("BasicInfoSettingActivity", "handleWhenSetUserInfoSuccess()!");
        this.f8592T.removeMessages(6);
        m12038M();
        this.f8580G.m11993c(true);
        this.f8580G.m11995d(true);
        if (C0969i.m3482a(35)) {
            m12082m();
            m12039N();
        }
        Intent intent = new Intent();
        if (this.f8588O || this.f8587N) {
            C2538c.m12677c("BasicInfoSettingActivity", "have connected device");
            intent.setClassName(this.f8596a, "com.huawei.bone.root.MainActivity");
        } else {
            C2538c.m12677c("BasicInfoSettingActivity", "have no connected device");
            intent.setClassName(this.f8596a, "com.huawei.ui.device.activity.adddevice.AddDeviceActivity");
            intent.putExtra("personalbasicinfosettingflag", "personalbasicinfosetting");
        }
        startActivity(intent);
        finish();
    }

    public void startActivity(Intent intent) {
        C2378a c2378a = new C2378a(BaseApplication.m2632b());
        if (c2378a.m12004h()) {
            intent.putExtra("KEY_ANROIDWEAR_OPEN_ESIM_FLAG", true);
        }
        if (c2378a.m12006i()) {
            intent.putExtra("KEY_ANROIDWEAR_OPEN_WALLET_FLAG", true);
        }
        super.startActivity(intent);
    }

    private void m12097t() {
        C2538c.m12677c("BasicInfoSettingActivity", "handleWhenSetUserInfoFail()!");
        this.f8580G.m11993c(true);
        this.f8580G.m11995d(true);
        this.f8592T.removeMessages(6);
        m12038M();
        Intent intent = new Intent();
        if (this.f8588O || this.f8587N) {
            C2538c.m12677c("BasicInfoSettingActivity", "have connected device");
            intent.setClassName(this.f8596a, "com.huawei.bone.root.MainActivity");
        } else {
            C2538c.m12677c("BasicInfoSettingActivity", "have no connected device");
            intent.setClassName(this.f8596a, "com.huawei.ui.device.activity.adddevice.AddDeviceActivity");
            intent.putExtra("personalbasicinfosettingflag", "personalbasicinfosetting");
        }
        startActivity(intent);
        finish();
    }

    private void m12098u() {
        this.f8598d = (LinearLayout) d.a(this, f.guide_basic_info_setting_gender_layout);
        this.f8599e = (LinearLayout) d.a(this, f.guide_basic_info_setting_height_layout);
        this.f8600f = (LinearLayout) d.a(this, f.guide_basic_info_setting_weight_layout);
        this.f8601g = (LinearLayout) d.a(this, f.guide_basic_info_setting_birthday_layout);
        this.f8602h = (TextView) d.a(this, f.guide_basic_info_setting_question_layout);
        this.f8603i = (TextView) d.a(this, f.guide_basic_info_setting_button_text);
        this.f8604j = (TextView) d.a(this, f.guide_basic_info_setting_gender_text);
        this.f8605k = (TextView) d.a(this, f.guide_basic_info_setting_height_text);
        this.f8606l = (TextView) d.a(this, f.guide_basic_info_setting_weight_text);
        this.f8607m = (TextView) d.a(this, f.guide_basic_info_setting_birthday_text);
        this.f8608n = (EditText) d.a(this, f.guide_basic_info_setting_user_nickname_edittext);
        this.f8609o = (ImageView) d.a(this, f.guide_basic_info_setting_user_head_img);
        this.f8610p = (ImageView) d.a(this, f.guide_basic_info_setting_gender_image);
        this.f8598d.setOnClickListener(this);
        this.f8599e.setOnClickListener(this);
        this.f8600f.setOnClickListener(this);
        this.f8601g.setOnClickListener(this);
        this.f8602h.setOnClickListener(this);
        this.f8608n.addTextChangedListener(this.f8594V);
        this.f8603i.setOnClickListener(this);
        this.f8609o.setOnClickListener(this);
        if (this.f8587N) {
            this.f8603i.setText(com.huawei.ui.main.j.IDS_contact_confirm);
        } else {
            this.f8603i.setText(getString(com.huawei.ui.main.j.IDS_start_to_use).toUpperCase());
        }
        if (c.e(this.f8596a)) {
            ((ImageView) d.a(this, f.guide_basic_info_setting_button_img)).setBackgroundResource(com.huawei.ui.main.e.ic_previous);
        }
    }

    private void m12101v() {
        if (this.f8581H == null) {
            C2538c.m12680e("BasicInfoSettingActivity", "updateViewByUserInformation() mUserInfomation == null");
            return;
        }
        m12102w();
        m12104x();
        m12107y();
        m12108z();
        m12017A();
        m12019B();
    }

    private void m12102w() {
        if (this.f8581H.getName() != null && !this.f8581H.getName().equals("")) {
            this.f8608n.setText(this.f8581H.getName());
            this.f8608n.setSelection(this.f8608n.getText().length());
        }
    }

    private void m12104x() {
        String picPath = this.f8581H.getPicPath();
        if (TextUtils.isEmpty(picPath)) {
            C2538c.m12679d("BasicInfoSettingActivity", "setmUserHead, headImgPath is null! ");
            return;
        }
        Bitmap a = com.huawei.hwcommonmodel.d.f.a(this.f8596a, picPath);
        if (a != null) {
            this.f8609o.setImageBitmap(a);
            File file = new File(picPath);
            C2538c.m12677c("BasicInfoSettingActivity", "setmUserHead headImgPath = " + picPath);
            File file2 = new File(file.getParent());
            C2538c.m12677c("BasicInfoSettingActivity", "setmUserHead file.getParent() = " + file.getParent());
            if ("avaters".equals(file2.getName())) {
                File[] listFiles = file2.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    for (int i = 0; i < listFiles.length; i++) {
                        C2538c.m12677c("BasicInfoSettingActivity", "setmUserHead childFiles[" + i + "].getName() = " + listFiles[i].getName() + " info = " + file.getName());
                        C2538c.m12677c("BasicInfoSettingActivity", "setmUserHead flag = " + r4.contains(listFiles[i].getName()));
                        if (!r4.contains(listFiles[i].getName())) {
                            boolean delete = listFiles[i].delete();
                            C2538c.m12677c("BasicInfoSettingActivity", "setmUserHead delete() flag = " + delete);
                        }
                    }
                    return;
                }
                return;
            }
            C2538c.m12677c("BasicInfoSettingActivity", "setmUserHead fileParent.getParent() is not avaters");
        }
    }

    private void m12107y() {
        if (this.f8581H.getGender() == 1) {
            this.f8604j.setText(com.huawei.ui.main.j.IDS_sns_girl);
            this.f8610p.setImageResource(com.huawei.ui.main.e.activity_guide_basic_info_setting_gender_femal_selector21);
            m12049a(1);
        } else if (this.f8581H.getGender() == 2) {
            this.f8604j.setText(com.huawei.ui.main.j.IDS_sns_gender_secret);
            this.f8610p.setImageResource(com.huawei.ui.main.e.activity_guide_basic_info_setting_gender_secret_selector21);
            m12049a(2);
        } else {
            this.f8604j.setText(com.huawei.ui.main.j.IDS_sns_boy);
            this.f8610p.setImageResource(com.huawei.ui.main.e.activity_guide_basic_info_setting_gender_male_selector21);
            m12049a(0);
        }
    }

    private void m12108z() {
        int i = 50;
        C2538c.m12677c("BasicInfoSettingActivity", "setUIHeight()");
        int i2;
        String quantityString;
        if (1 == this.f8581H.getClientSet()) {
            i = this.f8581H.getHeight();
            if (i != 0) {
                if (i < 12 || i > 107) {
                    i = 12;
                }
                i2 = i / 12;
                i -= i2 * 12;
                String a = C0956c.m3344a((double) i2, 1, 0);
                quantityString = this.f8596a.getResources().getQuantityString(i.IDS_ft_string, i2, new Object[]{a});
                a = C0956c.m3344a((double) i, 1, 0);
                String quantityString2 = this.f8596a.getResources().getQuantityString(i.IDS_ins_string, i, new Object[]{a});
                this.f8605k.setText(String.format(getResources().getString(com.huawei.ui.main.j.IDS_ft_ins_string21), new Object[]{quantityString, quantityString2}));
                return;
            }
            this.f8605k.setText("");
        } else if (this.f8581H.getClientSet() == 0) {
            i2 = this.f8581H.getHeight();
            if (i2 != 0) {
                if (i2 >= 50) {
                    if (i2 > 250) {
                        i = 250;
                    } else {
                        i = i2;
                    }
                }
                quantityString = C0956c.m3344a((double) i, 1, 0);
                this.f8605k.setText(this.f8596a.getResources().getQuantityString(i.IDS_cm_string, i, new Object[]{quantityString}));
                return;
            }
            this.f8605k.setText("");
        } else {
            C2538c.m12677c("BasicInfoSettingActivity", "setUIHeight() heightType is invalid");
        }
    }

    private void m12017A() {
        int i = 10;
        C2538c.m12677c("BasicInfoSettingActivity", "setUIWeight()");
        String a;
        if (1 == this.f8581H.getClientSet()) {
            i = this.f8581H.getWeight();
            if (i != 0) {
                if (i < 22 || i > 552) {
                    i = 22;
                }
                a = C0956c.m3344a((double) i, 1, 0);
                this.f8606l.setText(this.f8596a.getResources().getQuantityString(i.IDS_lb_string, i, new Object[]{a}));
                return;
            }
            this.f8606l.setText("");
        } else if (this.f8581H.getClientSet() == 0) {
            int weight = this.f8581H.getWeight();
            if (weight != 0) {
                if (weight >= 10) {
                    if (weight > 250) {
                        i = 250;
                    } else {
                        i = weight;
                    }
                }
                a = C0956c.m3344a((double) i, 1, 0);
                this.f8606l.setText(this.f8596a.getResources().getQuantityString(i.IDS_kg_string, i, new Object[]{a}));
                return;
            }
            this.f8606l.setText("");
        } else {
            C2538c.m12677c("BasicInfoSettingActivity", "setUIWeight() heightType is invalid");
        }
    }

    @TargetApi(3)
    private void m12019B() {
        if (this.f8581H.getBirthday() == null || this.f8581H.getBirthday().length() < 8) {
            C2538c.m12677c("BasicInfoSettingActivity", "getBirthday < 8");
            return;
        }
        int c = C0977d.m3546c(this.f8596a, this.f8581H.getBirthday().substring(0, 4));
        int c2 = C0977d.m3546c(this.f8596a, this.f8581H.getBirthday().substring(4, 6));
        int c3 = C0977d.m3546c(this.f8596a, this.f8581H.getBirthday().substring(6));
        Calendar instance = Calendar.getInstance();
        instance.set(c, c2 - 1, c3);
        this.f8607m.setText(C0956c.m3345a(instance, 65556));
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == f.guide_basic_info_setting_user_head_img) {
            C2538c.m12677c("BasicInfoSettingActivity", "guide_basic_info_setting_gender_layout");
            m12042Q();
        } else if (id == f.guide_basic_info_setting_gender_layout) {
            C2538c.m12677c("BasicInfoSettingActivity", "guide_basic_info_setting_gender_layout");
            if (!m12067e()) {
                m12023D();
            }
        } else if (id == f.guide_basic_info_setting_height_layout) {
            C2538c.m12677c("BasicInfoSettingActivity", "guide_basic_info_setting_height_layout");
            if (!m12067e()) {
                m12029G();
            }
        } else if (id == f.guide_basic_info_setting_weight_layout) {
            C2538c.m12677c("BasicInfoSettingActivity", "guide_basic_info_setting_weight_layout");
            if (!m12067e()) {
                m12033I();
            }
        } else if (id == f.guide_basic_info_setting_birthday_layout) {
            C2538c.m12677c("BasicInfoSettingActivity", "guide_basic_info_setting_birthday_layout");
            if (!m12067e()) {
                m12112b();
            }
        } else if (id == f.guide_basic_info_setting_question_layout) {
            C2538c.m12677c("BasicInfoSettingActivity", "guide_basic_info_setting_question_layout");
            m12092r();
        } else if (id == f.guide_basic_info_setting_next_button || id == f.guide_basic_info_setting_button_text) {
            C2538c.m12677c("BasicInfoSettingActivity", "guide_basic_info_setting_next_button");
            this.f8589P = true;
            if (this.f8581H.getHeight() == 0) {
                if (this.f8605k == null) {
                    return;
                }
                if (VERSION.SDK_INT < 23) {
                    this.f8605k.setBackgroundColor(getResources().getColor(com.huawei.ui.main.c.red));
                } else {
                    this.f8605k.setBackgroundColor(getColor(com.huawei.ui.main.c.red));
                }
            } else if (this.f8581H.getWeight() == 0) {
                if (this.f8606l == null) {
                    return;
                }
                if (VERSION.SDK_INT < 23) {
                    this.f8606l.setBackgroundColor(getResources().getColor(com.huawei.ui.main.c.red));
                } else {
                    this.f8606l.setBackgroundColor(getColor(com.huawei.ui.main.c.red));
                }
            } else if (m12041P()) {
                if (C0969i.m3482a(35)) {
                    if (this.f8581H.getClientSet() == 0) {
                        C0956c.m3348a(false);
                    } else {
                        C0956c.m3348a(true);
                    }
                }
                if (this.f8586M) {
                    C2538c.m12677c("BasicInfoSettingActivity", "if (mifNoNeedLogin)");
                    m12020C();
                    return;
                }
                C2538c.m12677c("BasicInfoSettingActivity", "if (mifNoNeedLogin) ELSE");
                if (C0977d.m3555e(BaseApplication.m2632b())) {
                    m12037L();
                } else {
                    com.huawei.ui.commonui.c.a.b(BaseApplication.m2632b(), com.huawei.ui.main.j.IDS_connect_error);
                }
            }
        } else {
            C2538c.m12677c("BasicInfoSettingActivity", "i =" + id);
        }
    }

    private void m12020C() {
        C2538c.m12677c("BasicInfoSettingActivity", "saveUserInformationToLocal() enter");
        this.f8581H.setName(this.f8608n.getText().toString());
        C2538c.m12677c("BasicInfoSettingActivity", "saveUserInformation, gender:" + this.f8581H.getGender());
        if (!this.f8577D) {
            this.f8581H.setPicPath(null);
            this.f8581H.setPortraitUrl(null);
        }
        if (-1 == this.f8581H.getGender()) {
            C2538c.m12677c("BasicInfoSettingActivity", "gender is not selected.");
            this.f8581H.setGender(Integer.valueOf(0));
        }
        C2538c.m12677c("BasicInfoSettingActivity", "saveUserInformationToLocal, gender:" + this.f8581H.getGender());
        this.f8592T.sendEmptyMessageDelayed(6, 35000);
        m12056a(this.f8596a.getString(com.huawei.ui.main.j.IDS_sns_waiting));
        if (this.f8584K != null) {
            C2538c.m12677c("BasicInfoSettingActivity", "saveUserInformationToLocal()! mUserInfomation = " + this.f8581H);
            this.f8584K.m2308a(this.f8581H, new C2386h(this));
        }
    }

    private void m12023D() {
        C2538c.m12677c("BasicInfoSettingActivity", "enter editGender():");
        String[] strArr = new String[]{this.f8596a.getString(com.huawei.ui.main.j.IDS_sns_boy), this.f8596a.getString(com.huawei.ui.main.j.IDS_sns_girl), this.f8596a.getString(com.huawei.ui.main.j.IDS_sns_gender_secret)};
        if (this.f8617w == null) {
            this.f8618x = new l(this);
            this.f8617w = this.f8618x.a(getString(com.huawei.ui.main.j.IDS_sns_gender_title)).a(strArr, this.f8619y, null, this.f8595W, false).a(getString(com.huawei.ui.main.j.IDS_settings_button_cancal), new C2387i(this)).b();
        }
        this.f8617w.show();
        C2538c.m12674b("BasicInfoSettingActivity", "showSamrtWakeDialog()");
    }

    private void m12025E() {
        if (!isFinishing() && this.f8617w != null) {
            this.f8617w.dismiss();
            this.f8617w = null;
            this.f8618x = null;
        }
    }

    private void m12049a(int i) {
        for (int i2 = 0; i2 < this.f8619y.length; i2++) {
            this.f8619y[i2] = false;
        }
        this.f8619y[i] = true;
    }

    private void m12026F() {
        C2538c.m12677c("BasicInfoSettingActivity", "selectGender() gender" + this.f8620z);
        if (1 == this.f8620z) {
            this.f8581H.setGender(Integer.valueOf(1));
        } else if (2 == this.f8620z) {
            this.f8581H.setGender(Integer.valueOf(2));
        } else {
            this.f8581H.setGender(Integer.valueOf(0));
        }
        m12107y();
    }

    private void m12029G() {
        int i;
        int i2 = 12;
        C2538c.m12677c("BasicInfoSettingActivity", "enter editHeight():");
        this.f8574A = new a(this.f8597b, 0);
        this.f8574A.a(-2130706433, -15884293);
        String[] strArr = new String[201];
        for (i = 0; i <= 200; i++) {
            strArr[i] = C0956c.m3344a((double) (i + 50), 1, 0);
        }
        String[] strArr2 = new String[8];
        for (i = 0; i <= 7; i++) {
            strArr2[i] = C0956c.m3344a((double) (i + 1), 1, 0);
        }
        String[] strArr3 = new String[12];
        for (i = 0; i <= 11; i++) {
            strArr3[i] = C0956c.m3344a((double) (i + 0), 1, 0);
        }
        String[] strArr4 = new String[]{this.f8596a.getResources().getString(com.huawei.ui.main.j.IDS_cm), this.f8596a.getResources().getString(com.huawei.ui.main.j.IDS_ft)};
        this.f8574A.c(strArr4, 0, false);
        this.f8574A.a(strArr, 1, true);
        this.f8574A.setOnWheelChangedListener(new C2389k(this, strArr2, strArr3, strArr));
        if (this.f8581H.getClientSet() == 1) {
            int height = this.f8581H.getHeight();
            if (height == 0) {
                i2 = com.huawei.hwcommonmodel.d.e.e(HiUserInfo.HEIGHT_DEFAULT);
            } else if (height >= 12) {
                if (height > 107) {
                    i2 = 107;
                } else {
                    i2 = height;
                }
            }
            int b = com.huawei.hwcommonmodel.d.e.b(i2);
            i2 = com.huawei.hwcommonmodel.d.e.c(i2);
            this.f8574A.b();
            this.f8574A.c(strArr4, 1, false);
            this.f8574A.a(strArr2, b - 1, true);
            this.f8574A.setFirstWheelPickValueUnit(this.f8596a.getString(com.huawei.ui.main.j.IDS_ft));
            this.f8574A.b(strArr3, i2 + 0, true);
            this.f8574A.setSecondWheelPickValueUnit(this.f8596a.getString(com.huawei.ui.main.j.IDS_ins));
        } else if (this.f8581H.getClientSet() == 0) {
            this.f8574A.a();
            i2 = this.f8581H.getHeight();
            if (i2 == 0) {
                i2 = HiUserInfo.HEIGHT_DEFAULT;
            } else if (i2 < 50) {
                i2 = 50;
            } else if (i2 > 250) {
                i2 = 250;
            }
            this.f8574A.c(strArr4, 0, false);
            this.f8574A.a(strArr, i2 - 50, true);
        }
        this.f8614t = this.f8574A.a(this.f8596a.getString(com.huawei.ui.main.j.IDS_sns_height_title), new C2391m(this), this.f8596a.getString(com.huawei.ui.main.j.IDS_settings_button_ok).toUpperCase(), new C2392n(this), this.f8596a.getString(com.huawei.ui.main.j.IDS_settings_button_cancal));
    }

    private void m12031H() {
        int i = 50;
        C2538c.m12677c("BasicInfoSettingActivity", "enter selectHeight()");
        int c = C0977d.m3546c(this.f8596a, this.f8574A.getFisrtPickerValue());
        C2538c.m12677c("BasicInfoSettingActivity", "value =" + c);
        if (this.f8574A.getThirdPickerValue().equalsIgnoreCase(BaseApplication.m2632b().getResources().getString(com.huawei.ui.main.j.IDS_cm))) {
            if (c >= 50) {
                if (c > 250) {
                    i = 250;
                } else {
                    i = c;
                }
            }
            this.f8581H.setHeight(Integer.valueOf(i));
            if (this.f8581H.getClientSet() == 1) {
                this.f8581H.setWeight(Integer.valueOf(n.c(this.f8581H.getWeight())));
            }
            this.f8581H.setClientSet(Integer.valueOf(0));
        } else {
            C2538c.m12677c("BasicInfoSettingActivity", "iInchesValue =" + C0977d.m3546c(this.f8596a, this.f8574A.getSecondPickerValue()));
            i = com.huawei.hwcommonmodel.d.e.a(c, i);
            if (i < 12) {
                i = 12;
            } else if (i > 107) {
                i = 107;
            }
            this.f8581H.setHeight(Integer.valueOf(i));
            if (this.f8581H.getClientSet() == 0) {
                this.f8581H.setWeight(Integer.valueOf(n.a((float) this.f8581H.getWeight())));
            }
            this.f8581H.setClientSet(Integer.valueOf(1));
        }
        if (this.f8605k != null) {
            if (VERSION.SDK_INT < 23) {
                this.f8605k.setBackgroundColor(getResources().getColor(com.huawei.ui.main.c.no_color));
            } else {
                this.f8605k.setBackgroundColor(getColor(com.huawei.ui.main.c.no_color));
            }
        }
        m12108z();
        m12017A();
    }

    private void m12033I() {
        int i;
        int i2 = 22;
        C2538c.m12677c("BasicInfoSettingActivity", "dialogWeight() enter ");
        this.f8575B = new a(this.f8597b, 1);
        this.f8575B.a(-2130706433, -15884293);
        String[] strArr = new String[241];
        for (i = 0; i <= 240; i++) {
            strArr[i] = C0956c.m3344a((double) (i + 10), 1, 0);
        }
        String[] strArr2 = new String[531];
        for (i = 0; i <= 530; i++) {
            strArr2[i] = C0956c.m3344a((double) (i + 22), 1, 0);
        }
        String[] strArr3 = new String[]{this.f8596a.getResources().getString(com.huawei.ui.main.j.IDS_weight_array_unit), this.f8596a.getResources().getString(com.huawei.ui.main.j.IDS_lbs)};
        this.f8575B.a(strArr, 1, true);
        this.f8575B.c(strArr3, 0, false);
        this.f8575B.setOnWheelChangedListener(new C2393o(this, strArr, strArr2));
        if (1 == this.f8581H.getClientSet()) {
            int weight = this.f8581H.getWeight();
            if (weight == 0) {
                i2 = com.huawei.hwcommonmodel.d.e.g(60);
            } else if (weight >= 22) {
                if (weight > 552) {
                    i2 = 552;
                } else {
                    i2 = weight;
                }
            }
            this.f8575B.a(strArr2, i2 - 22, true);
            this.f8575B.c(strArr3, 1, false);
        } else if (this.f8581H.getClientSet() == 0) {
            i2 = this.f8581H.getWeight();
            if (i2 == 0) {
                i2 = 60;
            } else if (i2 < 10) {
                i2 = 10;
            } else if (i2 > 250) {
                i2 = 250;
            }
            this.f8575B.a(strArr, i2 - 10, true);
            this.f8575B.c(strArr3, 0, false);
        }
        this.f8615u = this.f8575B.a(this.f8596a.getString(com.huawei.ui.main.j.IDS_sns_weight_title), new C2394p(this), this.f8596a.getString(com.huawei.ui.main.j.IDS_settings_button_ok), new C2395q(this), this.f8596a.getString(com.huawei.ui.main.j.IDS_settings_button_cancal));
    }

    private void m12035J() {
        int i = 10;
        C2538c.m12677c("BasicInfoSettingActivity", "enter selectWeight():");
        int c = C0977d.m3546c(this.f8596a, this.f8575B.getFisrtPickerValue());
        if (this.f8575B.getThirdPickerValue().equalsIgnoreCase(BaseApplication.m2632b().getResources().getString(com.huawei.ui.main.j.IDS_weight_array_unit))) {
            C2538c.m12677c("BasicInfoSettingActivity", "WEIGHT_UNIT_KG == weight_type");
            if (c >= 10) {
                if (c > 250) {
                    i = 250;
                } else {
                    i = c;
                }
            }
            C2538c.m12677c("BasicInfoSettingActivity", "用户修改后的weight_kg =" + i);
            this.f8581H.setWeight(Integer.valueOf(i));
            if (this.f8581H.getClientSet() == 1) {
                this.f8581H.setHeight(Integer.valueOf(n.a(this.f8581H.getHeight())));
            }
            this.f8581H.setClientSet(Integer.valueOf(0));
        } else {
            C2538c.m12677c("BasicInfoSettingActivity", "WEIGHT_UNIT_lb == weight_type");
            if (c < 22) {
                c = 22;
            } else if (c > 552) {
                c = 552;
            }
            C2538c.m12677c("BasicInfoSettingActivity", "用户修改后的weight_lb =" + c);
            this.f8581H.setWeight(Integer.valueOf(c));
            if (this.f8581H.getClientSet() == 0) {
                this.f8581H.setHeight(Integer.valueOf(n.b(this.f8581H.getHeight())));
            }
            this.f8581H.setClientSet(Integer.valueOf(1));
        }
        if (this.f8606l != null) {
            if (VERSION.SDK_INT < 23) {
                this.f8606l.setBackgroundColor(getResources().getColor(com.huawei.ui.main.c.no_color));
            } else {
                this.f8606l.setBackgroundColor(getColor(com.huawei.ui.main.c.no_color));
            }
        }
        m12108z();
        m12017A();
    }

    public void m12112b() {
        C2538c.m12677c("BasicInfoSettingActivity", "enter editBirthday():");
        this.f8576C = new a(this.f8597b, 2);
        this.f8576C.a(-2130706433, -15884293);
        String str = this.f8581H.getBirthday() + "";
        this.f8576C.a(C0977d.m3546c(this.f8596a, str.substring(0, 4)) + "", C0977d.m3546c(this.f8596a, str.substring(4, 6)) + "", C0977d.m3546c(this.f8596a, str.substring(6)) + "");
        this.f8616v = this.f8576C.a(this.f8596a.getString(com.huawei.ui.main.j.IDS_sns_birthday_title), new C2396r(this), this.f8596a.getString(com.huawei.ui.main.j.IDS_settings_button_ok), new C2397s(this), this.f8596a.getString(com.huawei.ui.main.j.IDS_settings_button_cancal));
    }

    private void m12036K() {
        C2538c.m12677c("BasicInfoSettingActivity", "selectBirthday()");
        String fisrtPickerValue = this.f8576C.getFisrtPickerValue();
        String secondPickerValue = this.f8576C.getSecondPickerValue();
        if (C0977d.m3546c(this.f8596a, secondPickerValue) > 0 && C0977d.m3546c(this.f8596a, secondPickerValue) < 10) {
            secondPickerValue = "0" + secondPickerValue;
        }
        String thirdPickerValue = this.f8576C.getThirdPickerValue();
        if (C0977d.m3546c(this.f8596a, thirdPickerValue) > 0 && C0977d.m3546c(this.f8596a, thirdPickerValue) < 10) {
            thirdPickerValue = "0" + thirdPickerValue;
        }
        C2538c.m12677c("BasicInfoSettingActivity", "birthdayUpdated = " + (fisrtPickerValue + secondPickerValue + thirdPickerValue));
        this.f8581H.setBirthday(secondPickerValue);
        m12019B();
    }

    private void m12037L() {
        if (this.f8581H.getName() == null || !this.f8608n.getText().toString().equals(this.f8581H.getName())) {
            this.f8581H.setName(this.f8608n.getText().toString());
        } else {
            C2538c.m12677c("BasicInfoSettingActivity", "saveUserInformation, nick is not changed.");
            this.f8581H.setName(null);
        }
        if (-1 == this.f8581H.getGender()) {
            C2538c.m12677c("BasicInfoSettingActivity", "gender is not selected.");
            this.f8581H.setGender(Integer.valueOf(0));
        }
        C2538c.m12677c("BasicInfoSettingActivity", "saveUserInformation, gender:" + this.f8581H.getGender());
        if (!this.f8577D) {
            this.f8581H.setPicPath(null);
            this.f8581H.setPortraitUrl(null);
        }
        this.f8592T.sendEmptyMessageDelayed(6, 35000);
        m12056a(this.f8596a.getString(com.huawei.ui.main.j.IDS_sns_waiting));
        this.f8580G.m11987a(this.f8597b, this.f8581H, new C2398t(this));
    }

    private void m12056a(String str) {
        C2538c.m12677c("BasicInfoSettingActivity", "showLoadingDialog()");
        if (this.f8611q != null || isFinishing()) {
            C2538c.m12677c("BasicInfoSettingActivity", "showLoadingDialog have dialog");
            return;
        }
        C2538c.m12677c("BasicInfoSettingActivity", "21 no dialog");
        com.huawei.ui.commonui.dialog.a aVar = new com.huawei.ui.commonui.dialog.a(this, k.app_update_dialogActivity);
        this.f8611q = com.huawei.ui.commonui.dialog.a.a(this);
        this.f8611q.a(str);
        this.f8611q.a();
    }

    private void m12038M() {
        C2538c.m12677c("BasicInfoSettingActivity", "enter dismissLoadingDialog()");
        if (this.f8592T != null && !isFinishing()) {
            this.f8592T.postDelayed(new C2399u(this), 1500);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.f8590Q != null) {
            this.f8590Q.m4734d();
        }
        this.f8593U = null;
        m12040O();
        if (this.f8592T != null) {
            this.f8592T.removeCallbacksAndMessages(null);
            this.f8592T = null;
        }
        if (this.f8611q != null && this.f8611q.isShowing()) {
            this.f8611q.dismiss();
            this.f8611q = null;
        }
        if (this.f8614t != null && this.f8614t.isShowing()) {
            this.f8614t.dismiss();
            this.f8614t = null;
        }
        if (this.f8615u != null && this.f8615u.isShowing()) {
            this.f8615u.dismiss();
            this.f8615u = null;
        }
        if (this.f8616v != null && this.f8616v.isShowing()) {
            this.f8616v.dismiss();
            this.f8616v = null;
        }
    }

    private void m12039N() {
        C2538c.m12677c("BasicInfoSettingActivity", "sendBroadcastToRefreshUnitSet():");
        Intent intent = new Intent();
        intent.setAction("com.huawei.bone.action.REFRESH_UNIT");
        BaseApplication.m2632b().sendBroadcast(intent, C0976c.f1642a);
    }

    private void m12040O() {
        try {
            C2538c.m12677c("BasicInfoSettingActivity", "unregisterGetUserProfileBroadcast()!");
            LocalBroadcastManager instance = LocalBroadcastManager.getInstance(this.f8596a);
            if (instance != null) {
                instance.unregisterReceiver(this.f8591S);
            }
        } catch (IllegalArgumentException e) {
            C2538c.m12677c("BasicInfoSettingActivity", e.getMessage());
        } catch (RuntimeException e2) {
            C2538c.m12677c("BasicInfoSettingActivity", e2.getMessage());
        }
    }

    private boolean m12041P() {
        if (!this.f8582I.a()) {
            m12070g();
            return false;
        } else if (this.f8580G != null || this.f8581H != null) {
            return true;
        } else {
            C2538c.m12680e("BasicInfoSettingActivity", "saveUserInformation() mGuideInteractors == null && mUserInfomation == null");
            return false;
        }
    }

    private void m12042Q() {
        C2538c.m12677c("BasicInfoSettingActivity", "hasPermission =" + com.huawei.hwcommonmodel.d.b.a(this.f8596a, f8572R));
        if (com.huawei.hwcommonmodel.d.b.a(this.f8596a, f8572R)) {
            this.f8583J.a(com.huawei.ui.commonui.b.d.a);
        } else {
            com.huawei.hwcommonmodel.d.b.a(this, f8572R, new C2400v(this));
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        C2538c.m12677c("BasicInfoSettingActivity", "Activity-onRequestPermissionsResult() PermissionsManager.notifyPermissionsChange()");
        com.huawei.hwcommonmodel.d.a.b.a().a(strArr, iArr);
    }

    public void m12111a(com.huawei.ui.commonui.b.d dVar, byte[] bArr) {
        C2538c.m12674b("BasicInfoSettingActivity", "onCorpComplete() flag=" + dVar);
        if (!TextUtils.isEmpty(this.f8579F)) {
            boolean delete = new File(this.f8579F).delete();
            C2538c.m12677c("BasicInfoSettingActivity", "onCorpComplete() deleteResult1=" + delete);
        }
        this.f8577D = true;
        Uri a = this.f8583J.a();
        C2538c.m12677c("BasicInfoSettingActivity", "onCorpComplete() imgUri=" + a);
        String str = com.huawei.ui.commonui.b.a.a(this) + File.separator + com.huawei.hwcommonmodel.d.g.a(this, a.getPath());
        C2538c.m12677c("BasicInfoSettingActivity", "onCorpComplete() editPath=" + str);
        File file = new File(str);
        if (file.exists()) {
            boolean delete2 = file.delete();
            C2538c.m12677c("BasicInfoSettingActivity", "onCorpComplete() deleteResult2=" + delete2);
        } else {
            C2538c.m12677c("BasicInfoSettingActivity", "onCorpComplete() file not exists");
        }
        file = new File(a.getPath());
        if (file.exists()) {
            delete2 = file.renameTo(new File(str));
            C2538c.m12674b("BasicInfoSettingActivity", "onCorpComplete() rename ret =" + delete2);
        } else {
            C2538c.m12677c("BasicInfoSettingActivity", "onCorpComplete() file2 not exists");
        }
        this.f8578E = a.getPath();
        new Thread(new C2402x(this, str)).start();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.f8583J.a(i, i2, intent);
    }

    private void m12055a(File file, File file2) {
        FileOutputStream fileOutputStream = null;
        byte[] bArr = new byte[1024];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (FileNotFoundException e) {
                C2538c.m12677c("BasicInfoSettingActivity", "Exception e0 = " + e.getMessage());
                try {
                    fileInputStream.close();
                } catch (IOException e2) {
                    C2538c.m12677c("BasicInfoSettingActivity", "Exception e1 = " + e2.getMessage());
                }
            }
            while (true) {
                try {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        try {
                            break;
                        } catch (IOException e22) {
                            C2538c.m12680e("BasicInfoSettingActivity", "Exception e1 = " + e22.getMessage());
                        }
                    } else if (fileOutputStream != null) {
                        fileOutputStream.write(bArr, 0, read);
                    }
                } catch (Exception e3) {
                    C2538c.m12677c("BasicInfoSettingActivity", "Exception e = " + e3.getMessage());
                    try {
                        fileInputStream.close();
                    } catch (IOException e222) {
                        C2538c.m12680e("BasicInfoSettingActivity", "Exception e1 = " + e222.getMessage());
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            return;
                        } catch (IOException e2222) {
                            C2538c.m12677c("BasicInfoSettingActivity", "Exception e2 = " + e2222.getMessage());
                            return;
                        }
                    }
                    return;
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e4) {
                        C2538c.m12680e("BasicInfoSettingActivity", "Exception e1 = " + e4.getMessage());
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                            C2538c.m12677c("BasicInfoSettingActivity", "Exception e2 = " + e5.getMessage());
                        }
                    }
                }
            }
            fileInputStream.close();
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e22222) {
                    C2538c.m12677c("BasicInfoSettingActivity", "Exception e2 = " + e22222.getMessage());
                }
            }
        } catch (FileNotFoundException e6) {
            C2538c.m12677c("BasicInfoSettingActivity", "Exception e3 = " + e6.getMessage());
        }
    }
}
