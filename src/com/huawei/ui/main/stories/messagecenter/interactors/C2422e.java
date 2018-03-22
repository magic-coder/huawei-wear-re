package com.huawei.ui.main.stories.messagecenter.interactors;

import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.os.Build.VERSION;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.p190v.C2538c;
import com.huawei.pluginmessagecenter.a;
import com.huawei.pluginmessagecenter.a.b;
import com.huawei.pluginmessagecenter.a.g;
import com.huawei.pluginmessagecenter.provider.data.MessageObject;
import com.huawei.ui.main.e;
import com.huawei.ui.main.h;
import com.huawei.ui.main.stories.messagecenter.activity.DispatchSkipEventActivity;
import java.util.Date;

/* compiled from: MCNotificationManager */
public class C2422e {
    private Context f8710a;
    private MessageObject f8711b;

    public C2422e(Context context) {
        this.f8710a = context;
    }

    public C2422e(Context context, MessageObject messageObject) {
        this.f8710a = context;
        this.f8711b = messageObject;
    }

    public void m12173a() {
        if (this.f8710a != null && this.f8711b != null) {
            if (m12167b(this.f8711b) && (m12169c(this.f8711b) || m12170d(this.f8711b))) {
                g.c("MCNotificationManager", "showNotification cancelNotification !!!");
                m12174a(m12171a(this.f8711b));
            }
            if (m12167b(this.f8711b) && !m12168c(this.f8711b.getReadFlag()) && !m12169c(this.f8711b) && this.f8711b.getNotified() != 1) {
                try {
                    Context context = this.f8710a;
                    Context context2 = this.f8710a;
                    NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                    Builder builder = new Builder(this.f8710a);
                    builder.setContentTitle(this.f8711b.getMsgTitle()).setContentText(this.f8711b.getMsgContent()).setContentIntent(m12172a(this.f8711b.getDetailUri(), this.f8711b.getMsgId())).setTicker(this.f8711b.getMsgTitle()).setNumber(this.f8711b.getWeight()).setWhen(this.f8711b.getCreateTime()).setPriority(0).setAutoCancel(true).setOngoing(false).setDefaults(2);
                    if (VERSION.SDK_INT >= 23) {
                        builder.setSmallIcon(m12166b(e.ic_wear_notification_small_icon));
                    } else {
                        builder.setSmallIcon(h.app_icon);
                    }
                    BitmapDrawable bitmapDrawable = (BitmapDrawable) this.f8710a.getApplicationInfo().loadIcon(this.f8710a.getPackageManager());
                    if (bitmapDrawable != null) {
                        builder.setLargeIcon(bitmapDrawable.getBitmap());
                    }
                    notificationManager.notify(m12171a(this.f8711b), builder.build());
                    a.a(this.f8710a).d(this.f8711b.getMsgId());
                    long currentTimeMillis = System.currentTimeMillis();
                    g.c("MCNotificationManager", "showNotification setReceiveTime = " + currentTimeMillis + " receiveDate = " + new Date(currentTimeMillis));
                    a.a(this.f8710a).a(this.f8711b.getMsgId(), currentTimeMillis);
                } catch (NumberFormatException e) {
                    g.b("MCNotificationManager", e.getMessage());
                } catch (NotFoundException e2) {
                    g.b("MCNotificationManager", e2.getMessage());
                }
            }
        }
    }

    public void m12175a(long j) {
        C2538c.m12677c("MCNotificationManager", "start_showNotification");
        if (this.f8710a == null || this.f8711b == null) {
            C2538c.m12677c("MCNotificationManager", "return");
            return;
        }
        try {
            Context context = this.f8710a;
            Context context2 = this.f8710a;
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            C2538c.m12677c("MCNotificationManager", "mContext_getSystemService");
            Builder builder = new Builder(this.f8710a);
            C2538c.m12677c("MCNotificationManager", "mBuilder =  " + builder);
            C2538c.m12677c("MCNotificationManager", "msgObj.getMsgTitle() " + this.f8711b.getMsgTitle());
            C2538c.m12677c("MCNotificationManager", "msgObj.getMsgContent() " + this.f8711b.getMsgContent());
            C2538c.m12677c("MCNotificationManager", "msgObj.getDetailUri() " + this.f8711b.getDetailUri());
            C2538c.m12677c("MCNotificationManager", "msgObj.getMsgId() " + this.f8711b.getMsgId());
            C2538c.m12677c("MCNotificationManager", "msgObj.getWeight() " + this.f8711b.getWeight());
            C2538c.m12677c("MCNotificationManager", "msgObj.getCreateTime() " + this.f8711b.getCreateTime());
            builder.setContentTitle(this.f8711b.getMsgTitle()).setContentText(this.f8711b.getMsgContent()).setContentIntent(m12172a(this.f8711b.getDetailUri(), this.f8711b.getMsgId())).setTicker(this.f8711b.getMsgTitle()).setNumber(this.f8711b.getWeight()).setWhen(this.f8711b.getCreateTime()).setPriority(0).setAutoCancel(true).setOngoing(false).setDefaults(2);
            C2538c.m12677c("MCNotificationManager", "Builder_setMess");
            if (VERSION.SDK_INT >= 23) {
                builder.setSmallIcon(m12166b(e.ic_wear_notification_small_icon));
            } else {
                builder.setSmallIcon(h.app_icon);
            }
            BitmapDrawable bitmapDrawable = (BitmapDrawable) this.f8710a.getApplicationInfo().loadIcon(this.f8710a.getPackageManager());
            if (bitmapDrawable != null) {
                builder.setLargeIcon(bitmapDrawable.getBitmap());
            }
            C2538c.m12677c("MCNotificationManager", "getMessageNotifyId  ==" + j);
            notificationManager.notify((int) j, builder.build());
            C2538c.m12677c("MCNotificationManager", "end_showNotification");
        } catch (NumberFormatException e) {
            g.b("MCNotificationManager", e.getMessage());
        } catch (NotFoundException e2) {
            g.b("MCNotificationManager", e2.getMessage());
        }
    }

    private Icon m12166b(int i) {
        C2538c.m12677c("MCNotificationManager", "Enter getBitmapIcon!");
        Drawable drawable = this.f8710a.getResources().getDrawable(i);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Config.ARGB_8888 : Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        if (VERSION.SDK_INT >= 23) {
            C2538c.m12677c("MCNotificationManager", "Leave getBitmapIcon android.os.Build.VERSION.SDK_INT >= 23 not null!");
            return Icon.createWithBitmap(createBitmap);
        }
        C2538c.m12677c("MCNotificationManager", "Leave getBitmapIcon is null!");
        return null;
    }

    private boolean m12168c(int i) {
        return i == 1;
    }

    private boolean m12167b(MessageObject messageObject) {
        return messageObject.getPosition() == 2 || messageObject.getPosition() == 3;
    }

    private boolean m12169c(MessageObject messageObject) {
        return messageObject.getExpireTime() < System.currentTimeMillis();
    }

    private boolean m12170d(MessageObject messageObject) {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        g.c("MCNotificationManager", "checkNotifyMessage24hExpire currentTime = " + currentTimeMillis + "  utcTime = " + b.a(currentTimeMillis) + "curDate = " + new Date(currentTimeMillis));
        long receiveTime = messageObject.getReceiveTime() + 86400000;
        g.c("MCNotificationManager", "checkNotifyMessage24hExpire expireTime = " + receiveTime + "expireTime Date = " + new Date(receiveTime));
        if (currentTimeMillis >= receiveTime) {
            z = true;
        } else {
            z = false;
        }
        C2538c.m12677c("MCNotificationManager", "checkNotifyMessage24hExpire result = " + z);
        return z;
    }

    public int m12171a(MessageObject messageObject) {
        if (messageObject == null) {
            return 0;
        }
        int createTime = ((int) (messageObject.getCreateTime() / 1000)) - 1476028800;
        g.c("MCNotificationManager", "getMessageNotifyId notifyId = " + createTime);
        return createTime;
    }

    public PendingIntent m12172a(String str, String str2) {
        g.a("MCNotificationManager", "detailUri=====>" + str);
        Intent intent = new Intent();
        intent.setClass(this.f8710a, DispatchSkipEventActivity.class);
        intent.putExtra("detailUri", str);
        intent.putExtra("msgId", str2);
        int i = 0;
        try {
            i = Integer.parseInt(this.f8711b.getMsgId().substring(1));
        } catch (NumberFormatException e) {
            g.b("MCNotificationManager", e.getMessage());
        }
        return PendingIntent.getActivity(this.f8710a, i, intent, HwAccountConstants.FLAG_TRANS_NAVIGATION_BAR);
    }

    public void m12174a(int i) {
        C2538c.m12677c("MCNotificationManager", "Enter cancelNotification");
        try {
            ((NotificationManager) BaseApplication.m2632b().getSystemService("notification")).cancel(i);
        } catch (Exception e) {
            C2538c.m12677c("MCNotificationManager", "error cancelNotification" + e.getMessage());
        }
    }
}
