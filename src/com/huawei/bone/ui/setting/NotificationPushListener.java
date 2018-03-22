package com.huawei.bone.ui.setting;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.huawei.bone.C6753R;
import com.huawei.crowdtestsdk.report.ReportInfoUtils;
import com.huawei.hwcommonmodel.p062a.C0972a;
import com.huawei.hwmessagenotifymgr.notifymanager.C1035a;
import com.huawei.hwservicesmgr.PhoneService;
import com.huawei.p190v.C2538c;
import java.util.ArrayList;

@SuppressLint({"NewApi"})
public class NotificationPushListener extends NotificationListenerService {
    private static final String[] f1217a = new String[]{"com.tencent.mm", "com.tencent.mqq", "com.tencent.mobileqq", "com.tencent.qqlite", "com.tencent.mobileqqi", "com.tencent.minihd.qq", "com.tencent.eim"};
    private ArrayList<String> f1218b = new ArrayList();
    private C1035a f1219c;
    private LocalBroadcastManager f1220d;
    private BroadcastReceiver f1221e = new C0668a(this);

    public void onCreate() {
        super.onCreate();
        try {
            m2647a();
        } catch (Exception e) {
            C2538c.m12661a("04", 1, "NotificationPushListener", "onCreat() error! Exception = " + e.getMessage());
        }
    }

    public boolean onUnbind(Intent intent) {
        C2538c.m12661a("04", 1, "NotificationPushListener", "onUnbind enter...");
        return super.onUnbind(intent);
    }

    private void m2647a() {
        C2538c.m12661a("04", 1, "NotificationPushListener", "onCreate");
        this.f1219c = C1035a.m4176b();
        if (this.f1219c == null) {
            C2538c.m12680e("NotificationPushListener", "mHWNotificationMgr is null");
            return;
        }
        this.f1220d = LocalBroadcastManager.getInstance(this);
        if (this.f1220d != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.huawei.bone.ACTION_NOTIFICATION_AUTHORIZED_CHANGED");
            intentFilter.addAction("com.huawei.bone.ACTION_NOTIFICATION_TIME_CHANGED");
            this.f1220d.registerReceiver(this.f1221e, intentFilter);
        }
        this.f1218b.add("com.android.server.telecom");
        this.f1218b.add("com.android.phone");
        C2538c.m12661a("04", 1, "NotificationPushListener", "onCreate leave");
    }

    public void onDestroy() {
        super.onDestroy();
        this.f1220d.unregisterReceiver(this.f1221e);
        C2538c.m12661a("04", 1, "NotificationPushListener", "onDestroy");
    }

    public void onNotificationPosted(StatusBarNotification statusBarNotification) {
        try {
            m2648a(statusBarNotification);
        } catch (Exception e) {
            C2538c.m12661a("04", 1, "NotificationPushListener", "onNotificationPosted, Exception = ", e.getMessage());
        }
    }

    private void m2648a(StatusBarNotification statusBarNotification) {
        String str = null;
        C2538c.m12661a("04", 1, "NotificationPushListener", "onNotificationPosted, Notification = ", statusBarNotification.toString());
        if (m2650b()) {
            String packageName = statusBarNotification.getPackageName();
            C2538c.m12661a("04", 1, "NotificationPushListener", "onNotificationPosted, packageName = " + packageName + ", id = " + statusBarNotification.getId());
            String string = Secure.getString(getContentResolver(), "sms_default_application");
            if (!packageName.contains(string)) {
                string = packageName;
            }
            if (string.equalsIgnoreCase("com.huawei.intelligent")) {
                if (5 == this.f1219c.m4189e()) {
                    if (!this.f1218b.contains("com.huawei.intelligent")) {
                        this.f1218b.add("com.huawei.intelligent");
                        C2538c.m12661a("04", 1, "NotificationPushListener", "add PACKAGE_NAME_INTELLIGENT");
                    }
                } else if (this.f1218b.contains("com.huawei.intelligent")) {
                    this.f1218b.remove("com.huawei.intelligent");
                    C2538c.m12661a("04", 1, "NotificationPushListener", "remove PACKAGE_NAME_INTELLIGENT");
                }
            }
            if (this.f1218b.contains(string)) {
                C2538c.m12661a("04", 1, "NotificationPushListener", "onNotificationPosted, mPushApp contain " + string);
            } else if (1 == this.f1219c.m4177a(string)) {
                this.f1218b.add(string);
            } else {
                C2538c.m12661a("04", 1, "NotificationPushListener", "onNotificationPosted, isAppPushEnable false");
                return;
            }
            int a = m2645a(string);
            Notification notification = statusBarNotification.getNotification();
            if (m2649a(notification, string)) {
                C2538c.m12661a("04", 1, "NotificationPushListener", "onNotificationPosted, isNeedFilter!");
                return;
            }
            Bundle bundle = notification.extras;
            if (bundle != null) {
                String string2 = bundle.getString(NotificationCompat.EXTRA_TITLE);
                CharSequence charSequence = bundle.getCharSequence(NotificationCompat.EXTRA_TEXT);
                if (charSequence != null) {
                    packageName = charSequence.toString();
                } else {
                    charSequence = null;
                }
                if (TextUtils.equals(bundle.getString("hw_notification_type"), "hang_up")) {
                    C2538c.m12661a("04", 1, "NotificationPushListener", "notification is repeat!");
                    return;
                }
                str = string2;
            } else {
                C2538c.m12661a("04", 1, "NotificationPushListener", "onNotificationPosted, extras == null ");
                packageName = null;
            }
            try {
                getPackageManager().getApplicationInfo(string, 0);
            } catch (NameNotFoundException e) {
                C2538c.m12661a("04", 1, "NotificationPushListener", "onNotificationPosted, NameNotFoundException------" + string);
            }
            if (TextUtils.isEmpty(packageName)) {
                C2538c.m12661a("04", 1, "NotificationPushListener", "onNotificationPosted, notificationText is empty");
                packageName = getString(C6753R.string.IDS_notification_message_prompt);
                if (r4 == ReportInfoUtils.FEEDBACK_SUCCESS) {
                    C2538c.m12661a("04", 1, "NotificationPushListener", "onNotificationPosted, notificationText is empty, is sms main notification");
                    return;
                } else if (TextUtils.isEmpty(str)) {
                    C2538c.m12661a("04", 1, "NotificationPushListener", "onNotificationPosted, notificationTitle is empty");
                    return;
                }
            }
            if (packageName.equalsIgnoreCase("Push Service") && str.equalsIgnoreCase("Push Service")) {
                C2538c.m12661a("04", 1, "NotificationPushListener", "onNotificationPosted, push service filter,return");
                return;
            }
            C2538c.m12661a("04", 1, "NotificationPushListener", "onNotificationPosted, type---------" + a);
            C2538c.m12661a("04", 1, "NotificationPushListener", "NotificationPushListener start NotifySendData to send command");
            Intent intent = new Intent(this, PhoneService.class);
            intent.setAction("com.huawei.bone.ACTION_NOTIFICATION_PUSH");
            Bundle bundle2 = new Bundle();
            bundle2.putInt("type", a);
            if (1 == a || 2 == a || 3 == a || 11 == a) {
                bundle2.putInt("title_type", 2);
            } else {
                bundle2.putInt("title_type", 3);
            }
            bundle2.putString("title", str);
            bundle2.putInt("text_type", 1);
            bundle2.putString("text", packageName);
            intent.putExtras(bundle2);
            C2538c.m12661a("04", 1, "NotificationPushListener", "start to push notification msg.");
            startService(intent);
            return;
        }
        C2538c.m12661a("04", 1, "NotificationPushListener", "onNotificationPosted, not support!");
    }

    private boolean m2650b() {
        if (this.f1219c.m4182a()) {
            C2538c.m12661a("04", 1, "NotificationPushListener", "onNotificationPosted, is forbidden! ");
            return false;
        } else if (!this.f1219c.m4187c()) {
            C2538c.m12661a("04", 1, "NotificationPushListener", "onNotificationPosted, AUTHORIZED  not available ");
            return false;
        } else if (this.f1219c.m4190f()) {
            return true;
        } else {
            C2538c.m12661a("04", 1, "NotificationPushListener", "onNotificationPosted, not support message push in device capability");
            return false;
        }
    }

    private boolean m2649a(Notification notification, String str) {
        C2538c.m12661a("04", 1, "NotificationPushListener", "SDK_LEVEL:" + VERSION.SDK_INT);
        if (VERSION.SDK_INT >= 21) {
            String str2 = notification.category;
            if (!TextUtils.isEmpty(str2)) {
                C2538c.m12661a("04", 1, "NotificationPushListener", "onNotificationPosted, category = " + str2);
                if ("com.android.contacts".equalsIgnoreCase(str) && str2.equalsIgnoreCase("call")) {
                    C2538c.m12661a("04", 1, "NotificationPushListener", "onNotificationPosted, 3 in 1 app & not sms message, return");
                    return true;
                }
            }
        }
        if ((notification.flags & 32) == 32) {
            C2538c.m12661a("04", 1, "NotificationPushListener", "onNotificationPosted, no_clear message filter,return");
            return true;
        } else if (str.equalsIgnoreCase("com.sdu.didi.psnger") && (notification.flags & 256) == 256) {
            C2538c.m12661a("04", 1, "NotificationPushListener", "onNotificationPosted, local message ,return");
            return true;
        } else if (notification.flags != 2) {
            return false;
        } else {
            C2538c.m12661a("04", 1, "NotificationPushListener", "onNotificationPosted, ongoing message filter,return");
            return true;
        }
    }

    public void onNotificationRemoved(StatusBarNotification statusBarNotification) {
        if (this.f1219c.m4182a()) {
            C2538c.m12677c("NotificationPushListener", "onNotificationPosted, is forbidden! ");
        } else if (statusBarNotification != null) {
            C2538c.m12661a("04", 1, "NotificationPushListener", "onNotificationRemoved, " + statusBarNotification.toString());
            if (C0972a.m3499a() != null) {
                C2538c.m12661a("04", 1, "NotificationPushListener", "onNotificationRemoved, isSupport :" + C0972a.m3499a().isSupportDeleteMsg());
                if (C0972a.m3499a().isSupportDeleteMsg()) {
                    String packageName = statusBarNotification.getPackageName();
                    int a;
                    Intent intent;
                    if (packageName.equals("com.android.server.telecom") || packageName.equals("com.android.phone")) {
                        a = m2645a(packageName);
                        C2538c.m12661a("04", 1, "NotificationPushListener", "onNotificationRemoved,  type :" + a);
                        if (a != 127) {
                            intent = new Intent(this, PhoneService.class);
                            intent.setAction("com.huawei.bone.ACTION_NOTIFICATION_DELETE");
                            intent.putExtra("type", a);
                            startService(intent);
                        }
                    } else if (1 == this.f1219c.m4177a(packageName)) {
                        a = m2645a(packageName);
                        C2538c.m12661a("04", 1, "NotificationPushListener", "onNotificationRemoved,  type :" + a);
                        if (a != 127) {
                            intent = new Intent(this, PhoneService.class);
                            intent.setAction("com.huawei.bone.ACTION_NOTIFICATION_DELETE");
                            intent.putExtra("type", a);
                            startService(intent);
                        }
                    }
                }
            }
        }
    }

    private int m2645a(String str) {
        CharSequence string = Secure.getString(getContentResolver(), "sms_default_application");
        if (TextUtils.equals(str, "com.android.incallui")) {
            return 1;
        }
        if (TextUtils.equals(str, string)) {
            return 2;
        }
        if (TextUtils.equals(str, "com.tencent.mm")) {
            return 3;
        }
        if (TextUtils.equals(str, "com.tencent.mqq") || TextUtils.equals(str, "com.tencent.mobileqq") || TextUtils.equals(str, "com.tencent.mobileqqi") || TextUtils.equals(str, "com.tencent.minihd.qq") || TextUtils.equals(str, "com.tencent.qqlite") || TextUtils.equals(str, "com.tencent.eim")) {
            return 11;
        }
        if (TextUtils.equals(str, "com.android.phone") || TextUtils.equals(str, "com.android.server.telecom") || TextUtils.equals(str, "com.android.dialer")) {
            return 14;
        }
        if (TextUtils.equals(str, "com.android.email") || TextUtils.equals(str, "com.netease.mobimail")) {
            return 15;
        }
        return 127;
    }
}
