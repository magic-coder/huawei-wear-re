package com.huawei.hwid.update.p453d;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.KeyEvent;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hwid.activity.C5063a;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.huawei.hwid.p075d.C5209d;
import java.lang.ref.WeakReference;

/* compiled from: GoogleWizard */
public class C5291f extends C5277a implements C5063a {
    private WeakReference<Activity> f18970a;
    private C5279b f18971b;
    private int f18972c = -1;

    public void mo4669a(Activity activity, boolean z) {
        this.f18970a = new WeakReference(activity);
        if (z) {
            m25583a(C5294g.class);
        } else {
            m25586e();
        }
    }

    public void mo4667a() {
        m25587f();
        this.f18970a = null;
    }

    public int m25596d() {
        if (this.f18972c != 2 && this.f18972c == 3) {
            return 2003;
        }
        return 2002;
    }

    public boolean mo4671a(int i, int i2, Intent intent) {
        Activity c = mo4674c();
        if (c == null || c.isFinishing()) {
            return false;
        }
        C5165e.m24906b("GoogleWizard", "updateType = " + this.f18972c + "requestCode = " + i);
        if (this.f18972c == 2 && i == 2002) {
            if (m25584a(c)) {
                m25582a(0);
                return true;
            }
            m25585b(c);
            return true;
        } else if (this.f18972c != 3 || i != 2003) {
            return false;
        } else {
            if (m25584a(c)) {
                m25582a(0);
                return true;
            }
            m25582a(8);
            return true;
        }
    }

    private boolean m25584a(Activity activity) {
        return new C5209d(activity).m25339b("com.huawei.hwid") >= 20300000;
    }

    public void mo4672b() {
        if (this.f18971b != null) {
            Class cls = this.f18971b.getClass();
            this.f18971b.m25561c();
            this.f18971b = null;
            m25583a(cls);
        }
    }

    Activity mo4674c() {
        if (this.f18970a == null) {
            return null;
        }
        return (Activity) this.f18970a.get();
    }

    void mo4670a(C5279b c5279b) {
        C5165e.m24906b("GoogleWizard", "Enter onCancel.");
        if (c5279b instanceof C5294g) {
            this.f18972c = 2;
            m25582a(13);
        }
    }

    void mo4673b(C5279b c5279b) {
        C5165e.m24906b("GoogleWizard", "Enter onDoWork.");
        if (c5279b instanceof C5294g) {
            c5279b.m25561c();
            m25586e();
        }
    }

    private void m25586e() {
        this.f18972c = 2;
        Activity c = mo4674c();
        if (c != null && !c.isFinishing()) {
            String str = "com.huawei.hwid";
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.huawei.hwid"));
                intent.setPackage("com.android.vending");
                c.startActivityForResult(intent, m25596d());
            } catch (ActivityNotFoundException e) {
                C5165e.m24910d("GoogleWizard", "can not open google play");
            }
        }
    }

    private void m25585b(Activity activity) {
        C5165e.m24906b("GoogleWizard", "gotoGooglePlayWeb");
        this.f18972c = 3;
        String str = "com.huawei.hwid";
        try {
            activity.startActivityForResult(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.huawei.hwid")), m25596d());
        } catch (ActivityNotFoundException e) {
            C5165e.m24910d("GoogleWizard", "can not find web to hold update hms apk");
        }
    }

    private void m25583a(Class<? extends C5279b> cls) {
        Exception e;
        m25587f();
        try {
            C5279b c5279b = (C5279b) cls.newInstance();
            c5279b.m25559a((C5277a) this);
            this.f18971b = c5279b;
            return;
        } catch (InstantiationException e2) {
            e = e2;
        } catch (IllegalAccessException e3) {
            e = e3;
        } catch (IllegalStateException e4) {
            e = e4;
        }
        C5165e.m24910d("GoogleWizard", "In showDialog, Failed to show the dialog." + e.getMessage());
    }

    private void m25587f() {
        if (this.f18971b != null) {
            try {
                this.f18971b.m25561c();
                this.f18971b = null;
            } catch (IllegalStateException e) {
                C5165e.m24910d("GoogleWizard", "In dismissDialog, Failed to dismiss the dialog." + e.getMessage());
            }
        }
    }

    private void m25582a(int i) {
        Activity c = mo4674c();
        if (c != null && !c.isFinishing()) {
            Intent intent = new Intent();
            intent.putExtra(BridgeActivity.EXTRA_DELEGATE_CLASS_NAME, getClass().getName());
            intent.putExtra(BridgeActivity.EXTRA_RESULT, i);
            c.setResult(-1, intent);
            c.finish();
        }
    }

    public void mo4668a(int i, KeyEvent keyEvent) {
        if (4 == i) {
            C5165e.m24906b("GoogleWizard", "In onKeyUp, Call finish.");
            Activity c = mo4674c();
            if (c != null && !c.isFinishing()) {
                c.setResult(0, null);
                c.finish();
            }
        }
    }
}
