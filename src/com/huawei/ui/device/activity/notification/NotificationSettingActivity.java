package com.huawei.ui.device.activity.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ResolveInfo.DisplayNameComparator;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import com.huawei.hwcommonmodel.p062a.C0972a;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.hwmessagenotifymgr.a.a;
import com.huawei.hwmessagenotifymgr.notifymanager.C1035a;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.commonui.dialog.u;
import com.huawei.ui.commonui.dialog.w;
import com.huawei.ui.device.b;
import com.huawei.ui.device.e;
import com.huawei.ui.device.f;
import com.huawei.ui.device.g;
import com.huawei.ui.device.i;
import com.huawei.ui.device.p170a.ae;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NotificationSettingActivity extends BaseActivity implements OnClickListener {
    private static final String[] f7388m = new String[]{"com.tencent.mm", "com.android.mms", "com.huawei.intelligent", "com.tencent.mobileqq", "com.tencent.mqq", "com.sina.weibo", "com.android.contacts", "com.android.phone", "com.bbk.calendar", "com.android.calendar", "com.google.android.calendar", "com.android.smspush", "com.android.providers.telephony", "com.htc.sense.mms", "com.google.android.apps.messaging"};
    private static final String[] f7389n = new String[]{"com.android.contacts", "com.htc.contacts", "cn.nubia.contacts"};
    boolean f7390a = false;
    private C2103j f7391b = null;
    private Context f7392c;
    private Switch f7393d;
    private Switch f7394e;
    private ListView f7395f;
    private RelativeLayout f7396g;
    private TextView f7397h;
    private ae f7398i;
    private List<a> f7399j = new ArrayList();
    private C2101h f7400k;
    private C2100g f7401l = null;
    private ProgressBar f7402o;
    private LocalBroadcastManager f7403p;
    private boolean f7404q = false;
    private LinearLayout f7405r = null;
    private ImageView f7406s = null;
    private OnCheckedChangeListener f7407t = new C2096c(this);
    private OnCheckedChangeListener f7408u = new C2097d(this);
    private BroadcastReceiver f7409v = new C2099f(this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(f.notification_setting_layout);
        this.f7392c = this;
        Intent intent = getIntent();
        if (intent != null) {
            this.f7390a = intent.getBooleanExtra("IsDisable", false);
            C2538c.m12677c("NotificationSettingActivity", "onCreate isNeedAlert :" + this.f7390a);
        }
        this.f7391b = new C2103j(this);
        this.f7403p = LocalBroadcastManager.getInstance(this.f7392c);
        this.f7398i = new ae(this.f7392c);
        m10845b();
        this.f7401l = new C2100g();
        this.f7401l.start();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        registerReceiver(this.f7409v, intentFilter);
    }

    private void m10845b() {
        this.f7393d = (Switch) d.a(this, e.switch_button_notification);
        this.f7393d.setChecked(this.f7398i.m10304a());
        this.f7393d.setOnCheckedChangeListener(this.f7407t);
        this.f7396g = (RelativeLayout) d.a(this, e.setting_device_notification_only_wearable);
        this.f7397h = (TextView) d.a(this, e.content_only_wearable);
        this.f7394e = (Switch) d.a(this, e.switch_button_notification_only_wearable);
        this.f7394e.setChecked(this.f7398i.m10305b());
        this.f7394e.setOnCheckedChangeListener(this.f7408u);
        this.f7395f = (ListView) findViewById(e.notification_app_list);
        this.f7400k = new C2101h();
        this.f7395f.setAdapter(this.f7400k);
        this.f7402o = (ProgressBar) findViewById(e.notify_load_app_progress);
        if (this.f7398i.m10304a()) {
            this.f7402o.setVisibility(0);
        }
        if (this.f7390a) {
            this.f7405r = (LinearLayout) d.a(this, e.activity_notification_setting_item);
            this.f7406s = (ImageView) d.a(this, e.notify_alert_icon);
            this.f7406s.setOnClickListener(this);
            this.f7405r.setVisibility(0);
        }
        this.f7404q = this.f7398i.m10304a();
        C2538c.m12677c("NotificationSettingActivity", "initView lastStatus:" + this.f7404q);
    }

    private void m10847c() {
        w wVar = new w(this.f7392c);
        wVar.a(i.IDS_service_area_notice_title);
        wVar.b(this.f7392c.getString(i.IDS_nottification_close_remind));
        wVar.a(i.IDS_yes, new C2094a(this));
        wVar.b(i.IDS_no, new C2095b(this));
        u a = wVar.a();
        a.setCancelable(false);
        if (!a.isShowing()) {
            a.show();
        }
    }

    protected void onResume() {
        C2538c.m12677c("NotificationSettingActivity", "onResume() mNotificationSwitch : isChecked = " + this.f7393d.isChecked());
        C2538c.m12661a("03", 1, "NotificationSettingActivity", "onResume() mNotificationSwitch : isChecked = " + this.f7393d.isChecked());
        super.onResume();
        if (this.f7398i.m10304a()) {
            C2538c.m12677c("NotificationSettingActivity", "onResume() isAuthorizeEnabled = true");
            this.f7393d.setChecked(true);
            this.f7397h.setTextColor(getResources().getColor(b.common_white_90alpha));
            this.f7394e.setEnabled(true);
            if (!this.f7401l.isAlive()) {
                this.f7395f.setVisibility(0);
                this.f7391b.sendEmptyMessage(0);
            }
        } else {
            C2538c.m12677c("NotificationSettingActivity", "onResume() isAuthorizeEnabled = false");
            this.f7393d.setChecked(false);
            this.f7397h.setTextColor(getResources().getColor(b.common_white_20alpha));
            this.f7394e.setEnabled(false);
            this.f7395f.setVisibility(8);
            C1035a.m4176b().m4188d();
        }
        C2538c.m12677c("NotificationSettingActivity", "onResume() lastStatus:" + this.f7404q + "isAuthorizeEnabled:" + this.f7393d.isChecked());
        if (this.f7404q != this.f7393d.isChecked()) {
            boolean z;
            if (this.f7398i.m10300a("com.huawei.intelligent") == 0) {
                z = false;
            } else {
                z = true;
            }
            if (C0972a.m3499a() != null && C0972a.m3499a().isSupportMidware()) {
                C1035a.m4176b().m4181a(this.f7398i.m10304a(), z);
            }
            this.f7404q = this.f7393d.isChecked();
        }
        if (this.f7398i.m10305b()) {
            this.f7394e.setChecked(true);
        } else {
            this.f7394e.setChecked(false);
        }
        if (C0972a.m3499a() == null || !C0972a.m3499a().isSupportWearMessagePush()) {
            this.f7396g.setVisibility(8);
        } else {
            this.f7396g.setVisibility(0);
        }
    }

    private void m10848d() {
        this.f7402o.setVisibility(8);
        if (this.f7398i.m10304a()) {
            C2538c.m12677c("NotificationSettingActivity", "onResume() isAuthorizeEnabled = true");
            this.f7395f.setVisibility(0);
            return;
        }
        C2538c.m12677c("NotificationSettingActivity", "onResume() isAuthorizeEnabled = false");
        this.f7395f.setVisibility(8);
    }

    private boolean m10843a(String str) {
        List asList = Arrays.asList(f7389n);
        for (int i = 0; i < asList.size(); i++) {
            if (asList.get(i).equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void m10857a() {
        this.f7399j.clear();
        List arrayList = new ArrayList();
        Object arrayList2 = new ArrayList();
        Object arrayList3 = new ArrayList();
        C2538c.m12677c("NotificationSettingActivity", "loadAllAppsByBatch----isChecked:" + this.f7393d.isChecked());
        Intent intent = new Intent("android.intent.action.MAIN", null);
        intent.addCategory("android.intent.category.LAUNCHER");
        Object string = Secure.getString(getContentResolver(), "sms_default_application");
        C2538c.m12677c("NotificationSettingActivity", "ActivityInfo", "getInstalledApplications--------- defaultSms: " + string);
        PackageManager packageManager = getPackageManager();
        List queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        Collections.sort(queryIntentActivities, new DisplayNameComparator(packageManager));
        int i = 0;
        Object obj = null;
        while (i < queryIntentActivities.size()) {
            Object obj2;
            ActivityInfo activityInfo = ((ResolveInfo) queryIntentActivities.get(i)).activityInfo;
            String str = activityInfo.packageName;
            String charSequence = activityInfo.loadLabel(packageManager).toString();
            if (TextUtils.equals(str, charSequence)) {
                obj2 = obj;
            } else {
                C2538c.m12677c("NotificationSettingActivity", "ActivityInfo", "getInstalledApplications--------- packageName: " + str + " Label: " + charSequence + "isAuthorized:" + this.f7398i.m10300a(str));
                a aVar = new a();
                if (TextUtils.equals(string, str)) {
                    if (obj != null) {
                        obj2 = obj;
                    } else {
                        obj = 1;
                        aVar.b(str);
                        aVar.a(this.f7392c.getResources().getString(i.IDS_short_message));
                        aVar.a(getResources().getDrawable(g.notification_icon_sms));
                    }
                } else if (m10843a(str)) {
                    obj2 = obj;
                } else {
                    aVar.b(str);
                    aVar.a(charSequence);
                    aVar.a(activityInfo.loadIcon(packageManager));
                }
                int a = m10838a(r2, string, str, r5, aVar);
                if (1 == a) {
                    aVar.a(a);
                    arrayList.add(aVar);
                    obj2 = obj;
                } else {
                    aVar.a(a);
                    a = 0;
                    while (a < f7388m.length) {
                        if (str.equals(f7388m[a])) {
                            arrayList2.add(aVar);
                            break;
                        }
                        a++;
                    }
                    if (a >= f7388m.length) {
                        arrayList3.add(aVar);
                    }
                    obj2 = obj;
                }
            }
            i++;
            obj = obj2;
        }
        Object a2 = m10842a(arrayList);
        a aVar2 = new a();
        if ((m10851e() && this.f7398i.m10300a("com.huawei.intelligent") == 1) || (m10851e() && m10837a("com.huawei.intelligent", this.f7398i.m10300a("com.huawei.intelligent"), aVar2) == 1)) {
            a2.add(m10840a(aVar2));
        } else if (m10851e()) {
            arrayList2.add(m10840a(aVar2));
        }
        try {
            this.f7399j.addAll(a2);
            this.f7399j.addAll(arrayList2);
            this.f7399j.addAll(arrayList3);
        } catch (ArrayIndexOutOfBoundsException e) {
            C2538c.m12680e("NotificationSettingActivity", "ArrayIndexOutOfBoundsException e : " + e.getMessage());
        }
        a2.clear();
        arrayList2.clear();
        arrayList3.clear();
    }

    private int m10838a(boolean z, String str, String str2, int i, a aVar) {
        if ("true".equals(C0996a.m3612a(this.f7392c, String.valueOf(10001), "KEY_NOTIFICATION_SETTINGS_FIRST_OPEN_FLAG")) || z) {
            return i;
        }
        if (!"com.tencent.mm".equals(str2) && !TextUtils.equals(str, str2) && !"com.tencent.mobileqq".equals(str2) && !"com.tencent.mqq".equals(str2)) {
            return i;
        }
        if (i != 1) {
            aVar.a(1);
            this.f7398i.m10302a(str2, 1);
            C2538c.m12677c("NotificationSettingActivity", "set authorizeFlag auto!");
            C2538c.m12661a("03", 1, "NotificationSettingActivity", "set authorizeFlag auto!");
            Intent intent = new Intent("com.huawei.bone.ACTION_NOTIFICATION_AUTHORIZED_CHANGED");
            intent.putExtra(SNBConstant.FIELD_PKG, str2);
            intent.putExtra("authorized_flag", 1);
            this.f7403p.sendBroadcast(intent);
            return 1;
        }
        C2538c.m12677c("NotificationSettingActivity", "already auto set authorizeFlag!");
        return i;
    }

    private int m10837a(String str, int i, a aVar) {
        if ("true".equals(C0996a.m3612a(this.f7392c, String.valueOf(10001), "KEY_NOTIFICATION_SETTINGS_FIRST_OPEN_FLAG_ADD"))) {
            return i;
        }
        if (i != 1) {
            aVar.a(1);
            this.f7398i.m10302a(str, 1);
            C2538c.m12677c("NotificationSettingActivity", "set authorizeFlag auto!");
            C2538c.m12661a("03", 1, "NotificationSettingActivity", "set authorizeFlag auto!");
            Intent intent = new Intent("com.huawei.bone.ACTION_NOTIFICATION_AUTHORIZED_CHANGED");
            intent.putExtra(SNBConstant.FIELD_PKG, str);
            intent.putExtra("authorized_flag", 1);
            this.f7403p.sendBroadcast(intent);
            return 1;
        }
        C2538c.m12677c("NotificationSettingActivity", "already auto set authorizeFlag!");
        return i;
    }

    private List<a> m10842a(List<a> list) {
        int i = 0;
        List<a> arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            int i3;
            for (String equals : f7388m) {
                if (equals.equals(((a) list.get(i2)).c())) {
                    arrayList.add(list.get(i2));
                    i3 = 1;
                    break;
                }
            }
            i3 = 0;
            if (i3 == 0) {
                arrayList2.add(Integer.valueOf(i2));
            }
        }
        while (i < arrayList2.size()) {
            arrayList.add(list.get(((Integer) arrayList2.get(i)).intValue()));
            i++;
        }
        arrayList2.clear();
        return arrayList;
    }

    protected void onStop() {
        C2538c.m12677c("NotificationSettingActivity", "onStop()  mNotificationSwitch : isChecked = " + this.f7393d.isChecked());
        super.onStop();
    }

    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.f7409v);
        if (this.f7401l != null) {
            this.f7401l = null;
        }
        this.f7391b.removeMessages(0);
        C0977d.m3575n(this.f7392c);
    }

    public void onClick(View view) {
        if (view.getId() == e.notify_alert_icon) {
            this.f7405r.setVisibility(8);
        }
    }

    private boolean m10851e() {
        try {
            PackageManager packageManager = getPackageManager();
            String charSequence = packageManager.getApplicationLabel(packageManager.getApplicationInfo("com.huawei.intelligent", 128)).toString();
            C2538c.m12677c("NotificationSettingActivity", "Intelligent_name_is = " + charSequence);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    private a m10840a(a aVar) {
        try {
            PackageManager packageManager = getPackageManager();
            C2538c.m12677c("NotificationSettingActivity", "com.huawei.intelligent   name = " + packageManager.getApplicationLabel(packageManager.getApplicationInfo("com.huawei.intelligent", 128)).toString());
            C2538c.m12677c("NotificationSettingActivity", "com.huawei.intelligent   icon = " + packageManager.getApplicationIcon(packageManager.getApplicationInfo("com.huawei.intelligent", 128)));
            aVar.b("com.huawei.intelligent");
            aVar.a(r1);
            aVar.a(r0);
            aVar.a(this.f7398i.m10300a("com.huawei.intelligent"));
        } catch (NameNotFoundException e) {
            C2538c.m12677c("NotificationSettingActivity", "com.huawei.intelligent = " + e.getMessage());
        }
        return aVar;
    }
}
