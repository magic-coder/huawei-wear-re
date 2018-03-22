package com.huawei.ui.device.views.device;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hwbasemgr.C0956c;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.device.b;
import com.huawei.ui.device.e;
import com.huawei.ui.device.g;
import com.huawei.ui.device.i;
import com.huawei.ui.device.p170a.C1996x;

/* compiled from: DeviceListAdapter */
class C2201g extends ViewHolder {
    final /* synthetic */ C2198d f7873a;
    private ImageView f7874b;
    private TextView f7875c;
    private TextView f7876d;
    private ImageView f7877e;
    private ImageView f7878f;
    private ImageView f7879g;
    private TextView f7880h;
    private TextView f7881i;
    private AnimationDrawable f7882j = ((AnimationDrawable) this.f7879g.getDrawable());
    private View f7883k;
    private FrameLayout f7884l;
    private FrameLayout f7885m;
    private FrameLayout f7886n;
    private FrameLayout f7887o;
    private RelativeLayout f7888p;
    private LinearLayout f7889q;
    private ImageView f7890r;
    private Button f7891s;

    public C2201g(C2198d c2198d, View view) {
        this.f7873a = c2198d;
        super(view);
        this.f7889q = (LinearLayout) d.a(view, e.cardsedit_layout);
        this.f7888p = (RelativeLayout) d.a(view, e.device_layout);
        this.f7874b = (ImageView) d.a(view, e.device_type_icon);
        this.f7875c = (TextView) d.a(view, e.device_type_name);
        this.f7876d = (TextView) d.a(view, e.device_battery_value1);
        this.f7877e = (ImageView) d.a(view, e.device_bluetooth_connect_status);
        this.f7878f = (ImageView) d.a(view, e.device_bluetooth_disconnect_status);
        this.f7880h = (TextView) d.a(view, e.device_bluetooth_disconnect_txt);
        this.f7879g = (ImageView) d.a(view, e.device_connecting_status);
        this.f7881i = (TextView) d.a(view, e.device_connecting_txt);
        this.f7883k = d.a(view, e.listView_ItemLine);
        this.f7884l = (FrameLayout) d.a(view, e.Frame_device_image_name);
        this.f7885m = (FrameLayout) d.a(view, e.Frame_battery_connect);
        this.f7886n = (FrameLayout) d.a(view, e.Frame_disconnected);
        this.f7887o = (FrameLayout) d.a(view, e.Frame_connecting);
        this.f7890r = (ImageView) d.a(view, e.device_battery_view);
        this.f7891s = (Button) d.a(view, e.cardsdelete_tv);
    }

    private void m11308a(C2201g c2201g, C2202h c2202h) {
        C2538c.m12677c("DeviceListAdapter", "onBindViewHolder():Device DisConnected");
        c2201g.f7889q.setVisibility(0);
        c2201g.f7884l.setVisibility(0);
        c2201g.f7885m.setVisibility(8);
        c2201g.f7886n.setVisibility(0);
        c2201g.f7887o.setVisibility(8);
        c2201g.f7874b.setBackgroundResource(c2202h.m11323c());
        c2201g.f7875c.setText(c2202h.m11316a());
        c2201g.f7878f.setBackgroundResource(g.ic_devicemanager_bluetooth_disconnected);
        c2201g.f7880h.setText(i.IDS_myfitnesspal_logout);
        c2201g.f7883k.setBackgroundResource(b.common_white_15alpha);
    }

    private void m11311b(C2201g c2201g, C2202h c2202h) {
        c2201g.f7884l.setVisibility(0);
        c2201g.f7885m.setVisibility(0);
        c2201g.f7886n.setVisibility(8);
        c2201g.f7887o.setVisibility(8);
        c2201g.f7874b.setBackgroundResource(c2202h.m11323c());
        c2201g.f7875c.setText(c2202h.m11316a());
        c2201g.f7889q.setVisibility(0);
        c2201g.f7877e.setBackgroundResource(g.ic_devicemanager_bluetooth_connected);
        c2201g.f7883k.setBackgroundResource(b.common_white_15alpha);
        c2201g.f7890r.setVisibility(0);
        if (-2 == c2202h.m11327f()) {
            c2201g.f7890r.setVisibility(8);
            c2201g.f7876d.setVisibility(8);
            return;
        }
        CharSequence a = C0956c.m3344a((double) c2202h.m11321b(c2202h.m11326e()), 2, 0);
        c2201g.f7890r.setVisibility(0);
        c2201g.f7876d.setVisibility(0);
        if (10 < c2202h.m11321b(c2202h.m11326e())) {
            c2201g.f7876d.setTextColor(this.f7873a.f7862a.getResources().getColor(b.common_white_50alpha));
        } else {
            c2201g.f7876d.setTextColor(this.f7873a.f7862a.getResources().getColor(b.common_dialog_red_btn_color));
        }
        c2201g.f7876d.setText(a);
        c2201g.f7890r.setImageDrawable(C1996x.m10455a(c2202h.m11321b(c2202h.m11326e()), this.f7873a.f7862a));
    }

    private void m11313c(C2201g c2201g, C2202h c2202h) {
        c2201g.f7889q.setVisibility(0);
        c2201g.f7884l.setVisibility(0);
        c2201g.f7885m.setVisibility(8);
        c2201g.f7886n.setVisibility(8);
        c2201g.f7887o.setVisibility(0);
        c2201g.f7874b.setBackgroundResource(c2202h.m11323c());
        c2201g.f7875c.setText(c2202h.m11316a());
        c2201g.f7881i.setText(i.IDS_device_connecting);
        c2201g.f7879g.setBackgroundResource(com.huawei.ui.device.d.sleep_loading_animation);
        C2538c.m12677c("DeviceListAdapter", "deviceViewHolder.loadingAnimation = " + c2201g.f7882j);
        c2201g.f7882j.start();
        c2201g.f7883k.setBackgroundResource(b.common_white_15alpha);
    }

    private void m11315d(C2201g c2201g, C2202h c2202h) {
        c2201g.f7889q.setVisibility(8);
        c2201g.f7884l.setVisibility(0);
        c2201g.f7885m.setVisibility(8);
        c2201g.f7886n.setVisibility(8);
        c2201g.f7887o.setVisibility(8);
        c2201g.f7874b.setBackgroundResource(c2202h.m11323c());
        c2201g.f7875c.setText(c2202h.m11316a());
        c2201g.f7883k.setBackgroundResource(b.common_white_15alpha);
    }
}
