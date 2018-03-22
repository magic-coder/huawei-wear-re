package com.huawei.android.pushselfshow.p338c;

import android.app.Notification;
import android.app.Notification.BigPictureStyle;
import android.app.Notification.Builder;
import android.app.Notification.InboxStyle;
import android.app.Notification.Style;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushselfshow.p337b.C4149a;
import com.huawei.android.pushselfshow.utils.C4203a;
import com.huawei.android.pushselfshow.utils.C4211e;
import com.huawei.android.pushselfshow.utils.p347c.C4209a;
import com.huawei.crowdtestsdk.utils.ResUtil;
import com.huawei.hwid.core.constants.HwAccountConstants;
import java.security.SecureRandom;
import java.util.Date;

public class C4154c {
    public static Builder m20274a(Context context, Builder builder, int i, C4149a c4149a, Bitmap bitmap) {
        e.a("PushSelfShowLog", "Notification addStyle");
        if (context == null || builder == null || c4149a == null) {
            return builder;
        }
        C4152a c4152a = C4152a.STYLE_1;
        if (c4149a.f15570K >= 0 && c4149a.f15570K < C4152a.values().length) {
            c4152a = C4152a.values()[c4149a.f15570K];
        }
        switch (C4155d.f15619a[c4152a.ordinal()]) {
            case 1:
            case 3:
                return builder;
            case 2:
                builder.setContent(C4154c.m20277a(context, i, bitmap, c4149a));
                return builder;
            case 4:
                builder.setContent(C4154c.m20283b(context, i, bitmap, c4149a));
                return builder;
            case 5:
                C4154c.m20281a(context, builder, i, bitmap, c4149a);
                return builder;
            case 6:
                return !C4154c.m20284b(context, builder, i, bitmap, c4149a) ? null : builder;
            case 7:
                builder.setContent(C4154c.m20285c(context, i, bitmap, c4149a));
                return builder;
            case 8:
                RemoteViews a = C4154c.m20278a(context, bitmap, c4149a);
                if (a == null) {
                    return null;
                }
                builder.setContent(a);
                return builder;
            default:
                return builder;
        }
    }

    public static Notification m20275a(Context context, Notification notification, int i, C4149a c4149a, Bitmap bitmap) {
        if (notification == null || c4149a == null) {
            return notification;
        }
        C4152a c4152a = C4152a.STYLE_1;
        if (c4149a.f15570K >= 0 && c4149a.f15570K < C4152a.values().length) {
            c4152a = C4152a.values()[c4149a.f15570K];
        }
        switch (C4155d.f15619a[c4152a.ordinal()]) {
            case 1:
            case 3:
            case 5:
            case 6:
                return notification;
            case 2:
                notification.contentView = C4154c.m20277a(context, i, bitmap, c4149a);
                return notification;
            case 4:
                notification.contentView = C4154c.m20283b(context, i, bitmap, c4149a);
                return notification;
            case 7:
                notification.contentView = C4154c.m20285c(context, i, bitmap, c4149a);
                return notification;
            case 8:
                RemoteViews a = C4154c.m20278a(context, bitmap, c4149a);
                if (a == null) {
                    return null;
                }
                notification.contentView = a;
                return notification;
            default:
                return notification;
        }
    }

    private static PendingIntent m20276a(Context context, int i, String str) {
        Intent flags = new Intent("com.huawei.android.push.intent.CLICK").setPackage(context.getPackageName()).setFlags(32);
        flags.putExtra("notifyId", i);
        flags.putExtra("clickBtn", str);
        int hashCode = (context.getPackageName() + str + new SecureRandom().nextInt() + new Date().toString()).hashCode();
        e.a("PushSelfShowLog", "getPendingIntent,requestCode:" + hashCode);
        return PendingIntent.getBroadcast(context, hashCode, flags, HwAccountConstants.FLAG_TRANS_NAVIGATION_BAR);
    }

    private static RemoteViews m20277a(Context context, int i, Bitmap bitmap, C4149a c4149a) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), C4211e.m20462b(context, "hwpush_layout2"));
        C4154c.m20282a(context, bitmap, remoteViews);
        C4154c.m20280a(context, i, remoteViews, c4149a);
        remoteViews.setTextViewText(C4211e.m20463c(context, "title"), C4154c.m20279a(context, c4149a));
        remoteViews.setTextViewText(C4211e.m20463c(context, "text"), c4149a.f15594p);
        return remoteViews;
    }

    private static RemoteViews m20278a(Context context, Bitmap bitmap, C4149a c4149a) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), C4211e.m20461a(context, ResUtil.TYPE_LAYOUT, "hwpush_layout8"));
        Bitmap a = !TextUtils.isEmpty(c4149a.f15578S) ? new C4209a().m20459a(context, c4149a.f15578S) : null;
        if (a == null) {
            return null;
        }
        remoteViews.setViewVisibility(C4211e.m20461a(context, "id", "big_pic"), 0);
        remoteViews.setImageViewBitmap(C4211e.m20461a(context, "id", "big_pic"), a);
        return remoteViews;
    }

    private static String m20279a(Context context, C4149a c4149a) {
        if (context == null || c4149a == null) {
            return "";
        }
        if (!TextUtils.isEmpty(c4149a.f15596r)) {
            return c4149a.f15596r;
        }
        return context.getResources().getString(context.getApplicationInfo().labelRes);
    }

    private static void m20280a(Context context, int i, RemoteViews remoteViews, C4149a c4149a) {
        if (context == null || remoteViews == null || c4149a == null) {
            e.c("PushSelfShowLog", "showRightBtn error");
        } else if ((C4152a.STYLE_2.ordinal() == c4149a.f15570K || C4152a.STYLE_3.ordinal() == c4149a.f15570K || C4152a.STYLE_4.ordinal() == c4149a.f15570K) && !TextUtils.isEmpty(c4149a.f15572M[0]) && !TextUtils.isEmpty(c4149a.f15574O[0])) {
            int a = C4211e.m20461a(context, "id", "right_btn");
            remoteViews.setViewVisibility(a, 0);
            remoteViews.setTextViewText(a, c4149a.f15572M[0]);
            remoteViews.setOnClickPendingIntent(a, C4154c.m20276a(context, i, c4149a.f15574O[0]));
        }
    }

    private static void m20281a(Context context, Builder builder, int i, Bitmap bitmap, C4149a c4149a) {
        if (c4149a == null || c4149a.f15594p == null) {
            e.b("PushSelfShowLog", "msg is null");
        } else if (!TextUtils.isEmpty(c4149a.f15594p) && c4149a.f15594p.contains("##")) {
            builder.setTicker(c4149a.f15594p.replace("##", "，"));
            if (C4203a.m20434c()) {
                builder.setLargeIcon(bitmap);
                builder.setContentTitle(C4154c.m20279a(context, c4149a));
                Style inboxStyle = new InboxStyle();
                String[] split = c4149a.f15594p.split("##");
                int length = split.length;
                if (length > 4) {
                    length = 4;
                }
                if (!TextUtils.isEmpty(c4149a.f15577R)) {
                    inboxStyle.setBigContentTitle(c4149a.f15577R);
                    builder.setContentText(c4149a.f15577R);
                    if (4 == length) {
                        length--;
                    }
                }
                for (int i2 = 0; i2 < length; i2++) {
                    inboxStyle.addLine(split[i2]);
                }
                if (c4149a.f15572M != null && c4149a.f15572M.length > 0) {
                    length = 0;
                    while (length < c4149a.f15572M.length) {
                        if (!(TextUtils.isEmpty(c4149a.f15572M[length]) || TextUtils.isEmpty(c4149a.f15574O[length]))) {
                            builder.addAction(0, c4149a.f15572M[length], C4154c.m20276a(context, i, c4149a.f15574O[length]));
                        }
                        length++;
                    }
                }
                builder.setStyle(inboxStyle);
                return;
            }
            builder.setContentText(c4149a.f15594p.replace("##", "，"));
        }
    }

    private static void m20282a(Context context, Bitmap bitmap, RemoteViews remoteViews) {
        if (context != null && remoteViews != null && C4203a.m20431b()) {
            if (bitmap == null) {
                int i = context.getApplicationInfo().icon;
                if (i == 0) {
                    i = context.getResources().getIdentifier("btn_star_big_on", ResUtil.TYPE_DRAWABLE, "android");
                    if (i == 0) {
                        i = 17301651;
                    }
                }
                remoteViews.setImageViewResource(C4211e.m20461a(context, "id", "icon"), i);
                return;
            }
            remoteViews.setImageViewBitmap(C4211e.m20461a(context, "id", "icon"), bitmap);
        }
    }

    private static RemoteViews m20283b(Context context, int i, Bitmap bitmap, C4149a c4149a) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), C4211e.m20462b(context, "hwpush_layout4"));
        C4154c.m20282a(context, bitmap, remoteViews);
        C4154c.m20280a(context, i, remoteViews, c4149a);
        remoteViews.setTextViewText(C4211e.m20463c(context, "title"), C4154c.m20279a(context, c4149a));
        if (c4149a.f15576Q == null || c4149a.f15576Q.length <= 0) {
            return remoteViews;
        }
        C4209a c4209a = new C4209a();
        remoteViews.removeAllViews(C4211e.m20463c(context, "linear_icons"));
        Bitmap bitmap2 = null;
        for (int i2 = 0; i2 < c4149a.f15576Q.length; i2++) {
            RemoteViews remoteViews2 = new RemoteViews(context.getPackageName(), C4211e.m20461a(context, ResUtil.TYPE_LAYOUT, "hwpush_icons_layout"));
            if (!TextUtils.isEmpty(c4149a.f15576Q[i2])) {
                bitmap2 = c4209a.m20459a(context, c4149a.f15576Q[i2]);
            }
            if (bitmap2 != null) {
                e.a("PushSelfShowLog", "rescale bitmap success");
                remoteViews2.setImageViewBitmap(C4211e.m20461a(context, "id", "smallicon"), bitmap2);
                remoteViews.addView(C4211e.m20461a(context, "id", "linear_icons"), remoteViews2);
            }
        }
        return remoteViews;
    }

    private static boolean m20284b(Context context, Builder builder, int i, Bitmap bitmap, C4149a c4149a) {
        builder.setContentTitle(C4154c.m20279a(context, c4149a));
        builder.setContentText(c4149a.f15594p);
        builder.setLargeIcon(bitmap);
        if (!C4203a.m20434c()) {
            return true;
        }
        C4209a c4209a = new C4209a();
        Bitmap bitmap2 = null;
        if (!TextUtils.isEmpty(c4149a.f15578S)) {
            bitmap2 = c4209a.m20459a(context, c4149a.f15578S);
        }
        if (bitmap2 == null) {
            return false;
        }
        Style bigPictureStyle = new BigPictureStyle();
        bigPictureStyle.bigPicture(bitmap2);
        int i2 = 0;
        while (i2 < c4149a.f15572M.length) {
            if (!(TextUtils.isEmpty(c4149a.f15572M[i2]) || TextUtils.isEmpty(c4149a.f15574O[i2]))) {
                builder.addAction(0, c4149a.f15572M[i2], C4154c.m20276a(context, i, c4149a.f15574O[i2]));
            }
            i2++;
        }
        builder.setStyle(bigPictureStyle);
        return true;
    }

    private static RemoteViews m20285c(Context context, int i, Bitmap bitmap, C4149a c4149a) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), C4211e.m20461a(context, ResUtil.TYPE_LAYOUT, "hwpush_layout7"));
        C4154c.m20282a(context, bitmap, remoteViews);
        remoteViews.setTextViewText(C4211e.m20461a(context, "id", "title"), C4154c.m20279a(context, c4149a));
        remoteViews.setTextViewText(C4211e.m20461a(context, "id", "text"), c4149a.f15594p);
        if (c4149a.f15573N == null || c4149a.f15573N.length <= 0 || c4149a.f15574O == null || c4149a.f15574O.length <= 0 || c4149a.f15573N.length != c4149a.f15574O.length) {
            return remoteViews;
        }
        C4209a c4209a = new C4209a();
        remoteViews.removeAllViews(C4211e.m20461a(context, "id", "linear_buttons"));
        int i2 = 0;
        while (i2 < c4149a.f15573N.length) {
            RemoteViews remoteViews2 = new RemoteViews(context.getPackageName(), C4211e.m20461a(context, ResUtil.TYPE_LAYOUT, "hwpush_buttons_layout"));
            Bitmap bitmap2 = null;
            if (!TextUtils.isEmpty(c4149a.f15573N[i2])) {
                bitmap2 = c4209a.m20459a(context, c4149a.f15573N[i2]);
            }
            if (!(bitmap2 == null || TextUtils.isEmpty(c4149a.f15574O[i2]))) {
                int a = C4211e.m20461a(context, "id", "small_btn");
                remoteViews2.setImageViewBitmap(a, bitmap2);
                remoteViews2.setOnClickPendingIntent(a, C4154c.m20276a(context, i, c4149a.f15574O[i2]));
                remoteViews.addView(C4211e.m20461a(context, "id", "linear_buttons"), remoteViews2);
            }
            i2++;
        }
        return remoteViews;
    }
}
