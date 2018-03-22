package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.SimpleArrayMap;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.c;
import com.google.android.gms.common.C0392d;
import com.google.android.gms.common.util.C0462g;
import com.google.android.gms.internal.cy;
import com.huawei.crowdtestsdk.utils.ResUtil;

public final class C0445z {
    private static final SimpleArrayMap<String, String> f459a = new SimpleArrayMap();

    public static String m766a(Context context) {
        String str = context.getApplicationInfo().name;
        if (TextUtils.isEmpty(str)) {
            str = context.getPackageName();
            try {
                str = cy.m1181b(context).m1178a(context.getPackageName()).toString();
            } catch (NameNotFoundException e) {
            }
        }
        return str;
    }

    @Nullable
    public static String m767a(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(c.common_google_play_services_install_title);
            case 2:
                return resources.getString(c.common_google_play_services_update_title);
            case 3:
                return resources.getString(c.common_google_play_services_enable_title);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return C0445z.m768a(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return C0445z.m768a(context, "common_google_play_services_network_error_title");
            case 8:
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                return null;
            case 9:
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return null;
            case 10:
                Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                return null;
            case 11:
                Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                return null;
            case 16:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            case 17:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return C0445z.m768a(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return C0445z.m768a(context, "common_google_play_services_restricted_profile_title");
            default:
                Log.e("GoogleApiAvailability", "Unexpected error code " + i);
                return null;
        }
    }

    @Nullable
    private static String m768a(Context context, String str) {
        synchronized (f459a) {
            String str2 = (String) f459a.get(str);
            if (str2 != null) {
                return str2;
            }
            Resources a = C0392d.m461a(context);
            if (a == null) {
                return null;
            }
            int identifier = a.getIdentifier(str, ResUtil.TYPE_STRING, "com.google.android.gms");
            if (identifier == 0) {
                String str3 = "GoogleApiAvailability";
                String str4 = "Missing resource: ";
                str2 = String.valueOf(str);
                Log.w(str3, str2.length() != 0 ? str4.concat(str2) : new String(str4));
                return null;
            }
            Object string = a.getString(identifier);
            if (TextUtils.isEmpty(string)) {
                str3 = "GoogleApiAvailability";
                str4 = "Got empty resource: ";
                str2 = String.valueOf(str);
                Log.w(str3, str2.length() != 0 ? str4.concat(str2) : new String(str4));
                return null;
            }
            f459a.put(str, string);
            return string;
        }
    }

    private static String m769a(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String a = C0445z.m768a(context, str);
        if (a == null) {
            a = resources.getString(c.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, a, new Object[]{str2});
    }

    @NonNull
    public static String m770b(Context context, int i) {
        String a = i == 6 ? C0445z.m768a(context, "common_google_play_services_resolution_required_title") : C0445z.m767a(context, i);
        return a == null ? context.getResources().getString(c.common_google_play_services_notification_ticker) : a;
    }

    @NonNull
    public static String m771c(Context context, int i) {
        Resources resources = context.getResources();
        String a = C0445z.m766a(context);
        switch (i) {
            case 1:
                return resources.getString(c.common_google_play_services_install_text, new Object[]{a});
            case 2:
                if (C0462g.m818b(context)) {
                    return resources.getString(c.common_google_play_services_wear_update_text);
                }
                return resources.getString(c.common_google_play_services_update_text, new Object[]{a});
            case 3:
                return resources.getString(c.common_google_play_services_enable_text, new Object[]{a});
            case 5:
                return C0445z.m769a(context, "common_google_play_services_invalid_account_text", a);
            case 7:
                return C0445z.m769a(context, "common_google_play_services_network_error_text", a);
            case 9:
                return resources.getString(c.common_google_play_services_unsupported_text, new Object[]{a});
            case 16:
                return C0445z.m769a(context, "common_google_play_services_api_unavailable_text", a);
            case 17:
                return C0445z.m769a(context, "common_google_play_services_sign_in_failed_text", a);
            case 18:
                return resources.getString(c.common_google_play_services_updating_text, new Object[]{a});
            case 20:
                return C0445z.m769a(context, "common_google_play_services_restricted_profile_text", a);
            default:
                return resources.getString(c.common_google_play_services_unknown_issue, new Object[]{a});
        }
    }

    @NonNull
    public static String m772d(Context context, int i) {
        return i == 6 ? C0445z.m769a(context, "common_google_play_services_resolution_required_text", C0445z.m766a(context)) : C0445z.m771c(context, i);
    }

    @NonNull
    public static String m773e(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(c.common_google_play_services_install_button);
            case 2:
                return resources.getString(c.common_google_play_services_update_button);
            case 3:
                return resources.getString(c.common_google_play_services_enable_button);
            default:
                return resources.getString(17039370);
        }
    }
}
