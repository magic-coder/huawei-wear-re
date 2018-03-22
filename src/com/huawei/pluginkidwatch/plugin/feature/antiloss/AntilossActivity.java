package com.huawei.pluginkidwatch.plugin.feature.antiloss;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.b.a;
import com.huawei.l.a.c;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1413d;
import com.huawei.pluginkidwatch.common.entity.C1417a;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.DeviceBindUsersIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.UserInfo;
import com.huawei.pluginkidwatch.common.lib.p147b.C1465a;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.ui.base.KidWatchBaseActivity;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;
import com.huawei.pluginkidwatch.common.ui.view.C1565a;
import com.huawei.pluginkidwatch.common.ui.view.C1595v;
import com.huawei.pluginkidwatch.common.ui.view.CustomDialog;
import com.huawei.pluginkidwatch.d;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.plugin.feature.antiloss.p162a.C1773a;
import com.huawei.pluginkidwatch.plugin.feature.antiloss.service.KidWatchService;
import com.huawei.pluginkidwatch.plugin.p152a.C1647c;
import com.huawei.pluginkidwatch.plugin.p152a.C1723d;
import com.huawei.pluginkidwatch.plugin.p152a.C1743x;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.log4j.helpers.FileWatchdog;

public class AntilossActivity extends KidWatchBaseActivity implements OnClickListener {
    private C1413d f4870A;
    private UserInfo f4871B;
    private C1565a f4872C = null;
    private Bitmap f4873D = null;
    private Bitmap f4874E = null;
    private int f4875F = 0;
    private Timer f4876G = new Timer();
    private TimerTask f4877H = new C1792p(this);
    private BroadcastReceiver f4878I;
    private Context f4879J;
    private Handler f4880K = new Handler(new C1777a(this));
    private final BroadcastReceiver f4881L = new C1780d(this);
    private C1647c f4882M = new C1784h(this);
    private ImageView f4883b;
    private ImageView f4884c;
    private ImageView f4885d;
    private ImageView f4886e;
    private ImageView f4887f;
    private ImageView f4888g;
    private TextView f4889h;
    private TextView f4890i;
    private TextView f4891j;
    private TextView f4892k;
    private LinearLayout f4893l;
    private LinearLayout f4894m;
    private LinearLayout f4895n;
    private LinearLayout f4896o;
    private Button f4897p;
    private Button f4898q;
    private Button f4899r;
    private IntentFilter f4900s;
    private BluetoothAdapter f4901t = BluetoothAdapter.getDefaultAdapter();
    private ServiceConnection f4902u;
    private KidWatchService f4903v;
    private C1723d f4904w;
    private String f4905x;
    private String f4906y;
    private CustomDialog f4907z;

    private void m8504d() {
        this.f4870A = C1417a.m6594a(this);
        if (C1462f.m6748k() != null) {
            this.f4905x = C1462f.m6748k().f3096p.toUpperCase(Locale.getDefault());
            this.f4906y = C1462f.m6748k().f3083c;
        } else {
            this.f4905x = "";
            this.f4906y = getResources().getString(C1680l.IDS_plugin_kidwatch_settings_profilekid_nickname_default);
        }
        this.f4904w = C1743x.m8322a((Context) this).m8323a();
        if (this.f4904w == null || !this.f4905x.equals(this.f4904w.m8281a())) {
            this.f4904w = new C1723d(this, this.f4905x);
            C1743x.m8322a((Context) this).m8324a(this.f4904w);
        }
        this.f4904w.m8290b(this.f4906y);
        this.f4904w.m8285a(C1462f.m6746j());
        this.f4904w.m8284a(this.f4882M);
        if (this.f4872C == null) {
            this.f4872C = new C1565a();
        }
        m8523m();
    }

    private void m8507e() {
        this.f4883b = (ImageView) findViewById(g.feature_iv_antiloss_connectstate);
        this.f4886e = (ImageView) findViewById(g.feature_iv_antiloss_move);
        this.f4887f = (ImageView) findViewById(g.feature_iv_antiloss_connecting_point);
        this.f4888g = (ImageView) findViewById(g.feature_iv_antiloss_link_wave);
        this.f4893l = (LinearLayout) findViewById(g.feature_llyt_antiloss_connect_failue);
        this.f4889h = (TextView) findViewById(g.feature_ftv_antiloss_connect_state);
        this.f4890i = (TextView) findViewById(g.feature_ftv_antiloss_connect_failue_notice);
        this.f4891j = (TextView) findViewById(g.feature_tv_antiloss_connect_failue_notice_content);
        this.f4892k = (TextView) findViewById(g.feature_ftv_antiloss_notice);
        this.f4895n = (LinearLayout) findViewById(g.feature_llyt_antiloss_parent_head);
        this.f4884c = (ImageView) findViewById(g.feature_iv_antiloss_parent_head);
        this.f4896o = (LinearLayout) findViewById(g.feature_llyt_antiloss_kid_head);
        this.f4885d = (ImageView) findViewById(g.feature_iv_antiloss_kid_head);
        this.f4894m = (LinearLayout) findViewById(g.feature_llyt_antiloss_btn);
        this.f4897p = (Button) findViewById(g.feature_btn_antiloss_connect_cancel);
        this.f4898q = (Button) findViewById(g.feature_btn_antiloss_connect_retry);
        this.f4899r = (Button) findViewById(g.feature_btn_antiloss_close);
        this.f4897p.setOnClickListener(this);
        this.f4898q.setOnClickListener(this);
        this.f4899r.setOnClickListener(this);
    }

    private void m8508f() {
        this.f4900s = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
        registerReceiver(this.f4881L, this.f4900s);
        this.f4902u = new C1785i(this);
        m8537t();
    }

    private void m8511g() {
        if (9 == this.f4904w.m8303j()) {
            switch (this.f4904w.m8302i()) {
                case -1:
                case 0:
                case 3:
                    m8533r();
                    if (this.f4901t.isEnabled()) {
                        C2538c.m12674b("AntilossActivity", "initAntilossState curKWBtDevice connect !!!!!");
                        if (C1773a.m8552a(this.f4879J) != null) {
                            C1773a.m8552a(this.f4879J).m8560d(this.f4879J);
                        }
                        this.f4904w.m8293c(this.f4882M);
                        return;
                    }
                    return;
                case 1:
                case 4:
                    m8533r();
                    return;
                case 2:
                    m8524n();
                    m8539u();
                    return;
                default:
                    return;
            }
        }
        m8524n();
        m8539u();
    }

    protected void mo2517a() {
        this.f4879J = this;
        requestWindowFeature(1);
        setContentView(h.activity_antiloss);
        m8507e();
        m8504d();
        m8508f();
        m8513h();
    }

    private void m8513h() {
        C2538c.m12674b("AntilossActivity", "========Enter registerCloseAntilossActivityReceiver");
        this.f4878I = new C1794r(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.kone.broadcast.close.antilossactivity");
        LocalBroadcastManager.getInstance(this.f4879J).registerReceiver(this.f4878I, intentFilter);
    }

    public void onClick(View view) {
        if (!isFinishing()) {
            if (g.feature_btn_antiloss_connect_cancel == view.getId()) {
                m8514i();
            } else if (g.feature_btn_antiloss_connect_retry == view.getId()) {
                m8516j();
            } else if (g.feature_btn_antiloss_close == view.getId()) {
                m8519k();
            }
        }
    }

    private void m8514i() {
        C2538c.m12674b("AntilossActivity", "=========feature_btn_antiloss_connect_cancel=====");
        this.f4903v.m8587a(true);
        if (2 == this.f4904w.m8302i()) {
            this.f4904w.m8299f(2);
        }
        this.f4904w.m8292c(9);
        this.f4904w.m8301h();
        finish();
    }

    private void m8516j() {
        if (C1773a.m8552a((Context) this) != null) {
            C1773a.m8552a((Context) this).m8560d(this);
        }
        m8523m();
        m8533r();
        if (3 == this.f4904w.m8302i() || this.f4904w.m8302i() == 0 || -1 == this.f4904w.m8302i()) {
            C2538c.m12674b("AntilossActivity", "onClick feature_btn_antiloss_connect_retry curKWBtDevice connect !!!!!");
            this.f4904w.m8293c(this.f4882M);
        }
    }

    private void m8519k() {
        Map hashMap = new HashMap();
        hashMap.put("click", "1");
        c.a().a(BaseApplication.m2632b(), a.af.a(), hashMap, 0);
        C2538c.m12674b("AntilossActivity", "=========退出随行=====");
        C2538c.m12674b("AntilossActivity", "=========feature_btn_antiloss_close=====");
        C1506g.m6978a(this, getResources().getString(C1680l.IDS_plugin_kidwatch_feature_antiloss_close_notice), false);
        this.f4903v.m8587a(true);
        this.f4904w.m8292c(9);
        if (2 == this.f4904w.m8302i()) {
            C2538c.m12674b("AntilossActivity", "=========退出随行  setDeviceLinkLoss 2222=====");
            this.f4904w.m8283a(2, new C1787k(this));
            if (this.f4880K != null) {
                this.f4880K.postDelayed(new C1788l(this), FileWatchdog.DEFAULT_DELAY);
                return;
            }
            return;
        }
        C2538c.m12674b("AntilossActivity", "=========退出随行  KWBtDevice.STATE_CONNECTED =====");
        if (!isFinishing()) {
            C1506g.m6979b();
            finish();
        }
    }

    private void m8521l() {
        if (this.f4880K != null) {
            if (this.f4904w != null) {
                this.f4904w.m8289b(this.f4882M);
            }
            this.f4880K.post(new C1789m(this));
            this.f4880K.postDelayed(new C1790n(this), 6000);
        }
    }

    private void m8523m() {
        if (this.f4876G == null) {
            this.f4876G = new Timer();
        }
        this.f4877H.cancel();
        this.f4877H = new C1792p(this);
        this.f4876G.schedule(this.f4877H, 0, 5000);
    }

    private void m8524n() {
        this.f4875F = 0;
        if (this.f4876G != null) {
            this.f4876G.cancel();
            this.f4876G = null;
        }
    }

    private void m8527o() {
        if (C1462f.m6748k() != null) {
            this.f4873D = this.f4872C.m7218a((Context) this, C1462f.m6748k().f3098r);
            if (this.f4873D == null) {
                this.f4873D = this.f4872C.m7219a((Context) this, C1462f.m6748k().f3098r, this.f4880K);
            }
        }
        if (this.f4873D == null) {
            this.f4896o.setVisibility(0);
            if (C1462f.m6748k() == null || 1 != C1462f.m6748k().f3091k) {
                this.f4885d.setImageResource(C1617f.kw_pic_user_boy);
                return;
            } else {
                this.f4885d.setImageResource(C1617f.kw_pic_user_girl);
                return;
            }
        }
        this.f4896o.setVisibility(0);
        this.f4885d.setImageBitmap(this.f4873D);
    }

    private void m8528p() {
        if (2 == this.f4904w.m8302i()) {
            this.f4895n.setVisibility(0);
            this.f4887f.setVisibility(4);
            this.f4883b.setVisibility(4);
            if (this.f4871B != null) {
                C2538c.m12674b("AntilossActivity", "showParentHeadImage userInfo.bigHeadIcon = " + this.f4871B.bigHeadIcon);
                if ("".equals(this.f4871B.bigHeadIcon)) {
                    String trim = this.f4871B.type.trim();
                    C2538c.m12674b("AntilossActivity", "showParentHeadImage userType = " + trim);
                    if ("".equals(trim) || "0".equals(trim)) {
                        this.f4884c.setImageResource(C1617f.kw_pic_ist_user_common);
                        return;
                    } else if ("1".equals(trim)) {
                        this.f4884c.setImageResource(C1617f.kw_pic_relation_mid_dad);
                        return;
                    } else if ("2".equals(trim)) {
                        this.f4884c.setImageResource(C1617f.kw_pic_relation_mid_mom);
                        return;
                    } else if ("3".equals(trim)) {
                        this.f4884c.setImageResource(C1617f.kw_pic_relation_mid_grandpa);
                        return;
                    } else if ("4".equals(trim)) {
                        this.f4884c.setImageResource(C1617f.kw_pic_relation_mid_grandma);
                        return;
                    } else if ("5".equals(trim)) {
                        this.f4884c.setImageResource(C1617f.kw_pic_user_boy);
                        return;
                    } else if ("6".equals(trim)) {
                        this.f4884c.setImageResource(C1617f.kw_pic_user_girl);
                        return;
                    } else {
                        return;
                    }
                }
                this.f4874E = C1465a.m6770a().m6776b(this.f4871B.bigHeadIcon);
                if (this.f4874E == null) {
                    this.f4874E = this.f4872C.m7218a((Context) this, this.f4871B.bigHeadIcon);
                    if (this.f4874E == null) {
                        this.f4872C.m7219a((Context) this, this.f4871B.bigHeadIcon, this.f4880K);
                        return;
                    }
                    this.f4874E = C1492l.m6903a(this.f4874E);
                    this.f4884c.setImageBitmap(this.f4874E);
                    return;
                }
                this.f4874E = C1492l.m6903a(this.f4874E);
                this.f4884c.setImageBitmap(this.f4874E);
                return;
            }
            this.f4884c.setImageResource(C1617f.kw_pic_ist_user_common);
            m8530q();
        }
    }

    private void m8530q() {
        C2538c.m12674b("AntilossActivity", "==enter  getParentHeadUrl ");
        DeviceBindUsersIOEntityModel deviceBindUsersIOEntityModel = new DeviceBindUsersIOEntityModel();
        deviceBindUsersIOEntityModel.deviceCode = C1462f.m6746j();
        this.f4870A.mo2477a(deviceBindUsersIOEntityModel, new C1791o(this));
    }

    private void m8533r() {
        this.f4883b.setVisibility(0);
        this.f4883b.setImageResource(C1617f.kw_pic_antiloss_connecting);
        this.f4895n.setVisibility(4);
        this.f4892k.setText(C1680l.IDS_plugin_kidwatch_feature_antiloss_notice);
        this.f4896o.setVisibility(8);
        this.f4893l.setVisibility(4);
        this.f4894m.setVisibility(4);
        this.f4886e.setVisibility(4);
        this.f4888g.setVisibility(0);
        this.f4887f.setVisibility(0);
        this.f4887f.setBackgroundResource(C1617f.dot_animation);
        ((AnimationDrawable) this.f4887f.getBackground()).start();
    }

    private void m8535s() {
        if (!isFinishing()) {
            C1595v c1595v = new C1595v(this);
            c1595v.m7339a(C1680l.IDS_plugin_kidwatch_common_ui_notice_title);
            c1595v.m7348b(C1680l.IDS_plugin_kidwatch_feature_antiloss_bluetooth_disable_notice);
            c1595v.m7340a(C1680l.IDS_plugin_kidwatch_common_ok, new C1778b(this));
            c1595v.m7341a(new C1779c(this));
            this.f4907z = c1595v.m7338a();
            this.f4907z.setCancelable(false);
            this.f4907z.show();
        }
    }

    private void m8537t() {
        Intent intent = new Intent(this, KidWatchService.class);
        intent.setPackage(getPackageName());
        bindService(intent, this.f4902u, 1);
    }

    private void m8539u() {
        this.f4888g.setVisibility(0);
        this.f4887f.setVisibility(4);
        m8541w();
        m8528p();
        m8527o();
        this.f4889h.setText(C1680l.IDS_plugin_kidwatch_feature_antiloss_doing);
        this.f4889h.setTextColor(getResources().getColor(d.kw_color_white_100alpha));
        this.f4893l.setVisibility(4);
        this.f4894m.setVisibility(0);
        this.f4899r.setVisibility(0);
        this.f4897p.setVisibility(8);
        this.f4898q.setVisibility(8);
        this.f4892k.setText(C1680l.IDS_plugin_kidwatch_feature_antiloss_notice_alarm);
    }

    private void m8540v() {
        this.f4888g.setVisibility(4);
        this.f4887f.setVisibility(4);
        this.f4889h.setText(C1680l.IDS_plugin_kidwatch_common_connect_failed);
        this.f4889h.setTextColor(getResources().getColor(d.kw_color_antiloss_connect_failue));
        this.f4883b.setVisibility(0);
        this.f4883b.setImageResource(C1617f.kw_pic_antiloss_disconnect);
        this.f4895n.setVisibility(4);
        this.f4896o.setVisibility(8);
        this.f4886e.clearAnimation();
        this.f4886e.setVisibility(8);
        this.f4893l.setVisibility(0);
        this.f4890i.setText(getResources().getString(C1680l.IDS_plugin_kidwatch_feature_antiloss_connect_failue_notice, new Object[]{this.f4906y}));
        this.f4891j.setText(String.format(getResources().getString(C1680l.IDS_plugin_kidwatch_feature_antiloss_connect_failue_content), new Object[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3)}));
        this.f4894m.setVisibility(0);
        this.f4897p.setVisibility(0);
        this.f4898q.setVisibility(0);
        this.f4899r.setVisibility(8);
    }

    protected void onDestroy() {
        C2538c.m12674b("AntilossActivity", "========Enter onDestroy");
        super.onDestroy();
        if (this.f4904w != null) {
            this.f4904w.m8289b(this.f4882M);
        }
        m8524n();
        this.f4887f.setVisibility(4);
        unregisterReceiver(this.f4881L);
        unbindService(this.f4902u);
        LocalBroadcastManager.getInstance(this.f4879J).unregisterReceiver(this.f4878I);
        if (this.f4873D != null) {
            this.f4873D.recycle();
        }
    }

    private void m8541w() {
        Animation rotateAnimation = new RotateAnimation(0.0f, 1080.0f, 2, 0.5f, 2, 0.5f);
        rotateAnimation.setDuration(21000);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        this.f4886e.setVisibility(0);
        this.f4886e.startAnimation(rotateAnimation);
    }
}
