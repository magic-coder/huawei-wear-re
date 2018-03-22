package com.huawei.sim.multisim;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.AnimationDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.amap.api.maps.model.WeightedLatLng;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.p063b.C4713a;
import com.huawei.multisimsdk.multidevicemanager.c.f;
import com.huawei.multisimsdk.multidevicemanager.common.b;
import com.huawei.multisimsdk.multidevicemanager.common.e;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.QueryRecordsListCallback;
import com.huawei.nfc.carrera.logic.oma.IOmaService;
import com.huawei.p190v.C2538c;
import com.huawei.p464l.p465a.C5417c;
import com.huawei.sim.C4501b;
import com.huawei.sim.C5898a;
import com.huawei.sim.d;
import com.huawei.sim.g;
import com.huawei.sim.h;
import com.huawei.sim.i;
import com.huawei.sim.j;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.dialog.C6002a;
import com.huawei.ui.commonui.dialog.C6022u;
import com.huawei.ui.commonui.dialog.C6024w;
import com.huawei.ui.commonui.webview.WebViewActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MultiSimConfigActivity extends BaseActivity implements OnClickListener {
    Button f20471A;
    Button f20472B;
    Button f20473C;
    Button f20474D;
    Button f20475E;
    Button f20476F;
    Button f20477G;
    OnClickListener f20478H = new C5952c(this);
    OnClickListener f20479I = new C5954e(this);
    boolean f20480J = false;
    String f20481K = "http://health.vmall.com/help/huawei-watch2/errorcode/index.html";
    String[] f20482L;
    boolean[] f20483M;
    TextWatcher f20484N = new C5961l(this);
    TextWatcher f20485O = new C5951b(this);
    private C4501b f20486P;
    private String f20487Q = "";
    private int f20488R = 0;
    private int f20489S = 0;
    private C5965p f20490T;
    private EditText f20491U;
    private EditText f20492V;
    private View f20493W;
    private View f20494X;
    private TextView f20495Y;
    private ListView f20496Z;
    public Context f20497a;
    private int aa = 0;
    private C6002a ab = null;
    private final BroadcastReceiver ac = new C5950a(this);
    private C6022u ad;
    private int ae = 60;
    private C6002a af = null;
    private OnItemClickListener ag;
    f f20498b;
    LinearLayout f20499c;
    LinearLayout f20500d;
    LinearLayout f20501e;
    LinearLayout f20502f;
    LinearLayout f20503g;
    LinearLayout f20504h;
    LinearLayout f20505i;
    LinearLayout f20506j;
    LinearLayout f20507k;
    LinearLayout f20508l;
    LinearLayout f20509m;
    LinearLayout f20510n;
    LinearLayout f20511o;
    LinearLayout f20512p;
    TextView f20513q;
    TextView f20514r;
    LinearLayout f20515s;
    LinearLayout f20516t;
    LinearLayout f20517u;
    LinearLayout f20518v;
    TextView f20519w;
    Button f20520x;
    Button f20521y;
    Button f20522z;

    public void m27358a() {
        C2538c.c("MultiSimConfigActivity", new Object[]{"initSDK"});
        this.f20498b = new f();
        this.f20498b.a(this.f20497a);
    }

    public void m27359b() {
        C2538c.c("MultiSimConfigActivity", new Object[]{"unInitSDK"});
        this.f20498b.a();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C2538c.c("MultiSimConfigActivity", new Object[]{"onCreate"});
        this.f20497a = this;
        this.f20486P = (C4501b) C5898a.m27101a((Context) this).getAdapter();
        if (this.f20486P == null) {
            C2538c.e("MultiSimConfigActivity", new Object[]{"pluginSimAdapter is null"});
            return;
        }
        this.f20490T = new C5965p(this);
        m27323e();
        m27358a();
        m27352u();
        m27307c();
    }

    protected void onResume() {
        super.onResume();
        m27356y();
    }

    protected void onDestroy() {
        super.onDestroy();
        C2538c.c("MultiSimConfigActivity", new Object[]{"onDestroy"});
        m27359b();
        m27277K();
        this.f20490T.removeCallbacksAndMessages(null);
        if (this.f20490T.hasMessages(7)) {
            this.f20490T.removeMessages(7);
        }
        m27316d();
    }

    private void m27307c() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.bone.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(this.ac, intentFilter);
    }

    private void m27316d() {
        try {
            C2538c.c("MultiSimConfigActivity", new Object[]{"Enter unregisterNonLocalBroadcast()!"});
            unregisterReceiver(this.ac);
        } catch (IllegalArgumentException e) {
            C2538c.c("MultiSimConfigActivity", new Object[]{e.getMessage()});
        } catch (RuntimeException e2) {
            C2538c.c("MultiSimConfigActivity", new Object[]{e2.getMessage()});
        }
    }

    private void m27323e() {
        setContentView(h.activity_multi_sim_config);
        this.f20499c = (LinearLayout) findViewById(g.multi_sim_config_open);
        this.f20500d = (LinearLayout) findViewById(g.multi_sim_config_open_error);
        this.f20501e = (LinearLayout) findViewById(g.multi_sim_config_query_error);
        this.f20502f = (LinearLayout) findViewById(g.multi_sim_config_unbind);
        this.f20503g = (LinearLayout) findViewById(g.multi_sim_config_waiting);
        this.f20504h = (LinearLayout) findViewById(g.multi_sim_config_confirm);
        this.f20505i = (LinearLayout) findViewById(g.multi_sim_config_sms_reauth);
        this.f20506j = (LinearLayout) findViewById(g.multi_sim_config_phone_select);
        this.f20507k = (LinearLayout) findViewById(g.multi_sim_config_start);
        this.f20496Z = (ListView) findViewById(g.phone_num_list);
        this.f20508l = (LinearLayout) findViewById(g.multi_sim_config_msg_auth);
        this.f20511o = (LinearLayout) findViewById(g.authButtonPanel);
        this.f20511o.setOnClickListener(this);
        this.f20520x = (Button) findViewById(g.multi_sim_cinfig_btn_open);
        this.f20520x.setOnClickListener(this);
        this.f20521y = (Button) findViewById(g.multi_sim_cinfig_btn_start);
        this.f20521y.setOnClickListener(this);
        this.f20522z = (Button) findViewById(g.multi_sim_config_btn_requery);
        this.f20522z.setOnClickListener(this);
        this.f20471A = (Button) findViewById(g.multi_sim_config_btn_unbind);
        this.f20471A.setOnClickListener(this);
        this.f20472B = (Button) findViewById(g.multi_sim_config_btn_confirm);
        this.f20472B.setOnClickListener(this);
        this.f20475E = (Button) findViewById(g.verify_code_button);
        this.f20475E.setOnClickListener(this);
        this.f20476F = (Button) findViewById(g.right_arrow_button);
        this.f20476F.setOnClickListener(this);
        this.f20473C = (Button) findViewById(g.multi_sim_open_confirm);
        this.f20473C.setOnClickListener(this);
        this.f20474D = (Button) findViewById(g.multi_sim_unbind_confirm);
        this.f20474D.setOnClickListener(this);
        this.f20477G = (Button) findViewById(g.multi_sim_config_btn_reauth);
        this.f20477G.setOnClickListener(this);
        this.f20512p = (LinearLayout) findViewById(g.select_phone_button_panel);
        this.f20512p.setOnClickListener(this);
        this.f20516t = (LinearLayout) findViewById(g.network_error_bar);
        this.f20515s = (LinearLayout) findViewById(g.no_sim_err_bar);
        this.f20517u = (LinearLayout) findViewById(g.bt_disconnect);
        this.f20518v = (LinearLayout) findViewById(g.bt_connecting);
        this.f20519w = (TextView) findViewById(g.network_err_text);
        this.f20519w.setOnClickListener(this);
        this.f20493W = findViewById(g.set_bt_reconnect);
        this.f20493W.setOnClickListener(this.f20478H);
        this.f20494X = findViewById(g.set_network_error);
        this.f20494X.setOnClickListener(this.f20479I);
        this.f20492V = (EditText) findViewById(g.input_text);
        this.f20491U = (EditText) findViewById(g.input_number_text);
        this.f20509m = (LinearLayout) findViewById(g.error_number_message);
        this.f20513q = (TextView) findViewById(g.input_error_number_view);
        this.f20510n = (LinearLayout) findViewById(g.error_verify_message);
        this.f20514r = (TextView) findViewById(g.input_error_verify_code_view);
        this.f20495Y = (TextView) findViewById(g.no_phone_num_text);
        this.f20495Y.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view.getId() == g.multi_sim_cinfig_btn_open) {
            C5417c.m26022a().m26023a(BaseApplication.b(), C4713a.MULTISIM_1170002.m22567a(), new HashMap(), 0);
            m27275I();
            this.f20488R = 0;
        } else if (view.getId() == g.multi_sim_cinfig_btn_start) {
            C5417c.m26022a().m26023a(BaseApplication.b(), C4713a.MULTISIM_1170004.m22567a(), new HashMap(), 0);
            m27275I();
            this.f20488R = 4;
        } else if (view.getId() == g.multi_sim_config_btn_requery) {
            m27279M();
        } else if (view.getId() == g.multi_sim_config_btn_unbind) {
            m27344n();
            this.f20488R = 2;
        } else if (view.getId() == g.multi_sim_config_btn_confirm) {
            if (this.f20488R == 2) {
                m27271E();
            } else {
                m27272F();
            }
        } else if (view.getId() == g.multi_sim_open_confirm) {
            C5417c.m26022a().m26023a(BaseApplication.b(), C4713a.MULTISIM_1170003.m22567a(), new HashMap(), 0);
            m27271E();
        } else if (view.getId() == g.multi_sim_unbind_confirm) {
            m27272F();
        } else if (view.getId() == g.verify_code_button) {
            m27338k();
        } else if (view.getId() == g.authButtonPanel) {
            m27342m();
        } else if (view.getId() == g.multi_sim_config_btn_reauth) {
            m27275I();
        } else if (view.getId() == g.network_err_text) {
            this.f20490T.sendEmptyMessageDelayed(1, 2000);
            m27353v();
            this.f20518v.setVisibility(0);
            ((ImageView) findViewById(g.bt_connecting_imgage)).startAnimation(AnimationUtils.loadAnimation(this, d.bt_connecting));
        } else if (view.getId() == g.select_phone_button_panel) {
            C2538c.c("MultiSimConfigActivity", new Object[]{"phone select "});
            m27326f();
        } else if (view.getId() == g.no_phone_num_text) {
            C2538c.c("MultiSimConfigActivity", new Object[]{"phone num not found"});
            m27312c(getString(i.IDS_plugin_multi_device_not_bind));
        }
    }

    private void m27326f() {
        int i = 0;
        while (i < this.f20483M.length) {
            C2538c.c("MultiSimConfigActivity", new Object[]{"procPhoneSelect i ", Integer.valueOf(i), "items[i]", this.f20482L[i]});
            if (this.f20483M[i]) {
                C2538c.c("MultiSimConfigActivity", new Object[]{"procPhoneSelect checked i ", Integer.valueOf(i), "items[i]", this.f20482L[i]});
                break;
            }
            i++;
        }
        if (i < this.f20483M.length) {
            C2538c.c("MultiSimConfigActivity", new Object[]{"select phone num", this.f20482L[i]});
            this.f20486P.mo4471a(this.f20487Q, this.f20482L[i], 1);
            m27271E();
            return;
        }
        C2538c.c("MultiSimConfigActivity", new Object[]{"not select phone num"});
    }

    private void m27330g() {
        if (this.ab != null || isFinishing()) {
            C2538c.c("MultiSimConfigActivity", new Object[]{"showLoadingDialog have dialog"});
            return;
        }
        C2538c.c("MultiSimConfigActivity", new Object[]{"21 no dialog"});
        C6002a c6002a = new C6002a(this, j.app_update_dialogActivity);
        this.ab = C6002a.m27468a((Context) this);
        this.ab.m27476a(this.f20497a.getString(i.IDS_plugin_sim_esim_handling));
        this.ab.m27474a();
    }

    private void m27332h() {
        C2538c.c("MultiSimConfigActivity", new Object[]{"enter dismissLoadingDialog()"});
        if (this.ab != null && this.ab.isShowing()) {
            C2538c.c("MultiSimConfigActivity", new Object[]{"dismissdialog!"});
            if (!isFinishing()) {
                this.ab.dismiss();
                this.ab = null;
            }
        }
    }

    private void m27335i() {
        C6024w c6024w = new C6024w(this.f20497a);
        c6024w.m27594a(this.f20497a.getString(i.IDS_plugin_multi_sim_note));
        c6024w.m27598b(this.f20497a.getString(i.IDS_plugin_multi_sim_unicom_user));
        c6024w.m27595a(this.f20497a.getString(i.IDS_plugin_multi_sim_known), new C5956g(this));
        this.ad = c6024w.m27590a();
        this.ad.setCancelable(false);
        if (!this.ad.isShowing()) {
            this.ad.show();
        }
    }

    private void m27293a(String str) {
        this.f20509m.setVisibility(0);
        this.f20513q.setText(str);
    }

    private void m27336j() {
        this.f20509m.setVisibility(8);
    }

    private void m27338k() {
        C2538c.c("MultiSimConfigActivity", new Object[]{"onClickGetSmsAuthCode"});
        String obj = this.f20491U.getText().toString();
        C2538c.c("MultiSimConfigActivity", new Object[]{"input PhoneNumber is", obj});
        if (TextUtils.isEmpty(obj)) {
            m27293a(getResources().getString(i.IDS_plugin_multi_sim_plz_input_phone_num));
            this.f20491U.requestFocus();
            return;
        }
        this.f20487Q = C5969t.m27378a(obj);
        C2538c.c("MultiSimConfigActivity", new Object[]{"input get PhoneNumber is", this.f20487Q, " length=", Integer.valueOf(this.f20487Q.length())});
        if (!C5969t.m27380b(this.f20487Q)) {
            m27293a(getResources().getString(i.IDS_plugin_multi_sim_phone_num_error));
            this.f20491U.requestFocus();
        } else if (this.f20498b.a(this.f20497a, this.f20487Q)) {
            m27328f(this.f20487Q);
            this.ae = 60;
            m27287a(this.f20475E);
            this.f20475E.setText(String.format(getResources().getString(i.IDS_plugin_multi_sim_obtain_verify_code_with_timer), new Object[]{Integer.toString(this.ae)}));
            this.f20490T.sendEmptyMessageDelayed(7, 1000);
            m27336j();
            m27341l();
            this.f20480J = false;
            this.f20492V.setText("");
            this.f20492V.requestFocus();
        } else if (C5969t.m27381c(this.f20487Q)) {
            C2538c.c("MultiSimConfigActivity", new Object[]{"carrier is unicom"});
            m27335i();
        } else {
            C2538c.c("MultiSimConfigActivity", new Object[]{"carrier not support"});
            m27293a(getResources().getString(i.IDS_plugin_multi_sim_unsupport_operater));
        }
    }

    private void m27303b(String str) {
        this.f20510n.setVisibility(0);
        this.f20514r.setText(str);
    }

    private void m27341l() {
        this.f20510n.setVisibility(8);
    }

    private void m27342m() {
        C2538c.c("MultiSimConfigActivity", new Object[]{"onClickstartSmsAuth"});
        String obj = this.f20492V.getText().toString();
        C2538c.c("MultiSimConfigActivity", new Object[]{"input veryfication code is", obj});
        if (TextUtils.isEmpty(obj)) {
            this.f20491U.requestFocus();
            return;
        }
        m27321d(this.f20487Q, obj);
        m27346o();
    }

    private void m27344n() {
        if (this.af == null) {
            C2538c.c("MultiSimConfigActivity", new Object[]{"show basic info notice for 21"});
            C6002a c6002a = new C6002a(this.f20497a, j.multi_sim_unbind_dialogActivity);
            this.af = C6002a.m27469b(this.f20497a);
            this.af.m27479b(this.f20497a.getString(i.IDS_plugin_multi_sim_unbind_dialog_title));
            this.af.m27482c(this.f20497a.getString(i.IDS_plugin_multi_sim_unbind_dialog_notic));
            this.af.m27480b(this.f20497a.getString(i.IDS_settings_button_cancal), new C5957h(this));
            this.af.m27477a(this.f20497a.getString(i.IDS_plugin_multi_sim_unbind_dialog_btn_unbind), new C5958i(this));
            this.af.m27478b();
        }
    }

    private String m27286a(e eVar) {
        String str = "";
        if (eVar == null) {
            C2538c.c("MultiSimConfigActivity", new Object[]{"getCurBindStatus  pairedDeviceList is null"});
        } else {
            ArrayList a = eVar.a();
            if (a == null) {
                C2538c.c("MultiSimConfigActivity", new Object[]{"getCurBindStatus  pairedDeviceList is null"});
            } else {
                C2538c.c("MultiSimConfigActivity", new Object[]{"getCurBindStatus imsi=", this.f20486P.mo4480g()});
                if (!this.f20486P.mo4480g().isEmpty()) {
                    Iterator it = a.iterator();
                    while (it.hasNext()) {
                        str = ((com.huawei.multisimsdk.multidevicemanager.common.g) it.next()).b();
                        C2538c.c("MultiSimConfigActivity", new Object[]{"getCurBindStatus pairedImsi=", str});
                        if (!str.isEmpty()) {
                            break;
                        }
                    }
                }
            }
        }
        return str;
    }

    private void m27288a(com.huawei.multisimsdk.multidevicemanager.common.f fVar) {
        C2538c.c("MultiSimConfigActivity", new Object[]{"refreshOpenMultiSimRet "});
        m27277K();
        if (fVar == null) {
            C2538c.e("MultiSimConfigActivity", new Object[]{"refreshOpenMultiSimRet  ret is null"});
            m27295a(getString(i.IDS_plugin_multi_sim_open_fail), getString(i.IDS_plugin_multi_sim_open_result_query_fail_notic));
            return;
        }
        C2538c.c("MultiSimConfigActivity", new Object[]{"refreshOpenMultiSimRet ret  action = ", Integer.valueOf(fVar.a())});
        C2538c.c("MultiSimConfigActivity", new Object[]{"refreshOpenMultiSimRet ret  result = ", Integer.valueOf(fVar.b())});
        C2538c.c("MultiSimConfigActivity", new Object[]{"refreshOpenMultiSimRet ret  reason = ", Integer.valueOf(fVar.c())});
        if (fVar.b() == 0 || fVar.b() == IOmaService.RETURN_APDU_EXCUTE_OPENCHANNEL_EXCEPTION) {
            this.f20486P.mo4471a(this.f20487Q, m27286a(fVar.d()), 1);
            m27325e(getString(i.IDS_plugin_multi_sim_confirm_open));
        } else if (fVar.b() == 2) {
            C2538c.c("MultiSimConfigActivity", new Object[]{"operation is processing and do nothing "});
        } else if (fVar.c() == 3) {
            m27272F();
        } else if (fVar.c() == 1) {
            this.f20488R = 0;
            m27275I();
        } else if (fVar.c() == 0) {
            m27304b(getString(i.IDS_plugin_multi_sim_open_result_query_fail), getString(i.IDS_plugin_multi_sim_open_result_query_fail_notic));
        } else if (fVar.c() == IOmaService.RETURN_APDU_EXCUTE_OPENCHANNEL_MISSRESOURCEEXCEPTION) {
            m27295a(getString(i.IDS_plugin_multi_sim_open_fail), getString(i.IDS_plugin_multi_sim_unsupport_sim_card));
        } else if (m27329f(fVar.c())) {
            m27295a(m27285a(this.f20488R), getString(i.IDS_plugin_multi_sim_server_error));
        } else {
            m27294a(getString(i.IDS_plugin_multi_sim_open_fail), fVar.c());
        }
    }

    private int m27282a(ArrayList<com.huawei.multisimsdk.multidevicemanager.common.g> arrayList) {
        if (arrayList == null) {
            C2538c.c("MultiSimConfigActivity", new Object[]{"getCurBindStatus  pairedDeviceList is null"});
            return 0;
        }
        String g = this.f20486P.mo4480g();
        C2538c.c("MultiSimConfigActivity", new Object[]{"getCurBindStatus imsi=", g, " pairedNum=", this.f20486P.mo4477d()});
        if (g.isEmpty()) {
            return 0;
        }
        int i;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            com.huawei.multisimsdk.multidevicemanager.common.g gVar = (com.huawei.multisimsdk.multidevicemanager.common.g) it.next();
            String a = gVar.a();
            String b = gVar.b();
            C2538c.c("MultiSimConfigActivity", new Object[]{"getCurBindStatus pairedImsi=", a});
            if (!a.equals(g)) {
                if (r5.equals(b)) {
                }
            }
            i = 1;
        }
        i = 0;
        if (i == 0 && arrayList.size() > 0) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                C2538c.c("MultiSimConfigActivity", new Object[]{"getCurBindStatus pairedImsi=", ((com.huawei.multisimsdk.multidevicemanager.common.g) it2.next()).a()});
                if (TextUtils.isEmpty(((com.huawei.multisimsdk.multidevicemanager.common.g) it2.next()).a())) {
                    i = 3;
                    break;
                }
            }
            i = 0;
        }
        return i;
    }

    private int m27296b(com.huawei.multisimsdk.multidevicemanager.common.f fVar) {
        e d = fVar.d();
        if (d == null) {
            return 2;
        }
        if (fVar.c() == 1502) {
            return 0;
        }
        if (fVar.c() == QueryRecordsListCallback.RESULT_FAILED_TRAFFIC_CARD_RECORDS_READ_FAILED) {
            return this.f20486P.mo4478e();
        }
        ArrayList a = d.a();
        com.huawei.multisimsdk.multidevicemanager.common.h b = d.b();
        if (b != null) {
            String a2 = b.a();
            C2538c.c("MultiSimConfigActivity", new Object[]{"refreshQeuryMultiSimRet ret  serviceInfo phoneNum = ", a2});
        } else {
            C2538c.e("MultiSimConfigActivity", new Object[]{"refreshQeuryMultiSimRet ret  PrimaryDevice is null"});
        }
        return m27282a(a);
    }

    private void m27309c(com.huawei.multisimsdk.multidevicemanager.common.f fVar) {
        C2538c.c("MultiSimConfigActivity", new Object[]{"refreshQeuryMultiSimRet"});
        m27277K();
        if (fVar == null) {
            C2538c.c("MultiSimConfigActivity", new Object[]{"refreshQeuryMultiSimRet ret  is null"});
            m27304b(null, getString(i.IDS_plugin_multi_sim_open_result_query_fail));
            return;
        }
        C2538c.c("MultiSimConfigActivity", new Object[]{"refreshQeuryMultiSimRet ret  action = ", Integer.valueOf(fVar.a())});
        C2538c.c("MultiSimConfigActivity", new Object[]{"refreshQeuryMultiSimRet ret  result = ", Integer.valueOf(fVar.b())});
        C2538c.c("MultiSimConfigActivity", new Object[]{"refreshQeuryMultiSimRet ret  reason = ", Integer.valueOf(fVar.c())});
        if (fVar.b() == 0 || fVar.c() == 1500 || fVar.c() == QueryRecordsListCallback.RESULT_FAILED_TRAFFIC_CARD_RECORDS_READ_FAILED || fVar.c() == 1502) {
            e d = fVar.d();
            int b = m27296b(fVar);
            this.f20486P.mo4471a(this.f20487Q, m27286a(d), b);
            if (this.f20488R == 4) {
                if (b == 3) {
                    m27314c(d.a());
                } else if (b == 1) {
                    m27271E();
                } else {
                    this.f20488R = 0;
                    m27278L();
                }
            } else if (b == 1) {
                m27271E();
            } else {
                m27272F();
            }
        } else if (fVar.b() == 2) {
            C2538c.c("MultiSimConfigActivity", new Object[]{"operation is processing and do nothing"});
        } else if (fVar.c() == 1) {
            m27320d(getString(i.IDS_plugin_multi_sim_verify_info_expired));
            this.f20488R = 1;
        } else if (fVar.c() == IOmaService.RETURN_APDU_EXCUTE_OPENCHANNEL_MISSRESOURCEEXCEPTION) {
            m27295a(m27285a(this.f20488R), getString(i.IDS_plugin_multi_sim_unsupport_sim_card));
        } else if (fVar.c() == 0) {
            m27304b(null, getString(i.IDS_plugin_multi_sim_open_result_query_fail));
        } else if (m27329f(fVar.c())) {
            m27295a(m27285a(this.f20488R), getString(i.IDS_plugin_multi_sim_server_error));
        } else {
            m27294a(m27285a(this.f20488R), fVar.c());
        }
    }

    private void m27318d(com.huawei.multisimsdk.multidevicemanager.common.f fVar) {
        C2538c.c("MultiSimConfigActivity", new Object[]{"refreshUnbindMultiSimRet"});
        m27277K();
        if (fVar == null) {
            C2538c.c("MultiSimConfigActivity", new Object[]{"refreshUnbindMultiSimRet ret  is null"});
            m27304b(getString(i.IDS_plugin_multi_sim_open_result_query_fail), getString(i.IDS_plugin_multi_sim_open_result_query_fail));
            return;
        }
        C2538c.c("MultiSimConfigActivity", new Object[]{"refreshUnbindMultiSimRet ret  action = ", Integer.valueOf(fVar.a())});
        C2538c.c("MultiSimConfigActivity", new Object[]{"refreshUnbindMultiSimRet ret  result = ", Integer.valueOf(fVar.b())});
        C2538c.c("MultiSimConfigActivity", new Object[]{"refreshUnbindMultiSimRet ret  reason = ", Integer.valueOf(fVar.c())});
        if (fVar.b() == 0 || fVar.c() == 2001 || fVar.c() == 1502) {
            m27325e(getString(i.IDS_plugin_multi_sim_confirm_unbind));
            this.f20486P.mo4471a(this.f20487Q, "", 0);
            this.f20487Q = "";
        } else if (fVar.b() == 2) {
            C2538c.c("MultiSimConfigActivity", new Object[]{"operation is processing and do nothing"});
        } else if (fVar.c() == 1 || fVar.c() == 1004) {
            m27275I();
            this.f20488R = 2;
        } else if (fVar.c() == 3) {
            m27271E();
        } else if (fVar.c() == 0) {
            m27304b(getString(i.IDS_plugin_multi_sim_unbind_result_query_fail), getString(i.IDS_plugin_multi_sim_open_result_query_fail));
        } else if (m27329f(fVar.c())) {
            m27295a(m27285a(this.f20488R), getString(i.IDS_plugin_multi_sim_server_error));
        } else {
            m27294a(m27285a(this.f20488R), fVar.c());
        }
    }

    private String m27285a(int i) {
        String str = "";
        if (i == 2) {
            return getString(i.IDS_plugin_multi_sim_unbind_fail);
        }
        if (i == 1) {
            return getString(i.IDS_plugin_multi_sim_query_fail);
        }
        if (i == 3) {
            return getString(i.IDS_plugin_multi_sim_verify_failed);
        }
        return getString(i.IDS_plugin_multi_sim_open_fail);
    }

    private void m27346o() {
        this.f20511o.setVisibility(8);
    }

    private void m27347p() {
        this.f20511o.setVisibility(0);
    }

    private void m27298b(int i) {
        C2538c.c("MultiSimConfigActivity", new Object[]{"refreshGetAuthCodeView"});
        C2538c.c("MultiSimConfigActivity", new Object[]{"refreshGetAuthCodeView ret=", Integer.valueOf(i)});
        m27277K();
        if (i == 1000) {
            this.f20491U.setEnabled(false);
            this.f20480J = true;
        } else if (i == 1001 || i == 1009) {
            m27293a(getResources().getString(i.IDS_plugin_multi_sim_unsupport_sim_card));
        } else if (i == 1008) {
            C2538c.c("MultiSimConfigActivity", new Object[]{"when timeout do nothing, user can click obtain to retry"});
        } else {
            m27294a(m27285a(3), i);
        }
    }

    private void m27308c(int i) {
        C2538c.c("MultiSimConfigActivity", new Object[]{"getAuthResult"});
        C2538c.c("MultiSimConfigActivity", new Object[]{"getAuthResult ret=", Integer.valueOf(i)});
        m27277K();
        if (i == 1000) {
            if (this.f20488R == 2) {
                m27330g();
                m27280N();
            } else if (this.f20488R == 1) {
                m27313c(getString(i.IDS_plugin_multi_sim_querying), null);
                m27279M();
            } else if (this.f20488R == 4) {
                m27330g();
                m27279M();
            } else {
                m27330g();
                m27278L();
            }
            m27274H();
        } else if (i == 1001 || i == 1009) {
            m27347p();
            m27274H();
            m27293a(getResources().getString(i.IDS_plugin_multi_sim_unsupport_sim_card));
        } else if (i == 1006) {
            m27347p();
            m27303b(getResources().getString(i.IDS_plugin_multi_sim_verify_code_error));
        } else if (i == 1007) {
            m27347p();
            m27274H();
            m27303b(getResources().getString(i.IDS_plugin_multi_sim_verify_code_expired));
        } else {
            m27294a(m27285a(3), i);
        }
    }

    private void m27348q() {
        this.ae--;
        if (this.ae == 0) {
            this.ae = 60;
            m27299b(this.f20475E);
            this.f20475E.setText(getResources().getString(i.IDS_plugin_multi_sim_obtain_verify_code));
            this.f20491U.setEnabled(true);
            return;
        }
        this.f20475E.setText(String.format(getResources().getString(i.IDS_plugin_multi_sim_obtain_verify_code_with_timer), new Object[]{Integer.toString(this.ae)}));
        this.f20490T.sendEmptyMessageDelayed(7, 1000);
    }

    private void m27317d(int i) {
        if (this.f20490T != null && this.f20490T.hasMessages(i)) {
            this.f20490T.removeMessages(i);
        }
    }

    private void m27349r() {
        this.f20499c.setVisibility(8);
        this.f20500d.setVisibility(8);
        this.f20501e.setVisibility(8);
        this.f20502f.setVisibility(8);
        this.f20503g.setVisibility(8);
        this.f20504h.setVisibility(8);
        this.f20508l.setVisibility(8);
        this.f20505i.setVisibility(8);
        this.f20506j.setVisibility(8);
        this.f20507k.setVisibility(8);
        m27332h();
    }

    private int m27350s() {
        return this.f20486P.mo4478e();
    }

    private String m27351t() {
        return this.f20486P.mo4476c();
    }

    private void m27352u() {
        int s = m27350s();
        if (s == 1) {
            this.f20487Q = this.f20486P.mo4479f();
            if (this.f20487Q.isEmpty() || !m27268B()) {
                m27272F();
            } else if (m27268B()) {
                m27313c(getString(i.IDS_plugin_multi_sim_querying), null);
                this.f20488R = 1;
                m27279M();
            }
        } else if (s == 2) {
            m27313c(getString(i.IDS_plugin_multi_sim_querying), null);
            this.f20486P.mo4467a(this.f20490T.obtainMessage(8));
            this.f20490T.sendEmptyMessageDelayed(8, 20000);
        } else {
            m27272F();
        }
    }

    private void m27353v() {
        this.f20516t.setVisibility(8);
        this.f20515s.setVisibility(8);
        this.f20517u.setVisibility(8);
        this.f20518v.setVisibility(8);
    }

    private void m27354w() {
        C2538c.c("setViewStatusBar status:", new Object[]{Integer.valueOf(this.f20489S)});
        switch (this.f20489S) {
            case 1:
                this.f20515s.setVisibility(0);
                return;
            case 2:
                this.f20517u.setVisibility(0);
                return;
            case 3:
                this.f20516t.setVisibility(0);
                return;
            case 4:
                ((TextView) findViewById(g.no_sim_err_txt)).setText(getString(i.IDS_plugin_multi_sim_error_dev_no_sim));
                this.f20515s.setVisibility(0);
                return;
            default:
                C2538c.c("setViewStatusBar ok", new Object[0]);
                return;
        }
    }

    private void m27355x() {
        if (this.f20489S == 0) {
            switch (this.aa) {
                case 0:
                    m27299b(this.f20520x);
                    return;
                case 1:
                    m27299b(this.f20471A);
                    return;
                case 4:
                    m27299b(this.f20522z);
                    return;
                case 9:
                    m27299b(this.f20521y);
                    return;
                default:
                    return;
            }
        }
        switch (this.aa) {
            case 0:
                m27287a(this.f20520x);
                return;
            case 1:
                m27287a(this.f20471A);
                return;
            case 4:
                m27287a(this.f20522z);
                return;
            case 9:
                m27287a(this.f20521y);
                return;
            default:
                return;
        }
    }

    private void m27356y() {
        m27353v();
        if (this.aa != 3 && this.aa != 2 && this.aa != 5 && this.aa != 8) {
            m27269C();
            m27354w();
            m27355x();
        }
    }

    private boolean m27357z() {
        int i;
        if (this.f20486P == null) {
            C2538c.e("MultiSimConfigActivity", new Object[]{"null == pluginSimAdapter"});
            i = 3;
        } else {
            i = this.f20486P.mo4474b();
        }
        if (i == 2) {
            return true;
        }
        return false;
    }

    private boolean m27267A() {
        C2538c.c("getDeviceSimStatus ", new Object[0]);
        return this.f20486P.mo4473a(this.f20486P.mo4481h());
    }

    private boolean m27268B() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f20497a.getSystemService("connectivity");
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
        if (networkInfo.isConnected() || networkInfo2.isConnected()) {
            return true;
        }
        return false;
    }

    private void m27269C() {
        if (!m27268B()) {
            this.f20489S = 3;
        } else if (!m27267A()) {
            this.f20489S = 4;
        } else if (m27357z()) {
            this.f20489S = 0;
        } else {
            this.f20489S = 2;
        }
    }

    private void m27287a(Button button) {
        if (button != null) {
            button.setEnabled(false);
            button.setClickable(false);
            button.setFocusable(false);
            button.setBackgroundResource(com.huawei.sim.f.sim_btn_one_disable);
            button.setTextColor(getResources().getColor(com.huawei.sim.e.IDS_plugin_sim_ext_back_color_20alpha));
        }
    }

    private void m27299b(Button button) {
        if (button != null) {
            button.setEnabled(true);
            button.setClickable(true);
            button.setFocusable(true);
            button.setBackgroundResource(com.huawei.sim.f.sim_btn_one);
            button.setTextColor(getResources().getColor(com.huawei.sim.e.IDS_plugin_sim_next_back_color));
        }
    }

    private String m27270D() {
        if (TextUtils.isEmpty(this.f20487Q)) {
            this.f20487Q = "";
        }
        return this.f20487Q;
    }

    private void m27271E() {
        C2538c.c("MultiSimConfigActivity", new Object[]{"initMultiSimUnbindView"});
        this.aa = 1;
        m27349r();
        this.f20502f.setVisibility(0);
        m27356y();
        String D = m27270D();
        ((TextView) findViewById(g.multi_sim_unbind_notice)).setText(String.format(getResources().getString(i.IDS_plugin_multi_sim_unbind_info), new Object[]{D}));
    }

    private void m27272F() {
        C2538c.c("MultiSimConfigActivity", new Object[]{"initMultiSimStartView"});
        this.aa = 9;
        m27349r();
        this.f20507k.setVisibility(0);
        m27356y();
        TextView textView = (TextView) findViewById(g.multi_sim_start_tip_tip2);
        ((TextView) findViewById(g.multi_sim_start_tip_tip1)).setText(String.format(getResources().getString(i.IDS_plugin_multi_device_note_no1), new Object[]{com.huawei.hwbasemgr.c.a(WeightedLatLng.DEFAULT_INTENSITY, 1, 0)}));
        String string = this.f20497a.getString(i.IDS_plugin_multi_device_touch_query);
        int[] iArr = new int[]{this.f20497a.getString(i.IDS_plugin_multi_device_note_no2, new Object[]{com.huawei.hwbasemgr.c.a(2.0d, 1, 0), string}).indexOf(string)};
        CharSequence spannableString = new SpannableString(r2);
        spannableString.setSpan(new C5959j(this), iArr[0], string.length() + iArr[0], 33);
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void m27312c(String str) {
        C2538c.c("MultiSimConfigActivity", new Object[]{"initMultiSimOpenSingleView"});
        this.aa = 0;
        m27349r();
        this.f20499c.setVisibility(0);
        m27356y();
        TextView textView = (TextView) findViewById(g.multi_sim_auth_notice);
        TextView textView2 = (TextView) findViewById(g.multi_sim_auth_tip);
        if (str == null || str.isEmpty()) {
            textView.setText(getString(i.IDS_plugin_multi_sim_query_not_bind));
        } else {
            textView.setText(str);
        }
        textView2.setVisibility(0);
        textView2.setText(getString(i.IDS_plugin_multi_sim_click_setup_now) + getString(i.IDS_plugin_multi_sim_config_tip));
    }

    private void m27295a(String str, String str2) {
        C2538c.c("MultiSimConfigActivity", new Object[]{"initMultiSimOperationFailView"});
        this.aa = 3;
        m27349r();
        m27356y();
        this.f20500d.setVisibility(0);
        TextView textView = (TextView) findViewById(g.multi_sim_open_error_notice);
        TextView textView2 = (TextView) findViewById(g.multi_sim_open_error_tip);
        if (!(str == null || str.isEmpty())) {
            textView.setText(str);
            textView.setVisibility(0);
        }
        if (str2 != null && !str2.isEmpty()) {
            textView2.setText(str2);
            textView2.setVisibility(0);
        }
    }

    private void m27273G() {
        C2538c.c("MultiSimConfigActivity", new Object[]{"openMultiSimErrerDetailActivity"});
        if (this.f20497a != null) {
            Intent intent = new Intent(this.f20497a, WebViewActivity.class);
            C2538c.b("MultiSimConfigActivity", new Object[]{"openAppHelpActivity url = " + this.f20481K});
            intent.putExtra("WebViewActivity.REQUEST_URL_KEY", this.f20481K);
            intent.putExtra("WebViewActivity.JUMP_MODE_KEY", 0);
            this.f20497a.startActivity(intent);
        }
    }

    private void m27294a(String str, int i) {
        C2538c.c("MultiSimConfigActivity", new Object[]{"initMultiSimOperationFailView errCode", Integer.valueOf(i)});
        this.aa = 3;
        m27349r();
        m27356y();
        this.f20500d.setVisibility(0);
        TextView textView = (TextView) findViewById(g.multi_sim_open_error_tip);
        TextView textView2 = (TextView) findViewById(g.multi_sim_open_error_notice);
        if (!(str == null || str.isEmpty())) {
            textView2.setText(str);
            textView2.setVisibility(0);
        }
        String string = this.f20497a.getString(i.IDS_plugin_multi_sim_open_fail_general_blue_link);
        int[] iArr = new int[]{this.f20497a.getString(i.IDS_plugin_multi_sim_open_fail_general_info, new Object[]{Integer.valueOf(i), string}).indexOf(string)};
        CharSequence spannableString = new SpannableString(r2);
        spannableString.setSpan(new C5960k(this), iArr[0], string.length() + iArr[0], 33);
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setVisibility(0);
    }

    private void m27304b(String str, String str2) {
        C2538c.c("MultiSimConfigActivity", new Object[]{"initMultiSimOpenQeuryFailView"});
        this.aa = 4;
        m27349r();
        m27356y();
        this.f20501e.setVisibility(0);
        TextView textView = (TextView) findViewById(g.multi_sim_query_error_notice);
        TextView textView2 = (TextView) findViewById(g.multi_sim_query_error_tip);
        if (!(str == null || str.isEmpty())) {
            textView.setVisibility(0);
            textView.setText(str);
        }
        if (!(str2 == null || str2.isEmpty())) {
            textView2.setVisibility(0);
            textView2.setText(str2);
        }
        m27356y();
    }

    private void m27313c(String str, String str2) {
        C2538c.c("MultiSimConfigActivity", new Object[]{"initMultiSimWaitingView"});
        this.aa = 2;
        m27349r();
        m27356y();
        this.f20503g.setVisibility(0);
        TextView textView = (TextView) findViewById(g.multi_sim_waiting_info_tip);
        ((TextView) findViewById(g.multi_sim_waiting_info)).setText(str);
        if (!(str2 == null || str2.isEmpty())) {
            textView.setVisibility(0);
            textView.setText(str2);
        }
        ((AnimationDrawable) ((ImageView) findViewById(g.multi_sim_waiting_image)).getDrawable()).start();
    }

    private void m27305b(ArrayList<com.huawei.multisimsdk.multidevicemanager.common.g> arrayList) {
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2;
            if (TextUtils.isEmpty(((com.huawei.multisimsdk.multidevicemanager.common.g) it.next()).a())) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        this.f20482L = new String[i];
        this.f20483M = new boolean[this.f20482L.length];
        it = arrayList.iterator();
        i = 0;
        while (it.hasNext()) {
            com.huawei.multisimsdk.multidevicemanager.common.g gVar = (com.huawei.multisimsdk.multidevicemanager.common.g) it.next();
            if (TextUtils.isEmpty(gVar.a())) {
                this.f20482L[i] = gVar.b();
                this.f20483M[i] = false;
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
    }

    private void m27314c(ArrayList<com.huawei.multisimsdk.multidevicemanager.common.g> arrayList) {
        this.aa = 8;
        m27349r();
        m27356y();
        this.f20506j.setVisibility(0);
        m27305b((ArrayList) arrayList);
        this.ag = new C5966q();
        this.f20496Z.setAdapter(new C5962m(this.f20497a, this.f20482L, this.f20483M, this.ag));
        this.f20496Z.setOnItemClickListener(this.ag);
    }

    private void m27274H() {
        if (this.f20490T.hasMessages(7)) {
            this.f20490T.removeMessages(7);
        }
        this.f20475E.setText(getResources().getString(i.IDS_plugin_multi_sim_obtain_verify_code));
        m27299b(this.f20475E);
        this.ae = 60;
        this.f20491U.setEnabled(true);
    }

    private void m27275I() {
        C2538c.c("MultiSimConfigActivity", new Object[]{"initMultiSimSMSAuthView"});
        this.aa = 6;
        m27349r();
        m27356y();
        this.f20508l.setVisibility(0);
        m27274H();
        this.f20491U.setText("");
        this.f20492V.setText("");
        m27346o();
        m27336j();
        m27341l();
        this.f20491U.addTextChangedListener(this.f20484N);
        this.f20492V.addTextChangedListener(this.f20485O);
    }

    private void m27320d(String str) {
        this.aa = 7;
        m27349r();
        m27356y();
        this.f20505i.setVisibility(0);
        TextView textView = (TextView) findViewById(g.multi_sim_config_sms_reauth_error_notice);
        if (str != null && !str.isEmpty()) {
            textView.setText(str);
        }
    }

    private void m27325e(String str) {
        C2538c.c("MultiSimConfigActivity", new Object[]{"initMultiSimConfirmView title=", str, " operationType =", Integer.valueOf(this.f20488R)});
        this.aa = 5;
        m27349r();
        m27356y();
        this.f20504h.setVisibility(0);
        ((TextView) findViewById(g.multi_sim_confirm_notice)).setText(str);
        if (this.f20488R == 0) {
            this.f20473C.setVisibility(0);
            this.f20474D.setVisibility(8);
            return;
        }
        this.f20473C.setVisibility(8);
        this.f20474D.setVisibility(0);
    }

    private void m27276J() {
        if (this.f20490T.hasMessages(10)) {
            this.f20490T.removeMessages(10);
        }
        if (this.f20490T.hasMessages(9)) {
            this.f20490T.removeMessages(9);
        }
    }

    private void m27277K() {
        C2538c.c("MultiSimConfigActivity", new Object[]{"rmNotifyMsg"});
        m27276J();
    }

    private void m27328f(String str) {
        C2538c.c("MultiSimConfigActivity", new Object[]{"getSmsAuthCode"});
        this.f20490T.sendEmptyMessageDelayed(10, 40000);
        this.f20498b.a(str, this.f20490T.obtainMessage(5));
    }

    private void m27321d(String str, String str2) {
        C2538c.c("MultiSimConfigActivity", new Object[]{"startSmsAuth phoneNum", str, " code", str2});
        this.f20490T.sendEmptyMessageDelayed(10, 40000);
        this.f20498b.a(str, str2, "", this.f20490T.obtainMessage(6));
    }

    private C5967r m27322e(int i) {
        C5967r c5967r = new C5967r();
        if (i == 1) {
            c5967r.m27364a(1);
            c5967r.m27367b(this.f20486P.mo4477d());
        } else {
            c5967r.m27364a(0);
            c5967r.m27365a(this.f20486P.mo4480g());
        }
        c5967r.m27369c(m27351t());
        return c5967r;
    }

    private void m27278L() {
        C2538c.c("MultiSimConfigActivity", new Object[]{"openMultiSim"});
        b c5968s = new C5968s();
        c5968s.m27375a(this.f20487Q);
        this.f20490T.sendEmptyMessageDelayed(9, (long) m27281O());
        m27330g();
        this.f20498b.a(c5968s, m27322e(0), this.f20490T.obtainMessage(2), this.f20490T.obtainMessage(11));
    }

    private void m27279M() {
        C2538c.c("MultiSimConfigActivity", new Object[]{"queryMultiSimStatus", this.f20487Q});
        if (TextUtils.isEmpty(m27270D())) {
            m27275I();
            this.f20488R = 1;
            return;
        }
        b c5968s = new C5968s();
        c5968s.m27375a(m27270D());
        this.f20490T.sendEmptyMessageDelayed(9, (long) m27281O());
        this.f20498b.a(c5968s, m27322e(0), this.f20490T.obtainMessage(3));
    }

    private void m27280N() {
        C2538c.c("MultiSimConfigActivity", new Object[]{"unbindMultiSim"});
        b c5968s = new C5968s();
        c5968s.m27375a(this.f20487Q);
        m27330g();
        this.f20490T.sendEmptyMessageDelayed(9, (long) m27281O());
        this.f20498b.b(c5968s, m27322e(1), this.f20490T.obtainMessage(4), this.f20490T.obtainMessage(12));
    }

    private boolean m27329f(int i) {
        if (i == 99) {
            return true;
        }
        if (i < 300 || i > 599) {
            return false;
        }
        return true;
    }

    private int m27281O() {
        C2538c.c("MultiSimConfigActivity", new Object[]{"getOperationTimeout ", Integer.valueOf(this.f20498b.a(this.f20497a, -1))});
        return this.f20498b.a(this.f20497a, -1);
    }
}
