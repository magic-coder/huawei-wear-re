package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.C0424f;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

public class C0356c {
    private static final Lock f244a = new ReentrantLock();
    private static C0356c f245b;
    private final Lock f246c = new ReentrantLock();
    private final SharedPreferences f247d;

    C0356c(Context context) {
        this.f247d = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static C0356c m297a(Context context) {
        C0424f.m649a((Object) context);
        f244a.lock();
        try {
            if (f245b == null) {
                f245b = new C0356c(context.getApplicationContext());
            }
            C0356c c0356c = f245b;
            return c0356c;
        } finally {
            f244a.unlock();
        }
    }

    private String m298a(String str, String str2) {
        String valueOf = String.valueOf(":");
        return new StringBuilder((String.valueOf(str).length() + String.valueOf(valueOf).length()) + String.valueOf(str2).length()).append(str).append(valueOf).append(str2).toString();
    }

    public GoogleSignInAccount m299a() {
        return m300a(m303c("defaultGoogleSignInAccount"));
    }

    GoogleSignInAccount m300a(String str) {
        GoogleSignInAccount googleSignInAccount = null;
        if (!TextUtils.isEmpty(str)) {
            String c = m303c(m298a("googleSignInAccount", str));
            if (c != null) {
                try {
                    googleSignInAccount = GoogleSignInAccount.zzcv(c);
                } catch (JSONException e) {
                }
            }
        }
        return googleSignInAccount;
    }

    public GoogleSignInOptions m301b() {
        return m302b(m303c("defaultGoogleSignInAccount"));
    }

    GoogleSignInOptions m302b(String str) {
        GoogleSignInOptions googleSignInOptions = null;
        if (!TextUtils.isEmpty(str)) {
            String c = m303c(m298a("googleSignInOptions", str));
            if (c != null) {
                try {
                    googleSignInOptions = GoogleSignInOptions.zzcx(c);
                } catch (JSONException e) {
                }
            }
        }
        return googleSignInOptions;
    }

    protected String m303c(String str) {
        this.f246c.lock();
        try {
            String string = this.f247d.getString(str, null);
            return string;
        } finally {
            this.f246c.unlock();
        }
    }
}
