package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ProgressBar;
import com.google.android.gms.b;
import com.google.android.gms.c;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.internal.C0424f;
import com.google.android.gms.common.internal.C0445z;
import com.google.android.gms.common.internal.aa;
import com.google.android.gms.common.util.C0462g;
import com.google.android.gms.common.util.C0467l;
import com.google.android.gms.internal.bi;
import com.google.android.gms.internal.bn;
import com.google.android.gms.internal.zzaaz;

public class C0389b extends C0388h {
    public static final int f306a = C0388h.f305b;
    private static final C0389b f307c = new C0389b();

    C0389b() {
    }

    public static C0389b m424a() {
        return f307c;
    }

    public int mo1742a(Context context) {
        return super.mo1742a(context);
    }

    public Dialog m426a(Activity activity, int i, int i2, OnCancelListener onCancelListener) {
        return m428a((Context) activity, i, aa.m519a(activity, mo1747b(activity, i, "d"), i2), onCancelListener);
    }

    public Dialog m427a(Activity activity, OnCancelListener onCancelListener) {
        View progressBar = new ProgressBar(activity, null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        Builder builder = new Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(C0445z.m771c(activity, 18));
        builder.setPositiveButton("", null);
        Dialog create = builder.create();
        m433a(activity, create, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return create;
    }

    Dialog m428a(Context context, int i, aa aaVar, OnCancelListener onCancelListener) {
        Builder builder = null;
        if (i == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843529, typedValue, true);
        if ("Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId))) {
            builder = new Builder(context, 5);
        }
        if (builder == null) {
            builder = new Builder(context);
        }
        builder.setMessage(C0445z.m771c(context, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        CharSequence e = C0445z.m773e(context, i);
        if (e != null) {
            builder.setPositiveButton(e, aaVar);
        }
        e = C0445z.m767a(context, i);
        if (e != null) {
            builder.setTitle(e);
        }
        return builder.create();
    }

    @Nullable
    public PendingIntent mo1743a(Context context, int i, int i2) {
        return super.mo1743a(context, i, i2);
    }

    @Nullable
    public PendingIntent mo1744a(Context context, int i, int i2, @Nullable String str) {
        return super.mo1744a(context, i, i2, str);
    }

    @Nullable
    public PendingIntent m431a(Context context, ConnectionResult connectionResult) {
        return connectionResult.hasResolution() ? connectionResult.getResolution() : mo1743a(context, connectionResult.getErrorCode(), 0);
    }

    @Nullable
    public zzaaz m432a(Context context, bi biVar) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        BroadcastReceiver com_google_android_gms_internal_zzaaz = new zzaaz(biVar);
        context.registerReceiver(com_google_android_gms_internal_zzaaz, intentFilter);
        com_google_android_gms_internal_zzaaz.m1635a(context);
        if (m418a(context, "com.google.android.gms")) {
            return com_google_android_gms_internal_zzaaz;
        }
        biVar.mo1833a();
        com_google_android_gms_internal_zzaaz.m1634a();
        return null;
    }

    void m433a(Activity activity, Dialog dialog, String str, OnCancelListener onCancelListener) {
        boolean z;
        try {
            z = activity instanceof FragmentActivity;
        } catch (NoClassDefFoundError e) {
            z = false;
        }
        if (z) {
            C0405e.m487a(dialog, onCancelListener).show(((FragmentActivity) activity).getSupportFragmentManager(), str);
            return;
        }
        C0365a.m326a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    public void m434a(Context context, int i) {
        m435a(context, i, null);
    }

    public void m435a(Context context, int i, String str) {
        m436a(context, i, str, mo1744a(context, i, 0, "n"));
    }

    @TargetApi(20)
    void m436a(Context context, int i, String str, PendingIntent pendingIntent) {
        if (i == 18) {
            m442b(context);
        } else if (pendingIntent != null) {
            Notification build;
            int i2;
            CharSequence b = C0445z.m770b(context, i);
            CharSequence d = C0445z.m772d(context, i);
            Resources resources = context.getResources();
            if (C0462g.m818b(context)) {
                C0424f.m654a(C0467l.m830f());
                build = new Notification.Builder(context).setSmallIcon(context.getApplicationInfo().icon).setPriority(2).setAutoCancel(true).setContentTitle(b).setStyle(new BigTextStyle().bigText(d)).addAction(b.common_full_open_on_phone, resources.getString(c.common_open_on_phone), pendingIntent).build();
            } else {
                build = new NotificationCompat.Builder(context).setSmallIcon(17301642).setTicker(resources.getString(c.common_google_play_services_notification_ticker)).setWhen(System.currentTimeMillis()).setAutoCancel(true).setContentIntent(pendingIntent).setContentTitle(b).setContentText(d).setLocalOnly(true).setStyle(new NotificationCompat.BigTextStyle().bigText(d)).build();
            }
            switch (i) {
                case 1:
                case 2:
                case 3:
                    C0391p.f315f.set(false);
                    i2 = 10436;
                    break;
                default:
                    i2 = 39789;
                    break;
            }
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (str == null) {
                notificationManager.notify(i2, build);
            } else {
                notificationManager.notify(str, i2, build);
            }
        } else if (i == 6) {
            Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
        }
    }

    public final boolean mo1745a(int i) {
        return super.mo1745a(i);
    }

    public boolean m438a(Activity activity, @NonNull bn bnVar, int i, int i2, OnCancelListener onCancelListener) {
        Dialog a = m428a((Context) activity, i, aa.m520a(bnVar, mo1747b(activity, i, "d"), i2), onCancelListener);
        if (a == null) {
            return false;
        }
        m433a(activity, a, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public boolean m439a(Context context, ConnectionResult connectionResult, int i) {
        PendingIntent a = m431a(context, connectionResult);
        if (a == null) {
            return false;
        }
        m436a(context, connectionResult.getErrorCode(), null, GoogleApiActivity.m327a(context, a, i));
        return true;
    }

    @Nullable
    @Deprecated
    public Intent mo1746b(int i) {
        return super.mo1746b(i);
    }

    @Nullable
    public Intent mo1747b(Context context, int i, @Nullable String str) {
        return super.mo1747b(context, i, str);
    }

    void m442b(Context context) {
        new C0390c(this, context).sendEmptyMessageDelayed(1, 120000);
    }

    public boolean m443b(Activity activity, int i, int i2, OnCancelListener onCancelListener) {
        Dialog a = m426a(activity, i, i2, onCancelListener);
        if (a == null) {
            return false;
        }
        m433a(activity, a, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public boolean mo1748b(Context context, int i) {
        return super.mo1748b(context, i);
    }

    public final String mo1749c(int i) {
        return super.mo1749c(i);
    }
}
