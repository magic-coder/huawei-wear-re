package p000a.p001a.p002a.p003a;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;

/* compiled from: NotificationCompatGingerbread */
class C2832h {
    public static Notification m12914a(Notification notification, Context context, CharSequence charSequence, CharSequence charSequence2, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        notification.setLatestEventInfo(context, charSequence, charSequence2, pendingIntent);
        notification.fullScreenIntent = pendingIntent2;
        return notification;
    }
}
