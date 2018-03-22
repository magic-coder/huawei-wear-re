package com.huawei.pluginkidwatch.home;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.volley.DefaultRetryPolicy;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.b.a;
import com.huawei.l.a.c;
import com.huawei.nfc.carrera.ui.NFCBaseActivity;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1413d;
import com.huawei.pluginkidwatch.common.entity.C1417a;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.lib.p148c.C1467b;
import com.huawei.pluginkidwatch.common.lib.utils.C1490j;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.ui.view.C1595v;
import com.huawei.pluginkidwatch.common.ui.view.CustomDialog;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.home.p156b.C1638r;
import com.huawei.pluginkidwatch.home.p156b.C1642v;
import com.huawei.pluginkidwatch.plugin.feature.track.activity.TrackActivity;
import com.huawei.pluginkidwatch.plugin.menu.activity.AlarmActivity;
import com.huawei.pluginkidwatch.plugin.menu.activity.ContactsListActivity;
import com.huawei.pluginkidwatch.plugin.menu.activity.ElectronicFenceActivity;
import com.huawei.pluginkidwatch.plugin.menu.activity.GeneralSettingsActivity;
import com.huawei.pluginkidwatch.plugin.menu.activity.NotificationHistoryActivity;
import com.huawei.pluginkidwatch.plugin.menu.activity.PeroidActivity;
import com.huawei.pluginkidwatch.plugin.menu.activity.ProjectModeActivity;
import com.huawei.pluginkidwatch.plugin.menu.activity.SettingLocationActivity;
import com.huawei.pluginkidwatch.plugin.p152a.C1647c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: MenuFragment */
public class bo extends Fragment implements OnClickListener {
    private LinearLayout f4281A;
    private TextView f4282B;
    private LinearLayout f4283C;
    private LinearLayout f4284D;
    private LinearLayout f4285E;
    private LinearLayout f4286F;
    private LinearLayout f4287G;
    private LinearLayout f4288H;
    private Context f4289I;
    private CustomDialog f4290J = null;
    private C1413d f4291K = null;
    private LinearLayout f4292L;
    private boolean f4293M = false;
    private C1647c f4294N = new bq(this);
    public TextView f4295a;
    public TextView f4296b;
    public TextView f4297c;
    public TextView f4298d;
    public LinearLayout f4299e;
    public TextView f4300f;
    public Handler f4301g = new Handler();
    public TextView f4302h;
    public ImageView f4303i;
    boolean f4304j = false;
    Runnable f4305k = new bp(this);
    private TextView f4306l;
    private TextView f4307m;
    private TextView f4308n;
    private TextView f4309o;
    private TextView f4310p;
    private TextView f4311q;
    private ImageView f4312r;
    private TextView f4313s;
    private TextView f4314t;
    private ImageView f4315u;
    private View f4316v;
    private LinearLayout f4317w;
    private LinearLayout f4318x;
    private TextView f4319y;
    private LinearLayout f4320z;

    public void m7809a(boolean z) {
        float f = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        this.f4311q.setAlpha(z ? DefaultRetryPolicy.DEFAULT_BACKOFF_MULT : NFCBaseActivity.PERCENT_MARGIN_30);
        ImageView imageView = this.f4312r;
        if (!z) {
            f = NFCBaseActivity.PERCENT_MARGIN_30;
        }
        imageView.setAlpha(f);
        this.f4285E.setEnabled(z);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C2538c.m12674b("KIDWATCH_MenuFragment", "==========Enter onCreateView()");
        View inflate = layoutInflater.inflate(h.activity_menu, viewGroup, false);
        m7790a(inflate);
        return inflate;
    }

    private void m7790a(View view) {
        C2538c.m12674b("KIDWATCH_MenuFragment", "==========Enter init()");
        this.f4289I = getActivity();
        if (this.f4289I == null) {
            C2538c.m12674b("KIDWATCH_MenuFragment", "========== init() mContext is null return !");
            return;
        }
        this.f4291K = C1417a.m6594a(this.f4289I.getApplicationContext());
        this.f4293M = false;
        m7799c(view);
        m7796b(view);
        m7794b();
        m7805f();
        if (C1462f.m6748k() != null && C1642v.m7777a(this.f4289I)) {
            m7789a(this.f4291K.mo2466a(C1462f.m6748k().f3096p));
            this.f4291K.mo2507a(C1462f.m6748k().f3096p, this.f4294N);
        }
        m7808a();
        C1497q.m6942a(this.f4289I, "enterMenuActivity", Boolean.valueOf(true));
    }

    private void m7794b() {
        this.f4317w.setOnClickListener(this);
        this.f4320z.setOnClickListener(this);
        this.f4281A.setOnClickListener(this);
        this.f4299e.setOnClickListener(this);
        this.f4283C.setOnClickListener(this);
        this.f4284D.setOnClickListener(this);
        this.f4285E.setOnClickListener(this);
        this.f4286F.setOnClickListener(this);
        this.f4287G.setOnClickListener(this);
        this.f4288H.setOnClickListener(this);
        this.f4316v.setOnClickListener(this);
        this.f4292L.setOnClickListener(this);
        this.f4318x.setOnClickListener(this);
    }

    private void m7796b(View view) {
        this.f4313s = (TextView) view.findViewById(g.menu_tv_reset_factory);
        this.f4314t = (TextView) view.findViewById(g.menu_tv_project_mode);
        this.f4317w = (LinearLayout) view.findViewById(g.menu_llyt_contact_management);
        this.f4320z = (LinearLayout) view.findViewById(g.menu_llyt_notification_history);
        this.f4281A = (LinearLayout) view.findViewById(g.menu_llyt_fence);
        this.f4299e = (LinearLayout) view.findViewById(g.menu_llyt_track);
        this.f4283C = (LinearLayout) view.findViewById(g.menu_llyt_peroid);
        this.f4284D = (LinearLayout) view.findViewById(g.menu_llyt_alarm);
        this.f4285E = (LinearLayout) view.findViewById(g.menu_llyt_shut_down);
        this.f4286F = (LinearLayout) view.findViewById(g.menu_llyt_update);
        this.f4287G = (LinearLayout) view.findViewById(g.menu_llyt_reset_factory);
        this.f4288H = (LinearLayout) view.findViewById(g.menu_llyt_project_mode);
        this.f4282B = (TextView) view.findViewById(g.menu_tv_fence_tip);
    }

    private void m7799c(View view) {
        this.f4316v = view.findViewById(g.menu_view);
        this.f4292L = (LinearLayout) view.findViewById(g.menu_lly_title);
        this.f4318x = (LinearLayout) view.findViewById(g.menu_llyt_location);
        this.f4319y = (TextView) view.findViewById(g.menu_tv_location);
        this.f4306l = (TextView) view.findViewById(g.menu_tv_contact_management);
        this.f4307m = (TextView) view.findViewById(g.menu_tv_notification_history);
        this.f4308n = (TextView) view.findViewById(g.menu_tv_fence);
        this.f4309o = (TextView) view.findViewById(g.menu_tv_peroid);
        this.f4310p = (TextView) view.findViewById(g.menu_tv_alarm);
        this.f4311q = (TextView) view.findViewById(g.menu_tv_shut_down);
        this.f4312r = (ImageView) view.findViewById(g.menu_tv_shut_down_pic);
        this.f4295a = (TextView) view.findViewById(g.menu_tv_update);
        this.f4297c = (TextView) view.findViewById(g.menu_tv_update_status);
        this.f4298d = (TextView) view.findViewById(g.menu_tv_update_status_version);
        this.f4297c.setVisibility(8);
        this.f4298d.setVisibility(8);
        this.f4296b = (TextView) view.findViewById(g.menu_tv_update_new);
        this.f4315u = (ImageView) view.findViewById(g.menu_img_bluetooth);
        this.f4302h = (TextView) view.findViewById(g.menu_kid_name);
        this.f4303i = (ImageView) view.findViewById(g.menu_img_bluetooth);
        this.f4300f = (TextView) view.findViewById(g.menu_tv_track);
    }

    public void m7808a() {
        C2538c.m12674b("KIDWATCH_MenuFragment", "==========Enter processLayoutClickable()");
        C2538c.m12674b("KIDWATCH_MenuFragment", "==========processLayoutClickable getDeviceCode：", C1462f.m6746j() + "");
        if (C1490j.m6890a("LCS_UserDefined_Setting")) {
            this.f4318x.setVisibility(0);
        } else {
            this.f4318x.setVisibility(8);
        }
        m7798c();
        if ("".equals(C1462f.m6746j())) {
            C2538c.m12674b("KIDWATCH_MenuFragment", "==========devicecode is null");
            m7803e();
            return;
        }
        C2538c.m12674b("KIDWATCH_MenuFragment", "==========devicecode is effetctive");
        m7800d();
    }

    private void m7798c() {
        if (C1490j.m6890a("LCS_PowerSaveMode") && C1462f.m6760t() == 0) {
            this.f4281A.setEnabled(false);
            this.f4281A.setClickable(false);
            this.f4281A.setAlpha(NFCBaseActivity.PERCENT_MARGIN_30);
            this.f4282B.setVisibility(0);
            return;
        }
        this.f4281A.setEnabled(true);
        this.f4281A.setClickable(true);
        this.f4281A.setAlpha(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        this.f4282B.setVisibility(8);
    }

    private void m7800d() {
        this.f4306l.setEnabled(true);
        this.f4307m.setEnabled(true);
        this.f4308n.setEnabled(true);
        this.f4309o.setEnabled(true);
        this.f4310p.setEnabled(true);
        this.f4311q.setEnabled(true);
        this.f4295a.setEnabled(true);
        this.f4313s.setEnabled(true);
        this.f4314t.setEnabled(true);
        this.f4300f.setEnabled(true);
        this.f4317w.setEnabled(true);
        this.f4320z.setEnabled(true);
        this.f4281A.setEnabled(true);
        this.f4283C.setEnabled(true);
        this.f4284D.setEnabled(true);
        this.f4318x.setEnabled(true);
        this.f4319y.setEnabled(true);
        if (!this.f4304j) {
            this.f4285E.setEnabled(true);
        }
        this.f4286F.setEnabled(true);
        this.f4287G.setEnabled(true);
        this.f4288H.setEnabled(true);
        this.f4299e.setEnabled(true);
    }

    private void m7803e() {
        this.f4306l.setEnabled(false);
        this.f4307m.setEnabled(false);
        this.f4308n.setEnabled(false);
        this.f4309o.setEnabled(false);
        this.f4310p.setEnabled(false);
        this.f4311q.setEnabled(false);
        this.f4295a.setEnabled(false);
        this.f4313s.setEnabled(false);
        this.f4314t.setEnabled(false);
        this.f4300f.setEnabled(false);
        this.f4317w.setEnabled(false);
        this.f4320z.setEnabled(false);
        this.f4281A.setEnabled(false);
        this.f4283C.setEnabled(false);
        this.f4284D.setEnabled(false);
        this.f4285E.setEnabled(false);
        this.f4286F.setEnabled(false);
        this.f4287G.setEnabled(false);
        this.f4288H.setEnabled(false);
        this.f4318x.setEnabled(false);
        this.f4299e.setEnabled(false);
        this.f4319y.setEnabled(false);
        this.f4296b.setVisibility(8);
        this.f4297c.setVisibility(8);
        this.f4298d.setVisibility(8);
        C1638r.m7763c();
    }

    private void m7805f() {
        C2538c.m12674b("KIDWATCH_MenuFragment", "==============refreshFragmentInitDataUI()");
        C2538c.m12677c("KIDWATCH_MenuFragment", "===www=======current device refreshFragmentInitDataUI" + C1467b.m6789d(this.f4289I));
        if (7 == C1467b.m6789d(this.f4289I)) {
            C2538c.m12677c("KIDWATCH_MenuFragment", "===www=======current device refreshFragmentInitDataUI  K2");
            C1467b.m6784a(this.f4289I, 7);
            this.f4302h.setText(C1680l.IDS_plugin_kidwatch_common_kids_watch_name_k2);
            this.f4303i.setVisibility(4);
            this.f4299e.setVisibility(0);
            return;
        }
        C2538c.m12677c("KIDWATCH_MenuFragment", "===www=======current refreshFragmentInitDataUI K1");
        this.f4302h.setText(C1680l.IDS_plugin_kidwatch_common_kids_watch_name_k1);
        this.f4303i.setVisibility(0);
        this.f4299e.setVisibility(8);
    }

    private void m7789a(int i) {
        if (2 == i) {
            C2538c.m12674b("KIDWATCH_MenuFragment", "==ww== onDataReceived connected");
            m7795b(C1617f.mid_popup_list_ic_bluetooth_1);
            return;
        }
        C2538c.m12674b("KIDWATCH_MenuFragment", "==ww== onDataReceived disconnected");
        m7795b(C1617f.mid_popup_list_ic_bluetooth_2);
    }

    private void m7795b(int i) {
        this.f4301g.post(new br(this, i));
    }

    public void onClick(View view) {
        if (g.menu_llyt_contact_management == view.getId()) {
            C2538c.m12674b("KIDWATCH_MenuFragment", "==========进入联系人列表");
            startActivity(new Intent(this.f4289I, ContactsListActivity.class));
        } else if (g.menu_llyt_notification_history == view.getId()) {
            C2538c.m12674b("KIDWATCH_MenuFragment", "==========进入历史通知");
            r0 = new Intent();
            r0.setClass(this.f4289I, NotificationHistoryActivity.class);
            startActivity(r0);
        } else if (g.menu_llyt_fence == view.getId()) {
            C2538c.m12674b("KIDWATCH_MenuFragment", "==========进入电子围栏");
            r0 = new Intent();
            r0.setClass(this.f4289I, ElectronicFenceActivity.class);
            startActivity(r0);
        } else if (g.menu_llyt_project_mode == view.getId()) {
            r0 = new Intent();
            r0.setClass(this.f4289I, ProjectModeActivity.class);
            startActivity(r0);
        } else if (g.menu_llyt_track == view.getId()) {
            Map hashMap = new HashMap();
            hashMap.put("click", "1");
            c.a().a(BaseApplication.m2632b(), a.V.a(), hashMap, 0);
            startActivity(new Intent(this.f4289I, TrackActivity.class));
        } else {
            m7801d(view);
        }
    }

    private void m7801d(View view) {
        Intent intent;
        if (g.menu_llyt_peroid == view.getId()) {
            C2538c.m12674b("KIDWATCH_MenuFragment", "==========进入静音时段");
            intent = new Intent();
            intent.setClass(this.f4289I, PeroidActivity.class);
            startActivity(intent);
        } else if (g.menu_llyt_location == view.getId()) {
            C2538c.m12674b("KIDWATCH_MenuFragment", "==========进入定位频率设置");
            intent = new Intent();
            intent.setClass(this.f4289I, SettingLocationActivity.class);
            startActivity(intent);
        } else if (g.menu_llyt_alarm == view.getId()) {
            C2538c.m12674b("KIDWATCH_MenuFragment", "========跳转到闹钟界面");
            intent = new Intent();
            intent.setClass(this.f4289I, AlarmActivity.class);
            startActivity(intent);
        } else if (g.menu_llyt_reset_factory == view.getId()) {
            C2538c.m12674b("KIDWATCH_MenuFragment", "========跳转到通用设置界面");
            intent = new Intent();
            intent.setClass(this.f4289I, GeneralSettingsActivity.class);
            startActivity(intent);
            C2538c.m12674b("KIDWATCH_MenuFragment", "============Enter relativeShakeClickListener");
        } else {
            m7804e(view);
        }
    }

    private void m7804e(View view) {
        if (g.menu_llyt_shut_down == view.getId()) {
            m7806g();
        } else if (g.menu_llyt_update == view.getId()) {
            C2538c.m12674b("KIDWATCH_MenuFragment", "============Enter Update OnClick");
            if (isAdded()) {
                C1638r.m7758a(getActivity(), false);
            }
        }
    }

    private void m7806g() {
        Boolean b = C1497q.m6944b(this.f4289I, "Has_been_initiated_shutdown");
        if (!this.f4293M || !b.booleanValue()) {
            if (this.f4290J == null) {
                C1595v c1595v = new C1595v(this.f4289I);
                c1595v.m7339a(C1680l.IDS_plugin_kidwatch_menu_shutdown);
                c1595v.m7348b(C1680l.IDS_plugin_kidwatch_menu_shutdown_warnning);
                c1595v.m7349b(C1680l.IDS_plugin_kidwatch_common_cancel, new bs(this));
                c1595v.m7340a(C1680l.IDS_plugin_kidwatch_common_ok, new bt(this));
                this.f4290J = c1595v.m7338a();
            }
            this.f4290J.show();
        }
    }

    private void m7807h() {
        C2538c.m12674b("KIDWATCH_MenuFragment", "===============Enter remoteShutDownOption");
        if (isAdded()) {
            this.f4293M = true;
            this.f4301g.post(this.f4305k);
            C1642v.m7778b(this.f4289I, this.f4291K);
        }
    }

    public void onDestroy() {
        C2538c.m12674b("KIDWATCH_MenuFragment", "========onDestroy");
        C1638r.m7756a();
        this.f4301g.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

    public void onResume() {
        C2538c.m12674b("KIDWATCH_MenuFragment", " ===============onResume");
        super.onResume();
        m7808a();
    }

    public void onStop() {
        C2538c.m12674b("KIDWATCH_MenuFragment", " ===============onStop");
        super.onStop();
    }

    public void onDestroyView() {
        C2538c.m12674b("KIDWATCH_MenuFragment", " ===============onDestroyView");
        super.onDestroyView();
    }
}
