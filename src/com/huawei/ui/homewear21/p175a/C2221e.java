package com.huawei.ui.homewear21.p175a;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.b.a;
import com.huawei.l.a.c;
import com.huawei.p190v.C2538c;
import com.huawei.pluginaf500.ui.SettingActivity;
import com.huawei.ui.device.activity.alarm.AlarmActivity;
import com.huawei.ui.device.activity.core_sleep.CoreSleepSelectorActivity;
import com.huawei.ui.device.activity.donotdisturb.NoDisturbSettingActivity;
import com.huawei.ui.device.activity.heartrate.HeartRateSettingsActivity;
import com.huawei.ui.device.activity.leftrighthand.LeftRightHandSettingsActivity;
import com.huawei.ui.device.activity.notification.NotificationSettingActivity;
import com.huawei.ui.device.activity.onelevelmenu.OneLevelMenuManagerActivity;
import com.huawei.ui.device.activity.selectcontact.ContactMainActivity;
import com.huawei.ui.device.activity.weatherreport.WeatherReportActivity;
import com.huawei.ui.device.views.p174c.C2193b;
import com.huawei.ui.device.views.p174c.C2194c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: HomeFragment */
class C2221e implements OnItemClickListener {
    final /* synthetic */ C2217a f8131a;

    C2221e(C2217a c2217a) {
        this.f8131a = c2217a;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C2194c c2194c;
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Genera onItemClick: parent = " + adapterView + ",+view = " + view + ",+position = " + i + "+idLong = " + j);
        Map hashMap = new HashMap();
        synchronized (this.f8131a.aW) {
            c2194c = (C2194c) this.f8131a.ak.get(i);
        }
        C2538c.m12661a("MainUI", 1, "HomeFragment", "onItemClick: id = " + c2194c.m11256a());
        switch (c2194c.m11256a()) {
            case 0:
                if (this.f8131a.bu != null) {
                    this.f8131a.bu.sendEmptyMessage(12);
                }
                this.f8131a.m11552g();
                return;
            case 1:
                this.f8131a.m11451a(((C2193b) view.getTag()).f7811e);
                return;
            case 2:
                this.f8131a.m11451a(((C2193b) view.getTag()).f7811e);
                return;
            case 3:
                C2538c.m12661a("MainUI", 0, "HomeFragment", "来电静音");
                c.a().a(BaseApplication.m2632b(), a.cJ.a(), hashMap, 0);
                return;
            case 4:
                C2538c.m12661a("MainUI", 0, "HomeFragment", "startAlarmActivity");
                this.f8131a.m11544a(AlarmActivity.class);
                c.a().a(BaseApplication.m2632b(), a.cB.a(), hashMap, 0);
                return;
            case 5:
                C2538c.m12661a("MainUI", 0, "HomeFragment", "startNoDisturbSettingActivity");
                this.f8131a.m11545a(NoDisturbSettingActivity.class, 5);
                c.a().a(BaseApplication.m2632b(), a.cC.a(), hashMap, 0);
                return;
            case 6:
                C2538c.m12661a("MainUI", 0, "HomeFragment", "startNotificationSettingActivity");
                Intent intent = new Intent();
                if (this.f8131a.bb == null || this.f8131a.bb.getVisibility() != 0) {
                    intent.putExtra("IsDisable", false);
                } else {
                    intent.putExtra("IsDisable", true);
                }
                intent.setClass(this.f8131a.f8041z, NotificationSettingActivity.class);
                this.f8131a.startActivity(intent);
                c.a().a(BaseApplication.m2632b(), a.cV.a(), hashMap, 0);
                return;
            case 7:
                C2538c.m12661a("MainUI", 0, "HomeFragment", "startWeatherReportActivity");
                this.f8131a.m11545a(WeatherReportActivity.class, 7);
                c.a().a(BaseApplication.m2632b(), a.cD.a(), hashMap, 0);
                return;
            case 11:
                this.f8131a.m11451a(((C2193b) view.getTag()).f7811e);
                return;
            case 12:
                this.f8131a.m11544a(ContactMainActivity.class);
                c.a().a(BaseApplication.m2632b(), a.cE.a(), hashMap, 0);
                return;
            case 15:
                this.f8131a.m11451a(((C2193b) view.getTag()).f7811e);
                return;
            case 17:
                this.f8131a.m11403I();
                c.a().a(BaseApplication.m2632b(), a.cH.a(), hashMap, 0);
                return;
            case 18:
                C2538c.m12661a("MainUI", 0, "HomeFragment", "openHuaweiAppStore");
                this.f8131a.m11404J();
                c.a().a(BaseApplication.m2632b(), a.cq.a(), hashMap, 0);
                return;
            case 19:
                C2538c.m12661a("MainUI", 0, "HomeFragment", "gotoWallet");
                this.f8131a.m11428V();
                c.a().a(BaseApplication.m2632b(), a.cr.a(), hashMap, 0);
                return;
            case 20:
                C2538c.m12661a("MainUI", 0, "HomeFragment", "gotoMember");
                this.f8131a.m11432X();
                c.a().a(BaseApplication.m2632b(), a.cv.a(), hashMap, 0);
                return;
            case 21:
                C2538c.m12661a("MainUI", 0, "HomeFragment", "gotoSimCard");
                this.f8131a.m11430W();
                c.a().a(BaseApplication.m2632b(), a.cu.a(), hashMap, 0);
                return;
            case 22:
                C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter af500SettingsClickListener --> onClick");
                this.f8131a.m11544a(SettingActivity.class);
                c.a().a(BaseApplication.m2632b(), a.cI.a(), hashMap, 0);
                return;
            case 23:
                C2538c.m12661a("MainUI", 0, "HomeFragment", "startCoreSleepSelectorActivity");
                this.f8131a.m11545a(CoreSleepSelectorActivity.class, 23);
                c.a().a(BaseApplication.m2632b(), a.C.a(), hashMap, 0);
                return;
            case 24:
                C2538c.m12661a("MainUI", 0, "HomeFragment", "startHeartRateEnable");
                this.f8131a.m11545a(HeartRateSettingsActivity.class, 24);
                return;
            case 25:
                this.f8131a.m11451a(((C2193b) view.getTag()).f7811e);
                return;
            case 26:
                C2538c.m12661a("MainUI", 0, "HomeFragment", "startActivity LeftRightHandSettingsActivity");
                this.f8131a.m11545a(LeftRightHandSettingsActivity.class, 26);
                return;
            case 27:
                C2538c.m12661a("MainUI", 0, "HomeFragment", "gotoHealth");
                this.f8131a.m11446a(0);
                return;
            case 28:
                C2538c.m12661a("MainUI", 0, "HomeFragment", "OneLevelMenuManagerActivity");
                this.f8131a.m11544a(OneLevelMenuManagerActivity.class);
                return;
            default:
                return;
        }
    }
}
