package com.google.zxing.client.android.p286a;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.preference.PreferenceManager;
import android.util.Log;
import com.google.zxing.client.android.p288b.p289a.C3779a;
import com.google.zxing.client.android.p288b.p289a.C3780b;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: AutoFocusManager */
final class C3771a implements AutoFocusCallback {
    private static final String f14683a = C3771a.class.getSimpleName();
    private static final Collection<String> f14684b = new ArrayList(2);
    private boolean f14685c;
    private final boolean f14686d;
    private final Camera f14687e;
    private C3772b f14688f;
    private final C3779a f14689g = ((C3779a) new C3780b().m18972a());

    static {
        f14684b.add("auto");
        f14684b.add("macro");
    }

    C3771a(Context context, Camera camera) {
        this.f14687e = camera;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String focusMode = camera.getParameters().getFocusMode();
        boolean z = defaultSharedPreferences.getBoolean("preferences_auto_focus", true) && f14684b.contains(focusMode);
        this.f14686d = z;
        Log.i(f14683a, "Current focus mode '" + focusMode + "'; use auto focus? " + this.f14686d);
        m18975a();
    }

    public synchronized void onAutoFocus(boolean z, Camera camera) {
        if (this.f14685c) {
            this.f14688f = new C3772b();
            this.f14689g.mo4311a(this.f14688f, new Object[0]);
        }
    }

    synchronized void m18975a() {
        if (this.f14686d) {
            this.f14685c = true;
            try {
                this.f14687e.autoFocus(this);
            } catch (Throwable e) {
                Log.w(f14683a, "Unexpected exception while focusing", e);
            }
        }
    }

    synchronized void m18976b() {
        if (this.f14686d) {
            try {
                this.f14687e.cancelAutoFocus();
            } catch (Throwable e) {
                Log.w(f14683a, "Unexpected exception while cancelling focusing", e);
            }
        }
        if (this.f14688f != null) {
            this.f14688f.cancel(true);
            this.f14688f = null;
        }
        this.f14685c = false;
    }
}
