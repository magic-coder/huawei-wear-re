package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.zxing.b.j;
import com.google.zxing.c;
import com.google.zxing.e;
import com.google.zxing.i;
import com.google.zxing.m;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.b.a;
import com.huawei.hwcommonmodel.d.a.b;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.C1413d;
import com.huawei.pluginkidwatch.common.entity.C1417a;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.BindDeviceIOEntityModel;
import com.huawei.pluginkidwatch.common.lib.p148c.C1466a;
import com.huawei.pluginkidwatch.common.lib.p148c.C1467b;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.ui.base.KidWatchBaseActivity;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;
import com.huawei.pluginkidwatch.common.ui.view.C1595v;
import com.huawei.pluginkidwatch.common.ui.view.CustomDialog;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.plugin.setting.qrcode.QrCodeActivity;
import com.huawei.pluginkidwatch.plugin.setting.qrcode.decoding.C1963j;
import com.huawei.pluginkidwatch.plugin.setting.qrcode.p168a.C1945b;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Vector;
import net.sqlcipher.database.SQLiteDatabase;

public class BindbyQrActivity extends KidWatchBaseActivity implements OnRequestPermissionsResultCallback, OnClickListener {
    private String f6263A = "";
    private OnClickListener f6264B = new C1914e(this);
    private C1378e f6265C = new C1916g(this);
    private String f6266b = "KIDWATCH_BindbyQrActivity";
    private final int f6267c = 5000;
    private Button f6268d;
    private Button f6269e;
    private Button f6270f;
    private Button f6271g;
    private View f6272h;
    private ImageView f6273i;
    private String f6274j = "";
    private TextView f6275k;
    private TextView f6276l;
    private ImageView f6277m;
    private C1413d f6278n = null;
    private boolean f6279o = false;
    private String f6280p = "";
    private FrameLayout f6281q;
    private FrameLayout f6282r;
    private ImageView f6283s;
    private Context f6284t;
    private String f6285u = "is_from_qr_code";
    private String f6286v = "";
    private String f6287w = "";
    private Handler f6288x = new Handler();
    private CustomDialog f6289y = null;
    private CustomDialog f6290z = null;

    protected void mo2517a() {
        requestWindowFeature(1);
        C2538c.m12674b(this.f6266b, "======Enter initView");
        setContentView(h.activity_bind);
        this.f6284t = BaseApplication.m2632b();
        m9750d();
        this.f6278n = C1417a.m6594a(this);
        m9754e();
        m9757f();
    }

    protected void onResume() {
        C2538c.m12674b(this.f6266b, "======Enter onResume");
        super.onResume();
    }

    private void m9750d() {
        C2538c.m12674b(this.f6266b, "======Enter initBindView");
        this.f6273i = (ImageView) findViewById(g.guide_iv_bindstate);
        this.f6277m = (ImageView) findViewById(g.guide_iv_bindsuccess);
        this.f6275k = (TextView) findViewById(g.guide_tv_bindnotice);
        this.f6268d = (Button) findViewById(g.guide_btn_scanqrcode);
        this.f6268d.setOnClickListener(this);
        this.f6272h = findViewById(g.btn_bottom_pannel);
        this.f6272h.setVisibility(0);
        this.f6269e = (Button) findViewById(g.guide_btn_next);
        this.f6270f = (Button) findViewById(g.guide_btn_back);
        this.f6271g = (Button) findViewById(g.guide_btn_finish);
        this.f6269e.setOnClickListener(this);
        this.f6270f.setOnClickListener(this);
        this.f6271g.setOnClickListener(this);
        this.f6276l = (TextView) findViewById(g.guide_tv_qrcode_info);
        this.f6276l.setOnClickListener(this.f6264B);
        this.f6281q = (FrameLayout) findViewById(g.seting_bind_frame);
        this.f6282r = (FrameLayout) findViewById(g.seting_bind_frame_prepared);
        this.f6283s = (ImageView) findViewById(g.guide_iv_bind_dot);
        this.f6283s.setBackgroundResource(C1617f.dot_animation);
        ((AnimationDrawable) this.f6283s.getBackground()).start();
    }

    private void m9754e() {
        C2538c.m12674b(this.f6266b, "======Enter initData");
        m9783o(getIntent().getStringExtra("qrcode_result"));
    }

    private void m9757f() {
        C2538c.m12674b(this.f6266b, "======Enter startPicturesActivity");
        C2538c.m12674b(this.f6266b, "startPicturesActivity ====== ALBUM:" + getIntent().getStringExtra("qrcode_album"));
        if (!this.f6279o && "1".equals(getIntent().getStringExtra("qrcode_album"))) {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            startActivityForResult(intent, 1);
        }
    }

    private void m9739a(String str) {
        C2538c.m12674b(this.f6266b, "======Enter processBindUser ");
        this.f6263A = "";
        this.f6273i.setVisibility(8);
        this.f6282r.setVisibility(8);
        this.f6281q.setVisibility(0);
        this.f6268d.setEnabled(false);
        C1506g.m6978a(this, getResources().getString(C1680l.IDS_plugin_kidwatch_settings_binding), false);
        if (this.f6288x != null) {
            this.f6288x.postDelayed(new C1915f(this, str), 5000);
        }
    }

    private void m9744b(String str) {
        C2538c.m12674b(this.f6266b, "======Enter watchBind ");
        C2538c.m12674b(this.f6266b, "============type = " + C1497q.m6945b((Context) this, "pictype", "0"));
        BindDeviceIOEntityModel bindDeviceIOEntityModel = new BindDeviceIOEntityModel();
        bindDeviceIOEntityModel.setBindDevice(str, C1462f.m6758r(), C1497q.m6945b((Context) this, "pictype", "0"), 0);
        C1462f.m6752m(str);
        this.f6278n.mo2471a(bindDeviceIOEntityModel, this.f6265C);
        C2538c.m12674b(this.f6266b, "======Leave watchBind ");
    }

    private void m9740a(String str, String str2) {
        C2538c.m12677c(this.f6266b, "Enter mainAdministerBindSucess =======phoneNum：" + str2 + "  , deviceCode = " + str);
        m9776j(str);
        C1462f.m6720a(this.f6280p, this.f6286v);
        C2538c.m12674b(this.f6266b, "=======phoneNum：" + str2);
        C2538c.m12677c(this.f6266b, "===www=======current device deviceType = " + (5 == C1467b.m6789d(this.f6284t) ? "k1" : "k2"));
        C1492l.m6911a(this.f6284t, a.A.a(), r0, this.f6286v);
        Intent intent = new Intent();
        if (str2 == null || "".equals(str2)) {
            C2538c.m12674b(this.f6266b, "============跳转到手表号码设置页面=======");
            intent.setClass(this, SetKidWatchNumActivity.class);
            intent.putExtra("in_guide", true);
            intent.putExtra("device_code_in_guide", this.f6280p);
            intent.putExtra("phone_num_in_guide", str2);
            intent.setPackage(this.f6284t.getPackageName());
        } else {
            C2538c.m12674b(this.f6266b, "============手表号码已上报，直接进入宝贝信息设置界面设置页面=======");
            C1462f.m6731d(this.f6280p);
            C1497q.m6943a(getApplicationContext(), "sharedpreferences_watch_device_code", this.f6280p);
            intent.putExtra("in_guide", true);
            intent.setClass(this.f6284t, ProfileSettingActivity.class);
        }
        startActivity(intent);
        finish();
        C2538c.m12677c(this.f6266b, "Leave mainAdministerBindSucess");
    }

    private void m9748c(String str) {
        C2538c.m12677c(this.f6266b, "Enter secondAdministerBindSucess");
        this.f6281q.setVisibility(8);
        this.f6270f.setEnabled(false);
        this.f6273i.setVisibility(8);
        this.f6282r.setVisibility(0);
        this.f6268d.setVisibility(8);
        if (m9779l(str).isEmpty()) {
            m9734a(C1680l.IDS_plugin_kidwatch_settings_bind_fail_verifying);
        } else {
            m9778k(String.format(getResources().getString(C1680l.IDS_plugin_kidwatch_settings_bind_fail_verifying_withnum), new Object[]{r0}));
        }
        this.f6269e.setEnabled(true);
        this.f6276l.setVisibility(4);
        C2538c.m12677c(this.f6266b, "Leave secondAdministerBindSucess");
    }

    private void m9752d(String str) {
        C2538c.m12677c(this.f6266b, "Enter alreadyAdministerReBindProcess");
        this.f6281q.setVisibility(8);
        this.f6270f.setEnabled(false);
        this.f6273i.setVisibility(8);
        this.f6282r.setVisibility(0);
        this.f6268d.setVisibility(8);
        m9734a(C1680l.IDS_plugin_kidwatch_settings_bind_success_was_manager);
        m9776j(str);
        this.f6269e.setEnabled(true);
        this.f6276l.setVisibility(4);
        C2538c.m12677c(this.f6266b, "Leave alreadyAdministerReBindProcess");
    }

    private void m9756e(String str) {
        C2538c.m12677c(this.f6266b, "Enter invalidIMEIProcess");
        this.f6281q.setVisibility(8);
        this.f6270f.setEnabled(false);
        this.f6273i.setVisibility(8);
        this.f6282r.setVisibility(0);
        this.f6277m.setVisibility(4);
        m9735a(C1680l.IDS_plugin_kidwatch_settings_bind_fail_imei_wrongful, str);
        this.f6270f.setEnabled(true);
        C2538c.m12677c(this.f6266b, "Leave invalidIMEIProcess");
    }

    private void m9760f(String str) {
        C2538c.m12677c(this.f6266b, "Enter bindDeviceUpperLimit");
        this.f6281q.setVisibility(8);
        this.f6270f.setEnabled(false);
        this.f6273i.setVisibility(8);
        this.f6282r.setVisibility(0);
        this.f6277m.setVisibility(4);
        this.f6270f.setEnabled(true);
        m9735a(C1680l.IDS_plugin_kidwatch_settings_bind_fail_upper_limit, str);
        C2538c.m12677c(this.f6266b, "Leave bindDeviceUpperLimit");
    }

    private void m9764g(String str) {
        C2538c.m12677c(this.f6266b, "Enter bindDeviceToMax");
        this.f6281q.setVisibility(8);
        this.f6270f.setEnabled(false);
        this.f6273i.setVisibility(8);
        this.f6282r.setVisibility(0);
        this.f6277m.setVisibility(4);
        this.f6270f.setEnabled(true);
        m9735a(C1680l.IDS_plugin_kidwatch_settings_bind_device_max, str);
        C2538c.m12677c(this.f6266b, "Leave bindDeviceToMax");
    }

    private void m9745b(String str, String str2) {
        C2538c.m12677c(this.f6266b, "Enter bindDeviceSucessGoToWatchPhoneNumSetting");
        C1462f.m6720a(str, this.f6286v);
        C2538c.m12674b(this.f6266b, "=======deviceCode ：", str, ", phoneNum = ", str2);
        C2538c.m12677c(this.f6266b, "===www=======current device type = " + (5 == C1467b.m6789d(this.f6284t) ? "k1" : "k2"));
        C1492l.m6911a(this.f6284t, a.A.a(), r0, this.f6286v);
        Intent intent = new Intent();
        intent.setClass(this, SetKidWatchNumActivity.class);
        intent.putExtra("in_guide", true);
        intent.putExtra("other_manager_bind_in_guide", true);
        intent.putExtra("device_code_in_guide", str);
        intent.putExtra("phone_num_in_guide", str2);
        intent.setPackage(this.f6284t.getPackageName());
        startActivity(intent);
        C2538c.m12677c(this.f6266b, "Leave bindDeviceSucessGoToWatchPhoneNumSetting");
    }

    private void m9768h(String str) {
        C2538c.m12677c(this.f6266b, "Enter bindDeviceFailProcess");
        this.f6281q.setVisibility(8);
        this.f6270f.setEnabled(false);
        this.f6273i.setVisibility(8);
        this.f6282r.setVisibility(0);
        this.f6277m.setVisibility(4);
        this.f6270f.setEnabled(true);
        m9735a(C1680l.IDS_plugin_kidwatch_settings_bind_fail, str);
        C2538c.m12677c(this.f6266b, "Leave bindDeviceFailProcess");
    }

    private void m9761g() {
        C2538c.m12677c(this.f6266b, "Enter mainAdministerAccountChangeSucess matb ");
        C1462f.m6720a(this.f6280p, this.f6286v);
        C1462f.m6731d(this.f6280p);
        C1497q.m6943a(getApplicationContext(), "sharedpreferences_watch_device_code", this.f6280p);
        C2538c.m12677c(this.f6266b, "mainAdministerAccountChangeSucess matb strDevicecode = " + this.f6280p);
        this.f6272h.setVisibility(8);
        this.f6281q.setVisibility(8);
        this.f6270f.setEnabled(false);
        this.f6273i.setVisibility(8);
        this.f6282r.setVisibility(0);
        this.f6268d.setVisibility(8);
        m9734a(C1680l.IDS_plugin_kidwatch_settings_reset_main_administer_sucess);
        this.f6269e.setEnabled(false);
        this.f6276l.setVisibility(4);
        this.f6271g.setVisibility(0);
        C2538c.m12677c(this.f6266b, "Leave mainAdministerAccountChangeSucess matb");
    }

    private void m9766h() {
        C2538c.m12677c(this.f6266b, "Enter showVirifyInfoExpiredDialog matb");
        C1497q.m6942a(this.f6284t, "sharedpreferences_exist_phone_number", Boolean.valueOf(false));
        if (this.f6289y == null || !this.f6289y.isShowing()) {
            C1595v c1595v = new C1595v(this);
            c1595v.m7348b(C1680l.IDS_plugin_kidwatch_change_admin_fail);
            c1595v.m7347a(false);
            c1595v.m7340a(C1680l.IDS_plugin_kidwatch_common_ok, new C1917h(this));
            c1595v.m7342a(new C1918i(this));
            this.f6289y = c1595v.m7338a();
            this.f6289y.show();
            C2538c.m12677c(this.f6266b, "Leave showVirifyInfoExpiredDialog matb");
            return;
        }
        C2538c.m12677c(this.f6266b, "Leave expiredDialog is show showVirifyInfoExpiredDialog matb");
    }

    private void m9772i(String str) {
        C2538c.m12677c(this.f6266b, "=======Enter showChangeMainAdministerAccountDialog matb");
        if (this.f6290z == null || !this.f6290z.isShowing()) {
            C1595v c1595v = new C1595v(this);
            c1595v.m7339a(C1680l.IDS_plugin_kidwatch_change_admin_title);
            c1595v.m7348b(C1680l.IDS_plugin_kidwatch_change_admin_content);
            c1595v.m7347a(false);
            c1595v.m7340a(C1680l.IDS_plugin_kidwatch_change_admin, new C1919j(this, str));
            c1595v.m7349b(C1680l.IDS_plugin_kidwatch_common_cancel, new C1920k(this));
            this.f6290z = c1595v.m7338a();
            this.f6290z.show();
            C2538c.m12677c(this.f6266b, "=======Leave showChangeMainAdministerAccountDialog matb");
            return;
        }
        C2538c.m12677c(this.f6266b, "=======Leave changeDialog is show showChangeMainAdministerAccountDialog matb");
    }

    private void m9769i() {
        C2538c.m12677c(this.f6266b, "matb Enter startSetPhoneNumActivity");
        Intent intent = new Intent();
        intent.setClass(this, SetPhoneNumActivity.class);
        intent.setPackage(this.f6284t.getPackageName());
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        startActivity(intent);
        finish();
        C2538c.m12677c(this.f6266b, "matb Leave startSetPhoneNumActivity");
    }

    private void m9776j(String str) {
        C2538c.m12674b(this.f6266b, "================Enter resetDeviceCode = " + str);
        if (!"".equals(str) && !"0".equals(str)) {
            this.f6280p = str;
        }
    }

    private void m9734a(int i) {
        C2538c.m12674b(this.f6266b, "================Enter 1111 bindSkip" + i);
        this.f6269e.setText(C1680l.IDS_plugin_kidwatch_common_skip);
        this.f6269e.setVisibility(0);
        this.f6268d.setVisibility(8);
        this.f6275k.setText(i);
    }

    private void m9778k(String str) {
        C2538c.m12674b(this.f6266b, "================Enter 2222 bindSkip" + str);
        this.f6269e.setText(C1680l.IDS_plugin_kidwatch_common_skip);
        this.f6269e.setVisibility(0);
        this.f6268d.setVisibility(8);
        this.f6275k.setText(str);
    }

    private void m9735a(int i, String str) {
        C2538c.m12674b(this.f6266b, "======Enter bindFail:" + str);
        if (C1492l.m6916b(this.f6284t)) {
            C1483c.m6824a((Context) this, i);
        } else {
            C1483c.m6824a(this.f6284t, C1680l.IDS_plugin_kidwatch_common_network_disable);
        }
        this.f6268d.setEnabled(true);
    }

    private String m9779l(String str) {
        String str2 = "";
        if (str == null) {
            return str2;
        }
        if (!str.contains("*")) {
            str = str.length() > 7 ? str.replace(str.substring(3, 7), "****") : str2;
        }
        return str;
    }

    private void m9774j() {
        startActivity(new Intent(this, QrCodeActivity.class));
        this.f6279o = false;
    }

    private void m9781m(String str) {
        C2538c.m12677c(this.f6266b, "Enter resetManagerPreCheck matb");
        this.f6273i.setVisibility(8);
        this.f6282r.setVisibility(8);
        this.f6281q.setVisibility(0);
        this.f6268d.setVisibility(8);
        this.f6276l.setVisibility(4);
        this.f6275k.setText(C1680l.IDS_plugin_kidwatch_watch_pair_tip);
        this.f6278n.mo2506a(str, new C1921l(this, str));
        C2538c.m12677c(this.f6266b, "Leave resetManagerPreCheck matb");
    }

    private void m9782n(String str) {
        C2538c.m12677c(this.f6266b, "Enter resetManager matb");
        this.f6273i.setVisibility(8);
        this.f6282r.setVisibility(8);
        this.f6272h.setVisibility(8);
        this.f6281q.setVisibility(0);
        this.f6268d.setVisibility(8);
        this.f6276l.setVisibility(4);
        this.f6275k.setText(C1680l.IDS_plugin_kidwatch_settings_changing_main_administer);
        if (this.f6288x != null) {
            this.f6288x.postDelayed(new C1926q(this, str), 1000);
        }
        C2538c.m12677c(this.f6266b, "Leave resetManager");
    }

    public void onClick(View view) {
        int id = view.getId();
        if (g.guide_btn_scanqrcode == id) {
            if (C1492l.m6913a((Context) this, C1466a.m6779c())) {
                m9774j();
            } else {
                C1492l.m6910a((Activity) this, C1466a.m6779c());
            }
        } else if (g.guide_btn_next == id) {
            if (this.f6269e.getText().equals(getResources().getString(C1680l.IDS_plugin_kidwatch_common_skip))) {
                C2538c.m12674b(this.f6266b, "=============点击跳过，跳转到主页=======");
                C1462f.m6731d(this.f6280p);
                r0 = new Intent();
                r0.setClassName(this, "com.huawei.pluginkidwatch.home.HomeActivity");
                startActivity(r0);
                finish();
                return;
            }
            r0 = new Intent();
            if (this.f6274j == null || "".equals(this.f6274j)) {
                C2538c.m12674b(this.f6266b, "============跳转到手表号码设置页面=======");
                r0.setClass(this, SetKidWatchNumActivity.class);
                r0.putExtra("in_guide", true);
                r0.putExtra("device_code_in_guide", this.f6280p);
                r0.putExtra("phone_num_in_guide", this.f6274j);
                r0.setPackage(this.f6284t.getPackageName());
            } else {
                C2538c.m12674b(this.f6266b, "============手表号码已上报，直接进入宝贝信息设置界面设置页面=======");
                C1462f.m6731d(this.f6280p);
                C1497q.m6943a(getApplicationContext(), "sharedpreferences_watch_device_code", this.f6280p);
                r0.putExtra("in_guide", true);
                r0.setClass(this.f6284t, ProfileSettingActivity.class);
            }
            startActivity(r0);
            finish();
        } else if (g.guide_btn_back == id) {
            C2538c.m12674b(this.f6266b, "===========点击上一步=======");
            r0 = new Intent();
            r0.setClass(this.f6284t, RelationSettingActivity.class);
            r0.addFlags(HwAccountConstants.FLAG_TRANSLUCENT_STATUS);
            r0.setPackage(this.f6284t.getPackageName());
            r0.putExtra(this.f6285u, true);
            startActivity(r0);
            finish();
        } else if (g.guide_btn_finish == id) {
            C1462f.m6731d(this.f6280p);
            r0 = new Intent();
            r0.setClassName(this, "com.huawei.pluginkidwatch.home.HomeActivity");
            startActivity(r0);
            finish();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.f6279o = true;
        if (i2 == -1) {
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(getContentResolver().openInputStream(intent.getData()));
                if (decodeStream != null) {
                    m9736a(decodeStream);
                } else {
                    C1483c.m6832c(this, getResources().getString(C1680l.IDS_plugin_kidwatch_settings_bind_qrcode_scan_nothing));
                }
            } catch (FileNotFoundException e) {
                C2538c.m12674b(this.f6266b, e.getMessage());
                C1483c.m6832c(this, getResources().getString(C1680l.IDS_plugin_kidwatch_settings_bind_qrcode_scan_nothing));
            }
        }
    }

    private void m9736a(Bitmap bitmap) {
        C2538c.m12674b(this.f6266b, "===========Enter decode =======");
        com.google.zxing.h hVar = new com.google.zxing.h();
        Map hashtable = new Hashtable(2);
        Object vector = new Vector();
        if (vector == null || vector.isEmpty()) {
            vector = new Vector();
            vector.addAll(C1963j.f6815b);
            vector.addAll(C1963j.f6816c);
            vector.addAll(C1963j.f6817d);
        }
        hashtable.put(e.c, vector);
        hVar.a(hashtable);
        m mVar = null;
        if (bitmap != null) {
            try {
                mVar = hVar.a(new c(new j(new C1945b(bitmap))));
            } catch (i e) {
                C2538c.m12680e(this.f6266b, "Exception e = " + e.getMessage());
            }
        }
        if (mVar == null) {
            C1483c.m6824a((Context) this, C1680l.IDS_plugin_kidwatch_settings_bind_qrcode_scan_nothing);
            return;
        }
        String a = mVar.a();
        C2538c.m12674b(this.f6266b, "===www123====processScanResult(res)= " + a);
        m9783o(a);
    }

    private void m9783o(String str) {
        C2538c.m12674b(this.f6266b, "===========Enter processScanResult =======");
        if (str != null && !"".equals(str)) {
            String[] split = str.split(";");
            if (str.contains("#")) {
                split = str.split("#");
            }
            if (split.length >= 4) {
                String str2 = split[2];
                String str3 = split[1];
                if (str2.startsWith("IMEI:")) {
                    str2 = str2.substring("IMEI:".length(), str2.length());
                    C2538c.m12674b(this.f6266b, "===Geted IMEI CODE===");
                    if (!"".equals(str2)) {
                        m9739a(str2);
                    }
                }
                if (str3.startsWith("MAC:")) {
                    str3 = str3.substring("MAC:".length(), str3.length());
                    C2538c.m12674b(this.f6266b, "===Geted MAC CODE===");
                    if (!"".equals(str3)) {
                        this.f6286v = str3;
                    }
                }
            }
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        C2538c.m12674b(this.f6266b, "Activity-onRequestPermissionsResult() PermissionsManager.notifyPermissionsChange()");
        b.a().a(strArr, iArr);
        switch (i) {
            case 1:
                Map hashMap = new HashMap();
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    C2538c.m12674b(this.f6266b, "onRequestPermissionsResult permissions = ", strArr[i2], ", grantResults = ", Integer.valueOf(iArr[i2]));
                    hashMap.put(strArr[i2], Integer.valueOf(iArr[i2]));
                }
                if (hashMap.containsKey("android.permission.CAMERA") && ((Integer) hashMap.get("android.permission.CAMERA")).intValue() == 0) {
                    m9774j();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        C2538c.m12674b(this.f6266b, "===========click onkeydown  =======");
        Intent intent = new Intent();
        intent.setClass(this.f6284t, RelationSettingActivity.class);
        intent.addFlags(HwAccountConstants.FLAG_TRANSLUCENT_STATUS);
        intent.setPackage(this.f6284t.getPackageName());
        intent.putExtra(this.f6285u, true);
        startActivity(intent);
        finish();
        return true;
    }

    protected void onDestroy() {
        C2538c.m12674b(this.f6266b, "===========onDestroy=======");
        C0977d.m3575n(this.f6284t);
        super.onDestroy();
        if (this.f6288x != null) {
            this.f6288x.removeCallbacksAndMessages(null);
        }
    }
}
