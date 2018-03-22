package com.huawei.hwid.update.p453d;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Build.VERSION;
import com.huawei.hwid.core.p435d.p437b.C5165e;

/* compiled from: AbstractDialog */
public abstract class C5279b {
    private AlertDialog f18962a;
    private C5277a f18963b;

    /* compiled from: AbstractDialog */
    class C52781 implements OnCancelListener {
        final /* synthetic */ C5279b f18961a;

        C52781(C5279b c5279b) {
            this.f18961a = c5279b;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f18961a.m25562d();
        }
    }

    protected abstract AlertDialog mo4663a();

    public void m25559a(C5277a c5277a) {
        this.f18963b = c5277a;
        if (m25564f() == null || m25564f().isFinishing()) {
            C5165e.m24910d("AbstractDialog", "In show, The activity is null or finishing.");
            return;
        }
        this.f18962a = mo4663a();
        this.f18962a.setCanceledOnTouchOutside(false);
        this.f18962a.setOnCancelListener(new C52781(this));
        this.f18962a.show();
    }

    public void m25560b() {
        if (this.f18962a != null) {
            this.f18962a.cancel();
        }
    }

    public void m25561c() {
        if (this.f18962a != null) {
            this.f18962a.dismiss();
        }
    }

    protected void m25562d() {
        if (this.f18963b != null) {
            this.f18963b.mo4670a(this);
        }
    }

    protected void m25563e() {
        if (this.f18963b != null) {
            this.f18963b.mo4673b(this);
        }
    }

    protected Activity m25564f() {
        if (this.f18963b != null) {
            return this.f18963b.mo4674c();
        }
        return null;
    }

    protected int m25565g() {
        if (C5279b.m25557a(m25564f()) == 0 || VERSION.SDK_INT < 16) {
            return 3;
        }
        return 0;
    }

    private static int m25557a(Context context) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier("androidhwext:style/Theme.Emui", null, null);
    }
}
