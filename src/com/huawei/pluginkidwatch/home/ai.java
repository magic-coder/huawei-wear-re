package com.huawei.pluginkidwatch.home;

import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1410z;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.home.p156b.C1638r;

/* compiled from: HomeActivity */
class ai implements DrawerListener {
    final /* synthetic */ HomeActivity f4172a;

    ai(HomeActivity homeActivity) {
        this.f4172a = homeActivity;
    }

    public void onDrawerSlide(View view, float f) {
    }

    public void onDrawerOpened(View view) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "==========Enter onDrawerOpened()");
        C2538c.m12674b("KIDWATCH_HomeActivity", "==========isMainOwner：", C1462f.m6754n() + "");
        C2538c.m12674b("KIDWATCH_HomeActivity", "==========KWCache.getDeviceCode()：", C1462f.m6746j() + "");
        this.f4172a.m7527a(C1462f.m6748k());
        this.f4172a.mo2519e();
        if (g.main_left_menu == view.getId()) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "==========LEFT ");
            ((TextView) this.f4172a.bj.findViewById(g.menu_tv_reset_factory)).setText(C1680l.IDS_plugin_kidwatch_menu_general_settings_title);
            this.f4172a.bl = (ImageView) this.f4172a.bj.findViewById(g.menu_img_battery);
            this.f4172a.bo = (TextView) this.f4172a.bj.findViewById(g.menu_tv_percent);
            this.f4172a.bn = (ImageView) this.f4172a.bj.findViewById(g.menu_img_bluetooth);
            try {
                C1410z e;
                if (C1462f.m6748k() == null || 2 != this.f4172a.f4139l.mo2466a(C1462f.m6748k().f3096p)) {
                    C2538c.m12674b("KIDWATCH_HomeActivity", "=========== getBTDeviceConnectState disconnected");
                    this.f4172a.bn.setImageResource(C1617f.mid_popup_list_ic_bluetooth_2);
                    this.f4172a.m7521a(this.f4172a.bl, this.f4172a.bo);
                    e = C1392h.m6309e(this.f4172a.f4109F, C1462f.m6744i(), C1462f.m6746j());
                    if (e != null) {
                        C2538c.m12674b("KIDWATCH_HomeActivity", "============table1:" + e.toString());
                    }
                    if (e != null || e.f3215g <= 0) {
                        C2538c.m12674b("KIDWATCH_HomeActivity", "============table is null");
                    } else {
                        C2538c.m12674b("KIDWATCH_HomeActivity", "============table is not null,table.data2: " + e.f3217i);
                        C2538c.m12674b("KIDWATCH_HomeActivity", "============table is not null,table.versionBefore: " + e.f3213e);
                        C2538c.m12674b("KIDWATCH_HomeActivity", "============table is not null,table.KWCache.DEVICE_VERSION: " + C1462f.m6750l());
                        if ((!"".equals(C1462f.m6750l()) && !e.f3213e.equals(C1462f.m6750l())) || Math.abs(System.currentTimeMillis() - C1492l.m6922f(e.f3217i)) > 3600000) {
                            C2538c.m12674b("KIDWATCH_HomeActivity", "============The watch has already update success or 12 hour past ");
                            if (Math.abs(System.currentTimeMillis() - C1492l.m6922f(e.f3217i)) > 3600000) {
                                C2538c.m12674b("KIDWATCH_HomeActivity", "============The watch update success 12 hour past ");
                            } else {
                                C2538c.m12674b("KIDWATCH_HomeActivity", "============The watch has already update success ");
                            }
                            C1392h.m6312f(this.f4172a.f4109F, C1462f.m6744i(), C1462f.m6746j());
                            C1497q.m6942a(this.f4172a.f4109F, C1462f.m6746j(), Boolean.valueOf(false));
                        } else if (this.f4172a.f4132d.isAdded()) {
                            C2538c.m12674b("KIDWATCH_HomeActivity", "=================get state");
                            C1638r.m7761b(this.f4172a.f4109F);
                        } else {
                            C2538c.m12674b("KIDWATCH_HomeActivity", "=========menuFragement.isAdded():false");
                        }
                    }
                    if (this.f4172a.f4132d.isAdded()) {
                        this.f4172a.m7599i();
                        this.f4172a.f4132d.m7808a();
                    }
                }
                this.f4172a.bn.setImageResource(C1617f.mid_popup_list_ic_bluetooth_1);
                C2538c.m12674b("KIDWATCH_HomeActivity", "============ getBTDeviceConnectState connected");
                this.f4172a.m7521a(this.f4172a.bl, this.f4172a.bo);
                e = C1392h.m6309e(this.f4172a.f4109F, C1462f.m6744i(), C1462f.m6746j());
                if (e != null) {
                    C2538c.m12674b("KIDWATCH_HomeActivity", "============table1:" + e.toString());
                }
                if (e != null) {
                }
                C2538c.m12674b("KIDWATCH_HomeActivity", "============table is null");
                if (this.f4172a.f4132d.isAdded()) {
                    this.f4172a.m7599i();
                    this.f4172a.f4132d.m7808a();
                }
            } catch (Exception e2) {
                C2538c.m12674b("KIDWATCH_HomeActivity", "============ getBTDeviceConnectState connected e = " + e2.getMessage());
            }
        } else {
            if (this.f4172a.f4133e.isAdded()) {
                this.f4172a.f4133e.m7823a();
                this.f4172a.f4133e.m7824b();
            } else {
                C2538c.m12674b("KIDWATCH_HomeActivity", "=========settingFragement.isAdded():false");
            }
            new Thread(new aj(this)).start();
        }
    }

    public void onDrawerClosed(View view) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "==========Enter onDrawerClosed()");
        this.f4172a.f4151x.setClickable(true);
        this.f4172a.f4150w.setClickable(true);
        if (g.main_left_menu == view.getId()) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "========R.id.main_left_menu");
            if (this.f4172a.f4132d != null) {
                if (this.f4172a.f4132d.isAdded()) {
                    C1638r.m7760b();
                }
                if (C1462f.m6723a()) {
                    this.f4172a.m7605k();
                }
            }
        }
    }

    public void onDrawerStateChanged(int i) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "==========Enter onDrawerStateChanged()");
    }
}
