package com.huawei.ui.homewear21.card.p176a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwcommonmodel.p063b.C0976c;
import com.huawei.p108n.C1204c;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.homewear21.c;
import com.huawei.ui.homewear21.e;
import com.huawei.ui.homewear21.f;
import com.huawei.ui.homewear21.h;
import com.huawei.ui.homewear21.i;

/* compiled from: HeartRateStatusInteractors */
public class C2247e {
    private static int f8170d = -4;
    private static int f8171e = 12;
    Handler f8172a = new C2249g(this);
    Runnable f8173b = new C2250h(this);
    Runnable f8174c = new C2251i(this);
    private int f8175f = 0;
    private final View f8176g;
    private Context f8177h;
    private ImageView f8178i;
    private TextView f8179j;
    private TextView f8180k;
    private AnimationDrawable f8181l;
    private View f8182m;
    private final BroadcastReceiver f8183n = new C2252j(this);
    private BroadcastReceiver f8184o = new C2253k(this);

    public C2247e(Context context, View view) {
        this.f8177h = context;
        this.f8176g = view;
        this.f8181l = (AnimationDrawable) this.f8177h.getResources().getDrawable(e.heart_rate_measuring);
        m11639m();
        m11629f();
        m11627e();
    }

    private void m11627e() {
        this.f8182m.setOnClickListener(new C2248f(this));
    }

    private void m11629f() {
        this.f8182m = d.a(this.f8176g, f.card_heart_rate_view);
        this.f8178i = (ImageView) d.a(this.f8176g, f.heart_rate_measuring_status_img);
        this.f8179j = (TextView) d.a(this.f8176g, f.heart_rate_measuring_status_tv);
        this.f8180k = (TextView) d.a(this.f8176g, f.heart_rate_measuring_unit_tv);
        this.f8180k.setVisibility(8);
    }

    private void m11631g() {
        this.f8175f = 0;
        this.f8172a.removeCallbacks(this.f8173b);
        this.f8182m.setEnabled(false);
        this.f8178i.setImageResource(h.heart_rate_measuring_connected);
        this.f8178i.setImageDrawable(this.f8181l);
        this.f8181l.start();
        this.f8180k.setVisibility(8);
        this.f8179j.setTextColor(this.f8177h.getResources().getColor(c.common_white_90alpha));
        this.f8179j.setTextSize(17.0f);
        this.f8179j.setText(this.f8177h.getResources().getString(i.IDS_heart_rate_measuring_status_start));
    }

    private void m11634h() {
        f8170d = -2;
        this.f8175f = 0;
        this.f8172a.postDelayed(this.f8173b, 8000);
        this.f8172a.removeCallbacks(this.f8174c);
        this.f8182m.setEnabled(false);
        if (!this.f8181l.isRunning()) {
            this.f8178i.setImageDrawable(this.f8181l);
            this.f8181l.start();
        }
        this.f8180k.setVisibility(8);
        this.f8179j.setTextColor(this.f8177h.getResources().getColor(c.common_white_90alpha));
        this.f8179j.setTextSize(17.0f);
        this.f8179j.setText(this.f8177h.getResources().getString(i.IDS_heart_rate_measuring_status_measuring));
    }

    private void m11635i() {
        this.f8182m.setEnabled(true);
        f8171e = 12;
        if (f8170d == -5) {
            f8170d = -6;
            return;
        }
        f8170d = -6;
        this.f8180k.setVisibility(8);
        this.f8181l.stop();
        this.f8178i.setImageResource(h.heart_rate_measuring_connected);
        this.f8179j.setTextColor(this.f8177h.getResources().getColor(c.common_white_90alpha));
        this.f8179j.setTextSize(17.0f);
        this.f8179j.setText(this.f8177h.getResources().getString(i.IDS_heart_rate_measuring_status_data_fail));
    }

    private void m11622b(int i) {
        this.f8182m.setEnabled(false);
        if (!this.f8181l.isRunning()) {
            this.f8178i.setImageDrawable(this.f8181l);
            this.f8181l.start();
        }
        this.f8179j.setTextColor(this.f8177h.getResources().getColor(c.common_white_90alpha));
        this.f8179j.setTextSize(24.0f);
        if (i == 0) {
            this.f8179j.setText("--");
        } else {
            this.f8179j.setText(String.valueOf(i));
        }
        this.f8180k.setVisibility(0);
    }

    private void m11636j() {
        this.f8175f = 0;
        f8171e = 12;
        this.f8172a.removeCallbacks(this.f8173b);
        this.f8182m.setEnabled(false);
        this.f8180k.setVisibility(8);
        this.f8181l.stop();
        this.f8178i.setImageResource(h.heart_rate_measuring_disconnected);
        this.f8179j.setTextColor(this.f8177h.getResources().getColor(c.common_white_30alpha));
        this.f8179j.setTextSize(17.0f);
        this.f8179j.setText(this.f8177h.getResources().getString(i.IDS_hw_health_show_healthdata_heart_bmp));
    }

    private void m11637k() {
        this.f8175f = 0;
        f8171e = 12;
        this.f8172a.removeCallbacks(this.f8173b);
        this.f8182m.setEnabled(false);
        this.f8180k.setVisibility(8);
        this.f8181l.stop();
        this.f8178i.setImageResource(h.heart_rate_measuring_connected);
        this.f8179j.setTextColor(this.f8177h.getResources().getColor(c.common_white_90alpha));
        this.f8179j.setTextSize(17.0f);
        this.f8179j.setText(this.f8177h.getResources().getString(i.IDS_hw_health_show_healthdata_heart_bmp));
    }

    private void m11638l() {
        this.f8182m.setEnabled(true);
        if (f8170d != -5) {
            f8170d = -5;
            this.f8180k.setVisibility(8);
            this.f8181l.stop();
            this.f8178i.setImageResource(h.heart_rate_measuring_connected);
            this.f8179j.setTextColor(this.f8177h.getResources().getColor(c.common_white_90alpha));
            this.f8179j.setTextSize(17.0f);
            this.f8179j.setText(this.f8177h.getResources().getString(i.IDS_heart_rate_measuring_status_data_zero));
        }
    }

    public void m11643a() {
        C2538c.m12677c("HeartRateStatusInteractors", "Enter onDestroy");
        m11642p();
        m11640n();
        m11644b();
    }

    public void m11644b() {
        try {
            C2538c.m12677c("HeartRateStatusInteractors", "Enter unRegisterHeartRateBroadcast()!");
            if (this.f8177h != null) {
                this.f8177h.unregisterReceiver(this.f8183n);
            }
        } catch (IllegalArgumentException e) {
            C2538c.m12677c("HeartRateStatusInteractors", e.getMessage());
        } catch (RuntimeException e2) {
            C2538c.m12677c("HeartRateStatusInteractors", e2.getMessage());
        }
    }

    private void m11639m() {
        this.f8177h.registerReceiver(this.f8184o, new IntentFilter("com.huawei.bone.action.CONNECTION_STATE_CHANGED"), C0976c.f1642a, null);
    }

    private void m11640n() {
        try {
            C2538c.m12677c("HeartRateStatusInteractors", "Enter unregisterDeviceConnectStatusBroadcast()!");
            if (this.f8177h != null) {
                this.f8177h.unregisterReceiver(this.f8184o);
            }
        } catch (IllegalArgumentException e) {
            C2538c.m12677c("HeartRateStatusInteractors", e.getMessage());
        } catch (RuntimeException e2) {
            C2538c.m12677c("HeartRateStatusInteractors", e2.getMessage());
        }
    }

    public void m11645c() {
        C2538c.m12677c("HeartRateStatusInteractors", "Enter onResume");
    }

    private void m11641o() {
        C2538c.m12677c("HeartRateStatusInteractors", "Enter openHeartRateRunningForeground");
        DeviceInfo c = C1204c.m5370a(this.f8177h).m5447c();
        if (c != null && 11 == c.getProductType() && 2 == c.getDeviceConnectState() && f8170d != -4 && f8170d != -6) {
        }
    }

    private void m11642p() {
        C2538c.m12677c("HeartRateStatusInteractors", "Enter closeHeartRateRunningForeground");
        DeviceInfo c = C1204c.m5370a(this.f8177h).m5447c();
        if (c != null && 11 == c.getProductType() && 2 != c.getDeviceConnectState()) {
        }
    }
}
