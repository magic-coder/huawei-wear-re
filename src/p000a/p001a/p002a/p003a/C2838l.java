package p000a.p001a.p002a.p003a;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompatExtras;
import android.support.v4.app.NotificationManagerCompat;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.List;
import p000a.p001a.p002a.p003a.C2831g.C2809a;

/* compiled from: NotificationCompatKitKat */
class C2838l {

    /* compiled from: NotificationCompatKitKat */
    public class C2837a implements C2807a, C2808b {
        private Builder f9212a;
        private Bundle f9213b;
        private List<Bundle> f9214c = new ArrayList();

        public C2837a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, ArrayList<String> arrayList, Bundle bundle, String str, boolean z5, String str2) {
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
            this.f9212a = lights.setFullScreenIntent(pendingIntent2, z6).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z);
            this.f9213b = new Bundle();
            if (bundle != null) {
                this.f9213b.putAll(bundle);
            }
            if (!(arrayList == null || arrayList.isEmpty())) {
                this.f9213b.putStringArray(NotificationCompat.EXTRA_PEOPLE, (String[]) arrayList.toArray(new String[arrayList.size()]));
            }
            if (z4) {
                this.f9213b.putBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY, true);
            }
            if (str != null) {
                this.f9213b.putString(NotificationCompatExtras.EXTRA_GROUP_KEY, str);
                if (z5) {
                    this.f9213b.putBoolean(NotificationCompatExtras.EXTRA_GROUP_SUMMARY, true);
                } else {
                    this.f9213b.putBoolean(NotificationManagerCompat.EXTRA_USE_SIDE_CHANNEL, true);
                }
            }
            if (str2 != null) {
                this.f9213b.putString(NotificationCompatExtras.EXTRA_SORT_KEY, str2);
            }
        }

        public void mo3336a(C2809a c2809a) {
            this.f9214c.add(C2836k.m12920a(this.f9212a, c2809a));
        }

        public Builder mo3335a() {
            return this.f9212a;
        }

        public Notification m12928b() {
            SparseArray a = C2836k.m12922a(this.f9214c);
            if (a != null) {
                this.f9213b.putSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS, a);
            }
            this.f9212a.setExtras(this.f9213b);
            return this.f9212a.build();
        }
    }
}
