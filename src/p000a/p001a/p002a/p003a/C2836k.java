package p000a.p001a.p002a.p003a;

import android.app.Notification;
import android.app.Notification.BigPictureStyle;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.Notification.InboxStyle;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.NotificationCompatExtras;
import android.support.v4.app.NotificationCompatJellybean;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p000a.p001a.p002a.p003a.C2831g.C2809a;

/* compiled from: NotificationCompatJellybean */
class C2836k {
    private static final Object f9208a = new Object();
    private static Field f9209b;
    private static boolean f9210c;
    private static final Object f9211d = new Object();

    /* compiled from: NotificationCompatJellybean */
    public class C2835a implements C2807a, C2808b {
        private Builder f9205a;
        private final Bundle f9206b;
        private List<Bundle> f9207c = new ArrayList();

        public C2835a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, int i4, CharSequence charSequence4, boolean z3, Bundle bundle, String str, boolean z4, String str2) {
            boolean z5;
            Builder lights = new Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
            if ((notification.flags & 2) != 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            lights = lights.setOngoing(z5);
            if ((notification.flags & 8) != 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            lights = lights.setOnlyAlertOnce(z5);
            if ((notification.flags & 16) != 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            lights = lights.setAutoCancel(z5).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
            if ((notification.flags & 128) != 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            this.f9205a = lights.setFullScreenIntent(pendingIntent2, z5).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z2).setPriority(i4).setProgress(i2, i3, z);
            this.f9206b = new Bundle();
            if (bundle != null) {
                this.f9206b.putAll(bundle);
            }
            if (z3) {
                this.f9206b.putBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY, true);
            }
            if (str != null) {
                this.f9206b.putString(NotificationCompatExtras.EXTRA_GROUP_KEY, str);
                if (z4) {
                    this.f9206b.putBoolean(NotificationCompatExtras.EXTRA_GROUP_SUMMARY, true);
                } else {
                    this.f9206b.putBoolean(NotificationManagerCompat.EXTRA_USE_SIDE_CHANNEL, true);
                }
            }
            if (str2 != null) {
                this.f9206b.putString(NotificationCompatExtras.EXTRA_SORT_KEY, str2);
            }
        }

        public void mo3336a(C2809a c2809a) {
            this.f9207c.add(C2836k.m12920a(this.f9205a, c2809a));
        }

        public Builder mo3335a() {
            return this.f9205a;
        }

        public Notification m12919b() {
            Notification build = this.f9205a.build();
            Bundle a = C2836k.m12921a(build);
            Bundle bundle = new Bundle(this.f9206b);
            for (String str : this.f9206b.keySet()) {
                if (a.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            a.putAll(bundle);
            SparseArray a2 = C2836k.m12922a(this.f9207c);
            if (a2 != null) {
                C2836k.m12921a(build).putSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS, a2);
            }
            return build;
        }
    }

    public static void m12924a(C2808b c2808b, CharSequence charSequence, boolean z, CharSequence charSequence2, CharSequence charSequence3) {
        BigTextStyle bigText = new BigTextStyle(c2808b.mo3335a()).setBigContentTitle(charSequence).bigText(charSequence3);
        if (z) {
            bigText.setSummaryText(charSequence2);
        }
    }

    public static void m12923a(C2808b c2808b, CharSequence charSequence, boolean z, CharSequence charSequence2, Bitmap bitmap, Bitmap bitmap2, boolean z2) {
        BigPictureStyle bigPicture = new BigPictureStyle(c2808b.mo3335a()).setBigContentTitle(charSequence).bigPicture(bitmap);
        if (z2) {
            bigPicture.bigLargeIcon(bitmap2);
        }
        if (z) {
            bigPicture.setSummaryText(charSequence2);
        }
    }

    public static void m12925a(C2808b c2808b, CharSequence charSequence, boolean z, CharSequence charSequence2, ArrayList<CharSequence> arrayList) {
        InboxStyle bigContentTitle = new InboxStyle(c2808b.mo3335a()).setBigContentTitle(charSequence);
        if (z) {
            bigContentTitle.setSummaryText(charSequence2);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            bigContentTitle.addLine((CharSequence) it.next());
        }
    }

    public static SparseArray<Bundle> m12922a(List<Bundle> list) {
        SparseArray<Bundle> sparseArray = null;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Bundle bundle = (Bundle) list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    public static Bundle m12921a(Notification notification) {
        synchronized (f9208a) {
            if (f9210c) {
                return null;
            }
            try {
                if (f9209b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (Bundle.class.isAssignableFrom(declaredField.getType())) {
                        declaredField.setAccessible(true);
                        f9209b = declaredField;
                    } else {
                        Log.e(NotificationCompatJellybean.TAG, "Notification.extras field is not of type Bundle");
                        f9210c = true;
                        return null;
                    }
                }
                Bundle bundle = (Bundle) f9209b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f9209b.set(notification, bundle);
                }
                return bundle;
            } catch (Throwable e) {
                Log.e(NotificationCompatJellybean.TAG, "Unable to access notification extras", e);
                f9210c = true;
                return null;
            } catch (Throwable e2) {
                Log.e(NotificationCompatJellybean.TAG, "Unable to access notification extras", e2);
                f9210c = true;
                return null;
            }
        }
    }

    public static Bundle m12920a(Builder builder, C2809a c2809a) {
        builder.addAction(c2809a.mo3329a(), c2809a.mo3330b(), c2809a.mo3331c());
        Bundle bundle = new Bundle(c2809a.mo3332d());
        if (c2809a.mo3333f() != null) {
            bundle.putParcelableArray(NotificationCompatExtras.EXTRA_REMOTE_INPUTS, C2849q.m12941a(c2809a.mo3333f()));
        }
        return bundle;
    }
}
