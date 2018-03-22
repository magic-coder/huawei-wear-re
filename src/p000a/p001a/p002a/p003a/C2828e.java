package p000a.p001a.p002a.p003a;

import android.app.Notification;
import android.app.Notification.Action;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.widget.RemoteViews;
import java.util.ArrayList;
import p000a.p001a.p002a.p003a.C2831g.C2809a;

/* compiled from: NotificationCompatApi20 */
class C2828e {

    /* compiled from: NotificationCompatApi20 */
    public class C2827a implements C2807a, C2808b {
        private Builder f9202a;
        private Bundle f9203b;

        public C2827a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, ArrayList<String> arrayList, Bundle bundle, String str, boolean z5, String str2) {
            boolean z6;
            Builder lights = new Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
            if ((notification.flags & 2) != 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            lights = lights.setOngoing(z6);
            if ((notification.flags & 8) != 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            lights = lights.setOnlyAlertOnce(z6);
            if ((notification.flags & 16) != 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            lights = lights.setAutoCancel(z6).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
            if ((notification.flags & 128) != 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            this.f9202a = lights.setFullScreenIntent(pendingIntent2, z6).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z).setLocalOnly(z4).setGroup(str).setGroupSummary(z5).setSortKey(str2);
            this.f9203b = new Bundle();
            if (bundle != null) {
                this.f9203b.putAll(bundle);
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                this.f9203b.putStringArray(NotificationCompat.EXTRA_PEOPLE, (String[]) arrayList.toArray(new String[arrayList.size()]));
            }
        }

        public void mo3336a(C2809a c2809a) {
            C2828e.m12910a(this.f9202a, c2809a);
        }

        public Builder mo3335a() {
            return this.f9202a;
        }

        public Notification m12909b() {
            this.f9202a.setExtras(this.f9203b);
            return this.f9202a.build();
        }
    }

    public static void m12910a(Builder builder, C2809a c2809a) {
        Action.Builder builder2 = new Action.Builder(c2809a.mo3329a(), c2809a.mo3330b(), c2809a.mo3331c());
        if (c2809a.mo3333f() != null) {
            for (RemoteInput addRemoteInput : C2847o.m12939a(c2809a.mo3333f())) {
                builder2.addRemoteInput(addRemoteInput);
            }
        }
        if (c2809a.mo3332d() != null) {
            builder2.addExtras(c2809a.mo3332d());
        }
        builder.addAction(builder2.build());
    }
}
