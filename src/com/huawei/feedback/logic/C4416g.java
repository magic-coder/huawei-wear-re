package com.huawei.feedback.logic;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import com.huawei.feedback.FeedbackApi;
import com.huawei.feedback.d;
import com.huawei.feedback.ui.FeedbackDetailActivity;
import com.huawei.feedback.ui.FeedbackRecordActivity;
import com.huawei.hwid.core.constants.HwAccountConstants;

/* compiled from: FeedbackNotify */
public final class C4416g {
    public static void m21257a(Context context, int i, ContentValues contentValues) {
        Intent intent;
        if (1 == i || 6 == i) {
            intent = new Intent(context, FeedbackRecordActivity.class);
            intent.setFlags(335544320);
        } else if (4 == i) {
            intent = new Intent(context, FeedbackDetailActivity.class);
            if (contentValues != null) {
                intent.putExtra("pQuestionId", contentValues.getAsString("pQuestionId"));
            }
            intent.setFlags(335544320);
        } else if (5 == i) {
            intent = new Intent(context, FeedbackDetailActivity.class);
            if (contentValues != null) {
                intent.putExtra("pQuestionId", contentValues.getAsString("pQuestionId"));
            }
            intent.setFlags(335544320);
        } else {
            intent = new Intent();
        }
        C4416g.m21256a(context, i, PendingIntent.getActivity(context, 0, intent, HwAccountConstants.FLAG_TRANS_NAVIGATION_BAR));
    }

    public static void m21256a(Context context, int i, PendingIntent pendingIntent) {
        CharSequence string;
        int e;
        int i2;
        switch (i) {
            case 0:
                string = context.getString(d.b(context, "feedback_sending_your_feedback"));
                e = d.e(context, "feedback_sending");
                i2 = 1001;
                break;
            case 1:
                string = context.getString(d.b(context, "feedback_send_withlog_successfully"));
                e = d.e(context, "feedback_success");
                i2 = 1002;
                break;
            case 4:
                string = context.getString(d.b(context, "feedback_send__feedback_failed"));
                e = d.e(context, "feedback_send_failed");
                i2 = 1005;
                break;
            case 5:
                string = context.getString(d.b(context, "feedback_send_nolog_successfully"));
                e = d.e(context, "feedback_success");
                i2 = 1006;
                break;
            case 6:
                string = context.getString(d.b(context, "feedback_send_nolog_successfully"));
                e = d.e(context, "feedback_success");
                i2 = 1007;
                break;
            default:
                return;
        }
        Notification build = new Builder(context).setContentTitle(context.getString(d.b(context, "feedback_dialog_title"))).setContentText(string).setContentIntent(pendingIntent).setSmallIcon(e).setTicker(string).setDefaults(1).setWhen(System.currentTimeMillis()).build();
        build.flags |= 16;
        C4416g.m21255a().notify(i2, build);
    }

    public static NotificationManager m21255a() {
        NotificationManager notificationManager = (NotificationManager) FeedbackApi.getApplicationcontext().getSystemService("notification");
        notificationManager.cancel(1001);
        notificationManager.cancel(1002);
        notificationManager.cancel(1003);
        notificationManager.cancel(1004);
        notificationManager.cancel(1005);
        notificationManager.cancel(1006);
        notificationManager.cancel(1007);
        return notificationManager;
    }

    public static void m21258b() {
        NotificationManager notificationManager = (NotificationManager) FeedbackApi.getApplicationcontext().getSystemService("notification");
        notificationManager.cancel(1002);
        notificationManager.cancel(1007);
    }

    public static void m21259c() {
        NotificationManager notificationManager = (NotificationManager) FeedbackApi.getApplicationcontext().getSystemService("notification");
        notificationManager.cancel(1005);
        notificationManager.cancel(1006);
    }

    public static void m21260d() {
        NotificationManager notificationManager = (NotificationManager) FeedbackApi.getApplicationcontext().getSystemService("notification");
        notificationManager.cancel(1003);
        notificationManager.cancel(1004);
    }
}
