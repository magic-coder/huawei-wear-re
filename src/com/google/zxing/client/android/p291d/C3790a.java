package com.google.zxing.client.android.p291d;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.util.Log;
import com.google.zxing.C3934m;
import com.google.zxing.client.android.C3817n;
import com.google.zxing.client.p285a.C3743q;
import com.sina.weibo.sdk.api.CmdObject;

/* compiled from: ResultHandler */
public abstract class C3790a {
    private static final String f14734a = C3790a.class.getSimpleName();
    private static final String[] f14735b = new String[]{CmdObject.CMD_HOME, "work", "mobile"};
    private static final String[] f14736c = new String[]{CmdObject.CMD_HOME, "work", "mobile", "fax", "pager", "main"};
    private static final String[] f14737d = new String[]{CmdObject.CMD_HOME, "work"};
    private static final int[] f14738e = new int[]{1, 2, 4};
    private static final int[] f14739f = new int[]{1, 3, 2, 4, 6, 12};
    private static final int[] f14740g = new int[]{1, 2};
    private final C3743q f14741h;
    private final Activity f14742i;
    private final C3934m f14743j;
    private final String f14744k;
    private C3817n f14745l = null;
    private final OnClickListener f14746m = new C3791b(this);

    C3790a(Activity activity, C3743q c3743q, C3934m c3934m) {
        this.f14741h = c3743q;
        this.f14742i = activity;
        this.f14743j = c3934m;
        this.f14744k = m19018c();
        this.f14745l = new C3817n(activity);
    }

    public boolean m19020a() {
        return false;
    }

    public CharSequence m19021b() {
        return this.f14741h.mo4309a().replace("\r", "");
    }

    final void m19019a(Intent intent) {
        if (intent != null) {
            intent.addFlags(524288);
            Log.d(f14734a, "Launching intent: " + intent + " with extras: " + intent.getExtras());
            this.f14742i.startActivity(intent);
        }
    }

    final void m19022b(Intent intent) {
        try {
            m19019a(intent);
        } catch (ActivityNotFoundException e) {
            Builder builder = new Builder(this.f14742i);
            builder.setTitle(this.f14745l.m19066h("sns_sweep"));
            builder.setMessage(this.f14745l.m19066h("sns_two_dim_code_error"));
            builder.setPositiveButton(this.f14745l.m19066h("sns_confirm"), null);
            builder.show();
        }
    }

    private String m19018c() {
        String string = PreferenceManager.getDefaultSharedPreferences(this.f14742i).getString("preferences_custom_product_search", null);
        if (string == null || string.trim().length() != 0) {
            return string;
        }
        return null;
    }
}
