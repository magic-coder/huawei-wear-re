package com.huawei.android.pushselfshow.p338c;

import android.R.drawable;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushselfshow.p337b.C4149a;
import com.huawei.android.pushselfshow.utils.C4203a;
import com.huawei.crowdtestsdk.utils.ResUtil;
import com.huawei.hwid.core.constants.HwAccountConstants;
import java.util.Date;
import net.sqlcipher.database.SQLiteDatabase;

public class C4153b {
    private static int f15618a = 0;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"InlinedApi"})
    private static float m20264a(android.content.Context r4) {
        /*
        r0 = 1111490560; // 0x42400000 float:48.0 double:5.491493014E-315;
        r0 = com.huawei.android.pushselfshow.utils.C4203a.m20413a(r4, r0);
        r1 = (float) r0;
        r0 = r4.getResources();	 Catch:{ Exception -> 0x0034 }
        r2 = 17104901; // 0x1050005 float:2.4428256E-38 double:8.450944E-317;
        r0 = r0.getDimension(r2);	 Catch:{ Exception -> 0x0034 }
        r2 = 0;
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 <= 0) goto L_0x003e;
    L_0x0017:
        r2 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1));
        if (r2 <= 0) goto L_0x003e;
    L_0x001b:
        r1 = "PushSelfShowLog";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "getRescaleBitmapSize:";
        r2 = r2.append(r3);
        r2 = r2.append(r0);
        r2 = r2.toString();
        com.huawei.android.pushagent.c.a.e.a(r1, r2);
        return r0;
    L_0x0034:
        r0 = move-exception;
        r2 = "PushSelfShowLog";
        r0 = r0.toString();
        com.huawei.android.pushagent.c.a.e.c(r2, r0);
    L_0x003e:
        r0 = r1;
        goto L_0x001b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushselfshow.c.b.a(android.content.Context):float");
    }

    public static int m20265a(Context context, String str, String str2, Object obj) {
        int i;
        Throwable e;
        Throwable th;
        try {
            String str3 = context.getPackageName() + ".R";
            e.a("PushSelfShowLog", "try to refrect " + str3 + " typeName is " + str2);
            Class[] classes = Class.forName(str3).getClasses();
            e.a("PushSelfShowLog", "sonClassArr length " + classes.length);
            for (Class cls : classes) {
                e.a("PushSelfShowLog", "sonTypeClass,query sonclass is  %s", new Object[]{cls.getName().substring(str3.length() + 1) + " sonClass.getName() is" + cls.getName()});
                if (str2.equals(cls.getName().substring(str3.length() + 1))) {
                    break;
                }
            }
            Class cls2 = null;
            if (cls2 != null) {
                i = cls2.getField(str).getInt(obj);
                try {
                    e.a("PushSelfShowLog", " refect res id is %s", new Object[]{"" + i});
                } catch (ClassNotFoundException e2) {
                    e = e2;
                    e.c("PushSelfShowLog", "ClassNotFound failed,", e);
                    return i;
                } catch (NoSuchFieldException e3) {
                    e = e3;
                    e.c("PushSelfShowLog", "NoSuchFieldException failed,", e);
                    return i;
                } catch (IllegalAccessException e4) {
                    e = e4;
                    e.c("PushSelfShowLog", "IllegalAccessException failed,", e);
                    return i;
                } catch (IllegalArgumentException e5) {
                    e = e5;
                    e.c("PushSelfShowLog", "IllegalArgumentException failed,", e);
                    return i;
                } catch (IndexOutOfBoundsException e6) {
                    e = e6;
                    e.c("PushSelfShowLog", "IndexOutOfBoundsException failed,", e);
                    return i;
                } catch (Exception e7) {
                    e = e7;
                    e.c("PushSelfShowLog", "  failed,", e);
                    return i;
                }
                return i;
            }
            e.a("PushSelfShowLog", "sonTypeClass is null");
            String str4 = context.getPackageName() + ".R$" + str2;
            e.a("PushSelfShowLog", "try to refrect 2 " + str4 + " typeName is " + str2);
            i = Class.forName(str4).getField(str).getInt(obj);
            e.a("PushSelfShowLog", " refect res id 2 is %s", new Object[]{"" + i});
            return i;
        } catch (Throwable e8) {
            th = e8;
            i = 0;
            e = th;
            e.c("PushSelfShowLog", "ClassNotFound failed,", e);
            return i;
        } catch (Throwable e82) {
            th = e82;
            i = 0;
            e = th;
            e.c("PushSelfShowLog", "NoSuchFieldException failed,", e);
            return i;
        } catch (Throwable e822) {
            th = e822;
            i = 0;
            e = th;
            e.c("PushSelfShowLog", "IllegalAccessException failed,", e);
            return i;
        } catch (Throwable e8222) {
            th = e8222;
            i = 0;
            e = th;
            e.c("PushSelfShowLog", "IllegalArgumentException failed,", e);
            return i;
        } catch (Throwable e82222) {
            th = e82222;
            i = 0;
            e = th;
            e.c("PushSelfShowLog", "IndexOutOfBoundsException failed,", e);
            return i;
        } catch (Throwable e822222) {
            th = e822222;
            i = 0;
            e = th;
            e.c("PushSelfShowLog", "  failed,", e);
            return i;
        }
    }

    public static Notification m20266a(Context context, C4149a c4149a, int i, int i2, int i3) {
        Notification notification = new Notification();
        notification.icon = C4153b.m20271b(context, c4149a);
        int i4 = context.getApplicationInfo().labelRes;
        notification.tickerText = c4149a.f15594p;
        notification.when = System.currentTimeMillis();
        notification.flags |= 16;
        notification.defaults |= 1;
        Intent intent = new Intent("com.huawei.intent.action.PUSH");
        intent.putExtra("selfshow_info", c4149a.m20262c()).putExtra("selfshow_token", c4149a.m20263d()).putExtra("selfshow_event_id", "1").putExtra("selfshow_notify_id", i).setPackage(context.getPackageName()).setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, i2, intent, HwAccountConstants.FLAG_TRANS_NAVIGATION_BAR);
        notification.contentIntent = broadcast;
        Intent intent2 = new Intent("com.huawei.intent.action.PUSH");
        intent2.putExtra("selfshow_info", c4149a.m20262c()).putExtra("selfshow_token", c4149a.m20263d()).putExtra("selfshow_event_id", "2").putExtra("selfshow_notify_id", i).setPackage(context.getPackageName()).setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        notification.deleteIntent = PendingIntent.getBroadcast(context, i3, intent2, HwAccountConstants.FLAG_TRANS_NAVIGATION_BAR);
        if (c4149a.f15596r == null || "".equals(c4149a.f15596r)) {
            notification.setLatestEventInfo(context, context.getResources().getString(i4), c4149a.f15594p, broadcast);
        } else {
            notification.setLatestEventInfo(context, c4149a.f15596r, c4149a.f15594p, broadcast);
        }
        i4 = context.getResources().getIdentifier("icon", "id", "android");
        Bitmap c = C4153b.m20273c(context, c4149a);
        if (!(i4 == 0 || notification.contentView == null || c == null)) {
            notification.contentView.setImageViewBitmap(i4, c);
        }
        return C4154c.m20275a(context, notification, i, c4149a, c);
    }

    public static void m20267a(Context context, int i) {
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (notificationManager != null) {
                notificationManager.cancel(i);
            }
        } catch (Exception e) {
            e.d("PushSelfShowLog", "removeNotifiCationById err:" + e.toString());
        }
    }

    public static void m20268a(Context context, Intent intent) {
        int i = 0;
        try {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            if (intent.hasExtra("selfshow_notify_id")) {
                i = intent.getIntExtra("selfshow_notify_id", 0) + 3;
            }
            e.a("PushSelfShowLog", "setDelayAlarm(cancel) alarmNotityId " + i + " and intent is " + intent.toURI());
            Intent intent2 = new Intent("com.huawei.intent.action.PUSH");
            intent2.setPackage(context.getPackageName()).setFlags(32);
            PendingIntent broadcast = PendingIntent.getBroadcast(context, i, intent2, 536870912);
            if (broadcast != null) {
                e.a("PushSelfShowLog", "  alarm cancel");
                alarmManager.cancel(broadcast);
                return;
            }
            e.a("PushSelfShowLog", "alarm not exist");
        } catch (Exception e) {
            e.d("PushSelfShowLog", "cancelAlarm err:" + e.toString());
        }
    }

    public static void m20269a(Context context, Intent intent, long j, int i) {
        try {
            e.a("PushSelfShowLog", "enter setDelayAlarm(intent:" + intent.toURI() + " interval:" + j + "ms, context:" + context);
            ((AlarmManager) context.getSystemService("alarm")).set(0, System.currentTimeMillis() + j, PendingIntent.getBroadcast(context, i, intent, HwAccountConstants.FLAG_TRANS_NAVIGATION_BAR));
        } catch (Throwable e) {
            e.a("PushSelfShowLog", "set DelayAlarm error", e);
        }
    }

    public static synchronized void m20270a(Context context, C4149a c4149a) {
        synchronized (C4153b.class) {
            if (!(context == null || c4149a == null)) {
                try {
                    e.a("PushSelfShowLog", " showNotification , the msg id = " + c4149a.f15590l);
                    C4203a.m20412a(2, 180);
                    if (f15618a == 0) {
                        f15618a = (context.getPackageName() + new Date().toString()).hashCode();
                    }
                    int i = f15618a;
                    int i2 = f15618a + 1;
                    f15618a = i2;
                    int i3 = f15618a + 1;
                    f15618a = i3;
                    int i4 = f15618a + 1;
                    f15618a = i4;
                    Notification b = C4203a.m20431b() ? C4153b.m20272b(context, c4149a, i, i2, i3) : C4153b.m20266a(context, c4149a, i, i2, i3);
                    NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                    if (!(notificationManager == null || b == null)) {
                        notificationManager.notify(i, b);
                        if (c4149a.f15583e > 0) {
                            Intent intent = new Intent("com.huawei.intent.action.PUSH");
                            intent.putExtra("selfshow_info", c4149a.m20262c()).putExtra("selfshow_token", c4149a.m20263d()).putExtra("selfshow_event_id", "-1").putExtra("selfshow_notify_id", i).setPackage(context.getPackageName()).setFlags(32);
                            C4153b.m20269a(context, intent, (long) c4149a.f15583e, i4);
                            e.a("PushSelfShowLog", "setDelayAlarm alarmNotityId" + i4 + " and intent is " + intent.toURI());
                        }
                        C4203a.m20424a(context, "0", c4149a);
                    }
                } catch (Exception e) {
                    e.d("PushSelfShowLog", "showNotification error " + e.toString());
                }
            }
        }
    }

    private static int m20271b(Context context, C4149a c4149a) {
        int i = 0;
        if (context == null || c4149a == null) {
            e.b("PushSelfShowLog", "enter getSmallIconId, context or msg is null");
            return 0;
        }
        if (c4149a.f15597s != null && c4149a.f15597s.length() > 0) {
            i = C4153b.m20265a(context, c4149a.f15597s, ResUtil.TYPE_DRAWABLE, new drawable());
            e.a("PushSelfShowLog", context.getPackageName() + "  msg.statusIcon is " + c4149a.f15597s + ",and icon is " + i);
            if (i == 0) {
                i = context.getResources().getIdentifier(c4149a.f15597s, ResUtil.TYPE_DRAWABLE, "android");
            }
            e.a("PushSelfShowLog", "msg.statusIcon is " + c4149a.f15597s + ",and icon is " + i);
        }
        if (i != 0) {
            return i;
        }
        i = context.getApplicationInfo().icon;
        if (i != 0) {
            return i;
        }
        i = context.getResources().getIdentifier("btn_star_big_on", ResUtil.TYPE_DRAWABLE, "android");
        return i == 0 ? 17301651 : i;
    }

    public static Notification m20272b(Context context, C4149a c4149a, int i, int i2, int i3) {
        Builder builder = new Builder(context);
        builder.setSmallIcon(C4153b.m20271b(context, c4149a));
        int i4 = context.getApplicationInfo().labelRes;
        builder.setTicker(c4149a.f15594p);
        builder.setWhen(System.currentTimeMillis());
        builder.setAutoCancel(true);
        builder.setDefaults(1);
        Intent intent = new Intent("com.huawei.intent.action.PUSH");
        intent.putExtra("selfshow_info", c4149a.m20262c()).putExtra("selfshow_token", c4149a.m20263d()).putExtra("selfshow_event_id", "1").putExtra("selfshow_notify_id", i).setPackage(context.getPackageName()).setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, i2, intent, HwAccountConstants.FLAG_TRANS_NAVIGATION_BAR);
        Intent intent2 = new Intent("com.huawei.intent.action.PUSH");
        intent2.putExtra("selfshow_info", c4149a.m20262c()).putExtra("selfshow_token", c4149a.m20263d()).putExtra("selfshow_event_id", "2").putExtra("selfshow_notify_id", i).setPackage(context.getPackageName()).setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        PendingIntent broadcast2 = PendingIntent.getBroadcast(context, i3, intent2, HwAccountConstants.FLAG_TRANS_NAVIGATION_BAR);
        if (c4149a.f15596r == null || "".equals(c4149a.f15596r)) {
            builder.setContentTitle(context.getResources().getString(i4));
        } else {
            builder.setContentTitle(c4149a.f15596r);
        }
        builder.setContentText(c4149a.f15594p);
        builder.setContentIntent(broadcast);
        builder.setDeleteIntent(broadcast2);
        Bitmap c = C4153b.m20273c(context, c4149a);
        if (c != null) {
            builder.setLargeIcon(c);
        }
        return C4154c.m20274a(context, builder, i, c4149a, c) == null ? null : builder.getNotification();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Bitmap m20273c(android.content.Context r7, com.huawei.android.pushselfshow.p337b.C4149a r8) {
        /*
        r0 = 0;
        if (r7 == 0) goto L_0x0005;
    L_0x0003:
        if (r8 != 0) goto L_0x0006;
    L_0x0005:
        return r0;
    L_0x0006:
        r1 = r8.f15595q;	 Catch:{ NameNotFoundException -> 0x0100, Exception -> 0x011f }
        if (r1 == 0) goto L_0x00fe;
    L_0x000a:
        r1 = r8.f15595q;	 Catch:{ NameNotFoundException -> 0x0100, Exception -> 0x011f }
        r1 = r1.length();	 Catch:{ NameNotFoundException -> 0x0100, Exception -> 0x011f }
        if (r1 <= 0) goto L_0x00fe;
    L_0x0012:
        r2 = new com.huawei.android.pushselfshow.utils.c.a;	 Catch:{ NameNotFoundException -> 0x0100, Exception -> 0x011f }
        r2.<init>();	 Catch:{ NameNotFoundException -> 0x0100, Exception -> 0x011f }
        r1 = 0;
        r3 = r8.f15595q;	 Catch:{ NameNotFoundException -> 0x0100, Exception -> 0x011f }
        r4 = new java.lang.StringBuilder;	 Catch:{ NameNotFoundException -> 0x0100, Exception -> 0x011f }
        r4.<init>();	 Catch:{ NameNotFoundException -> 0x0100, Exception -> 0x011f }
        r5 = "";
        r4 = r4.append(r5);	 Catch:{ NameNotFoundException -> 0x0100, Exception -> 0x011f }
        r5 = r8.m20260a();	 Catch:{ NameNotFoundException -> 0x0100, Exception -> 0x011f }
        r4 = r4.append(r5);	 Catch:{ NameNotFoundException -> 0x0100, Exception -> 0x011f }
        r4 = r4.toString();	 Catch:{ NameNotFoundException -> 0x0100, Exception -> 0x011f }
        r3 = r3.equals(r4);	 Catch:{ NameNotFoundException -> 0x0100, Exception -> 0x011f }
        if (r3 != 0) goto L_0x0078;
    L_0x0037:
        r1 = r8.f15595q;	 Catch:{ NameNotFoundException -> 0x0100, Exception -> 0x011f }
        r3 = "drawable";
        r4 = new android.R$drawable;	 Catch:{ NameNotFoundException -> 0x0100, Exception -> 0x011f }
        r4.<init>();	 Catch:{ NameNotFoundException -> 0x0100, Exception -> 0x011f }
        r1 = com.huawei.android.pushselfshow.p338c.C4153b.m20265a(r7, r1, r3, r4);	 Catch:{ NameNotFoundException -> 0x0100, Exception -> 0x011f }
        if (r1 != 0) goto L_0x0054;
    L_0x0046:
        r1 = r7.getResources();	 Catch:{ NameNotFoundException -> 0x0100, Exception -> 0x011f }
        r3 = r8.f15595q;	 Catch:{ NameNotFoundException -> 0x0100, Exception -> 0x011f }
        r4 = "drawable";
        r5 = "android";
        r1 = r1.getIdentifier(r3, r4, r5);	 Catch:{ NameNotFoundException -> 0x0100, Exception -> 0x011f }
    L_0x0054:
        r3 = "PushSelfShowLog";
        r4 = new java.lang.StringBuilder;	 Catch:{ NameNotFoundException -> 0x0100, Exception -> 0x011f }
        r4.<init>();	 Catch:{ NameNotFoundException -> 0x0100, Exception -> 0x011f }
        r5 = "msg.notifyIcon is ";
        r4 = r4.append(r5);	 Catch:{ NameNotFoundException -> 0x0100, Exception -> 0x011f }
        r5 = r8.f15595q;	 Catch:{ NameNotFoundException -> 0x0100, Exception -> 0x011f }
        r4 = r4.append(r5);	 Catch:{ NameNotFoundException -> 0x0100, Exception -> 0x011f }
        r5 = ",and defaultIcon is ";
        r4 = r4.append(r5);	 Catch:{ NameNotFoundException -> 0x0100, Exception -> 0x011f }
        r4 = r4.append(r1);	 Catch:{ NameNotFoundException -> 0x0100, Exception -> 0x011f }
        r4 = r4.toString();	 Catch:{ NameNotFoundException -> 0x0100, Exception -> 0x011f }
        com.huawei.android.pushagent.c.a.e.a(r3, r4);	 Catch:{ NameNotFoundException -> 0x0100, Exception -> 0x011f }
    L_0x0078:
        if (r1 == 0) goto L_0x00bb;
    L_0x007a:
        r2 = r7.getResources();	 Catch:{ NameNotFoundException -> 0x0100, Exception -> 0x011f }
        r0 = android.graphics.BitmapFactory.decodeResource(r2, r1);	 Catch:{ NameNotFoundException -> 0x0100, Exception -> 0x011f }
        r1 = r0;
    L_0x0083:
        if (r1 != 0) goto L_0x0148;
    L_0x0085:
        r0 = "com.huawei.android.pushagent";
        r2 = r8.f15591m;	 Catch:{ NameNotFoundException -> 0x0143, Exception -> 0x013e }
        r0 = r0.equals(r2);	 Catch:{ NameNotFoundException -> 0x0143, Exception -> 0x013e }
        if (r0 != 0) goto L_0x0148;
    L_0x008f:
        r0 = "PushSelfShowLog";
        r2 = new java.lang.StringBuilder;	 Catch:{ NameNotFoundException -> 0x0143, Exception -> 0x013e }
        r2.<init>();	 Catch:{ NameNotFoundException -> 0x0143, Exception -> 0x013e }
        r3 = "get left bitmap from ";
        r2 = r2.append(r3);	 Catch:{ NameNotFoundException -> 0x0143, Exception -> 0x013e }
        r3 = r8.f15591m;	 Catch:{ NameNotFoundException -> 0x0143, Exception -> 0x013e }
        r2 = r2.append(r3);	 Catch:{ NameNotFoundException -> 0x0143, Exception -> 0x013e }
        r2 = r2.toString();	 Catch:{ NameNotFoundException -> 0x0143, Exception -> 0x013e }
        com.huawei.android.pushagent.c.a.e.b(r0, r2);	 Catch:{ NameNotFoundException -> 0x0143, Exception -> 0x013e }
        r0 = r7.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0143, Exception -> 0x013e }
        r2 = r8.f15591m;	 Catch:{ NameNotFoundException -> 0x0143, Exception -> 0x013e }
        r0 = r0.getApplicationIcon(r2);	 Catch:{ NameNotFoundException -> 0x0143, Exception -> 0x013e }
        r0 = (android.graphics.drawable.BitmapDrawable) r0;	 Catch:{ NameNotFoundException -> 0x0143, Exception -> 0x013e }
        r0 = r0.getBitmap();	 Catch:{ NameNotFoundException -> 0x0143, Exception -> 0x013e }
        goto L_0x0005;
    L_0x00bb:
        r1 = r8.f15595q;	 Catch:{ NameNotFoundException -> 0x0100, Exception -> 0x011f }
        r1 = r2.m20459a(r7, r1);	 Catch:{ NameNotFoundException -> 0x0100, Exception -> 0x011f }
        r3 = "PushSelfShowLog";
        r4 = "get bitmap from new downloaded ";
        com.huawei.android.pushagent.c.a.e.a(r3, r4);	 Catch:{ NameNotFoundException -> 0x0100, Exception -> 0x011f }
        if (r1 == 0) goto L_0x00fc;
    L_0x00ca:
        r3 = "PushSelfShowLog";
        r4 = new java.lang.StringBuilder;	 Catch:{ NameNotFoundException -> 0x0100, Exception -> 0x011f }
        r4.<init>();	 Catch:{ NameNotFoundException -> 0x0100, Exception -> 0x011f }
        r5 = "height:";
        r4 = r4.append(r5);	 Catch:{ NameNotFoundException -> 0x0100, Exception -> 0x011f }
        r5 = r1.getHeight();	 Catch:{ NameNotFoundException -> 0x0100, Exception -> 0x011f }
        r4 = r4.append(r5);	 Catch:{ NameNotFoundException -> 0x0100, Exception -> 0x011f }
        r5 = ",width:";
        r4 = r4.append(r5);	 Catch:{ NameNotFoundException -> 0x0100, Exception -> 0x011f }
        r5 = r1.getWidth();	 Catch:{ NameNotFoundException -> 0x0100, Exception -> 0x011f }
        r4 = r4.append(r5);	 Catch:{ NameNotFoundException -> 0x0100, Exception -> 0x011f }
        r4 = r4.toString();	 Catch:{ NameNotFoundException -> 0x0100, Exception -> 0x011f }
        com.huawei.android.pushagent.c.a.e.a(r3, r4);	 Catch:{ NameNotFoundException -> 0x0100, Exception -> 0x011f }
        r3 = com.huawei.android.pushselfshow.p338c.C4153b.m20264a(r7);	 Catch:{ NameNotFoundException -> 0x0100, Exception -> 0x011f }
        r1 = r2.m20458a(r7, r1, r3, r3);	 Catch:{ NameNotFoundException -> 0x0100, Exception -> 0x011f }
    L_0x00fc:
        if (r1 != 0) goto L_0x0083;
    L_0x00fe:
        r1 = r0;
        goto L_0x0083;
    L_0x0100:
        r1 = move-exception;
    L_0x0101:
        r2 = "PushSelfShowLog";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "";
        r3 = r3.append(r4);
        r4 = r1.toString();
        r3 = r3.append(r4);
        r3 = r3.toString();
        com.huawei.android.pushagent.c.a.e.c(r2, r3, r1);
        goto L_0x0005;
    L_0x011f:
        r1 = move-exception;
    L_0x0120:
        r2 = "PushSelfShowLog";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "";
        r3 = r3.append(r4);
        r4 = r1.toString();
        r3 = r3.append(r4);
        r3 = r3.toString();
        com.huawei.android.pushagent.c.a.e.c(r2, r3, r1);
        goto L_0x0005;
    L_0x013e:
        r0 = move-exception;
        r6 = r0;
        r0 = r1;
        r1 = r6;
        goto L_0x0120;
    L_0x0143:
        r0 = move-exception;
        r6 = r0;
        r0 = r1;
        r1 = r6;
        goto L_0x0101;
    L_0x0148:
        r0 = r1;
        goto L_0x0005;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushselfshow.c.b.c(android.content.Context, com.huawei.android.pushselfshow.b.a):android.graphics.Bitmap");
    }
}
