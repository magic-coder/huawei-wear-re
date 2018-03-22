package com.huawei.pluginkidwatch.common.lib.utils;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.Notification.Style;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.widget.RemoteViews;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.i;
import java.lang.reflect.Field;

@SuppressLint({"NewApi"})
/* compiled from: NotificationUtil */
public class C1495o {
    private static int f3494a = 0;

    public static boolean m6931a(Context context) {
        if ("notification_off".equals(C1491k.m6899b(context, "sharedpreferences_notification_switch", "notification_on"))) {
            return false;
        }
        return true;
    }

    public static void m6930a(Context context, Class<?> cls, String str, String str2, String str3, int i, int... iArr) {
        C1495o.m6929a(context, cls, str, str2, str3, i, null, iArr);
    }

    public static void m6929a(Context context, Class<?> cls, String str, String str2, String str3, int i, RemoteViews remoteViews, int... iArr) {
        if (C1495o.m6931a(context)) {
            PendingIntent activity;
            int i2;
            Notification build;
            Intent intent;
            if (i == 0) {
                C2538c.m12674b("NotificationUtil", "notificationService which:" + i);
                intent = new Intent();
                intent.addFlags(536870912);
                intent.setClass(context, cls);
                activity = PendingIntent.getActivity(context, 0, intent, HwAccountConstants.FLAG_TRANS_NAVIGATION_BAR);
            } else if (8 == i) {
                C2538c.m12674b("NotificationUtil", "=====reach goal notifacation");
                i2 = 0;
                r4 = new Intent();
                r4.setClass(context, cls);
                r4.setFlags(3);
                r4.putExtra("is_from_notification", true);
                for (int i3 : iArr) {
                }
                if (i2 != 0) {
                    C2538c.m12674b("NotificationUtil", "==========通知中的deviceCode和当前devicecode不是同一个");
                    r4.putExtra("devicecode_from_notification", i2);
                }
                activity = PendingIntent.getActivity(context, 0, r4, HwAccountConstants.FLAG_TRANS_NAVIGATION_BAR);
            } else if (11 == i) {
                C2538c.m12674b("NotificationUtil", "=====reach goal notifacation");
                i2 = 0;
                r4 = new Intent();
                r4.setClass(context, cls);
                r4.setFlags(3);
                r4.putExtra("is_from_notification", true);
                for (int i4 : iArr) {
                }
                if (i2 != 0) {
                    C2538c.m12674b("NotificationUtil", "==========通知中的deviceCode和当前devicecode不是同一个");
                    r4.putExtra("devicecode_from_notification", i2);
                }
                activity = PendingIntent.getActivity(context, 0, r4, HwAccountConstants.FLAG_TRANS_NAVIGATION_BAR);
            } else if (10 == i) {
                C2538c.m12674b("NotificationUtil", "=====reach request reward notifacation");
                i2 = 0;
                r4 = new Intent();
                r4.setClass(context, cls);
                r4.setFlags(3);
                r4.putExtra("is_from_notification", true);
                for (int i5 : iArr) {
                }
                if (i2 != 0) {
                    C2538c.m12674b("NotificationUtil", "==========通知中的deviceCode和当前devicecode是同一个");
                    r4.putExtra("devicecode_from_notification", i2);
                }
                activity = PendingIntent.getActivity(context, 0, r4, HwAccountConstants.FLAG_TRANS_NAVIGATION_BAR);
            } else if (9 == i) {
                intent = new Intent();
                intent.addFlags(32768);
                intent.addFlags(HwAccountConstants.FLAG_TRANSLUCENT_STATUS);
                intent.setClass(context, cls);
                activity = PendingIntent.getActivity(context, 0, intent, HwAccountConstants.FLAG_TRANS_NAVIGATION_BAR);
            } else if (7 == i) {
                C2538c.m12674b("NotificationUtil", "notificationService which:" + i);
                intent = new Intent();
                intent.setClass(context, cls);
                activity = PendingIntent.getActivity(context, 0, intent, HwAccountConstants.FLAG_TRANS_NAVIGATION_BAR);
            } else if (12 == i) {
                C2538c.m12674b("NotificationUtil", "=checkBill=  ID_GET_NEW_BILL ");
                i2 = 0;
                r4 = new Intent();
                r4.setClass(context, cls);
                r4.setFlags(4);
                r4.putExtra("is_from_notification", true);
                for (int i6 : iArr) {
                }
                if (i2 != 0) {
                    C2538c.m12674b("NotificationUtil", "=checkBill= 通知中的deviceCode和当前devicecode不是同一个");
                    r4.putExtra("devicecode_from_notification", i2);
                }
                activity = PendingIntent.getActivity(context, 0, r4, HwAccountConstants.FLAG_TRANS_NAVIGATION_BAR);
            } else if (4 == i) {
                C2538c.m12674b("NotificationUtil", "notificationService which:" + i);
                intent = new Intent();
                intent.addFlags(536870912);
                intent.setClass(context, cls);
                intent.putExtra("AutoCheckSucce", true);
                activity = PendingIntent.getActivity(context, 0, intent, HwAccountConstants.FLAG_TRANS_NAVIGATION_BAR);
            } else {
                activity = null;
            }
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            BitmapDrawable bitmapDrawable;
            if (VERSION.SDK_INT >= 16) {
                Builder builder = new Builder(context);
                if (remoteViews != null) {
                    Style bigTextStyle = new BigTextStyle();
                    bigTextStyle.setBigContentTitle(str2);
                    bigTextStyle.bigText(str3);
                    builder.setStyle(bigTextStyle);
                }
                builder.setContentTitle(str2);
                builder.setAutoCancel(true);
                builder.setContentText(str3);
                builder.setTicker(str);
                builder.setWhen(System.currentTimeMillis());
                builder.setContentIntent(activity);
                builder.setDefaults(5);
                builder.setSmallIcon(C1617f.app_logo_little);
                bitmapDrawable = (BitmapDrawable) context.getResources().getDrawable(i.app_icon);
                if (bitmapDrawable != null) {
                    builder.setLargeIcon(bitmapDrawable.getBitmap());
                }
                build = builder.build();
            } else {
                int i7;
                Notification notification = new Notification();
                notification.icon = C1617f.app_logo_little;
                notification.tickerText = str;
                notification.when = System.currentTimeMillis();
                notification.flags = 16;
                notification.defaults = 1;
                notification.defaults |= 4;
                i2 = 0;
                try {
                    Field field = Class.forName("com.android.internal.R$id").getField("icon");
                    field.setAccessible(true);
                    i7 = field.getInt(null);
                } catch (ClassNotFoundException e) {
                    C2538c.m12680e("NotificationUtil", "ClassNotFoundException e = " + e.getMessage());
                    i7 = i2;
                } catch (NoSuchFieldException e2) {
                    C2538c.m12680e("NotificationUtil", "NoSuchFieldException e = " + e2.getMessage());
                    i7 = i2;
                } catch (IllegalAccessException e3) {
                    C2538c.m12680e("NotificationUtil", "IllegalAccessException e = " + e3.getMessage());
                    i7 = i2;
                }
                bitmapDrawable = (BitmapDrawable) context.getResources().getDrawable(i.app_icon);
                if (!(notification.contentView == null || bitmapDrawable == null)) {
                    notification.contentView.setImageViewBitmap(i7, bitmapDrawable.getBitmap());
                }
                notification.flags = 16;
                build = notification;
            }
            if (remoteViews != null) {
                build.contentView = remoteViews;
                build.bigContentView = remoteViews;
            }
            notificationManager.notify(i, build);
            return;
        }
        C2538c.m12674b("NotificationUtil", "getNotificationSwitch is off");
    }

    public static void m6928a(Context context, int i) {
        C2538c.m12674b("NotificationUtil", "--cancelNotification:start--");
        try {
            ((NotificationManager) context.getSystemService("notification")).cancel(i);
        } catch (Exception e) {
            C2538c.m12680e("NotificationUtil", e.getMessage());
        }
    }
}
