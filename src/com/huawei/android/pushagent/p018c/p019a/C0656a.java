package com.huawei.android.pushagent.p018c.p019a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.huawei.hwid.core.constants.HwAccountConstants;

public class C0656a {
    private static String f1184a = "PushLogSC2712";
    private static int f1185b = 19;

    public static void m2503a(Context context, long j, PendingIntent pendingIntent) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager == null) {
            C0657e.m2517b(f1184a, "get AlarmManager error");
            return;
        }
        try {
            Object[] objArr = new Object[]{Integer.valueOf(0), Long.valueOf(j), pendingIntent};
            alarmManager.getClass().getDeclaredMethod("setExact", new Class[]{Integer.TYPE, Long.TYPE, PendingIntent.class}).invoke(alarmManager, objArr);
        } catch (Throwable e) {
            C0657e.m2521c(f1184a, " setExact NoSuchMethodException " + e.toString(), e);
            alarmManager.set(0, j, pendingIntent);
        } catch (Throwable e2) {
            C0657e.m2521c(f1184a, " setExact IllegalAccessException " + e2.toString(), e2);
            alarmManager.set(0, j, pendingIntent);
        } catch (Throwable e22) {
            C0657e.m2521c(f1184a, " setExact InvocationTargetException " + e22.toString(), e22);
            alarmManager.set(0, j, pendingIntent);
        } catch (Throwable e222) {
            C0657e.m2521c(f1184a, " setExact Exception " + e222.toString(), e222);
            alarmManager.set(0, j, pendingIntent);
        }
    }

    public static void m2504a(Context context, Intent intent) {
        C0657e.m2512a(f1184a, "enter cancelAlarm(Intent=" + intent);
        ((AlarmManager) context.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(context, 0, intent, 0));
    }

    public static void m2505a(Context context, Intent intent, long j) {
        C0657e.m2512a(f1184a, "enter AlarmTools:setHeartAlarm(intent:" + intent + " interval:" + j + "ms");
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, HwAccountConstants.FLAG_TRANS_NAVIGATION_BAR);
        if (VERSION.SDK_INT >= f1185b) {
            C0656a.m2503a(context, System.currentTimeMillis() + j, broadcast);
        } else {
            alarmManager.setRepeating(0, System.currentTimeMillis() + j, j, broadcast);
        }
    }

    public static void m2506a(Context context, String str) {
        C0657e.m2512a(f1184a, "enter cancelAlarm(Action=" + str);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        alarmManager.cancel(PendingIntent.getBroadcast(context, 0, intent, 0));
    }

    public static void m2507b(Context context, Intent intent, long j) {
        C0657e.m2512a(f1184a, "enter AlarmTools:setDelayAlarm(intent:" + intent + " interval:" + j + "ms, context:" + context);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, HwAccountConstants.FLAG_TRANS_NAVIGATION_BAR);
        if (VERSION.SDK_INT >= f1185b) {
            C0656a.m2503a(context, System.currentTimeMillis() + j, broadcast);
        } else {
            alarmManager.set(0, System.currentTimeMillis() + j, broadcast);
        }
    }
}
