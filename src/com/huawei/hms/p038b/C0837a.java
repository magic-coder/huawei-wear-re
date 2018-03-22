package com.huawei.hms.p038b;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.os.Build.VERSION;
import com.huawei.hms.support.log.C0887a;

/* compiled from: AbstractDialog */
public abstract class C0837a {
    private Activity f1331a;
    private AlertDialog f1332b;
    private C0842a f1333c;

    /* compiled from: AbstractDialog */
    public interface C0842a {
        void mo2242a(C0837a c0837a);

        void mo2243b(C0837a c0837a);
    }

    protected abstract String mo2235a(Context context);

    protected abstract String mo2236b(Context context);

    protected abstract String mo2233c(Context context);

    protected abstract String mo2234d(Context context);

    protected AlertDialog m2954a(Activity activity) {
        Builder builder = new Builder(m2964e(), m2965f());
        CharSequence c = mo2233c(activity);
        if (c != null) {
            builder.setTitle(c);
        }
        c = mo2235a((Context) activity);
        if (c != null) {
            builder.setMessage(c);
        }
        c = mo2236b(activity);
        if (c != null) {
            builder.setPositiveButton(c, new C0848b(this));
        }
        c = mo2234d(activity);
        if (c != null) {
            builder.setNegativeButton(c, new C0849c(this));
        }
        return builder.create();
    }

    public void m2957a(Activity activity, C0842a c0842a) {
        this.f1331a = activity;
        this.f1333c = c0842a;
        if (this.f1331a == null || this.f1331a.isFinishing()) {
            C0887a.m3098d("AbstractDialog", "In show, The activity is null or finishing.");
            return;
        }
        this.f1332b = m2954a(this.f1331a);
        this.f1332b.setCanceledOnTouchOutside(false);
        this.f1332b.setOnCancelListener(new C0850d(this));
        this.f1332b.setOnKeyListener(new C0851e(this));
        this.f1332b.show();
    }

    public void m2956a() {
        if (this.f1332b != null) {
            this.f1332b.cancel();
        }
    }

    public void m2959b() {
        if (this.f1332b != null) {
            this.f1332b.dismiss();
        }
    }

    protected void m2961c() {
        if (this.f1333c != null) {
            this.f1333c.mo2243b(this);
        }
    }

    protected void m2963d() {
        if (this.f1333c != null) {
            this.f1333c.mo2242a(this);
        }
    }

    protected Activity m2964e() {
        return this.f1331a;
    }

    protected int m2965f() {
        if (C0837a.m2953e(this.f1331a) == 0 || VERSION.SDK_INT < 16) {
            return 3;
        }
        return 0;
    }

    private static int m2953e(Context context) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier("androidhwext:style/Theme.Emui", null, null);
    }
}
